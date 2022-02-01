package com.tencent.ilivesdk.liveoverservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.liveoverservice_interface.model.LiveOverReq;

public abstract interface LiveOverServiceInterface
  extends ServiceBaseInterface
{
  public abstract void init(LiveOverServiceAdapter paramLiveOverServiceAdapter);
  
  public abstract void queryLiveOverData(LiveOverReq paramLiveOverReq, LiveOverServiceInterface.LiveOverRequestListener paramLiveOverRequestListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.liveoverservice_interface.LiveOverServiceInterface
 * JD-Core Version:    0.7.0.1
 */