package com.tencent.mobileqq.activity.aio.intimate.view;

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
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class IntimateContentItemBaseView
  extends RelativeLayout
  implements View.OnClickListener, View.OnTouchListener
{
  protected Context a;
  protected boolean b = false;
  protected boolean c = false;
  protected IntimateInfo d;
  protected int e;
  protected int f;
  protected boolean g = false;
  protected BaseIntimateView h;
  private long i;
  
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
    this.a = paramContext;
  }
  
  protected abstract void a(View paramView);
  
  protected abstract void a(IntimateInfo paramIntimateInfo, int paramInt);
  
  protected abstract boolean a();
  
  protected abstract void b();
  
  public void b(IntimateInfo paramIntimateInfo, int paramInt)
  {
    this.d = paramIntimateInfo;
    this.e = paramInt;
    if (!a())
    {
      setVisibility(8);
      return;
    }
    if (!this.g) {
      h();
    }
    setVisibility(0);
    a(paramIntimateInfo, paramInt);
  }
  
  protected void c() {}
  
  protected void d() {}
  
  protected void e() {}
  
  protected void f() {}
  
  protected void g() {}
  
  public void h()
  {
    if (this.g) {
      return;
    }
    this.g = true;
    b();
  }
  
  public void i()
  {
    this.b = true;
    this.c = true;
    c();
  }
  
  public void j()
  {
    this.b = false;
    this.c = false;
    d();
  }
  
  public void k()
  {
    if (this.f == 1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResumed isOpened:");
        localStringBuilder.append(this.c);
        QLog.i("IntimateContentItemBaseView", 2, localStringBuilder.toString());
      }
      if (!this.c) {
        return;
      }
    }
    this.b = true;
    e();
  }
  
  public void l()
  {
    this.b = false;
    f();
  }
  
  public void m()
  {
    this.b = false;
    g();
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if (l - this.i >= 500L)
    {
      this.i = l;
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (((j == 1) || (j == 3)) && (Build.VERSION.SDK_INT >= 11)) {
        paramView.setAlpha(1.0F);
      }
    }
    else if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
  
  public void setCurrentShowType(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurrentShowType showType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  old:");
      localStringBuilder.append(this.f);
      QLog.d("IntimateContentItemBaseView", 2, localStringBuilder.toString());
    }
    this.f = paramInt;
  }
  
  public void setIntimateInterface(BaseIntimateView paramBaseIntimateView)
  {
    this.h = paramBaseIntimateView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
 * JD-Core Version:    0.7.0.1
 */