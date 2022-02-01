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
  long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new SpringFestivalTaskCallback.1(this));
  Conversation.UICallBack jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack;
  private final Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private SpringFestivalTaskCallback.BrushHBStateChangeListener jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener = new SpringFestivalTaskCallback.3(this);
  private BaseActivityData jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
  private SpringPopBanner jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner;
  private DesktopChangeListener jdField_a_of_type_ComTencentMobileqqMiniEntryDesktopDesktopChangeListener = new SpringFestivalTaskCallback.2(this);
  private boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = false;
  long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean = false;
  long jdField_d_of_type_Long = 2500L;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  private boolean f;
  private boolean g;
  
  public SpringFestivalTaskCallback(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    b();
  }
  
  private long a()
  {
    long l = ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a().grabReqInterval;
    if (l > 0L) {
      return l;
    }
    return this.jdField_d_of_type_Long;
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void a(boolean paramBoolean, String paramString)
  {
    MiniAppPullInterface localMiniAppPullInterface = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    if (localMiniAppPullInterface == null)
    {
      QLog.i("2021_UI_SpringFestivalTaskCallback", 1, "updateAppletsBackDrawable, miniAppPullInterface null, return");
      return;
    }
    if (paramBoolean)
    {
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getResources().getDisplayMetrics();
      paramString = Utils.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime, paramString, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, "default_miniapp_desktop_bg");
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
  
  private boolean a(int paramInt)
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
  
  private long b()
  {
    return ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a();
  }
  
  private boolean d()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loginwelcome_");
    localStringBuilder.append(((QQAppInterface)localObject1).getCurrentAccountUin());
    localObject1 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
    int i = ((SharedPreferences)localObject1).getInt("first_login", 0);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestIsFirstLogin state=");
      ((StringBuilder)localObject2).append(i);
      QLog.i("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject2).toString());
    }
    if (i != 1)
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putInt("first_login", 1);
      ((SharedPreferences.Editor)localObject1).apply();
      return true;
    }
    return false;
  }
  
  private void l()
  {
    MiniAppPullInterface localMiniAppPullInterface = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
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
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).removeDesktopChangeListener(localMiniAppPullInterface, this.jdField_a_of_type_ComTencentMobileqqMiniEntryDesktopDesktopChangeListener);
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "reportMiniAppDesktopOpened ");
    }
    HashMap localHashMap = new HashMap();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
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
  
  public BaseActivityData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "setMiniAppDesktop2NormalMode");
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).updateMiniHBBanner(null);
    a(false, null);
  }
  
  public void a(int paramInt)
  {
    long l1 = b();
    if (this.jdField_c_of_type_Long < 0L) {
      this.jdField_c_of_type_Long = l1;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a(false, PortalConstants.a, null);
      return;
    }
    long l2 = a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("grabHongbao  current  = ");
      localStringBuilder1.append(l1);
      localStringBuilder1.append(",lastGrabHongBaoResponseTime = ");
      localStringBuilder1.append(this.jdField_b_of_type_Long);
      localStringBuilder1.append(",lastGrabHongBaoRequestTime = ");
      localStringBuilder1.append(this.jdField_a_of_type_Long);
      localStringBuilder1.append(",firstGrabHongBaoLastCallTime = ");
      localStringBuilder1.append(this.jdField_c_of_type_Long);
      localStringBuilder1.append(",reqInterval = ");
      localStringBuilder1.append(l2);
      localStringBuilder1.append(",comboCount = ");
      localStringBuilder1.append(paramInt);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder1.toString());
    }
    if ((this.jdField_b_of_type_Long < 0L) && (Math.abs(l1 - this.jdField_a_of_type_Long) < 30000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "grabHongbao return for not resp");
      }
      return;
    }
    StringBuilder localStringBuilder2;
    if ((l1 - this.jdField_b_of_type_Long >= l2) && (l1 - this.jdField_a_of_type_Long >= l2) && (l1 - this.jdField_c_of_type_Long >= l2))
    {
      int j = -1;
      int i;
      try
      {
        i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.promotionId);
      }
      catch (Exception localException)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "grabHongbao Exception", localException);
          i = j;
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("grabHongbao real do request,current = ");
        localStringBuilder2.append(l1);
        localStringBuilder2.append(",lastGrabHongBaoRequestTime = ");
        localStringBuilder2.append(this.jdField_a_of_type_Long);
        localStringBuilder2.append(",lastGrabHongBaoResponseTime = ");
        localStringBuilder2.append(this.jdField_b_of_type_Long);
        localStringBuilder2.append(",promotionId = ");
        localStringBuilder2.append(i);
        localStringBuilder2.append(",activityId = ");
        localStringBuilder2.append(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id);
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder2.toString());
      }
      this.jdField_a_of_type_Long = l1;
      RedPacketServlet.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime, i, paramInt);
      j();
      return;
    }
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))
    {
      l1 = (Math.random() * 2300.0D + 1200.0D);
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("grabHongbao MSG_GRAB_FAKE_EVENT  delay = ");
        localStringBuilder2.append(l1);
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder2.toString());
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, l1);
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
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
    if (localRelativeLayout1.findViewById(2131377798) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "showSpringFestivalBanner return for already added");
      }
      return;
    }
    RelativeLayout localRelativeLayout2 = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a()).inflate(2131561111, localRelativeLayout1, false);
    ImageView localImageView = (ImageView)localRelativeLayout2.findViewById(2131377799);
    localImageView.setImageResource(2130845454);
    Object localObject2 = null;
    localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
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
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    if (i > 0) {
      paramInt = i;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("showSpringFestivalBanner,statusTitle.w = ");
      paramString.append(localRelativeLayout1.getWidth());
      paramString.append(",statusTitle.h = ");
      paramString.append(localRelativeLayout1.getHeight());
      paramString.append(",statusTitleHeightInNormalState = ");
      paramString.append(i);
      paramString.append(",bgBmp = ");
      paramString.append(localObject1);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, paramString.toString());
    }
    localRelativeLayout1.addView(localRelativeLayout2, 0, new RelativeLayout.LayoutParams(localRelativeLayout1.getWidth(), paramInt));
    localRelativeLayout2.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.j();
  }
  
  public void a(long paramLong, BaseActivityData paramBaseActivityData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData = paramBaseActivityData;
    Object localObject1 = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    Object localObject2 = ((SpringFestivalEntryManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onActivityStart isMiniAppDesktopOpened = ");
      ((StringBuilder)localObject3).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject3).append(",userDataItem.hasClickCloseBtn = ");
      ((StringBuilder)localObject3).append(((UserData.UserDataItem)localObject2).hasClickCloseBtn);
      ((StringBuilder)localObject3).append(",userDataItem.pendantCloseType = ");
      ((StringBuilder)localObject3).append(((UserData.UserDataItem)localObject2).pendantCloseType);
      ((StringBuilder)localObject3).append(",isResume = ");
      ((StringBuilder)localObject3).append(this.jdField_d_of_type_Boolean);
      ((StringBuilder)localObject3).append(",isLeftDrawerOpen = ");
      ((StringBuilder)localObject3).append(this.e);
      ((StringBuilder)localObject3).append(",actData = ");
      ((StringBuilder)localObject3).append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject3).toString());
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (!this.e))
    {
      if (paramBaseActivityData.type == 2)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener;
        if (localObject3 != null) {
          ((SpringFestivalTaskCallback.BrushHBStateChangeListener)localObject3).a();
        }
        if ((((UserData.UserDataItem)localObject2).hasClickCloseBtn) && ((((UserData.UserDataItem)localObject2).pendantCloseType == 2) || (((UserData.UserDataItem)localObject2).pendantCloseType == 3)))
        {
          g(paramBaseActivityData);
          return;
        }
        long l2 = b();
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
        if (((SpringFestivalEntryManager)localObject1).c())
        {
          int i = ((SpringFestivalEntryManager)localObject1).a();
          l1 /= i;
          paramLong = l1;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onActivityStart showPrepareCountDown SpeedUp prepareCountDownMs = ");
            ((StringBuilder)localObject1).append(l1);
            ((StringBuilder)localObject1).append(", ratio = ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject1).toString());
            paramLong = l1;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a((OnGrabActivityData)paramBaseActivityData, paramLong);
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
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
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
    if (localObject2 != null)
    {
      localObject2 = ((BaseActivityData)localObject2).id;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.promotionId;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack = paramUICallBack;
  }
  
  public void a(HBEntryBannerData paramHBEntryBannerData)
  {
    boolean bool = StudyModeManager.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMiniAppDesktop2HBMode isStudyMode = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(",");
      localStringBuilder.append(paramHBEntryBannerData.b());
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    if (bool) {
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).updateMiniHBBanner(paramHBEntryBannerData);
    a(true, paramHBEntryBannerData.c());
  }
  
  public void a(BaseActivityData paramBaseActivityData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData = paramBaseActivityData;
    UserData.UserDataItem localUserDataItem = ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(paramBaseActivityData.id);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityAboutToOver isMiniAppDesktopOpened = ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(",userDataItem.hasClickCloseBtn = ");
      localStringBuilder.append(localUserDataItem.hasClickCloseBtn);
      localStringBuilder.append(",userDataItem.pendantCloseType = ");
      localStringBuilder.append(localUserDataItem.pendantCloseType);
      localStringBuilder.append(",conversation.mHongBaoCtrlV2.mState = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a);
      localStringBuilder.append(",actData = ");
      localStringBuilder.append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    if (paramBaseActivityData.type == 2) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a != 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a != 3))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a == -1)
        {
          g(paramBaseActivityData);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onActivityAboutToOver call onActivityRealStart");
          }
          b(System.currentTimeMillis(), paramBaseActivityData);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.f();
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
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(",isLeftDrawerOpen = ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(",isResume = ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      ((StringBuilder)localObject).append(",msgTabBannerData = ");
      ((StringBuilder)localObject).append(paramMsgTabBannerData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (!this.e))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
      if ((localObject != null) && (((BaseActivityData)localObject).type == 2))
      {
        localObject = ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id);
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener;
        if (localObject != null) {
          ((SpringFestivalTaskCallback.BrushHBStateChangeListener)localObject).c();
        }
        a(paramMsgTabBannerData.type, paramMsgTabBannerData.liuhaiBgUrl);
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(PopBannerData paramPopBannerData)
  {
    if (paramPopBannerData == null)
    {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 1, "showPopBanner data=null return");
      return;
    }
    boolean bool;
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (!AppSetting.jdField_d_of_type_Boolean))
    {
      bool = d();
      if (!bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, String.format("showPopBanner data = %s", new Object[] { paramPopBannerData }));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner = new SpringPopBanner(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner.a(paramPopBannerData);
      }
    }
    else
    {
      bool = false;
    }
    QLog.d("2021_UI_SpringFestivalTaskCallback", 1, String.format("showPopBanner return... isMiniAppDesktopOpened=%b resume=%b talkback=%b isFirstLogin=%b", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(this.jdField_d_of_type_Boolean), Boolean.valueOf(AppSetting.jdField_d_of_type_Boolean), Boolean.valueOf(bool) }));
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onAccountChanged");
    }
    b();
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
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isBrushHBActOngoing isBrushHBActOngoing = ");
      localStringBuilder.append(this.f);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    return this.f;
  }
  
  public void b()
  {
    MiniAppPullInterface localMiniAppPullInterface = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
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
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).addDesktopChangeListener(localMiniAppPullInterface, this.jdField_a_of_type_ComTencentMobileqqMiniEntryDesktopDesktopChangeListener);
  }
  
  public void b(long paramLong, BaseActivityData paramBaseActivityData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData = paramBaseActivityData;
    UserData.UserDataItem localUserDataItem = ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityRealStart isMiniAppDesktopOpened = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(",userDataItem.hasClickCloseBtn = ");
      ((StringBuilder)localObject).append(localUserDataItem.hasClickCloseBtn);
      ((StringBuilder)localObject).append(",userDataItem.pendantCloseType = ");
      ((StringBuilder)localObject).append(localUserDataItem.pendantCloseType);
      ((StringBuilder)localObject).append(",isResume = ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      ((StringBuilder)localObject).append(",isLeftDrawerOpen = ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(",actData = ");
      ((StringBuilder)localObject).append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (!this.e))
    {
      if (paramBaseActivityData.type == 2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener;
        if (localObject != null) {
          ((SpringFestivalTaskCallback.BrushHBStateChangeListener)localObject).a();
        }
        if ((localUserDataItem.hasClickCloseBtn) && ((localUserDataItem.pendantCloseType == 2) || (localUserDataItem.pendantCloseType == 3)))
        {
          g(paramBaseActivityData);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a((OnGrabActivityData)paramBaseActivityData);
        return;
      }
      if ((paramBaseActivityData.type == 3) || (paramBaseActivityData.type == 1)) {
        g(paramBaseActivityData);
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void b(BaseActivityData paramBaseActivityData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityOver isMiniAppDesktopOpened = ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append("actData = ");
      localStringBuilder.append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.d();
    a();
    a(false);
    e();
    paramBaseActivityData = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener;
    if (paramBaseActivityData != null) {
      paramBaseActivityData.d();
    }
    k();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData = null;
    paramBaseActivityData = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener;
    if (paramBaseActivityData != null) {
      paramBaseActivityData.b();
    }
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Long = -1L;
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
    e();
    paramMsgTabBannerData = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener;
    if (paramMsgTabBannerData != null) {
      paramMsgTabBannerData.d();
    }
    k();
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
    paramPopBannerData = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner;
    if (paramPopBannerData != null) {
      paramPopBannerData.a(false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c()
  {
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onPause");
    }
  }
  
  public void c(BaseActivityData paramBaseActivityData)
  {
    Object localObject = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = ((SpringFestivalEntryManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id);
    boolean bool1 = ((SpringFestivalEntryManager)localObject).b();
    boolean bool2 = StudyModeManager.a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPendantShow  userDataItem.hasClickCloseBtn = ");
      ((StringBuilder)localObject).append(localUserDataItem.hasClickCloseBtn);
      ((StringBuilder)localObject).append(",isMiniAppDesktopOpened = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(",isPendantShowSwitchOn = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(",isStudyMode = ");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(",isResume = ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      ((StringBuilder)localObject).append(",isLeftDrawerOpen = ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(",actData = ");
      ((StringBuilder)localObject).append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject).toString());
    }
    if (bool2) {
      return;
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (!this.e))
    {
      if ((!localUserDataItem.hasClickCloseBtn) && (bool1)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a(paramBaseActivityData);
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean c()
  {
    SpringPopBanner localSpringPopBanner = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner;
    if ((localSpringPopBanner != null) && (localSpringPopBanner.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner.a(true);
      return true;
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_d_of_type_Boolean = true;
    boolean bool = StudyModeManager.a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume isStudyMode = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
    if ((localObject != null) && ((((BaseActivityData)localObject).type == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.type == 1)))
    {
      if (!((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onResume hideNormalActivityPendant");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.v();
      }
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.v();
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a();
      }
    }
    if (bool) {
      a();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onResume isNeedRefreshScheduleTask=");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
    QLog.d("2021_UI_SpringFestivalTaskCallback", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_c_of_type_Boolean)
    {
      ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).c();
      this.jdField_c_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.j();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.v();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "removeSpringFestivalBanner");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
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
    Object localObject2 = ((RelativeLayout)localObject1).findViewById(2131377798);
    if (localObject2 != null) {
      ((RelativeLayout)localObject1).removeView((View)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.i();
  }
  
  public void e(BaseActivityData paramBaseActivityData)
  {
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = localSpringFestivalEntryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id);
    boolean bool1 = StudyModeManager.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBreathLightShow ,userDataItem.hasDisplayBreathLight = ");
      localStringBuilder.append(localUserDataItem.hasDisplayBreathLight);
      localStringBuilder.append(",isMiniAppDesktopOpened = ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(",userDataItem.hasClickCloseBtn = ");
      localStringBuilder.append(localUserDataItem.hasClickCloseBtn);
      localStringBuilder.append(",isLeftDrawerOpen = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",isResume = ");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      localStringBuilder.append(",isStudyMode = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",actData = ");
      localStringBuilder.append(paramBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    if (bool1) {
      return;
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (!this.e))
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
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a(bool1);
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.d(bool1);
        localUserDataItem.hasDisplayBreathLight = true;
        localSpringFestivalEntryManager.a();
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 5000L);
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onDestroy");
    }
    l();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack = null;
    SpringPopBanner localSpringPopBanner = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner;
    if (localSpringPopBanner != null) {
      localSpringPopBanner.a(true);
    }
    a(false);
    b(false);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "updateLastGrabHongbaoRequestTime");
    }
    this.jdField_a_of_type_Long = b();
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
    e();
    paramBaseActivityData = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener;
    if (paramBaseActivityData != null) {
      paramBaseActivityData.d();
    }
    k();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onDrawerOpened");
    }
    this.e = true;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onDrawerClosed");
    }
    this.e = false;
    if (this.jdField_c_of_type_Boolean)
    {
      ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).c();
      this.jdField_c_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.j();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "reportBrushLotteryRequest");
    }
    HashMap localHashMap = new HashMap();
    Object localObject = a();
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
  
  public void k()
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
    int i = paramBundle.getInt("key_award_id", -1);
    int j = paramBundle.getInt("key_award_type", -1);
    int k = paramBundle.getInt("k_money", -1);
    int m = paramBundle.getInt("key_promotion_id", -1);
    Object localObject1 = paramBundle.getString("key_url");
    long l = paramBundle.getLong("key_report_ret_code");
    a(l, String.valueOf(j));
    this.jdField_b_of_type_Long = b();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive cmd = CMD_RESULT isSuccess = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(",awardType = ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(", lastGrabHongBaoResponseTime = ");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject2).append(", portId = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", retCodeForReport = ");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(", packUrl = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", showType = ");
      ((StringBuilder)localObject2).append(-1);
      ((StringBuilder)localObject2).append(", money = ");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(", awardId = ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", promotionId = ");
      ((StringBuilder)localObject2).append(m);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject2).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isSuccess = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" isValidAwardType(awardType) = ");
      ((StringBuilder)localObject1).append(a(j));
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    if ((paramBoolean) && (a(j))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().getResources().getString(2131698958);
    l = -1L;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData;
    if ((localObject2 != null) && ((localObject2 instanceof OnGrabActivityData)))
    {
      localObject1 = ((OnGrabActivityData)localObject2).noRPWording;
      l = ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id).leftCountDownDuration;
      l = ((OnGrabActivityData)this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData).playDuration * 1000 - l;
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive grabhongbao result exception , curActivityData = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 1, ((StringBuilder)localObject2).toString());
    }
    paramBundle.putLong("key_current_brush_progress_ms", l);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a(paramBoolean, (String)localObject1, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback
 * JD-Core Version:    0.7.0.1
 */