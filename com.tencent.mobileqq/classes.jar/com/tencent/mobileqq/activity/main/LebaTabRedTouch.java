package com.tencent.mobileqq.activity.main;

import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedPointInfo;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class LebaTabRedTouch
{
  private static volatile LebaTabRedTouch.QZoneRedPointReportInfo a;
  public SplashActivity a;
  
  public LebaTabRedTouch(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
  }
  
  private int a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.QZONE_MANAGER);
    if (localQZoneManagerImp != null)
    {
      int j = localQZoneManagerImp.a(1);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + localQZoneManagerImp.a(1));
        i = j;
      }
    }
    return i;
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(TroopRedTouchManager paramTroopRedTouchManager, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsShowNewLeba=").append(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.mIsShowNewLeba);
    boolean bool5 = QQTheme.e();
    Map localMap = Collections.emptyMap();
    if (bool5) {
      localMap = a();
    }
    ILebaHelperService localILebaHelperService = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(ILebaHelperService.class, "");
    int j = paramTroopRedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
    int k = paramTroopRedTouchManager.a();
    if ((localILebaHelperService != null) && (localILebaHelperService.needShowRedDot(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 826L, bool5, localMap)))
    {
      i = 1;
      if (i != 0) {
        break label985;
      }
      k = 0;
    }
    label208:
    label978:
    label985:
    for (int i = 0;; i = j)
    {
      localStringBuilder.append("troop red point-->redPointNums= ").append(i).append(", redNumPointNums=").append(k).append(", isBuluoEntryShow=").append(k);
      ((LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(100510);
      paramTroopRedTouchManager = paramTroopRedTouchManager.a(paramTroopRedTouchManager.a(), false);
      boolean bool1;
      int m;
      boolean bool2;
      label246:
      boolean bool3;
      if (paramTroopRedTouchManager.a != -1)
      {
        bool1 = true;
        m = paramTroopRedTouchManager.b;
        if ((localILebaHelperService == null) || (!localILebaHelperService.needShowRedDot(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 7719L, bool5, localMap))) {
          break label893;
        }
        bool2 = true;
        if (bool2) {
          break label978;
        }
        bool3 = false;
        m = 0;
      }
      for (;;)
      {
        localStringBuilder.append("nearby red point-->nearbyNum= ").append(m).append(", nearbyHasRedPoint=").append(bool3).append(", isNearbyEntryShow=").append(bool2);
        paramTroopRedTouchManager = a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, bool5, localMap, localILebaHelperService);
        if ((paramTroopRedTouchManager != null) && (paramTroopRedTouchManager.red_type.get() == 5)) {}
        for (int n = Integer.parseInt(paramTroopRedTouchManager.red_content.get());; n = 0)
        {
          localStringBuilder.append("business red point-->numRedTouch=").append(n);
          int i4 = a();
          localStringBuilder.append("QZone red point-->qzonMsgCount=").append(i4);
          ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo = a();
          boolean bool4;
          if (localReadInJoyNotifyRedTouchInfo != null)
          {
            j = localReadInJoyNotifyRedTouchInfo.a();
            if ((localReadInJoyNotifyRedTouchInfo == null) || (!localReadInJoyNotifyRedTouchInfo.a())) {
              break label905;
            }
            bool1 = true;
            if ((localILebaHelperService == null) || (!localILebaHelperService.needShowRedDot(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 1130L, bool5, localMap))) {
              break label911;
            }
            bool2 = true;
            if (bool2) {
              break label965;
            }
            bool4 = false;
            j = 0;
          }
          for (;;)
          {
            localStringBuilder.append("readInJoy red point-->readInJoyNotifyCount=").append(j).append(", isReadinjoyNotifyNeedsDisplay=").append(bool4).append(", isKanDianEntryShow=").append(bool2);
            if ((paramRedDotInfo != null) && (paramRedDotInfo.uint32_appid.get() == 52) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getNowLiveManager().a) && (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getNowLiveManager().b())) {}
            for (int i1 = paramRedDotInfo.uint32_number.get();; i1 = 0)
            {
              boolean bool6 = ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, "redpoint_leba_show");
              bool1 = false;
              bool2 = false;
              if (bool6)
              {
                if ((localILebaHelperService != null) && (localILebaHelperService.needShowRedDot(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 7759L, bool5, localMap)))
                {
                  bool1 = true;
                  if ((!bool6) || (!bool1)) {
                    break label923;
                  }
                  bool2 = true;
                }
              }
              else
              {
                label604:
                localStringBuilder.append("confessRedPoit").append(bool2).append(",").append(bool6).append(",").append(bool1);
                if ((localILebaHelperService == null) || (!localILebaHelperService.needShowRedDot(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 7720L, bool5, localMap))) {
                  break label929;
                }
                i2 = 1;
                if (i2 == 0) {
                  break label953;
                }
              }
              for (int i2 = MatchChatMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);; i2 = 0)
              {
                localStringBuilder.append("matchChatRedNum,").append(i2);
                paramRedDotInfo = a();
                int i3;
                if (paramRedDotInfo == null)
                {
                  i3 = 0;
                  if ((paramRedDotInfo == null) || (!((Boolean)paramRedDotInfo.second).booleanValue())) {
                    break label950;
                  }
                  i += 1;
                }
                for (;;)
                {
                  i2 = i4 + n + k + j + m + i1 + i2 + i3;
                  QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify: totalCount=" + i2 + ", qz=" + i4 + ", numRedTouch=" + n + ", redNumPointNums=" + k + ", readInJoyNotifyCount=" + j + ", nearbyNum=" + m + ", storyRedNum=" + i1 + ", allPeopleVoteRedNumCount=" + localStringBuilder.toString());
                  return a(paramRedTypeInfo, i, bool3, paramTroopRedTouchManager, i4, bool4, bool2, i2);
                  i = 0;
                  break;
                  bool1 = false;
                  break label208;
                  label893:
                  bool2 = false;
                  break label246;
                  j = 0;
                  break label385;
                  bool1 = false;
                  break label401;
                  bool2 = false;
                  break label433;
                  bool1 = false;
                  break label591;
                  bool2 = false;
                  break label604;
                  i2 = 0;
                  break label669;
                  i3 = ((Integer)paramRedDotInfo.first).intValue();
                  break label711;
                }
              }
            }
            bool4 = bool1;
          }
        }
        bool3 = bool1;
      }
    }
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(QQAppInterface paramQQAppInterface, boolean paramBoolean, Map<Long, LebaPluginInfo> paramMap, ILebaHelperService paramILebaHelperService)
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    List localList1 = localRedTouchManager.b(0);
    if ((localList1 == null) || (localList1.size() == 0))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    List localList2 = localRedTouchManager.a();
    Object localObject = null;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = null;
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("getRedTouchInfoForLeba:redpoint path List:");
    int i = 0;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    label158:
    label346:
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2;
    if (i < localList1.size())
    {
      localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localList1.get(i);
      localStringBuilder.append(", for ").append(localAppInfo.path.get());
      if (localAppInfo.mission_level.get() != 0) {
        localStringBuilder.append(" mission_level ").append(localAppInfo.mission_level.get());
      }
      for (;;)
      {
        i += 1;
        break;
        if ((999999 == localAppInfo.uiAppId.get()) || (localAppInfo.path.get().contains(".")))
        {
          localStringBuilder.append(" second ");
        }
        else if (1130 == localAppInfo.uiAppId.get())
        {
          localStringBuilder.append(" exclude kandian ");
        }
        else if ((localAppInfo.iNewFlag.get() != 1) || (localAppInfo.exposure_max.get() <= 0))
        {
          localStringBuilder.append(" isNewFlag exposure_max error").append(localAppInfo.iNewFlag.get()).append(localAppInfo.exposure_max.get());
        }
        else
        {
          if ((paramILebaHelperService != null) && (paramILebaHelperService.needShowRedDot(paramQQAppInterface, localAppInfo.uiAppId.get(), paramBoolean, paramMap))) {}
          for (int j = 1;; j = 0)
          {
            if (j != 0) {
              break label346;
            }
            localStringBuilder.append(" !needShowRedDot");
            break;
          }
          j = 0;
          for (;;)
          {
            if ((j >= localList2.size()) || (localAppInfo.uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).appid.get()))
            {
              if ((j >= localList2.size()) || (((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).setting.get())) {
                break label444;
              }
              localStringBuilder.append(" hide ");
              break;
            }
            j += 1;
          }
          label444:
          localRedTypeInfo2 = (BusinessInfoCheckUpdate.RedTypeInfo)localAppInfo.red_display_info.tab_display_info.get();
          if ((localAppInfo.uiAppId.get() != 100510) || (localRedTypeInfo2.red_type.get() != 5)) {
            break label497;
          }
          localStringBuilder.append(" !nearby");
        }
      }
      label497:
      if ((localObject != null) && (localObject.red_priority.get() >= localRedTypeInfo2.red_priority.get())) {
        break label678;
      }
      localObject = localRedTypeInfo2;
    }
    label678:
    for (;;)
    {
      localStringBuilder.append(" show ");
      if (localRedTypeInfo2.red_type.get() == 5)
      {
        localRedTypeInfo1 = localRedTouchManager.a(localRedTypeInfo1, localAppInfo, localRedTypeInfo2, "getRedTouchInfoForLeba, content=");
        break label158;
      }
      if ((localObject == null) || (localObject.red_priority.get() < localRedTypeInfo2.red_priority.get()))
      {
        localObject = localRedTypeInfo2;
        break label158;
        paramQQAppInterface = localRedTypeInfo1;
        if (localRedTypeInfo1 != null) {
          break;
        }
        if (localObject != null) {
          QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "getRedTouchInfoForLeba result != nullpathList = " + localStringBuilder.toString());
        }
        for (;;)
        {
          return localObject;
          QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "getRedTouchInfoForLeba result = nullpathList = " + localStringBuilder.toString());
        }
      }
      break label158;
    }
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, int paramInt1, boolean paramBoolean1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      paramRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramRedTypeInfo1.red_type.set(5);
      paramRedTypeInfo1.red_content.set(paramInt3 + "");
      paramRedTypeInfo1.red_desc.set("{'cn':'#FF0000'}");
      a(paramInt2, 0);
      return paramRedTypeInfo1;
    }
    if (paramRedTypeInfo2 != null)
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify redTypeInfo != null.");
      return paramRedTypeInfo2;
    }
    int i;
    if (paramInt1 <= 0)
    {
      i = b();
      paramInt3 = i;
      if (i <= 0)
      {
        paramInt3 = i;
        if (!paramBoolean2)
        {
          paramInt3 = i;
          if (!paramBoolean1) {
            if (!paramBoolean3) {
              break label229;
            }
          }
        }
      }
    }
    for (paramInt3 = i;; paramInt3 = 0)
    {
      paramRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramRedTypeInfo1.red_type.set(0);
      paramRedTypeInfo1.red_content.set("");
      paramRedTypeInfo1.red_desc.set("");
      a(paramInt2, paramInt3);
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify hasReddot; redpointMums = " + paramInt1 + ",isReadinjoyNotifyNeedsDisplay" + paramBoolean2 + ",nearbyHasRedPoint = " + paramBoolean1 + ", finalConfessShowRedDot=" + paramBoolean3);
      return paramRedTypeInfo1;
      label229:
      return paramRedTypeInfo1;
    }
  }
  
  private com.tencent.util.Pair<Integer, Boolean> a()
  {
    if ((SimpleUIUtil.a()) || (!QzoneConfig.isShowQCircleEnter(StudyModeManager.a()))) {
      return null;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app != null)) {
          i = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
        }
      }
      catch (Exception localException1)
      {
        Object localObject;
        long l;
        label120:
        bool1 = false;
        label147:
        bool2 = false;
        j = 0;
        int i = 0;
        QLog.e("MainAssistObserver.LebaTabRedTouch", 2, "getQQCircleRedTouchNums" + localException1.toString());
        bool3 = false;
        bool4 = bool1;
        bool5 = bool2;
        continue;
      }
      for (;;)
      {
        try
        {
          localObject = QCircleUtils.a().getOuterEntranceRedPointInfoByAppid("circle_entrance");
          if (localObject == null) {
            continue;
          }
          l = ((QQCircleCounter.RedPointInfo)localObject).outLayerInfo.combineRedTypes.get();
          j = ((QQCircleCounter.RedPointInfo)localObject).redTotalNum.get();
        }
        catch (Exception localException2)
        {
          bool1 = false;
          bool2 = false;
          j = 0;
          break label297;
          bool1 = false;
          bool2 = false;
          bool3 = false;
          j = 0;
          break label147;
        }
        try
        {
          bool1 = QCircleHostUtil.checkOperateMaskEnabled(l, 1);
          if (!bool1) {
            continue;
          }
          bool1 = true;
        }
        catch (Exception localException3)
        {
          bool1 = false;
          bool2 = false;
          break label297;
          bool1 = false;
          break;
        }
        try
        {
          bool2 = QCircleHostUtil.checkOperateMaskEnabled(l, 6);
          if (!bool2) {
            continue;
          }
          bool2 = true;
        }
        catch (Exception localException4)
        {
          bool2 = bool1;
          bool1 = false;
          break label297;
          bool3 = bool1;
          bool1 = false;
          break label147;
          bool2 = false;
          break label120;
        }
      }
      if (i > 0) {
        break label394;
      }
      try
      {
        bool3 = QCircleHostUtil.checkOperateMaskEnabled(l, 3);
        if (!bool3) {
          break label394;
        }
        bool4 = true;
        bool3 = bool1;
        bool1 = bool4;
        bool5 = bool3;
        bool4 = bool2;
        bool3 = bool1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getQQCircleRedTouchNums]").append("  pushUnReadNum = ").append(j).append(", chatUnReadNum = ").append(i).append(", showActiveRedDot = ").append(bool5).append(", showRecommendRedDot = ").append(bool3).append(", showPYMKRedDot = ").append(bool4);
        QLog.d("QCircleEeveeRedPoint_MainAssistObserver.LebaTabRedTouch", 2, new Object[] { localObject });
        return new com.tencent.util.Pair(Integer.valueOf(j + i), Boolean.valueOf(bool3 | bool5 | bool4));
      }
      catch (Exception localException5)
      {
        boolean bool4;
        boolean bool5;
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
        continue;
      }
      QLog.d("MainAssistObserver.LebaTabRedTouch", 1, "getChatUnReadNum error activity or appInterface is null");
      i = 0;
    }
  }
  
  private ReadInJoyNotifyRedTouchInfo a()
  {
    if (!a()) {
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return null;
    }
    ReadInJoyManager localReadInJoyManager = (ReadInJoyManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.READINJOY_MANAGER);
    if (localReadInJoyManager == null) {
      return null;
    }
    return localReadInJoyManager.a();
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    if (!QQTheme.e()) {}
    LebaTabRedTouch.QZoneRedPointReportInfo localQZoneRedPointReportInfo;
    do
    {
      return;
      localQZoneRedPointReportInfo = new LebaTabRedTouch.QZoneRedPointReportInfo(paramInt1, paramInt2, null);
    } while (localQZoneRedPointReportInfo.equals(jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch$QZoneRedPointReportInfo));
    jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch$QZoneRedPointReportInfo = localQZoneRedPointReportInfo;
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "doQZoneRedPointExposeReport: " + LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo) + " " + LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo));
    if (LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo) > 0)
    {
      LpReportInfo_pf00064.allReport(637, 22, 1);
      return;
    }
    if (LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo))
    {
      LpReportInfo_pf00064.allReport(637, 21, 1);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 23, 1);
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return false;
    }
    Iterator localIterator = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).a().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator.next();
      if (localAppSetting.appid.get() == 1130L) {
        return localAppSetting.setting.get();
      }
    }
    return true;
  }
  
  private int b()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.QZONE_MANAGER);
    if (localQZoneManagerImp != null)
    {
      int j = localQZoneManagerImp.a(2);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + localQZoneManagerImp.a(2) + " TYPE_ZEBRA_ALBUM:" + localQZoneManagerImp.a(17));
        i = j;
      }
    }
    QLog.d("UndealCount.MainAssistObserver", 1, "isNewQzoneMsgExist: " + i);
    return i;
  }
  
  public static void b()
  {
    LebaTabRedTouch.QZoneRedPointReportInfo localQZoneRedPointReportInfo = jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch$QZoneRedPointReportInfo;
    StringBuilder localStringBuilder = new StringBuilder().append("doQZoneRedPointClickReport: ");
    if (localQZoneRedPointReportInfo == null) {}
    for (String str = "null";; str = LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo) + " " + LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo))
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 4, str);
      if ((localQZoneRedPointReportInfo != null) && (LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo) <= 0) && (LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo))) {
        break;
      }
      LpReportInfo_pf00064.allReport(637, 22, 2);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 21, 2);
  }
  
  public static void c()
  {
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "clearReportCache");
    jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch$QZoneRedPointReportInfo = null;
  }
  
  public Runnable a(LebaTabRedTouch.RefreshCallback paramRefreshCallback)
  {
    return new LebaTabRedTouch.1(this, paramRefreshCallback);
  }
  
  public Map<Long, LebaPluginInfo> a()
  {
    Object localObject2 = Collections.emptyMap();
    Object localObject1 = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(ILebaHelperService.class, "");
    if (localObject1 != null) {
      localObject1 = ((ILebaHelperService)localObject1).getLebaConfigList();
    }
    while ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject2 = new HashMap();
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)((Iterator)localObject1).next();
          if (localLebaPluginInfo != null)
          {
            ((Map)localObject2).put(Long.valueOf(localLebaPluginInfo.uiResId), localLebaPluginInfo);
            continue;
            QLog.d("MainAssistObserver.LebaTabRedTouch", 1, "getLebaPluginMap lebaHelperService == null");
            localObject1 = null;
            break;
          }
        }
      }
      return localObject2;
    }
    return localObject2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.LebaTabRedTouch
 * JD-Core Version:    0.7.0.1
 */