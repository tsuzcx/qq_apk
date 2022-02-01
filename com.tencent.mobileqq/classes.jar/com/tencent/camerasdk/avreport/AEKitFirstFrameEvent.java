package com.tencent.camerasdk.avreport;

import android.os.AsyncTask;

public class AEKitFirstFrameEvent
{
  private int mCameraFirstDataAavailable = 0;
  private int mFirstFrameRenderTime = 0;
  private String mLaunchType;
  
  private void resetData()
  {
    this.mFirstFrameRenderTime = 0;
    this.mCameraFirstDataAavailable = 0;
    this.mLaunchType = null;
  }
  
  public AEKitFirstFrameEvent addCameraFirstFrameDataTime(long paramLong)
  {
    this.mCameraFirstDataAavailable = ((int)paramLong);
    return this;
  }
  
  public AEKitFirstFrameEvent addFirstRenderCompletedTime(long paramLong)
  {
    this.mFirstFrameRenderTime = ((int)paramLong);
    return this;
  }
  
  public AEKitFirstFrameEvent addLanchCount(int paramInt)
  {
    if (paramInt > 1) {}
    for (String str = "hot";; str = "cold")
    {
      this.mLaunchType = str;
      return this;
    }
  }
  
  public void report()
  {
    AsyncTask.execute(new AEKitFirstFrameEvent.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.AEKitFirstFrameEvent
 * JD-Core Version:    0.7.0.1
 */