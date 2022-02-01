package com.tencent.luggage.wxa.standalone_open_runtime.container;

import com.tencent.luggage.opensdk.d.b;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "resp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "genTargetKey"}, k=3, mv={1, 1, 16})
final class WxaContainerActivity0$b<T extends BaseResp>
  implements d.b<BaseResp>
{
  public static final b a = new b();
  
  public final String a(BaseResp paramBaseResp)
  {
    if ((paramBaseResp instanceof WXLaunchWxaRedirectingPage.Resp)) {
      return ((WXLaunchWxaRedirectingPage.Resp)paramBaseResp).invokeTicket;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerActivity0.b
 * JD-Core Version:    0.7.0.1
 */