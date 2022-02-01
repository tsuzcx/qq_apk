package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper.CommentInputListener;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class QCircleCommentListView$8
  implements QCircleCommentHelper.CommentInputListener
{
  QCircleCommentListView$8(QCircleCommentListView paramQCircleCommentListView, FeedCloudMeta.StComment paramStComment) {}
  
  private void a(boolean paramBoolean, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (QCircleCommentListView.e(this.b))
    {
      paramStComment = this.b;
      QCircleCommentListView.a(paramStComment, QCircleCommentListView.h(paramStComment), 3, QCircleCommentListView.i(this.b));
      return;
    }
    if (QCircleCommentListView.i(this.b) != null) {
      paramStComment = QCircleCommentListView.i(this.b).mFeed;
    } else {
      paramStComment = null;
    }
    paramStReply = QCirclePluginReportUtil.b(paramStComment).setActionType(QCircleCommentListView.h(this.b)).setSubActionType(3);
    if ((QCircleCommentListView.i(this.b) != null) && (QCircleCommentListView.i(this.b).mFeed != null)) {
      paramStComment = QCircleCommentListView.i(this.b).mFeed.poster.id.get();
    } else {
      paramStComment = "";
    }
    paramStComment = paramStReply.setToUin(paramStComment);
    int i;
    if (QCircleCommentListView.i(this.b) != null) {
      i = QCircleCommentListView.i(this.b).mDataPosition;
    } else {
      i = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramStComment.setIndex(i).setPageId(this.b.getPageId())));
  }
  
  public void a(int paramInt) {}
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    if (QCircleCommentListView.b(this.b) != null)
    {
      QCircleCommentListView.b(this.b).a(paramStComment);
      QCircleCommentListView.g(this.b);
    }
    if (QCircleCommentListView.f(this.b) != null)
    {
      QLog.d("QCircleCommentPanelPart", 1, "mNeedShowCommentList1");
      QCircleCommentListView.f(this.b).getRecyclerView().scrollToPosition(0);
    }
    a(true, paramStComment, null);
  }
  
  public void a(FeedCloudMeta.StReply paramStReply)
  {
    if (QCircleCommentListView.b(this.b) != null)
    {
      int i = QCircleCommentListView.a(this.b, this.a.id.get());
      QCircleCommentListView.b(this.b).a(this.a.id.get(), paramStReply);
      if ((i != -1) && (QCircleCommentListView.f(this.b) != null)) {
        QCircleCommentListView.f(this.b).getRecyclerView().scrollBy(0, i);
      }
    }
    a(false, null, paramStReply);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentListView.8
 * JD-Core Version:    0.7.0.1
 */