package com.tencent.mobileqq.activity.home;

import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.activity.weather.webpage.WeatherPreloadHelperKt;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.identity.AccountLifeCycleClient;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class Conversation$UICallBack
  implements Handler.Callback
{
  public Conversation$UICallBack(Conversation paramConversation) {}
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    if (paramTextView1 != null)
    {
      Conversation.a(this.a).setTag(2131366402, new WeakReference(paramTextView1));
      paramTextView1.setText(Conversation.a(this.a).getText());
    }
    if (paramTextView2 != null)
    {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setTag(2131366402, new WeakReference(paramTextView2));
      int i = AIOUtils.a(10.0F, this.a.a());
      AIOUtils.a(paramTextView2, i, i, i, i);
      paramTextView2.setText(this.a.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramTextView1 = this.a.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      if (paramTextView1.length == 4)
      {
        paramTextView2.setCompoundDrawablePadding(this.a.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawablePadding());
        paramTextView2.setCompoundDrawables(paramTextView1[0], paramTextView1[1], paramTextView1[2], paramTextView1[3]);
      }
      paramTextView2.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
      paramTextView2.setOnClickListener(new Conversation.UICallBack.8(this));
      paramTextView2.setOnLongClickListener(new Conversation.UICallBack.9(this));
    }
  }
  
  private boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1134045: 
      Conversation.a(this.a, paramMessage);
      return true;
    case 1134047: 
      i();
      return true;
    case 1134048: 
      ThreadManager.getSubThreadHandler().post(new Conversation.UICallBack.1(this));
      return true;
    case 1134053: 
      b(paramMessage);
      return true;
    case 1134054: 
      return true;
    case 1053: 
      this.a.z();
      return true;
    case 1134030: 
      ((RegisterProxySvcPackHandler)((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime).getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).b();
      return true;
    case 1054: 
      e();
      return true;
    case 1055: 
      f();
      return true;
    case 1070: 
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1070);
      ((IRedTouchManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).conversationRemainReport();
      return true;
    case 1134061: 
      if (this.a.f)
      {
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134062, QZoneReport.a * 1000);
        return true;
      }
      break;
    case 1134062: 
      b();
      return true;
    case 1134068: 
      e(paramMessage);
      return true;
    case 1134064: 
      Conversation.a(this.a, 1);
      return true;
    case 1059: 
      VasShieldFont.a((TextView)this.a.a(2131380147));
      return true;
    case 1060: 
      this.a.a(2131380147).setVisibility(8);
      return true;
    case 1061: 
      ThreadManager.executeOnSubThread(new Conversation.UICallBack.2(this));
      return true;
    case 1067: 
      Conversation.a(this.a);
      return true;
    case 1071: 
      g();
      return true;
    case 1072: 
      Conversation.b(this.a);
      return true;
    case 1073: 
      WeatherPreloadHelperKt.a(1);
      return true;
    case 9003: 
      Conversation.a(this.a, (String)paramMessage.obj);
      return true;
    case 9004: 
      Conversation.b(this.a, (String)paramMessage.obj);
      return true;
    }
    return true;
  }
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.UICallBack.3(this));
  }
  
  private void b(Message paramMessage)
  {
    try
    {
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.a.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
      if (CmGameUtil.a(null)) {
        localIApolloManagerService.setNeedShowWorldCup(true);
      }
      if ((!((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime).isConversationTabShow) || (CmGameUtil.a(null)))
      {
        if (localIApolloManagerService != null) {
          localIApolloManagerService.setNeedShowWorldCup(true);
        }
        return;
      }
      if (FrameHelperActivity.b())
      {
        FrameHelperActivity.c(true);
        FrameHelperActivity.w();
      }
      CmGameUtil.a(this.a.jdField_b_of_type_AndroidWidgetRelativeLayout, (String)paramMessage.obj);
      this.a.d = true;
      return;
    }
    catch (Exception paramMessage) {}
  }
  
  private boolean b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1025: 
      Conversation.c(this.a);
      return true;
    case 1009: 
      QLog.i("Q.recent", 2, "refresh recent list, from_handle");
      this.a.a(0L);
      return true;
    case 10001: 
    case 10002: 
    case 10003: 
      this.a.a(paramMessage, true);
      return true;
    case 1134020: 
      Conversation.b(this.a, paramMessage);
      return true;
    case 1134015: 
      QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_CLOSE_NOT_LOADING");
      this.a.a(paramMessage, false);
      return true;
    case 1134012: 
      QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_CLOSE");
      this.a.a(paramMessage, true);
      return true;
    case 1134013: 
      QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_OPEN");
      this.a.a(paramMessage, true);
      return true;
    case 1134014: 
      this.a.a(null, true);
      return true;
    case 1014: 
    case 1017: 
      this.a.a(0L);
      return true;
    case 1016: 
      c();
      return true;
    case 1020: 
      Conversation.d(this.a);
      return true;
    case 10000: 
      c(paramMessage);
      return true;
    case 1019: 
      paramMessage = (List)paramMessage.obj;
      Conversation.a(this.a, 1, paramMessage);
      return true;
    case 1024: 
      if (this.a.jdField_a_of_type_MqqAppAppRuntime != null)
      {
        ((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime).refreshMsgTabUnreadNum(true, 0);
        return true;
      }
      break;
    case 1030: 
      Conversation.e(this.a);
      return true;
    case 1044: 
      d();
      return true;
    case 1048: 
      d(paramMessage);
      return true;
    }
    return true;
  }
  
  private void c()
  {
    this.a.g = false;
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).springBackOverScrollHeaderView();
    }
    if (this.a.c > 0L) {
      StartupTracker.a("Conversation_PullToRefresh_finish", SystemClock.uptimeMillis() - this.a.c);
    }
    this.a.c = 0L;
  }
  
  private void c(Message paramMessage)
  {
    long l = Math.abs(System.currentTimeMillis() - this.a.e);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "MSG_REFRESH_UI, [" + paramMessage.arg1 + "," + l + "]");
    }
    if (l < 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "distance < 0[" + l + "," + this.a.e + "]");
      }
      l = this.a.jdField_a_of_type_Long + 1L;
    }
    for (;;)
    {
      List localList = (List)paramMessage.obj;
      if ((paramMessage.arg2 != 1) && (l < this.a.jdField_a_of_type_Long))
      {
        this.a.jdField_a_of_type_JavaUtilList = localList;
        paramMessage = Message.obtain();
        paramMessage.what = 10000;
        paramMessage.obj = this.a.jdField_a_of_type_JavaUtilList;
        paramMessage.arg1 = 0;
        paramMessage.arg2 = 1;
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, this.a.jdField_a_of_type_Long - l + 50L);
      }
      for (;;)
      {
        return;
        int i;
        if (paramMessage.arg2 == 1) {
          if (localList == this.a.jdField_a_of_type_JavaUtilList) {
            i = 1;
          }
        }
        while (i != 0)
        {
          Conversation.a(this.a, 0, this.a.jdField_a_of_type_JavaUtilList);
          this.a.e = System.currentTimeMillis();
          return;
          i = 0;
          continue;
          this.a.jdField_a_of_type_JavaUtilList = localList;
          i = 1;
        }
      }
    }
  }
  
  private boolean c(Message paramMessage)
  {
    if ((paramMessage.what != 1134022) && (!this.a.jdField_a_of_type_MqqAppAppRuntime.isLogin())) {
      return true;
    }
    return d(paramMessage);
  }
  
  private void d()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a();
    }
  }
  
  private void d(Message paramMessage)
  {
    int i = 1;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) {
      return;
    }
    if (paramMessage.arg1 == 1) {}
    while (i != 0)
    {
      paramMessage = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramMessage.red_type.set(0);
      this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(paramMessage);
      return;
      i = 0;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(new BusinessInfoCheckUpdate.AppInfo());
  }
  
  private boolean d(Message paramMessage)
  {
    int i = 2;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1080: 
      a();
      return true;
    case 1081: 
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a()) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.b())))
      {
        QLog.d("Q.recent", 1, "MSG_QBOSS_AD_BANNER_SHOW_WITH_OBJ return, isBrushHBActOngoing = " + this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a() + ",isShowingSFMsgTabBanner = " + this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.b());
        return true;
      }
      a(paramMessage);
      return true;
    case 1077: 
      AccountLifeCycleClient.a().a();
      return true;
    case 1134019: 
      f(paramMessage);
      return true;
    case 1134057: 
      h();
      return true;
    case 1134065: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(13, paramMessage.arg1, paramMessage);
      return true;
    case 1134039: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134040)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134040);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(33, 2, paramMessage);
      return true;
    case 1134040: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(33, 0, paramMessage);
      return true;
    case 1134041: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134042)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134042);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(34, 2, paramMessage);
      return true;
    case 1134042: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(34, 0, null);
      return true;
    case 1134049: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134050)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134050);
      }
      paramMessage = Message.obtain(paramMessage);
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(36, paramMessage);
      return true;
    case 1134050: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(36, 0, paramMessage);
      return true;
    case 1134071: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134072)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134072);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(35, 2, paramMessage);
      return true;
    case 1134072: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(35, 0, paramMessage);
      return true;
    case 1134021: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(10, 2, paramMessage);
      return true;
    case 1134022: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(10, 0, paramMessage);
      return true;
    case 1134066: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134066)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134066);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(45, 2, paramMessage);
      return true;
    case 1134067: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134067)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134067);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(45, 0, paramMessage);
      return true;
    case 1134026: 
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
      if (FileViewMusicService.a().a()) {}
      for (;;)
      {
        ((BannerManager)localObject).a(44, i, paramMessage);
        return true;
        i = 0;
      }
    case 1035: 
      this.a.y();
      return true;
    case 1134200: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null)
      {
        paramMessage = Message.obtain(paramMessage);
        this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(40, paramMessage);
        return true;
      }
      break;
    case 1134201: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "MSG_HIDE_GENERAL_BANNER with: " + paramMessage);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null)
      {
        paramMessage = Message.obtain(paramMessage);
        this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(40, paramMessage);
        return true;
      }
      break;
    case 1069: 
      if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(false)))
      {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1069);
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1068);
        return true;
      }
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1068)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1068);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(false);
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(-1, null);
      return true;
    case 1068: 
      if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(false)))
      {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1069);
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1068);
        return true;
      }
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1069)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1069);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(-1, null);
      return true;
    case 1134063: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "handler msg MSG_WIFISECURITY_BAR, msg.obj: " + paramMessage.obj);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(4, 2, paramMessage);
      return true;
    case 1074: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "[status][banner] handleMessage MSG_HIDE_BANNER_AUTO_STATUS");
      }
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1074)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1074);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(30, 0, paramMessage);
      return true;
    case 1075: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "[status][banner] handleMessage MSG_SHOW_BANNER_AUTO_STATUS");
      }
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1074)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1074);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(30, 2, paramMessage);
      return true;
    case 1134210: 
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
      if (!Conversation.a(this.a).a((List)localObject))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(46, 2, paramMessage);
        return true;
      }
      break;
    }
    return true;
  }
  
  private void e()
  {
    ImageView localImageView = this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a;
    boolean bool = ((MedalWallMng)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a((BaseActivity)this.a.a(), localImageView, 1, null);
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "MSG_CHECK_MEDAL_GUIDE ret: %s", new Object[] { Boolean.valueOf(bool) }));
    }
  }
  
  private void e(Message paramMessage)
  {
    if (((paramMessage.obj instanceof String[])) && (!this.a.h))
    {
      Object localObject = (String[])paramMessage.obj;
      if (localObject.length == 3)
      {
        paramMessage = localObject[0];
        String str = localObject[1];
        localObject = localObject[2];
        new Conversation.ShowRealNameDialog(this.a, paramMessage, str, (String)localObject).a();
      }
    }
  }
  
  private void f()
  {
    SLog.b("Q.recent", "handle MSG_INIT_MSGTAG_STORY");
    if (this.a.jdField_a_of_type_MqqAppAppRuntime != null) {
      QQStoryManager localQQStoryManager = (QQStoryManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QQSTORY_MANAGER);
    }
    ThreadManager.post(new Conversation.UICallBack.4(this), 8, null, true);
  }
  
  /* Error */
  private void f(Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   4: invokestatic 630	com/tencent/mobileqq/activity/home/Conversation:a	(Lcom/tencent/mobileqq/activity/home/Conversation;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   7: ifnull +22 -> 29
    //   10: aload_0
    //   11: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   14: invokestatic 630	com/tencent/mobileqq/activity/home/Conversation:a	(Lcom/tencent/mobileqq/activity/home/Conversation;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   17: invokevirtual 635	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   20: aload_0
    //   21: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   24: aconst_null
    //   25: invokestatic 638	com/tencent/mobileqq/activity/home/Conversation:a	(Lcom/tencent/mobileqq/activity/home/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   28: pop
    //   29: aload_0
    //   30: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   33: getfield 487	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqBannerBannerManager	Lcom/tencent/mobileqq/banner/BannerManager;
    //   36: bipush 17
    //   38: iconst_0
    //   39: aload_1
    //   40: invokevirtual 492	com/tencent/mobileqq/banner/BannerManager:a	(IILandroid/os/Message;)V
    //   43: return
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   49: aconst_null
    //   50: invokestatic 638	com/tencent/mobileqq/activity/home/Conversation:a	(Lcom/tencent/mobileqq/activity/home/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   53: pop
    //   54: goto -25 -> 29
    //   57: astore_1
    //   58: aload_0
    //   59: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   62: aconst_null
    //   63: invokestatic 638	com/tencent/mobileqq/activity/home/Conversation:a	(Lcom/tencent/mobileqq/activity/home/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   66: pop
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	UICallBack
    //   0	69	1	paramMessage	Message
    //   44	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   10	20	44	java/lang/Exception
    //   10	20	57	finally
  }
  
  private void g()
  {
    if (MiniAppConfProcessor.c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "MSG_SCROLL_TOP_AND_REFRESH");
      }
      Conversation.a(this.a, true);
      Conversation.a(this.a, SystemClock.elapsedRealtime());
      Conversation.a(this.a).setSelection(0);
      Conversation.f(this.a);
    }
  }
  
  private void h()
  {
    ThreadManager.post(new Conversation.UICallBack.5(this), 8, null, true);
  }
  
  private void i()
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.UICallBack.6(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "handleQBossADBannerClose");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl.b();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl = null;
    }
    View localView = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374341);
    if (localView != null)
    {
      localView.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "handleQBossADBannerClose,statusTitle.h = " + this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
    }
  }
  
  public void a(Message paramMessage)
  {
    if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof View[]))) {}
    Object localObject1;
    TextView localTextView1;
    TextView localTextView2;
    do
    {
      do
      {
        return;
        if (Conversation.a(this.a) < 0) {
          Conversation.a(this.a, this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "handleQBossADBannerShowWithObj,statusTitle.h = " + this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() + "，statusTitleHeightInNormalState = " + Conversation.a(this.a));
        }
        localObject1 = (View[])paramMessage.obj;
      } while (localObject1.length != 4);
      paramMessage = localObject1[0];
      localTextView1 = (TextView)localObject1[1];
      localTextView2 = (TextView)localObject1[2];
      localObject1 = localObject1[3];
    } while ((paramMessage == null) || (paramMessage.getParent() != null));
    Object localObject2 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374341);
    if (localObject2 != null) {
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject2);
    }
    if ((Conversation.a(this.a) != null) && (Conversation.a(this.a).hasOpenDesktop())) {
      paramMessage.setVisibility(8);
    }
    localObject2 = new ConversationQbossBannerTitleEntranceCtrl(this.a);
    ((ConversationQbossBannerTitleEntranceCtrl)localObject2).a(paramMessage);
    ((ConversationQbossBannerTitleEntranceCtrl)localObject2).a(false);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl = ((ConversationQbossBannerTitleEntranceCtrl)localObject2);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramMessage);
    paramMessage.requestLayout();
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener(new Conversation.UICallBack.7(this));
    }
    a(localTextView1, localTextView2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (c(paramMessage)) {}
    while (b(paramMessage)) {
      return true;
    }
    return a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack
 * JD-Core Version:    0.7.0.1
 */