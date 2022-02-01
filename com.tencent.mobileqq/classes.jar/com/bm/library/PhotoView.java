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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new PhotoView.4(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ScaleGestureDetector.OnScaleGestureListener jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener = new PhotoView.2(this);
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private Info jdField_a_of_type_ComBmLibraryInfo;
  private OnRotateListener jdField_a_of_type_ComBmLibraryOnRotateListener = new PhotoView.1(this);
  private PhotoView.Transform jdField_a_of_type_ComBmLibraryPhotoView$Transform = new PhotoView.Transform(this);
  private RotateGestureDetector jdField_a_of_type_ComBmLibraryRotateGestureDetector;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private PointF jdField_b_of_type_AndroidGraphicsPointF = new PointF();
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private Runnable jdField_b_of_type_JavaLangRunnable = new PhotoView.3(this);
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 0;
  private Matrix jdField_c_of_type_AndroidGraphicsMatrix = new Matrix();
  private PointF jdField_c_of_type_AndroidGraphicsPointF = new PointF();
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float = 1.0F;
  private int jdField_d_of_type_Int = 0;
  private Matrix jdField_d_of_type_AndroidGraphicsMatrix = new Matrix();
  private RectF jdField_d_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 0;
  private RectF jdField_e_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_e_of_type_Boolean = false;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 500;
  private RectF jdField_f_of_type_AndroidGraphicsRectF;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private boolean i;
  private boolean j;
  private boolean k;
  
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
    return paramFloat2 * (Math.abs(Math.abs(paramFloat1) - this.jdField_e_of_type_Int) / this.jdField_e_of_type_Int);
  }
  
  private static int a(Drawable paramDrawable)
  {
    int n = paramDrawable.getIntrinsicWidth();
    int m = n;
    if (n <= 0) {
      m = paramDrawable.getMinimumWidth();
    }
    n = m;
    if (m <= 0) {
      n = paramDrawable.getBounds().width();
    }
    return n;
  }
  
  private void a(RectF paramRectF)
  {
    float f1 = paramRectF.width();
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
    int n = 0;
    if (f1 <= f2)
    {
      if (!b(paramRectF))
      {
        m = -(int)((this.jdField_a_of_type_AndroidGraphicsRectF.width() - paramRectF.width()) / 2.0F - paramRectF.left);
        break label127;
      }
    }
    else
    {
      if (paramRectF.left > this.jdField_a_of_type_AndroidGraphicsRectF.left) {
        f1 = paramRectF.left;
      }
      for (f2 = this.jdField_a_of_type_AndroidGraphicsRectF.left;; f2 = this.jdField_a_of_type_AndroidGraphicsRectF.right)
      {
        m = (int)(f1 - f2);
        break label127;
        if (paramRectF.right >= this.jdField_a_of_type_AndroidGraphicsRectF.right) {
          break;
        }
        f1 = paramRectF.right;
      }
    }
    int m = 0;
    label127:
    if (paramRectF.height() <= this.jdField_a_of_type_AndroidGraphicsRectF.height())
    {
      if (!a(paramRectF)) {
        n = -(int)((this.jdField_a_of_type_AndroidGraphicsRectF.height() - paramRectF.height()) / 2.0F - paramRectF.top);
      }
    }
    else
    {
      if (paramRectF.top > this.jdField_a_of_type_AndroidGraphicsRectF.top) {
        f2 = paramRectF.top;
      }
      for (f1 = this.jdField_a_of_type_AndroidGraphicsRectF.top;; f1 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom)
      {
        n = (int)(f2 - f1);
        break;
        if (paramRectF.bottom >= this.jdField_a_of_type_AndroidGraphicsRectF.bottom) {
          break;
        }
        f2 = paramRectF.bottom;
      }
    }
    if ((m != 0) || (n != 0))
    {
      if (!this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.b.isFinished()) {
        this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.b.abortAnimation();
      }
      this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, -m, -n);
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
  
  private boolean a(RectF paramRectF)
  {
    return Math.abs(Math.round(paramRectF.top) - (this.jdField_a_of_type_AndroidGraphicsRectF.height() - paramRectF.height()) / 2.0F) < 1.0F;
  }
  
  private boolean a(Drawable paramDrawable)
  {
    return ((paramDrawable.getIntrinsicHeight() > 0) && (paramDrawable.getIntrinsicWidth() > 0)) || ((paramDrawable.getMinimumWidth() > 0) && (paramDrawable.getMinimumHeight() > 0)) || ((paramDrawable.getBounds().width() > 0) && (paramDrawable.getBounds().height() > 0));
  }
  
  private float b(float paramFloat1, float paramFloat2)
  {
    return paramFloat2 * (Math.abs(Math.abs(paramFloat1) - this.jdField_e_of_type_Int) / this.jdField_e_of_type_Int);
  }
  
  private static int b(Drawable paramDrawable)
  {
    int n = paramDrawable.getIntrinsicHeight();
    int m = n;
    if (n <= 0) {
      m = paramDrawable.getMinimumHeight();
    }
    n = m;
    if (m <= 0) {
      n = paramDrawable.getBounds().height();
    }
    return n;
  }
  
  private void b()
  {
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == null) {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.jdField_a_of_type_ComBmLibraryRotateGestureDetector = new RotateGestureDetector(this.jdField_a_of_type_ComBmLibraryOnRotateListener);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(getContext(), this.jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener);
    float f1 = getResources().getDisplayMetrics().density;
    int m = (int)(30.0F * f1);
    this.jdField_c_of_type_Int = m;
    this.jdField_d_of_type_Int = m;
    this.jdField_e_of_type_Int = ((int)(f1 * 140.0F));
    this.jdField_a_of_type_Int = 35;
    this.jdField_b_of_type_Int = 340;
    this.jdField_a_of_type_Float = 2.5F;
  }
  
  private boolean b(RectF paramRectF)
  {
    return Math.abs(Math.round(paramRectF.left) - (this.jdField_a_of_type_AndroidGraphicsRectF.width() - paramRectF.width()) / 2.0F) < 1.0F;
  }
  
  private void c()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_h_of_type_Boolean = false;
    Object localObject = getDrawable();
    int m = getWidth();
    int n = getHeight();
    int i1 = a((Drawable)localObject);
    int i2 = b((Drawable)localObject);
    localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
    float f1 = i1;
    float f3 = i2;
    ((RectF)localObject).set(0.0F, 0.0F, f1, f3);
    int i3 = (m - i1) / 2;
    int i4 = (n - i2) / 2;
    float f2 = 1.0F;
    if (i1 > m) {
      f1 = m / f1;
    } else {
      f1 = 1.0F;
    }
    if (i2 > n) {
      f2 = n / f3;
    }
    if (f1 >= f2) {
      f1 = f2;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(i3, i4);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
    this.jdField_e_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.width() / 2.0F);
    this.jdField_f_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.height() / 2.0F);
    this.jdField_b_of_type_AndroidGraphicsPointF.set(this.jdField_a_of_type_AndroidGraphicsPointF);
    this.jdField_c_of_type_AndroidGraphicsPointF.set(this.jdField_b_of_type_AndroidGraphicsPointF);
    l();
    switch (PhotoView.6.a[this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal()])
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
    this.jdField_f_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComBmLibraryInfo != null) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < this.jdField_f_of_type_Int)) {
      a(this.jdField_a_of_type_ComBmLibraryInfo);
    }
    this.jdField_a_of_type_ComBmLibraryInfo = null;
  }
  
  private void d()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject = getDrawable();
    int m = a((Drawable)localObject);
    int n = b((Drawable)localObject);
    float f1 = m;
    if ((f1 > this.jdField_a_of_type_AndroidGraphicsRectF.width()) || (n > this.jdField_a_of_type_AndroidGraphicsRectF.height()))
    {
      float f2 = f1 / this.jdField_c_of_type_AndroidGraphicsRectF.width();
      float f3 = n / this.jdField_c_of_type_AndroidGraphicsRectF.height();
      f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      this.jdField_d_of_type_Float = f1;
      localObject = this.jdField_b_of_type_AndroidGraphicsMatrix;
      f1 = this.jdField_d_of_type_Float;
      ((Matrix)localObject).postScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      l();
      k();
    }
  }
  
  private void e()
  {
    if ((this.jdField_c_of_type_AndroidGraphicsRectF.width() < this.jdField_a_of_type_AndroidGraphicsRectF.width()) || (this.jdField_c_of_type_AndroidGraphicsRectF.height() < this.jdField_a_of_type_AndroidGraphicsRectF.height()))
    {
      float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width();
      float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_c_of_type_AndroidGraphicsRectF.height();
      if (f1 <= f2) {
        f1 = f2;
      }
      this.jdField_d_of_type_Float = f1;
      Matrix localMatrix = this.jdField_b_of_type_AndroidGraphicsMatrix;
      f1 = this.jdField_d_of_type_Float;
      localMatrix.postScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      l();
      k();
    }
  }
  
  private void f()
  {
    if ((this.jdField_c_of_type_AndroidGraphicsRectF.width() > this.jdField_a_of_type_AndroidGraphicsRectF.width()) || (this.jdField_c_of_type_AndroidGraphicsRectF.height() > this.jdField_a_of_type_AndroidGraphicsRectF.height()))
    {
      float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width();
      float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_c_of_type_AndroidGraphicsRectF.height();
      if (f1 >= f2) {
        f1 = f2;
      }
      this.jdField_d_of_type_Float = f1;
      Matrix localMatrix = this.jdField_b_of_type_AndroidGraphicsMatrix;
      f1 = this.jdField_d_of_type_Float;
      localMatrix.postScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      l();
      k();
    }
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_AndroidGraphicsRectF.width() < this.jdField_a_of_type_AndroidGraphicsRectF.width())
    {
      this.jdField_d_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width());
      Matrix localMatrix = this.jdField_b_of_type_AndroidGraphicsMatrix;
      float f1 = this.jdField_d_of_type_Float;
      localMatrix.postScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      l();
      k();
    }
  }
  
  private void h()
  {
    g();
    float f1 = -this.jdField_c_of_type_AndroidGraphicsRectF.top;
    this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(0.0F, f1);
    l();
    k();
    this.jdField_h_of_type_Int = ((int)(this.jdField_h_of_type_Int + f1));
  }
  
  private void i()
  {
    g();
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom - this.jdField_c_of_type_AndroidGraphicsRectF.bottom;
    this.jdField_h_of_type_Int = ((int)(this.jdField_h_of_type_Int + f1));
    this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(0.0F, f1);
    l();
    k();
  }
  
  private void j()
  {
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width();
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_c_of_type_AndroidGraphicsRectF.height();
    this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(f1, f2, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
    l();
    k();
  }
  
  private void k()
  {
    Drawable localDrawable = getDrawable();
    int m = a(localDrawable);
    int n = b(localDrawable);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, m, n);
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_c_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
    this.jdField_e_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.width() / 2.0F);
    this.jdField_f_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.height() / 2.0F);
    this.jdField_d_of_type_Float = 1.0F;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
  }
  
  private void l()
  {
    this.jdField_c_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_c_of_type_AndroidGraphicsMatrix.postConcat(this.jdField_b_of_type_AndroidGraphicsMatrix);
    setImageMatrix(this.jdField_c_of_type_AndroidGraphicsMatrix);
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
    float f1 = this.jdField_c_of_type_AndroidGraphicsRectF.width();
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
    boolean bool2 = true;
    boolean bool1;
    if (f1 > f2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.j = bool1;
    if (this.jdField_c_of_type_AndroidGraphicsRectF.height() > this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.k = bool1;
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.i) || (this.jdField_c_of_type_Float % 90.0F != 0.0F))
    {
      f1 = this.jdField_c_of_type_Float;
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
      this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a((int)this.jdField_c_of_type_Float, (int)f1);
      this.jdField_c_of_type_Float = f1;
    }
    float f1 = this.jdField_d_of_type_Float;
    float f2 = 1.0F;
    if (f1 < 1.0F)
    {
      this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(f1, 1.0F);
      f1 = f2;
    }
    else
    {
      f2 = this.jdField_a_of_type_Float;
      if (f1 > f2)
      {
        this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(f1, f2);
        f1 = f2;
      }
    }
    f2 = this.jdField_c_of_type_AndroidGraphicsRectF.left + this.jdField_c_of_type_AndroidGraphicsRectF.width() / 2.0F;
    float f3 = this.jdField_c_of_type_AndroidGraphicsRectF.top + this.jdField_c_of_type_AndroidGraphicsRectF.height() / 2.0F;
    this.jdField_b_of_type_AndroidGraphicsPointF.set(f2, f3);
    this.jdField_c_of_type_AndroidGraphicsPointF.set(f2, f3);
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_d_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_d_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_b_of_type_AndroidGraphicsRectF.left, -this.jdField_b_of_type_AndroidGraphicsRectF.top);
    this.jdField_d_of_type_AndroidGraphicsMatrix.postTranslate(f2 - this.jdField_e_of_type_Float, f3 - this.jdField_f_of_type_Float);
    this.jdField_d_of_type_AndroidGraphicsMatrix.postScale(f1, f1, f2, f3);
    this.jdField_d_of_type_AndroidGraphicsMatrix.postRotate(this.jdField_c_of_type_Float, f2, f3);
    this.jdField_d_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_d_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
    a(this.jdField_d_of_type_AndroidGraphicsRectF);
    this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a();
  }
  
  private void n()
  {
    if (!this.jdField_d_of_type_Boolean) {
      a(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_e_of_type_AndroidGraphicsRectF);
    }
  }
  
  private void o()
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    l();
    this.jdField_d_of_type_Float = 1.0F;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
  }
  
  public Info a()
  {
    RectF localRectF = new RectF();
    int[] arrayOfInt = new int[2];
    a(this, arrayOfInt);
    localRectF.set(arrayOfInt[0] + this.jdField_c_of_type_AndroidGraphicsRectF.left, arrayOfInt[1] + this.jdField_c_of_type_AndroidGraphicsRectF.top, arrayOfInt[0] + this.jdField_c_of_type_AndroidGraphicsRectF.right, arrayOfInt[1] + this.jdField_c_of_type_AndroidGraphicsRectF.bottom);
    return new Info(localRectF, this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPointF, this.jdField_d_of_type_Float, this.jdField_c_of_type_Float, this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
  }
  
  public void a()
  {
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void a(Info paramInfo)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      o();
      Object localObject = a();
      float f1 = paramInfo.jdField_b_of_type_AndroidGraphicsRectF.width() / ((Info)localObject).jdField_b_of_type_AndroidGraphicsRectF.width();
      float f2 = paramInfo.jdField_b_of_type_AndroidGraphicsRectF.height() / ((Info)localObject).jdField_b_of_type_AndroidGraphicsRectF.height();
      if (f1 >= f2) {
        f1 = f2;
      }
      f2 = paramInfo.jdField_a_of_type_AndroidGraphicsRectF.left + paramInfo.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
      float f3 = paramInfo.jdField_a_of_type_AndroidGraphicsRectF.top + paramInfo.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F;
      float f6 = ((Info)localObject).jdField_a_of_type_AndroidGraphicsRectF.left;
      float f7 = ((Info)localObject).jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
      float f4 = ((Info)localObject).jdField_a_of_type_AndroidGraphicsRectF.top;
      float f5 = ((Info)localObject).jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F;
      this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
      localObject = this.jdField_b_of_type_AndroidGraphicsMatrix;
      f6 = f2 - (f6 + f7);
      f4 = f3 - (f4 + f5);
      ((Matrix)localObject).postTranslate(f6, f4);
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(f1, f1, f2, f3);
      this.jdField_b_of_type_AndroidGraphicsMatrix.postRotate(paramInfo.jdField_b_of_type_Float, f2, f3);
      l();
      this.jdField_b_of_type_AndroidGraphicsPointF.set(f2, f3);
      this.jdField_c_of_type_AndroidGraphicsPointF.set(f2, f3);
      this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(0, 0, (int)-f6, (int)-f4);
      this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(f1, 1.0F);
      this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a((int)paramInfo.jdField_b_of_type_Float, 0);
      if ((paramInfo.jdField_c_of_type_AndroidGraphicsRectF.width() < paramInfo.jdField_b_of_type_AndroidGraphicsRectF.width()) || (paramInfo.jdField_c_of_type_AndroidGraphicsRectF.height() < paramInfo.jdField_b_of_type_AndroidGraphicsRectF.height()))
      {
        f2 = paramInfo.jdField_c_of_type_AndroidGraphicsRectF.width() / paramInfo.jdField_b_of_type_AndroidGraphicsRectF.width();
        f3 = paramInfo.jdField_c_of_type_AndroidGraphicsRectF.height() / paramInfo.jdField_b_of_type_AndroidGraphicsRectF.height();
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        f2 = f3;
        if (f3 > 1.0F) {
          f2 = 1.0F;
        }
        if (paramInfo.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.FIT_START) {
          paramInfo = new PhotoView.START(this);
        } else if (paramInfo.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.FIT_END) {
          paramInfo = new PhotoView.END(this);
        } else {
          paramInfo = new PhotoView.OTHER(this);
        }
        this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(f1, f2, 1.0F - f1, 1.0F - f2, this.jdField_b_of_type_Int / 3, paramInfo);
        this.jdField_d_of_type_AndroidGraphicsMatrix.setScale(f1, f2, (this.jdField_c_of_type_AndroidGraphicsRectF.left + this.jdField_c_of_type_AndroidGraphicsRectF.right) / 2.0F, paramInfo.a());
        this.jdField_d_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_AndroidGraphicsRectF);
        this.jdField_f_of_type_AndroidGraphicsRectF = this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.jdField_a_of_type_AndroidGraphicsRectF;
      }
      this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a();
      return;
    }
    this.jdField_a_of_type_ComBmLibraryInfo = paramInfo;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a(float paramFloat)
  {
    if (this.jdField_c_of_type_AndroidGraphicsRectF.width() <= this.jdField_a_of_type_AndroidGraphicsRectF.width()) {
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.jdField_c_of_type_AndroidGraphicsRectF.left) - paramFloat >= this.jdField_a_of_type_AndroidGraphicsRectF.left)) {
      return false;
    }
    return (paramFloat <= 0.0F) || (Math.round(this.jdField_c_of_type_AndroidGraphicsRectF.right) - paramFloat > this.jdField_a_of_type_AndroidGraphicsRectF.right);
  }
  
  public boolean b(float paramFloat)
  {
    if (this.jdField_c_of_type_AndroidGraphicsRectF.height() <= this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.jdField_c_of_type_AndroidGraphicsRectF.top) - paramFloat >= this.jdField_a_of_type_AndroidGraphicsRectF.top)) {
      return false;
    }
    return (paramFloat <= 0.0F) || (Math.round(this.jdField_c_of_type_AndroidGraphicsRectF.bottom) - paramFloat > this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return a(paramInt);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return b(paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_e_of_type_Boolean)
    {
      int m = paramMotionEvent.getActionMasked();
      if (paramMotionEvent.getPointerCount() >= 2) {
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_ComBmLibraryRotateGestureDetector.a(paramMotionEvent);
      this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
      if ((m == 1) || (m == 3)) {
        m();
      }
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    RectF localRectF = this.jdField_f_of_type_AndroidGraphicsRectF;
    if (localRectF != null)
    {
      paramCanvas.clipRect(localRectF);
      this.jdField_f_of_type_AndroidGraphicsRectF = null;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    Object localObject = getDrawable();
    int i1 = a((Drawable)localObject);
    int i2 = b((Drawable)localObject);
    int n = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new ViewGroup.LayoutParams(-2, -2);
    }
    if (((ViewGroup.LayoutParams)localObject).width == -1)
    {
      paramInt1 = n;
      if (i4 != 0) {
        break label144;
      }
    }
    else
    {
      if (i4 == 1073741824)
      {
        paramInt1 = n;
        break label144;
      }
      if ((i4 == -2147483648) && (i1 > n))
      {
        paramInt1 = n;
        break label144;
      }
    }
    paramInt1 = i1;
    label144:
    if (((ViewGroup.LayoutParams)localObject).height == -1)
    {
      paramInt2 = m;
      if (i3 != 0) {
        break label202;
      }
    }
    else
    {
      if (i3 == 1073741824)
      {
        paramInt2 = m;
        break label202;
      }
      if ((i3 == -2147483648) && (i2 > m))
      {
        paramInt2 = m;
        break label202;
      }
    }
    paramInt2 = i2;
    label202:
    n = paramInt1;
    m = paramInt2;
    if (this.jdField_g_of_type_Boolean)
    {
      float f4 = i1;
      float f5 = i2;
      float f2 = f4 / f5;
      float f1 = paramInt1;
      float f3 = paramInt2;
      n = paramInt1;
      m = paramInt2;
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
          n = paramInt1;
          m = paramInt2;
        }
        else
        {
          m = (int)(f5 * f1);
          n = paramInt1;
        }
      }
    }
    setMeasuredDimension(n, m);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPointF.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      c();
    }
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    super.setAdjustViewBounds(paramBoolean);
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setAnimaDuring(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (!a(paramDrawable)) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = true;
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
    this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(paramInterpolator);
  }
  
  public void setMaxAnimFromWaiteTime(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == ImageView.ScaleType.MATRIX) {
      return;
    }
    if (paramScaleType != this.jdField_a_of_type_AndroidWidgetImageView$ScaleType)
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
      if (this.jdField_f_of_type_Boolean) {
        c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.bm.library.PhotoView
 * JD-Core Version:    0.7.0.1
 */