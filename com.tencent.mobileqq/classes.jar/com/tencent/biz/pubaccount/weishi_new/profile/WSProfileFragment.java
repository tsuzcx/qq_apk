package com.tencent.biz.pubaccount.weishi_new.profile;

import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.profile.data.WSProfileHomePageData;
import com.tencent.biz.pubaccount.weishi_new.profile.header.AbsWSHeaderPresenter;
import com.tencent.biz.pubaccount.weishi_new.profile.header.WSGuestPresenter;
import com.tencent.biz.pubaccount.weishi_new.profile.header.WSHostPresenter;
import com.tencent.biz.pubaccount.weishi_new.profile.header.WSProfileHeaderView;
import com.tencent.biz.pubaccount.weishi_new.profile.presenter.WSProfilePresenterFactory;
import com.tencent.biz.pubaccount.weishi_new.profile.toolbar.WSProfileToolbarController;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener;
import com.tencent.biz.pubaccount.weishi_new.ui.WSBehaviorSuite.HeaderBehavior;
import com.tencent.biz.pubaccount.weishi_new.ui.WSBehaviorSuite.OnViewTranslateListener;
import com.tencent.biz.pubaccount.weishi_new.ui.WSBehaviorSuite.ScrollingViewBehavior;
import com.tencent.biz.pubaccount.weishi_new.ui.dialog.WSCancelFollowConfirmDialog;
import com.tencent.biz.pubaccount.weishi_new.util.WSRedDotUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSTextFormatter;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout.OnInterceptTouchEventListener;
import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabInfo;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WSProfileFragment
  extends WSBaseFragment<WSProfileContract.View, WSProfileContract.Presenter>
  implements SwipeRefreshLayout.OnRefreshListener, WSSimpleEventReceiver, WSProfileContract.View
{
  private WSSwipeRefreshLayout f;
  private View g;
  private WSTabLayout h;
  private WSTabItemViewHolder i;
  private WSTabItemViewHolder j;
  private WSProfileHeaderView k;
  private AbsWSHeaderPresenter l;
  private WSHostPresenter m;
  private WSGuestPresenter n;
  private WSViewPager o;
  private WSCancelFollowConfirmDialog p;
  private List<QBaseFragment> q;
  private WSProfileToolbarController r;
  private String s;
  private boolean t;
  private boolean u;
  private boolean v;
  
  private void A()
  {
    this.o.addOnPageChangeListener(new WSProfileFragment.6(this));
    this.q = new ArrayList();
    this.q.add(WSProfileWorksFragment.b(1, c()));
    this.q.add(WSProfileWorksFragment.b(2, c()));
    WSFragmentAdapter localWSFragmentAdapter = new WSFragmentAdapter(getChildFragmentManager(), this.q);
    this.o.setAdapter(localWSFragmentAdapter);
    this.o.setCanScrollHorizontally(true);
    this.o.setScrollable(true);
    if (((WSProfileContract.Presenter)this.b).j()) {
      aP_();
    }
  }
  
  private Drawable B()
  {
    Drawable localDrawable = getResources().getDrawable(1929642004);
    localDrawable.setBounds(0, 0, WeishiUIUtil.j, WeishiUIUtil.j);
    return localDrawable;
  }
  
  private void C()
  {
    WSProfileContract.Presenter localPresenter = (WSProfileContract.Presenter)aO_();
    if (localPresenter != null)
    {
      Object localObject = localPresenter.e();
      if (localObject != null)
      {
        stSimpleMetaPerson localstSimpleMetaPerson = localPresenter.c();
        if (localstSimpleMetaPerson == null) {
          return;
        }
        WSShareParam localWSShareParam = new WSShareParam();
        localWSShareParam.a = a(localstSimpleMetaPerson, (stShareInfo)localObject);
        localWSShareParam.b = 3;
        if (localPresenter.f()) {
          localObject = "homepage_main";
        } else {
          localObject = "homepage_guest";
        }
        localWSShareParam.d = ((String)localObject);
        localWSShareParam.f = "share";
        localWSShareParam.h = false;
        localObject = new HashMap();
        ((Map)localObject).put("homepage_from", WSProfileBeaconReport.c(((WSProfileContract.Presenter)this.b).g()));
        localWSShareParam.g = ((Map)localObject);
        WeishiShareUtil.a(this.a, localWSShareParam);
        WSProfileBeaconReport.d(localPresenter.g(), localPresenter.d());
      }
    }
  }
  
  private void D()
  {
    WeishiUtils.a(requireContext());
    WSProfileBeaconReport.a(((WSProfileContract.Presenter)this.b).d());
  }
  
  private void E()
  {
    if (TextUtils.isEmpty(this.s)) {
      this.s = WSRedDotUtil.a();
    }
    WeishiActivityHelper.a(requireContext(), this.s);
    WSProfileBeaconReport.e(((WSProfileContract.Presenter)this.b).g(), ((WSProfileContract.Presenter)this.b).d());
  }
  
  private void F()
  {
    this.o.setCurrentItem(0);
    a(new WSProfileFragment.10(this));
  }
  
  private void G()
  {
    a(new WSProfileFragment.11(this));
  }
  
  private void H()
  {
    ((WSBehaviorSuite.HeaderBehavior)((CoordinatorLayout.LayoutParams)this.g.getLayoutParams()).getBehavior()).a((LinearLayout)this.g);
  }
  
  private stSimpleMetaFeed a(@NonNull stSimpleMetaPerson paramstSimpleMetaPerson, @NonNull stShareInfo paramstShareInfo)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
    localstSimpleMetaFeed.share_info = paramstShareInfo;
    localstSimpleMetaFeed.poster = paramstSimpleMetaPerson;
    localstSimpleMetaFeed.poster_id = paramstSimpleMetaPerson.id;
    return localstSimpleMetaFeed;
  }
  
  @NonNull
  public static WSProfileFragment a(@Nullable Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramBundle = new WSProfileFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  public static void a(@NonNull Context paramContext, @Nullable stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_person", paramstSimpleMetaPerson);
    localIntent.putExtra("from", "click_avatar");
    localIntent.putExtra("page_type", 2);
    PublicFragmentActivity.a(paramContext, localIntent, WSProfileFragment.class);
  }
  
  public static void a(@NonNull Context paramContext, @Nullable String paramString1, @NonNull String paramString2)
  {
    Intent localIntent = new Intent();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localIntent.putExtra("key_pid", str);
    localIntent.putExtra("from", paramString2);
    localIntent.putExtra("page_type", 2);
    PublicFragmentActivity.a(paramContext, localIntent, WSProfileFragment.class);
  }
  
  private void a(View paramView)
  {
    paramView = paramView.findViewById(1929707618);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
    paramView.setVisibility(8);
  }
  
  private void a(@NonNull TextView paramTextView)
  {
    paramTextView.getLayoutParams().width = -2;
    paramTextView.setHorizontallyScrolling(false);
  }
  
  private void a(WSProfileFragment.IWSWorksFragmentTask paramIWSWorksFragmentTask)
  {
    int i1 = 0;
    while (i1 < this.q.size())
    {
      QBaseFragment localQBaseFragment = (QBaseFragment)this.q.get(i1);
      if ((localQBaseFragment instanceof WSProfileWorksFragment)) {
        paramIWSWorksFragmentTask.a((WSProfileWorksFragment)localQBaseFragment);
      }
      i1 += 1;
    }
  }
  
  private int b(@Nullable Bundle paramBundle)
  {
    if (paramBundle == null) {
      return 2;
    }
    return paramBundle.getInt("page_type", 2);
  }
  
  private void b(View paramView)
  {
    this.k = ((WSProfileHeaderView)paramView.findViewById(1929707563));
    this.h = ((WSTabLayout)paramView.findViewById(1929707578));
    this.o = ((WSViewPager)paramView.findViewById(1929707623));
    this.g = paramView.findViewById(1929707555);
    this.f = ((WSSwipeRefreshLayout)paramView.findViewById(1929707576));
  }
  
  private void c(View paramView)
  {
    this.r = new WSProfileToolbarController(paramView);
    this.r.a(((WSProfileContract.Presenter)this.b).h());
    this.r.b(((WSProfileContract.Presenter)this.b).i());
    this.r.a(new WSProfileFragment.2(this));
  }
  
  private void e(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.q.size())
    {
      Object localObject = (QBaseFragment)this.q.get(i1);
      if ((localObject instanceof OnTabSelectedListener))
      {
        localObject = (OnTabSelectedListener)localObject;
        if (paramInt == i1) {
          ((OnTabSelectedListener)localObject).A();
        } else {
          ((OnTabSelectedListener)localObject).B();
        }
      }
      i1 += 1;
    }
  }
  
  private AbsWSHeaderPresenter f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.m == null) {
        this.m = new WSHostPresenter(requireContext(), this);
      }
      return this.m;
    }
    if (this.n == null) {
      this.n = new WSGuestPresenter(requireContext(), this);
    }
    return this.n;
  }
  
  private boolean p()
  {
    return (this.d) && (this.v);
  }
  
  private void q()
  {
    this.k.setPresenter(f(false));
  }
  
  private void t()
  {
    int i1 = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
    int i2 = WeishiUIUtil.e;
    this.f.setProgressViewOffset(true, 0, i1 + i2);
    this.f.setOnInterceptTouchEventListener(v());
    this.f.setOnRefreshListener(this);
  }
  
  private WSSwipeRefreshLayout.OnInterceptTouchEventListener v()
  {
    return new WSProfileFragment.1(this);
  }
  
  private void w()
  {
    this.r.b();
    int i1 = this.r.c();
    Object localObject = new WSBehaviorSuite.HeaderBehavior();
    ((WSBehaviorSuite.HeaderBehavior)localObject).a(i1);
    ((WSBehaviorSuite.HeaderBehavior)localObject).a(x());
    ((CoordinatorLayout.LayoutParams)this.g.getLayoutParams()).setBehavior((CoordinatorLayout.Behavior)localObject);
    localObject = new WSBehaviorSuite.ScrollingViewBehavior();
    ((WSBehaviorSuite.ScrollingViewBehavior)localObject).a(i1);
    ((CoordinatorLayout.LayoutParams)this.o.getLayoutParams()).setBehavior((CoordinatorLayout.Behavior)localObject);
  }
  
  private WSBehaviorSuite.OnViewTranslateListener x()
  {
    return new WSProfileFragment.3(this);
  }
  
  private void y()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new WSTabInfo("作品").a(true).a(16));
    localArrayList.add(new WSTabInfo("赞").a(true).a(16));
    this.h.a(localArrayList, new WSProfileFragment.4(this));
    this.i = ((WSTabItemViewHolder)this.h.b(0).a());
    this.j = ((WSTabItemViewHolder)this.h.b(1).a());
    a(this.i.d());
    a(this.j.d());
    this.i.b(0.1F);
    this.j.b(1.0F);
  }
  
  public void a(int paramInt)
  {
    WSProfileHeaderView localWSProfileHeaderView = this.k;
    if (localWSProfileHeaderView == null) {
      return;
    }
    localWSProfileHeaderView.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = this.i;
    if ((localObject1 != null) && (this.j != null) && (((WSTabItemViewHolder)localObject1).d() != null))
    {
      if (this.j.d() == null) {
        return;
      }
      localObject1 = this.i.d();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("作品 ");
      ((StringBuilder)localObject2).append(WSTextFormatter.a(paramInt1));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      TextView localTextView = this.j.d();
      if ((!((WSProfileContract.Presenter)this.b).f()) && (!paramBoolean))
      {
        localObject1 = "赞";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("赞 ");
        ((StringBuilder)localObject1).append(WSTextFormatter.a(paramInt2));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (paramBoolean) {
        localObject2 = null;
      } else {
        localObject2 = B();
      }
      localTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
      localTextView.setCompoundDrawablePadding(WeishiUIUtil.f);
      localTextView.setText((CharSequence)localObject1);
      if (this.q.size() > 0)
      {
        ((WSProfileWorksFragment)this.q.get(0)).a(paramInt1);
        ((WSProfileWorksFragment)this.q.get(0)).e(true);
      }
      if (this.q.size() > 1)
      {
        ((WSProfileWorksFragment)this.q.get(1)).a(paramInt2);
        ((WSProfileWorksFragment)this.q.get(1)).e(paramBoolean);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    ToastUtil.a().a(paramString);
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson, String paramString)
  {
    ((WSProfileContract.Presenter)this.b).a(paramstSimpleMetaPerson, paramString);
  }
  
  public void a(@NonNull stSimpleMetaPerson paramstSimpleMetaPerson, boolean paramBoolean)
  {
    if (this.k == null) {
      return;
    }
    this.l = f(paramBoolean);
    this.k.setPresenter(this.l);
    this.k.setData(paramstSimpleMetaPerson);
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((WSProfileContract.Presenter)this.b).a(paramWSSimpleBaseEvent);
  }
  
  public void a(WSProfileHomePageData paramWSProfileHomePageData) {}
  
  public void a(@NonNull String paramString)
  {
    this.r.a(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    List localList = this.q;
    if (localList != null)
    {
      if (localList.size() == 0) {
        return;
      }
      ((WSProfileWorksFragment)this.q.get(0)).a(paramString, paramBoolean);
    }
  }
  
  public void aP_()
  {
    WSProfileWorksFragment localWSProfileWorksFragment = (WSProfileWorksFragment)this.q.get(0);
    if (localWSProfileWorksFragment.getView() != null)
    {
      localWSProfileWorksFragment.A();
      return;
    }
    this.o.post(new WSProfileFragment.5(this, localWSProfileWorksFragment));
  }
  
  public void aQ_()
  {
    a(this.r.a());
  }
  
  public void b()
  {
    if (this.p == null)
    {
      this.p = new WSCancelFollowConfirmDialog(requireContext());
      this.p.a(new WSProfileFragment.7(this));
    }
    if (this.p.isShowing()) {
      return;
    }
    this.p.show();
  }
  
  public void b(int paramInt)
  {
    WSProfileHeaderView localWSProfileHeaderView = this.k;
    if (localWSProfileHeaderView == null) {
      return;
    }
    localWSProfileHeaderView.b(paramInt);
  }
  
  public void b(String paramString)
  {
    a(new WSProfileFragment.8(this, paramString));
  }
  
  public String c()
  {
    return ((WSProfileContract.Presenter)this.b).g();
  }
  
  public void c(int paramInt)
  {
    WSProfileHeaderView localWSProfileHeaderView = this.k;
    if (localWSProfileHeaderView == null) {
      return;
    }
    localWSProfileHeaderView.c(paramInt);
  }
  
  public void c(String paramString)
  {
    a(new WSProfileFragment.9(this, paramString));
  }
  
  public void d()
  {
    this.k.a();
    this.r.a(null);
    this.f.setRefreshing(false);
    a(0, 0, true);
    H();
    F();
  }
  
  public void d(int paramInt)
  {
    WSProfileHeaderView localWSProfileHeaderView = this.k;
    if (localWSProfileHeaderView == null) {
      return;
    }
    localWSProfileHeaderView.d(paramInt);
  }
  
  public void e()
  {
    this.r.a(((WSProfileContract.Presenter)this.b).h());
  }
  
  public void e(boolean paramBoolean)
  {
    this.u = true;
    ((WSProfileContract.Presenter)this.b).a(paramBoolean);
    ((WSProfileWorksFragment)this.q.get(0)).A();
    a(this.r.a());
    WSProfileBeaconReport.a(((WSProfileContract.Presenter)this.b).g(), ((WSProfileContract.Presenter)this.b).d());
  }
  
  public void n()
  {
    this.u = false;
    a(false);
    WSProfileBeaconReport.b(((WSProfileContract.Presenter)this.b).g(), ((WSProfileContract.Presenter)this.b).d());
  }
  
  @NonNull
  public WSProfileContract.Presenter o()
  {
    return WSProfilePresenterFactory.a().a(b(getArguments()));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    WSSimpleEventBus.a().a(this);
    ((WSProfileContract.Presenter)this.b).a(getArguments());
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(1929773069, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    WSSimpleEventBus.a().b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.u) {
      WSProfileBeaconReport.b(((WSProfileContract.Presenter)this.b).g(), ((WSProfileContract.Presenter)this.b).d());
    }
  }
  
  public void onRefresh()
  {
    ((WSProfileContract.Presenter)this.b).a();
    G();
  }
  
  public void onResume()
  {
    super.onResume();
    aZ_();
    if (this.u) {
      WSProfileBeaconReport.a(((WSProfileContract.Presenter)this.b).g(), ((WSProfileContract.Presenter)this.b).d());
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.v = true;
    b(paramView);
    c(paramView);
    y();
    q();
    w();
    A();
    t();
    a(paramView);
    if (((WSProfileContract.Presenter)this.b).k()) {
      setUserVisibleHint(true);
    }
    ((WSProfileContract.Presenter)this.b).b(p());
  }
  
  public void r() {}
  
  public void s() {}
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (!this.v) {
      return;
    }
    this.u = p();
    ((WSProfileContract.Presenter)this.b).b(p());
  }
  
  public void u()
  {
    WSSwipeRefreshLayout localWSSwipeRefreshLayout = this.f;
    if (localWSSwipeRefreshLayout == null) {
      return;
    }
    localWSSwipeRefreshLayout.setRefreshing(false);
  }
  
  public ArrayList<Class> z()
  {
    return ((WSProfileContract.Presenter)this.b).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment
 * JD-Core Version:    0.7.0.1
 */