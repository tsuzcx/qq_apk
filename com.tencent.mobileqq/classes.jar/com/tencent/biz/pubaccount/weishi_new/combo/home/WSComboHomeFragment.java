package com.tencent.biz.pubaccount.weishi_new.combo.home;

import UserGrowth.stNewsRedDot;
import UserGrowth.stRedDotRsp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter;
import com.tencent.biz.pubaccount.weishi_new.combo.IWSFragmentFactory;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.WSFrameBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.combo.home.topbar.WSComboHomeTopBarController;
import com.tencent.biz.pubaccount.weishi_new.combo.reddot.WSRedDotDataFetcher.ResponseModel;
import com.tencent.biz.pubaccount.weishi_new.event.WSComboHomePageChangeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.TabContentClickListener;
import com.tencent.biz.pubaccount.weishi_new.view.topnav.WSTopNavigationBar;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeFragment;", "Lcom/tencent/biz/pubaccount/weishi_new/WSBaseFragment;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeContract$Presenter;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/tencent/biz/pubaccount/weishi_new/view/tabLayout/WSTabLayout$TabContentClickListener;", "()V", "comboMainPageChangeReceiver", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeForMainChangeReceiver;", "currentBarId", "", "currentPagerPosition", "", "pageHasDragging", "", "pagerBarIdPositionMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "topBarController", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/topbar/WSComboHomeTopBarController;", "topNavigationBar", "Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/WSTopNavigationBar;", "viewPager", "Lcom/tencent/biz/pubaccount/weishi_new/view/WSViewPager;", "createPagerFragment", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", "bundle", "Landroid/os/Bundle;", "createPresenter", "dispatchScrollStateChangeEvent", "", "state", "getRecommendPageSopName", "handleIntent", "handleOnChangeTabSelected", "position", "handleOnPageSelected", "initBarIdPositionMap", "initData", "initEvent", "initView", "rootView", "Landroid/view/View;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onPageScrollStateChanged", "onPageScrolled", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onTabContentClick", "viewHolder", "Lcom/tencent/biz/pubaccount/weishi_new/view/tabLayout/WSTabItemViewHolder;", "onVisibleToUserChanged", "isVisibleToUser", "invokeInResumeOrPause", "reportFollowRedDot", "newsRedDot", "LUserGrowth/stNewsRedDot;", "setupTopBarController", "setupViewPager", "showRedDotFailureView", "showRedDotSuccessView", "resModel", "Lcom/tencent/biz/pubaccount/weishi_new/combo/reddot/WSRedDotDataFetcher$ResponseModel;", "startPublicAccountDetailActivity", "switchFragmentByBottomBarId", "barId", "unRegisterEventReceiver", "updateFollowRedDotView", "redCount", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboHomeFragment
  extends WSBaseFragment<WSComboHomeContract.View, WSComboHomeContract.Presenter>
  implements ViewPager.OnPageChangeListener, WSComboHomeContract.View, WSTabLayout.TabContentClickListener
{
  public static final WSComboHomeFragment.Companion f = new WSComboHomeFragment.Companion(null);
  private WSTopNavigationBar g;
  private WSViewPager h;
  private WSComboHomeForMainChangeReceiver i;
  private WSComboHomeTopBarController j;
  private HashMap<String, Integer> k = new HashMap();
  private int l = 1;
  private String m = WSComboHelper.a.a();
  private boolean n;
  
  private final List<QBaseFragment> a(Bundle paramBundle)
  {
    return (List)((WSComboHomeContract.Presenter)aO_()).a().a(paramBundle);
  }
  
  private final void a(int paramInt)
  {
    this.l = paramInt;
    ((Map)this.k).put(this.m, Integer.valueOf(paramInt));
    c(paramInt);
    WSSimpleEventBus.a().a((WSSimpleBaseEvent)new WSComboHomePageChangeEvent("onPageSelected", WSComboHelper.a.a(), paramInt));
  }
  
  private final void a(stNewsRedDot paramstNewsRedDot)
  {
    if (paramstNewsRedDot != null) {
      WSPublicAccReport.getInstance().reportAttentionRedDotExposure(paramstNewsRedDot.newsCount, s());
    }
  }
  
  private final void a(View paramView)
  {
    Object localObject = paramView.findViewById(1929707581);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rootView.findViewById(R.id.top_navigation_bar)");
    this.g = ((WSTopNavigationBar)localObject);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topNavigationBar");
    }
    localObject = new WSComboHomeTopBarController((WSTopNavigationBar)localObject, this);
    this.j = ((WSComboHomeTopBarController)localObject);
    a((WSComboHomeTopBarController)localObject);
    paramView = (WSViewPager)paramView.findViewById(1929707622);
    this.h = paramView;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "wsViewPager");
    a(paramView);
    a(this.l);
  }
  
  private final void a(WSComboHomeTopBarController paramWSComboHomeTopBarController)
  {
    paramWSComboHomeTopBarController.a(this.m, 1, (WSTabLayout.TabContentClickListener)this);
    paramWSComboHomeTopBarController.a((View.OnClickListener)new WSComboHomeFragment.setupTopBarController..inlined.apply.lambda.1(this));
    paramWSComboHomeTopBarController.b((View.OnClickListener)new WSComboHomeFragment.setupTopBarController..inlined.apply.lambda.2(this));
  }
  
  private final void a(WSViewPager paramWSViewPager)
  {
    paramWSViewPager.setAdapter((PagerAdapter)new WSFragmentAdapter(getChildFragmentManager(), a(getArguments())));
    paramWSViewPager.setCurrentItem(this.l, false);
    paramWSViewPager.setOffscreenPageLimit(((WSComboHomeContract.Presenter)aO_()).b());
    paramWSViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)this);
  }
  
  private final void b(int paramInt)
  {
    Object localObject = this.h;
    int i1;
    if (localObject != null) {
      i1 = ((WSViewPager)localObject).getCurrentItem();
    } else {
      i1 = 0;
    }
    localObject = WSSimpleEventBus.a();
    WSComboHomePageChangeEvent localWSComboHomePageChangeEvent = new WSComboHomePageChangeEvent("onPageScrollStateChanged", WSComboHelper.a.a(), i1);
    localWSComboHomePageChangeEvent.setScrollState(paramInt);
    ((WSSimpleEventBus)localObject).a((WSSimpleBaseEvent)localWSComboHomePageChangeEvent);
  }
  
  private final void c(int paramInt)
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      ((WSComboHomeTopBarController)localObject).a(WSComboHelper.a.a(), paramInt);
      if (paramInt == 0)
      {
        WeishiUtils.m("focus");
        WSPublicAccReport localWSPublicAccReport = WSPublicAccReport.getInstance();
        localObject = ((WSComboHomeTopBarController)localObject).a();
        if (localObject != null) {
          paramInt = ((WSTabItemViewHolder)localObject).c();
        } else {
          paramInt = 0;
        }
        localWSPublicAccReport.reportAttentionClick(paramInt, s(), this.n);
        d(0);
        return;
      }
      WeishiUtils.m(s());
      WSPublicAccReport.getInstance().reportRecommendClick(this.n);
    }
  }
  
  private final void d(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSComboHomeFragment.java][updateFollowRedDotView] redCount:");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.e("WSComboHomeFragmentLog", ((StringBuilder)localObject).toString());
    localObject = this.j;
    if (localObject != null)
    {
      localObject = ((WSComboHomeTopBarController)localObject).a();
      if (localObject != null) {
        ((WSTabItemViewHolder)localObject).b(paramInt);
      }
    }
  }
  
  private final void o()
  {
    WSComboHomeForMainChangeReceiver localWSComboHomeForMainChangeReceiver = new WSComboHomeForMainChangeReceiver(this);
    WSSimpleEventBus.a().a((WSSimpleEventReceiver)localWSComboHomeForMainChangeReceiver);
    this.i = localWSComboHomeForMainChangeReceiver;
  }
  
  private final void p()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      this.l = localBundle.getInt("key_home_to_index", 1);
    }
  }
  
  private final void q()
  {
    r();
    WSComboHomeContract.Presenter localPresenter = (WSComboHomeContract.Presenter)aO_();
    if (localPresenter != null) {
      localPresenter.c();
    }
  }
  
  private final void r()
  {
    Map localMap = (Map)this.k;
    boolean bool = Intrinsics.areEqual(this.m, "waterfall_tab");
    int i2 = 1;
    if (bool) {
      i1 = this.l;
    } else {
      i1 = 1;
    }
    localMap.put("waterfall_tab", Integer.valueOf(i1));
    localMap = (Map)this.k;
    int i1 = i2;
    if (Intrinsics.areEqual(this.m, "monofeed_tab")) {
      i1 = this.l;
    }
    localMap.put("monofeed_tab", Integer.valueOf(i1));
  }
  
  private final String s()
  {
    if (Intrinsics.areEqual(WSComboHelper.a.a(), "monofeed_tab")) {
      return "monofeed";
    }
    return "feeds";
  }
  
  private final void t()
  {
    WSFrameBeaconReport.a(s());
    WeishiUtils.a((Context)getBaseActivity());
  }
  
  private final void u()
  {
    WSSimpleEventBus localWSSimpleEventBus = WSSimpleEventBus.a();
    WSComboHomeForMainChangeReceiver localWSComboHomeForMainChangeReceiver = this.i;
    if (localWSComboHomeForMainChangeReceiver == null) {
      Intrinsics.throwUninitializedPropertyAccessException("comboMainPageChangeReceiver");
    }
    localWSSimpleEventBus.b((WSSimpleEventReceiver)localWSComboHomeForMainChangeReceiver);
  }
  
  public void a(@NotNull WSRedDotDataFetcher.ResponseModel paramResponseModel)
  {
    Intrinsics.checkParameterIsNotNull(paramResponseModel, "resModel");
    paramResponseModel = paramResponseModel.a().newsReddot;
    if (paramResponseModel != null)
    {
      d(paramResponseModel.newsCount);
      a(paramResponseModel);
    }
  }
  
  public void a(@Nullable WSTabItemViewHolder paramWSTabItemViewHolder)
  {
    if (paramWSTabItemViewHolder != null)
    {
      paramWSTabItemViewHolder = paramWSTabItemViewHolder.b();
      if (paramWSTabItemViewHolder != null)
      {
        this.n = false;
        WSViewPager localWSViewPager = this.h;
        if (localWSViewPager != null) {
          localWSViewPager.setCurrentItem(paramWSTabItemViewHolder.d(), true);
        }
      }
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "barId");
    this.m = paramString;
    paramString = this.h;
    if (paramString != null) {
      paramString.setCurrentItem(1, false);
    }
    onPageSelected(1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (paramBoolean2) {
      return;
    }
    if (!paramBoolean1)
    {
      WSViewPager localWSViewPager = this.h;
      if (localWSViewPager != null) {
        localWSViewPager.setCurrentItem(1);
      }
    }
  }
  
  public void aI_() {}
  
  @NotNull
  public WSComboHomeContract.Presenter n()
  {
    return (WSComboHomeContract.Presenter)new WSComboHomePresenter();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.h;
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
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter");
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    o();
    p();
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(1929773064, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…o_home, container, false)");
    a(paramLayoutInflater);
    q();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    u();
    WSViewPager localWSViewPager = this.h;
    if (localWSViewPager != null) {
      localWSViewPager.removeOnPageChangeListener((ViewPager.OnPageChangeListener)this);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSComboHomeFragment.java][onPageScrollStateChanged] state:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", viewPager.currentItem:");
    Object localObject = this.h;
    if (localObject != null) {
      localObject = Integer.valueOf(((WSViewPager)localObject).getCurrentItem());
    } else {
      localObject = null;
    }
    localStringBuilder.append(localObject);
    WSLog.e("WSComboHomeFragmentLog", localStringBuilder.toString());
    b(paramInt);
    if (paramInt != 1) {
      return;
    }
    this.n = true;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((WSComboHomeTopBarController)localObject).a(WSComboHelper.a.a(), paramFloat);
    }
    localObject = WSSimpleEventBus.a();
    WSComboHomePageChangeEvent localWSComboHomePageChangeEvent = new WSComboHomePageChangeEvent("onPageScrolled", WSComboHelper.a.a(), paramInt1);
    localWSComboHomePageChangeEvent.setOffset(paramFloat);
    ((WSSimpleEventBus)localObject).a((WSSimpleBaseEvent)localWSComboHomePageChangeEvent);
  }
  
  public void onPageSelected(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSComboHomeFragment.java][onPageSelected] position:");
    localStringBuilder.append(paramInt);
    WSLog.e("WSComboHomeFragmentLog", localStringBuilder.toString());
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.WSComboHomeFragment
 * JD-Core Version:    0.7.0.1
 */