package com.tencent.mobileqq.Doraemon.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class DefaultDoraemonAPIManager$3
  implements View.OnClickListener
{
  DefaultDoraemonAPIManager$3(DefaultDoraemonAPIManager paramDefaultDoraemonAPIManager, UserPermission paramUserPermission, APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAPIManager.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reject ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDoraemonUserPermission.a);
    QLog.i("DoraemonOpenAPI.apiMgr", 1, localStringBuilder.toString());
    DefaultDoraemonAPIManager.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAPIManager, this.jdField_a_of_type_ComTencentMobileqqDoraemonUserPermission, 1);
    DefaultDoraemonAPIManager.b(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAPIManager, 4, this.jdField_a_of_type_ComTencentMobileqqDoraemonAPIConfig, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager.3
 * JD-Core Version:    0.7.0.1
 */