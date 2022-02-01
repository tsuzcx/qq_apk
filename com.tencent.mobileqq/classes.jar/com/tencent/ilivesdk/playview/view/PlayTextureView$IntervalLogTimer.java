package com.tencent.ilivesdk.playview.view;

public class PlayTextureView$IntervalLogTimer
{
  protected long mInterval;
  private long mLastTime = 0L;
  
  public PlayTextureView$IntervalLogTimer(int paramInt)
  {
    this.mInterval = paramInt;
    this.mLastTime = (System.currentTimeMillis() - paramInt - 1L);
  }
  
  public boolean isTimeToWriteLog()
  {
    if (this.mLastTime + this.mInterval < System.currentTimeMillis())
    {
      this.mLastTime = System.currentTimeMillis();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.IntervalLogTimer
 * JD-Core Version:    0.7.0.1
 */