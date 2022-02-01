package com.tencent.aelight.camera.ae.biz.circle.widget;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qphone.base.util.QLog;

public class PhotoViewAttacher
  implements View.OnLayoutChangeListener, View.OnTouchListener
{
  private static float jdField_a_of_type_Float = 7.0F;
  private static int jdField_a_of_type_Int = 200;
  private static float jdField_b_of_type_Float = 3.5F;
  private static int jdField_b_of_type_Int = 1;
  private static float jdField_c_of_type_Float = 1.75F;
  private static float jdField_d_of_type_Float = 1.0F;
  private static float jdField_e_of_type_Float = 0.6F;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.FIT_CENTER;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private CustomGestureDetector jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector;
  private OnGestureListener jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetOnGestureListener = new PhotoViewAttacher.1(this);
  private PhotoViewAttacher.FlingRunnable jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher$FlingRunnable;
  private boolean jdField_a_of_type_Boolean = true;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private final Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = jdField_a_of_type_Int;
  private final Matrix jdField_c_of_type_AndroidGraphicsMatrix = new Matrix();
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 2;
  private int jdField_e_of_type_Int = 2;
  private float f = jdField_d_of_type_Float;
  private float g = jdField_c_of_type_Float;
  private float h = jdField_b_of_type_Float;
  private float i;
  private float j;
  private float k;
  
  public PhotoViewAttacher(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    paramImageView.setOnTouchListener(this);
    paramImageView.addOnLayoutChangeListener(this);
    if (paramImageView.isInEditMode()) {
      return;
    }
    this.i = 0.0F;
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector = new CustomGestureDetector(paramImageView.getContext(), this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetOnGestureListener);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramImageView.getContext(), new PhotoViewAttacher.2(this));
    this.jdField_a_of_type_AndroidViewGestureDetector.setOnDoubleTapListener(new PhotoViewAttacher.3(this));
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat[paramInt];
  }
  
  private int a(ImageView paramImageView)
  {
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }
  
  private RectF a(Matrix paramMatrix)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramMatrix.mapRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      return this.jdField_a_of_type_AndroidGraphicsRectF;
    }
    return null;
  }
  
  private void a(Matrix paramMatrix)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(paramMatrix);
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    float f1 = a(this.jdField_a_of_type_AndroidWidgetImageView);
    float f2 = b(this.jdField_a_of_type_AndroidWidgetImageView);
    int m = paramDrawable.getIntrinsicWidth();
    int n = paramDrawable.getIntrinsicHeight();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateBaseMatrix viewWidth:");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(" viewHeight:");
    ((StringBuilder)localObject).append(f2);
    ((StringBuilder)localObject).append(" drawableWidth:");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(" drawableHeight:");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append(" drawableHash:");
    ((StringBuilder)localObject).append(paramDrawable.hashCode());
    QLog.d("PhotoViewAttacher", 4, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    float f3 = m;
    float f5 = f1 / f3;
    float f4 = n;
    float f6 = f2 / f4;
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((f1 - f3) / 2.0F, (f2 - f4) / 2.0F);
    }
    else if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER_CROP)
    {
      f5 = Math.max(f5, f6);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f5, f5);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
    }
    else if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER_INSIDE)
    {
      f5 = Math.min(1.0F, Math.min(f5, f6));
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f5, f5);
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
    }
    else
    {
      paramDrawable = new RectF(0.0F, 0.0F, f3, f4);
      localObject = new RectF(0.0F, 0.0F, f1, f2);
      if ((int)this.i % 180 != 0) {
        paramDrawable = new RectF(0.0F, 0.0F, f4, f3);
      }
      m = PhotoViewAttacher.4.a[this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal()];
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m == 4) {
              this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.FILL);
            }
          }
          else {
            this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.END);
          }
        }
        else {
          this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.START);
        }
      }
      else {
        this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.CENTER);
      }
    }
    b();
  }
  
  private boolean a()
  {
    RectF localRectF = a(b());
    if (localRectF == null) {
      return false;
    }
    float f1 = localRectF.height();
    float f4 = localRectF.width();
    float f2 = b(this.jdField_a_of_type_AndroidWidgetImageView);
    float f3 = 0.0F;
    int m;
    if (f1 <= f2)
    {
      m = PhotoViewAttacher.4.a[this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal()];
      if (m != 2)
      {
        if (m != 3) {
          f2 = (f2 - f1) / 2.0F;
        }
        for (f1 = localRectF.top;; f1 = localRectF.top)
        {
          f1 = f2 - f1;
          break;
          f2 -= f1;
        }
      }
      f1 = -localRectF.top;
      this.jdField_e_of_type_Int = 2;
    }
    else if (localRectF.top > 0.0F)
    {
      this.jdField_e_of_type_Int = 0;
      f1 = -localRectF.top;
    }
    else if (localRectF.bottom < f2)
    {
      this.jdField_e_of_type_Int = 1;
      f1 = f2 - localRectF.bottom;
    }
    else
    {
      this.jdField_e_of_type_Int = -1;
      f1 = 0.0F;
    }
    f2 = a(this.jdField_a_of_type_AndroidWidgetImageView);
    if (f4 <= f2)
    {
      m = PhotoViewAttacher.4.a[this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal()];
      if (m != 2)
      {
        if (m != 3) {
          f3 = (f2 - f4) / 2.0F;
        }
        for (f2 = localRectF.left;; f2 = localRectF.left)
        {
          f2 = f3 - f2;
          break;
          f3 = f2 - f4;
        }
      }
      f2 = -localRectF.left;
      this.jdField_d_of_type_Int = 2;
    }
    else if (localRectF.left > 0.0F)
    {
      this.jdField_d_of_type_Int = 0;
      f2 = -localRectF.left;
    }
    else if (localRectF.right < f2)
    {
      f2 -= localRectF.right;
      this.jdField_d_of_type_Int = 1;
    }
    else
    {
      this.jdField_d_of_type_Int = -1;
      f2 = f3;
    }
    this.jdField_c_of_type_AndroidGraphicsMatrix.postTranslate(f2, f1);
    return true;
  }
  
  private int b(ImageView paramImageView)
  {
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }
  
  private Matrix b()
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_b_of_type_AndroidGraphicsMatrix.postConcat(this.jdField_c_of_type_AndroidGraphicsMatrix);
    return this.jdField_b_of_type_AndroidGraphicsMatrix;
  }
  
  private void b()
  {
    this.jdField_c_of_type_AndroidGraphicsMatrix.reset();
    b(this.i);
    a(b());
    a();
  }
  
  private void c()
  {
    if (a()) {
      a(b());
    }
  }
  
  private void d()
  {
    PhotoViewAttacher.FlingRunnable localFlingRunnable = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher$FlingRunnable;
    if (localFlingRunnable != null)
    {
      localFlingRunnable.a();
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetPhotoViewAttacher$FlingRunnable = null;
    }
  }
  
  public float a()
  {
    return (float)Math.sqrt((float)Math.pow(a(this.jdField_c_of_type_AndroidGraphicsMatrix, 0), 2.0D) + (float)Math.pow(a(this.jdField_c_of_type_AndroidGraphicsMatrix, 3), 2.0D));
  }
  
  public Matrix a()
  {
    return this.jdField_b_of_type_AndroidGraphicsMatrix;
  }
  
  public RectF a()
  {
    a();
    return a(b());
  }
  
  public ImageView.ScaleType a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      a(this.jdField_a_of_type_AndroidWidgetImageView.getDrawable());
      return;
    }
    b();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_c_of_type_AndroidGraphicsMatrix.setRotate(paramFloat % 360.0F);
    c();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Util.a(paramFloat1, paramFloat2, paramFloat3);
    this.f = paramFloat1;
    this.g = paramFloat2;
    this.h = paramFloat3;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    if ((paramFloat1 >= this.f) && (paramFloat1 <= this.h))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.post(new PhotoViewAttacher.AnimatedZoomRunnable(this, a(), paramFloat1, paramFloat2, paramFloat3));
        return;
      }
      this.jdField_c_of_type_AndroidGraphicsMatrix.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      c();
      return;
    }
    throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    a(paramFloat, this.jdField_a_of_type_AndroidWidgetImageView.getRight() / 2, this.jdField_a_of_type_AndroidWidgetImageView.getBottom() / 2, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  public void a(ImageView.ScaleType paramScaleType)
  {
    if ((Util.a(paramScaleType)) && (paramScaleType != this.jdField_a_of_type_AndroidWidgetImageView$ScaleType))
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
      a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector.a()) && (!this.jdField_b_of_type_Boolean))
    {
      int m;
      if ((Math.abs(paramFloat2) > 8.0F) && (Math.abs(paramFloat2) > Math.abs(paramFloat1))) {
        m = 1;
      } else {
        m = 0;
      }
      int n;
      if ((Math.abs(paramFloat1) > 8.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2))) {
        n = 1;
      } else {
        n = 0;
      }
      if ((m != 0) && (Math.abs(paramFloat2) * 0.6F > Math.abs(paramFloat1)))
      {
        m = this.jdField_e_of_type_Int;
        if ((m == 2) || ((m == 0) && (paramFloat2 >= 8.0F)) || ((this.jdField_e_of_type_Int == 1) && (paramFloat2 <= -8.0F)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedToDisAllowInterceptEvent vertical solp false mAllowParentInterceptOnEdge:");
          localStringBuilder.append(this.jdField_a_of_type_Boolean);
          localStringBuilder.append(" isScaling:");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector.a());
          localStringBuilder.append(" mBlockParentIntercept:");
          localStringBuilder.append(this.jdField_b_of_type_Boolean);
          localStringBuilder.append(" getScale:");
          localStringBuilder.append(a());
          localStringBuilder.append(" mHorizontalScrollEdge:");
          localStringBuilder.append(this.jdField_d_of_type_Int);
          localStringBuilder.append(" mVerticalScrollEdge:");
          localStringBuilder.append(this.jdField_e_of_type_Int);
          localStringBuilder.append(" dx:");
          localStringBuilder.append(paramFloat1);
          localStringBuilder.append(" dy:");
          localStringBuilder.append(paramFloat2);
          QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
          return false;
        }
      }
      if ((n != 0) && (0.6F * Math.abs(paramFloat1) > Math.abs(paramFloat2)))
      {
        m = this.jdField_d_of_type_Int;
        if ((m == 2) || ((m == 0) && (paramFloat1 >= 8.0F)) || ((this.jdField_d_of_type_Int == 1) && (paramFloat1 <= -8.0F)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedToDisAllowInterceptEvent horizontal solp false mAllowParentInterceptOnEdge:");
          localStringBuilder.append(this.jdField_a_of_type_Boolean);
          localStringBuilder.append(" isScaling:");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector.a());
          localStringBuilder.append(" mBlockParentIntercept:");
          localStringBuilder.append(this.jdField_b_of_type_Boolean);
          localStringBuilder.append(" getScale:");
          localStringBuilder.append(a());
          localStringBuilder.append(" mHorizontalScrollEdge:");
          localStringBuilder.append(this.jdField_d_of_type_Int);
          localStringBuilder.append(" mVerticalScrollEdge:");
          localStringBuilder.append(this.jdField_e_of_type_Int);
          localStringBuilder.append(" dx:");
          localStringBuilder.append(paramFloat1);
          localStringBuilder.append(" dy:");
          localStringBuilder.append(paramFloat2);
          QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
          return false;
        }
      }
      if (((this.jdField_e_of_type_Int == 0) && (this.jdField_d_of_type_Int == 0) && (paramFloat2 >= 8.0F) && (paramFloat1 >= 8.0F)) || ((this.jdField_e_of_type_Int == 0) && (this.jdField_d_of_type_Int == 1) && (paramFloat2 >= 8.0F) && (paramFloat1 <= -8.0F)) || ((this.jdField_e_of_type_Int == 1) && (this.jdField_d_of_type_Int == 0) && (paramFloat2 <= -8.0F) && (paramFloat1 >= 8.0F)) || ((this.jdField_e_of_type_Int == 1) && (this.jdField_d_of_type_Int == 1) && (paramFloat2 <= -8.0F) && (paramFloat1 <= -8.0F)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedToDisAllowInterceptEvent corner slop false mAllowParentInterceptOnEdge:");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        localStringBuilder.append(" isScaling:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector.a());
        localStringBuilder.append(" mBlockParentIntercept:");
        localStringBuilder.append(this.jdField_b_of_type_Boolean);
        localStringBuilder.append(" getScale:");
        localStringBuilder.append(a());
        localStringBuilder.append(" mHorizontalScrollEdge:");
        localStringBuilder.append(this.jdField_d_of_type_Int);
        localStringBuilder.append(" mVerticalScrollEdge:");
        localStringBuilder.append(this.jdField_e_of_type_Int);
        localStringBuilder.append(" dx:");
        localStringBuilder.append(paramFloat1);
        localStringBuilder.append(" dy:");
        localStringBuilder.append(paramFloat2);
        QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
        return false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNeedToDisAllowInterceptEvent default:true mAllowParentInterceptOnEdge:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" isScaling:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector.a());
      localStringBuilder.append(" mBlockParentIntercept:");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(" getScale:");
      localStringBuilder.append(a());
      localStringBuilder.append(" mHorizontalScrollEdge:");
      localStringBuilder.append(this.jdField_d_of_type_Int);
      localStringBuilder.append(" mVerticalScrollEdge:");
      localStringBuilder.append(this.jdField_e_of_type_Int);
      localStringBuilder.append(" dx:");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(" dy:");
      localStringBuilder.append(paramFloat2);
      QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isNeedToDisAllowInterceptEvent true mAllowParentInterceptOnEdge:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" isScaling:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector.a());
    localStringBuilder.append(" mBlockParentIntercept:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" getScale:");
    localStringBuilder.append(a());
    localStringBuilder.append(" mHorizontalScrollEdge:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" mVerticalScrollEdge:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(" dx:");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(" dy:");
    localStringBuilder.append(paramFloat2);
    QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
    return true;
  }
  
  public void b(float paramFloat)
  {
    this.jdField_c_of_type_AndroidGraphicsMatrix.postRotate(paramFloat % 360.0F);
    c();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    a();
  }
  
  public void c(float paramFloat)
  {
    Util.a(paramFloat, this.g, this.h);
    this.f = paramFloat;
  }
  
  public void d(float paramFloat)
  {
    Util.a(this.f, paramFloat, this.h);
    this.g = paramFloat;
  }
  
  public void e(float paramFloat)
  {
    Util.a(this.f, this.g, paramFloat);
    this.h = paramFloat;
  }
  
  public void f(float paramFloat)
  {
    a(paramFloat, false);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8)) {
      a(this.jdField_a_of_type_AndroidWidgetImageView.getDrawable());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool4 = this.jdField_c_of_type_Boolean;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool2;
    if (bool4)
    {
      bool1 = bool2;
      if (Util.a((ImageView)paramView))
      {
        int m = paramMotionEvent.getAction();
        if (m != 0)
        {
          if ((m == 1) || (m == 3))
          {
            float f1;
            float f2;
            Object localObject;
            if (a() < this.f)
            {
              f1 = a();
              f2 = jdField_e_of_type_Float;
              if (f1 < f2) {
                f1 = f2;
              }
              localObject = a();
              if (localObject == null) {
                break label469;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("postAnimationZoom minscale event:");
              localStringBuilder.append(paramMotionEvent.getAction());
              localStringBuilder.append(" scale:");
              localStringBuilder.append(a());
              localStringBuilder.append(" startScale:");
              localStringBuilder.append(f1);
              localStringBuilder.append(" mMinScale:");
              localStringBuilder.append(this.f);
              localStringBuilder.append(" rect:");
              localStringBuilder.append(((RectF)localObject).toString());
              QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
              paramView.post(new PhotoViewAttacher.AnimatedZoomRunnable(this, f1, this.f, ((RectF)localObject).centerX(), ((RectF)localObject).centerY()));
            }
            else
            {
              if (a() <= this.h) {
                break label469;
              }
              f1 = a();
              f2 = jdField_a_of_type_Float;
              if (f1 > f2) {
                f1 = f2;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("postAnimationZoom maxscale event:");
              ((StringBuilder)localObject).append(paramMotionEvent.getAction());
              ((StringBuilder)localObject).append(" scale:");
              ((StringBuilder)localObject).append(a());
              ((StringBuilder)localObject).append(" startScale:");
              ((StringBuilder)localObject).append(f1);
              ((StringBuilder)localObject).append(" mMaxScale:");
              ((StringBuilder)localObject).append(this.h);
              ((StringBuilder)localObject).append(" scaleX:");
              ((StringBuilder)localObject).append(this.j);
              ((StringBuilder)localObject).append(" scaleY:");
              ((StringBuilder)localObject).append(this.k);
              QLog.d("PhotoViewAttacher", 4, ((StringBuilder)localObject).toString());
              paramView.post(new PhotoViewAttacher.AnimatedZoomRunnable(this, f1, this.h, this.j, this.k));
            }
            bool1 = true;
            break label472;
          }
        }
        else
        {
          paramView = paramView.getParent();
          if (paramView != null) {
            paramView.requestDisallowInterceptTouchEvent(true);
          }
          d();
        }
        label469:
        bool1 = false;
        label472:
        paramView = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector;
        if (paramView != null)
        {
          boolean bool5 = paramView.a();
          boolean bool6 = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector.b();
          bool4 = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector.a(paramMotionEvent);
          if ((!bool5) && (!this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector.a())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if ((!bool6) && (!this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetCustomGestureDetector.b())) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          m = paramMotionEvent.getPointerCount();
          if (((bool1) && (bool2)) || (m > 1)) {
            bool3 = true;
          }
          this.jdField_b_of_type_Boolean = bool3;
          paramView = new StringBuilder();
          paramView.append("onTouch scaleDragDetector wasScaling:");
          paramView.append(bool5);
          paramView.append(" wasDragging:");
          paramView.append(bool6);
          paramView.append(" didntScale:");
          paramView.append(bool1);
          paramView.append(" didntDrag:");
          paramView.append(bool2);
          paramView.append(" mBlockParentIntercept:");
          paramView.append(this.jdField_b_of_type_Boolean);
          QLog.d("PhotoViewAttacher", 4, paramView.toString());
          bool2 = bool4;
        }
        else
        {
          bool2 = bool1;
        }
        paramView = this.jdField_a_of_type_AndroidViewGestureDetector;
        bool1 = bool2;
        if (paramView != null)
        {
          bool1 = bool2;
          if (paramView.onTouchEvent(paramMotionEvent)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.widget.PhotoViewAttacher
 * JD-Core Version:    0.7.0.1
 */