import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public class anka
  implements Runnable
{
  public anka(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload update filterpager begin");
    }
    VideoFilterViewPager localVideoFilterViewPager = QIMEffectCameraCaptureUnit.a(this.a);
    if (localVideoFilterViewPager == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload filterPager null ");
      }
    }
    do
    {
      return;
      localVideoFilterViewPager.setCaptureScene(0);
      CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
      QIMPtvTemplateManager localQIMPtvTemplateManager = (QIMPtvTemplateManager)QIMManager.a(3);
      if (localCaptureComboManager.a() != null) {
        localVideoFilterViewPager.a(localCaptureComboManager.a().c);
      }
      VideoFilterTools.a().a(null);
      VideoFilterTools.a().a(null, this.a.a.a(), 0);
      localQIMPtvTemplateManager.a("0", 0, "");
    } while (!QLog.isColorLevel());
    QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload update filterpager end; postion=" + 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anka
 * JD-Core Version:    0.7.0.1
 */