package com.tencent.biz.pubaccount.weishi_new.combo.publisher;

import UserGrowth.stPublisherRsp;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/publisher/WSPublisherFetcher$fetchPublisherInfo$1", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/ServiceCallback;", "LUserGrowth/stPublisherRsp;", "failureOnSubThread", "", "errorInfo", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSServiceErrorInfo;", "failureOnUIThread", "successOnSubThread", "request", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSRequest;", "rsp", "headerBean", "Lcom/tencent/biz/pubaccount/weishi_new/net/RspHeaderBean;", "successOnUIThread", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSPublisherFetcher$fetchPublisherInfo$1
  extends ServiceCallback<stPublisherRsp, stPublisherRsp>
{
  WSPublisherFetcher$fetchPublisherInfo$1(IWSPublisherRspListener paramIWSPublisherRspListener) {}
  
  @NotNull
  protected stPublisherRsp a(@Nullable WSRequest<stPublisherRsp> paramWSRequest, @NotNull stPublisherRsp paramstPublisherRsp, @Nullable RspHeaderBean paramRspHeaderBean)
  {
    Intrinsics.checkParameterIsNotNull(paramstPublisherRsp, "rsp");
    return paramstPublisherRsp;
  }
  
  protected void a(@NotNull stPublisherRsp paramstPublisherRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramstPublisherRsp, "rsp");
    super.a(paramstPublisherRsp);
    IWSPublisherRspListener localIWSPublisherRspListener = this.a;
    if (localIWSPublisherRspListener != null) {
      localIWSPublisherRspListener.a(paramstPublisherRsp);
    }
  }
  
  protected void a(@Nullable WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(@Nullable WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    IWSPublisherRspListener localIWSPublisherRspListener = this.a;
    if (localIWSPublisherRspListener != null)
    {
      int i;
      if (paramWSServiceErrorInfo != null) {
        i = paramWSServiceErrorInfo.a();
      } else {
        i = -1;
      }
      if (paramWSServiceErrorInfo != null) {
        paramWSServiceErrorInfo = paramWSServiceErrorInfo.b();
      } else {
        paramWSServiceErrorInfo = null;
      }
      localIWSPublisherRspListener.a(i, paramWSServiceErrorInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherFetcher.fetchPublisherInfo.1
 * JD-Core Version:    0.7.0.1
 */