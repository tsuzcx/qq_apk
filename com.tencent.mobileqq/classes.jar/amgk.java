import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class amgk
  implements Runnable
{
  public amgk(QzoneModuleManager paramQzoneModuleManager) {}
  
  public void run()
  {
    int i = StatisticCollector.a();
    QLog.i("QzoneModuleManager", 1, "current versionNum is:" + i);
    StatisticCollector.a(i + 6000);
    QzoneModuleManager.access$102(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgk
 * JD-Core Version:    0.7.0.1
 */