import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class amtw
  implements Runnable
{
  public amtw(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    VideoFilterViewPager localVideoFilterViewPager = QIMEffectCameraCaptureUnit.a(this.a);
    if ((localVideoFilterViewPager != null) && (localCaptureComboManager.a() != null)) {
      localVideoFilterViewPager.a(localCaptureComboManager.a().c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amtw
 * JD-Core Version:    0.7.0.1
 */