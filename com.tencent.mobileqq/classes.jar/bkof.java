import java.util.concurrent.ConcurrentHashMap;

public class bkof
  implements com.tencent.oskplayer.util.QLog
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
    if (com.tencent.qphone.base.util.QLog.isDevelopLevel()) {
      com.tencent.qphone.base.util.QLog.d(a(paramString1), 4, paramString2);
    }
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (com.tencent.qphone.base.util.QLog.isDevelopLevel()) {
      com.tencent.qphone.base.util.QLog.d(a(paramString1), 4, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    com.tencent.qphone.base.util.QLog.e(a(paramString1), 1, paramString2);
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    com.tencent.qphone.base.util.QLog.e(a(paramString1), 1, paramString2, paramThrowable);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    com.tencent.qphone.base.util.QLog.i(a(paramString1), 1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    com.tencent.qphone.base.util.QLog.i(a(paramString1), 1, paramString2, paramThrowable);
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i(a(paramString1), 2, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i(a(paramString1), 2, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    com.tencent.qphone.base.util.QLog.w(a(paramString1), 1, paramString2);
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    com.tencent.qphone.base.util.QLog.w(a(paramString1), 1, paramString2, paramThrowable);
    return 0;
  }
  
  public int w(String paramString, Throwable paramThrowable)
  {
    com.tencent.qphone.base.util.QLog.w(a(paramString), 1, paramThrowable.getMessage());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkof
 * JD-Core Version:    0.7.0.1
 */