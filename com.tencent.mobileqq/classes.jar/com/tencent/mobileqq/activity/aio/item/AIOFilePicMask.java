package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class AIOFilePicMask
  extends Drawable
{
  private static final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  
  public AIOFilePicMask(int paramInt1, int paramInt2, float paramFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt2);
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = getBounds();
    int i = ((Rect)localObject).width();
    int j = ((Rect)localObject).height();
    if ((i > 0) && (j > 0))
    {
      paramCanvas.save();
      jdField_a_of_type_AndroidGraphicsRectF.set((Rect)localObject);
      localObject = jdField_a_of_type_AndroidGraphicsRectF;
      float f = this.jdField_a_of_type_Float;
      paramCanvas.drawRoundRect((RectF)localObject, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AIOFilePicMask
 * JD-Core Version:    0.7.0.1
 */