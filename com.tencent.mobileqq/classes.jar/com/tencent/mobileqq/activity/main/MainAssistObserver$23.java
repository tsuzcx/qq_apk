package com.tencent.mobileqq.activity.main;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$23
  extends OpenIdObserver
{
  MainAssistObserver$23(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->onGetOpenId, isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" data: ");
      localStringBuilder.append(paramOpenID.toString());
      localStringBuilder.append(" mOpenId = ");
      localStringBuilder.append(this.a.jdField_b_of_type_JavaLangString);
      QLog.i("MainAssistObserver", 2, localStringBuilder.toString());
    }
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.isFinishing())
    {
      if (this.a.c) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.hide();
      }
      if (this.a.jdField_b_of_type_AndroidOsHandler != null) {
        this.a.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MainAssistObserver", 2, "openIdObserver success");
        }
        if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) && (!paramOpenID.openID.equals(this.a.jdField_b_of_type_JavaLangString))) {
          this.a.i();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MainAssistObserver", 2, "openIdObserver fail");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.23
 * JD-Core Version:    0.7.0.1
 */