package com.tencent.mobileqq.activity.springfestival.entry;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.Conversation.UICallBack;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.activity.springfestival.HBEntryBannerData;
import com.tencent.mobileqq.activity.springfestival.Utils;
import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.BreathLightData;
import com.tencent.mobileqq.activity.springfestival.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.activity.springfestival.entry.model.OnGrabActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.PopBannerData;
import com.tencent.mobileqq.activity.springfestival.entry.model.UserData;
import com.tencent.mobileqq.activity.springfestival.entry.model.UserData.UserDataItem;
import com.tencent.mobileqq.activity.springfestival.entry.ui.SpringPopBanner;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener;
import com.tencent.mobileqq.portal.ConversationHongBaoV2;
import com.tencent.mobileqq.portal.PortalConstants;
import com.tencent.mobileqq.portal.RedPacketServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class SpringFestivalTaskCallback
  implements ITaskCallback, BusinessObserver
{
  Conversation.UICallBack a;
  long b = -1L;
  long c = -1L;
  long d = -1L;
  long e = 2500L;
  private final Conversation f;
  private SpringPopBanner g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private Handler m = new Handler(Looper.getMainLooper(), new SpringFestivalTaskCallback.1(this));
  private DesktopChangeListener n = new SpringFestivalTaskCallback.2(this);
  private BaseActivityData o;
  private SpringFestivalTaskCallback.BrushHBStateChangeListener p = new SpringFestivalTaskCallback.3(this);
  private boolean q;
  private boolean r;
  
  public SpringFestivalTaskCallback(Conversation paramConversation)
  {
    this.f = paramConversation;
    e();
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void a(boolean paramBoolean, String paramString)
  {
    MiniAppPullInterface localMiniAppPullInterface = this.f.y();
    if (localMiniAppPullInterface == null)
    {
      QLog.i("2021_UI_SpringFestivalTaskCallback", 1, "updateAppletsBackDrawable, miniAppPullInterface null, return");
      return;
    }
    if (paramBoolean)
    {
      DisplayMetrics localDisplayMetrics = this.f.aF.getApplicationContext().getResources().getDisplayMetrics();
      paramString = Utils.a(this.f.aF, paramString, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, "default_miniapp_desktop_bg");
      if (paramString != null)
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).updateMiniDesktopBackground(localMiniAppPullInterface, paramString);
        return;
      }
      QLog.d("2021_UI_SpringFestivalTaskCallback", 1, "updateAppletsBackDrawable, drawable null");
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).updateMiniDesktopBackground(localMiniAppPullInterface, null);
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1) {
        if (paramInt == 2) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isValidAwardType type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",result = ");
      localStringBuilder.append(bool1);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  private void p()
  {
    MiniAppPullInterface localMiniAppPullInterface = this.f.y();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeMiniAppDestopChangeListener miniAppPullInterface = ");
      localStringBuilder.append(localMiniAppPullInterface);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    if (localMiniAppPullInterface == null) {
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).removeDesktopChangeListener(localMiniAppPullInterface, this.n);
  }
  
  private long q()
  {
    long l1 = ((SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a().grabReqInterval;
    if (l1 > 0L) {
      return l1;
    }
    return this.e;
  }
  
  private long r()
  {
    return ((SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).i();
  }
  
  private boolean s()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loginwelcome_");
    localStringBuilder.append(((QQAppInterface)localObject1).getCurrentAccountUin());
    localObject1 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
    int i1 = ((SharedPreferences)localObject1).getInt("first_login", 0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestIsFirstLogin state=");
      ((StringBuilder)localObject2).append(i1);
      QLog.i("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject2).toString());
    }
    if (i1 != 1)
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putInt("first_login", 1);
      ((SharedPreferences.Editor)localObject1).apply();
      return true;
    }
    return false;
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "reportMiniAppDesktopOpened ");
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((BaseActivityData)localObject).id;
      localHashMap.put("active_id", localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportMiniAppDesktopOpened activityID = ");
        localStringBuilder.append((String)localObject);
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
      }
    }
    SpringHbReporter.a(ReportConstant.Event.m, 0, 0, localHashMap, "drop");
  }
  
  public void a(int paramInt)
  {
    long l1 = r();
    if (this.d < 0L) {
      this.d = l1;
    }
    if (!NetworkUtils.isNetworkAvailable(this.f.P()))
    {
      this.f.aa.a(false, PortalConstants.a, null);
      return;
    }
    long l2 = q();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("grabHongbao  current  = ");
      localStringBuilder1.append(l1);
      localStringBuilder1.append(",lastGrabHongBaoResponseTime = ");
      localStringBuilder1.append(this.c);
      localStringBuilder1.append(",lastGrabHongBaoRequestTime = ");
      localStringBuilder1.append(this.b);
      localStringBuilder1.append(",firstGrabHongBaoLastCallTime = ");
      localStringBuilder1.append(this.d);
      localStringBuilder1.append(",reqInterval = ");
      localStringBuilder1.append(l2);
      localStringBuilder1.append(",comboCount = ");
      localStringBuilder1.append(paramInt);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder1.toString());
    }
    if ((this.c < 0L) && (Math.abs(l1 - this.b) < 30000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "grabHongbao return for not resp");
      }
      return;
    }
    StringBuilder localStringBuilder2;
    if ((l1 - this.c >= l2) && (l1 - this.b >= l2) && (l1 - this.d >= l2))
    {
      int i2 = -1;
      int i1;
      try
      {
        i1 = Integer.parseInt(this.o.promotionId);
      }
      catch (Exception localException)
      {
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "grabHongbao Exception", localException);
          i1 = i2;
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("grabHongbao real do request,current = ");
        localStringBuilder2.append(l1);
        localStringBuilder2.append(",lastGrabHongBaoRequestTime = ");
        localStringBuilder2.append(this.b);
        localStringBuilder2.append(",lastGrabHongBaoResponseTime = ");
        localStringBuilder2.append(this.c);
        localStringBuilder2.append(",promotionId = ");
        localStringBuilder2.append(i1);
        localStringBuilder2.append(",activityId = ");
        localStringBuilder2.append(this.o.id);
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder2.toString());
      }
      this.b = l1;
      RedPacketServlet.a(this.f.aF, i1, paramInt);
      n();
      return;
    }
    if (!this.m.hasMessages(1))
    {
      l1 = (Math.random() * 2300.0D + 1200.0D);
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("grabHongbao MSG_GRAB_FAKE_EVENT  delay = ");
        localStringBuilder2.append(l1);
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder2.toString());
      }
      this.m.sendEmptyMessageDelayed(1, l1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "grabHongbao return for limit req freq ");
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showSpringFestivalBanner ,bannerType = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",bannerBgUrl = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.f.B();
    if (!(localObject1 instanceof RelativeLayout))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("showSpringFestivalBanner return, title = ");
        paramString.append(localObject1);
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, paramString.toString());
      }
      return;
    }
    ((View)localObject1).requestLayout();
    RelativeLayout localRelativeLayout1 = (RelativeLayout)localObject1;
    if (localRelativeLayout1.findViewById(2131446264) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "showSpringFestivalBanner return for already added");
      }
      return;
    }
    RelativeLayout localRelativeLayout2 = (RelativeLayout)LayoutInflater.from(this.f.P()).inflate(2131627461, localRelativeLayout1, false);
    ImageView localImageView = (ImageView)localRelativeLayout2.findViewById(2131446265);
    localImageView.setImageResource(2130846910);
    Object localObject2 = null;
    localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if (paramInt == 0)
      {
        paramString = localSpringFestivalEntryManager.a(paramString, "");
        localObject1 = paramString;
        if (paramString != null)
        {
          localImageView.setImageBitmap(paramString);
          localObject1 = paramString;
        }
      }
      else
      {
        localObject1 = localObject2;
        if (paramInt == 1)
        {
          paramString = localSpringFestivalEntryManager.b(paramString);
          boolean bool = FileUtils.fileExists(paramString);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("showSpringFestivalBanner exist = ");
            ((StringBuilder)localObject1).append(bool);
            ((StringBuilder)localObject1).append(",apngFilePath = ");
            ((StringBuilder)localObject1).append(paramString);
            QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = localObject2;
          if (bool)
          {
            localObject1 = new ApngOptions();
            ((ApngOptions)localObject1).a(URLDrawableHelperConstants.a);
            localImageView.setImageDrawable(((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", (ApngOptions)localObject1, paramString));
            localObject1 = localObject2;
          }
        }
      }
    }
    paramInt = localRelativeLayout1.getHeight();
    int i1 = this.f.i();
    if (i1 > 0) {
      paramInt = i1;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("showSpringFestivalBanner,statusTitle.w = ");
      paramString.append(localRelativeLayout1.getWidth());
      paramString.append(",statusTitle.h = ");
      paramString.append(localRelativeLayout1.getHeight());
      paramString.append(",statusTitleHeightInNormalState = ");
      paramString.append(i1);
      paramString.append(",bgBmp = ");
      paramString.append(localObject1);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, paramString.toString());
    }
    localRelativeLayout1.addView(localRelativeLayout2, 0, new RelativeLayout.LayoutParams(localRelativeLayout1.getWidth(), paramInt));
    localRelativeLayout2.requestLayout();
    this.f.n();
  }
  
  public void a(long paramLong, BaseActivityData paramBaseActivityData)
  {
    this.o = paramBaseActivityData;
    Object localObject1 = (SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    Object localObject2 = ((SpringFestivalEntryManager)localObject1).c(this.o.id);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onActivityStart isMiniAppDesktopOpened = ");
      ((StringBuilder)localObject3).append(this.i);
      ((StringBuilder)localObject3).append(",userDataItem.hasClickCloseBtn = ");
      ((StringBuilder)localObject3).append(((UserData.UserDataItem)localObject2).hasClickCloseBtn);
      ((StringBuilder)localObject3).append(",userDataItem.pendantCloseType = ");
      ((StringBuilder)localObject3).append(((UserData.UserDataItem)localObject2).pendantCloseType);
      ((StringBuilder)localObject3).append(",isResume = ");
      ((StringBuilder)localObject3).append(this.k);
      ((StringBuilder)localObject3).append(",isLeftDrawerOpen = ");
      ((StringBuilder)localObject3).append(this.l);
      ((StringBuilder)localObject3).append(",actData = ");
      ((StringBuilder)localObject3).append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject3).toString());
    }
    if ((!this.i) && (this.k) && (!this.l))
    {
      if (paramBaseActivityData.type == 2)
      {
        localObject3 = this.p;
        if (localObject3 != null) {
          ((SpringFestivalTaskCallback.BrushHBStateChangeListener)localObject3).a();
        }
        if ((((UserData.UserDataItem)localObject2).hasClickCloseBtn) && ((((UserData.UserDataItem)localObject2).pendantCloseType == 2) || (((UserData.UserDataItem)localObject2).pendantCloseType == 3)))
        {
          g(paramBaseActivityData);
          return;
        }
        long l2 = r();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onActivityStart current = ");
          ((StringBuilder)localObject2).append(l2);
          ((StringBuilder)localObject2).append(",taskTime = ");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append(",delay = ");
          ((StringBuilder)localObject2).append(paramBaseActivityData.getPeakDelayMs());
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject2).toString());
        }
        long l1 = paramLong + paramBaseActivityData.getPeakDelayMs() - l2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onActivityStart showPrepareCountDown current = ");
          ((StringBuilder)localObject2).append(l2);
          ((StringBuilder)localObject2).append(",prepareCountDownMs = ");
          ((StringBuilder)localObject2).append(l1);
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject2).toString());
        }
        paramLong = l1;
        if (((SpringFestivalEntryManager)localObject1).j())
        {
          int i1 = ((SpringFestivalEntryManager)localObject1).k();
          l1 /= i1;
          paramLong = l1;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onActivityStart showPrepareCountDown SpeedUp prepareCountDownMs = ");
            ((StringBuilder)localObject1).append(l1);
            ((StringBuilder)localObject1).append(", ratio = ");
            ((StringBuilder)localObject1).append(i1);
            QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject1).toString());
            paramLong = l1;
          }
        }
        this.f.aa.a((OnGrabActivityData)paramBaseActivityData, paramLong);
      }
      return;
    }
    this.j = true;
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportBrushLotteryRequestResult result = ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(",awardType = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new HashMap();
    Object localObject2 = this.o;
    if (localObject2 != null)
    {
      localObject2 = ((BaseActivityData)localObject2).id;
      String str = this.o.promotionId;
      ((Map)localObject1).put("active_id", localObject2);
      ((Map)localObject1).put("jackpot_id", str);
      ((Map)localObject1).put("ext1", paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportBrushLotteryRequestResult activityID = ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("，promotionId = ");
        localStringBuilder.append(str);
        localStringBuilder.append(",awardType = ");
        localStringBuilder.append(paramString);
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
      }
    }
    SpringHbReporter.a(ReportConstant.Event.p, 0, (int)paramLong, (Map)localObject1, "response");
  }
  
  public void a(Conversation.UICallBack paramUICallBack)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setConversationUICallBack uiCallBack = ");
      localStringBuilder.append(paramUICallBack);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    this.a = paramUICallBack;
  }
  
  public void a(HBEntryBannerData paramHBEntryBannerData)
  {
    boolean bool = StudyModeManager.h();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMiniAppDesktop2HBMode isStudyMode = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(",");
      localStringBuilder.append(paramHBEntryBannerData.d());
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    if (bool) {
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).updateMiniHBBanner(paramHBEntryBannerData);
    a(true, paramHBEntryBannerData.e());
  }
  
  public void a(BaseActivityData paramBaseActivityData)
  {
    this.o = paramBaseActivityData;
    UserData.UserDataItem localUserDataItem = ((SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).c(paramBaseActivityData.id);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityAboutToOver isMiniAppDesktopOpened = ");
      localStringBuilder.append(this.i);
      localStringBuilder.append(",userDataItem.hasClickCloseBtn = ");
      localStringBuilder.append(localUserDataItem.hasClickCloseBtn);
      localStringBuilder.append(",userDataItem.pendantCloseType = ");
      localStringBuilder.append(localUserDataItem.pendantCloseType);
      localStringBuilder.append(",conversation.mHongBaoCtrlV2.mState = ");
      localStringBuilder.append(this.f.aa.e);
      localStringBuilder.append(",actData = ");
      localStringBuilder.append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    if (this.i)
    {
      this.j = true;
      return;
    }
    if (paramBaseActivityData.type == 2) {
      if ((this.f.aa.e != 2) && (this.f.aa.e != 3))
      {
        if (this.f.aa.e == -1)
        {
          g(paramBaseActivityData);
          return;
        }
        if (this.f.aa.e == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onActivityAboutToOver call onActivityRealStart");
          }
          b(System.currentTimeMillis(), paramBaseActivityData);
        }
      }
      else
      {
        this.f.aa.h();
      }
    }
  }
  
  public void a(MsgTabBannerData paramMsgTabBannerData)
  {
    if (paramMsgTabBannerData == null)
    {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 1, "onMsgTabBannerShow data=null return");
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMsgTabBannerShow ,isMiniAppDesktopOpened = ");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(",isLeftDrawerOpen = ");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append(",isResume = ");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append(",msgTabBannerData = ");
      ((StringBuilder)localObject).append(paramMsgTabBannerData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.i) && (this.k) && (!this.l))
    {
      localObject = this.o;
      if ((localObject != null) && (((BaseActivityData)localObject).type == 2))
      {
        localObject = ((SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).c(this.o.id);
        if (((UserData.UserDataItem)localObject).leftCountDownDuration == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onMsgTabBannerShow return for already played grab act");
          }
          return;
        }
        if ((((UserData.UserDataItem)localObject).hasClickCloseBtn) && ((((UserData.UserDataItem)localObject).pendantCloseType == 2) || (((UserData.UserDataItem)localObject).pendantCloseType == 3)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onMsgTabBannerShow return for grab act has closed");
          }
          return;
        }
      }
      boolean bool = ThemeUtil.isDefaultOrDIYTheme(false);
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, String.format("onMsgTabBannerShow isDefaultTheme = %s, data = %s", new Object[] { Boolean.valueOf(bool), paramMsgTabBannerData.toSimpleString() }));
      }
      if (bool)
      {
        localObject = this.p;
        if (localObject != null) {
          ((SpringFestivalTaskCallback.BrushHBStateChangeListener)localObject).c();
        }
        a(paramMsgTabBannerData.type, paramMsgTabBannerData.liuhaiBgUrl);
      }
      return;
    }
    this.j = true;
  }
  
  public void a(PopBannerData paramPopBannerData)
  {
    if (paramPopBannerData == null)
    {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 1, "showPopBanner data=null return");
      return;
    }
    boolean bool;
    if ((!this.i) && (this.k) && (!AppSetting.e))
    {
      bool = s();
      if (!bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, String.format("showPopBanner data = %s", new Object[] { paramPopBannerData }));
        }
        if (this.g == null) {
          this.g = new SpringPopBanner(this.f);
        }
        this.g.a(paramPopBannerData);
      }
    }
    else
    {
      bool = false;
    }
    QLog.d("2021_UI_SpringFestivalTaskCallback", 1, String.format("showPopBanner return... isMiniAppDesktopOpened=%b resume=%b talkback=%b isFirstLogin=%b", new Object[] { Boolean.valueOf(this.i), Boolean.valueOf(this.k), Boolean.valueOf(AppSetting.e), Boolean.valueOf(bool) }));
    this.j = true;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onAccountChanged");
    }
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBrushHBActOngoing brushHBActOngoing = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    this.q = paramBoolean;
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isBrushHBActOngoing isBrushHBActOngoing = ");
      localStringBuilder.append(this.q);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    return this.q;
  }
  
  public void b(long paramLong, BaseActivityData paramBaseActivityData)
  {
    this.o = paramBaseActivityData;
    UserData.UserDataItem localUserDataItem = ((SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).c(this.o.id);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityRealStart isMiniAppDesktopOpened = ");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(",userDataItem.hasClickCloseBtn = ");
      ((StringBuilder)localObject).append(localUserDataItem.hasClickCloseBtn);
      ((StringBuilder)localObject).append(",userDataItem.pendantCloseType = ");
      ((StringBuilder)localObject).append(localUserDataItem.pendantCloseType);
      ((StringBuilder)localObject).append(",isResume = ");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append(",isLeftDrawerOpen = ");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append(",actData = ");
      ((StringBuilder)localObject).append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.i) && (this.k) && (!this.l))
    {
      if (paramBaseActivityData.type == 2)
      {
        localObject = this.p;
        if (localObject != null) {
          ((SpringFestivalTaskCallback.BrushHBStateChangeListener)localObject).a();
        }
        if ((localUserDataItem.hasClickCloseBtn) && ((localUserDataItem.pendantCloseType == 2) || (localUserDataItem.pendantCloseType == 3)))
        {
          g(paramBaseActivityData);
          return;
        }
        this.f.aa.a((OnGrabActivityData)paramBaseActivityData);
        return;
      }
      if ((paramBaseActivityData.type == 3) || (paramBaseActivityData.type == 1)) {
        g(paramBaseActivityData);
      }
      return;
    }
    this.j = true;
  }
  
  public void b(BaseActivityData paramBaseActivityData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityOver isMiniAppDesktopOpened = ");
      localStringBuilder.append(this.i);
      localStringBuilder.append("actData = ");
      localStringBuilder.append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    if (this.i)
    {
      this.j = true;
      return;
    }
    this.f.aa.e();
    d();
    a(false);
    h();
    paramBaseActivityData = this.p;
    if (paramBaseActivityData != null) {
      paramBaseActivityData.d();
    }
    o();
    this.o = null;
    paramBaseActivityData = this.p;
    if (paramBaseActivityData != null) {
      paramBaseActivityData.b();
    }
    this.c = -1L;
    this.b = -1L;
    this.d = -1L;
  }
  
  public void b(MsgTabBannerData paramMsgTabBannerData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMsgTabBannerHide data = ");
      if (paramMsgTabBannerData == null) {
        paramMsgTabBannerData = "null";
      } else {
        paramMsgTabBannerData = paramMsgTabBannerData.toSimpleString();
      }
      localStringBuilder.append(paramMsgTabBannerData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    h();
    paramMsgTabBannerData = this.p;
    if (paramMsgTabBannerData != null) {
      paramMsgTabBannerData.d();
    }
    o();
  }
  
  public void b(PopBannerData paramPopBannerData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPopBannerHide data = ");
      localStringBuilder.append(paramPopBannerData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    paramPopBannerData = this.g;
    if (paramPopBannerData != null) {
      paramPopBannerData.a(false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public boolean b()
  {
    return this.r;
  }
  
  public BaseActivityData c()
  {
    return this.o;
  }
  
  public void c(BaseActivityData paramBaseActivityData)
  {
    Object localObject = (SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = ((SpringFestivalEntryManager)localObject).c(this.o.id);
    boolean bool1 = ((SpringFestivalEntryManager)localObject).h();
    boolean bool2 = StudyModeManager.h();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPendantShow  userDataItem.hasClickCloseBtn = ");
      ((StringBuilder)localObject).append(localUserDataItem.hasClickCloseBtn);
      ((StringBuilder)localObject).append(",isMiniAppDesktopOpened = ");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(",isPendantShowSwitchOn = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(",isStudyMode = ");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(",isResume = ");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append(",isLeftDrawerOpen = ");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append(",actData = ");
      ((StringBuilder)localObject).append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject).toString());
    }
    if (bool2) {
      return;
    }
    if ((!this.i) && (this.k) && (!this.l))
    {
      if ((!localUserDataItem.hasClickCloseBtn) && (bool1)) {
        this.f.aa.a(paramBaseActivityData);
      }
      return;
    }
    this.j = true;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "setMiniAppDesktop2NormalMode");
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).updateMiniHBBanner(null);
    a(false, null);
  }
  
  public void d(BaseActivityData paramBaseActivityData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPendantHide actData = ");
      localStringBuilder.append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    this.f.aa.y();
  }
  
  public void e()
  {
    MiniAppPullInterface localMiniAppPullInterface = this.f.y();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMiniAppDestopChangeListener miniAppPullInterface = ");
      localStringBuilder.append(localMiniAppPullInterface);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    if (localMiniAppPullInterface == null) {
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).addDesktopChangeListener(localMiniAppPullInterface, this.n);
  }
  
  public void e(BaseActivityData paramBaseActivityData)
  {
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = localSpringFestivalEntryManager.c(this.o.id);
    boolean bool1 = StudyModeManager.h();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBreathLightShow ,userDataItem.hasDisplayBreathLight = ");
      localStringBuilder.append(localUserDataItem.hasDisplayBreathLight);
      localStringBuilder.append(",isMiniAppDesktopOpened = ");
      localStringBuilder.append(this.i);
      localStringBuilder.append(",userDataItem.hasClickCloseBtn = ");
      localStringBuilder.append(localUserDataItem.hasClickCloseBtn);
      localStringBuilder.append(",isLeftDrawerOpen = ");
      localStringBuilder.append(this.l);
      localStringBuilder.append(",isResume = ");
      localStringBuilder.append(this.k);
      localStringBuilder.append(",isStudyMode = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",actData = ");
      localStringBuilder.append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    if (bool1) {
      return;
    }
    if ((!this.i) && (this.k) && (!this.l))
    {
      if ((!localUserDataItem.hasClickCloseBtn) && (!localUserDataItem.hasDisplayBreathLight))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (paramBaseActivityData != null)
        {
          bool1 = bool2;
          if (paramBaseActivityData.breathLightData != null)
          {
            bool1 = bool2;
            if (paramBaseActivityData.breathLightData.type == 1) {
              bool1 = true;
            }
          }
        }
        this.f.aa.a(bool1);
        this.f.aa.d(bool1);
        localUserDataItem.hasDisplayBreathLight = true;
        localSpringFestivalEntryManager.b();
        this.h = true;
        this.m.sendEmptyMessageDelayed(2, 5000L);
      }
      return;
    }
    this.j = true;
  }
  
  public void f()
  {
    this.k = false;
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onPause");
    }
  }
  
  public void f(BaseActivityData paramBaseActivityData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBreathLightHide actData = ");
      localStringBuilder.append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    this.f.aa.a();
    this.h = false;
  }
  
  public void g()
  {
    this.k = true;
    boolean bool = StudyModeManager.h();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume isStudyMode = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.o;
    if ((localObject != null) && ((((BaseActivityData)localObject).type == 3) || (this.o.type == 1)))
    {
      if (!((SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).h())
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onResume hideNormalActivityPendant");
        }
        this.f.aa.y();
      }
      if (bool)
      {
        this.f.aa.y();
        this.f.aa.a();
      }
    }
    if (bool) {
      d();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onResume isNeedRefreshScheduleTask=");
    ((StringBuilder)localObject).append(this.j);
    QLog.d("2021_UI_SpringFestivalTaskCallback", 1, ((StringBuilder)localObject).toString());
    if (this.j)
    {
      ((SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).m();
      this.j = false;
    }
    this.f.aa.l();
  }
  
  public void g(BaseActivityData paramBaseActivityData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyBrushEnd actData = ");
      localStringBuilder.append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    if (paramBaseActivityData == null)
    {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 1, "notifyBrushEnd return");
      return;
    }
    a(new HBEntryBannerData(paramBaseActivityData.getMiniEntryData(), paramBaseActivityData.getType(), paramBaseActivityData.getId()));
    a(false);
    h();
    paramBaseActivityData = this.p;
    if (paramBaseActivityData != null) {
      paramBaseActivityData.d();
    }
    o();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "removeSpringFestivalBanner");
    }
    Object localObject1 = this.f.B();
    if (!(localObject1 instanceof RelativeLayout))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("removeSpringFestivalBanner return, title = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    localObject1 = (RelativeLayout)localObject1;
    Object localObject2 = ((RelativeLayout)localObject1).findViewById(2131446264);
    if (localObject2 != null) {
      ((RelativeLayout)localObject1).removeView((View)localObject2);
    }
    this.f.m();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onDestroy");
    }
    p();
    this.m.removeCallbacksAndMessages(null);
    this.a = null;
    SpringPopBanner localSpringPopBanner = this.g;
    if (localSpringPopBanner != null) {
      localSpringPopBanner.a(true);
    }
    a(false);
    b(false);
  }
  
  public boolean j()
  {
    SpringPopBanner localSpringPopBanner = this.g;
    if ((localSpringPopBanner != null) && (localSpringPopBanner.a()))
    {
      this.g.a(true);
      return true;
    }
    return false;
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "updateLastGrabHongbaoRequestTime");
    }
    this.b = r();
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onDrawerOpened");
    }
    this.l = true;
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onDrawerClosed");
    }
    this.l = false;
    if (this.j)
    {
      ((SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).m();
      this.j = false;
    }
    this.f.aa.l();
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "reportBrushLotteryRequest");
    }
    HashMap localHashMap = new HashMap();
    Object localObject = c();
    if (localObject != null)
    {
      String str = ((BaseActivityData)localObject).id;
      localObject = ((BaseActivityData)localObject).promotionId;
      localHashMap.put("active_id", str);
      localHashMap.put("jackpot_id", localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportBrushLotteryRequest activityID = ");
        localStringBuilder.append(str);
        localStringBuilder.append("，promotionId = ");
        localStringBuilder.append((String)localObject);
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
      }
    }
    SpringHbReporter.a(ReportConstant.Event.p, 0, 0, localHashMap, "request");
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "tryRecoverTianshuBanner");
    }
    BannerManager.a().b(VasADBannerProcessor.a, 3003);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive, ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt != 1) {
      return;
    }
    paramInt = paramBundle.getInt("k_id", -1);
    int i1 = paramBundle.getInt("key_award_id", -1);
    int i2 = paramBundle.getInt("key_award_type", -1);
    int i3 = paramBundle.getInt("k_money", -1);
    int i4 = paramBundle.getInt("key_promotion_id", -1);
    Object localObject1 = paramBundle.getString("key_url");
    long l1 = paramBundle.getLong("key_report_ret_code");
    a(l1, String.valueOf(i2));
    this.c = r();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive cmd = CMD_RESULT isSuccess = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(",awardType = ");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append(", lastGrabHongBaoResponseTime = ");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(", portId = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", retCodeForReport = ");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(", packUrl = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", showType = ");
      ((StringBuilder)localObject2).append(-1);
      ((StringBuilder)localObject2).append(", money = ");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject2).append(", awardId = ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(", promotionId = ");
      ((StringBuilder)localObject2).append(i4);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject2).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isSuccess = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" isValidAwardType(awardType) = ");
      ((StringBuilder)localObject1).append(b(i2));
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.m.hasMessages(1)) {
      this.m.removeMessages(1);
    }
    if ((paramBoolean) && (b(i2))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localObject1 = this.f.P().getResources().getString(2131896950);
    l1 = -1L;
    Object localObject2 = this.o;
    if ((localObject2 != null) && ((localObject2 instanceof OnGrabActivityData)))
    {
      localObject1 = ((OnGrabActivityData)localObject2).noRPWording;
      l1 = ((SpringFestivalEntryManager)this.f.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).c(this.o.id).leftCountDownDuration;
      l1 = ((OnGrabActivityData)this.o).playDuration * 1000 - l1;
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive grabhongbao result exception , curActivityData = ");
      ((StringBuilder)localObject2).append(this.o);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 1, ((StringBuilder)localObject2).toString());
    }
    paramBundle.putLong("key_current_brush_progress_ms", l1);
    this.f.aa.a(paramBoolean, (String)localObject1, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback
 * JD-Core Version:    0.7.0.1
 */