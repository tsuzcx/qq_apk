package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper.CommentInputListener;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.HashMap;
import java.util.Map;

class QCircleCommentPanelPart$10
  implements QCircleCommentHelper.CommentInputListener
{
  QCircleCommentPanelPart$10(QCircleCommentPanelPart paramQCircleCommentPanelPart, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt) {}
  
  private void a(boolean paramBoolean, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (QCircleCommentPanelPart.e(this.d) != null)
    {
      if (QCircleCommentPanelPart.e(this.d).mFeed == null) {
        return;
      }
      if (QCircleCommentPanelPart.b(this.d))
      {
        if (this.c == 103) {
          QCircleCommentPanelPart.b(this.d, 7);
        }
        paramStComment = this.d;
        QCircleCommentPanelPart.a(paramStComment, QCircleCommentPanelPart.l(paramStComment), 3, QCircleCommentPanelPart.e(this.d));
        return;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(QCircleCommentPanelPart.e(this.d).mFeed).setActionType(QCircleCommentPanelPart.l(this.d)).setSubActionType(3).setToUin(QCircleCommentPanelPart.e(this.d).mFeed.poster.id.get()).setIndex(QCircleCommentPanelPart.e(this.d).mDataPosition).setPageId(this.d.f())));
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 103) && (QCircleCommentPanelPart.a(this.d) != null)) {
      QCircleCommentPanelPart.a(this.d).f();
    }
  }
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    if (QCircleCommentPanelPart.h(this.d) != null)
    {
      QCircleCommentPanelPart.h(this.d).a(paramStComment);
      QCircleCommentPanelPart.j(this.d);
    }
    if (QCircleCommentPanelPart.i(this.d) != null)
    {
      QLog.d("QCircleCommentPanelPart", 1, "mNeedShowCommentList1");
      QCircleCommentPanelPart.i(this.d).getRecyclerView().scrollToPosition(0);
    }
    a(true, paramStComment, null);
    if ((QCircleCommentPanelPart.k(this.d) != null) && (QCircleCommentPanelPart.k(this.d).b != null)) {
      paramStComment = QCircleCommentPanelPart.k(this.d).b.poster.id.get();
    } else {
      paramStComment = "";
    }
    QCircleCommentPanelPart.a(this.d, "ev_xsj_cmt_action", "cmt", paramStComment, null);
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    if (this.a != null)
    {
      if (QCircleCommentPanelPart.h(this.d) == null) {
        return;
      }
      QCircleCommentPanelPart localQCircleCommentPanelPart = this.d;
      String str = this.a.id.get();
      Object localObject = this.b;
      if (localObject != null) {
        localObject = ((FeedCloudMeta.StReply)localObject).id.get();
      } else {
        localObject = "";
      }
      int i = QCircleCommentPanelPart.a(localQCircleCommentPanelPart, str, (String)localObject);
      QCircleCommentPanelPart.h(this.d).a(this.a.id.get(), paramStReply);
      if ((i != -1) && (QCircleCommentPanelPart.i(this.d) != null)) {
        QCircleCommentPanelPart.i(this.d).getRecyclerView().scrollBy(0, i);
      }
      a(false, null, paramStReply);
      localObject = new HashMap();
      ((Map)localObject).put("xsj_cmt_id", this.a.id.get());
      paramStReply = this.b;
      if (paramStReply != null) {
        ((Map)localObject).put("xsj_reply_id", paramStReply.id.get());
      }
      paramStReply = this.b;
      if (paramStReply != null) {
        paramStReply = paramStReply.postUser.id;
      } else {
        paramStReply = this.a.postUser.id;
      }
      paramStReply = paramStReply.get();
      QCircleCommentPanelPart.a(this.d, "ev_xsj_reply_action", "reply", paramStReply, (Map)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.10
 * JD-Core Version:    0.7.0.1
 */