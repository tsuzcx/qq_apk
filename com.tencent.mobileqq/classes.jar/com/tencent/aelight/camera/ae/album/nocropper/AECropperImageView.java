package com.tencent.aelight.camera.ae.album.nocropper;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.aelight.camera.impl.R.styleable;
import com.tencent.aelight.camera.log.AEQLog;

public class AECropperImageView
  extends ImageView
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = -1;
  Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = null;
  public Bitmap a;
  protected GestureDetector a;
  protected ScaleGestureDetector a;
  private AECropperImageView.GestureCallback jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView$GestureCallback;
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 1;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 0.0F;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float = 0.0F;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean = true;
  private float jdField_f_of_type_Float;
  private boolean jdField_f_of_type_Boolean = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = true;
  
  public AECropperImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AECropperImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AECropperImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = paramInt1;
    float f2 = paramInt2;
    float f3 = f1 * 1.0F / f2;
    if (f3 <= 0.3333333F)
    {
      f2 = paramInt3;
      f1 /= 0.3333333F;
    }
    for (;;)
    {
      return f2 / f1;
      if (f3 >= 1.777778F)
      {
        f1 = paramInt3;
        f2 *= 1.777778F;
      }
      for (;;)
      {
        return f1 / f2;
        if (f3 >= 1.0F) {
          break;
        }
        f1 = paramInt3 * 1.0F;
      }
      f2 = paramInt3 * 1.0F;
    }
  }
  
  private float a(Matrix paramMatrix)
  {
    return a(paramMatrix, 0);
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat[paramInt];
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = getImageMatrix();
    float f1 = a(localMatrix, 2);
    float f2 = a(localMatrix, 5);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new AECropperImageView.3(this, localMatrix, paramFloat1, f1, paramFloat2, f2));
    localValueAnimator.addListener(new AECropperImageView.4(this));
    localValueAnimator.start();
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new AECropperImageView.1(this, paramFloat6, paramFloat5, paramFloat2, paramFloat1, paramFloat4, paramFloat3));
    localValueAnimator.addListener(new AECropperImageView.2(this));
    localValueAnimator.start();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.d);
      if (paramAttributeSet != null)
      {
        this.jdField_a_of_type_Int = paramAttributeSet.getColor(2, this.jdField_a_of_type_Int);
        this.jdField_d_of_type_Boolean = paramAttributeSet.getBoolean(0, true);
        if (paramAttributeSet.getBoolean(1, false)) {
          this.jdField_b_of_type_Int = 2;
        } else {
          this.jdField_b_of_type_Int = 1;
        }
        paramAttributeSet.recycle();
      }
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new AECropperImageView.GestureListener(this, null), null, true);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new AECropperImageView.ScaleListener(this, null));
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null)
    {
      if (this.h) {
        AEQLog.d("AECropperImageView", "Drawable is null. I can't fit anything");
      }
      return;
    }
    if (paramInt == 0)
    {
      if (this.h) {
        AEQLog.d("AECropperImageView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
      }
      return;
    }
    this.jdField_b_of_type_Int = 1;
    int j = paramDrawable.getIntrinsicWidth();
    int k = paramDrawable.getIntrinsicHeight();
    float f1 = b(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), getWidth());
    paramDrawable = new Matrix();
    paramDrawable.setScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2.0F, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2.0F);
    paramDrawable.postTranslate((paramInt - j) / 2, (paramInt - k) / 2);
    setImageMatrix(paramDrawable);
  }
  
  private void a(Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    if (paramDrawable == null)
    {
      if (this.h) {
        AEQLog.d("AECropperImageView", "Drawable is null. I can't fit anything");
      }
      return;
    }
    if (paramInt == 0)
    {
      if (this.h) {
        AEQLog.d("AECropperImageView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
      }
      return;
    }
    this.jdField_b_of_type_Int = 2;
    int j;
    int k;
    float f1;
    Matrix localMatrix;
    float f2;
    float f3;
    if (!paramBoolean)
    {
      j = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      f1 = a(j, k, getWidth());
      localMatrix = new Matrix();
      localMatrix.setScale(f1, f1, j / 2.0F, k / 2.0F);
      localMatrix.postTranslate((paramInt - j) / 2, (paramInt - k) / 2);
      setImageMatrix(localMatrix);
      f1 = a(localMatrix, 2);
      f2 = a(localMatrix, 5);
      f3 = a(localMatrix, 0);
      if (f3 < this.jdField_a_of_type_Float) {
        a(f1, getWidth() / 2 - this.jdField_a_of_type_Float * paramDrawable.getIntrinsicWidth() / 2.0F, f2, getHeight() / 2 - this.jdField_a_of_type_Float * paramDrawable.getIntrinsicHeight() / 2.0F, f3, this.jdField_a_of_type_Float);
      }
    }
    else
    {
      j = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      f1 = a(j, k, getWidth());
      localMatrix = new Matrix();
      localMatrix.setScale(f1, f1, j / 2.0F, k / 2.0F);
      localMatrix.postTranslate((paramInt - j) / 2, (paramInt - k) / 2);
      f2 = a(localMatrix, 2);
      f3 = a(localMatrix, 5);
      float f4 = a(getImageMatrix(), 0);
      paramInt = getWidth() / 2;
      paramDrawable.getIntrinsicWidth();
      paramInt = getHeight() / 2;
      paramDrawable.getIntrinsicHeight();
      a(f2, f2, f3, f3, f4, f1);
    }
  }
  
  private boolean a(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      AEQLog.d("AECropperImageView", "Min zoom must be greater than 0");
      return false;
    }
    if ((this.jdField_a_of_type_Boolean) && (paramFloat > this.jdField_b_of_type_Float))
    {
      AEQLog.d("AECropperImageView", "Min zoom must not be greater than max zoom");
      this.jdField_b_of_type_Float = paramFloat;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Float = paramFloat;
    return true;
  }
  
  private float b(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = paramInt1;
    float f2 = paramInt2;
    if (f1 * 1.0F / f2 <= 1.0F) {
      return paramInt3 * 1.0F / f1;
    }
    return paramInt3 * 1.0F / f2;
  }
  
  private void b(Drawable paramDrawable, int paramInt)
  {
    a(paramDrawable, paramInt, false);
  }
  
  private boolean c()
  {
    Object localObject = getDrawable();
    if (localObject == null) {
      return false;
    }
    Matrix localMatrix = getImageMatrix();
    float f3 = a(localMatrix, 2);
    float f4 = a(localMatrix, 5);
    float f6 = a(localMatrix, 0);
    float f5 = a(localMatrix, 4);
    if (this.h)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUp( tx = ");
      localStringBuilder.append(f3);
      localStringBuilder.append(", ty = ");
      localStringBuilder.append(f4);
      localStringBuilder.append(")");
      AEQLog.a("AECropperImageView", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUp() - scale: ");
      localStringBuilder.append(f6);
      AEQLog.a("AECropperImageView", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUp() - min, max, base zoom: ");
      localStringBuilder.append(this.jdField_a_of_type_Float);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.jdField_b_of_type_Float);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.jdField_c_of_type_Float);
      AEQLog.a("AECropperImageView", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUp() - imageview size: ");
      localStringBuilder.append(getWidth());
      localStringBuilder.append(" ");
      localStringBuilder.append(getHeight());
      AEQLog.a("AECropperImageView", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUp() - drawable size: ");
      localStringBuilder.append(((Drawable)localObject).getIntrinsicWidth());
      localStringBuilder.append(" ");
      localStringBuilder.append(((Drawable)localObject).getIntrinsicHeight());
      AEQLog.a("AECropperImageView", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUp() - scaled drawable size: ");
      localStringBuilder.append(((Drawable)localObject).getIntrinsicWidth() * f6);
      localStringBuilder.append(" ");
      localStringBuilder.append(((Drawable)localObject).getIntrinsicHeight() * f5);
      AEQLog.a("AECropperImageView", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUp() - h diff: ");
      localStringBuilder.append(((Drawable)localObject).getIntrinsicHeight() * f5 + f4 - getHeight());
      AEQLog.a("AECropperImageView", localStringBuilder.toString());
    }
    float f1 = this.jdField_a_of_type_Float;
    float f2;
    if ((f6 < f1) && (f1 >= this.jdField_c_of_type_Float))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUp(");
      localStringBuilder.append(f6);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.jdField_a_of_type_Float);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.jdField_c_of_type_Float);
      localStringBuilder.append(") - 1 scaleX < mMinZoom && mMinZoom >= mBaseZoom");
      AEQLog.b("AECropperImageView", localStringBuilder.toString());
      if (this.h)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUp() - set scale to min zoom: ");
        localStringBuilder.append(this.jdField_a_of_type_Float);
        AEQLog.a("AECropperImageView", localStringBuilder.toString());
      }
      f1 = getWidth() / 2 - this.jdField_a_of_type_Float * ((Drawable)localObject).getIntrinsicWidth() / 2.0F;
      f2 = getHeight() / 2 - this.jdField_a_of_type_Float * ((Drawable)localObject).getIntrinsicHeight() / 2.0F;
      if (((Drawable)localObject).getIntrinsicHeight() > ((Drawable)localObject).getIntrinsicWidth())
      {
        if (f4 >= 0.0F)
        {
          f2 = 0.0F;
        }
        else if (((Drawable)localObject).getIntrinsicHeight() * f5 + f4 <= getHeight())
        {
          f2 = getHeight() - this.jdField_a_of_type_Float * ((Drawable)localObject).getIntrinsicHeight();
        }
        else
        {
          f2 = this.jdField_f_of_type_Float;
          f2 = (f4 - f2) * (this.jdField_a_of_type_Float / f5) + f2;
        }
      }
      else if (f3 >= 0.0F)
      {
        f1 = 0.0F;
      }
      else if (((Drawable)localObject).getIntrinsicWidth() * f6 + f3 <= getWidth())
      {
        f1 = getWidth() - this.jdField_a_of_type_Float * ((Drawable)localObject).getIntrinsicWidth();
      }
      else
      {
        f1 = this.jdField_e_of_type_Float;
        f1 = (f3 - f1) * (this.jdField_a_of_type_Float / f6) + f1;
      }
      if (a())
      {
        a(f3, f1, f4, f2, f6, this.jdField_a_of_type_Float);
        return true;
      }
      localMatrix.reset();
      f3 = this.jdField_a_of_type_Float;
      localMatrix.setScale(f3, f3);
      localMatrix.postTranslate(f1, f2);
      setImageMatrix(localMatrix);
      invalidate();
      if (this.h)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onUp() - scale after invalidate: ");
        ((StringBuilder)localObject).append(a(localMatrix));
        AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
      }
      return true;
    }
    if ((f6 > this.jdField_c_of_type_Float) && (f6 > this.jdField_d_of_type_Float))
    {
      if ((this.jdField_a_of_type_Boolean) && (f6 > this.jdField_b_of_type_Float))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onUp(");
        ((StringBuilder)localObject).append(f6);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Float);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Float);
        ((StringBuilder)localObject).append(") - 3 isMaxZoomSet && scaleX > mMaxZoom");
        AEQLog.b("AECropperImageView", ((StringBuilder)localObject).toString());
        if (this.h)
        {
          AEQLog.a("AECropperImageView", "onUp() - set to max zoom");
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onUp() - isMaxZoomSet: ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
          AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
        }
        if (a())
        {
          d();
          return true;
        }
        f1 = this.jdField_b_of_type_Float;
        localMatrix.postScale(f1 / f6, f1 / f6, this.jdField_e_of_type_Float, this.jdField_f_of_type_Float);
        setImageMatrix(localMatrix);
        invalidate();
        d();
        return true;
      }
      if (this.h) {
        AEQLog.a("AECropperImageView", "onUp() - adjust to sides");
      }
      d();
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUp(");
    localStringBuilder.append(f6);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_c_of_type_Float);
    localStringBuilder.append(") - 2 scaleX <= mBaseZoom || scaleX <= mBaseZoomBigger");
    AEQLog.b("AECropperImageView", localStringBuilder.toString());
    int j = ((Drawable)localObject).getIntrinsicHeight();
    int k = ((Drawable)localObject).getIntrinsicWidth();
    if (j <= k)
    {
      f5 = getHeight() / 2 - j * f6 / 2.0F;
      if (f3 >= 0.0F)
      {
        f2 = 0.0F;
        f1 = f5;
      }
      else
      {
        f1 = getWidth() - ((Drawable)localObject).getIntrinsicWidth() * f6;
        if (f3 >= f1) {
          f1 = f3;
        }
        f2 = f1;
        f1 = f5;
      }
    }
    else
    {
      f2 = getWidth() / 2 - k * f6 / 2.0F;
      if (f4 >= 0.0F)
      {
        f1 = 0.0F;
      }
      else
      {
        f1 = getHeight() - f5 * ((Drawable)localObject).getIntrinsicHeight();
        if (f4 >= f1) {
          f1 = f4;
        }
      }
    }
    if (a())
    {
      localMatrix.reset();
      localMatrix.postScale(f6, f6);
      localMatrix.postTranslate(f3, f4);
      setImageMatrix(localMatrix);
      a(f2 - f3, f1 - f4);
      return true;
    }
    localMatrix.reset();
    localMatrix.postScale(f6, f6);
    localMatrix.postTranslate(f2, f1);
    setImageMatrix(localMatrix);
    invalidate();
    return true;
  }
  
  private void d()
  {
    float f1 = a(getImageMatrix());
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new AECropperImageView.5(this, f1));
    localValueAnimator.addListener(new AECropperImageView.6(this));
    localValueAnimator.start();
  }
  
  private boolean d()
  {
    Drawable localDrawable = getDrawable();
    boolean bool1 = false;
    if (localDrawable == null) {
      return false;
    }
    Matrix localMatrix = getImageMatrix();
    float f1 = a(localMatrix, 2);
    float f4 = a(localMatrix, 5);
    float f2 = a(localMatrix, 0);
    float f5 = a(localMatrix, 4);
    boolean bool2 = true;
    float f3 = 0.0F;
    if (f1 > 0.0F) {}
    for (f1 = -f1;; f1 = f2 - f1)
    {
      bool1 = true;
      f2 = f1;
      break label108;
      f2 = getWidth() - f2 * localDrawable.getIntrinsicWidth();
      if (f1 >= f2) {
        break;
      }
    }
    f2 = 0.0F;
    label108:
    if (f4 > 0.0F)
    {
      f1 = -f4;
      bool1 = bool2;
    }
    else
    {
      f1 = getHeight() - f5 * localDrawable.getIntrinsicHeight();
      if (f4 < f1)
      {
        f1 -= f4;
        bool1 = bool2;
      }
      else
      {
        f1 = f3;
      }
    }
    if (bool1)
    {
      if (a())
      {
        a(f2, f1);
        return bool1;
      }
      localMatrix.postTranslate(f2, f1);
      setImageMatrix(localMatrix);
      invalidate();
    }
    return bool1;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public CropInfo a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      AEQLog.d("AECropperImageView", "original image is not available");
      return null;
    }
    Object localObject = getImageMatrix();
    float f4 = a((Matrix)localObject, 2);
    float f5 = a((Matrix)localObject, 5);
    boolean bool2 = false;
    int k = 0;
    float f3 = a((Matrix)localObject, 0);
    if (this.h)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("xTrans: ");
      ((StringBuilder)localObject).append(f4);
      ((StringBuilder)localObject).append(", yTrans: ");
      ((StringBuilder)localObject).append(f5);
      ((StringBuilder)localObject).append(" , scale: ");
      ((StringBuilder)localObject).append(f3);
      AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("old bitmap: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
    }
    if ((f4 > 0.0F) && (f5 > 0.0F) && (f3 <= this.jdField_a_of_type_Float))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() > this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) {
        j = 0;
      } else {
        j = (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) / 2;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) {
        k = (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) / 2;
      }
      return CropInfo.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_Boolean, k, j, this.jdField_a_of_type_Int);
    }
    float f1 = -f5 / f3;
    float f6 = getHeight() / f3;
    float f2 = -f4 / f3;
    float f7 = getWidth() / f3;
    if (this.h)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cropY: ");
      ((StringBuilder)localObject).append(f1);
      AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Y: ");
      ((StringBuilder)localObject).append(f6);
      AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cropX: ");
      ((StringBuilder)localObject).append(f2);
      AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("X: ");
      ((StringBuilder)localObject).append(f7);
      AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
    }
    if (f1 + f6 > this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight())
    {
      f3 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() - f6;
      f1 = f3;
      if (this.h)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readjust cropY to: ");
        ((StringBuilder)localObject).append(f3);
        AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
        f1 = f3;
      }
    }
    else if (f1 < 0.0F)
    {
      if (this.h)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readjust cropY to: ");
        ((StringBuilder)localObject).append(0.0F);
        AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
      }
      f1 = 0.0F;
    }
    if (f2 + f7 > this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth())
    {
      f3 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() - f7;
      f2 = f3;
      if (this.h)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readjust cropX to: ");
        ((StringBuilder)localObject).append(f3);
        AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
        f2 = f3;
      }
    }
    else if (f2 < 0.0F)
    {
      if (this.h)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readjust cropX to: ");
        ((StringBuilder)localObject).append(0.0F);
        AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
      }
      f2 = 0.0F;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() > this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth())
    {
      if (f4 >= 0.0F)
      {
        localObject = new Rect(0, (int)f1, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), (int)(f1 + f6));
        j = (int)((f6 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) / 2.0F);
        k = 0;
        m = 1;
        break label944;
      }
      localObject = new Rect((int)f2, (int)f1, (int)(f2 + f7), (int)(f1 + f6));
    }
    else
    {
      if (f5 >= 0.0F)
      {
        localObject = new Rect((int)f2, 0, (int)(f2 + f7), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
        k = (int)((f7 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) / 2.0F);
        m = 1;
        j = 0;
        break label944;
      }
      localObject = new Rect((int)f2, (int)f1, (int)(f2 + f7), (int)(f1 + f6));
    }
    int m = 0;
    int j = 0;
    k = 0;
    label944:
    if ((m != 0) && ((j != 0) || (k != 0))) {
      m = 1;
    } else {
      m = 0;
    }
    boolean bool1 = bool2;
    if (this.jdField_d_of_type_Boolean)
    {
      bool1 = bool2;
      if (m != 0) {
        bool1 = true;
      }
    }
    return CropInfo.a((Rect)localObject, bool1, j, k, this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      b();
      return;
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.g)
    {
      AEQLog.d("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
      return;
    }
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      a(localDrawable, getWidth(), paramBoolean);
    }
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = getImageMatrix();
    localMatrix.postTranslate(-paramFloat1, -paramFloat2);
    setImageMatrix(localMatrix);
    invalidate();
    return true;
  }
  
  public float b()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return b(localBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), getWidth());
    }
    return 0.0F;
  }
  
  public int b()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return localBitmap.getWidth();
    }
    return 0;
  }
  
  public void b()
  {
    if (this.g)
    {
      AEQLog.d("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
      return;
    }
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      a(localDrawable, getWidth());
    }
  }
  
  public boolean b()
  {
    return this.i;
  }
  
  public int c()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return localBitmap.getHeight();
    }
    return 0;
  }
  
  public void c()
  {
    a(false);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject;
    if (this.h)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLayout: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" [");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append("]");
      AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        if (this.h) {
          AEQLog.d("AECropperImageView", "drawable is null");
        }
        return;
      }
      float f1;
      if (getResources().getConfiguration().orientation == 2)
      {
        f1 = paramInt3 - paramInt1;
        this.jdField_c_of_type_Float = (f1 / Math.max(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
        this.jdField_d_of_type_Float = (f1 / Math.min(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
      }
      else
      {
        f1 = paramInt4 - paramInt2;
        this.jdField_c_of_type_Float = (f1 / Math.max(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
        this.jdField_d_of_type_Float = (f1 / Math.min(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
      }
      if (this.jdField_a_of_type_Boolean)
      {
        f1 = this.jdField_c_of_type_Float;
        float f2 = this.jdField_b_of_type_Float;
        if (f1 > f2)
        {
          this.jdField_c_of_type_Float = f2;
          this.jdField_d_of_type_Float = f2;
          if (this.jdField_a_of_type_Float > f2)
          {
            AEQLog.d("AECropperImageView", "min zoom is greater than max zoom. Changing min zoom = max zoom");
            a(this.jdField_b_of_type_Float);
          }
        }
      }
      if ((this.jdField_a_of_type_Float <= 0.0F) || (!this.jdField_b_of_type_Boolean)) {
        a(this.jdField_c_of_type_Float);
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = getContext().getResources().getConfiguration().orientation;
    if ((j != 1) && (j != 0))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt1);
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      AEQLog.a("AECropperImageView", "onTouchEvent(isAdjusting) - Can't perform this action right now.");
      return true;
    }
    if (this.g)
    {
      AEQLog.a("AECropperImageView", "onTouchEvent(isCropping) - Can't perform this action right now.");
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onTouchEvent(");
    ((StringBuilder)localObject).append(paramMotionEvent.getActionMasked());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramMotionEvent.getAction());
    ((StringBuilder)localObject).append(")");
    AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
    getParent().requestDisallowInterceptTouchEvent(true);
    if (paramMotionEvent.getActionMasked() == 0)
    {
      AEQLog.a("AECropperImageView", "onTouchEvent(MotionEvent.ACTION_DOWN)");
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView$GestureCallback;
      if (localObject != null) {
        ((AECropperImageView.GestureCallback)localObject).a();
      }
    }
    this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
    if (!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    int j = paramMotionEvent.getAction();
    if ((j != 1) && (j != 3)) {
      return true;
    }
    AEQLog.a("AECropperImageView", "onTouchEvent(MotionEvent.ACTION_UP)");
    paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView$GestureCallback;
    if (paramMotionEvent != null) {
      paramMotionEvent.b();
    }
    return c();
  }
  
  public void setDEBUG(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setGestureCallback(AECropperImageView.GestureCallback paramGestureCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperImageView$GestureCallback = paramGestureCallback;
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.g)
    {
      AEQLog.d("AECropperImageView", "Cropping current bitmap. Can't set bitmap now");
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (paramBitmap == null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      super.setImageBitmap(null);
      return;
    }
    if ((paramBitmap.getHeight() > 1280) || ((paramBitmap.getWidth() > 1280) && (this.h))) {
      AEQLog.c("AECropperImageView", "Bitmap size greater than 1280. This might cause memory issues");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    setMinZoom(a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), getWidth()));
    super.setImageBitmap(paramBitmap);
    if (this.jdField_b_of_type_Int == 2) {
      b(getDrawable(), getWidth());
    } else {
      a(getDrawable(), getWidth());
    }
    requestLayout();
  }
  
  public void setMaxZoom(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      AEQLog.d("AECropperImageView", "Max zoom must be greater than 0");
      return;
    }
    float f1 = this.jdField_a_of_type_Float;
    if ((f1 > 0.0F) && (paramFloat < f1))
    {
      AEQLog.d("AECropperImageView", "Max zoom must be greater than min zoom");
      return;
    }
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setMinZoom(float paramFloat)
  {
    if (a(paramFloat)) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void setShowAnimation(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperImageView
 * JD-Core Version:    0.7.0.1
 */