package com.tencent.feedback.eup.jni;

import com.tencent.bugly.proguard.x;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeExceptionUpload
{
  public static final int ANDROID_LOG_DEBUG = 3;
  public static final int ANDROID_LOG_ERROR = 6;
  public static final int ANDROID_LOG_INFO = 4;
  public static final int ANDROID_LOG_WARN = 5;
  public static final int JAR_JNI_VERSION = 1;
  private static NativeExceptionHandler a = null;
  public static AtomicBoolean isEnable = new AtomicBoolean(true);
  
  public static native boolean appendNativeLog(String paramString1, String paramString2, String paramString3);
  
  public static native boolean appendWholeNativeLog(String paramString);
  
  public static boolean checkExtraJni(String paramString)
  {
    x.c("Check extra jni for RQD NDK: %s", new Object[] { paramString });
    String str2 = "nativeRqd.2.1.0".replace("nativeRqd.", "").replace(".", "");
    String str1 = paramString.replace("nativeRqd.", "").replace(".", "");
    if (str1.length() == 2)
    {
      paramString = new StringBuilder();
      paramString.append(str1);
      paramString.append("0");
      paramString = paramString.toString();
    }
    else
    {
      paramString = str1;
      if (str1.length() == 1)
      {
        paramString = new StringBuilder();
        paramString.append(str1);
        paramString.append("00");
        paramString = paramString.toString();
      }
    }
    try
    {
      if (Integer.parseInt(paramString) >= Integer.parseInt(str2))
      {
        x.a("Extra RQD JNI can be accessed.", new Object[0]);
        return true;
      }
    }
    catch (Throwable paramString)
    {
      if (!x.a(paramString)) {
        paramString.printStackTrace();
      }
      x.d("Extra RQD JNI can not be accessed.", new Object[0]);
    }
    return false;
  }
  
  public static native void doNativeCrashForTest();
  
  public static native void enableHandler(boolean paramBoolean);
  
  public static native String getNativeKeyValueList();
  
  public static native String getNativeLog();
  
  public static NativeExceptionHandler getmHandler()
  {
    try
    {
      NativeExceptionHandler localNativeExceptionHandler = a;
      return localNativeExceptionHandler;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static native boolean putNativeKeyValue(String paramString1, String paramString2);
  
  public static native boolean registNativeExceptionHandler(String paramString1, String paramString2, int paramInt);
  
  public static native String registNativeExceptionHandler2(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public static native String removeNativeKeyValue(String paramString);
  
  public static native void setLogMode(int paramInt);
  
  public static void setmHandler(NativeExceptionHandler paramNativeExceptionHandler)
  {
    try
    {
      a = paramNativeExceptionHandler;
      return;
    }
    finally
    {
      paramNativeExceptionHandler = finally;
      throw paramNativeExceptionHandler;
    }
  }
  
  public static void testNativeCrash()
  {
    x.a("rqdp{ test native crash}", new Object[0]);
    doNativeCrashForTest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.feedback.eup.jni.NativeExceptionUpload
 * JD-Core Version:    0.7.0.1
 */