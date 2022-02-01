package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class RiskHintDlgFragment$8
  extends WtloginObserver
{
  RiskHintDlgFragment$8(RiskHintDlgFragment paramRiskHintDlgFragment) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if ((this.a.getQBaseActivity() != null) && (!this.a.getQBaseActivity().isFinishing()))
    {
      if ((paramInt == 0) && (paramDevlockInfo != null))
      {
        if (QLog.isColorLevel())
        {
          paramWUserSigInfo = new StringBuilder();
          paramWUserSigInfo.append("OnCheckDevLockStatus ret = ");
          paramWUserSigInfo.append(paramInt);
          QLog.d("RiskHintDlgFragment", 2, paramWUserSigInfo.toString());
          paramWUserSigInfo = new StringBuilder();
          paramWUserSigInfo.append("DevlockInfo devSetup:");
          paramWUserSigInfo.append(paramDevlockInfo.DevSetup);
          paramWUserSigInfo.append(" countryCode:");
          paramWUserSigInfo.append(paramDevlockInfo.CountryCode);
          paramWUserSigInfo.append(" mobile:");
          paramWUserSigInfo.append(paramDevlockInfo.Mobile);
          paramWUserSigInfo.append(" MbItemSmsCodeStatus:");
          paramWUserSigInfo.append(paramDevlockInfo.MbItemSmsCodeStatus);
          paramWUserSigInfo.append(" TimeLimit:");
          paramWUserSigInfo.append(paramDevlockInfo.TimeLimit);
          paramWUserSigInfo.append(" AvailableMsgCount:");
          paramWUserSigInfo.append(paramDevlockInfo.AvailableMsgCount);
          paramWUserSigInfo.append(" AllowSet:");
          paramWUserSigInfo.append(paramDevlockInfo.AllowSet);
          QLog.d("RiskHintDlgFragment", 2, paramWUserSigInfo.toString());
          paramWUserSigInfo = new StringBuilder();
          paramWUserSigInfo.append("DevlockInfo.ProtectIntro:");
          paramWUserSigInfo.append(paramDevlockInfo.ProtectIntro);
          paramWUserSigInfo.append("  info.MbGuideType:");
          paramWUserSigInfo.append(paramDevlockInfo.MbGuideType);
          QLog.d("RiskHintDlgFragment", 2, paramWUserSigInfo.toString());
          paramWUserSigInfo = new StringBuilder();
          paramWUserSigInfo.append("DevlockInfo.MbGuideMsg:");
          paramWUserSigInfo.append(paramDevlockInfo.MbGuideMsg);
          QLog.d("RiskHintDlgFragment", 2, paramWUserSigInfo.toString());
          paramWUserSigInfo = new StringBuilder();
          paramWUserSigInfo.append("DevlockInfo.MbGuideInfoType:");
          paramWUserSigInfo.append(paramDevlockInfo.MbGuideInfoType);
          QLog.d("RiskHintDlgFragment", 2, paramWUserSigInfo.toString());
          paramWUserSigInfo = new StringBuilder();
          paramWUserSigInfo.append("DevlockInfo.MbGuideInfo:");
          paramWUserSigInfo.append(paramDevlockInfo.MbGuideInfo);
          QLog.d("RiskHintDlgFragment", 2, paramWUserSigInfo.toString());
        }
        DevlockPhoneStatus.a().a(paramDevlockInfo.TransferInfo);
        this.a.a = paramDevlockInfo;
        return;
      }
      if (QLog.isColorLevel())
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnCheckDevLockStatus ret = ");
        paramWUserSigInfo.append(paramInt);
        QLog.d("RiskHintDlgFragment", 2, paramWUserSigInfo.toString());
        if (paramErrMsg != null)
        {
          paramWUserSigInfo = new StringBuilder();
          paramWUserSigInfo.append("OnCheckDevLockStatus errMsg:");
          paramWUserSigInfo.append(paramErrMsg.getMessage());
          QLog.d("RiskHintDlgFragment", 2, paramWUserSigInfo.toString());
        }
        if (paramDevlockInfo == null) {
          QLog.d("RiskHintDlgFragment", 2, "OnCheckDevLockStatus DevlockInfo is null");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskHintDlgFragment.8
 * JD-Core Version:    0.7.0.1
 */