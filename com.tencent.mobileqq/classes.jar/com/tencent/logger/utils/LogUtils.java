package com.tencent.logger.utils;

import android.util.Log;
import com.tencent.logger.Logger;
import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.Continuation<-Ljava.lang.Boolean;>;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/utils/LogUtils;", "", "()V", "LOG_TMP_FILE_PREFIX", "", "TAG", "appendArgsAndThrowableToMsg", "msg", "throwable", "", "args", "", "appendArgsAndThrowableToMsg$qq_wink_impl_release", "(Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)Ljava/lang/String;", "appendArgsToMsg", "appendArgsToMsg$qq_wink_impl_release", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "appendThrowableToMsg", "appendThrowableToMsg$qq_wink_impl_release", "extractLog", "", "Ljava/io/File;", "date", "Ljava/util/Date;", "startSec", "", "endSec", "(Ljava/util/Date;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentThreadInfo", "getCurrentThreadInfo$qq_wink_impl_release", "getLogZipFile", "", "outputPath", "(Ljava/util/Date;Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "throwableToString", "throwableToString$qq_wink_impl_release", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class LogUtils
{
  public static final LogUtils a = new LogUtils();
  
  @Nullable
  public final Object a(@NotNull Date paramDate, @NotNull String paramString, long paramLong1, long paramLong2, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    if ((paramContinuation instanceof LogUtils.getLogZipFile.1))
    {
      localObject1 = (LogUtils.getLogZipFile.1)paramContinuation;
      if ((((LogUtils.getLogZipFile.1)localObject1).label & 0x80000000) != 0)
      {
        ((LogUtils.getLogZipFile.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super Boolean>)localObject1;
        break label58;
      }
    }
    paramContinuation = new LogUtils.getLogZipFile.1(this, paramContinuation);
    label58:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramLong1 = paramContinuation.J$1;
        paramLong1 = paramContinuation.J$0;
        paramString = (String)paramContinuation.L$2;
        paramDate = (Date)paramContinuation.L$1;
        paramDate = (LogUtils)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
        paramDate = (Date)localObject1;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      Logger.a.a(true);
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramDate;
      paramContinuation.L$2 = paramString;
      paramContinuation.J$0 = paramLong1;
      paramContinuation.J$1 = paramLong2;
      paramContinuation.label = 1;
      paramContinuation = a(paramDate, paramLong1, paramLong2, paramContinuation);
      paramDate = paramContinuation;
      if (paramContinuation == localObject2) {
        return localObject2;
      }
    }
    paramContinuation = (List)paramDate;
    if (paramContinuation.isEmpty())
    {
      Logger.a.a("LogUtils", "[getLogZipFile] logFileList is empty!");
      return Boxing.boxBoolean(false);
    }
    paramDate = FileUtils.a;
    localObject1 = ((Collection)paramContinuation).toArray(new File[0]);
    if (localObject1 != null)
    {
      paramDate = Boxing.boxBoolean(paramDate.a((File[])localObject1, new File(paramString)));
      paramDate.booleanValue();
      paramString = ((Iterable)paramContinuation).iterator();
      while (paramString.hasNext())
      {
        localObject1 = (File)paramString.next();
        paramContinuation = FileUtils.a;
        localObject1 = ((File)localObject1).getPath();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "it.path");
        paramContinuation.a((String)localObject1);
      }
      return paramDate;
    }
    paramDate = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramDate;
    }
  }
  
  @NotNull
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Thread localThread = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
    localStringBuilder.append(localThread.getId());
    localStringBuilder.append("] ");
    localStringBuilder.append("[");
    localThread = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
    localStringBuilder.append(localThread.getName());
    localStringBuilder.append("] ");
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final String a(@NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "throwable");
    paramThrowable = Log.getStackTraceString(paramThrowable);
    Intrinsics.checkExpressionValueIsNotNull(paramThrowable, "Log.getStackTraceString(throwable)");
    return paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.utils.LogUtils
 * JD-Core Version:    0.7.0.1
 */