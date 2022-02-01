package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PickerContainer
  extends RelativeLayout
  implements PickerBarLayout.PickerBarLayoutListener
{
  public static final String a = HardCodeUtil.a(2131905951);
  public float b = 333.60001F;
  public float c = 333.60001F;
  Property<PickerContainer, Float> d = new PickerContainer.1(this, Float.class, "containerAlpha");
  private float e = 200.0F;
  private float f = 497.0F;
  private int g = 58;
  private View h;
  private ContainerDrawable i;
  private PickerBarLayout j;
  private ImageView k;
  private HintDrawable l;
  private Handler m = new Handler(Looper.getMainLooper());
  private Float n = Float.valueOf(1.0F);
  private boolean o = false;
  private WeakReference<PickerContainer.PickerContainerListener> p;
  private ValueAnimator q;
  private boolean r = false;
  
  public PickerContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PickerContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PickerContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static float a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    return paramFloat * paramResources.getDisplayMetrics().density;
  }
  
  public static float a(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return paramFloat;
    }
    return a(paramFloat / 2.0F, paramContext.getResources());
  }
  
  private void a(Context paramContext)
  {
    this.e = a(paramContext, this.e);
    this.b = a(paramContext, this.b);
    this.c = a(paramContext, this.c);
    this.f = a(paramContext, this.f);
    this.g = AIOUtils.b(this.g, paramContext.getResources());
  }
  
  private void b()
  {
    if (!this.o) {
      return;
    }
    ValueAnimator localValueAnimator = this.q;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.q.removeAllUpdateListeners();
      this.q = null;
    }
    this.o = false;
  }
  
  private void b(boolean paramBoolean, long paramLong)
  {
    ValueAnimator localValueAnimator = this.q;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.q.removeAllUpdateListeners();
      this.q = null;
    }
    float f1 = 1.0F;
    if (!paramBoolean) {
      f1 = 0.0F;
    }
    this.q = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.d, new float[] { this.n.floatValue(), f1 }) });
    this.q.setDuration(paramLong);
    localValueAnimator = this.q;
    if (localValueAnimator != null)
    {
      localValueAnimator.setRepeatMode(1);
      this.q.setRepeatCount(0);
      this.q.setStartDelay(0L);
      this.q.addUpdateListener(new PickerContainer.2(this));
      this.q.addListener(new PickerContainer.3(this));
      this.q.start();
    }
  }
  
  private Float getContainerAlpha()
  {
    return this.n;
  }
  
  private void setContainerAlpha(Float paramFloat)
  {
    this.n = paramFloat;
  }
  
  public void a()
  {
    this.p = null;
    Object localObject = this.l;
    if (localObject != null)
    {
      ((HintDrawable)localObject).a();
      this.l = null;
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((ContainerDrawable)localObject).a();
      this.i = null;
    }
    this.h = null;
    localObject = this.j;
    if (localObject != null) {
      ((PickerBarLayout)localObject).a();
    }
    this.k = null;
    localObject = this.m;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.q;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.q.removeAllUpdateListeners();
      this.q = null;
    }
    this.d = null;
  }
  
  public void a(int paramInt)
  {
    ContainerDrawable localContainerDrawable;
    if (paramInt == 1)
    {
      localContainerDrawable = this.i;
      if (localContainerDrawable != null)
      {
        localContainerDrawable.stop();
        this.i.a(false);
        this.i.a(1);
        this.i.start();
      }
    }
    else
    {
      if (paramInt == 4) {
        return;
      }
      localContainerDrawable = this.i;
      if (localContainerDrawable != null)
      {
        localContainerDrawable.stop();
        this.i.a(false);
        this.i.a(2);
        this.i.start();
      }
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelected: index:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" text:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" bstart:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" bend:");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("PickerContainer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (PickerContainer.PickerContainerListener)this.p.get();
    if (localObject != null) {
      if (paramBoolean1)
      {
        this.r = true;
        ((PickerContainer.PickerContainerListener)localObject).a(paramInt, paramString);
      }
      else if (paramBoolean2)
      {
        this.r = false;
        ((PickerContainer.PickerContainerListener)localObject).c(paramInt, paramString);
      }
      else
      {
        ((PickerContainer.PickerContainerListener)localObject).b(paramInt, paramString);
      }
    }
    this.m.removeCallbacksAndMessages(null);
    this.m.postDelayed(new PickerContainer.4(this, paramString), 300L);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    PickerBarLayout localPickerBarLayout = this.j;
    if (localPickerBarLayout != null) {
      localPickerBarLayout.a(paramInt, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (this.o) {
      b();
    }
    if (paramLong > 0L)
    {
      setVisibility(0);
      b(paramBoolean, paramLong);
      return;
    }
    setAlpha(1.0F);
    if (paramBoolean)
    {
      setVisibility(0);
      return;
    }
    setVisibility(8);
  }
  
  public boolean a(EditVideoParams paramEditVideoParams, PickerContainer.PickerContainerListener paramPickerContainerListener)
  {
    this.p = new WeakReference(paramPickerContainerListener);
    a(getContext());
    this.h = new View(getContext());
    paramPickerContainerListener = new RelativeLayout.LayoutParams(-1, -1);
    this.i = new ContainerDrawable();
    this.i.a(getContext());
    this.h.setBackground(this.i);
    addView(this.h, paramPickerContainerListener);
    paramPickerContainerListener = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.bottomMargin = this.g;
    addView(paramPickerContainerListener, localLayoutParams);
    this.j = new PickerBarLayout(getContext());
    this.j.a(paramEditVideoParams, getContext(), this);
    this.f = (this.j.getMarkSize() * 60 + 80 + this.j.getMarkSize() * 5 + 22 + 70);
    this.f = a(getContext(), this.f);
    paramEditVideoParams = new RelativeLayout.LayoutParams((int)this.e, (int)this.f);
    paramEditVideoParams.addRule(11);
    paramEditVideoParams.addRule(15);
    paramPickerContainerListener.addView(this.j, paramEditVideoParams);
    this.k = new ImageView(getContext());
    paramEditVideoParams = new RelativeLayout.LayoutParams((int)this.b, (int)this.c);
    paramEditVideoParams.addRule(13);
    this.l = new HintDrawable();
    this.l.a(getContext(), this.b, this.c, 1.2F);
    this.k.setBackground(this.l);
    paramPickerContainerListener.addView(this.k, paramEditVideoParams);
    return true;
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if (paramInt == 4)
    {
      this.m.removeCallbacksAndMessages(null);
      HintDrawable localHintDrawable = this.l;
      if (localHintDrawable != null)
      {
        localHintDrawable.stop();
        if ((this.l.b() == 1) || (this.l.b() == 3))
        {
          this.l.a(2);
          this.l.start();
        }
      }
    }
  }
  
  public void d(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer
 * JD-Core Version:    0.7.0.1
 */