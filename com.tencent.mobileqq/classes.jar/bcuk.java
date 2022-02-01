import MessageSvcPack.RequestPushStatus;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.msf.service.protocol.push.SvcReqSetToken;
import com.tencent.msf.service.protocol.push.SvcRespSetToken;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class bcuk
  extends aauq
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "Push", "PushService" };
  private aqtc jdField_a_of_type_Aqtc;
  
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
        QLog.d("PushService", 2, "HPush_requestSetPushToken-encodeRequestMsg-handleReqSetPushToken:");
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
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg.getWupBuffer() == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PushNotify")) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(aqtc paramaqtc)
  {
    this.jdField_a_of_type_Aqtc = paramaqtc;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str.equals("MessageSvc.RequestPushStatus"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatusPush", 2, "decodeRespMsg MessageSvc.RequestPushStatus uin:" + paramFromServiceMsg.getUin() + " at " + System.currentTimeMillis());
      }
      paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (paramToServiceMsg != null) {}
    }
    do
    {
      do
      {
        return;
        paramFromServiceMsg = new UniPacket();
        paramFromServiceMsg.decode(paramToServiceMsg);
        paramToServiceMsg = (RequestPushStatus)paramFromServiceMsg.getByClass("req_PushStatus", new RequestPushStatus());
        paramFromServiceMsg = BaseApplication.getContext().getSharedPreferences("share", 0);
        if (paramToServiceMsg.cStatus == 1)
        {
          paramFromServiceMsg.edit().putBoolean("is_pc_online" + paramToServiceMsg.lUin, true).commit();
          return;
        }
        paramFromServiceMsg.edit().putBoolean("is_pc_online" + paramToServiceMsg.lUin, false).commit();
        return;
        if (!"CliNotifySvc.register".equals(str)) {
          break;
        }
      } while ((!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.extraData.getLong("pushId") != 128L));
      return;
      if ("baseSdk.Msf.NotifyResp".equals(str))
      {
        paramToServiceMsg = new Intent("tencent.notify.album");
        paramToServiceMsg.putExtra("resp", paramFromServiceMsg);
        BaseApplication.getContext().sendBroadcast(paramToServiceMsg, "com.tencent.msg.permission.pushnotify");
        return;
      }
      if ("PushService.SetToken".equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      paramToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    } while (this.jdField_a_of_type_Aqtc == null);
    this.jdField_a_of_type_Aqtc.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("PushService.SetToken")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcuk
 * JD-Core Version:    0.7.0.1
 */