package com.tencent.biz.qqcircle.bizparts;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

class QCirclePersonalTitleBarPart$11
  implements ActionSheet.OnButtonClickListener
{
  QCirclePersonalTitleBarPart$11(QCirclePersonalTitleBarPart paramQCirclePersonalTitleBarPart, ActionSheet paramActionSheet, String paramString) {}
  
  public void a(View paramView, int paramInt)
  {
    if (!FastClickUtils.a("showMoreActionSheetClick"))
    {
      paramView = this.a.d(paramInt);
      if (TextUtils.isEmpty(paramView)) {
        return;
      }
      if (paramView.equals(this.c.g().getResources().getString(2131895766)))
      {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePersonalTitleBarPart.c(this.c).id.get()).setActionType(11).setSubActionType(31).setThrActionType(2));
        QCircleLauncher.a(this.c.g(), this.b, null, -1);
      }
      else if (paramView.equals(this.c.g().getResources().getString(2131895943)))
      {
        QCircleLauncher.a(this.c.g(), "https://h5.qzone.qq.com/v2/wezone/wallet?_wv=3&_proxy=1", null, -1);
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePersonalTitleBarPart.c(this.c).id.get()).setActionType(11).setSubActionType(34).setThrActionType(2));
      }
      else if (paramView.equals(this.c.g().getResources().getString(2131895910)))
      {
        QCirclePersonalTitleBarPart.k(this.c);
      }
      else if (paramView.equals(this.c.g().getResources().getString(2131895907)))
      {
        paramView = QCirclePersonalTitleBarPart.l(this.c);
        boolean bool2 = true;
        boolean bool1;
        if ((paramView != null) && (QCirclePluginUtil.b(QCirclePersonalTitleBarPart.l(this.c).opMask.get()))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if ((QCirclePersonalTitleBarPart.l(this.c) == null) || (!QCirclePluginUtil.c(QCirclePersonalTitleBarPart.l(this.c).opMask.get()))) {
          bool2 = false;
        }
        paramView = new QCircleSettingBean();
        paramView.setCanJumpProfile(bool1);
        paramView.setCanSyncTroopARK(bool2);
        paramView.setFromReportBean(this.c.d().clone());
        QCircleLauncher.a(this.c.g(), paramView);
      }
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.11
 * JD-Core Version:    0.7.0.1
 */