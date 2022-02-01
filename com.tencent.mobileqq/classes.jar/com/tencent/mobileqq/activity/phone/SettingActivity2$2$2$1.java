package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

class SettingActivity2$2$2$1
  extends ContactBindObserver
{
  SettingActivity2$2$2$1(SettingActivity2.2.2 param2) {}
  
  protected void onDisableMobileMatch(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDisableMobileMatch suc[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("SettingActivity2", 2, localStringBuilder.toString());
    }
    this.a.a.a.dismissProgressDialog();
    this.a.a.a.app.unRegistObserver(this);
    if (paramBoolean)
    {
      this.a.a.a.a();
      this.a.a.a.setResult(-1);
      return;
    }
    this.a.a.a.showToast(1, HardCodeUtil.a(2131713734));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.2.2.1
 * JD-Core Version:    0.7.0.1
 */