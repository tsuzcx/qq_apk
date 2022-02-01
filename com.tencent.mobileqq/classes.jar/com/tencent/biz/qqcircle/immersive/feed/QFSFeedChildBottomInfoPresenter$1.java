package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView.FollowReportListener;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;

class QFSFeedChildBottomInfoPresenter$1
  implements QCircleFollowView.FollowReportListener
{
  QFSFeedChildBottomInfoPresenter$1(QFSFeedChildBottomInfoPresenter paramQFSFeedChildBottomInfoPresenter, QFSPlusFollowView paramQFSPlusFollowView) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (this.b.b())
    {
      QFSFeedChildBottomInfoPresenter localQFSFeedChildBottomInfoPresenter = this.b;
      QFSFeedChildBottomInfoPresenter.a(localQFSFeedChildBottomInfoPresenter, 80, 1, localQFSFeedChildBottomInfoPresenter.e(), "");
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.b;
    QFSFeedChildBottomInfoPresenter.a((QFSFeedChildBottomInfoPresenter)localObject, 80, 2, ((QFSFeedChildBottomInfoPresenter)localObject).e(), "");
    VideoReport.setElementId(this.a, "em_xsj_multimedia");
    localObject = new HashMap();
    ((Map)localObject).put("xsj_action_type", "follow");
    QFSFeedChildBottomInfoPresenter.a(this.b, this.a, "ev_xsj_follow", (Map)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomInfoPresenter.1
 * JD-Core Version:    0.7.0.1
 */