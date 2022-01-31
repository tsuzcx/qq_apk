package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.QLog;

public class StartSmartDevice
  extends AsyncStep
{
  protected int a()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(51);
    QLog.i("smartdevice", 1, "start device when device bind flag:" + localSmartDeviceProxyMgr.a());
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartSmartDevice
 * JD-Core Version:    0.7.0.1
 */