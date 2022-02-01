package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;

public class BubbleFrameLayout
  extends FrameLayout
{
  private static final int jdField_a_of_type_Int = Color.argb(25, 0, 0, 0);
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int;
  private int h;
  private int i;
  private int j;
  
  public BubbleFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BubbleFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    setPadding(getPaddingLeft() + this.jdField_e_of_type_Int, getPaddingTop() + this.jdField_e_of_type_Int, getPaddingRight() + this.jdField_e_of_type_Int, getPaddingBottom() + this.jdField_f_of_type_Int + this.jdField_e_of_type_Int);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.BubbleFrameLayout, 0, 0);
    try
    {
      this.jdField_a_of_type_Float = paramContext.getFloat(8, 0.6F);
      this.jdField_f_of_type_Int = paramContext.getDimensionPixelSize(9, 24);
      this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(2, 6);
      this.h = paramContext.getDimensionPixelSize(5, 0);
      this.jdField_g_of_type_Int = paramContext.getDimensionPixelSize(6, 4);
      this.jdField_e_of_type_Int = paramContext.getDimensionPixelSize(7, 24);
      this.j = paramContext.getColor(4, jdField_a_of_type_Int);
      this.i = paramContext.getColor(0, -1);
      this.jdField_c_of_type_Int = paramContext.getColor(1, -1644826);
      this.jdField_d_of_type_Int = paramContext.getDimensionPixelSize(3, 1);
      paramContext.recycle();
      this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.WINDING);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(this.jdField_e_of_type_Int, this.h, this.jdField_g_of_type_Int, this.j);
      setLayerType(1, this.jdField_a_of_type_AndroidGraphicsPaint);
      setWillNotDraw(false);
      a();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    int k = this.jdField_e_of_type_Int;
    int m = getWidth() - this.jdField_e_of_type_Int;
    int n = this.jdField_e_of_type_Int;
    int i1 = getHeight() - this.jdField_f_of_type_Int - this.jdField_e_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_b_of_type_Int + k, i1);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(k, i1 - this.jdField_b_of_type_Int * 2, this.jdField_b_of_type_Int * 2 + k, i1);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_a_of_type_AndroidGraphicsRectF, 90.0F, 90.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(k, this.jdField_b_of_type_Int + n);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(k, n, this.jdField_b_of_type_Int * 2 + k, this.jdField_b_of_type_Int * 2 + n);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_a_of_type_AndroidGraphicsRectF, -180.0F, 90.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(m - this.jdField_b_of_type_Int, n);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(m - this.jdField_b_of_type_Int * 2, n, m, n + this.jdField_b_of_type_Int * 2);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 90.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(m, i1 - this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(m - this.jdField_b_of_type_Int * 2, i1 - this.jdField_b_of_type_Int * 2, m, i1);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 90.0F);
    this.jdField_d_of_type_Float = (getWidth() * this.jdField_a_of_type_Float);
    this.jdField_e_of_type_Float = (getHeight() - this.jdField_e_of_type_Int);
    this.jdField_b_of_type_Float = (this.jdField_d_of_type_Float - this.jdField_f_of_type_Int);
    this.jdField_c_of_type_Float = (this.jdField_e_of_type_Float - this.jdField_f_of_type_Int);
    this.jdField_f_of_type_Float = (this.jdField_b_of_type_Float + this.jdField_f_of_type_Int * 2);
    this.jdField_g_of_type_Float = this.jdField_c_of_type_Float;
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_f_of_type_Float, this.jdField_g_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_d_of_type_Float, this.jdField_e_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(k + this.jdField_b_of_type_Int, i1);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    paramCanvas.restore();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(0.0F, this.jdField_e_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.i);
    a(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    a(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.BubbleFrameLayout
 * JD-Core Version:    0.7.0.1
 */