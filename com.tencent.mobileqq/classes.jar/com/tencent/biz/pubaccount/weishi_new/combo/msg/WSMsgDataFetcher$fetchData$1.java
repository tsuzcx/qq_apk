package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import UserGrowth.stGetFirstPageMsgListRsp;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgPageData;
import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.IFetchDataListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgDataFetcher$fetchData$1", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/ServiceCallback;", "LUserGrowth/stGetFirstPageMsgListRsp;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgPageData;", "failureOnSubThread", "", "errorInfo", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSServiceErrorInfo;", "failureOnUIThread", "successOnSubThread", "request", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSRequest;", "t", "headerBean", "Lcom/tencent/biz/pubaccount/weishi_new/net/RspHeaderBean;", "successOnUIThread", "data", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgDataFetcher$fetchData$1
  extends ServiceCallback<stGetFirstPageMsgListRsp, WSMsgPageData>
{
  WSMsgDataFetcher$fetchData$1(FetcherParams paramFetcherParams, IFetchDataListener paramIFetchDataListener) {}
  
  @NotNull
  protected WSMsgPageData a(@Nullable WSRequest<stGetFirstPageMsgListRsp> paramWSRequest, @NotNull stGetFirstPageMsgListRsp paramstGetFirstPageMsgListRsp, @Nullable RspHeaderBean paramRspHeaderBean)
  {
    Intrinsics.checkParameterIsNotNull(paramstGetFirstPageMsgListRsp, "t");
    return WSMsgDataFetcher.a(this.a, this.b, paramstGetFirstPageMsgListRsp);
  }
  
  protected void a(@NotNull WSMsgPageData paramWSMsgPageData)
  {
    Intrinsics.checkParameterIsNotNull(paramWSMsgPageData, "data");
    super.a(paramWSMsgPageData);
    WSMsgDataFetcher.a(this.a, paramWSMsgPageData, this.c);
  }
  
  protected void a(@Nullable WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(@NotNull WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramWSServiceErrorInfo, "errorInfo");
    super.b(paramWSServiceErrorInfo);
    WSMsgDataFetcher.a(this.a, paramWSServiceErrorInfo, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgDataFetcher.fetchData.1
 * JD-Core Version:    0.7.0.1
 */