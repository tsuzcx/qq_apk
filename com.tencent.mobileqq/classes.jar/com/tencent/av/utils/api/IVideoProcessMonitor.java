package com.tencent.av.utils.api;

import android.os.IBinder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=true)
public abstract interface IVideoProcessMonitor
  extends QRouteApi
{
  public abstract void clearMonitorBinder();
  
  public abstract boolean isVideoProcessAlive();
  
  public abstract void setMonitorBinder(IBinder paramIBinder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.api.IVideoProcessMonitor
 * JD-Core Version:    0.7.0.1
 */