package com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import olw;
import omf;

public class CommonAdBar
  extends FrameLayout
  implements olw
{
  private omf a;
  
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
  
  public omf a()
  {
    return this.a;
  }
  
  public void a()
  {
    removeAllViews();
  }
  
  public void a(omf paramomf)
  {
    if (this.a != null) {
      this.a.c();
    }
    this.a = paramomf;
    this.a.a(this);
    addView(paramomf.a());
  }
  
  public void b()
  {
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.CommonAdBar
 * JD-Core Version:    0.7.0.1
 */