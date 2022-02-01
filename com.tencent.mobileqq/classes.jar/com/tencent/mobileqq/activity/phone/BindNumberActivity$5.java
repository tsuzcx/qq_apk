package com.tencent.mobileqq.activity.phone;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class BindNumberActivity$5
  extends ContactBindObserver
{
  BindNumberActivity$5(BindNumberActivity paramBindNumberActivity) {}
  
  public void onBindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.f = false;
    this.a.a();
    this.a.b();
    int i;
    if (paramBoolean)
    {
      String str = ContactUtils.b();
      if (!TextUtils.isEmpty(str)) {
        ReportController.b(this.a.app, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      i = paramBundle.getInt("k_result");
      if (paramBundle.getBoolean("k_buto_bind", false)) {
        this.a.c();
      }
    }
    for (;;)
    {
      ContactUtils.a();
      this.a.app.unRegistObserver(this.a.a);
      this.a.a = null;
      return;
      if ((i == 104) || (i == 0))
      {
        this.a.b();
      }
      else
      {
        if (i == 107)
        {
          this.a.a(paramBundle);
          return;
        }
        if (i == 106)
        {
          this.a.a(null, 2);
        }
        else if (i == 227)
        {
          this.a.d();
        }
        else if (i == 226)
        {
          this.a.e();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("BindNumberActivity", 2, "bind error " + i);
          }
          this.a.a(getBindErrorMessage(i));
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("BindNumberActivity", 2, "onBindMobile failed");
          }
          this.a.a(2131718550);
        }
      }
    }
  }
  
  public void onRebindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.b();
    if (paramBoolean) {
      this.a.b();
    }
    for (;;)
    {
      this.a.app.unRegistObserver(this.a.a);
      this.a.a = null;
      return;
      this.a.a(2131718550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity.5
 * JD-Core Version:    0.7.0.1
 */