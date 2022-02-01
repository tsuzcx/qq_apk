package com.tencent.luggage.opensdk;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;

final class f$1
  implements d.b<BaseResp>
{
  public String a(BaseResp paramBaseResp)
  {
    if ((paramBaseResp instanceof WXLaunchMiniProgram.Resp)) {
      return f.a(g.b.a((WXLaunchMiniProgram.Resp)paramBaseResp).a);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.f.1
 * JD-Core Version:    0.7.0.1
 */