package com.tencent.biz.pubaccount.weishi_new.combo.publisher;

import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.request.GetPublisherRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/publisher/WSPublisherFetcher;", "", "()V", "fetchPublisherInfo", "", "listener", "Lcom/tencent/biz/pubaccount/weishi_new/combo/publisher/IWSPublisherRspListener;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSPublisherFetcher
{
  public final void a(@Nullable IWSPublisherRspListener paramIWSPublisherRspListener)
  {
    WSNetService.a((WSRequest)new GetPublisherRequest()).a((ServiceCallback)new WSPublisherFetcher.fetchPublisherInfo.1(paramIWSPublisherRspListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherFetcher
 * JD-Core Version:    0.7.0.1
 */