package com.tencent.biz.qqcircle.bizparts;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.comment.QCircleCommentBusiness;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.HashMap;
import java.util.Map;

class QCircleCommentPanelPart$9$1
  implements DialogInterface.OnClickListener
{
  QCircleCommentPanelPart$9$1(QCircleCommentPanelPart.9 param9, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QCircleCommentPanelPart.g(this.b.c).a(this.b.c.c().hashCode(), QCircleCommentPanelPart.f(this.b.c), this.b.b, this.b.a, this.a, QCircleCommentPanelPart.b(this.b.c));
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("xsj_cmt_id", this.b.b.id.get());
    paramDialogInterface.put("xsj_reply_id", this.b.a.id.get());
    QCircleCommentPanelPart.a(this.b.c, "ev_xsj_reply_action", "delete", this.b.a.postUser.id.get(), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.9.1
 * JD-Core Version:    0.7.0.1
 */