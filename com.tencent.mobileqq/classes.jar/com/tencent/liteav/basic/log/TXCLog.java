package com.tencent.liteav.basic.log;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class TXCLog
{
  public static final int LOG_ASYNC = 0;
  public static final int LOG_DEBUG = 1;
  public static final int LOG_ERROR = 4;
  public static final int LOG_FATAL = 5;
  public static final int LOG_INFO = 2;
  public static final int LOG_NONE = 6;
  public static final int LOG_SYNC = 1;
  public static final int LOG_VERBOSE = 0;
  public static final int LOG_WARNING = 3;
  private static boolean mEnableCallback = false;
  private static boolean mEnableCompress = true;
  private static boolean mEnableConsole = false;
  private static boolean mHasInit = false;
  private static TXCLog.a mListener;
  private static String mLogCacheDir = "";
  public static String mLogDir = "";
  private static int mLogLevel;
  private static final Object mLogLock = new Object();
  
  static
  {
    mHasInit = false;
    mListener = null;
    mLogLevel = 0;
    mEnableConsole = true;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    log(1, paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    log(1, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void e(String paramString1, String paramString2)
  {
    log(4, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    for (paramThrowable = paramThrowable.getCause(); paramThrowable != null; paramThrowable = paramThrowable.getCause()) {
      paramThrowable.printStackTrace(localPrintWriter);
    }
    localPrintWriter.close();
    paramThrowable = new StringBuilder();
    paramThrowable.append(paramString2);
    paramThrowable.append("\n");
    paramThrowable.append(localStringWriter.toString());
    e(paramString1, paramThrowable.toString());
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    log(4, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void i(String paramString1, String paramString2)
  {
    log(2, paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    log(2, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static boolean init()
  {
    if (mHasInit) {
      return true;
    }
    synchronized (mLogLock)
    {
      if (mHasInit) {
        return true;
      }
      boolean bool = f.f();
      Object localObject2 = TXCCommonUtil.getAppContext();
      if ((bool) && (localObject2 != null))
      {
        if (TextUtils.isEmpty(mLogDir))
        {
          localObject4 = ((Context)localObject2).getExternalFilesDir(null);
          if (localObject4 != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((File)localObject4).getAbsolutePath());
            localStringBuilder.append("/log/tencent/liteav");
            mLogDir = localStringBuilder.toString();
          }
        }
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((Context)localObject2).getFilesDir().getAbsolutePath());
        ((StringBuilder)localObject4).append("/log/tencent/liteav");
        mLogCacheDir = ((StringBuilder)localObject4).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("TXCLog init log file path : ");
        ((StringBuilder)localObject2).append(mLogDir);
        ((StringBuilder)localObject2).append(", cache : ");
        ((StringBuilder)localObject2).append(mLogCacheDir);
        Log.i("TXCLog", ((StringBuilder)localObject2).toString());
        nativeLogInit();
        nativeLogSetLevel(mLogLevel);
        nativeLogSetConsole(mEnableConsole);
        nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
        nativeEnableCallback(mEnableCallback);
        mHasInit = true;
      }
      return mHasInit;
    }
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    if (init()) {
      nativeLog(paramInt, paramString1, "", 0, "", paramString2);
    }
    log_callback(paramInt, paramString1, paramString2);
  }
  
  private static void log_callback(int paramInt, String paramString1, String paramString2)
  {
    TXCLog.a locala = mListener;
    if (locala != null) {
      locala.a(paramInt, paramString1, paramString2);
    }
  }
  
  private static native void nativeEnableCallback(boolean paramBoolean);
  
  private static native void nativeLog(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4);
  
  private static native void nativeLogClose();
  
  private static native void nativeLogInit();
  
  private static native void nativeLogOpen(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  private static native void nativeLogSetConsole(boolean paramBoolean);
  
  private static native void nativeLogSetLevel(int paramInt);
  
  public static void setConsoleEnabled(boolean paramBoolean)
  {
    mEnableConsole = paramBoolean;
    if (mHasInit) {
      nativeLogSetConsole(mEnableConsole);
    }
  }
  
  public static void setLevel(int paramInt)
  {
    mLogLevel = paramInt;
    if (mHasInit) {
      nativeLogSetLevel(mLogLevel);
    }
  }
  
  public static void setListener(TXCLog.a parama)
  {
    mListener = parama;
    boolean bool;
    if (mListener != null) {
      bool = true;
    } else {
      bool = false;
    }
    mEnableCallback = bool;
    if (mHasInit) {
      nativeEnableCallback(mEnableCallback);
    }
  }
  
  public static void setLogCompressEnabled(boolean paramBoolean)
  {
    if (mEnableCompress != paramBoolean)
    {
      mEnableCompress = paramBoolean;
      if (mHasInit)
      {
        nativeLogClose();
        nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
      }
    }
  }
  
  public static void setLogDirPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!paramString.equalsIgnoreCase(mLogDir))
    {
      mLogDir = paramString;
      if (mHasInit)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TXCLog setLogDirPath ");
        localStringBuilder.append(paramString);
        Log.i("TXCLog", localStringBuilder.toString());
        nativeLogClose();
        nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
      }
    }
  }
  
  public static void sliceLogFile()
  {
    if (mHasInit)
    {
      Log.i("TXCLog", "TXCLog sliceLogFile");
      nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    log(0, paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    log(0, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void w(String paramString1, String paramString2)
  {
    log(3, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    log(3, paramString1, String.format(paramString2, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.log.TXCLog
 * JD-Core Version:    0.7.0.1
 */