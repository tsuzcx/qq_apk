package com.tencent.component.animation.rebound;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class Spring
{
  private static int ID = 0;
  private static final double MAX_DELTA_TIME_SEC = 0.064D;
  private static final double SOLVER_TIMESTEP_SEC = 0.001D;
  private final Spring.PhysicsState mCurrentState = new Spring.PhysicsState(null);
  private double mDisplacementFromRestThreshold = 0.005D;
  private double mEndValue;
  private final String mId;
  private CopyOnWriteArraySet<SpringListener> mListeners = new CopyOnWriteArraySet();
  private boolean mOvershootClampingEnabled;
  private final Spring.PhysicsState mPreviousState = new Spring.PhysicsState(null);
  private double mRestSpeedThreshold = 0.005D;
  private SpringConfig mSpringConfig;
  private final BaseSpringSystem mSpringSystem;
  private double mStartValue;
  private final Spring.PhysicsState mTempState = new Spring.PhysicsState(null);
  private double mTimeAccumulator = 0.0D;
  private boolean mWasAtRest = true;
  
  Spring(BaseSpringSystem paramBaseSpringSystem)
  {
    if (paramBaseSpringSystem != null)
    {
      this.mSpringSystem = paramBaseSpringSystem;
      paramBaseSpringSystem = new StringBuilder("spring:");
      int i = ID;
      ID = i + 1;
      paramBaseSpringSystem.append(i);
      this.mId = paramBaseSpringSystem.toString();
      setSpringConfig(SpringConfig.defaultConfig);
      return;
    }
    throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
  }
  
  private double getDisplacementDistanceForState(Spring.PhysicsState paramPhysicsState)
  {
    return Math.abs(this.mEndValue - paramPhysicsState.position);
  }
  
  private void interpolate(double paramDouble)
  {
    Spring.PhysicsState localPhysicsState = this.mCurrentState;
    double d1 = localPhysicsState.position;
    double d2 = this.mPreviousState.position;
    double d3 = 1.0D - paramDouble;
    localPhysicsState.position = (d1 * paramDouble + d2 * d3);
    localPhysicsState = this.mCurrentState;
    localPhysicsState.velocity = (localPhysicsState.velocity * paramDouble + this.mPreviousState.velocity * d3);
  }
  
  public Spring addListener(SpringListener paramSpringListener)
  {
    if (paramSpringListener != null)
    {
      this.mListeners.add(paramSpringListener);
      return this;
    }
    throw new IllegalArgumentException("newListener is required");
  }
  
  void advance(double paramDouble)
  {
    boolean bool2 = isAtRest();
    if ((bool2) && (this.mWasAtRest)) {
      return;
    }
    double d1 = 0.064D;
    if (paramDouble > 0.064D) {
      paramDouble = d1;
    }
    this.mTimeAccumulator += paramDouble;
    double d4 = this.mSpringConfig.tension;
    double d5 = this.mSpringConfig.friction;
    d1 = this.mCurrentState.position;
    paramDouble = this.mCurrentState.velocity;
    double d2 = this.mTempState.position;
    double d3 = this.mTempState.velocity;
    for (;;)
    {
      double d6 = this.mTimeAccumulator;
      Object localObject;
      if (d6 < 0.001D)
      {
        localObject = this.mTempState;
        ((Spring.PhysicsState)localObject).position = d2;
        ((Spring.PhysicsState)localObject).velocity = d3;
        localObject = this.mCurrentState;
        ((Spring.PhysicsState)localObject).position = d1;
        ((Spring.PhysicsState)localObject).velocity = paramDouble;
        if (d6 > 0.0D) {
          interpolate(d6 / 0.001D);
        }
        boolean bool1;
        if (!isAtRest())
        {
          bool1 = bool2;
          if (this.mOvershootClampingEnabled)
          {
            bool1 = bool2;
            if (!isOvershooting()) {}
          }
        }
        else
        {
          if (d4 > 0.0D)
          {
            paramDouble = this.mEndValue;
            this.mStartValue = paramDouble;
            this.mCurrentState.position = paramDouble;
          }
          else
          {
            this.mEndValue = this.mCurrentState.position;
            this.mStartValue = this.mEndValue;
          }
          setVelocity(0.0D);
          bool1 = true;
        }
        int i;
        if (this.mWasAtRest)
        {
          this.mWasAtRest = false;
          i = 1;
        }
        else
        {
          i = 0;
        }
        int j;
        if (bool1)
        {
          this.mWasAtRest = true;
          j = 1;
        }
        else
        {
          j = 0;
        }
        localObject = this.mListeners.iterator();
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            return;
          }
          SpringListener localSpringListener = (SpringListener)((Iterator)localObject).next();
          if (i != 0) {
            localSpringListener.onSpringActivate(this);
          }
          localSpringListener.onSpringUpdate(this);
          if (j != 0) {
            localSpringListener.onSpringAtRest(this);
          }
        }
      }
      this.mTimeAccumulator = (d6 - 0.001D);
      if (this.mTimeAccumulator < 0.001D)
      {
        localObject = this.mPreviousState;
        ((Spring.PhysicsState)localObject).position = d1;
        ((Spring.PhysicsState)localObject).velocity = paramDouble;
      }
      d6 = this.mEndValue;
      double d7 = (d6 - d2) * d4 - d5 * paramDouble;
      double d10 = paramDouble + d7 * 0.001D * 0.5D;
      double d8 = (d6 - (paramDouble * 0.001D * 0.5D + d1)) * d4 - d5 * d10;
      double d11 = paramDouble + d8 * 0.001D * 0.5D;
      double d9 = (d6 - (d1 + d10 * 0.001D * 0.5D)) * d4 - d5 * d11;
      d2 = d1 + d11 * 0.001D;
      d3 = paramDouble + d9 * 0.001D;
      d1 += (paramDouble + (d10 + d11) * 2.0D + d3) * 0.1666666666666667D * 0.001D;
      paramDouble += (d7 + (d8 + d9) * 2.0D + ((d6 - d2) * d4 - d5 * d3)) * 0.1666666666666667D * 0.001D;
    }
  }
  
  public boolean currentValueIsApproximately(double paramDouble)
  {
    return Math.abs(getCurrentValue() - paramDouble) <= getRestDisplacementThreshold();
  }
  
  public void destroy()
  {
    this.mListeners.clear();
    this.mSpringSystem.deregisterSpring(this);
  }
  
  public double getCurrentDisplacementDistance()
  {
    return getDisplacementDistanceForState(this.mCurrentState);
  }
  
  public double getCurrentValue()
  {
    return this.mCurrentState.position;
  }
  
  public double getEndValue()
  {
    return this.mEndValue;
  }
  
  public String getId()
  {
    return this.mId;
  }
  
  public double getRestDisplacementThreshold()
  {
    return this.mDisplacementFromRestThreshold;
  }
  
  public double getRestSpeedThreshold()
  {
    return this.mRestSpeedThreshold;
  }
  
  public SpringConfig getSpringConfig()
  {
    return this.mSpringConfig;
  }
  
  public double getStartValue()
  {
    return this.mStartValue;
  }
  
  public double getVelocity()
  {
    return this.mCurrentState.velocity;
  }
  
  public boolean isAtRest()
  {
    return (Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold) && ((getDisplacementDistanceForState(this.mCurrentState) <= this.mDisplacementFromRestThreshold) || (this.mSpringConfig.tension == 0.0D));
  }
  
  public boolean isOvershootClampingEnabled()
  {
    return this.mOvershootClampingEnabled;
  }
  
  public boolean isOvershooting()
  {
    return (this.mSpringConfig.tension > 0.0D) && (((this.mStartValue < this.mEndValue) && (getCurrentValue() > this.mEndValue)) || ((this.mStartValue > this.mEndValue) && (getCurrentValue() < this.mEndValue)));
  }
  
  public Spring removeAllListeners()
  {
    this.mListeners.clear();
    return this;
  }
  
  public Spring removeListener(SpringListener paramSpringListener)
  {
    if (paramSpringListener != null)
    {
      this.mListeners.remove(paramSpringListener);
      return this;
    }
    throw new IllegalArgumentException("listenerToRemove is required");
  }
  
  public Spring setAtRest()
  {
    this.mEndValue = this.mCurrentState.position;
    this.mTempState.position = this.mCurrentState.position;
    this.mCurrentState.velocity = 0.0D;
    return this;
  }
  
  public Spring setCurrentValue(double paramDouble)
  {
    return setCurrentValue(paramDouble, true);
  }
  
  public Spring setCurrentValue(double paramDouble, boolean paramBoolean)
  {
    this.mStartValue = paramDouble;
    this.mCurrentState.position = paramDouble;
    this.mSpringSystem.activateSpring(getId());
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (paramBoolean) {
          setAtRest();
        }
        return this;
      }
      ((SpringListener)localIterator.next()).onSpringUpdate(this);
    }
  }
  
  public Spring setEndValue(double paramDouble)
  {
    if ((this.mEndValue == paramDouble) && (isAtRest())) {
      return this;
    }
    this.mStartValue = getCurrentValue();
    this.mEndValue = paramDouble;
    this.mSpringSystem.activateSpring(getId());
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return this;
      }
      ((SpringListener)localIterator.next()).onSpringEndStateChange(this);
    }
  }
  
  public Spring setOvershootClampingEnabled(boolean paramBoolean)
  {
    this.mOvershootClampingEnabled = paramBoolean;
    return this;
  }
  
  public Spring setRestDisplacementThreshold(double paramDouble)
  {
    this.mDisplacementFromRestThreshold = paramDouble;
    return this;
  }
  
  public Spring setRestSpeedThreshold(double paramDouble)
  {
    this.mRestSpeedThreshold = paramDouble;
    return this;
  }
  
  public Spring setSpringConfig(SpringConfig paramSpringConfig)
  {
    if (paramSpringConfig != null)
    {
      this.mSpringConfig = paramSpringConfig;
      return this;
    }
    throw new IllegalArgumentException("springConfig is required");
  }
  
  public Spring setVelocity(double paramDouble)
  {
    if (paramDouble == this.mCurrentState.velocity) {
      return this;
    }
    this.mCurrentState.velocity = paramDouble;
    this.mSpringSystem.activateSpring(getId());
    return this;
  }
  
  public boolean systemShouldAdvance()
  {
    return (!isAtRest()) || (!wasAtRest());
  }
  
  public boolean wasAtRest()
  {
    return this.mWasAtRest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.animation.rebound.Spring
 * JD-Core Version:    0.7.0.1
 */