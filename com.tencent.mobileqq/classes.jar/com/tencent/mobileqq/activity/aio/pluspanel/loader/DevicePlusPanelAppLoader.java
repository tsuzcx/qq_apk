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
    try
    {
      l = Long.parseLong(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if ((localSmartDeviceProxyMgr != null) && (localSmartDeviceProxyMgr.c(l))) {
        a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 206);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.DevicePlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */