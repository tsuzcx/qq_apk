package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

class VideoRecommendManager$1
  implements Runnable
{
  VideoRecommendManager$1(VideoRecommendManager paramVideoRecommendManager) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    VideoRecommendManager.a(this.this$0, ReadInJoyHelper.v(localQQAppInterface));
    VideoRecommendManager.b(this.this$0, ReadInJoyHelper.w(localQQAppInterface));
    VideoRecommendManager.a(this.this$0, ReadInJoyHelper.a(localQQAppInterface));
    VideoRecommendManager.c(this.this$0, ReadInJoyHelper.x(localQQAppInterface));
    if ((VideoRecommendManager.a(this.this$0) < 0.0F) || (VideoRecommendManager.a(this.this$0) > 1.0D)) {
      VideoRecommendManager.a(this.this$0, 0.8F);
    }
    if (VideoRecommendManager.a(this.this$0) < 1000) {
      VideoRecommendManager.b(this.this$0, 40000);
    }
    if (VideoRecommendManager.b(this.this$0) == 1) {
      VideoRecommendManager.a(this.this$0, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() 开关配置，mIsOpened = " + VideoRecommendManager.a(this.this$0) + ", mStrategyID = " + VideoRecommendManager.b(this.this$0) + ", mStrategyDurationLimit = " + VideoRecommendManager.a(this.this$0) + ", mStrategyDurationPercent = " + VideoRecommendManager.a(this.this$0) + ", mOperator = " + VideoRecommendManager.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */