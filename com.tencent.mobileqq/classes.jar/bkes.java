import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.Logger;

public class bkes
  implements Logger
{
  public void d(String paramString1, String paramString2)
  {
    bnzb.a(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    bnzb.d(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    bnzb.a(paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    bnzb.a(paramString, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    bnzb.b(paramString1, paramString2);
  }
  
  public boolean isEnable()
  {
    return QLog.isColorLevel();
  }
  
  public void w(String paramString1, String paramString2)
  {
    bnzb.c(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkes
 * JD-Core Version:    0.7.0.1
 */