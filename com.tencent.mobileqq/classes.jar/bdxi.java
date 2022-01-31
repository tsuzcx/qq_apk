import com.tencent.tissue.v8rt.engine.ILog;

public class bdxi
  implements ILog
{
  String a = "MIV8RT";
  
  public int d(String paramString1, String paramString2)
  {
    bdnw.a(this.a + "/" + paramString1, paramString2, null);
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    bdnw.a(this.a + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    bdnw.d(this.a + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    bdnw.d(this.a + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    bdnw.b(this.a + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    bdnw.b(this.a + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
  
  public void printNativeLog(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = this.a + "/" + paramString1;
    int i;
    if (paramInt >= 100)
    {
      i = paramInt - 100 + 2;
      if (i > 2) {
        break label65;
      }
      bdnw.a(paramString1, paramString2);
    }
    for (;;)
    {
      if (paramInt >= 100) {}
      return;
      i = paramInt;
      break;
      label65:
      if (i == 3) {
        bdnw.b(paramString1, paramString2);
      } else if (i == 4) {
        bdnw.c(paramString1, paramString2);
      } else if (i == 5) {
        bdnw.d(paramString1, paramString2);
      }
    }
  }
  
  public int w(String paramString1, String paramString2)
  {
    bdnw.c(this.a + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    bdnw.c(this.a + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdxi
 * JD-Core Version:    0.7.0.1
 */