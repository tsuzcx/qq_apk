package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stRedDotReq;
import UserGrowth.stRedDotRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/request/newreq/WSRedDotRequest;", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSRequest;", "LUserGrowth/stRedDotRsp;", "()V", "getRspClass", "Ljava/lang/Class;", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSRedDotRequest
  extends WSRequest<stRedDotRsp>
{
  @NotNull
  public static final String CMD_STRING = "RedDot";
  public static final WSRedDotRequest.Companion Companion = new WSRedDotRequest.Companion(null);
  
  public WSRedDotRequest()
  {
    super("RedDot", 10001);
    this.req = ((JceStruct)new stRedDotReq(111, 1, null));
  }
  
  @NotNull
  public Class<stRedDotRsp> getRspClass()
  {
    return stRedDotRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSRedDotRequest
 * JD-Core Version:    0.7.0.1
 */