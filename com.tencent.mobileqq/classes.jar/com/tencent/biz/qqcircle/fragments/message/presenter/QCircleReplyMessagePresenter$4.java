package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

class QCircleReplyMessagePresenter$4
  implements View.OnClickListener
{
  QCircleReplyMessagePresenter$4(QCircleReplyMessagePresenter paramQCircleReplyMessagePresenter, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if ((this.a instanceof Activity)) {
      if (!QCircleBindPhoneNumberHelper.a())
      {
        QCircleBindPhoneNumberHelper.a(this.a, 3);
      }
      else
      {
        QCircleFeedCommentInfo localQCircleFeedCommentInfo = QCircleReplyMessagePresenter.c(this.b);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startReply getFeedCommentInfo is");
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
          int i = this.b.l;
          localObject = "";
          QCircleReplyMessagePresenter localQCircleReplyMessagePresenter;
          if (i == 1)
          {
            localQCircleReplyMessagePresenter = this.b;
            if (localQCircleFeedCommentInfo.b != null) {
              localObject = localQCircleFeedCommentInfo.b.id.get();
            }
            QCircleReplyMessagePresenter.a(localQCircleReplyMessagePresenter, localQCircleFeedCommentInfo, 6, (String)localObject);
          }
          else if (this.b.l == 2)
          {
            localQCircleReplyMessagePresenter = this.b;
            if (localQCircleFeedCommentInfo.c != null) {
              localObject = localQCircleFeedCommentInfo.c.id.get();
            }
            QCircleReplyMessagePresenter.a(localQCircleReplyMessagePresenter, localQCircleFeedCommentInfo, 10, (String)localObject);
          }
          QCircleCommentHelper.a().a((Activity)this.a, localQCircleFeedCommentInfo, QCircleReplyMessagePresenter.a(this.b), QCircleReplyMessagePresenter.b(this.b));
          QCircleReplyMessagePresenter.a(this.b, paramView);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleReplyMessagePresenter.4
 * JD-Core Version:    0.7.0.1
 */