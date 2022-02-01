import com.tencent.qg.sdk.log.IQLog;

public class bkfo
  implements IQLog
{
  private static String a(String paramString, Object... paramVarArgs)
  {
    return String.format(null, paramString, paramVarArgs);
  }
  
  public void a(String paramString1, String paramString2)
  {
    yuk.c(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    yuk.b(paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    yuk.b(paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    yuk.a(paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    yuk.b(paramString1, a(paramString2, paramVarArgs));
  }
  
  public void e(String paramString1, String paramString2)
  {
    yuk.e(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    yuk.c(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    yuk.c(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    yuk.b(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    yuk.c(paramString1, a(paramString2, paramVarArgs));
  }
  
  public void v(String paramString1, String paramString2)
  {
    yuk.a(paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    yuk.a(paramString1, paramString2, new Object[] { paramThrowable });
  }
  
  public void w(String paramString1, String paramString2)
  {
    yuk.c(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    yuk.b(paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    yuk.d(paramString1, a(paramString2, paramVarArgs));
  }
  
  public void w(String paramString, Throwable paramThrowable)
  {
    yuk.b(paramString, "", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfo
 * JD-Core Version:    0.7.0.1
 */