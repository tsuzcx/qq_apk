package com.tencent.biz.qqcircle.polylike;

import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.richframework.animation.support.AnimationListener.Stop;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCirclePolyRequestManager$1
  implements AnimationListener.Stop
{
  QCirclePolyRequestManager$1(QCirclePolyRequestManager paramQCirclePolyRequestManager, FeedCloudMeta.StFeed paramStFeed, int paramInt, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2) {}
  
  public void a()
  {
    if ((!QCirclePolyRequestManager.a(this.e)) && (!QCirclePolyRequestManager.b(this.e)) && (HostNetworkUtils.isNetworkAvailable()))
    {
      this.e.a(this.a, this.b, this.c, this.d);
      QCirclePolyRequestManager.a(this.e, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyRequestManager.1
 * JD-Core Version:    0.7.0.1
 */