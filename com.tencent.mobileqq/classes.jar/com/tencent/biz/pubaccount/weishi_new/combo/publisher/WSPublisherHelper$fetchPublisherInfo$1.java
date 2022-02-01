package com.tencent.biz.pubaccount.weishi_new.combo.publisher;

import UserGrowth.stPublisherRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/publisher/WSPublisherHelper$fetchPublisherInfo$1", "Lcom/tencent/biz/pubaccount/weishi_new/combo/publisher/IWSPublisherRspListener;", "onFailure", "", "code", "", "errMsg", "", "onSuccess", "rsp", "LUserGrowth/stPublisherRsp;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSPublisherHelper$fetchPublisherInfo$1
  implements IWSPublisherRspListener
{
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(@NotNull stPublisherRsp paramstPublisherRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramstPublisherRsp, "rsp");
    WSPublisherHelper.a(WSPublisherHelper.a, paramstPublisherRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherHelper.fetchPublisherInfo.1
 * JD-Core Version:    0.7.0.1
 */