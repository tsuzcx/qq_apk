package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import UserGrowth.stSimpleGetFeedListRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.IWeiShiCacheCallback;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.IVerticalRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import java.util.ArrayList;

class WSFetchPreloadDataModule$1
  implements IWeiShiCacheCallback
{
  WSFetchPreloadDataModule$1(WSFetchPreloadDataModule paramWSFetchPreloadDataModule, IVerticalRspListener paramIVerticalRspListener) {}
  
  public void a(JceStruct paramJceStruct)
  {
    if (!(paramJceStruct instanceof stSimpleGetFeedListRsp)) {}
    do
    {
      do
      {
        return;
        paramJceStruct = (stSimpleGetFeedListRsp)paramJceStruct;
      } while ((paramJceStruct.feeds == null) || (paramJceStruct.feeds.size() <= 0));
      paramJceStruct = paramJceStruct.feeds;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener == null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener.a(WSVerticalDataUtil.a(paramJceStruct), false, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchPreloadDataModule.1
 * JD-Core Version:    0.7.0.1
 */