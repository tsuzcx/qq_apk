package com.tencent.mobileqq.activity.aio.coreui.input;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class FakeInputUI
  implements View.OnClickListener
{
  protected float a;
  public View b;
  RelativeLayout.LayoutParams c;
  public View d;
  RelativeLayout.LayoutParams e;
  private final AIOContext f;
  
  public FakeInputUI(AIOContext paramAIOContext)
  {
    this.f = paramAIOContext;
    this.a = paramAIOContext.a().getApplication().getResources().getDisplayMetrics().density;
  }
  
  public void a()
  {
    View localView = this.d;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.b;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    View localView = this.b;
    if (localView != null) {
      if (paramInt >= 1) {
        localView.setVisibility(8);
      } else {
        localView.setVisibility(0);
      }
    }
    localView = this.d;
    if (localView != null)
    {
      if (paramInt >= 1)
      {
        localView.setVisibility(8);
        return;
      }
      localView.setVisibility(0);
    }
  }
  
  public void b()
  {
    View localView = this.d;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.b;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void c()
  {
    View localView = this.d;
    if (localView != null) {
      localView.setVisibility(4);
    }
    localView = this.b;
    if (localView != null) {
      localView.setVisibility(4);
    }
  }
  
  protected void d()
  {
    if (this.b == null)
    {
      this.b = new View(this.f.b());
      this.c = new RelativeLayout.LayoutParams(-1, (int)(this.a * 15.0F + 0.5F));
      this.c.addRule(3, 2131435809);
      this.b.setId(2131427963);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.f.d(2131430542);
      if (localRelativeLayout != null) {
        localRelativeLayout.addView(this.b, this.c);
      }
    }
    this.b.setVisibility(0);
    this.b.setOnClickListener(this);
    if (AppSetting.e) {
      AccessibilityUtil.a(this.b, false);
    }
  }
  
  protected void e()
  {
    if (this.d == null)
    {
      this.d = new View(this.f.b());
      this.e = new RelativeLayout.LayoutParams(-1, (int)(this.a * 12.0F + 0.5F));
      this.e.addRule(6, 2131435809);
      this.d.setId(2131427964);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.f.d(2131430542);
      if (localRelativeLayout != null) {
        localRelativeLayout.addView(this.d, this.e);
      }
    }
    this.d.setVisibility(0);
    this.d.setOnClickListener(this);
    if (AppSetting.e) {
      AccessibilityUtil.a(this.d, false);
    }
  }
  
  public void f()
  {
    RelativeLayout localRelativeLayout;
    if (this.b != null)
    {
      localRelativeLayout = (RelativeLayout)this.f.d(2131430542);
      if (localRelativeLayout != null) {
        localRelativeLayout.removeView(this.b);
      }
    }
    if (this.d != null)
    {
      localRelativeLayout = (RelativeLayout)this.f.d(2131430542);
      if (localRelativeLayout != null) {
        localRelativeLayout.removeView(this.d);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    this.f.q().a(1, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.FakeInputUI
 * JD-Core Version:    0.7.0.1
 */