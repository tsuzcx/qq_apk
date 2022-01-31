import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.banner.QIMCaptureBannerConfig;
import dov.com.qq.im.capture.banner.QIMCaptureBannerConfig.BannerItem;
import dov.com.qq.im.capture.banner.QIMCaptureBannerManager;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class antt
  implements Runnable
{
  public antt(QIMCaptureBannerManager paramQIMCaptureBannerManager) {}
  
  public void run()
  {
    QIMCaptureBannerConfig localQIMCaptureBannerConfig = QIMCaptureBannerConfig.getBannerConfigFromFile(this.a.a(), QIMCaptureBannerManager.jdField_a_of_type_JavaLangString);
    if ((localQIMCaptureBannerConfig != null) && (localQIMCaptureBannerConfig.mBannerList.size() > 0))
    {
      ??? = localQIMCaptureBannerConfig.mBannerList.entrySet().iterator();
      while (((Iterator)???).hasNext())
      {
        QIMCaptureBannerConfig.BannerItem localBannerItem = (QIMCaptureBannerConfig.BannerItem)((Map.Entry)((Iterator)???).next()).getValue();
        long l = NetConnInfoCenter.getServerTimeMillis();
        if (localBannerItem.mEndTime < l) {
          ((Iterator)???).remove();
        }
      }
    }
    synchronized (QIMCaptureBannerManager.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig = localQIMCaptureBannerConfig;
      if (QLog.isColorLevel()) {
        QLog.d("QIMCaptureBannerManager", 2, "initBannerFromCache= " + localQIMCaptureBannerConfig);
      }
      this.a.a().notifyObservers(CaptureConfigUpdateObserver.class, 6, true, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     antt
 * JD-Core Version:    0.7.0.1
 */