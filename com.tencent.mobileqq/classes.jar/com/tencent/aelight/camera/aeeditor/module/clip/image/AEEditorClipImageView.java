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

public class AEEditorClipImageView
  extends ImageView
{
  private static final String e = "AEEditorClipImageView";
  private int A;
  private AEEditorClipContainer B;
  protected GestureDetector a;
  protected ScaleGestureDetector b;
  public Bitmap c;
  Animator.AnimatorListener d = null;
  private float[] f = new float[9];
  private float g = 0.0F;
  private float h = 0.0F;
  private float i = 0.0F;
  private float j = 0.0F;
  private float k;
  private float l;
  private boolean m = false;
  private boolean n = false;
  private boolean o = true;
  private boolean p = true;
  private AEEditorClipImageView.GestureCallback q;
  private boolean r = true;
  private boolean s = false;
  private boolean t = false;
  private int u = -1;
  private boolean v = false;
  private boolean w = true;
  private int x = 0;
  private AEEditorImageInfo y;
  private int z;
  
  public AEEditorClipImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AEEditorClipImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public AEEditorClipImageView(Context paramContext, AttributeSet paramAttributeSet, AEEditorClipContainer paramAEEditorClipContainer)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    this.B = paramAEEditorClipContainer;
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
    paramMatrix.getValues(this.f);
    return this.f[paramInt];
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new AEEditorClipImageView.1(this, paramFloat6, paramFloat5, paramFloat2, paramFloat1, paramFloat4, paramFloat3));
    localValueAnimator.addListener(new AEEditorClipImageView.2(this));
    localValueAnimator.start();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.d);
      if (paramAttributeSet != null)
      {
        this.u = paramAttributeSet.getColor(2, this.u);
        this.p = paramAttributeSet.getBoolean(0, true);
        paramAttributeSet.recycle();
      }
    }
    this.a = new GestureDetector(paramContext, new AEEditorClipImageView.GestureListener(this, null), null, true);
    this.b = new ScaleGestureDetector(paramContext, new AEEditorClipImageView.ScaleListener(this, null));
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (this.v) {
        AEQLog.d(e, "Drawable is null. I can't fit anything");
      }
      return;
    }
    if ((this.z != 0) && (this.A != 0))
    {
      int i1 = paramDrawable.getIntrinsicWidth();
      int i2 = paramDrawable.getIntrinsicHeight();
      float f1 = a(i1, i2, this.z, this.A);
      paramDrawable = new Matrix();
      paramDrawable.setScale(f1, f1);
      paramDrawable.postTranslate((this.z - i1 * f1) / 2.0F, (this.A - i2 * f1) / 2.0F);
      setImageMatrix(paramDrawable);
      return;
    }
    if (this.v) {
      AEQLog.d(e, "VideoFrame Dimension is 0. I'm quite boggled by it.");
    }
  }
  
  private boolean a(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      AEQLog.d(e, "Min zoom must be greater than 0");
      return false;
    }
    if ((this.m) && (paramFloat > this.h))
    {
      AEQLog.d(e, "Min zoom must not be greater than max zoom");
      this.h = paramFloat;
    }
    this.n = false;
    this.g = paramFloat;
    return true;
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = getImageMatrix();
    float f1 = a(localMatrix, 2);
    float f2 = a(localMatrix, 5);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new AEEditorClipImageView.3(this, localMatrix, paramFloat1, f1, paramFloat2, f2));
    localValueAnimator.addListener(new AEEditorClipImageView.4(this));
    localValueAnimator.start();
  }
  
  private boolean e()
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
    if (f5 != 0.0F)
    {
      if (f1 == 0.0F) {
        return false;
      }
      Rect localRect = this.B.c.getCropRect();
      if (localRect == null) {
        localRect = new Rect(0, 0, this.z, this.A);
      } else {
        localRect = a(localRect);
      }
      if (f4 >= localRect.top) {
        f1 = localRect.top;
      } else if (localDrawable.getIntrinsicHeight() * f1 + f4 <= localRect.bottom) {
        f1 = localRect.bottom - f1 * localDrawable.getIntrinsicHeight();
      } else {
        f1 = f4;
      }
      float f2;
      if (f3 >= localRect.left) {
        f2 = localRect.left;
      } else if (localDrawable.getIntrinsicWidth() * f5 + f3 <= localRect.right) {
        f2 = localRect.right - localDrawable.getIntrinsicWidth() * f5;
      } else {
        f2 = f3;
      }
      if (b())
      {
        localMatrix.reset();
        localMatrix.postScale(f5, f5);
        localMatrix.postTranslate(f3, f4);
        setImageMatrix(localMatrix);
        b(f2 - f3, f1 - f4);
        return false;
      }
      localMatrix.reset();
      localMatrix.postScale(f5, f5);
      localMatrix.postTranslate(f2, f1);
      setImageMatrix(localMatrix);
      invalidate();
    }
    return false;
  }
  
  private float getCropScale()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return 1.0F;
    }
    int i1 = ((Bitmap)localObject).getWidth();
    int i2 = this.c.getHeight();
    localObject = this.B.c.a();
    if (localObject == null) {
      return a(i1, i2, this.z, this.A);
    }
    float f1 = i1;
    float f2 = i2;
    if (f1 * 1.0F / f2 <= (((Rect)localObject).right - ((Rect)localObject).left) * 1.0F / (((Rect)localObject).bottom - ((Rect)localObject).top)) {
      return (((Rect)localObject).right - ((Rect)localObject).left) * 1.0F / f1;
    }
    return (((Rect)localObject).bottom - ((Rect)localObject).top) * 1.0F / f2;
  }
  
  public Rect a(Rect paramRect)
  {
    Rect localRect = new Rect();
    paramRect.left -= AEEditorClipContainer.a;
    paramRect.right -= AEEditorClipContainer.a;
    paramRect.top -= AEEditorClipContainer.a;
    paramRect.bottom -= AEEditorClipContainer.a;
    return localRect;
  }
  
  public void a()
  {
    if (this.t)
    {
      AEQLog.d(e, "Cropping current bitmap. Can't perform this action right now.");
      return;
    }
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      a(localDrawable);
      return;
    }
    a(false);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat2 -= AEEditorClipContainer.a;
    paramFloat3 -= AEEditorClipContainer.a;
    Matrix localMatrix = getImageMatrix();
    float f1 = a(localMatrix, 2);
    float f2 = a(localMatrix, 5);
    float f3 = a(localMatrix, 0);
    a(f1, paramFloat2 - (paramFloat2 - f1) * paramFloat1, f2, paramFloat3 - (paramFloat3 - f2) * paramFloat1, f3, f3 * paramFloat1);
  }
  
  public void a(int paramInt)
  {
    this.x = paramInt;
    a(true);
  }
  
  public void a(AEEditorImageInfo paramAEEditorImageInfo, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    this.y = paramAEEditorImageInfo;
    this.z = paramInt1;
    this.A = paramInt2;
    setImageBitmap(paramBitmap);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = getImageMatrix();
    localMatrix.postTranslate(-paramFloat1, -paramFloat2);
    setImageMatrix(localMatrix);
    invalidate();
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return false;
    }
    Matrix localMatrix = getImageMatrix();
    float f3 = a(localMatrix, 2);
    float f4 = a(localMatrix, 5);
    float f1 = a(localMatrix, 4);
    float f5 = a(localMatrix, 0);
    if (f5 != 0.0F)
    {
      if (f1 == 0.0F) {
        return false;
      }
      Rect localRect = this.B.c.a();
      if (localRect == null)
      {
        a();
        return true;
      }
      localRect = a(localRect);
      this.g = getCropScale();
      if (this.v)
      {
        String str = e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUp( tx = ");
        localStringBuilder.append(f3);
        localStringBuilder.append(", ty = ");
        localStringBuilder.append(f4);
        localStringBuilder.append(")");
        AEQLog.a(str, localStringBuilder.toString());
        str = e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUp() - scale: ");
        localStringBuilder.append(f5);
        AEQLog.a(str, localStringBuilder.toString());
        str = e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUp() - min, max, base zoom: ");
        localStringBuilder.append(this.g);
        localStringBuilder.append(", ");
        localStringBuilder.append(this.h);
        localStringBuilder.append(", ");
        localStringBuilder.append(this.i);
        AEQLog.a(str, localStringBuilder.toString());
        str = e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUp() - imageview size: ");
        localStringBuilder.append(this.z);
        localStringBuilder.append(" ");
        localStringBuilder.append(this.A);
        AEQLog.a(str, localStringBuilder.toString());
        str = e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUp() - drawable size: ");
        localStringBuilder.append(localDrawable.getIntrinsicWidth());
        localStringBuilder.append(" ");
        localStringBuilder.append(localDrawable.getIntrinsicHeight());
        AEQLog.a(str, localStringBuilder.toString());
        str = e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUp() - scaled drawable size: ");
        localStringBuilder.append(localDrawable.getIntrinsicWidth() * f5);
        localStringBuilder.append(" ");
        localStringBuilder.append(localDrawable.getIntrinsicHeight() * f1);
        AEQLog.a(str, localStringBuilder.toString());
        str = e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUp() - h diff: ");
        localStringBuilder.append(localDrawable.getIntrinsicHeight() * f1 + f4 - getHeight());
        AEQLog.a(str, localStringBuilder.toString());
      }
      if (!paramBoolean)
      {
        f1 = (this.A - this.g * localDrawable.getIntrinsicHeight()) / 2.0F;
        f2 = (this.z - this.g * localDrawable.getIntrinsicWidth()) / 2.0F;
        localMatrix.reset();
        f3 = this.g;
        localMatrix.postScale(f3, f3);
        localMatrix.postTranslate(f2, f1);
        setImageMatrix(localMatrix);
        invalidate();
        return true;
      }
      float f2 = this.g;
      if (f5 >= f2)
      {
        if (f4 > localRect.top) {
          f1 = localRect.top;
        } else if (f4 < localRect.bottom - localDrawable.getIntrinsicHeight() * f5) {
          f1 = localRect.bottom - localDrawable.getIntrinsicHeight() * f5;
        } else {
          f1 = f4;
        }
        if (f3 > localRect.left) {
          f2 = localRect.left;
        } else if (f3 < localRect.right - localDrawable.getIntrinsicWidth() * f5) {
          f2 = localRect.right - f5 * localDrawable.getIntrinsicWidth();
        } else {
          f2 = f3;
        }
        b(f2 - f3, f1 - f4);
        return true;
      }
      if (f5 < f2)
      {
        if (f4 > localRect.top) {
          f1 = localRect.top;
        }
        for (;;)
        {
          break;
          if (f1 * localDrawable.getIntrinsicHeight() + f4 <= localRect.bottom) {
            f1 = localRect.bottom - this.g * localDrawable.getIntrinsicHeight();
          } else {
            f1 = (f4 - (localRect.bottom + localRect.top) / 2) * this.g / f5 + (localRect.bottom + localRect.top) / 2;
          }
        }
        if (f3 >= localRect.left) {
          f2 = localRect.left;
        }
        for (;;)
        {
          break;
          if (localDrawable.getIntrinsicWidth() * f5 + f3 <= localRect.right) {
            f2 = localRect.right - this.g * localDrawable.getIntrinsicWidth();
          } else {
            f2 = (f3 - (localRect.right + localRect.left) / 2) * this.g / f5 + (localRect.right + localRect.left) / 2;
          }
        }
        a(f3, f2, f4, f1, f5, this.g);
      }
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return this.r;
  }
  
  public void c()
  {
    if (this.t)
    {
      AEQLog.d(e, "Cropping current bitmap. Can't perform this action right now.");
      return;
    }
    setImageBitmap(null);
    Bitmap localBitmap = this.c;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
  
  public float getCropCenterZoom()
  {
    if (this.c != null) {
      return getCropScale();
    }
    return 0.0F;
  }
  
  public Rect getImageBounds()
  {
    if (this.c == null) {
      return null;
    }
    Matrix localMatrix = getImageMatrix();
    float f1 = a(localMatrix, 2);
    float f2 = a(localMatrix, 5);
    float f3 = a(localMatrix, 4);
    int i1 = (int)f1;
    int i2 = (int)(this.c.getWidth() * f3 + f1);
    return new Rect(i1, (int)f2, i2, (int)(this.c.getHeight() * f3 + f2));
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
  
  public float getMaxZoom()
  {
    return this.h;
  }
  
  public float getMinZoom()
  {
    return this.g;
  }
  
  public int getRatioType()
  {
    return this.x;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject;
    if (this.v)
    {
      localObject = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayout: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("]");
      AEQLog.a((String)localObject, localStringBuilder.toString());
    }
    if (this.o)
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        if (this.v) {
          AEQLog.d(e, "drawable is null");
        }
        return;
      }
      float f1;
      if (getResources().getConfiguration().orientation == 2)
      {
        f1 = paramInt3 - paramInt1;
        this.i = (f1 / Math.max(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
        this.j = (f1 / Math.min(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
      }
      else
      {
        f1 = paramInt4 - paramInt2;
        this.i = (f1 / Math.max(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
        this.j = (f1 / Math.min(((Drawable)localObject).getIntrinsicHeight(), ((Drawable)localObject).getIntrinsicWidth()));
      }
      if (this.m)
      {
        f1 = this.i;
        float f2 = this.h;
        if (f1 > f2)
        {
          this.i = f2;
          this.j = f2;
          if (this.g > f2)
          {
            AEQLog.d(e, "min zoom is greater than max zoom. Changing min zoom = max zoom");
            a(this.h);
          }
        }
      }
      if ((this.g <= 0.0F) || (!this.n)) {
        a(this.i);
      }
      this.o = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.x == 0) {
      return true;
    }
    if (this.s)
    {
      AEQLog.a(e, "onTouchEvent(isAdjusting) - Can't perform this action right now.");
      return true;
    }
    if (this.t)
    {
      AEQLog.a(e, "onTouchEvent(isCropping) - Can't perform this action right now.");
      return true;
    }
    Object localObject = e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTouchEvent(");
    localStringBuilder.append(paramMotionEvent.getActionMasked());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramMotionEvent.getAction());
    localStringBuilder.append(")");
    AEQLog.a((String)localObject, localStringBuilder.toString());
    getParent().requestDisallowInterceptTouchEvent(true);
    if (paramMotionEvent.getActionMasked() == 0)
    {
      AEQLog.a(e, "onTouchEvent(MotionEvent.ACTION_DOWN)");
      localObject = this.q;
      if (localObject != null) {
        ((AEEditorClipImageView.GestureCallback)localObject).a();
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
    AEQLog.a(e, "onTouchEvent(MotionEvent.ACTION_UP)");
    paramMotionEvent = this.q;
    if (paramMotionEvent != null) {
      paramMotionEvent.b();
    }
    return a(true);
  }
  
  public void setAEEditorImageInfo(AEEditorImageInfo paramAEEditorImageInfo)
  {
    this.y = paramAEEditorImageInfo;
  }
  
  public void setDEBUG(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setGestureCallback(AEEditorClipImageView.GestureCallback paramGestureCallback)
  {
    this.q = paramGestureCallback;
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.t)
    {
      AEQLog.d(e, "Cropping current bitmap. Can't set bitmap now");
      return;
    }
    this.o = true;
    if (paramBitmap == null)
    {
      this.c = null;
      super.setImageBitmap(null);
      return;
    }
    if ((paramBitmap.getHeight() > 1280) || ((paramBitmap.getWidth() > 1280) && (this.v))) {
      AEQLog.c(e, "Bitmap size greater than 1280. This might cause memory issues");
    }
    this.c = paramBitmap;
    super.setImageBitmap(paramBitmap);
    this.x = this.y.e;
    if (this.y.a() != null) {
      setImageMatrix(this.y.a());
    } else if (this.x == 0) {
      a();
    } else {
      a(false);
    }
    requestLayout();
  }
  
  public void setMaxZoom(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      AEQLog.d(e, "Max zoom must be greater than 0");
      return;
    }
    float f1 = this.g;
    if ((f1 > 0.0F) && (paramFloat < f1))
    {
      AEQLog.d(e, "Max zoom must be greater than min zoom");
      return;
    }
    this.h = paramFloat;
    this.m = true;
  }
  
  public void setMinZoom(float paramFloat)
  {
    if (a(paramFloat)) {
      this.n = true;
    }
  }
  
  public void setShowAnimation(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipImageView
 * JD-Core Version:    0.7.0.1
 */