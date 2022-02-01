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
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private int b;
  
  public VolumeIndicateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      int n = getWidth();
      int m = getHeight();
      int i2 = this.b;
      int i = 0;
      int i1 = 0;
      int k;
      int j;
      if (i2 == 3)
      {
        i = n - this.jdField_a_of_type_Int * n / 10000 - 1;
        k = m;
        j = n;
      }
      for (;;)
      {
        m = 0;
        break;
        if (i2 == 4)
        {
          j = n * this.jdField_a_of_type_Int / 10000 + 1;
          k = m;
          i = i1;
        }
        else
        {
          if (i2 == 1)
          {
            i1 = m - this.jdField_a_of_type_Int * m / 10000 - 1;
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
            k = m * this.jdField_a_of_type_Int / 10000 + 1;
            j = n;
            i = i1;
          }
        }
      }
      this.jdField_a_of_type_AndroidGraphicsRect.set(i, m, j, k);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setIndicateVolumeBitmap(Bitmap paramBitmap, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.b = paramInt;
  }
  
  public void setLevel(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateView
 * JD-Core Version:    0.7.0.1
 */