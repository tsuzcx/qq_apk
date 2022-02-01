package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import UserGrowth.stSimpleGetFeedListRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.IWeiShiCacheCallback;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import java.util.ArrayList;

class WSFetchPreloadDataModule$1
  implements IWeiShiCacheCallback
{
  WSFetchPreloadDataModule$1(WSFetchPreloadDataModule paramWSFetchPreloadDataModule, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  public void a(JceStruct paramJceStruct)
  {
    if (!(paramJceStruct instanceof stSimpleGetFeedListRsp)) {
      return;
    }
    paramJceStruct = (stSimpleGetFeedListRsp)paramJceStruct;
    if (paramJceStruct.feeds != null)
    {
      if (paramJceStruct.feeds.size() <= 0) {
        return;
      }
      paramJceStruct = paramJceStruct.feeds;
      IFetchDataRspListener localIFetchDataRspListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener;
      if (localIFetchDataRspListener != null) {
        localIFetchDataRspListener.a(WSVerticalDataUtil.a(paramJceStruct), false, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchPreloadDataModule.1
 * JD-Core Version:    0.7.0.1
 */