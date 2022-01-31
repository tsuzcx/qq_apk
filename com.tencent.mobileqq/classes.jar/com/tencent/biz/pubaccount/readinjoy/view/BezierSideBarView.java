package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import bbdv;
import qzj;

public class BezierSideBarView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  protected Paint a;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  protected Drawable a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private int c;
  private int d;
  
  public BezierSideBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BezierSideBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BezierSideBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_b_of_type_Float = ((int)bbdv.a(paramContext, 18.0F));
    this.jdField_a_of_type_Int = -16777216;
    this.d = ((int)bbdv.a(paramContext, 18.0F));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    paramAttributeSet = BitmapFactory.decodeResource(paramContext.getResources(), 2130842661);
    if (paramAttributeSet != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramAttributeSet, (int)bbdv.a(paramContext, 7.0F), (int)bbdv.a(paramContext, 12.0F), true);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_b_of_type_Int, a());
    int i = this.c - this.d * 2;
    int k = (int)(this.jdField_b_of_type_Int - this.d * Math.cos(0.7853981633974483D) * this.jdField_a_of_type_Float);
    int j = (int)(i + this.d * Math.sin(0.7853981633974483D));
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_b_of_type_Int, i, k, j);
    i = (int)(this.jdField_b_of_type_Int - a());
    j = this.c;
    int m = this.c + this.d * 2;
    int n = (int)(m - this.d * Math.cos(0.7853981633974483D));
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(i, j, k, n);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_b_of_type_Int, m, this.jdField_b_of_type_Int, b());
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      k = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      m = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      n = i + 50;
      int i1 = j - m / 2;
      Rect localRect1 = new Rect(0, 0, k, m);
      Rect localRect2 = new Rect(n, i1, k + n, m + i1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha((int)(this.jdField_a_of_type_Float * 255.0F));
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect1, localRect2, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      k = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
      paramCanvas.save();
      paramCanvas.translate(i + 50, j - k);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public double a()
  {
    return 1.8F * this.d * Math.sin(1.570796326794897D) * this.jdField_a_of_type_Float;
  }
  
  protected int a()
  {
    return this.c - this.d * 3;
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(float paramFloat, int paramInt)
  {
    this.c = paramInt;
    if (paramFloat < 0.0F) {
      return;
    }
    float f = paramFloat;
    if (paramFloat > this.jdField_b_of_type_Float) {
      f = this.jdField_b_of_type_Float;
    }
    this.jdField_a_of_type_Float = (f / this.jdField_b_of_type_Float);
    invalidate();
  }
  
  public void a(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setFloatValues(new float[] { this.jdField_a_of_type_Float, 0.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new qzj(this, paramAnimatorUpdateListener));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  protected int b()
  {
    return this.c + this.d * 2 + this.d;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_b_of_type_Int = getMeasuredWidth();
    this.c = (getMeasuredHeight() / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView
 * JD-Core Version:    0.7.0.1
 */