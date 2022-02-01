package com.tencent.mobileqq.activity.main;

import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyNotifyRedTouchInfo;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyManager;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      if (((SplashActivity)localObject).app == null) {
        return 0;
      }
      localObject = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.QZONE_MANAGER);
      i = j;
      if (localObject != null)
      {
        i = ((QZoneManagerImp)localObject).a(1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getQZoneMsgCount TYPE_PASSIVE_FEED: ");
          localStringBuilder.append(((QZoneManagerImp)localObject).a(1));
          QLog.d("UndealCount.MainAssistObserver", 2, localStringBuilder.toString());
        }
      }
    }
    return i;
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramInt = MatchChatMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
    }
    return paramInt;
  }
  
  private int a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt)
  {
    int i = paramInt;
    if (paramRedTypeInfo != null)
    {
      i = paramInt;
      if (paramRedTypeInfo.red_type.get() == 5) {
        i = Integer.parseInt(paramRedTypeInfo.red_content.get());
      }
    }
    return i;
  }
  
  private int a(oidb_0x791.RedDotInfo paramRedDotInfo, int paramInt)
  {
    int i = paramInt;
    if (paramRedDotInfo != null)
    {
      i = paramInt;
      if (paramRedDotInfo.uint32_appid.get() == 52)
      {
        i = paramInt;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getNowLiveManager().a)
        {
          i = paramInt;
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getNowLiveManager().b()) {
            i = paramRedDotInfo.uint32_number.get();
          }
        }
      }
    }
    return i;
  }
  
  private ReadInJoyNotifyRedTouchInfo a()
  {
    if (!a()) {
      return null;
    }
    SplashActivity localSplashActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if (localSplashActivity != null)
    {
      if (localSplashActivity.app == null) {
        return null;
      }
      return ((IReadInJoyManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(IReadInJoyManager.class)).obtainLatestNotifyRedTouchInfo();
    }
    return null;
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(TroopRedTouchManager paramTroopRedTouchManager, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsShowNewLeba=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.mIsShowNewLeba);
    boolean bool6 = QQTheme.f();
    Map localMap = Collections.emptyMap();
    if (bool6) {
      localMap = a();
    }
    ILebaHelperService localILebaHelperService = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(ILebaHelperService.class, "");
    int i = paramTroopRedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
    int k = paramTroopRedTouchManager.a();
    int j;
    if ((localILebaHelperService != null) && (localILebaHelperService.needShowRedDot(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 826L, bool6, localMap))) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0)
    {
      i = 0;
      k = 0;
    }
    localStringBuilder.append("troop red point-->redPointNums= ");
    localStringBuilder.append(i);
    localStringBuilder.append(", redNumPointNums=");
    localStringBuilder.append(k);
    localStringBuilder.append(", isBuluoEntryShow=");
    localStringBuilder.append(k);
    ((LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(100510);
    paramTroopRedTouchManager = paramTroopRedTouchManager.a(paramTroopRedTouchManager.a(), false);
    boolean bool1;
    if (paramTroopRedTouchManager.getRedType() != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int m = paramTroopRedTouchManager.getRedNum();
    boolean bool2;
    if ((localILebaHelperService != null) && (localILebaHelperService.needShowRedDot(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 7719L, bool6, localMap))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if (!bool2)
    {
      m = 0;
      bool3 = false;
    }
    else
    {
      bool3 = bool1;
    }
    localStringBuilder.append("nearby red point-->nearbyNum= ");
    localStringBuilder.append(m);
    localStringBuilder.append(", nearbyHasRedPoint=");
    localStringBuilder.append(bool3);
    localStringBuilder.append(", isNearbyEntryShow=");
    localStringBuilder.append(bool2);
    paramTroopRedTouchManager = a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, bool6, localMap, localILebaHelperService);
    int n = a(paramTroopRedTouchManager, 0);
    localStringBuilder.append("business red point-->numRedTouch=");
    localStringBuilder.append(n);
    int i1 = a();
    localStringBuilder.append("QZone red point-->qzonMsgCount=");
    localStringBuilder.append(i1);
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo = a();
    if (localReadInJoyNotifyRedTouchInfo != null) {
      j = localReadInJoyNotifyRedTouchInfo.a();
    } else {
      j = 0;
    }
    if ((localReadInJoyNotifyRedTouchInfo != null) && (localReadInJoyNotifyRedTouchInfo.a())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((localILebaHelperService != null) && (localILebaHelperService.needShowRedDot(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 1130L, bool6, localMap))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool4;
    if (!bool2)
    {
      bool4 = false;
      j = 0;
    }
    else
    {
      bool4 = bool1;
    }
    localStringBuilder.append("readInJoy red point-->readInJoyNotifyCount=");
    localStringBuilder.append(j);
    localStringBuilder.append(", isReadinjoyNotifyNeedsDisplay=");
    localStringBuilder.append(bool4);
    localStringBuilder.append(", isKanDianEntryShow=");
    localStringBuilder.append(bool2);
    int i3 = a(paramRedDotInfo, 0);
    boolean bool7 = ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, "redpoint_leba_show");
    boolean bool5;
    if (bool7)
    {
      if ((localILebaHelperService != null) && (localILebaHelperService.needShowRedDot(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 7759L, bool6, localMap))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((bool7) && (bool1)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool5 = bool1;
      bool1 = bool2;
    }
    else
    {
      bool5 = false;
      bool1 = false;
    }
    int i4 = j;
    localStringBuilder.append("confessRedPoit");
    localStringBuilder.append(bool1);
    localStringBuilder.append(",");
    localStringBuilder.append(bool7);
    localStringBuilder.append(",");
    localStringBuilder.append(bool5);
    if ((localILebaHelperService != null) && (localILebaHelperService.needShowRedDot(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 7720L, bool6, localMap))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int i5 = a(0, bool2);
    localStringBuilder.append("matchChatRedNum,");
    localStringBuilder.append(i5);
    paramRedDotInfo = a();
    if (paramRedDotInfo == null) {
      j = 0;
    } else {
      j = ((Integer)paramRedDotInfo.first).intValue();
    }
    int i2 = i;
    if (paramRedDotInfo != null)
    {
      i2 = i;
      if (((Boolean)paramRedDotInfo.second).booleanValue()) {
        i2 = i + 1;
      }
    }
    if ((QzoneConfig.isQQCircleShowMessageEntrance(StudyModeManager.a())) && (QzoneConfig.isQQCircleShowLebaBySwitchButton(StudyModeManager.a())) && (QzoneConfig.getQQCircleShowGuideOnLebaTab()) && (QCircleHostConfig.isNeedShowLebaTabGuideNew() != 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    i = i1 + n + k + i4 + m + i3 + i5 + j;
    paramRedDotInfo = new StringBuilder();
    paramRedDotInfo.append("updateTabLebaNotify: totalCount=");
    paramRedDotInfo.append(i);
    paramRedDotInfo.append(", qz=");
    paramRedDotInfo.append(i1);
    paramRedDotInfo.append(", numRedTouch=");
    paramRedDotInfo.append(n);
    paramRedDotInfo.append(", redNumPointNums=");
    paramRedDotInfo.append(k);
    paramRedDotInfo.append(", readInJoyNotifyCount=");
    paramRedDotInfo.append(i4);
    paramRedDotInfo.append(", nearbyNum=");
    paramRedDotInfo.append(m);
    paramRedDotInfo.append(", storyRedNum=");
    paramRedDotInfo.append(i3);
    paramRedDotInfo.append(", allPeopleVoteRedNumCount=");
    paramRedDotInfo.append(localStringBuilder.toString());
    QLog.i("MainAssistObserver.LebaTabRedTouch", 1, paramRedDotInfo.toString());
    return a(paramRedTypeInfo, i2, bool3, paramTroopRedTouchManager, i1, bool4, bool1, i, bool2);
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(QQAppInterface paramQQAppInterface, boolean paramBoolean, Map<Long, LebaPluginInfo> paramMap, ILebaHelperService paramILebaHelperService)
  {
    Object localObject1 = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(IRedTouchManager.class, "");
    List localList1 = ((IRedTouchManager)localObject1).requestAppInfoListByAppSet(0);
    if (localList1 != null)
    {
      if (localList1.size() == 0) {
        return null;
      }
      List localList2 = ((IRedTouchManager)localObject1).requestSettingInfoList();
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("getRedTouchInfoForLeba:redpoint path List:");
      Object localObject3 = null;
      localObject1 = localObject3;
      int i = 0;
      for (;;)
      {
        int k = localList1.size();
        int j = 1;
        if (i >= k) {
          break;
        }
        Object localObject4 = (BusinessInfoCheckUpdate.AppInfo)localList1.get(i);
        localStringBuilder.append(", for ");
        localStringBuilder.append(((BusinessInfoCheckUpdate.AppInfo)localObject4).path.get());
        if (((BusinessInfoCheckUpdate.AppInfo)localObject4).mission_level.get() != 0)
        {
          localStringBuilder.append(" mission_level ");
          localStringBuilder.append(((BusinessInfoCheckUpdate.AppInfo)localObject4).mission_level.get());
          localObject4 = localObject3;
        }
        else if ((999999 != ((BusinessInfoCheckUpdate.AppInfo)localObject4).uiAppId.get()) && (!((BusinessInfoCheckUpdate.AppInfo)localObject4).path.get().contains(".")))
        {
          if (1130 == ((BusinessInfoCheckUpdate.AppInfo)localObject4).uiAppId.get())
          {
            localStringBuilder.append(" exclude kandian ");
            localObject4 = localObject3;
          }
          else if ((((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() == 1) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).exposure_max.get() > 0))
          {
            if ((paramILebaHelperService == null) || (!paramILebaHelperService.needShowRedDot(paramQQAppInterface, ((BusinessInfoCheckUpdate.AppInfo)localObject4).uiAppId.get(), paramBoolean, paramMap))) {
              j = 0;
            }
            if (j == 0)
            {
              localStringBuilder.append(" !needShowRedDot");
              localObject4 = localObject3;
            }
            else
            {
              j = 0;
              while ((j < localList2.size()) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).uiAppId.get() != ((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).appid.get())) {
                j += 1;
              }
              if ((j < localList2.size()) && (!((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).setting.get()))
              {
                localStringBuilder.append(" hide ");
                localObject4 = localObject3;
              }
              else
              {
                BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((BusinessInfoCheckUpdate.AppInfo)localObject4).red_display_info.tab_display_info.get();
                if ((((BusinessInfoCheckUpdate.AppInfo)localObject4).uiAppId.get() == 100510) && (localRedTypeInfo.red_type.get() == 5))
                {
                  localStringBuilder.append(" !nearby");
                  localObject4 = localObject3;
                }
                else
                {
                  Object localObject2;
                  if (localObject1 != null)
                  {
                    localObject2 = localObject1;
                    if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
                  }
                  else
                  {
                    localObject2 = localRedTypeInfo;
                  }
                  localStringBuilder.append(" show ");
                  if (localRedTypeInfo.red_type.get() == 5)
                  {
                    localObject4 = a((BusinessInfoCheckUpdate.RedTypeInfo)localObject3, (BusinessInfoCheckUpdate.AppInfo)localObject4, localRedTypeInfo, "getRedTouchInfoForLeba, content=");
                    localObject1 = localObject2;
                  }
                  else if (localObject2 != null)
                  {
                    localObject4 = localObject3;
                    localObject1 = localObject2;
                    if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
                  }
                  else
                  {
                    localObject1 = localRedTypeInfo;
                    localObject4 = localObject3;
                  }
                }
              }
            }
          }
          else
          {
            localStringBuilder.append(" isNewFlag exposure_max error");
            localStringBuilder.append(((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get());
            localStringBuilder.append(((BusinessInfoCheckUpdate.AppInfo)localObject4).exposure_max.get());
            localObject4 = localObject3;
          }
        }
        else
        {
          localStringBuilder.append(" second ");
          localObject4 = localObject3;
        }
        i += 1;
        localObject3 = localObject4;
      }
      if (localObject3 != null) {
        return localObject3;
      }
      if (localObject1 != null)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getRedTouchInfoForLeba result != nullpathList = ");
        paramQQAppInterface.append(localStringBuilder.toString());
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, paramQQAppInterface.toString());
        return localObject1;
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getRedTouchInfoForLeba result = nullpathList = ");
      paramQQAppInterface.append(localStringBuilder.toString());
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, paramQQAppInterface.toString());
      return localObject1;
    }
    return null;
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, int paramInt1, boolean paramBoolean1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3, boolean paramBoolean4)
  {
    if (paramInt3 > 0)
    {
      paramRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramRedTypeInfo1.red_type.set(5);
      paramRedTypeInfo2 = paramRedTypeInfo1.red_content;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramInt3);
      localStringBuilder1.append("");
      paramRedTypeInfo2.set(localStringBuilder1.toString());
      paramRedTypeInfo1.red_desc.set("{'cn':'#FF0000'}");
      a(paramInt2, 0);
      return paramRedTypeInfo1;
    }
    if (paramBoolean4)
    {
      paramRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramRedTypeInfo1.red_type.set(4);
      paramRedTypeInfo1.red_content.set("NEW");
      paramRedTypeInfo2 = new JSONObject();
      try
      {
        paramRedTypeInfo2.put("cn", "#FF0000");
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("error");
        localStringBuilder2.append(localException);
        QLog.e("MainAssistObserver.LebaTabRedTouch", 1, localStringBuilder2.toString());
      }
      paramRedTypeInfo1.red_desc.set(paramRedTypeInfo2.toString());
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify show qcircleNew User");
      return paramRedTypeInfo1;
    }
    if (paramRedTypeInfo2 != null)
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify redTypeInfo != null.");
      return paramRedTypeInfo2;
    }
    if (paramInt1 <= 0)
    {
      int i = b();
      paramInt3 = i;
      if (i <= 0)
      {
        paramInt3 = i;
        if (!paramBoolean2)
        {
          paramInt3 = i;
          if (!paramBoolean1)
          {
            if (!paramBoolean3) {
              return paramRedTypeInfo1;
            }
            paramInt3 = i;
          }
        }
      }
    }
    else
    {
      paramInt3 = 0;
    }
    paramRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
    paramRedTypeInfo1.red_type.set(0);
    paramRedTypeInfo1.red_content.set("");
    paramRedTypeInfo1.red_desc.set("");
    a(paramInt2, paramInt3);
    paramRedTypeInfo2 = new StringBuilder();
    paramRedTypeInfo2.append("updateTabLebaNotify hasReddot; redpointMums = ");
    paramRedTypeInfo2.append(paramInt1);
    paramRedTypeInfo2.append(",isReadinjoyNotifyNeedsDisplay");
    paramRedTypeInfo2.append(paramBoolean2);
    paramRedTypeInfo2.append(",nearbyHasRedPoint = ");
    paramRedTypeInfo2.append(paramBoolean1);
    paramRedTypeInfo2.append(", finalConfessShowRedDot=");
    paramRedTypeInfo2.append(paramBoolean3);
    QLog.i("MainAssistObserver.LebaTabRedTouch", 1, paramRedTypeInfo2.toString());
    return paramRedTypeInfo1;
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, BusinessInfoCheckUpdate.AppInfo paramAppInfo, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2, String paramString)
  {
    if (paramRedTypeInfo1 == null) {
      return paramRedTypeInfo2;
    }
    try
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(paramRedTypeInfo1.red_content.get());
        localStringBuilder.append(", path=");
        localStringBuilder.append(paramAppInfo.path.get());
        localStringBuilder.append(",redTypeInfoContent=");
        localStringBuilder.append(paramRedTypeInfo2.red_content.get());
        QLog.e("MainAssistObserver.LebaTabRedTouch", 4, localStringBuilder.toString());
      }
      paramAppInfo = paramRedTypeInfo1.red_content;
      paramString = new StringBuilder();
      paramString.append(Integer.parseInt(paramRedTypeInfo1.red_content.get()) + Integer.parseInt(paramRedTypeInfo2.red_content.get()));
      paramString.append("");
      paramAppInfo.set(paramString.toString());
      return paramRedTypeInfo1;
    }
    catch (NumberFormatException paramAppInfo)
    {
      paramRedTypeInfo2 = new StringBuilder();
      paramRedTypeInfo2.append("error getRedTypeInfo ");
      paramRedTypeInfo2.append(paramAppInfo);
      QLog.e("MainAssistObserver.LebaTabRedTouch", 1, paramRedTypeInfo2.toString());
    }
    return paramRedTypeInfo1;
  }
  
  private Pair<Integer, Boolean> a()
  {
    if ((!SimpleUIUtil.a()) && (QzoneConfig.isShowQCircleEnter(StudyModeManager.a())))
    {
      int i;
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app != null))
        {
          i = QCircleChatBoxHelper.getInstance().getUnReadChatNum();
        }
        else
        {
          QLog.d("MainAssistObserver.LebaTabRedTouch", 1, "getChatUnReadNum error activity or appInterface is null");
          i = 0;
        }
        try
        {
          QQCircleCounter.RedPointInfo localRedPointInfo = QCircleUtils.a().getOuterEntranceRedPointInfoByAppid("circle_entrance");
          if (localRedPointInfo != null)
          {
            long l = localRedPointInfo.outLayerInfo.combineRedTypes.get();
            k = localRedPointInfo.redTotalNum.get();
            try
            {
              bool2 = QCircleHostUtil.checkOperateMaskEnabled(l, 1);
              try
              {
                bool4 = QCircleHostUtil.checkOperateMaskEnabled(l, 6);
                if (i <= 0) {
                  try
                  {
                    bool1 = QCircleHostUtil.checkOperateMaskEnabled(l, 3);
                    if (bool1)
                    {
                      bool1 = true;
                      j = k;
                      bool3 = bool2;
                      bool2 = bool4;
                    }
                  }
                  catch (Exception localException1)
                  {
                    bool1 = bool2;
                    bool2 = bool4;
                    break label193;
                  }
                }
                bool1 = false;
                j = k;
                bool3 = bool2;
                bool2 = bool4;
              }
              catch (Exception localException2)
              {
                bool1 = bool2;
              }
              bool2 = false;
            }
            catch (Exception localException3)
            {
              bool1 = false;
            }
            label193:
            j = i;
            i = k;
            break label235;
          }
          bool1 = false;
          j = 0;
          bool3 = false;
          bool2 = false;
          k = i;
        }
        catch (Exception localException4)
        {
          j = i;
        }
        i = 0;
      }
      catch (Exception localException5)
      {
        j = 0;
      }
      boolean bool1 = false;
      boolean bool2 = false;
      label235:
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getQQCircleRedTouchNums");
      localStringBuilder2.append(localException5.toString());
      QLog.e("MainAssistObserver.LebaTabRedTouch", 2, localStringBuilder2.toString());
      boolean bool4 = false;
      boolean bool3 = bool1;
      int k = j;
      int j = i;
      bool1 = bool4;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[getQQCircleRedTouchNums]");
      localStringBuilder1.append("  pushUnReadNum = ");
      localStringBuilder1.append(j);
      localStringBuilder1.append(", chatUnReadNum = ");
      localStringBuilder1.append(k);
      localStringBuilder1.append(", showActiveRedDot = ");
      localStringBuilder1.append(bool3);
      localStringBuilder1.append(", showRecommendRedDot = ");
      localStringBuilder1.append(bool1);
      localStringBuilder1.append(", showPYMKRedDot = ");
      localStringBuilder1.append(bool2);
      QLog.d("QCircleEeveeRedPoint_MainAssistObserver.LebaTabRedTouch", 2, new Object[] { localStringBuilder1 });
      return new Pair(Integer.valueOf(j + k), Boolean.valueOf(bool1 | bool3 | bool2));
    }
    return null;
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    if (!QQTheme.f()) {
      return;
    }
    LebaTabRedTouch.QZoneRedPointReportInfo localQZoneRedPointReportInfo = new LebaTabRedTouch.QZoneRedPointReportInfo(paramInt1, paramInt2, null);
    if (localQZoneRedPointReportInfo.equals(jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch$QZoneRedPointReportInfo)) {
      return;
    }
    jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch$QZoneRedPointReportInfo = localQZoneRedPointReportInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doQZoneRedPointExposeReport: ");
    localStringBuilder.append(LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo));
    localStringBuilder.append(" ");
    localStringBuilder.append(LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo));
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, localStringBuilder.toString());
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if ((localObject != null) && (((SplashActivity)localObject).app != null))
    {
      localObject = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(IRedTouchManager.class, "")).requestSettingInfoList();
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((List)localObject).size() > 0)
        {
          localObject = ((List)localObject).iterator();
          BusinessInfoCheckUpdate.AppSetting localAppSetting;
          do
          {
            bool1 = bool2;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localAppSetting = (BusinessInfoCheckUpdate.AppSetting)((Iterator)localObject).next();
          } while (localAppSetting.appid.get() != 1130L);
          bool1 = localAppSetting.setting.get();
        }
      }
      return bool1;
    }
    return false;
  }
  
  private int b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    int i = 0;
    int j = 0;
    if (localObject != null)
    {
      if (((SplashActivity)localObject).app == null) {
        return 0;
      }
      localObject = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.QZONE_MANAGER);
      i = j;
      if (localObject != null)
      {
        i = ((QZoneManagerImp)localObject).a(2);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNewQzoneMsgExist TYPE_ACTIVE_FEED: ");
          localStringBuilder.append(((QZoneManagerImp)localObject).a(2));
          localStringBuilder.append(" TYPE_ZEBRA_ALBUM:");
          localStringBuilder.append(((QZoneManagerImp)localObject).a(17));
          QLog.d("UndealCount.MainAssistObserver", 2, localStringBuilder.toString());
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNewQzoneMsgExist: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("UndealCount.MainAssistObserver", 1, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public static void b()
  {
    LebaTabRedTouch.QZoneRedPointReportInfo localQZoneRedPointReportInfo = jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch$QZoneRedPointReportInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doQZoneRedPointClickReport: ");
    Object localObject;
    if (localQZoneRedPointReportInfo == null)
    {
      localObject = "null";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo));
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, localStringBuilder.toString());
    if ((localQZoneRedPointReportInfo != null) && (LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo) <= 0) && (LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo)))
    {
      LpReportInfo_pf00064.allReport(637, 21, 2);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 22, 2);
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
    Object localObject3 = Collections.emptyMap();
    Object localObject1 = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(ILebaHelperService.class, "");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((ILebaHelperService)localObject1).getLebaConfigList();
    }
    else
    {
      QLog.d("MainAssistObserver.LebaTabRedTouch", 1, "getLebaPluginMap lebaHelperService == null");
      localObject2 = null;
    }
    localObject1 = localObject3;
    if (localObject2 != null)
    {
      localObject1 = localObject3;
      if (!((List)localObject2).isEmpty())
      {
        localObject3 = new HashMap();
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          localObject1 = localObject3;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (LebaPluginInfo)((Iterator)localObject2).next();
          if (localObject1 != null) {
            ((Map)localObject3).put(Long.valueOf(((LebaPluginInfo)localObject1).uiResId), localObject1);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.LebaTabRedTouch
 * JD-Core Version:    0.7.0.1
 */