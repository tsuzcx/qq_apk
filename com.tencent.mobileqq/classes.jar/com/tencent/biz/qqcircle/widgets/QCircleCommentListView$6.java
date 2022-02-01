package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
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
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class QCircleCommentListView$6
  implements QCirclePopupWindowHelper.MenuClickListener
{
  QCircleCommentListView$6(QCircleCommentListView paramQCircleCommentListView, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    String str;
    if (paramInt == QCirclePopupWindowHelper.MenuType.a)
    {
      QCircleCommentListView.a(this.b, 48);
      if (QCircleCommentListView.d(this.b).a(this.b.getFeedData(), this.a))
      {
        str = this.b.getContext().getResources().getString(2131895885);
        QCircleCustomDialog.a(this.b.getContext(), str, null, 2131887648, 2131887629, new QCircleCommentListView.6.1(this), new QCircleCommentListView.6.2(this)).show();
        return;
      }
      QCircleCommentListView.d(this.b).a(this.b.getContext().hashCode(), this.b.getFeedData(), this.a);
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.b)
    {
      QCircleCommentListView.a(this.b, 49);
      str = this.b.getContext().getResources().getString(2131895647);
      QCircleCustomDialog.a(this.b.getContext(), str, null, 2131887648, 2131887629, new QCircleCommentListView.6.3(this), new QCircleCommentListView.6.4(this)).show();
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.c)
    {
      QCircleCommentListView.a(this.b, 46);
      QCircleCopyUtils.a(this.b.getContext(), this.a.content.get());
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.e)
    {
      QCircleCommentListView.a(this.b, 47);
      if (QCirclePluginUtil.b((FeedCloudMeta.StUser)this.a.postUser.get())) {
        paramInt = 0;
      } else {
        paramInt = 2;
      }
      str = this.b.getContext().getResources().getString(2131895653);
      QCircleCustomDialog.a(this.b.getContext(), str, null, 2131887648, 2131887629, new QCircleCommentListView.6.5(this, paramInt), new QCircleCommentListView.6.6(this)).show();
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.d)
    {
      str = new QCircleEvilReportInfo.ContentIdBuilder().b(this.b.getFeedData().id.get()).c(this.a.id.get()).e(String.valueOf(this.a.createTime.get())).a();
      QCircleEvilReportUtils.a(new QCircleEvilReportInfo.Builder().e(this.a.postUser.id.get()).d("25014").c("wezone_comment").g(str).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentListView.6
 * JD-Core Version:    0.7.0.1
 */