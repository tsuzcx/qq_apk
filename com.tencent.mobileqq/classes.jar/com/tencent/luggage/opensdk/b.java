package com.tencent.luggage.opensdk;

import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/EventOnReceivedWxaRedirectingPageResponse;", "Lcom/tencent/mm/sdk/event/IEvent;", "()V", "sdkRequest", "Lcom/tencent/luggage/opensdk/BridgedJsApiInvokeProtocol$Request;", "getSdkRequest", "()Lcom/tencent/luggage/opensdk/BridgedJsApiInvokeProtocol$Request;", "setSdkRequest", "(Lcom/tencent/luggage/opensdk/BridgedJsApiInvokeProtocol$Request;)V", "wxResponse", "Lcom/tencent/mm/opensdk/modelbiz/WXLaunchWxaRedirectingPage$Resp;", "getWxResponse", "()Lcom/tencent/mm/opensdk/modelbiz/WXLaunchWxaRedirectingPage$Resp;", "setWxResponse", "(Lcom/tencent/mm/opensdk/modelbiz/WXLaunchWxaRedirectingPage$Resp;)V", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  extends com.tencent.luggage.wxa.qy.b
{
  @Nullable
  private a.c a;
  @Nullable
  private WXLaunchWxaRedirectingPage.Resp b;
  
  @Nullable
  public final a.c a()
  {
    return this.a;
  }
  
  public final void a(@Nullable a.c paramc)
  {
    this.a = paramc;
  }
  
  public final void a(@Nullable WXLaunchWxaRedirectingPage.Resp paramResp)
  {
    this.b = paramResp;
  }
  
  @Nullable
  public final WXLaunchWxaRedirectingPage.Resp b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.b
 * JD-Core Version:    0.7.0.1
 */