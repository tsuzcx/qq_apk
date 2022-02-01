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
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    float f = 0.0F;
    int m = 0;
    int n = 0;
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    Drawable localDrawable = getDrawable();
    int i6;
    int i7;
    int i4;
    int i5;
    int i1;
    int k;
    if (localDrawable == null)
    {
      i = 0;
      j = 0;
      i6 = getPaddingLeft();
      i7 = getPaddingRight();
      i4 = getPaddingTop();
      i5 = getPaddingBottom();
      if ((m == 0) && (n == 0)) {
        break label358;
      }
      j = resolveSize(j + i6 + i7, paramInt1);
      i1 = resolveSize(i + i4 + i5, paramInt2);
      k = j;
      if (f == 0.0F) {
        break label425;
      }
      k = j;
      if (Math.abs((j - i6 - i7) / (i1 - i4 - i5) - f) <= 1.0E-007D) {
        break label425;
      }
      int i3 = 0;
      i = j;
      int i2 = i3;
      if (m != 0)
      {
        k = (int)((i1 - i4 - i5) * f) + i6 + i7;
        if (n != 0) {
          j = resolveSize(k, paramInt1);
        }
        i = j;
        i2 = i3;
        if (k <= j)
        {
          i2 = 1;
          i = k;
        }
      }
      k = i;
      if (i2 != 0) {
        break label425;
      }
      k = i;
      if (n == 0) {
        break label425;
      }
      j = (int)((i - i6 - i7) / f) + i4 + i5;
      if (m != 0) {
        break label419;
      }
      paramInt1 = resolveSize(j, paramInt2);
      label266:
      if (j > paramInt1) {
        break label413;
      }
      paramInt2 = i;
      paramInt1 = j;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      k = localDrawable.getIntrinsicWidth();
      i1 = localDrawable.getIntrinsicHeight();
      if (i != 1073741824)
      {
        i = 1;
        label309:
        if (j == 1073741824) {
          break label352;
        }
      }
      label352:
      for (j = 1;; j = 0)
      {
        f = k / i1;
        n = j;
        m = i;
        i = i1;
        j = k;
        break;
        i = 0;
        break label309;
      }
      label358:
      j = Math.max(i6 + i7 + j, getSuggestedMinimumWidth());
      k = Math.max(i4 + i5 + i, getSuggestedMinimumHeight());
      i = resolveSize(j, paramInt1);
      paramInt1 = resolveSize(k, paramInt2);
      paramInt2 = i;
      continue;
      label413:
      paramInt2 = i;
      continue;
      label419:
      paramInt1 = i1;
      break label266;
      label425:
      paramInt1 = i1;
      paramInt2 = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.view.AspectAsyncImageView
 * JD-Core Version:    0.7.0.1
 */