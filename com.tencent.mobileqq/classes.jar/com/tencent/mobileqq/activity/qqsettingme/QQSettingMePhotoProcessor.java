package com.tencent.mobileqq.activity.qqsettingme;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QQSettingMePhotoProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public String a()
  {
    return "d_album";
  }
  
  public void a(View paramView)
  {
    paramView = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    Object localObject = paramView.getAppInfoByPath(String.valueOf(100180));
    boolean bool;
    if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      paramView.reportLevelOneRedInfo(100180, 31);
    }
    localObject = new QZoneClickReport.ReportInfo();
    ((QZoneClickReport.ReportInfo)localObject).setActionType("443");
    ((QZoneClickReport.ReportInfo)localObject).setSubactionType("3");
    ((QZoneClickReport.ReportInfo)localObject).setToUin(this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin());
    if (bool) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ((QZoneClickReport.ReportInfo)localObject).setReserves(paramView);
    QZoneClickReport.startReportImediately(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), (QZoneClickReport.ReportInfo)localObject);
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin()).longValue();
      l1 = l2;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = String.valueOf(l1);
    localObject = ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentNickname();
    paramView = (View)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = ContactUtils.e((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
    }
    localUserInfo.nickname = paramView;
    QZoneHelper.forwardFromQQSettingToPersonalAlbum(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localUserInfo, Long.valueOf(l1), 0, bool, -1);
    paramView = new QZoneClickReport.ReportInfo();
    paramView.actionType = "1";
    paramView.subactionType = "0";
    paramView.tabletype = 4;
    paramView.sourceType = "3";
    paramView.sourceFrom = "drawerAlbumList";
    paramView.sourceTo = "QZonePhotoListActivity";
    QZoneClickReport.startReportImediately(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), paramView);
    paramView = new HashMap();
    paramView.put("source_type", "3");
    paramView.put("source_from", "drawerAlbumList");
    paramView.put("source_to", "QZonePhotoListActivity");
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramView, null);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
    com.tencent.mobileqq.activity.recent.DrawerFrame.a = QQSettingMe.a;
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      ((QzoneAlbumRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH)).a(paramAppInfo);
    }
    super.a(paramAppInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMePhotoProcessor
 * JD-Core Version:    0.7.0.1
 */