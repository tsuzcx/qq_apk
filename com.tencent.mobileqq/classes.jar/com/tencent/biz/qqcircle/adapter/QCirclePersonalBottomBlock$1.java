package com.tencent.biz.qqcircle.adapter;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView;
import feedcloud.FeedCloudMeta.StUser;

class QCirclePersonalBottomBlock$1
  implements Observer<FeedCloudMeta.StUser>
{
  QCirclePersonalBottomBlock$1(QCirclePersonalBottomBlock paramQCirclePersonalBottomBlock) {}
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    QCirclePersonalBottomBlock.a(this.a).setUser((FeedCloudMeta.StUser)paramStUser.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCirclePersonalBottomBlock.1
 * JD-Core Version:    0.7.0.1
 */