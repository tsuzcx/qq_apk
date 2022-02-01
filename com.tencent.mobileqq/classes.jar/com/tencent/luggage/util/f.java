package com.tencent.luggage.util;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/util/CronetEx;", "", "()V", "TAG", "", "send", "", "url", "savePath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class f
{
  public static final f a = new f();
  
  @Nullable
  public final Object a(@NotNull String paramString1, @NotNull String paramString2, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    CancellableContinuationImpl localCancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    CancellableContinuation localCancellableContinuation = (CancellableContinuation)localCancellableContinuationImpl;
    CronetLogic.startCronetDownloadTask(e.a.a(paramString1, paramString2), (CronetLogic.CronetTaskCallback)new f.a(localCancellableContinuation, paramString1, paramString2));
    paramString1 = localCancellableContinuationImpl.getResult();
    if (paramString1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.f
 * JD-Core Version:    0.7.0.1
 */