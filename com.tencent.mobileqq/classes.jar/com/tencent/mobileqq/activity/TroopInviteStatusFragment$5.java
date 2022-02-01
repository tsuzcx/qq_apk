package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopInviteStatusFragment$5
  extends MessageObserver
{
  TroopInviteStatusFragment$5(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  protected void onSendSystemMsgActionError(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendSystemMsgActionError logStr:");
      localStringBuilder.append(paramString);
      QLog.i("TroopInviteStatusFragment", 2, localStringBuilder.toString());
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719418);
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight()).show();
    }
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (!paramBoolean)
    {
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131718739);
      if (!TextUtils.isEmpty(paramString3)) {
        paramString1 = paramString3;
      }
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString1, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692656);
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, paramString1, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    paramString1 = this.a;
    paramString1.c = -1;
    TroopInviteStatusFragment.a(paramString1);
    paramString1 = this.a;
    paramString1.jdField_b_of_type_Boolean = true;
    paramString1.jdField_a_of_type_AndroidOsHandler.post(this.a.jdField_b_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.5
 * JD-Core Version:    0.7.0.1
 */