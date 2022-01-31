import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.observer.BusinessObserver;

class aqig
  implements BusinessObserver
{
  aqig(aqif paramaqif, FaceDetectForThirdPartyManager paramFaceDetectForThirdPartyManager, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 17) && (paramBoolean) && (paramBundle != null))
    {
      paramInt = paramBundle.getInt("app_id", 0);
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 2, "onReceive appid = " + paramInt);
      }
      if (paramInt == 0) {
        return;
      }
      FaceDetectForThirdPartyManager.AppConf localAppConf = (FaceDetectForThirdPartyManager.AppConf)paramBundle.getSerializable("FaceRecognition.AppConf");
      if (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager.a(paramInt, localAppConf);
      }
      this.jdField_a_of_type_Aqif.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(0, paramBundle));
      return;
    }
    if (paramInt != 15)
    {
      this.jdField_a_of_type_Aqif.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(-102, null));
      label126:
      if (paramInt != 17) {
        break label184;
      }
      if (paramBundle != null) {
        break label186;
      }
    }
    label184:
    label186:
    for (paramBundle = "1";; paramBundle = "2")
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D63", "0X8009D63", 0, 0, paramBundle, "", "", "");
      return;
      this.jdField_a_of_type_Aqif.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(15, null));
      break label126;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqig
 * JD-Core Version:    0.7.0.1
 */