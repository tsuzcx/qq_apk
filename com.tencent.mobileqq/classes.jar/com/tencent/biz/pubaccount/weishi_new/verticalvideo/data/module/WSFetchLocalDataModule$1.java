package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.IWeiShiCacheCallback;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport.RecommendFullScreenInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import java.util.List;

class WSFetchLocalDataModule$1
  implements IWeiShiCacheCallback
{
  WSFetchLocalDataModule$1(WSFetchLocalDataModule paramWSFetchLocalDataModule, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  public void a(JceStruct paramJceStruct)
  {
    WSLog.a("WSFetchLocalDataModule", "onReadCacheCompleted");
    if (!(paramJceStruct instanceof stSimpleGetFeedListRsp))
    {
      WSLog.a("WSFetchLocalDataModule", "struct not instanceof stSimpleGetFeedListRsp");
      return;
    }
    paramJceStruct = ((stSimpleGetFeedListRsp)paramJceStruct).feeds;
    if (paramJceStruct != null)
    {
      if (paramJceStruct.size() <= 0) {
        return;
      }
      Object localObject = (stSimpleMetaFeed)paramJceStruct.get(0);
      if (!TextUtils.equals(((stSimpleMetaFeed)localObject).id, WSFetchLocalDataModule.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataModuleWSFetchLocalDataModule))) {
        return;
      }
      WSPublicAccReport.getInstance().getRecommendFullScreenInfo().a(((stSimpleMetaFeed)localObject).video_url);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReadCacheCompleted feeds.size() = ");
      ((StringBuilder)localObject).append(paramJceStruct.size());
      WSLog.a("WSFetchLocalDataModule", ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataIFetchDataRspListener;
      if (localObject != null) {
        ((IFetchDataRspListener)localObject).a(WSVerticalDataUtil.a(paramJceStruct), false, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchLocalDataModule.1
 * JD-Core Version:    0.7.0.1
 */