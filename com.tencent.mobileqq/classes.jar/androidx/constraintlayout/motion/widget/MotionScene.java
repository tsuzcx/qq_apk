package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R.id;
import androidx.constraintlayout.widget.R.styleable;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MotionScene
{
  static final int ANTICIPATE = 4;
  static final int BOUNCE = 5;
  private static final boolean DEBUG = false;
  static final int EASE_IN = 1;
  static final int EASE_IN_OUT = 0;
  static final int EASE_OUT = 2;
  private static final int INTERPOLATOR_REFRENCE_ID = -2;
  public static final int LAYOUT_HONOR_REQUEST = 1;
  public static final int LAYOUT_IGNORE_REQUEST = 0;
  static final int LINEAR = 3;
  private static final int SPLINE_STRING = -1;
  public static final String TAG = "MotionScene";
  static final int TRANSITION_BACKWARD = 0;
  static final int TRANSITION_FORWARD = 1;
  public static final int UNSET = -1;
  private boolean DEBUG_DESKTOP = false;
  private ArrayList<MotionScene.Transition> mAbstractTransitionList = new ArrayList();
  private HashMap<String, Integer> mConstraintSetIdMap = new HashMap();
  private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray();
  MotionScene.Transition mCurrentTransition = null;
  private int mDefaultDuration = 400;
  private MotionScene.Transition mDefaultTransition = null;
  private SparseIntArray mDeriveMap = new SparseIntArray();
  private boolean mDisableAutoTransition = false;
  private boolean mIgnoreTouch = false;
  private MotionEvent mLastTouchDown;
  float mLastTouchX;
  float mLastTouchY;
  private int mLayoutDuringTransition = 0;
  private final MotionLayout mMotionLayout;
  private boolean mMotionOutsideRegion = false;
  private boolean mRtl;
  StateSet mStateSet = null;
  private ArrayList<MotionScene.Transition> mTransitionList = new ArrayList();
  private MotionLayout.MotionTracker mVelocityTracker;
  
  MotionScene(Context paramContext, MotionLayout paramMotionLayout, int paramInt)
  {
    this.mMotionLayout = paramMotionLayout;
    load(paramContext, paramInt);
    this.mConstraintSetMap.put(R.id.motion_base, new ConstraintSet());
    this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(R.id.motion_base));
  }
  
  public MotionScene(MotionLayout paramMotionLayout)
  {
    this.mMotionLayout = paramMotionLayout;
  }
  
  private int getId(Context paramContext, String paramString)
  {
    int i;
    if (paramString.contains("/"))
    {
      Object localObject = paramString.substring(paramString.indexOf('/') + 1);
      int j = paramContext.getResources().getIdentifier((String)localObject, "id", paramContext.getPackageName());
      i = j;
      if (this.DEBUG_DESKTOP)
      {
        paramContext = System.out;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("id getMap res = ");
        ((StringBuilder)localObject).append(j);
        paramContext.println(((StringBuilder)localObject).toString());
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    if (i == -1)
    {
      if ((paramString != null) && (paramString.length() > 1)) {
        return Integer.parseInt(paramString.substring(1));
      }
      Log.e("MotionScene", "error in parsing id");
    }
    return i;
  }
  
  private int getIndex(MotionScene.Transition paramTransition)
  {
    int j = MotionScene.Transition.access$300(paramTransition);
    if (j != -1)
    {
      int i = 0;
      while (i < this.mTransitionList.size())
      {
        if (MotionScene.Transition.access$300((MotionScene.Transition)this.mTransitionList.get(i)) == j) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    paramTransition = new IllegalArgumentException("The transition must have an id");
    for (;;)
    {
      throw paramTransition;
    }
  }
  
  private int getRealID(int paramInt)
  {
    StateSet localStateSet = this.mStateSet;
    if (localStateSet != null)
    {
      int i = localStateSet.stateGetConstraintID(paramInt, -1, -1);
      if (i != -1) {
        return i;
      }
    }
    return paramInt;
  }
  
  private boolean hasCycleDependency(int paramInt)
  {
    int j = this.mDeriveMap.get(paramInt);
    int i = this.mDeriveMap.size();
    while (j > 0)
    {
      if (j == paramInt) {
        return true;
      }
      if (i < 0) {
        return true;
      }
      j = this.mDeriveMap.get(j);
      i -= 1;
    }
    return false;
  }
  
  private boolean isProcessingTouch()
  {
    return this.mVelocityTracker != null;
  }
  
  private void load(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    MotionScene.Transition localTransition = null;
    try
    {
      i = localXmlResourceParser.getEventType();
    }
    catch (IOException paramContext)
    {
      Object localObject1;
      Object localObject2;
      StringBuilder localStringBuilder;
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
    localObject1 = localXmlResourceParser.getName();
    if (this.DEBUG_DESKTOP)
    {
      localObject2 = System.out;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parsing = ");
      localStringBuilder.append((String)localObject1);
      ((PrintStream)localObject2).println(localStringBuilder.toString());
    }
    int i = ((String)localObject1).hashCode();
    int j;
    switch (i)
    {
    default: 
      break;
    case 1382829617: 
      if (((String)localObject1).equals("StateSet")) {
        i = 4;
      }
      break;
    case 793277014: 
      if (((String)localObject1).equals("MotionScene")) {
        i = 0;
      }
      break;
    case 327855227: 
      if (((String)localObject1).equals("OnSwipe")) {
        i = 2;
      }
      break;
    case 312750793: 
      if (((String)localObject1).equals("OnClick")) {
        i = 3;
      }
      break;
    case 269306229: 
      if (((String)localObject1).equals("Transition")) {
        i = j;
      }
      break;
    case -1239391468: 
      if (((String)localObject1).equals("KeyFrameSet")) {
        i = 6;
      }
      break;
    case -1349929691: 
      if (((String)localObject1).equals("ConstraintSet"))
      {
        i = 5;
        break label675;
        localObject1 = new KeyFrames(paramContext, localXmlResourceParser);
        MotionScene.Transition.access$1300(localTransition).add(localObject1);
        break label630;
        parseConstraintSet(paramContext, localXmlResourceParser);
        break label630;
        this.mStateSet = new StateSet(paramContext, localXmlResourceParser);
        break label630;
        localTransition.addOnClick(paramContext, localXmlResourceParser);
        break label630;
        if (localTransition == null)
        {
          localObject1 = paramContext.getResources().getResourceEntryName(paramInt);
          i = localXmlResourceParser.getLineNumber();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" OnSwipe (");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(".xml:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(")");
          Log.v("MotionScene", ((StringBuilder)localObject2).toString());
        }
        MotionScene.Transition.access$202(localTransition, new TouchResponse(paramContext, this.mMotionLayout, localXmlResourceParser));
        break label630;
        localObject1 = this.mTransitionList;
        localTransition = new MotionScene.Transition(this, paramContext, localXmlResourceParser);
        ((ArrayList)localObject1).add(localTransition);
        if ((this.mCurrentTransition == null) && (!MotionScene.Transition.access$1200(localTransition)))
        {
          this.mCurrentTransition = localTransition;
          if ((this.mCurrentTransition != null) && (MotionScene.Transition.access$200(this.mCurrentTransition) != null)) {
            MotionScene.Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
          }
        }
        if (!MotionScene.Transition.access$1200(localTransition)) {
          break label723;
        }
        if (MotionScene.Transition.access$000(localTransition) == -1) {
          this.mDefaultTransition = localTransition;
        } else {
          this.mAbstractTransitionList.add(localTransition);
        }
        this.mTransitionList.remove(localTransition);
        break label723;
        parseMotionSceneTags(paramContext, localXmlResourceParser);
        break label630;
        label582:
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("WARNING UNKNOWN ATTRIBUTE ");
        ((StringBuilder)localObject2).append((String)localObject1);
        Log.v("MotionScene", ((StringBuilder)localObject2).toString());
        break label630;
        label622:
        localXmlResourceParser.getName();
      }
      break;
    }
    label675:
    label723:
    for (;;)
    {
      label630:
      i = localXmlResourceParser.next();
      do
      {
        return;
        j = 1;
      } while (i == 1);
      if (i == 0) {
        break label622;
      }
      if (i == 2) {
        break;
      }
      continue;
      i = -1;
      switch (i)
      {
      }
      break label582;
    }
  }
  
  private void parseConstraintSet(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    ConstraintSet localConstraintSet = new ConstraintSet();
    localConstraintSet.setForceId(false);
    int n = paramXmlPullParser.getAttributeCount();
    int j = 0;
    int m = -1;
    int k = -1;
    while (j < n)
    {
      String str1 = paramXmlPullParser.getAttributeName(j);
      String str2 = paramXmlPullParser.getAttributeValue(j);
      if (this.DEBUG_DESKTOP)
      {
        PrintStream localPrintStream = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("id string = ");
        localStringBuilder.append(str2);
        localPrintStream.println(localStringBuilder.toString());
      }
      int i = str1.hashCode();
      if (i != -1496482599)
      {
        if ((i == 3355) && (str1.equals("id")))
        {
          i = 0;
          break label163;
        }
      }
      else if (str1.equals("deriveConstraintsFrom"))
      {
        i = 1;
        break label163;
      }
      i = -1;
      label163:
      if (i != 0)
      {
        if (i == 1) {
          k = getId(paramContext, str2);
        }
      }
      else
      {
        m = getId(paramContext, str2);
        this.mConstraintSetIdMap.put(stripID(str2), Integer.valueOf(m));
      }
      j += 1;
    }
    if (m != -1)
    {
      if (this.mMotionLayout.mDebugPath != 0) {
        localConstraintSet.setValidateOnParse(true);
      }
      localConstraintSet.load(paramContext, paramXmlPullParser);
      if (k != -1) {
        this.mDeriveMap.put(m, k);
      }
      this.mConstraintSetMap.put(m, localConstraintSet);
    }
  }
  
  private void parseMotionSceneTags(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    paramContext = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.MotionScene);
    int j = paramContext.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramContext.getIndex(i);
      if (k == R.styleable.MotionScene_defaultDuration) {
        this.mDefaultDuration = paramContext.getInt(k, this.mDefaultDuration);
      } else if (k == R.styleable.MotionScene_layoutDuringTransition) {
        this.mLayoutDuringTransition = paramContext.getInteger(k, 0);
      }
      i += 1;
    }
    paramContext.recycle();
  }
  
  private void readConstraintChain(int paramInt)
  {
    int i = this.mDeriveMap.get(paramInt);
    if (i > 0)
    {
      readConstraintChain(this.mDeriveMap.get(paramInt));
      Object localObject = (ConstraintSet)this.mConstraintSetMap.get(paramInt);
      ConstraintSet localConstraintSet = (ConstraintSet)this.mConstraintSetMap.get(i);
      if (localConstraintSet == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ERROR! invalid deriveConstraintsFrom: @id/");
        ((StringBuilder)localObject).append(Debug.getName(this.mMotionLayout.getContext(), i));
        Log.e("MotionScene", ((StringBuilder)localObject).toString());
        return;
      }
      ((ConstraintSet)localObject).readFallback(localConstraintSet);
      this.mDeriveMap.put(paramInt, -1);
    }
  }
  
  public static String stripID(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.indexOf('/');
    if (i < 0) {
      return paramString;
    }
    return paramString.substring(i + 1);
  }
  
  public void addOnClickListeners(MotionLayout paramMotionLayout, int paramInt)
  {
    Iterator localIterator1 = this.mTransitionList.iterator();
    Object localObject;
    while (localIterator1.hasNext())
    {
      localObject = (MotionScene.Transition)localIterator1.next();
      if (MotionScene.Transition.access$400((MotionScene.Transition)localObject).size() > 0)
      {
        localObject = MotionScene.Transition.access$400((MotionScene.Transition)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((MotionScene.Transition.TransitionOnClick)((Iterator)localObject).next()).removeOnClickListeners(paramMotionLayout);
        }
      }
    }
    localIterator1 = this.mAbstractTransitionList.iterator();
    while (localIterator1.hasNext())
    {
      localObject = (MotionScene.Transition)localIterator1.next();
      if (MotionScene.Transition.access$400((MotionScene.Transition)localObject).size() > 0)
      {
        localObject = MotionScene.Transition.access$400((MotionScene.Transition)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((MotionScene.Transition.TransitionOnClick)((Iterator)localObject).next()).removeOnClickListeners(paramMotionLayout);
        }
      }
    }
    localIterator1 = this.mTransitionList.iterator();
    Iterator localIterator2;
    while (localIterator1.hasNext())
    {
      localObject = (MotionScene.Transition)localIterator1.next();
      if (MotionScene.Transition.access$400((MotionScene.Transition)localObject).size() > 0)
      {
        localIterator2 = MotionScene.Transition.access$400((MotionScene.Transition)localObject).iterator();
        while (localIterator2.hasNext()) {
          ((MotionScene.Transition.TransitionOnClick)localIterator2.next()).addOnClickListeners(paramMotionLayout, paramInt, (MotionScene.Transition)localObject);
        }
      }
    }
    localIterator1 = this.mAbstractTransitionList.iterator();
    while (localIterator1.hasNext())
    {
      localObject = (MotionScene.Transition)localIterator1.next();
      if (MotionScene.Transition.access$400((MotionScene.Transition)localObject).size() > 0)
      {
        localIterator2 = MotionScene.Transition.access$400((MotionScene.Transition)localObject).iterator();
        while (localIterator2.hasNext()) {
          ((MotionScene.Transition.TransitionOnClick)localIterator2.next()).addOnClickListeners(paramMotionLayout, paramInt, (MotionScene.Transition)localObject);
        }
      }
    }
  }
  
  public void addTransition(MotionScene.Transition paramTransition)
  {
    int i = getIndex(paramTransition);
    if (i == -1)
    {
      this.mTransitionList.add(paramTransition);
      return;
    }
    this.mTransitionList.set(i, paramTransition);
  }
  
  boolean autoTransition(MotionLayout paramMotionLayout, int paramInt)
  {
    if (isProcessingTouch()) {
      return false;
    }
    if (this.mDisableAutoTransition) {
      return false;
    }
    Iterator localIterator = this.mTransitionList.iterator();
    while (localIterator.hasNext())
    {
      MotionScene.Transition localTransition = (MotionScene.Transition)localIterator.next();
      if ((MotionScene.Transition.access$600(localTransition) != 0) && (this.mCurrentTransition != localTransition))
      {
        if ((paramInt == MotionScene.Transition.access$100(localTransition)) && ((MotionScene.Transition.access$600(localTransition) == 4) || (MotionScene.Transition.access$600(localTransition) == 2)))
        {
          paramMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
          paramMotionLayout.setTransition(localTransition);
          if (MotionScene.Transition.access$600(localTransition) == 4)
          {
            paramMotionLayout.transitionToEnd();
            paramMotionLayout.setState(MotionLayout.TransitionState.SETUP);
            paramMotionLayout.setState(MotionLayout.TransitionState.MOVING);
            return true;
          }
          paramMotionLayout.setProgress(1.0F);
          paramMotionLayout.evaluate(true);
          paramMotionLayout.setState(MotionLayout.TransitionState.SETUP);
          paramMotionLayout.setState(MotionLayout.TransitionState.MOVING);
          paramMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
          paramMotionLayout.onNewStateAttachHandlers();
          return true;
        }
        if ((paramInt == MotionScene.Transition.access$000(localTransition)) && ((MotionScene.Transition.access$600(localTransition) == 3) || (MotionScene.Transition.access$600(localTransition) == 1)))
        {
          paramMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
          paramMotionLayout.setTransition(localTransition);
          if (MotionScene.Transition.access$600(localTransition) == 3)
          {
            paramMotionLayout.transitionToStart();
            paramMotionLayout.setState(MotionLayout.TransitionState.SETUP);
            paramMotionLayout.setState(MotionLayout.TransitionState.MOVING);
            return true;
          }
          paramMotionLayout.setProgress(0.0F);
          paramMotionLayout.evaluate(true);
          paramMotionLayout.setState(MotionLayout.TransitionState.SETUP);
          paramMotionLayout.setState(MotionLayout.TransitionState.MOVING);
          paramMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
          paramMotionLayout.onNewStateAttachHandlers();
          return true;
        }
      }
    }
    return false;
  }
  
  public MotionScene.Transition bestTransitionFor(int paramInt, float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    if (paramInt != -1)
    {
      Object localObject2 = getTransitionsWithState(paramInt);
      float f1 = 0.0F;
      Object localObject1 = null;
      RectF localRectF1 = new RectF();
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (MotionScene.Transition)localIterator.next();
        if ((!MotionScene.Transition.access$500((MotionScene.Transition)localObject2)) && (MotionScene.Transition.access$200((MotionScene.Transition)localObject2) != null))
        {
          MotionScene.Transition.access$200((MotionScene.Transition)localObject2).setRTL(this.mRtl);
          RectF localRectF2 = MotionScene.Transition.access$200((MotionScene.Transition)localObject2).getTouchRegion(this.mMotionLayout, localRectF1);
          if ((localRectF2 == null) || (paramMotionEvent == null) || (localRectF2.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
          {
            localRectF2 = MotionScene.Transition.access$200((MotionScene.Transition)localObject2).getTouchRegion(this.mMotionLayout, localRectF1);
            if ((localRectF2 == null) || (paramMotionEvent == null) || (localRectF2.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
            {
              float f3 = MotionScene.Transition.access$200((MotionScene.Transition)localObject2).dot(paramFloat1, paramFloat2);
              if (MotionScene.Transition.access$000((MotionScene.Transition)localObject2) == paramInt) {
                f2 = -1.0F;
              } else {
                f2 = 1.1F;
              }
              float f2 = f3 * f2;
              if (f2 > f1)
              {
                localObject1 = localObject2;
                f1 = f2;
              }
            }
          }
        }
      }
      return localObject1;
    }
    return this.mCurrentTransition;
  }
  
  public void disableAutoTransition(boolean paramBoolean)
  {
    this.mDisableAutoTransition = paramBoolean;
  }
  
  public int gatPathMotionArc()
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if (localTransition != null) {
      return MotionScene.Transition.access$1800(localTransition);
    }
    return -1;
  }
  
  ConstraintSet getConstraintSet(int paramInt)
  {
    return getConstraintSet(paramInt, -1, -1);
  }
  
  ConstraintSet getConstraintSet(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.DEBUG_DESKTOP)
    {
      localObject = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id ");
      localStringBuilder.append(paramInt1);
      ((PrintStream)localObject).println(localStringBuilder.toString());
      localObject = System.out;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("size ");
      localStringBuilder.append(this.mConstraintSetMap.size());
      ((PrintStream)localObject).println(localStringBuilder.toString());
    }
    Object localObject = this.mStateSet;
    int i = paramInt1;
    if (localObject != null)
    {
      paramInt2 = ((StateSet)localObject).stateGetConstraintID(paramInt1, paramInt2, paramInt3);
      i = paramInt1;
      if (paramInt2 != -1) {
        i = paramInt2;
      }
    }
    if (this.mConstraintSetMap.get(i) == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Warning could not find ConstraintSet id/");
      ((StringBuilder)localObject).append(Debug.getName(this.mMotionLayout.getContext(), i));
      ((StringBuilder)localObject).append(" In MotionScene");
      Log.e("MotionScene", ((StringBuilder)localObject).toString());
      localObject = this.mConstraintSetMap;
      return (ConstraintSet)((SparseArray)localObject).get(((SparseArray)localObject).keyAt(0));
    }
    return (ConstraintSet)this.mConstraintSetMap.get(i);
  }
  
  public ConstraintSet getConstraintSet(Context paramContext, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (this.DEBUG_DESKTOP)
    {
      localObject1 = System.out;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id ");
      ((StringBuilder)localObject2).append(paramString);
      ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
      localObject1 = System.out;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("size ");
      ((StringBuilder)localObject2).append(this.mConstraintSetMap.size());
      ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
    }
    int i = 0;
    while (i < this.mConstraintSetMap.size())
    {
      int j = this.mConstraintSetMap.keyAt(i);
      localObject1 = paramContext.getResources().getResourceName(j);
      if (this.DEBUG_DESKTOP)
      {
        localObject2 = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Id for <");
        localStringBuilder.append(i);
        localStringBuilder.append("> is <");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("> looking for <");
        localStringBuilder.append(paramString);
        localStringBuilder.append(">");
        ((PrintStream)localObject2).println(localStringBuilder.toString());
      }
      if (paramString.equals(localObject1)) {
        return (ConstraintSet)this.mConstraintSetMap.get(j);
      }
      i += 1;
    }
    return null;
  }
  
  public int[] getConstraintSetIds()
  {
    int[] arrayOfInt = new int[this.mConstraintSetMap.size()];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = this.mConstraintSetMap.keyAt(i);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public ArrayList<MotionScene.Transition> getDefinedTransitions()
  {
    return this.mTransitionList;
  }
  
  public int getDuration()
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if (localTransition != null) {
      return MotionScene.Transition.access$1700(localTransition);
    }
    return this.mDefaultDuration;
  }
  
  int getEndId()
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if (localTransition == null) {
      return -1;
    }
    return MotionScene.Transition.access$000(localTransition);
  }
  
  public Interpolator getInterpolator()
  {
    switch (MotionScene.Transition.access$1400(this.mCurrentTransition))
    {
    default: 
      return null;
    case 5: 
      return new BounceInterpolator();
    case 4: 
      return new AnticipateInterpolator();
    case 3: 
      return null;
    case 2: 
      return new DecelerateInterpolator();
    case 1: 
      return new AccelerateInterpolator();
    case 0: 
      return new AccelerateDecelerateInterpolator();
    case -1: 
      return new MotionScene.1(this, Easing.getInterpolator(MotionScene.Transition.access$1500(this.mCurrentTransition)));
    }
    return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), MotionScene.Transition.access$1600(this.mCurrentTransition));
  }
  
  Key getKeyFrame(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = this.mCurrentTransition;
    if (paramContext == null) {
      return null;
    }
    paramContext = MotionScene.Transition.access$1300(paramContext).iterator();
    label19:
    if (paramContext.hasNext())
    {
      KeyFrames localKeyFrames = (KeyFrames)paramContext.next();
      Iterator localIterator = localKeyFrames.getKeys().iterator();
      label97:
      Key localKey;
      do
      {
        break label97;
        if (!localIterator.hasNext()) {
          break label19;
        }
        Object localObject = (Integer)localIterator.next();
        if (paramInt2 != ((Integer)localObject).intValue()) {
          break;
        }
        localObject = localKeyFrames.getKeyFramesForView(((Integer)localObject).intValue()).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localKey = (Key)((Iterator)localObject).next();
      } while ((localKey.mFramePosition != paramInt3) || (localKey.mType != paramInt1));
      return localKey;
    }
    return null;
  }
  
  public void getKeyFrames(MotionController paramMotionController)
  {
    Object localObject = this.mCurrentTransition;
    if (localObject == null)
    {
      localObject = this.mDefaultTransition;
      if (localObject != null)
      {
        localObject = MotionScene.Transition.access$1300((MotionScene.Transition)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((KeyFrames)((Iterator)localObject).next()).addFrames(paramMotionController);
        }
      }
      return;
    }
    localObject = MotionScene.Transition.access$1300((MotionScene.Transition)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((KeyFrames)((Iterator)localObject).next()).addFrames(paramMotionController);
    }
  }
  
  float getMaxAcceleration()
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if ((localTransition != null) && (MotionScene.Transition.access$200(localTransition) != null)) {
      return MotionScene.Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
    }
    return 0.0F;
  }
  
  float getMaxVelocity()
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if ((localTransition != null) && (MotionScene.Transition.access$200(localTransition) != null)) {
      return MotionScene.Transition.access$200(this.mCurrentTransition).getMaxVelocity();
    }
    return 0.0F;
  }
  
  boolean getMoveWhenScrollAtTop()
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if ((localTransition != null) && (MotionScene.Transition.access$200(localTransition) != null)) {
      return MotionScene.Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
    }
    return false;
  }
  
  public float getPathPercent(View paramView, int paramInt)
  {
    return 0.0F;
  }
  
  float getProgressDirection(float paramFloat1, float paramFloat2)
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if ((localTransition != null) && (MotionScene.Transition.access$200(localTransition) != null)) {
      return MotionScene.Transition.access$200(this.mCurrentTransition).getProgressDirection(paramFloat1, paramFloat2);
    }
    return 0.0F;
  }
  
  public float getStaggered()
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if (localTransition != null) {
      return MotionScene.Transition.access$1900(localTransition);
    }
    return 0.0F;
  }
  
  int getStartId()
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if (localTransition == null) {
      return -1;
    }
    return MotionScene.Transition.access$100(localTransition);
  }
  
  public MotionScene.Transition getTransitionById(int paramInt)
  {
    Iterator localIterator = this.mTransitionList.iterator();
    while (localIterator.hasNext())
    {
      MotionScene.Transition localTransition = (MotionScene.Transition)localIterator.next();
      if (MotionScene.Transition.access$300(localTransition) == paramInt) {
        return localTransition;
      }
    }
    return null;
  }
  
  int getTransitionDirection(int paramInt)
  {
    Iterator localIterator = this.mTransitionList.iterator();
    while (localIterator.hasNext()) {
      if (MotionScene.Transition.access$100((MotionScene.Transition)localIterator.next()) == paramInt) {
        return 0;
      }
    }
    return 1;
  }
  
  public List<MotionScene.Transition> getTransitionsWithState(int paramInt)
  {
    paramInt = getRealID(paramInt);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mTransitionList.iterator();
    while (localIterator.hasNext())
    {
      MotionScene.Transition localTransition = (MotionScene.Transition)localIterator.next();
      if ((MotionScene.Transition.access$100(localTransition) == paramInt) || (MotionScene.Transition.access$000(localTransition) == paramInt)) {
        localArrayList.add(localTransition);
      }
    }
    return localArrayList;
  }
  
  boolean hasKeyFramePosition(View paramView, int paramInt)
  {
    Object localObject = this.mCurrentTransition;
    if (localObject == null) {
      return false;
    }
    Iterator localIterator;
    do
    {
      localObject = MotionScene.Transition.access$1300((MotionScene.Transition)localObject).iterator();
      while (!localIterator.hasNext())
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localIterator = ((KeyFrames)((Iterator)localObject).next()).getKeyFramesForView(paramView.getId()).iterator();
      }
    } while (((Key)localIterator.next()).mFramePosition != paramInt);
    return true;
    return false;
  }
  
  public int lookUpConstraintId(String paramString)
  {
    return ((Integer)this.mConstraintSetIdMap.get(paramString)).intValue();
  }
  
  public String lookUpConstraintName(int paramInt)
  {
    Iterator localIterator = this.mConstraintSetIdMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return (String)localEntry.getKey();
      }
    }
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  void processScrollMove(float paramFloat1, float paramFloat2)
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if ((localTransition != null) && (MotionScene.Transition.access$200(localTransition) != null)) {
      MotionScene.Transition.access$200(this.mCurrentTransition).scrollMove(paramFloat1, paramFloat2);
    }
  }
  
  void processScrollUp(float paramFloat1, float paramFloat2)
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if ((localTransition != null) && (MotionScene.Transition.access$200(localTransition) != null)) {
      MotionScene.Transition.access$200(this.mCurrentTransition).scrollUp(paramFloat1, paramFloat2);
    }
  }
  
  void processTouchEvent(MotionEvent paramMotionEvent, int paramInt, MotionLayout paramMotionLayout)
  {
    Object localObject1 = new RectF();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    if (paramInt != -1)
    {
      int i = paramMotionEvent.getAction();
      boolean bool2 = false;
      if (i != 0)
      {
        if ((i == 2) && (!this.mIgnoreTouch))
        {
          float f1 = paramMotionEvent.getRawY() - this.mLastTouchY;
          float f2 = paramMotionEvent.getRawX() - this.mLastTouchX;
          if ((f2 != 0.0D) || (f1 != 0.0D))
          {
            localObject2 = this.mLastTouchDown;
            if (localObject2 != null) {}
          }
          else
          {
            return;
          }
          Object localObject2 = bestTransitionFor(paramInt, f2, f1, (MotionEvent)localObject2);
          if (localObject2 != null)
          {
            paramMotionLayout.setTransition((MotionScene.Transition)localObject2);
            localObject1 = MotionScene.Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, (RectF)localObject1);
            boolean bool1 = bool2;
            if (localObject1 != null)
            {
              bool1 = bool2;
              if (!((RectF)localObject1).contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                bool1 = true;
              }
            }
            this.mMotionOutsideRegion = bool1;
            MotionScene.Transition.access$200(this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
          }
        }
      }
      else
      {
        this.mLastTouchX = paramMotionEvent.getRawX();
        this.mLastTouchY = paramMotionEvent.getRawY();
        this.mLastTouchDown = paramMotionEvent;
        this.mIgnoreTouch = false;
        if (MotionScene.Transition.access$200(this.mCurrentTransition) != null)
        {
          paramMotionEvent = MotionScene.Transition.access$200(this.mCurrentTransition).getLimitBoundsTo(this.mMotionLayout, (RectF)localObject1);
          if ((paramMotionEvent != null) && (!paramMotionEvent.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())))
          {
            this.mLastTouchDown = null;
            this.mIgnoreTouch = true;
            return;
          }
          paramMotionEvent = MotionScene.Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, (RectF)localObject1);
          if ((paramMotionEvent != null) && (!paramMotionEvent.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()))) {
            this.mMotionOutsideRegion = true;
          } else {
            this.mMotionOutsideRegion = false;
          }
          MotionScene.Transition.access$200(this.mCurrentTransition).setDown(this.mLastTouchX, this.mLastTouchY);
        }
        return;
      }
    }
    if (this.mIgnoreTouch) {
      return;
    }
    localObject1 = this.mCurrentTransition;
    if ((localObject1 != null) && (MotionScene.Transition.access$200((MotionScene.Transition)localObject1) != null) && (!this.mMotionOutsideRegion)) {
      MotionScene.Transition.access$200(this.mCurrentTransition).processTouchEvent(paramMotionEvent, this.mVelocityTracker, paramInt, this);
    }
    this.mLastTouchX = paramMotionEvent.getRawX();
    this.mLastTouchY = paramMotionEvent.getRawY();
    if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = this.mVelocityTracker;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.recycle();
        this.mVelocityTracker = null;
        if (paramMotionLayout.mCurrentState != -1) {
          autoTransition(paramMotionLayout, paramMotionLayout.mCurrentState);
        }
      }
    }
  }
  
  void readFallback(MotionLayout paramMotionLayout)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.mConstraintSetMap.size()) {
        break;
      }
      j = this.mConstraintSetMap.keyAt(i);
      if (hasCycleDependency(j))
      {
        Log.e("MotionScene", "Cannot be derived from yourself");
        return;
      }
      readConstraintChain(j);
      i += 1;
    }
    while (j < this.mConstraintSetMap.size())
    {
      ((ConstraintSet)this.mConstraintSetMap.valueAt(j)).readFallback(paramMotionLayout);
      j += 1;
    }
  }
  
  public void removeTransition(MotionScene.Transition paramTransition)
  {
    int i = getIndex(paramTransition);
    if (i != -1) {
      this.mTransitionList.remove(i);
    }
  }
  
  public void setConstraintSet(int paramInt, ConstraintSet paramConstraintSet)
  {
    this.mConstraintSetMap.put(paramInt, paramConstraintSet);
  }
  
  public void setDuration(int paramInt)
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if (localTransition != null)
    {
      localTransition.setDuration(paramInt);
      return;
    }
    this.mDefaultDuration = paramInt;
  }
  
  public void setKeyframe(View paramView, int paramInt, String paramString, Object paramObject)
  {
    Object localObject = this.mCurrentTransition;
    if (localObject == null) {
      return;
    }
    localObject = MotionScene.Transition.access$1300((MotionScene.Transition)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((KeyFrames)((Iterator)localObject).next()).getKeyFramesForView(paramView.getId()).iterator();
      while (localIterator.hasNext()) {
        if (((Key)localIterator.next()).mFramePosition == paramInt)
        {
          float f;
          if (paramObject != null) {
            f = ((Float)paramObject).floatValue();
          } else {
            f = 0.0F;
          }
          paramString.equalsIgnoreCase("app:PerpendicularPath_percent");
        }
      }
    }
  }
  
  public void setRtl(boolean paramBoolean)
  {
    this.mRtl = paramBoolean;
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if ((localTransition != null) && (MotionScene.Transition.access$200(localTransition) != null)) {
      MotionScene.Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
    }
  }
  
  void setTransition(int paramInt1, int paramInt2)
  {
    Object localObject = this.mStateSet;
    int j;
    if (localObject != null)
    {
      i = ((StateSet)localObject).stateGetConstraintID(paramInt1, -1, -1);
      if (i == -1) {
        i = paramInt1;
      }
      k = this.mStateSet.stateGetConstraintID(paramInt2, -1, -1);
      j = i;
      if (k != -1) {
        break label63;
      }
    }
    else
    {
      j = paramInt1;
    }
    int k = paramInt2;
    int i = j;
    label63:
    localObject = this.mTransitionList.iterator();
    MotionScene.Transition localTransition;
    while (((Iterator)localObject).hasNext())
    {
      localTransition = (MotionScene.Transition)((Iterator)localObject).next();
      if (((MotionScene.Transition.access$000(localTransition) == k) && (MotionScene.Transition.access$100(localTransition) == i)) || ((MotionScene.Transition.access$000(localTransition) == paramInt2) && (MotionScene.Transition.access$100(localTransition) == paramInt1)))
      {
        this.mCurrentTransition = localTransition;
        localObject = this.mCurrentTransition;
        if ((localObject != null) && (MotionScene.Transition.access$200((MotionScene.Transition)localObject) != null)) {
          MotionScene.Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        }
        return;
      }
    }
    localObject = this.mDefaultTransition;
    Iterator localIterator = this.mAbstractTransitionList.iterator();
    while (localIterator.hasNext())
    {
      localTransition = (MotionScene.Transition)localIterator.next();
      if (MotionScene.Transition.access$000(localTransition) == paramInt2) {
        localObject = localTransition;
      }
    }
    localObject = new MotionScene.Transition(this, (MotionScene.Transition)localObject);
    MotionScene.Transition.access$102((MotionScene.Transition)localObject, i);
    MotionScene.Transition.access$002((MotionScene.Transition)localObject, k);
    if (i != -1) {
      this.mTransitionList.add(localObject);
    }
    this.mCurrentTransition = ((MotionScene.Transition)localObject);
  }
  
  public void setTransition(MotionScene.Transition paramTransition)
  {
    this.mCurrentTransition = paramTransition;
    paramTransition = this.mCurrentTransition;
    if ((paramTransition != null) && (MotionScene.Transition.access$200(paramTransition) != null)) {
      MotionScene.Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
    }
  }
  
  void setupTouch()
  {
    MotionScene.Transition localTransition = this.mCurrentTransition;
    if ((localTransition != null) && (MotionScene.Transition.access$200(localTransition) != null)) {
      MotionScene.Transition.access$200(this.mCurrentTransition).setupTouch();
    }
  }
  
  boolean supportTouch()
  {
    Object localObject = this.mTransitionList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (MotionScene.Transition.access$200((MotionScene.Transition)((Iterator)localObject).next()) != null) {
        return true;
      }
    }
    localObject = this.mCurrentTransition;
    return (localObject != null) && (MotionScene.Transition.access$200((MotionScene.Transition)localObject) != null);
  }
  
  public boolean validateLayout(MotionLayout paramMotionLayout)
  {
    return (paramMotionLayout == this.mMotionLayout) && (paramMotionLayout.mScene == this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionScene
 * JD-Core Version:    0.7.0.1
 */