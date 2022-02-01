package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkDrawable
  extends Drawable
  implements Animatable
{
  private Map<String, Drawable> A = new HashMap();
  private List<Integer> B = new ArrayList();
  private WeakReference<MarkDrawable.MarkDrawableListener> C;
  Property<MarkDrawable, Integer> a = new MarkDrawable.1(this, Integer.class, "bfIndex");
  Property<MarkDrawable, Integer> b = new MarkDrawable.2(this, Integer.class, "textAlpha");
  Property<MarkDrawable, Float> c = new MarkDrawable.3(this, Float.class, "textPos");
  private AnimationDrawable d;
  private AnimationDrawable e;
  private AnimationDrawable f;
  private int g;
  private String h;
  private Drawable i;
  private Drawable j;
  private Paint k = new Paint();
  private float l = 68.0F;
  private float m = 68.0F;
  private float n = 30.0F;
  private float o = 70.0F;
  private float p = 60.0F;
  private float q = 50.0F;
  private float r = 35.0F;
  private float s = 5.0F;
  private RectF t = new RectF();
  private int u = 255;
  private float v = this.s;
  private boolean w = false;
  private int x = 1;
  private ValueAnimator y;
  private Map<String, Drawable> z = new HashMap();
  
  private AnimationDrawable a(Context paramContext, int paramInt)
  {
    paramContext = (AnimationDrawable)paramContext.getResources().getDrawable(paramInt);
    paramContext.setVisible(true, false);
    paramContext.setOneShot(true);
    return paramContext;
  }
  
  private void a(float paramFloat)
  {
    this.v = paramFloat;
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    RectF localRectF = this.t;
    paramFloat4 /= 2.0F;
    localRectF.bottom = (paramFloat2 + paramFloat4);
    localRectF.top = (paramFloat2 - paramFloat4);
    paramFloat2 = paramFloat3 / 2.0F;
    localRectF.right = (paramFloat1 + paramFloat2);
    localRectF.left = (paramFloat1 - paramFloat2);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.y.removeAllUpdateListeners();
      this.y = null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startValueAnimator: state:");
      ((StringBuilder)localObject).append(this.x);
      ((StringBuilder)localObject).append(" mIndex:");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(" mTextAlpha:");
      ((StringBuilder)localObject).append(this.u);
      QLog.d("MarkDrawable", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 2)
    {
      localObject = this.f;
      if (localObject != null)
      {
        this.y = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.a, new int[] { this.g, ((AnimationDrawable)localObject).getNumberOfFrames() }) });
        this.y.setDuration(600L);
      }
    }
    else if (paramInt1 == 4)
    {
      if (this.d != null)
      {
        paramInt1 = d(this.g);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("calcBackIndex return : ");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.d("MarkDrawable", 2, ((StringBuilder)localObject).toString());
        }
        this.y = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.a, new int[] { paramInt1, this.d.getNumberOfFrames() }) });
        this.y.setDuration(400L);
      }
    }
    else if (paramInt1 == 5)
    {
      this.y = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.b, new int[] { this.u, 255 }), PropertyValuesHolder.ofFloat(this.c, new float[] { this.v, 0.0F }) });
      this.y.setDuration(paramInt2);
    }
    else if (paramInt1 == 6)
    {
      this.y = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.b, new int[] { this.u, 0 }) });
      this.y.setDuration(paramInt2);
    }
    localObject = this.y;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).setRepeatMode(1);
      this.y.setRepeatCount(0);
      this.y.setStartDelay(0L);
      this.y.addUpdateListener(new MarkDrawable.4(this));
      this.y.addListener(new MarkDrawable.5(this));
      this.y.start();
    }
  }
  
  private void a(Context paramContext)
  {
    this.l = PickerContainer.a(paramContext, this.l);
    this.m = PickerContainer.a(paramContext, this.m);
    this.n = PickerContainer.a(paramContext, this.n);
    this.o = PickerContainer.a(paramContext, this.o);
    this.p = PickerContainer.a(paramContext, this.p);
    this.q = PickerContainer.a(paramContext, this.q);
    this.r = PickerContainer.a(paramContext, this.r);
    this.s = PickerContainer.a(paramContext, this.s);
    List localList = this.B;
    if ((localList != null) && (localList.size() > 0))
    {
      int i1 = 0;
      while (i1 < this.B.size())
      {
        localList = this.B;
        localList.set(i1, Integer.valueOf((int)PickerContainer.a(paramContext, ((Integer)localList.get(i1)).intValue())));
        i1 += 1;
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    int i1 = this.x;
    if (i1 == 1) {
      return;
    }
    Object localObject;
    if (i1 == 2)
    {
      localObject = this.f;
      if (localObject != null)
      {
        i1 = ((AnimationDrawable)localObject).getNumberOfFrames();
        if (this.g >= i1) {
          this.g = (i1 - 1);
        }
        localObject = this.f.getFrame(this.g);
        if (localObject != null) {
          ((Drawable)localObject).draw(paramCanvas);
        }
      }
    }
    else if (i1 == 3)
    {
      localObject = this.f;
      localObject = ((AnimationDrawable)localObject).getFrame(((AnimationDrawable)localObject).getNumberOfFrames() - 1);
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
    }
    else if (i1 == 4)
    {
      localObject = this.d;
      if (localObject == null) {
        return;
      }
      i1 = ((AnimationDrawable)localObject).getNumberOfFrames();
      if (this.g >= i1) {
        this.g = (i1 - 1);
      }
      localObject = this.d.getFrame(this.g);
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
      localObject = this.e.getFrame(this.g);
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
    }
  }
  
  private void b(float paramFloat)
  {
    a(this.t.centerX(), this.t.centerY(), paramFloat, paramFloat);
  }
  
  private void b(int paramInt)
  {
    this.u = paramInt;
  }
  
  private void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.z.put("1/2", paramContext.getResources().getDrawable(2130842468));
    this.z.put("1/4", paramContext.getResources().getDrawable(2130842469));
    this.z.put("1x", paramContext.getResources().getDrawable(2130842470));
    this.z.put("2x", paramContext.getResources().getDrawable(2130842471));
    this.z.put("4x", paramContext.getResources().getDrawable(2130842472));
    this.z.put(PickerContainer.a, paramContext.getResources().getDrawable(2130842495));
    this.A.put("1/2", paramContext.getResources().getDrawable(2130842512));
    this.A.put("1/4", paramContext.getResources().getDrawable(2130842513));
    this.A.put("1x", paramContext.getResources().getDrawable(2130842514));
    this.A.put("2x", paramContext.getResources().getDrawable(2130842515));
    this.A.put("4x", paramContext.getResources().getDrawable(2130842516));
    this.A.put(PickerContainer.a, paramContext.getResources().getDrawable(2130842517));
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.i == null) {
      return;
    }
    if (this.x == 1) {
      return;
    }
    Rect localRect = new Rect((int)this.t.left, (int)this.t.top, (int)this.t.right, (int)this.t.bottom);
    this.i.setBounds(localRect);
    this.i.setAlpha(this.u);
    this.i.draw(paramCanvas);
  }
  
  private float c()
  {
    return this.v;
  }
  
  private void c(float paramFloat)
  {
    a(getBounds().width() - paramFloat, this.t.centerY(), this.t.width(), this.t.height());
  }
  
  private void c(int paramInt)
  {
    this.g = paramInt;
    paramInt = this.x;
    if (paramInt == 2)
    {
      paramInt = this.g;
      if ((paramInt >= 0) && (paramInt < this.B.size()))
      {
        paramInt = ((Integer)this.B.get(this.g)).intValue();
        c(this.r + paramInt);
        b(this.l);
      }
      paramInt = this.g;
      if (paramInt == 1)
      {
        this.u = 51;
        return;
      }
      if (paramInt == 2)
      {
        this.u = 127;
        return;
      }
      this.u = 255;
      return;
    }
    if (paramInt == 4)
    {
      Object localObject = this.C;
      if ((localObject != null) && (this.d != null))
      {
        localObject = (MarkDrawable.MarkDrawableListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((MarkDrawable.MarkDrawableListener)localObject).a(this.x, this.g, this.d.getNumberOfFrames());
        }
      }
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.h)) {
      return;
    }
    if (this.j == null) {
      return;
    }
    int i1 = this.x;
    if ((i1 != 2) && (i1 != 4))
    {
      if (i1 == 3) {
        return;
      }
      Rect localRect = getBounds();
      i1 = (int)(localRect.right - this.o - this.p);
      float f1 = localRect.centerY();
      float f2 = this.q;
      int i2 = (int)(f1 - f2 / 2.0F);
      localRect = new Rect(i1, i2, (int)(i1 + this.p), (int)(i2 + f2));
      if (this.x == 5) {
        localRect.offset(0, (int)this.v);
      }
      this.j.setBounds(localRect);
      this.j.setAlpha(this.u);
      this.j.draw(paramCanvas);
    }
  }
  
  private int d()
  {
    return this.u;
  }
  
  private int d(int paramInt)
  {
    if (paramInt > this.d.getNumberOfFrames()) {
      return 0;
    }
    return this.d.getNumberOfFrames() - paramInt;
  }
  
  private int e()
  {
    return this.g;
  }
  
  private void e(int paramInt)
  {
    Object localObject = this.C;
    if (localObject == null) {
      return;
    }
    localObject = (MarkDrawable.MarkDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((MarkDrawable.MarkDrawableListener)localObject).e(paramInt);
  }
  
  private void f()
  {
    this.B.add(Integer.valueOf(1000));
    this.B.add(Integer.valueOf(42));
    this.B.add(Integer.valueOf(47));
    this.B.add(Integer.valueOf(54));
    this.B.add(Integer.valueOf(61));
    this.B.add(Integer.valueOf(65));
    this.B.add(Integer.valueOf(67));
    this.B.add(Integer.valueOf(69));
    this.B.add(Integer.valueOf(66));
    List localList = this.B;
    Integer localInteger = Integer.valueOf(64);
    localList.add(localInteger);
    this.B.add(localInteger);
    this.B.add(localInteger);
    this.B.add(localInteger);
    this.B.add(localInteger);
  }
  
  private void f(int paramInt)
  {
    Object localObject = this.C;
    if (localObject == null) {
      return;
    }
    localObject = (MarkDrawable.MarkDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((MarkDrawable.MarkDrawableListener)localObject).d(paramInt);
  }
  
  private void g(int paramInt)
  {
    Object localObject = this.C;
    if (localObject == null) {
      return;
    }
    localObject = (MarkDrawable.MarkDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((MarkDrawable.MarkDrawableListener)localObject).f(paramInt);
  }
  
  public void a()
  {
    this.d = null;
    this.e = null;
    this.f = null;
    this.i = null;
    this.j = null;
    this.w = false;
    ValueAnimator localValueAnimator = this.y;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.y.removeAllUpdateListeners();
      this.y = null;
    }
    this.z.clear();
    this.A.clear();
    this.B.clear();
    this.C = null;
    this.a = null;
    this.b = null;
    this.c = null;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAnimState: old state:");
      localStringBuilder.append(this.x);
      localStringBuilder.append(" new state:");
      localStringBuilder.append(paramInt);
      QLog.d("MarkDrawable", 2, localStringBuilder.toString());
    }
    this.x = paramInt;
    paramInt = this.x;
    if (paramInt != 2)
    {
      if ((paramInt == 3) || (paramInt == 4) || (paramInt == 5)) {}
    }
    else
    {
      this.g = 0;
      b(this.l);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.h = "";
      this.i = null;
      return;
    }
    this.h = paramString;
    this.i = ((Drawable)this.z.get(paramString));
    this.j = ((Drawable)this.A.get(paramString));
    invalidateSelf();
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, MarkDrawable.MarkDrawableListener paramMarkDrawableListener)
  {
    f();
    a(paramContext);
    this.d = a(paramContext, paramInt1);
    this.e = a(paramContext, paramInt2);
    this.f = a(paramContext, paramInt3);
    this.C = new WeakReference(paramMarkDrawableListener);
    b(paramContext);
    this.k.setTextSize(this.n);
    this.k.setColor(16777215);
    this.k.setTextAlign(Paint.Align.LEFT);
    return true;
  }
  
  public int b()
  {
    return this.x;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i1 = this.x;
    if (i1 == 0) {
      return;
    }
    if ((i1 != 2) && (i1 != 4) && (i1 != 3))
    {
      if ((i1 == 5) || (i1 == 1) || (i1 == 6)) {
        c(paramCanvas);
      }
    }
    else
    {
      a(paramCanvas);
      if (this.x != 4) {
        b(paramCanvas);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.w;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBoundsChange: mState:");
      ((StringBuilder)localObject).append(this.x);
      ((StringBuilder)localObject).append(" bound:");
      ((StringBuilder)localObject).append(paramRect);
      QLog.d("MarkDrawable", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.f;
    int i2 = 0;
    int i1;
    if (localObject != null)
    {
      ((AnimationDrawable)localObject).setBounds(paramRect);
      i1 = 0;
      while (i1 < this.f.getNumberOfFrames())
      {
        localObject = this.f.getFrame(i1);
        if (localObject != null) {
          ((Drawable)localObject).setBounds(paramRect);
        }
        i1 += 1;
      }
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((AnimationDrawable)localObject).setBounds(paramRect);
      i1 = 0;
      while (i1 < this.d.getNumberOfFrames())
      {
        localObject = this.d.getFrame(i1);
        if (localObject != null) {
          ((Drawable)localObject).setBounds(paramRect);
        }
        i1 += 1;
      }
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((AnimationDrawable)localObject).setBounds(paramRect);
      i1 = i2;
      while (i1 < this.e.getNumberOfFrames())
      {
        localObject = this.e.getFrame(i1);
        if (localObject != null) {
          ((Drawable)localObject).setBounds(paramRect);
        }
        i1 += 1;
      }
    }
    a(paramRect.centerX(), paramRect.centerY(), this.l, this.m);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void start()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start:");
      localStringBuilder.append(this.x);
      localStringBuilder.append(" isRunning:");
      localStringBuilder.append(this.w);
      QLog.d("MarkDrawable", 2, localStringBuilder.toString());
    }
    if (isRunning()) {
      stop();
    }
    this.w = true;
    int i1 = this.x;
    if ((i1 != 2) && (i1 != 1))
    {
      if ((i1 != 4) && (i1 != 3))
      {
        if ((i1 == 5) || (i1 == 6)) {
          a(this.x, 200);
        }
      }
      else
      {
        this.x = 4;
        a(this.x, 400);
      }
    }
    else
    {
      this.x = 2;
      a(this.x, 600);
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stop:");
      ((StringBuilder)localObject).append(this.x);
      ((StringBuilder)localObject).append(" isRunning:");
      ((StringBuilder)localObject).append(this.w);
      QLog.d("MarkDrawable", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.w) {
      return;
    }
    this.w = false;
    Object localObject = this.y;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.y.removeAllUpdateListeners();
      this.y = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.MarkDrawable
 * JD-Core Version:    0.7.0.1
 */