import com.tencent.mobileqq.activity.qwallet.emoj.IBaseRecognizer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.6.1;
import mqq.os.MqqHandler;

public class bigz
  implements IBaseRecognizer
{
  bigz(bigs parambigs) {}
  
  public void OnInitResultCallback(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "init recoginzer result =" + paramBoolean);
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.6.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bigz
 * JD-Core Version:    0.7.0.1
 */