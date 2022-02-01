package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

public class TipsView
  extends View
{
  protected float a;
  protected int a;
  protected Paint a;
  protected Path a;
  protected RectF a;
  protected String a;
  protected float b;
  protected int b;
  protected Paint b;
  protected int c;
  
  public TipsView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 3;
    a();
  }
  
  public TipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 3;
    a();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(DisplayUtil.a(super.getContext(), 14.0F));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.argb(178, 0, 0, 0));
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    int i = DisplayUtil.a(super.getContext(), 10.0F);
    super.setPadding(i, i, i, i);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    float f1 = ((Paint.FontMetrics)localObject).bottom;
    float f3 = ((Paint.FontMetrics)localObject).top;
    float f4 = ((Paint.FontMetrics)localObject).bottom;
    float f5 = super.getPaddingTop();
    int i = this.jdField_a_of_type_Int;
    int j = 0;
    if (i == 1) {
      i = DisplayUtil.a(super.getContext(), 6.5F);
    } else {
      i = 0;
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f2 = i;
    float f6 = this.jdField_a_of_type_Float;
    float f7 = this.jdField_b_of_type_Float;
    if (this.jdField_a_of_type_Int == 1) {
      i = 0;
    } else {
      i = DisplayUtil.a(super.getContext(), 6.5F);
    }
    ((RectF)localObject).set(0.0F, f2, f6, f7 - i);
    paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, DisplayUtil.a(super.getContext(), 4.0F), DisplayUtil.a(super.getContext(), 4.0F), this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, super.getPaddingLeft(), f5 + (f1 - f3 - f4) + f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    f3 = this.jdField_a_of_type_Float;
    f1 = f3 / 2.0F;
    i = this.jdField_b_of_type_Int;
    if (i == 1) {
      f1 = this.c;
    } else if (i == 2) {
      f1 = f3 - this.c;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 - DisplayUtil.a(super.getContext(), 6.5F), f2);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + DisplayUtil.a(super.getContext(), 6.5F), f2);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, this.jdField_b_of_type_Float);
      localObject = this.jdField_a_of_type_AndroidGraphicsPath;
      f2 = DisplayUtil.a(super.getContext(), 6.5F);
      f3 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_Int == 1) {
        i = 0;
      } else {
        i = DisplayUtil.a(super.getContext(), 6.5F);
      }
      ((Path)localObject).lineTo(f1 - f2, f3 - i);
      localObject = this.jdField_a_of_type_AndroidGraphicsPath;
      f2 = DisplayUtil.a(super.getContext(), 6.5F);
      f3 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_Int == 1) {
        i = j;
      } else {
        i = DisplayUtil.a(super.getContext(), 6.5F);
      }
      ((Path)localObject).lineTo(f1 + f2, f3 - i);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Float = (super.getPaddingLeft() + super.getPaddingRight() + f1);
    Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    f1 = localFontMetrics.bottom;
    float f2 = localFontMetrics.top;
    this.jdField_b_of_type_Float = (super.getPaddingTop() + super.getPaddingBottom() + (f1 - f2) + DisplayUtil.a(super.getContext(), 6.5F));
    super.setMeasuredDimension((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
  }
  
  public void setArrowPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    super.invalidate();
  }
  
  public void setBgColor(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
    super.invalidate();
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    super.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.TipsView
 * JD-Core Version:    0.7.0.1
 */