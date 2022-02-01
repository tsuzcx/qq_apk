package com.tencent.biz.pubaccount.readinjoy;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;

public class ReadInJoyAdVideoCompleteGuide
  extends ViewBase
{
  private ReadInJoyAdVideoGuide a;
  private Context b;
  
  public ReadInJoyAdVideoCompleteGuide(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.b = paramVafContext.getContext();
    a(paramVafContext);
  }
  
  private void a(VafContext paramVafContext)
  {
    this.a = new ReadInJoyAdVideoGuide(this.b);
    this.a.setVisibility(8);
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyAdVideoCompleteGuide
 * JD-Core Version:    0.7.0.1
 */