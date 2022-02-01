package com.tencent.biz.qqcircle.immersive.personal.part;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;

class QFSPersonalTitleBarPart$12
  implements ActionSheet.OnButtonClickListener
{
  QFSPersonalTitleBarPart$12(QFSPersonalTitleBarPart paramQFSPersonalTitleBarPart, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    if (!FastClickUtils.a("showMoreActionSheetClick"))
    {
      paramView = this.a.d(paramInt);
      if (TextUtils.isEmpty(paramView)) {
        return;
      }
      if (paramView.equals(this.b.g().getResources().getString(2131895766)))
      {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QFSPersonalTitleBarPart.g(this.b).c).setActionType(11).setSubActionType(31).setThrActionType(2));
        QCircleLauncher.a(this.b.g(), QFSPersonalTitleBarPart.g(this.b).K, null, -1);
      }
      else if (paramView.equals(this.b.g().getResources().getString(2131895943)))
      {
        QCircleLauncher.a(this.b.g(), "https://h5.qzone.qq.com/v2/wezone/wallet?_wv=3&_proxy=1", null, -1);
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QFSPersonalTitleBarPart.g(this.b).c).setActionType(11).setSubActionType(34).setThrActionType(2));
      }
      else if (paramView.equals(this.b.g().getResources().getString(2131895910)))
      {
        QFSPersonalTitleBarPart.h(this.b);
      }
      else if (paramView.equals(this.b.g().getResources().getString(2131895907)))
      {
        paramView = QFSPersonalTitleBarPart.g(this.b).z;
        boolean bool2 = true;
        boolean bool1;
        if ((paramView != null) && (QCirclePluginUtil.b(QFSPersonalTitleBarPart.g(this.b).M))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if ((QFSPersonalTitleBarPart.g(this.b).z == null) || (!QCirclePluginUtil.c(QFSPersonalTitleBarPart.g(this.b).M))) {
          bool2 = false;
        }
        paramView = new QCircleSettingBean();
        paramView.setCanJumpProfile(bool1);
        paramView.setCanSyncTroopARK(bool2);
        paramView.setFromReportBean(this.b.l().clone());
        QCircleLauncher.a(this.b.g(), paramView);
      }
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart.12
 * JD-Core Version:    0.7.0.1
 */