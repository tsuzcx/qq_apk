package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class PhoneUnityBindInfoActivity$11
  extends ContactBindObserver
{
  PhoneUnityBindInfoActivity$11(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  protected void onBindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    PhoneUnityBindInfoActivity.access$2000(this.a);
    if (paramBoolean)
    {
      int i = paramBundle.getInt("k_result");
      if ((i != 104) && (i != 0))
      {
        if (i == 107)
        {
          paramBundle = this.a.mPhoneUnityInfoBundle.getString("country_code");
          byte[] arrayOfByte = this.a.getPhoneVasKey(3);
          if (arrayOfByte != null)
          {
            PhoneUnityBindInfoActivity.access$2100(this.a).sendRebindMobileEncrypt(paramBundle, arrayOfByte, 0, true, false);
            PhoneUnityBindInfoActivity.access$2200(this.a, 2131718766, 1000L, true);
          }
          else if (QLog.isColorLevel())
          {
            QLog.e("PhoneUnityBindInfoActivity", 2, "sendBindMobileEncrypt contact vaskey is null.");
          }
          ReportController.b(this.a.app, "dc00898", "", "", "0X800B31D", "0X800B31D", 0, 0, "2", "", "", "");
          return;
        }
        if (i == 106)
        {
          this.a.onBindSuc();
          ReportController.b(this.a.app, "dc00898", "", "", "0X800B31D", "0X800B31D", 0, 0, "1", "", "", "");
        }
        else if (i == 227)
        {
          this.a.onMobileBindUinNotSetPasswordError();
          this.a.resetContactSwitch(false);
        }
        else if (i == 226)
        {
          this.a.onUinNotSetPasswordError();
          this.a.resetContactSwitch(false);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("bind error ");
            paramBundle.append(i);
            QLog.d("PhoneUnityBindInfoActivity", 2, paramBundle.toString());
          }
          PhoneUnityBindInfoActivity.access$2300(this.a, getBindErrorMessage(i));
          this.a.resetContactSwitch(false);
        }
      }
      else
      {
        this.a.gotoBindVerify();
        this.a.resetContactSwitch(false);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneUnityBindInfoActivity", 2, "onBindMobile failed");
      }
      PhoneUnityBindInfoActivity.access$2400(this.a, 2131718218);
      this.a.resetContactSwitch(false);
    }
    this.a.app.unRegistObserver(this.a.bindObserver);
    this.a.bindObserver = null;
  }
  
  protected void onRebindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    PhoneUnityBindInfoActivity.access$2500(this.a);
    if (paramBoolean)
    {
      this.a.gotoBindVerify();
    }
    else
    {
      PhoneUnityBindInfoActivity.access$2600(this.a, 2131718218);
      this.a.resetContactSwitch(false);
    }
    this.a.app.unRegistObserver(this.a.bindObserver);
    this.a.bindObserver = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.11
 * JD-Core Version:    0.7.0.1
 */