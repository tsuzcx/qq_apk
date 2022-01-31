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
import belq;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import wpa;
import wpg;
import wph;
import wpi;
import wpj;

public class RefreshView
  extends CustomScrollView
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new wpg(this);
  private belq jdField_a_of_type_Belq = new wph(this);
  public wpa a;
  private wpj jdField_a_of_type_Wpj;
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
    return this.jdField_a_of_type_Wpa.a().getMeasuredHeight();
  }
  
  @SuppressLint({"InflateParams"})
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Wpa = ((PullRefreshHeader)LayoutInflater.from(paramContext).inflate(2131493891, null));
    addView(this.jdField_a_of_type_Wpa.a(), 0);
    c();
  }
  
  private void c()
  {
    float f = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Wpa.a().setMinimumHeight((int)(f * 60.0F));
    this.jdField_a_of_type_Wpa.a().setVisibility(8);
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
        this.jdField_a_of_type_Belq.a(0, null, null);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = 1;
      return false;
      label61:
      if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2)) {
        this.jdField_a_of_type_Belq.c(0, null, null);
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
        this.jdField_a_of_type_Belq.b(0, null, null);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = 2;
      return bool1;
      bool1 = bool2;
      if (this.jdField_b_of_type_Int == 2) {
        bool1 = this.jdField_a_of_type_Belq.a(0, null, null);
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Wpj != null)
    {
      this.jdField_a_of_type_Wpj.a();
      return;
    }
    a();
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    super.onBack();
  }
  
  protected boolean a()
  {
    return (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int == 3);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
    if (this.jdField_a_of_type_Wpa.a() == 0L)
    {
      a();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, this.jdField_a_of_type_Wpa.a());
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onBack()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Wpj == null)
    {
      super.onBack();
      return;
    }
    c();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Wpa.a().layout(0, -this.jdField_a_of_type_Wpa.a().getMeasuredHeight(), this.jdField_a_of_type_Wpa.a().getMeasuredWidth(), 0);
  }
  
  public void onOverScroll(int paramInt)
  {
    super.onOverScroll(paramInt);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != 2) {
      c();
    }
  }
  
  public void setDelayBeforeScrollBack(long paramLong)
  {
    if ((this.jdField_a_of_type_Wpa instanceof PullRefreshHeader)) {
      ((PullRefreshHeader)this.jdField_a_of_type_Wpa).a = paramLong;
    }
  }
  
  public void setHeader(wpa paramwpa)
  {
    if (paramwpa == null) {
      return;
    }
    removeViewAt(0);
    this.jdField_a_of_type_Wpa = paramwpa;
    addView(this.jdField_a_of_type_Wpa.a(), 0);
    c();
  }
  
  public final void setHeaderBgColor(int paramInt)
  {
    if (this.jdField_a_of_type_Wpa != null) {
      this.jdField_a_of_type_Wpa.setHeaderBgColor(paramInt);
    }
  }
  
  public final void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Wpa != null) {
      this.jdField_a_of_type_Wpa.setHeaderBgDrawable(paramDrawable);
    }
  }
  
  public final void setHeaderBgRes(int paramInt)
  {
    if (this.jdField_a_of_type_Wpa != null) {
      this.jdField_a_of_type_Wpa.setHeaderBgRes(paramInt);
    }
  }
  
  public final void setHeaderTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_Wpa != null) {
      this.jdField_a_of_type_Wpa.setTextColor(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public void setOnCancelListener(wpi paramwpi) {}
  
  public void setOnRefreshListener(wpj paramwpj)
  {
    this.jdField_a_of_type_Wpj = paramwpj;
    if (paramwpj == null)
    {
      this.jdField_a_of_type_Wpa.a().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Wpa.a().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.RefreshView
 * JD-Core Version:    0.7.0.1
 */