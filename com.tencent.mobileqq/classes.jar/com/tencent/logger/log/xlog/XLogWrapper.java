package com.tencent.logger.log.xlog;

import android.os.Looper;
import android.os.Process;
import com.tencent.logger.Logger;
import com.tencent.logger.log.ILog;
import com.tencent.logger.log.LogConfig;
import com.tencent.logger.log.LogLevel;
import com.tencent.mars.xlog.Xlog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/log/xlog/XLogWrapper;", "Lcom/tencent/logger/log/ILog;", "()V", "mConfig", "Lcom/tencent/logger/log/LogConfig;", "extractLog", "", "inputLogPath", "", "startSec", "", "endSec", "outputLogPath", "(Ljava/lang/String;JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLogFile", "", "Ljava/io/File;", "date", "Ljava/util/Date;", "flush", "", "isSync", "getLogDir", "init", "config", "log", "level", "Lcom/tencent/logger/log/LogLevel;", "tag", "msg", "logD", "logE", "logF", "logI", "logV", "logW", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class XLogWrapper
  implements ILog
{
  public static final XLogWrapper.Companion a = new XLogWrapper.Companion(null);
  private LogConfig b;
  
  private final void a(String paramString1, String paramString2)
  {
    Xlog localXlog = Xlog.INSTANCE;
    int i = Process.myPid();
    Object localObject = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread()");
    long l = ((Thread)localObject).getId();
    localObject = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper()");
    localObject = ((Looper)localObject).getThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper().thread");
    localXlog.logV(paramString1, "", "", 0, i, l, ((Thread)localObject).getId(), paramString2);
  }
  
  private final void b(String paramString1, String paramString2)
  {
    Xlog localXlog = Xlog.INSTANCE;
    int i = Process.myPid();
    Object localObject = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread()");
    long l = ((Thread)localObject).getId();
    localObject = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper()");
    localObject = ((Looper)localObject).getThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper().thread");
    localXlog.logD(paramString1, "", "", 0, i, l, ((Thread)localObject).getId(), paramString2);
  }
  
  private final void c(String paramString1, String paramString2)
  {
    Xlog localXlog = Xlog.INSTANCE;
    int i = Process.myPid();
    Object localObject = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread()");
    long l = ((Thread)localObject).getId();
    localObject = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper()");
    localObject = ((Looper)localObject).getThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper().thread");
    localXlog.logI(paramString1, "", "", 0, i, l, ((Thread)localObject).getId(), paramString2);
  }
  
  private final void d(String paramString1, String paramString2)
  {
    Xlog localXlog = Xlog.INSTANCE;
    int i = Process.myPid();
    Object localObject = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread()");
    long l = ((Thread)localObject).getId();
    localObject = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper()");
    localObject = ((Looper)localObject).getThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper().thread");
    localXlog.logW(paramString1, "", "", 0, i, l, ((Thread)localObject).getId(), paramString2);
  }
  
  private final void e(String paramString1, String paramString2)
  {
    Xlog localXlog = Xlog.INSTANCE;
    int i = Process.myPid();
    Object localObject = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread()");
    long l = ((Thread)localObject).getId();
    localObject = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper()");
    localObject = ((Looper)localObject).getThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper().thread");
    localXlog.logE(paramString1, "", "", 0, i, l, ((Thread)localObject).getId(), paramString2);
  }
  
  private final void f(String paramString1, String paramString2)
  {
    Xlog localXlog = Xlog.INSTANCE;
    int i = Process.myPid();
    Object localObject = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread()");
    long l = ((Thread)localObject).getId();
    localObject = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper()");
    localObject = ((Looper)localObject).getThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Looper.getMainLooper().thread");
    localXlog.logF(paramString1, "", "", 0, i, l, ((Thread)localObject).getId(), paramString2);
  }
  
  @Nullable
  public Object a(@NotNull String paramString1, long paramLong1, long paramLong2, @NotNull String paramString2, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    return Boxing.boxBoolean(Xlog.getPeriodLogs(paramString1, paramLong1, paramLong2, paramString2));
  }
  
  @NotNull
  public String a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = XLogHelper.a.a(((LogConfig)localObject).a());
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  @NotNull
  public List<File> a(@NotNull Date paramDate)
  {
    Intrinsics.checkParameterIsNotNull(paramDate, "date");
    Object localObject1 = new File(Logger.a.a());
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      paramDate = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(paramDate);
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        Collection localCollection = (Collection)new ArrayList();
        int k = localObject1.length;
        int i = 0;
        while (i < k)
        {
          Object localObject2 = localObject1[i];
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
          Object localObject3 = localObject2.getName();
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.name");
          localObject3 = (CharSequence)localObject3;
          Intrinsics.checkExpressionValueIsNotNull(paramDate, "dateString");
          if (StringsKt.contains$default((CharSequence)localObject3, (CharSequence)paramDate, false, 2, null))
          {
            localObject3 = localObject2.getName();
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.name");
            if ((StringsKt.contains$default((CharSequence)localObject3, (CharSequence)".xlog", false, 2, null)) && (localObject2.isFile()))
            {
              j = 1;
              break label197;
            }
          }
          int j = 0;
          label197:
          if (j != 0) {
            localCollection.add(localObject2);
          }
          i += 1;
        }
        return (List)localCollection;
      }
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.emptyList();
  }
  
  public void a(@NotNull LogLevel paramLogLevel, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramLogLevel, "level");
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    switch (XLogWrapper.WhenMappings.$EnumSwitchMapping$0[paramLogLevel.ordinal()])
    {
    default: 
      return;
    case 6: 
      f(paramString1, paramString2);
      return;
    case 5: 
      e(paramString1, paramString2);
      return;
    case 4: 
      d(paramString1, paramString2);
      return;
    case 3: 
      c(paramString1, paramString2);
      return;
    case 2: 
      b(paramString1, paramString2);
      return;
    }
    a(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    Xlog.appenderFlush(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.log.xlog.XLogWrapper
 * JD-Core Version:    0.7.0.1
 */