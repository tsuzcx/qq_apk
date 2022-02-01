package com.tencent.luggage.util;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hj.c;
import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.hu.d;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/util/PresentationActivityHelper$IPC_LuggageActivityHelpInvoker;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class PresentationActivityHelper$b
  implements c<Bundle, d>
{
  public void a(@NotNull Bundle paramBundle, @NotNull e<d> parame)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "data");
    Intrinsics.checkParameterIsNotNull(parame, "callback");
    parame = PresentationActivityHelper.Companion;
    int i = paramBundle.getInt("resultCode");
    Parcelable localParcelable = paramBundle.getParcelable("from");
    if (localParcelable != null)
    {
      parame.a(i, (Intent)localParcelable, (Intent)paramBundle.getParcelable("data"));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.content.Intent");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.PresentationActivityHelper.b
 * JD-Core Version:    0.7.0.1
 */