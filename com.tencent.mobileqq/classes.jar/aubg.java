import com.tencent.kwstudio.office.base.ILog;
import com.tencent.qphone.base.util.QLog;

public final class aubg
  implements ILog
{
  public void d(String paramString1, String paramString2)
  {
    QLog.d("TdsReaderView_" + paramString1, 2, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.d("TdsReaderView_" + paramString1, 2, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e("TdsReaderView_" + paramString1, 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e("TdsReaderView_" + paramString1, 1, paramString2, paramThrowable);
  }
  
  public int getLogLevel()
  {
    return 1;
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i("TdsReaderView_" + paramString1, 2, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i("TdsReaderView_" + paramString1, 2, paramString2, paramThrowable);
  }
  
  public void v(String paramString1, String paramString2)
  {
    QLog.i("TdsReaderView_" + paramString1, 2, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i("TdsReaderView_" + paramString1, 2, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    QLog.w("TdsReaderView_" + paramString1, 1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.w("TdsReaderView_" + paramString1, 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubg
 * JD-Core Version:    0.7.0.1
 */