import android.os.Bundle;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class arcm
  implements EIPCResultCallback
{
  arcm(arcn paramarcn) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str = null;
    QLog.d("FaceLoginHelper", 1, "callServer error_code:" + paramEIPCResult.code);
    FaceDetectForThirdPartyManager.AppConf localAppConf;
    switch (paramEIPCResult.code)
    {
    default: 
      str = ajya.a(2131714525);
      localAppConf = null;
    }
    while ((paramEIPCResult.code != 0) || (paramEIPCResult.data == null))
    {
      this.a.a(paramEIPCResult.code, str);
      return;
      if (paramEIPCResult.data != null)
      {
        localAppConf = (FaceDetectForThirdPartyManager.AppConf)paramEIPCResult.data.getSerializable("FaceRecognition.AppConf");
        QLog.d("FaceLoginHelper", 1, "callServer error_code:" + localAppConf);
      }
      else
      {
        str = ajya.a(2131714525);
        localAppConf = null;
        continue;
        str = ajya.a(2131692278);
        localAppConf = null;
      }
    }
    this.a.a(localAppConf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arcm
 * JD-Core Version:    0.7.0.1
 */