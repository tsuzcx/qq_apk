import com.tencent.oskplayer.util.QLog;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.concurrent.ConcurrentHashMap;

public class bhiv
  implements QLog
{
  private static ConcurrentHashMap<String, String> a;
  
  private static String a(String paramString)
  {
    if (a == null) {
      a = new ConcurrentHashMap();
    }
    if (!a.containsKey(paramString)) {
      a.put(paramString, "VIDEO_LOG/" + paramString);
    }
    return (String)a.get(paramString);
  }
  
  public int d(String paramString1, String paramString2)
  {
    QMLog.d(a(paramString1), paramString2);
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QMLog.d(a(paramString1), paramString2, paramThrowable);
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    QMLog.e(a(paramString1), paramString2);
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QMLog.e(a(paramString1), paramString2, paramThrowable);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    QMLog.i(a(paramString1), paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QMLog.i(a(paramString1), paramString2, paramThrowable);
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (QMLog.isColorLevel()) {
      QMLog.i(a(paramString1), paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QMLog.isColorLevel()) {
      QMLog.i(a(paramString1), paramString2, paramThrowable);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    QMLog.w(a(paramString1), paramString2);
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QMLog.w(a(paramString1), paramString2, paramThrowable);
    return 0;
  }
  
  public int w(String paramString, Throwable paramThrowable)
  {
    QMLog.w(a(paramString), paramThrowable.getMessage());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhiv
 * JD-Core Version:    0.7.0.1
 */