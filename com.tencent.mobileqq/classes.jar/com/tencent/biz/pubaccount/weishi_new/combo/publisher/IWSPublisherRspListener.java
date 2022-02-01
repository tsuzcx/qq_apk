package com.tencent.biz.pubaccount.weishi_new.combo.publisher;

import UserGrowth.stPublisherRsp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/publisher/IWSPublisherRspListener;", "", "onFailure", "", "code", "", "errMsg", "", "onSuccess", "rsp", "LUserGrowth/stPublisherRsp;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IWSPublisherRspListener
{
  public abstract void a(int paramInt, @Nullable String paramString);
  
  public abstract void a(@NotNull stPublisherRsp paramstPublisherRsp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.publisher.IWSPublisherRspListener
 * JD-Core Version:    0.7.0.1
 */