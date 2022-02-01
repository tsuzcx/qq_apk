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
    return Math.abs(Math.abs(paramFloat1) - this.jdField_e_of_type_Int) / this.jdField_e_of_type_Int * paramFloat2;
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
    int n = 0;
    int m;
    if (paramRectF.width() <= this.jdField_a_of_type_AndroidGraphicsRectF.width())
    {
      if (b(paramRectF)) {
        break label271;
      }
      m = -(int)((this.jdField_a_of_type_AndroidGraphicsRectF.width() - paramRectF.width()) / 2.0F - paramRectF.left);
    }
    for (;;)
    {
      if (paramRectF.height() <= this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
        if (!a(paramRectF)) {
          n = -(int)((this.jdField_a_of_type_AndroidGraphicsRectF.height() - paramRectF.height()) / 2.0F - paramRectF.top);
        }
      }
      for (;;)
      {
        if ((m != 0) || (n != 0))
        {
          if (!this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.b.isFinished()) {
            this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.b.abortAnimation();
          }
          this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, -m, -n);
        }
        return;
        if (paramRectF.left > this.jdField_a_of_type_AndroidGraphicsRectF.left)
        {
          m = (int)(paramRectF.left - this.jdField_a_of_type_AndroidGraphicsRectF.left);
          break;
        }
        if (paramRectF.right >= this.jdField_a_of_type_AndroidGraphicsRectF.right) {
          break label271;
        }
        m = (int)(paramRectF.right - this.jdField_a_of_type_AndroidGraphicsRectF.right);
        break;
        if (paramRectF.top > this.jdField_a_of_type_AndroidGraphicsRectF.top) {
          n = (int)(paramRectF.top - this.jdField_a_of_type_AndroidGraphicsRectF.top);
        } else if (paramRectF.bottom < this.jdField_a_of_type_AndroidGraphicsRectF.bottom) {
          n = (int)(paramRectF.bottom - this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
        }
      }
      label271:
      m = 0;
    }
  }
  
  private void a(RectF paramRectF1, RectF paramRectF2, RectF paramRectF3)
  {
    float f1;
    if (paramRectF1.left > paramRectF2.left)
    {
      f1 = paramRectF1.left;
      if (paramRectF1.right >= paramRectF2.right) {
        break label62;
      }
    }
    label62:
    for (float f2 = paramRectF1.right;; f2 = paramRectF2.right)
    {
      if (f1 <= f2) {
        break label71;
      }
      paramRectF3.set(0.0F, 0.0F, 0.0F, 0.0F);
      return;
      f1 = paramRectF2.left;
      break;
    }
    label71:
    float f3;
    if (paramRectF1.top > paramRectF2.top)
    {
      f3 = paramRectF1.top;
      if (paramRectF1.bottom >= paramRectF2.bottom) {
        break label133;
      }
    }
    label133:
    for (float f4 = paramRectF1.bottom;; f4 = paramRectF2.bottom)
    {
      if (f3 <= f4) {
        break label142;
      }
      paramRectF3.set(0.0F, 0.0F, 0.0F, 0.0F);
      return;
      f3 = paramRectF2.top;
      break;
    }
    label142:
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
    return Math.abs(Math.abs(paramFloat1) - this.jdField_e_of_type_Int) / this.jdField_e_of_type_Int * paramFloat2;
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
    this.jdField_c_of_type_Int = ((int)(f1 * 30.0F));
    this.jdField_d_of_type_Int = ((int)(f1 * 30.0F));
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
    float f2 = 1.0F;
    if (!this.jdField_b_of_type_Boolean) {}
    while (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_h_of_type_Boolean = false;
    Drawable localDrawable = getDrawable();
    int m = getWidth();
    int n = getHeight();
    int i1 = a(localDrawable);
    int i2 = b(localDrawable);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i1, i2);
    int i3 = (m - i1) / 2;
    int i4 = (n - i2) / 2;
    if (i1 > m) {}
    for (float f1 = m / i1;; f1 = 1.0F)
    {
      if (i2 > n) {
        f2 = n / i2;
      }
      if (f1 < f2)
      {
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
        }
      }
      for (;;)
      {
        this.jdField_f_of_type_Boolean = true;
        if ((this.jdField_a_of_type_ComBmLibraryInfo != null) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < this.jdField_f_of_type_Int)) {
          a(this.jdField_a_of_type_ComBmLibraryInfo);
        }
        this.jdField_a_of_type_ComBmLibraryInfo = null;
        return;
        f1 = f2;
        break;
        d();
        continue;
        e();
        continue;
        f();
        continue;
        g();
        continue;
        h();
        continue;
        i();
        continue;
        j();
      }
    }
  }
  
  private void d()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    int m;
    int n;
    do
    {
      do
      {
        return;
      } while (!this.jdField_c_of_type_Boolean);
      Drawable localDrawable = getDrawable();
      m = a(localDrawable);
      n = b(localDrawable);
    } while ((m <= this.jdField_a_of_type_AndroidGraphicsRectF.width()) && (n <= this.jdField_a_of_type_AndroidGraphicsRectF.height()));
    float f1 = m / this.jdField_c_of_type_AndroidGraphicsRectF.width();
    float f2 = n / this.jdField_c_of_type_AndroidGraphicsRectF.height();
    if (f1 > f2) {}
    for (;;)
    {
      this.jdField_d_of_type_Float = f1;
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(this.jdField_d_of_type_Float, this.jdField_d_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      l();
      k();
      return;
      f1 = f2;
    }
  }
  
  private void e()
  {
    float f1;
    float f2;
    if ((this.jdField_c_of_type_AndroidGraphicsRectF.width() < this.jdField_a_of_type_AndroidGraphicsRectF.width()) || (this.jdField_c_of_type_AndroidGraphicsRectF.height() < this.jdField_a_of_type_AndroidGraphicsRectF.height()))
    {
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width();
      f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_c_of_type_AndroidGraphicsRectF.height();
      if (f1 <= f2) {
        break label118;
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Float = f1;
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(this.jdField_d_of_type_Float, this.jdField_d_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      l();
      k();
      return;
      label118:
      f1 = f2;
    }
  }
  
  private void f()
  {
    float f1;
    float f2;
    if ((this.jdField_c_of_type_AndroidGraphicsRectF.width() > this.jdField_a_of_type_AndroidGraphicsRectF.width()) || (this.jdField_c_of_type_AndroidGraphicsRectF.height() > this.jdField_a_of_type_AndroidGraphicsRectF.height()))
    {
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width();
      f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_c_of_type_AndroidGraphicsRectF.height();
      if (f1 >= f2) {
        break label118;
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Float = f1;
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(this.jdField_d_of_type_Float, this.jdField_d_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      l();
      k();
      return;
      label118:
      f1 = f2;
    }
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_AndroidGraphicsRectF.width() < this.jdField_a_of_type_AndroidGraphicsRectF.width())
    {
      this.jdField_d_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width());
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(this.jdField_d_of_type_Float, this.jdField_d_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
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
    this.jdField_h_of_type_Int = ((int)(f1 + this.jdField_h_of_type_Int));
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
    boolean bool2 = true;
    this.jdField_c_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_c_of_type_AndroidGraphicsMatrix.postConcat(this.jdField_b_of_type_AndroidGraphicsMatrix);
    setImageMatrix(this.jdField_c_of_type_AndroidGraphicsMatrix);
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
    if (this.jdField_c_of_type_AndroidGraphicsRectF.width() > this.jdField_a_of_type_AndroidGraphicsRectF.width())
    {
      bool1 = true;
      this.j = bool1;
      if (this.jdField_c_of_type_AndroidGraphicsRectF.height() <= this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
        break label105;
      }
    }
    label105:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.k = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.jdField_a_of_type_Boolean) {
      return;
    }
    float f2;
    float f3;
    float f1;
    if ((this.i) || (this.jdField_c_of_type_Float % 90.0F != 0.0F))
    {
      f2 = (int)(this.jdField_c_of_type_Float / 90.0F) * 90;
      f3 = this.jdField_c_of_type_Float % 90.0F;
      if (f3 > 45.0F)
      {
        f1 = f2 + 90.0F;
        this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a((int)this.jdField_c_of_type_Float, (int)f1);
        this.jdField_c_of_type_Float = f1;
      }
    }
    else
    {
      f1 = this.jdField_d_of_type_Float;
      if (this.jdField_d_of_type_Float >= 1.0F) {
        break label307;
      }
      this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(this.jdField_d_of_type_Float, 1.0F);
      f1 = 1.0F;
    }
    for (;;)
    {
      f2 = this.jdField_c_of_type_AndroidGraphicsRectF.left + this.jdField_c_of_type_AndroidGraphicsRectF.width() / 2.0F;
      f3 = this.jdField_c_of_type_AndroidGraphicsRectF.top + this.jdField_c_of_type_AndroidGraphicsRectF.height() / 2.0F;
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
      return;
      f1 = f2;
      if (f3 >= -45.0F) {
        break;
      }
      f1 = f2 - 90.0F;
      break;
      label307:
      if (this.jdField_d_of_type_Float > this.jdField_a_of_type_Float)
      {
        f1 = this.jdField_a_of_type_Float;
        this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(this.jdField_d_of_type_Float, this.jdField_a_of_type_Float);
      }
    }
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
      Info localInfo = a();
      float f1 = paramInfo.jdField_b_of_type_AndroidGraphicsRectF.width() / localInfo.jdField_b_of_type_AndroidGraphicsRectF.width();
      float f2 = paramInfo.jdField_b_of_type_AndroidGraphicsRectF.height() / localInfo.jdField_b_of_type_AndroidGraphicsRectF.height();
      if (f1 < f2)
      {
        f2 = paramInfo.jdField_a_of_type_AndroidGraphicsRectF.left + paramInfo.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
        float f3 = paramInfo.jdField_a_of_type_AndroidGraphicsRectF.top + paramInfo.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F;
        float f4 = localInfo.jdField_a_of_type_AndroidGraphicsRectF.left + localInfo.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
        float f5 = localInfo.jdField_a_of_type_AndroidGraphicsRectF.top;
        f5 = localInfo.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F + f5;
        this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(f2 - f4, f3 - f5);
        this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(f1, f1, f2, f3);
        this.jdField_b_of_type_AndroidGraphicsMatrix.postRotate(paramInfo.jdField_b_of_type_Float, f2, f3);
        l();
        this.jdField_b_of_type_AndroidGraphicsPointF.set(f2, f3);
        this.jdField_c_of_type_AndroidGraphicsPointF.set(f2, f3);
        this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(0, 0, (int)-(f2 - f4), (int)-(f3 - f5));
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
          if (paramInfo.jdField_a_of_type_AndroidWidgetImageView$ScaleType != ImageView.ScaleType.FIT_START) {
            break label467;
          }
          paramInfo = new PhotoView.START(this);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a(f1, f2, 1.0F - f1, 1.0F - f2, this.jdField_b_of_type_Int / 3, paramInfo);
        this.jdField_d_of_type_AndroidGraphicsMatrix.setScale(f1, f2, (this.jdField_c_of_type_AndroidGraphicsRectF.left + this.jdField_c_of_type_AndroidGraphicsRectF.right) / 2.0F, paramInfo.a());
        this.jdField_d_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_AndroidGraphicsRectF);
        this.jdField_f_of_type_AndroidGraphicsRectF = this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.jdField_a_of_type_AndroidGraphicsRectF;
        this.jdField_a_of_type_ComBmLibraryPhotoView$Transform.a();
        return;
        f1 = f2;
        break;
        label467:
        if (paramInfo.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.FIT_END) {
          paramInfo = new PhotoView.END(this);
        } else {
          paramInfo = new PhotoView.OTHER(this);
        }
      }
    }
    this.jdField_a_of_type_ComBmLibraryInfo = paramInfo;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a(float paramFloat)
  {
    if (this.jdField_c_of_type_AndroidGraphicsRectF.width() <= this.jdField_a_of_type_AndroidGraphicsRectF.width()) {}
    while (((paramFloat < 0.0F) && (Math.round(this.jdField_c_of_type_AndroidGraphicsRectF.left) - paramFloat >= this.jdField_a_of_type_AndroidGraphicsRectF.left)) || ((paramFloat > 0.0F) && (Math.round(this.jdField_c_of_type_AndroidGraphicsRectF.right) - paramFloat <= this.jdField_a_of_type_AndroidGraphicsRectF.right))) {
      return false;
    }
    return true;
  }
  
  public boolean b(float paramFloat)
  {
    if (this.jdField_c_of_type_AndroidGraphicsRectF.height() <= this.jdField_a_of_type_AndroidGraphicsRectF.height()) {}
    while (((paramFloat < 0.0F) && (Math.round(this.jdField_c_of_type_AndroidGraphicsRectF.top) - paramFloat >= this.jdField_a_of_type_AndroidGraphicsRectF.top)) || ((paramFloat > 0.0F) && (Math.round(this.jdField_c_of_type_AndroidGraphicsRectF.bottom) - paramFloat <= this.jdField_a_of_type_AndroidGraphicsRectF.bottom))) {
      return false;
    }
    return true;
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
    if (this.jdField_f_of_type_AndroidGraphicsRectF != null)
    {
      paramCanvas.clipRect(this.jdField_f_of_type_AndroidGraphicsRectF);
      this.jdField_f_of_type_AndroidGraphicsRectF = null;
    }
    super.draw(paramCanvas);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    Object localObject = getDrawable();
    int n = a((Drawable)localObject);
    int m = b((Drawable)localObject);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new ViewGroup.LayoutParams(-2, -2);
    }
    label126:
    float f1;
    float f2;
    if (((ViewGroup.LayoutParams)localObject).width == -1)
    {
      paramInt1 = i2;
      if (i4 == 0) {
        paramInt1 = n;
      }
      if (((ViewGroup.LayoutParams)localObject).height != -1) {
        break label257;
      }
      paramInt2 = i1;
      if (i3 == 0) {
        paramInt2 = m;
      }
      i1 = paramInt1;
      i2 = paramInt2;
      if (this.jdField_g_of_type_Boolean)
      {
        i1 = paramInt1;
        i2 = paramInt2;
        if (n / m != paramInt1 / paramInt2)
        {
          f1 = paramInt2 / m;
          f2 = paramInt1 / n;
          if (f1 >= f2) {
            break label298;
          }
          label183:
          if (((ViewGroup.LayoutParams)localObject).width != -1) {
            break label304;
          }
          label192:
          if (((ViewGroup.LayoutParams)localObject).height != -1) {
            break label314;
          }
          i2 = paramInt2;
        }
      }
    }
    for (i1 = paramInt1;; i1 = paramInt1)
    {
      setMeasuredDimension(i1, i2);
      return;
      paramInt1 = i2;
      if (i4 == 1073741824) {
        break;
      }
      if (i4 == -2147483648)
      {
        paramInt1 = i2;
        if (n > i2) {
          break;
        }
        paramInt1 = n;
        break;
      }
      paramInt1 = n;
      break;
      label257:
      paramInt2 = i1;
      if (i3 == 1073741824) {
        break label126;
      }
      if (i3 == -2147483648)
      {
        paramInt2 = i1;
        if (m > i1) {
          break label126;
        }
        paramInt2 = m;
        break label126;
      }
      paramInt2 = m;
      break label126;
      label298:
      f1 = f2;
      break label183;
      label304:
      paramInt1 = (int)(n * f1);
      break label192;
      label314:
      i2 = (int)(m * f1);
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
    if (paramDrawable == null) {
      this.jdField_b_of_type_Boolean = false;
    }
    while (!a(paramDrawable)) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = true;
    }
    c();
  }
  
  public void setImageResource(int paramInt)
  {
    Object localObject = null;
    try
    {
      Drawable localDrawable = getResources().getDrawable(paramInt);
      localObject = localDrawable;
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    setImageDrawable(localObject);
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
    if (paramScaleType == ImageView.ScaleType.MATRIX) {}
    do
    {
      do
      {
        return;
      } while (paramScaleType == this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
    } while (!this.jdField_f_of_type_Boolean);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.bm.library.PhotoView
 * JD-Core Version:    0.7.0.1
 */