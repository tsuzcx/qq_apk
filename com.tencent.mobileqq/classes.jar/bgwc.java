import android.os.Process;
import com.tencent.mobileqq.triton.sdk.ITLog;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;

public class bgwc
  implements ITLog
{
  private static bgwc jdField_a_of_type_Bgwc;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "log", "info", "warn", "error" };
  
  public static bgwc a()
  {
    if (jdField_a_of_type_Bgwc == null) {}
    try
    {
      jdField_a_of_type_Bgwc = new bgwc();
      return jdField_a_of_type_Bgwc;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    bgwh localbgwh = bgwk.a().a(Process.myPid());
    if (localbgwh != null) {
      localbgwh.a("error", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bgwh localbgwh = bgwk.a().a(Process.myPid());
    if (localbgwh != null) {
      localbgwh.a(paramString1, paramString2);
    }
  }
  
  private boolean a()
  {
    return GameWnsUtils.gameEnableLog();
  }
  
  public int d(String paramString1, String paramString2)
  {
    if (a()) {
      QMLog.i("[minigame] " + paramString1, paramString2);
    }
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a()) {
      QMLog.i("[minigame] " + paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    if (a()) {
      QMLog.e("[minigame] " + paramString1, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a()) {
      QMLog.e("[minigame] " + paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (a()) {
      QMLog.i("[minigame] " + paramString1, paramString2);
    }
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a()) {
      QMLog.i("[minigame] " + paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public void printNativeLog(int paramInt, String paramString1, String paramString2)
  {
    if (a() == null)
    {
      QMLog.i("[minigame] ", "g_printNativeLog getLog null");
      QMLog.i("[minigame] " + paramString1, paramString2);
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
      QMLog.w("[minigame] " + paramString1, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a()) {
      QMLog.w("[minigame] " + paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwc
 * JD-Core Version:    0.7.0.1
 */