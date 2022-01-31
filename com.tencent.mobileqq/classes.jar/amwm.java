import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.humrecognition.humming.IRecognizer;
import dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditRecognitionPart;
import java.io.File;

public class amwm
  implements Runnable
{
  public amwm(BgmRecognitionProviderView paramBgmRecognitionProviderView) {}
  
  public void run()
  {
    if (BgmRecognitionProviderView.a(this.a) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BgmRecognitionProviderView", 2, "run: invoked. info: mRecognitionPart = " + BgmRecognitionProviderView.a(this.a));
      }
      return;
    }
    File localFile = BgmRecognitionProviderView.a(this.a).a();
    if ((localFile != null) && (localFile.exists()))
    {
      BgmRecognitionProviderView.a(this.a).a(localFile);
      BgmRecognitionProviderView.a(this.a).a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("BgmRecognitionProviderView", 2, "run: invoked. info: Failed to get audioFile. audioFile = " + localFile);
    }
    ToastUtil.a().a(2131439225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amwm
 * JD-Core Version:    0.7.0.1
 */