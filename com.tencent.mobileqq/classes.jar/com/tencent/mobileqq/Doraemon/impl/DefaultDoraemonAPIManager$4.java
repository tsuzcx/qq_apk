package com.tencent.mobileqq.Doraemon.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class DefaultDoraemonAPIManager$4
  implements DialogInterface.OnCancelListener
{
  DefaultDoraemonAPIManager$4(DefaultDoraemonAPIManager paramDefaultDoraemonAPIManager, UserPermission paramUserPermission, APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAPIManager.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.jdField_a_of_type_ComTencentMobileqqDoraemonUserPermission.a);
    DefaultDoraemonAPIManager.c(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAPIManager, 4, this.jdField_a_of_type_ComTencentMobileqqDoraemonAPIConfig, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager.4
 * JD-Core Version:    0.7.0.1
 */