package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qx.a;

public class RemoteDebugMoveView
  extends FrameLayout
{
  float a;
  float b;
  float c;
  float d;
  private int e;
  private int f;
  
  public RemoteDebugMoveView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RemoteDebugMoveView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RemoteDebugMoveView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int b()
  {
    int i = getWidth();
    if (i > 0) {
      return i;
    }
    return a.e(getContext(), 200);
  }
  
  public void a()
  {
    postDelayed(new RemoteDebugMoveView.3(this), 50L);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.e = paramInt1;
    this.f = paramInt2;
    post(new RemoteDebugMoveView.1(this));
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getViewTreeObserver().addOnGlobalLayoutListener(new RemoteDebugMoveView.2(this));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        this.c = paramMotionEvent.getRawX();
        this.d = paramMotionEvent.getRawY();
        float f1 = getX() + (this.c - this.a);
        if ((0.0F < f1) && (f1 < this.e - getWidth())) {
          setX(f1);
        }
        f1 = this.d - this.b;
        float f2 = this.f - getHeight();
        float f3 = getY() + f1;
        if ((0.0F < f3) && (f3 < f2)) {
          setY(f3);
        } else if (((f3 <= 0.0F) && (f1 > 0.0F)) || ((f3 >= f2) && (f1 < 0.0F))) {
          setY(f3);
        }
        this.a = this.c;
        this.b = this.d;
      }
    }
    else
    {
      this.a = paramMotionEvent.getRawX();
      this.b = paramMotionEvent.getRawY();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView
 * JD-Core Version:    0.7.0.1
 */