package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

public class DevicePlusPanelAppLoader
  extends CommonPlusPanelAppLoader
{
  protected void b(BaseChatPie paramBaseChatPie)
  {
    long l;
    try
    {
      l = Long.parseLong(paramBaseChatPie.ah.b);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l = 0L;
    }
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)paramBaseChatPie.d.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if ((localSmartDeviceProxyMgr != null) && (localSmartDeviceProxyMgr.c(l))) {
      a(paramBaseChatPie.ah.a, 206);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.DevicePlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */