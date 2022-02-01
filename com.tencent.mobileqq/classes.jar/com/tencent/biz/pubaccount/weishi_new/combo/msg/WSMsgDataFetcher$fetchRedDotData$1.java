package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import UserGrowth.stGetMsgRedDotRsp;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.IFetchDataListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgDataFetcher$fetchRedDotData$1", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/ServiceCallback;", "LUserGrowth/stGetMsgRedDotRsp;", "", "failureOnSubThread", "", "errorInfo", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSServiceErrorInfo;", "failureOnUIThread", "successOnSubThread", "request", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSRequest;", "t", "headerBean", "Lcom/tencent/biz/pubaccount/weishi_new/net/RspHeaderBean;", "(Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSRequest;LUserGrowth/stGetMsgRedDotRsp;Lcom/tencent/biz/pubaccount/weishi_new/net/RspHeaderBean;)Ljava/lang/Integer;", "successOnUIThread", "count", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgDataFetcher$fetchRedDotData$1
  extends ServiceCallback<stGetMsgRedDotRsp, Integer>
{
  WSMsgDataFetcher$fetchRedDotData$1(IFetchDataListener paramIFetchDataListener) {}
  
  @NotNull
  protected Integer a(@NotNull WSRequest<stGetMsgRedDotRsp> paramWSRequest, @NotNull stGetMsgRedDotRsp paramstGetMsgRedDotRsp, @NotNull RspHeaderBean paramRspHeaderBean)
  {
    Intrinsics.checkParameterIsNotNull(paramWSRequest, "request");
    Intrinsics.checkParameterIsNotNull(paramstGetMsgRedDotRsp, "t");
    Intrinsics.checkParameterIsNotNull(paramRspHeaderBean, "headerBean");
    return Integer.valueOf(WSMsgDataFetcher.a(this.a, paramstGetMsgRedDotRsp));
  }
  
  protected void a(int paramInt)
  {
    super.a(Integer.valueOf(paramInt));
    IFetchDataListener localIFetchDataListener = this.b;
    if (localIFetchDataListener != null) {
      localIFetchDataListener.a(Integer.valueOf(paramInt));
    }
  }
  
  protected void a(@Nullable WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(@NotNull WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramWSServiceErrorInfo, "errorInfo");
    super.b(paramWSServiceErrorInfo);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSMsgDataFetcher.java][fetchRedDotData] response errorCode:");
    ((StringBuilder)localObject).append(paramWSServiceErrorInfo.a());
    ((StringBuilder)localObject).append(", errorMsg:");
    ((StringBuilder)localObject).append(paramWSServiceErrorInfo.b());
    WSLog.d("WSMsgDataFetcher", ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null)
    {
      int i = paramWSServiceErrorInfo.a();
      paramWSServiceErrorInfo = paramWSServiceErrorInfo.b();
      if (paramWSServiceErrorInfo == null) {
        paramWSServiceErrorInfo = "";
      }
      ((IFetchDataListener)localObject).a(i, paramWSServiceErrorInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgDataFetcher.fetchRedDotData.1
 * JD-Core Version:    0.7.0.1
 */