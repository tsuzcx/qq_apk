package com.tencent.mobileqq.activity.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$18
  extends Handler
{
  MainAssistObserver$18(MainAssistObserver paramMainAssistObserver, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app != null))
    {
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.isLogin()) {
        return;
      }
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 3)
          {
            if (i != 28929) {
              return;
            }
            paramMessage = paramMessage.getData();
            if (paramMessage == null) {
              return;
            }
            i = paramMessage.getInt("result");
            if ((i != -1) && (i != -2))
            {
              if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
                this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
              }
            }
            else
            {
              String str;
              if (i == -1)
              {
                str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131718581);
                paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131718580);
              }
              else
              {
                str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131718583);
                paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131718582);
              }
              try
              {
                if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
                {
                  if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
                    this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
                  }
                  this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
                }
                this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230, str, paramMessage, new MainAssistObserver.18.1(this), null);
                this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new MainAssistObserver.18.2(this));
                this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new MainAssistObserver.18.3(this));
                this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
                return;
              }
              catch (Exception paramMessage)
              {
                if (!QLog.isColorLevel()) {
                  return;
                }
              }
              paramMessage.printStackTrace();
            }
          }
          else
          {
            paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
            this.a.a(33, paramMessage);
          }
        }
        else
        {
          paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
          this.a.a(34, paramMessage);
        }
      }
      else
      {
        paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
        this.a.a(35, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.18
 * JD-Core Version:    0.7.0.1
 */