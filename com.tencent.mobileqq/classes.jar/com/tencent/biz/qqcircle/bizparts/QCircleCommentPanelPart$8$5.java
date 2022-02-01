package com.tencent.biz.qqcircle.bizparts;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.comment.QCircleCommentBusiness;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StUser;

class QCircleCommentPanelPart$8$5
  implements DialogInterface.OnClickListener
{
  QCircleCommentPanelPart$8$5(QCircleCommentPanelPart.8 param8, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QCircleCommentPanelPart.g(this.b.b).a(this.b.b.c().hashCode(), QCircleCommentPanelPart.f(this.b.b), this.b.a, this.a, QCircleCommentPanelPart.b(this.b.b));
    QCircleCommentPanelPart.a(this.b.b, "ev_xsj_cmt_action", "delete", this.b.a.postUser.id.get(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.8.5
 * JD-Core Version:    0.7.0.1
 */