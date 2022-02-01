import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.IVasLog;

public class bieb
  implements IVasLog
{
  public void d(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i(paramString1, 1, paramString2, paramThrowable);
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public boolean isDebugVersion()
  {
    return false;
  }
  
  public void v(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.w(paramString1, 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bieb
 * JD-Core Version:    0.7.0.1
 */