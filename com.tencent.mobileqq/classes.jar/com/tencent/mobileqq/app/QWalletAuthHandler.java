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
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;

public class QWalletAuthHandler
  extends BusinessHandler
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  
  protected QWalletAuthHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(ReqCheckChangePwdAuth paramReqCheckChangePwdAuth)
  {
    if (paramReqCheckChangePwdAuth == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QQWalletPayAuthServer.checkChangePwdAuth");
      localToServiceMsg.extraData.putSerializable("ReqCheckChangePwdAuth", paramReqCheckChangePwdAuth);
      super.send(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendCheckModifyPassReq: on send--cmd=QQWalletPayAuthServer.checkChangePwdAuth");
  }
  
  public void a(AuthCodeReq paramAuthCodeReq)
  {
    if (paramAuthCodeReq == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "VacThirdCodeSvc.fetchCodes");
      localToServiceMsg.extraData.putSerializable("AuthCodeReq", paramAuthCodeReq);
      super.send(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetAuthCode: on send--cmd=VacThirdCodeSvc.fetchCodes");
  }
  
  public void a(GetPasswordReq paramGetPasswordReq)
  {
    if (paramGetPasswordReq == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "WalletGestureSvc.GetPassword");
      localToServiceMsg.extraData.putSerializable("GetPasswordReq", paramGetPasswordReq);
      super.send(localToServiceMsg);
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetPasswordReq: on send--cmd=WalletGestureSvc.GetPassword");
  }
  
  public void a(PfaFriendRqt paramPfaFriendRqt)
  {
    if (paramPfaFriendRqt == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "QWalletPfa.RecFriend");
      localToServiceMsg.extraData.putSerializable("PfaFriendRqt", paramPfaFriendRqt);
      super.send(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetRecentList: on send--cmd=QWalletPfa.RecFriend");
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QWalletAuthObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      super.notifyUI(1, bool, paramObject);
      return;
    }
    if (paramToServiceMsg.compareTo("WalletGestureSvc.GetPassword") == 0) {
      if ((paramObject == null) || (!(paramObject instanceof GetPasswordRsp))) {
        break label402;
      }
    }
    label402:
    for (paramToServiceMsg = (GetPasswordRsp)paramObject;; paramToServiceMsg = null)
    {
      if ((bool) && (paramToServiceMsg != null) && (paramToServiceMsg.ret == 0))
      {
        PatternLockUtils.setSyncPatternLockState(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
        paramFromServiceMsg = "";
        if (!TextUtils.isEmpty(paramToServiceMsg.password))
        {
          paramFromServiceMsg = QWalletHelperImpl.getQWDevId();
          paramFromServiceMsg = MD5.toMD5(paramFromServiceMsg + paramToServiceMsg.password);
        }
        PatternLockUtils.setPWD(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFromServiceMsg);
        PatternLockUtils.setPWDType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramToServiceMsg.passwordType);
        PatternLockUtils.setCheckIntervalTime(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramToServiceMsg.checkInterval);
        PatternLockUtils.setForgroundIntervalTime(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramToServiceMsg.passInterval);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetPasswordReq: onReceive isSuccess:" + bool);
        return;
        if ((this.jdField_a_of_type_Boolean) && (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())))
        {
          this.jdField_a_of_type_Boolean = false;
          paramToServiceMsg = new GetPasswordReq();
          paramToServiceMsg.MQOS = "Android";
          paramToServiceMsg.MQVersion = DeviceInfoUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
          paramFromServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "WalletGestureSvc.GetPassword");
          paramFromServiceMsg.extraData.putSerializable("GetPasswordReq", paramToServiceMsg);
          super.send(paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.auth.AuthHandler", 2, "RetrySendGetPasswordReq: on send--cmd=WalletGestureSvc.GetPassword");
          }
        }
      }
      break;
      if (paramToServiceMsg.compareTo("VacThirdCodeSvc.fetchCodes") == 0)
      {
        super.notifyUI(4, bool, paramObject);
        return;
      }
      if (paramToServiceMsg.compareTo("QWalletPfa.RecFriend") != 0) {
        break;
      }
      super.notifyUI(5, bool, paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QWalletAuthHandler
 * JD-Core Version:    0.7.0.1
 */