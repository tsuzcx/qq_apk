package com.tencent.avgame.gameroom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CoverRoundCornerRelativeLayout
  extends RelativeLayout
{
  protected int a;
  protected Paint a;
  protected Path a;
  protected boolean a;
  protected float[] a;
  protected int b;
  protected Path b;
  protected int c;
  protected int d;
  
  public CoverRoundCornerRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CoverRoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CoverRoundCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsPath == null) || (this.jdField_b_of_type_AndroidGraphicsPath == null) || (this.c != getMeasuredWidth()) || (this.d != getMeasuredHeight()))
    {
      this.c = getMeasuredWidth();
      this.d = getMeasuredHeight();
      this.jdField_b_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), this.c - getPaddingRight(), this.d - getPaddingBottom());
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
      this.jdField_b_of_type_AndroidGraphicsPath.addRect(new RectF(0.0F, 0.0F, this.c, this.d), Path.Direction.CCW);
      this.jdField_b_of_type_AndroidGraphicsPath.addRoundRect(localRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
    }
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
    paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  public void setIsPressed(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setPressCoverColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setRadius(int paramInt, float paramFloat)
  {
    setRadius(paramInt, paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setRadius(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 };
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.CoverRoundCornerRelativeLayout
 * JD-Core Version:    0.7.0.1
 */