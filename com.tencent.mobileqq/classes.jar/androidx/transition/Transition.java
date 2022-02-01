package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class Transition
  implements Cloneable
{
  static final boolean DBG = false;
  private static final int[] DEFAULT_MATCH_ORDER = { 2, 1, 3, 4 };
  private static final String LOG_TAG = "Transition";
  private static final int MATCH_FIRST = 1;
  public static final int MATCH_ID = 3;
  private static final String MATCH_ID_STR = "id";
  public static final int MATCH_INSTANCE = 1;
  private static final String MATCH_INSTANCE_STR = "instance";
  public static final int MATCH_ITEM_ID = 4;
  private static final String MATCH_ITEM_ID_STR = "itemId";
  private static final int MATCH_LAST = 4;
  public static final int MATCH_NAME = 2;
  private static final String MATCH_NAME_STR = "name";
  private static final PathMotion STRAIGHT_PATH_MOTION = new Transition.1();
  private static ThreadLocal<ArrayMap<Animator, Transition.AnimationInfo>> sRunningAnimators = new ThreadLocal();
  private ArrayList<Animator> mAnimators = new ArrayList();
  boolean mCanRemoveViews = false;
  ArrayList<Animator> mCurrentAnimators = new ArrayList();
  long mDuration = -1L;
  private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
  private ArrayList<TransitionValues> mEndValuesList;
  private boolean mEnded = false;
  private Transition.EpicenterCallback mEpicenterCallback;
  private TimeInterpolator mInterpolator = null;
  private ArrayList<Transition.TransitionListener> mListeners = null;
  private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
  private String mName = getClass().getName();
  private ArrayMap<String, String> mNameOverrides;
  private int mNumInstances = 0;
  TransitionSet mParent = null;
  private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
  private boolean mPaused = false;
  TransitionPropagation mPropagation;
  private ViewGroup mSceneRoot = null;
  private long mStartDelay = -1L;
  private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
  private ArrayList<TransitionValues> mStartValuesList;
  private ArrayList<View> mTargetChildExcludes = null;
  private ArrayList<View> mTargetExcludes = null;
  private ArrayList<Integer> mTargetIdChildExcludes = null;
  private ArrayList<Integer> mTargetIdExcludes = null;
  ArrayList<Integer> mTargetIds = new ArrayList();
  private ArrayList<String> mTargetNameExcludes = null;
  private ArrayList<String> mTargetNames = null;
  private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
  private ArrayList<Class<?>> mTargetTypeExcludes = null;
  private ArrayList<Class<?>> mTargetTypes = null;
  ArrayList<View> mTargets = new ArrayList();
  
  public Transition() {}
  
  @SuppressLint({"RestrictedApi"})
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.TRANSITION);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l = TypedArrayUtils.getNamedInt(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l >= 0L) {
      setDuration(l);
    }
    l = TypedArrayUtils.getNamedInt(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l > 0L) {
      setStartDelay(l);
    }
    int i = TypedArrayUtils.getNamedResourceId(localTypedArray, paramAttributeSet, "interpolator", 0, 0);
    if (i > 0) {
      setInterpolator(AnimationUtils.loadInterpolator(paramContext, i));
    }
    paramContext = TypedArrayUtils.getNamedString(localTypedArray, paramAttributeSet, "matchOrder", 3);
    if (paramContext != null) {
      setMatchOrder(parseMatchOrder(paramContext));
    }
    localTypedArray.recycle();
  }
  
  private void addUnmatched(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramArrayMap1.size()) {
        break;
      }
      TransitionValues localTransitionValues = (TransitionValues)paramArrayMap1.valueAt(i);
      if (isValidTarget(localTransitionValues.view))
      {
        this.mStartValuesList.add(localTransitionValues);
        this.mEndValuesList.add(null);
      }
      i += 1;
    }
    while (j < paramArrayMap2.size())
    {
      paramArrayMap1 = (TransitionValues)paramArrayMap2.valueAt(j);
      if (isValidTarget(paramArrayMap1.view))
      {
        this.mEndValuesList.add(paramArrayMap1);
        this.mStartValuesList.add(null);
      }
      j += 1;
    }
  }
  
  private static void addViewValues(TransitionValuesMaps paramTransitionValuesMaps, View paramView, TransitionValues paramTransitionValues)
  {
    paramTransitionValuesMaps.mViewValues.put(paramView, paramTransitionValues);
    int i = paramView.getId();
    if (i >= 0) {
      if (paramTransitionValuesMaps.mIdValues.indexOfKey(i) >= 0) {
        paramTransitionValuesMaps.mIdValues.put(i, null);
      } else {
        paramTransitionValuesMaps.mIdValues.put(i, paramView);
      }
    }
    paramTransitionValues = ViewCompat.getTransitionName(paramView);
    if (paramTransitionValues != null) {
      if (paramTransitionValuesMaps.mNameValues.containsKey(paramTransitionValues)) {
        paramTransitionValuesMaps.mNameValues.put(paramTransitionValues, null);
      } else {
        paramTransitionValuesMaps.mNameValues.put(paramTransitionValues, paramView);
      }
    }
    if ((paramView.getParent() instanceof ListView))
    {
      paramTransitionValues = (ListView)paramView.getParent();
      if (paramTransitionValues.getAdapter().hasStableIds())
      {
        long l = paramTransitionValues.getItemIdAtPosition(paramTransitionValues.getPositionForView(paramView));
        if (paramTransitionValuesMaps.mItemIdValues.indexOfKey(l) >= 0)
        {
          paramView = (View)paramTransitionValuesMaps.mItemIdValues.get(l);
          if (paramView != null)
          {
            ViewCompat.setHasTransientState(paramView, false);
            paramTransitionValuesMaps.mItemIdValues.put(l, null);
          }
        }
        else
        {
          ViewCompat.setHasTransientState(paramView, true);
          paramTransitionValuesMaps.mItemIdValues.put(l, paramView);
        }
      }
    }
  }
  
  private static boolean alreadyContains(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt[i] == j) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void captureHierarchy(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    int k = paramView.getId();
    Object localObject = this.mTargetIdExcludes;
    if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(k)))) {
      return;
    }
    localObject = this.mTargetExcludes;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
      return;
    }
    localObject = this.mTargetTypeExcludes;
    int j = 0;
    int i;
    if (localObject != null)
    {
      int m = ((ArrayList)localObject).size();
      i = 0;
      while (i < m)
      {
        if (((Class)this.mTargetTypeExcludes.get(i)).isInstance(paramView)) {
          return;
        }
        i += 1;
      }
    }
    if ((paramView.getParent() instanceof ViewGroup))
    {
      localObject = new TransitionValues(paramView);
      if (paramBoolean) {
        captureStartValues((TransitionValues)localObject);
      } else {
        captureEndValues((TransitionValues)localObject);
      }
      ((TransitionValues)localObject).mTargetedTransitions.add(this);
      capturePropagationValues((TransitionValues)localObject);
      if (paramBoolean) {
        addViewValues(this.mStartValues, paramView, (TransitionValues)localObject);
      } else {
        addViewValues(this.mEndValues, paramView, (TransitionValues)localObject);
      }
    }
    if ((paramView instanceof ViewGroup))
    {
      localObject = this.mTargetIdChildExcludes;
      if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(k)))) {
        return;
      }
      localObject = this.mTargetChildExcludes;
      if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
        return;
      }
      localObject = this.mTargetTypeChildExcludes;
      if (localObject != null)
      {
        k = ((ArrayList)localObject).size();
        i = 0;
        while (i < k)
        {
          if (((Class)this.mTargetTypeChildExcludes.get(i)).isInstance(paramView)) {
            return;
          }
          i += 1;
        }
      }
      paramView = (ViewGroup)paramView;
      i = j;
      while (i < paramView.getChildCount())
      {
        captureHierarchy(paramView.getChildAt(i), paramBoolean);
        i += 1;
      }
    }
  }
  
  private ArrayList<Integer> excludeId(ArrayList<Integer> paramArrayList, int paramInt, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramInt > 0)
    {
      if (paramBoolean) {
        return Transition.ArrayListManager.add(paramArrayList, Integer.valueOf(paramInt));
      }
      localObject = Transition.ArrayListManager.remove(paramArrayList, Integer.valueOf(paramInt));
    }
    return localObject;
  }
  
  private static <T> ArrayList<T> excludeObject(ArrayList<T> paramArrayList, T paramT, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramT != null)
    {
      if (paramBoolean) {
        return Transition.ArrayListManager.add(paramArrayList, paramT);
      }
      localObject = Transition.ArrayListManager.remove(paramArrayList, paramT);
    }
    return localObject;
  }
  
  private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> paramArrayList, Class<?> paramClass, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramClass != null)
    {
      if (paramBoolean) {
        return Transition.ArrayListManager.add(paramArrayList, paramClass);
      }
      localObject = Transition.ArrayListManager.remove(paramArrayList, paramClass);
    }
    return localObject;
  }
  
  private ArrayList<View> excludeView(ArrayList<View> paramArrayList, View paramView, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramView != null)
    {
      if (paramBoolean) {
        return Transition.ArrayListManager.add(paramArrayList, paramView);
      }
      localObject = Transition.ArrayListManager.remove(paramArrayList, paramView);
    }
    return localObject;
  }
  
  private static ArrayMap<Animator, Transition.AnimationInfo> getRunningAnimators()
  {
    ArrayMap localArrayMap2 = (ArrayMap)sRunningAnimators.get();
    ArrayMap localArrayMap1 = localArrayMap2;
    if (localArrayMap2 == null)
    {
      localArrayMap1 = new ArrayMap();
      sRunningAnimators.set(localArrayMap1);
    }
    return localArrayMap1;
  }
  
  private static boolean isValidMatch(int paramInt)
  {
    return (paramInt >= 1) && (paramInt <= 4);
  }
  
  private static boolean isValueChanged(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2, String paramString)
  {
    paramTransitionValues1 = paramTransitionValues1.values.get(paramString);
    paramTransitionValues2 = paramTransitionValues2.values.get(paramString);
    boolean bool = true;
    if ((paramTransitionValues1 == null) && (paramTransitionValues2 == null)) {
      return false;
    }
    if (paramTransitionValues1 != null)
    {
      if (paramTransitionValues2 == null) {
        return true;
      }
      bool = true ^ paramTransitionValues1.equals(paramTransitionValues2);
    }
    return bool;
  }
  
  private void matchIds(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, SparseArray<View> paramSparseArray1, SparseArray<View> paramSparseArray2)
  {
    int j = paramSparseArray1.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramSparseArray1.valueAt(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramSparseArray2.get(paramSparseArray1.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          TransitionValues localTransitionValues1 = (TransitionValues)paramArrayMap1.get(localView1);
          TransitionValues localTransitionValues2 = (TransitionValues)paramArrayMap2.get(localView2);
          if ((localTransitionValues1 != null) && (localTransitionValues2 != null))
          {
            this.mStartValuesList.add(localTransitionValues1);
            this.mEndValuesList.add(localTransitionValues2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchInstances(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2)
  {
    int i = paramArrayMap1.size() - 1;
    while (i >= 0)
    {
      Object localObject = (View)paramArrayMap1.keyAt(i);
      if ((localObject != null) && (isValidTarget((View)localObject)))
      {
        localObject = (TransitionValues)paramArrayMap2.remove(localObject);
        if ((localObject != null) && (isValidTarget(((TransitionValues)localObject).view)))
        {
          TransitionValues localTransitionValues = (TransitionValues)paramArrayMap1.removeAt(i);
          this.mStartValuesList.add(localTransitionValues);
          this.mEndValuesList.add(localObject);
        }
      }
      i -= 1;
    }
  }
  
  private void matchItemIds(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, LongSparseArray<View> paramLongSparseArray1, LongSparseArray<View> paramLongSparseArray2)
  {
    int j = paramLongSparseArray1.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramLongSparseArray1.valueAt(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramLongSparseArray2.get(paramLongSparseArray1.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          TransitionValues localTransitionValues1 = (TransitionValues)paramArrayMap1.get(localView1);
          TransitionValues localTransitionValues2 = (TransitionValues)paramArrayMap2.get(localView2);
          if ((localTransitionValues1 != null) && (localTransitionValues2 != null))
          {
            this.mStartValuesList.add(localTransitionValues1);
            this.mEndValuesList.add(localTransitionValues2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchNames(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, ArrayMap<String, View> paramArrayMap3, ArrayMap<String, View> paramArrayMap4)
  {
    int j = paramArrayMap3.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramArrayMap3.valueAt(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramArrayMap4.get(paramArrayMap3.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          TransitionValues localTransitionValues1 = (TransitionValues)paramArrayMap1.get(localView1);
          TransitionValues localTransitionValues2 = (TransitionValues)paramArrayMap2.get(localView2);
          if ((localTransitionValues1 != null) && (localTransitionValues2 != null))
          {
            this.mStartValuesList.add(localTransitionValues1);
            this.mEndValuesList.add(localTransitionValues2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchStartAndEnd(TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2)
  {
    ArrayMap localArrayMap1 = new ArrayMap(paramTransitionValuesMaps1.mViewValues);
    ArrayMap localArrayMap2 = new ArrayMap(paramTransitionValuesMaps2.mViewValues);
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.mMatchOrder;
      if (i >= arrayOfInt.length) {
        break;
      }
      int j = arrayOfInt[i];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j == 4) {
              matchItemIds(localArrayMap1, localArrayMap2, paramTransitionValuesMaps1.mItemIdValues, paramTransitionValuesMaps2.mItemIdValues);
            }
          }
          else {
            matchIds(localArrayMap1, localArrayMap2, paramTransitionValuesMaps1.mIdValues, paramTransitionValuesMaps2.mIdValues);
          }
        }
        else {
          matchNames(localArrayMap1, localArrayMap2, paramTransitionValuesMaps1.mNameValues, paramTransitionValuesMaps2.mNameValues);
        }
      }
      else {
        matchInstances(localArrayMap1, localArrayMap2);
      }
      i += 1;
    }
    addUnmatched(localArrayMap1, localArrayMap2);
  }
  
  private static int[] parseMatchOrder(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    paramString = new int[localStringTokenizer.countTokens()];
    int i = 0;
    while (localStringTokenizer.hasMoreTokens())
    {
      Object localObject = localStringTokenizer.nextToken().trim();
      if ("id".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 3;
      }
      else if ("instance".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 1;
      }
      else if ("name".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 2;
      }
      else if ("itemId".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 4;
      }
      else
      {
        if (!((String)localObject).isEmpty()) {
          break label135;
        }
        localObject = new int[paramString.length - 1];
        System.arraycopy(paramString, 0, localObject, 0, i);
        i -= 1;
        paramString = (String)localObject;
      }
      i += 1;
      continue;
      label135:
      paramString = new StringBuilder();
      paramString.append("Unknown match type in matchOrder: '");
      paramString.append((String)localObject);
      paramString.append("'");
      throw new InflateException(paramString.toString());
    }
    return paramString;
  }
  
  private void runAnimator(Animator paramAnimator, ArrayMap<Animator, Transition.AnimationInfo> paramArrayMap)
  {
    if (paramAnimator != null)
    {
      paramAnimator.addListener(new Transition.2(this, paramArrayMap));
      animate(paramAnimator);
    }
  }
  
  @NonNull
  public Transition addListener(@NonNull Transition.TransitionListener paramTransitionListener)
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramTransitionListener);
    return this;
  }
  
  @NonNull
  public Transition addTarget(@IdRes int paramInt)
  {
    if (paramInt != 0) {
      this.mTargetIds.add(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  @NonNull
  public Transition addTarget(@NonNull View paramView)
  {
    this.mTargets.add(paramView);
    return this;
  }
  
  @NonNull
  public Transition addTarget(@NonNull Class<?> paramClass)
  {
    if (this.mTargetTypes == null) {
      this.mTargetTypes = new ArrayList();
    }
    this.mTargetTypes.add(paramClass);
    return this;
  }
  
  @NonNull
  public Transition addTarget(@NonNull String paramString)
  {
    if (this.mTargetNames == null) {
      this.mTargetNames = new ArrayList();
    }
    this.mTargetNames.add(paramString);
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void animate(Animator paramAnimator)
  {
    if (paramAnimator == null)
    {
      end();
      return;
    }
    if (getDuration() >= 0L) {
      paramAnimator.setDuration(getDuration());
    }
    if (getStartDelay() >= 0L) {
      paramAnimator.setStartDelay(getStartDelay() + paramAnimator.getStartDelay());
    }
    if (getInterpolator() != null) {
      paramAnimator.setInterpolator(getInterpolator());
    }
    paramAnimator.addListener(new Transition.3(this));
    paramAnimator.start();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void cancel()
  {
    int i = this.mCurrentAnimators.size() - 1;
    while (i >= 0)
    {
      ((Animator)this.mCurrentAnimators.get(i)).cancel();
      i -= 1;
    }
    ArrayList localArrayList = this.mListeners;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = (ArrayList)this.mListeners.clone();
      int j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        ((Transition.TransitionListener)localArrayList.get(i)).onTransitionCancel(this);
        i += 1;
      }
    }
  }
  
  public abstract void captureEndValues(@NonNull TransitionValues paramTransitionValues);
  
  void capturePropagationValues(TransitionValues paramTransitionValues)
  {
    if ((this.mPropagation != null) && (!paramTransitionValues.values.isEmpty()))
    {
      String[] arrayOfString = this.mPropagation.getPropagationProperties();
      if (arrayOfString == null) {
        return;
      }
      int j = 0;
      int i = 0;
      while (i < arrayOfString.length)
      {
        if (!paramTransitionValues.values.containsKey(arrayOfString[i]))
        {
          i = j;
          break label75;
        }
        i += 1;
      }
      i = 1;
      label75:
      if (i == 0) {
        this.mPropagation.captureValues(paramTransitionValues);
      }
    }
  }
  
  public abstract void captureStartValues(@NonNull TransitionValues paramTransitionValues);
  
  void captureValues(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    clearValues(paramBoolean);
    int i = this.mTargetIds.size();
    int k = 0;
    Object localObject1;
    if ((i > 0) || (this.mTargets.size() > 0))
    {
      localObject1 = this.mTargetNames;
      if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
      {
        localObject1 = this.mTargetTypes;
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
          break label80;
        }
      }
    }
    captureHierarchy(paramViewGroup, paramBoolean);
    break label304;
    label80:
    i = 0;
    Object localObject2;
    while (i < this.mTargetIds.size())
    {
      localObject1 = paramViewGroup.findViewById(((Integer)this.mTargetIds.get(i)).intValue());
      if (localObject1 != null)
      {
        localObject2 = new TransitionValues((View)localObject1);
        if (paramBoolean) {
          captureStartValues((TransitionValues)localObject2);
        } else {
          captureEndValues((TransitionValues)localObject2);
        }
        ((TransitionValues)localObject2).mTargetedTransitions.add(this);
        capturePropagationValues((TransitionValues)localObject2);
        if (paramBoolean) {
          addViewValues(this.mStartValues, (View)localObject1, (TransitionValues)localObject2);
        } else {
          addViewValues(this.mEndValues, (View)localObject1, (TransitionValues)localObject2);
        }
      }
      i += 1;
    }
    i = 0;
    while (i < this.mTargets.size())
    {
      paramViewGroup = (View)this.mTargets.get(i);
      localObject1 = new TransitionValues(paramViewGroup);
      if (paramBoolean) {
        captureStartValues((TransitionValues)localObject1);
      } else {
        captureEndValues((TransitionValues)localObject1);
      }
      ((TransitionValues)localObject1).mTargetedTransitions.add(this);
      capturePropagationValues((TransitionValues)localObject1);
      if (paramBoolean) {
        addViewValues(this.mStartValues, paramViewGroup, (TransitionValues)localObject1);
      } else {
        addViewValues(this.mEndValues, paramViewGroup, (TransitionValues)localObject1);
      }
      i += 1;
    }
    label304:
    if (!paramBoolean)
    {
      paramViewGroup = this.mNameOverrides;
      if (paramViewGroup != null)
      {
        int m = paramViewGroup.size();
        paramViewGroup = new ArrayList(m);
        i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= m) {
            break;
          }
          localObject1 = (String)this.mNameOverrides.keyAt(i);
          paramViewGroup.add(this.mStartValues.mNameValues.remove(localObject1));
          i += 1;
        }
        while (j < m)
        {
          localObject1 = (View)paramViewGroup.get(j);
          if (localObject1 != null)
          {
            localObject2 = (String)this.mNameOverrides.valueAt(j);
            this.mStartValues.mNameValues.put(localObject2, localObject1);
          }
          j += 1;
        }
      }
    }
  }
  
  void clearValues(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mStartValues.mViewValues.clear();
      this.mStartValues.mIdValues.clear();
      this.mStartValues.mItemIdValues.clear();
      return;
    }
    this.mEndValues.mViewValues.clear();
    this.mEndValues.mIdValues.clear();
    this.mEndValues.mItemIdValues.clear();
  }
  
  public Transition clone()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      localTransition.mAnimators = new ArrayList();
      localTransition.mStartValues = new TransitionValuesMaps();
      localTransition.mEndValues = new TransitionValuesMaps();
      localTransition.mStartValuesList = null;
      localTransition.mEndValuesList = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  @Nullable
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, @Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    return null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void createAnimators(ViewGroup paramViewGroup, TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2, ArrayList<TransitionValues> paramArrayList1, ArrayList<TransitionValues> paramArrayList2)
  {
    ArrayMap localArrayMap = getRunningAnimators();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramArrayList1.size();
    long l1 = 9223372036854775807L;
    int i = 0;
    int j;
    while (i < k)
    {
      Object localObject1 = (TransitionValues)paramArrayList1.get(i);
      paramTransitionValuesMaps1 = (TransitionValues)paramArrayList2.get(i);
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!((TransitionValues)localObject1).mTargetedTransitions.contains(this)) {
          localObject2 = null;
        }
      }
      TransitionValuesMaps localTransitionValuesMaps = paramTransitionValuesMaps1;
      if (paramTransitionValuesMaps1 != null)
      {
        localTransitionValuesMaps = paramTransitionValuesMaps1;
        if (!paramTransitionValuesMaps1.mTargetedTransitions.contains(this)) {
          localTransitionValuesMaps = null;
        }
      }
      if ((localObject2 == null) && (localTransitionValuesMaps == null)) {}
      do
      {
        do
        {
          l2 = l1;
          j = i;
          break;
          if ((localObject2 != null) && (localTransitionValuesMaps != null) && (!isTransitionRequired(localObject2, localTransitionValuesMaps))) {
            j = 0;
          } else {
            j = 1;
          }
        } while (j == 0);
        paramTransitionValuesMaps1 = createAnimator(paramViewGroup, localObject2, localTransitionValuesMaps);
      } while (paramTransitionValuesMaps1 == null);
      Object localObject4;
      Object localObject3;
      if (localTransitionValuesMaps != null)
      {
        localObject4 = localTransitionValuesMaps.view;
        String[] arrayOfString = getTransitionProperties();
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          localObject3 = new TransitionValues((View)localObject4);
          localObject1 = (TransitionValues)paramTransitionValuesMaps2.mViewValues.get(localObject4);
          j = i;
          if (localObject1 != null)
          {
            m = 0;
            for (;;)
            {
              j = i;
              if (m >= arrayOfString.length) {
                break;
              }
              ((TransitionValues)localObject3).values.put(arrayOfString[m], ((TransitionValues)localObject1).values.get(arrayOfString[m]));
              m += 1;
            }
          }
          i = j;
          int m = localArrayMap.size();
          j = 0;
          while (j < m)
          {
            localObject1 = (Transition.AnimationInfo)localArrayMap.get((Animator)localArrayMap.keyAt(j));
            if ((((Transition.AnimationInfo)localObject1).mValues != null) && (((Transition.AnimationInfo)localObject1).mView == localObject4) && (((Transition.AnimationInfo)localObject1).mName.equals(getName())) && (((Transition.AnimationInfo)localObject1).mValues.equals(localObject3)))
            {
              paramTransitionValuesMaps1 = null;
              localObject1 = localObject3;
              break label417;
            }
            j += 1;
          }
          localObject1 = localObject3;
        }
        else
        {
          localObject1 = null;
        }
        label417:
        localObject3 = paramTransitionValuesMaps1;
        paramTransitionValuesMaps1 = (TransitionValuesMaps)localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
      }
      else
      {
        localObject3 = localObject2.view;
        localObject4 = null;
        localObject1 = paramTransitionValuesMaps1;
        paramTransitionValuesMaps1 = (TransitionValuesMaps)localObject4;
      }
      long l2 = l1;
      j = i;
      if (localObject1 != null)
      {
        localObject4 = this.mPropagation;
        l2 = l1;
        if (localObject4 != null)
        {
          l2 = ((TransitionPropagation)localObject4).getStartDelay(paramViewGroup, this, localObject2, localTransitionValuesMaps);
          localSparseIntArray.put(this.mAnimators.size(), (int)l2);
          l2 = Math.min(l2, l1);
        }
        localArrayMap.put(localObject1, new Transition.AnimationInfo((View)localObject3, getName(), this, ViewUtils.getWindowId(paramViewGroup), paramTransitionValuesMaps1));
        this.mAnimators.add(localObject1);
        j = i;
      }
      i = j + 1;
      l1 = l2;
    }
    if (localSparseIntArray.size() != 0)
    {
      i = 0;
      while (i < localSparseIntArray.size())
      {
        j = localSparseIntArray.keyAt(i);
        paramViewGroup = (Animator)this.mAnimators.get(j);
        paramViewGroup.setStartDelay(localSparseIntArray.valueAt(i) - l1 + paramViewGroup.getStartDelay());
        i += 1;
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void end()
  {
    this.mNumInstances -= 1;
    if (this.mNumInstances == 0)
    {
      Object localObject = this.mListeners;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (ArrayList)this.mListeners.clone();
        int j = ((ArrayList)localObject).size();
        i = 0;
        while (i < j)
        {
          ((Transition.TransitionListener)((ArrayList)localObject).get(i)).onTransitionEnd(this);
          i += 1;
        }
      }
      int i = 0;
      while (i < this.mStartValues.mItemIdValues.size())
      {
        localObject = (View)this.mStartValues.mItemIdValues.valueAt(i);
        if (localObject != null) {
          ViewCompat.setHasTransientState((View)localObject, false);
        }
        i += 1;
      }
      i = 0;
      while (i < this.mEndValues.mItemIdValues.size())
      {
        localObject = (View)this.mEndValues.mItemIdValues.valueAt(i);
        if (localObject != null) {
          ViewCompat.setHasTransientState((View)localObject, false);
        }
        i += 1;
      }
      this.mEnded = true;
    }
  }
  
  @NonNull
  public Transition excludeChildren(@IdRes int paramInt, boolean paramBoolean)
  {
    this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, paramInt, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeChildren(@NonNull View paramView, boolean paramBoolean)
  {
    this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, paramView, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeChildren(@NonNull Class<?> paramClass, boolean paramBoolean)
  {
    this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, paramClass, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@IdRes int paramInt, boolean paramBoolean)
  {
    this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, paramInt, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull View paramView, boolean paramBoolean)
  {
    this.mTargetExcludes = excludeView(this.mTargetExcludes, paramView, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull Class<?> paramClass, boolean paramBoolean)
  {
    this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, paramClass, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull String paramString, boolean paramBoolean)
  {
    this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, paramString, paramBoolean);
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void forceToEnd(ViewGroup paramViewGroup)
  {
    Object localObject = getRunningAnimators();
    int i = ((ArrayMap)localObject).size();
    if (paramViewGroup != null)
    {
      if (i == 0) {
        return;
      }
      paramViewGroup = ViewUtils.getWindowId(paramViewGroup);
      ArrayMap localArrayMap = new ArrayMap((SimpleArrayMap)localObject);
      ((ArrayMap)localObject).clear();
      i -= 1;
      while (i >= 0)
      {
        localObject = (Transition.AnimationInfo)localArrayMap.valueAt(i);
        if ((((Transition.AnimationInfo)localObject).mView != null) && (paramViewGroup != null) && (paramViewGroup.equals(((Transition.AnimationInfo)localObject).mWindowId))) {
          ((Animator)localArrayMap.keyAt(i)).end();
        }
        i -= 1;
      }
    }
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  @Nullable
  public Rect getEpicenter()
  {
    Transition.EpicenterCallback localEpicenterCallback = this.mEpicenterCallback;
    if (localEpicenterCallback == null) {
      return null;
    }
    return localEpicenterCallback.onGetEpicenter(this);
  }
  
  @Nullable
  public Transition.EpicenterCallback getEpicenterCallback()
  {
    return this.mEpicenterCallback;
  }
  
  @Nullable
  public TimeInterpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  TransitionValues getMatchedTransitionValues(View paramView, boolean paramBoolean)
  {
    Object localObject1 = this.mParent;
    if (localObject1 != null) {
      return ((TransitionSet)localObject1).getMatchedTransitionValues(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject1 = this.mStartValuesList;
    } else {
      localObject1 = this.mEndValuesList;
    }
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    int m = ((ArrayList)localObject1).size();
    int k = -1;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      TransitionValues localTransitionValues = (TransitionValues)((ArrayList)localObject1).get(i);
      if (localTransitionValues == null) {
        return null;
      }
      if (localTransitionValues.view == paramView)
      {
        j = i;
        break;
      }
      i += 1;
    }
    paramView = localObject2;
    if (j >= 0)
    {
      if (paramBoolean) {
        paramView = this.mEndValuesList;
      } else {
        paramView = this.mStartValuesList;
      }
      paramView = (TransitionValues)paramView.get(j);
    }
    return paramView;
  }
  
  @NonNull
  public String getName()
  {
    return this.mName;
  }
  
  @NonNull
  public PathMotion getPathMotion()
  {
    return this.mPathMotion;
  }
  
  @Nullable
  public TransitionPropagation getPropagation()
  {
    return this.mPropagation;
  }
  
  public long getStartDelay()
  {
    return this.mStartDelay;
  }
  
  @NonNull
  public List<Integer> getTargetIds()
  {
    return this.mTargetIds;
  }
  
  @Nullable
  public List<String> getTargetNames()
  {
    return this.mTargetNames;
  }
  
  @Nullable
  public List<Class<?>> getTargetTypes()
  {
    return this.mTargetTypes;
  }
  
  @NonNull
  public List<View> getTargets()
  {
    return this.mTargets;
  }
  
  @Nullable
  public String[] getTransitionProperties()
  {
    return null;
  }
  
  @Nullable
  public TransitionValues getTransitionValues(@NonNull View paramView, boolean paramBoolean)
  {
    Object localObject = this.mParent;
    if (localObject != null) {
      return ((TransitionSet)localObject).getTransitionValues(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject = this.mStartValues;
    } else {
      localObject = this.mEndValues;
    }
    return (TransitionValues)((TransitionValuesMaps)localObject).mViewValues.get(paramView);
  }
  
  public boolean isTransitionRequired(@Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTransitionValues1 != null)
    {
      bool1 = bool2;
      if (paramTransitionValues2 != null)
      {
        Object localObject = getTransitionProperties();
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          for (;;)
          {
            bool1 = bool2;
            if (i >= j) {
              break label120;
            }
            if (isValueChanged(paramTransitionValues1, paramTransitionValues2, localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        localObject = paramTransitionValues1.values.keySet().iterator();
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!isValueChanged(paramTransitionValues1, paramTransitionValues2, (String)((Iterator)localObject).next()));
        bool1 = true;
      }
    }
    label120:
    return bool1;
  }
  
  boolean isValidTarget(View paramView)
  {
    int j = paramView.getId();
    ArrayList localArrayList = this.mTargetIdExcludes;
    if ((localArrayList != null) && (localArrayList.contains(Integer.valueOf(j)))) {
      return false;
    }
    localArrayList = this.mTargetExcludes;
    if ((localArrayList != null) && (localArrayList.contains(paramView))) {
      return false;
    }
    localArrayList = this.mTargetTypeExcludes;
    int i;
    if (localArrayList != null)
    {
      int k = localArrayList.size();
      i = 0;
      while (i < k)
      {
        if (((Class)this.mTargetTypeExcludes.get(i)).isInstance(paramView)) {
          return false;
        }
        i += 1;
      }
    }
    if ((this.mTargetNameExcludes != null) && (ViewCompat.getTransitionName(paramView) != null) && (this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(paramView)))) {
      return false;
    }
    if ((this.mTargetIds.size() == 0) && (this.mTargets.size() == 0))
    {
      localArrayList = this.mTargetTypes;
      if ((localArrayList == null) || (localArrayList.isEmpty()))
      {
        localArrayList = this.mTargetNames;
        if ((localArrayList == null) || (localArrayList.isEmpty())) {
          return true;
        }
      }
    }
    if (!this.mTargetIds.contains(Integer.valueOf(j)))
    {
      if (this.mTargets.contains(paramView)) {
        return true;
      }
      localArrayList = this.mTargetNames;
      if ((localArrayList != null) && (localArrayList.contains(ViewCompat.getTransitionName(paramView)))) {
        return true;
      }
      if (this.mTargetTypes != null)
      {
        i = 0;
        while (i < this.mTargetTypes.size())
        {
          if (((Class)this.mTargetTypes.get(i)).isInstance(paramView)) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    return true;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void pause(View paramView)
  {
    if (!this.mEnded)
    {
      ArrayMap localArrayMap = getRunningAnimators();
      int i = localArrayMap.size();
      paramView = ViewUtils.getWindowId(paramView);
      i -= 1;
      while (i >= 0)
      {
        Transition.AnimationInfo localAnimationInfo = (Transition.AnimationInfo)localArrayMap.valueAt(i);
        if ((localAnimationInfo.mView != null) && (paramView.equals(localAnimationInfo.mWindowId))) {
          AnimatorUtils.pause((Animator)localArrayMap.keyAt(i));
        }
        i -= 1;
      }
      paramView = this.mListeners;
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = (ArrayList)this.mListeners.clone();
        int j = paramView.size();
        i = 0;
        while (i < j)
        {
          ((Transition.TransitionListener)paramView.get(i)).onTransitionPause(this);
          i += 1;
        }
      }
      this.mPaused = true;
    }
  }
  
  void playTransition(ViewGroup paramViewGroup)
  {
    this.mStartValuesList = new ArrayList();
    this.mEndValuesList = new ArrayList();
    matchStartAndEnd(this.mStartValues, this.mEndValues);
    ArrayMap localArrayMap = getRunningAnimators();
    int i = localArrayMap.size();
    WindowIdImpl localWindowIdImpl = ViewUtils.getWindowId(paramViewGroup);
    i -= 1;
    while (i >= 0)
    {
      Animator localAnimator = (Animator)localArrayMap.keyAt(i);
      if (localAnimator != null)
      {
        Transition.AnimationInfo localAnimationInfo = (Transition.AnimationInfo)localArrayMap.get(localAnimator);
        if ((localAnimationInfo != null) && (localAnimationInfo.mView != null) && (localWindowIdImpl.equals(localAnimationInfo.mWindowId)))
        {
          TransitionValues localTransitionValues3 = localAnimationInfo.mValues;
          View localView = localAnimationInfo.mView;
          TransitionValues localTransitionValues4 = getTransitionValues(localView, true);
          TransitionValues localTransitionValues2 = getMatchedTransitionValues(localView, true);
          TransitionValues localTransitionValues1 = localTransitionValues2;
          if (localTransitionValues4 == null)
          {
            localTransitionValues1 = localTransitionValues2;
            if (localTransitionValues2 == null) {
              localTransitionValues1 = (TransitionValues)this.mEndValues.mViewValues.get(localView);
            }
          }
          int j;
          if (((localTransitionValues4 != null) || (localTransitionValues1 != null)) && (localAnimationInfo.mTransition.isTransitionRequired(localTransitionValues3, localTransitionValues1))) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0) {
            if ((!localAnimator.isRunning()) && (!localAnimator.isStarted())) {
              localArrayMap.remove(localAnimator);
            } else {
              localAnimator.cancel();
            }
          }
        }
      }
      i -= 1;
    }
    createAnimators(paramViewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
    runAnimators();
  }
  
  @NonNull
  public Transition removeListener(@NonNull Transition.TransitionListener paramTransitionListener)
  {
    ArrayList localArrayList = this.mListeners;
    if (localArrayList == null) {
      return this;
    }
    localArrayList.remove(paramTransitionListener);
    if (this.mListeners.size() == 0) {
      this.mListeners = null;
    }
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@IdRes int paramInt)
  {
    if (paramInt != 0) {
      this.mTargetIds.remove(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@NonNull View paramView)
  {
    this.mTargets.remove(paramView);
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@NonNull Class<?> paramClass)
  {
    ArrayList localArrayList = this.mTargetTypes;
    if (localArrayList != null) {
      localArrayList.remove(paramClass);
    }
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@NonNull String paramString)
  {
    ArrayList localArrayList = this.mTargetNames;
    if (localArrayList != null) {
      localArrayList.remove(paramString);
    }
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void resume(View paramView)
  {
    if (this.mPaused)
    {
      if (!this.mEnded)
      {
        ArrayMap localArrayMap = getRunningAnimators();
        int i = localArrayMap.size();
        paramView = ViewUtils.getWindowId(paramView);
        i -= 1;
        while (i >= 0)
        {
          Transition.AnimationInfo localAnimationInfo = (Transition.AnimationInfo)localArrayMap.valueAt(i);
          if ((localAnimationInfo.mView != null) && (paramView.equals(localAnimationInfo.mWindowId))) {
            AnimatorUtils.resume((Animator)localArrayMap.keyAt(i));
          }
          i -= 1;
        }
        paramView = this.mListeners;
        if ((paramView != null) && (paramView.size() > 0))
        {
          paramView = (ArrayList)this.mListeners.clone();
          int j = paramView.size();
          i = 0;
          while (i < j)
          {
            ((Transition.TransitionListener)paramView.get(i)).onTransitionResume(this);
            i += 1;
          }
        }
      }
      this.mPaused = false;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void runAnimators()
  {
    start();
    ArrayMap localArrayMap = getRunningAnimators();
    Iterator localIterator = this.mAnimators.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      if (localArrayMap.containsKey(localAnimator))
      {
        start();
        runAnimator(localAnimator, localArrayMap);
      }
    }
    this.mAnimators.clear();
    end();
  }
  
  void setCanRemoveViews(boolean paramBoolean)
  {
    this.mCanRemoveViews = paramBoolean;
  }
  
  @NonNull
  public Transition setDuration(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  public void setEpicenterCallback(@Nullable Transition.EpicenterCallback paramEpicenterCallback)
  {
    this.mEpicenterCallback = paramEpicenterCallback;
  }
  
  @NonNull
  public Transition setInterpolator(@Nullable TimeInterpolator paramTimeInterpolator)
  {
    this.mInterpolator = paramTimeInterpolator;
    return this;
  }
  
  public void setMatchOrder(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int i = 0;
      while (i < paramVarArgs.length) {
        if (isValidMatch(paramVarArgs[i]))
        {
          if (!alreadyContains(paramVarArgs, i)) {
            i += 1;
          } else {
            throw new IllegalArgumentException("matches contains a duplicate value");
          }
        }
        else {
          throw new IllegalArgumentException("matches contains invalid value");
        }
      }
      this.mMatchOrder = ((int[])paramVarArgs.clone());
      return;
    }
    this.mMatchOrder = DEFAULT_MATCH_ORDER;
  }
  
  public void setPathMotion(@Nullable PathMotion paramPathMotion)
  {
    if (paramPathMotion == null)
    {
      this.mPathMotion = STRAIGHT_PATH_MOTION;
      return;
    }
    this.mPathMotion = paramPathMotion;
  }
  
  public void setPropagation(@Nullable TransitionPropagation paramTransitionPropagation)
  {
    this.mPropagation = paramTransitionPropagation;
  }
  
  Transition setSceneRoot(ViewGroup paramViewGroup)
  {
    this.mSceneRoot = paramViewGroup;
    return this;
  }
  
  @NonNull
  public Transition setStartDelay(long paramLong)
  {
    this.mStartDelay = paramLong;
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void start()
  {
    if (this.mNumInstances == 0)
    {
      ArrayList localArrayList = this.mListeners;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localArrayList = (ArrayList)this.mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((Transition.TransitionListener)localArrayList.get(i)).onTransitionStart(this);
          i += 1;
        }
      }
      this.mEnded = false;
    }
    this.mNumInstances += 1;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  String toString(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject).append(": ");
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (this.mDuration != -1L)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("dur(");
      paramString.append(this.mDuration);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    localObject = paramString;
    if (this.mStartDelay != -1L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("dly(");
      ((StringBuilder)localObject).append(this.mStartDelay);
      ((StringBuilder)localObject).append(") ");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = (String)localObject;
    if (this.mInterpolator != null)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("interp(");
      paramString.append(this.mInterpolator);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    if (this.mTargetIds.size() <= 0)
    {
      localObject = paramString;
      if (this.mTargets.size() <= 0) {}
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("tgts(");
      localObject = ((StringBuilder)localObject).toString();
      int i = this.mTargetIds.size();
      int j = 0;
      paramString = (String)localObject;
      if (i > 0)
      {
        paramString = (String)localObject;
        i = 0;
        while (i < this.mTargetIds.size())
        {
          localObject = paramString;
          if (i > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", ");
            localObject = ((StringBuilder)localObject).toString();
          }
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(this.mTargetIds.get(i));
          paramString = paramString.toString();
          i += 1;
        }
      }
      localObject = paramString;
      if (this.mTargets.size() > 0)
      {
        i = j;
        for (;;)
        {
          localObject = paramString;
          if (i >= this.mTargets.size()) {
            break;
          }
          localObject = paramString;
          if (i > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", ");
            localObject = ((StringBuilder)localObject).toString();
          }
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(this.mTargets.get(i));
          paramString = paramString.toString();
          i += 1;
        }
      }
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(")");
      localObject = paramString.toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.Transition
 * JD-Core Version:    0.7.0.1
 */