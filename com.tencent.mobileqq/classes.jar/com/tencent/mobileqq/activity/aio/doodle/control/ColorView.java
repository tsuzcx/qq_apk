package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.Utils;

public class ColorView
  extends View
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private ColorView.ColorViewListener jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView$ColorViewListener;
  private int b = Utils.a(4.0F, getResources());
  
  public ColorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      paramCanvas.drawBitmap((Bitmap)localObject, null, new RectF(0.0F, 0.0F, getWidth(), getHeight()), null);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
      return;
    }
    int j = getWidth();
    int k = getHeight();
    if (j > k) {
      i = j;
    } else {
      i = k;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(i);
    localObject = new RectF(0.0F, 0.0F, j, k);
    int i = this.b;
    paramCanvas.drawRoundRect((RectF)localObject, i, i, this.jdField_a_of_type_AndroidGraphicsPaint);
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
  
  public void setListener(ColorView.ColorViewListener paramColorViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView$ColorViewListener = paramColorViewListener;
    setOnClickListener(new ColorView.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorView
 * JD-Core Version:    0.7.0.1
 */