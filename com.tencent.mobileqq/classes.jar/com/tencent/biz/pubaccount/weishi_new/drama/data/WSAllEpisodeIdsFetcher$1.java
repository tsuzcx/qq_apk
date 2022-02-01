package com.tencent.biz.pubaccount.weishi_new.drama.data;

import UserGrowth.stGetAllFeedsByDramaIDRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;

class WSAllEpisodeIdsFetcher$1
  extends ServiceCallback<stGetAllFeedsByDramaIDRsp, stGetAllFeedsByDramaIDRsp>
{
  WSAllEpisodeIdsFetcher$1(WSAllEpisodeIdsFetcher paramWSAllEpisodeIdsFetcher, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  protected stGetAllFeedsByDramaIDRsp a(WSRequest<stGetAllFeedsByDramaIDRsp> paramWSRequest, stGetAllFeedsByDramaIDRsp paramstGetAllFeedsByDramaIDRsp, RspHeaderBean paramRspHeaderBean)
  {
    return paramstGetAllFeedsByDramaIDRsp;
  }
  
  protected void a(stGetAllFeedsByDramaIDRsp paramstGetAllFeedsByDramaIDRsp)
  {
    super.a(paramstGetAllFeedsByDramaIDRsp);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener.a(paramstGetAllFeedsByDramaIDRsp.feedIDs, false, false, null);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.a(), false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.data.WSAllEpisodeIdsFetcher.1
 * JD-Core Version:    0.7.0.1
 */