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
import com.tencent.mobileqq.activity.recent.bannerprocessor.BeginnerGuideBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BrowserBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ComicBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.DonDisturbBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.GameBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.GeneralBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MsgBackupBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.WifiPhotoBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.WifiSecurityCheckBannerProcessor;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.identity.IAccountApi;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.onlinestatus.constants.CommonConstants;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
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
      Conversation.a(this.a).setTag(2131366283, new WeakReference(paramTextView1));
      paramTextView1.setText(Conversation.a(this.a).getText());
    }
    if (paramTextView2 != null)
    {
      this.a.b.setTag(2131366283, new WeakReference(paramTextView2));
      int i = AIOUtils.b(10.0F, this.a.a());
      AIOUtils.a(paramTextView2, i, i, i, i);
      paramTextView2.setText(this.a.b.getText());
      paramTextView1 = this.a.b.getCompoundDrawables();
      if (paramTextView1.length == 4)
      {
        paramTextView2.setCompoundDrawablePadding(this.a.b.getCompoundDrawablePadding());
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
    case 1134068: 
      d(paramMessage);
      return true;
    case 1134064: 
      Conversation.a(this.a, 1);
      return true;
    case 1134062: 
      b();
      return true;
    case 1134061: 
      if (this.a.jdField_e_of_type_Boolean)
      {
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134062, QZoneReport.a * 1000);
        return true;
      }
      break;
    case 1134048: 
      ThreadManager.getSubThreadHandler().post(new Conversation.UICallBack.1(this));
      return true;
    case 1134047: 
      i();
      return true;
    case 1134045: 
      Conversation.a(this.a, paramMessage);
      return true;
    case 1134030: 
      ((RegisterProxySvcPackHandler)((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime).getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).b();
      return true;
    case 9004: 
      Conversation.b(this.a, (String)paramMessage.obj);
      return true;
    case 9003: 
      Conversation.a(this.a, (String)paramMessage.obj);
      return true;
    case 1073: 
      ((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).preloadWebProcessAsync(1);
      return true;
    case 1072: 
      Conversation.b(this.a);
      return true;
    case 1071: 
      g();
      return true;
    case 1070: 
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1070);
      ((IRedTouchManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).conversationRemainReport();
      return true;
    case 1067: 
      Conversation.a(this.a);
      return true;
    case 1061: 
      ThreadManager.executeOnSubThread(new Conversation.UICallBack.2(this));
      return true;
    case 1060: 
      this.a.a(2131379475).setVisibility(8);
      return true;
    case 1059: 
      VasShieldFont.a((TextView)this.a.a(2131379475));
      return true;
    case 1055: 
      f();
      return true;
    case 1054: 
      e();
      return true;
    case 1053: 
      this.a.y();
    }
    return true;
  }
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.UICallBack.3(this));
  }
  
  private void b(Message paramMessage)
  {
    long l2 = Math.abs(System.currentTimeMillis() - this.a.jdField_e_of_type_Long);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MSG_REFRESH_UI, [");
      ((StringBuilder)localObject).append(paramMessage.arg1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("]");
      QLog.i("Q.recent", 4, ((StringBuilder)localObject).toString());
    }
    long l1 = l2;
    if (l2 < 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("distance < 0[");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.a.jdField_e_of_type_Long);
        ((StringBuilder)localObject).append("]");
        QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
      }
      l1 = this.a.jdField_a_of_type_Long + 1L;
    }
    Object localObject = (List)paramMessage.obj;
    int j = paramMessage.arg2;
    int i = 1;
    if ((j != 1) && (l1 < this.a.jdField_a_of_type_Long))
    {
      this.a.jdField_a_of_type_JavaUtilList = ((List)localObject);
      paramMessage = Message.obtain();
      paramMessage.what = 10000;
      paramMessage.obj = this.a.jdField_a_of_type_JavaUtilList;
      paramMessage.arg1 = 0;
      paramMessage.arg2 = 1;
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, this.a.jdField_a_of_type_Long - l1 + 50L);
      return;
    }
    if (paramMessage.arg2 == 1)
    {
      if (localObject != this.a.jdField_a_of_type_JavaUtilList) {
        i = 0;
      }
    }
    else {
      this.a.jdField_a_of_type_JavaUtilList = ((List)localObject);
    }
    if (i != 0)
    {
      paramMessage = this.a;
      Conversation.a(paramMessage, 0, paramMessage.jdField_a_of_type_JavaUtilList);
      this.a.jdField_e_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private boolean b(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1009)
    {
      if (i != 1014) {
        if (i != 1030)
        {
          if (i != 1044)
          {
            if (i != 1048)
            {
              if (i != 1134020)
              {
                if (i != 1016)
                {
                  if (i != 1017)
                  {
                    if (i != 1019)
                    {
                      if (i != 1020)
                      {
                        if (i != 1024)
                        {
                          if (i != 1025) {
                            switch (i)
                            {
                            default: 
                              switch (i)
                              {
                              default: 
                                return false;
                              case 1134015: 
                                QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_CLOSE_NOT_LOADING");
                                this.a.a(paramMessage, false);
                                break;
                              case 1134014: 
                                this.a.a(null, true);
                                break;
                              case 1134013: 
                                QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_OPEN");
                                this.a.a(paramMessage, true);
                                break;
                              case 1134012: 
                                QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_CLOSE");
                                this.a.a(paramMessage, true);
                              }
                              break;
                            case 10001: 
                            case 10002: 
                            case 10003: 
                              this.a.a(paramMessage, true);
                              break;
                            case 10000: 
                              b(paramMessage);
                              break;
                            }
                          }
                          Conversation.c(this.a);
                          break label392;
                        }
                        if (this.a.jdField_a_of_type_MqqAppAppRuntime == null) {
                          break label392;
                        }
                        ((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime).refreshMsgTabUnreadNum(true, 0);
                        break label392;
                      }
                      Conversation.d(this.a);
                      break label392;
                    }
                    paramMessage = (List)paramMessage.obj;
                    Conversation.a(this.a, 1, paramMessage);
                    break label392;
                  }
                }
                else
                {
                  c();
                  break label392;
                }
              }
              else
              {
                Conversation.b(this.a, paramMessage);
                break label392;
              }
            }
            else
            {
              c(paramMessage);
              break label392;
            }
          }
          else
          {
            d();
            break label392;
          }
        }
        else
        {
          Conversation.e(this.a);
          break label392;
        }
      }
      this.a.a(0L);
    }
    else
    {
      QLog.i("Q.recent", 2, "refresh recent list, from_handle");
      this.a.a(0L);
    }
    label392:
    return true;
  }
  
  private void c()
  {
    Conversation localConversation = this.a;
    localConversation.f = false;
    if (Conversation.a(localConversation) != null) {
      Conversation.a(this.a).springBackOverScrollHeaderView();
    }
    if (this.a.c > 0L) {
      StartupTracker.a("Conversation_PullToRefresh_finish", SystemClock.uptimeMillis() - this.a.c);
    }
    this.a.c = 0L;
  }
  
  private void c(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) {
      return;
    }
    int j = paramMessage.arg1;
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0)
    {
      paramMessage = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramMessage.red_type.set(0);
      this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(paramMessage);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(new BusinessInfoCheckUpdate.AppInfo());
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
    if (((paramMessage.obj instanceof String[])) && (!this.a.g))
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
  
  private boolean d(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1134210: 
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
      if (!Conversation.a(this.a).a((List)localObject))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(BeginnerGuideBannerProcessor.a, 2, paramMessage);
        return true;
      }
      break;
    case 1134201: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MSG_HIDE_GENERAL_BANNER with: ");
        ((StringBuilder)localObject).append(paramMessage);
        QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null)
      {
        paramMessage = Message.obtain(paramMessage);
        this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(GeneralBannerProcessor.a, paramMessage);
        return true;
      }
      break;
    case 1134200: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null)
      {
        paramMessage = Message.obtain(paramMessage);
        this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(GeneralBannerProcessor.a, paramMessage);
        return true;
      }
      break;
    case 1134067: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134067)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134067);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(MsgBackupBannerProcessor.a, 0, paramMessage);
      return true;
    case 1134066: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134066)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134066);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(MsgBackupBannerProcessor.a, 2, paramMessage);
      return true;
    case 1134065: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(DonDisturbBannerProcessor.a, paramMessage.arg1, paramMessage);
      return true;
    case 1134063: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handler msg MSG_WIFISECURITY_BAR, msg.obj: ");
        ((StringBuilder)localObject).append(paramMessage.obj);
        QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(WifiSecurityCheckBannerProcessor.a, 2, paramMessage);
      return true;
    case 1134057: 
      h();
      return true;
    case 1134050: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(GameBannerProcessor.a, 0, paramMessage);
      return true;
    case 1134049: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134050)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134050);
      }
      paramMessage = Message.obtain(paramMessage);
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(GameBannerProcessor.a, paramMessage);
      return true;
    case 1134042: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(BrowserBannerProcessor.a, 0, null);
      return true;
    case 1134041: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134042)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134042);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(BrowserBannerProcessor.a, 2, paramMessage);
      return true;
    case 1134040: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(ComicBannerProcessor.a, 0, paramMessage);
      return true;
    case 1134039: 
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1134040)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134040);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(ComicBannerProcessor.a, 2, paramMessage);
      return true;
    case 1134022: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(WifiPhotoBannerProcessor.a, 0, paramMessage);
      return true;
    case 1134021: 
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(WifiPhotoBannerProcessor.a, 2, paramMessage);
      return true;
    case 1134019: 
      e(paramMessage);
      return true;
    case 1081: 
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a()) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.b())))
      {
        paramMessage = new StringBuilder();
        paramMessage.append("MSG_QBOSS_AD_BANNER_SHOW_WITH_OBJ return, isBrushHBActOngoing = ");
        paramMessage.append(this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a());
        paramMessage.append(",isShowingSFMsgTabBanner = ");
        paramMessage.append(this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.b());
        QLog.d("Q.recent", 1, paramMessage.toString());
        return true;
      }
      a(paramMessage);
      return true;
    case 1080: 
      a();
      return true;
    case 1077: 
      ((IAccountApi)QRoute.api(IAccountApi.class)).onAccountLoginOrSwitch();
      return true;
    case 1075: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "[status][banner] handleMessage MSG_SHOW_BANNER_AUTO_STATUS");
      }
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1074)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1074);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(CommonConstants.a, 2, paramMessage);
      return true;
    case 1074: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "[status][banner] handleMessage MSG_HIDE_BANNER_AUTO_STATUS");
      }
      if (this.a.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1074)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1074);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(CommonConstants.a, 0, paramMessage);
      return true;
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
    case 1035: 
      this.a.x();
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
  
  /* Error */
  private void e(Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   4: invokestatic 611	com/tencent/mobileqq/activity/home/Conversation:a	(Lcom/tencent/mobileqq/activity/home/Conversation;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   7: ifnull +37 -> 44
    //   10: aload_0
    //   11: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   14: invokestatic 611	com/tencent/mobileqq/activity/home/Conversation:a	(Lcom/tencent/mobileqq/activity/home/Conversation;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   17: invokevirtual 616	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   20: goto +15 -> 35
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   28: aconst_null
    //   29: invokestatic 619	com/tencent/mobileqq/activity/home/Conversation:a	(Lcom/tencent/mobileqq/activity/home/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   32: pop
    //   33: aload_1
    //   34: athrow
    //   35: aload_0
    //   36: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   39: aconst_null
    //   40: invokestatic 619	com/tencent/mobileqq/activity/home/Conversation:a	(Lcom/tencent/mobileqq/activity/home/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   43: pop
    //   44: aload_0
    //   45: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   48: getfield 450	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqBannerBannerManager	Lcom/tencent/mobileqq/banner/BannerManager;
    //   51: getstatic 622	com/tencent/mobileqq/activity/recent/bannerprocessor/InstallUpgradeBannerProcessor:a	I
    //   54: iconst_0
    //   55: aload_1
    //   56: invokevirtual 458	com/tencent/mobileqq/banner/BannerManager:a	(IILandroid/os/Message;)V
    //   59: return
    //   60: astore_2
    //   61: goto -26 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	UICallBack
    //   0	64	1	paramMessage	Message
    //   60	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   10	20	23	finally
    //   10	20	60	java/lang/Exception
  }
  
  private void f()
  {
    SLog.b("Q.recent", "handle MSG_INIT_MSGTAG_STORY");
    if (this.a.jdField_a_of_type_MqqAppAppRuntime != null) {
      QQStoryManager localQQStoryManager = (QQStoryManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QQSTORY_MANAGER);
    }
    ThreadManager.post(new Conversation.UICallBack.4(this), 8, null, true);
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
      QLog.d("Q.recent", 2, "handleVasADBannerClose");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl.b();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl = null;
    }
    Object localObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380381);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleVasADBannerClose,statusTitle.h = ");
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(Message paramMessage)
  {
    if (paramMessage.obj != null)
    {
      if (!(paramMessage.obj instanceof View[])) {
        return;
      }
      Object localObject1;
      if (Conversation.a(this.a) < 0)
      {
        localObject1 = this.a;
        Conversation.a((Conversation)localObject1, ((Conversation)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleVasADBannerShowWithObj,statusTitle.h = ");
        ((StringBuilder)localObject1).append(this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
        ((StringBuilder)localObject1).append("，statusTitleHeightInNormalState = ");
        ((StringBuilder)localObject1).append(Conversation.a(this.a));
        QLog.d("Q.recent", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = (View[])paramMessage.obj;
      if (localObject2.length == 4)
      {
        paramMessage = localObject2[0];
        localObject1 = (TextView)localObject2[1];
        TextView localTextView = (TextView)localObject2[2];
        localObject2 = localObject2[3];
        if ((paramMessage != null) && (paramMessage.getParent() == null))
        {
          Object localObject3 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380381);
          if (localObject3 != null) {
            this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject3);
          }
          if ((Conversation.a(this.a) != null) && (Conversation.a(this.a).hasOpenDesktop())) {
            paramMessage.setVisibility(8);
          }
          localObject3 = new ConversationQbossBannerTitleEntranceCtrl(this.a);
          ((ConversationQbossBannerTitleEntranceCtrl)localObject3).a(paramMessage);
          ((ConversationQbossBannerTitleEntranceCtrl)localObject3).a(false);
          Conversation localConversation = this.a;
          localConversation.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl = ((ConversationQbossBannerTitleEntranceCtrl)localObject3);
          localConversation.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramMessage);
          paramMessage.requestLayout();
          if (localObject2 != null) {
            ((View)localObject2).setOnClickListener(new Conversation.UICallBack.7(this));
          }
          a((TextView)localObject1, localTextView);
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (c(paramMessage)) {
      return true;
    }
    if (b(paramMessage)) {
      return true;
    }
    return a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack
 * JD-Core Version:    0.7.0.1
 */