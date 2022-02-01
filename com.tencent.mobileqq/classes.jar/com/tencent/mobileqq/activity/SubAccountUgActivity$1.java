package com.tencent.mobileqq.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

class SubAccountUgActivity$1
  extends SubAccountBindObserver
{
  SubAccountUgActivity$1(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (this.a.subUin != null) && (this.a.subUin.length() >= 5))
    {
      paramSubAccountBackProtocData = paramSubAccountBackProtocData.c();
      if (paramSubAccountBackProtocData != null)
      {
        if (paramSubAccountBackProtocData.contains(this.a.subUin)) {
          return;
        }
        paramSubAccountBackProtocData = (SubAccountControlServiceImpl)this.a.app.getRuntimeService(SubAccountControlServiceImpl.class, null);
        SubAccountUgActivity localSubAccountUgActivity = this.a;
        localSubAccountUgActivity.showUnbindDialog(paramSubAccountBackProtocData, localSubAccountUgActivity.subUin);
      }
    }
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SubAccountUgActivity.onUnBindSubAccount() isSucc=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" currentActivity subUin=");
      ((StringBuilder)localObject).append(this.a.subUin);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
      if (paramSubAccountBackProtocData != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SubAccountUgActivity.onUnBindSubAccount() mainAccount=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.b);
        ((StringBuilder)localObject).append(" subAccount=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.c);
        ((StringBuilder)localObject).append(" errType=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" errMsg=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((paramSubAccountBackProtocData != null) && (this.a.subUin != null))
    {
      if ((this.a.subUin != null) && (!this.a.subUin.equals(paramSubAccountBackProtocData.c))) {
        return;
      }
      this.a.hideJuhua();
      if (this.a.mBindClick)
      {
        paramSubAccountBackProtocData = this.a;
        paramSubAccountBackProtocData.mBindClick = false;
        if (paramBoolean)
        {
          paramSubAccountBackProtocData.bindSwitchUnbind();
          paramSubAccountBackProtocData = this.a;
          paramSubAccountBackProtocData.showQQToastSuccess(paramSubAccountBackProtocData.getString(2131719350));
          return;
        }
        paramSubAccountBackProtocData.showQQToast(paramSubAccountBackProtocData.getString(2131719349));
        return;
      }
      if (paramBoolean)
      {
        paramSubAccountBackProtocData = (SubAccountControlServiceImpl)this.a.app.getRuntimeService(SubAccountControlServiceImpl.class, null);
        localObject = paramSubAccountBackProtocData.addHintPair(this.a.subUin, 1);
        paramSubAccountBackProtocData.showHintDialog(this.a.app, this.a, (Pair)localObject, new SubAccountUgActivity.1.1(this, paramSubAccountBackProtocData, (Pair)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity.1
 * JD-Core Version:    0.7.0.1
 */