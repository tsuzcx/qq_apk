package com.tencent.biz.pubaccount.weishi_new.combo.reddot;

import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.biz.pubaccount.weishi_new.data.IFetcher;
import com.tencent.biz.pubaccount.weishi_new.data.IFetcherRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSRedDotRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/reddot/WSRedDotDataFetcher;", "Lcom/tencent/biz/pubaccount/weishi_new/data/IFetcher;", "Lcom/tencent/biz/pubaccount/weishi_new/data/FetcherParams;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/reddot/WSRedDotDataFetcher$ResponseModel;", "()V", "fetchData", "", "params", "listener", "Lcom/tencent/biz/pubaccount/weishi_new/data/IFetcherRspListener;", "ResponseModel", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSRedDotDataFetcher
  implements IFetcher<FetcherParams, WSRedDotDataFetcher.ResponseModel>
{
  public boolean a(@Nullable FetcherParams paramFetcherParams, @Nullable IFetcherRspListener<WSRedDotDataFetcher.ResponseModel> paramIFetcherRspListener)
  {
    WSNetService.a((WSRequest)new WSRedDotRequest()).a((ServiceCallback)new WSRedDotDataFetcher.fetchData.1(paramIFetcherRspListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.reddot.WSRedDotDataFetcher
 * JD-Core Version:    0.7.0.1
 */