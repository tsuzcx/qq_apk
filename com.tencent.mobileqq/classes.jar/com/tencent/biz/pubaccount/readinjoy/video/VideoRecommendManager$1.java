package com.tencent.biz.pubaccount.readinjoy.video;

import bhvh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import onk;
import qup;

public class VideoRecommendManager$1
  implements Runnable
{
  public VideoRecommendManager$1(qup paramqup) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)onk.a();
    qup.a(this.this$0, bhvh.D(localQQAppInterface));
    qup.b(this.this$0, bhvh.E(localQQAppInterface));
    qup.a(this.this$0, bhvh.a(localQQAppInterface));
    qup.c(this.this$0, bhvh.F(localQQAppInterface));
    if ((qup.a(this.this$0) < 0.0F) || (qup.a(this.this$0) > 1.0D)) {
      qup.a(this.this$0, 0.8F);
    }
    if (qup.a(this.this$0) < 1000) {
      qup.b(this.this$0, 40000);
    }
    if (qup.b(this.this$0) == 1) {
      qup.a(this.this$0, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() 开关配置，mIsOpened = " + qup.a(this.this$0) + ", mStrategyID = " + qup.b(this.this$0) + ", mStrategyDurationLimit = " + qup.a(this.this$0) + ", mStrategyDurationPercent = " + qup.a(this.this$0) + ", mOperator = " + qup.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */