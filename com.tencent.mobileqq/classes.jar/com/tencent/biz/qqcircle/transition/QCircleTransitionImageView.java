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
import uao;
import uap;
import uaq;
import uas;
import uat;
import uau;

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
  private uaq jdField_a_of_type_Uaq;
  private uau jdField_a_of_type_Uau;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 500;
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
  private int jdField_d_of_type_Int;
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
  
  private void a()
  {
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == null) {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.jdField_a_of_type_Int = 340;
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
    int i = getWidth();
    int j = getHeight();
    int k = a(localDrawable);
    int m = b(localDrawable);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, k, m);
    int n = (i - k) / 2;
    int i1 = (j - m) / 2;
    if (k > i) {}
    for (float f1 = i / k;; f1 = 1.0F)
    {
      if (m > j) {
        f2 = j / m;
      }
      if (f1 < f2)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(n, i1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
        this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
        this.jdField_b_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.width() / 2.0F);
        this.jdField_c_of_type_Float = (this.jdField_b_of_type_AndroidGraphicsRectF.height() / 2.0F);
        this.jdField_b_of_type_AndroidGraphicsPointF.set(this.jdField_a_of_type_AndroidGraphicsPointF);
        this.jdField_c_of_type_AndroidGraphicsPointF.set(this.jdField_b_of_type_AndroidGraphicsPointF);
        k();
        switch (uan.a[this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal()])
        {
        }
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = true;
        if ((this.jdField_a_of_type_Uaq != null) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < this.jdField_b_of_type_Int)) {
          a(this.jdField_a_of_type_Uaq, this.jdField_a_of_type_Uau);
        }
        this.jdField_a_of_type_Uaq = null;
        return;
        f1 = f2;
        break;
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
    this.jdField_d_of_type_Int = ((int)(f1 + this.jdField_d_of_type_Int));
  }
  
  private void h()
  {
    f();
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom - this.jdField_c_of_type_AndroidGraphicsRectF.bottom;
    this.jdField_d_of_type_Int = ((int)(this.jdField_d_of_type_Int + f1));
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
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
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
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
  }
  
  public uaq a()
  {
    RectF localRectF = new RectF();
    int[] arrayOfInt = new int[2];
    a(this, arrayOfInt);
    localRectF.set(arrayOfInt[0] + this.jdField_c_of_type_AndroidGraphicsRectF.left, arrayOfInt[1] + this.jdField_c_of_type_AndroidGraphicsRectF.top, arrayOfInt[0] + this.jdField_c_of_type_AndroidGraphicsRectF.right, arrayOfInt[1] + this.jdField_c_of_type_AndroidGraphicsRectF.bottom);
    return new uaq(localRectF, this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPointF, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
  }
  
  public void a(uaq paramuaq, uau paramuau)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      l();
      uaq localuaq = a();
      float f1 = paramuaq.jdField_b_of_type_AndroidGraphicsRectF.width() / localuaq.jdField_b_of_type_AndroidGraphicsRectF.width();
      float f2 = paramuaq.jdField_b_of_type_AndroidGraphicsRectF.height() / localuaq.jdField_b_of_type_AndroidGraphicsRectF.height();
      if (f1 < f2)
      {
        f2 = paramuaq.jdField_a_of_type_AndroidGraphicsRectF.left + paramuaq.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
        float f3 = paramuaq.jdField_a_of_type_AndroidGraphicsRectF.top + paramuaq.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F;
        float f4 = localuaq.jdField_a_of_type_AndroidGraphicsRectF.left + localuaq.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
        float f5 = localuaq.jdField_a_of_type_AndroidGraphicsRectF.top;
        f5 = localuaq.jdField_a_of_type_AndroidGraphicsRectF.height() / 2.0F + f5;
        this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(f2 - f4, f3 - f5);
        this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(f1, f1, f2, f3);
        k();
        this.jdField_b_of_type_AndroidGraphicsPointF.set(f2, f3);
        this.jdField_c_of_type_AndroidGraphicsPointF.set(f2, f3);
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a(0, 0, (int)-(f2 - f4), (int)-(f3 - f5));
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a(f1, 1.0F);
        if ((paramuaq.jdField_c_of_type_AndroidGraphicsRectF.width() < paramuaq.jdField_b_of_type_AndroidGraphicsRectF.width()) || (paramuaq.jdField_c_of_type_AndroidGraphicsRectF.height() < paramuaq.jdField_b_of_type_AndroidGraphicsRectF.height()))
        {
          f2 = paramuaq.jdField_c_of_type_AndroidGraphicsRectF.width() / paramuaq.jdField_b_of_type_AndroidGraphicsRectF.width();
          f3 = paramuaq.jdField_c_of_type_AndroidGraphicsRectF.height() / paramuaq.jdField_b_of_type_AndroidGraphicsRectF.height();
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          f2 = f3;
          if (f3 > 1.0F) {
            f2 = 1.0F;
          }
          if (paramuaq.jdField_a_of_type_AndroidWidgetImageView$ScaleType != ImageView.ScaleType.FIT_START) {
            break label461;
          }
          paramuaq = new uat(this);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a(f1, f2, 1.0F - f1, 1.0F - f2, this.jdField_a_of_type_Int / 3, paramuaq);
        this.jdField_d_of_type_AndroidGraphicsMatrix.setScale(f1, f2, (this.jdField_c_of_type_AndroidGraphicsRectF.left + this.jdField_c_of_type_AndroidGraphicsRectF.right) / 2.0F, paramuaq.a());
        this.jdField_d_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_AndroidGraphicsRectF);
        this.jdField_d_of_type_AndroidGraphicsRectF = this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.jdField_a_of_type_AndroidGraphicsRectF;
        this.jdField_a_of_type_Uau = paramuau;
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView$Transform.a();
        return;
        f1 = f2;
        break;
        label461:
        if (paramuaq.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.FIT_END) {
          paramuaq = new uap(this);
        } else {
          paramuaq = new uas(this);
        }
      }
    }
    this.jdField_a_of_type_Uaq = paramuaq;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionImageView
 * JD-Core Version:    0.7.0.1
 */