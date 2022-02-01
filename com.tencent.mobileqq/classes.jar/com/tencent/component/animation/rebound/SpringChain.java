package com.tencent.component.animation.rebound;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SpringChain
  implements SpringListener
{
  private static final int DEFAULT_ATTACHMENT_FRICTION = 10;
  private static final int DEFAULT_ATTACHMENT_TENSION = 70;
  private static final int DEFAULT_MAIN_FRICTION = 6;
  private static final int DEFAULT_MAIN_TENSION = 40;
  private static int id = 0;
  private static final SpringConfigRegistry registry = ;
  private final SpringConfig mAttachmentSpringConfig;
  private int mControlSpringIndex = -1;
  private final CopyOnWriteArrayList<SpringListener> mListeners = new CopyOnWriteArrayList();
  private final SpringConfig mMainSpringConfig;
  private final SpringSystem mSpringSystem = SpringSystem.create();
  private final CopyOnWriteArrayList<Spring> mSprings = new CopyOnWriteArrayList();
  
  private SpringChain()
  {
    this(40, 6, 70, 10);
  }
  
  private SpringChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mMainSpringConfig = SpringConfig.fromOrigamiTensionAndFriction(paramInt1, paramInt2);
    this.mAttachmentSpringConfig = SpringConfig.fromOrigamiTensionAndFriction(paramInt3, paramInt4);
    SpringConfigRegistry localSpringConfigRegistry = registry;
    SpringConfig localSpringConfig = this.mMainSpringConfig;
    StringBuilder localStringBuilder = new StringBuilder("main spring ");
    paramInt1 = id;
    id = paramInt1 + 1;
    localSpringConfigRegistry.addSpringConfig(localSpringConfig, paramInt1);
    localSpringConfigRegistry = registry;
    localSpringConfig = this.mAttachmentSpringConfig;
    localStringBuilder = new StringBuilder("attachment spring ");
    paramInt1 = id;
    id = paramInt1 + 1;
    localSpringConfigRegistry.addSpringConfig(localSpringConfig, paramInt1);
  }
  
  public static SpringChain create()
  {
    return new SpringChain();
  }
  
  public static SpringChain create(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new SpringChain(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public SpringChain addSpring(SpringListener paramSpringListener)
  {
    Spring localSpring = this.mSpringSystem.createSpring().addListener(this).setSpringConfig(this.mAttachmentSpringConfig);
    this.mSprings.add(localSpring);
    this.mListeners.add(paramSpringListener);
    return this;
  }
  
  public List<Spring> getAllSprings()
  {
    return this.mSprings;
  }
  
  public SpringConfig getAttachmentSpringConfig()
  {
    return this.mAttachmentSpringConfig;
  }
  
  public Spring getControlSpring()
  {
    return (Spring)this.mSprings.get(this.mControlSpringIndex);
  }
  
  public SpringConfig getMainSpringConfig()
  {
    return this.mMainSpringConfig;
  }
  
  public void onSpringActivate(Spring paramSpring)
  {
    int i = this.mSprings.indexOf(paramSpring);
    ((SpringListener)this.mListeners.get(i)).onSpringActivate(paramSpring);
  }
  
  public void onSpringAtRest(Spring paramSpring)
  {
    int i = this.mSprings.indexOf(paramSpring);
    ((SpringListener)this.mListeners.get(i)).onSpringAtRest(paramSpring);
  }
  
  public void onSpringEndStateChange(Spring paramSpring)
  {
    int i = this.mSprings.indexOf(paramSpring);
    ((SpringListener)this.mListeners.get(i)).onSpringEndStateChange(paramSpring);
  }
  
  public void onSpringUpdate(Spring paramSpring)
  {
    int j = this.mSprings.indexOf(paramSpring);
    SpringListener localSpringListener = (SpringListener)this.mListeners.get(j);
    int i;
    if (j == this.mControlSpringIndex)
    {
      i = j + 1;
      j -= 1;
    }
    for (;;)
    {
      if ((i > -1) && (i < this.mSprings.size())) {
        ((Spring)this.mSprings.get(i)).setEndValue(paramSpring.getCurrentValue());
      }
      if ((j > -1) && (j < this.mSprings.size())) {
        ((Spring)this.mSprings.get(j)).setEndValue(paramSpring.getCurrentValue());
      }
      localSpringListener.onSpringUpdate(paramSpring);
      return;
      if (j < this.mControlSpringIndex)
      {
        j -= 1;
        i = -1;
      }
      else if (j > this.mControlSpringIndex)
      {
        i = j + 1;
        j = -1;
      }
      else
      {
        j = -1;
        i = -1;
      }
    }
  }
  
  public SpringChain setControlSpringIndex(int paramInt)
  {
    this.mControlSpringIndex = paramInt;
    if ((Spring)this.mSprings.get(this.mControlSpringIndex) == null) {
      return null;
    }
    Iterator localIterator = this.mSpringSystem.getAllSprings().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        getControlSpring().setSpringConfig(this.mMainSpringConfig);
        return this;
      }
      ((Spring)localIterator.next()).setSpringConfig(this.mAttachmentSpringConfig);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.animation.rebound.SpringChain
 * JD-Core Version:    0.7.0.1
 */