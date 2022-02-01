package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.OnDismissListener;
import com.tencent.biz.qqcircle.comment.QCircleCommentInputPopupWindow;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

class QCircleCommentHelper$4
  implements QCircleBaseInputPopupWindow.OnDismissListener
{
  QCircleCommentHelper$4(QCircleCommentHelper paramQCircleCommentHelper, QCircleCommentInputPopupWindow paramQCircleCommentInputPopupWindow, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, QCircleCommentHelper.CommentInputListener paramCommentInputListener, int paramInt) {}
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((QCircleCommentInputPopupWindow)localObject).b("");
      QCircleCommentHelper.a().a(this.b, this.c, this.d, this.a.g());
      this.a.a("");
      this.a.b(this.g.a(null, null));
    }
    QCircleCommentHelper.a(this.g, null);
    QCircleCommentHelper.a(this.g, null);
    localObject = this.e;
    if (localObject != null) {
      ((QCircleCommentHelper.CommentInputListener)localObject).a(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleCommentHelper.4
 * JD-Core Version:    0.7.0.1
 */