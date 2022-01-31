package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark;
import com.tencent.qphone.base.util.QLog;

class ArkAppNotifyCenter$GdtNotify$4$1
  implements Runnable
{
  ArkAppNotifyCenter$GdtNotify$4$1(ArkAppNotifyCenter.GdtNotify.4 param4, Object paramObject) {}
  
  public void run()
  {
    ark.arkNotify(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppNotifyCenter$GdtNotify$4.b, "get_device_info_callback", this.jdField_a_of_type_JavaLangObject.toString(), "json");
    QLog.d("ark.ArkAppNotifyCenter", 1, "ark get_device_info_callback", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.4.1
 * JD-Core Version:    0.7.0.1
 */