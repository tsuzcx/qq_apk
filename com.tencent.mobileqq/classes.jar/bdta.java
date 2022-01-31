import com.tencent.qg.sdk.log.IQLog;

public class bdta
  implements IQLog
{
  private static String a(String paramString, Object... paramVarArgs)
  {
    return String.format(null, paramString, paramVarArgs);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ved.c(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ved.b(paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    ved.b(paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ved.a(paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ved.b(paramString1, a(paramString2, paramVarArgs));
  }
  
  public void e(String paramString1, String paramString2)
  {
    ved.e(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ved.c(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    ved.c(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ved.b(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ved.c(paramString1, a(paramString2, paramVarArgs));
  }
  
  public void v(String paramString1, String paramString2)
  {
    ved.a(paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ved.a(paramString1, paramString2, new Object[] { paramThrowable });
  }
  
  public void w(String paramString1, String paramString2)
  {
    ved.c(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ved.b(paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ved.d(paramString1, a(paramString2, paramVarArgs));
  }
  
  public void w(String paramString, Throwable paramThrowable)
  {
    ved.b(paramString, "", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdta
 * JD-Core Version:    0.7.0.1
 */