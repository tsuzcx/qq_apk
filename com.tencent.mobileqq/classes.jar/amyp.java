import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import mqq.os.MqqHandler;

public class amyp
  implements Runnable
{
  public amyp(QzoneOnlineTimeCollectRptService paramQzoneOnlineTimeCollectRptService) {}
  
  public void run()
  {
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "closeTrace isForeground:" + QzoneOnlineTimeCollectRptService.a(this.a));
    if (QzoneOnlineTimeCollectRptService.a(this.a))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(QzoneOnlineTimeCollectRptService.a(this.a));
      this.a.c();
      QzoneOnlineTimeCollectRptService.b(this.a);
      LocalMultiProcConfig.putBool("key_sp_qzone_isforeground", false);
      QzoneOnlineTimeCollectRptService.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyp
 * JD-Core Version:    0.7.0.1
 */