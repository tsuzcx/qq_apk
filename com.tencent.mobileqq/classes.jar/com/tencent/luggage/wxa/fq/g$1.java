package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.opensdk.d.b;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "resp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "genTargetKey"}, k=3, mv={1, 1, 16})
final class g$1<T extends BaseResp>
  implements d.b<BaseResp>
{
  public static final 1 a = new 1();
  
  public final String a(BaseResp paramBaseResp)
  {
    if ((paramBaseResp instanceof WXLaunchWxaRedirectingPage.Resp)) {
      return ((WXLaunchWxaRedirectingPage.Resp)paramBaseResp).invokeTicket;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.1
 * JD-Core Version:    0.7.0.1
 */