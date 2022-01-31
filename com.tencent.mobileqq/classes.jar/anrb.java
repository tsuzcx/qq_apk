import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public final class anrb
  implements Runnable
{
  public void run()
  {
    ((QIMMusicConfigManager)QIMManager.a().c(2)).c();
    ((PasterDataManager)QIMManager.a().c(4)).c();
    ((QIMPtvTemplateManager)QIMManager.a().c(3)).e();
    ((CaptureComboManager)QIMManager.a().c(5)).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrb
 * JD-Core Version:    0.7.0.1
 */