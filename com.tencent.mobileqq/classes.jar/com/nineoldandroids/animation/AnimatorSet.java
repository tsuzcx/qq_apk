package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class AnimatorSet
  extends Animator
{
  private ValueAnimator mDelayAnim = null;
  private long mDuration = -1L;
  private boolean mNeedsSort = true;
  private HashMap<Animator, AnimatorSet.Node> mNodeMap = new HashMap();
  private ArrayList<AnimatorSet.Node> mNodes = new ArrayList();
  private ArrayList<Animator> mPlayingSet = new ArrayList();
  private AnimatorSet.AnimatorSetListener mSetListener = null;
  private ArrayList<AnimatorSet.Node> mSortedNodes = new ArrayList();
  private long mStartDelay = 0L;
  private boolean mStarted = false;
  boolean mTerminated = false;
  
  private void sortNodes()
  {
    int j;
    Object localObject2;
    label168:
    int m;
    if (this.mNeedsSort)
    {
      this.mSortedNodes.clear();
      localObject1 = new ArrayList();
      j = this.mNodes.size();
      i = 0;
      if (i >= j) {
        localObject2 = new ArrayList();
      }
      for (;;)
      {
        if (((ArrayList)localObject1).size() <= 0)
        {
          this.mNeedsSort = false;
          if (this.mSortedNodes.size() == this.mNodes.size()) {
            break label288;
          }
          throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
          localObject2 = (AnimatorSet.Node)this.mNodes.get(i);
          if ((((AnimatorSet.Node)localObject2).dependencies == null) || (((AnimatorSet.Node)localObject2).dependencies.size() == 0)) {
            ((ArrayList)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
        k = ((ArrayList)localObject1).size();
        i = 0;
        if (i < k) {
          break label168;
        }
        ((ArrayList)localObject1).clear();
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        ((ArrayList)localObject2).clear();
      }
      AnimatorSet.Node localNode1 = (AnimatorSet.Node)((ArrayList)localObject1).get(i);
      this.mSortedNodes.add(localNode1);
      if (localNode1.nodeDependents != null)
      {
        m = localNode1.nodeDependents.size();
        j = 0;
      }
      for (;;)
      {
        if (j >= m)
        {
          i += 1;
          break;
        }
        AnimatorSet.Node localNode2 = (AnimatorSet.Node)localNode1.nodeDependents.get(j);
        localNode2.nodeDependencies.remove(localNode1);
        if (localNode2.nodeDependencies.size() == 0) {
          ((ArrayList)localObject2).add(localNode2);
        }
        j += 1;
      }
    }
    int k = this.mNodes.size();
    int i = 0;
    if (i >= k) {
      label288:
      return;
    }
    Object localObject1 = (AnimatorSet.Node)this.mNodes.get(i);
    if ((((AnimatorSet.Node)localObject1).dependencies != null) && (((AnimatorSet.Node)localObject1).dependencies.size() > 0))
    {
      m = ((AnimatorSet.Node)localObject1).dependencies.size();
      j = 0;
    }
    for (;;)
    {
      if (j >= m)
      {
        ((AnimatorSet.Node)localObject1).done = false;
        i += 1;
        break;
      }
      localObject2 = (AnimatorSet.Dependency)((AnimatorSet.Node)localObject1).dependencies.get(j);
      if (((AnimatorSet.Node)localObject1).nodeDependencies == null) {
        ((AnimatorSet.Node)localObject1).nodeDependencies = new ArrayList();
      }
      if (!((AnimatorSet.Node)localObject1).nodeDependencies.contains(((AnimatorSet.Dependency)localObject2).node)) {
        ((AnimatorSet.Node)localObject1).nodeDependencies.add(((AnimatorSet.Dependency)localObject2).node);
      }
      j += 1;
    }
  }
  
  public void cancel()
  {
    this.mTerminated = true;
    Object localObject;
    Iterator localIterator;
    if (isStarted())
    {
      if (this.mListeners == null) {
        break label173;
      }
      localObject = (ArrayList)this.mListeners.clone();
      localIterator = ((ArrayList)localObject).iterator();
      if (localIterator.hasNext()) {
        break label92;
      }
    }
    for (;;)
    {
      if ((this.mDelayAnim != null) && (this.mDelayAnim.isRunning()))
      {
        this.mDelayAnim.cancel();
        label68:
        if (localObject != null) {
          localObject = ((ArrayList)localObject).iterator();
        }
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext())
        {
          this.mStarted = false;
          return;
          label92:
          ((Animator.AnimatorListener)localIterator.next()).onAnimationCancel(this);
          break;
          if (this.mSortedNodes.size() <= 0) {
            break label68;
          }
          localIterator = this.mSortedNodes.iterator();
          while (localIterator.hasNext()) {
            ((AnimatorSet.Node)localIterator.next()).animation.cancel();
          }
          break label68;
        }
        ((Animator.AnimatorListener)((Iterator)localObject).next()).onAnimationEnd(this);
      }
      label173:
      localObject = null;
    }
  }
  
  public AnimatorSet clone()
  {
    AnimatorSet localAnimatorSet = (AnimatorSet)super.clone();
    localAnimatorSet.mNeedsSort = true;
    localAnimatorSet.mTerminated = false;
    localAnimatorSet.mStarted = false;
    localAnimatorSet.mPlayingSet = new ArrayList();
    localAnimatorSet.mNodeMap = new HashMap();
    localAnimatorSet.mNodes = new ArrayList();
    localAnimatorSet.mSortedNodes = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject3 = this.mNodes.iterator();
    Object localObject1;
    if (!((Iterator)localObject3).hasNext()) {
      localObject1 = this.mNodes.iterator();
    }
    for (;;)
    {
      Object localObject4;
      if (!((Iterator)localObject1).hasNext())
      {
        return localAnimatorSet;
        localObject1 = (AnimatorSet.Node)((Iterator)localObject3).next();
        localObject2 = ((AnimatorSet.Node)localObject1).clone();
        localHashMap.put(localObject1, localObject2);
        localAnimatorSet.mNodes.add(localObject2);
        localAnimatorSet.mNodeMap.put(((AnimatorSet.Node)localObject2).animation, localObject2);
        ((AnimatorSet.Node)localObject2).dependencies = null;
        ((AnimatorSet.Node)localObject2).tmpDependencies = null;
        ((AnimatorSet.Node)localObject2).nodeDependents = null;
        ((AnimatorSet.Node)localObject2).nodeDependencies = null;
        localObject4 = ((AnimatorSet.Node)localObject2).animation.getListeners();
        if (localObject4 == null) {
          break;
        }
        Iterator localIterator = ((ArrayList)localObject4).iterator();
        localObject1 = null;
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            if (localObject1 == null) {
              break;
            }
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((ArrayList)localObject4).remove((Animator.AnimatorListener)((Iterator)localObject1).next());
            }
            break;
          }
          Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localIterator.next();
          if ((localAnimatorListener instanceof AnimatorSet.AnimatorSetListener))
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localAnimatorListener);
            localObject1 = localObject2;
          }
        }
      }
      localObject3 = (AnimatorSet.Node)((Iterator)localObject1).next();
      Object localObject2 = (AnimatorSet.Node)localHashMap.get(localObject3);
      if (((AnimatorSet.Node)localObject3).dependencies != null)
      {
        localObject3 = ((AnimatorSet.Node)localObject3).dependencies.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (AnimatorSet.Dependency)((Iterator)localObject3).next();
          ((AnimatorSet.Node)localObject2).addDependency(new AnimatorSet.Dependency((AnimatorSet.Node)localHashMap.get(((AnimatorSet.Dependency)localObject4).node), ((AnimatorSet.Dependency)localObject4).rule));
        }
      }
    }
  }
  
  public void end()
  {
    this.mTerminated = true;
    Iterator localIterator;
    if (isStarted())
    {
      if (this.mSortedNodes.size() != this.mNodes.size())
      {
        sortNodes();
        localIterator = this.mSortedNodes.iterator();
        if (localIterator.hasNext()) {
          break label127;
        }
      }
      if (this.mDelayAnim != null) {
        this.mDelayAnim.cancel();
      }
      if (this.mSortedNodes.size() > 0)
      {
        localIterator = this.mSortedNodes.iterator();
        label82:
        if (localIterator.hasNext()) {
          break label171;
        }
      }
      if (this.mListeners != null) {
        localIterator = ((ArrayList)this.mListeners.clone()).iterator();
      }
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.mStarted = false;
        return;
        label127:
        AnimatorSet.Node localNode = (AnimatorSet.Node)localIterator.next();
        if (this.mSetListener == null) {
          this.mSetListener = new AnimatorSet.AnimatorSetListener(this, this);
        }
        localNode.animation.addListener(this.mSetListener);
        break;
        label171:
        ((AnimatorSet.Node)localIterator.next()).animation.end();
        break label82;
      }
      ((Animator.AnimatorListener)localIterator.next()).onAnimationEnd(this);
    }
  }
  
  public ArrayList<Animator> getChildAnimations()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      localArrayList.add(((AnimatorSet.Node)localIterator.next()).animation);
    }
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public long getStartDelay()
  {
    return this.mStartDelay;
  }
  
  public boolean isRunning()
  {
    Iterator localIterator = this.mNodes.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (!((AnimatorSet.Node)localIterator.next()).animation.isRunning());
    return true;
  }
  
  public boolean isStarted()
  {
    return this.mStarted;
  }
  
  public AnimatorSet.Builder play(Animator paramAnimator)
  {
    if (paramAnimator != null)
    {
      this.mNeedsSort = true;
      return new AnimatorSet.Builder(this, paramAnimator);
    }
    return null;
  }
  
  public void playSequentially(List<Animator> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.mNeedsSort = true;
      if (paramList.size() != 1) {
        break label44;
      }
      play((Animator)paramList.get(0));
    }
    for (;;)
    {
      return;
      label44:
      int i = 0;
      while (i < paramList.size() - 1)
      {
        play((Animator)paramList.get(i)).before((Animator)paramList.get(i + 1));
        i += 1;
      }
    }
  }
  
  public void playSequentially(Animator... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs != null)
    {
      this.mNeedsSort = true;
      if (paramVarArgs.length == 1) {
        play(paramVarArgs[0]);
      }
    }
    else
    {
      return;
    }
    while (i < paramVarArgs.length - 1)
    {
      play(paramVarArgs[i]).before(paramVarArgs[(i + 1)]);
      i += 1;
    }
  }
  
  public void playTogether(Collection<Animator> paramCollection)
  {
    Iterator localIterator;
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      this.mNeedsSort = true;
      localIterator = paramCollection.iterator();
      paramCollection = null;
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Animator localAnimator = (Animator)localIterator.next();
      if (paramCollection == null) {
        paramCollection = play(localAnimator);
      } else {
        paramCollection.with(localAnimator);
      }
    }
  }
  
  public void playTogether(Animator... paramVarArgs)
  {
    int i = 1;
    AnimatorSet.Builder localBuilder;
    if (paramVarArgs != null)
    {
      this.mNeedsSort = true;
      localBuilder = play(paramVarArgs[0]);
    }
    for (;;)
    {
      if (i >= paramVarArgs.length) {
        return;
      }
      localBuilder.with(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public AnimatorSet setDuration(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("duration must be a value of zero or greater");
    }
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.mDuration = paramLong;
        return this;
      }
      ((AnimatorSet.Node)localIterator.next()).animation.setDuration(paramLong);
    }
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((AnimatorSet.Node)localIterator.next()).animation.setInterpolator(paramInterpolator);
    }
  }
  
  public void setStartDelay(long paramLong)
  {
    this.mStartDelay = paramLong;
  }
  
  public void setTarget(Object paramObject)
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Animator localAnimator = ((AnimatorSet.Node)localIterator.next()).animation;
      if ((localAnimator instanceof AnimatorSet)) {
        ((AnimatorSet)localAnimator).setTarget(paramObject);
      } else if ((localAnimator instanceof ObjectAnimator)) {
        ((ObjectAnimator)localAnimator).setTarget(paramObject);
      }
    }
  }
  
  public void setupEndValues()
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((AnimatorSet.Node)localIterator.next()).animation.setupEndValues();
    }
  }
  
  public void setupStartValues()
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((AnimatorSet.Node)localIterator.next()).animation.setupStartValues();
    }
  }
  
  public void start()
  {
    int k = 0;
    this.mTerminated = false;
    this.mStarted = true;
    sortNodes();
    int m = this.mSortedNodes.size();
    int i = 0;
    Object localObject1;
    label44:
    label66:
    label76:
    int j;
    if (i >= m)
    {
      localObject1 = new ArrayList();
      i = 0;
      if (i < m) {
        break label273;
      }
      if (this.mStartDelay > 0L) {
        break label472;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {
        break label436;
      }
      if (this.mListeners != null)
      {
        localObject1 = (ArrayList)this.mListeners.clone();
        j = ((ArrayList)localObject1).size();
        i = 0;
        label103:
        if (i < j) {
          break label529;
        }
      }
      if ((this.mNodes.size() == 0) && (this.mStartDelay == 0L))
      {
        this.mStarted = false;
        if (this.mListeners != null)
        {
          localObject1 = (ArrayList)this.mListeners.clone();
          j = ((ArrayList)localObject1).size();
          i = k;
        }
      }
    }
    for (;;)
    {
      if (i >= j)
      {
        return;
        localObject1 = (AnimatorSet.Node)this.mSortedNodes.get(i);
        Object localObject2 = ((AnimatorSet.Node)localObject1).animation.getListeners();
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
          localObject2 = new ArrayList((Collection)localObject2).iterator();
        }
        Object localObject3;
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext())
          {
            i += 1;
            break;
          }
          localObject3 = (Animator.AnimatorListener)((Iterator)localObject2).next();
          if (((localObject3 instanceof AnimatorSet.DependencyListener)) || ((localObject3 instanceof AnimatorSet.AnimatorSetListener))) {
            ((AnimatorSet.Node)localObject1).animation.removeListener((Animator.AnimatorListener)localObject3);
          }
        }
        label273:
        localObject2 = (AnimatorSet.Node)this.mSortedNodes.get(i);
        if (this.mSetListener == null) {
          this.mSetListener = new AnimatorSet.AnimatorSetListener(this, this);
        }
        if ((((AnimatorSet.Node)localObject2).dependencies == null) || (((AnimatorSet.Node)localObject2).dependencies.size() == 0))
        {
          ((ArrayList)localObject1).add(localObject2);
          ((AnimatorSet.Node)localObject2).animation.addListener(this.mSetListener);
          i += 1;
          break label44;
        }
        int n = ((AnimatorSet.Node)localObject2).dependencies.size();
        j = 0;
        for (;;)
        {
          if (j >= n)
          {
            ((AnimatorSet.Node)localObject2).tmpDependencies = ((ArrayList)((AnimatorSet.Node)localObject2).dependencies.clone());
            break;
          }
          localObject3 = (AnimatorSet.Dependency)((AnimatorSet.Node)localObject2).dependencies.get(j);
          ((AnimatorSet.Dependency)localObject3).node.animation.addListener(new AnimatorSet.DependencyListener(this, (AnimatorSet.Node)localObject2, ((AnimatorSet.Dependency)localObject3).rule));
          j += 1;
        }
        label436:
        localObject2 = (AnimatorSet.Node)((Iterator)localObject1).next();
        ((AnimatorSet.Node)localObject2).animation.start();
        this.mPlayingSet.add(((AnimatorSet.Node)localObject2).animation);
        break label66;
        label472:
        this.mDelayAnim = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        this.mDelayAnim.setDuration(this.mStartDelay);
        this.mDelayAnim.addListener(new AnimatorSet.1(this, (ArrayList)localObject1));
        this.mDelayAnim.start();
        break label76;
        label529:
        ((Animator.AnimatorListener)((ArrayList)localObject1).get(i)).onAnimationStart(this);
        i += 1;
        break label103;
      }
      ((Animator.AnimatorListener)((ArrayList)localObject1).get(i)).onAnimationEnd(this);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet
 * JD-Core Version:    0.7.0.1
 */