package com.tencent.kwstudio.office.base;

public final class Log
{
  private static final String GLOBAL_TAG = "kwstudio_office";
  private static volatile ILog sLog;
  
  public static void d(String paramString)
  {
    d("kwstudio_office", paramString, null);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((2 >= getLogLevel()) && (sLog != null)) {
      sLog.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString, Throwable paramThrowable)
  {
    d("kwstudio_office", paramString, paramThrowable);
  }
  
  public static void e(String paramString)
  {
    e("kwstudio_office", paramString, null);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((5 >= getLogLevel()) && (sLog != null)) {
      sLog.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    e("kwstudio_office", paramString, paramThrowable);
  }
  
  public static int getLogLevel()
  {
    if (sLog != null) {
      return sLog.getLogLevel();
    }
    return 1;
  }
  
  public static void i(String paramString)
  {
    i("kwstudio_office", paramString, null);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, null);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((3 >= getLogLevel()) && (sLog != null)) {
      sLog.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString, Throwable paramThrowable)
  {
    i("kwstudio_office", paramString, paramThrowable);
  }
  
  public static void setLog(ILog paramILog)
  {
    sLog = paramILog;
  }
  
  public static void v(String paramString)
  {
    v("kwstudio_office", paramString, null);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    v(paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((1 >= getLogLevel()) && (sLog != null)) {
      sLog.v(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void v(String paramString, Throwable paramThrowable)
  {
    v("kwstudio_office", paramString, paramThrowable);
  }
  
  public static void w(String paramString)
  {
    w("kwstudio_office", paramString, null);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((4 >= getLogLevel()) && (sLog != null)) {
      sLog.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    w("kwstudio_office", paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.kwstudio.office.base.Log
 * JD-Core Version:    0.7.0.1
 */