package com.tencent.av.utils.api.impl;

import android.os.IBinder;
import com.tencent.av.utils.api.IVideoProcessMonitor;

public class VideoProcessMonitorImpl
  implements IVideoProcessMonitor
{
  private IBinder mMonitorBinder;
  
  public void clearMonitorBinder()
  {
    this.mMonitorBinder = null;
  }
  
  public boolean isVideoProcessAlive()
  {
    return this.mMonitorBinder != null;
  }
  
  public void setMonitorBinder(IBinder paramIBinder)
  {
    this.mMonitorBinder = paramIBinder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.api.impl.VideoProcessMonitorImpl
 * JD-Core Version:    0.7.0.1
 */