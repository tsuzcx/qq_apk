package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import uem;
import uer;

public class CommonAdBar
  extends FrameLayout
  implements uem
{
  private uer a;
  
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
  
  public uer a()
  {
    return this.a;
  }
  
  public void a()
  {
    removeAllViews();
  }
  
  public void a(uer paramuer)
  {
    if (this.a != null) {
      this.a.c();
    }
    this.a = paramuer;
    this.a.a(this);
    addView(paramuer.a());
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