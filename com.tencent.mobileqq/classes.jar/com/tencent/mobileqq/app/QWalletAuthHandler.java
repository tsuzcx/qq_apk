package com.tencent.mobileqq.app;

import QQWalletPay.ReqCheckChangePwdAuth;
import Wallet.AuthCodeReq;
import Wallet.GetPasswordReq;
import Wallet.GetPasswordRsp;
import Wallet.PfaFriendRqt;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;

public class QWalletAuthHandler
  extends BusinessHandler
{
  private boolean a;
  
  protected QWalletAuthHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return QWalletAuthObserver.class;
  }
  
  public void a(ReqCheckChangePwdAuth paramReqCheckChangePwdAuth)
  {
    if (paramReqCheckChangePwdAuth == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "QQWalletPayAuthServer.checkChangePwdAuth");
      localToServiceMsg.extraData.putSerializable("ReqCheckChangePwdAuth", paramReqCheckChangePwdAuth);
      super.a(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendCheckModifyPassReq: on send--cmd=QQWalletPayAuthServer.checkChangePwdAuth");
  }
  
  public void a(AuthCodeReq paramAuthCodeReq)
  {
    if (paramAuthCodeReq == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "VacThirdCodeSvc.fetchCodes");
      localToServiceMsg.extraData.putSerializable("AuthCodeReq", paramAuthCodeReq);
      super.a(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetAuthCode: on send--cmd=VacThirdCodeSvc.fetchCodes");
  }
  
  public void a(GetPasswordReq paramGetPasswordReq)
  {
    if (paramGetPasswordReq == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "WalletGestureSvc.GetPassword");
      localToServiceMsg.extraData.putSerializable("GetPasswordReq", paramGetPasswordReq);
      super.a(localToServiceMsg);
      this.a = true;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetPasswordReq: on send--cmd=WalletGestureSvc.GetPassword");
  }
  
  public void a(PfaFriendRqt paramPfaFriendRqt)
  {
    if (paramPfaFriendRqt == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "QWalletPfa.RecFriend");
      localToServiceMsg.extraData.putSerializable("PfaFriendRqt", paramPfaFriendRqt);
      super.a(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetRecentList: on send--cmd=QWalletPfa.RecFriend");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    boolean bool;
    do
    {
      return;
      bool = paramFromServiceMsg.isSuccess();
      paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    } while (TextUtils.isEmpty(paramToServiceMsg));
    if (paramToServiceMsg.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0)
    {
      super.a(1, bool, paramObject);
      return;
    }
    if (paramToServiceMsg.compareTo("WalletGestureSvc.GetPassword") == 0) {
      if ((paramObject == null) || (!(paramObject instanceof GetPasswordRsp))) {
        break label374;
      }
    }
    label374:
    for (paramToServiceMsg = (GetPasswordRsp)paramObject;; paramToServiceMsg = null)
    {
      if ((bool) && (paramToServiceMsg != null) && (paramToServiceMsg.ret == 0))
      {
        PatternLockUtils.setSyncPatternLockState(this.b.getApp(), this.b.getCurrentAccountUin(), false);
        paramFromServiceMsg = "";
        if (!TextUtils.isEmpty(paramToServiceMsg.password))
        {
          paramFromServiceMsg = Utils.b(this.b.getApp());
          paramFromServiceMsg = MD5.toMD5(paramFromServiceMsg + paramToServiceMsg.password);
        }
        PatternLockUtils.setPWD(this.b.getApp(), this.b.getCurrentAccountUin(), paramFromServiceMsg);
        PatternLockUtils.setCheckIntervalTime(this.b.getApp(), this.b.getCurrentAccountUin(), paramToServiceMsg.checkInterval);
        PatternLockUtils.setForgroundIntervalTime(this.b.getApp(), this.b.getCurrentAccountUin(), paramToServiceMsg.passInterval);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetPasswordReq: onReceive isSuccess:" + bool);
        return;
        if ((this.a) && (NetworkUtil.d(this.b.getApp())))
        {
          this.a = false;
          paramToServiceMsg = new GetPasswordReq();
          paramToServiceMsg.MQOS = "Android";
          paramFromServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "WalletGestureSvc.GetPassword");
          paramFromServiceMsg.extraData.putSerializable("GetPasswordReq", paramToServiceMsg);
          super.a(paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.auth.AuthHandler", 2, "RetrySendGetPasswordReq: on send--cmd=WalletGestureSvc.GetPassword");
          }
        }
      }
      break;
      if (paramToServiceMsg.compareTo("VacThirdCodeSvc.fetchCodes") == 0)
      {
        super.a(4, bool, paramObject);
        return;
      }
      if (paramToServiceMsg.compareTo("QWalletPfa.RecFriend") != 0) {
        break;
      }
      super.a(5, bool, paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QWalletAuthHandler
 * JD-Core Version:    0.7.0.1
 */