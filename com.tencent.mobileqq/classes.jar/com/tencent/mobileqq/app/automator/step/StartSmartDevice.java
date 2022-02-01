package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.QLog;

public class StartSmartDevice
  extends AsyncStep
{
  protected int doStep()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start device when device bind flag:");
    localStringBuilder.append(localSmartDeviceProxyMgr.c());
    QLog.i("smartdevice", 1, localStringBuilder.toString());
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartSmartDevice
 * JD-Core Version:    0.7.0.1
 */