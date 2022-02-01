package com.tencent.biz.qqcircle.bizparts;

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
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class QCircleCommentPanelPart$8
  implements QCirclePopupWindowHelper.MenuClickListener
{
  QCircleCommentPanelPart$8(QCircleCommentPanelPart paramQCircleCommentPanelPart, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    String str;
    if (paramInt == QCirclePopupWindowHelper.MenuType.a)
    {
      QCircleCommentPanelPart.a(this.b, 48);
      if (QCircleCommentPanelPart.g(this.b).a(QCircleCommentPanelPart.f(this.b), this.a))
      {
        str = this.b.g().getResources().getString(2131895885);
        QCircleCustomDialog.a(this.b.g(), str, null, 2131887648, 2131887629, new QCircleCommentPanelPart.8.1(this), new QCircleCommentPanelPart.8.2(this)).show();
        return;
      }
      QCircleCommentPanelPart.g(this.b).a(this.b.c().hashCode(), QCircleCommentPanelPart.f(this.b), this.a);
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.b)
    {
      QCircleCommentPanelPart.a(this.b, 49);
      str = this.b.g().getResources().getString(2131895647);
      QCircleCustomDialog.a(this.b.g(), str, null, 2131887648, 2131887629, new QCircleCommentPanelPart.8.3(this), new QCircleCommentPanelPart.8.4(this)).show();
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.c)
    {
      QCircleCommentPanelPart.a(this.b, 46);
      QCircleCopyUtils.a(this.b.g(), this.a.content.get());
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.e)
    {
      QCircleCommentPanelPart.a(this.b, 47);
      if (QCirclePluginUtil.b((FeedCloudMeta.StUser)this.a.postUser.get())) {
        paramInt = 0;
      } else {
        paramInt = 2;
      }
      str = this.b.g().getResources().getString(2131895653);
      QCircleCustomDialog.a(this.b.g(), str, null, 2131887648, 2131887629, new QCircleCommentPanelPart.8.5(this, paramInt), new QCircleCommentPanelPart.8.6(this)).show();
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.d)
    {
      str = new QCircleEvilReportInfo.ContentIdBuilder().b(QCircleCommentPanelPart.f(this.b).id.get()).c(this.a.id.get()).a(QCircleCommentPanelPart.f(this.b).poster.id.get()).e(String.valueOf(this.a.createTime.get())).a();
      QCircleEvilReportUtils.a(new QCircleEvilReportInfo.Builder().c("wezone_comment").g(str).e(this.a.postUser.id.get()).d("25041").a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.8
 * JD-Core Version:    0.7.0.1
 */