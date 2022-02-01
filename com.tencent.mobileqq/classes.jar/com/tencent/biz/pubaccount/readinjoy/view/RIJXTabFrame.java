package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.RIJXTabViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler.Companion;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.engine.IRIJXTabNormalRedDotConsumer;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotReporter;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotStore;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar.OnBtnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/view/RIJXTabFrame;", "Lcom/tencent/biz/pubaccount/readinjoy/common/RIJTabFrameBase;", "frameFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "(Lcom/tencent/mobileqq/app/FrameFragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "channelBarMask", "Landroid/view/View;", "getChannelBarMask", "()Landroid/view/View;", "setChannelBarMask", "(Landroid/view/View;)V", "channelViewPager", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/ReadInJoyChannelViewPager;", "getChannelViewPager", "()Lcom/tencent/biz/pubaccount/readinjoy/view/widget/ReadInJoyChannelViewPager;", "setChannelViewPager", "(Lcom/tencent/biz/pubaccount/readinjoy/view/widget/ReadInJoyChannelViewPager;)V", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "getFragmentManager", "()Landroid/support/v4/app/FragmentManager;", "setFragmentManager", "(Landroid/support/v4/app/FragmentManager;)V", "getFrameFragment", "()Lcom/tencent/mobileqq/app/FrameFragment;", "setFrameFragment", "immersiveBar", "Lcom/tencent/widget/immersive/ImmersiveTitleBar2;", "getImmersiveBar", "()Lcom/tencent/widget/immersive/ImmersiveTitleBar2;", "setImmersiveBar", "(Lcom/tencent/widget/immersive/ImmersiveTitleBar2;)V", "mObserver", "com/tencent/biz/pubaccount/readinjoy/view/RIJXTabFrame$mObserver$1", "Lcom/tencent/biz/pubaccount/readinjoy/view/RIJXTabFrame$mObserver$1;", "nightView", "getNightView", "setNightView", "pagerAdapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;", "getPagerAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/view/widget/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;", "setPagerAdapter", "(Lcom/tencent/biz/pubaccount/readinjoy/view/widget/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;)V", "redDotConsumer", "com/tencent/biz/pubaccount/readinjoy/view/RIJXTabFrame$redDotConsumer$1", "Lcom/tencent/biz/pubaccount/readinjoy/view/RIJXTabFrame$redDotConsumer$1;", "rootView", "getRootView", "setRootView", "viewPagerController", "Lcom/tencent/biz/pubaccount/readinjoy/RIJXTabViewPagerController;", "getViewPagerController", "()Lcom/tencent/biz/pubaccount/readinjoy/RIJXTabViewPagerController;", "setViewPagerController", "(Lcom/tencent/biz/pubaccount/readinjoy/RIJXTabViewPagerController;)V", "xTabTopBar", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabBar;", "adjustStatusBarStyle", "", "userDark", "", "doOnTabChange", "visible", "fillData", "isSwitchAccount", "getCurrentChannelId", "", "getCurrentFragement", "Lcom/tencent/biz/pubaccount/readinjoy/fragment/ReadInJoyBaseFragment;", "getTitleView", "handleChannelBarMask", "isImmersive", "handlePageSelected", "channelCoverInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/TabChannelCoverInfo;", "handleRedPoint", "handleStatusBar", "initBarMarginTop", "initNightView", "initTopBar", "initUI", "initViewPager", "initViewPagerListener", "needHideRedPoint", "kandianMergeManager", "Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager;", "needHideTabBlur", "onBackPressed", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "onDestroy", "onPostThemeChanged", "onRefreshDeliverBtn", "onResume", "tabChanged", "onTabClickSelf", "switchToChannel", "channelID", "switchToDefaultChannel", "ignoreChannelID", "switchToMainFragmentForLongTime", "updateNightStatus", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame
  extends RIJTabFrameBase
{
  @NotNull
  public FragmentManager a;
  @NotNull
  public View a;
  @NotNull
  public RIJXTabViewPagerController a;
  private final RIJXTabFrame.mObserver.1 jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRIJXTabFrame$mObserver$1;
  private final RIJXTabFrame.redDotConsumer.1 jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRIJXTabFrame$redDotConsumer$1;
  private RIJXTabBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar;
  @NotNull
  public ReadInJoyChannelViewPager.CustomFragmentPagerAdapter a;
  @NotNull
  public ReadInJoyChannelViewPager a;
  @Nullable
  private FrameFragment jdField_a_of_type_ComTencentMobileqqAppFrameFragment;
  @NotNull
  public ImmersiveTitleBar2 a;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @Nullable
  private View b;
  @Nullable
  private View c;
  
  public RIJXTabFrame(@Nullable FrameFragment paramFrameFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment = paramFrameFragment;
    this.jdField_a_of_type_JavaLangString = "RIJXTabFrame";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRIJXTabFrame$mObserver$1 = new RIJXTabFrame.mObserver.1(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRIJXTabFrame$redDotConsumer$1 = new RIJXTabFrame.redDotConsumer.1(this);
  }
  
  private final void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo != null) {
      f(paramTabChannelCoverInfo.isImmersive);
    }
    if (c())
    {
      RIJAppSetting.b((Activity)a(), false);
      return;
    }
    RIJAppSetting.b((Activity)a(), true);
  }
  
  private final void b()
  {
    o();
    q();
    View localView = a(2131379533);
    if (localView == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.widget.immersive.ImmersiveTitleBar2");
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView);
    localView = a(2131364573);
    Intrinsics.checkExpressionValueIsNotNull(localView, "findViewById(R.id.channelBarMask)");
    this.jdField_a_of_type_AndroidViewView = localView;
    m();
  }
  
  private final boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localObject = ((RIJXTabViewPagerController)localObject).a();
    if (localObject != null) {}
    for (int i = ((TabChannelCoverInfo)localObject).mChannelCoverId;; i = 0) {
      switch (i)
      {
      default: 
        return false;
      }
    }
    return true;
  }
  
  private final void f(boolean paramBoolean)
  {
    boolean bool = false;
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("channelBarMask");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      if (!paramBoolean) {
        bool = true;
      }
      g(bool);
      return;
    }
  }
  
  private final void g(boolean paramBoolean)
  {
    try
    {
      Object localObject = a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
      if (!ImmersiveUtils.setStatusTextColor(paramBoolean, ((QBaseActivity)localObject).getWindow()))
      {
        localObject = (Activity)a();
        Frame localFrame = (Frame)this;
        ImmersiveTitleBar2 localImmersiveTitleBar2 = this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
        if (localImmersiveTitleBar2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
        }
        RIJAppSetting.a((Activity)localObject, localFrame, true, localImmersiveTitleBar2, -1);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyTabFrame", 1, "adjustStatusBarStyle exception,msg" + localException);
    }
  }
  
  private final void m()
  {
    View localView = a(2131376602);
    if (localView == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewStub");
    }
    this.c = ((ViewStub)localView).inflate();
    t();
  }
  
  private final void o()
  {
    Object localObject = a(2131364572);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar = ((RIJXTabBar)localObject);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
    }
    ((RIJXTabBar)localObject).setOnBtnClickListener((RIJXTabBar.OnBtnClickListener)new RIJXTabFrame.initTopBar.1(this));
    p();
  }
  
  private final void p()
  {
    int i = RIJXTabFrameUtils.a.a();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
    }
    localObject = ((RIJXTabBar)localObject).getLayoutParams();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    ((RelativeLayout.LayoutParams)localObject).topMargin = i;
  }
  
  private final void q()
  {
    Object localObject1 = a();
    Object localObject2 = a(2131376564);
    if (localObject2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)localObject2);
    if ((localObject1 instanceof SplashActivity))
    {
      localObject1 = ((SplashActivity)localObject1).getSupportFragmentManager();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.supportFragmentManager");
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((FragmentManager)localObject1);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter((FragmentManager)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("channelViewPager");
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
      }
      ((ReadInJoyChannelViewPager)localObject1).setAdapter((PagerAdapter)localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("channelViewPager");
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
      }
      RIJXTabBar localRIJXTabBar = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar;
      if (localRIJXTabBar == null) {
        Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController = new RIJXTabViewPagerController((ReadInJoyChannelViewPager)localObject1, (ReadInJoyChannelViewPager.CustomFragmentPagerAdapter)localObject2, localRIJXTabBar);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
      }
      ((RIJXTabViewPagerController)localObject1).a();
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
      }
      ((RIJXTabViewPagerController)localObject1).b();
      ReadInJoyChannelViewPagerController.a(RIJXTabConfigHandler.a.a().a(), 0);
      s();
      return;
      if ((localObject1 instanceof FragmentActivity))
      {
        localObject1 = ((FragmentActivity)localObject1).getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.supportFragmentManager");
        this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((FragmentManager)localObject1);
      }
    }
  }
  
  private final void s()
  {
    ReadInJoyChannelViewPager localReadInJoyChannelViewPager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
    if (localReadInJoyChannelViewPager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("channelViewPager");
    }
    localReadInJoyChannelViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)new RIJXTabFrame.initViewPagerListener.1(this));
  }
  
  private final void t()
  {
    View localView = this.c;
    if (localView != null) {
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime)) {
        break label27;
      }
    }
    label27:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private final void u() {}
  
  private final void v()
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localObject = ((RIJXTabViewPagerController)localObject).a();
    if (localObject != null) {}
    for (boolean bool1 = ((TabChannelCoverInfo)localObject).isImmersive;; bool1 = false)
    {
      if (!bool1) {
        bool2 = true;
      }
      g(bool2);
      return;
    }
  }
  
  private final void w()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager");
    }
    localObject = (KandianMergeManager)localObject;
    if ((((KandianMergeManager)localObject).e() > 0) || (((KandianMergeManager)localObject).b()))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
      }
      ((RIJXTabViewPagerController)localObject).d();
    }
    while (!RIJXTabNormalRedDotStore.a.a()) {
      return;
    }
    int i = RIJXTabNormalRedDotStore.a.a();
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    ((RIJXTabViewPagerController)localObject).a(i);
  }
  
  public void A_()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.f();
    }
    try
    {
      RIJKanDianTabReport.a(a(), localReadInJoyBaseFragment);
      RIJKanDianTabReport.a(a(), true);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "onTabClickSelf error,msg=" + localException);
    }
  }
  
  public void B_()
  {
    RIJXTabBar localRIJXTabBar = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar;
    if (localRIJXTabBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
    }
    localRIJXTabBar.a();
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localObject = ((RIJXTabViewPagerController)localObject).a();
    if (localObject != null) {
      return ((TabChannelCoverInfo)localObject).mChannelCoverId;
    }
    return -1;
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    this.b = paramLayoutInflater.inflate(2131560340, null);
    paramLayoutInflater = a();
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "activity");
    paramLayoutInflater = new ReadinjoyViewLayer(paramLayoutInflater.getBaseContext());
    paramLayoutInflater.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater.addView(this.b);
    View localView = paramLayoutInflater.findViewById(2131365241);
    Intrinsics.checkExpressionValueIsNotNull(localView, "viewLayer.findViewById(R.id.contactsRoot)");
    paramLayoutInflater.a((View)localView);
    return (View)paramLayoutInflater;
  }
  
  @NotNull
  public final RIJXTabViewPagerController a()
  {
    RIJXTabViewPagerController localRIJXTabViewPagerController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
    if (localRIJXTabViewPagerController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    return localRIJXTabViewPagerController;
  }
  
  @Nullable
  public ReadInJoyBaseFragment a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localObject = ((RIJXTabViewPagerController)localObject).a();
    if ((localObject instanceof ReadInJoyBaseFragment)) {
      return (ReadInJoyBaseFragment)localObject;
    }
    return null;
  }
  
  @Nullable
  public final FrameFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    RIJXTabViewPagerController localRIJXTabViewPagerController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
    if (localRIJXTabViewPagerController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localRIJXTabViewPagerController.a(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    VideoReport.traversePage(this.b);
    Object localObject1;
    if (paramBoolean)
    {
      v();
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
      }
      ((RIJXTabViewPagerController)localObject1).b();
      w();
      u();
      if (c()) {
        RIJAppSetting.b((Activity)a(), false);
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJXTabBar;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
      }
      ((RIJXTabBar)localObject1).b(paramBoolean);
      return;
      localObject1 = (Activity)a();
      Object localObject2 = (Frame)this;
      ImmersiveTitleBar2 localImmersiveTitleBar2 = this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
      if (localImmersiveTitleBar2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
      }
      RIJAppSetting.a((Activity)localObject1, (Frame)localObject2, false, localImmersiveTitleBar2, -1);
      localObject1 = (Activity)a();
      localObject2 = this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
      }
      RIJAppSetting.a((Activity)localObject1, (ImmersiveTitleBar2)localObject2);
      RIJAppSetting.b((Activity)a(), true);
    }
  }
  
  public boolean a(@Nullable KandianMergeManager paramKandianMergeManager)
  {
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    RIJXTabNormalRedDotReporter.b();
  }
  
  public boolean b()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if ((localReadInJoyBaseFragment instanceof ReadInJoyVideoChannelFragment))
    {
      VideoPlayManager localVideoPlayManager = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null))
      {
        VideoUIManager localVideoUIManager = localVideoPlayManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localVideoUIManager, "videoPlayManager.videoUIManager");
        if (localVideoUIManager.a())
        {
          localVideoPlayManager.a().j();
          localVideoPlayManager.a().c();
          return true;
        }
        if (ReadInJoyPatchAdUtils.a(localVideoPlayManager.a())) {
          localVideoPlayManager.a().c();
        }
      }
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localReadInJoyBaseFragment).f())) {
      return true;
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyViolaChannelFragment)) && (((ReadInJoyViolaChannelFragment)localReadInJoyBaseFragment).g())) {
      return true;
    }
    return super.b();
  }
  
  public void c()
  {
    Activity localActivity = (Activity)a();
    Frame localFrame = (Frame)this;
    ImmersiveTitleBar2 localImmersiveTitleBar2 = this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
    if (localImmersiveTitleBar2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
    }
    RIJAppSetting.a(localActivity, localFrame, true, localImmersiveTitleBar2, -1);
    t();
  }
  
  public void e(boolean paramBoolean) {}
  
  public void f()
  {
    super.f();
    b();
    ReadInJoyLogicEngineEventDispatcher.a().a((ReadInJoyObserver)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRIJXTabFrame$mObserver$1);
    RIJXTabNormalRedDotDispatcher.a.a((IRIJXTabNormalRedDotConsumer)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRIJXTabFrame$redDotConsumer$1);
  }
  
  public void k()
  {
    super.k();
    RIJXTabViewPagerController localRIJXTabViewPagerController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRIJXTabViewPagerController;
    if (localRIJXTabViewPagerController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    QBaseActivity localQBaseActivity = a();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "activity");
    localRIJXTabViewPagerController.a((Context)localQBaseActivity);
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRIJXTabFrame$mObserver$1);
    RIJXTabNormalRedDotDispatcher.a.a((IRIJXTabNormalRedDotConsumer)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRIJXTabFrame$redDotConsumer$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RIJXTabFrame
 * JD-Core Version:    0.7.0.1
 */