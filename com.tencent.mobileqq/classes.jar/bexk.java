import android.os.Process;
import com.tencent.mobileqq.triton.sdk.ITLog;

public class bexk
  implements ITLog
{
  private static bexk jdField_a_of_type_Bexk;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "log", "info", "warn", "error" };
  
  public static bexk a()
  {
    if (jdField_a_of_type_Bexk == null) {}
    try
    {
      jdField_a_of_type_Bexk = new bexk();
      return jdField_a_of_type_Bexk;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    bexp localbexp = bexs.a().a(Process.myPid());
    if (localbexp != null) {
      localbexp.a("error", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bexp localbexp = bexs.a().a(Process.myPid());
    if (localbexp != null) {
      localbexp.a(paramString1, paramString2);
    }
  }
  
  private boolean a()
  {
    return bexm.a();
  }
  
  public int d(String paramString1, String paramString2)
  {
    if (a()) {
      betc.b("[minigame] " + paramString1, paramString2);
    }
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a()) {
      betc.b("[minigame] " + paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    if (a()) {
      betc.d("[minigame] " + paramString1, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a()) {
      betc.d("[minigame] " + paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (a()) {
      betc.b("[minigame] " + paramString1, paramString2);
    }
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a()) {
      betc.b("[minigame] " + paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public void printNativeLog(int paramInt, String paramString1, String paramString2)
  {
    if (a() == null)
    {
      betc.b("[minigame] ", "g_printNativeLog getLog null");
      betc.b("[minigame] " + paramString1, paramString2);
    }
    label154:
    for (;;)
    {
      return;
      int i;
      if (paramInt >= 100)
      {
        i = paramInt - 100 + 3;
        label51:
        if (i > 3) {
          break label101;
        }
        a().d(paramString1, paramString2);
      }
      for (;;)
      {
        if (paramInt < 100) {
          break label154;
        }
        paramInt -= 100;
        if (paramInt >= jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        a(jdField_a_of_type_ArrayOfJavaLangString[paramInt], paramString2);
        return;
        i = paramInt;
        break label51;
        label101:
        if (i == 4) {
          a().i(paramString1, paramString2);
        } else if (i == 5) {
          a().w(paramString1, paramString2);
        } else if (i == 6) {
          a().e(paramString1, paramString2);
        }
      }
    }
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (a()) {
      betc.c("[minigame] " + paramString1, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a()) {
      betc.c("[minigame] " + paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexk
 * JD-Core Version:    0.7.0.1
 */