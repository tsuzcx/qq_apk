import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import mqq.os.MqqHandler;

public class amil
  implements Runnable
{
  public amil(QzoneOnlineTimeCollectRptService paramQzoneOnlineTimeCollectRptService) {}
  
  public void run()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(QzoneOnlineTimeCollectRptService.a(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("QzoneOnlineTimeCollectRptService", 2, "mOnlineTimeCheckTraceRunnable run");
    }
    this.a.d();
    ThreadManager.getSubThreadHandler().postDelayed(this, QzoneOnlineTimeCollectRptService.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amil
 * JD-Core Version:    0.7.0.1
 */