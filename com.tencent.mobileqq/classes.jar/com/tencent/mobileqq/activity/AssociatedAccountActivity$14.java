package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class AssociatedAccountActivity$14
  extends SubAccountBindObserver
{
  AssociatedAccountActivity$14(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetBindSubAccount() isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramSubAccountBackProtocData != null)
    {
      if (!TextUtils.equals(paramSubAccountBackProtocData.c, this.a.app.getCurrentUin())) {
        return;
      }
      if (paramBoolean)
      {
        paramSubAccountBackProtocData = paramSubAccountBackProtocData.f();
        if ((paramSubAccountBackProtocData != null) && (this.a.mSubAccountList != null))
        {
          localObject = this.a.mSubAccountList.iterator();
          while (((Iterator)localObject).hasNext()) {
            if (!paramSubAccountBackProtocData.contains(((SubAccountInfo)((Iterator)localObject).next()).subuin))
            {
              i = 1;
              break label138;
            }
          }
          int i = 0;
          label138:
          if (paramSubAccountBackProtocData.size() != this.a.mSubAccountList.size()) {
            i = 1;
          }
          if (i != 0) {
            AssociatedAccountActivity.access$1700(this.a, false);
          }
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindSubAccount() isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
      if (paramSubAccountBackProtocData != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBindSubAccount() mainAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.c);
        localStringBuilder.append(" subAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.d);
        localStringBuilder.append(" errType=");
        localStringBuilder.append(paramSubAccountBackProtocData.a);
        localStringBuilder.append(" errMsg=");
        localStringBuilder.append(paramSubAccountBackProtocData.b);
        QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
      }
    }
    if (paramSubAccountBackProtocData != null)
    {
      if (!TextUtils.equals(paramSubAccountBackProtocData.c, this.a.app.getCurrentUin())) {
        return;
      }
      if (paramBoolean) {
        AssociatedAccountActivity.access$1700(this.a, false);
      }
    }
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUnBindSubAccount() isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
      if (paramSubAccountBackProtocData != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUnBindSubAccount() mainAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.c);
        localStringBuilder.append(" subAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.d);
        localStringBuilder.append(" errType=");
        localStringBuilder.append(paramSubAccountBackProtocData.a);
        localStringBuilder.append(" errMsg=");
        localStringBuilder.append(paramSubAccountBackProtocData.b);
        QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
      }
    }
    if (paramSubAccountBackProtocData != null)
    {
      if (!TextUtils.equals(paramSubAccountBackProtocData.c, this.a.app.getCurrentUin())) {
        return;
      }
      if (paramBoolean) {
        AssociatedAccountActivity.access$1700(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.14
 * JD-Core Version:    0.7.0.1
 */