package com.tencent.logger;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"extractLog", "", "inputPath", "", "startSec", "", "endSec", "outputPath", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.logger.Logger", f="Logger.kt", i={0, 0, 0, 0, 0}, l={39}, m="extractLog", n={"this", "inputPath", "startSec", "endSec", "outputPath"}, s={"L$0", "L$1", "J$0", "J$1", "L$2"})
final class Logger$extractLog$1
  extends ContinuationImpl
{
  long J$0;
  long J$1;
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  
  Logger$extractLog$1(Logger paramLogger, Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.result = paramObject;
    this.label |= 0x80000000;
    return this.this$0.a(null, 0L, 0L, null, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.Logger.extractLog.1
 * JD-Core Version:    0.7.0.1
 */