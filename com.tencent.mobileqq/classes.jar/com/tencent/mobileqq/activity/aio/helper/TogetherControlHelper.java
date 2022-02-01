package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TogetherTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TogetherWatchTroopTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TogetherEntryBean;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherObserver;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.together.ui.TogetherPanel;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class TogetherControlHelper
  implements Handler.Callback, View.OnClickListener, ILifeCycleHelper
{
  TogetherPanel a;
  ImageView b;
  ImageView c;
  RedpointObserver d = new TogetherControlHelper.2(this);
  private boolean e;
  private final AIOContext f;
  private BaseChatPie g;
  private BaseActivity h;
  private TogetherTipsBar i;
  private TogetherUIData j;
  private long k = 0L;
  private Handler l;
  private QQCustomDialog m;
  private long n = 0L;
  private AtomicBoolean o = new AtomicBoolean(false);
  private TogetherWatchTroopTipsBar p;
  private TogetherObserver q = new TogetherControlHelper.1(this);
  
  public TogetherControlHelper(BaseChatPie paramBaseChatPie)
  {
    this.f = paramBaseChatPie.bv();
    this.g = paramBaseChatPie;
    this.h = this.g.aX();
    this.j = new TogetherUIData();
    this.l = new Handler(Looper.getMainLooper(), this);
    if (QLog.isColorLevel())
    {
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append("TogetherControlHelper mUIData=");
      paramBaseChatPie.append(Integer.toHexString(System.identityHashCode(this.j)));
      QLog.d("TogetherControlHelper.helper", 2, paramBaseChatPie.toString());
    }
  }
  
  private void a(TogetherSession paramTogetherSession)
  {
    BaseActivity localBaseActivity = this.h;
    if ((localBaseActivity != null) && (localBaseActivity.getIntent() != null))
    {
      if (!TogetherUtils.a(this.h.getIntent(), paramTogetherSession, this.e)) {
        return;
      }
      b(((TogetherControlManager)this.g.d.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).d(paramTogetherSession.l));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "invokeJoinDialog activity or intent is null");
    }
  }
  
  private void b(String paramString)
  {
    ThreadManagerV2.executeOnSubThread(new TogetherControlHelper.3(this, paramString));
  }
  
  private void c(String paramString)
  {
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.g.d.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    localTogetherControlManager.a("video_tab", "exp_joinframe", 0, this.g.ae());
    t();
    String str1 = String.format(this.h.getResources().getString(2131897441), new Object[] { paramString });
    paramString = String.format(this.h.getResources().getString(2131897444), new Object[] { paramString });
    String str2 = this.h.getResources().getString(2131887648);
    String str3 = this.h.getResources().getString(2131892267);
    this.m = DialogUtil.a(this.h, 230, null, paramString, str2, str3, new TogetherControlHelper.4(this, localTogetherControlManager, str1), new TogetherControlHelper.5(this, localTogetherControlManager));
    this.m.setMessageMaxLine(1);
    this.m.show();
  }
  
  private TogetherTipsBar o()
  {
    if (this.i == null)
    {
      this.i = new TogetherTipsBar(this.g, this);
      if (this.g.J() != null) {
        this.g.J().b(this.i);
      }
    }
    return this.i;
  }
  
  private void p()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      if (((TogetherUIData)localObject).getTogetherSession() == null) {
        return;
      }
      localObject = this.g;
      if ((localObject instanceof TroopChatPie)) {
        ((TroopChatPie)localObject).cc();
      }
      localObject = this.g;
      if ((localObject instanceof FriendChatPie)) {
        ((FriendChatPie)localObject).bB();
      }
    }
  }
  
  private boolean q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "showTogetherTip");
    }
    o();
    if (this.g.J() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null");
      }
      return false;
    }
    TipsBarTask localTipsBarTask = this.g.J().a();
    if ((localTipsBarTask != null) && (localTipsBarTask != this.i))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "currTip is other");
      }
      return false;
    }
    this.g.J().a(this.i, new Object[0]);
    this.i.a(this.j.getTogetherSession(), this.g.d);
    return true;
  }
  
  private void r()
  {
    if ((this.p == null) && ((this.g instanceof TroopChatPie)) && (this.f.z().a(24)))
    {
      this.p = new TogetherWatchTroopTipsBar(this.f.a(), this.f.O(), this.f.c(), this.h);
      this.g.J().b(this.p);
    }
  }
  
  private void s()
  {
    if (System.currentTimeMillis() - this.n < 1000L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click button too frequently pastTime=");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - this.n);
        QLog.d("TogetherControlHelper.helper", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.n = System.currentTimeMillis();
    if (!NetworkUtil.isNetworkAvailable(this.h))
    {
      QQToast.makeText(this.h, 2131918148, 0).show(this.h.getTitleBarHeight());
      return;
    }
    Object localObject = this.j;
    if ((localObject != null) && (((TogetherUIData)localObject).getTogetherSession() != null))
    {
      TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.g.d.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      if (localTogetherControlManager == null) {
        return;
      }
      TogetherSession localTogetherSession = this.j.getTogetherSession();
      boolean bool = localTogetherSession instanceof WatchTogetherSession;
      int i1 = 1;
      if (bool)
      {
        localObject = ((TroopManager)this.g.d.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.g.ae());
        if (localObject == null) {
          return;
        }
        localObject = TogetherUtils.a(true, ((TroopInfo)localObject).isTroopOwner(this.g.d.getCurrentAccountUin()), ((TroopInfo)localObject).isAdmin(), ((TroopInfo)localObject).troopowneruin, this.g.ah.b, 0);
        i1 = this.j.getTogetherSession().u;
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            if (localTogetherControlManager.a(this.g.e, 2, this.g.ae(), 1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TogetherControlHelper.helper", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
              }
            }
            else
            {
              localTogetherControlManager.a("video_tab", "clk_join_suc", 0, this.g.ae());
              TogetherUtils.a(this.g.d, this.j.getTogetherSession().v, this.j.getTogetherSession().w, null, (Bundle)localObject, 1);
            }
          }
          else
          {
            localTogetherControlManager.a("video_tab", "clk_join_suc", 0, this.g.ae());
            localTogetherControlManager.b(this.g.e, this.g.ae(), 1, 2, 1, (Bundle)localObject);
          }
        }
        else {
          QQToast.makeText(this.h, 0, 2131890214, 0).show();
        }
        localTogetherControlManager.a("video_tab", "clk_join", 0, this.g.ae());
        return;
      }
      if ((localTogetherSession instanceof SingTogetherSession))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "SING together is click");
        }
        localObject = null;
        Bundle localBundle = new Bundle();
        String str1 = this.g.d.getCurrentAccountUin();
        String str2 = localTogetherSession.n;
        int i2 = -1;
        bool = localTogetherControlManager.b(4, -1, str2);
        if (localTogetherSession.m == 1)
        {
          localObject = ((TroopManager)this.g.d.getManager(QQManagerFactory.TROOP_MANAGER)).g(localTogetherSession.n);
          if (localObject == null) {
            return;
          }
          localBundle = TogetherUtils.a(bool, ((TroopInfo)localObject).isTroopOwner(str1), ((TroopInfo)localObject).isAdmin(), ((TroopInfo)localObject).troopowneruin, localTogetherSession.n, 1);
          localTogetherControlManager.a("sing_tab", "clk_join", 0, this.g.ae());
          localObject = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
          i2 = 1;
        }
        else if (localTogetherSession.m == 2)
        {
          localBundle = TogetherUtils.a(bool, 4);
          ReportController.b(this.g.d, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join", 0, 0, localTogetherSession.n, "", "", "");
          localObject = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
          i1 = 2;
          i2 = 4;
        }
        else
        {
          i1 = -1;
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        if (bool)
        {
          localTogetherControlManager.b(this.h, localTogetherSession.n, i1, 4, i2, localBundle);
          return;
        }
        localTogetherControlManager.a(this.h, localTogetherSession.n, i1, 4, i2, localBundle);
      }
      return;
    }
    QQToast.makeText(this.h, 0, 2131890214, 0).show();
  }
  
  private boolean t()
  {
    QQCustomDialog localQQCustomDialog = this.m;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing()))
    {
      this.m.dismiss();
      return true;
    }
    return false;
  }
  
  private void u()
  {
    BaseActivity localBaseActivity = this.h;
    if ((localBaseActivity != null) && (localBaseActivity.getIntent() != null) && (this.h.getIntent().getBooleanExtra("open_together_panel", false))) {
      a(3);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onCreate()");
    }
    this.g.d.addObserver(this.q);
    this.g.d.addObserver(this.d);
    TogetherControlManager.a(this.g.d).a(this.q);
    BaseChatPie localBaseChatPie = this.g;
    if ((localBaseChatPie instanceof TroopChatPie)) {
      TogetherControlManager.a(localBaseChatPie.d).a(true);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.g;
    if (!(localObject instanceof TroopChatPie))
    {
      QLog.d("TogetherControlHelper.helper", 1, "chat pie not TroopChatPie");
      return;
    }
    if (this.a == null) {
      this.a = new TogetherPanel(((BaseChatPie)localObject).aX());
    }
    localObject = this.h.findViewById(2131430542);
    this.a.a((TroopChatPie)this.g, (View)localObject, paramInt);
  }
  
  public void a(int paramInt, TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onOtherTipsHide tip=");
      ((StringBuilder)localObject).append(paramTipsBarTask);
      ((StringBuilder)localObject).append(" type=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TogetherControlHelper.helper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.j;
    if ((localObject != null) && (((TogetherUIData)localObject).getTogetherSession() != null))
    {
      boolean bool = true;
      if (paramInt == 1)
      {
        localObject = this.i;
        if ((localObject != null) && (localObject != paramTipsBarTask))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip not equal TogetherTip");
          }
          if ((!TogetherUtils.a(this.g.d, this.j.getTogetherSession())) || (TogetherWatchFloatingUtil.a(this.j.getTogetherSession().l, this.j.getTogetherSession().n, this.j.getTogetherSession().m)) || (j())) {
            bool = false;
          }
          if (QLog.isColorLevel())
          {
            paramTipsBarTask = new StringBuilder();
            paramTipsBarTask.append("onOtherTipsHide expand=");
            paramTipsBarTask.append(bool);
            QLog.d("TogetherControlHelper.helper", 2, paramTipsBarTask.toString());
          }
          if (bool) {
            q();
          }
          p();
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide mUIData is null or session is null");
    }
  }
  
  public void a(String paramString)
  {
    if (Math.abs(System.currentTimeMillis() - this.k) < 500L) {
      return;
    }
    Object localObject1 = this.j;
    if (localObject1 != null)
    {
      if (((TogetherUIData)localObject1).getTogetherSession() == null) {
        return;
      }
      boolean bool3 = b();
      boolean bool1 = false;
      boolean bool2;
      if (bool3)
      {
        bool2 = c();
      }
      else
      {
        if (!TogetherWatchFloatingUtil.a(this.j.getTogetherSession().l, this.j.getTogetherSession().n, this.j.getTogetherSession().m)) {
          bool1 = q();
        }
        bool2 = bool1;
        if (bool1)
        {
          localObject1 = this.j.getTogetherSession();
          bool2 = bool1;
          if ((localObject1 instanceof WatchTogetherSession))
          {
            bool2 = bool1;
            if (((TogetherSession)localObject1).z == 2)
            {
              ((TogetherSession)localObject1).z = 1;
              bool2 = bool1;
            }
          }
        }
      }
      this.k = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onSubTitleClicked isPanelShow= ");
        ((StringBuilder)localObject1).append(bool3);
        ((StringBuilder)localObject1).append(" handle=");
        ((StringBuilder)localObject1).append(bool2);
        QLog.d("TogetherControlHelper.helper", 2, ((StringBuilder)localObject1).toString());
      }
      if (!bool2) {
        return;
      }
      int i1 = this.j.getTogetherSession().m;
      localObject1 = "clk_expand";
      Object localObject2;
      if (i1 == 2)
      {
        localObject2 = this.g.d;
        if (!bool3) {
          localObject1 = "clk_expand";
        } else {
          localObject1 = "clk_fold";
        }
        ReportController.b((AppRuntime)localObject2, "dc00899", "c2c_AIO", "", "sing_tab", (String)localObject1, 0, 2, paramString, "", "", "");
      }
      else if (this.j.getTogetherSession().l == 2)
      {
        localObject2 = TogetherControlManager.a(this.g.d);
        if (bool3) {
          localObject1 = "clk_fold";
        }
        ((TogetherControlManager)localObject2).a("video_tab", (String)localObject1, 2, paramString);
      }
      else if (this.j.getTogetherSession().l == 4)
      {
        localObject2 = TogetherControlManager.a(this.g.d);
        if (bool3) {
          localObject1 = "clk_fold";
        }
        ((TogetherControlManager)localObject2).a("sing_tab", (String)localObject1, 2, paramString);
      }
      TogetherUtils.a(this.g.d, this.j.getTogetherSession(), bool3 ^ true);
      p();
    }
  }
  
  public void b(int paramInt)
  {
    a(paramInt);
    Object localObject1 = (IRedTouchManager)this.h.app.getRuntimeService(IRedTouchManager.class, "");
    Object localObject2 = ((IRedTouchManager)localObject1).getAppInfo(10, String.valueOf(130500));
    if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1)) {
      ((IRedTouchManager)localObject1).onRedTouchItemClick((BusinessInfoCheckUpdate.AppInfo)localObject2, "");
    }
    localObject1 = this.g.d;
    localObject2 = this.g.ah.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.c(this.g.d, String.valueOf(this.g.ah.b)));
    ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_AIO", "", "hi_tab", "clk_hi", 0, 0, (String)localObject2, "", localStringBuilder.toString(), "");
  }
  
  public void b(int paramInt, TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOtherTipsShow tip=");
      localStringBuilder.append(paramTipsBarTask);
      localStringBuilder.append(" type=");
      localStringBuilder.append(paramInt);
      QLog.d("TogetherControlHelper.helper", 2, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    if ((this.g.J() != null) && (this.i != null))
    {
      if (this.g.J().a() == this.i)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "curTip is togetherTip");
        }
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
    }
    return false;
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "dismissTogetherTip");
    }
    if ((this.i != null) && (this.g.J() != null))
    {
      TipsBarTask localTipsBarTask = this.g.J().a();
      if ((localTipsBarTask != null) && (localTipsBarTask == this.i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "currTip is togetherTip");
        }
        this.g.J().c();
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
    }
    return false;
  }
  
  public String d()
  {
    if (this.j == null) {
      return "";
    }
    boolean bool = b();
    return this.j.getSubTitleText(bool, this.g.d);
  }
  
  public boolean e()
  {
    Object localObject = this.j;
    boolean bool2 = false;
    if ((localObject != null) && (((TogetherUIData)localObject).getTogetherSession() != null))
    {
      boolean bool1 = bool2;
      if (this.j.getTogetherSession() != null)
      {
        bool1 = bool2;
        if (this.j.getTogetherSession().p != 3)
        {
          bool1 = bool2;
          if (this.j.getTogetherSession().p != 0) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    if ((this.j != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TogetherControlHelper isTogetherTime mUIData=");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.j)));
      QLog.d("TogetherControlHelper.helper", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean f()
  {
    return (e()) && (TogetherWatchFloatingUtil.a(this.j.getTogetherSession().l, this.j.getTogetherSession().n, this.j.getTogetherSession().m));
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onResume()");
    }
    this.e = true;
    this.o.set(false);
  }
  
  public String getTag()
  {
    return "TogetherControlHelper.helper";
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onPause()");
    }
    this.e = false;
    TipsManager localTipsManager = this.g.J();
    if (localTipsManager != null) {
      localTipsManager.a(1003, new Object[0]);
    }
    t();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3) {
      c((String)paramMessage.obj);
    }
    return false;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onStop()");
    }
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    int i1;
    if (((BaseChatPie)localObject).F() == 1)
    {
      i1 = 1;
    }
    else
    {
      this.g.F();
      i1 = 2;
    }
    localObject = (WatchTogetherSession)TogetherControlManager.a(this.g.d).a(2, i1, this.g.ae());
    if (localObject == null) {
      return;
    }
    if ((((TogetherSession)localObject).p == 1) && (((TogetherSession)localObject).q != 2) && (((TogetherSession)localObject).z == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onStop() hideTogetherTip");
      }
      ((TogetherSession)localObject).z = 2;
    }
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 8, 7, 10, 11, 12, 15 };
  }
  
  public boolean j()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      if (((TogetherUIData)localObject).getTogetherSession() == null) {
        return true;
      }
      localObject = this.j.getTogetherSession();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isHideTogetherTip = ");
        localStringBuilder.append(((TogetherSession)localObject).z);
        QLog.d("TogetherControlHelper.helper", 2, localStringBuilder.toString());
      }
      if (!(localObject instanceof WatchTogetherSession)) {
        return false;
      }
      return ((TogetherSession)localObject).z == 2;
    }
    return true;
  }
  
  public boolean k()
  {
    TogetherPanel localTogetherPanel = this.a;
    if ((localTogetherPanel != null) && (localTogetherPanel.a())) {
      return true;
    }
    return t();
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onDestroy()");
    }
    this.o.set(true);
    this.g.d.removeObserver(this.q);
    this.g.d.removeObserver(this.d);
    TogetherControlManager.a(this.g.d).b(this.q);
    if (this.g.J() != null) {
      c();
    }
    this.k = 0L;
    Object localObject = this.j;
    if (localObject != null) {
      ((TogetherUIData)localObject).reset();
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((TogetherPanel)localObject).b();
      this.a = null;
    }
    this.l.removeCallbacksAndMessages(null);
    this.p = null;
  }
  
  public void m()
  {
    Object localObject = (TroopManager)this.g.d.getManager(QQManagerFactory.TROOP_MANAGER);
    TogetherEntryBean localTogetherEntryBean = (TogetherEntryBean)QConfigManager.b().b(553);
    if ((localTogetherEntryBean != null) && (localTogetherEntryBean.a) && (!((TroopManager)localObject).aa(this.g.ah.b)))
    {
      localObject = this.g.p;
      int i1;
      if (AnonymousChatHelper.a().a(this.g.ah.b)) {
        i1 = 2130852610;
      } else {
        i1 = 2130852611;
      }
      ((NavBarAIO)localObject).setRight2Icon(i1);
      try
      {
        if (!AnonymousChatHelper.a().a(this.g.ah.b))
        {
          i1 = this.h.getResources().getColor(2131167990);
          localObject = ThemeUtil.drawableTint(this.h, 2130852611, i1);
          this.b.setImageDrawable((Drawable)localObject);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("TogetherControlHelper.helper", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public void n()
  {
    if (this.b == null) {
      this.b = ((ImageView)this.g.aZ.findViewById(2131436189));
    }
    if (this.c == null) {
      this.c = ((ImageView)this.g.aZ.findViewById(2131444531));
    }
    if (this.b != null)
    {
      if (this.c == null) {
        return;
      }
      Object localObject1 = (TroopManager)this.g.d.getManager(QQManagerFactory.TROOP_MANAGER);
      Object localObject2 = (TogetherEntryBean)QConfigManager.b().b(553);
      if ((localObject2 != null) && (((TogetherEntryBean)localObject2).a) && (this.g.ah != null) && (!((TroopManager)localObject1).aa(this.g.ah.b)) && (!((TroopManager)localObject1).F(this.g.ah.b)))
      {
        localObject1 = this.g.p;
        int i1;
        if (AnonymousChatHelper.a().a(this.g.ah.b)) {
          i1 = 2130852610;
        } else {
          i1 = 2130852611;
        }
        ((NavBarAIO)localObject1).setRight2Icon(i1);
        localObject1 = (IRedTouchManager)this.g.d.getRuntimeService(IRedTouchManager.class, "");
        localObject2 = ((IRedTouchManager)localObject1).getAppInfo(4, String.valueOf(130500));
        if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1))
        {
          this.c.setVisibility(0);
          ((IRedTouchManager)localObject1).onRedTouchItemExposure((BusinessInfoCheckUpdate.AppInfo)localObject2, "");
        }
        else
        {
          this.c.setVisibility(8);
        }
        try
        {
          if (!AnonymousChatHelper.a().a(this.g.ah.b))
          {
            i1 = this.h.getResources().getColor(2131167990);
            localObject1 = ThemeUtil.drawableTint(this.h, 2130852611, i1);
            this.b.setImageDrawable((Drawable)localObject1);
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("TogetherControlHelper.helper", 2, localThrowable, new Object[0]);
        }
        if (AppSetting.e) {
          this.b.setContentDescription(HardCodeUtil.a(2131897442));
        }
        this.b.setOnClickListener(this);
        this.b.setVisibility(0);
        this.g.bf();
        QQAppInterface localQQAppInterface = this.g.d;
        localObject2 = this.g.ah.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopUtils.c(this.g.d, String.valueOf(this.g.ah.b)));
        ReportController.b(localQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "exp_hi", 0, 0, (String)localObject2, "", localStringBuilder.toString(), "");
        return;
      }
      this.b.setOnClickListener(null);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131447681) && (paramView.getId() != 2131447678))
    {
      if (paramView.getId() == 2131436189) {
        b(1);
      }
    }
    else {
      s();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15)
      {
        if (paramInt != 7)
        {
          if (paramInt != 8) {
            switch (paramInt)
            {
            default: 
              break;
            case 12: 
              i();
              break;
            case 11: 
              h();
              break;
            case 10: 
              r();
              break;
            }
          } else {
            u();
          }
        }
        else {
          g();
        }
      }
      else {
        l();
      }
    }
    else {
      a();
    }
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.g.d.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    if (localTogetherControlManager != null) {
      localTogetherControlManager.a(this.g.e, this.g.ah, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper
 * JD-Core Version:    0.7.0.1
 */