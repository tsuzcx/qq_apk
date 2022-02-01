package com.tencent.logger.log;

import java.io.File;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/log/ILog;", "", "extractLog", "", "inputLogPath", "", "startSec", "", "endSec", "outputLogPath", "(Ljava/lang/String;JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLogFile", "", "Ljava/io/File;", "date", "Ljava/util/Date;", "flush", "", "isSync", "getLogDir", "init", "config", "Lcom/tencent/logger/log/LogConfig;", "log", "level", "Lcom/tencent/logger/log/LogLevel;", "tag", "msg", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ILog
{
  @Nullable
  public abstract Object a(@NotNull String paramString1, long paramLong1, long paramLong2, @NotNull String paramString2, @NotNull Continuation<? super Boolean> paramContinuation);
  
  @NotNull
  public abstract String a();
  
  @NotNull
  public abstract List<File> a(@NotNull Date paramDate);
  
  public abstract void a(@NotNull LogLevel paramLogLevel, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void a(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.log.ILog
 * JD-Core Version:    0.7.0.1
 */