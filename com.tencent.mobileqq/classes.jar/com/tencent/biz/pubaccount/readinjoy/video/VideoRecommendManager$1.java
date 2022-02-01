package com.tencent.biz.pubaccount.readinjoy.video;

import bmqa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import pha;
import sfn;

public class VideoRecommendManager$1
  implements Runnable
{
  public VideoRecommendManager$1(sfn paramsfn) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pha.a();
    sfn.a(this.this$0, bmqa.D(localQQAppInterface));
    sfn.b(this.this$0, bmqa.E(localQQAppInterface));
    sfn.a(this.this$0, bmqa.a(localQQAppInterface));
    sfn.c(this.this$0, bmqa.F(localQQAppInterface));
    if ((sfn.a(this.this$0) < 0.0F) || (sfn.a(this.this$0) > 1.0D)) {
      sfn.a(this.this$0, 0.8F);
    }
    if (sfn.a(this.this$0) < 1000) {
      sfn.b(this.this$0, 40000);
    }
    if (sfn.b(this.this$0) == 1) {
      sfn.a(this.this$0, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() 开关配置，mIsOpened = " + sfn.a(this.this$0) + ", mStrategyID = " + sfn.b(this.this$0) + ", mStrategyDurationLimit = " + sfn.a(this.this$0) + ", mStrategyDurationPercent = " + sfn.a(this.this$0) + ", mOperator = " + sfn.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */