package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView.FollowReportListener;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;

class QFSFeedChildInteractPresenter$1
  implements QCircleFollowView.FollowReportListener
{
  QFSFeedChildInteractPresenter$1(QFSFeedChildInteractPresenter paramQFSFeedChildInteractPresenter, QFSPlusFollowView paramQFSPlusFollowView) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (this.b.b())
    {
      QFSFeedChildInteractPresenter localQFSFeedChildInteractPresenter = this.b;
      QFSFeedChildInteractPresenter.a(localQFSFeedChildInteractPresenter, 80, 1, localQFSFeedChildInteractPresenter.e(), "");
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.b;
    QFSFeedChildInteractPresenter.a((QFSFeedChildInteractPresenter)localObject, 80, 2, ((QFSFeedChildInteractPresenter)localObject).e(), "");
    VideoReport.setElementId(this.a, "em_xsj_multimedia");
    localObject = new HashMap();
    ((Map)localObject).put("xsj_action_type", "follow");
    QFSFeedChildInteractPresenter.a(this.b, this.a, "ev_xsj_follow", (Map)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildInteractPresenter.1
 * JD-Core Version:    0.7.0.1
 */