package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AbsSlidingIndicator;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.mobileqq.widget.UnderlineIndicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FadeIconImageView;

public class ChatHistoryCommonViewController
  extends ChatHistoryBaseViewController
  implements View.OnClickListener, AbsSlidingIndicator.OnTabListener
{
  ChatHistoryTabs g;
  int h;
  int i = -1;
  public int j = 0;
  AbsSlidingIndicator k;
  QQViewPager l;
  ChatHistoryViewPagerAdapter m;
  TextView n;
  FadeIconImageView o;
  
  public ChatHistoryCommonViewController(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageChange. position:");
      localStringBuilder.append(paramInt);
      QLog.d("Q.history.CommonViewController", 2, localStringBuilder.toString());
    }
    this.m.a(paramInt, this.i);
    this.k.setCurrentPosition(paramInt, true);
    this.h = paramInt;
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onContactTabChange. position:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" fromUserClick:");
      localStringBuilder.append(paramBoolean);
      QLog.i("Q.history.CommonViewController", 2, localStringBuilder.toString());
    }
    this.i = this.l.getCurrentItem();
    this.h = paramInt;
    this.l.setCurrentItem(paramInt, false);
    return 0;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1603: 
      this.n.setVisibility(0);
      this.n.setText(2131887648);
      this.o.setVisibility(8);
      this.j = 2;
      return;
    case 1602: 
      this.n.setVisibility(0);
      this.n.setText(2131886578);
      this.o.setVisibility(8);
      this.j = 1;
      return;
    case 1601: 
      this.n.setVisibility(8);
      this.o.setVisibility(0);
      return;
    }
    this.n.setVisibility(8);
    this.o.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    ChatHistoryBaseFragment localChatHistoryBaseFragment = m();
    if (localChatHistoryBaseFragment != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult, cur Fragment = ");
        localStringBuilder.append(localChatHistoryBaseFragment.getClass().getName());
        QLog.d("Q.history.CommonViewController", 2, localStringBuilder.toString());
      }
      localChatHistoryBaseFragment.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.CommonViewController", 2, "onActivityResult, cur Fragment is null ");
    }
  }
  
  public void a(ChatHistoryBaseFragment paramChatHistoryBaseFragment, boolean paramBoolean)
  {
    if (this.m.a(this.h, false) != paramChatHistoryBaseFragment) {
      return;
    }
    paramChatHistoryBaseFragment = this.n;
    if (paramChatHistoryBaseFragment != null) {
      paramChatHistoryBaseFragment.setEnabled(paramBoolean);
    }
  }
  
  public void c()
  {
    super.c();
    b(2131436180).setOnClickListener(this);
    this.n = ((TextView)b(2131436211));
    this.n.setOnClickListener(this);
    this.n.setVisibility(8);
    this.o = ((FadeIconImageView)b(2131436179));
    this.o.setOnClickListener(this);
    this.o.setVisibility(8);
    this.k = ((SimpleSlidingIndicator)b(2131446094));
    this.l = ((QQViewPager)b(2131430533));
    this.g = new ChatHistoryTabs();
    int[] arrayOfInt1 = k();
    int[] arrayOfInt2 = l();
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null))
    {
      this.g.a(a(), arrayOfInt1, arrayOfInt2);
      this.k.setTabData(this.g.b, arrayOfInt1);
    }
    this.k.setOnTabListener(this);
    this.m = new ChatHistoryViewPagerAdapter(b(), a(), this, this.g, this.c);
    this.l.setAdapter(this.m);
    if (arrayOfInt1 != null) {
      this.l.setOffscreenPageLimit(arrayOfInt1.length);
    }
    this.l.setOnPageChangeListener(new ChatHistoryCommonViewController.1(this));
    o();
    c(0);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchToTabPos mCurrentTabPos:");
      localStringBuilder.append(this.h);
      localStringBuilder.append("  pos:");
      localStringBuilder.append(paramInt);
      QLog.i("Q.history.CommonViewController", 2, localStringBuilder.toString());
    }
    this.h = paramInt;
    this.k.setCurrentPosition(this.h, false);
    this.l.setCurrentItem(this.h, false);
  }
  
  public void d()
  {
    super.d();
    this.m.c(this.l.getCurrentItem());
  }
  
  public void e()
  {
    super.e();
    this.m.d(this.l.getCurrentItem());
  }
  
  public void f()
  {
    super.f();
    this.m.a();
  }
  
  public void g()
  {
    if (this.j == 2)
    {
      this.n.setText(2131886578);
      this.j = 1;
      if (this.d != null) {
        this.d.c();
      }
    }
  }
  
  public int i()
  {
    return this.g.a[this.h];
  }
  
  public void j()
  {
    o();
    p();
  }
  
  protected int[] k()
  {
    return null;
  }
  
  protected int[] l()
  {
    return null;
  }
  
  public ChatHistoryBaseFragment m()
  {
    ChatHistoryViewPagerAdapter localChatHistoryViewPagerAdapter = this.m;
    if (localChatHistoryViewPagerAdapter != null) {
      return localChatHistoryViewPagerAdapter.a(this.h, false);
    }
    return null;
  }
  
  protected void n()
  {
    this.a.finish();
  }
  
  protected void o()
  {
    if (this.k == null) {
      return;
    }
    int i1 = 2131168122;
    boolean bool = QQTheme.isNowSimpleUI();
    int i2 = 2131168072;
    int i3 = 2131165916;
    if (bool)
    {
      i1 = 2131168060;
      i3 = 2131168072;
    }
    else
    {
      i2 = 2131165916;
    }
    this.k.c(255);
    this.k.a(i2, i1, i3);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131436211: 
      int i1 = this.j;
      if (i1 == 1)
      {
        if (this.d != null) {
          this.d.b();
        }
        this.n.setText(2131887648);
        this.j = 2;
      }
      else if (i1 == 2)
      {
        if (this.d != null) {
          this.d.c();
        }
        this.n.setText(2131886578);
        this.j = 1;
      }
      break;
    case 2131436180: 
      n();
      break;
    case 2131436179: 
      if (this.d != null) {
        this.d.a();
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    FrameLayout localFrameLayout = (FrameLayout)this.b.findViewById(2131446095);
    int i1 = localFrameLayout.indexOfChild(this.k);
    localFrameLayout.removeView(this.k);
    if (QQTheme.isNowSimpleUI()) {
      this.k = new UnderlineIndicator(BaseApplication.getContext());
    } else {
      this.k = new SimpleSlidingIndicator(BaseApplication.getContext());
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(56.0F));
    localFrameLayout.addView(this.k, i1, localLayoutParams);
    this.k.setTabData(this.g.b, k());
    this.k.setOnTabListener(this);
    c(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryCommonViewController
 * JD-Core Version:    0.7.0.1
 */