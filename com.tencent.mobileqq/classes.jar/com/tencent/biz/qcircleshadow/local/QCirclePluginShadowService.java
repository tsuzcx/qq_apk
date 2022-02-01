package com.tencent.biz.qcircleshadow.local;

import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginProcessService;

public class QCirclePluginShadowService
  extends PluginProcessService
{
  public void onCreate()
  {
    try
    {
      super.onCreate();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ASDynamicEngine", 1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginShadowService
 * JD-Core Version:    0.7.0.1
 */