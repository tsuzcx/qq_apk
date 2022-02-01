package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class QCircleReplyMessagePresenter$5
  implements View.OnClickListener
{
  QCircleReplyMessagePresenter$5(QCircleReplyMessagePresenter paramQCircleReplyMessagePresenter) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.callOnClick();
    }
    QCircleFeedCommentInfo localQCircleFeedCommentInfo = QCircleReplyMessagePresenter.c(this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tvTime getFeedCommentInfo is");
    boolean bool;
    if (localQCircleFeedCommentInfo != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.d("QCircleReplyMessagePresenter", 1, ((StringBuilder)localObject).toString());
    if (localQCircleFeedCommentInfo != null)
    {
      QCircleReplyMessagePresenter localQCircleReplyMessagePresenter = this.a;
      if (localQCircleFeedCommentInfo.c != null) {
        localObject = localQCircleFeedCommentInfo.c.postUser.id.get();
      } else {
        localObject = "";
      }
      QCircleReplyMessagePresenter.a(localQCircleReplyMessagePresenter, localQCircleFeedCommentInfo, 2, (String)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleReplyMessagePresenter.5
 * JD-Core Version:    0.7.0.1
 */