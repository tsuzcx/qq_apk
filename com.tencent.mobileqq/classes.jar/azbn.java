import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.servlet.LoginVerifyServlet.3;
import com.tencent.mobileqq.troop.org.pb.oidb_0x587.ReqBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceSecureCheck.SecureCheckRequest;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.manager.WtloginManager;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x5e1.ReqBody;
import tencent.im.oidb.oidb_0x87a.ReqBody;
import tencent.im.oidb.oidb_0x87c.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class azbn
  extends MSFServlet
{
  public static AtomicInteger a = new AtomicInteger(0);
  
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
      a("https://graph.qq.com/face/if_proxy", "application/json", localJSONObject.toString(), new azbo(paramBusinessObserver));
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
    paramArrayOfByte = new NewIntent(paramQQAppInterface.getApp(), azbn.class);
    paramArrayOfByte.setObserver(paramBusinessObserver);
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    paramQQAppInterface.startServlet(paramArrayOfByte);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, avvc paramavvc)
  {
    paramString = new FaceSecureCheck.SecureCheckRequest();
    Object localObject = pco.a(BaseApplicationImpl.getApplication());
    boolean bool;
    if (localObject != null)
    {
      paramString.bytes_client_addr.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
      localObject = (WifiManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("wifi");
      if (localObject == null) {
        break label363;
      }
      bool = ((WifiManager)localObject).isWifiEnabled();
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if ((!bool) || (localObject == null)) {
        break label317;
      }
      paramString.uint32_client_addr.set(((WifiInfo)localObject).getIpAddress());
      label91:
      localObject = paramQQAppInterface.getManager(1);
      if ((localObject != null) && ((localObject instanceof WtloginManager)))
      {
        localObject = ((WtloginManager)localObject).getGUID();
        if (localObject == null) {
          break label374;
        }
        paramString.bytes_guid.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
    }
    for (;;)
    {
      paramString.uint32_seq.set(a.addAndGet(1));
      paramString.uint32_timestamp.set((int)(System.currentTimeMillis() / 1000L));
      paramString.uint32_version.set(AppSetting.a());
      paramString.uint64_appid.set(101810106L);
      long l = new Random().nextLong();
      paramString.uint64_nonce.set(l);
      paramString = paramString.toByteArray();
      localObject = ByteBuffer.allocate(paramString.length + 4);
      ((ByteBuffer)localObject).putInt(paramString.length + 4);
      ((ByteBuffer)localObject).put(paramString);
      localObject = new NewIntent(paramQQAppInterface.getApp(), azbn.class);
      ((NewIntent)localObject).setObserver(paramavvc);
      ((NewIntent)localObject).putExtra("cmd", "FaceRecognition.SecureCheck");
      ((NewIntent)localObject).putExtra("data", paramString);
      paramQQAppInterface.startServlet((NewIntent)localObject);
      return;
      QLog.e("LoginVerifyServlet", 1, "getIpAddress error");
      paramString.bytes_client_addr.set(ByteStringMicro.copyFrom("0.0.0.0".getBytes()));
      break;
      label317:
      if (localObject == null) {}
      for (bool = true;; bool = false)
      {
        QLog.e("LoginVerifyServlet", 1, new Object[] { "wifiManager.isWifiEnabled : false or connection is null : ", Boolean.valueOf(bool) });
        paramString.uint32_client_addr.set(0);
        break;
      }
      label363:
      paramString.uint32_client_addr.set(0);
      break label91;
      label374:
      QLog.e("LoginVerifyServlet", 1, "guid is null");
    }
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
      a("https://graph.qq.com/face/appconf", "application/json", localJSONObject.toString(), new azbp(paramBusinessObserver));
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e("LoginVerifyServlet", 1, "sendGetAppConfigRequest error, msg : " + paramString1.getMessage());
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, azbr paramazbr)
  {
    ThreadManager.getNetExcutor().execute(new LoginVerifyServlet.3(paramString1, paramString2, paramString3, paramazbr));
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
    for (localObject2 = bdpd.b(paramFromServiceMsg.getWupBuffer());; localObject2 = null)
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
    paramPacket.putSendData(bdpd.a(arrayOfByte));
    if (QLog.isColorLevel()) {
      QLog.i("LoginVerifyServlet", 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbn
 * JD-Core Version:    0.7.0.1
 */