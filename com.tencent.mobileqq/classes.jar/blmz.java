import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.banner.QIMCaptureBannerConfig.BannerItem;
import dov.com.qq.im.capture.banner.QIMCaptureBannerManager.3;

public class blmz
  implements bapx
{
  public blmz(QIMCaptureBannerManager.3 param3) {}
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCaptureBannerManager", 2, "onResp url: " + this.a.a.imgUrl + " resultcode: " + parambaqw.c);
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmz
 * JD-Core Version:    0.7.0.1
 */