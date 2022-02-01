package com.tencent.biz.qqcircle.bizparts;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper.MenuClickListener;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper.MenuType;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo.Builder;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo.ContentIdBuilder;
import com.tencent.biz.qqcircle.utils.QCircleCopyUtils;
import com.tencent.biz.qqcircle.utils.QCircleEvilReportUtils;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class QCircleCommentPanelPart$9
  implements QCirclePopupWindowHelper.MenuClickListener
{
  QCircleCommentPanelPart$9(QCircleCommentPanelPart paramQCircleCommentPanelPart, FeedCloudMeta.StReply paramStReply, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    if (paramInt == QCirclePopupWindowHelper.MenuType.c)
    {
      QCircleCopyUtils.a(this.c.g(), this.a.content.get());
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
      str = this.c.g().getResources().getString(2131895887);
      QCircleCustomDialog.a(this.c.g(), str, null, 2131887648, 2131887629, new QCircleCommentPanelPart.9.1(this, paramInt), new QCircleCommentPanelPart.9.2(this)).show();
      return;
    }
    if (paramInt == QCirclePopupWindowHelper.MenuType.d)
    {
      str = new QCircleEvilReportInfo.ContentIdBuilder().b(QCircleCommentPanelPart.f(this.c).id.get()).c(this.b.id.get()).a(QCircleCommentPanelPart.f(this.c).poster.id.get()).d(this.a.id.get()).e(String.valueOf(this.a.createTime.get())).a();
      QCircleEvilReportUtils.a(new QCircleEvilReportInfo.Builder().c("wezone_reply").g(str).e(this.a.postUser.id.get()).d("25042").a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.9
 * JD-Core Version:    0.7.0.1
 */