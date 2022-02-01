package com.tencent.biz.pubaccount.weishi_new.combo.reddot;

import UserGrowth.stRedDotRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetcherRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/reddot/WSRedDotDataFetcher$fetchData$1", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/ServiceCallback;", "LUserGrowth/stRedDotRsp;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/reddot/WSRedDotDataFetcher$ResponseModel;", "failureOnSubThread", "", "errorInfo", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSServiceErrorInfo;", "failureOnUIThread", "successOnSubThread", "request", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSRequest;", "rsp", "headerBean", "Lcom/tencent/biz/pubaccount/weishi_new/net/RspHeaderBean;", "successOnUIThread", "responseModel", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSRedDotDataFetcher$fetchData$1
  extends ServiceCallback<stRedDotRsp, WSRedDotDataFetcher.ResponseModel>
{
  WSRedDotDataFetcher$fetchData$1(IFetcherRspListener paramIFetcherRspListener) {}
  
  @NotNull
  protected WSRedDotDataFetcher.ResponseModel a(@Nullable WSRequest<stRedDotRsp> paramWSRequest, @NotNull stRedDotRsp paramstRedDotRsp, @NotNull RspHeaderBean paramRspHeaderBean)
  {
    Intrinsics.checkParameterIsNotNull(paramstRedDotRsp, "rsp");
    Intrinsics.checkParameterIsNotNull(paramRspHeaderBean, "headerBean");
    paramWSRequest = new WSRedDotDataFetcher.ResponseModel(paramstRedDotRsp);
    paramWSRequest.a(paramRspHeaderBean);
    return paramWSRequest;
  }
  
  protected void a(@NotNull WSRedDotDataFetcher.ResponseModel paramResponseModel)
  {
    Intrinsics.checkParameterIsNotNull(paramResponseModel, "responseModel");
    super.a(paramResponseModel);
    IFetcherRspListener localIFetcherRspListener = this.a;
    if (localIFetcherRspListener != null) {
      localIFetcherRspListener.a(paramResponseModel, false, false, null);
    }
  }
  
  protected void a(@NotNull WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramWSServiceErrorInfo, "errorInfo");
  }
  
  protected void b(@NotNull WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramWSServiceErrorInfo, "errorInfo");
    super.b(paramWSServiceErrorInfo);
    IFetcherRspListener localIFetcherRspListener = this.a;
    if (localIFetcherRspListener != null) {
      localIFetcherRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.b(), false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.reddot.WSRedDotDataFetcher.fetchData.1
 * JD-Core Version:    0.7.0.1
 */