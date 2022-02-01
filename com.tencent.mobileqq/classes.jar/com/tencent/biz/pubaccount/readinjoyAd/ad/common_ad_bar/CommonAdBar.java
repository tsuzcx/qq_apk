package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import tle;
import tln;

public class CommonAdBar
  extends FrameLayout
  implements tle
{
  private tln a;
  
  public CommonAdBar(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonAdBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonAdBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public tln a()
  {
    return this.a;
  }
  
  public void a()
  {
    removeAllViews();
  }
  
  public void a(tln paramtln)
  {
    if (this.a != null) {
      this.a.c();
    }
    this.a = paramtln;
    this.a.a(this);
    addView(paramtln.a());
  }
  
  public void b()
  {
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdBar
 * JD-Core Version:    0.7.0.1
 */