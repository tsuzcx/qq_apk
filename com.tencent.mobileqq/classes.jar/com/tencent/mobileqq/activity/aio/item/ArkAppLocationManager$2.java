package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class ArkAppLocationManager$2
  implements QQPermissionCallback
{
  ArkAppLocationManager$2(ArkAppLocationManager paramArkAppLocationManager, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramArrayOfString, paramArrayOfInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager.denied();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.2
 * JD-Core Version:    0.7.0.1
 */