package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.IWeiShiCacheCallback;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport.RecommendFullScreenInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.IVerticalRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import java.util.List;

class WSFetchLocalDataModule$1
  implements IWeiShiCacheCallback
{
  WSFetchLocalDataModule$1(WSFetchLocalDataModule paramWSFetchLocalDataModule, IVerticalRspListener paramIVerticalRspListener) {}
  
  public void a(JceStruct paramJceStruct)
  {
    WSLog.a("WSFetchLocalDataModule", "onReadCacheCompleted");
    if (!(paramJceStruct instanceof stSimpleGetFeedListRsp)) {
      WSLog.a("WSFetchLocalDataModule", "struct not instanceof stSimpleGetFeedListRsp");
    }
    do
    {
      stSimpleMetaFeed localstSimpleMetaFeed;
      do
      {
        do
        {
          return;
          paramJceStruct = ((stSimpleGetFeedListRsp)paramJceStruct).feeds;
        } while ((paramJceStruct == null) || (paramJceStruct.size() <= 0));
        localstSimpleMetaFeed = (stSimpleMetaFeed)paramJceStruct.get(0);
      } while (!TextUtils.equals(localstSimpleMetaFeed.id, WSFetchLocalDataModule.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataModuleWSFetchLocalDataModule)));
      WSPublicAccReport.getInstance().getRecommendFullScreenInfo().a(localstSimpleMetaFeed.video_url);
      WSLog.a("WSFetchLocalDataModule", "onReadCacheCompleted feeds.size() = " + paramJceStruct.size());
    } while (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener == null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener.a(WSVerticalDataUtil.a(paramJceStruct), false, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchLocalDataModule.1
 * JD-Core Version:    0.7.0.1
 */