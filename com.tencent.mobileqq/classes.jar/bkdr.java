import com.tencent.qphone.base.util.QLog;

public class bkdr
  extends bkdq
{
  public void a(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void b(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.w(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void c(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdr
 * JD-Core Version:    0.7.0.1
 */