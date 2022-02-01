package com.tencent.biz.qqcircle.polylike;

import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.richframework.animation.support.AnimationListener.Stop;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCirclePolyRequestManager$2
  implements AnimationListener.Stop
{
  QCirclePolyRequestManager$2(QCirclePolyRequestManager paramQCirclePolyRequestManager, FeedCloudMeta.StFeed paramStFeed, int paramInt, QQCircleFeedBase.StPolyLike paramStPolyLike) {}
  
  public void a()
  {
    if (HostNetworkUtils.isNetworkAvailable())
    {
      QCirclePolyRequestManager localQCirclePolyRequestManager = this.d;
      FeedCloudMeta.StFeed localStFeed = this.a;
      int i = this.b;
      QQCircleFeedBase.StPolyLike localStPolyLike = this.c;
      localQCirclePolyRequestManager.a(localStFeed, i, localStPolyLike, localStPolyLike);
      QCirclePolyRequestManager.a(this.d, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyRequestManager.2
 * JD-Core Version:    0.7.0.1
 */