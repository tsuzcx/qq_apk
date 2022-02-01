package com.tencent.biz.qqcircle.comment;

import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.OnClickBoldTextListener;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class QCircleReplyItemView$2
  implements QCircleAsyncTextView.OnClickBoldTextListener
{
  QCircleReplyItemView$2(QCircleReplyItemView paramQCircleReplyItemView, FeedCloudMeta.StReply paramStReply) {}
  
  public void a()
  {
    QCircleReplyItemView.a(this.b, this.a.targetUser.id.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleReplyItemView.2
 * JD-Core Version:    0.7.0.1
 */