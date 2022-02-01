package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mm.plugin.appbrand.page.bi;

public final class AppBrandCapsuleBarPlaceHolderView
  extends View
  implements bi
{
  private int a = -1;
  
  public AppBrandCapsuleBarPlaceHolderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBrandCapsuleBarPlaceHolderView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppBrandCapsuleBarPlaceHolderView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public AppBrandCapsuleBarPlaceHolderView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public boolean a(@NonNull Canvas paramCanvas)
  {
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getVisibility() == 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.max(this.a, 0), 1073741824), paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setFixedWidth(@Dimension(unit=1) int paramInt)
  {
    paramInt = Math.max(paramInt, 0);
    if (paramInt != this.a)
    {
      this.a = paramInt;
      if (this.a != getMeasuredWidth()) {
        requestLayout();
      }
    }
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    int i;
    if (getLayoutParams() == null) {
      i = 1;
    } else {
      i = 0;
    }
    super.setLayoutParams(paramLayoutParams);
    if (i != 0)
    {
      this.a = paramLayoutParams.width;
      this.a = Math.max(0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView
 * JD-Core Version:    0.7.0.1
 */