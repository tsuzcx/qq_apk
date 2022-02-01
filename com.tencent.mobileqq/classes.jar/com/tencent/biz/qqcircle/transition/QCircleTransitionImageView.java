package com.tencent.biz.qqcircle.transition;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class QCircleTransitionImageView
  extends ImageView
{
  private long A;
  private QCircleTransitionImageView.TranAnimListener B;
  private int a;
  private Matrix b = new Matrix();
  private Matrix c = new Matrix();
  private Matrix d = new Matrix();
  private Matrix e = new Matrix();
  private ImageView.ScaleType f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private float m = 1.0F;
  private int n;
  private int o;
  private float p;
  private float q;
  private RectF r = new RectF();
  private RectF s = new RectF();
  private RectF t = new RectF();
  private PointF u = new PointF();
  private PointF v = new PointF();
  private PointF w = new PointF();
  private QCircleTransitionImageView.Transform x = new QCircleTransitionImageView.Transform(this);
  private RectF y;
  private QCircleTransitionImageView.ImageInfo z;
  
  public QCircleTransitionImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QCircleTransitionImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QCircleTransitionImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static QCircleTransitionImageView.ImageInfo a(Matrix paramMatrix, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return null;
    }
    Object localObject1 = new int[2];
    a(paramImageView, (int[])localObject1);
    Object localObject2 = paramImageView.getDrawable();
    Object localObject3 = paramImageView.getImageMatrix();
    int i1 = b((Drawable)localObject2);
    int i2 = c((Drawable)localObject2);
    localObject2 = new RectF(0.0F, 0.0F, i1, i2);
    ((Matrix)localObject3).mapRect((RectF)localObject2);
    localObject3 = new RectF(localObject1[0] + ((RectF)localObject2).left, localObject1[1] + ((RectF)localObject2).top, localObject1[0] + ((RectF)localObject2).right, localObject1[1] + ((RectF)localObject2).bottom);
    RectF localRectF1 = new RectF(0.0F, 0.0F, paramImageView.getWidth(), paramImageView.getHeight());
    RectF localRectF2 = new RectF((RectF)localObject2);
    localObject1 = new PointF(localRectF1.width() / 2.0F, localRectF1.height() / 2.0F);
    if (paramMatrix != null)
    {
      paramMatrix.mapRect((RectF)localObject2);
      paramMatrix.mapRect((RectF)localObject3);
      paramMatrix.mapRect(localRectF1);
      paramMatrix.mapRect(localRectF2);
      localObject1 = new PointF(localRectF1.width() / 2.0F, localRectF1.height() / 2.0F);
    }
    paramMatrix = new QCircleTransitionImageView.ImageInfoBuilder(null).a((RectF)localObject3).b((RectF)localObject2).c(localRectF1).d(localRectF2).a((PointF)localObject1).a(1.0F).a(paramImageView.getScaleType()).a();
    paramImageView = new StringBuilder();
    paramImageView.append("getCurrentShowImageInfo:");
    paramImageView.append(paramMatrix.toString());
    QLog.d("QCircleTransitionImageView", 1, paramImageView.toString());
    return paramMatrix;
  }
  
  private void a()
  {
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.f == null) {
      this.f = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.a = 340;
  }
  
  public static void a(View paramView, int[] paramArrayOfInt)
  {
    if (paramView == null) {
      return;
    }
    paramArrayOfInt[0] += paramView.getLeft();
    paramArrayOfInt[1] += paramView.getTop();
    for (paramView = paramView.getParent(); (paramView instanceof View); paramView = paramView.getParent())
    {
      paramView = (View)paramView;
      if (paramView.getId() == 16908290) {
        return;
      }
      paramArrayOfInt[0] -= paramView.getScrollX();
      paramArrayOfInt[1] -= paramView.getScrollY();
      paramArrayOfInt[0] += paramView.getLeft();
      paramArrayOfInt[1] += paramView.getTop();
    }
    paramArrayOfInt[0] = ((int)(paramArrayOfInt[0] + 0.5F));
    paramArrayOfInt[1] = ((int)(paramArrayOfInt[1] + 0.5F));
  }
  
  private boolean a(Drawable paramDrawable)
  {
    return ((paramDrawable.getIntrinsicHeight() > 0) && (paramDrawable.getIntrinsicWidth() > 0)) || ((paramDrawable.getMinimumWidth() > 0) && (paramDrawable.getMinimumHeight() > 0)) || ((paramDrawable.getBounds().width() > 0) && (paramDrawable.getBounds().height() > 0));
  }
  
  private static int b(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return 0;
    }
    int i2 = paramDrawable.getIntrinsicWidth();
    int i1 = i2;
    if (i2 <= 0) {
      i1 = paramDrawable.getMinimumWidth();
    }
    i2 = i1;
    if (i1 <= 0) {
      i2 = paramDrawable.getBounds().width();
    }
    return i2;
  }
  
  private void b()
  {
    if (!this.g) {
      return;
    }
    if (!this.h) {
      return;
    }
    this.b.reset();
    this.c.reset();
    Object localObject = getDrawable();
    int i1 = getPaddingLeft();
    int i4 = getPaddingRight();
    int i2 = getPaddingTop();
    int i3 = getPaddingBottom();
    i1 = getWidth() - i1 - i4;
    i2 = getHeight() - i2 - i3;
    i3 = b((Drawable)localObject);
    i4 = c((Drawable)localObject);
    localObject = this.s;
    float f1 = i3;
    float f3 = i4;
    ((RectF)localObject).set(0.0F, 0.0F, f1, f3);
    int i5 = (i1 - i3) / 2;
    int i6 = (i2 - i4) / 2;
    float f2 = 1.0F;
    if (i3 > i1) {
      f1 = i1 / f1;
    } else {
      f1 = 1.0F;
    }
    if (i4 > i2) {
      f2 = i2 / f3;
    }
    f1 = Math.min(f1, f2);
    this.b.reset();
    this.b.postTranslate(i5, i6);
    this.b.postScale(f1, f1, this.u.x, this.u.y);
    this.b.mapRect(this.s);
    this.p = (this.s.width() / 2.0F);
    this.q = (this.s.height() / 2.0F);
    this.v.set(this.u);
    this.w.set(this.v);
    k();
    switch (QCircleTransitionImageView.2.a[this.f.ordinal()])
    {
    default: 
      break;
    case 7: 
      i();
      break;
    case 6: 
      h();
      break;
    case 5: 
      g();
      break;
    case 4: 
      f();
      break;
    case 3: 
      e();
      break;
    case 2: 
      d();
      break;
    case 1: 
      c();
    }
    this.i = true;
    if ((this.z != null) && (System.currentTimeMillis() - this.A < 500L)) {
      a(this.z, this.B);
    }
    this.z = null;
  }
  
  private static int c(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return 0;
    }
    int i2 = paramDrawable.getIntrinsicHeight();
    int i1 = i2;
    if (i2 <= 0) {
      i1 = paramDrawable.getMinimumHeight();
    }
    i2 = i1;
    if (i1 <= 0) {
      i2 = paramDrawable.getBounds().height();
    }
    return i2;
  }
  
  private void c()
  {
    if (!this.g) {
      return;
    }
    if (!this.h) {
      return;
    }
    Object localObject = getDrawable();
    int i1 = b((Drawable)localObject);
    int i2 = c((Drawable)localObject);
    float f1 = i1;
    if ((f1 > this.r.width()) || (i2 > this.r.height()))
    {
      float f2 = f1 / this.t.width();
      float f3 = i2 / this.t.height();
      f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.m = f1;
      localObject = this.c;
      f1 = this.m;
      ((Matrix)localObject).postScale(f1, f1, this.u.x, this.u.y);
      k();
      j();
    }
  }
  
  private void d()
  {
    if ((this.t.width() < this.r.width()) || (this.t.height() < this.r.height()))
    {
      float f1 = this.r.width() / this.t.width();
      float f2 = this.r.height() / this.t.height();
      if (f1 <= f2) {
        f1 = f2;
      }
      this.m = f1;
      Matrix localMatrix = this.c;
      f1 = this.m;
      localMatrix.postScale(f1, f1, this.u.x, this.u.y);
      k();
      j();
    }
  }
  
  private void e()
  {
    if ((this.t.width() > this.r.width()) || (this.t.height() > this.r.height()))
    {
      float f1 = this.r.width() / this.t.width();
      float f2 = this.r.height() / this.t.height();
      if (f1 >= f2) {
        f1 = f2;
      }
      this.m = f1;
      Matrix localMatrix = this.c;
      f1 = this.m;
      localMatrix.postScale(f1, f1, this.u.x, this.u.y);
      k();
      j();
    }
  }
  
  private void f()
  {
    if (this.t.width() < this.r.width())
    {
      this.m = (this.r.width() / this.t.width());
      Matrix localMatrix = this.c;
      float f1 = this.m;
      localMatrix.postScale(f1, f1, this.u.x, this.u.y);
      k();
      j();
    }
  }
  
  private void g()
  {
    f();
    float f1 = -this.t.top;
    this.c.postTranslate(0.0F, f1);
    k();
    j();
    this.o = ((int)(this.o + f1));
  }
  
  private void h()
  {
    f();
    float f1 = this.r.bottom - this.t.bottom;
    this.o = ((int)(this.o + f1));
    this.c.postTranslate(0.0F, f1);
    k();
    j();
  }
  
  private void i()
  {
    float f1 = this.r.width() / this.t.width();
    float f2 = this.r.height() / this.t.height();
    this.c.postScale(f1, f2, this.u.x, this.u.y);
    k();
    j();
  }
  
  private void j()
  {
    Drawable localDrawable = getDrawable();
    int i1 = b(localDrawable);
    int i2 = c(localDrawable);
    this.s.set(0.0F, 0.0F, i1, i2);
    this.b.set(this.d);
    this.b.mapRect(this.s);
    this.p = (this.s.width() / 2.0F);
    this.q = (this.s.height() / 2.0F);
    this.m = 1.0F;
    this.n = 0;
    this.o = 0;
    this.c.reset();
  }
  
  private void k()
  {
    this.d.set(this.b);
    this.d.postConcat(this.c);
    setImageMatrix(this.d);
    this.c.mapRect(this.t, this.s);
    float f1 = this.t.width();
    float f2 = this.r.width();
    boolean bool2 = true;
    boolean bool1;
    if (f1 > f2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.k = bool1;
    if (this.t.height() > this.r.height()) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.l = bool1;
  }
  
  private void l()
  {
    this.c.reset();
    k();
    this.m = 1.0F;
    this.n = 0;
    this.o = 0;
  }
  
  public void a(QCircleTransitionImageView.ImageInfo paramImageInfo)
  {
    l();
    j();
    QCircleTransitionImageView.ImageInfo localImageInfo = getInfo();
    float f1 = Math.min(paramImageInfo.b.width() / localImageInfo.b.width(), paramImageInfo.b.height() / localImageInfo.b.height());
    float f2 = paramImageInfo.a.left + paramImageInfo.a.width() / 2.0F;
    float f3 = paramImageInfo.a.top + paramImageInfo.a.height() / 2.0F;
    float f4 = localImageInfo.a.left;
    float f5 = localImageInfo.a.width() / 2.0F;
    float f6 = localImageInfo.a.top;
    float f7 = localImageInfo.a.height() / 2.0F;
    this.c.reset();
    this.c.postTranslate(f2 - (f4 + f5), f3 - (f6 + f7));
    this.c.postScale(f1, f1, f2, f3);
    k();
    this.v.set(f2, f3);
    this.w.set(f2, f3);
    this.t = paramImageInfo.b;
    this.r = paramImageInfo.c;
    this.s = paramImageInfo.d;
    this.u = paramImageInfo.e;
    this.m = paramImageInfo.f;
    this.f = paramImageInfo.g;
    this.b.set(this.d);
    this.p = (this.s.width() / 2.0F);
    this.q = (this.s.height() / 2.0F);
  }
  
  public void a(QCircleTransitionImageView.ImageInfo paramImageInfo, QCircleTransitionImageView.TranAnimListener paramTranAnimListener)
  {
    if (this.i)
    {
      l();
      QCircleTransitionImageView.ImageInfo localImageInfo = getInfo();
      float f1 = Math.min(paramImageInfo.b.width() / localImageInfo.b.width(), paramImageInfo.b.height() / localImageInfo.b.height());
      float f2 = paramImageInfo.a.left + paramImageInfo.a.width() / 2.0F;
      float f3 = paramImageInfo.a.top + paramImageInfo.a.height() / 2.0F;
      float f4 = localImageInfo.a.left + localImageInfo.a.width() / 2.0F;
      float f5 = localImageInfo.a.top + localImageInfo.a.height() / 2.0F;
      this.c.reset();
      Object localObject = this.c;
      float f6 = f2 - f4;
      float f7 = f3 - f5;
      ((Matrix)localObject).postTranslate(f6, f7);
      this.c.postScale(f1, f1, f2, f3);
      k();
      this.v.set(f2, f3);
      this.w.set(f2, f3);
      this.x.a(0, 0, (int)(f4 - f2), (int)(f5 - f3));
      this.x.a(f1, 1.0F);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("animaFrom from imageInfo:");
      ((StringBuilder)localObject).append(paramImageInfo.toString());
      ((StringBuilder)localObject).append(" to imageInfo:");
      ((StringBuilder)localObject).append(localImageInfo.toString());
      ((StringBuilder)localObject).append(" translate x:");
      ((StringBuilder)localObject).append(f6);
      ((StringBuilder)localObject).append(" translate y:");
      ((StringBuilder)localObject).append(f7);
      ((StringBuilder)localObject).append(" scale");
      ((StringBuilder)localObject).append(f1);
      QLog.d("QCircleTransitionImageView", 4, ((StringBuilder)localObject).toString());
      if ((paramImageInfo.c.width() >= paramImageInfo.b.width()) && (paramImageInfo.c.height() >= paramImageInfo.b.height())) {}
      for (;;)
      {
        break;
        f2 = paramImageInfo.c.width() / paramImageInfo.b.width();
        f3 = paramImageInfo.c.height() / paramImageInfo.b.height();
        QLog.d("QCircleTransitionImageView", 1, new Object[] { "animaFrom source clipX:", Float.valueOf(f2), ",clipY:", Float.valueOf(f3) });
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        f2 = f3;
        if (f3 > 1.0F) {
          f2 = 1.0F;
        }
        QLog.d("QCircleTransitionImageView", 1, new Object[] { "animaFrom result clipX:", Float.valueOf(f1), ",clipY:", Float.valueOf(f2) });
        if (paramImageInfo.g == ImageView.ScaleType.FIT_START) {
          paramImageInfo = new QCircleTransitionImageView.START(this);
        } else if (paramImageInfo.g == ImageView.ScaleType.FIT_END) {
          paramImageInfo = new QCircleTransitionImageView.END(this);
        } else {
          paramImageInfo = new QCircleTransitionImageView.OTHER(this);
        }
        this.x.a(f1, f2, 1.0F - f1, 1.0F - f2, this.a / 3, paramImageInfo);
        this.e.setScale(f1, f2, (this.t.left + this.t.right) / 2.0F, paramImageInfo.a());
        this.e.mapRect(this.x.h, this.t);
        this.y = this.x.h;
        QLog.d("QCircleTransitionImageView", 1, new Object[] { "animaFrom mImgRect:", this.t.toString(), ",mClip:", this.y.toString() });
      }
      this.B = paramTranAnimListener;
      this.x.a();
      return;
    }
    this.z = paramImageInfo;
    this.A = System.currentTimeMillis();
  }
  
  public void b(QCircleTransitionImageView.ImageInfo paramImageInfo, QCircleTransitionImageView.TranAnimListener paramTranAnimListener)
  {
    if (this.i)
    {
      this.x.b();
      this.n = 0;
      this.o = 0;
      QCircleTransitionImageView.ImageInfo localImageInfo = getInfo();
      float f1 = Math.min(paramImageInfo.b.width() / localImageInfo.b.width(), paramImageInfo.b.height() / localImageInfo.b.height());
      float f2 = localImageInfo.a.left + localImageInfo.a.width() / 2.0F;
      float f3 = localImageInfo.a.top + localImageInfo.a.height() / 2.0F;
      float f4 = paramImageInfo.a.left;
      float f5 = paramImageInfo.a.width() / 2.0F;
      float f6 = paramImageInfo.a.top;
      float f7 = paramImageInfo.a.height() / 2.0F;
      this.c.reset();
      this.v.set(f2, f3);
      this.w.set(f2, f3);
      Object localObject = this.x;
      int i1 = (int)(f4 + f5 - f2);
      int i2 = (int)(f6 + f7 - f3);
      ((QCircleTransitionImageView.Transform)localObject).a(0, 0, i1, i2);
      this.x.a(1.0F, f1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("animaTo from imageInfo:");
      ((StringBuilder)localObject).append(localImageInfo.toString());
      ((StringBuilder)localObject).append(" to imageInfo:");
      ((StringBuilder)localObject).append(paramImageInfo.toString());
      ((StringBuilder)localObject).append(" translate x:");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" translate y:");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" scale");
      ((StringBuilder)localObject).append(f1);
      QLog.d("QCircleTransitionImageView", 4, ((StringBuilder)localObject).toString());
      if ((paramImageInfo.c.width() < paramImageInfo.b.width()) || (paramImageInfo.c.height() < paramImageInfo.b.height()))
      {
        f2 = paramImageInfo.c.width() / paramImageInfo.b.width();
        f3 = paramImageInfo.c.height() / paramImageInfo.b.height();
        QLog.d("QCircleTransitionImageView", 1, new Object[] { "animaTo source clipX:", Float.valueOf(f2), ",clipY:", Float.valueOf(f3) });
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        f2 = f3;
        if (f3 > 1.0F) {
          f2 = 1.0F;
        }
        QLog.d("QCircleTransitionImageView", 1, new Object[] { "animaTo result clipX:", Float.valueOf(f1), ",clipY:", Float.valueOf(f2) });
        if (paramImageInfo.g == ImageView.ScaleType.FIT_START) {
          paramImageInfo = new QCircleTransitionImageView.START(this);
        } else if (paramImageInfo.g == ImageView.ScaleType.FIT_END) {
          paramImageInfo = new QCircleTransitionImageView.END(this);
        } else {
          paramImageInfo = new QCircleTransitionImageView.OTHER(this);
        }
        postDelayed(new QCircleTransitionImageView.1(this, f1, f2, paramImageInfo), this.a / 2);
      }
      this.B = paramTranAnimListener;
      this.x.a();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    RectF localRectF = this.y;
    if (localRectF != null)
    {
      paramCanvas.clipRect(localRectF);
      this.y = null;
    }
    super.draw(paramCanvas);
  }
  
  public QCircleTransitionImageView.ImageInfo getInfo()
  {
    RectF localRectF = new RectF();
    int[] arrayOfInt = new int[2];
    a(this, arrayOfInt);
    localRectF.set(arrayOfInt[0] + this.t.left, arrayOfInt[1] + this.t.top, arrayOfInt[0] + this.t.right, arrayOfInt[1] + this.t.bottom);
    return new QCircleTransitionImageView.ImageInfoBuilder(null).a(localRectF).b(this.t).c(this.r).d(this.s).a(this.u).a(this.m).a(this.f).a();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.g)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    Object localObject = getDrawable();
    int i3 = b((Drawable)localObject);
    int i4 = c((Drawable)localObject);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new ViewGroup.LayoutParams(-2, -2);
    }
    if (((ViewGroup.LayoutParams)localObject).width == -1)
    {
      paramInt1 = i2;
      if (i6 != 0) {
        break label144;
      }
    }
    else
    {
      if (i6 == 1073741824)
      {
        paramInt1 = i2;
        break label144;
      }
      if ((i6 == -2147483648) && (i3 > i2))
      {
        paramInt1 = i2;
        break label144;
      }
    }
    paramInt1 = i3;
    label144:
    if (((ViewGroup.LayoutParams)localObject).height == -1)
    {
      paramInt2 = i1;
      if (i5 != 0) {
        break label202;
      }
    }
    else
    {
      if (i5 == 1073741824)
      {
        paramInt2 = i1;
        break label202;
      }
      if ((i5 == -2147483648) && (i4 > i1))
      {
        paramInt2 = i1;
        break label202;
      }
    }
    paramInt2 = i4;
    label202:
    i2 = paramInt1;
    i1 = paramInt2;
    if (this.j)
    {
      float f4 = i3;
      float f5 = i4;
      float f2 = f4 / f5;
      float f1 = paramInt1;
      float f3 = paramInt2;
      i2 = paramInt1;
      i1 = paramInt2;
      if (f2 != f1 / f3)
      {
        f2 = f3 / f5;
        f3 = f1 / f4;
        f1 = f3;
        if (f2 < f3) {
          f1 = f2;
        }
        if (((ViewGroup.LayoutParams)localObject).width != -1) {
          paramInt1 = (int)(f4 * f1);
        }
        if (((ViewGroup.LayoutParams)localObject).height == -1)
        {
          i2 = paramInt1;
          i1 = paramInt2;
        }
        else
        {
          i1 = (int)(f5 * f1);
          i2 = paramInt1;
        }
      }
    }
    setMeasuredDimension(i2, i1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = paramInt2 - getPaddingTop() - getPaddingBottom();
    this.r.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.u.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.h)
    {
      this.h = true;
      b();
    }
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    super.setAdjustViewBounds(paramBoolean);
    this.j = paramBoolean;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      this.g = false;
      return;
    }
    if (!a(paramDrawable)) {
      return;
    }
    if (!this.g) {
      this.g = true;
    }
    b();
  }
  
  public void setImageResource(int paramInt)
  {
    try
    {
      localDrawable = getResources().getDrawable(paramInt);
    }
    catch (Exception localException)
    {
      Drawable localDrawable;
      label12:
      break label12;
    }
    localDrawable = null;
    setImageDrawable(localDrawable);
  }
  
  public void setImageURI(@Nullable Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = getDrawable();
    if (paramUri == null)
    {
      this.g = false;
      return;
    }
    if (!a(paramUri)) {
      return;
    }
    if (!this.g) {
      this.g = true;
    }
    b();
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.x.a(paramInterpolator);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == ImageView.ScaleType.MATRIX) {
      return;
    }
    if (paramScaleType != this.f)
    {
      this.f = paramScaleType;
      if (this.i) {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionImageView
 * JD-Core Version:    0.7.0.1
 */