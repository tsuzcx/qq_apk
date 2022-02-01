package com.tencent.logger;

import com.tencent.logger.log.ILog;
import com.tencent.logger.log.LogConfig;
import com.tencent.logger.log.LogLevel;
import com.tencent.logger.log.writer.LogWriter;
import com.tencent.logger.log.writer.WriteTask;
import com.tencent.logger.utils.LogUtils;
import java.io.File;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.Continuation<-Ljava.lang.Boolean;>;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/Logger;", "", "()V", "mLog", "Lcom/tencent/logger/log/ILog;", "mLogConfig", "Lcom/tencent/logger/log/LogConfig;", "mLogWriter", "Lcom/tencent/logger/log/writer/LogWriter;", "d", "", "tag", "", "msg", "args", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "throwable", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V", "e", "extractLog", "", "inputPath", "startSec", "", "endSec", "outputPath", "(Ljava/lang/String;JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findFile", "", "Ljava/io/File;", "date", "Ljava/util/Date;", "flush", "isSync", "getLogDir", "i", "init", "log", "logConfig", "isNeedLog", "curLogLevel", "Lcom/tencent/logger/log/LogLevel;", "configLogLevel", "level", "v", "w", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class Logger
{
  public static final Logger a = new Logger();
  private static ILog b;
  private static LogConfig c;
  private static LogWriter d;
  
  private final void a(LogLevel paramLogLevel, String paramString1, String paramString2)
  {
    Object localObject = c;
    if (localObject != null) {
      localObject = ((LogConfig)localObject).b();
    } else {
      localObject = null;
    }
    if (!a(paramLogLevel, (LogLevel)localObject)) {
      return;
    }
    localObject = d;
    if (localObject != null) {
      ((LogWriter)localObject).a((WriteTask)new Logger.log.1(paramLogLevel, paramString1, paramString2, paramString1, paramString2, LogUtils.a.a()));
    }
  }
  
  private final boolean a(LogLevel paramLogLevel1, LogLevel paramLogLevel2)
  {
    return (paramLogLevel2 != null) && (paramLogLevel1.compareTo((Enum)paramLogLevel2) >= 0);
  }
  
  @Nullable
  public final Object a(@NotNull String paramString1, long paramLong1, long paramLong2, @NotNull String paramString2, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    if ((paramContinuation instanceof Logger.extractLog.1))
    {
      localObject1 = (Logger.extractLog.1)paramContinuation;
      if ((((Logger.extractLog.1)localObject1).label & 0x80000000) != 0)
      {
        ((Logger.extractLog.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super Boolean>)localObject1;
        break label58;
      }
    }
    paramContinuation = new Logger.extractLog.1(this, paramContinuation);
    label58:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramString1 = (String)paramContinuation.L$2;
        paramLong1 = paramContinuation.J$1;
        paramLong1 = paramContinuation.J$0;
        paramString1 = (String)paramContinuation.L$1;
        paramString1 = (Logger)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
        paramString1 = (String)localObject1;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      localObject1 = b;
      if (localObject1 == null) {
        break label249;
      }
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramString1;
      paramContinuation.J$0 = paramLong1;
      paramContinuation.J$1 = paramLong2;
      paramContinuation.L$2 = paramString2;
      paramContinuation.label = 1;
      paramString2 = ((ILog)localObject1).a(paramString1, paramLong1, paramLong2, paramString2, paramContinuation);
      paramString1 = paramString2;
      if (paramString2 == localObject2) {
        return localObject2;
      }
    }
    paramString1 = (Boolean)paramString1;
    boolean bool;
    if (paramString1 != null) {
      bool = paramString1.booleanValue();
    } else {
      label249:
      bool = false;
    }
    return Boxing.boxBoolean(bool);
  }
  
  @NotNull
  public final String a()
  {
    Object localObject = b;
    if (localObject != null)
    {
      localObject = ((ILog)localObject).a();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  @NotNull
  public final List<File> a(@NotNull Date paramDate)
  {
    Intrinsics.checkParameterIsNotNull(paramDate, "date");
    ILog localILog = b;
    if (localILog != null)
    {
      paramDate = localILog.a(paramDate);
      if (paramDate != null) {
        return paramDate;
      }
    }
    return CollectionsKt.emptyList();
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    a(LogLevel.INFO, paramString1, paramString2);
  }
  
  public final void a(@NotNull String paramString, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tag");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "throwable");
    c(paramString, LogUtils.a.a(paramThrowable));
  }
  
  public final void a(boolean paramBoolean)
  {
    ILog localILog = b;
    if (localILog != null) {
      localILog.a(paramBoolean);
    }
  }
  
  public final void b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    a(LogLevel.DEBUG, paramString1, paramString2);
  }
  
  public final void c(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    a(LogLevel.ERROR, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.Logger
 * JD-Core Version:    0.7.0.1
 */