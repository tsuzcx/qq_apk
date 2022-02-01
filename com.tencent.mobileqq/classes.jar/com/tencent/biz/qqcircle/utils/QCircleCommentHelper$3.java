package com.tencent.biz.qqcircle.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.qqcircle.comment.QCircleCommentInputPopupWindow;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

class QCircleCommentHelper$3
  implements DialogInterface.OnShowListener
{
  QCircleCommentHelper$3(QCircleCommentHelper paramQCircleCommentHelper, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, QCircleCommentInputPopupWindow paramQCircleCommentInputPopupWindow) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = QCircleCommentHelper.a().a(this.a, this.b, this.c);
    QCircleCommentInputPopupWindow localQCircleCommentInputPopupWindow = this.d;
    localQCircleCommentInputPopupWindow.a(localQCircleCommentInputPopupWindow.c(paramDialogInterface));
    this.d.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleCommentHelper.3
 * JD-Core Version:    0.7.0.1
 */