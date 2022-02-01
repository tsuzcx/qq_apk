package com.tencent.biz.pubaccount.weishi_new.combo.reddot;

import UserGrowth.stRedDotRsp;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/reddot/WSRedDotDataFetcher$ResponseModel;", "", "rsp", "LUserGrowth/stRedDotRsp;", "(LUserGrowth/stRedDotRsp;)V", "headerBean", "Lcom/tencent/biz/pubaccount/weishi_new/net/RspHeaderBean;", "getHeaderBean", "()Lcom/tencent/biz/pubaccount/weishi_new/net/RspHeaderBean;", "setHeaderBean", "(Lcom/tencent/biz/pubaccount/weishi_new/net/RspHeaderBean;)V", "getRsp", "()LUserGrowth/stRedDotRsp;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSRedDotDataFetcher$ResponseModel
{
  @NotNull
  public RspHeaderBean a;
  @NotNull
  private final stRedDotRsp b;
  
  public WSRedDotDataFetcher$ResponseModel(@NotNull stRedDotRsp paramstRedDotRsp)
  {
    this.b = paramstRedDotRsp;
  }
  
  @NotNull
  public final stRedDotRsp a()
  {
    return this.b;
  }
  
  public final void a(@NotNull RspHeaderBean paramRspHeaderBean)
  {
    Intrinsics.checkParameterIsNotNull(paramRspHeaderBean, "<set-?>");
    this.a = paramRspHeaderBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.reddot.WSRedDotDataFetcher.ResponseModel
 * JD-Core Version:    0.7.0.1
 */