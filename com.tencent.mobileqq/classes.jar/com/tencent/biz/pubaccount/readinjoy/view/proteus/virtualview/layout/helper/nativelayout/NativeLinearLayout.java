package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout.Params;

public class NativeLinearLayout
  extends LinearLayout
{
  private NativeLayoutImpl a;
  
  public NativeLinearLayout(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeLayoutImpl(paramVafContext.a());
    this.a.setVirtualView(this);
  }
  
  public View a()
  {
    return this.a;
  }
  
  public LinearLayout.Params a()
  {
    return new LinearLayout.Params();
  }
  
  public void a()
  {
    this.a.setBorderColor(this.f);
    this.a.setBorderWidth(this.e);
    this.a.setBorderTopLeftRadius(this.h);
    this.a.setBorderTopRightRadius(this.i);
    this.a.setBorderBottomLeftRadius(this.j);
    this.a.setBorderBottomRightRadius(this.k);
    this.a.setBackgroundColor(this.d);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.a.b(this.t, this.u);
  }
  
  public void a(ViewBase paramViewBase)
  {
    super.a(paramViewBase);
    this.a.a(paramViewBase);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramBoolean, 0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return super.a(paramInt1 - d(), paramInt2 - e());
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return super.a(paramInt1 - d(), paramInt2 - e(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLinearLayout
 * JD-Core Version:    0.7.0.1
 */