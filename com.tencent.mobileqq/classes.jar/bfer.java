import com.tencent.tissue.v8rt.engine.ILog;

public class bfer
  implements ILog
{
  String a = "MIV8RT";
  
  public int d(String paramString1, String paramString2)
  {
    betc.a(this.a + "/" + paramString1, paramString2, null);
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    betc.a(this.a + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    betc.d(this.a + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    betc.d(this.a + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    betc.b(this.a + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    betc.b(this.a + "/" + paramString1, paramString2, paramThrowable);
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
      betc.a(paramString1, paramString2);
    }
    for (;;)
    {
      if (paramInt >= 100) {}
      return;
      i = paramInt;
      break;
      label65:
      if (i == 3) {
        betc.b(paramString1, paramString2);
      } else if (i == 4) {
        betc.c(paramString1, paramString2);
      } else if (i == 5) {
        betc.d(paramString1, paramString2);
      }
    }
  }
  
  public int w(String paramString1, String paramString2)
  {
    betc.c(this.a + "/" + paramString1, paramString2);
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    betc.c(this.a + "/" + paramString1, paramString2, paramThrowable);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfer
 * JD-Core Version:    0.7.0.1
 */