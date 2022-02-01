package com.tencent.biz.ui;

import aakn;
import aakt;
import aaku;
import aakv;
import aakw;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import bldp;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class RefreshView
  extends CustomScrollView
{
  public int a;
  public aakn a;
  private aakw jdField_a_of_type_Aakw;
  private Handler jdField_a_of_type_AndroidOsHandler = new aakt(this);
  private bldp jdField_a_of_type_Bldp = new aaku(this);
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
    return this.jdField_a_of_type_Aakn.a().getMeasuredHeight();
  }
  
  @SuppressLint({"InflateParams"})
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Aakn = ((PullRefreshHeader)LayoutInflater.from(paramContext).inflate(2131559689, null));
    addView(this.jdField_a_of_type_Aakn.a(), 0);
    c();
  }
  
  private void c()
  {
    float f = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Aakn.a().setMinimumHeight((int)(f * 60.0F));
    this.jdField_a_of_type_Aakn.a().setVisibility(8);
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
        this.jdField_a_of_type_Bldp.onNotCompleteVisable(0, null, null);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = 1;
      return false;
      label61:
      if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2)) {
        this.jdField_a_of_type_Bldp.onViewNotCompleteVisableAndReleased(0, null, null);
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
        this.jdField_a_of_type_Bldp.onViewCompleteVisable(0, null, null);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = 2;
      return bool1;
      bool1 = bool2;
      if (this.jdField_b_of_type_Int == 2) {
        bool1 = this.jdField_a_of_type_Bldp.onViewCompleteVisableAndReleased(0, null, null);
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Aakw != null)
    {
      this.jdField_a_of_type_Aakw.a();
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
    if (this.jdField_a_of_type_Aakn.a() == 0L)
    {
      a();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, this.jdField_a_of_type_Aakn.a());
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onBack()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Aakw == null)
    {
      super.onBack();
      return;
    }
    c();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Aakn.a().layout(0, -this.jdField_a_of_type_Aakn.a().getMeasuredHeight(), this.jdField_a_of_type_Aakn.a().getMeasuredWidth(), 0);
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
    if ((this.jdField_a_of_type_Aakn instanceof PullRefreshHeader)) {
      ((PullRefreshHeader)this.jdField_a_of_type_Aakn).a = paramLong;
    }
  }
  
  public void setHeader(aakn paramaakn)
  {
    if (paramaakn == null) {
      return;
    }
    removeViewAt(0);
    this.jdField_a_of_type_Aakn = paramaakn;
    addView(this.jdField_a_of_type_Aakn.a(), 0);
    c();
  }
  
  public final void setHeaderBgColor(int paramInt)
  {
    if (this.jdField_a_of_type_Aakn != null) {
      this.jdField_a_of_type_Aakn.setHeaderBgColor(paramInt);
    }
  }
  
  public final void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Aakn != null) {
      this.jdField_a_of_type_Aakn.setHeaderBgDrawable(paramDrawable);
    }
  }
  
  public final void setHeaderBgRes(int paramInt)
  {
    if (this.jdField_a_of_type_Aakn != null) {
      this.jdField_a_of_type_Aakn.setHeaderBgRes(paramInt);
    }
  }
  
  public final void setHeaderTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_Aakn != null) {
      this.jdField_a_of_type_Aakn.setTextColor(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public void setOnCancelListener(aakv paramaakv) {}
  
  public void setOnRefreshListener(aakw paramaakw)
  {
    this.jdField_a_of_type_Aakw = paramaakw;
    if (paramaakw == null)
    {
      this.jdField_a_of_type_Aakn.a().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Aakn.a().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.ui.RefreshView
 * JD-Core Version:    0.7.0.1
 */