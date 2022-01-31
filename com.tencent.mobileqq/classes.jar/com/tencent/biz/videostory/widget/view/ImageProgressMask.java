package com.tencent.biz.videostory.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import bdee;

public class ImageProgressMask
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private int b;
  
  public ImageProgressMask(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ImageProgressMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImageProgressMask(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131165455));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    if (Build.VERSION.SDK_INT <= 16) {
      setLayerType(1, null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      paramCanvas.save();
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      if ((this.jdField_a_of_type_Int == 0) && (this.b == 0))
      {
        this.jdField_a_of_type_Int = getWidth();
        this.b = getHeight();
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, this.b * this.jdField_a_of_type_Float, this.jdField_a_of_type_Int, this.b);
      }
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    catch (Exception localException)
    {
      super.onDraw(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != 0) && (paramInt2 != 0) && ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))) {
      this.jdField_a_of_type_AndroidGraphicsPath = bdee.a(paramInt1, paramInt2);
    }
  }
  
  public void setProgress(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = getWidth();
    this.b = getHeight();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, this.b * this.jdField_a_of_type_Float, this.jdField_a_of_type_Int, this.b);
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.ImageProgressMask
 * JD-Core Version:    0.7.0.1
 */