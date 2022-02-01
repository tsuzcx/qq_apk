package com.nineoldandroids.animation;

public class TimeAnimator
  extends ValueAnimator
{
  private TimeAnimator.TimeListener mListener;
  private long mPreviousTime = -1L;
  
  void animateValue(float paramFloat) {}
  
  boolean animationFrame(long paramLong)
  {
    int i = this.mPlayingState;
    long l1 = 0L;
    if (i == 0)
    {
      this.mPlayingState = 1;
      if (this.mSeekTime < 0L)
      {
        this.mStartTime = paramLong;
      }
      else
      {
        this.mStartTime = (paramLong - this.mSeekTime);
        this.mSeekTime = -1L;
      }
    }
    if (this.mListener != null)
    {
      long l2 = this.mStartTime;
      long l3 = this.mPreviousTime;
      if (l3 >= 0L) {
        l1 = paramLong - l3;
      }
      this.mPreviousTime = paramLong;
      this.mListener.onTimeUpdate(this, paramLong - l2, l1);
    }
    return false;
  }
  
  void initAnimation() {}
  
  public void setTimeListener(TimeAnimator.TimeListener paramTimeListener)
  {
    this.mListener = paramTimeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.TimeAnimator
 * JD-Core Version:    0.7.0.1
 */