package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.widget.QQViewPager;

public class EffectViewPager
  extends QQViewPager
{
  DisplayMetrics a = getContext().getResources().getDisplayMetrics();
  
  public EffectViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public EffectViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(this.a.widthPixels, 1073741824), paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.view.EffectViewPager
 * JD-Core Version:    0.7.0.1
 */