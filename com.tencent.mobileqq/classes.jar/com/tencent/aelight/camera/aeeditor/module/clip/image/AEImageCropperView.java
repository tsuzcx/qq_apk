package com.tencent.aelight.camera.aeeditor.module.clip.image;

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
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.impl.R.styleable;
import com.tencent.aelight.camera.log.AEQLog;

public class AEImageCropperView
  extends ImageView
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = -1;
  Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = null;
  public Bitmap a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  protected GestureDetector a;
  protected ScaleGestureDetector a;
  private AEEditorImageInfo jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorImageInfo;
  private AEImageCropperView.GestureCallback jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView$GestureCallback;
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 0;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean = true;
  private float jdField_f_of_type_Float;
  private boolean jdField_f_of_type_Boolean = false;
  private float jdField_g_of_type_Float;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h = false;
  private boolean i = true;
  
  public AEImageCropperView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AEImageCropperView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AEImageCropperView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private float a(int paramInt1, int paramInt2)
  {
    int j = this.jdField_b_of_type_Int;
    if (j == 0) {
      return a(paramInt1, paramInt2, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    Rect localRect2 = AEImageCropperMask.a(j, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect(0, 0, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    float f1 = paramInt1;
    float f2 = paramInt2;
    if (f1 * 1.0F / f2 <= (localRect1.right - localRect1.left) * 1.0F / (localRect1.bottom - localRect1.top)) {
      return (localRect1.right - localRect1.left) * 1.0F / f1;
    }
    return (localRect1.bottom - localRect1.top) * 1.0F / f2;
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt1;
    float f2 = paramInt2;
    float f3 = f1 * 1.0F / f2;
    float f4 = paramInt3;
    float f5 = f4 * 1.0F;
    float f6 = paramInt4;
    float f7 = f5 / f6;
    if (f3 <= 0.3333333F) {
      return f6 * 0.3333333F / f1;
    }
    if (f3 >= 1.777778F) {
      return f4 / 1.777778F / f2;
    }
    if (f3 < f7) {
      return f6 * 1.0F / f2;
    }
    return f5 / f1;
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
    localValueAnimator.addUpdateListener(new AEImageCropperView.3(this, localMatrix, paramFloat1, f1, paramFloat2, f2));
    localValueAnimator.addListener(new AEImageCropperView.4(this));
    localValueAnimator.start();
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new AEImageCropperView.1(this, paramFloat6, paramFloat5, paramFloat2, paramFloat1, paramFloat4, paramFloat3));
    localValueAnimator.addListener(new AEImageCropperView.2(this));
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
        paramAttributeSet.recycle();
      }
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new AEImageCropperView.GestureListener(this, null), null, true);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new AEImageCropperView.ScaleListener(this, null));
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (this.h) {
        AEQLog.d("AEImageCropperView", "Drawable is null. I can't fit anything");
      }
      return;
    }
    if ((this.jdField_c_of_type_Int != 0) && (this.jdField_d_of_type_Int != 0))
    {
      int j = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      setMinZoom(a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()));
      if (this.jdField_b_of_type_Int == 0)
      {
        j = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        this.jdField_g_of_type_Float = a(j, k, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        paramDrawable = new Matrix();
        f1 = this.jdField_g_of_type_Float;
        paramDrawable.setScale(f1, f1, j / 2.0F, k / 2.0F);
        paramDrawable.postTranslate((this.jdField_c_of_type_Int - j) / 2, (this.jdField_d_of_type_Int - k) / 2);
        setImageMatrix(paramDrawable);
        return;
      }
      float f1 = a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      paramDrawable = new Matrix();
      paramDrawable.setScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2.0F, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2.0F);
      paramDrawable.postTranslate((this.jdField_c_of_type_Int - j) / 2, (this.jdField_d_of_type_Int - k) / 2);
      setImageMatrix(paramDrawable);
      return;
    }
    if (this.h) {
      AEQLog.d("AEImageCropperView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
    }
  }
  
  private boolean a(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      AEQLog.d("AEImageCropperView", "Min zoom must be greater than 0");
      return false;
    }
    if ((this.jdField_a_of_type_Boolean) && (paramFloat > this.jdField_b_of_type_Float))
    {
      AEQLog.d("AEImageCropperView", "Min zoom must not be greater than max zoom");
      this.jdField_b_of_type_Float = paramFloat;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Float = paramFloat;
    return true;
  }
  
  private boolean b()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return false;
    }
    Matrix localMatrix = getImageMatrix();
    float f4 = a(localMatrix, 2);
    float f5 = a(localMatrix, 5);
    float f6 = a(localMatrix, 0);
    float f1 = a(localMatrix, 4);
    Object localObject2 = AEImageCropperMask.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Rect(0, 0, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    float f7 = localDrawable.getIntrinsicWidth() * 1.0F / localDrawable.getIntrinsicHeight();
    float f8 = (((Rect)localObject1).right - ((Rect)localObject1).left) * 1.0F / (((Rect)localObject1).bottom - ((Rect)localObject1).top);
    if (this.h)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUp( tx = ");
      ((StringBuilder)localObject2).append(f4);
      ((StringBuilder)localObject2).append(", ty = ");
      ((StringBuilder)localObject2).append(f5);
      ((StringBuilder)localObject2).append(")");
      AEQLog.a("AEImageCropperView", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUp() - scale: ");
      ((StringBuilder)localObject2).append(f6);
      AEQLog.a("AEImageCropperView", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUp() - min, max, base zoom: ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Float);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Float);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_Float);
      AEQLog.a("AEImageCropperView", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUp() - imageview size: ");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_Int);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(this.jdField_d_of_type_Int);
      AEQLog.a("AEImageCropperView", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUp() - drawable size: ");
      ((StringBuilder)localObject2).append(localDrawable.getIntrinsicWidth());
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(localDrawable.getIntrinsicHeight());
      AEQLog.a("AEImageCropperView", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUp() - scaled drawable size: ");
      ((StringBuilder)localObject2).append(localDrawable.getIntrinsicWidth() * f6);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(localDrawable.getIntrinsicHeight() * f1);
      AEQLog.a("AEImageCropperView", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUp() - h diff: ");
      ((StringBuilder)localObject2).append(localDrawable.getIntrinsicHeight() * f1 + f5 - getHeight());
      AEQLog.a("AEImageCropperView", ((StringBuilder)localObject2).toString());
    }
    float f2 = this.jdField_a_of_type_Float;
    if ((f6 < f2) && (f2 >= this.jdField_c_of_type_Float))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUp(");
      ((StringBuilder)localObject2).append(f6);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Float);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_Float);
      ((StringBuilder)localObject2).append(") - 1 scaleX < mMinZoom && mMinZoom >= mBaseZoom");
      AEQLog.b("AEImageCropperView", ((StringBuilder)localObject2).toString());
      if (this.h)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onUp() - set scale to min zoom: ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Float);
        AEQLog.a("AEImageCropperView", ((StringBuilder)localObject2).toString());
      }
      float f3 = this.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Float * localDrawable.getIntrinsicWidth() / 2.0F;
      f2 = this.jdField_d_of_type_Int / 2 - this.jdField_a_of_type_Float * localDrawable.getIntrinsicHeight() / 2.0F;
      if (f8 >= f7)
      {
        if (f5 >= ((Rect)localObject1).top)
        {
          f1 = ((Rect)localObject1).top;
          f2 = f3;
        }
        else
        {
          if (localDrawable.getIntrinsicHeight() * f1 + f5 <= ((Rect)localObject1).bottom)
          {
            f1 = ((Rect)localObject1).bottom - this.jdField_a_of_type_Float * localDrawable.getIntrinsicHeight();
          }
          else
          {
            f2 = this.jdField_f_of_type_Float;
            f1 = (f5 - f2) * (this.jdField_a_of_type_Float / f1) + f2;
          }
          f2 = f3;
        }
      }
      else if (f4 >= 0.0F)
      {
        f1 = f2;
        f2 = 0.0F;
      }
      else
      {
        f1 = localDrawable.getIntrinsicWidth();
        j = this.jdField_c_of_type_Int;
        if (f1 * f6 + f4 <= j)
        {
          f1 = j - this.jdField_a_of_type_Float * localDrawable.getIntrinsicWidth();
        }
        else
        {
          f1 = this.jdField_e_of_type_Float;
          f1 = (f4 - f1) * (this.jdField_a_of_type_Float / f6) + f1;
        }
        f3 = f2;
        f2 = f1;
        f1 = f3;
      }
      if (a())
      {
        a(f4, f2, f5, f1, f6, this.jdField_a_of_type_Float);
      }
      else
      {
        localMatrix.reset();
        f3 = this.jdField_a_of_type_Float;
        localMatrix.setScale(f3, f3);
        localMatrix.postTranslate(f2, f1);
        setImageMatrix(localMatrix);
        invalidate();
        if (this.h)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onUp() - scale after invalidate: ");
          ((StringBuilder)localObject1).append(a(localMatrix));
          AEQLog.a("AEImageCropperView", ((StringBuilder)localObject1).toString());
        }
      }
      return true;
    }
    if ((f6 > this.jdField_c_of_type_Float) && (f6 > this.jdField_d_of_type_Float))
    {
      if ((this.jdField_a_of_type_Boolean) && (f6 > this.jdField_b_of_type_Float))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onUp(");
        ((StringBuilder)localObject1).append(f6);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Float);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Float);
        ((StringBuilder)localObject1).append(") - 3 isMaxZoomSet && scaleX > mMaxZoom");
        AEQLog.b("AEImageCropperView", ((StringBuilder)localObject1).toString());
        if (this.h)
        {
          AEQLog.a("AEImageCropperView", "onUp() - set to max zoom");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onUp() - isMaxZoomSet: ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
          AEQLog.a("AEImageCropperView", ((StringBuilder)localObject1).toString());
        }
        if (a())
        {
          c();
        }
        else
        {
          f1 = this.jdField_b_of_type_Float;
          localMatrix.postScale(f1 / f6, f1 / f6, this.jdField_e_of_type_Float, this.jdField_f_of_type_Float);
          setImageMatrix(localMatrix);
          invalidate();
          c();
        }
        return true;
      }
      if (this.h) {
        AEQLog.a("AEImageCropperView", "onUp() - adjust to sides");
      }
      c();
      return true;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onUp(");
    ((StringBuilder)localObject2).append(f6);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Float);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(this.jdField_c_of_type_Float);
    ((StringBuilder)localObject2).append(") - 2 scaleX <= mBaseZoom || scaleX <= mBaseZoomBigger");
    AEQLog.b("AEImageCropperView", ((StringBuilder)localObject2).toString());
    int j = localDrawable.getIntrinsicHeight();
    int k = localDrawable.getIntrinsicWidth();
    if (f8 >= f7)
    {
      f2 = this.jdField_c_of_type_Int / 2 - k * f6 / 2.0F;
      if (f5 >= ((Rect)localObject1).top) {
        f1 = ((Rect)localObject1).top;
      } else if (localDrawable.getIntrinsicHeight() * f1 + f5 <= ((Rect)localObject1).bottom) {
        f1 = ((Rect)localObject1).bottom - f1 * localDrawable.getIntrinsicHeight();
      } else {
        f1 = f5;
      }
    }
    else
    {
      f1 = this.jdField_d_of_type_Int / 2 - j * f6 / 2.0F;
      if (f4 >= 0.0F)
      {
        f2 = 0.0F;
      }
      else
      {
        f2 = this.jdField_c_of_type_Int - localDrawable.getIntrinsicWidth() * f6;
        if (f4 >= f2) {
          f2 = f4;
        }
      }
    }
    if (a())
    {
      localMatrix.reset();
      localMatrix.postScale(f6, f6);
      localMatrix.postTranslate(f4, f5);
      setImageMatrix(localMatrix);
      a(f2 - f4, f1 - f5);
    }
    else
    {
      localMatrix.reset();
      localMatrix.postScale(f6, f6);
      localMatrix.postTranslate(f2, f1);
      setImageMatrix(localMatrix);
      invalidate();
    }
    return true;
  }
  
  private void c()
  {
    float f1 = a(getImageMatrix());
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new AEImageCropperView.5(this, f1));
    localValueAnimator.addListener(new AEImageCropperView.6(this));
    localValueAnimator.start();
  }
  
  private boolean c()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return false;
    }
    Matrix localMatrix = getImageMatrix();
    float f3 = a(localMatrix, 2);
    float f4 = a(localMatrix, 5);
    float f5 = a(localMatrix, 0);
    float f1 = a(localMatrix, 4);
    Rect localRect2 = AEImageCropperMask.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect(0, 0, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    if (f4 >= localRect1.top) {
      f1 = localRect1.top;
    } else if (localDrawable.getIntrinsicHeight() * f1 + f4 <= localRect1.bottom) {
      f1 = localRect1.bottom - f1 * localDrawable.getIntrinsicHeight();
    } else {
      f1 = f4;
    }
    float f2;
    if (f3 >= localRect1.left) {
      f2 = localRect1.left;
    } else if (localDrawable.getIntrinsicWidth() * f5 + f3 <= localRect1.right) {
      f2 = localRect1.right - localDrawable.getIntrinsicWidth() * f5;
    } else {
      f2 = f3;
    }
    if (a())
    {
      localMatrix.reset();
      localMatrix.postScale(f5, f5);
      localMatrix.postTranslate(f3, f4);
      setImageMatrix(localMatrix);
      a(f2 - f3, f1 - f4);
      return false;
    }
    localMatrix.reset();
    localMatrix.postScale(f5, f5);
    localMatrix.postTranslate(f2, f1);
    setImageMatrix(localMatrix);
    invalidate();
    return false;
  }
  
  public float a()
  {
    return this.jdField_g_of_type_Float;
  }
  
  public int a()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return localBitmap.getWidth();
    }
    return 0;
  }
  
  public Rect a()
  {
    if (this.jdField_b_of_type_AndroidGraphicsRect == null)
    {
      double d1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 1.0F / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      int j;
      int k;
      int m;
      int n;
      if (d1 <= 0.333333343267441D)
      {
        j = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
        k = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
        m = AEImageCropperContainer.jdField_a_of_type_Int;
        n = this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int;
      }
      else
      {
        float f1;
        float f2;
        float f3;
        if (d1 >= 1.777777791023254D)
        {
          j = AEImageCropperContainer.jdField_a_of_type_Int;
          k = this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int;
          m = (int)((this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_g_of_type_Float) / 2.0F);
          f1 = this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2;
          f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
          f3 = this.jdField_g_of_type_Float;
        }
        else
        {
          j = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
          k = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
          m = (int)((this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_g_of_type_Float) / 2.0F);
          f1 = this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2;
          f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
          f3 = this.jdField_g_of_type_Float;
        }
        n = (int)((f1 + f2 * f3) / 2.0F);
      }
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect(j, m, k, n);
    }
    return this.jdField_b_of_type_AndroidGraphicsRect;
  }
  
  public void a()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      AEQLog.d("AEImageCropperView", "Cropping current bitmap. Can't perform this action right now.");
      return;
    }
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      a(localDrawable);
    }
  }
  
  public void a(AEEditorImageInfo paramAEEditorImageInfo, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    paramAEEditorImageInfo.a = null;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorImageInfo = paramAEEditorImageInfo;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    setImageBitmap(paramBitmap);
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
  
  public int b()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return localBitmap.getHeight();
    }
    return 0;
  }
  
  public Rect b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null)
    {
      int j = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
      int k = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(j, (int)((this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_g_of_type_Float) / 2.0F), k, (int)((this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_g_of_type_Float) / 2.0F));
    }
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public void b()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      AEQLog.d("AEImageCropperView", "Cropping current bitmap. Can't perform this action right now.");
      return;
    }
    setImageBitmap(null);
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
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
      AEQLog.a("AEImageCropperView", ((StringBuilder)localObject).toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        if (this.h) {
          AEQLog.d("AEImageCropperView", "drawable is null");
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
            AEQLog.d("AEImageCropperView", "min zoom is greater than max zoom. Changing min zoom = max zoom");
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
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      AEQLog.a("AEImageCropperView", "onTouchEvent(isAdjusting) - Can't perform this action right now.");
      return true;
    }
    if (this.jdField_g_of_type_Boolean)
    {
      AEQLog.a("AEImageCropperView", "onTouchEvent(isCropping) - Can't perform this action right now.");
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onTouchEvent(");
    ((StringBuilder)localObject).append(paramMotionEvent.getActionMasked());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramMotionEvent.getAction());
    ((StringBuilder)localObject).append(")");
    AEQLog.a("AEImageCropperView", ((StringBuilder)localObject).toString());
    getParent().requestDisallowInterceptTouchEvent(true);
    if (paramMotionEvent.getActionMasked() == 0)
    {
      AEQLog.a("AEImageCropperView", "onTouchEvent(MotionEvent.ACTION_DOWN)");
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView$GestureCallback;
      if (localObject != null) {
        ((AEImageCropperView.GestureCallback)localObject).a();
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
    AEQLog.a("AEImageCropperView", "onTouchEvent(MotionEvent.ACTION_UP)");
    paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView$GestureCallback;
    if (paramMotionEvent != null) {
      paramMotionEvent.b();
    }
    return b();
  }
  
  public void setAEEditorImageInfo(AEEditorImageInfo paramAEEditorImageInfo)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorImageInfo = paramAEEditorImageInfo;
  }
  
  public void setDEBUG(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setGestureCallback(AEImageCropperView.GestureCallback paramGestureCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperView$GestureCallback = paramGestureCallback;
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.jdField_g_of_type_Boolean)
    {
      AEQLog.d("AEImageCropperView", "Cropping current bitmap. Can't set bitmap now");
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
      AEQLog.c("AEImageCropperView", "Bitmap size greater than 1280. This might cause memory issues");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    super.setImageBitmap(paramBitmap);
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorImageInfo.a != null) {
      setImageMatrix(this.jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorImageInfo.a);
    } else {
      a();
    }
    requestLayout();
  }
  
  public void setMaxZoom(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      AEQLog.d("AEImageCropperView", "Max zoom must be greater than 0");
      return;
    }
    float f1 = this.jdField_a_of_type_Float;
    if ((f1 > 0.0F) && (paramFloat < f1))
    {
      AEQLog.d("AEImageCropperView", "Max zoom must be greater than min zoom");
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
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEImageCropperView
 * JD-Core Version:    0.7.0.1
 */