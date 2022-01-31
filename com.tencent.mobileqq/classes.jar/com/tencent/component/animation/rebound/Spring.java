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
    if (paramBaseSpringSystem == null) {
      throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }
    this.mSpringSystem = paramBaseSpringSystem;
    paramBaseSpringSystem = new StringBuilder("spring:");
    int i = ID;
    ID = i + 1;
    this.mId = i;
    setSpringConfig(SpringConfig.defaultConfig);
  }
  
  private double getDisplacementDistanceForState(Spring.PhysicsState paramPhysicsState)
  {
    return Math.abs(this.mEndValue - paramPhysicsState.position);
  }
  
  private void interpolate(double paramDouble)
  {
    this.mCurrentState.position = (this.mCurrentState.position * paramDouble + this.mPreviousState.position * (1.0D - paramDouble));
    this.mCurrentState.velocity = (this.mCurrentState.velocity * paramDouble + this.mPreviousState.velocity * (1.0D - paramDouble));
  }
  
  public Spring addListener(SpringListener paramSpringListener)
  {
    if (paramSpringListener == null) {
      throw new IllegalArgumentException("newListener is required");
    }
    this.mListeners.add(paramSpringListener);
    return this;
  }
  
  void advance(double paramDouble)
  {
    boolean bool = isAtRest();
    if ((bool) && (this.mWasAtRest)) {
      return;
    }
    double d1 = paramDouble;
    if (paramDouble > 0.064D) {
      d1 = 0.064D;
    }
    this.mTimeAccumulator += d1;
    double d4 = this.mSpringConfig.tension;
    double d5 = this.mSpringConfig.friction;
    d1 = this.mCurrentState.position;
    paramDouble = this.mCurrentState.velocity;
    double d3 = this.mTempState.position;
    double d2 = this.mTempState.velocity;
    label95:
    if (this.mTimeAccumulator < 0.001D)
    {
      this.mTempState.position = d3;
      this.mTempState.velocity = d2;
      this.mCurrentState.position = d1;
      this.mCurrentState.velocity = paramDouble;
      if (this.mTimeAccumulator > 0.0D) {
        interpolate(this.mTimeAccumulator / 0.001D);
      }
      if ((!isAtRest()) && ((!this.mOvershootClampingEnabled) || (!isOvershooting()))) {
        break label575;
      }
      if (d4 <= 0.0D) {
        break label547;
      }
      this.mStartValue = this.mEndValue;
      this.mCurrentState.position = this.mEndValue;
      setVelocity(0.0D);
      bool = true;
    }
    label547:
    label575:
    for (;;)
    {
      label208:
      if (this.mWasAtRest) {
        this.mWasAtRest = false;
      }
      for (int i = 1;; i = 0)
      {
        int j = 0;
        if (bool)
        {
          this.mWasAtRest = true;
          j = 1;
        }
        Iterator localIterator = this.mListeners.iterator();
        while (localIterator.hasNext())
        {
          SpringListener localSpringListener = (SpringListener)localIterator.next();
          if (i != 0) {
            localSpringListener.onSpringActivate(this);
          }
          localSpringListener.onSpringUpdate(this);
          if (j != 0) {
            localSpringListener.onSpringAtRest(this);
          }
        }
        break;
        this.mTimeAccumulator -= 0.001D;
        if (this.mTimeAccumulator < 0.001D)
        {
          this.mPreviousState.position = d1;
          this.mPreviousState.velocity = paramDouble;
        }
        double d6 = (this.mEndValue - d3) * d4 - d5 * paramDouble;
        double d10 = paramDouble + 0.001D * d6 * 0.5D;
        double d7 = (this.mEndValue - (0.001D * paramDouble * 0.5D + d1)) * d4 - d5 * d10;
        double d11 = paramDouble + 0.001D * d7 * 0.5D;
        double d8 = (this.mEndValue - (0.001D * d10 * 0.5D + d1)) * d4 - d5 * d11;
        d3 = d1 + 0.001D * d11;
        d2 = 0.001D * d8 + paramDouble;
        double d9 = this.mEndValue;
        d1 += ((d10 + d11) * 2.0D + paramDouble + d2) * 0.1666666666666667D * 0.001D;
        paramDouble += (d6 + (d7 + d8) * 2.0D + ((d9 - d3) * d4 - d5 * d2)) * 0.1666666666666667D * 0.001D;
        break label95;
        this.mEndValue = this.mCurrentState.position;
        this.mStartValue = this.mEndValue;
        break label208;
      }
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
    if (paramSpringListener == null) {
      throw new IllegalArgumentException("listenerToRemove is required");
    }
    this.mListeners.remove(paramSpringListener);
    return this;
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
    if ((this.mEndValue == paramDouble) && (isAtRest())) {}
    for (;;)
    {
      return this;
      this.mStartValue = getCurrentValue();
      this.mEndValue = paramDouble;
      this.mSpringSystem.activateSpring(getId());
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((SpringListener)localIterator.next()).onSpringEndStateChange(this);
      }
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
    if (paramSpringConfig == null) {
      throw new IllegalArgumentException("springConfig is required");
    }
    this.mSpringConfig = paramSpringConfig;
    return this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.animation.rebound.Spring
 * JD-Core Version:    0.7.0.1
 */