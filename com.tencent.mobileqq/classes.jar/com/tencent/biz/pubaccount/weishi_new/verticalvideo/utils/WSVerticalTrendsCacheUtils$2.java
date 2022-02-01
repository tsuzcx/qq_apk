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
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(this.a);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp.feeds = ((ArrayList)localObject);
    boolean bool = WSFileUtils.a(localstSimpleGetFeedListRsp, WSVerticalTrendsCacheUtils.a());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[asyncSaveDataToFile] isSuccess:");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(", title:");
    ((StringBuilder)localObject).append(this.a.feed_desc);
    WSLog.e("WSVerticalTrendsCacheUtils", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalTrendsCacheUtils.2
 * JD-Core Version:    0.7.0.1
 */