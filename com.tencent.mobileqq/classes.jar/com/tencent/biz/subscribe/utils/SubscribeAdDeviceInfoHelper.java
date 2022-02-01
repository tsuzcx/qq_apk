package com.tencent.biz.subscribe.utils;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class SubscribeAdDeviceInfoHelper
{
  private static SubscribeAdDeviceInfoHelper jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeAdDeviceInfoHelper;
  private qq_ad_get.QQAdGet.DeviceInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  
  public static SubscribeAdDeviceInfoHelper a()
  {
    if (jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeAdDeviceInfoHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeAdDeviceInfoHelper == null) {
          jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeAdDeviceInfoHelper = new SubscribeAdDeviceInfoHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeAdDeviceInfoHelper;
  }
  
  public qq_ad_get.QQAdGet.DeviceInfo a()
  {
    a();
    return this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  }
  
  public void a()
  {
    ThreadManager.getFileThreadHandler().post(new SubscribeAdDeviceInfoHelper.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper
 * JD-Core Version:    0.7.0.1
 */