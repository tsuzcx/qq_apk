package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class PickerBarLayout
  extends RelativeLayout
  implements GroundDrawable.GroundDrawableListener, MarkDrawable.MarkDrawableListener
{
  boolean a;
  private float b = 38.0F;
  private float c = 50.0F;
  private float d = 18.0F;
  private float e = 146.0F;
  private float f = 102.0F;
  private float g = 22.0F;
  private float h = 22.0F;
  private float i = 4.0F;
  private float j = 36.0F;
  private List<String> k = new ArrayList();
  private View l;
  private MarkDrawable m;
  private View n;
  private GroundDrawable o;
  private int p = -1;
  private WeakReference<PickerBarLayout.PickerBarLayoutListener> q;
  private float r;
  private int s;
  private PickerBarLayout.CheckForLongPress t;
  
  public PickerBarLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public PickerBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PickerBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt >= 0) && (paramInt < this.k.size()))
    {
      Object localObject = this.q;
      if (localObject != null)
      {
        localObject = (PickerBarLayout.PickerBarLayoutListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((PickerBarLayout.PickerBarLayoutListener)localObject).a(paramInt, (String)this.k.get(paramInt), paramBoolean1, paramBoolean2);
        }
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.b = PickerContainer.a(paramContext, this.b);
    this.c = PickerContainer.a(paramContext, this.c);
    this.d = PickerContainer.a(paramContext, this.d);
    this.e = PickerContainer.a(paramContext, this.e);
    this.f = PickerContainer.a(paramContext, this.f);
    this.i = PickerContainer.a(paramContext, this.i);
    this.g = PickerContainer.a(paramContext, this.g);
    this.h = PickerContainer.a(paramContext, this.h);
    this.j = PickerContainer.a(paramContext, this.j);
  }
  
  private void b()
  {
    this.l = new View(getContext());
    this.m = new MarkDrawable();
    this.m.a(getContext(), 2130840069, 2130840068, 2130840070, this);
    this.l.setBackground(this.m);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Math.round(this.e), Math.round(this.f));
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, 0, Math.round(this.i), 0);
    addView(this.l, localLayoutParams);
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      localObject = (PickerBarLayout.PickerBarLayoutListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (paramBoolean1)
        {
          if (paramBoolean2)
          {
            ((PickerBarLayout.PickerBarLayoutListener)localObject).a(paramInt);
            return;
          }
          ((PickerBarLayout.PickerBarLayoutListener)localObject).b(paramInt);
          return;
        }
        if (paramBoolean2)
        {
          ((PickerBarLayout.PickerBarLayoutListener)localObject).c(paramInt);
          return;
        }
        ((PickerBarLayout.PickerBarLayoutListener)localObject).d(paramInt);
      }
    }
  }
  
  private int c(float paramFloat)
  {
    this.r = paramFloat;
    int i1 = f(paramFloat);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("movemark posY:");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(" markindex:");
      localStringBuilder.append(i1);
      localStringBuilder.append("  curIndex:");
      localStringBuilder.append(this.s);
      QLog.d("PickerBarLayout", 2, localStringBuilder.toString());
    }
    if (i1 != this.s)
    {
      this.s = i1;
      a(this.s, false, false);
    }
    setMarkText(this.s);
    float f1 = paramFloat;
    if (this.a) {
      f1 = paramFloat - this.j;
    }
    d(f1);
    invalidate();
    return this.s;
  }
  
  private void c()
  {
    this.n = new View(getContext());
    this.o = new GroundDrawable();
    float f1 = d();
    this.o.a(getContext(), this.k.size(), (Math.round(this.c) - this.b) / 2.0F + f1, (Math.round(this.c) - this.b) / 2.0F - f1, this);
    this.n.setBackground(this.o);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Math.round(this.c), -1);
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, 0, Math.round(this.d), 0);
    addView(this.n, localLayoutParams);
  }
  
  private float d()
  {
    return Math.round(this.d) - this.d - (Math.round(this.i) - this.i) + (Math.round(this.c) - this.c);
  }
  
  private void d(float paramFloat)
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localObject != null)
      {
        float f1 = this.f;
        float f2 = f1 / 2.0F;
        float f3 = this.g;
        if (paramFloat < f2 + f3)
        {
          f1 = f1 / 2.0F + f3;
        }
        else
        {
          f1 = paramFloat;
          if (paramFloat > getHeight() - this.f / 2.0F - this.h) {
            f1 = getHeight() - this.f / 2.0F - this.h;
          }
        }
        ((RelativeLayout.LayoutParams)localObject).topMargin = Math.round(f1 - this.f / 2.0F);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = Math.round(-this.f);
      }
    }
    requestLayout();
  }
  
  private boolean e(float paramFloat)
  {
    return getWidth() - this.d - this.c <= paramFloat;
  }
  
  private int f(float paramFloat)
  {
    GroundDrawable localGroundDrawable = this.o;
    if (localGroundDrawable != null) {
      return localGroundDrawable.a(paramFloat);
    }
    return -1;
  }
  
  public void a()
  {
    this.q = null;
    Object localObject = this.o;
    if (localObject != null) {
      ((GroundDrawable)localObject).stop();
    }
    localObject = this.m;
    if (localObject != null) {
      ((MarkDrawable)localObject).stop();
    }
    this.k.clear();
    this.l = null;
    localObject = this.m;
    if (localObject != null)
    {
      ((MarkDrawable)localObject).a();
      this.m = null;
    }
    this.n = null;
    localObject = this.o;
    if (localObject != null)
    {
      ((GroundDrawable)localObject).c();
      this.o = null;
    }
    this.p = -1;
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startenter:");
      ((StringBuilder)localObject).append(paramFloat);
      QLog.d("PickerBarLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.r = paramFloat;
    this.s = f(paramFloat);
    a(this.s, true, false);
    Object localObject = this.m;
    if ((localObject != null) && (this.o != null))
    {
      int i1 = ((MarkDrawable)localObject).b();
      boolean bool1 = this.m.isRunning();
      int i2 = this.o.b();
      boolean bool2 = this.o.isRunning();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("drawable state, markdrawble:");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" isrun:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append("  groundrawable:");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(" isrun:");
        ((StringBuilder)localObject).append(bool2);
        QLog.d("PickerBarLayout", 2, ((StringBuilder)localObject).toString());
      }
      if ((i1 == 1) && (i2 == 0))
      {
        this.m.stop();
        this.m.a(6);
        this.m.start();
        this.o.stop();
        this.o.a(1);
        this.o.start();
        return;
      }
      if (i1 == 4)
      {
        this.m.stop();
        this.m.a(2);
        this.m.start();
        return;
      }
      if (i2 == 3)
      {
        this.o.stop();
        this.o.a(1);
        this.o.start();
        return;
      }
      if (i1 == 5)
      {
        this.m.stop();
        this.m.a(6);
        this.m.start();
        this.o.stop();
        this.o.a(1);
        this.o.start();
        return;
      }
      if (i2 == 4)
      {
        this.o.stop();
        this.o.a(1);
        this.o.start();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PickerBarLayout", 2, "startenter: state not process!!");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 4))
    {
      MarkDrawable localMarkDrawable = this.m;
      if (localMarkDrawable != null) {
        localMarkDrawable.stop();
      }
    }
    b(paramInt, true, true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 4)
    {
      Object localObject = this.o;
      if (localObject != null)
      {
        if (paramInt3 == 0) {
          return;
        }
        localObject = ((GroundDrawable)localObject).b(this.r);
        if (localObject != null)
        {
          float f1 = ((RectF)localObject).centerY();
          float f2 = this.r;
          float f3 = this.j;
          d(f2 - f3 + (f1 - f2 + f3) * (paramInt2 + 1) / paramInt3);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, RectF paramRectF)
  {
    if ((this.o != null) && (paramRectF != null)) {
      d(paramRectF.centerY());
    }
  }
  
  public void a(int paramInt, RectF paramRectF)
  {
    if (((paramInt == 1) || (paramInt == 4)) && (paramRectF != null)) {
      d(paramRectF.centerY());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.s = paramInt;
    setMarkText(this.s);
    GroundDrawable localGroundDrawable = this.o;
    if (localGroundDrawable != null) {
      localGroundDrawable.a(this.s, true, paramBoolean);
    }
    invalidate();
  }
  
  public boolean a(EditVideoParams paramEditVideoParams, Context paramContext, PickerBarLayout.PickerBarLayoutListener paramPickerBarLayoutListener)
  {
    this.q = new WeakReference(paramPickerBarLayoutListener);
    a(paramContext);
    this.k.add("4x");
    this.k.add("2x");
    this.k.add("1x");
    if (paramEditVideoParams.g())
    {
      this.k.add("1/2");
      this.k.add("1/4");
    }
    if (paramEditVideoParams.f()) {
      this.k.add(PickerContainer.a);
    }
    c();
    b();
    return true;
  }
  
  public void b(float paramFloat)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startleave:");
      ((StringBuilder)localObject).append(paramFloat);
      QLog.d("PickerBarLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.r = paramFloat;
    int i1 = c(this.r);
    if (i1 != this.s) {
      this.s = i1;
    }
    a(this.s, false, true);
    if (this.m != null)
    {
      localObject = this.o;
      if (localObject != null)
      {
        ((GroundDrawable)localObject).a(this.s, false, false);
        i1 = this.m.b();
        boolean bool1 = this.m.isRunning();
        int i2 = this.o.b();
        boolean bool2 = this.o.isRunning();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("drawable state, markdrawble:");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(" isrun:");
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append("  groundrawable:");
          ((StringBuilder)localObject).append(i2);
          ((StringBuilder)localObject).append(" isrun:");
          ((StringBuilder)localObject).append(bool2);
          QLog.d("PickerBarLayout", 2, ((StringBuilder)localObject).toString());
        }
        if ((i1 == 3) && (i2 == 2))
        {
          this.m.stop();
          this.m.a(4);
          this.m.start();
          return;
        }
        if (i2 == 1)
        {
          this.o.stop();
          this.o.a(3);
          this.o.start();
          return;
        }
        if (i1 == 2)
        {
          this.m.stop();
          this.m.a(4);
          this.m.start();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PickerBarLayout", 2, "startleave: state not process!!");
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.l;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      if (this.o.b(this.r) != null) {
        d(this.r - this.j);
      }
      if (this.m != null)
      {
        setMarkText(this.s);
        this.m.stop();
        this.m.a(2);
        this.m.start();
      }
    }
    else if (paramInt == 3)
    {
      localObject = this.o;
      if (localObject != null)
      {
        localObject = ((GroundDrawable)localObject).a();
        if (localObject != null) {
          d(((RectF)localObject).centerY());
        }
      }
      localObject = this.l;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.m;
      if (localObject != null)
      {
        ((MarkDrawable)localObject).stop();
        this.m.a(5);
        this.m.start();
      }
    }
    else if ((paramInt != 4) && (paramInt == 0))
    {
      localObject = this.m;
      if (localObject != null)
      {
        ((MarkDrawable)localObject).stop();
        this.m.a(1);
        this.m.start();
      }
    }
    b(paramInt, true, false);
  }
  
  public void c(int paramInt)
  {
    MarkDrawable localMarkDrawable = this.m;
    if (localMarkDrawable != null) {
      localMarkDrawable.stop();
    }
  }
  
  public void d(int paramInt)
  {
    b(paramInt, false, true);
  }
  
  public void e(int paramInt)
  {
    if (paramInt != 2) {
      if (paramInt == 4)
      {
        GroundDrawable localGroundDrawable = this.o;
        if (localGroundDrawable != null)
        {
          localGroundDrawable.stop();
          this.o.a(3);
          this.o.start();
        }
      }
      else if (paramInt == 6)
      {
        d(this.r);
      }
    }
    b(paramInt, false, false);
  }
  
  public void f(int paramInt) {}
  
  public int getMarkSize()
  {
    return this.k.size();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      float f1;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return true;
          }
          i1 = paramMotionEvent.findPointerIndex(this.p);
          if (i1 == -1) {
            return true;
          }
          paramMotionEvent.getY(i1);
          b(paramMotionEvent.getY());
          this.p = -1;
          this.a = false;
          return true;
        }
        i1 = paramMotionEvent.findPointerIndex(this.p);
        if (i1 == -1) {
          return true;
        }
        f1 = paramMotionEvent.getY(i1);
        if (this.a)
        {
          c(f1);
          return true;
        }
      }
      else
      {
        i1 = paramMotionEvent.findPointerIndex(this.p);
        if (i1 == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PickerBarLayout", 2, "ACTION_UP with activePointerIndex = -1");
          }
          f1 = paramMotionEvent.getY();
        }
        else
        {
          f1 = paramMotionEvent.getY(i1);
        }
        if (!this.a)
        {
          paramMotionEvent = this.t;
          if (paramMotionEvent != null) {
            removeCallbacks(paramMotionEvent);
          }
          paramMotionEvent = this.o;
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.b(f1);
            if (paramMotionEvent != null)
            {
              c(paramMotionEvent.centerY());
              a(this.s, true);
              return true;
            }
          }
        }
        else
        {
          b(f1);
          this.p = -1;
          this.a = false;
          return true;
        }
      }
    }
    else
    {
      this.p = paramMotionEvent.getPointerId(0);
      if (!e(paramMotionEvent.getX())) {
        return false;
      }
      this.r = paramMotionEvent.getY();
      this.a = false;
      if (this.t == null) {
        this.t = new PickerBarLayout.CheckForLongPress(this);
      }
      this.t.a();
      postDelayed(this.t, ViewConfiguration.getLongPressTimeout());
    }
    return true;
  }
  
  public void setMarkText(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.k.size()) {
        return;
      }
      MarkDrawable localMarkDrawable = this.m;
      if (localMarkDrawable != null) {
        localMarkDrawable.a((String)this.k.get(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerBarLayout
 * JD-Core Version:    0.7.0.1
 */