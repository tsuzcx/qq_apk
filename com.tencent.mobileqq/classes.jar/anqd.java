import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.view.StaticStickerProviderView;

public class anqd
  extends CaptureConfigUpdateObserver
{
  public anqd(StaticStickerProviderView paramStaticStickerProviderView) {}
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StaticStickerProviderView", 2, "paster config get notify");
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqd
 * JD-Core Version:    0.7.0.1
 */