package com.tencent.biz.qqcircle.comment;

import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout.OnClickHookListener;
import com.tencent.biz.qqcircle.widgets.comment.OnCommentElementClickListener;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

class QCircleReplyItemView$1
  implements QCircleCommentPraiseLayout.OnClickHookListener
{
  QCircleReplyItemView$1(QCircleReplyItemView paramQCircleReplyItemView) {}
  
  public void a(boolean paramBoolean)
  {
    if (QCircleReplyItemView.a(this.a) != null)
    {
      FeedCloudMeta.StComment localStComment = QCircleReplyItemView.b(this.a);
      FeedCloudMeta.StReply localStReply = QCircleReplyItemView.c(this.a);
      OnCommentElementClickListener localOnCommentElementClickListener = QCircleReplyItemView.a(this.a);
      QCircleCommentPraiseLayout localQCircleCommentPraiseLayout = QCircleReplyItemView.d(this.a);
      int i;
      if (paramBoolean) {
        i = 14;
      } else {
        i = 15;
      }
      localOnCommentElementClickListener.a(localQCircleCommentPraiseLayout, i, QCircleReplyItemView.e(this.a), new Object[] { localStComment, localStReply });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleReplyItemView.1
 * JD-Core Version:    0.7.0.1
 */