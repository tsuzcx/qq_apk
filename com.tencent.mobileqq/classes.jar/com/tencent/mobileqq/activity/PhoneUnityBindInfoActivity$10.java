package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class PhoneUnityBindInfoActivity$10
  extends ContactBindObserver
{
  PhoneUnityBindInfoActivity$10(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onBindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    PhoneUnityBindInfoActivity.d(this.a);
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_result");
      if ((i == 104) || (i == 0))
      {
        this.a.i();
        this.a.a(false);
      }
    }
    for (;;)
    {
      this.a.app.unRegistObserver(this.a.b);
      this.a.b = null;
      return;
      if (i == 107)
      {
        paramBundle = this.a.a.getString("country_code");
        byte[] arrayOfByte = this.a.a(3);
        if (arrayOfByte != null)
        {
          PhoneUnityBindInfoActivity.a(this.a).b(paramBundle, arrayOfByte, 0, true, false);
          PhoneUnityBindInfoActivity.b(this.a, 2131719050, 1000L, true);
        }
        for (;;)
        {
          ReportController.b(this.a.app, "dc00898", "", "", "0X800B31D", "0X800B31D", 0, 0, "2", "", "", "");
          return;
          if (QLog.isColorLevel()) {
            QLog.e("PhoneUnityBindInfoActivity", 2, "sendBindMobileEncrypt contact vaskey is null.");
          }
        }
      }
      if (i == 106)
      {
        this.a.a();
        ReportController.b(this.a.app, "dc00898", "", "", "0X800B31D", "0X800B31D", 0, 0, "1", "", "", "");
      }
      else if (i == 227)
      {
        this.a.j();
        this.a.a(false);
      }
      else if (i == 226)
      {
        this.a.k();
        this.a.a(false);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneUnityBindInfoActivity", 2, "bind error " + i);
        }
        PhoneUnityBindInfoActivity.b(this.a, getBindErrorMessage(i));
        this.a.a(false);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PhoneUnityBindInfoActivity", 2, "onBindMobile failed");
        }
        PhoneUnityBindInfoActivity.c(this.a, 2131718550);
        this.a.a(false);
      }
    }
  }
  
  public void onRebindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    PhoneUnityBindInfoActivity.e(this.a);
    if (paramBoolean) {
      this.a.i();
    }
    for (;;)
    {
      this.a.app.unRegistObserver(this.a.b);
      this.a.b = null;
      return;
      PhoneUnityBindInfoActivity.d(this.a, 2131718550);
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.10
 * JD-Core Version:    0.7.0.1
 */