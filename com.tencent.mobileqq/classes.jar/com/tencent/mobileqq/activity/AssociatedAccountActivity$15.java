package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.MessageObserverCallback;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;
import com.tencent.qphone.base.util.QLog;

class AssociatedAccountActivity$15
  implements ISubAccountApi.MessageObserverCallback
{
  AssociatedAccountActivity$15(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (AssociatedAccountActivity.access$1900(this.a, paramString, paramSubAccountBackProtocData)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetSubAccountMsg subAccount=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" mIsFromPull=");
      localStringBuilder.append(this.a.mIsFromPull);
      localStringBuilder.append(" isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("  mPullReqNeedBackNum=");
      localStringBuilder.append(this.a.mPullReqNeedBackNum);
      QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
    }
    if (this.a.mIsFromPull)
    {
      AssociatedAccountActivity.access$2000(this.a, paramBoolean, true);
      return;
    }
    paramString = this.a;
    paramString.mPullReqNeedBackNum = 0;
    paramString.mIsPullReqSuccess = false;
    if ((paramBoolean) && (paramSubAccountBackProtocData.l))
    {
      this.a.loadItemDataList();
      return;
    }
    if (paramBoolean) {
      this.a.updateSubAccountStatus();
    }
  }
  
  public void a(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    if (AssociatedAccountActivity.access$2100(this.a, paramString, paramSubAccountThirdQQBackProtocData)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSubAccountThirdQQUnreadMsgNum mIsFromPull=");
      localStringBuilder.append(this.a.mIsFromPull);
      localStringBuilder.append("  mPullReqNeedBackNum=");
      localStringBuilder.append(this.a.mPullReqNeedBackNum);
      localStringBuilder.append(" isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("  mainAccount=");
      localStringBuilder.append(paramString);
      localStringBuilder.append("  data=");
      localStringBuilder.append(paramSubAccountThirdQQBackProtocData);
      QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
    }
    if (this.a.mIsFromPull)
    {
      AssociatedAccountActivity.access$2000(this.a, paramBoolean, false);
      return;
    }
    paramString = this.a;
    paramString.mPullReqNeedBackNum = 0;
    paramString.mIsPullReqSuccess = false;
    if (paramBoolean) {
      AssociatedAccountActivity.access$2200(paramString, paramSubAccountThirdQQBackProtocData);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSubAccountMsgNumConfirm isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" subUin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" set need2ConfirmMsgNum=");
      localStringBuilder.append(paramBoolean ^ true);
      localStringBuilder.append(" nextAction=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" mNeed2ConfirmMsgNum=");
      localStringBuilder.append(this.a.mNeed2ConfirmMsgNum);
      QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
    }
    if ("sub.account.switchAccount".equals(paramString2))
    {
      paramString1 = this.a;
      paramString1.mNeed2ConfirmMsgNum -= 1;
      if (this.a.mNeed2ConfirmMsgNum <= 0)
      {
        paramString1 = this.a;
        AssociatedAccountActivity.access$1800(paramString1, false, paramString1.mCurrentSwitchUin);
      }
      if (this.a.mNeed2ConfirmMsgNum < 0) {
        this.a.mNeed2ConfirmMsgNum = 0;
      }
    }
  }
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (AssociatedAccountActivity.access$1900(this.a, paramString, paramSubAccountBackProtocData)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramSubAccountBackProtocData = new StringBuilder();
      paramSubAccountBackProtocData.append("onPushSubAccountMsg subUin");
      paramSubAccountBackProtocData.append(paramString);
      QLog.d("AssociatedAccountActivity", 2, paramSubAccountBackProtocData.toString());
    }
    if (paramBoolean) {
      AssociatedAccountActivity.access$1700(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.15
 * JD-Core Version:    0.7.0.1
 */