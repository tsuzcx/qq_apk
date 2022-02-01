import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class asgd
  implements bovk
{
  public asgd(CameraEmoSingleSend paramCameraEmoSingleSend, bovi parambovi, long paramLong) {}
  
  public void a()
  {
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "onGifCreateFail, emoId:", Integer.valueOf(CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend).emoId) });
    CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend, false, null);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sucFlag", "0");
    this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend.a().a(null, "CamEmoCreateGIF", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, localHashMap, null);
  }
  
  public void a(String paramString)
  {
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "onGifCreateSuccess, emoId:", Integer.valueOf(CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend).emoId) });
    CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend, true, paramString);
    this.jdField_a_of_type_Bovi.a();
    paramString = new HashMap();
    paramString.put("sucFlag", "1");
    this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend.a().a(null, "CamEmoCreateGIF", true, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgd
 * JD-Core Version:    0.7.0.1
 */