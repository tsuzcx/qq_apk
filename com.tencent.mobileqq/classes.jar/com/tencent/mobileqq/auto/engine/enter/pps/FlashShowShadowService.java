package com.tencent.mobileqq.auto.engine.enter.pps;

import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginProcessService;

public class FlashShowShadowService
  extends PluginProcessService
{
  public void onCreate()
  {
    try
    {
      super.onCreate();
      QLog.d("flash-show-app", 1, "FlashShowShadowService created");
      return;
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    QLog.d("flash-show-app", 1, "FlashShowShadowService created");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.enter.pps.FlashShowShadowService
 * JD-Core Version:    0.7.0.1
 */