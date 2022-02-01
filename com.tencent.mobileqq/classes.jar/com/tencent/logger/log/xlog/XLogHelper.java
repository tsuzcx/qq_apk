package com.tencent.logger.log.xlog;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/log/xlog/XLogHelper;", "", "()V", "LOG_CACHE_DIR", "", "LOG_DIR", "getCacheDir", "rootDir", "getLogDir", "toXLogConfig", "Lcom/tencent/mars/xlog/Xlog$XLogConfig;", "logConfig", "Lcom/tencent/logger/log/LogConfig;", "toXLogLevel", "", "logLevel", "Lcom/tencent/logger/log/LogLevel;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class XLogHelper
{
  public static final XLogHelper a = new XLogHelper();
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rootDir");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("logs");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.log.xlog.XLogHelper
 * JD-Core Version:    0.7.0.1
 */