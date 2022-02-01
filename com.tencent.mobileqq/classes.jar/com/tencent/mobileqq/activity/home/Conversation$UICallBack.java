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
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
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
      Conversation.b(this.a).setTag(2131432585, new WeakReference(paramTextView1));
      paramTextView1.setText(Conversation.b(this.a).getText());
    }
    if (paramTextView2 != null)
    {
      this.a.W.setTag(2131432585, new WeakReference(paramTextView2));
      int i = AIOUtils.b(10.0F, this.a.Q());
      AIOUtils.a(paramTextView2, i, i, i, i);
      paramTextView2.setText(this.a.W.getText());
      paramTextView1 = this.a.W.getCompoundDrawables();
      if (paramTextView1.length == 4)
      {
        paramTextView2.setCompoundDrawablePadding(this.a.W.getCompoundDrawablePadding());
        paramTextView2.setCompoundDrawables(paramTextView1[0], paramTextView1[1], paramTextView1[2], paramTextView1[3]);
      }
      paramTextView2.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
      paramTextView2.setOnClickListener(new Conversation.UICallBack.8(this));
      paramTextView2.setOnLongClickListener(new Conversation.UICallBack.9(this));
    }
  }
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.UICallBack.3(this));
  }
  
  private boolean b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1134068: 
      h(paramMessage);
      return true;
    case 1134064: 
      Conversation.a(this.a, 1);
      return true;
    case 1134062: 
      b();
      return true;
    case 1134061: 
      if (this.a.C)
      {
        this.a.A.sendEmptyMessageDelayed(1134062, QZoneReport.a * 1000);
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
      ((RegisterProxySvcPackHandler)((QQAppInterface)this.a.aF).getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).b();
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
      Conversation.d(this.a);
      return true;
    case 1071: 
      g();
      return true;
    case 1070: 
      this.a.A.removeMessages(1070);
      ((IRedTouchManager)this.a.aF.getRuntimeService(IRedTouchManager.class, "")).conversationRemainReport();
      return true;
    case 1067: 
      Conversation.c(this.a);
      return true;
    case 1061: 
      ThreadManager.executeOnSubThread(new Conversation.UICallBack.2(this));
      return true;
    case 1060: 
      this.a.d(2131448218).setVisibility(8);
      return true;
    case 1059: 
      VasShieldFont.a((TextView)this.a.d(2131448218));
      return true;
    case 1055: 
      f();
      return true;
    case 1054: 
      e();
      return true;
    case 1053: 
      this.a.L();
    }
    return true;
  }
  
  private void c()
  {
    Conversation localConversation = this.a;
    localConversation.D = false;
    if (Conversation.i(localConversation) != null) {
      Conversation.i(this.a).springBackOverScrollHeaderView();
    }
    if (this.a.E > 0L) {
      StartupTracker.a("Conversation_PullToRefresh_finish", SystemClock.uptimeMillis() - this.a.E);
    }
    this.a.E = 0L;
  }
  
  private boolean c(Message paramMessage)
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
                              f(paramMessage);
                              break;
                            }
                          }
                          Conversation.e(this.a);
                          break label392;
                        }
                        if (this.a.aF == null) {
                          break label392;
                        }
                        ((QQAppInterface)this.a.aF).refreshMsgTabUnreadNum(true, 0);
                        break label392;
                      }
                      Conversation.f(this.a);
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
              g(paramMessage);
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
          Conversation.g(this.a);
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
  
  private void d()
  {
    if (this.a.t != null) {
      this.a.t.c();
    }
  }
  
  private boolean d(Message paramMessage)
  {
    if ((paramMessage.what != 1134022) && (!this.a.aF.isLogin())) {
      return true;
    }
    return e(paramMessage);
  }
  
  private void e()
  {
    ImageView localImageView = this.a.Y.ab;
    boolean bool = ((MedalWallMng)this.a.aF.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a((BaseActivity)this.a.P(), localImageView, 1, null);
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "MSG_CHECK_MEDAL_GUIDE ret: %s", new Object[] { Boolean.valueOf(bool) }));
    }
  }
  
  private boolean e(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1134210: 
      localObject = this.a.t.j();
      if (!Conversation.h(this.a).a((List)localObject))
      {
        this.a.y.a(BeginnerGuideBannerProcessor.a, 2, paramMessage);
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
      if (this.a.y != null)
      {
        paramMessage = Message.obtain(paramMessage);
        this.a.y.b(GeneralBannerProcessor.a, paramMessage);
        return true;
      }
      break;
    case 1134200: 
      if (this.a.y != null)
      {
        paramMessage = Message.obtain(paramMessage);
        this.a.y.b(GeneralBannerProcessor.a, paramMessage);
        return true;
      }
      break;
    case 1134067: 
      if (this.a.A.hasMessages(1134067)) {
        this.a.A.removeMessages(1134067);
      }
      this.a.y.a(MsgBackupBannerProcessor.a, 0, paramMessage);
      return true;
    case 1134066: 
      if (this.a.A.hasMessages(1134066)) {
        this.a.A.removeMessages(1134066);
      }
      this.a.y.a(MsgBackupBannerProcessor.a, 2, paramMessage);
      return true;
    case 1134065: 
      this.a.y.a(DonDisturbBannerProcessor.a, paramMessage.arg1, paramMessage);
      return true;
    case 1134063: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handler msg MSG_WIFISECURITY_BAR, msg.obj: ");
        ((StringBuilder)localObject).append(paramMessage.obj);
        QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
      }
      this.a.y.a(WifiSecurityCheckBannerProcessor.a, 2, paramMessage);
      return true;
    case 1134057: 
      h();
      return true;
    case 1134050: 
      this.a.y.a(GameBannerProcessor.a, 0, paramMessage);
      return true;
    case 1134049: 
      if (this.a.A.hasMessages(1134050)) {
        this.a.A.removeMessages(1134050);
      }
      paramMessage = Message.obtain(paramMessage);
      this.a.y.b(GameBannerProcessor.a, paramMessage);
      return true;
    case 1134042: 
      this.a.y.a(BrowserBannerProcessor.a, 0, null);
      return true;
    case 1134041: 
      if (this.a.A.hasMessages(1134042)) {
        this.a.A.removeMessages(1134042);
      }
      this.a.y.a(BrowserBannerProcessor.a, 2, paramMessage);
      return true;
    case 1134040: 
      this.a.y.a(ComicBannerProcessor.a, 0, paramMessage);
      return true;
    case 1134039: 
      if (this.a.A.hasMessages(1134040)) {
        this.a.A.removeMessages(1134040);
      }
      this.a.y.a(ComicBannerProcessor.a, 2, paramMessage);
      return true;
    case 1134022: 
      this.a.y.a(WifiPhotoBannerProcessor.a, 0, paramMessage);
      return true;
    case 1134021: 
      this.a.y.a(WifiPhotoBannerProcessor.a, 2, paramMessage);
      return true;
    case 1134019: 
      i(paramMessage);
      return true;
    case 1081: 
      if ((this.a.ab != null) && ((this.a.ab.a()) || (this.a.ab.b())))
      {
        paramMessage = new StringBuilder();
        paramMessage.append("MSG_QBOSS_AD_BANNER_SHOW_WITH_OBJ return, isBrushHBActOngoing = ");
        paramMessage.append(this.a.ab.a());
        paramMessage.append(",isShowingSFMsgTabBanner = ");
        paramMessage.append(this.a.ab.b());
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
      if (this.a.A.hasMessages(1074)) {
        this.a.A.removeMessages(1074);
      }
      this.a.y.a(CommonConstants.a, 2, paramMessage);
      return true;
    case 1074: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "[status][banner] handleMessage MSG_HIDE_BANNER_AUTO_STATUS");
      }
      if (this.a.A.hasMessages(1074)) {
        this.a.A.removeMessages(1074);
      }
      this.a.y.a(CommonConstants.a, 0, paramMessage);
      return true;
    case 1069: 
      if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(false)))
      {
        this.a.A.removeMessages(1069);
        this.a.A.removeMessages(1068);
        return true;
      }
      if (this.a.A.hasMessages(1068)) {
        this.a.A.removeMessages(1068);
      }
      this.a.y.a(false);
      this.a.y.a(-1, null);
      return true;
    case 1068: 
      if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(false)))
      {
        this.a.A.removeMessages(1069);
        this.a.A.removeMessages(1068);
        return true;
      }
      if (this.a.A.hasMessages(1069)) {
        this.a.A.removeMessages(1069);
      }
      this.a.y.a(true);
      this.a.y.a(-1, null);
      return true;
    case 1035: 
      this.a.I();
    }
    return true;
  }
  
  private void f()
  {
    SLog.b("Q.recent", "handle MSG_INIT_MSGTAG_STORY");
    if (this.a.aF != null) {
      QQStoryManager localQQStoryManager = (QQStoryManager)this.a.aF.getManager(QQManagerFactory.QQSTORY_MANAGER);
    }
    ThreadManager.post(new Conversation.UICallBack.4(this), 8, null, true);
  }
  
  private void f(Message paramMessage)
  {
    long l2 = Math.abs(System.currentTimeMillis() - this.a.K);
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
        ((StringBuilder)localObject).append(this.a.K);
        ((StringBuilder)localObject).append("]");
        QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
      }
      l1 = this.a.a + 1L;
    }
    Object localObject = (List)paramMessage.obj;
    int j = paramMessage.arg2;
    int i = 1;
    if ((j != 1) && (l1 < this.a.a))
    {
      this.a.J = ((List)localObject);
      paramMessage = Message.obtain();
      paramMessage.what = 10000;
      paramMessage.obj = this.a.J;
      paramMessage.arg1 = 0;
      paramMessage.arg2 = 1;
      this.a.A.sendMessageDelayed(paramMessage, this.a.a - l1 + 50L);
      return;
    }
    if (paramMessage.arg2 == 1)
    {
      if (localObject != this.a.J) {
        i = 0;
      }
    }
    else {
      this.a.J = ((List)localObject);
    }
    if (i != 0)
    {
      paramMessage = this.a;
      Conversation.a(paramMessage, 0, paramMessage.J);
      this.a.K = System.currentTimeMillis();
    }
  }
  
  private void g()
  {
    if (MiniAppConfProcessor.e())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "MSG_SCROLL_TOP_AND_REFRESH");
      }
      Conversation.b(this.a, true);
      Conversation.a(this.a, SystemClock.elapsedRealtime());
      Conversation.i(this.a).setSelection(0);
      Conversation.j(this.a);
    }
  }
  
  private void g(Message paramMessage)
  {
    if (this.a.l != null)
    {
      if (this.a.m == null) {
        return;
      }
      boolean bool = this.a.m.f();
      paramMessage = new StringBuilder();
      paramMessage.append("handleMessageForUpdatePlusRedTouch: needsExposeRedTouchUpward = ");
      paramMessage.append(bool);
      QLog.i("Q.recent", 1, paramMessage.toString());
      if (bool)
      {
        paramMessage = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramMessage.red_type.set(0);
        this.a.l.a(paramMessage);
        return;
      }
      this.a.l.g();
    }
  }
  
  private void h()
  {
    ThreadManager.post(new Conversation.UICallBack.5(this), 8, null, true);
  }
  
  private void h(Message paramMessage)
  {
    if (((paramMessage.obj instanceof String[])) && (!this.a.F))
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
  
  private void i()
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.UICallBack.6(this));
  }
  
  /* Error */
  private void i(Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   4: invokestatic 675	com/tencent/mobileqq/activity/home/Conversation:l	(Lcom/tencent/mobileqq/activity/home/Conversation;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   7: ifnull +37 -> 44
    //   10: aload_0
    //   11: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   14: invokestatic 675	com/tencent/mobileqq/activity/home/Conversation:l	(Lcom/tencent/mobileqq/activity/home/Conversation;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   17: invokevirtual 680	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   20: goto +15 -> 35
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   28: aconst_null
    //   29: invokestatic 683	com/tencent/mobileqq/activity/home/Conversation:a	(Lcom/tencent/mobileqq/activity/home/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   32: pop
    //   33: aload_1
    //   34: athrow
    //   35: aload_0
    //   36: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   39: aconst_null
    //   40: invokestatic 683	com/tencent/mobileqq/activity/home/Conversation:a	(Lcom/tencent/mobileqq/activity/home/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   43: pop
    //   44: aload_0
    //   45: getfield 12	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	Lcom/tencent/mobileqq/activity/home/Conversation;
    //   48: getfield 410	com/tencent/mobileqq/activity/home/Conversation:y	Lcom/tencent/mobileqq/banner/BannerManager;
    //   51: getstatic 686	com/tencent/mobileqq/activity/recent/bannerprocessor/InstallUpgradeBannerProcessor:a	I
    //   54: iconst_0
    //   55: aload_1
    //   56: invokevirtual 418	com/tencent/mobileqq/banner/BannerManager:a	(IILandroid/os/Message;)V
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
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "handleVasADBannerClose");
    }
    if (this.a.V != null)
    {
      this.a.V.b();
      this.a.V = null;
    }
    Object localObject = this.a.h.findViewById(2131449329);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      this.a.h.removeView((View)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleVasADBannerClose,statusTitle.h = ");
      ((StringBuilder)localObject).append(this.a.h.getHeight());
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
      if (Conversation.m(this.a) < 0)
      {
        localObject1 = this.a;
        Conversation.b((Conversation)localObject1, ((Conversation)localObject1).h.getHeight());
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleVasADBannerShowWithObj,statusTitle.h = ");
        ((StringBuilder)localObject1).append(this.a.h.getHeight());
        ((StringBuilder)localObject1).append("，statusTitleHeightInNormalState = ");
        ((StringBuilder)localObject1).append(Conversation.m(this.a));
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
          Object localObject3 = this.a.h.findViewById(2131449329);
          if (localObject3 != null) {
            this.a.h.removeView((View)localObject3);
          }
          if ((Conversation.n(this.a) != null) && (Conversation.n(this.a).hasOpenDesktop())) {
            paramMessage.setVisibility(8);
          }
          localObject3 = new ConversationQbossBannerTitleEntranceCtrl(this.a);
          ((ConversationQbossBannerTitleEntranceCtrl)localObject3).a(paramMessage);
          ((ConversationQbossBannerTitleEntranceCtrl)localObject3).a(false);
          Conversation localConversation = this.a;
          localConversation.V = ((ConversationQbossBannerTitleEntranceCtrl)localObject3);
          localConversation.h.addView(paramMessage);
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
    if (d(paramMessage)) {
      return true;
    }
    if (c(paramMessage)) {
      return true;
    }
    return b(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack
 * JD-Core Version:    0.7.0.1
 */