package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StUser;

class QCircleFollowView$2
  implements Runnable
{
  QCircleFollowView$2(QCircleFollowView paramQCircleFollowView) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (QCirclePluginUtil.c(this.this$0.a.followState.get()))) {
      this.this$0.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowView.2
 * JD-Core Version:    0.7.0.1
 */