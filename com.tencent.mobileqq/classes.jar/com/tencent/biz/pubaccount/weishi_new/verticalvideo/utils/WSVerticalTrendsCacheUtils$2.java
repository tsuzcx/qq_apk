package com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.util.WSFileUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;

final class WSVerticalTrendsCacheUtils$2
  implements Runnable
{
  WSVerticalTrendsCacheUtils$2(stSimpleMetaFeed paramstSimpleMetaFeed) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.a);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp.feeds = localArrayList;
    boolean bool = WSFileUtils.a(localstSimpleGetFeedListRsp, WSVerticalTrendsCacheUtils.a());
    WSLog.e("WSVerticalTrendsCacheUtils", "[asyncSaveDataToFile] isSuccess:" + bool + ", title:" + this.a.feed_desc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalTrendsCacheUtils.2
 * JD-Core Version:    0.7.0.1
 */