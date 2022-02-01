package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

public class AIOSendMask
  extends Drawable
{
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private static final Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  
  public AIOSendMask(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(paramInt1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt2);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = getLevel();
    if (i == 0) {
      return;
    }
    Object localObject1 = jdField_b_of_type_AndroidGraphicsRect;
    Rect localRect = getBounds();
    int j = localRect.width();
    int k = localRect.height();
    k -= (10000 - i) * k / 10000;
    int m = paramCanvas.getHeight();
    Gravity.apply(48, j, k, localRect, (Rect)localObject1);
    if ((j > 0) && (k > 0))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(100 - i / 100);
      ((StringBuilder)localObject2).append("%");
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      paramCanvas.save();
      boolean bool = this.jdField_a_of_type_Boolean;
      float f2 = 0.0F;
      float f1;
      if (bool)
      {
        localObject2 = this.jdField_b_of_type_AndroidGraphicsPaint;
        String str = this.jdField_a_of_type_JavaLangString;
        ((Paint)localObject2).getTextBounds(str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsRect);
        f2 = (paramCanvas.getWidth() - this.jdField_a_of_type_AndroidGraphicsRect.width()) / 2;
        f1 = (m + this.jdField_a_of_type_AndroidGraphicsRect.height()) / 2;
        paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f2, f1, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      else
      {
        f1 = 0.0F;
      }
      paramCanvas.clipRect((Rect)localObject1);
      jdField_a_of_type_AndroidGraphicsRectF.set(localRect);
      localObject1 = jdField_a_of_type_AndroidGraphicsRectF;
      float f3 = this.jdField_a_of_type_Float;
      paramCanvas.drawRoundRect((RectF)localObject1, f3, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_Boolean) {
        paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f2, f1, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      paramCanvas.restore();
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AIOSendMask
 * JD-Core Version:    0.7.0.1
 */