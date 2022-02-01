import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.YtLogger.IYtLoggerListener;

class avpx
  implements YtLogger.IYtLoggerListener
{
  avpx(avpw paramavpw) {}
  
  public void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("youtu.log_" + paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpx
 * JD-Core Version:    0.7.0.1
 */