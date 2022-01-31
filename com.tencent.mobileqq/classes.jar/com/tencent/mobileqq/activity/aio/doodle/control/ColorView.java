package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import uqf;
import uqg;

public class ColorView
  extends View
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private uqg jdField_a_of_type_Uqg;
  private int b = AIOUtils.a(4.0F, getResources());
  
  public ColorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, new RectF(0.0F, 0.0F, getWidth(), getHeight()), null);
    }
    while (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
      return;
    }
    int j = getWidth();
    int k = getHeight();
    if (j > k) {}
    for (int i = j;; i = k)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(i);
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, j, k), this.b, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public void setBtmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    invalidate();
  }
  
  public void setListener(uqg paramuqg)
  {
    this.jdField_a_of_type_Uqg = paramuqg;
    setOnClickListener(new uqf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorView
 * JD-Core Version:    0.7.0.1
 */