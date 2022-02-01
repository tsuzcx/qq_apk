package com.tencent.biz.qqcircle.immersive;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

class QFSPersonalProductFeedFragment$2
  implements Observer<FeedCloudMeta.StFeed>
{
  QFSPersonalProductFeedFragment$2(QFSPersonalProductFeedFragment paramQFSPersonalProductFeedFragment) {}
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    QFSPersonalProductFeedFragment.a(this.a, paramStFeed);
    QFSPersonalProductFeedFragment.a(this.a, -1);
    if ((this.a.e != null) && (QFSPersonalProductFeedFragment.a(this.a) != null)) {
      this.a.e.a(QFSPersonalProductFeedFragment.a(this.a).id.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalProductFeedFragment.2
 * JD-Core Version:    0.7.0.1
 */