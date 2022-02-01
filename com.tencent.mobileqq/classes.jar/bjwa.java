import com.tencent.qg.sdk.log.IQLog;

public class bjwa
  implements IQLog
{
  private static String a(String paramString, Object... paramVarArgs)
  {
    return String.format(null, paramString, paramVarArgs);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ykq.c(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ykq.b(paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    ykq.b(paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ykq.a(paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ykq.b(paramString1, a(paramString2, paramVarArgs));
  }
  
  public void e(String paramString1, String paramString2)
  {
    ykq.e(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ykq.c(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    ykq.c(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ykq.b(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ykq.c(paramString1, a(paramString2, paramVarArgs));
  }
  
  public void v(String paramString1, String paramString2)
  {
    ykq.a(paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ykq.a(paramString1, paramString2, new Object[] { paramThrowable });
  }
  
  public void w(String paramString1, String paramString2)
  {
    ykq.c(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ykq.b(paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ykq.d(paramString1, a(paramString2, paramVarArgs));
  }
  
  public void w(String paramString, Throwable paramThrowable)
  {
    ykq.b(paramString, "", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwa
 * JD-Core Version:    0.7.0.1
 */