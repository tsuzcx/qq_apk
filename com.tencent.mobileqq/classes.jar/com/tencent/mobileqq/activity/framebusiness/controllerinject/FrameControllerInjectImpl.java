package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.QzoneFrameInjectImpl.ABotDragClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.IFrameControllerInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.framejumpentry.TabJumpHelper;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.FrameInitBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.kandian.base.view.api.IKanDianOptUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.tab.api.IRIJTabInject;
import com.tencent.mobileqq.kandian.biz.xtab.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.tab.TabDataUtil;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabWidget;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import cooperation.qzone.api.QZoneApiProxy;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class FrameControllerInjectImpl
  implements IFrameControllerInterface
{
  boolean a = false;
  private boolean b = false;
  
  private FrameInitBean b()
  {
    return new FrameInitBean();
  }
  
  public int a(int paramInt)
  {
    return FrameControllerUtil.a(paramInt);
  }
  
  public int a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = (Conversation)paramFrameFragment.a(Conversation.class);
    if (paramFrameFragment != null) {
      return paramFrameFragment.O;
    }
    return 0;
  }
  
  public void a(TextView paramTextView, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    CustomWidgetUtil.a(paramTextView, paramInt2, paramInt1, paramInt3, paramInt4, paramString);
  }
  
  public void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment)
  {
    if (FrameFragment.m)
    {
      ((MainFragment)paramFrameFragment).e.c();
      FrameFragment.m = false;
      ThreadManager.getUIHandler().postDelayed(new FrameControllerInjectImpl.1(this, paramFrameFragment), 2000L);
    }
    StartupTracker.a("Main_Start", null);
  }
  
  public void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, int paramInt)
  {
    ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).updateKanDianTab(paramFrameFragment, paramInt);
  }
  
  public void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, boolean paramBoolean)
  {
    ReportController.b(null, "dc00898", "", "", "0X800BDFF", "0X800BDFF", 0, 0, "", "", "", "");
    boolean bool1;
    if (TabDataHelper.isOnceFetchFromServer(paramFrameFragment.getContext(), BaseApplicationImpl.getApplication().getRuntime().getCurrentUin())) {
      bool1 = TabDataHelper.isExtendTabShow(paramFrameFragment.getContext(), BaseApplicationImpl.getApplication().getRuntime().getCurrentUin(), "RIJ");
    } else {
      bool1 = QCircleThirdTabConfig.a().c();
    }
    Object localObject2 = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
    Object localObject1 = (MainFragment)paramFrameFragment;
    boolean bool3 = ((IReadInJoyHelper)localObject2).needUpdateKandianFrame(((MainFragment)localObject1).f, bool1);
    boolean bool2;
    if (paramFrameFragment.x != QQTheme.isNowSimpleUI()) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramFrameFragment.x = QQTheme.isNowSimpleUI();
    if (QLog.isDevelopLevel()) {
      QLog.d("FrameControllerInjectImpl", 4, "doSetFrames enter()");
    }
    if (!a((QQAppInterface)paramFrameFragment.A, paramFrameFragment.Y, paramFrameFragment.z, paramBoolean, bool3, bool2, QZoneApiProxy.needShowQzoneFrame(paramFrameFragment.C(), paramFrameFragment.A)))
    {
      TabControlReporter.a(paramFrameFragment.s, paramFrameFragment.v);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("FrameControllerInjectImpl", 4, "doSetFrames enter(), needUpdate!");
    }
    com.tencent.biz.now.NowLiveManager.j = false;
    ((IKanDianOptUtils)QRoute.api(IKanDianOptUtils.class)).updateMainFrameInitStatus(true);
    ((ILebaHelperService)paramFrameFragment.A.getRuntimeService(ILebaHelperService.class, "all")).setFlagUpdateOnPause();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setFrames");
      ((StringBuilder)localObject2).append(((QQAppInterface)paramFrameFragment.A).isCallTabShow);
      QLog.i("FrameControllerInjectImpl", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramFrameFragment.s != null) {
      paramFrameFragment.s.clearAllTabs();
    }
    if (paramFrameFragment.u != null) {
      paramFrameFragment.u.clear();
    }
    if (paramFrameFragment.v != null) {
      paramFrameFragment.v.clear();
    }
    int j = paramFrameFragment.z.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = paramFrameFragment.z[i];
      if (localObject2 != null)
      {
        ((View)localObject2).setSelected(false);
        ((View)localObject2).setId(i + 16);
      }
      i += 1;
    }
    localObject2 = b();
    if (TabDataHelper.isOnceFetchFromServer(paramFrameFragment.getContext(), BaseApplicationImpl.getApplication().getRuntime().getCurrentUin())) {
      bool2 = TabDataHelper.isExtendTabShow(paramFrameFragment.getContext(), BaseApplicationImpl.getApplication().getRuntime().getCurrentUin(), "NEW_WORLD");
    } else {
      bool2 = QCircleConfigHelper.a(((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
    }
    bool3 = ((QQAppInterface)paramFrameFragment.A).isCallTabShow;
    if (bool2) {
      bool1 = false;
    }
    ((FrameInitBean)localObject2).c(bool2).a(bool3).a(-100).d(this.b).b(bool1).e(((IQCircleNativeFrameApi)QRoute.api(IQCircleNativeFrameApi.class)).isNewLayerMode());
    paramTabFrameControllerImpl.initTabIndexByConfig((FrameInitBean)localObject2);
    paramTabFrameControllerImpl.initTabDragIconsAbdTextVuews(paramFrameFragment);
    Object localObject3 = paramFrameFragment.a(Conversation.class);
    if (localObject3 != null) {
      ((Conversation)localObject3).h(true);
    }
    paramFrameFragment.z[1] = null;
    paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.W, Conversation.class, paramFrameFragment.z[0]);
    GuildInjectImpl.a(this.b, paramFrameFragment, paramTabFrameControllerImpl);
    paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.W, Contacts.class, paramFrameFragment.z[2]);
    if (bool1)
    {
      if (paramFrameFragment.z[6] == null) {
        ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).initKanDianTab(paramFrameFragment, (FrameInitBean)localObject2);
      }
      paramFrameFragment.z[6].setId(22);
      localObject3 = (TabDragAnimationView)paramFrameFragment.z[6].findViewById(2131446751);
      TextView localTextView = (TextView)paramFrameFragment.z[6].findViewById(2131448791);
      if ((localTextView != null) && (localObject3 != null))
      {
        ((TabDragAnimationView)localObject3).setOnTouchListener(new FrameFragment.DragViewTouchListener());
        ((TabDragAnimationView)localObject3).setPressChanged(false);
        localTextView.setTextColor(paramFrameFragment.getResources().getColor(2131168263));
        ((TabDragAnimationView)localObject3).a(paramFrameFragment.getResources().getString(2131894176));
        paramFrameFragment.B.put(FrameControllerUtil.g, localObject3);
        paramFrameFragment.C.put(FrameControllerUtil.g, localTextView);
        paramFrameFragment.b(((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).getPreFrameClass(((MainFragment)localObject1).f));
        paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.W, ((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).getTabFrame(), paramFrameFragment.z[6]);
        ((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).updateFrameStatus(((MainFragment)localObject1).f, true);
      }
      ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).updateKanDianTab(paramFrameFragment, 3);
      if (!FrameFragment.m) {
        ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).updateKanDianRedTouch(paramFrameFragment);
      }
      if (paramFrameFragment.F != null)
      {
        localObject1 = paramFrameFragment.F.getExtras();
        if (localObject1 != null)
        {
          i = ((Bundle)localObject1).getInt("tab_index");
          if (i == 2) {
            paramFrameFragment.s.setCurrentTab(i);
          }
        }
        paramFrameFragment.F = null;
      }
    }
    else
    {
      paramFrameFragment.b(((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).getPreFrameClass(((MainFragment)localObject1).f));
      paramFrameFragment.B.remove(FrameControllerUtil.g);
      paramFrameFragment.C.remove(FrameControllerUtil.g);
      ((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).updateFrameStatus(((MainFragment)localObject1).f, false);
    }
    QCircleInjectImpl.a(paramTabFrameControllerImpl, paramFrameFragment, (FrameInitBean)localObject2);
    paramFrameFragment.G.put(FrameControllerUtil.o, paramFrameFragment.z[3]);
    localObject1 = paramFrameFragment.G;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FrameControllerUtil.o);
    ((StringBuilder)localObject2).append("_num");
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.z[3].findViewById(2131449076));
    if (QZoneApiProxy.needShowQzoneFrame(paramFrameFragment.C(), paramFrameFragment.A))
    {
      ((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).showQzoneFrame();
      paramFrameFragment.Y = true;
      paramFrameFragment.B.remove(FrameControllerUtil.d);
      paramFrameFragment.C.remove(FrameControllerUtil.d);
      paramFrameFragment.b(((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass());
      paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.W, QzoneFrame.class, paramFrameFragment.z[7]);
      paramFrameFragment.G.put(FrameControllerUtil.n, paramFrameFragment.z[7]);
      localObject1 = paramFrameFragment.G;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FrameControllerUtil.n);
      ((StringBuilder)localObject2).append("_num");
      ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.z[7].findViewById(2131449076));
      localObject1 = (TabDragAnimationView)paramFrameFragment.z[7].findViewById(2131446751);
      localObject2 = (TextView)paramFrameFragment.z[7].findViewById(2131448791);
      paramFrameFragment.B.put(FrameControllerUtil.i, localObject1);
      paramFrameFragment.C.put(FrameControllerUtil.i, localObject2);
    }
    else
    {
      if (QZoneApiProxy.isQzoneInstalled()) {
        paramFrameFragment.Y = true;
      }
      ((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).showLebaFrame();
      paramFrameFragment.B.remove(FrameControllerUtil.i);
      paramFrameFragment.C.remove(FrameControllerUtil.i);
      paramFrameFragment.b(QzoneFrame.class);
      paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.W, ((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass(), paramFrameFragment.z[3]);
      localObject1 = (TabDragAnimationView)paramFrameFragment.z[3].findViewById(2131446751);
      localObject2 = (TextView)paramFrameFragment.z[3].findViewById(2131448791);
      paramFrameFragment.B.put(FrameControllerUtil.d, localObject1);
      paramFrameFragment.C.put(FrameControllerUtil.d, localObject2);
    }
    TabControlHelper.a().a(paramFrameFragment);
    TabControlReporter.a(paramFrameFragment.s, paramFrameFragment.v);
    ((IKanDianOptUtils)QRoute.api(IKanDianOptUtils.class)).updateMainFrameInitStatus(false);
    paramTabFrameControllerImpl.checkEnableTabAnim(paramFrameFragment, false);
    ((IKanDianOptUtils)QRoute.api(IKanDianOptUtils.class)).reportTabInfo(paramFrameFragment.s);
    if ((paramFrameFragment.v != null) && (paramFrameFragment.v.size() > 5) && (!paramFrameFragment.w))
    {
      QLog.e("FrameControllerInjectImpl", 1, "setFrames num error, setFrames again");
      paramFrameFragment.w = true;
      TabDataUtil.b(false);
      a(paramTabFrameControllerImpl, paramFrameFragment, paramBoolean);
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt)
  {
    ((QQAppInterface)paramFrameFragment.A).playThemeVoice(paramInt + 1);
  }
  
  public void a(FrameFragment paramFrameFragment, Intent paramIntent)
  {
    BBannerHelper.a((QQAppInterface)paramFrameFragment.A, paramIntent);
  }
  
  public void a(FrameFragment paramFrameFragment, Intent paramIntent, Bundle paramBundle, int paramInt)
  {
    TabJumpHelper.a().a(paramFrameFragment, paramIntent, paramBundle, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    FrameHelperActivity.c(paramBoolean);
  }
  
  public boolean a()
  {
    return SplashActivity.currentFragment != 1;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, View[] paramArrayOfView, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    boolean bool1;
    if (TabDataHelper.isOnceFetchFromServer(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin())) {
      bool1 = TabDataHelper.isExtendTabShow(paramQQAppInterface.getApp(), BaseApplicationImpl.getApplication().getRuntime().getCurrentUin(), "NEW_WORLD");
    } else {
      bool1 = QCircleConfigHelper.a(StudyModeManager.h());
    }
    boolean bool3 = QCircleFrame.a;
    boolean bool2 = false;
    int i;
    if (bool3 != bool1) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((QQTheme.isNowSimpleUI()) && (paramBoolean1 != QZoneApiProxy.isQzoneInstalled())) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (this.a != paramBoolean5) {
      k = 1;
    } else {
      k = 0;
    }
    this.a = paramBoolean5;
    if (TabDataHelper.isOnceFetchFromServer(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin())) {
      paramBoolean1 = TabDataHelper.isExtendTabShow(paramQQAppInterface.getApp(), BaseApplicationImpl.getApplication().getRuntime().getCurrentUin(), "GUILD");
    } else {
      paramBoolean1 = ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab();
    }
    this.b = paramBoolean1;
    int m;
    if (GuildInjectImpl.c() != this.b) {
      m = 1;
    } else {
      m = 0;
    }
    if ((!paramBoolean2) && ((!paramQQAppInterface.isCallTabShow) || (paramArrayOfView[1] != null)) && ((paramQQAppInterface.isCallTabShow) || (paramArrayOfView[1] == null)) && (!paramBoolean3) && (!paramBoolean4) && (j == 0) && (i == 0) && (k == 0))
    {
      paramBoolean1 = bool2;
      if (m == 0) {}
    }
    else
    {
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public View[] a(TabFrameControllerImpl paramTabFrameControllerImpl, LayoutInflater paramLayoutInflater)
  {
    boolean bool = FrameControllerUtil.a();
    View[] arrayOfView = new View[8];
    arrayOfView[0] = paramLayoutInflater.inflate(2131625273, null);
    arrayOfView[1] = ((DragFrameLayout)arrayOfView[0].findViewById(2131431325));
    Object localObject1 = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.a);
    int k = -1;
    int i;
    int j;
    if (bool)
    {
      i = -1;
      j = -1;
    }
    else
    {
      i = 2130852755;
      j = 2130852756;
    }
    arrayOfView[2] = paramTabFrameControllerImpl.generateTabItem(i, ((FrameInfoBean)localObject1).e(), j, ((FrameInfoBean)localObject1).f(), ((FrameInfoBean)localObject1).g(), ((FrameInfoBean)localObject1).h(), ((FrameInfoBean)localObject1).i());
    arrayOfView[2].setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
    localObject1 = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.c);
    if (bool)
    {
      i = -1;
      j = -1;
    }
    else
    {
      i = 2130852753;
      j = 2130852754;
    }
    localObject1 = paramTabFrameControllerImpl.generateTabItem(i, ((FrameInfoBean)localObject1).e(), j, ((FrameInfoBean)localObject1).f(), ((FrameInfoBean)localObject1).g(), ((FrameInfoBean)localObject1).h(), ((FrameInfoBean)localObject1).i());
    ((View)localObject1).setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
    arrayOfView[3] = new RedTouchTab(paramLayoutInflater.getContext(), (View)localObject1).c(49).c(3.0F).a(true).d(5).a();
    Object localObject2 = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.d);
    if (bool) {
      i = k;
    } else {
      i = 2130852758;
    }
    localObject1 = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject2).e(), i, ((FrameInfoBean)localObject2).f(), ((FrameInfoBean)localObject2).g(), ((FrameInfoBean)localObject2).h(), ((FrameInfoBean)localObject2).i());
    ((View)localObject1).setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener((View)localObject1, "lebaTab"));
    arrayOfView[4] = new RedTouchTab(paramLayoutInflater.getContext(), (View)localObject1).c(49).c(3.0F).a(true).d(5).a();
    View localView = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject2).e(), i, ((FrameInfoBean)localObject2).f(), ((FrameInfoBean)localObject2).g(), ((FrameInfoBean)localObject2).h(), ((FrameInfoBean)localObject2).i());
    localView.setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener(localView, "lebaTabNew"));
    arrayOfView[5] = new RedTouchTab(paramLayoutInflater.getContext(), localView).c(49).c(3.0F).a(true).d(5).a();
    localObject2 = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject2).e(), i, ((FrameInfoBean)localObject2).f(), ((FrameInfoBean)localObject2).g(), ((FrameInfoBean)localObject2).h(), ((FrameInfoBean)localObject2).i());
    ((View)localObject2).setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener((View)localObject1, "QzoneTab"));
    arrayOfView[6] = new RedTouchTab(paramLayoutInflater.getContext(), (View)localObject2).c(49).c(3.0F).a(true).d(5).a();
    paramTabFrameControllerImpl = GuildInjectImpl.a(paramTabFrameControllerImpl, paramLayoutInflater.getContext(), i);
    arrayOfView[7] = new RedTouchTab(paramLayoutInflater.getContext(), paramTabFrameControllerImpl).c(49).c(3.0F).a(true).d(5).a();
    return arrayOfView;
  }
  
  public View[] a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, View paramView)
  {
    paramFrameFragment.G = new HashMap(9);
    paramFrameFragment.R = new HashMap(13);
    boolean bool = FrameControllerUtil.a();
    Object localObject1 = ((SplashActivity)paramFrameFragment.C()).mPreloadMainViews;
    ((SplashActivity)paramFrameFragment.C()).mPreloadMainViews = null;
    if (localObject1 != null)
    {
      paramFrameFragment.Q = ((DragFrameLayout)localObject1[1]);
      paramFrameFragment.z = new View[] { localObject1[2], null, localObject1[3], localObject1[4], null, localObject1[5], null, localObject1[6], null, null, localObject1[7] };
    }
    else
    {
      paramFrameFragment.Q = ((DragFrameLayout)paramView.findViewById(2131431325));
      localObject1 = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.c);
      int j;
      if (bool)
      {
        i = -1;
        j = -1;
      }
      else
      {
        i = 2130852753;
        j = 2130852753;
      }
      localObject1 = paramTabFrameControllerImpl.generateTabItem(i, ((FrameInfoBean)localObject1).e(), j, ((FrameInfoBean)localObject1).f(), ((FrameInfoBean)localObject1).g(), ((FrameInfoBean)localObject1).h(), ((FrameInfoBean)localObject1).i());
      ((View)localObject1).setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
      Object localObject3 = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.d);
      int i = 2130852758;
      if (bool) {
        i = -1;
      }
      localObject2 = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject3).e(), i, ((FrameInfoBean)localObject3).f(), ((FrameInfoBean)localObject3).g(), ((FrameInfoBean)localObject3).h(), ((FrameInfoBean)localObject3).i());
      ((View)localObject2).setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener((View)localObject2, "lebaTab"));
      View localView1 = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject3).e(), i, ((FrameInfoBean)localObject3).f(), ((FrameInfoBean)localObject3).g(), ((FrameInfoBean)localObject3).h(), ((FrameInfoBean)localObject3).i());
      localView1.setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener(localView1, "qzoneTab"));
      View localView2 = GuildInjectImpl.a(paramTabFrameControllerImpl, paramFrameFragment.C(), i);
      localObject3 = paramTabFrameControllerImpl.generateTabItem(-1, ((FrameInfoBean)localObject3).e(), i, ((FrameInfoBean)localObject3).f(), ((FrameInfoBean)localObject3).g(), ((FrameInfoBean)localObject3).h(), ((FrameInfoBean)localObject3).i());
      ((View)localObject3).setOnClickListener(new QzoneFrameInjectImpl.ABotDragClickListener((View)localObject3, "lebaTabNew"));
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.f);
      View localView3 = paramTabFrameControllerImpl.generateTabItem(2130848287, 2130852568, 2130848288, 2130852569, 2131897952, 15, 5);
      localView3.setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
      FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.a);
      if (bool)
      {
        i = -1;
        j = -1;
      }
      else
      {
        i = 2130852755;
        j = 2130852756;
      }
      paramTabFrameControllerImpl = paramTabFrameControllerImpl.generateTabItem(i, localFrameInfoBean.e(), j, localFrameInfoBean.f(), localFrameInfoBean.g(), localFrameInfoBean.h(), localFrameInfoBean.i());
      paramTabFrameControllerImpl.setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
      paramFrameFragment.z = new View[] { paramTabFrameControllerImpl, null, new RedTouchTab(paramFrameFragment.C(), (View)localObject1).c(49).c(3.0F).a(true).d(5).a(), new RedTouchTab(paramFrameFragment.C(), (View)localObject2).c(49).c(3.0F).a(true).d(5).a(), new RedTouchTab(paramFrameFragment.C(), localView3).c(49).c(3.0F).a(true).d(5).a(), new RedTouchTab(paramFrameFragment.C(), (View)localObject3).c(49).c(3.0F).a(true).d(5).a(), null, new RedTouchTab(paramFrameFragment.C(), localView1).c(49).c(3.0F).a(true).d(5).a(), null, null, new RedTouchTab(paramFrameFragment.C(), localView2).c(49).c(3.0F).a(true).d(5).a() };
    }
    localObject1 = paramFrameFragment.Q;
    paramTabFrameControllerImpl = (MainFragment)paramFrameFragment;
    ((DragFrameLayout)localObject1).setOnDragListener(paramTabFrameControllerImpl.g);
    paramFrameFragment.G.put(FrameControllerUtil.l, paramFrameFragment.z[0]);
    paramFrameFragment.G.put(FrameControllerUtil.m, paramFrameFragment.z[2]);
    paramFrameFragment.G.put(FrameControllerUtil.o, paramFrameFragment.z[3]);
    paramFrameFragment.G.put(FrameControllerUtil.n, paramFrameFragment.z[7]);
    paramFrameFragment.G.put(FrameControllerUtil.s, paramFrameFragment.z[10]);
    localObject1 = paramFrameFragment.G;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FrameControllerUtil.l);
    ((StringBuilder)localObject2).append("_num");
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.z[0].findViewById(2131449076));
    localObject1 = paramFrameFragment.G;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FrameControllerUtil.m);
    ((StringBuilder)localObject2).append("_num");
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.z[2].findViewById(2131449076));
    localObject1 = paramFrameFragment.G;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FrameControllerUtil.o);
    ((StringBuilder)localObject2).append("_num");
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.z[3].findViewById(2131449076));
    localObject1 = paramFrameFragment.G;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FrameControllerUtil.n);
    ((StringBuilder)localObject2).append("_num");
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.z[7].findViewById(2131449076));
    localObject1 = paramFrameFragment.G;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FrameControllerUtil.s);
    ((StringBuilder)localObject2).append("_num");
    ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.z[10].findViewById(2131449076));
    localObject1 = (TabDragAnimationView)paramFrameFragment.z[0].findViewById(2131446751);
    ((TabDragAnimationView)localObject1).setTag(FrameControllerUtil.l);
    ((TabDragAnimationView)localObject1).setOnDragListener(new FrameControllerInjectImpl.2(this, paramFrameFragment));
    ((TabDragAnimationView)localObject1).setOnLongClickListener(new FrameControllerInjectImpl.3(this, paramFrameFragment));
    paramView = (QQTabWidget)paramView.findViewById(16908307);
    if (paramView != null)
    {
      paramView.setShowDividers(0);
      paramView.setTabWidgetMoveListener(paramTabFrameControllerImpl.h);
    }
    else
    {
      QLog.i("FrameControllerInjectImpl", 1, "initTabs tabWidget is null");
    }
    return paramFrameFragment.z;
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    if (!MultiMsgManager.a().b()) {
      MultiMsgManager.a().a((QQAppInterface)paramFrameFragment.A);
    }
  }
  
  public boolean c(FrameFragment paramFrameFragment)
  {
    return ((MainFragment)paramFrameFragment).e == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.FrameControllerInjectImpl
 * JD-Core Version:    0.7.0.1
 */