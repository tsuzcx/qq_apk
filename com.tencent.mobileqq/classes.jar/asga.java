import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class asga
  extends beyf
{
  asga(asfy paramasfy, Looper paramLooper, CameraEmotionData paramCameraEmotionData)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if (asfy.a(this.jdField_a_of_type_Asfy) == null) {
      label19:
      return;
    }
    if ((localbete == null) || (localbete.c != this.jdField_a_of_type_Asfy.a()))
    {
      asfy.b(this.jdField_a_of_type_Asfy).a().b(this);
      return;
    }
    Bdh_extinfo.CommFileExtRsp localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (localbete.a != null) {}
    for (;;)
    {
      try
      {
        localCommFileExtRsp.mergeFrom(localbete.a);
        if (!localCommFileExtRsp.bytes_download_url.has()) {
          break label515;
        }
        localObject1 = localCommFileExtRsp.bytes_download_url.get().toStringUtf8();
        localObject3 = new HashMap();
        switch (paramMessage.what)
        {
        case 1002: 
        default: 
          return;
        case 1001: 
          if (!QLog.isColorLevel()) {
            break label19;
          }
          QLog.d("CameraEmoRoamingManager", 2, "start upload camera emo");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("CameraEmoRoamingManager", 2, "extRsp.mergeFrom(file.bdhExtendInfo) failed");
        localObject2 = localObject3;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("CameraEmoRoamingManager", 2, "finish upload camera emo serverPath=" + (String)localObject2);
        }
        asfy.c(this.jdField_a_of_type_Asfy).a().b(this);
        ((anuj)asfy.d(this.jdField_a_of_type_Asfy).a(160)).a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, true);
        ((HashMap)localObject3).put("sucFlag", "1");
        ((HashMap)localObject3).put("retCode", String.valueOf(paramMessage.what));
        bdmc.a(BaseApplication.getContext()).a(null, "CamEmoRealUpload", true, 0L, 0L, (HashMap)localObject3, null);
        return;
      }
      asfy.e(this.jdField_a_of_type_Asfy).a().b(this);
      QLog.i("CameraEmoRoamingManager", 1, "upload camera emo error:" + localCommFileExtRsp.int32_retcode.get());
      ((anuj)asfy.f(this.jdField_a_of_type_Asfy).a(160)).a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, false);
      ((HashMap)localObject3).put("sucFlag", "0");
      ((HashMap)localObject3).put("retCode", String.valueOf(localCommFileExtRsp.int32_retcode.get()));
      bdmc.a(BaseApplication.getContext()).a(null, "CamEmoRealUpload", false, 0L, 0L, (HashMap)localObject3, null);
      return;
      asfy.g(this.jdField_a_of_type_Asfy).a().b(this);
      QLog.i("CameraEmoRoamingManager", 1, "upload camera emo cancel:" + (String)localObject2);
      ((anuj)asfy.h(this.jdField_a_of_type_Asfy).a(160)).a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, false);
      ((HashMap)localObject3).put("sucFlag", "0");
      ((HashMap)localObject3).put("retCode", String.valueOf(paramMessage.what));
      bdmc.a(BaseApplication.getContext()).a(null, "CamEmoRealUpload", false, 0L, 0L, (HashMap)localObject3, null);
      return;
      label515:
      Object localObject2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asga
 * JD-Core Version:    0.7.0.1
 */