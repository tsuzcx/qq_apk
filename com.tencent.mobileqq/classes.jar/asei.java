import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class asei
  extends TransProcessorHandler
{
  asei(aseg paramaseg, Looper paramLooper, CameraEmotionData paramCameraEmotionData)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (aseg.a(this.jdField_a_of_type_Aseg) == null) {
      label19:
      return;
    }
    if ((localFileMsg == null) || (localFileMsg.commandId != this.jdField_a_of_type_Aseg.a()))
    {
      aseg.b(this.jdField_a_of_type_Aseg).getTransFileController().removeHandle(this);
      return;
    }
    Bdh_extinfo.CommFileExtRsp localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (localFileMsg.bdhExtendInfo != null) {}
    for (;;)
    {
      try
      {
        localCommFileExtRsp.mergeFrom(localFileMsg.bdhExtendInfo);
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
        aseg.c(this.jdField_a_of_type_Aseg).getTransFileController().removeHandle(this);
        ((anrf)aseg.d(this.jdField_a_of_type_Aseg).getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, true);
        ((HashMap)localObject3).put("sucFlag", "1");
        ((HashMap)localObject3).put("retCode", String.valueOf(paramMessage.what));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoRealUpload", true, 0L, 0L, (HashMap)localObject3, null);
        return;
      }
      aseg.e(this.jdField_a_of_type_Aseg).getTransFileController().removeHandle(this);
      QLog.i("CameraEmoRoamingManager", 1, "upload camera emo error:" + localCommFileExtRsp.int32_retcode.get());
      ((anrf)aseg.f(this.jdField_a_of_type_Aseg).getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, false);
      ((HashMap)localObject3).put("sucFlag", "0");
      ((HashMap)localObject3).put("retCode", String.valueOf(localCommFileExtRsp.int32_retcode.get()));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoRealUpload", false, 0L, 0L, (HashMap)localObject3, null);
      return;
      aseg.g(this.jdField_a_of_type_Aseg).getTransFileController().removeHandle(this);
      QLog.i("CameraEmoRoamingManager", 1, "upload camera emo cancel:" + (String)localObject2);
      ((anrf)aseg.h(this.jdField_a_of_type_Aseg).getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, false);
      ((HashMap)localObject3).put("sucFlag", "0");
      ((HashMap)localObject3).put("retCode", String.valueOf(paramMessage.what));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoRealUpload", false, 0L, 0L, (HashMap)localObject3, null);
      return;
      label515:
      Object localObject2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asei
 * JD-Core Version:    0.7.0.1
 */