package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxaapi.TdiAuthListener;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/WxaApiImpl$AuthCallbackHolder;", "", "tdiAuthListener", "Lcom/tencent/luggage/wxaapi/TdiAuthListener;", "handler", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "(Lcom/tencent/luggage/wxaapi/TdiAuthListener;Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;)V", "getHandler", "()Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "getTdiAuthListener", "()Lcom/tencent/luggage/wxaapi/TdiAuthListener;", "component1", "component2", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
final class g$a
{
  @Nullable
  private final TdiAuthListener a;
  @Nullable
  private final IWXAPIEventHandler b;
  
  public g$a(@Nullable TdiAuthListener paramTdiAuthListener, @Nullable IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    this.a = paramTdiAuthListener;
    this.b = paramIWXAPIEventHandler;
  }
  
  @Nullable
  public final TdiAuthListener a()
  {
    return this.a;
  }
  
  @Nullable
  public final IWXAPIEventHandler b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.a
 * JD-Core Version:    0.7.0.1
 */