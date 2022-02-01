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
      l = Long.parseLong(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l = 0L;
    }
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if ((localSmartDeviceProxyMgr != null) && (localSmartDeviceProxyMgr.c(l))) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 206);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.DevicePlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */