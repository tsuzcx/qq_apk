package com.tencent.biz.pubaccount.weishi_new.main;

import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter;
import com.tencent.biz.pubaccount.weishi_new.event.WSActivityResultEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSChangeItemViewVisibilityEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSaveFirstItemLocationCoverEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSDragFrameLayout;
import com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSDragFrameLayout.OnDragListener;
import com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionAnimUtil;
import com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;

public class WSMainContainerFragment
  extends WSBaseFragment<WSMainContract.View, WSMainContract.Presenter>
  implements WSMainContract.View
{
  private WSDragFrameLayout f;
  private WSViewPager g;
  private WSFragmentAdapter h;
  private List<QBaseFragment> i;
  private WSVideoTransitionManager j = new WSVideoTransitionManager();
  private int k;
  private String l;
  private boolean m;
  private boolean n = true;
  private boolean o = false;
  private boolean p = false;
  private RectF q = new RectF();
  private RectF r = new RectF();
  
  private WSDragFrameLayout.OnDragListener A()
  {
    return new WSMainContainerFragment.4(this);
  }
  
  private stSimpleMetaFeed B()
  {
    QBaseFragment localQBaseFragment = (QBaseFragment)this.i.get(0);
    if ((localQBaseFragment instanceof WSVerticalPageContract.View)) {
      return ((WSVerticalPageContract.View)localQBaseFragment).C();
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.g.setCurrentItem(paramInt, true);
  }
  
  private void a(@Nullable Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.o = WSVideoTransitionAnimUtil.a(paramBundle);
    this.p = WSVideoTransitionAnimUtil.b(paramBundle);
    this.q.set(WSVideoTransitionAnimUtil.c(paramBundle));
  }
  
  private void a(View paramView)
  {
    this.g = ((WSViewPager)paramView.findViewById(1929707619));
    this.g.setOffscreenPageLimit(1);
    this.g.setCurrentItem(0);
  }
  
  private void a(@android.support.annotation.NonNull WSDragFrameLayout paramWSDragFrameLayout)
  {
    b(paramWSDragFrameLayout);
    a(paramWSDragFrameLayout, ((WSMainContract.Presenter)this.b).getIntentFeed());
    paramWSDragFrameLayout.getViewTreeObserver().addOnPreDrawListener(new WSMainContainerFragment.1(this, paramWSDragFrameLayout));
    this.j.a(paramWSDragFrameLayout, WSVideoTransitionAnimUtil.b(), this.q, this.r);
  }
  
  private void a(@android.support.annotation.NonNull WSDragFrameLayout paramWSDragFrameLayout, @Nullable stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int i1 = paramWSDragFrameLayout.getMeasuredWidth();
    int i2 = paramWSDragFrameLayout.getMeasuredHeight();
    this.r.set(WSVideoTransitionAnimUtil.a(i1, i2, paramstSimpleMetaFeed));
  }
  
  private void a(@android.support.annotation.NonNull String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendChangeItemViewVisibilityEvent() fallFeedId = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", from = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", isShow = ");
    localStringBuilder.append(paramBoolean);
    WSLog.e("WSVerticalMainFragment", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString1))
    {
      if (this.p) {
        WSSimpleEventBus.a().a(new WSChangeItemViewVisibilityEvent(true, paramBoolean));
      }
      return;
    }
    WSSimpleEventBus.a().a(new WSChangeItemViewVisibilityEvent(paramString1, paramBoolean));
  }
  
  private void b(@android.support.annotation.NonNull WSDragFrameLayout paramWSDragFrameLayout)
  {
    paramWSDragFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(WeishiUIUtil.c(), 1073741824), View.MeasureSpec.makeMeasureSpec(WeishiUIUtil.d(), 1073741824));
  }
  
  private void c(@android.support.annotation.NonNull WSDragFrameLayout paramWSDragFrameLayout)
  {
    f(false);
    paramWSDragFrameLayout.setFeatureEnable(true);
    paramWSDragFrameLayout.setOnDragListener(A());
  }
  
  private boolean v()
  {
    return WSVideoTransitionAnimUtil.a(o());
  }
  
  private boolean w()
  {
    return (this.o) || (this.p);
  }
  
  private void x()
  {
    ((WSMainContract.Presenter)aO_()).handleIntent(getArguments());
  }
  
  private void y()
  {
    this.i = ((WSMainContract.Presenter)aO_()).getFragments(getArguments());
    this.h = new WSFragmentAdapter(getChildFragmentManager(), this.i);
    this.g.setAdapter(this.h);
    this.g.addOnPageChangeListener(new WSMainContainerFragment.2(this));
  }
  
  private boolean z()
  {
    if (this.k != 0)
    {
      s();
      return true;
    }
    WSFragmentAdapter localWSFragmentAdapter = this.h;
    if (localWSFragmentAdapter == null) {
      return false;
    }
    int i1 = 0;
    boolean bool1;
    for (boolean bool2 = false; i1 < localWSFragmentAdapter.getCount(); bool2 = bool1)
    {
      QBaseFragment localQBaseFragment = localWSFragmentAdapter.a(i1);
      bool1 = bool2;
      if ((localQBaseFragment instanceof WSBaseFragment)) {
        if ((!bool2) && (!((WSBaseFragment)localQBaseFragment).onBackEvent())) {
          bool1 = false;
        } else {
          bool1 = true;
        }
      }
      i1 += 1;
    }
    return bool2;
  }
  
  public void e(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void f(boolean paramBoolean)
  {
    WSDragFrameLayout localWSDragFrameLayout = this.f;
    boolean bool = paramBoolean;
    if (localWSDragFrameLayout != null)
    {
      bool = paramBoolean;
      if (localWSDragFrameLayout.a()) {
        bool = false;
      }
    }
    d_(bool);
  }
  
  public void g(boolean paramBoolean)
  {
    this.n = paramBoolean;
    this.f.setEnableDragVertical(paramBoolean);
  }
  
  public void h(boolean paramBoolean)
  {
    this.g.setCanScrollHorizontally(paramBoolean);
    this.g.setScrollable(paramBoolean);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    a(paramActivity);
  }
  
  @android.support.annotation.NonNull
  public WSMainContract.Presenter n()
  {
    String str = t();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalMainFragment.java][createPresenter] from:");
    localStringBuilder.append(str);
    WSLog.d("WSVerticalMainFragment", localStringBuilder.toString());
    return WSMainPresenterFactory.a(str, this);
  }
  
  public Bundle o()
  {
    return getArguments();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    WSFragmentAdapter localWSFragmentAdapter = this.h;
    if ((localWSFragmentAdapter != null) && (localWSFragmentAdapter.a(p()) != null)) {
      this.h.a(p()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    WSSimpleEventBus.a().a(new WSActivityResultEvent(paramInt1, paramInt2, paramIntent));
  }
  
  public boolean onBackEvent()
  {
    boolean bool;
    if ((!z()) && (!super.onBackEvent())) {
      bool = false;
    } else {
      bool = true;
    }
    if (!bool)
    {
      Object localObject = this.f;
      if ((localObject != null) && (((WSDragFrameLayout)localObject).a()))
      {
        localObject = this.q;
        if (this.p)
        {
          WSSimpleEventBus.a().a(new WSSaveFirstItemLocationCoverEvent());
          a(this.f, B());
          localObject = WSVideoTransitionAnimUtil.c();
          this.j.a(this.f, WSVideoTransitionAnimUtil.b(), this.r, (RectF)localObject);
        }
        this.j.a(this.f, this.r, (RectF)localObject, new WSMainContainerFragment.3(this));
        return true;
      }
    }
    return bool;
  }
  
  @Nullable
  public View onCreateView(@androidx.annotation.NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(1929773072, paramViewGroup, false);
    x();
    a(paramLayoutInflater);
    y();
    a(o());
    this.f = ((WSDragFrameLayout)paramLayoutInflater);
    if (w()) {
      c(this.f);
    }
    if (v()) {
      a(this.f);
    }
    return paramLayoutInflater;
  }
  
  public int p()
  {
    return this.k;
  }
  
  public boolean q()
  {
    return this.m;
  }
  
  public void r()
  {
    e(true);
    a(1);
  }
  
  public void s()
  {
    a(0);
  }
  
  public String t()
  {
    if (!TextUtils.isEmpty(this.l)) {
      return this.l;
    }
    if (getArguments() != null) {
      this.l = getArguments().getString("key_from");
    }
    return this.l;
  }
  
  public WSFragmentAdapter u()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSMainContainerFragment
 * JD-Core Version:    0.7.0.1
 */