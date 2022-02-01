package com.tencent.biz.pubaccount.weishi_new.profile.fetcher;

import UserGrowth.stGetPersonalInfoRsp;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.profile.IWSProfileHomePageRspListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/profile/fetcher/WSProfileHomePageFetcher$fetchData$1", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/ServiceCallback;", "LUserGrowth/stGetPersonalInfoRsp;", "failureOnSubThread", "", "errorInfo", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSServiceErrorInfo;", "failureOnUIThread", "successOnSubThread", "request", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSRequest;", "rsp", "headerBean", "Lcom/tencent/biz/pubaccount/weishi_new/net/RspHeaderBean;", "successOnUIThread", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSProfileHomePageFetcher$fetchData$1
  extends ServiceCallback<stGetPersonalInfoRsp, stGetPersonalInfoRsp>
{
  WSProfileHomePageFetcher$fetchData$1(IWSProfileHomePageRspListener paramIWSProfileHomePageRspListener) {}
  
  @Nullable
  protected stGetPersonalInfoRsp a(@Nullable WSRequest<stGetPersonalInfoRsp> paramWSRequest, @Nullable stGetPersonalInfoRsp paramstGetPersonalInfoRsp, @Nullable RspHeaderBean paramRspHeaderBean)
  {
    return paramstGetPersonalInfoRsp;
  }
  
  protected void a(@Nullable stGetPersonalInfoRsp paramstGetPersonalInfoRsp)
  {
    this.a.a(paramstGetPersonalInfoRsp);
  }
  
  protected void a(@Nullable WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(@Nullable WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    IWSProfileHomePageRspListener localIWSProfileHomePageRspListener = this.a;
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
    localIWSProfileHomePageRspListener.a(i, paramWSServiceErrorInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.fetcher.WSProfileHomePageFetcher.fetchData.1
 * JD-Core Version:    0.7.0.1
 */