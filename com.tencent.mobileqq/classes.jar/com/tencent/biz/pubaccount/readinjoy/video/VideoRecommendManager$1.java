package com.tencent.biz.pubaccount.readinjoy.video;

import bkwm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import pay;
import sdv;

public class VideoRecommendManager$1
  implements Runnable
{
  public VideoRecommendManager$1(sdv paramsdv) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pay.a();
    sdv.a(this.this$0, bkwm.y(localQQAppInterface));
    sdv.b(this.this$0, bkwm.z(localQQAppInterface));
    sdv.a(this.this$0, bkwm.a(localQQAppInterface));
    sdv.c(this.this$0, bkwm.A(localQQAppInterface));
    if ((sdv.a(this.this$0) < 0.0F) || (sdv.a(this.this$0) > 1.0D)) {
      sdv.a(this.this$0, 0.8F);
    }
    if (sdv.a(this.this$0) < 1000) {
      sdv.b(this.this$0, 40000);
    }
    if (sdv.b(this.this$0) == 1) {
      sdv.a(this.this$0, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() 开关配置，mIsOpened = " + sdv.a(this.this$0) + ", mStrategyID = " + sdv.b(this.this$0) + ", mStrategyDurationLimit = " + sdv.a(this.this$0) + ", mStrategyDurationPercent = " + sdv.a(this.this$0) + ", mOperator = " + sdv.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */