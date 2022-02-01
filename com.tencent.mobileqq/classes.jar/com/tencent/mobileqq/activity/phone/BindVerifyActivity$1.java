package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class BindVerifyActivity$1
  extends ContactBindObserver
{
  BindVerifyActivity$1(BindVerifyActivity paramBindVerifyActivity) {}
  
  protected void onBindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindMobile [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("]");
      QLog.i("BindVerifyActivity", 2, localStringBuilder.toString());
    }
    this.a.dismissProgressDialog();
    if (paramBoolean)
    {
      int i = paramBundle.getInt("k_result");
      if ((i != 104) && (i != 0))
      {
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
          this.a.showToast(1, getBindErrorMessage(i));
        }
      }
      else {
        this.a.b();
      }
    }
    else
    {
      paramBundle = this.a;
      paramBundle.showToast(1, paramBundle.getString(2131718218));
    }
    this.a.app.unRegistObserver(BindVerifyActivity.a(this.a));
    BindVerifyActivity.a(this.a, null);
  }
  
  protected void onRebindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRebindMobile [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("]");
      QLog.d("BindVerifyActivity", 2, localStringBuilder.toString());
    }
    this.a.dismissProgressDialog();
    if (paramBoolean)
    {
      this.a.b();
    }
    else
    {
      paramBundle = this.a;
      paramBundle.showToast(1, paramBundle.getString(2131718218));
    }
    this.a.app.unRegistObserver(BindVerifyActivity.a(this.a));
    BindVerifyActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity.1
 * JD-Core Version:    0.7.0.1
 */