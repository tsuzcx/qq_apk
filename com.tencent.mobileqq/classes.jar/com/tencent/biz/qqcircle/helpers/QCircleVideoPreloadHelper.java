package com.tencent.biz.qqcircle.helpers;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.richframework.helper.VideoPreloadHelper;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;

public class QCircleVideoPreloadHelper
  extends VideoPreloadHelper
{
  public QCircleVideoPreloadHelper(int paramInt)
  {
    super(paramInt);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    FeedCloudMeta.StVideo localStVideo = (FeedCloudMeta.StVideo)paramStFeed.video.get();
    boolean bool = QCirclePluginUtil.a(paramStFeed);
    QCircleVideoExchangeHelper.a().a(this.a, localStVideo, new QCircleVideoPreloadHelper.1(this, bool, localStVideo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.helpers.QCircleVideoPreloadHelper
 * JD-Core Version:    0.7.0.1
 */