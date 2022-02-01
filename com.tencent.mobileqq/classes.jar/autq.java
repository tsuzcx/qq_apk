import android.os.Bundle;
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
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.Appconf.AppConfResponse;
import face.qqlogin.Appconf.Wording;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

final class autq
  extends axkv
{
  autq(int paramInt, BusinessObserver paramBusinessObserver) {}
  
  public void getAppConfigSuccess(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      Object localObject2;
      int i;
      String str1;
      String str2;
      int j;
      String str3;
      String str4;
      try
      {
        localObject2 = new Appconf.AppConfResponse();
        ((Appconf.AppConfResponse)localObject2).mergeFrom(paramArrayOfByte);
        localObject1 = ((Appconf.AppConfResponse)localObject2).AppName.get();
        i = ((Appconf.AppConfResponse)localObject2).Mode.get();
        str1 = ((Appconf.AppConfResponse)localObject2).ColorSeq.get().toStringUtf8();
        str2 = ((Appconf.AppConfResponse)localObject2).Session.get();
        j = ((Appconf.AppConfResponse)localObject2).Ret.get();
        str3 = ((Appconf.AppConfResponse)localObject2).ErrMsg.get();
        str4 = ((Appconf.AppConfResponse)localObject2).ActionSeq.get().toStringUtf8();
        if (!QLog.isDevelopLevel()) {
          break label396;
        }
        paramArrayOfByte = ((Appconf.AppConfResponse)localObject2).Debug.get();
        Object localObject3 = ((Appconf.AppConfResponse)localObject2).Wordings.get();
        localObject2 = new ArrayList(3);
        if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
        {
          localObject3 = ((List)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label267;
          }
          Appconf.Wording localWording = (Appconf.Wording)((Iterator)localObject3).next();
          ((List)localObject2).add(new FaceDetectForThirdPartyManager.AppWordings(localWording.serviceType.get(), localWording.Text.get()));
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label267;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(17, false, null);
        if (QLog.isColorLevel()) {
          QLog.d("FaceDetectForThirdPartyServlet", 2, "handleFaceDetectResponse error=", paramArrayOfByte);
        }
        return;
      }
      QLog.d("FaceDetectForThirdPartyServlet", 2, "handleFaceDetectResponse list is null appName =" + (String)localObject1);
      label267:
      Object localObject1 = new FaceDetectForThirdPartyManager.AppConf((String)localObject1, (List)localObject2, i);
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).colorSequence = str1;
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).actionReq = autp.a(str4);
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).session = str2;
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).ret = j;
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).errMsg = str3;
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).debug = paramArrayOfByte;
      paramArrayOfByte = new Bundle();
      paramArrayOfByte.putInt("app_id", this.jdField_a_of_type_Int);
      paramArrayOfByte.putSerializable("FaceRecognition.AppConf", (Serializable)localObject1);
      this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(17, true, paramArrayOfByte);
      if ((QLog.isColorLevel()) && (QLog.isColorLevel()))
      {
        QLog.d("FaceDetectForThirdPartyServlet", 2, new Object[] { "handleFaceDetectResponse succsss=", localObject1 });
        return;
        label396:
        paramArrayOfByte = null;
      }
    }
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(paramInt, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autq
 * JD-Core Version:    0.7.0.1
 */