package com.tencent.mobileqq.ark.component;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class ArkAppLocationManager$2
  implements QQPermissionCallback
{
  ArkAppLocationManager$2(ArkAppLocationManager paramArkAppLocationManager, QBaseActivity paramQBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramArrayOfString, paramArrayOfInt);
    this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppLocationManager.denied();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppLocationManager.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppLocationManager.2
 * JD-Core Version:    0.7.0.1
 */