package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper.MenuClickListener;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper.MenuType;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo.Builder;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo.ContentIdBuilder;
import com.tencent.biz.qqcircle.comment.QCircleCommentBusiness;
import com.tencent.biz.qqcircle.utils.QCircleCopyUtils;
import com.tencent.biz.qqcircle.utils.QCircleEvilReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class QCircleFeedCommentWidget$9
  implements QCirclePopupWindowHelper.MenuClickListener
{
  QCircleFeedCommentWidget$9(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    if (this.c.getContext() == null)
    {
      QLog.e("QCircleFeedCommentWidget", 1, "onSticky mContext is null");
      return;
    }
    String str;
    if (paramInt == QCirclePopupWindowHelper.MenuType.a)
    {
      if (QCircleFeedCommentWidget.c(this.c).a(this.a, this.b))
      {
        str = this.c.getContext().getString(2131895885);
        QCircleFeedCommentWidget.a(this.c, str, new QCircleFeedCommentWidget.9.1(this), new QCircleFeedCommentWidget.9.2(this));
        return;
      }
      QCircleFeedCommentWidget.c(this.c).a(this.c.getContext().hashCode(), this.a, this.b);
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.b)
    {
      str = this.c.getContext().getString(2131895647);
      QCircleFeedCommentWidget.a(this.c, str, new QCircleFeedCommentWidget.9.3(this), new QCircleFeedCommentWidget.9.4(this));
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.c)
    {
      QCircleCopyUtils.a(this.c.getContext(), this.b.content.get());
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.e)
    {
      if (QCirclePluginUtil.b((FeedCloudMeta.StUser)this.b.postUser.get())) {
        paramInt = 0;
      } else {
        paramInt = 2;
      }
      str = this.c.getContext().getString(2131895653);
      QCircleFeedCommentWidget.a(this.c, str, new QCircleFeedCommentWidget.9.5(this, paramInt), new QCircleFeedCommentWidget.9.6(this));
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.d)
    {
      str = new QCircleEvilReportInfo.ContentIdBuilder().e(String.valueOf(this.b.createTime.get())).c(this.b.id.get()).a(this.a.poster.id.get()).b(this.a.id.get()).a();
      QCircleEvilReportUtils.a(new QCircleEvilReportInfo.Builder().c("wezone_comment").d("25041").e(this.b.postUser.id.get()).g(str).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget.9
 * JD-Core Version:    0.7.0.1
 */