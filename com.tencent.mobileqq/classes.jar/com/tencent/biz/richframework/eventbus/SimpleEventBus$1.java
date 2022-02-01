package com.tencent.biz.richframework.eventbus;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import mqq.os.MqqHandler;

class SimpleEventBus$1
  extends QIPCModule
{
  SimpleEventBus$1(SimpleEventBus paramSimpleEventBus, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    ThreadManager.getUIHandler().post(new SimpleEventBus.1.1(this, paramString, paramBundle));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.eventbus.SimpleEventBus.1
 * JD-Core Version:    0.7.0.1
 */