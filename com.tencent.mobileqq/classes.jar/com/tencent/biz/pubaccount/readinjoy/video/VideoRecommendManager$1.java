package com.tencent.biz.pubaccount.readinjoy.video;

import bnrf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ozs;
import rwr;

public class VideoRecommendManager$1
  implements Runnable
{
  public VideoRecommendManager$1(rwr paramrwr) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ozs.a();
    rwr.a(this.this$0, bnrf.B(localQQAppInterface));
    rwr.b(this.this$0, bnrf.C(localQQAppInterface));
    rwr.a(this.this$0, bnrf.a(localQQAppInterface));
    rwr.c(this.this$0, bnrf.D(localQQAppInterface));
    if ((rwr.a(this.this$0) < 0.0F) || (rwr.a(this.this$0) > 1.0D)) {
      rwr.a(this.this$0, 0.8F);
    }
    if (rwr.a(this.this$0) < 1000) {
      rwr.b(this.this$0, 40000);
    }
    if (rwr.b(this.this$0) == 1) {
      rwr.a(this.this$0, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() 开关配置，mIsOpened = " + rwr.a(this.this$0) + ", mStrategyID = " + rwr.b(this.this$0) + ", mStrategyDurationLimit = " + rwr.a(this.this$0) + ", mStrategyDurationPercent = " + rwr.a(this.this$0) + ", mOperator = " + rwr.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */