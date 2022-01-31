package com.tencent.biz.pubaccount.readinjoy.video;

import bhvy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import onh;
import qum;

public class VideoRecommendManager$1
  implements Runnable
{
  public VideoRecommendManager$1(qum paramqum) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)onh.a();
    qum.a(this.this$0, bhvy.D(localQQAppInterface));
    qum.b(this.this$0, bhvy.E(localQQAppInterface));
    qum.a(this.this$0, bhvy.a(localQQAppInterface));
    qum.c(this.this$0, bhvy.F(localQQAppInterface));
    if ((qum.a(this.this$0) < 0.0F) || (qum.a(this.this$0) > 1.0D)) {
      qum.a(this.this$0, 0.8F);
    }
    if (qum.a(this.this$0) < 1000) {
      qum.b(this.this$0, 40000);
    }
    if (qum.b(this.this$0) == 1) {
      qum.a(this.this$0, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() 开关配置，mIsOpened = " + qum.a(this.this$0) + ", mStrategyID = " + qum.b(this.this$0) + ", mStrategyDurationLimit = " + qum.a(this.this$0) + ", mStrategyDurationPercent = " + qum.a(this.this$0) + ", mOperator = " + qum.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */