package com.tencent.biz.pubaccount.weishi_new.combo.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter;
import com.tencent.biz.pubaccount.weishi_new.combo.IWSFragmentFactory;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.WSFrameBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarAdapter;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfo;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfoHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboVerticalVideoProgressManager;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboVerticalVideoProgressManager.Companion;
import com.tencent.biz.pubaccount.weishi_new.combo.main.receiver.WSComboMainForHomePageChangeReceiver;
import com.tencent.biz.pubaccount.weishi_new.combo.main.receiver.WSComboMainForUserAuthReceiver;
import com.tencent.biz.pubaccount.weishi_new.event.WSActivityResultEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.util.WSSystemNavigationBarUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.bottomnav.WSBottomNavigationBar;
import com.tencent.biz.pubaccount.weishi_new.view.bottomnav.WSBottomNavigationBar.BarAdapter;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainFragment;", "Lcom/tencent/biz/pubaccount/weishi_new/WSBaseFragment;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainContract$Presenter;", "()V", "bottomBarAdapter", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarAdapter;", "bottomBarInfoList", "", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "bottomNavigationBar", "Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar;", "comboHomePageChangeReceiver", "Lcom/tencent/biz/pubaccount/weishi_new/combo/main/receiver/WSComboMainForHomePageChangeReceiver;", "pagerFragmentFactory", "Lcom/tencent/biz/pubaccount/weishi_new/combo/IWSFragmentFactory;", "systemBarCompact", "Lcom/tencent/widget/immersive/SystemBarCompact;", "userAuthReceiver", "Lcom/tencent/biz/pubaccount/weishi_new/combo/main/receiver/WSComboMainForUserAuthReceiver;", "videoProgressContainer", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVerticalVideoRelativeLayout;", "viewPager", "Lcom/tencent/biz/pubaccount/weishi_new/view/WSViewPager;", "changeBottomBarColor", "", "offset", "", "createPresenter", "initData", "initEvent", "initView", "rootView", "Landroid/view/View;", "isWrapContent", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onResume", "refreshBarViewOnSelected", "currentBarId", "", "barStyle", "refreshBarViewRedDot", "count", "setSystemNavigationBarStyle", "setupViewPager", "fragments", "Lcom/tencent/mobileqq/app/QBaseFragment;", "switchBottomBarStyle", "switchFragment", "barId", "unRegisterEventReceiver", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public class WSComboMainFragment
  extends WSBaseFragment<WSComboMainContract.View, WSComboMainContract.Presenter>
  implements WSComboMainContract.View
{
  public static final WSComboMainFragment.Companion f = new WSComboMainFragment.Companion(null);
  private WSViewPager g;
  private WSBottomNavigationBar h;
  private WSVerticalVideoRelativeLayout i;
  private SystemBarCompact j;
  private WSBottomBarAdapter k;
  private List<WSBottomBarInfo> l;
  private IWSFragmentFactory m;
  private WSComboMainForHomePageChangeReceiver n;
  private WSComboMainForUserAuthReceiver o;
  
  private final void a(View paramView)
  {
    Object localObject1 = getActivity();
    if (localObject1 != null)
    {
      localObject1 = ((PublicFragmentActivity)localObject1).mSystemBarComp;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(activity as PublicFragm…tActivity).mSystemBarComp");
      this.j = ((SystemBarCompact)localObject1);
      localObject1 = paramView.findViewById(1929707520);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "rootView.findViewById(R.id.bottom_navigation_bar)");
      this.h = ((WSBottomNavigationBar)localObject1);
      this.k = new WSBottomBarAdapter((WSComboMainContract.View)this);
      localObject1 = this.h;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomNavigationBar");
      }
      Object localObject2 = this.k;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomBarAdapter");
      }
      ((WSBottomNavigationBar)localObject1).setAdapter((WSBottomNavigationBar.BarAdapter)localObject2);
      localObject1 = (WSViewPager)paramView.findViewById(1929707620);
      this.g = ((WSViewPager)localObject1);
      localObject2 = (WSComboMainContract.Presenter)aO_();
      List localList = this.l;
      if (localList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomBarInfoList");
      }
      this.m = ((WSComboMainContract.Presenter)localObject2).a(localList);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "wsViewPager");
      localObject2 = this.m;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("pagerFragmentFactory");
      }
      a((WSViewPager)localObject1, (List)((IWSFragmentFactory)localObject2).a(getArguments()));
      paramView = paramView.findViewById(1929707616);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "rootView.findViewById(R.…_play_progress_container)");
      this.i = ((WSVerticalVideoRelativeLayout)paramView);
      paramView = WSComboVerticalVideoProgressManager.a.a();
      localObject1 = this.i;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoProgressContainer");
      }
      paramView.a((WSVerticalVideoRelativeLayout)localObject1);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.activity.PublicFragmentActivity");
  }
  
  private final void a(WSViewPager paramWSViewPager, List<QBaseFragment> paramList)
  {
    paramWSViewPager.setAdapter((PagerAdapter)new WSFragmentAdapter(getChildFragmentManager(), paramList));
    paramWSViewPager.setScrollable(false);
    paramWSViewPager.setCanScrollHorizontally(false);
    paramWSViewPager.setOffscreenPageLimit(((WSComboMainContract.Presenter)aO_()).b());
  }
  
  private final void o()
  {
    Object localObject = new WSComboMainForHomePageChangeReceiver(this);
    WSSimpleEventBus.a().a((WSSimpleEventReceiver)localObject);
    this.n = ((WSComboMainForHomePageChangeReceiver)localObject);
    localObject = new WSComboMainForUserAuthReceiver(this);
    WSSimpleEventBus.a().a((WSSimpleEventReceiver)localObject);
    this.o = ((WSComboMainForUserAuthReceiver)localObject);
  }
  
  private final void p()
  {
    Object localObject1 = this.k;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomBarAdapter");
    }
    Object localObject2 = this.l;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomBarInfoList");
    }
    ((WSBottomBarAdapter)localObject1).a((List)localObject2);
    localObject1 = WSComboExpHelper.a.b();
    localObject2 = WSBottomBarInfoHelper.a;
    List localList = this.l;
    if (localList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomBarInfoList");
    }
    localObject1 = ((WSBottomBarInfoHelper)localObject2).a((String)localObject1, localList);
    if (localObject1 == null)
    {
      localObject1 = this.l;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bottomBarInfoList");
      }
      localObject1 = (WSBottomBarInfo)((List)localObject1).get(0);
    }
    localObject2 = this.k;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomBarAdapter");
    }
    ((WSBottomBarAdapter)localObject2).a((WSBottomBarInfo)localObject1);
    ((WSComboMainContract.Presenter)aO_()).c();
    WSFrameBeaconReport.a();
    ((WSComboMainContract.Presenter)aO_()).d();
  }
  
  private final void q()
  {
    WSSimpleEventBus localWSSimpleEventBus = WSSimpleEventBus.a();
    Object localObject = this.n;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("comboHomePageChangeReceiver");
    }
    localWSSimpleEventBus.b((WSSimpleEventReceiver)localObject);
    localWSSimpleEventBus = WSSimpleEventBus.a();
    localObject = this.o;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("userAuthReceiver");
    }
    localWSSimpleEventBus.b((WSSimpleEventReceiver)localObject);
  }
  
  public void a(float paramFloat)
  {
    WSBottomNavigationBar localWSBottomNavigationBar = this.h;
    if (localWSBottomNavigationBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomNavigationBar");
    }
    localWSBottomNavigationBar.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    WSBottomNavigationBar localWSBottomNavigationBar = this.h;
    if (localWSBottomNavigationBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomNavigationBar");
    }
    localWSBottomNavigationBar.setBottomBarStyle(paramInt);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "barId");
    IWSFragmentFactory localIWSFragmentFactory = this.m;
    if (localIWSFragmentFactory == null) {
      Intrinsics.throwUninitializedPropertyAccessException("pagerFragmentFactory");
    }
    if (localIWSFragmentFactory != null)
    {
      paramString = ((WSMainPagerFragmentFactory)localIWSFragmentFactory).a(paramString);
      if (paramString != null)
      {
        int i1 = ((Number)paramString).intValue();
        paramString = this.g;
        if (paramString != null) {
          paramString.setCurrentItem(i1, false);
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.combo.main.WSMainPagerFragmentFactory");
  }
  
  public void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "currentBarId");
    WSBottomBarAdapter localWSBottomBarAdapter = this.k;
    if (localWSBottomBarAdapter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomBarAdapter");
    }
    localWSBottomBarAdapter.b(paramString, paramInt);
  }
  
  public void b(int paramInt)
  {
    WSSystemNavigationBarUtil.a((Activity)getActivity(), paramInt);
  }
  
  public void b(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "currentBarId");
    WSBottomBarAdapter localWSBottomBarAdapter = this.k;
    if (localWSBottomBarAdapter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomBarAdapter");
    }
    localWSBottomBarAdapter.a(paramString, paramInt);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @NotNull
  public WSComboMainContract.Presenter n()
  {
    return (WSComboMainContract.Presenter)new WSComboMainPresenter();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((WSViewPager)localObject).getAdapter();
      if (localObject != null)
      {
        localObject = (WSFragmentAdapter)localObject;
        int i2 = ((WSFragmentAdapter)localObject).getCount() - 1;
        int i1 = 0;
        if (i2 >= 0) {
          for (;;)
          {
            ((WSFragmentAdapter)localObject).a(i1).onActivityResult(paramInt1, paramInt2, paramIntent);
            if (i1 == i2) {
              break;
            }
            i1 += 1;
          }
        }
        WSSimpleEventBus.a().a((WSSimpleBaseEvent)new WSActivityResultEvent(paramInt1, paramInt2, paramIntent));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter");
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.l = ((WSComboMainContract.Presenter)aO_()).a();
    o();
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(1929773065, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…o_main, container, false)");
    a(paramLayoutInflater);
    p();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    WSComboHelper.a.b();
    q();
    WSComboVerticalVideoProgressManager.a.a().a();
  }
  
  public void onResume()
  {
    super.onResume();
    SystemBarCompact localSystemBarCompact = this.j;
    if (localSystemBarCompact == null) {
      Intrinsics.throwUninitializedPropertyAccessException("systemBarCompact");
    }
    localSystemBarCompact.setStatusBarVisible(2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.main.WSComboMainFragment
 * JD-Core Version:    0.7.0.1
 */