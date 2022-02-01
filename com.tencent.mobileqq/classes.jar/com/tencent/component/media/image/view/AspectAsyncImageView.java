package com.tencent.component.media.image.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

public class AspectAsyncImageView
  extends AsyncImageView
{
  public AspectAsyncImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AspectAsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AspectAsyncImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    Drawable localDrawable = getDrawable();
    int n;
    int i1;
    int k;
    int m;
    float f1;
    if (localDrawable == null)
    {
      n = 0;
      i1 = 0;
      k = 0;
      m = 0;
      f1 = 0.0F;
    }
    else
    {
      m = localDrawable.getIntrinsicWidth();
      k = localDrawable.getIntrinsicHeight();
      if (i != 1073741824) {
        i = 1;
      } else {
        i = 0;
      }
      if (j != 1073741824) {
        j = 1;
      } else {
        j = 0;
      }
      f1 = m / k;
      i1 = j;
      n = i;
    }
    int i4 = getPaddingLeft();
    int i5 = getPaddingRight();
    int i2 = getPaddingTop();
    int i3 = getPaddingBottom();
    if ((n == 0) && (i1 == 0))
    {
      i = Math.max(m + (i4 + i5), getSuggestedMinimumWidth());
      j = Math.max(k + (i2 + i3), getSuggestedMinimumHeight());
      paramInt1 = resolveSize(i, paramInt1);
      paramInt2 = resolveSize(j, paramInt2);
    }
    for (;;)
    {
      break;
      i = resolveSize(m + i4 + i5, paramInt1);
      j = resolveSize(k + i2 + i3, paramInt2);
      if (f1 != 0.0F)
      {
        float f2 = i - i4 - i5;
        float f3 = j - i2 - i3;
        m = j;
        k = i;
        if (Math.abs(f2 / f3 - f1) > 1.0E-007D)
        {
          k = i;
          if (n != 0)
          {
            m = (int)(f3 * f1) + i4 + i5;
            if (i1 != 0) {
              i = resolveSize(m, paramInt1);
            }
            k = i;
            if (m <= i)
            {
              paramInt1 = m;
              i = 1;
              break label333;
            }
          }
          i = 0;
          paramInt1 = k;
          label333:
          m = j;
          k = paramInt1;
          if (i == 0)
          {
            m = j;
            k = paramInt1;
            if (i1 != 0)
            {
              i = (int)((paramInt1 - i4 - i5) / f1) + i2 + i3;
              if (n == 0) {
                j = resolveSize(i, paramInt2);
              }
              m = j;
              k = paramInt1;
              if (i <= j)
              {
                paramInt2 = i;
                break label415;
              }
            }
          }
        }
        paramInt2 = m;
        paramInt1 = k;
      }
      else
      {
        label415:
        paramInt1 = i;
        paramInt2 = j;
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.view.AspectAsyncImageView
 * JD-Core Version:    0.7.0.1
 */