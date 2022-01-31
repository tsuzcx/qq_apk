package com.tencent.biz.pubaccount.readinjoy.video;

import bkbq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ors;
import rkb;

public class VideoRecommendManager$1
  implements Runnable
{
  public VideoRecommendManager$1(rkb paramrkb) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    rkb.a(this.this$0, bkbq.D(localQQAppInterface));
    rkb.b(this.this$0, bkbq.E(localQQAppInterface));
    rkb.a(this.this$0, bkbq.a(localQQAppInterface));
    rkb.c(this.this$0, bkbq.F(localQQAppInterface));
    if ((rkb.a(this.this$0) < 0.0F) || (rkb.a(this.this$0) > 1.0D)) {
      rkb.a(this.this$0, 0.8F);
    }
    if (rkb.a(this.this$0) < 1000) {
      rkb.b(this.this$0, 40000);
    }
    if (rkb.b(this.this$0) == 1) {
      rkb.a(this.this$0, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() 开关配置，mIsOpened = " + rkb.a(this.this$0) + ", mStrategyID = " + rkb.b(this.this$0) + ", mStrategyDurationLimit = " + rkb.a(this.this$0) + ", mStrategyDurationPercent = " + rkb.a(this.this$0) + ", mOperator = " + rkb.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */