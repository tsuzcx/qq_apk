package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsTabs;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.MiniAppScrollListener;
import com.tencent.mobileqq.activity.contacts.pullrefresh.OnRefreshListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryController;
import com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController;
import com.tencent.mobileqq.activity.contacts.topentry.RecommendTroopEntryController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.extendfriend.widget.ExtendFriendContactEntranceContainer;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AbsSlidingIndicator;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.widget.IPullRefreshHeaderControl;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ContactsViewController
  extends BaseViewController
  implements ContactsBaseFragment.RefreshDataListener, OnRefreshListener, StudyModeChangeListener, AbsSlidingIndicator.OnTabListener
{
  private FriendListObserver A = new ContactsViewController.6(this);
  protected QQAppInterface b;
  MqqHandler c = new MqqHandler(Looper.getMainLooper(), new ContactsViewController.1(this));
  private int d;
  private int e;
  private int f = -1;
  private boolean g = false;
  private AbsSlidingIndicator h;
  private CommonRefreshLayout i;
  private IPullRefreshHeaderControl j;
  private HeaderScrollView k;
  private ContactsViewPager l;
  private ContactsViewPagerAdapter m;
  private CTEntryController n;
  private int o = 2;
  private View p;
  private ExtendFriendContactEntranceContainer q;
  private ContactsTabs r;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x;
  private BaseContactsMiniAppEntryManager y;
  private boolean z = false;
  
  public ContactsViewController(Activity paramActivity)
  {
    super(paramActivity);
    if ((paramActivity instanceof SplashActivity)) {
      this.b = ((SplashActivity)paramActivity).app;
    }
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.b.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    this.r = new ContactsTabs(localMayknowRecommendManager.d("sp_mayknow_entry_list_recommend"), StudyModeManager.h());
    int i1;
    if (localMayknowRecommendManager.n()) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    this.o = i1;
    if (this.o == 2) {
      paramActivity = new RecommendTroopEntryController(paramActivity);
    } else {
      paramActivity = new MayKnowPersonEntryController(paramActivity);
    }
    this.n = paramActivity;
    this.n.a(new ContactsViewController.2(this));
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("ContactsViewController headType is: ");
      paramActivity.append(this.o);
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, paramActivity.toString());
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkTabsNeedChange. causeSwitchAccount:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" moveToDefault:");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" mIsResumed:");
      localStringBuilder.append(this.t);
      QLog.i("ContactsViewController", 2, localStringBuilder.toString());
    }
    if (this.t)
    {
      this.s = true;
      int i1 = this.r.a(this.e);
      if (n())
      {
        i1 = this.r.b(i1);
        if ((i1 == -1) || (paramBoolean2)) {
          i1 = c(paramBoolean1);
        }
        d(i1);
        this.l.setOffscreenPageLimit(this.r.c.size());
      }
      this.s = false;
      return;
    }
    this.u = true;
    this.v = paramBoolean1;
    this.w = paramBoolean2;
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.y;
    if (localObject != null) {
      ((BaseContactsMiniAppEntryManager)localObject).onAccountChanged(paramQQAppInterface);
    }
    if (!p())
    {
      paramQQAppInterface = this.y;
      if (paramQQAppInterface != null)
      {
        localObject = this.i;
        if (localObject != null) {
          paramQQAppInterface.shutdownMiniAppPullDownEntry((ViewGroup)localObject, FrameControllerUtil.c);
        }
      }
    }
  }
  
  private int c(boolean paramBoolean)
  {
    int i1 = this.r.b(1);
    int i3 = i1;
    Object localObject;
    if (this.r.b())
    {
      int i4 = SharedPreUtils.aI(b(), this.b.getCurrentUin());
      int i2 = 0;
      localObject = (FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject != null) {
        i2 = ((FriendsManager)localObject).u();
      }
      if ((paramBoolean) && (i2 == 0)) {
        this.z = true;
      }
      if (((paramBoolean) && (i2 == 0)) || (i2 > i4)) {
        i1 = this.r.b(1);
      }
      i3 = i1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDefaultTabPosition ShowRecommendTab friendCount:");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(" boundaryCount:");
        ((StringBuilder)localObject).append(i4);
        QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
        i3 = i1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDefaultTabPosition. defaultPos:");
      ((StringBuilder)localObject).append(i3);
      QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
    }
    return i3;
  }
  
  private void c(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConversationRecommendTypeChange newType is: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" oldType: ");
      ((StringBuilder)localObject).append(this.o);
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, ((StringBuilder)localObject).toString());
    }
    if (this.o == paramInt) {
      return;
    }
    this.n.e();
    this.o = paramInt;
    if (this.o == 2) {
      localObject = new RecommendTroopEntryController(this.a);
    } else {
      localObject = new MayKnowPersonEntryController(this.a);
    }
    this.n = ((CTEntryController)localObject);
    this.n.a(new ContactsViewController.3(this));
    this.n.c();
    this.n.a(this.p);
    if (this.t) {
      this.n.a(false);
    }
  }
  
  private void d(int paramInt)
  {
    if ((this.m != null) && (this.l != null) && (this.h != null) && (this.r != null) && (this.b != null))
    {
      if (this.k == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("switchToTabPos mCurrentTabPos:");
        localStringBuilder.append(this.e);
        localStringBuilder.append("  pos:");
        localStringBuilder.append(paramInt);
        QLog.i("ContactsViewController", 2, localStringBuilder.toString());
      }
      this.e = paramInt;
      this.h.setCurrentPosition(this.e, false);
      this.l.setCurrentItem(this.e, false);
      this.k.setCurrentScrollableContainer(this.m.a(this.e, true));
    }
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageChange. position:");
      localStringBuilder.append(paramInt);
      QLog.d("ContactsViewController", 2, localStringBuilder.toString());
    }
    this.k.setCurrentScrollableContainer(this.m.a(paramInt, true));
    this.m.b(paramInt, this.f);
    this.h.setCurrentPosition(paramInt, this.s ^ true);
    this.e = paramInt;
  }
  
  private boolean n()
  {
    Object localObject = this.m;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (localObject != null)
    {
      bool2 = bool3;
      if (this.l != null)
      {
        bool2 = bool3;
        if (this.h != null)
        {
          bool2 = bool3;
          if (this.r != null)
          {
            localObject = this.b;
            bool2 = bool3;
            if (localObject != null)
            {
              if (this.k == null) {
                return false;
              }
              localObject = (MayknowRecommendManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
              if (localObject != null)
              {
                bool1 = ((MayknowRecommendManager)localObject).d("sp_mayknow_entry_list_recommend");
                bool1 = this.r.a(bool1, StudyModeManager.h());
              }
              if (bool1)
              {
                this.m.a(this.r.c);
                this.h.setTabData(this.r.a, this.r.b);
              }
              bool2 = bool1;
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("checkAndUpdateRecommendTabShow. mCurrentTabPos:");
                ((StringBuilder)localObject).append(this.e);
                ((StringBuilder)localObject).append(" isShowRecommendTab:");
                ((StringBuilder)localObject).append(this.r.b());
                ((StringBuilder)localObject).append(" changed:");
                ((StringBuilder)localObject).append(bool1);
                QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
                bool2 = bool1;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "initMicroAppEntryLayout.");
    }
    Object localObject = this.b;
    if (localObject == null)
    {
      QLog.e("ContactsViewController", 1, "initMicroAppEntryLayout, mApp = null.");
      return;
    }
    localObject = ((QQAppInterface)localObject).getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
    if (localObject != null) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).sendUserAppListRequest((Manager)localObject, Long.valueOf(this.b.getCurrentAccountUin()).longValue(), 20L);
    }
    if (this.y == null)
    {
      this.y = ((IMiniAppService)QRoute.api(IMiniAppService.class)).createContactsMiniAppEntryManager(b(), this.b, (RelativeLayout)this.j, 1);
      this.i.setMiniAppScrollListener((CommonRefreshLayout.MiniAppScrollListener)this.y);
    }
    this.y.showMicroAppPanel(FrameControllerUtil.c);
  }
  
  private static boolean p()
  {
    MiniAppConfBean localMiniAppConfBean = MiniAppConfProcessor.a();
    return (localMiniAppConfBean != null) && (localMiniAppConfBean.f());
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onContactTabChange. position:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" fromUserClick:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
    }
    this.f = this.l.getCurrentItem();
    if (this.f != paramInt) {
      this.x = true;
    }
    this.e = paramInt;
    this.l.setCurrentItem(paramInt, false);
    if (paramBoolean)
    {
      switch (this.r.a(paramInt))
      {
      default: 
        localObject = "";
      }
      for (;;)
      {
        break;
        localObject = "0X800A1F6";
        continue;
        localObject = "0X8007F1E";
        continue;
        localObject = "0X8007F1D";
        continue;
        localObject = "0X8007F1C";
        continue;
        localObject = "0X8007F1A";
        continue;
        localObject = "0X8007F19";
      }
      ReportController.b(this.b, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
    return 0;
  }
  
  public void a()
  {
    Object localObject;
    if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      localObject = this.m;
      if (localObject != null)
      {
        ContactsViewPager localContactsViewPager = this.l;
        if (localContactsViewPager != null) {
          ((ContactsViewPagerAdapter)localObject).g(localContactsViewPager.getCurrentItem());
        }
      }
      localObject = this.q;
      if (localObject != null) {
        ((ExtendFriendContactEntranceContainer)localObject).b();
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsViewController", 2, "refresh falied. network unavailable");
      }
      localObject = this.c.obtainMessage(3);
      this.c.sendMessageDelayed((Message)localObject, 1000L);
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = ThemeUtil.isNowThemeIsDefaultCache(this.b, true);
    k();
    Object localObject = this.m;
    if (localObject != null) {
      ((ContactsViewPagerAdapter)localObject).a(bool, paramInt);
    }
    this.n.c(bool);
    localObject = this.y;
    if (localObject != null) {
      ((BaseContactsMiniAppEntryManager)localObject).onPostThemeChanged();
    }
    m();
    this.j = SimpleModeHelper.a(this.i);
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(View paramView)
  {
    this.p = paramView;
    this.h = ((SimpleSlidingIndicator)paramView.findViewById(2131446094));
    m();
    k();
    this.k = ((HeaderScrollView)paramView.findViewById(2131431264));
    this.l = ((ContactsViewPager)paramView.findViewById(2131431267));
    this.m = new ContactsViewPagerAdapter(((SplashActivity)b()).getSupportFragmentManager(), ((SplashActivity)b()).app, (BaseActivity)b(), this.r.c);
    this.m.a(this);
    this.l.setAdapter(this.m);
    this.l.setOffscreenPageLimit(this.r.c.size());
    this.l.setOnPageChangeListener(new ContactsViewController.4(this));
    this.h.setTabData(this.r.a, this.r.b);
    this.h.setOnTabListener(this);
    this.h.setInterceptListener(this);
    this.i = ((CommonRefreshLayout)paramView.findViewById(2131446666));
    this.i.setRefreshCompleteDelayDuration(0);
    this.j = ((IPullRefreshHeaderControl)this.i.findViewById(2131446664));
    this.j.a(19, null);
    this.i.setOnRefreshListener(this);
    this.n.a(paramView);
    if (p()) {
      o();
    }
    d(c(false));
    if (this.e != 0) {
      this.g = true;
    }
    this.k.setOnScrollListener(new ContactsViewController.5(this));
    this.q = ((ExtendFriendContactEntranceContainer)paramView.findViewById(2131432682));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramQQAppInterface != null)
    {
      localObject = this.b;
      if (localObject != paramQQAppInterface)
      {
        if (localObject != null) {
          ((QQAppInterface)localObject).removeObserver(this.A);
        }
        paramQQAppInterface.addObserver(this.A);
      }
      this.b = paramQQAppInterface;
      localObject = (MayknowRecommendManager)this.b.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      boolean bool;
      if ((localObject != null) && (((MayknowRecommendManager)localObject).d("sp_mayknow_entry_list_recommend") != this.r.b())) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fillData. tabsChanged:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" mIsResumed:");
        ((StringBuilder)localObject).append(this.t);
        QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
      }
      this.c.removeMessages(6);
      if (bool)
      {
        this.c.sendEmptyMessageDelayed(6, 500L);
      }
      else
      {
        this.s = true;
        d(c(true));
        this.s = false;
      }
      localObject = this.m;
      if (localObject != null) {
        ((ContactsViewPagerAdapter)localObject).a(paramQQAppInterface);
      }
      localObject = this.k;
      if (localObject != null) {
        ((HeaderScrollView)localObject).scrollTo(0, 0);
      }
      this.n.a(paramQQAppInterface);
      b(paramQQAppInterface);
    }
    paramQQAppInterface = this.m;
    if (paramQQAppInterface != null)
    {
      localObject = this.k;
      if (localObject != null) {
        paramQQAppInterface.a(((HeaderScrollView)localObject).getScrollY(), this.k.getMaxY());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.t = true;
    super.a(paramBoolean);
    this.b.setTalkbackSwitch();
    Object localObject = this.h;
    if (localObject != null) {
      ((AbsSlidingIndicator)localObject).setAccessibilityMsg();
    }
    if ((this.m != null) && (this.l != null)) {
      if (!this.g)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ContactsViewController", 2, "mContactsViewPagerAdapter.doOnResume");
        }
        this.m.b(this.l.getCurrentItem(), paramBoolean);
      }
      else
      {
        this.g = false;
      }
    }
    this.n.a(paramBoolean);
    int i1 = this.e;
    if (this.u)
    {
      a(this.v, this.w);
      this.u = false;
    }
    else
    {
      int i2 = c(false);
      if ((i2 != this.e) && (this.b.isBackgroundStop))
      {
        this.s = true;
        d(i2);
        this.s = false;
      }
    }
    localObject = this.m;
    if (localObject != null)
    {
      HeaderScrollView localHeaderScrollView = this.k;
      if (localHeaderScrollView != null) {
        ((ContactsViewPagerAdapter)localObject).a(localHeaderScrollView.getScrollY(), this.k.getMaxY());
      }
    }
    localObject = this.y;
    if (localObject != null) {
      ((BaseContactsMiniAppEntryManager)localObject).setDrawerFrameEvent(FrameControllerUtil.c);
    }
    this.c.removeMessages(8);
    this.c.sendEmptyMessageDelayed(8, 500L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume. oldPos:");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" mCurrentTabPos:");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(" isBackground_Stop:");
      ((StringBuilder)localObject).append(this.b.isBackgroundStop);
      ((StringBuilder)localObject).append(" isBackground_Pause:");
      ((StringBuilder)localObject).append(this.b.isBackgroundPause);
      QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void bT_()
  {
    HeaderScrollView localHeaderScrollView = this.k;
    if ((localHeaderScrollView != null) && (!localHeaderScrollView.a()))
    {
      localHeaderScrollView = this.k;
      localHeaderScrollView.scrollTo(0, localHeaderScrollView.getMaxY());
    }
  }
  
  public void c()
  {
    super.c();
    QQAppInterface localQQAppInterface = this.b;
    if (localQQAppInterface != null) {
      localQQAppInterface.addObserver(this.A);
    }
    this.n.c();
    StudyModeManager.a(this);
  }
  
  public void d()
  {
    super.d();
    Object localObject = this.m;
    if (localObject != null)
    {
      ContactsViewPager localContactsViewPager = this.l;
      if (localContactsViewPager != null) {
        ((ContactsViewPagerAdapter)localObject).h(localContactsViewPager.getCurrentItem());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause. mCurrentTabPos:");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(" isBackground_Stop:");
      ((StringBuilder)localObject).append(this.b.isBackgroundStop);
      ((StringBuilder)localObject).append(" isBackground_Pause:");
      ((StringBuilder)localObject).append(this.b.isBackgroundPause);
      QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
    }
    this.n.d();
    this.t = false;
  }
  
  public void e()
  {
    super.e();
    Object localObject = this.m;
    if (localObject != null) {
      ((ContactsViewPagerAdapter)localObject).b();
    }
    this.n.e();
    localObject = this.b;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.A);
    }
    StudyModeManager.b(this);
  }
  
  public void f()
  {
    super.f();
    ContactsViewPagerAdapter localContactsViewPagerAdapter = this.m;
    if (localContactsViewPagerAdapter != null) {
      localContactsViewPagerAdapter.a();
    }
    this.n.f();
  }
  
  public void g()
  {
    try
    {
      this.h.a(2131431277, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountTitle());
      this.h.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateContactsTabPubAccount error! ");
      localStringBuilder.append(QLog.getStackTraceString(localThrowable));
      QLog.e("ContactsViewController", 2, localStringBuilder.toString());
    }
  }
  
  public void h()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = ((HeaderScrollView)localObject).findViewById(2131439213);
      if ((localObject != null) && (this.k.getScrollY() > ((View)localObject).getTop())) {
        this.k.scrollTo(0, ((View)localObject).getTop());
      }
    }
  }
  
  public void i()
  {
    if (this.m != null)
    {
      ContactsViewPager localContactsViewPager = this.l;
      if (localContactsViewPager != null)
      {
        int i1 = localContactsViewPager.getCurrentItem();
        this.m.e(i1);
        if ((i1 == this.r.b(1)) || (i1 == this.r.b(2)) || (i1 == this.r.b(0))) {
          this.k.scrollTo(0, 0);
        }
      }
    }
    this.z = false;
  }
  
  public void j()
  {
    AbsSlidingIndicator localAbsSlidingIndicator = this.h;
    if (localAbsSlidingIndicator != null) {
      localAbsSlidingIndicator.setCurrentPosition(this.r.b(3), false);
    }
  }
  
  protected void k()
  {
    if (this.h != null)
    {
      boolean bool1 = ThemeUtil.isNowThemeIsDefaultCache(this.b, true);
      int i3 = 25;
      boolean bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      boolean bool3 = QQTheme.isNowSimpleUI();
      int i2 = 2131168002;
      int i4 = 2131168122;
      int i1;
      if (bool3)
      {
        i4 = 2131168060;
        if (bool2) {
          i1 = 2131167341;
        } else {
          i1 = 2131168072;
        }
        i3 = 255;
        i2 = 2131168072;
      }
      else if (bool2)
      {
        i2 = 2131165915;
        i4 = 2131165914;
        i1 = 2131165913;
        i3 = 30;
      }
      else if (!bool1)
      {
        i1 = 2131168002;
      }
      else
      {
        i1 = 2131165916;
        i2 = 2131165916;
      }
      this.h.c(i3);
      this.h.a(i2, i4, i1);
    }
  }
  
  public void l()
  {
    if ((this.l != null) && (ContactsBaseFragment.p == null) && (this.l.getHeight() > 0) && (this.l.getWidth() > 0))
    {
      int[] arrayOfInt = new int[2];
      this.l.getLocationOnScreen(arrayOfInt);
      DisplayMetrics localDisplayMetrics = this.l.getResources().getDisplayMetrics();
      int i1 = (int)(localDisplayMetrics.density * 54.0F);
      ContactsBaseFragment.p = new Rect(arrayOfInt[0], arrayOfInt[1], localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels - i1);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, String.format("init sContentRect:%s, w:%s, h: %s, density: %s", new Object[] { ContactsBaseFragment.p.toString(), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels), Float.valueOf(localDisplayMetrics.density) }));
      }
    }
  }
  
  protected void m()
  {
    FrameLayout localFrameLayout = (FrameLayout)this.p.findViewById(2131439796);
    this.h = SimpleModeHelper.a(this.h, localFrameLayout, this, this.r);
    d(c(false));
  }
  
  public void onChange(boolean paramBoolean)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ContactsViewController.7(this));
      return;
    }
    a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.ContactsViewController
 * JD-Core Version:    0.7.0.1
 */