package com.tencent.luggage.wxa.fv;

import com.tencent.luggage.wxa.dd.b.b;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxaapi.TdiAuthListener;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/tdi/LoginByWechatOpenSDKOauth$Companion;", "", "()V", "doLogin", "", "tdiAuthBuffer", "", "authListener", "Lcom/tencent/luggage/wxaapi/TdiAuthListener;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class f$a
{
  @JvmStatic
  public final void a(@NotNull byte[] paramArrayOfByte, @Nullable TdiAuthListener paramTdiAuthListener)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "tdiAuthBuffer");
    i.a.a((b.b)new f(paramArrayOfByte, paramTdiAuthListener, null), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.f.a
 * JD-Core Version:    0.7.0.1
 */