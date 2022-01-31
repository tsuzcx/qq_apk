import android.util.Printer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneThreadMonitor;

public class amkf
  implements Printer
{
  public amkf(QzoneThreadMonitor paramQzoneThreadMonitor) {}
  
  public void println(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneThreadMonitor", 4, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkf
 * JD-Core Version:    0.7.0.1
 */