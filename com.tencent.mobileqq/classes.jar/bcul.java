import QQWalletPay.ReqCheckChangePwdAuth;
import QQWalletPay.RespCheckChangePwdAuth;
import Wallet.AuthCodeReq;
import Wallet.AuthCodeRsp;
import Wallet.GetPasswordReq;
import Wallet.GetPasswordRsp;
import Wallet.PfaFriendRqt;
import Wallet.PfaFriendRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class bcul
  extends aauq
{
  private static final String[] a = { "QQWalletPayAuthServer", "AdvRuleSvrCmd", "WalletGestureSvc", "VacThirdCodeSvc", "QWalletPfa" };
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (RespCheckChangePwdAuth)paramToServiceMsg.getByClass("resp", new RespCheckChangePwdAuth());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeModifyPassAuthWUP error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeModifyPassAuthWUP error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.OpenPayServer.QQWalletPayAuthObj");
    paramUniPacket.setFuncName("checkChangePwdAuth");
    paramUniPacket.put("req", (ReqCheckChangePwdAuth)paramToServiceMsg.extraData.getSerializable("ReqCheckChangePwdAuth"));
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (GetPasswordRsp)paramToServiceMsg.getByClass("rsp", new GetPasswordRsp());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetPasswordWUP error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetPasswordWUP error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("Wallet.GesturePasswordServer.GesturePasswordObj");
    paramUniPacket.setFuncName("GetPassword");
    paramUniPacket.put("req", (GetPasswordReq)paramToServiceMsg.extraData.getSerializable("GetPasswordReq"));
    return true;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (AuthCodeRsp)paramToServiceMsg.getByClass("rsp", new AuthCodeRsp());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetAuthCode error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetAuthCode error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("VAC.AuthCodeCoroServer.AuthCodeCoroObj");
    paramUniPacket.setFuncName("fetchCodes");
    paramUniPacket.put("req", (AuthCodeReq)paramToServiceMsg.extraData.getSerializable("AuthCodeReq"));
    return true;
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (PfaFriendRsp)paramToServiceMsg.getByClass("rsp", new PfaFriendRsp());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetRecentList error:" + paramToServiceMsg.getMessage());
      }
      return null;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qwallet.auth.AuthService", 4, "decodeGetRecentList error:" + paramToServiceMsg.getMessage());
      }
    }
    return null;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("Wallet.WalletFriendQueryServer.WalletFriendObj");
    paramUniPacket.setFuncName("QueryRecommendFriend");
    paramUniPacket.put("rqt", (PfaFriendRqt)paramToServiceMsg.extraData.getSerializable("PfaFriendRqt"));
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return null;
      if (str.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0) {
        return b(paramToServiceMsg, paramFromServiceMsg);
      }
      if (str.compareTo("WalletGestureSvc.GetPassword") == 0) {
        return c(paramToServiceMsg, paramFromServiceMsg);
      }
      if (str.compareTo("VacThirdCodeSvc.fetchCodes") == 0) {
        return d(paramToServiceMsg, paramFromServiceMsg);
      }
    } while (str.compareTo("QWalletPfa.RecFriend") != 0);
    return e(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return false;
      if (str.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0) {
        return b(paramToServiceMsg, paramUniPacket);
      }
      if (str.compareTo("WalletGestureSvc.GetPassword") == 0) {
        return c(paramToServiceMsg, paramUniPacket);
      }
      if (str.compareTo("VacThirdCodeSvc.fetchCodes") == 0) {
        return d(paramToServiceMsg, paramUniPacket);
      }
    } while (str.compareTo("QWalletPfa.RecFriend") != 0);
    return e(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcul
 * JD-Core Version:    0.7.0.1
 */