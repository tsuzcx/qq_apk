package com.tencent.mobileqq.app;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;

class PublicAccountHandler$4
  implements QQPermissionCallback
{
  PublicAccountHandler$4(PublicAccountHandler paramPublicAccountHandler, int paramInt, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("PublicAccountHandler", 1, "User requestPermissions denied...");
    ThreadManager.getSubThreadHandler().post(new PublicAccountHandler.4.1(this));
    DialogUtil.a(this.jdField_a_of_type_MqqAppAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("PublicAccountHandler", 1, "User requestPermissions grant...");
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.4
 * JD-Core Version:    0.7.0.1
 */