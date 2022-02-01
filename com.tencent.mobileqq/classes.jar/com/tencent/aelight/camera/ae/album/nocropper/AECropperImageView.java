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
  protected GestureDetector a;
  protected ScaleGestureDetector b;
  public Bitmap c;
  Animator.AnimatorListener d = null;
  private float[] e = new float[9];
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 0.0F;
  private float i = 0.0F;
  private float j;
  private float k;
  private boolean l = false;
  private boolean m = false;
  private boolean n = true;
  private boolean o = true;
  private AECropperImageView.GestureCallback p;
  private boolean q = true;
  private boolean r = false;
  private boolean s = false;
  private int t = -1;
  private boolean u = false;
  private boolean v = true;
  private int w = 1;
  
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
    paramMatrix.getValues(this.e);
    return this.e[paramInt];
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
        this.t = paramAttributeSet.getColor(2, this.t);
        this.o = paramAttributeSet.getBoolean(0, true);
        if (paramAttributeSet.getBoolean(1, false)) {
          this.w = 2;
        } else {
          this.w = 1;
        }
        paramAttributeSet.recycle();
      }
    }
    this.a = new GestureDetector(paramContext, new AECropperImageView.GestureListener(this, null), null, true);
    this.b = new ScaleGestureDetector(paramContext, new AECropperImageView.ScaleListener(this, null));
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null)
    {
      if (this.u) {
        AEQLog.d("AECropperImageView", "Drawable is null. I can't fit anything");
      }
      return;
    }
    if (paramInt == 0)
    {
      if (this.u) {
        AEQLog.d("AECropperImageView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
      }
      return;
    }
    this.w = 1;
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    float f1 = b(this.c.getWidth(), this.c.getHeight(), getWidth());
    paramDrawable = new Matrix();
    paramDrawable.setScale(f1, f1, this.c.getWidth() / 2.0F, this.c.getHeight() / 2.0F);
    paramDrawable.postTranslate((paramInt - i1) / 2, (paramInt - i2) / 2);
    setImageMatrix(paramDrawable);
  }
  
  private void a(Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    if (paramDrawable == null)
    {
      if (this.u) {
        AEQLog.d("AECropperImageView", "Drawable is null. I can't fit anything");
      }
      return;
    }
    if (paramInt == 0)
    {
      if (this.u) {
        AEQLog.d("AECropperImageView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
      }
      return;
    }
    this.w = 2;
    int i1;
    int i2;
    float f1;
    Matrix localMatrix;
    float f2;
    float f3;
    if (!paramBoolean)
    {
      i1 = this.c.getWidth();
      i2 = this.c.getHeight();
      f1 = a(i1, i2, getWidth());
      localMatrix = new Matrix();
      localMatrix.setScale(f1, f1, i1 / 2.0F, i2 / 2.0F);
      localMatrix.postTranslate((paramInt - i1) / 2, (paramInt - i2) / 2);
      setImageMatrix(localMatrix);
      f1 = a(localMatrix, 2);
      f2 = a(localMatrix, 5);
      f3 = a(localMatrix, 0);
      if (f3 < this.f) {
        a(f1, getWidth() / 2 - this.f * paramDrawable.getIntrinsicWidth() / 2.0F, f2, getHeight() / 2 - this.f * paramDrawable.getIntrinsicHeight() / 2.0F, f3, this.f);
      }
    }
    else
    {
      i1 = this.c.getWidth();
      i2 = this.c.getHeight();
      f1 = a(i1, i2, getWidth());
      localMatrix = new Matrix();
      localMatrix.setScale(f1, f1, i1 / 2.0F, i2 / 2.0F);
      localMatrix.postTranslate((paramInt - i1) / 2, (paramInt - i2) / 2);
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
    if ((this.l) && (paramFloat > this.g))
    {
      AEQLog.d("AECropperImageView", "Min zoom must not be greater than max zoom");
      this.g = paramFloat;
    }
    this.m = false;
    this.f = paramFloat;
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
  
  private void b(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = getImageMatrix();
    float f1 = a(localMatrix, 2);
    float f2 = a(localMatrix, 5);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new AECropperImageView.3(this, localMatrix, paramFloat1, f1, paramFloat2, f2));
    localValueAnimator.addListener(new AECropperImageView.4(this));
    localValueAnimator.start();
  }
  
  private void b(Drawable paramDrawable, int paramInt)
  {
    a(paramDrawable, paramInt, false);
  }
  
  private boolean f()
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
    if (this.u)
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
      localStringBuilder.append(this.f);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.g);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.h);
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
    float f1 = this.f;
    float f2;
    if ((f6 < f1) && (f1 >= this.h))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUp(");
      localStringBuilder.append(f6);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.h);
      localStringBuilder.append(") - 1 scaleX < mMinZoom && mMinZoom >= mBaseZoom");
      AEQLog.b("AECropperImageView", localStringBuilder.toString());
      if (this.u)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUp() - set scale to min zoom: ");
        localStringBuilder.append(this.f);
        AEQLog.a("AECropperImageView", localStringBuilder.toString());
      }
      f1 = getWidth() / 2 - this.f * ((Drawable)localObject).getIntrinsicWidth() / 2.0F;
      f2 = getHeight() / 2 - this.f * ((Drawable)localObject).getIntrinsicHeight() / 2.0F;
      if (((Drawable)localObject).getIntrinsicHeight() > ((Drawable)localObject).getIntrinsicWidth())
      {
        if (f4 >= 0.0F)
        {
          f2 = 0.0F;
        }
        else if (((Drawable)localObject).getIntrinsicHeight() * f5 + f4 <= getHeight())
        {
          f2 = getHeight() - this.f * ((Drawable)localObject).getIntrinsicHeight();
        }
        else
        {
          f2 = this.k;
          f2 = (f4 - f2) * (this.f / f5) + f2;
        }
      }
      else if (f3 >= 0.0F)
      {
        f1 = 0.0F;
      }
      else if (((Drawable)localObject).getIntrinsicWidth() * f6 + f3 <= getWidth())
      {
        f1 = getWidth() - this.f * ((Drawable)localObject).getIntrinsicWidth();
      }
      else
      {
        f1 = this.j;
        f1 = (f3 - f1) * (this.f / f6) + f1;
      }
      if (d())
      {
        a(f3, f1, f4, f2, f6, this.f);
        return true;
      }
      localMatrix.reset();
      f3 = this.f;
      localMatrix.setScale(f3, f3);
      localMatrix.postTranslate(f1, f2);
      setImageMatrix(localMatrix);
      invalidate();
      if (this.u)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onUp() - scale after invalidate: ");
        ((StringBuilder)localObject).append(a(localMatrix));
        AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
      }
      return true;
    }
    if ((f6 > this.h) && (f6 > this.i))
    {
      if ((this.l) && (f6 > this.g))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onUp(");
        ((StringBuilder)localObject).append(f6);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append(") - 3 isMaxZoomSet && scaleX > mMaxZoom");
        AEQLog.b("AECropperImageView", ((StringBuilder)localObject).toString());
        if (this.u)
        {
          AEQLog.a("AECropperImageView", "onUp() - set to max zoom");
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onUp() - isMaxZoomSet: ");
          ((StringBuilder)localObject).append(this.l);
          AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
        }
        if (d())
        {
          h();
          return true;
        }
        f1 = this.g;
        localMatrix.postScale(f1 / f6, f1 / f6, this.j, this.k);
        setImageMatrix(localMatrix);
        invalidate();
        g();
        return true;
      }
      if (this.u) {
        AEQLog.a("AECropperImageView", "onUp() - adjust to sides");
      }
      g();
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUp(");
    localStringBuilder.append(f6);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(") - 2 scaleX <= mBaseZoom || scaleX <= mBaseZoomBigger");
    AEQLog.b("AECropperImageView", localStringBuilder.toString());
    int i1 = ((Drawable)localObject).getIntrinsicHeight();
    int i2 = ((Drawable)localObject).getIntrinsicWidth();
    if (i1 <= i2)
    {
      f5 = getHeight() / 2 - i1 * f6 / 2.0F;
      if (f3 >= 0.0F)
      {
        f2 = 0.0F;
        f1 = f5;
      }
      else
      {
        f1 = getWidth() - f6 * ((Drawable)localObject).getIntrinsicWidth();
        if (f3 >= f1) {
          f1 = f3;
        }
        f2 = f1;
        f1 = f5;
      }
    }
    else
    {
      f2 = getWidth() / 2 - f6 * i2 / 2.0F;
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
    if (d())
    {
      localMatrix.reset();
      f5 = this.h;
      localMatrix.postScale(f5, f5);
      localMatrix.postTranslate(f3, f4);
      setImageMatrix(localMatrix);
      b(f2 - f3, f1 - f4);
      return true;
    }
    localMatrix.reset();
    f3 = this.h;
    localMatrix.postScale(f3, f3);
    localMatrix.postTranslate(f2, f1);
    setImageMatrix(localMatrix);
    invalidate();
    return true;
  }
  
  private boolean g()
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
      if (d())
      {
        b(f2, f1);
        return bool1;
      }
      localMatrix.postTranslate(f2, f1);
      setImageMatrix(localMatrix);
      invalidate();
    }
    return bool1;
  }
  
  private void h()
  {
    float f1 = a(getImageMatrix());
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new AECropperImageView.5(this, f1));
    localValueAnimator.addListener(new AECropperImageView.6(this));
    localValueAnimator.start();
  }
  
  public void a()
  {
    if (this.c == null) {
      return;
    }
    if (this.w == 2)
    {
      b();
      return;
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.s)
    {
      AEQLog.d("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
      return;
    }
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      a(localDrawable, getWidth(), paramBoolean);
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = getImageMatrix();
    localMatrix.postTranslate(-paramFloat1, -paramFloat2);
    setImageMatrix(localMatrix);
    invalidate();
    return true;
  }
  
  public void b()
  {
    if (this.s)
    {
      AEQLog.d("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
      return;
    }
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      a(localDrawable, getWidth());
    }
  }
  
  public void c()
  {
    a(false);
  }
  
  public boolean d()
  {
    return this.q;
  }
  
  public boolean e()
  {
    return this.v;
  }
  
  public float getCropCenterZoom()
  {
    Bitmap localBitmap = this.c;
    if (localBitmap != null) {
      return b(localBitmap.getWidth(), this.c.getHeight(), getWidth());
    }
    return 0.0F;
  }
  
  public CropInfo getCropInfo()
  {
    if (this.c == null)
    {
      AEQLog.d("AECropperImageView", "original image is not available");
      return null;
    }
    Object localObject = getImageMatrix();
    float f4 = a((Matrix)localObject, 2);
    float f5 = a((Matrix)localObject, 5);
    boolean bool2 = false;
    int i2 = 0;
    float f3 = a((Matrix)localObject, 0);
    if (this.u)
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
      ((StringBuilder)localObject).append(this.c.getWidth());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.c.getHeight());
      AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
    }
    if ((f4 > 0.0F) && (f5 > 0.0F) && (f3 <= this.f))
    {
      if (this.c.getHeight() > this.c.getWidth()) {
        i1 = 0;
      } else {
        i1 = (this.c.getWidth() - this.c.getHeight()) / 2;
      }
      if (this.c.getWidth() <= this.c.getHeight()) {
        i2 = (this.c.getHeight() - this.c.getWidth()) / 2;
      }
      return CropInfo.a(this.c, this.o, i2, i1, this.t);
    }
    float f1 = -f5 / f3;
    float f6 = getHeight() / f3;
    float f2 = -f4 / f3;
    float f7 = getWidth() / f3;
    if (this.u)
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
    if (f1 + f6 > this.c.getHeight())
    {
      f3 = this.c.getHeight() - f6;
      f1 = f3;
      if (this.u)
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
      if (this.u)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readjust cropY to: ");
        ((StringBuilder)localObject).append(0.0F);
        AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
      }
      f1 = 0.0F;
    }
    if (f2 + f7 > this.c.getWidth())
    {
      f3 = this.c.getWidth() - f7;
      f2 = f3;
      if (this.u)
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
      if (this.u)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readjust cropX to: ");
        ((StringBuilder)localObject).append(0.0F);
        AEQLog.a("AECropperImageView", ((StringBuilder)localObject).toString());
      }
      f2 = 0.0F;
    }
    if (this.c.getHeight() > this.c.getWidth())
    {
      if (f4 >= 0.0F)
      {
        localObject = new Rect(0, (int)f1, this.c.getWidth(), (int)(f1 + f6));
        i1 = (int)((f6 - this.c.getWidth()) / 2.0F);
        i2 = 0;
        i3 = 1;
        break label944;
      }
      localObject = new Rect((int)f2, (int)f1, (int)(f2 + f7), (int)(f1 + f6));
    }
    else
    {
      if (f5 >= 0.0F)
      {
        localObject = new Rect((int)f2, 0, (int)(f2 + f7), this.c.getHeight());
        i2 = (int)((f7 - this.c.getHeight()) / 2.0F);
        i3 = 1;
        i1 = 0;
        break label944;
      }
      localObject = new Rect((int)f2, (int)f1, (int)(f2 + f7), (int)(f1 + f6));
    }
    int i3 = 0;
    int i1 = 0;
    i2 = 0;
    label944:
    if ((i3 != 0) && ((i1 != 0) || (i2 != 0))) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    boolean bool1 = bool2;
    if (this.o)
    {
      bool1 = bool2;
      if (i3 != 0) {
        bool1 = true;
      }
    }
    return CropInfo.a((Rect)localObject, bool1, i1, i2, this.t);
  }
  
  public int getImageHeight()
  {
    Bitmap localBitmap = this.c;
    if (localBitmap != null) {
      return localBitmap.getHeight();
    }
    return 0;
  }
  
  public int getImageWidth()
  {
    Bitmap localBitmap = this.c;
    if (localBitmap != null) {
      return localBitmap.getWidth();
    }
    return 0;
  }
  
  public Bitmap getLoadedBitmap()
  {
    return this.c;
  }
  
  public float getMaxZoom()
  {
    return this.g;
  }
  
  public float getMinZoom()
  {
    return this.f;
  }
  
  public int getRatioType()
  {
    return this.w;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject;
    if (this.u)
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
    if (this.n)
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        if (this.u) {
          AEQLog.d("AECropperImageView", "drawable is null");
        }
        return;
      }
      float f1;
      if (getResources().getConfiguration().orientation == 2)
      {
        f1 = paramInt3 - paramInt1;
        this.h = (f1 / Math.max(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
        this.i = (f1 / Math.min(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
      }
      else
      {
        f1 = paramInt4 - paramInt2;
        this.h = (f1 / Math.max(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
        this.i = (f1 / Math.min(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
      }
      if (this.l)
      {
        f1 = this.h;
        float f2 = this.g;
        if (f1 > f2)
        {
          this.h = f2;
          this.i = f2;
          if (this.f > f2)
          {
            AEQLog.d("AECropperImageView", "min zoom is greater than max zoom. Changing min zoom = max zoom");
            a(this.g);
          }
        }
      }
      if ((this.f <= 0.0F) || (!this.m)) {
        a(this.h);
      }
      this.n = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = getContext().getResources().getConfiguration().orientation;
    if ((i1 != 1) && (i1 != 0))
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
    if (this.r)
    {
      AEQLog.a("AECropperImageView", "onTouchEvent(isAdjusting) - Can't perform this action right now.");
      return true;
    }
    if (this.s)
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
      localObject = this.p;
      if (localObject != null) {
        ((AECropperImageView.GestureCallback)localObject).a();
      }
    }
    this.b.onTouchEvent(paramMotionEvent);
    if (!this.b.isInProgress()) {
      this.a.onTouchEvent(paramMotionEvent);
    }
    int i1 = paramMotionEvent.getAction();
    if ((i1 != 1) && (i1 != 3)) {
      return true;
    }
    AEQLog.a("AECropperImageView", "onTouchEvent(MotionEvent.ACTION_UP)");
    paramMotionEvent = this.p;
    if (paramMotionEvent != null) {
      paramMotionEvent.b();
    }
    return f();
  }
  
  public void setDEBUG(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setGestureCallback(AECropperImageView.GestureCallback paramGestureCallback)
  {
    this.p = paramGestureCallback;
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.s)
    {
      AEQLog.d("AECropperImageView", "Cropping current bitmap. Can't set bitmap now");
      return;
    }
    this.n = true;
    if (paramBitmap == null)
    {
      this.c = null;
      super.setImageBitmap(null);
      return;
    }
    if ((paramBitmap.getHeight() > 1280) || ((paramBitmap.getWidth() > 1280) && (this.u))) {
      AEQLog.c("AECropperImageView", "Bitmap size greater than 1280. This might cause memory issues");
    }
    this.c = paramBitmap;
    setMinZoom(a(this.c.getWidth(), this.c.getHeight(), getWidth()));
    super.setImageBitmap(paramBitmap);
    if (this.w == 2) {
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
    float f1 = this.f;
    if ((f1 > 0.0F) && (paramFloat < f1))
    {
      AEQLog.d("AECropperImageView", "Max zoom must be greater than min zoom");
      return;
    }
    this.g = paramFloat;
    this.l = true;
  }
  
  public void setMinZoom(float paramFloat)
  {
    if (a(paramFloat)) {
      this.m = true;
    }
  }
  
  public void setShowAnimation(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperImageView
 * JD-Core Version:    0.7.0.1
 */