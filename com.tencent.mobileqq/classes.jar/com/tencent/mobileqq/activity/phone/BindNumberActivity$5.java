package com.tencent.mobileqq.activity.phone;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class BindNumberActivity$5
  extends ContactBindObserver
{
  BindNumberActivity$5(BindNumberActivity paramBindNumberActivity) {}
  
  protected void onBindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = this.a;
    ((BindNumberActivity)localObject).q = false;
    ((BindNumberActivity)localObject).a();
    this.a.dismissProgressDialog();
    if (paramBoolean)
    {
      localObject = ContactUtils.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ReportController.b(this.a.app, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
      int i = paramBundle.getInt("k_result");
      if (paramBundle.getBoolean("k_buto_bind", false))
      {
        this.a.d();
      }
      else if ((i != 104) && (i != 0))
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
          this.a.e();
        }
        else if (i == 226)
        {
          this.a.f();
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("bind error ");
            paramBundle.append(i);
            QLog.d("BindNumberActivity", 2, paramBundle.toString());
          }
          this.a.showToast(getBindErrorMessage(i));
        }
      }
      else
      {
        this.a.c();
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("BindNumberActivity", 2, "onBindMobile failed");
      }
      this.a.showToast(2131915700);
    }
    ContactUtils.b();
    this.a.app.unRegistObserver(this.a.f);
    this.a.f = null;
  }
  
  protected void onRebindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.dismissProgressDialog();
    if (paramBoolean) {
      this.a.c();
    } else {
      this.a.showToast(2131915700);
    }
    this.a.app.unRegistObserver(this.a.f);
    this.a.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity.5
 * JD-Core Version:    0.7.0.1
 */