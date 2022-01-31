package com.tencent.mobileqq.apollo.store.openbox;

import ajya;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class AnimationableProgressView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c = 5;
  private int d = 3;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public AnimationableProgressView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AnimationableProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.f = -3946292;
    this.g = -1;
    this.h = -1972505;
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.d = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    if ((this.d < 0) || (this.c <= 0) || (this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0)) {
      return;
    }
    if (this.jdField_b_of_type_Long > 0L) {
      if (this.jdField_a_of_type_Long > 0L)
      {
        this.jdField_a_of_type_JavaLangString = (ajya.a(2131700267) + this.d + ajya.a(2131700269));
        this.i = -34816;
      }
    }
    do
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(14.0F * getResources().getDisplayMetrics().density);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = (this.d + "/" + this.c + ajya.a(2131700268));
      }
      float f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Float = ((this.jdField_a_of_type_Int - f1) / 2.0F);
      Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
      this.jdField_b_of_type_Float = ((this.jdField_b_of_type_Int - localFontMetrics.bottom - localFontMetrics.top) / 2.0F);
      super.invalidate();
      return;
      this.jdField_a_of_type_JavaLangString = (ajya.a(2131700264) + this.d + "/" + this.c);
      break;
      this.i = -16777216;
      this.jdField_a_of_type_JavaLangString = (ajya.a(2131700266) + this.d + "/" + this.c + ajya.a(2131700265));
    } while (this.d <= 0);
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    paramInt1 = this.jdField_a_of_type_Int * this.d / this.c;
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.e, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(0.0F, this.jdField_b_of_type_Int - this.e * 2, this.e * 2, this.jdField_b_of_type_Int), 90.0F, 90.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(0.0F, 0.0F, this.e * 2, this.e * 2), 180.0F, 90.0F);
    if (this.d >= this.c)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(this.jdField_a_of_type_Int - this.e * 2, 0.0F, this.jdField_a_of_type_Int, this.e * 2), -90.0F, 90.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(this.jdField_a_of_type_Int - this.e * 2, this.jdField_b_of_type_Int - this.e * 2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int), 0.0F, 90.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      break;
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(paramInt1, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(paramInt1, this.jdField_b_of_type_Int);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    if ((this.jdField_b_of_type_Long <= 0L) && (this.jdField_a_of_type_Long <= 0L) && (this.jdField_a_of_type_AndroidGraphicsRectF != null))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.g);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.e, this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_AndroidGraphicsPath != null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.e, this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.i);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.e = ((int)(this.jdField_b_of_type_Int * 0.16F));
      a(this.d, this.c, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.right = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = this.jdField_b_of_type_Int;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.AnimationableProgressView
 * JD-Core Version:    0.7.0.1
 */