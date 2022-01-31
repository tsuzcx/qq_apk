package com.tencent.biz.ui;

import alpo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class CustomGuideView
  extends View
{
  public float a;
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public CustomGuideView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = alpo.a(2131703080);
    a();
  }
  
  public CustomGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = alpo.a(2131703080);
    a();
  }
  
  public CustomGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = alpo.a(2131703080);
    a();
  }
  
  private int a(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824) {
      paramInt2 = i;
    }
    do
    {
      return paramInt2;
      paramInt2 = paramInt1;
    } while (j != -2147483648);
    return Math.min(paramInt1, i);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int + this.b;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.e = a(12.5F);
    this.jdField_a_of_type_Int = a(30.0F);
    this.b = a(7.0F);
    this.c = a(5.0F);
    this.d = 0;
    this.jdField_a_of_type_Float = a(12.0F);
  }
  
  public int b()
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    return (int)(this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString) + this.c * 2 + this.d * 2 + this.e * 2 + 0.5F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    float f1 = getWidth() * 0.9F - this.h;
    float f2 = this.b;
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.h / 2 + f1, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + this.h, f2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.g);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    RectF localRectF = new RectF(0.0F, this.b, getWidth(), getHeight());
    paramCanvas.drawRoundRect(localRectF, this.e, this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.f);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
    String str = this.jdField_a_of_type_JavaLangString;
    f1 = (getWidth() - this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString)) / 2.0F;
    f2 = this.b;
    float f3 = localRectF.height();
    float f4 = localFontMetrics.ascent;
    paramCanvas.drawText(str, f1, (f3 - (localFontMetrics.bottom + f4)) / 2.0F + f2, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(b(), paramInt1), a(a(), paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.ui.CustomGuideView
 * JD-Core Version:    0.7.0.1
 */