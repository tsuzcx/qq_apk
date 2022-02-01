package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class BindVerifyActivity$1
  extends ContactBindObserver
{
  BindVerifyActivity$1(BindVerifyActivity paramBindVerifyActivity) {}
  
  public void onBindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "onBindMobile [" + paramBoolean + ", " + paramBundle + "]");
    }
    this.a.b();
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_result");
      if ((i == 104) || (i == 0)) {
        this.a.b();
      }
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindVerifyActivity.a(this.a));
      BindVerifyActivity.a(this.a, null);
      return;
      if (i == 107)
      {
        this.a.a(paramBundle);
      }
      else if (i == 106)
      {
        this.a.a();
        if (this.a.getIntent().getBooleanExtra("k_is_block", false)) {
          ReportController.b(this.a.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 2, 0, "", "", "", "");
        }
      }
      else
      {
        this.a.a(1, getBindErrorMessage(i));
        continue;
        this.a.a(1, this.a.getString(2131718550));
      }
    }
  }
  
  public void onRebindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindVerifyActivity", 2, "onRebindMobile [" + paramBoolean + ", " + paramBundle + "]");
    }
    this.a.b();
    if (paramBoolean) {
      this.a.b();
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindVerifyActivity.a(this.a));
      BindVerifyActivity.a(this.a, null);
      return;
      this.a.a(1, this.a.getString(2131718550));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity.1
 * JD-Core Version:    0.7.0.1
 */