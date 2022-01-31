package com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.utils.DynamicUnitUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Arrays;
import java.util.List;

@SuppressLint({"AppCompatCustomView"})
public class RoundBorderImageView
  extends ImageView
{
  public static final String[] a;
  public static final int b;
  private double jdField_a_of_type_Double;
  private float jdField_a_of_type_Float;
  public int a;
  private DashPathEffect jdField_a_of_type_AndroidGraphicsDashPathEffect;
  public Paint a;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  public Rect a;
  public Drawable a;
  private ShapeDrawable jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable;
  public boolean a;
  public float[] a;
  private float jdField_b_of_type_Float;
  private DashPathEffect jdField_b_of_type_AndroidGraphicsDashPathEffect;
  public Paint b;
  public boolean b;
  public float[] b;
  private float c;
  @RoundBorderImageView.BadgeDisplayMode
  public int c;
  public boolean c;
  private int jdField_d_of_type_Int = DynamicUnitUtils.a(8.0F);
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = DynamicUnitUtils.a(8.0F);
  private boolean jdField_e_of_type_Boolean = true;
  private int f = DynamicUnitUtils.a(1.5F);
  private int g = 9;
  private int h = 5;
  private int i = -16776961;
  private int j = -7829368;
  private int k = DynamicUnitUtils.a(3.0F);
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "HUAWEI ALE-CL00" };
    if (Arrays.asList(jdField_a_of_type_ArrayOfJavaLangString).contains(Build.MODEL))
    {
      jdField_b_of_type_Int = 1;
      return;
    }
    jdField_b_of_type_Int = 0;
  }
  
  public RoundBorderImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundBorderImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 25;
    this.jdField_c_of_type_Int = 2;
    e();
  }
  
  private void d()
  {
    int n = 0;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    int m;
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      m = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(m, n, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + m, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + n);
      return;
      m = getWidth() - getPaddingRight() - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      continue;
      m = getWidth() - getPaddingRight() - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      n = getHeight() - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      continue;
      m = getWidth() - getPaddingRight() - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      n = getHeight() - -getPaddingBottom() - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.rgb(200, 200, 200));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.rgb(128, 128, 128));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[8];
    this.jdField_b_of_type_ArrayOfFloat = new float[8];
    this.jdField_d_of_type_Int = (this.jdField_e_of_type_Int - getPaddingTop() + this.f / 2);
    Arrays.fill(this.jdField_a_of_type_ArrayOfFloat, this.jdField_d_of_type_Int);
    Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable = new ShapeDrawable(new RoundRectShape(this.jdField_b_of_type_ArrayOfFloat, null, this.jdField_b_of_type_ArrayOfFloat));
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(-65536);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeWidth(this.f);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setAntiAlias(true);
  }
  
  private void f()
  {
    this.jdField_e_of_type_Int = (this.jdField_d_of_type_Int + getPaddingTop() - this.f / 2);
    Arrays.fill(this.jdField_a_of_type_ArrayOfFloat, this.jdField_d_of_type_Int);
    Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable = new ShapeDrawable(new RoundRectShape(this.jdField_b_of_type_ArrayOfFloat, null, this.jdField_b_of_type_ArrayOfFloat));
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(-65536);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeWidth(this.f);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setAntiAlias(true);
  }
  
  private void g()
  {
    int m = getWidth();
    int n = getHeight();
    this.jdField_a_of_type_Float = (m - (this.jdField_e_of_type_Int + this.f / 2.0F) * 2.0F);
    this.jdField_b_of_type_Float = (n - (this.jdField_e_of_type_Int + this.f / 2.0F) * 2.0F);
    this.jdField_a_of_type_Double = (this.jdField_e_of_type_Int * 3.141592653589793D / 2.0D);
    RectF localRectF = new RectF(this.f / 2.0F, this.f / 2.0F, m - this.f / 2.0F, n - this.f / 2.0F);
    Path localPath = new Path();
    localPath.addRoundRect(localRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
    this.jdField_c_of_type_Float = new PathMeasure(localPath, true).getLength();
    SLog.b("RoundBorderImageView", "width=%d, height=%d, hLength=%f, vLength=%f, roundLength=%f, mStrokeWidth=%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Float.valueOf(this.jdField_a_of_type_Float), Float.valueOf(this.jdField_b_of_type_Float), Double.valueOf(this.jdField_a_of_type_Double), Integer.valueOf(this.f) });
    localRectF = new RectF(getPaddingLeft(), getPaddingTop(), m - getPaddingRight(), n - getPaddingBottom());
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.f / 2, this.f / 2, m - this.f / 2, n - this.f / 2);
    if (this.jdField_c_of_type_Float > 0.0F)
    {
      this.jdField_a_of_type_Int = ((int)Math.floor(this.jdField_c_of_type_Float * 1.0F / (this.k * 2)));
      SLog.a("RoundBorderImageView", "mBoarderLength = %f, gapLength = %d, max segment count = %d", Float.valueOf(this.jdField_c_of_type_Float), Integer.valueOf(this.k), Integer.valueOf(this.jdField_a_of_type_Int));
      return;
    }
    this.jdField_a_of_type_Int = 1;
    SLog.a("RoundBorderImageView", "mBoarderLength = %f, gapLength = %d, max segment count fallback to %d", Float.valueOf(this.jdField_c_of_type_Float), Integer.valueOf(this.k), Integer.valueOf(this.jdField_a_of_type_Int));
  }
  
  float a()
  {
    if (jdField_b_of_type_Int == 0) {
      return (float)-(this.jdField_b_of_type_Float + this.jdField_a_of_type_Double + this.jdField_a_of_type_Float / 2.0F + this.k / 2);
    }
    return this.jdField_a_of_type_Float / 2.0F - this.k;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    invalidate();
  }
  
  public void a(float paramFloat)
  {
    int m = DynamicUnitUtils.a(paramFloat);
    if (m != this.f)
    {
      this.f = m;
      f();
      g();
      c();
      invalidate();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  protected void b()
  {
    d();
    g();
    c();
    invalidate();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void c()
  {
    int i1 = 0;
    int n = 0;
    int m = Math.min(this.jdField_a_of_type_Int, this.g);
    Math.min(this.jdField_a_of_type_Int, this.h);
    if (this.g > this.jdField_a_of_type_Int)
    {
      float f2 = (float)Math.floor(this.jdField_c_of_type_Float * 0.5D / this.g);
      f1 = f2;
      if (f2 < this.f + DynamicUnitUtils.a(1.0F)) {
        f1 = this.f + DynamicUnitUtils.a(1.0F);
      }
      f2 = a();
      d1 = this.jdField_c_of_type_Float / this.g - f1;
      if ((d1 <= 0.0D) || (Double.isNaN(d1)) || (m <= 1))
      {
        this.jdField_a_of_type_AndroidGraphicsDashPathEffect = null;
        this.jdField_b_of_type_AndroidGraphicsDashPathEffect = null;
        return;
      }
      arrayOfFloat = new float[this.g * 2];
      m = 0;
      while (m < this.g * 2)
      {
        arrayOfFloat[m] = ((float)d1);
        arrayOfFloat[(m + 1)] = f1;
        m += 2;
      }
      this.jdField_a_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(arrayOfFloat, f2);
      arrayOfFloat = new float[this.g * 2];
      m = n;
      if (m < this.g * 2)
      {
        if (m < this.h * 2)
        {
          arrayOfFloat[m] = ((float)d1);
          arrayOfFloat[(m + 1)] = f1;
        }
        for (;;)
        {
          m += 2;
          break;
          arrayOfFloat[m] = 0.0F;
          arrayOfFloat[(m + 1)] = ((float)d1 + f1);
        }
      }
      this.jdField_b_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(arrayOfFloat, f2);
      return;
    }
    float f1 = a();
    double d1 = this.jdField_c_of_type_Float / this.g - this.k;
    if ((d1 <= 0.0D) || (Double.isNaN(d1)) || (this.g <= 1))
    {
      this.jdField_a_of_type_AndroidGraphicsDashPathEffect = null;
      this.jdField_b_of_type_AndroidGraphicsDashPathEffect = null;
      return;
    }
    float[] arrayOfFloat = new float[this.g * 2];
    m = 0;
    while (m < this.g * 2)
    {
      arrayOfFloat[m] = ((float)d1);
      arrayOfFloat[(m + 1)] = this.k;
      m += 2;
    }
    this.jdField_a_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(arrayOfFloat, f1);
    arrayOfFloat = new float[this.g * 2];
    m = i1;
    if (m < this.g * 2)
    {
      if (m < this.h * 2)
      {
        arrayOfFloat[m] = ((float)d1);
        arrayOfFloat[(m + 1)] = this.k;
      }
      for (;;)
      {
        m += 2;
        break;
        arrayOfFloat[m] = 0.0F;
        arrayOfFloat[(m + 1)] = ((float)d1 + this.k);
      }
    }
    this.jdField_b_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(arrayOfFloat, f1);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = 0;
    int m = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(m);
    m = paramCanvas.getSaveCount();
    paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setPathEffect(this.jdField_a_of_type_AndroidGraphicsDashPathEffect);
      this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(this.i);
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.draw(paramCanvas);
      }
      paramCanvas.restoreToCount(m);
      m = paramCanvas.getSaveCount();
      paramCanvas.save();
      if ((this.jdField_c_of_type_Boolean) && (this.h > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
        if (!this.jdField_e_of_type_Boolean) {
          break label276;
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setPathEffect(this.jdField_b_of_type_AndroidGraphicsDashPathEffect);
      }
    }
    int n;
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(this.j);
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.draw(paramCanvas);
      }
      paramCanvas.restoreToCount(m);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      m = 0;
      for (;;)
      {
        n = i1;
        if (m >= getWidth()) {
          break;
        }
        paramCanvas.drawLine(m, 0.0F, m, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
        m += 40;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setPathEffect(null);
      break;
      label276:
      this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setPathEffect(null);
    }
    while (n < getHeight())
    {
      paramCanvas.drawLine(0.0F, n, getWidth(), n, this.jdField_a_of_type_AndroidGraphicsPaint);
      n += 40;
    }
    paramCanvas.drawLine(0.0F, getHeight() / 2.0F, getWidth(), getHeight() / 2.0F, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawLine(getWidth() / 2.0F, 0.0F, getWidth() / 2, getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void setBadgeIcon(int paramInt1, @RoundBorderImageView.BadgeDisplayMode int paramInt2)
  {
    if (paramInt1 == 0) {}
    for (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;; this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt1))
    {
      this.jdField_c_of_type_Int = paramInt2;
      d();
      invalidate();
      return;
    }
  }
  
  public void setBadgeIcon(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int m = 2;; m = 3)
    {
      setBadgeIcon(paramInt, m);
      return;
    }
  }
  
  public void setSegmentAttrs(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    this.j = paramInt4;
    c();
    invalidate();
  }
  
  public void setSegmentColor(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    invalidate();
  }
  
  public void setSegmentCount(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    c();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView
 * JD-Core Version:    0.7.0.1
 */