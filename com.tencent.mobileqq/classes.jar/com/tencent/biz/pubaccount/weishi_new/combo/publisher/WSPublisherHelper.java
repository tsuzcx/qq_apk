package com.tencent.biz.pubaccount.weishi_new.combo.publisher;

import UserGrowth.stPublisherRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/publisher/WSPublisherHelper;", "", "()V", "TAG", "", "<set-?>", "LUserGrowth/stPublisherRsp;", "publisherInfo", "getPublisherInfo", "()LUserGrowth/stPublisherRsp;", "fetchPublisherInfo", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSPublisherHelper
{
  public static final WSPublisherHelper a = new WSPublisherHelper();
  @Nullable
  private static stPublisherRsp b;
  
  @Nullable
  public final stPublisherRsp a()
  {
    return b;
  }
  
  public final void b()
  {
    WSLog.e("WSPublisherHelper", "[WSPublisherHelper.kt][fetchPublisherInfo]");
    new WSPublisherFetcher().a((IWSPublisherRspListener)new WSPublisherHelper.fetchPublisherInfo.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherHelper
 * JD-Core Version:    0.7.0.1
 */