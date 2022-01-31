package com.tencent.biz.pubaccount.readinjoy.view.appinpush;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class BubbleFrameLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 0.6F;
  private int jdField_a_of_type_Int = AIOUtils.a(6.0F, getResources());
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = AIOUtils.a(6.0F, getResources());
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = AIOUtils.a(1.5F, getResources());
  private float e;
  private float f;
  private float g;
  
  public BubbleFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BubbleFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.WINDING);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(this.jdField_a_of_type_Int, 0.0F, this.jdField_d_of_type_Int, Color.argb(30, 0, 0, 0));
    setLayerType(1, this.jdField_a_of_type_AndroidGraphicsPaint);
    setWillNotDraw(false);
    a();
  }
  
  private void a()
  {
    setPadding(getPaddingLeft() + this.jdField_b_of_type_Int, getPaddingTop(), getPaddingRight() + this.jdField_b_of_type_Int, getPaddingBottom() + this.jdField_c_of_type_Int + this.jdField_b_of_type_Int);
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_Int, 0.0F, getWidth() - this.jdField_b_of_type_Int, getHeight() - this.jdField_c_of_type_Int - this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, Path.Direction.CW);
    this.jdField_d_of_type_Float = (getWidth() * this.jdField_a_of_type_Float);
    this.e = (getHeight() - this.jdField_b_of_type_Int);
    this.jdField_b_of_type_Float = (this.jdField_d_of_type_Float - this.jdField_c_of_type_Int);
    this.jdField_c_of_type_Float = (this.e - this.jdField_c_of_type_Int);
    this.f = (this.jdField_b_of_type_Float + this.jdField_c_of_type_Int * 2);
    this.g = this.jdField_c_of_type_Float;
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_d_of_type_Float, this.e);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.f, this.g);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    paramCanvas.restore();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.argb(234, 0, 0, 0));
    a(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.argb(94, 255, 255, 255));
    a(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    super.onDraw(paramCanvas);
  }
  
  public void setTriPosition(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.appinpush.BubbleFrameLayout
 * JD-Core Version:    0.7.0.1
 */