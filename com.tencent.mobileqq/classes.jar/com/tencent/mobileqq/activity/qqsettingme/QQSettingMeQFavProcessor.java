package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import mqq.app.AppRuntime;

public class QQSettingMeQFavProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public void a(View paramView)
  {
    boolean bool = this.d.isInMultiWindow();
    QfavHelper.a(this.d, this.c.getAccount(), null, -1, bool ^ true);
    QfavReport.b(this.c, 1, 0);
    QfavUtil.a(this.c.getCurrentAccountUin());
    com.tencent.mobileqq.activity.recent.DrawerFrame.b = QQSettingMe.a;
    paramView = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = paramView.getAppInfoByPath(String.valueOf(103000));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
      paramView.reportLevelOneRedInfo(103000, 31);
    }
  }
  
  public String b()
  {
    return "d_favorite";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeQFavProcessor
 * JD-Core Version:    0.7.0.1
 */