package com.tencent.mobileqq.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.MessageObserverCallback;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;
import com.tencent.qphone.base.util.QLog;

class SubAccountUgActivity$4
  implements ISubAccountApi.MessageObserverCallback
{
  SubAccountUgActivity$4(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPushSubAccountMsg() isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("  subAccount=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
      if (paramSubAccountBackProtocData != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPushSubAccountMsg() data.errorType=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.a);
        ((StringBuilder)localObject).append("  errorMsg=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.b);
        ((StringBuilder)localObject).append(" mainAccount=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.c);
        ((StringBuilder)localObject).append("  subAccount=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.d);
        ((StringBuilder)localObject).append(" isNeedStartGetMsg=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.k);
        QLog.i("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((paramSubAccountBackProtocData != null) && (paramString != null))
    {
      if (paramString.length() < 5) {
        return;
      }
      if (this.a.isFinishing()) {
        return;
      }
      localObject = (SubAccountControlServiceImpl)this.a.app.getRuntimeService(SubAccountControlServiceImpl.class, null);
      if (paramSubAccountBackProtocData.a == 1)
      {
        if ((this.a.subUin != null) && (this.a.subUin.equals(paramString))) {
          this.a.showUnbindDialog((ISubAccountControlService)localObject, paramString);
        }
      }
      else if ((this.a.subUin != null) && (this.a.subUin.equals(paramString))) {
        ((SubAccountControlServiceImpl)localObject).cancelHintDialog(this.a.subUin, 1, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity.4
 * JD-Core Version:    0.7.0.1
 */