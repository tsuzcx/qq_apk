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
  public String a()
  {
    return "d_favorite";
  }
  
  public void a(View paramView)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow();
    QfavHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), null, -1, bool ^ true);
    QfavReport.b(this.jdField_a_of_type_MqqAppAppRuntime, 1, 0);
    QfavUtil.a(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
    com.tencent.mobileqq.activity.recent.DrawerFrame.a = QQSettingMe.a;
    paramView = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = paramView.getAppInfoByPath(String.valueOf(103000));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
      paramView.reportLevelOneRedInfo(103000, 31);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeQFavProcessor
 * JD-Core Version:    0.7.0.1
 */