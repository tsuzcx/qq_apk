package com.tencent.biz.qqstory.takevideo.rmw;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class RMWServiceProxy$CallbackHandler
  extends Handler
{
  private RMWServiceProxy a;
  
  public RMWServiceProxy$CallbackHandler(RMWServiceProxy paramRMWServiceProxy)
  {
    super(Looper.getMainLooper());
    this.a = paramRMWServiceProxy;
  }
  
  public void handleMessage(Message paramMessage)
  {
    RMWServiceProxy localRMWServiceProxy = this.a;
    if (localRMWServiceProxy != null) {
      localRMWServiceProxy.a(Message.obtain(paramMessage));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy.CallbackHandler
 * JD-Core Version:    0.7.0.1
 */