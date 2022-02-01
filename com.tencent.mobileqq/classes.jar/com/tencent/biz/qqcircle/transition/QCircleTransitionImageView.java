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
import vst;
import vsu;
import vsv;
import vsx;
import vsy;
import vsz;

public class QCircleTransitionImageView
  extends ImageView
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private QCircleTransitionImageView.Transform jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform = new QCircleTransitionImageView.Transform(this);
  private vsv jdField_a_of_type_Vsv;
  private vsz jdField_a_of_type_Vsz;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private PointF jdField_b_of_type_AndroidGraphicsPointF = new PointF();
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Matrix jdField_c_of_type_AndroidGraphicsMatrix = new Matrix();
  private PointF jdField_c_of_type_AndroidGraphicsPointF = new PointF();
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_c_of_type_Boolean;
  private Matrix jdField_d_of_type_AndroidGraphicsMatrix = new Matrix();
  private RectF jdField_d_of_type_AndroidGraphicsRectF;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
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
  
  private static int a(Drawable paramDrawable)
  {
    int j = paramDrawable.getIntrinsicWidth();
    int i = j;
    if (j <= 0) {
      i = paramDrawable.getMinimumWidth();
    }
    j = i;
    if (i <= 0) {
      j = paramDrawable.getBounds().width();
    }
    return j;
  }
  
  public static vsv a(Matrix paramMatrix, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return null;
    }
    Object localObject1 = new int[2];
    a(paramImageView, (int[])localObject1);
    Object localObject3 = paramImageView.getDrawable();
    Object localObject2 = paramImageView.getImageMatrix();
    int i = a((Drawable)localObject3);
    int j = b((Drawable)localObject3);
    localObject3 = new RectF(0.0F, 0.0F, i, j);
    ((Matrix)localObject2).mapRect((RectF)localObject3);
    RectF localRectF1 = new RectF(localObject1[0] + ((RectF)localObject3).left, localObject1[1] + ((RectF)localObject3).top, localObject1[0] + ((RectF)localObject3).right, localObject1[1] + ((RectF)localObject3).bottom);
    RectF localRectF2 = new RectF(0.0F, 0.0F, paramImageView.getWidth(), paramImageView.getHeight());
    RectF localRectF3 = new RectF((RectF)localObject3);
    localObject2 = new vsv(localRectF1, (RectF)localObject3, localRectF2, localRectF3, new PointF(localRectF2.width() / 2.0F, localRectF2.height() / 2.0F), 1.0F, paramImageView.getScaleType());
    localObject1 = localObject2;
    if (paramMatrix != null)
    {
      QLog.d("QCircleTransitionImageView", 1, "getOriginalShowImageInfo:" + ((vsv)localObject2).toString());
      paramMatrix.mapRect((RectF)localObject3);
      paramMatrix.mapRect(localRectF1);
      paramMatrix.mapRect(localRectF2);
      paramMatrix.mapRect(localRectF3);
      localObject1 = new vsv(localRectF1, (RectF)localObject3, localRectF2, localRectF3, new PointF(localRectF2.width() / 2.0F, localRectF2.height() / 2.0F), 1.0F, paramImageView.getScaleType());
    }
    QLog.d("QCircleTransitionImageView", 1, "getCurrentShowImageInfo:" + ((vsv)localObject1).toString());
    return localObject1;
  }
  
  private void a()
  {
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == null) {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.jdField_a_of_type_Int = 340;
  }
  
  public static void a(View paramView, int[] paramArrayOfInt)
  {
    if (paramView == null) {
      return;
    }
    paramArrayOfInt[0] += paramView.getLeft();
    paramArrayOfInt[1] += paramView.getTop();
    for (paramView = paramView.getParent();; paramView = paramView.getParent())
    {
      if (!(paramView instanceof View)) {
        break label105;
      }
      paramView = (View)paramView;
      if (paramView.getId() == 16908290) {
        break;
      }
      paramArrayOfInt[0] -= paramView.getScrollX();
      paramArrayOfInt[1] -= paramView.getScrollY();
      paramArrayOfInt[0] += paramView.getLeft();
      paramArrayOfInt[1] += paramView.getTop();
    }
    label105:
    paramArrayOfInt[0] = ((int)(paramArrayOfInt[0] + 0.5F));
    paramArrayOfInt[1] = ((int)(paramArrayOfInt[1] + 0.5F));
  }
  
  private boolean a(Drawable paramDrawable)
  {
    return ((paramDrawable.getIntrinsicHeight() > 0) && (paramDrawable.getIntrinsicWidth() > 0)) || ((paramDrawable.getMinimumWidth() > 0) && (paramDrawable.getMinimumHeight() > 0)) || ((paramDrawable.getBounds().width() > 0) && (paramDrawable.getBounds().height() > 0));
  }
  
  private static int b(Drawable paramDrawable)
  {
    int j = paramDrawable.getIntrinsicHeight();
    int i = j;
    if (j <= 0) {
      i = paramDrawable.getMinimumHeight();
    }
    j = i;
    if (i <= 0) {
      j = paramDrawable.getBounds().height();
    }
    return j;
  }
  
  private void b()
  {
    float f2 = 1.0F;
    if (!this.jdField_a_of_type_Boolean) {}
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    Drawable localDrawable = getDrawable();
    int i = getPaddingLeft();
    int m = getPaddingRight();
    int j = getPaddingTop();
    int k = getPaddingBottom();
    i = getWidth() - i - m;
    j = getHeight() - j - k;
    k = a(localDrawable);
    m = b(localDrawable);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, k, m);
    int n = (i - k) / 2;
    int i1 = (j - m) / 2;
    if (k > i) {}
    for (float f1 = i / k;; f1 = 1.0F)
    {
      if (m > j) {
        f2 = j / m;
      }
      f1 = Math.min(f1, f2);
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(n, i1);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
      this.jdField_b_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.width() / 2.0F);
      this.jdField_c_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.height() / 2.0F);
      this.jdField_b_of_type_AndroidGraphicsPointF.set(this.jdField_a_of_type_AndroidGraphicsPointF);
      this.jdField_c_of_type_AndroidGraphicsPointF.set(this.jdField_b_of_type_AndroidGraphicsPointF);
      k();
      switch (vss.a[this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal()])
      {
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = true;
        if ((this.jdField_a_of_type_Vsv != null) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L)) {
          a(this.jdField_a_of_type_Vsv, this.jdField_a_of_type_Vsz);
        }
        this.jdField_a_of_type_Vsv = null;
        return;
        c();
        continue;
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
      }
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while (!this.jdField_b_of_type_Boolean);
      Drawable localDrawable = getDrawable();
      i = a(localDrawable);
      j = b(localDrawable);
    } while ((i <= this.jdField_a_of_type_AndroidGraphicsRectF.width()) && (j <= this.jdField_a_of_type_AndroidGraphicsRectF.height()));
    float f1 = i / this.jdField_c_of_type_AndroidGraphicsRectF.width();
    float f2 = j / this.jdField_c_of_type_AndroidGraphicsRectF.height();
    if (f1 > f2) {}
    for (;;)
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      k();
      j();
      return;
      f1 = f2;
    }
  }
  
  private void d()
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
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      k();
      j();
      return;
      label118:
      f1 = f2;
    }
  }
  
  private void e()
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
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      k();
      j();
      return;
      label118:
      f1 = f2;
    }
  }
  
  private void f()
  {
    if (this.jdField_c_of_type_AndroidGraphicsRectF.width() < this.jdField_a_of_type_AndroidGraphicsRectF.width())
    {
      this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width());
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      k();
      j();
    }
  }
  
  private void g()
  {
    f();
    float f1 = -this.jdField_c_of_type_AndroidGraphicsRectF.top;
    this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(0.0F, f1);
    k();
    j();
    this.jdField_c_of_type_Int = ((int)(f1 + this.jdField_c_of_type_Int));
  }
  
  private void h()
  {
    f();
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom - this.jdField_c_of_type_AndroidGraphicsRectF.bottom;
    this.jdField_c_of_type_Int = ((int)(this.jdField_c_of_type_Int + f1));
    this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(0.0F, f1);
    k();
    j();
  }
  
  private void i()
  {
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width();
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_c_of_type_AndroidGraphicsRectF.height();
    this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(f1, f2, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
    k();
    j();
  }
  
  private void j()
  {
    Drawable localDrawable = getDrawable();
    int i = a(localDrawable);
    int j = b(localDrawable);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_c_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
    this.jdField_b_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.width() / 2.0F);
    this.jdField_c_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.height() / 2.0F);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
  }
  
  private void k()
  {
    boolean bool2 = true;
    this.jdField_c_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_c_of_type_AndroidGraphicsMatrix.postConcat(this.jdField_b_of_type_AndroidGraphicsMatrix);
    setImageMatrix(this.jdField_c_of_type_AndroidGraphicsMatrix);
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
    if (this.jdField_c_of_type_AndroidGraphicsRectF.width() > this.jdField_a_of_type_AndroidGraphicsRectF.width())
    {
      bool1 = true;
      this.e = bool1;
      if (this.jdField_c_of_type_AndroidGraphicsRectF.height() <= this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
        break label105;
      }
    }
    label105:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.f = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    k();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  public vsv a()
  {
    RectF localRectF = new RectF();
    int[] arrayOfInt = new int[2];
    a(this, arrayOfInt);
    localRectF.set(arrayOfInt[0] + this.jdField_c_of_type_AndroidGraphicsRectF.left, arrayOfInt[1] + this.jdField_c_of_type_AndroidGraphicsRectF.top, arrayOfInt[0] + this.jdField_c_of_type_AndroidGraphicsRectF.right, arrayOfInt[1] + this.jdField_c_of_type_AndroidGraphicsRectF.bottom);
    return new vsv(localRectF, this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPointF, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
  }
  
  public void a(vsv paramvsv)
  {
    l();
    j();
    vsv localvsv = a();
    float f1 = Math.min(paramvsv.jdField_b_of_type_AndroidGraphicsRectF.width() / localvsv.jdField_b_of_type_AndroidGraphicsRectF.width(), paramvsv.jdField_b_of_type_AndroidGraphicsRectF.height() / localvsv.jdField_b_of_type_AndroidGraphicsRectF.height());
    float f2 = paramvsv.jdField_a_of_type_AndroidGraphicsRectF.left + paramvsv.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
    float f3 = paramvsv.jdField_a_of_type_AndroidGraphicsRectF.top + paramvsv.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F;
    float f4 = localvsv.jdField_a_of_type_AndroidGraphicsRectF.left;
    float f5 = localvsv.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
    float f6 = localvsv.jdField_a_of_type_AndroidGraphicsRectF.top;
    float f7 = localvsv.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F;
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(f2 - (f4 + f5), f3 - (f7 + f6));
    this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(f1, f1, f2, f3);
    k();
    this.jdField_b_of_type_AndroidGraphicsPointF.set(f2, f3);
    this.jdField_c_of_type_AndroidGraphicsPointF.set(f2, f3);
    this.jdField_c_of_type_AndroidGraphicsRectF = paramvsv.jdField_b_of_type_AndroidGraphicsRectF;
    this.jdField_a_of_type_AndroidGraphicsRectF = paramvsv.jdField_c_of_type_AndroidGraphicsRectF;
    this.jdField_b_of_type_AndroidGraphicsRectF = paramvsv.jdField_d_of_type_AndroidGraphicsRectF;
    this.jdField_a_of_type_AndroidGraphicsPointF = paramvsv.jdField_a_of_type_AndroidGraphicsPointF;
    this.jdField_a_of_type_Float = paramvsv.jdField_a_of_type_Float;
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramvsv.jdField_a_of_type_AndroidWidgetImageView$ScaleType;
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_c_of_type_AndroidGraphicsMatrix);
    this.jdField_b_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.width() / 2.0F);
    this.jdField_c_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.height() / 2.0F);
  }
  
  public void a(vsv paramvsv, vsz paramvsz)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      l();
      vsv localvsv = a();
      float f1 = Math.min(paramvsv.jdField_b_of_type_AndroidGraphicsRectF.width() / localvsv.jdField_b_of_type_AndroidGraphicsRectF.width(), paramvsv.jdField_b_of_type_AndroidGraphicsRectF.height() / localvsv.jdField_b_of_type_AndroidGraphicsRectF.height());
      float f2 = paramvsv.jdField_a_of_type_AndroidGraphicsRectF.left + paramvsv.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
      float f3 = paramvsv.jdField_a_of_type_AndroidGraphicsRectF.top + paramvsv.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F;
      float f4 = localvsv.jdField_a_of_type_AndroidGraphicsRectF.left + localvsv.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
      float f5 = localvsv.jdField_a_of_type_AndroidGraphicsRectF.top + localvsv.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F;
      this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(f2 - f4, f3 - f5);
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(f1, f1, f2, f3);
      k();
      this.jdField_b_of_type_AndroidGraphicsPointF.set(f2, f3);
      this.jdField_c_of_type_AndroidGraphicsPointF.set(f2, f3);
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a(0, 0, (int)(f4 - f2), (int)(f5 - f3));
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a(f1, 1.0F);
      QLog.d("QCircleTransitionImageView", 4, "animaFrom from imageInfo:" + paramvsv.toString() + " to imageInfo:" + localvsv.toString() + " translate x:" + (f2 - f4) + " translate y:" + (f3 - f5) + " scale" + f1);
      if ((paramvsv.jdField_c_of_type_AndroidGraphicsRectF.width() < paramvsv.jdField_b_of_type_AndroidGraphicsRectF.width()) || (paramvsv.jdField_c_of_type_AndroidGraphicsRectF.height() < paramvsv.jdField_b_of_type_AndroidGraphicsRectF.height()))
      {
        f2 = paramvsv.jdField_c_of_type_AndroidGraphicsRectF.width() / paramvsv.jdField_b_of_type_AndroidGraphicsRectF.width();
        f3 = paramvsv.jdField_c_of_type_AndroidGraphicsRectF.height() / paramvsv.jdField_b_of_type_AndroidGraphicsRectF.height();
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
        if (paramvsv.jdField_a_of_type_AndroidWidgetImageView$ScaleType != ImageView.ScaleType.FIT_START) {
          break label641;
        }
        paramvsv = new vsy(this);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a(f1, f2, 1.0F - f1, 1.0F - f2, this.jdField_a_of_type_Int / 3, paramvsv);
        this.jdField_d_of_type_AndroidGraphicsMatrix.setScale(f1, f2, (this.jdField_c_of_type_AndroidGraphicsRectF.left + this.jdField_c_of_type_AndroidGraphicsRectF.right) / 2.0F, paramvsv.a());
        this.jdField_d_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_AndroidGraphicsRectF);
        this.jdField_d_of_type_AndroidGraphicsRectF = this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.jdField_a_of_type_AndroidGraphicsRectF;
        QLog.d("QCircleTransitionImageView", 1, new Object[] { "animaFrom mImgRect:", this.jdField_c_of_type_AndroidGraphicsRectF.toString(), ",mClip:", this.jdField_d_of_type_AndroidGraphicsRectF.toString() });
        this.jdField_a_of_type_Vsz = paramvsz;
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a();
        return;
        label641:
        if (paramvsv.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.FIT_END) {
          paramvsv = new vsu(this);
        } else {
          paramvsv = new vsx(this);
        }
      }
    }
    this.jdField_a_of_type_Vsv = paramvsv;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void b(vsv paramvsv, vsz paramvsz)
  {
    float f2 = 1.0F;
    float f1;
    float f3;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.b();
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      vsv localvsv = a();
      f1 = Math.min(paramvsv.jdField_b_of_type_AndroidGraphicsRectF.width() / localvsv.jdField_b_of_type_AndroidGraphicsRectF.width(), paramvsv.jdField_b_of_type_AndroidGraphicsRectF.height() / localvsv.jdField_b_of_type_AndroidGraphicsRectF.height());
      f3 = localvsv.jdField_a_of_type_AndroidGraphicsRectF.left + localvsv.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
      float f4 = localvsv.jdField_a_of_type_AndroidGraphicsRectF.top + localvsv.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F;
      float f5 = paramvsv.jdField_a_of_type_AndroidGraphicsRectF.left + paramvsv.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
      float f6 = paramvsv.jdField_a_of_type_AndroidGraphicsRectF.top + paramvsv.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F;
      this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_b_of_type_AndroidGraphicsPointF.set(f3, f4);
      this.jdField_c_of_type_AndroidGraphicsPointF.set(f3, f4);
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a(0, 0, (int)(f5 - f3), (int)(f6 - f4));
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a(1.0F, f1);
      QLog.d("QCircleTransitionImageView", 4, "animaTo from imageInfo:" + localvsv.toString() + " to imageInfo:" + paramvsv.toString() + " translate x:" + (int)(f5 - f3) + " translate y:" + (int)(f6 - f4) + " scale" + f1);
      if ((paramvsv.jdField_c_of_type_AndroidGraphicsRectF.width() < paramvsv.jdField_b_of_type_AndroidGraphicsRectF.width()) || (paramvsv.jdField_c_of_type_AndroidGraphicsRectF.height() < paramvsv.jdField_b_of_type_AndroidGraphicsRectF.height()))
      {
        f4 = paramvsv.jdField_c_of_type_AndroidGraphicsRectF.width() / paramvsv.jdField_b_of_type_AndroidGraphicsRectF.width();
        f3 = paramvsv.jdField_c_of_type_AndroidGraphicsRectF.height() / paramvsv.jdField_b_of_type_AndroidGraphicsRectF.height();
        QLog.d("QCircleTransitionImageView", 1, new Object[] { "animaTo source clipX:", Float.valueOf(f4), ",clipY:", Float.valueOf(f3) });
        f1 = f4;
        if (f4 > 1.0F) {
          f1 = 1.0F;
        }
        if (f3 <= 1.0F) {
          break label511;
        }
        QLog.d("QCircleTransitionImageView", 1, new Object[] { "animaTo result clipX:", Float.valueOf(f1), ",clipY:", Float.valueOf(f2) });
        if (paramvsv.jdField_a_of_type_AndroidWidgetImageView$ScaleType != ImageView.ScaleType.FIT_START) {
          break label518;
        }
        paramvsv = new vsy(this);
      }
    }
    for (;;)
    {
      postDelayed(new QCircleTransitionImageView.1(this, f1, f2, paramvsv), this.jdField_a_of_type_Int / 2);
      this.jdField_a_of_type_Vsz = paramvsz;
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a();
      return;
      label511:
      f2 = f3;
      break;
      label518:
      if (paramvsv.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.FIT_END) {
        paramvsv = new vsu(this);
      } else {
        paramvsv = new vsx(this);
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_d_of_type_AndroidGraphicsRectF != null)
    {
      paramCanvas.clipRect(this.jdField_d_of_type_AndroidGraphicsRectF);
      this.jdField_d_of_type_AndroidGraphicsRectF = null;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    Object localObject = getDrawable();
    int j = a((Drawable)localObject);
    int i = b((Drawable)localObject);
    int m = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
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
      paramInt1 = m;
      if (i1 == 0) {
        paramInt1 = j;
      }
      if (((ViewGroup.LayoutParams)localObject).height != -1) {
        break label257;
      }
      paramInt2 = k;
      if (n == 0) {
        paramInt2 = i;
      }
      k = paramInt1;
      m = paramInt2;
      if (this.jdField_d_of_type_Boolean)
      {
        k = paramInt1;
        m = paramInt2;
        if (j / i != paramInt1 / paramInt2)
        {
          f1 = paramInt2 / i;
          f2 = paramInt1 / j;
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
          m = paramInt2;
        }
      }
    }
    for (k = paramInt1;; k = paramInt1)
    {
      setMeasuredDimension(k, m);
      return;
      paramInt1 = m;
      if (i1 == 1073741824) {
        break;
      }
      if (i1 == -2147483648)
      {
        paramInt1 = m;
        if (j > m) {
          break;
        }
        paramInt1 = j;
        break;
      }
      paramInt1 = j;
      break;
      label257:
      paramInt2 = k;
      if (n == 1073741824) {
        break label126;
      }
      if (n == -2147483648)
      {
        paramInt2 = k;
        if (i > k) {
          break label126;
        }
        paramInt2 = i;
        break label126;
      }
      paramInt2 = i;
      break label126;
      label298:
      f1 = f2;
      break label183;
      label304:
      paramInt1 = (int)(j * f1);
      break label192;
      label314:
      m = (int)(i * f1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = paramInt2 - getPaddingTop() - getPaddingBottom();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPointF.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b();
    }
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    super.setAdjustViewBounds(paramBoolean);
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null) {
      this.jdField_a_of_type_Boolean = false;
    }
    while (!a(paramDrawable)) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = true;
    }
    b();
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
  
  public void setImageURI(@Nullable Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = getDrawable();
    if (paramUri == null) {
      this.jdField_a_of_type_Boolean = false;
    }
    while (!a(paramUri)) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = true;
    }
    b();
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a(paramInterpolator);
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
    } while (!this.jdField_c_of_type_Boolean);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionImageView
 * JD-Core Version:    0.7.0.1
 */