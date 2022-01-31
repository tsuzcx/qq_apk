import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.Logger;

public class bhnb
  implements Logger
{
  public void d(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 2, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 2, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 2, paramString2, paramThrowable);
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    QLog.e(paramString, 2, paramThrowable, new Object[0]);
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 2, paramString2);
  }
  
  public boolean isEnable()
  {
    return QLog.isColorLevel();
  }
  
  public void w(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhnb
 * JD-Core Version:    0.7.0.1
 */