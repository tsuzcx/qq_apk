package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;
import mqq.os.MqqHandler;

class LoginInfoActivity$10$1
  extends SubAccountObserver
{
  LoginInfoActivity$10$1(LoginInfoActivity.10 param10, SvcDevLoginInfo paramSvcDevLoginInfo) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetKeyBack mainAccount=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" subAccount=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" key=");
      localStringBuilder.append(paramString3);
      QLog.d("LoginInfoActivity.AccDevSec", 2, localStringBuilder.toString());
    }
    if ((paramString3 != null) && (paramString3.length() <= 0))
    {
      LoginInfoActivity.access$1700(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity$10.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).post(new LoginInfoActivity.10.1.2(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetKeyBack begin to kickOutDev");
    }
    if (EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity$10.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app, this.jdField_a_of_type_QQServiceSvcDevLoginInfo.iAppId, (byte)1, HexUtil.hexStr2Bytes(paramString3), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity$10.jdField_a_of_type_Int))
    {
      LoginInfoActivity.access$2300(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity$10.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, 1);
      return;
    }
    LoginInfoActivity.access$1700(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity$10.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).post(new LoginInfoActivity.10.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.10.1
 * JD-Core Version:    0.7.0.1
 */