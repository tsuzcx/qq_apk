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

class anbj
  extends axvs
{
  anbj(anbh paramanbh, Looper paramLooper, CameraEmotionData paramCameraEmotionData)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    axqf localaxqf = (axqf)paramMessage.obj;
    if (anbh.b(this.jdField_a_of_type_Anbh) == null) {
      label19:
      return;
    }
    if ((localaxqf == null) || (localaxqf.c != this.jdField_a_of_type_Anbh.a()))
    {
      anbh.c(this.jdField_a_of_type_Anbh).a().b(this);
      return;
    }
    Bdh_extinfo.CommFileExtRsp localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (localaxqf.a != null) {}
    for (;;)
    {
      try
      {
        localCommFileExtRsp.mergeFrom(localaxqf.a);
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
        anbh.d(this.jdField_a_of_type_Anbh).a().b(this);
        ((ajff)anbh.e(this.jdField_a_of_type_Anbh).a(160)).a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, true);
        ((HashMap)localObject3).put("sucFlag", "1");
        ((HashMap)localObject3).put("retCode", String.valueOf(paramMessage.what));
        awrn.a(BaseApplication.getContext()).a(null, "CamEmoRealUpload", true, 0L, 0L, (HashMap)localObject3, null);
        return;
      }
      anbh.f(this.jdField_a_of_type_Anbh).a().b(this);
      QLog.i("CameraEmoRoamingManager", 1, "upload camera emo error:" + localCommFileExtRsp.int32_retcode.get());
      ((ajff)anbh.g(this.jdField_a_of_type_Anbh).a(160)).a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, false);
      ((HashMap)localObject3).put("sucFlag", "0");
      ((HashMap)localObject3).put("retCode", String.valueOf(localCommFileExtRsp.int32_retcode.get()));
      awrn.a(BaseApplication.getContext()).a(null, "CamEmoRealUpload", false, 0L, 0L, (HashMap)localObject3, null);
      return;
      anbh.h(this.jdField_a_of_type_Anbh).a().b(this);
      QLog.i("CameraEmoRoamingManager", 1, "upload camera emo cancel:" + (String)localObject2);
      ((ajff)anbh.i(this.jdField_a_of_type_Anbh).a(160)).a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, false);
      ((HashMap)localObject3).put("sucFlag", "0");
      ((HashMap)localObject3).put("retCode", String.valueOf(paramMessage.what));
      awrn.a(BaseApplication.getContext()).a(null, "CamEmoRealUpload", false, 0L, 0L, (HashMap)localObject3, null);
      return;
      label515:
      Object localObject2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anbj
 * JD-Core Version:    0.7.0.1
 */