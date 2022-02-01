package com.tencent.luggage.wxa.fq;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"waitForQRCodeHandler", "", "context", "Landroid/content/Context;", "codeData", "", "codeType", "", "codeVersion", "hostExtraData", "", "invokeTimestampNs", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/luggage/wxaapi/internal/DemoScan$QRCodeHandleResult;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.wxaapi.internal.DemoScan", f="DemoScan.kt", i={0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l={88, 236}, m="waitForQRCodeHandler", n={"this", "context", "codeData", "codeType", "codeVersion", "hostExtraData", "invokeTimestampNs", "this", "context", "codeData", "codeType", "codeVersion", "hostExtraData", "invokeTimestampNs", "a8keyResponse"}, s={"L$0", "L$1", "L$2", "I$0", "I$1", "L$3", "J$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$3", "J$0", "L$4"})
final class b$e
  extends ContinuationImpl
{
  int b;
  Object d;
  Object e;
  Object f;
  Object g;
  Object h;
  int i;
  int j;
  long k;
  
  b$e(b paramb, Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.a = paramObject;
    this.b |= 0x80000000;
    return this.c.a(null, null, 0, 0, null, 0L, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.b.e
 * JD-Core Version:    0.7.0.1
 */