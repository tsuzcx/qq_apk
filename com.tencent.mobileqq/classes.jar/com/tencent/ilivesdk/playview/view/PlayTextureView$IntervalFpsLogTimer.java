package com.tencent.ilivesdk.playview.view;

public class PlayTextureView$IntervalFpsLogTimer
  extends PlayTextureView.IntervalLogTimer
{
  private int mFps = 0;
  
  public PlayTextureView$IntervalFpsLogTimer(int paramInt)
  {
    super(paramInt);
  }
  
  public int getFps()
  {
    int i;
    if (this.mInterval != 0L) {
      i = this.mFps * 1000 / (int)this.mInterval;
    } else {
      i = this.mFps;
    }
    this.mFps = 0;
    return i;
  }
  
  public boolean isTimeToWriteLog()
  {
    this.mFps += 1;
    return super.isTimeToWriteLog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.IntervalFpsLogTimer
 * JD-Core Version:    0.7.0.1
 */