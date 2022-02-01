package com.tencent.biz.qqstory.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.R.styleable;
import java.util.Arrays;

public class RotateCircleImageView
  extends ImageView
{
  private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
  private static final int u = Color.parseColor("#4799FE");
  private static final int v = Color.parseColor("#19D7FD");
  private static final int w = u;
  private static final SparseArray<RotateCircleImageView.BorderStyle> x = new RotateCircleImageView.1(2);
  private ValueAnimator A;
  private int B = 1200;
  private int C = 2000;
  private int D = u;
  private int E = v;
  private ValueAnimator F;
  private ValueAnimator G;
  private float H;
  private Paint I = new Paint();
  private ValueAnimator J;
  private ValueAnimator K;
  private float L;
  private Paint M = new Paint();
  private DashPathEffect N = new DashPathEffect(new float[] { 10.0F, 10.0F }, 0.0F);
  private int[] O = { w };
  private int P = 0;
  private final RectF c = new RectF();
  private final RectF d = new RectF();
  private final Matrix e = new Matrix();
  private final Paint f = new Paint();
  private final Paint g = new Paint();
  private final Paint h = new Paint();
  private int i = 0;
  private int j = 0;
  private Bitmap k;
  private BitmapShader l;
  private int m;
  private int n;
  private float o;
  private ColorFilter p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private RotateCircleImageView.BorderStyle y = RotateCircleImageView.BorderStyle.STILL;
  private float z;
  
  public RotateCircleImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RotateCircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RotateCircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RotateCircleImageView, paramInt, 0);
    try
    {
      this.i = paramContext.getDimensionPixelSize(8, 0);
      this.s = paramContext.getBoolean(1, false);
      this.j = paramContext.getColor(9, 0);
      this.P = paramContext.getDimensionPixelSize(2, 0);
      this.D = paramContext.getColor(7, u);
      this.E = paramContext.getColor(7, v);
      this.C = paramContext.getInt(5, 2000);
      this.B = paramContext.getInt(3, 1200);
      setBorderStyle((RotateCircleImageView.BorderStyle)x.get(paramContext.getInt(4, RotateCircleImageView.BorderStyle.STILL.ordinal())));
      paramInt = paramContext.getResourceId(0, 0);
      if (paramInt != 0) {
        this.O = paramContext.getResources().getIntArray(paramInt);
      }
      paramContext.recycle();
      a();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      Bitmap localBitmap;
      if ((paramDrawable instanceof ColorDrawable)) {
        localBitmap = Bitmap.createBitmap(2, 2, b);
      } else {
        localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), b);
      }
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
    return null;
  }
  
  private void a()
  {
    super.setScaleType(a);
    this.q = true;
    if (this.r)
    {
      d();
      this.r = false;
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.rotate(this.z, this.d.centerX(), this.d.centerY());
    paramCanvas.drawArc(this.d, 270.0F, this.H, false, this.I);
    paramCanvas.drawArc(this.d, 270.0F, this.L, false, this.M);
  }
  
  private void b()
  {
    Paint localPaint = this.f;
    if (localPaint != null) {
      localPaint.setColorFilter(this.p);
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    int i1 = 0;
    for (;;)
    {
      int[] arrayOfInt = this.O;
      if (i1 >= arrayOfInt.length) {
        break;
      }
      this.g.setColor(arrayOfInt[i1]);
      arrayOfInt = this.O;
      float f2 = 360.0F / arrayOfInt.length;
      float f3 = i1;
      float f1;
      if (arrayOfInt.length > 1) {
        f1 = 6.0F;
      } else {
        f1 = 0.0F;
      }
      paramCanvas.drawArc(this.d, f2 * f3 + 270.0F, 360.0F / this.O.length - f1, false, this.g);
      i1 += 1;
    }
  }
  
  private void c()
  {
    if (this.t) {
      this.k = null;
    } else {
      this.k = a(getDrawable());
    }
    d();
  }
  
  private void d()
  {
    if (!this.q)
    {
      this.r = true;
      return;
    }
    if ((getWidth() == 0) && (getHeight() == 0)) {
      return;
    }
    if (this.k != null)
    {
      this.f.setAntiAlias(true);
      this.l = new BitmapShader(this.k, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.f.setShader(this.l);
      this.n = this.k.getHeight();
      this.m = this.k.getWidth();
    }
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setAntiAlias(true);
    this.g.setStrokeWidth(this.i);
    this.g.setStrokeCap(Paint.Cap.ROUND);
    this.h.setStyle(Paint.Style.FILL);
    this.h.setAntiAlias(true);
    this.h.setColor(this.j);
    this.d.set(e());
    Object localObject = this.d;
    int i1 = this.i;
    ((RectF)localObject).inset(i1 / 2.0F, i1 / 2.0F);
    this.c.set(e());
    i1 = this.P;
    if (i1 > 0) {
      this.c.inset(i1, i1);
    }
    if (!this.s)
    {
      i1 = this.i;
      if (i1 > 0) {
        this.c.inset(i1 - 1.0F, i1 - 1.0F);
      }
    }
    this.o = Math.min(this.c.height() / 2.0F, this.c.width() / 2.0F);
    localObject = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), this.D, this.E, Shader.TileMode.CLAMP);
    this.I.setShader((Shader)localObject);
    this.I.setStyle(Paint.Style.STROKE);
    this.I.setAntiAlias(true);
    this.I.setStrokeWidth(this.i);
    this.I.setStrokeCap(Paint.Cap.ROUND);
    this.M = new Paint(this.I);
    this.M.setPathEffect(this.N);
    b();
    f();
    invalidate();
  }
  
  private RectF e()
  {
    int i1 = getWidth() - getPaddingLeft() - getPaddingRight();
    int i2 = getHeight() - getPaddingTop() - getPaddingBottom();
    int i3 = Math.min(i1, i2);
    float f1 = getPaddingLeft() + (i1 - i3) / 2.0F;
    float f2 = getPaddingTop() + (i2 - i3) / 2.0F;
    float f3 = i3;
    return new RectF(f1, f2, f1 + f3, f3 + f2);
  }
  
  private void f()
  {
    if (this.k == null) {
      return;
    }
    this.e.set(null);
    float f1 = this.m;
    float f2 = this.c.height();
    float f4 = this.c.width();
    float f5 = this.n;
    float f3 = 0.0F;
    if (f1 * f2 > f4 * f5)
    {
      f1 = this.c.height() / this.n;
      f2 = (this.c.width() - this.m * f1) * 0.5F;
    }
    else
    {
      f1 = this.c.width() / this.m;
      f3 = (this.c.height() - this.n * f1) * 0.5F;
      f2 = 0.0F;
    }
    this.e.setScale(f1, f1);
    this.e.postTranslate((int)(f2 + 0.5F) + this.c.left, (int)(f3 + 0.5F) + this.c.top);
    this.l.setLocalMatrix(this.e);
  }
  
  private void g()
  {
    if (this.A == null)
    {
      this.A = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.A.addUpdateListener(new RotateCircleImageView.2(this));
      this.A.setInterpolator(new LinearInterpolator());
      this.A.setDuration(this.B);
      this.A.setRepeatCount(-1);
    }
    this.A.start();
    if (this.F == null)
    {
      this.F = ValueAnimator.ofFloat(new float[] { 0.0F, 216.0F });
      this.F.setDuration(this.C);
      this.F.setRepeatCount(0);
      this.F.addUpdateListener(new RotateCircleImageView.3(this));
      this.F.addListener(new RotateCircleImageView.4(this));
    }
    if (this.G == null)
    {
      this.G = ValueAnimator.ofFloat(new float[] { 216.0F, 36.0F });
      this.G.setDuration(this.C);
      this.G.setRepeatCount(-1);
      this.G.setRepeatMode(2);
      this.G.addUpdateListener(new RotateCircleImageView.5(this));
    }
    this.F.start();
    if (this.J == null)
    {
      this.J = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.J.setInterpolator(new LinearInterpolator());
      this.J.setDuration(this.C);
      this.J.setRepeatCount(0);
      this.J.addUpdateListener(new RotateCircleImageView.6(this));
      this.J.addListener(new RotateCircleImageView.7(this));
    }
    if (this.K == null)
    {
      this.K = ValueAnimator.ofFloat(new float[] { 360.0F, 108.0F });
      this.K.setInterpolator(new LinearInterpolator());
      this.K.setDuration(this.C);
      this.K.setRepeatCount(-1);
      this.K.setRepeatMode(2);
      this.K.addUpdateListener(new RotateCircleImageView.8(this));
    }
    this.J.start();
  }
  
  private void h()
  {
    ValueAnimator localValueAnimator = this.A;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
    localValueAnimator = this.F;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
    localValueAnimator = this.G;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
    localValueAnimator = this.J;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
    localValueAnimator = this.K;
    if (localValueAnimator != null) {
      localValueAnimator.end();
    }
  }
  
  public int getBorderPadding()
  {
    return this.P;
  }
  
  public RotateCircleImageView.BorderStyle getBorderStyle()
  {
    return this.y;
  }
  
  public int getBorderWidth()
  {
    return this.i;
  }
  
  public int getCircleBackgroundColor()
  {
    return this.j;
  }
  
  public ColorFilter getColorFilter()
  {
    return this.p;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.t)
    {
      super.onDraw(paramCanvas);
      return;
    }
    if (this.k != null)
    {
      if (this.j != 0) {
        paramCanvas.drawCircle(this.c.centerX(), this.c.centerY(), this.o, this.h);
      }
      paramCanvas.drawCircle(this.c.centerX(), this.c.centerY(), this.o, this.f);
    }
    if (this.i > 0)
    {
      int i1 = RotateCircleImageView.9.a[this.y.ordinal()];
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        b(paramCanvas);
        return;
      }
      a(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0)
    {
      if (this.y == RotateCircleImageView.BorderStyle.ROTATE) {
        g();
      }
    }
    else if (this.y == RotateCircleImageView.BorderStyle.ROTATE) {
      h();
    }
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    throw new IllegalArgumentException("adjustViewBounds not supported.");
  }
  
  public void setBorderColors(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (!Arrays.equals(this.O, paramArrayOfInt)))
    {
      int[] arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length > 50) {
        arrayOfInt = Arrays.copyOfRange(paramArrayOfInt, 0, 50);
      }
      this.O = arrayOfInt;
      invalidate();
    }
  }
  
  public void setBorderOverlay(boolean paramBoolean)
  {
    if (paramBoolean == this.s) {
      return;
    }
    this.s = paramBoolean;
    d();
  }
  
  public void setBorderPadding(int paramInt)
  {
    if (paramInt == this.P) {
      return;
    }
    this.P = paramInt;
    d();
  }
  
  public void setBorderRotateDuration(int paramInt)
  {
    if (this.B != paramInt)
    {
      this.B = paramInt;
      this.A.setDuration(this.B);
    }
  }
  
  public void setBorderStyle(RotateCircleImageView.BorderStyle paramBorderStyle)
  {
    if (this.y != paramBorderStyle)
    {
      this.y = paramBorderStyle;
      if (this.y == RotateCircleImageView.BorderStyle.ROTATE) {
        g();
      } else {
        h();
      }
      invalidate();
    }
  }
  
  public void setBorderTrackDuration(int paramInt)
  {
    if (this.C != paramInt)
    {
      this.C = paramInt;
      this.F.setDuration(this.C);
    }
  }
  
  public void setBorderTrackEndColor(int paramInt)
  {
    if (paramInt != this.E)
    {
      this.E = paramInt;
      this.I = null;
      this.M = null;
    }
  }
  
  public void setBorderTrackStartColor(int paramInt)
  {
    if (paramInt != this.D)
    {
      this.D = paramInt;
      this.I = null;
      this.M = null;
    }
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.i) {
      return;
    }
    this.i = paramInt;
    d();
  }
  
  public void setCircleBackgroundColor(int paramInt)
  {
    if (paramInt == this.j) {
      return;
    }
    this.j = paramInt;
    this.h.setColor(paramInt);
    invalidate();
  }
  
  public void setCircleBackgroundColorResource(int paramInt)
  {
    setCircleBackgroundColor(getContext().getResources().getColor(paramInt));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (paramColorFilter == this.p) {
      return;
    }
    this.p = paramColorFilter;
    b();
    invalidate();
  }
  
  public void setDisableCircularTransformation(boolean paramBoolean)
  {
    if (this.t == paramBoolean) {
      return;
    }
    this.t = paramBoolean;
    c();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    c();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    c();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    c();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    c();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == a) {
      return;
    }
    throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.RotateCircleImageView
 * JD-Core Version:    0.7.0.1
 */