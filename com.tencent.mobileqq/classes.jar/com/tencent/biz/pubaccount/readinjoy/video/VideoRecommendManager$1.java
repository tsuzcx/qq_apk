package com.tencent.biz.pubaccount.readinjoy.video;

import bgmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import obz;
import qik;

public class VideoRecommendManager$1
  implements Runnable
{
  public VideoRecommendManager$1(qik paramqik) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)obz.a();
    qik.a(this.this$0, bgmq.D(localQQAppInterface));
    qik.b(this.this$0, bgmq.E(localQQAppInterface));
    qik.a(this.this$0, bgmq.a(localQQAppInterface));
    qik.c(this.this$0, bgmq.F(localQQAppInterface));
    if ((qik.a(this.this$0) < 0.0F) || (qik.a(this.this$0) > 1.0D)) {
      qik.a(this.this$0, 0.8F);
    }
    if (qik.a(this.this$0) < 1000) {
      qik.b(this.this$0, 40000);
    }
    if (qik.b(this.this$0) == 1) {
      qik.a(this.this$0, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() 开关配置，mIsOpened = " + qik.a(this.this$0) + ", mStrategyID = " + qik.b(this.this$0) + ", mStrategyDurationLimit = " + qik.a(this.this$0) + ", mStrategyDurationPercent = " + qik.a(this.this$0) + ", mOperator = " + qik.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */