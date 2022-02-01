package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.adapter.QCircleMessageReplyAdapter;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper.CommentInputListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class QCircleReplyMessagePresenter$3
  implements QCircleCommentHelper.CommentInputListener
{
  QCircleReplyMessagePresenter$3(QCircleReplyMessagePresenter paramQCircleReplyMessagePresenter) {}
  
  public void a(int paramInt) {}
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addFakeComment stComment");
    localStringBuilder.append(paramStComment.id.get());
    QLog.d("QCircleReplyMessagePresenter", 1, localStringBuilder.toString());
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addFakeReply stReply");
    ((StringBuilder)localObject).append(paramStReply.id.get());
    QLog.d("QCircleReplyMessagePresenter", 1, ((StringBuilder)localObject).toString());
    QCircleFeedCommentInfo localQCircleFeedCommentInfo = QCircleReplyMessagePresenter.c(this.a);
    if (localQCircleFeedCommentInfo != null)
    {
      int i = this.a.l;
      localObject = "";
      QCircleReplyMessagePresenter localQCircleReplyMessagePresenter;
      if (i == 1)
      {
        localQCircleReplyMessagePresenter = this.a;
        if (localQCircleFeedCommentInfo.b != null) {
          localObject = localQCircleFeedCommentInfo.b.postUser.id.get();
        }
        QCircleReplyMessagePresenter.a(localQCircleReplyMessagePresenter, localQCircleFeedCommentInfo, 7, (String)localObject);
      }
      else if (this.a.l == 2)
      {
        localQCircleReplyMessagePresenter = this.a;
        if (localQCircleFeedCommentInfo.c != null) {
          localObject = localQCircleFeedCommentInfo.c.postUser.id.get();
        }
        QCircleReplyMessagePresenter.a(localQCircleReplyMessagePresenter, localQCircleFeedCommentInfo, 11, (String)localObject);
      }
      localQCircleFeedCommentInfo.c = paramStReply;
      paramStReply = QCircleReplyMessagePresenter.d(this.a);
      if (!TextUtils.isEmpty(paramStReply))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFakeReplysKey");
        ((StringBuilder)localObject).append(paramStReply);
        QLog.d("QCircleReplyMessagePresenter", 1, ((StringBuilder)localObject).toString());
        paramStReply = QCircleCommentHelper.a().a(paramStReply, localQCircleFeedCommentInfo);
        QCircleReplyMessagePresenter.e(this.a).a(paramStReply);
        QCircleReplyMessagePresenter.e(this.a).notifyDataSetChanged();
        return;
      }
      QLog.d("QCircleReplyMessagePresenter", 1, "getFakeReplysKey error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleReplyMessagePresenter.3
 * JD-Core Version:    0.7.0.1
 */