package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import mpt;

public class BoringView
  extends ViewBase
{
  private mpt a;
  
  public BoringView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new mpt(paramVafContext.a());
  }
  
  public int a()
  {
    return this.a.getMeasuredWidth();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a()
  {
    super.a();
    this.a.f(this.f);
    this.a.e(this.e);
    this.a.a(this.h);
    this.a.b(this.i);
    this.a.c(this.j);
    this.a.d(this.k);
    this.a.setBackgroundColor(this.d);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.measure(paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int b()
  {
    return this.a.getMeasuredHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.BoringView
 * JD-Core Version:    0.7.0.1
 */