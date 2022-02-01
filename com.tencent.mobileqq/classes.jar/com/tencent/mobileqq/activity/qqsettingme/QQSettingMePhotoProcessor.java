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
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QQSettingMePhotoProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public void a(View paramView)
  {
    paramView = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
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
    ((QZoneClickReport.ReportInfo)localObject).setToUin(this.c.getLongAccountUin());
    if (bool) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ((QZoneClickReport.ReportInfo)localObject).setReserves(paramView);
    QZoneClickReport.startReportImediately(this.c.getCurrentAccountUin(), (QZoneClickReport.ReportInfo)localObject);
    LpReportInfo_pf00064.report(326, 30, 2);
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(this.c.getCurrentAccountUin()).longValue();
      l1 = l2;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = String.valueOf(l1);
    localObject = ((QQAppInterface)this.c).getCurrentNickname();
    paramView = (View)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = ContactUtils.f((QQAppInterface)this.c, this.c.getCurrentAccountUin());
    }
    localUserInfo.nickname = paramView;
    QZoneHelper.forwardFromQQSettingToPersonalAlbum(this.d, localUserInfo, Long.valueOf(l1), 0, bool, -1);
    paramView = new QZoneClickReport.ReportInfo();
    paramView.actionType = "1";
    paramView.subactionType = "0";
    paramView.tabletype = 4;
    paramView.sourceType = "3";
    paramView.sourceFrom = "drawerAlbumList";
    paramView.sourceTo = "QZonePhotoListActivity";
    QZoneClickReport.startReportImediately(this.c.getAccount(), paramView);
    paramView = new HashMap();
    paramView.put("source_type", "3");
    paramView.put("source_from", "drawerAlbumList");
    paramView.put("source_to", "QZonePhotoListActivity");
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.c.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramView, null);
    ReportController.b(this.c, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
    com.tencent.mobileqq.activity.recent.DrawerFrame.b = QQSettingMe.a;
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if (this.g) {
      ((QzoneAlbumRedTouchManager)this.c.getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH)).a(paramAppInfo);
    }
    super.a(paramAppInfo, paramBoolean);
  }
  
  public String b()
  {
    return "d_album";
  }
  
  protected void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if ((QQSettingMe.b("d_album") != null) && (QQSettingMe.b("d_album").getVisibility() == 0)) {
      LpReportInfo_pf00064.report(326, 30, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMePhotoProcessor
 * JD-Core Version:    0.7.0.1
 */