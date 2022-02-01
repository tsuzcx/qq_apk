package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

class ApolloItemBuilder$AvatarImageView
  extends View
{
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
  private float b;
  private float c;
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((i == 0) || (j == 0) || (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap == null) || (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length <= 0)) {}
    for (;;)
    {
      return;
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length)
      {
        if ((this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] != null) && (!this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].isRecycled()))
        {
          paramCanvas.save();
          paramCanvas.translate(this.jdField_a_of_type_Float, 0.0F);
          paramCanvas.translate((this.jdField_a_of_type_Float + this.jdField_a_of_type_Float + this.c + this.c) * i, 0.0F);
          paramCanvas.drawCircle(this.c, this.c, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.translate(this.b, this.b);
          paramCanvas.drawBitmap(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i], new Rect(0, 0, this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getWidth(), this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getHeight()), new RectF(0.0F, 0.0F, (this.c - this.b) * 2.0F, (this.c - this.b) * 2.0F), null);
          paramCanvas.restore();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder.AvatarImageView
 * JD-Core Version:    0.7.0.1
 */