package com.tencent.biz.qqcircle.widgets.multiTouchImage;

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
import way;
import wba;
import wbb;
import wbc;
import wbd;
import wbe;
import wbf;
import wbg;
import wbh;
import wbi;
import wbj;
import wbk;
import wbl;
import wbm;
import wbn;
import wbp;

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
  private PhotoViewAttacher.FlingRunnable jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher$FlingRunnable;
  private way jdField_a_of_type_Way;
  private wba jdField_a_of_type_Wba;
  private wbb jdField_a_of_type_Wbb = new wbl(this);
  private wbc jdField_a_of_type_Wbc;
  private wbd jdField_a_of_type_Wbd;
  private wbe jdField_a_of_type_Wbe;
  private wbf jdField_a_of_type_Wbf;
  private wbg jdField_a_of_type_Wbg;
  private wbh jdField_a_of_type_Wbh;
  private wbi jdField_a_of_type_Wbi;
  private wbj jdField_a_of_type_Wbj;
  private wbk jdField_a_of_type_Wbk;
  private boolean jdField_a_of_type_Boolean = true;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private final Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private boolean jdField_b_of_type_Boolean;
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
    this.jdField_a_of_type_Way = new way(paramImageView.getContext(), this.jdField_a_of_type_Wbb);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramImageView.getContext(), new wbm(this));
    this.jdField_a_of_type_AndroidViewGestureDetector.setOnDoubleTapListener(new wbn(this));
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
    if (this.jdField_a_of_type_Wbc != null)
    {
      paramMatrix = a(paramMatrix);
      if (paramMatrix != null) {
        this.jdField_a_of_type_Wbc.a(paramMatrix);
      }
    }
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
    QLog.d("PhotoViewAttacher", 4, "updateBaseMatrix viewWidth:" + f1 + " viewHeight:" + f2 + " drawableWidth:" + m + " drawableHeight:" + n + " drawableHash:" + paramDrawable.hashCode());
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    float f3 = f1 / m;
    float f4 = f2 / n;
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((f1 - m) / 2.0F, (f2 - n) / 2.0F);
    }
    for (;;)
    {
      c();
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER_CROP)
      {
        f3 = Math.max(f3, f4);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f3, f3);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((f1 - m * f3) / 2.0F, (f2 - f3 * n) / 2.0F);
      }
      else if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER_INSIDE)
      {
        f3 = Math.min(1.0F, Math.min(f3, f4));
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f3, f3);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((f1 - m * f3) / 2.0F, (f2 - f3 * n) / 2.0F);
      }
      else
      {
        paramDrawable = new RectF(0.0F, 0.0F, m, n);
        RectF localRectF = new RectF(0.0F, 0.0F, f1, f2);
        if ((int)this.i % 180 != 0) {
          paramDrawable = new RectF(0.0F, 0.0F, n, m);
        }
        switch (wbo.a[this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal()])
        {
        default: 
          break;
        case 1: 
          this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(paramDrawable, localRectF, Matrix.ScaleToFit.CENTER);
          break;
        case 2: 
          this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(paramDrawable, localRectF, Matrix.ScaleToFit.START);
          break;
        case 3: 
          this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(paramDrawable, localRectF, Matrix.ScaleToFit.END);
          break;
        case 4: 
          this.jdField_a_of_type_AndroidGraphicsMatrix.setRectToRect(paramDrawable, localRectF, Matrix.ScaleToFit.FILL);
        }
      }
    }
  }
  
  private boolean a()
  {
    float f2 = 0.0F;
    RectF localRectF = a(b());
    if (localRectF == null) {
      return false;
    }
    float f1 = localRectF.height();
    float f3 = localRectF.width();
    int m = b(this.jdField_a_of_type_AndroidWidgetImageView);
    if (f1 <= m) {
      switch (wbo.a[this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal()])
      {
      default: 
        f1 = (m - f1) / 2.0F - localRectF.top;
        this.jdField_e_of_type_Int = 2;
        label103:
        m = a(this.jdField_a_of_type_AndroidWidgetImageView);
        if (f3 <= m) {
          switch (wbo.a[this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal()])
          {
          default: 
            f2 = (m - f3) / 2.0F - localRectF.left;
            label170:
            this.jdField_d_of_type_Int = 2;
          }
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidGraphicsMatrix.postTranslate(f2, f1);
      return true;
      f1 = -localRectF.top;
      break;
      f1 = m - f1 - localRectF.top;
      break;
      if (localRectF.top > 0.0F)
      {
        this.jdField_e_of_type_Int = 0;
        f1 = -localRectF.top;
        break label103;
      }
      if (localRectF.bottom < m)
      {
        this.jdField_e_of_type_Int = 1;
        f1 = m - localRectF.bottom;
        break label103;
      }
      this.jdField_e_of_type_Int = -1;
      f1 = 0.0F;
      break label103;
      f2 = -localRectF.left;
      break label170;
      f2 = m - f3 - localRectF.left;
      break label170;
      if (localRectF.left > 0.0F)
      {
        this.jdField_d_of_type_Int = 0;
        f2 = -localRectF.left;
      }
      else if (localRectF.right < m)
      {
        f2 = m - localRectF.right;
        this.jdField_d_of_type_Int = 1;
      }
      else
      {
        this.jdField_d_of_type_Int = -1;
      }
    }
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
  
  private void c()
  {
    this.jdField_c_of_type_AndroidGraphicsMatrix.reset();
    b(this.i);
    a(b());
    a();
  }
  
  private void d()
  {
    if (a()) {
      a(b());
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher$FlingRunnable != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher$FlingRunnable.a();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImagePhotoViewAttacher$FlingRunnable = null;
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
    c();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_c_of_type_AndroidGraphicsMatrix.setRotate(paramFloat % 360.0F);
    d();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    wbp.a(paramFloat1, paramFloat2, paramFloat3);
    this.f = paramFloat1;
    this.g = paramFloat2;
    this.h = paramFloat3;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    if ((paramFloat1 < this.f) || (paramFloat1 > this.h)) {
      throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.post(new PhotoViewAttacher.AnimatedZoomRunnable(this, a(), paramFloat1, paramFloat2, paramFloat3));
      return;
    }
    this.jdField_c_of_type_AndroidGraphicsMatrix.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    d();
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
    if ((wbp.a(paramScaleType)) && (paramScaleType != this.jdField_a_of_type_AndroidWidgetImageView$ScaleType))
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
      a();
    }
  }
  
  public void a(wba paramwba)
  {
    this.jdField_a_of_type_Wba = paramwba;
  }
  
  public void a(wbc paramwbc)
  {
    this.jdField_a_of_type_Wbc = paramwbc;
  }
  
  public void a(wbd paramwbd)
  {
    this.jdField_a_of_type_Wbd = paramwbd;
  }
  
  public void a(wbe paramwbe)
  {
    this.jdField_a_of_type_Wbe = paramwbe;
  }
  
  public void a(wbf paramwbf)
  {
    this.jdField_a_of_type_Wbf = paramwbf;
    if (this.jdField_a_of_type_Way != null) {
      this.jdField_a_of_type_Way.a(paramwbf);
    }
  }
  
  public void a(wbg paramwbg)
  {
    this.jdField_a_of_type_Wbg = paramwbg;
  }
  
  public void a(wbh paramwbh)
  {
    this.jdField_a_of_type_Wbh = paramwbh;
    if (this.jdField_a_of_type_Way != null) {
      this.jdField_a_of_type_Way.a(paramwbh);
    }
  }
  
  public void a(wbi paramwbi)
  {
    this.jdField_a_of_type_Wbi = paramwbi;
  }
  
  public void a(wbj paramwbj)
  {
    this.jdField_a_of_type_Wbj = paramwbj;
  }
  
  public void a(wbk paramwbk)
  {
    this.jdField_a_of_type_Wbk = paramwbk;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Way.a()) && (!this.jdField_b_of_type_Boolean))
    {
      int m;
      if ((Math.abs(paramFloat2) > 8.0F) && (Math.abs(paramFloat2) > Math.abs(paramFloat1)))
      {
        m = 1;
        if ((Math.abs(paramFloat1) <= 8.0F) || (Math.abs(paramFloat1) <= Math.abs(paramFloat2))) {
          break label259;
        }
      }
      label259:
      for (int n = 1;; n = 0)
      {
        if ((m == 0) || (Math.abs(paramFloat2) * 0.6F <= Math.abs(paramFloat1)) || ((this.jdField_e_of_type_Int != 2) && ((this.jdField_e_of_type_Int != 0) || (paramFloat2 < 8.0F)) && ((this.jdField_e_of_type_Int != 1) || (paramFloat2 > 0.0F - 8.0F)))) {
          break label265;
        }
        QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent vertical solp false mAllowParentInterceptOnEdge:" + this.jdField_a_of_type_Boolean + " isScaling:" + this.jdField_a_of_type_Way.a() + " mBlockParentIntercept:" + this.jdField_b_of_type_Boolean + " getScale:" + a() + " mHorizontalScrollEdge:" + this.jdField_d_of_type_Int + " mVerticalScrollEdge:" + this.jdField_e_of_type_Int + " dx:" + paramFloat1 + " dy:" + paramFloat2);
        return false;
        m = 0;
        break;
      }
      label265:
      if ((n != 0) && (Math.abs(paramFloat1) * 0.6F > Math.abs(paramFloat2)) && ((this.jdField_d_of_type_Int == 2) || ((this.jdField_d_of_type_Int == 0) && (paramFloat1 >= 8.0F)) || ((this.jdField_d_of_type_Int == 1) && (paramFloat1 <= 0.0F - 8.0F))))
      {
        QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent horizontal solp false mAllowParentInterceptOnEdge:" + this.jdField_a_of_type_Boolean + " isScaling:" + this.jdField_a_of_type_Way.a() + " mBlockParentIntercept:" + this.jdField_b_of_type_Boolean + " getScale:" + a() + " mHorizontalScrollEdge:" + this.jdField_d_of_type_Int + " mVerticalScrollEdge:" + this.jdField_e_of_type_Int + " dx:" + paramFloat1 + " dy:" + paramFloat2);
        return false;
      }
      if (((this.jdField_e_of_type_Int == 0) && (this.jdField_d_of_type_Int == 0) && (paramFloat2 >= 8.0F) && (paramFloat1 >= 8.0F)) || ((this.jdField_e_of_type_Int == 0) && (this.jdField_d_of_type_Int == 1) && (paramFloat2 >= 8.0F) && (paramFloat1 <= 0.0F - 8.0F)) || ((this.jdField_e_of_type_Int == 1) && (this.jdField_d_of_type_Int == 0) && (paramFloat2 <= 0.0F - 8.0F) && (paramFloat1 >= 8.0F)) || ((this.jdField_e_of_type_Int == 1) && (this.jdField_d_of_type_Int == 1) && (paramFloat2 <= 0.0F - 8.0F) && (paramFloat1 <= 0.0F - 8.0F)))
      {
        QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent corner slop false mAllowParentInterceptOnEdge:" + this.jdField_a_of_type_Boolean + " isScaling:" + this.jdField_a_of_type_Way.a() + " mBlockParentIntercept:" + this.jdField_b_of_type_Boolean + " getScale:" + a() + " mHorizontalScrollEdge:" + this.jdField_d_of_type_Int + " mVerticalScrollEdge:" + this.jdField_e_of_type_Int + " dx:" + paramFloat1 + " dy:" + paramFloat2);
        return false;
      }
    }
    else
    {
      QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent true mAllowParentInterceptOnEdge:" + this.jdField_a_of_type_Boolean + " isScaling:" + this.jdField_a_of_type_Way.a() + " mBlockParentIntercept:" + this.jdField_b_of_type_Boolean + " getScale:" + a() + " mHorizontalScrollEdge:" + this.jdField_d_of_type_Int + " mVerticalScrollEdge:" + this.jdField_e_of_type_Int + " dx:" + paramFloat1 + " dy:" + paramFloat2);
      return true;
    }
    QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent default:true mAllowParentInterceptOnEdge:" + this.jdField_a_of_type_Boolean + " isScaling:" + this.jdField_a_of_type_Way.a() + " mBlockParentIntercept:" + this.jdField_b_of_type_Boolean + " getScale:" + a() + " mHorizontalScrollEdge:" + this.jdField_d_of_type_Int + " mVerticalScrollEdge:" + this.jdField_e_of_type_Int + " dx:" + paramFloat1 + " dy:" + paramFloat2);
    return true;
  }
  
  public void b()
  {
    c();
  }
  
  public void b(float paramFloat)
  {
    this.jdField_c_of_type_AndroidGraphicsMatrix.postRotate(paramFloat % 360.0F);
    d();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    a();
  }
  
  public void c(float paramFloat)
  {
    wbp.a(paramFloat, this.g, this.h);
    this.f = paramFloat;
  }
  
  public void d(float paramFloat)
  {
    wbp.a(this.f, paramFloat, this.h);
    this.g = paramFloat;
  }
  
  public void e(float paramFloat)
  {
    wbp.a(this.f, this.g, paramFloat);
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
    boolean bool3 = false;
    if ((this.jdField_c_of_type_Boolean) && (wbp.a((ImageView)paramView)))
    {
      boolean bool1;
      label59:
      boolean bool5;
      boolean bool6;
      boolean bool4;
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        bool1 = false;
        if (this.jdField_a_of_type_Way != null)
        {
          bool5 = this.jdField_a_of_type_Way.a();
          bool6 = this.jdField_a_of_type_Way.b();
          bool4 = this.jdField_a_of_type_Way.a(paramMotionEvent);
          if ((bool5) || (this.jdField_a_of_type_Way.a())) {
            break label611;
          }
          bool1 = true;
          label112:
          if ((bool6) || (this.jdField_a_of_type_Way.b())) {
            break label617;
          }
        }
        break;
      }
      label611:
      label617:
      for (boolean bool2 = true;; bool2 = false)
      {
        int m = paramMotionEvent.getPointerCount();
        if (((bool1) && (bool2)) || (m > 1)) {
          bool3 = true;
        }
        this.jdField_b_of_type_Boolean = bool3;
        QLog.d("PhotoViewAttacher", 4, "onTouch scaleDragDetector wasScaling:" + bool5 + " wasDragging:" + bool6 + " didntScale:" + bool1 + " didntDrag:" + bool2 + " mBlockParentIntercept:" + this.jdField_b_of_type_Boolean);
        bool1 = bool4;
        bool2 = bool1;
        if (this.jdField_a_of_type_AndroidViewGestureDetector != null)
        {
          bool2 = bool1;
          if (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent)) {
            bool2 = true;
          }
        }
        return bool2;
        paramView = paramView.getParent();
        if (paramView != null) {
          paramView.requestDisallowInterceptTouchEvent(true);
        }
        e();
        bool1 = false;
        break label59;
        if (a() < this.f)
        {
          f2 = a();
          f1 = f2;
          if (f2 < jdField_e_of_type_Float) {
            f1 = jdField_e_of_type_Float;
          }
          RectF localRectF = a();
          if (localRectF == null) {
            break;
          }
          QLog.d("PhotoViewAttacher", 4, "postAnimationZoom minscale event:" + paramMotionEvent.getAction() + " scale:" + a() + " startScale:" + f1 + " mMinScale:" + this.f + " rect:" + localRectF.toString());
          paramView.post(new PhotoViewAttacher.AnimatedZoomRunnable(this, f1, this.f, localRectF.centerX(), localRectF.centerY()));
          bool1 = true;
          break label59;
        }
        if (a() <= this.h) {
          break;
        }
        float f2 = a();
        float f1 = f2;
        if (f2 > jdField_a_of_type_Float) {
          f1 = jdField_a_of_type_Float;
        }
        QLog.d("PhotoViewAttacher", 4, "postAnimationZoom maxscale event:" + paramMotionEvent.getAction() + " scale:" + a() + " startScale:" + f1 + " mMaxScale:" + this.h + " scaleX:" + this.j + " scaleY:" + this.k);
        paramView.post(new PhotoViewAttacher.AnimatedZoomRunnable(this, f1, this.h, this.j, this.k));
        bool1 = true;
        break label59;
        bool1 = false;
        break label112;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher
 * JD-Core Version:    0.7.0.1
 */