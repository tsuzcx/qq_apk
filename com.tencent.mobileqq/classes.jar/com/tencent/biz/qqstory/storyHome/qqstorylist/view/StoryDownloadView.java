package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.animation.AnimatorSet;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

@TargetApi(11)
public class StoryDownloadView
  extends View
{
  public static final int a;
  public static final int b;
  public static final int c;
  public float a;
  public AnimatorSet a;
  public boolean a;
  public float b;
  public AnimatorSet b;
  public float c;
  public float d;
  public int d;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  public float j;
  public float k;
  public float l;
  public float m;
  public float n;
  public float o;
  public float p;
  public float q;
  public float r = -45.0F;
  public float s = 0.1F;
  
  static
  {
    jdField_a_of_type_Int = Color.parseColor("#FFFFFF");
    jdField_b_of_type_Int = Color.parseColor("#BCBFC4");
    jdField_c_of_type_Int = Color.parseColor("#7f8393");
  }
  
  public StoryDownloadView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StoryDownloadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
    a(this.jdField_a_of_type_Float);
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 * super.getContext().getResources().getDisplayMetrics().density + 0.5F) * paramFloat2;
  }
  
  private void a(float paramFloat)
  {
    this.jdField_b_of_type_Float = a(46.0F, paramFloat);
    this.jdField_c_of_type_Float = a(46.0F, paramFloat);
    this.jdField_d_of_type_Float = a(5.0F, paramFloat);
    this.e = a(5.0F, paramFloat);
    this.f = a(6.0F, paramFloat);
    this.g = a(4.0F, paramFloat);
    this.h = a(5.0F, paramFloat);
    this.i = a(2.0F, paramFloat);
    this.j = a(18.0F, paramFloat);
    this.k = (this.jdField_c_of_type_Float - a(7.0F, paramFloat));
    this.l = a(6.0F, paramFloat);
    this.m = a(28.0F, paramFloat);
    this.n = (this.jdField_b_of_type_Float - a(8.0F, paramFloat));
    this.o = a(20.0F, paramFloat);
    this.p = this.f;
    this.q = (this.jdField_c_of_type_Float - this.g - this.h / 2.0F);
  }
  
  public void a()
  {
    this.jdField_d_of_type_Int = 0;
    super.setEnabled(true);
    b();
    super.invalidate();
  }
  
  public void a(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    int i1;
    if (this.jdField_a_of_type_Boolean) {
      i1 = jdField_a_of_type_Int;
    } else {
      i1 = jdField_c_of_type_Int;
    }
    localPaint.setColor(i1);
    localPaint.setAntiAlias(true);
    Object localObject = new Path();
    ((Path)localObject).moveTo(this.jdField_b_of_type_Float / 2.0F - this.h / 2.0F, this.p + this.i);
    ((Path)localObject).lineTo(this.jdField_b_of_type_Float / 2.0F - this.h / 2.0F, this.p + this.i + this.jdField_c_of_type_Float * 13.0F / 46.0F);
    float f1 = this.jdField_b_of_type_Float;
    ((Path)localObject).lineTo(f1 / 2.0F - this.h / 2.0F - f1 * 8.0F / 46.0F, this.p + this.i + this.jdField_c_of_type_Float * 13.0F / 46.0F);
    ((Path)localObject).lineTo(this.jdField_b_of_type_Float / 2.0F, this.p + this.i + this.jdField_c_of_type_Float * 25.0F / 46.0F);
    f1 = this.jdField_b_of_type_Float;
    ((Path)localObject).lineTo(f1 / 2.0F + this.h / 2.0F + f1 * 8.0F / 46.0F, this.p + this.i + this.jdField_c_of_type_Float * 13.0F / 46.0F);
    ((Path)localObject).lineTo(this.jdField_b_of_type_Float / 2.0F + this.h / 2.0F, this.p + this.i + this.jdField_c_of_type_Float * 13.0F / 46.0F);
    ((Path)localObject).lineTo(this.jdField_b_of_type_Float / 2.0F + this.h / 2.0F, this.p + this.i);
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath((Path)localObject, localPaint);
    f1 = this.jdField_b_of_type_Float;
    float f2 = f1 / 2.0F;
    float f3 = this.h;
    float f4 = f3 / 2.0F;
    float f5 = this.p;
    paramCanvas.drawArc(new RectF(f2 - f4, f5, f1 / 2.0F + f3 / 2.0F, this.i * 2.0F + f5), 180.0F, 360.0F, true, localPaint);
    f1 = this.jdField_b_of_type_Float - this.e - this.i;
    f3 = this.jdField_c_of_type_Float;
    f4 = this.g;
    f2 = f3 - f4 - this.h;
    f3 -= f4;
    localObject = new Path();
    ((Path)localObject).moveTo(this.jdField_d_of_type_Float + this.i, this.jdField_c_of_type_Float - this.g - this.h / 2.0F);
    ((Path)localObject).quadTo(this.jdField_b_of_type_Float / 2.0F, this.q, f1, this.jdField_c_of_type_Float - this.g - this.h / 2.0F);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.h);
    paramCanvas.drawPath((Path)localObject, localPaint);
    f4 = this.jdField_d_of_type_Float;
    localObject = new RectF(f4, f2, this.i * 2.0F + f4, f3);
    f4 = this.i;
    RectF localRectF = new RectF(f1 - f4, f2, f1 + f4, f3);
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawArc((RectF)localObject, 90.0F, 360.0F, true, localPaint);
    paramCanvas.drawArc(localRectF, -90.0F, 360.0F, true, localPaint);
  }
  
  public void b()
  {
    AnimatorSet localAnimatorSet = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.end();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
    localAnimatorSet = this.jdField_b_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.end();
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_b_of_type_AndroidAnimationAnimatorSet = null;
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    Path localPath = new Path();
    int i1;
    if (this.jdField_a_of_type_Boolean) {
      i1 = jdField_a_of_type_Int;
    } else {
      i1 = jdField_c_of_type_Int;
    }
    localPaint.setColor(i1);
    localPaint.setAntiAlias(true);
    localPaint.setStrokeWidth(this.h);
    localPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.save();
    paramCanvas.rotate(this.r, this.j, this.k);
    float f1 = this.s;
    paramCanvas.scale(f1, f1, this.j, this.k);
    localPath.moveTo(this.l, this.m);
    localPath.lineTo(this.j, this.k);
    localPath.moveTo(this.j, this.k);
    localPath.lineTo(this.n, this.o);
    paramCanvas.drawPath(localPath, localPaint);
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.l, this.m, this.h / 2.0F, localPaint);
    paramCanvas.drawCircle(this.n, this.o, this.h / 2.0F, localPaint);
    paramCanvas.drawCircle(this.j, this.k, this.h / 2.0F, localPaint);
    paramCanvas.restore();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(super.getPaddingLeft(), super.getPaddingTop());
    int i1 = this.jdField_d_of_type_Int;
    if (i1 == 2)
    {
      b(paramCanvas);
      return;
    }
    if ((i1 == 1) || (i1 == 0)) {
      a(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    float f2 = 1.0F;
    float f1;
    if (i1 == 1073741824) {
      f1 = paramInt1 / a(46.0F, 1.0F);
    } else {
      f1 = 1.0F;
    }
    if (i2 == 1073741824) {
      f2 = paramInt2 / a(46.0F, 1.0F);
    }
    a(Math.min(f1, f2));
    super.setMeasuredDimension(super.getPaddingLeft() + (int)this.jdField_b_of_type_Float + super.getPaddingRight(), super.getPaddingTop() + (int)this.jdField_c_of_type_Float + super.getPaddingBottom());
  }
  
  public void setWhiteMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView
 * JD-Core Version:    0.7.0.1
 */