package com.tencent.biz.pubaccount.weishi_new.combo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter;
import com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherHelper;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.instancestate.WSInstanceStateManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.jump.WSOpenHomeThenVideoManager;
import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerFragment;", "Lcom/tencent/biz/pubaccount/weishi_new/WSBaseFragment;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerContract$Presenter;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "()V", "comboHomePageChangeEventReceiver", "Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboHomePageChangeReceiver;", "comboMainPageChangeEventReceiver", "Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainPageChangeEventReceiver;", "instanceStateManager", "Lcom/tencent/biz/pubaccount/weishi_new/instancestate/WSInstanceStateManager;", "mFragments", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", "mHasPageOperation", "", "openHomeThenVideoManager", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/jump/WSOpenHomeThenVideoManager;", "startTime", "", "systemBarCompact", "Lcom/tencent/widget/immersive/SystemBarCompact;", "viewPager", "Lcom/tencent/biz/pubaccount/weishi_new/view/WSViewPager;", "createPagerFragment", "createPresenter", "exitPublicAccReport", "", "getFragments", "initData", "initEvent", "initView", "rootView", "Landroid/view/View;", "isWrapContent", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onPause", "onResume", "onSaveInstanceState", "outState", "onViewStateRestored", "scrollToLeftFragment", "scrollToRightFragment", "setViewPagerScrollHorizontally", "scrollable", "setupViewPager", "unRegisterEventReceiver", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboMainContainerFragment
  extends WSBaseFragment<WSComboMainContainerContract.View, WSComboMainContainerContract.Presenter>
  implements ViewPager.OnPageChangeListener, WSComboMainContainerContract.View
{
  public static final WSComboMainContainerFragment.Companion f = new WSComboMainContainerFragment.Companion(null);
  private boolean g;
  private WSViewPager h;
  private SystemBarCompact i;
  private WSComboMainPageChangeEventReceiver j;
  private WSComboHomePageChangeReceiver k;
  private List<QBaseFragment> l;
  private final WSInstanceStateManager m = new WSInstanceStateManager();
  private final WSOpenHomeThenVideoManager n = new WSOpenHomeThenVideoManager();
  private long o;
  
  private final void a(View paramView)
  {
    Object localObject = getActivity();
    if (localObject != null)
    {
      localObject = ((PublicFragmentActivity)localObject).mSystemBarComp;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(activity as PublicFragm…tActivity).mSystemBarComp");
      this.i = ((SystemBarCompact)localObject);
      paramView = paramView.findViewById(1929707621);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "rootView.findViewById(R.….vp_combo_main_container)");
      this.h = ((WSViewPager)paramView);
      paramView = this.h;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
      }
      a(paramView);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.activity.PublicFragmentActivity");
  }
  
  private final void a(WSViewPager paramWSViewPager)
  {
    this.l = r();
    paramWSViewPager.setAdapter((PagerAdapter)new WSFragmentAdapter(getChildFragmentManager(), this.l));
    paramWSViewPager.setCurrentItem(0, false);
    b_(false);
    paramWSViewPager.setOffscreenPageLimit(2);
    paramWSViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)this);
  }
  
  private final void p()
  {
    Object localObject = new WSComboMainPageChangeEventReceiver(this);
    WSSimpleEventBus.a().a((WSSimpleEventReceiver)localObject);
    this.j = ((WSComboMainPageChangeEventReceiver)localObject);
    localObject = new WSComboHomePageChangeReceiver(this);
    WSSimpleEventBus.a().a((WSSimpleEventReceiver)localObject);
    this.k = ((WSComboHomePageChangeReceiver)localObject);
  }
  
  private final void q()
  {
    WSComboMainContainerContract.Presenter localPresenter = (WSComboMainContainerContract.Presenter)aO_();
    Context localContext = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localContext, "mContext");
    localPresenter.initGdtManager(localContext);
    ((WSComboMainContainerContract.Presenter)aO_()).reqAioListOperationFeed();
    WSPublisherHelper.a.b();
  }
  
  private final List<QBaseFragment> r()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      localBundle = localBundle.getBundle("key_home_bundle");
    } else {
      localBundle = null;
    }
    if (localBundle != null)
    {
      WSComboMainContainerContract.Presenter localPresenter = (WSComboMainContainerContract.Presenter)aO_();
      if (localPresenter != null) {
        localBundle.putSerializable("page_change_observer", (Serializable)localPresenter);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.main.WSVideoPageChangeObserver");
      }
    }
    return (List)((WSComboMainContainerContract.Presenter)aO_()).createFragmentFactory().a(localBundle);
  }
  
  private final void s()
  {
    WSSimpleEventBus localWSSimpleEventBus = WSSimpleEventBus.a();
    Object localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("comboMainPageChangeEventReceiver");
    }
    localWSSimpleEventBus.b((WSSimpleEventReceiver)localObject);
    localWSSimpleEventBus = WSSimpleEventBus.a();
    localObject = this.k;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("comboHomePageChangeEventReceiver");
    }
    localWSSimpleEventBus.b((WSSimpleEventReceiver)localObject);
  }
  
  private final void t()
  {
    int i1 = WSReportUtils.a(this.g);
    WSPublicAccReport localWSPublicAccReport = WSPublicAccReport.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localWSPublicAccReport, "WSPublicAccReport.getInstance()");
    if (!TextUtils.equals((CharSequence)localWSPublicAccReport.getEnterPublicAccFrom(), (CharSequence)"from_qq_chat"))
    {
      localWSPublicAccReport = WSPublicAccReport.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localWSPublicAccReport, "WSPublicAccReport.getInstance()");
      if (!TextUtils.equals((CharSequence)localWSPublicAccReport.getEnterPublicAccFrom(), (CharSequence)"from_operation_h5")) {
        WSPublicAccReport.getInstance().closePublicAccReport(i1);
      }
    }
    com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.d = 0;
    com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.e = 0;
  }
  
  public void aG_()
  {
    WSViewPager localWSViewPager = this.h;
    if (localWSViewPager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    localWSViewPager.setCurrentItem(1, true);
  }
  
  public void b_(boolean paramBoolean)
  {
    WSViewPager localWSViewPager = this.h;
    if (localWSViewPager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    localWSViewPager.setCanScrollHorizontally(paramBoolean);
    localWSViewPager = this.h;
    if (localWSViewPager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    localWSViewPager.setScrollable(paramBoolean);
  }
  
  @Nullable
  public List<QBaseFragment> c()
  {
    return this.l;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @NotNull
  public WSComboMainContainerContract.Presenter n()
  {
    return (WSComboMainContainerContract.Presenter)new WSComboMainContainerPresenter();
  }
  
  public void o()
  {
    WSViewPager localWSViewPager = this.h;
    if (localWSViewPager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    localWSViewPager.setCurrentItem(0, true);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = c();
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QBaseFragment localQBaseFragment = (QBaseFragment)((Iterator)localObject).next();
        if (localQBaseFragment != null) {
          localQBaseFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    WSViewPager localWSViewPager = this.h;
    if (localWSViewPager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    if (localWSViewPager.getCurrentItem() == 1)
    {
      o();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((WSComboMainContainerContract.Presenter)aO_()).doOnCreate();
    p();
    paramBundle = this.n;
    Context localContext = requireContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "requireContext()");
    paramBundle.a(localContext, getArguments());
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(1929773066, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…tainer, container, false)");
    a(paramLayoutInflater);
    q();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((WSComboMainContainerContract.Presenter)aO_()).doOnDestroy();
    WSViewPager localWSViewPager = this.h;
    if (localWSViewPager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    localWSViewPager.removeOnPageChangeListener((ViewPager.OnPageChangeListener)this);
    s();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((WSComboMainContainerContract.Presenter)aO_()).donOnDestroyView();
    t();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.g = true;
    ((WSComboMainContainerContract.Presenter)aO_()).onRightLeftPageSelected(paramInt);
  }
  
  public void onPause()
  {
    super.onPause();
    PublicAccountEventReport.a(getBaseActivity().app, "2062433139", 1, 4, System.currentTimeMillis() - this.o);
  }
  
  public void onResume()
  {
    super.onResume();
    this.o = System.currentTimeMillis();
    SystemBarCompact localSystemBarCompact = this.i;
    if (localSystemBarCompact == null) {
      Intrinsics.throwUninitializedPropertyAccessException("systemBarCompact");
    }
    localSystemBarCompact.setStatusBarVisible(2, 0);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast((Context)BaseApplicationImpl.getContext(), false, 10);
  }
  
  public void onSaveInstanceState(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    this.m.a(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSComboMainContainerFragment.kt][onSaveInstanceState] outState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSComboMainContainerFragmentLog", localStringBuilder.toString());
  }
  
  public void onViewStateRestored(@Nullable Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSComboMainContainerFragment.kt][onViewStateRestored] savedInstanceState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSComboMainContainerFragmentLog", localStringBuilder.toString());
    this.m.b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.WSComboMainContainerFragment
 * JD-Core Version:    0.7.0.1
 */