package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginInfoActivity$10
  implements View.OnClickListener
{
  LoginInfoActivity$10(LoginInfoActivity paramLoginInfoActivity, Button paramButton, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity;
      QQToast.a((Context)localObject, ((LoginInfoActivity)localObject).getString(2131692183), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getTitleBarHeight());
    }
    else
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app, "CliOper", "", "", "My_eq", "Kick_off_PC", 0, 0, "", "", "", "");
      localObject = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetButton.getTag();
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app.getAccount(), new LoginInfoActivity.10.1(this, (SvcDevLoginInfo)localObject));
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getString(2131694375), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getTitleBarHeight());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.10
 * JD-Core Version:    0.7.0.1
 */