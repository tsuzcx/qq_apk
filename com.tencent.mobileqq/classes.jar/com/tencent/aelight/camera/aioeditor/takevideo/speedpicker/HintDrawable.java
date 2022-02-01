package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;

public class HintDrawable
  extends Drawable
  implements Animatable
{
  Property<HintDrawable, Float> a = new HintDrawable.1(this, Float.class, "backScale");
  Property<HintDrawable, Integer> b = new HintDrawable.2(this, Integer.class, "backAlpha");
  private Rect c = new Rect();
  private int d = 255;
  private boolean e = false;
  private int f = 0;
  private ValueAnimator g;
  private float h;
  private String i;
  private Drawable j;
  private float k;
  private float l;
  private float m;
  private boolean n = false;
  private Context o;
  
  private void a(float paramFloat)
  {
    this.h = paramFloat;
    int i1 = this.c.centerX();
    int i2 = this.c.centerY();
    float f1 = this.k;
    paramFloat -= 1.0F;
    int i3 = (int)(f1 * paramFloat) / 2;
    float f2 = this.l;
    int i4 = (int)(paramFloat * f2) / 2;
    this.c.set((int)(i1 - i3 - f1 / 2.0F), (int)(i2 - i4 - f2 / 2.0F), (int)(i1 + i3 + f1 / 2.0F), (int)(i2 + i4 + f2 / 2.0F));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = this.g;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.g.removeAllUpdateListeners();
      this.g = null;
    }
    if (paramInt1 == 1)
    {
      this.g = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.a, new float[] { this.m, 1.0F }), PropertyValuesHolder.ofInt(this.b, new int[] { 0, 255 }) });
      this.g.setDuration(paramInt2);
    }
    else if (paramInt1 == 2)
    {
      this.g = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.b, new int[] { 255, 0 }) });
      this.g.setDuration(paramInt2);
    }
    localValueAnimator = this.g;
    if (localValueAnimator != null)
    {
      localValueAnimator.setRepeatMode(1);
      this.g.setRepeatCount(0);
      this.g.setStartDelay(0L);
      this.g.addUpdateListener(new HintDrawable.3(this));
      this.g.addListener(new HintDrawable.4(this));
      this.g.start();
    }
  }
  
  private Drawable b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (this.o == null) {
        return null;
      }
    }
    try
    {
      if ("1/4".equals(paramString)) {
        return this.o.getResources().getDrawable(2130842463);
      }
      if ("1/2".equals(paramString)) {
        return this.o.getResources().getDrawable(2130842462);
      }
      if ("1x".equals(paramString)) {
        return this.o.getResources().getDrawable(2130842464);
      }
      if ("2x".equals(paramString)) {
        return this.o.getResources().getDrawable(2130842465);
      }
      if ("4x".equals(paramString)) {
        return this.o.getResources().getDrawable(2130842466);
      }
      if (!PickerContainer.a.equals(paramString)) {
        break label200;
      }
      paramString = this.o.getResources().getDrawable(2130842467);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDrawableByText exception:");
      localStringBuilder.append(paramString.toString());
      QLog.e("HintDrawable", 2, localStringBuilder.toString());
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      label151:
      break label151;
    }
    QLog.e("HintDrawable", 2, "getDrawableByText OOM!!");
    return null;
  }
  
  private void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  private float c()
  {
    return this.h;
  }
  
  private int d()
  {
    return this.d;
  }
  
  public void a()
  {
    this.e = false;
    this.o = null;
    this.j = null;
    ValueAnimator localValueAnimator = this.g;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.g.removeAllUpdateListeners();
      this.g = null;
    }
    this.a = null;
    this.b = null;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public boolean a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramContext == null) {
      return false;
    }
    this.k = paramFloat1;
    this.l = paramFloat2;
    this.m = paramFloat3;
    this.o = paramContext;
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.equals(this.i)) {
      return false;
    }
    this.i = paramString;
    this.j = b(paramString);
    invalidateSelf();
    return true;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.f == 0) {
      return;
    }
    Drawable localDrawable = this.j;
    if (localDrawable != null)
    {
      localDrawable.setAlpha(this.d);
      this.j.setBounds(this.c);
      this.j.draw(paramCanvas);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.e;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.c.set(paramRect);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void start()
  {
    if (isRunning()) {
      stop();
    }
    this.e = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start :");
      localStringBuilder.append(this.f);
      QLog.d("HintDrawable", 2, localStringBuilder.toString());
    }
    a(this.f, 150);
  }
  
  public void stop()
  {
    if (!this.e) {
      return;
    }
    this.e = false;
    ValueAnimator localValueAnimator = this.g;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.g.removeAllUpdateListeners();
      this.g = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.HintDrawable
 * JD-Core Version:    0.7.0.1
 */