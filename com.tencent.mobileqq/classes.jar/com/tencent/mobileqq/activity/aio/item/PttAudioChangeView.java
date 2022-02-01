package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class PttAudioChangeView
  extends PttThemeBaseView
{
  Bitmap a;
  private int j;
  
  public PttAudioChangeView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.j = paramInt1;
    a(paramInt2);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), this.j);
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected boolean a()
  {
    return (this.c != null) && (!this.c.isRecycled()) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioChangeView
 * JD-Core Version:    0.7.0.1
 */