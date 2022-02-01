package com.tencent.logger.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"extractLog", "", "date", "Ljava/util/Date;", "startSec", "", "endSec", "continuation", "Lkotlin/coroutines/Continuation;", "", "Ljava/io/File;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.logger.utils.LogUtils", f="LogUtils.kt", i={0, 0, 0, 0, 0, 0, 0, 0, 0}, l={61}, m="extractLog", n={"this", "date", "startSec", "endSec", "logFileList", "result", "logFile", "parentPathName", "tmpLogPath"}, s={"L$0", "L$1", "J$0", "J$1", "L$2", "L$3", "L$4", "L$6", "L$7"})
final class LogUtils$extractLog$1
  extends ContinuationImpl
{
  long J$0;
  long J$1;
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  Object L$6;
  Object L$7;
  int label;
  
  LogUtils$extractLog$1(LogUtils paramLogUtils, Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return this.this$0.a(null, 0L, 0L, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.utils.LogUtils.extractLog.1
 * JD-Core Version:    0.7.0.1
 */