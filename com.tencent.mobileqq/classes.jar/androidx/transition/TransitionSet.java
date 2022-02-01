package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet
  extends Transition
{
  private static final int FLAG_CHANGE_EPICENTER = 8;
  private static final int FLAG_CHANGE_INTERPOLATOR = 1;
  private static final int FLAG_CHANGE_PATH_MOTION = 4;
  private static final int FLAG_CHANGE_PROPAGATION = 2;
  public static final int ORDERING_SEQUENTIAL = 1;
  public static final int ORDERING_TOGETHER = 0;
  private int mChangeFlags = 0;
  int mCurrentListeners;
  private boolean mPlayTogether = true;
  boolean mStarted = false;
  private ArrayList<Transition> mTransitions = new ArrayList();
  
  public TransitionSet() {}
  
  @SuppressLint({"RestrictedApi"})
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.TRANSITION_SET);
    setOrdering(TypedArrayUtils.getNamedInt(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
  }
  
  private void addTransitionInternal(@NonNull Transition paramTransition)
  {
    this.mTransitions.add(paramTransition);
    paramTransition.mParent = this;
  }
  
  private void setupStartEndListeners()
  {
    TransitionSet.TransitionSetListener localTransitionSetListener = new TransitionSet.TransitionSetListener(this);
    Iterator localIterator = this.mTransitions.iterator();
    while (localIterator.hasNext()) {
      ((Transition)localIterator.next()).addListener(localTransitionSetListener);
    }
    this.mCurrentListeners = this.mTransitions.size();
  }
  
  @NonNull
  public TransitionSet addListener(@NonNull Transition.TransitionListener paramTransitionListener)
  {
    return (TransitionSet)super.addListener(paramTransitionListener);
  }
  
  @NonNull
  public TransitionSet addTarget(@IdRes int paramInt)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).addTarget(paramInt);
      i += 1;
    }
    return (TransitionSet)super.addTarget(paramInt);
  }
  
  @NonNull
  public TransitionSet addTarget(@NonNull View paramView)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).addTarget(paramView);
      i += 1;
    }
    return (TransitionSet)super.addTarget(paramView);
  }
  
  @NonNull
  public TransitionSet addTarget(@NonNull Class<?> paramClass)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).addTarget(paramClass);
      i += 1;
    }
    return (TransitionSet)super.addTarget(paramClass);
  }
  
  @NonNull
  public TransitionSet addTarget(@NonNull String paramString)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).addTarget(paramString);
      i += 1;
    }
    return (TransitionSet)super.addTarget(paramString);
  }
  
  @NonNull
  public TransitionSet addTransition(@NonNull Transition paramTransition)
  {
    addTransitionInternal(paramTransition);
    if (this.mDuration >= 0L) {
      paramTransition.setDuration(this.mDuration);
    }
    if ((this.mChangeFlags & 0x1) != 0) {
      paramTransition.setInterpolator(getInterpolator());
    }
    if ((this.mChangeFlags & 0x2) != 0) {
      paramTransition.setPropagation(getPropagation());
    }
    if ((this.mChangeFlags & 0x4) != 0) {
      paramTransition.setPathMotion(getPathMotion());
    }
    if ((this.mChangeFlags & 0x8) != 0) {
      paramTransition.setEpicenterCallback(getEpicenterCallback());
    }
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void cancel()
  {
    super.cancel();
    int j = this.mTransitions.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.mTransitions.get(i)).cancel();
      i += 1;
    }
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    if (isValidTarget(paramTransitionValues.view))
    {
      Iterator localIterator = this.mTransitions.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.isValidTarget(paramTransitionValues.view))
        {
          localTransition.captureEndValues(paramTransitionValues);
          paramTransitionValues.mTargetedTransitions.add(localTransition);
        }
      }
    }
  }
  
  void capturePropagationValues(TransitionValues paramTransitionValues)
  {
    super.capturePropagationValues(paramTransitionValues);
    int j = this.mTransitions.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.mTransitions.get(i)).capturePropagationValues(paramTransitionValues);
      i += 1;
    }
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    if (isValidTarget(paramTransitionValues.view))
    {
      Iterator localIterator = this.mTransitions.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.isValidTarget(paramTransitionValues.view))
        {
          localTransition.captureStartValues(paramTransitionValues);
          paramTransitionValues.mTargetedTransitions.add(localTransition);
        }
      }
    }
  }
  
  public Transition clone()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.clone();
    localTransitionSet.mTransitions = new ArrayList();
    int j = this.mTransitions.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.addTransitionInternal(((Transition)this.mTransitions.get(i)).clone());
      i += 1;
    }
    return localTransitionSet;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void createAnimators(ViewGroup paramViewGroup, TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2, ArrayList<TransitionValues> paramArrayList1, ArrayList<TransitionValues> paramArrayList2)
  {
    long l1 = getStartDelay();
    int j = this.mTransitions.size();
    int i = 0;
    while (i < j)
    {
      Transition localTransition = (Transition)this.mTransitions.get(i);
      if ((l1 > 0L) && ((this.mPlayTogether) || (i == 0)))
      {
        long l2 = localTransition.getStartDelay();
        if (l2 > 0L) {
          localTransition.setStartDelay(l2 + l1);
        } else {
          localTransition.setStartDelay(l1);
        }
      }
      localTransition.createAnimators(paramViewGroup, paramTransitionValuesMaps1, paramTransitionValuesMaps2, paramArrayList1, paramArrayList2);
      i += 1;
    }
  }
  
  @NonNull
  public Transition excludeTarget(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).excludeTarget(paramInt, paramBoolean);
      i += 1;
    }
    return super.excludeTarget(paramInt, paramBoolean);
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull View paramView, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).excludeTarget(paramView, paramBoolean);
      i += 1;
    }
    return super.excludeTarget(paramView, paramBoolean);
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull Class<?> paramClass, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).excludeTarget(paramClass, paramBoolean);
      i += 1;
    }
    return super.excludeTarget(paramClass, paramBoolean);
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).excludeTarget(paramString, paramBoolean);
      i += 1;
    }
    return super.excludeTarget(paramString, paramBoolean);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void forceToEnd(ViewGroup paramViewGroup)
  {
    super.forceToEnd(paramViewGroup);
    int j = this.mTransitions.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.mTransitions.get(i)).forceToEnd(paramViewGroup);
      i += 1;
    }
  }
  
  public int getOrdering()
  {
    return this.mPlayTogether ^ true;
  }
  
  @Nullable
  public Transition getTransitionAt(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mTransitions.size())) {
      return (Transition)this.mTransitions.get(paramInt);
    }
    return null;
  }
  
  public int getTransitionCount()
  {
    return this.mTransitions.size();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void pause(View paramView)
  {
    super.pause(paramView);
    int j = this.mTransitions.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.mTransitions.get(i)).pause(paramView);
      i += 1;
    }
  }
  
  @NonNull
  public TransitionSet removeListener(@NonNull Transition.TransitionListener paramTransitionListener)
  {
    return (TransitionSet)super.removeListener(paramTransitionListener);
  }
  
  @NonNull
  public TransitionSet removeTarget(@IdRes int paramInt)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).removeTarget(paramInt);
      i += 1;
    }
    return (TransitionSet)super.removeTarget(paramInt);
  }
  
  @NonNull
  public TransitionSet removeTarget(@NonNull View paramView)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).removeTarget(paramView);
      i += 1;
    }
    return (TransitionSet)super.removeTarget(paramView);
  }
  
  @NonNull
  public TransitionSet removeTarget(@NonNull Class<?> paramClass)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).removeTarget(paramClass);
      i += 1;
    }
    return (TransitionSet)super.removeTarget(paramClass);
  }
  
  @NonNull
  public TransitionSet removeTarget(@NonNull String paramString)
  {
    int i = 0;
    while (i < this.mTransitions.size())
    {
      ((Transition)this.mTransitions.get(i)).removeTarget(paramString);
      i += 1;
    }
    return (TransitionSet)super.removeTarget(paramString);
  }
  
  @NonNull
  public TransitionSet removeTransition(@NonNull Transition paramTransition)
  {
    this.mTransitions.remove(paramTransition);
    paramTransition.mParent = null;
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void resume(View paramView)
  {
    super.resume(paramView);
    int j = this.mTransitions.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.mTransitions.get(i)).resume(paramView);
      i += 1;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void runAnimators()
  {
    if (this.mTransitions.isEmpty())
    {
      start();
      end();
      return;
    }
    setupStartEndListeners();
    Object localObject;
    if (!this.mPlayTogether)
    {
      int i = 1;
      while (i < this.mTransitions.size())
      {
        ((Transition)this.mTransitions.get(i - 1)).addListener(new TransitionSet.1(this, (Transition)this.mTransitions.get(i)));
        i += 1;
      }
      localObject = (Transition)this.mTransitions.get(0);
      if (localObject != null) {
        ((Transition)localObject).runAnimators();
      }
    }
    else
    {
      localObject = this.mTransitions.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).runAnimators();
      }
    }
  }
  
  void setCanRemoveViews(boolean paramBoolean)
  {
    super.setCanRemoveViews(paramBoolean);
    int j = this.mTransitions.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.mTransitions.get(i)).setCanRemoveViews(paramBoolean);
      i += 1;
    }
  }
  
  @NonNull
  public TransitionSet setDuration(long paramLong)
  {
    super.setDuration(paramLong);
    if (this.mDuration >= 0L)
    {
      ArrayList localArrayList = this.mTransitions;
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((Transition)this.mTransitions.get(i)).setDuration(paramLong);
          i += 1;
        }
      }
    }
    return this;
  }
  
  public void setEpicenterCallback(Transition.EpicenterCallback paramEpicenterCallback)
  {
    super.setEpicenterCallback(paramEpicenterCallback);
    this.mChangeFlags |= 0x8;
    int j = this.mTransitions.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.mTransitions.get(i)).setEpicenterCallback(paramEpicenterCallback);
      i += 1;
    }
  }
  
  @NonNull
  public TransitionSet setInterpolator(@Nullable TimeInterpolator paramTimeInterpolator)
  {
    this.mChangeFlags |= 0x1;
    ArrayList localArrayList = this.mTransitions;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.mTransitions.get(i)).setInterpolator(paramTimeInterpolator);
        i += 1;
      }
    }
    return (TransitionSet)super.setInterpolator(paramTimeInterpolator);
  }
  
  @NonNull
  public TransitionSet setOrdering(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        this.mPlayTogether = false;
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid parameter for TransitionSet ordering: ");
      localStringBuilder.append(paramInt);
      throw new AndroidRuntimeException(localStringBuilder.toString());
    }
    this.mPlayTogether = true;
    return this;
  }
  
  public void setPathMotion(PathMotion paramPathMotion)
  {
    super.setPathMotion(paramPathMotion);
    this.mChangeFlags |= 0x4;
    if (this.mTransitions != null)
    {
      int i = 0;
      while (i < this.mTransitions.size())
      {
        ((Transition)this.mTransitions.get(i)).setPathMotion(paramPathMotion);
        i += 1;
      }
    }
  }
  
  public void setPropagation(TransitionPropagation paramTransitionPropagation)
  {
    super.setPropagation(paramTransitionPropagation);
    this.mChangeFlags |= 0x2;
    int j = this.mTransitions.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.mTransitions.get(i)).setPropagation(paramTransitionPropagation);
      i += 1;
    }
  }
  
  TransitionSet setSceneRoot(ViewGroup paramViewGroup)
  {
    super.setSceneRoot(paramViewGroup);
    int j = this.mTransitions.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.mTransitions.get(i)).setSceneRoot(paramViewGroup);
      i += 1;
    }
    return this;
  }
  
  @NonNull
  public TransitionSet setStartDelay(long paramLong)
  {
    return (TransitionSet)super.setStartDelay(paramLong);
  }
  
  String toString(String paramString)
  {
    Object localObject = super.toString(paramString);
    int i = 0;
    while (i < this.mTransitions.size())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("\n");
      localObject = (Transition)this.mTransitions.get(i);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("  ");
      localStringBuilder1.append(((Transition)localObject).toString(localStringBuilder2.toString()));
      localObject = localStringBuilder1.toString();
      i += 1;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.TransitionSet
 * JD-Core Version:    0.7.0.1
 */