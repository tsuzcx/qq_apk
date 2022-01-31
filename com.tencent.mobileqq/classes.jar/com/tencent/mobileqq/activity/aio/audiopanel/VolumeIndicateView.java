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
    int m = 0;
    int k;
    int j;
    int i;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      k = getWidth();
      j = getHeight();
      if (this.b != 3) {
        break label79;
      }
      i = k - this.jdField_a_of_type_Int * k / 10000 - 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(i, m, k, j);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      super.onDraw(paramCanvas);
      return;
      label79:
      if (this.b == 4)
      {
        k = k * this.jdField_a_of_type_Int / 10000 + 1;
        i = 0;
      }
      else if (this.b == 1)
      {
        m = this.jdField_a_of_type_Int * j / 10000;
        i = 0;
        m = j - m - 1;
      }
      else if (this.b == 2)
      {
        j = j * this.jdField_a_of_type_Int / 10000 + 1;
        i = 0;
      }
      else
      {
        i = 0;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateView
 * JD-Core Version:    0.7.0.1
 */