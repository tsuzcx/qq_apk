package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextScrollerListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class VoiceTextEditScrollerView
  extends RelativeLayout
{
  private int a;
  private VelocityTracker b;
  private Context c;
  private float d;
  private float e;
  private int f;
  private float g;
  private float h;
  private float i;
  private float j;
  private boolean k = false;
  private float l;
  private boolean m = false;
  private int n = -1;
  private int o = -1;
  private int p = -1;
  private boolean q = true;
  private boolean r = false;
  private VoiceTextScrollerListener s;
  
  public VoiceTextEditScrollerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VoiceTextEditScrollerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VoiceTextEditScrollerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    paramContext = ViewConfiguration.get(this.c);
    this.a = paramContext.getScaledMaximumFlingVelocity();
    this.d = (paramContext.getScaledTouchSlop() * 2);
    this.e = (this.d * 3.0F);
    paramContext = (WindowManager)this.c.getSystemService("window");
    paramAttributeSet = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(paramAttributeSet);
    this.b = VelocityTracker.obtain();
  }
  
  private float a(float paramFloat)
  {
    return paramFloat - this.i;
  }
  
  private void a()
  {
    this.b.computeCurrentVelocity(1000, this.a);
    this.g = this.b.getYVelocity();
  }
  
  private void a(int paramInt)
  {
    VoiceTextScrollerListener localVoiceTextScrollerListener = this.s;
    if (localVoiceTextScrollerListener != null)
    {
      int i1 = localVoiceTextScrollerListener.d();
      int i2 = getHeight();
      int i3 = getHeight();
      this.s.a(this.f - i1 - paramInt, i2 - i1, i3);
    }
    b();
  }
  
  private void a(ValueAnimator paramValueAnimator, int paramInt1, int paramInt2, View paramView)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = paramValueAnimator.getAnimatedFraction();
    int i1 = View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824);
    paramInt1 = (int)(paramInt1 - f2 * paramInt2);
    paramView.measure(i1, View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    paramInt2 = getLeft();
    i1 = (int)f1;
    paramView.layout(paramInt2, i1, getRight(), paramInt1 + i1);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    this.q = true;
    this.h = paramMotionEvent.getRawX();
    float f1 = paramMotionEvent.getRawY();
    this.i = f1;
    this.l = f1;
    this.j = -1.0F;
    this.m = false;
    d(paramMotionEvent);
    paramMotionEvent = this.s;
    if (paramMotionEvent != null) {
      paramMotionEvent.a(this.f);
    }
  }
  
  private void b()
  {
    if (!this.m)
    {
      if (this.r)
      {
        this.r = false;
        ReportUtils.a("0X800A8A0", 3, 0);
        return;
      }
      ReportUtils.a("0X800A8A0", 2, 0);
      return;
    }
    ReportUtils.a("0X800A8A0", 1, 0);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f1 = Math.abs(paramMotionEvent.getRawX() - this.h);
    float f2 = Math.abs(paramMotionEvent.getRawY() - this.i);
    float f3 = this.d;
    if ((f1 <= f3) && (f2 <= f3)) {
      return;
    }
    this.m = true;
    if (f2 > this.e) {
      c();
    }
    int i1 = (int)(paramMotionEvent.getRawY() - this.l);
    int i2 = getTop() + i1;
    int i3 = getBottom();
    if (i2 < this.p) {
      return;
    }
    VoiceTextScrollerListener localVoiceTextScrollerListener = this.s;
    if ((localVoiceTextScrollerListener != null) && (i2 >= this.f - localVoiceTextScrollerListener.d() - this.n)) {
      return;
    }
    setTop(i2);
    setBottom(i3 + i1);
    this.j = this.g;
    this.l = paramMotionEvent.getRawY();
  }
  
  private boolean b(float paramFloat)
  {
    paramFloat = a(paramFloat);
    return (this.j > 2000.0F) || (paramFloat > ScreenUtil.dip2px(150.0F)) || (!this.m);
  }
  
  private void c()
  {
    if (this.q)
    {
      VoiceTextScrollerListener localVoiceTextScrollerListener = this.s;
      if (localVoiceTextScrollerListener != null) {
        localVoiceTextScrollerListener.a();
      }
      this.q = false;
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (this.s != null)
    {
      c();
      if (b(paramMotionEvent.getRawY()))
      {
        a(this.n);
        return;
      }
      int i1 = this.o;
      int i2 = this.n;
      this.s.a(i1 - i2, i2);
    }
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    this.b.addMovement(paramMotionEvent);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, View paramView)
  {
    ValueAnimator localValueAnimator = ObjectAnimator.ofFloat(new float[] { paramInt1, paramInt2 }).setDuration(paramInt6);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new VoiceTextEditScrollerView.1(this, paramInt4, paramInt3, paramView));
    localValueAnimator.start();
    localValueAnimator.addListener(new VoiceTextEditScrollerView.2(this, paramInt5));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int getMaxHeight()
  {
    return this.f;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.k) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label57;
          }
        }
        else
        {
          d(paramMotionEvent);
          a();
          b(paramMotionEvent);
          break label57;
        }
      }
      c(paramMotionEvent);
    }
    else
    {
      a(paramMotionEvent);
    }
    label57:
    return this.k;
  }
  
  public void setListener(VoiceTextScrollerListener paramVoiceTextScrollerListener)
  {
    this.s = paramVoiceTextScrollerListener;
  }
  
  public void setMaskClick(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setPanelActionDownPos(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.o = paramInt2;
    this.p = getTop();
  }
  
  public void setSlideEnable(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextEditScrollerView
 * JD-Core Version:    0.7.0.1
 */