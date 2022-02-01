package com.bm.library;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;

public class PhotoView
  extends ImageView
{
  private boolean A;
  private float B;
  private float C;
  private float D = 1.0F;
  private int E;
  private int F;
  private float G;
  private float H;
  private RectF I = new RectF();
  private RectF J = new RectF();
  private RectF K = new RectF();
  private RectF L = new RectF();
  private RectF M = new RectF();
  private PointF N = new PointF();
  private PointF O = new PointF();
  private PointF P = new PointF();
  private PhotoView.Transform Q = new PhotoView.Transform(this);
  private RectF R;
  private Info S;
  private long T;
  private Runnable U;
  private View.OnLongClickListener V;
  private OnRotateListener W = new PhotoView.1(this);
  private ScaleGestureDetector.OnScaleGestureListener Z = new PhotoView.2(this);
  private int a;
  private Runnable aa = new PhotoView.3(this);
  private GestureDetector.OnGestureListener ab = new PhotoView.4(this);
  private int b;
  private float c;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 500;
  private Matrix h = new Matrix();
  private Matrix i = new Matrix();
  private Matrix j = new Matrix();
  private Matrix k = new Matrix();
  private RotateGestureDetector l;
  private GestureDetector m;
  private ScaleGestureDetector n;
  private View.OnClickListener o;
  private ImageView.ScaleType p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u = false;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public PhotoView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return paramFloat2 * (Math.abs(Math.abs(paramFloat1) - this.f) / this.f);
  }
  
  private void a(RectF paramRectF)
  {
    float f1 = paramRectF.width();
    float f2 = this.I.width();
    int i2 = 0;
    if (f1 <= f2)
    {
      if (!c(paramRectF))
      {
        i1 = -(int)((this.I.width() - paramRectF.width()) / 2.0F - paramRectF.left);
        break label127;
      }
    }
    else
    {
      if (paramRectF.left > this.I.left) {
        f1 = paramRectF.left;
      }
      for (f2 = this.I.left;; f2 = this.I.right)
      {
        i1 = (int)(f1 - f2);
        break label127;
        if (paramRectF.right >= this.I.right) {
          break;
        }
        f1 = paramRectF.right;
      }
    }
    int i1 = 0;
    label127:
    if (paramRectF.height() <= this.I.height())
    {
      if (!b(paramRectF)) {
        i2 = -(int)((this.I.height() - paramRectF.height()) / 2.0F - paramRectF.top);
      }
    }
    else
    {
      if (paramRectF.top > this.I.top) {
        f2 = paramRectF.top;
      }
      for (f1 = this.I.top;; f1 = this.I.bottom)
      {
        i2 = (int)(f2 - f1);
        break;
        if (paramRectF.bottom >= this.I.bottom) {
          break;
        }
        f2 = paramRectF.bottom;
      }
    }
    if ((i1 != 0) || (i2 != 0))
    {
      if (!this.Q.c.isFinished()) {
        this.Q.c.abortAnimation();
      }
      this.Q.a(this.E, this.F, -i1, -i2);
    }
  }
  
  private void a(RectF paramRectF1, RectF paramRectF2, RectF paramRectF3)
  {
    float f1;
    if (paramRectF1.left > paramRectF2.left) {
      f1 = paramRectF1.left;
    } else {
      f1 = paramRectF2.left;
    }
    float f2;
    if (paramRectF1.right < paramRectF2.right) {
      f2 = paramRectF1.right;
    } else {
      f2 = paramRectF2.right;
    }
    if (f1 > f2)
    {
      paramRectF3.set(0.0F, 0.0F, 0.0F, 0.0F);
      return;
    }
    float f3;
    if (paramRectF1.top > paramRectF2.top) {
      f3 = paramRectF1.top;
    } else {
      f3 = paramRectF2.top;
    }
    float f4;
    if (paramRectF1.bottom < paramRectF2.bottom) {
      f4 = paramRectF1.bottom;
    } else {
      f4 = paramRectF2.bottom;
    }
    if (f3 > f4)
    {
      paramRectF3.set(0.0F, 0.0F, 0.0F, 0.0F);
      return;
    }
    paramRectF3.set(f1, f3, f2, f4);
  }
  
  private static void a(View paramView, int[] paramArrayOfInt)
  {
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
  
  private float b(float paramFloat1, float paramFloat2)
  {
    return paramFloat2 * (Math.abs(Math.abs(paramFloat1) - this.f) / this.f);
  }
  
  private static int b(Drawable paramDrawable)
  {
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
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.p == null) {
      this.p = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.l = new RotateGestureDetector(this.W);
    this.m = new GestureDetector(getContext(), this.ab);
    this.n = new ScaleGestureDetector(getContext(), this.Z);
    float f1 = getResources().getDisplayMetrics().density;
    int i1 = (int)(30.0F * f1);
    this.d = i1;
    this.e = i1;
    this.f = ((int)(f1 * 140.0F));
    this.a = 35;
    this.b = 340;
    this.c = 2.5F;
  }
  
  private boolean b(RectF paramRectF)
  {
    return Math.abs(Math.round(paramRectF.top) - (this.I.height() - paramRectF.height()) / 2.0F) < 1.0F;
  }
  
  private static int c(Drawable paramDrawable)
  {
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
    if (!this.r) {
      return;
    }
    if (!this.s) {
      return;
    }
    this.h.reset();
    this.i.reset();
    this.x = false;
    Object localObject = getDrawable();
    int i1 = getWidth();
    int i2 = getHeight();
    int i3 = b((Drawable)localObject);
    int i4 = c((Drawable)localObject);
    localObject = this.J;
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
    if (f1 >= f2) {
      f1 = f2;
    }
    this.h.reset();
    this.h.postTranslate(i5, i6);
    this.h.postScale(f1, f1, this.N.x, this.N.y);
    this.h.mapRect(this.J);
    this.G = (this.J.width() / 2.0F);
    this.H = (this.J.height() / 2.0F);
    this.O.set(this.N);
    this.P.set(this.O);
    l();
    switch (PhotoView.6.a[this.p.ordinal()])
    {
    default: 
      break;
    case 7: 
      j();
      break;
    case 6: 
      i();
      break;
    case 5: 
      h();
      break;
    case 4: 
      g();
      break;
    case 3: 
      f();
      break;
    case 2: 
      e();
      break;
    case 1: 
      d();
    }
    this.v = true;
    if ((this.S != null) && (System.currentTimeMillis() - this.T < this.g)) {
      a(this.S);
    }
    this.S = null;
  }
  
  private boolean c(RectF paramRectF)
  {
    return Math.abs(Math.round(paramRectF.left) - (this.I.width() - paramRectF.width()) / 2.0F) < 1.0F;
  }
  
  private void d()
  {
    if (!this.r) {
      return;
    }
    if (!this.s) {
      return;
    }
    Object localObject = getDrawable();
    int i1 = b((Drawable)localObject);
    int i2 = c((Drawable)localObject);
    float f1 = i1;
    if ((f1 > this.I.width()) || (i2 > this.I.height()))
    {
      float f2 = f1 / this.K.width();
      float f3 = i2 / this.K.height();
      f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.D = f1;
      localObject = this.i;
      f1 = this.D;
      ((Matrix)localObject).postScale(f1, f1, this.N.x, this.N.y);
      l();
      k();
    }
  }
  
  private void e()
  {
    if ((this.K.width() < this.I.width()) || (this.K.height() < this.I.height()))
    {
      float f1 = this.I.width() / this.K.width();
      float f2 = this.I.height() / this.K.height();
      if (f1 <= f2) {
        f1 = f2;
      }
      this.D = f1;
      Matrix localMatrix = this.i;
      f1 = this.D;
      localMatrix.postScale(f1, f1, this.N.x, this.N.y);
      l();
      k();
    }
  }
  
  private void f()
  {
    if ((this.K.width() > this.I.width()) || (this.K.height() > this.I.height()))
    {
      float f1 = this.I.width() / this.K.width();
      float f2 = this.I.height() / this.K.height();
      if (f1 >= f2) {
        f1 = f2;
      }
      this.D = f1;
      Matrix localMatrix = this.i;
      f1 = this.D;
      localMatrix.postScale(f1, f1, this.N.x, this.N.y);
      l();
      k();
    }
  }
  
  private void g()
  {
    if (this.K.width() < this.I.width())
    {
      this.D = (this.I.width() / this.K.width());
      Matrix localMatrix = this.i;
      float f1 = this.D;
      localMatrix.postScale(f1, f1, this.N.x, this.N.y);
      l();
      k();
    }
  }
  
  private void h()
  {
    g();
    float f1 = -this.K.top;
    this.i.postTranslate(0.0F, f1);
    l();
    k();
    this.F = ((int)(this.F + f1));
  }
  
  private void i()
  {
    g();
    float f1 = this.I.bottom - this.K.bottom;
    this.F = ((int)(this.F + f1));
    this.i.postTranslate(0.0F, f1);
    l();
    k();
  }
  
  private void j()
  {
    float f1 = this.I.width() / this.K.width();
    float f2 = this.I.height() / this.K.height();
    this.i.postScale(f1, f2, this.N.x, this.N.y);
    l();
    k();
  }
  
  private void k()
  {
    Drawable localDrawable = getDrawable();
    int i1 = b(localDrawable);
    int i2 = c(localDrawable);
    this.J.set(0.0F, 0.0F, i1, i2);
    this.h.set(this.j);
    this.h.mapRect(this.J);
    this.G = (this.J.width() / 2.0F);
    this.H = (this.J.height() / 2.0F);
    this.D = 1.0F;
    this.E = 0;
    this.F = 0;
    this.i.reset();
  }
  
  private void l()
  {
    this.j.set(this.h);
    this.j.postConcat(this.i);
    setImageMatrix(this.j);
    this.i.mapRect(this.K, this.J);
    float f1 = this.K.width();
    float f2 = this.I.width();
    boolean bool2 = true;
    boolean bool1;
    if (f1 > f2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.z = bool1;
    if (this.K.height() > this.I.height()) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.A = bool1;
  }
  
  private void m()
  {
    if (this.Q.a) {
      return;
    }
    if ((this.y) || (this.C % 90.0F != 0.0F))
    {
      f1 = this.C;
      f2 = (int)(f1 / 90.0F) * 90;
      f3 = f1 % 90.0F;
      if (f3 > 45.0F)
      {
        f1 = f2 + 90.0F;
      }
      else
      {
        f1 = f2;
        if (f3 < -45.0F) {
          f1 = f2 - 90.0F;
        }
      }
      this.Q.a((int)this.C, (int)f1);
      this.C = f1;
    }
    float f1 = this.D;
    float f2 = 1.0F;
    if (f1 < 1.0F)
    {
      this.Q.a(f1, 1.0F);
      f1 = f2;
    }
    else
    {
      f2 = this.c;
      if (f1 > f2)
      {
        this.Q.a(f1, f2);
        f1 = f2;
      }
    }
    f2 = this.K.left + this.K.width() / 2.0F;
    float f3 = this.K.top + this.K.height() / 2.0F;
    this.O.set(f2, f3);
    this.P.set(f2, f3);
    this.E = 0;
    this.F = 0;
    this.k.reset();
    this.k.postTranslate(-this.J.left, -this.J.top);
    this.k.postTranslate(f2 - this.G, f3 - this.H);
    this.k.postScale(f1, f1, f2, f3);
    this.k.postRotate(this.C, f2, f3);
    this.k.mapRect(this.L, this.J);
    a(this.L);
    this.Q.a();
  }
  
  private void n()
  {
    if (!this.t) {
      a(this.I, this.K, this.M);
    }
  }
  
  private void o()
  {
    this.i.reset();
    l();
    this.D = 1.0F;
    this.E = 0;
    this.F = 0;
  }
  
  public void a()
  {
    this.u = true;
  }
  
  public void a(Info paramInfo)
  {
    if (this.v)
    {
      o();
      Object localObject = getInfo();
      float f1 = paramInfo.b.width() / ((Info)localObject).b.width();
      float f2 = paramInfo.b.height() / ((Info)localObject).b.height();
      if (f1 >= f2) {
        f1 = f2;
      }
      f2 = paramInfo.a.left + paramInfo.a.width() / 2.0F;
      float f3 = paramInfo.a.top + paramInfo.a.height() / 2.0F;
      float f6 = ((Info)localObject).a.left;
      float f7 = ((Info)localObject).a.width() / 2.0F;
      float f4 = ((Info)localObject).a.top;
      float f5 = ((Info)localObject).a.height() / 2.0F;
      this.i.reset();
      localObject = this.i;
      f6 = f2 - (f6 + f7);
      f4 = f3 - (f4 + f5);
      ((Matrix)localObject).postTranslate(f6, f4);
      this.i.postScale(f1, f1, f2, f3);
      this.i.postRotate(paramInfo.g, f2, f3);
      l();
      this.O.set(f2, f3);
      this.P.set(f2, f3);
      this.Q.a(0, 0, (int)-f6, (int)-f4);
      this.Q.a(f1, 1.0F);
      this.Q.a((int)paramInfo.g, 0);
      if ((paramInfo.c.width() < paramInfo.b.width()) || (paramInfo.c.height() < paramInfo.b.height()))
      {
        f2 = paramInfo.c.width() / paramInfo.b.width();
        f3 = paramInfo.c.height() / paramInfo.b.height();
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        f2 = f3;
        if (f3 > 1.0F) {
          f2 = 1.0F;
        }
        if (paramInfo.h == ImageView.ScaleType.FIT_START) {
          paramInfo = new PhotoView.START(this);
        } else if (paramInfo.h == ImageView.ScaleType.FIT_END) {
          paramInfo = new PhotoView.END(this);
        } else {
          paramInfo = new PhotoView.OTHER(this);
        }
        this.Q.a(f1, f2, 1.0F - f1, 1.0F - f2, this.b / 3, paramInfo);
        this.k.setScale(f1, f2, (this.K.left + this.K.right) / 2.0F, paramInfo.a());
        this.k.mapRect(this.Q.l, this.K);
        this.R = this.Q.l;
      }
      this.Q.a();
      return;
    }
    this.S = paramInfo;
    this.T = System.currentTimeMillis();
  }
  
  public boolean a(float paramFloat)
  {
    if (this.K.width() <= this.I.width()) {
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.K.left) - paramFloat >= this.I.left)) {
      return false;
    }
    return (paramFloat <= 0.0F) || (Math.round(this.K.right) - paramFloat > this.I.right);
  }
  
  public boolean b(float paramFloat)
  {
    if (this.K.height() <= this.I.height()) {
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.K.top) - paramFloat >= this.I.top)) {
      return false;
    }
    return (paramFloat <= 0.0F) || (Math.round(this.K.bottom) - paramFloat > this.I.bottom);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.q) {
      return true;
    }
    return a(paramInt);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    if (this.q) {
      return true;
    }
    return b(paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.u)
    {
      int i1 = paramMotionEvent.getActionMasked();
      if (paramMotionEvent.getPointerCount() >= 2) {
        this.q = true;
      }
      this.m.onTouchEvent(paramMotionEvent);
      this.l.a(paramMotionEvent);
      this.n.onTouchEvent(paramMotionEvent);
      if ((i1 == 1) || (i1 == 3)) {
        m();
      }
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    RectF localRectF = this.R;
    if (localRectF != null)
    {
      paramCanvas.clipRect(localRectF);
      this.R = null;
    }
    super.draw(paramCanvas);
  }
  
  public int getAnimaDuring()
  {
    return this.b;
  }
  
  public int getDefaultAnimaDuring()
  {
    return 340;
  }
  
  public Info getInfo()
  {
    RectF localRectF = new RectF();
    int[] arrayOfInt = new int[2];
    a(this, arrayOfInt);
    localRectF.set(arrayOfInt[0] + this.K.left, arrayOfInt[1] + this.K.top, arrayOfInt[0] + this.K.right, arrayOfInt[1] + this.K.bottom);
    return new Info(localRectF, this.K, this.I, this.J, this.N, this.D, this.C, this.p);
  }
  
  public float getMaxScale()
  {
    return this.c;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.r)
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
    if (this.w)
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
    this.I.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.N.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.s)
    {
      this.s = true;
      c();
    }
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    super.setAdjustViewBounds(paramBoolean);
    this.w = paramBoolean;
  }
  
  public void setAnimaDuring(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      this.r = false;
      return;
    }
    if (!a(paramDrawable)) {
      return;
    }
    if (!this.r) {
      this.r = true;
    }
    c();
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
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.Q.a(paramInterpolator);
  }
  
  public void setMaxAnimFromWaiteTime(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.o = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.V = paramOnLongClickListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == ImageView.ScaleType.MATRIX) {
      return;
    }
    if (paramScaleType != this.p)
    {
      this.p = paramScaleType;
      if (this.v) {
        c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bm.library.PhotoView
 * JD-Core Version:    0.7.0.1
 */