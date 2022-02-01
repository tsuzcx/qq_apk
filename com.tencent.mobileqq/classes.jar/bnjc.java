import android.util.Printer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneThreadMonitor;

public class bnjc
  implements Printer
{
  public bnjc(QzoneThreadMonitor paramQzoneThreadMonitor) {}
  
  public void println(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneThreadMonitor", 4, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjc
 * JD-Core Version:    0.7.0.1
 */