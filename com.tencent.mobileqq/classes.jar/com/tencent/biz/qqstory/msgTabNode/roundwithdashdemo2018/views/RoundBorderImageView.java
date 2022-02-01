package com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@SuppressLint({"AppCompatCustomView"})
public class RoundBorderImageView
  extends ImageView
{
  public static final String[] a;
  public static final int c;
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
  public int b;
  private DashPathEffect jdField_b_of_type_AndroidGraphicsDashPathEffect;
  public Paint b;
  public boolean b;
  public float[] b;
  private float c;
  public boolean c;
  @RoundBorderImageView.BadgeDisplayMode
  public int d;
  public boolean d;
  private int jdField_e_of_type_Int = AIOUtils.b(8.0F, getResources());
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = AIOUtils.b(1.5F, getResources());
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int = 9;
  private boolean jdField_g_of_type_Boolean = false;
  private int h = 5;
  private int i = -16776961;
  private int j = -7829368;
  private int k = AIOUtils.b(3.0F, getResources());
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "HUAWEI ALE-CL00" };
    if (Arrays.asList(jdField_a_of_type_ArrayOfJavaLangString).contains(Build.MODEL))
    {
      jdField_c_of_type_Int = 1;
      return;
    }
    jdField_c_of_type_Int = 0;
  }
  
  public RoundBorderImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundBorderImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = AIOUtils.b(8.0F, getResources());
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 25;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 2;
    e();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    int n = this.jdField_d_of_type_Int;
    int m = 0;
    if (n != 1) {
      if (n != 2) {
        if (n == 3) {}
      }
    }
    for (;;)
    {
      n = 0;
      break;
      m = getWidth() - getPaddingRight() - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      n = getHeight() - -getPaddingBottom();
      int i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      break label106;
      m = getWidth() - getPaddingRight() - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      n = getHeight();
      i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      label106:
      n -= i1;
      break;
      m = getWidth() - getPaddingRight() - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    }
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localDrawable.setBounds(m, n, localDrawable.getIntrinsicWidth() + m, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + n);
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
    this.jdField_a_of_type_Int = (this.jdField_e_of_type_Int - getPaddingTop() + this.jdField_f_of_type_Int / 2);
    Arrays.fill(this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_Int);
    Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, this.jdField_e_of_type_Int);
    float[] arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable = new ShapeDrawable(new RoundRectShape(arrayOfFloat, null, arrayOfFloat));
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(-65536);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeWidth(this.jdField_f_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setAntiAlias(true);
  }
  
  private void f()
  {
    this.jdField_e_of_type_Int = (this.jdField_a_of_type_Int + getPaddingTop() - this.jdField_f_of_type_Int / 2);
    Arrays.fill(this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_Int);
    Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, this.jdField_e_of_type_Int);
    float[] arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable = new ShapeDrawable(new RoundRectShape(arrayOfFloat, null, arrayOfFloat));
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(-65536);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeWidth(this.jdField_f_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setAntiAlias(true);
  }
  
  private void g()
  {
    int m = getWidth();
    int n = getHeight();
    float f1 = m;
    int i1 = this.jdField_e_of_type_Int;
    float f2 = i1;
    int i2 = this.jdField_f_of_type_Int;
    this.jdField_a_of_type_Float = (f1 - (f2 + i2 / 2.0F) * 2.0F);
    f2 = n;
    this.jdField_b_of_type_Float = (f2 - (i1 + i2 / 2.0F) * 2.0F);
    double d1 = i1;
    Double.isNaN(d1);
    this.jdField_a_of_type_Double = (d1 * 3.141592653589793D / 2.0D);
    RectF localRectF = new RectF(i2 / 2.0F, i2 / 2.0F, f1 - i2 / 2.0F, f2 - i2 / 2.0F);
    Path localPath = new Path();
    localPath.addRoundRect(localRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
    this.jdField_c_of_type_Float = new PathMeasure(localPath, true).getLength();
    SLog.b("RoundBorderImageView", "width=%d, height=%d, hLength=%f, vLength=%f, roundLength=%f, mStrokeWidth=%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Float.valueOf(this.jdField_a_of_type_Float), Float.valueOf(this.jdField_b_of_type_Float), Double.valueOf(this.jdField_a_of_type_Double), Integer.valueOf(this.jdField_f_of_type_Int) });
    localRectF = new RectF(getPaddingLeft(), getPaddingTop(), m - getPaddingRight(), n - getPaddingBottom());
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
    i1 = this.jdField_f_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i1 / 2, i1 / 2, m - i1 / 2, n - i1 / 2);
    f1 = this.jdField_c_of_type_Float;
    if (f1 > 0.0F)
    {
      this.jdField_b_of_type_Int = ((int)Math.floor(f1 * 1.0F / (this.k * 2)));
      SLog.a("RoundBorderImageView", "mBoarderLength = %f, gapLength = %d, max segment count = %d", Float.valueOf(this.jdField_c_of_type_Float), Integer.valueOf(this.k), Integer.valueOf(this.jdField_b_of_type_Int));
      return;
    }
    this.jdField_b_of_type_Int = 1;
    SLog.a("RoundBorderImageView", "mBoarderLength = %f, gapLength = %d, max segment count fallback to %d", Float.valueOf(f1), Integer.valueOf(this.k), Integer.valueOf(this.jdField_b_of_type_Int));
  }
  
  float a()
  {
    if (jdField_c_of_type_Int == 0)
    {
      double d1 = this.jdField_b_of_type_Float;
      double d2 = this.jdField_a_of_type_Double;
      Double.isNaN(d1);
      double d3 = this.jdField_a_of_type_Float / 2.0F;
      Double.isNaN(d3);
      double d4 = this.k / 2;
      Double.isNaN(d4);
      return (float)-(d1 + d2 + d3 + d4);
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
    int m = AIOUtils.b(paramFloat, getResources());
    if (m != this.jdField_f_of_type_Int)
    {
      this.jdField_f_of_type_Int = m;
      f();
      g();
      c();
      invalidate();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public boolean a(Drawable paramDrawable)
  {
    if ((!Build.MODEL.equalsIgnoreCase("vivo X7Plus")) && (!Build.MODEL.equalsIgnoreCase("vivo X6S A"))) {
      return false;
    }
    try
    {
      if (paramDrawable == getDrawable())
      {
        if (paramDrawable != null)
        {
          int m = paramDrawable.getIntrinsicWidth();
          int n = paramDrawable.getIntrinsicHeight();
          paramDrawable = ImageView.class.getDeclaredField("mDrawableWidth");
          Field localField = ImageView.class.getDeclaredField("mDrawableHeight");
          paramDrawable.setAccessible(true);
          localField.setAccessible(true);
          int i1 = ((Integer)paramDrawable.get(this)).intValue();
          int i2 = ((Integer)localField.get(this)).intValue();
          if ((i1 != m) || (i2 != n))
          {
            paramDrawable.setInt(this, m);
            localField.setInt(this, n);
            paramDrawable = ImageView.class.getDeclaredMethod("configureBounds", new Class[0]);
            paramDrawable.setAccessible(true);
            paramDrawable.invoke(this, new Object[0]);
          }
        }
        invalidate();
        return true;
      }
      return false;
    }
    catch (IllegalAccessException|NoSuchFieldException|NoSuchMethodException|InvocationTargetException paramDrawable) {}
    return false;
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
    this.jdField_e_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void c()
  {
    int m = Math.min(this.jdField_b_of_type_Int, this.jdField_g_of_type_Int);
    Math.min(this.jdField_b_of_type_Int, this.h);
    int i2 = this.jdField_g_of_type_Int;
    int i3 = this.jdField_b_of_type_Int;
    int n = 0;
    int i1 = 0;
    float[] arrayOfFloat;
    if (i2 > i3)
    {
      d1 = this.jdField_c_of_type_Float;
      Double.isNaN(d1);
      double d2 = i2;
      Double.isNaN(d2);
      float f2 = (float)Math.floor(d1 * 0.5D / d2);
      f1 = f2;
      if (f2 < this.jdField_f_of_type_Int + AIOUtils.b(1.0F, getResources())) {
        f1 = this.jdField_f_of_type_Int + AIOUtils.b(1.0F, getResources());
      }
      f2 = a();
      d1 = this.jdField_c_of_type_Float / this.jdField_g_of_type_Int - f1;
      if ((d1 > 0.0D) && (!Double.isNaN(d1)) && (m > 1))
      {
        arrayOfFloat = new float[this.jdField_g_of_type_Int * 2];
        m = 0;
        while (m < this.jdField_g_of_type_Int * 2)
        {
          arrayOfFloat[m] = ((float)d1);
          arrayOfFloat[(m + 1)] = f1;
          m += 2;
        }
        this.jdField_a_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(arrayOfFloat, f2);
        arrayOfFloat = new float[this.jdField_g_of_type_Int * 2];
        m = i1;
        while (m < this.jdField_g_of_type_Int * 2)
        {
          if (m < this.h * 2)
          {
            arrayOfFloat[m] = ((float)d1);
            arrayOfFloat[(m + 1)] = f1;
          }
          else
          {
            arrayOfFloat[m] = 0.0F;
            arrayOfFloat[(m + 1)] = ((float)d1 + f1);
          }
          m += 2;
        }
        this.jdField_b_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(arrayOfFloat, f2);
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsDashPathEffect = null;
      this.jdField_b_of_type_AndroidGraphicsDashPathEffect = null;
      return;
    }
    float f1 = a();
    double d1 = this.jdField_c_of_type_Float / this.jdField_g_of_type_Int - this.k;
    if ((d1 > 0.0D) && (!Double.isNaN(d1)))
    {
      m = this.jdField_g_of_type_Int;
      if (m > 1)
      {
        arrayOfFloat = new float[m * 2];
        m = 0;
        while (m < this.jdField_g_of_type_Int * 2)
        {
          arrayOfFloat[m] = ((float)d1);
          arrayOfFloat[(m + 1)] = this.k;
          m += 2;
        }
        this.jdField_a_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(arrayOfFloat, f1);
        arrayOfFloat = new float[this.jdField_g_of_type_Int * 2];
        m = n;
        while (m < this.jdField_g_of_type_Int * 2)
        {
          if (m < this.h * 2)
          {
            arrayOfFloat[m] = ((float)d1);
            arrayOfFloat[(m + 1)] = this.k;
          }
          else
          {
            arrayOfFloat[m] = 0.0F;
            arrayOfFloat[(m + 1)] = ((float)d1 + this.k);
          }
          m += 2;
        }
        this.jdField_b_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(arrayOfFloat, f1);
        SLog.a("RoundBorderImageView", "buildDashes length (%d), %s, %s, hash:%d", Integer.valueOf(arrayOfFloat.length), this.jdField_a_of_type_AndroidGraphicsDashPathEffect, this.jdField_b_of_type_AndroidGraphicsDashPathEffect, Integer.valueOf(hashCode()));
        return;
      }
    }
    this.jdField_a_of_type_AndroidGraphicsDashPathEffect = null;
    this.jdField_b_of_type_AndroidGraphicsDashPathEffect = null;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    if (this.jdField_d_of_type_Boolean) {
      SLog.a("RoundBorderImageView", "[DEBUG] before invalidateDrawable %d %d type %s, matrix:%s", Integer.valueOf(getDrawable().getIntrinsicWidth()), Integer.valueOf(getDrawable().getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
    if (a(paramDrawable)) {
      SLog.b("RoundBorderImageView", "[PATCH] PATCH for vivo");
    } else {
      super.invalidateDrawable(paramDrawable);
    }
    if (this.jdField_d_of_type_Boolean) {
      SLog.a("RoundBorderImageView", "[DEBUG] after invalidateDrawable %d %d type %s, matrix:%s", Integer.valueOf(getDrawable().getIntrinsicWidth()), Integer.valueOf(getDrawable().getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
    paramDrawable = getDrawable();
    if (((paramDrawable instanceof URLDrawable)) && ((((URLDrawable)paramDrawable).getCurrDrawable() instanceof GifDrawable)) && ((Build.MODEL.equalsIgnoreCase("MI 8")) || (Build.MODEL.equalsIgnoreCase("VIVO NEX A")) || (Build.MODEL.equalsIgnoreCase("PACM00")) || (Build.MODEL.equalsIgnoreCase("PAFM00")))) {
      requestLayout();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(m);
    if (this.jdField_g_of_type_Boolean) {
      paramCanvas.drawColor(Color.parseColor("#7fffffff"));
    }
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void requestLayout()
  {
    if (this.jdField_d_of_type_Boolean) {
      SLog.a("RoundBorderImageView", "[DEBUG] requestLayout %d %d type %s, matrix:%s", Integer.valueOf(getDrawable().getIntrinsicWidth()), Integer.valueOf(getDrawable().getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
    super.requestLayout();
  }
  
  public void setBadgeIcon(int paramInt1, @RoundBorderImageView.BadgeDisplayMode int paramInt2)
  {
    if (paramInt1 == 0) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    } else {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt1);
    }
    this.jdField_d_of_type_Int = paramInt2;
    d();
    invalidate();
  }
  
  public void setBadgeIcon(int paramInt, boolean paramBoolean)
  {
    int m;
    if (paramBoolean) {
      m = 2;
    } else {
      m = 3;
    }
    setBadgeIcon(paramInt, m);
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    if ((this.jdField_d_of_type_Boolean) && (paramDrawable != null)) {
      SLog.a("RoundBorderImageView", "[DEBUG] before set %d %d type %s matrix:%s", Integer.valueOf(paramDrawable.getIntrinsicWidth()), Integer.valueOf(paramDrawable.getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
    super.setImageDrawable(paramDrawable);
    if ((this.jdField_d_of_type_Boolean) && (paramDrawable != null)) {
      SLog.a("RoundBorderImageView", "[DEBUG] after set %d %d type %s, matrix:%s", Integer.valueOf(paramDrawable.getIntrinsicWidth()), Integer.valueOf(paramDrawable.getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
  }
  
  public void setSegmentAttrs(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_g_of_type_Int = paramInt1;
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
    this.jdField_g_of_type_Int = paramInt1;
    this.h = paramInt2;
    f();
    c();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView
 * JD-Core Version:    0.7.0.1
 */