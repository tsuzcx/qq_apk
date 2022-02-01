package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

public class VolumeIndicateView
  extends ImageView
{
  private Bitmap a;
  private Rect b = new Rect();
  private int c;
  private int d;
  
  public VolumeIndicateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      int n = getWidth();
      int m = getHeight();
      int i2 = this.d;
      int i = 0;
      int i1 = 0;
      int k;
      int j;
      if (i2 == 3)
      {
        i = n - this.c * n / 10000 - 1;
        k = m;
        j = n;
      }
      for (;;)
      {
        m = 0;
        break;
        if (i2 == 4)
        {
          j = n * this.c / 10000 + 1;
          k = m;
          i = i1;
        }
        else
        {
          if (i2 == 1)
          {
            i1 = m - this.c * m / 10000 - 1;
            j = n;
            k = m;
            m = i1;
            break;
          }
          j = n;
          k = m;
          i = i1;
          if (i2 == 2)
          {
            k = m * this.c / 10000 + 1;
            j = n;
            i = i1;
          }
        }
      }
      this.b.set(i, m, j, k);
      paramCanvas.drawBitmap(this.a, null, this.b, null);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setIndicateVolumeBitmap(Bitmap paramBitmap, int paramInt)
  {
    this.a = paramBitmap;
    this.d = paramInt;
  }
  
  public void setLevel(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateView
 * JD-Core Version:    0.7.0.1
 */