package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.view.View;

public class NativeViewBase
  extends ViewBase
{
  protected View a;
  
  public int a()
  {
    if ((this.a instanceof IView)) {
      return ((IView)this.a).a();
    }
    return this.a.getMeasuredWidth();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a()
  {
    super.a();
  }
  
  protected void a(int paramInt)
  {
    this.a.setBackgroundColor(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.n <= 0) || ((this.a instanceof IView))) {
      ((IView)this.a).a(paramInt1, paramInt2);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a instanceof IView)) {
      ((IView)this.a).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public int b()
  {
    if ((this.a instanceof IView)) {
      return ((IView)this.a).b();
    }
    return this.a.getMeasuredHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.NativeViewBase
 * JD-Core Version:    0.7.0.1
 */