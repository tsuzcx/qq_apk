package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import java.util.Arrays;

class WSFetchPushDataModule$1
  implements Runnable
{
  WSFetchPushDataModule$1(WSFetchPushDataModule paramWSFetchPushDataModule, IFetchDataRspListener paramIFetchDataRspListener, stSimpleMetaFeed paramstSimpleMetaFeed) {}
  
  public void run()
  {
    IFetchDataRspListener localIFetchDataRspListener = this.a;
    if (localIFetchDataRspListener != null) {
      localIFetchDataRspListener.a(WSVerticalDataUtil.a(Arrays.asList(new stSimpleMetaFeed[] { this.b })), false, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchPushDataModule.1
 * JD-Core Version:    0.7.0.1
 */