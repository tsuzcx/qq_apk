package com.tencent.biz.pubaccount.weishi_new;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSPreloadTabEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSSubTabData;
import com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.WSFeedsLinearLayout;
import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSSubTabsHelper;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabInfo;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class WSRecommendFragment
  extends WSBaseFragment
  implements WSSimpleEventReceiver, OnTabSelectedListener
{
  private static final int f = Color.parseColor("#6933CC");
  private WSFeedsLinearLayout g;
  private WSViewPager h;
  private WSTabLayout i;
  private View j;
  private ViewGroup k;
  private WSFragmentAdapter l;
  private List<QBaseFragment> m;
  private List<WSTabInfo> n;
  private String o;
  private boolean p;
  private int q = 0;
  private int r = -1;
  
  public static BaseFragment a(String paramString, boolean paramBoolean)
  {
    WSRecommendFragment localWSRecommendFragment = new WSRecommendFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_context_feed_id", paramString);
    localBundle.putBoolean("key_show_context_feed_musk", paramBoolean);
    localWSRecommendFragment.setArguments(localBundle);
    return localWSRecommendFragment;
  }
  
  private void a(int paramInt)
  {
    this.i.setTabItemSelect(paramInt, f);
    Object localObject = this.m;
    if (localObject != null)
    {
      if (paramInt >= ((List)localObject).size()) {
        return;
      }
      int i1 = this.r;
      this.r = paramInt;
      localObject = b(i1);
      if (localObject != null) {
        ((WSGridPageFragment)localObject).B();
      }
      localObject = b(paramInt);
      if (localObject != null) {
        ((WSGridPageFragment)localObject).A();
      }
      if (paramInt != 0)
      {
        localObject = new WSPreloadTabEvent();
        ((WSPreloadTabEvent)localObject).setPosition(paramInt);
        WSSimpleEventBus.a().a((WSSimpleBaseEvent)localObject);
      }
      WSTabBeaconReport.a(paramInt, ((WSTabInfo)this.n.get(paramInt)).a());
    }
  }
  
  private void a(WSSubTabData paramWSSubTabData)
  {
    this.g.getViewTreeObserver().addOnGlobalLayoutListener(new WSRecommendFragment.3(this, paramWSSubTabData));
  }
  
  private void a(List<WSTabInfo> paramList)
  {
    this.l = new WSFragmentAdapter(getChildFragmentManager(), b(paramList));
    this.h.setAdapter(this.l);
    this.h.setOffscreenPageLimit(5);
    this.h.addOnPageChangeListener(new WSRecommendFragment.2(this));
    this.r = 0;
  }
  
  @Nullable
  private WSGridPageFragment b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.m.size())) {
      return (WSGridPageFragment)this.m.get(paramInt);
    }
    return null;
  }
  
  private List<QBaseFragment> b(List<WSTabInfo> paramList)
  {
    this.m = new ArrayList();
    if (paramList.size() == 0)
    {
      this.m.add(WSGridPageFragment.a("1000", true, true, this.o, this.p));
      return this.m;
    }
    int i1 = 0;
    while (i1 < paramList.size())
    {
      WSTabInfo localWSTabInfo = (WSTabInfo)paramList.get(i1);
      boolean bool;
      if (i1 != 0) {
        bool = false;
      } else {
        bool = true;
      }
      String str;
      if (TextUtils.equals("1000", localWSTabInfo.a())) {
        str = this.o;
      } else {
        str = "";
      }
      this.m.add(WSGridPageFragment.a(localWSTabInfo.a(), true, bool, str, this.p));
      i1 += 1;
    }
    return this.m;
  }
  
  private void o()
  {
    this.i = ((WSTabLayout)this.g.findViewById(2131450286));
    this.h = ((WSViewPager)this.g.findViewById(2131450304));
    this.j = this.g.findViewById(2131449831);
    p();
    q();
    r();
  }
  
  private void p()
  {
    if (this.e) {
      this.g.setBackgroundColor(-16777216);
    } else {
      this.g.setBackgroundColor(-1);
    }
    this.g.setOnActionListener(new WSOnActionListenerImpl(this, this.i));
  }
  
  private void q()
  {
    WSSubTabData localWSSubTabData = WSSubTabsHelper.a(WSExpABTestManager.a().n());
    this.n = WSSubTabsHelper.a(localWSSubTabData);
    a(this.n);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    this.j.setLayoutParams(localLayoutParams);
    if (this.n.size() == 0)
    {
      this.i.setVisibility(8);
      return;
    }
    this.i.setVisibility(0);
    this.i.setupWithViewPager(this.h);
    this.i.a(this.n, new WSRecommendFragment.1(this));
    this.i.setTabItemSelect(0, f);
    a(localWSSubTabData);
  }
  
  private void r()
  {
    WSSimpleEventBus.a().a(this);
  }
  
  public void A()
  {
    WSLog.b("WSRecommendFragment", "[WSRecommendFragment.java][onTabSelected]");
    WSGridPageFragment localWSGridPageFragment = b(this.r);
    if (localWSGridPageFragment != null) {
      localWSGridPageFragment.A();
    }
  }
  
  public void B()
  {
    WSLog.b("WSRecommendFragment", "[WSRecommendFragment.java][onTabUnselected]");
    WSGridPageFragment localWSGridPageFragment = b(this.r);
    if (localWSGridPageFragment != null) {
      localWSGridPageFragment.B();
    }
  }
  
  @NonNull
  public IWSPresenter a()
  {
    return new WSBasePresenter();
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (!(paramWSSimpleBaseEvent instanceof WSPreloadTabEvent)) {
      return;
    }
    int i2 = ((WSPreloadTabEvent)paramWSSimpleBaseEvent).getPosition();
    int i1 = i2;
    if (i2 == -1) {
      i1 = this.h.getCurrentItem();
    }
    i1 += 1;
    if (i1 >= this.m.size()) {
      return;
    }
    ((WSGridPageFragment)this.m.get(i1)).q();
  }
  
  protected boolean aN_()
  {
    if (WSComboExpHelper.a.a()) {
      return false;
    }
    return super.aN_();
  }
  
  public void e(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSRecommendFragment.java][setCurrentViewPagerCanScroll] canScroll:");
    localStringBuilder.append(paramBoolean);
    WSLog.d("WSRecommendFragment", localStringBuilder.toString());
    this.h.setCanScrollHorizontally(paramBoolean);
    this.h.setScrollable(paramBoolean);
  }
  
  public int n()
  {
    return this.q;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null)
    {
      this.o = getArguments().getString("key_context_feed_id");
      this.p = getArguments().getBoolean("key_show_context_feed_musk");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.k = paramViewGroup;
    this.g = ((WSFeedsLinearLayout)paramLayoutInflater.inflate(2131626060, paramViewGroup, false));
    return this.g;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    WSSimpleEventBus.a().b(this);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    o();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (!isResumed()) {
      return;
    }
    if (paramBoolean)
    {
      A();
      return;
    }
    B();
  }
  
  public ArrayList<Class> z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSPreloadTabEvent.class);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment
 * JD-Core Version:    0.7.0.1
 */