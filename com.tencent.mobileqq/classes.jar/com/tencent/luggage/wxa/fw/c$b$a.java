package com.tencent.luggage.wxa.fw;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class c$b$a
  extends AbstractCoroutineContextElement
  implements CoroutineExceptionHandler
{
  public c$b$a(CoroutineContext.Key paramKey, c.b paramb)
  {
    super(paramKey);
  }
  
  public void handleException(@NotNull CoroutineContext paramCoroutineContext, @NotNull Throwable paramThrowable)
  {
    paramCoroutineContext = new StringBuilder();
    paramCoroutineContext.append("CoroutineExceptionHandler | exception:");
    paramCoroutineContext.append(paramThrowable);
    o.b("Luggage.WxaRuntimePkgDownloader|runProfiled", paramCoroutineContext.toString());
    paramCoroutineContext = this.a.d;
    if (paramCoroutineContext != null) {
      paramCoroutineContext.a(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fw.c.b.a
 * JD-Core Version:    0.7.0.1
 */