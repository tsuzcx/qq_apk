package com.tencent.ilivesdk.liveoverservice_interface;

import com.tencent.ilivesdk.liveoverservice_interface.model.LiveOverRsp;

public abstract interface LiveOverServiceInterface$LiveOverRequestListener
{
  public abstract void onRecv(LiveOverServiceInterface.RetCode paramRetCode, String paramString, LiveOverRsp paramLiveOverRsp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.liveoverservice_interface.LiveOverServiceInterface.LiveOverRequestListener
 * JD-Core Version:    0.7.0.1
 */