package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core", "com/tencent/luggage/launch/SubProcessLaunchWxaApp$callSuspended$2$1$invokeSuspend$$inlined$CoroutineExceptionHandler$1"}, k=1, mv={1, 1, 16})
public final class j$c$1
  extends AbstractCoroutineContextElement
  implements CoroutineExceptionHandler
{
  public j$c$1(CoroutineContext.Key paramKey, j.c paramc)
  {
    super(paramKey);
  }
  
  public void handleException(@NotNull CoroutineContext paramCoroutineContext, @NotNull Throwable paramThrowable)
  {
    j.a();
    paramCoroutineContext = new StringBuilder();
    paramCoroutineContext.append("getLaunchPBFromCGI async, get co exception:");
    paramCoroutineContext.append(paramThrowable);
    paramCoroutineContext.append(", instanceId:");
    paramCoroutineContext.append(this.a.d);
    o.b("Luggage.WXA.SubProcessLaunchWxaApp", paramCoroutineContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.j.c.1
 * JD-Core Version:    0.7.0.1
 */