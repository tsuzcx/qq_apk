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
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.Conversation.UICallBack;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
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
        if (paramInt != 2) {
          break label64;
        }
      }
    }
    label64:
    for (bool1 = bool2;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "isValidAwardType type = " + paramInt + ",result = " + bool1);
      }
      return bool1;
    }
  }
  
  private long b()
  {
    return ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a();
  }
  
  private boolean d()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("loginwelcome_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0);
    int i = ((SharedPreferences)localObject).getInt("first_login", 0);
    if (QLog.isColorLevel()) {
      QLog.i("2021_UI_SpringFestivalTaskCallback", 2, "requestIsFirstLogin state=" + i);
    }
    if (i != 1)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("first_login", 1);
      ((SharedPreferences.Editor)localObject).apply();
      return true;
    }
    return false;
  }
  
  private void l()
  {
    MiniAppPullInterface localMiniAppPullInterface = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "removeMiniAppDestopChangeListener miniAppPullInterface = " + localMiniAppPullInterface);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id;
      localHashMap.put("active_id", str);
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "reportMiniAppDesktopOpened activityID = " + str);
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
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a(false, PortalConstants.a, null);
    }
    do
    {
      long l2;
      do
      {
        return;
        l2 = a();
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "grabHongbao  current  = " + l1 + ",lastGrabHongBaoResponseTime = " + this.jdField_b_of_type_Long + ",lastGrabHongBaoRequestTime = " + this.jdField_a_of_type_Long + ",firstGrabHongBaoLastCallTime = " + this.jdField_c_of_type_Long + ",reqInterval = " + l2 + ",comboCount = " + paramInt);
        }
        if ((this.jdField_b_of_type_Long >= 0L) || (Math.abs(l1 - this.jdField_a_of_type_Long) >= 30000L)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "grabHongbao return for not resp");
      return;
      if ((l1 - this.jdField_b_of_type_Long >= l2) && (l1 - this.jdField_a_of_type_Long >= l2) && (l1 - this.jdField_c_of_type_Long >= l2)) {
        break;
      }
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))
      {
        l1 = (1200.0D + Math.random() * 2300.0D);
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "grabHongbao MSG_GRAB_FAKE_EVENT  delay = " + l1);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, l1);
      }
    } while (!QLog.isColorLevel());
    QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "grabHongbao return for limit req freq ");
    return;
    int j = -1;
    try
    {
      i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.promotionId);
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "grabHongbao real do request,current = " + l1 + ",lastGrabHongBaoRequestTime = " + this.jdField_a_of_type_Long + ",lastGrabHongBaoResponseTime = " + this.jdField_b_of_type_Long + ",promotionId = " + i + ",activityId = " + this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id);
      }
      this.jdField_a_of_type_Long = l1;
      RedPacketServlet.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime, i, paramInt);
      j();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "grabHongbao Exception", localException);
          i = j;
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "showSpringFestivalBanner ,bannerType = " + paramInt + ",bannerBgUrl = " + paramString);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    if (!(localObject1 instanceof RelativeLayout)) {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "showSpringFestivalBanner return, title = " + localObject1);
      }
    }
    do
    {
      return;
      ((View)localObject1).requestLayout();
      localObject1 = (RelativeLayout)localObject1;
      if (((RelativeLayout)localObject1).findViewById(2131378387) == null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "showSpringFestivalBanner return for already added");
    return;
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a()).inflate(2131561268, (ViewGroup)localObject1, false);
    ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131378388);
    localImageView.setImageResource(2130845581);
    Object localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if (paramInt == 0)
      {
        paramString = ((SpringFestivalEntryManager)localObject2).a(paramString, "");
        if (paramString == null) {
          break label452;
        }
        localImageView.setImageBitmap(paramString);
      }
    }
    label452:
    for (;;)
    {
      paramInt = ((RelativeLayout)localObject1).getHeight();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
      if (i > 0) {
        paramInt = i;
      }
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "showSpringFestivalBanner,statusTitle.w = " + ((RelativeLayout)localObject1).getWidth() + ",statusTitle.h = " + ((RelativeLayout)localObject1).getHeight() + ",statusTitleHeightInNormalState = " + i + ",bgBmp = " + paramString);
      }
      ((RelativeLayout)localObject1).addView(localRelativeLayout, 0, new RelativeLayout.LayoutParams(((RelativeLayout)localObject1).getWidth(), paramInt));
      localRelativeLayout.requestLayout();
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.g();
      return;
      if (paramInt == 1)
      {
        paramString = ((SpringFestivalEntryManager)localObject2).b(paramString);
        boolean bool = FileUtils.a(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "showSpringFestivalBanner exist = " + bool + ",apngFilePath = " + paramString);
        }
        if (bool)
        {
          localObject2 = new VasApngFactory.Options();
          ((VasApngFactory.Options)localObject2).a(URLDrawableHelper.TRANSPARENT);
          localImageView.setImageDrawable(VasApngFactory.a("", (VasApngFactory.Options)localObject2, paramString));
        }
      }
      paramString = null;
    }
  }
  
  public void a(long paramLong, BaseActivityData paramBaseActivityData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData = paramBaseActivityData;
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = localSpringFestivalEntryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id);
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onActivityStart isMiniAppDesktopOpened = " + this.jdField_b_of_type_Boolean + ",userDataItem.hasClickCloseBtn = " + localUserDataItem.hasClickCloseBtn + ",userDataItem.pendantCloseType = " + localUserDataItem.pendantCloseType + ",isResume = " + this.jdField_d_of_type_Boolean + ",isLeftDrawerOpen = " + this.e + ",actData = " + paramBaseActivityData);
    }
    if ((this.jdField_b_of_type_Boolean) || (!this.jdField_d_of_type_Boolean) || (this.e)) {
      this.jdField_c_of_type_Boolean = true;
    }
    while (paramBaseActivityData.type != 2) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener.a();
    }
    if ((localUserDataItem.hasClickCloseBtn) && ((localUserDataItem.pendantCloseType == 2) || (localUserDataItem.pendantCloseType == 3)))
    {
      g(paramBaseActivityData);
      return;
    }
    long l = b();
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onActivityStart current = " + l + ",taskTime = " + paramLong + ",delay = " + paramBaseActivityData.getPeakDelayMs());
    }
    paramLong = paramBaseActivityData.getPeakDelayMs() + paramLong - l;
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onActivityStart showPrepareCountDown current = " + l + ",prepareCountDownMs = " + paramLong);
    }
    if (localSpringFestivalEntryManager.c())
    {
      int i = localSpringFestivalEntryManager.a();
      l = paramLong / i;
      paramLong = l;
      if (QLog.isColorLevel())
      {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onActivityStart showPrepareCountDown SpeedUp prepareCountDownMs = " + l + ", ratio = " + i);
        paramLong = l;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a((OnGrabActivityData)paramBaseActivityData, paramLong);
      return;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "reportBrushLotteryRequestResult result = " + paramLong + ",awardType = " + paramString);
    }
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData != null)
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.promotionId;
      localHashMap.put("active_id", str1);
      localHashMap.put("jackpot_id", str2);
      localHashMap.put("ext1", paramString);
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "reportBrushLotteryRequestResult activityID = " + str1 + "，promotionId = " + str2 + ",awardType = " + paramString);
      }
    }
    SpringHbReporter.a(ReportConstant.Event.p, 0, (int)paramLong, localHashMap, "response");
  }
  
  public void a(Conversation.UICallBack paramUICallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "setConversationUICallBack uiCallBack = " + paramUICallBack);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack = paramUICallBack;
  }
  
  public void a(HBEntryBannerData paramHBEntryBannerData)
  {
    boolean bool = StudyModeManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "setMiniAppDesktop2HBMode isStudyMode = " + bool + "," + paramHBEntryBannerData.b());
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onActivityAboutToOver isMiniAppDesktopOpened = " + this.jdField_b_of_type_Boolean + ",userDataItem.hasClickCloseBtn = " + localUserDataItem.hasClickCloseBtn + ",userDataItem.pendantCloseType = " + localUserDataItem.pendantCloseType + ",conversation.mHongBaoCtrlV2.mState = " + this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a + ",actData = " + paramBaseActivityData);
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = true;
    }
    do
    {
      do
      {
        return;
      } while (paramBaseActivityData.type != 2);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a == 3))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.f();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a == -1)
      {
        g(paramBaseActivityData);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a != 4);
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onActivityAboutToOver call onActivityRealStart");
    }
    b(System.currentTimeMillis(), paramBaseActivityData);
  }
  
  public void a(MsgTabBannerData paramMsgTabBannerData)
  {
    if (paramMsgTabBannerData == null) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 1, "onMsgTabBannerShow data=null return");
    }
    label221:
    boolean bool;
    do
    {
      do
      {
        UserData.UserDataItem localUserDataItem;
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onMsgTabBannerShow ,isMiniAppDesktopOpened = " + this.jdField_b_of_type_Boolean + ",isLeftDrawerOpen = " + this.e + ",isResume = " + this.jdField_d_of_type_Boolean + ",msgTabBannerData = " + paramMsgTabBannerData);
          }
          if ((this.jdField_b_of_type_Boolean) || (!this.jdField_d_of_type_Boolean) || (this.e))
          {
            this.jdField_c_of_type_Boolean = true;
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.type != 2)) {
            break label221;
          }
          localUserDataItem = ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id);
          if (localUserDataItem.leftCountDownDuration != 0L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onMsgTabBannerShow return for already played grab act");
        return;
        if ((!localUserDataItem.hasClickCloseBtn) || ((localUserDataItem.pendantCloseType != 2) && (localUserDataItem.pendantCloseType != 3))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onMsgTabBannerShow return for grab act has closed");
      return;
      bool = ThemeUtil.isDefaultOrDIYTheme(false);
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, String.format("onMsgTabBannerShow isDefaultTheme = %s, data = %s", new Object[] { Boolean.valueOf(bool), paramMsgTabBannerData.toSimpleString() }));
      }
    } while (!bool);
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener.c();
    }
    a(paramMsgTabBannerData.type, paramMsgTabBannerData.liuhaiBgUrl);
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
      if (!bool) {}
    }
    for (;;)
    {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 1, String.format("showPopBanner return... isMiniAppDesktopOpened=%b resume=%b talkback=%b isFirstLogin=%b", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(this.jdField_d_of_type_Boolean), Boolean.valueOf(AppSetting.jdField_d_of_type_Boolean), Boolean.valueOf(bool) }));
      this.jdField_c_of_type_Boolean = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, String.format("showPopBanner data = %s", new Object[] { paramPopBannerData }));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner = new SpringPopBanner(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner.a(paramPopBannerData);
      return;
      bool = false;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "setBrushHBActOngoing brushHBActOngoing = " + paramBoolean);
    }
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "isBrushHBActOngoing isBrushHBActOngoing = " + this.f);
    }
    return this.f;
  }
  
  public void b()
  {
    MiniAppPullInterface localMiniAppPullInterface = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "setMiniAppDestopChangeListener miniAppPullInterface = " + localMiniAppPullInterface);
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onActivityRealStart isMiniAppDesktopOpened = " + this.jdField_b_of_type_Boolean + ",userDataItem.hasClickCloseBtn = " + localUserDataItem.hasClickCloseBtn + ",userDataItem.pendantCloseType = " + localUserDataItem.pendantCloseType + ",isResume = " + this.jdField_d_of_type_Boolean + ",isLeftDrawerOpen = " + this.e + ",actData = " + paramBaseActivityData);
    }
    if ((this.jdField_b_of_type_Boolean) || (!this.jdField_d_of_type_Boolean) || (this.e)) {
      this.jdField_c_of_type_Boolean = true;
    }
    do
    {
      return;
      if (paramBaseActivityData.type == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener.a();
        }
        if ((localUserDataItem.hasClickCloseBtn) && ((localUserDataItem.pendantCloseType == 2) || (localUserDataItem.pendantCloseType == 3)))
        {
          g(paramBaseActivityData);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a((OnGrabActivityData)paramBaseActivityData);
        return;
      }
    } while ((paramBaseActivityData.type != 3) && (paramBaseActivityData.type != 1));
    g(paramBaseActivityData);
  }
  
  public void b(BaseActivityData paramBaseActivityData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onActivityOver isMiniAppDesktopOpened = " + this.jdField_b_of_type_Boolean + "actData = " + paramBaseActivityData);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener.d();
    }
    k();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener.b();
    }
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Long = -1L;
  }
  
  public void b(MsgTabBannerData paramMsgTabBannerData)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onMsgTabBannerHide data = ");
      if (paramMsgTabBannerData != null) {
        break label67;
      }
    }
    label67:
    for (paramMsgTabBannerData = "null";; paramMsgTabBannerData = paramMsgTabBannerData.toSimpleString())
    {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, paramMsgTabBannerData);
      e();
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener.d();
      }
      k();
      return;
    }
  }
  
  public void b(PopBannerData paramPopBannerData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onPopBannerHide data = " + paramPopBannerData);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner.a(false);
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
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = localSpringFestivalEntryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id);
    boolean bool1 = localSpringFestivalEntryManager.b();
    boolean bool2 = StudyModeManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onPendantShow  userDataItem.hasClickCloseBtn = " + localUserDataItem.hasClickCloseBtn + ",isMiniAppDesktopOpened = " + this.jdField_b_of_type_Boolean + ",isPendantShowSwitchOn = " + bool1 + ",isStudyMode = " + bool2 + ",isResume = " + this.jdField_d_of_type_Boolean + ",isLeftDrawerOpen = " + this.e + ",actData = " + paramBaseActivityData);
    }
    if (bool2) {}
    do
    {
      return;
      if ((this.jdField_b_of_type_Boolean) || (!this.jdField_d_of_type_Boolean) || (this.e))
      {
        this.jdField_c_of_type_Boolean = true;
        return;
      }
    } while ((localUserDataItem.hasClickCloseBtn) || (!bool1));
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a(paramBaseActivityData);
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner.a()))
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onResume isStudyMode = " + bool);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.type == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.type == 1)))
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
    QLog.d("2021_UI_SpringFestivalTaskCallback", 1, "onResume isNeedRefreshScheduleTask=" + this.jdField_c_of_type_Boolean);
    if (this.jdField_c_of_type_Boolean)
    {
      ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).c();
      this.jdField_c_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.j();
  }
  
  public void d(BaseActivityData paramBaseActivityData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onPendantHide actData = " + paramBaseActivityData);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.v();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "removeSpringFestivalBanner");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    if (!(localObject instanceof RelativeLayout))
    {
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "removeSpringFestivalBanner return, title = " + localObject);
      }
      return;
    }
    localObject = (RelativeLayout)localObject;
    View localView = ((RelativeLayout)localObject).findViewById(2131378387);
    if (localView != null) {
      ((RelativeLayout)localObject).removeView(localView);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.c();
  }
  
  public void e(BaseActivityData paramBaseActivityData)
  {
    boolean bool2 = false;
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    UserData.UserDataItem localUserDataItem = localSpringFestivalEntryManager.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id);
    boolean bool1 = StudyModeManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onBreathLightShow ,userDataItem.hasDisplayBreathLight = " + localUserDataItem.hasDisplayBreathLight + ",isMiniAppDesktopOpened = " + this.jdField_b_of_type_Boolean + ",userDataItem.hasClickCloseBtn = " + localUserDataItem.hasClickCloseBtn + ",isLeftDrawerOpen = " + this.e + ",isResume = " + this.jdField_d_of_type_Boolean + ",isStudyMode = " + bool1 + ",actData = " + paramBaseActivityData);
    }
    if (bool1) {}
    do
    {
      return;
      if ((this.jdField_b_of_type_Boolean) || (!this.jdField_d_of_type_Boolean) || (this.e))
      {
        this.jdField_c_of_type_Boolean = true;
        return;
      }
    } while ((localUserDataItem.hasClickCloseBtn) || (localUserDataItem.hasDisplayBreathLight));
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
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onDestroy");
    }
    l();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner.a(true);
    }
    a(false);
    b(false);
  }
  
  public void f(BaseActivityData paramBaseActivityData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onBreathLightHide actData = " + paramBaseActivityData);
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
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "notifyBrushEnd actData = " + paramBaseActivityData);
    }
    if (paramBaseActivityData == null)
    {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 1, "notifyBrushEnd return");
      return;
    }
    a(new HBEntryBannerData(paramBaseActivityData.getMiniEntryData(), paramBaseActivityData.getType(), paramBaseActivityData.getId()));
    a(false);
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback$BrushHBStateChangeListener.d();
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
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "reportBrushLotteryRequest activityID = " + str + "，promotionId = " + (String)localObject);
      }
    }
    SpringHbReporter.a(ReportConstant.Event.p, 0, 0, localHashMap, "request");
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "tryRecoverTianshuBanner");
    }
    BannerManager.a().b(23, 3003);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onReceive, " + paramInt + ", " + paramBoolean + ", " + paramBundle);
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    paramInt = paramBundle.getInt("k_id", -1);
    int i = paramBundle.getInt("key_award_id", -1);
    int j = paramBundle.getInt("key_award_type", -1);
    int k = paramBundle.getInt("k_money", -1);
    int m = paramBundle.getInt("key_promotion_id", -1);
    String str = paramBundle.getString("key_url");
    long l = paramBundle.getLong("key_report_ret_code");
    a(l, String.valueOf(j));
    this.jdField_b_of_type_Long = b();
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onReceive cmd = CMD_RESULT isSuccess = " + paramBoolean + ",awardType = " + j + ", lastGrabHongBaoResponseTime = " + this.jdField_b_of_type_Long + ", portId = " + paramInt + ", retCodeForReport = " + l + ", packUrl = " + str + ", showType = " + -1 + ", money = " + k + ", awardId = " + i + ", promotionId = " + m);
    }
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "isSuccess = " + paramBoolean + " isValidAwardType(awardType) = " + a(j));
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    if ((paramBoolean) && (a(j)))
    {
      paramBoolean = true;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().getResources().getString(2131698879);
      l = -1L;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData instanceof OnGrabActivityData))) {
        break label503;
      }
      str = ((OnGrabActivityData)this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData).noRPWording;
      l = ((SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData.id).leftCountDownDuration;
      l = ((OnGrabActivityData)this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData).playDuration * 1000 - l;
    }
    for (;;)
    {
      paramBundle.putLong("key_current_brush_progress_ms", l);
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a(paramBoolean, str, paramBundle);
      return;
      paramBoolean = false;
      break;
      label503:
      QLog.d("2021_UI_SpringFestivalTaskCallback", 1, "onReceive grabhongbao result exception , curActivityData = " + this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelBaseActivityData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback
 * JD-Core Version:    0.7.0.1
 */