package com.tencent.biz.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.OverScrollViewListener;

public class RefreshView
  extends CustomScrollView
{
  public IPullRefreshHeader c;
  int d;
  private RefreshView.OnRefreshListener e;
  private int f = 0;
  private boolean g = false;
  private final int h = 0;
  private volatile boolean i = true;
  private Handler j = new RefreshView.1(this);
  private OverScrollViewListener k = new RefreshView.2(this);
  
  public RefreshView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @SuppressLint({"InflateParams"})
  private void a(Context paramContext)
  {
    this.c = ((PullRefreshHeader)LayoutInflater.from(paramContext).inflate(2131625671, null));
    addView(this.c.getHeaderView(), 0);
    e();
  }
  
  private void e()
  {
    float f1 = getResources().getDisplayMetrics().density;
    this.c.getHeaderView().setMinimumHeight((int)(f1 * 60.0F));
    this.c.getHeaderView().setVisibility(8);
  }
  
  private void f()
  {
    RefreshView.OnRefreshListener localOnRefreshListener = this.e;
    if (localOnRefreshListener != null)
    {
      localOnRefreshListener.a();
      return;
    }
    b();
  }
  
  private boolean g()
  {
    int m = getScrollY();
    boolean bool1 = false;
    boolean bool2 = false;
    if (m < 0)
    {
      if (m > -getOverScrollHeight())
      {
        if (this.g)
        {
          m = this.f;
          if ((m == 0) || (m == 2)) {
            this.k.onNotCompleteVisable(0, null, null);
          }
        }
        else
        {
          m = this.f;
          if ((m == 1) || (m == 2)) {
            this.k.onViewNotCompleteVisableAndReleased(0, null, null);
          }
        }
        this.f = 1;
        return false;
      }
      if (this.g)
      {
        m = this.f;
        if (m != 0)
        {
          bool1 = bool2;
          if (m != 1) {}
        }
        else
        {
          this.k.onViewCompleteVisable(0, null, null);
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = bool2;
        if (this.f == 2) {
          bool1 = this.k.onViewCompleteVisableAndReleased(0, null, null);
        }
      }
      this.f = 2;
    }
    return bool1;
  }
  
  private int getOverScrollHeight()
  {
    return this.c.getHeaderView().getMeasuredHeight();
  }
  
  protected boolean a()
  {
    return (this.i) || (this.d == 3);
  }
  
  protected void b()
  {
    this.i = true;
    super.onBack();
  }
  
  public void c()
  {
    this.i = true;
    this.d = 3;
    if (this.c.g() == 0L)
    {
      b();
      return;
    }
    this.j.sendEmptyMessageDelayed(0, this.c.g());
  }
  
  public boolean d()
  {
    return this.g;
  }
  
  public void onBack()
  {
    this.g = false;
    if (this.e == null)
    {
      super.onBack();
      return;
    }
    g();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.c.getHeaderView().layout(0, -this.c.getHeaderView().getMeasuredHeight(), this.c.getHeaderView().getMeasuredWidth(), 0);
  }
  
  public void onOverScroll(int paramInt)
  {
    super.onOverScroll(paramInt);
    this.g = true;
    if (this.d != 2) {
      g();
    }
  }
  
  public void setDelayBeforeScrollBack(long paramLong)
  {
    IPullRefreshHeader localIPullRefreshHeader = this.c;
    if ((localIPullRefreshHeader instanceof PullRefreshHeader)) {
      ((PullRefreshHeader)localIPullRefreshHeader).a = paramLong;
    }
  }
  
  public void setHeader(IPullRefreshHeader paramIPullRefreshHeader)
  {
    if (paramIPullRefreshHeader == null) {
      return;
    }
    removeViewAt(0);
    this.c = paramIPullRefreshHeader;
    addView(this.c.getHeaderView(), 0);
    e();
  }
  
  public final void setHeaderBgColor(int paramInt)
  {
    IPullRefreshHeader localIPullRefreshHeader = this.c;
    if (localIPullRefreshHeader != null) {
      localIPullRefreshHeader.setHeaderBgColor(paramInt);
    }
  }
  
  public final void setHeaderBgDrawable(Drawable paramDrawable)
  {
    IPullRefreshHeader localIPullRefreshHeader = this.c;
    if (localIPullRefreshHeader != null) {
      localIPullRefreshHeader.setHeaderBgDrawable(paramDrawable);
    }
  }
  
  public final void setHeaderBgRes(int paramInt)
  {
    IPullRefreshHeader localIPullRefreshHeader = this.c;
    if (localIPullRefreshHeader != null) {
      localIPullRefreshHeader.setHeaderBgRes(paramInt);
    }
  }
  
  public final void setHeaderTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    IPullRefreshHeader localIPullRefreshHeader = this.c;
    if (localIPullRefreshHeader != null) {
      localIPullRefreshHeader.setTextColor(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public void setOnCancelListener(RefreshView.OnCancelListener paramOnCancelListener) {}
  
  public void setOnRefreshListener(RefreshView.OnRefreshListener paramOnRefreshListener)
  {
    this.e = paramOnRefreshListener;
    if (paramOnRefreshListener == null)
    {
      this.c.getHeaderView().setVisibility(8);
      return;
    }
    this.c.getHeaderView().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.RefreshView
 * JD-Core Version:    0.7.0.1
 */