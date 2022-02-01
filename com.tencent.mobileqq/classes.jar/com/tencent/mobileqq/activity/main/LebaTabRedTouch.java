package com.tencent.mobileqq.activity.main;

import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class LebaTabRedTouch
{
  private static volatile LebaTabRedTouch.QZoneRedPointReportInfo b;
  public SplashActivity a;
  
  public LebaTabRedTouch(SplashActivity paramSplashActivity)
  {
    this.a = paramSplashActivity;
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramInt = MatchChatMsgUtil.b(this.a.app);
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
        if (!this.a.app.getNowLiveManager().d)
        {
          i = paramInt;
          if (this.a.app.getNowLiveManager().b()) {
            i = paramRedDotInfo.uint32_number.get();
          }
        }
      }
    }
    return i;
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(TroopRedTouchManager paramTroopRedTouchManager, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (a()) {
      return a(paramRedTypeInfo);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsShowNewLeba=");
    localStringBuilder.append(this.a.app.mIsShowNewLeba);
    ILebaHelperService localILebaHelperService = (ILebaHelperService)this.a.app.getRuntimeService(ILebaHelperService.class, "");
    Set localSet = a(localILebaHelperService);
    localStringBuilder.append("troop red point-->redPointNums= ");
    localStringBuilder.append(0);
    localStringBuilder.append(", redNumPointNums=");
    localStringBuilder.append(0);
    localStringBuilder.append(", isBuluoEntryShow=");
    localStringBuilder.append(0);
    ((LocalRedTouchManager)this.a.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(100510);
    paramTroopRedTouchManager = paramTroopRedTouchManager.a(paramTroopRedTouchManager.p(), false);
    if (paramTroopRedTouchManager.getRedType() != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i = paramTroopRedTouchManager.getRedNum();
    boolean bool3 = localILebaHelperService.needShowRedDot(this.a.app, 7719L, localSet);
    paramTroopRedTouchManager = b();
    if ((c()) && ("exp_shouq_dongtai_jianjie_B".equals(paramTroopRedTouchManager))) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool2;
    if (bool3)
    {
      bool2 = bool1;
      if (j == 0) {}
    }
    else
    {
      i = 0;
      bool2 = false;
    }
    localStringBuilder.append("nearby red point-->nearbyNum= ");
    localStringBuilder.append(i);
    localStringBuilder.append(", nearbyHasRedPoint=");
    localStringBuilder.append(bool2);
    localStringBuilder.append(", isNearbyEntryShow=");
    localStringBuilder.append(bool3);
    paramTroopRedTouchManager = a(this.a.app, localSet, localILebaHelperService);
    int m = a(paramTroopRedTouchManager, 0);
    localStringBuilder.append("business red point-->numRedTouch=");
    localStringBuilder.append(m);
    int n = d();
    localStringBuilder.append("QZone red point-->qzonMsgCount=");
    localStringBuilder.append(n);
    localStringBuilder.append("readInJoy red point-->readInJoyNotifyCount=");
    localStringBuilder.append(0);
    localStringBuilder.append(", isReadinjoyNotifyNeedsDisplay=");
    localStringBuilder.append(false);
    localStringBuilder.append(", isKanDianEntryShow=");
    int i1 = a(paramRedDotInfo, 0);
    boolean bool5 = ConfessConfig.a(this.a.app, "redpoint_leba_show");
    boolean bool4;
    if (bool5)
    {
      bool4 = localILebaHelperService.needShowRedDot(this.a.app, 7759L, localSet);
      if ((bool5) && (bool4)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool3 = bool1;
    }
    else
    {
      bool4 = false;
      bool3 = false;
    }
    localStringBuilder.append("confessRedPoit");
    localStringBuilder.append(bool3);
    localStringBuilder.append(",");
    localStringBuilder.append(bool5);
    localStringBuilder.append(",");
    localStringBuilder.append(bool4);
    int i2 = a(0, localILebaHelperService.needShowRedDot(this.a.app, 7720L, localSet));
    localStringBuilder.append("matchChatRedNum,");
    localStringBuilder.append(i2);
    paramRedDotInfo = h();
    if (paramRedDotInfo == null) {
      j = 0;
    } else {
      j = ((Integer)paramRedDotInfo.first).intValue();
    }
    int k;
    if ((paramRedDotInfo != null) && (((Boolean)paramRedDotInfo.second).booleanValue())) {
      k = 1;
    } else {
      k = 0;
    }
    if ((QCircleConfigHelper.b(StudyModeManager.h())) && (QCircleConfigHelper.e(StudyModeManager.h())) && (QzoneConfig.getQQCircleShowGuideOnLebaTab()) && (QCircleHostConfig.isNeedShowLebaTabGuideNew() != 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((!SimpleUIUtil.e()) && (!StudyModeManager.h())) {
      break label679;
    }
    boolean bool1 = false;
    label679:
    int j = n + m + 0 + 0 + i + i1 + i2 + j;
    paramRedDotInfo = new StringBuilder();
    paramRedDotInfo.append("updateTabLebaNotify: totalCount=");
    paramRedDotInfo.append(j);
    paramRedDotInfo.append(", qz=");
    paramRedDotInfo.append(n);
    paramRedDotInfo.append(", numRedTouch=");
    paramRedDotInfo.append(m);
    paramRedDotInfo.append(", redNumPointNums=");
    paramRedDotInfo.append(0);
    paramRedDotInfo.append(", readInJoyNotifyCount=");
    paramRedDotInfo.append(0);
    paramRedDotInfo.append(", nearbyNum=");
    paramRedDotInfo.append(i);
    paramRedDotInfo.append(", storyRedNum=");
    paramRedDotInfo.append(i1);
    paramRedDotInfo.append(", allPeopleVoteRedNumCount=");
    paramRedDotInfo.append(localStringBuilder.toString());
    QLog.i("MainAssistObserver.LebaTabRedTouch", 1, paramRedDotInfo.toString());
    return a(paramRedTypeInfo, k, bool2, paramTroopRedTouchManager, n, false, bool3, j, bool1);
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(QQAppInterface paramQQAppInterface, Set<Long> paramSet, ILebaHelperService paramILebaHelperService)
  {
    List localList = ((IRedTouchManager)this.a.app.getRuntimeService(IRedTouchManager.class, "")).requestAppInfoListByAppSet(0);
    if (localList != null)
    {
      if (localList.size() == 0) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("getRedTouchInfoForLeba:redpoint path List:");
      Object localObject3 = null;
      Object localObject1 = localObject3;
      int i = 0;
      for (;;)
      {
        int k = localList.size();
        int j = 1;
        if (i >= k) {
          break;
        }
        Object localObject4 = (BusinessInfoCheckUpdate.AppInfo)localList.get(i);
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
            if ((paramILebaHelperService == null) || (!paramILebaHelperService.needShowRedDot(paramQQAppInterface, ((BusinessInfoCheckUpdate.AppInfo)localObject4).uiAppId.get(), paramSet))) {
              j = 0;
            }
            if (j == 0)
            {
              localStringBuilder.append(" !needShowRedDot");
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
                  if (localObject1.red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
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
      int i = i();
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
  
  private static void a(int paramInt1, int paramInt2)
  {
    if (!QQTheme.isNowSimpleUI()) {
      return;
    }
    LebaTabRedTouch.QZoneRedPointReportInfo localQZoneRedPointReportInfo = new LebaTabRedTouch.QZoneRedPointReportInfo(paramInt1, paramInt2, null);
    if (localQZoneRedPointReportInfo.equals(b)) {
      return;
    }
    b = localQZoneRedPointReportInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doQZoneRedPointExposeReport: ");
    localStringBuilder.append(LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo));
    localStringBuilder.append(" ");
    localStringBuilder.append(LebaTabRedTouch.QZoneRedPointReportInfo.b(localQZoneRedPointReportInfo));
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, localStringBuilder.toString());
    if (LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo) > 0)
    {
      LpReportInfo_pf00064.allReport(637, 22, 1);
      return;
    }
    if (LebaTabRedTouch.QZoneRedPointReportInfo.b(localQZoneRedPointReportInfo))
    {
      LpReportInfo_pf00064.allReport(637, 21, 1);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 23, 1);
  }
  
  public static void f()
  {
    LebaTabRedTouch.QZoneRedPointReportInfo localQZoneRedPointReportInfo = b;
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
      ((StringBuilder)localObject).append(LebaTabRedTouch.QZoneRedPointReportInfo.b(localQZoneRedPointReportInfo));
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, localStringBuilder.toString());
    if ((localQZoneRedPointReportInfo != null) && (LebaTabRedTouch.QZoneRedPointReportInfo.a(localQZoneRedPointReportInfo) <= 0) && (LebaTabRedTouch.QZoneRedPointReportInfo.b(localQZoneRedPointReportInfo)))
    {
      LpReportInfo_pf00064.allReport(637, 21, 2);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 22, 2);
  }
  
  public static void g()
  {
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "clearReportCache");
    b = null;
  }
  
  /* Error */
  private Pair<Integer, Boolean> h()
  {
    // Byte code:
    //   0: invokestatic 263	com/tencent/mobileqq/simpleui/SimpleUIUtil:e	()Z
    //   3: ifne +392 -> 395
    //   6: invokestatic 241	com/tencent/mobileqq/studymode/StudyModeManager:h	()Z
    //   9: ifne +386 -> 395
    //   12: invokestatic 241	com/tencent/mobileqq/studymode/StudyModeManager:h	()Z
    //   15: invokestatic 486	com/tencent/qcircle/cooperation/config/QCircleConfigHelper:d	(Z)Z
    //   18: ifne +6 -> 24
    //   21: goto +374 -> 395
    //   24: aload_0
    //   25: getfield 15	com/tencent/mobileqq/activity/main/LebaTabRedTouch:a	Lcom/tencent/mobileqq/activity/SplashActivity;
    //   28: ifnull +13 -> 41
    //   31: aload_0
    //   32: getfield 15	com/tencent/mobileqq/activity/main/LebaTabRedTouch:a	Lcom/tencent/mobileqq/activity/SplashActivity;
    //   35: getfield 23	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: ifnonnull +13 -> 51
    //   41: ldc_w 282
    //   44: iconst_1
    //   45: ldc_w 488
    //   48: invokestatic 490	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: invokestatic 495	com/tencent/mobileqq/activity/qcircle/utils/QCircleUtils:b	()Lcom/tencent/mobileqq/qcircle/api/IQCircleRedPointService;
    //   54: ldc_w 497
    //   57: invokeinterface 503 2 0
    //   62: astore 10
    //   64: aload 10
    //   66: ifnull +92 -> 158
    //   69: aload 10
    //   71: getfield 509	qqcircle/QQCircleCounter$RedPointInfo:outLayerInfo	Lqqcircle/QQCircleCounter$OutLayerPointInfo;
    //   74: getfield 515	qqcircle/QQCircleCounter$OutLayerPointInfo:combineRedTypes	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   77: invokevirtual 520	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   80: lstore_3
    //   81: aload 10
    //   83: getfield 523	qqcircle/QQCircleCounter$RedPointInfo:redTotalNum	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   86: invokevirtual 41	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   89: istore_1
    //   90: lload_3
    //   91: iconst_1
    //   92: invokestatic 529	com/tencent/mobileqq/qcircle/api/utils/QCircleHostUtil:checkOperateMaskEnabled	(JI)Z
    //   95: istore 5
    //   97: lload_3
    //   98: bipush 6
    //   100: invokestatic 529	com/tencent/mobileqq/qcircle/api/utils/QCircleHostUtil:checkOperateMaskEnabled	(JI)Z
    //   103: istore 6
    //   105: lload_3
    //   106: iconst_3
    //   107: invokestatic 529	com/tencent/mobileqq/qcircle/api/utils/QCircleHostUtil:checkOperateMaskEnabled	(JI)Z
    //   110: istore 9
    //   112: iload_1
    //   113: istore_2
    //   114: iload 5
    //   116: istore 7
    //   118: iload 6
    //   120: istore 8
    //   122: iload 9
    //   124: ifeq +105 -> 229
    //   127: iconst_1
    //   128: istore 7
    //   130: goto +116 -> 246
    //   133: astore 10
    //   135: goto +16 -> 151
    //   138: astore 10
    //   140: goto +8 -> 148
    //   143: astore 10
    //   145: iconst_0
    //   146: istore 5
    //   148: iconst_0
    //   149: istore 6
    //   151: iload 5
    //   153: istore 7
    //   155: goto +27 -> 182
    //   158: iconst_0
    //   159: istore 7
    //   161: iconst_0
    //   162: istore_1
    //   163: iconst_0
    //   164: istore 5
    //   166: iconst_0
    //   167: istore 6
    //   169: goto +77 -> 246
    //   172: astore 10
    //   174: iconst_0
    //   175: istore_1
    //   176: iconst_0
    //   177: istore 7
    //   179: iconst_0
    //   180: istore 6
    //   182: new 88	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   189: astore 11
    //   191: aload 11
    //   193: ldc_w 531
    //   196: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 11
    //   202: aload 10
    //   204: invokevirtual 532	java/lang/Exception:toString	()Ljava/lang/String;
    //   207: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: ldc_w 282
    //   214: iconst_2
    //   215: aload 11
    //   217: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 421	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: iload 6
    //   225: istore 8
    //   227: iload_1
    //   228: istore_2
    //   229: iconst_0
    //   230: istore 9
    //   232: iload 8
    //   234: istore 6
    //   236: iload 7
    //   238: istore 5
    //   240: iload_2
    //   241: istore_1
    //   242: iload 9
    //   244: istore 7
    //   246: invokestatic 537	com/tencent/mobileqq/qcircle/api/global/QCircleHostGlobalInfo:needShowEntranceGuideTips	()Z
    //   249: istore 8
    //   251: new 88	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   258: astore 10
    //   260: aload 10
    //   262: ldc_w 539
    //   265: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 10
    //   271: ldc_w 541
    //   274: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 10
    //   280: iload_1
    //   281: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 10
    //   287: ldc_w 543
    //   290: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 10
    //   296: iload 5
    //   298: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 10
    //   304: ldc_w 545
    //   307: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 10
    //   313: iload 7
    //   315: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 10
    //   321: ldc_w 547
    //   324: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 10
    //   330: iload 6
    //   332: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 10
    //   338: ldc_w 549
    //   341: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 10
    //   347: iload 8
    //   349: invokevirtual 101	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: ldc_w 551
    //   356: iconst_2
    //   357: iconst_1
    //   358: anewarray 4	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: aload 10
    //   365: aastore
    //   366: invokestatic 554	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   369: new 222	com/tencent/util/Pair
    //   372: dup
    //   373: iload_1
    //   374: invokestatic 558	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: iload 7
    //   379: iload 5
    //   381: ior
    //   382: iload 6
    //   384: ior
    //   385: iload 8
    //   387: ior
    //   388: invokestatic 561	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   391: invokespecial 564	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   394: areturn
    //   395: aconst_null
    //   396: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	LebaTabRedTouch
    //   89	285	1	i	int
    //   113	128	2	j	int
    //   80	26	3	l	long
    //   95	287	5	bool1	boolean
    //   103	282	6	bool2	boolean
    //   116	266	7	bool3	boolean
    //   120	268	8	bool4	boolean
    //   110	133	9	bool5	boolean
    //   62	20	10	localRedPointInfo	qqcircle.QQCircleCounter.RedPointInfo
    //   133	1	10	localException1	Exception
    //   138	1	10	localException2	Exception
    //   143	1	10	localException3	Exception
    //   172	31	10	localException4	Exception
    //   258	106	10	localStringBuilder1	StringBuilder
    //   189	27	11	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   105	112	133	java/lang/Exception
    //   97	105	138	java/lang/Exception
    //   90	97	143	java/lang/Exception
    //   24	41	172	java/lang/Exception
    //   41	51	172	java/lang/Exception
    //   51	64	172	java/lang/Exception
    //   69	90	172	java/lang/Exception
  }
  
  private int i()
  {
    Object localObject = this.a;
    int i = 0;
    int j = 0;
    if (localObject != null)
    {
      if (((SplashActivity)localObject).app == null) {
        return 0;
      }
      localObject = (QZoneManagerImp)this.a.app.getManager(QQManagerFactory.QZONE_MANAGER);
      i = j;
      if (localObject != null)
      {
        i = ((QZoneManagerImp)localObject).d(2);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNewQzoneMsgExist TYPE_ACTIVE_FEED: ");
          localStringBuilder.append(((QZoneManagerImp)localObject).d(2));
          localStringBuilder.append(" TYPE_ZEBRA_ALBUM:");
          localStringBuilder.append(((QZoneManagerImp)localObject).d(17));
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
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    int i = d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getQzoneRedType qzonMsgCount=");
    localStringBuilder.append(i);
    QLog.i("MainAssistObserver.LebaTabRedTouch", 1, localStringBuilder.toString());
    if (i > 0)
    {
      paramRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramRedTypeInfo.red_type.set(5);
      paramRedTypeInfo.red_content.set(String.valueOf(i));
      paramRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      a(i, 0);
      return paramRedTypeInfo;
    }
    int j = i();
    if (j > 0)
    {
      paramRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramRedTypeInfo.red_type.set(0);
      paramRedTypeInfo.red_content.set("");
      paramRedTypeInfo.red_desc.set("");
      a(i, j);
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify hasReddot;");
    }
    return paramRedTypeInfo;
  }
  
  public Runnable a(LebaTabRedTouch.RefreshCallback paramRefreshCallback)
  {
    return new LebaTabRedTouch.1(this, paramRefreshCallback);
  }
  
  public Set<Long> a(ILebaHelperService paramILebaHelperService)
  {
    HashSet localHashSet = new HashSet();
    paramILebaHelperService = paramILebaHelperService.getLebaShowList();
    if ((paramILebaHelperService != null) && (!paramILebaHelperService.isEmpty()))
    {
      paramILebaHelperService = paramILebaHelperService.iterator();
      while (paramILebaHelperService.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)paramILebaHelperService.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.b != null)) {
          localHashSet.add(Long.valueOf(localLebaViewItem.a));
        }
      }
    }
    return localHashSet;
  }
  
  public boolean a()
  {
    if (!c())
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "isOnlyShowQzone is no eModel");
      return false;
    }
    if (QzoneFrame.q())
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "isOnlyShowQzone isShowOldQZoneFrame");
      return true;
    }
    String str = b();
    if ("exp_shouq_dongtai_jianjie_B".equals(str))
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "isOnlyShowQzone exp b");
      return false;
    }
    if ("exp_shouq_dongtai_jianjie_C".equals(str))
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "isOnlyShowQzone exp c");
      return false;
    }
    QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "isOnlyShowQzone true");
    return true;
  }
  
  public String b()
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).getExpContentInSimpleUI(this.a.app);
  }
  
  public boolean c()
  {
    return SimpleUIUtil.e();
  }
  
  public int d()
  {
    Object localObject = this.a;
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      if (((SplashActivity)localObject).app == null) {
        return 0;
      }
      localObject = (QZoneManagerImp)this.a.app.getManager(QQManagerFactory.QZONE_MANAGER);
      i = j;
      if (localObject != null)
      {
        i = ((QZoneManagerImp)localObject).d(1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getQZoneMsgCount TYPE_PASSIVE_FEED: ");
          localStringBuilder.append(((QZoneManagerImp)localObject).d(1));
          QLog.d("UndealCount.MainAssistObserver", 2, localStringBuilder.toString());
        }
      }
    }
    return i;
  }
  
  public void e()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.LebaTabRedTouch
 * JD-Core Version:    0.7.0.1
 */