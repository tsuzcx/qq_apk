package com.tencent.biz.qqstory.takevideo.rmw;

import android.os.Handler;
import android.os.Message;

class RMWService$1
  extends Handler
{
  RMWService$1(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    RMWLog.b("RMWService", "service.handle : " + RMWProto.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.1
 * JD-Core Version:    0.7.0.1
 */