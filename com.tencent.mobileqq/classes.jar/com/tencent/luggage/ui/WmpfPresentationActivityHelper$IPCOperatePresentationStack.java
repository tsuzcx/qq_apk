package com.tencent.luggage.ui;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.hj.k;
import com.tencent.luggage.wxa.hu.b;
import com.tencent.luggage.wxa.qz.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WmpfPresentationActivityHelper$IPCOperatePresentationStack;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "()V", "invoke", "data", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
@Keep
public final class WmpfPresentationActivityHelper$IPCOperatePresentationStack
  implements k<Bundle, b>
{
  @NotNull
  public b invoke(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "data");
    t.a((Runnable)new WmpfPresentationActivityHelper.IPCOperatePresentationStack.a(paramBundle));
    return new b(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WmpfPresentationActivityHelper.IPCOperatePresentationStack
 * JD-Core Version:    0.7.0.1
 */