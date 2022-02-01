package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import java.util.concurrent.ConcurrentHashMap;

class RecommendADVideoFeedsManager$1
  extends Handler
{
  RecommendADVideoFeedsManager$1(RecommendADVideoFeedsManager paramRecommendADVideoFeedsManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 3001)
    {
      super.handleMessage(paramMessage);
      return;
    }
    paramMessage = this.a.a(false);
    if (paramMessage != null)
    {
      RecommendADVideoFeedsManager.a(this.a).remove(Integer.valueOf(paramMessage.e));
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramMessage.D;
      if (localAdvertisementInfo != null) {
        localAdvertisementInfo.isShowingGuide = false;
      }
      this.a.a(null, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager.1
 * JD-Core Version:    0.7.0.1
 */