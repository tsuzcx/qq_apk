import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppWordings;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.Appconf.AppConfRequest;
import face.qqlogin.Appconf.AppConfResponse;
import face.qqlogin.Appconf.Wording;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class avod
  extends MSFServlet
{
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    for (;;)
    {
      Object localObject1;
      int i;
      Object localObject3;
      String str1;
      int j;
      String str2;
      String str3;
      try
      {
        localObject1 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject1).getInt() - 4];
        ((ByteBuffer)localObject1).get(paramFromServiceMsg);
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(paramFromServiceMsg);
        i = ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.get();
        if (i == 15)
        {
          paramFromServiceMsg = ((oidb_sso.OIDBSSOPkg)localObject1).str_error_msg.get();
          QLog.e("FaceDetectForThirdPartyServlet", 1, "sso result error, ret : " + i + "  error : " + paramFromServiceMsg);
          notifyObserver(paramIntent, 15, false, null, null);
          return;
        }
        localObject3 = new Appconf.AppConfResponse();
        ((Appconf.AppConfResponse)localObject3).mergeFrom(paramFromServiceMsg);
        localObject2 = ((Appconf.AppConfResponse)localObject3).AppName.get();
        i = ((Appconf.AppConfResponse)localObject3).Mode.get();
        localObject1 = ((Appconf.AppConfResponse)localObject3).ColorSeq.get().toStringUtf8();
        str1 = ((Appconf.AppConfResponse)localObject3).Session.get();
        j = ((Appconf.AppConfResponse)localObject3).Ret.get();
        str2 = ((Appconf.AppConfResponse)localObject3).ErrMsg.get();
        str3 = ((Appconf.AppConfResponse)localObject3).ActionSeq.get().toStringUtf8();
        if (!QLog.isDevelopLevel()) {
          break label543;
        }
        paramFromServiceMsg = ((Appconf.AppConfResponse)localObject3).Debug.get();
        Object localObject4 = ((Appconf.AppConfResponse)localObject3).Wordings.get();
        localObject3 = new ArrayList(3);
        if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
          break label354;
        }
        localObject4 = ((List)localObject4).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label386;
        }
        Appconf.Wording localWording = (Appconf.Wording)((Iterator)localObject4).next();
        ((List)localObject3).add(new FaceDetectForThirdPartyManager.AppWordings(localWording.serviceType.get(), localWording.Text.get()));
        continue;
        QLog.d("FaceDetectForThirdPartyServlet", 2, "handleFaceDetectResponse error=", paramFromServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyObserver(paramIntent, 17, false, null, null);
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      return;
      label354:
      if (QLog.isColorLevel()) {
        QLog.d("FaceDetectForThirdPartyServlet", 2, "handleFaceDetectResponse list is null appName =" + (String)localObject2);
      }
      label386:
      Object localObject2 = new FaceDetectForThirdPartyManager.AppConf((String)localObject2, (List)localObject3, i);
      ((FaceDetectForThirdPartyManager.AppConf)localObject2).colorSequence = ((String)localObject1);
      ((FaceDetectForThirdPartyManager.AppConf)localObject2).session = str1;
      ((FaceDetectForThirdPartyManager.AppConf)localObject2).ret = j;
      ((FaceDetectForThirdPartyManager.AppConf)localObject2).errMsg = str2;
      ((FaceDetectForThirdPartyManager.AppConf)localObject2).actionReq = b(str3);
      ((FaceDetectForThirdPartyManager.AppConf)localObject2).debug = paramFromServiceMsg;
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putInt("app_id", paramIntent.getIntExtra("app_id", 0));
      paramFromServiceMsg.putSerializable("FaceRecognition.AppConf", (Serializable)localObject2);
      notifyObserver(paramIntent, 17, true, paramFromServiceMsg, null);
      if ((!QLog.isColorLevel()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("FaceDetectForThirdPartyServlet", 2, new Object[] { "handleFaceDetectResponse succsss=", localObject2 });
      return;
      notifyObserver(paramIntent, 17, false, null, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FaceDetectForThirdPartyServlet", 2, "handleFaceDetectResponse not ok");
      return;
      label543:
      paramFromServiceMsg = null;
    }
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("app_id", 0);
    Object localObject = paramIntent.getStringExtra("qq_version");
    String str = paramIntent.getStringExtra("light_info");
    paramIntent = paramIntent.getStringExtra("tmp_key");
    Appconf.AppConfRequest localAppConfRequest = new Appconf.AppConfRequest();
    localAppConfRequest.AppID.set(i);
    localAppConfRequest.Platform.set("a");
    localAppConfRequest.QQVersion.set((String)localObject);
    localAppConfRequest.YtSDKEnv.set(str);
    localAppConfRequest.TmpKey.set(paramIntent);
    paramIntent = localAppConfRequest.toByteArray();
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.setSSOCommand("FaceRecognition.AppConf");
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, long paramLong, BusinessObserver paramBusinessObserver)
  {
    if ("loginVerify".equals(paramString1)) {
      a(paramString2, paramInt, paramString3, paramString4, paramString5, paramLong, paramBusinessObserver);
    }
    do
    {
      return;
      NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), avod.class);
      localNewIntent.putExtra("qq_version", paramString3);
      localNewIntent.putExtra("app_id", paramInt);
      localNewIntent.putExtra("cmd_param", "FaceRecognition.AppConf");
      localNewIntent.putExtra("light_info", paramString4);
      localNewIntent.putExtra("tmp_key", paramString5);
      localNewIntent.putExtra("method", paramString1);
      localNewIntent.putExtra("nonce", paramLong);
      localNewIntent.putExtra("uin", paramString2);
      localNewIntent.setObserver(paramBusinessObserver);
      paramQQAppInterface.startServlet(localNewIntent);
    } while (!QLog.isColorLevel());
    QLog.d("FaceDetectForThirdPartyServlet", 2, "requestThirdPartyInfo appId=" + paramInt + " qqVersion=" + paramString3 + " lightInfo=" + paramString4);
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, long paramLong, BusinessObserver paramBusinessObserver)
  {
    Appconf.AppConfRequest localAppConfRequest = new Appconf.AppConfRequest();
    localAppConfRequest.AppID.set(paramInt);
    localAppConfRequest.Platform.set("a");
    localAppConfRequest.QQVersion.set(paramString2);
    localAppConfRequest.YtSDKEnv.set(paramString3);
    localAppConfRequest.TmpKey.set(paramString4);
    bccl.a(paramString1, paramLong, Base64.encodeToString(localAppConfRequest.toByteArray(), 11), new avoe(paramInt, paramBusinessObserver));
  }
  
  private static int[] b(String paramString)
  {
    int i = 0;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return new int[0];
      }
      String[] arrayOfString = paramString.split(" ");
      int[] arrayOfInt = new int[arrayOfString.length];
      for (;;)
      {
        paramString = arrayOfInt;
        if (i >= arrayOfString.length) {
          break;
        }
        arrayOfInt[i] = Integer.parseInt(arrayOfString[i]);
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("FaceDetectForThirdPartyServlet", 1, "parseAction error : " + paramString.getMessage());
      paramString = null;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (String str1 = "";; str1 = "not")
    {
      QLog.d("FaceDetectForThirdPartyServlet", 2, str1 + " success");
      if (!"FaceRecognition.AppConf".equals(str2)) {
        break;
      }
      a(paramIntent, paramFromServiceMsg);
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd_param");
    if (QLog.isColorLevel()) {
      QLog.d("FaceDetectForThirdPartyServlet", 2, "resp:" + str);
    }
    if ("FaceRecognition.AppConf".equals(str)) {
      a(paramIntent, paramPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avod
 * JD-Core Version:    0.7.0.1
 */