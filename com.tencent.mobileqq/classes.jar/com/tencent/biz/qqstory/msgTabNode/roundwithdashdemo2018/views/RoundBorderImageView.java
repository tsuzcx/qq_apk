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
  public static final String[] m = { "HUAWEI ALE-CL00" };
  public static final int n = 0;
  private int A = AIOUtils.b(3.0F, getResources());
  private float B = 0.0F;
  private boolean C = true;
  private DashPathEffect D;
  private DashPathEffect E;
  private Path F;
  private boolean G = false;
  public int a = AIOUtils.b(8.0F, getResources());
  public boolean b = false;
  public Paint c;
  public Paint d;
  public Drawable e;
  public boolean f = true;
  public float[] g;
  public float[] h;
  public Rect i;
  public boolean j = true;
  public int k = 25;
  public boolean l = false;
  @RoundBorderImageView.BadgeDisplayMode
  public int o = 2;
  private int p = AIOUtils.b(8.0F, getResources());
  private int q = AIOUtils.b(1.5F, getResources());
  private float r;
  private float s;
  private double t;
  private boolean u = true;
  private ShapeDrawable v;
  private int w = 9;
  private int x = 5;
  private int y = -16776961;
  private int z = -7829368;
  
  static
  {
    if (Arrays.asList(m).contains(Build.MODEL))
    {
      n = 1;
      return;
    }
  }
  
  public RoundBorderImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundBorderImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  private void d()
  {
    if (this.e == null) {
      return;
    }
    int i2 = this.o;
    int i1 = 0;
    if (i2 != 1) {
      if (i2 != 2) {
        if (i2 == 3) {}
      }
    }
    for (;;)
    {
      i2 = 0;
      break;
      i1 = getWidth() - getPaddingRight() - this.e.getIntrinsicWidth();
      i2 = getHeight() - -getPaddingBottom();
      int i3 = this.e.getIntrinsicHeight();
      break label106;
      i1 = getWidth() - getPaddingRight() - this.e.getIntrinsicWidth();
      i2 = getHeight();
      i3 = this.e.getIntrinsicHeight();
      label106:
      i2 -= i3;
      break;
      i1 = getWidth() - getPaddingRight() - this.e.getIntrinsicWidth();
    }
    Drawable localDrawable = this.e;
    localDrawable.setBounds(i1, i2, localDrawable.getIntrinsicWidth() + i1, this.e.getIntrinsicHeight() + i2);
  }
  
  private void e()
  {
    this.c = new Paint();
    this.c.setColor(Color.rgb(200, 200, 200));
    this.c.setStrokeWidth(1.0F);
    this.d = new Paint();
    this.d.setColor(Color.rgb(128, 128, 128));
    this.d.setStrokeWidth(1.0F);
    this.g = new float[8];
    this.h = new float[8];
    this.a = (this.p - getPaddingTop() + this.q / 2);
    Arrays.fill(this.g, this.a);
    Arrays.fill(this.h, this.p);
    float[] arrayOfFloat = this.h;
    this.v = new ShapeDrawable(new RoundRectShape(arrayOfFloat, null, arrayOfFloat));
    this.v.getPaint().setColor(-65536);
    this.v.getPaint().setStrokeWidth(this.q);
    this.v.getPaint().setStyle(Paint.Style.STROKE);
    this.v.getPaint().setStrokeCap(Paint.Cap.ROUND);
    this.v.getPaint().setAntiAlias(true);
  }
  
  private void f()
  {
    this.p = (this.a + getPaddingTop() - this.q / 2);
    Arrays.fill(this.g, this.a);
    Arrays.fill(this.h, this.p);
    float[] arrayOfFloat = this.h;
    this.v = new ShapeDrawable(new RoundRectShape(arrayOfFloat, null, arrayOfFloat));
    this.v.getPaint().setColor(-65536);
    this.v.getPaint().setStrokeWidth(this.q);
    this.v.getPaint().setStyle(Paint.Style.STROKE);
    this.v.getPaint().setStrokeCap(Paint.Cap.ROUND);
    this.v.getPaint().setAntiAlias(true);
  }
  
  private void g()
  {
    int i1 = getWidth();
    int i2 = getHeight();
    float f1 = i1;
    int i3 = this.p;
    float f2 = i3;
    int i4 = this.q;
    this.r = (f1 - (f2 + i4 / 2.0F) * 2.0F);
    f2 = i2;
    this.s = (f2 - (i3 + i4 / 2.0F) * 2.0F);
    double d1 = i3;
    Double.isNaN(d1);
    this.t = (d1 * 3.141592653589793D / 2.0D);
    RectF localRectF = new RectF(i4 / 2.0F, i4 / 2.0F, f1 - i4 / 2.0F, f2 - i4 / 2.0F);
    Path localPath = new Path();
    localPath.addRoundRect(localRectF, this.h, Path.Direction.CW);
    this.B = new PathMeasure(localPath, true).getLength();
    SLog.b("RoundBorderImageView", "width=%d, height=%d, hLength=%f, vLength=%f, roundLength=%f, mStrokeWidth=%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Float.valueOf(this.r), Float.valueOf(this.s), Double.valueOf(this.t), Integer.valueOf(this.q) });
    localRectF = new RectF(getPaddingLeft(), getPaddingTop(), i1 - getPaddingRight(), i2 - getPaddingBottom());
    this.F = new Path();
    this.F.addRoundRect(localRectF, this.g, Path.Direction.CW);
    i3 = this.q;
    this.i = new Rect(i3 / 2, i3 / 2, i1 - i3 / 2, i2 - i3 / 2);
    f1 = this.B;
    if (f1 > 0.0F)
    {
      this.k = ((int)Math.floor(f1 * 1.0F / (this.A * 2)));
      SLog.a("RoundBorderImageView", "mBoarderLength = %f, gapLength = %d, max segment count = %d", Float.valueOf(this.B), Integer.valueOf(this.A), Integer.valueOf(this.k));
      return;
    }
    this.k = 1;
    SLog.a("RoundBorderImageView", "mBoarderLength = %f, gapLength = %d, max segment count fallback to %d", Float.valueOf(f1), Integer.valueOf(this.A), Integer.valueOf(this.k));
  }
  
  public void a()
  {
    this.e = null;
    invalidate();
  }
  
  public void a(float paramFloat)
  {
    int i1 = AIOUtils.b(paramFloat, getResources());
    if (i1 != this.q)
    {
      this.q = i1;
      f();
      g();
      c();
      invalidate();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.G = paramBoolean;
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
          int i1 = paramDrawable.getIntrinsicWidth();
          int i2 = paramDrawable.getIntrinsicHeight();
          paramDrawable = ImageView.class.getDeclaredField("mDrawableWidth");
          Field localField = ImageView.class.getDeclaredField("mDrawableHeight");
          paramDrawable.setAccessible(true);
          localField.setAccessible(true);
          int i3 = ((Integer)paramDrawable.get(this)).intValue();
          int i4 = ((Integer)localField.get(this)).intValue();
          if ((i3 != i1) || (i4 != i2))
          {
            paramDrawable.setInt(this, i1);
            localField.setInt(this, i2);
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
    this.u = paramBoolean;
    invalidate();
  }
  
  public void c()
  {
    int i1 = Math.min(this.k, this.w);
    Math.min(this.k, this.x);
    int i4 = this.w;
    int i5 = this.k;
    int i2 = 0;
    int i3 = 0;
    float[] arrayOfFloat;
    if (i4 > i5)
    {
      d1 = this.B;
      Double.isNaN(d1);
      double d2 = i4;
      Double.isNaN(d2);
      float f2 = (float)Math.floor(d1 * 0.5D / d2);
      f1 = f2;
      if (f2 < this.q + AIOUtils.b(1.0F, getResources())) {
        f1 = this.q + AIOUtils.b(1.0F, getResources());
      }
      f2 = getDashOffset();
      d1 = this.B / this.w - f1;
      if ((d1 > 0.0D) && (!Double.isNaN(d1)) && (i1 > 1))
      {
        arrayOfFloat = new float[this.w * 2];
        i1 = 0;
        while (i1 < this.w * 2)
        {
          arrayOfFloat[i1] = ((float)d1);
          arrayOfFloat[(i1 + 1)] = f1;
          i1 += 2;
        }
        this.D = new DashPathEffect(arrayOfFloat, f2);
        arrayOfFloat = new float[this.w * 2];
        i1 = i3;
        while (i1 < this.w * 2)
        {
          if (i1 < this.x * 2)
          {
            arrayOfFloat[i1] = ((float)d1);
            arrayOfFloat[(i1 + 1)] = f1;
          }
          else
          {
            arrayOfFloat[i1] = 0.0F;
            arrayOfFloat[(i1 + 1)] = ((float)d1 + f1);
          }
          i1 += 2;
        }
        this.E = new DashPathEffect(arrayOfFloat, f2);
        return;
      }
      this.D = null;
      this.E = null;
      return;
    }
    float f1 = getDashOffset();
    double d1 = this.B / this.w - this.A;
    if ((d1 > 0.0D) && (!Double.isNaN(d1)))
    {
      i1 = this.w;
      if (i1 > 1)
      {
        arrayOfFloat = new float[i1 * 2];
        i1 = 0;
        while (i1 < this.w * 2)
        {
          arrayOfFloat[i1] = ((float)d1);
          arrayOfFloat[(i1 + 1)] = this.A;
          i1 += 2;
        }
        this.D = new DashPathEffect(arrayOfFloat, f1);
        arrayOfFloat = new float[this.w * 2];
        i1 = i2;
        while (i1 < this.w * 2)
        {
          if (i1 < this.x * 2)
          {
            arrayOfFloat[i1] = ((float)d1);
            arrayOfFloat[(i1 + 1)] = this.A;
          }
          else
          {
            arrayOfFloat[i1] = 0.0F;
            arrayOfFloat[(i1 + 1)] = ((float)d1 + this.A);
          }
          i1 += 2;
        }
        this.E = new DashPathEffect(arrayOfFloat, f1);
        SLog.a("RoundBorderImageView", "buildDashes length (%d), %s, %s, hash:%d", Integer.valueOf(arrayOfFloat.length), this.D, this.E, Integer.valueOf(hashCode()));
        return;
      }
    }
    this.D = null;
    this.E = null;
  }
  
  float getDashOffset()
  {
    if (n == 0)
    {
      double d1 = this.s;
      double d2 = this.t;
      Double.isNaN(d1);
      double d3 = this.r / 2.0F;
      Double.isNaN(d3);
      double d4 = this.A / 2;
      Double.isNaN(d4);
      return (float)-(d1 + d2 + d3 + d4);
    }
    return this.r / 2.0F - this.A;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    if (this.l) {
      SLog.a("RoundBorderImageView", "[DEBUG] before invalidateDrawable %d %d type %s, matrix:%s", Integer.valueOf(getDrawable().getIntrinsicWidth()), Integer.valueOf(getDrawable().getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
    if (a(paramDrawable)) {
      SLog.b("RoundBorderImageView", "[PATCH] PATCH for vivo");
    } else {
      super.invalidateDrawable(paramDrawable);
    }
    if (this.l) {
      SLog.a("RoundBorderImageView", "[DEBUG] after invalidateDrawable %d %d type %s, matrix:%s", Integer.valueOf(getDrawable().getIntrinsicWidth()), Integer.valueOf(getDrawable().getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
    paramDrawable = getDrawable();
    if (((paramDrawable instanceof URLDrawable)) && ((((URLDrawable)paramDrawable).getCurrDrawable() instanceof GifDrawable)) && ((Build.MODEL.equalsIgnoreCase("MI 8")) || (Build.MODEL.equalsIgnoreCase("VIVO NEX A")) || (Build.MODEL.equalsIgnoreCase("PACM00")) || (Build.MODEL.equalsIgnoreCase("PAFM00")))) {
      requestLayout();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.clipPath(this.F);
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(i1);
    if (this.G) {
      paramCanvas.drawColor(Color.parseColor("#7fffffff"));
    }
    Drawable localDrawable = this.e;
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
    if (this.l) {
      SLog.a("RoundBorderImageView", "[DEBUG] requestLayout %d %d type %s, matrix:%s", Integer.valueOf(getDrawable().getIntrinsicWidth()), Integer.valueOf(getDrawable().getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
    super.requestLayout();
  }
  
  public void setBadgeIcon(int paramInt1, @RoundBorderImageView.BadgeDisplayMode int paramInt2)
  {
    if (paramInt1 == 0) {
      this.e = null;
    } else {
      this.e = getResources().getDrawable(paramInt1);
    }
    this.o = paramInt2;
    d();
    invalidate();
  }
  
  public void setBadgeIcon(int paramInt, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 2;
    } else {
      i1 = 3;
    }
    setBadgeIcon(paramInt, i1);
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    if ((this.l) && (paramDrawable != null)) {
      SLog.a("RoundBorderImageView", "[DEBUG] before set %d %d type %s matrix:%s", Integer.valueOf(paramDrawable.getIntrinsicWidth()), Integer.valueOf(paramDrawable.getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
    super.setImageDrawable(paramDrawable);
    if ((this.l) && (paramDrawable != null)) {
      SLog.a("RoundBorderImageView", "[DEBUG] after set %d %d type %s, matrix:%s", Integer.valueOf(paramDrawable.getIntrinsicWidth()), Integer.valueOf(paramDrawable.getIntrinsicHeight()), getScaleType(), getImageMatrix().toShortString());
    }
  }
  
  public void setSegmentAttrs(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.w = paramInt1;
    this.x = paramInt2;
    this.y = paramInt3;
    this.z = paramInt4;
    c();
    invalidate();
  }
  
  public void setSegmentColor(int paramInt1, int paramInt2)
  {
    this.y = paramInt1;
    this.z = paramInt2;
    invalidate();
  }
  
  public void setSegmentCount(int paramInt1, int paramInt2)
  {
    this.w = paramInt1;
    this.x = paramInt2;
    f();
    c();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView
 * JD-Core Version:    0.7.0.1
 */