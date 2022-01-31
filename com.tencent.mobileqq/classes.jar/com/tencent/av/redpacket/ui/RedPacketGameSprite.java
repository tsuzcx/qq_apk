package com.tencent.av.redpacket.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class RedPacketGameSprite
{
  public Bitmap a;
  public Rect a;
  
  public RedPacketGameSprite(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsRect.right = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
  }
  
  public void a(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, paramRect, paramPaint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameSprite
 * JD-Core Version:    0.7.0.1
 */