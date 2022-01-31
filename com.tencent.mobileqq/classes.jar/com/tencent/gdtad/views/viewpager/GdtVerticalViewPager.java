package com.tencent.gdtad.views.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import qkv;

public class GdtVerticalViewPager
  extends ViewPager
{
  public GdtVerticalViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GdtVerticalViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    setPageTransformer(true, new qkv(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.viewpager.GdtVerticalViewPager
 * JD-Core Version:    0.7.0.1
 */