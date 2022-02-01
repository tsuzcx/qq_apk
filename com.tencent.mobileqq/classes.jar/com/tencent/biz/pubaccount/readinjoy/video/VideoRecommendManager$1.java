package com.tencent.biz.pubaccount.readinjoy.video;

import bmhv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import pkh;
import spz;

public class VideoRecommendManager$1
  implements Runnable
{
  public VideoRecommendManager$1(spz paramspz) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
    spz.a(this.this$0, bmhv.y(localQQAppInterface));
    spz.b(this.this$0, bmhv.z(localQQAppInterface));
    spz.a(this.this$0, bmhv.a(localQQAppInterface));
    spz.c(this.this$0, bmhv.A(localQQAppInterface));
    if ((spz.a(this.this$0) < 0.0F) || (spz.a(this.this$0) > 1.0D)) {
      spz.a(this.this$0, 0.8F);
    }
    if (spz.a(this.this$0) < 1000) {
      spz.b(this.this$0, 40000);
    }
    if (spz.b(this.this$0) == 1) {
      spz.a(this.this$0, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() 开关配置，mIsOpened = " + spz.a(this.this$0) + ", mStrategyID = " + spz.b(this.this$0) + ", mStrategyDurationLimit = " + spz.a(this.this$0) + ", mStrategyDurationPercent = " + spz.a(this.this$0) + ", mOperator = " + spz.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */