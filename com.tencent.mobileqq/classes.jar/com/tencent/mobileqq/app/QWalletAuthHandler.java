package com.tencent.mobileqq.app;

import QQWalletPay.ReqCheckChangePwdAuth;
import Wallet.AuthCodeReq;
import Wallet.GetPasswordReq;
import Wallet.GetPasswordRsp;
import Wallet.PfaFriendRqt;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;

public class QWalletAuthHandler
  extends BusinessHandler
{
  private boolean a = false;
  private QQAppInterface b;
  
  protected QWalletAuthHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  public void a(ReqCheckChangePwdAuth paramReqCheckChangePwdAuth)
  {
    if (paramReqCheckChangePwdAuth == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "QQWalletPayAuthServer.checkChangePwdAuth");
    localToServiceMsg.extraData.putSerializable("ReqCheckChangePwdAuth", paramReqCheckChangePwdAuth);
    super.send(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendCheckModifyPassReq: on send--cmd=QQWalletPayAuthServer.checkChangePwdAuth");
    }
  }
  
  public void a(AuthCodeReq paramAuthCodeReq)
  {
    if (paramAuthCodeReq == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "VacThirdCodeSvc.fetchCodes");
    localToServiceMsg.extraData.putSerializable("AuthCodeReq", paramAuthCodeReq);
    super.send(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetAuthCode: on send--cmd=VacThirdCodeSvc.fetchCodes");
    }
  }
  
  public void a(GetPasswordReq paramGetPasswordReq)
  {
    if (paramGetPasswordReq == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "WalletGestureSvc.GetPassword");
    localToServiceMsg.extraData.putSerializable("GetPasswordReq", paramGetPasswordReq);
    super.send(localToServiceMsg);
    this.a = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetPasswordReq: on send--cmd=WalletGestureSvc.GetPassword");
    }
  }
  
  public void a(PfaFriendRqt paramPfaFriendRqt)
  {
    if (paramPfaFriendRqt == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "QWalletPfa.RecFriend");
    localToServiceMsg.extraData.putSerializable("PfaFriendRqt", paramPfaFriendRqt);
    super.send(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetRecentList: on send--cmd=QWalletPfa.RecFriend");
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QWalletAuthObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      boolean bool = paramFromServiceMsg.isSuccess();
      paramToServiceMsg = paramToServiceMsg.getServiceCmd();
      if (TextUtils.isEmpty(paramToServiceMsg)) {
        return;
      }
      if (paramToServiceMsg.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0)
      {
        super.notifyUI(1, bool, paramObject);
        return;
      }
      if (paramToServiceMsg.compareTo("WalletGestureSvc.GetPassword") == 0)
      {
        paramFromServiceMsg = null;
        paramToServiceMsg = paramFromServiceMsg;
        if (paramObject != null)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if ((paramObject instanceof GetPasswordRsp)) {
            paramToServiceMsg = (GetPasswordRsp)paramObject;
          }
        }
        if ((bool) && (paramToServiceMsg != null) && (paramToServiceMsg.ret == 0))
        {
          PatternLockUtils.setSyncPatternLockState(this.b.getApp(), this.b.getCurrentAccountUin(), false);
          if (!TextUtils.isEmpty(paramToServiceMsg.password))
          {
            paramFromServiceMsg = QWalletHelperDelegate.getQWDevId();
            paramObject = new StringBuilder();
            paramObject.append(paramFromServiceMsg);
            paramObject.append(paramToServiceMsg.password);
            paramFromServiceMsg = MD5.toMD5(paramObject.toString());
          }
          else
          {
            paramFromServiceMsg = "";
          }
          PatternLockUtils.setPWD(this.b.getApp(), this.b.getCurrentAccountUin(), paramFromServiceMsg);
          PatternLockUtils.setPWDType(this.b.getApp(), this.b.getCurrentAccountUin(), paramToServiceMsg.passwordType);
          PatternLockUtils.setCheckIntervalTime(this.b.getApp(), this.b.getCurrentAccountUin(), paramToServiceMsg.checkInterval);
          PatternLockUtils.setForgroundIntervalTime(this.b.getApp(), this.b.getCurrentAccountUin(), paramToServiceMsg.passInterval);
        }
        else if ((this.a) && (NetworkUtil.isNetSupport(this.b.getApp())))
        {
          this.a = false;
          paramToServiceMsg = new GetPasswordReq();
          paramToServiceMsg.MQOS = "Android";
          paramToServiceMsg.MQVersion = DeviceInfoUtil.a(this.b.getApp());
          paramFromServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "WalletGestureSvc.GetPassword");
          paramFromServiceMsg.extraData.putSerializable("GetPasswordReq", paramToServiceMsg);
          super.send(paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.auth.AuthHandler", 2, "RetrySendGetPasswordReq: on send--cmd=WalletGestureSvc.GetPassword");
          }
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("sendGetPasswordReq: onReceive isSuccess:");
          paramToServiceMsg.append(bool);
          QLog.d("Q.qwallet.auth.AuthHandler", 2, paramToServiceMsg.toString());
        }
      }
      else
      {
        if (paramToServiceMsg.compareTo("VacThirdCodeSvc.fetchCodes") == 0)
        {
          super.notifyUI(4, bool, paramObject);
          return;
        }
        if (paramToServiceMsg.compareTo("QWalletPfa.RecFriend") == 0) {
          super.notifyUI(5, bool, paramObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QWalletAuthHandler
 * JD-Core Version:    0.7.0.1
 */