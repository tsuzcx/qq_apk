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
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.OverScrollViewListener;
import paa;
import pab;

public class RefreshView
  extends CustomScrollView
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new paa(this);
  public IPullRefreshHeader a;
  private RefreshView.OnRefreshListener jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new pab(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private volatile boolean jdField_b_of_type_Boolean = true;
  private final int c = 0;
  
  public RefreshView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private int a()
  {
    return this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().getMeasuredHeight();
  }
  
  @SuppressLint({"InflateParams"})
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(paramContext).inflate(2130969239, null));
    addView(this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a(), 0);
    d();
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    int i = getScrollY();
    if (i < 0)
    {
      if (i <= -a()) {
        break label92;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label61;
      }
      if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 2)) {
        this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(0, null, null);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = 1;
      return false;
      label61:
      if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2)) {
        this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.c(0, null, null);
      }
    }
    label92:
    boolean bool1;
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_b_of_type_Int != 0)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Int != 1) {}
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.b(0, null, null);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = 2;
      return bool1;
      bool1 = bool2;
      if (this.jdField_b_of_type_Int == 2) {
        bool1 = this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener.a(0, null, null);
      }
    }
  }
  
  private void d()
  {
    float f = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().setMinimumHeight((int)(f * 60.0F));
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().setVisibility(8);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener != null)
    {
      this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener.a();
      return;
    }
    b();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener == null)
    {
      super.a();
      return;
    }
    c();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != 2) {
      c();
    }
  }
  
  protected boolean a()
  {
    return (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int == 3);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    super.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a() == 0L)
    {
      b();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().layout(0, -this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().getMeasuredHeight(), this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().getMeasuredWidth(), 0);
  }
  
  public void setDelayBeforeScrollBack(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader instanceof PullRefreshHeader)) {
      ((PullRefreshHeader)this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader).a = paramLong;
    }
  }
  
  public void setHeader(IPullRefreshHeader paramIPullRefreshHeader)
  {
    if (paramIPullRefreshHeader == null) {
      return;
    }
    removeViewAt(0);
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader = paramIPullRefreshHeader;
    addView(this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a(), 0);
    d();
  }
  
  public final void setHeaderBgColor(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader != null) {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.setHeaderBgColor(paramInt);
    }
  }
  
  public final void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader != null) {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.setHeaderBgDrawable(paramDrawable);
    }
  }
  
  public final void setHeaderBgRes(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader != null) {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.setHeaderBgRes(paramInt);
    }
  }
  
  public final void setHeaderTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader != null) {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.setTextColor(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public void setOnCancelListener(RefreshView.OnCancelListener paramOnCancelListener) {}
  
  public void setOnRefreshListener(RefreshView.OnRefreshListener paramOnRefreshListener)
  {
    this.jdField_a_of_type_ComTencentBizUiRefreshView$OnRefreshListener = paramOnRefreshListener;
    if (paramOnRefreshListener == null)
    {
      this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.RefreshView
 * JD-Core Version:    0.7.0.1
 */