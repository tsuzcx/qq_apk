import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.QZoneVideoDownloadActivity;

public class amci
  implements Runnable
{
  public amci(QZoneVideoDownloadActivity paramQZoneVideoDownloadActivity) {}
  
  public void run()
  {
    QQToast.a(this.a.getApplicationContext(), "网络已断,请连接网络后继续下载", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amci
 * JD-Core Version:    0.7.0.1
 */