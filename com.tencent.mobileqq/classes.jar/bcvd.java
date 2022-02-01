import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Base64;
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
import com.tencent.mobileqq.servlet.LoginVerifyServlet.4;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe96.ReqBody;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe9a.ReqBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import face.FaceForeignIp.AvailableRequest;
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
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.ReqBody;
import tencent.im.oidb.oidb_0x5e1.ReqBody;
import tencent.im.oidb.oidb_0x87a.ReqBody;
import tencent.im.oidb.oidb_0x87c.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bcvd
  extends MSFServlet
{
  public static AtomicInteger a = new AtomicInteger(0);
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, BusinessObserver paramBusinessObserver)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", paramInt);
      localJSONObject.put("key_type", paramString2);
      localJSONObject.put("key", paramString3);
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("from", paramString4);
      localJSONObject.put("nonce", Math.abs(new Random(System.currentTimeMillis()).nextLong()));
      a("https://graph.qq.com/face/if_proxy", "application/json", localJSONObject.toString(), new bcve(paramBusinessObserver));
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e("LoginVerifyServlet", 1, "sendGetTmpKey JSONException : " + paramString1.getMessage());
    }
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, BusinessObserver paramBusinessObserver)
  {
    a(paramInt, paramString1, paramString2, paramString3, "guard", paramBusinessObserver);
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte, long paramLong, BusinessObserver paramBusinessObserver)
  {
    try
    {
      localObject = new FaceForeignIp.AvailableRequest();
      ((FaceForeignIp.AvailableRequest)localObject).appID.set(paramInt);
      ((FaceForeignIp.AvailableRequest)localObject).ip.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      ((FaceForeignIp.AvailableRequest)localObject).uin.set(paramLong);
      paramArrayOfByte = Base64.encodeToString(((FaceForeignIp.AvailableRequest)localObject).toByteArray(), 11);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("available_req", paramArrayOfByte);
      a("https://graph.qq.com/face/available", "application/json", ((JSONObject)localObject).toString(), 2000, 2000, new bcvf(paramBusinessObserver));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("LoginVerifyServlet", 1, new Object[] { "sendHTTPSIpForeignJudgeRequest error : ", paramArrayOfByte.getMessage() });
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("dataErrorMsg", paramArrayOfByte.getMessage());
      ((Bundle)localObject).putInt("dataErrorCode", -1);
      paramBusinessObserver.onReceive(0, false, (Bundle)localObject);
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
    paramArrayOfByte = new NewIntent(paramQQAppInterface.getApp(), bcvd.class);
    paramArrayOfByte.setObserver(paramBusinessObserver);
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    paramQQAppInterface.startServlet(paramArrayOfByte);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, BusinessObserver paramBusinessObserver)
  {
    try
    {
      localObject = new FaceForeignIp.AvailableRequest();
      ((FaceForeignIp.AvailableRequest)localObject).appID.set(paramInt);
      a(paramQQAppInterface, "FaceRecognition.Available", ((FaceForeignIp.AvailableRequest)localObject).toByteArray(), 2000L, paramBusinessObserver);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("LoginVerifyServlet", 1, new Object[] { "sendSSOIpForeignJudgeRequest error : ", paramQQAppInterface.getMessage() });
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("dataErrorMsg", paramQQAppInterface.getMessage());
      ((Bundle)localObject).putInt("dataErrorCode", -1);
      paramBusinessObserver.onReceive(0, false, (Bundle)localObject);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ayxn paramayxn)
  {
    a(paramQQAppInterface, 2478, "OidbSvc.0x9ae_13", 13, new cmd0x9ae.ReqBody().toByteArray(), paramayxn);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ayxn paramayxn)
  {
    paramString = new FaceSecureCheck.SecureCheckRequest();
    Object localObject = plw.a(BaseApplicationImpl.getApplication());
    boolean bool;
    if (localObject != null)
    {
      paramString.bytes_client_addr.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
      localObject = (WifiManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("wifi");
      if (localObject == null) {
        break label364;
      }
      bool = ((WifiManager)localObject).isWifiEnabled();
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if ((!bool) || (localObject == null)) {
        break label318;
      }
      paramString.uint32_client_addr.set(((WifiInfo)localObject).getIpAddress());
      label92:
      localObject = paramQQAppInterface.getManager(1);
      if ((localObject != null) && ((localObject instanceof WtloginManager)))
      {
        localObject = ((WtloginManager)localObject).getGUID();
        if (localObject == null) {
          break label375;
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
      localObject = new NewIntent(paramQQAppInterface.getApp(), bcvd.class);
      ((NewIntent)localObject).setObserver(paramayxn);
      ((NewIntent)localObject).putExtra("cmd", "FaceRecognition.SecureCheck");
      ((NewIntent)localObject).putExtra("data", paramString);
      paramQQAppInterface.startServlet((NewIntent)localObject);
      return;
      QLog.e("LoginVerifyServlet", 1, "getIpAddress error");
      paramString.bytes_client_addr.set(ByteStringMicro.copyFrom("0.0.0.0".getBytes()));
      break;
      label318:
      if (localObject == null) {}
      for (bool = true;; bool = false)
      {
        QLog.e("LoginVerifyServlet", 1, new Object[] { "wifiManager.isWifiEnabled : false or connection is null : ", Boolean.valueOf(bool) });
        paramString.uint32_client_addr.set(0);
        break;
      }
      label364:
      paramString.uint32_client_addr.set(0);
      break label92;
      label375:
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
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte, long paramLong, BusinessObserver paramBusinessObserver)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("LoginVerifyServlet", 1, new Object[] { "sendRequest QQAppInterface is null, command is ", paramString });
      return;
    }
    Object localObject = ByteBuffer.allocate(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).putInt(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    localObject = new NewIntent(paramQQAppInterface.getApp(), bcvd.class);
    ((NewIntent)localObject).setObserver(paramBusinessObserver);
    ((NewIntent)localObject).putExtra("cmd", paramString);
    ((NewIntent)localObject).putExtra("data", paramArrayOfByte);
    if (paramLong > 0L) {
      ((NewIntent)localObject).putExtra("timeout", paramLong);
    }
    paramQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessObserver paramBusinessObserver)
  {
    oidb_0x87a.ReqBody localReqBody = new oidb_0x87a.ReqBody();
    localReqBody.enum_butype.set(1);
    a(paramQQAppInterface, 2170, "OidbSvc.0x87a_108", 108, localReqBody.toByteArray(), paramBusinessObserver);
  }
  
  public static void a(String paramString1, long paramLong, String paramString2, BusinessObserver paramBusinessObserver)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("nonce", paramLong);
      localJSONObject.put("appconf_req", paramString2);
      a("https://graph.qq.com/face/appconf", "application/json", localJSONObject.toString(), new bcvg(paramBusinessObserver));
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e("LoginVerifyServlet", 1, "sendGetAppConfigRequest error, msg : " + paramString1.getMessage());
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, bcvi parambcvi)
  {
    ThreadManager.getNetExcutor().execute(new LoginVerifyServlet.4(paramString1, paramInt1, paramInt2, paramString2, paramString3, parambcvi));
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, bcvi parambcvi)
  {
    a(paramString1, paramString2, paramString3, 10000, 30000, parambcvi);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt, BusinessObserver paramBusinessObserver)
  {
    oidb_0xe9a.ReqBody localReqBody = new oidb_0xe9a.ReqBody();
    localReqBody.uint32_use_status.set(paramInt);
    a(paramQQAppInterface, 3738, "OidbSvc.0xe9a_0", 0, localReqBody.toByteArray(), paramBusinessObserver);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ayxn paramayxn)
  {
    a(paramQQAppInterface, 2478, "OidbSvc.0x9ae_14", 14, new cmd0x9ae.ReqBody().toByteArray(), paramayxn);
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
    a(paramQQAppInterface, 3734, "OidbSvc.0xe96_0", 0, new oidb_0xe96.ReqBody().toByteArray(), paramBusinessObserver);
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
    for (localObject2 = bhuf.b(paramFromServiceMsg.getWupBuffer());; localObject2 = null)
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
    String str = paramIntent.getStringExtra("cmd");
    long l = paramIntent.getLongExtra("timeout", 0L);
    QLog.i("LoginVerifyServlet", 1, "onSend, cmd is " + str);
    paramPacket.setSSOCommand(str);
    paramPacket.putSendData(bhuf.a(arrayOfByte));
    if (l > 0L) {
      paramPacket.setTimeout(l);
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginVerifyServlet", 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvd
 * JD-Core Version:    0.7.0.1
 */