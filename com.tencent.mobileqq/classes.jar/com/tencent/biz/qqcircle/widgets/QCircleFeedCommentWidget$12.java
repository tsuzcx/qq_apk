package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper.MenuClickListener;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper.MenuType;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo.Builder;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo.ContentIdBuilder;
import com.tencent.biz.qqcircle.utils.QCircleCopyUtils;
import com.tencent.biz.qqcircle.utils.QCircleEvilReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class QCircleFeedCommentWidget$12
  implements QCirclePopupWindowHelper.MenuClickListener
{
  QCircleFeedCommentWidget$12(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    if (this.d.getContext() == null)
    {
      QLog.e("QCircleFeedCommentWidget", 1, "onSticky mContext is null");
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.c)
    {
      QCircleCopyUtils.a(this.d.getContext(), this.a.content.get());
      return;
    }
    String str;
    if (paramInt == QCirclePopupWindowHelper.MenuType.e)
    {
      if (QCirclePluginUtil.b((FeedCloudMeta.StUser)this.a.postUser.get())) {
        paramInt = 0;
      } else {
        paramInt = 2;
      }
      str = this.d.getContext().getString(2131895887);
      QCircleFeedCommentWidget.a(this.d, str, new QCircleFeedCommentWidget.12.1(this, paramInt), new QCircleFeedCommentWidget.12.2(this));
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.d)
    {
      str = new QCircleEvilReportInfo.ContentIdBuilder().e(String.valueOf(this.a.createTime.get())).c(this.c.id.get()).d(this.a.id.get()).a(this.b.poster.id.get()).b(this.b.id.get()).a();
      QCircleEvilReportUtils.a(new QCircleEvilReportInfo.Builder().c("wezone_reply").d("25042").e(this.a.postUser.id.get()).g(str).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget.12
 * JD-Core Version:    0.7.0.1
 */