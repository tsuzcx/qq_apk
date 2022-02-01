package com.tencent.avgame.floatwindow;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class FloatWindowBaseLayout
  extends FrameLayout
{
  FloatPositionChangeCallback d;
  public int e;
  public int f;
  WindowManager g;
  WindowManager.LayoutParams h;
  boolean i = false;
  float j;
  float k;
  float l;
  float m;
  boolean n = false;
  float o = 6.0F;
  boolean p = false;
  
  public FloatWindowBaseLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.o = ViewUtils.dip2px(3.0F);
    this.g = ((WindowManager)getContext().getSystemService("window"));
    this.h = new WindowManager.LayoutParams();
    WindowManager.LayoutParams localLayoutParams = this.h;
    localLayoutParams.format = -3;
    localLayoutParams.flags = 808;
    if (Build.VERSION.SDK_INT >= 26) {
      this.h.type = 2038;
    } else {
      this.h.type = 2002;
    }
    localLayoutParams = this.h;
    localLayoutParams.systemUiVisibility = 5892;
    localLayoutParams.gravity = 85;
    localLayoutParams.setTitle("FloatWindowBaseLayout");
    localLayoutParams = this.h;
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    b();
  }
  
  private void b()
  {
    try
    {
      int i1 = ((Integer)this.h.getClass().getField("privateFlags").get(this.h)).intValue();
      this.h.getClass().getField("privateFlags").set(this.h, Integer.valueOf(i1 | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.h.x) || (paramInt2 != this.h.y))
    {
      WindowManager.LayoutParams localLayoutParams = this.h;
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
    }
  }
  
  public boolean d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("showOrUpdate mAdded: ");
      localStringBuilder1.append(this.i);
      QLog.d("FloatWindowBaseLayout", 2, localStringBuilder1.toString());
    }
    try
    {
      boolean bool2 = this.i;
      boolean bool1 = false;
      StringBuilder localStringBuilder2;
      if (!bool2) {
        try
        {
          this.g.addView(this, this.h);
          this.i = true;
        }
        catch (Throwable localThrowable1)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("showOrUpdate addView error:");
          localStringBuilder2.append(localThrowable1.getMessage());
          QLog.e("FloatWindowBaseLayout", 1, localStringBuilder2.toString());
          break label175;
        }
      }
      try
      {
        this.g.updateViewLayout(this, this.h);
        bool1 = true;
      }
      catch (Throwable localThrowable2)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("showOrUpdate updateViewLayout error: ");
        localStringBuilder2.append(localThrowable2.getMessage());
        QLog.e("FloatWindowBaseLayout", 1, localStringBuilder2.toString());
      }
      label175:
      return bool1;
    }
    finally {}
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    int i1 = paramMotionEvent.getAction();
    boolean bool = false;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label245;
          }
        }
        else
        {
          if ((Math.abs(f1 - this.l) > this.o) && (Math.abs(f2 - this.m) > this.o) && (this.p) && (!this.n)) {
            this.n = true;
          }
          localFloatPositionChangeCallback = this.d;
          if ((localFloatPositionChangeCallback != null) && (this.n)) {
            localFloatPositionChangeCallback.a((int)(f1 - this.j), (int)(f2 - this.k));
          }
          if (this.n)
          {
            bool = true;
            break label245;
          }
          bool = super.dispatchTouchEvent(paramMotionEvent);
          break label245;
        }
      }
      FloatPositionChangeCallback localFloatPositionChangeCallback = this.d;
      if ((localFloatPositionChangeCallback != null) && (this.n)) {
        localFloatPositionChangeCallback.b();
      }
      if (this.n) {
        bool = true;
      } else {
        bool = super.dispatchTouchEvent(paramMotionEvent);
      }
      this.n = false;
      this.p = false;
    }
    else
    {
      this.l = f1;
      this.m = f2;
      this.n = false;
      this.p = true;
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    label245:
    this.j = f1;
    this.k = f2;
    return bool;
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("applyChanges: ");
      localStringBuilder1.append(this.i);
      QLog.d("FloatWindowBaseLayout", 2, localStringBuilder1.toString());
    }
    if (this.i) {
      try
      {
        this.g.updateViewLayout(this, this.h);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("applyChanges updateViewLayout error: ");
        localStringBuilder2.append(localThrowable.getMessage());
        QLog.e("FloatWindowBaseLayout", 1, localStringBuilder2.toString());
      }
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("hide: ");
      localStringBuilder1.append(this.i);
      QLog.d("FloatWindowBaseLayout", 2, localStringBuilder1.toString());
    }
    for (;;)
    {
      try
      {
        boolean bool2 = this.i;
        bool1 = false;
        if (bool2)
        {
          try
          {
            this.g.removeView(this);
            this.i = false;
          }
          catch (Throwable localThrowable)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("hide removeView error: ");
            localStringBuilder2.append(localThrowable.getMessage());
            QLog.e("FloatWindowBaseLayout", 1, localStringBuilder2.toString());
          }
          return bool1;
        }
      }
      finally {}
      boolean bool1 = true;
    }
  }
  
  public void g()
  {
    this.d = null;
  }
  
  public int getCurrentX()
  {
    return this.h.x;
  }
  
  public int getCurrentY()
  {
    return this.h.y;
  }
  
  public int getFloatCenterX()
  {
    return this.h.x + this.h.width / 2;
  }
  
  public int getFloatHeight()
  {
    return this.f;
  }
  
  public int getFloatWidth()
  {
    return this.e;
  }
  
  public WindowManager.LayoutParams getLayoutParams()
  {
    return this.h;
  }
  
  public void setFloatPositionChangeCallback(FloatPositionChangeCallback paramFloatPositionChangeCallback)
  {
    this.d = paramFloatPositionChangeCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowBaseLayout
 * JD-Core Version:    0.7.0.1
 */