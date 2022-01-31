import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class amij
  implements Runnable
{
  public amij(QzoneOnlineTimeCollectRptService paramQzoneOnlineTimeCollectRptService) {}
  
  public void run()
  {
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "beginTrace isForeground:" + QzoneOnlineTimeCollectRptService.a(this.a));
    if (!QzoneOnlineTimeCollectRptService.a(this.a)) {}
    try
    {
      this.a.a = Long.parseLong(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      QzoneOnlineTimeCollectRptService.a(this.a, QzoneConfig.getInstance().getConfig("ClientReport", "OnlineLocalSaveFrequency", 10000));
      this.a.b();
      QzoneOnlineTimeCollectRptService.a(this.a);
      QzoneOnlineTimeCollectRptService.a(this.a, true);
      LocalMultiProcConfig.putBool("key_sp_qzone_isforeground", true);
      if (QzoneOnlineTimeCollectRptService.a(this.a) != 0) {
        ThreadManager.getSubThreadHandler().post(QzoneOnlineTimeCollectRptService.a(this.a));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QzoneOnlineTimeCollectRptService", 2, "beginTrace:" + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amij
 * JD-Core Version:    0.7.0.1
 */