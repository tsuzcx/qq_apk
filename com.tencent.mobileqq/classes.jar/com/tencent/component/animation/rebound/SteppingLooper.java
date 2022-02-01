package com.tencent.component.animation.rebound;

public class SteppingLooper
  extends SpringLooper
{
  private long mLastTime;
  private boolean mStarted;
  
  public void start()
  {
    this.mStarted = true;
    this.mLastTime = 0L;
  }
  
  public boolean step(long paramLong)
  {
    if ((this.mSpringSystem == null) || (!this.mStarted)) {
      return false;
    }
    paramLong = this.mLastTime + paramLong;
    this.mSpringSystem.loop(paramLong);
    this.mLastTime = paramLong;
    return this.mSpringSystem.getIsIdle();
  }
  
  public void stop()
  {
    this.mStarted = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.animation.rebound.SteppingLooper
 * JD-Core Version:    0.7.0.1
 */