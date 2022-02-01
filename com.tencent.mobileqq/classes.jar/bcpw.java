import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.Key;

public class bcpw
  extends abiv
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "StatSvc" };
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public bcpw(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespRegister)a(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SvcReqRegister localSvcReqRegister = new SvcReqRegister();
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
      if ((localStatus == AppRuntime.Status.online) && (azib.a(localSvcReqRegister.uExtOnlineStatus))) {
        localSvcReqRegister.iBatteryStatus = azhq.a(paramToServiceMsg.extraData.getInt("batteryCapacity", 0), paramToServiceMsg.extraData.getInt("powerConnect", -1));
      }
      try
      {
        for (;;)
        {
          localSvcReqRegister.iOSVersion = Integer.parseInt(Build.VERSION.SDK);
          if (!NetConnInfoCenter.isMobileConn()) {
            break label301;
          }
          localSvcReqRegister.cNetType = 0;
          localSvcReqRegister.vecGuid = NetConnInfoCenter.GUID;
          localSvcReqRegister.strDevName = Build.MODEL;
          localSvcReqRegister.strDevType = Build.MODEL;
          localSvcReqRegister.strOSVer = Build.VERSION.RELEASE;
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
          label301:
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
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    return super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("StatSvc.SetStatusFromClient")) {
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