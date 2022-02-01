package com.tencent.mobileqq.activity.aio.intimate.view;

import agll;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class IntimateContentItemBaseView
  extends RelativeLayout
  implements View.OnClickListener, View.OnTouchListener
{
  protected int a;
  private long a;
  public agll a;
  public Context a;
  protected IntimateInfo a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected boolean c;
  
  public IntimateContentItemBaseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemBaseView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemBaseView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  protected abstract void a();
  
  protected abstract void a(View paramView);
  
  protected abstract void a(IntimateInfo paramIntimateInfo, int paramInt);
  
  protected abstract boolean a();
  
  protected void b() {}
  
  public void b(IntimateInfo paramIntimateInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.jdField_a_of_type_Int = paramInt;
    if (!a())
    {
      setVisibility(8);
      return;
    }
    if (!this.c) {
      g();
    }
    setVisibility(0);
    a(paramIntimateInfo, paramInt);
  }
  
  protected void c() {}
  
  protected void d() {}
  
  protected void e() {}
  
  protected void f() {}
  
  public void g()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    a();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    b();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    c();
  }
  
  public void j()
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IntimateContentItemBaseView", 2, "onResumed isOpened:" + this.jdField_b_of_type_Boolean);
      }
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  public void k()
  {
    this.jdField_a_of_type_Boolean = false;
    e();
  }
  
  public void l()
  {
    this.jdField_a_of_type_Boolean = false;
    f();
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if (l - this.jdField_a_of_type_Long < 500L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = l;
      a(paramView);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramView.setAlpha(0.5F);
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
  
  public void setCurrentShowType(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateContentItemBaseView", 2, "setCurrentShowType showType: " + paramInt + "  old:" + this.jdField_b_of_type_Int);
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setIntimateInterface(agll paramagll)
  {
    this.jdField_a_of_type_Agll = paramagll;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
 * JD-Core Version:    0.7.0.1
 */