package com.tencent.biz.qrcode.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class QRLoginAuthActivity$4
  extends Handler
{
  QRLoginAuthActivity$4(QRLoginAuthActivity paramQRLoginAuthActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.a((Bundle)localObject);
      return;
    case 2: 
      int i = ((Bundle)localObject).getInt("ret", 1);
      paramMessage = ((Bundle)localObject).getByteArray("errMsg");
      localObject = ((Bundle)localObject).getByteArray("devInfo");
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          localObject = new JSONObject(new String((byte[])localObject, "UTF-8"));
          this.a.b = ((JSONObject)localObject).optInt("app_type");
          this.a.i = ((JSONObject)localObject).optString("login_tips");
          this.a.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("sub_appid");
          if (QLog.isColorLevel()) {
            QLog.d("QRLoginAuthActivity", 2, "ON CLOSE appType:" + this.a.b + ",bannerTips:" + this.a.i + ",subappid:" + this.a.jdField_a_of_type_Long);
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
          if (i != 0) {
            break;
          }
          this.a.c();
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QRLoginAuthActivity", 4, "ON CLOSE devInfo == null");
        }
      }
      this.a.a(new String(paramMessage));
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginAuthActivity.4
 * JD-Core Version:    0.7.0.1
 */