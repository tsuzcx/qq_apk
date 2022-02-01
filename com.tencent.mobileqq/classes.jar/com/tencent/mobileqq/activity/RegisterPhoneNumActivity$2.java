package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.security.RegisterOverseaHelper;
import com.tencent.mobileqq.register.QueryAccount;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

class RegisterPhoneNumActivity$2
  extends MqqHandler
{
  RegisterPhoneNumActivity$2(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 103)
    {
      if (i != 104)
      {
        if (i != 111) {
          return;
        }
        QLog.d("RegisterPhoneNumActivity", 1, "ACT_OVERSEA_CAPTCHA handleMessage");
        paramMessage = (Bundle)paramMessage.obj;
        paramMessage = RegisterOverseaHelper.a().a(paramMessage);
        if ((paramMessage != null) && (!TextUtils.isEmpty(this.a.mCountryEnglishName))) {
          paramMessage.put("country_english_name", this.a.mCountryEnglishName.getBytes());
        }
        ReportController.a(null, "dc00898", "", "", "0X800B8B2", "0X800B8B2", 0, 0, "", "", "", "");
        RegisterPhoneNumActivity.access$000(this.a).a(null, paramMessage);
        return;
      }
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        RegisterPhoneNumActivity.access$000(this.a).a(paramMessage);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RegisterPhoneNumActivity", 2, "captcha sig is empty");
      }
    }
    else
    {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity.2
 * JD-Core Version:    0.7.0.1
 */