import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.servlet.LoginVerifyServlet.3;
import com.tencent.mobileqq.troop.org.pb.oidb_0x587.ReqBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x5e1.ReqBody;
import tencent.im.oidb.oidb_0x87a.ReqBody;
import tencent.im.oidb.oidb_0x87c.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class awcq
  extends MSFServlet
{
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, BusinessObserver paramBusinessObserver)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", paramInt);
      localJSONObject.put("key_type", paramString2);
      localJSONObject.put("key", paramString3);
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("from", "guard");
      localJSONObject.put("nonce", 15331231);
      a("https://graph.qq.com/face/if_proxy", "application/json", localJSONObject.toString(), new awcr(paramBusinessObserver));
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e("LoginVerifyServlet", 1, "sendGetTmpKey JSONException : " + paramString1.getMessage());
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("LoginVerifyServlet", 1, "sendRequest QQAppInterface is null, command is " + paramString);
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    paramArrayOfByte = new NewIntent(paramQQAppInterface.getApp(), awcq.class);
    paramArrayOfByte.setObserver(paramBusinessObserver);
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    paramQQAppInterface.startServlet(paramArrayOfByte);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    try
    {
      oidb_0x5e1.ReqBody localReqBody = new oidb_0x5e1.ReqBody();
      localReqBody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(paramString)));
      localReqBody.user_login_guard_face.set(1);
      a(paramQQAppInterface, 1505, "OidbSvc.0x5e1_295", 295, localReqBody.toByteArray(), paramBusinessObserver);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("LoginVerifyServlet", 1, "sendGetUserFaceStateRequest error : " + paramQQAppInterface.getMessage());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessObserver paramBusinessObserver)
  {
    oidb_0x587.ReqBody localReqBody = new oidb_0x587.ReqBody();
    localReqBody.user_login_guard_face.set(0);
    a(paramQQAppInterface, 1415, "OidbSvc.0x587_63", 63, localReqBody.toByteArray(), paramBusinessObserver);
  }
  
  public static void a(String paramString1, long paramLong, String paramString2, BusinessObserver paramBusinessObserver)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("nonce", paramLong);
      localJSONObject.put("appconf_req", paramString2);
      a("https://graph.qq.com/face/appconf", "application/json", localJSONObject.toString(), new awcs(paramBusinessObserver));
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e("LoginVerifyServlet", 1, "sendGetAppConfigRequest error, msg : " + paramString1.getMessage());
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, awcu paramawcu)
  {
    ThreadManager.getNetExcutor().execute(new LoginVerifyServlet.3(paramString1, paramString2, paramString3, paramawcu));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    oidb_0x87c.ReqBody localReqBody = new oidb_0x87c.ReqBody();
    localReqBody.str_sms_code.set(paramString);
    localReqBody.enum_butype.set(1);
    a(paramQQAppInterface, 2172, "OidbSvc.0x87c_108", 108, localReqBody.toByteArray(), paramBusinessObserver);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, BusinessObserver paramBusinessObserver)
  {
    oidb_0x87a.ReqBody localReqBody = new oidb_0x87a.ReqBody();
    localReqBody.enum_butype.set(1);
    a(paramQQAppInterface, 2170, "OidbSvc.0x87a_108", 108, localReqBody.toByteArray(), paramBusinessObserver);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LoginVerifyServlet", 2, "onReceive");
    }
    if (paramIntent == null) {
      return;
    }
    Object localObject2 = paramIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (localObject2 = bakc.b(paramFromServiceMsg.getWupBuffer());; localObject2 = null)
    {
      ((Bundle)localObject1).putByteArray("data", (byte[])localObject2);
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("LoginVerifyServlet", 2, "onReceive exit");
      return;
      ((Bundle)localObject1).putString("dataErrorMsg", paramFromServiceMsg.getBusinessFailMsg());
      ((Bundle)localObject1).putInt("dataErrorCode", paramFromServiceMsg.getBusinessFailCode());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramIntent = paramIntent.getStringExtra("cmd");
    QLog.i("LoginVerifyServlet", 1, "onSend, cmd is " + paramIntent);
    paramPacket.setSSOCommand(paramIntent);
    paramPacket.putSendData(bakc.a(arrayOfByte));
    if (QLog.isColorLevel()) {
      QLog.i("LoginVerifyServlet", 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awcq
 * JD-Core Version:    0.7.0.1
 */