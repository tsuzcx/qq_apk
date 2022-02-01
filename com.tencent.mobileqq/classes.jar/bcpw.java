import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.SvcReqSetToken;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.msf.service.protocol.push.SvcRespSetToken;
import com.tencent.msf.service.protocol.push.VendorPushInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.Key;

public class bcpw
  extends aauq
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "StatSvc" };
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public bcpw(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespSetToken)a(paramFromServiceMsg.getWupBuffer(), "SvcRespSetToken", new SvcRespSetToken());
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SvcReqSetToken localSvcReqSetToken = new SvcReqSetToken();
    paramToServiceMsg = paramToServiceMsg.extraData.getString("push_token");
    try
    {
      localSvcReqSetToken.vNewToken = paramToServiceMsg.getBytes("utf-8");
      localSvcReqSetToken.bEnterVersion = 37;
      localSvcReqSetToken.bPushMsg = 1;
      paramUniPacket.put("SvcReqSetToken", localSvcReqSetToken);
      paramUniPacket.setServantName("PushService");
      paramUniPacket.setFuncName("SvcReqSetToken");
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusService", 2, "HPush_requestSetPushToken-encodeRequestMsg-handleReqSetPushToken:");
      }
      return true;
    }
    catch (UnsupportedEncodingException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespRegister)a(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SvcReqRegister localSvcReqRegister = new SvcReqRegister();
    VendorPushInfo localVendorPushInfo = new VendorPushInfo();
    localSvcReqRegister.cConnType = 0;
    localSvcReqRegister.lBid = 7L;
    localSvcReqRegister.lUin = Long.parseLong(paramToServiceMsg.getUin());
    AppRuntime.Status localStatus = (AppRuntime.Status)paramToServiceMsg.extraData.getSerializable("onlineStatus");
    localSvcReqRegister.iStatus = localStatus.getValue();
    localSvcReqRegister.bKikPC = 0;
    localSvcReqRegister.bKikWeak = 0;
    localSvcReqRegister.timeStamp = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
    localSvcReqRegister.iLargeSeq = paramToServiceMsg.extraData.getLong("K_SEQ", 0L);
    localSvcReqRegister.bRegType = 0;
    byte b;
    if (paramToServiceMsg.extraData.getBoolean("isAutoSet", false)) {
      b = 2;
    }
    for (;;)
    {
      localSvcReqRegister.bIsSetStatus = b;
      localSvcReqRegister.uExtOnlineStatus = paramToServiceMsg.extraData.getLong("extOnlineStatus", -1L);
      int i = paramToServiceMsg.extraData.getInt("vendor_push_type", 1);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusService", 2, "OnlineStatusService-handleReqSetOnlineStatus.vendor_push_type:" + i);
      }
      localVendorPushInfo.uVendorType = i;
      if ((localStatus == AppRuntime.Status.online) && (azbu.a(localSvcReqRegister.uExtOnlineStatus))) {
        localSvcReqRegister.iBatteryStatus = azbj.a(paramToServiceMsg.extraData.getInt("batteryCapacity", 0), paramToServiceMsg.extraData.getInt("powerConnect", -1));
      }
      try
      {
        for (;;)
        {
          localSvcReqRegister.iOSVersion = Integer.parseInt(Build.VERSION.SDK);
          if (!NetConnInfoCenter.isMobileConn()) {
            break label371;
          }
          localSvcReqRegister.cNetType = 0;
          localSvcReqRegister.vecGuid = NetConnInfoCenter.GUID;
          localSvcReqRegister.strDevName = Build.MODEL;
          localSvcReqRegister.strDevType = Build.MODEL;
          localSvcReqRegister.strOSVer = Build.VERSION.RELEASE;
          localSvcReqRegister.stVendorPushInfo = localVendorPushInfo;
          paramUniPacket.put("SvcReqRegister", localSvcReqRegister);
          paramUniPacket.setServantName("PushService");
          paramUniPacket.setFuncName("SvcReqRegister");
          return true;
          b = 1;
          break;
          localSvcReqRegister.iBatteryStatus = 0;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          paramToServiceMsg.printStackTrace();
          continue;
          label371:
          if (NetConnInfoCenter.isWifiConn()) {
            localSvcReqRegister.cNetType = 1;
          }
        }
      }
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("StatSvc.SetStatusFromClient".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("PushService.SetToken")) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    return super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("StatSvc.SetStatusFromClient")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("PushService.SetToken")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    return true;
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpw
 * JD-Core Version:    0.7.0.1
 */