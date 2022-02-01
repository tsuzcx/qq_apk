package com.tencent.mars.xlog;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mars/xlog/Xlog;", "", "()V", "<set-?>", "", "logLevel", "logLevel$annotations", "getLogLevel", "()I", "setLogLevel", "(I)V", "appenderClose", "", "appenderFlush", "isSync", "", "appenderOpen", "logConfig", "Lcom/tencent/mars/xlog/Xlog$XLogConfig;", "getPeriodLogs", "logPrefix", "", "startSec", "", "endSec", "tmpLogPath", "init", "isLoadLib", "logD", "tag", "filename", "funcname", "line", "pid", "tid", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "logWrite", "logInfo", "Lcom/tencent/mars/xlog/Xlog$XLoggerInfo;", "logWrite2", "level", "setAppenderMode", "mode", "setConsoleLogOpen", "isOpen", "setErrLogOpen", "setMaxAliveTime", "duration", "setMaxFileSize", "size", "XLogConfig", "XLoggerInfo", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class Xlog
{
  public static final Xlog INSTANCE = new Xlog();
  private static int logLevel;
  
  @JvmStatic
  public static final native void appenderClose();
  
  @JvmStatic
  public static final native void appenderFlush(boolean paramBoolean);
  
  @JvmStatic
  public static final native void appenderOpen(@NotNull Xlog.XLogConfig paramXLogConfig);
  
  public static final native int getLogLevel();
  
  @JvmStatic
  public static final native boolean getPeriodLogs(@NotNull String paramString1, long paramLong1, long paramLong2, @Nullable String paramString2);
  
  @JvmStatic
  public static final native void logWrite(@NotNull Xlog.XLoggerInfo paramXLoggerInfo, @NotNull String paramString);
  
  @JvmStatic
  public static final native void logWrite2(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt2, int paramInt3, long paramLong1, long paramLong2, @NotNull String paramString4);
  
  @JvmStatic
  public static final native void setAppenderMode(int paramInt);
  
  @JvmStatic
  public static final native void setConsoleLogOpen(boolean paramBoolean);
  
  @JvmStatic
  public static final native void setErrLogOpen(boolean paramBoolean);
  
  public static final native void setLogLevel(int paramInt);
  
  @JvmStatic
  public static final native void setMaxAliveTime(long paramLong);
  
  @JvmStatic
  public static final native void setMaxFileSize(long paramLong);
  
  public final void init(boolean paramBoolean, @NotNull Xlog.XLogConfig paramXLogConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramXLogConfig, "logConfig");
    if (paramBoolean)
    {
      System.loadLibrary("c++_shared");
      System.loadLibrary("marsxlog");
    }
    appenderOpen(paramXLogConfig);
  }
  
  public final void logD(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "filename");
    Intrinsics.checkParameterIsNotNull(paramString3, "funcname");
    Intrinsics.checkParameterIsNotNull(paramString4, "log");
    logWrite2(1, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
  }
  
  public final void logE(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "filename");
    Intrinsics.checkParameterIsNotNull(paramString3, "funcname");
    Intrinsics.checkParameterIsNotNull(paramString4, "log");
    logWrite2(4, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
  }
  
  public final void logF(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "filename");
    Intrinsics.checkParameterIsNotNull(paramString3, "funcname");
    Intrinsics.checkParameterIsNotNull(paramString4, "log");
    logWrite2(5, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
  }
  
  public final void logI(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "filename");
    Intrinsics.checkParameterIsNotNull(paramString3, "funcname");
    Intrinsics.checkParameterIsNotNull(paramString4, "log");
    logWrite2(2, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
  }
  
  public final void logV(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "filename");
    Intrinsics.checkParameterIsNotNull(paramString3, "funcname");
    Intrinsics.checkParameterIsNotNull(paramString4, "log");
    logWrite2(0, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
  }
  
  public final void logW(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "filename");
    Intrinsics.checkParameterIsNotNull(paramString3, "funcname");
    Intrinsics.checkParameterIsNotNull(paramString4, "log");
    logWrite2(3, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.xlog.Xlog
 * JD-Core Version:    0.7.0.1
 */