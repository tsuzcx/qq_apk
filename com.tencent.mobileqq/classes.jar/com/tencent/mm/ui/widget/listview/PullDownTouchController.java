package com.tencent.mm.ui.widget.listview;

import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.g;

public final class PullDownTouchController
{
  private static String s = "MicroMsg.PullDownTouchController";
  private final int a = 0;
  private float b;
  private float c;
  private int d;
  private int e;
  private int f;
  private Vibrator g;
  private VelocityTracker h;
  private PullDownListView i;
  private View j;
  private boolean k;
  private boolean l;
  private boolean m;
  private PullDownTouchController.MoveType n;
  private int o;
  private PullDownTouchController.OnLongClickListener p;
  private Handler q = new PullDownTouchController.1(this);
  private Context r = null;
  
  public PullDownTouchController(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.r = paramContext;
    this.g = ((Vibrator)this.r.getSystemService("vibrator"));
    this.n = PullDownTouchController.MoveType.None;
    paramContext = ViewConfiguration.get(this.r);
    if (paramContext != null)
    {
      this.d = ViewConfiguration.getLongPressTimeout();
      this.e = paramContext.getScaledTouchSlop();
      this.f = g.a(this.r, 30);
    }
  }
  
  private final float a(float paramFloat)
  {
    return paramFloat / 15.0F;
  }
  
  private final void b()
  {
    VelocityTracker localVelocityTracker = this.h;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.clear();
      this.h.recycle();
    }
    this.h = null;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = s;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchTouchEvent ");
    localStringBuilder.append(paramMotionEvent.getAction());
    f.b((String)localObject, localStringBuilder.toString(), new Object[0]);
    if (this.h == null) {
      this.h = VelocityTracker.obtain();
    }
    this.h.addMovement(paramMotionEvent);
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool2 = true;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label804;
          }
        }
        else
        {
          float f1 = paramMotionEvent.getRawX();
          float f2 = paramMotionEvent.getRawY();
          float f4 = this.c;
          float f3 = f2 - this.b;
          if (!this.m)
          {
            if ((Math.abs(f1 - f4) <= this.e) && (Math.abs(f2 - this.b) <= this.e)) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            this.m = bool1;
          }
          bool1 = this.m;
          f2 = 0.0F;
          if (bool1)
          {
            localObject = this.q;
            getClass();
            ((Handler)localObject).removeMessages(0);
            if (this.n == PullDownTouchController.MoveType.None)
            {
              if (Math.abs(f3) > Math.abs(f1 - f4))
              {
                if (f3 < 0.0F) {
                  localObject = PullDownTouchController.MoveType.DragUp;
                } else {
                  localObject = PullDownTouchController.MoveType.DragDown;
                }
              }
              else {
                localObject = PullDownTouchController.MoveType.Normal;
              }
              this.n = ((PullDownTouchController.MoveType)localObject);
            }
          }
          this.h.computeCurrentVelocity(1000);
          localObject = this.h;
          if (localObject != null) {
            f1 = ((VelocityTracker)localObject).getXVelocity(this.o);
          } else {
            f1 = 0.0F;
          }
          localObject = this.h;
          if (localObject != null) {
            f2 = ((VelocityTracker)localObject).getYVelocity(this.o);
          }
          localObject = s;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("moveDirection ");
          localStringBuilder.append(this.n);
          localStringBuilder.append(" deltaOverScrollY:");
          localStringBuilder.append(f3);
          localStringBuilder.append(" velocityX:");
          localStringBuilder.append(f1);
          localStringBuilder.append(" velocityY:");
          localStringBuilder.append(f2);
          f.b((String)localObject, localStringBuilder.toString(), new Object[0]);
          if (this.l) {
            break label804;
          }
          if (this.n == PullDownTouchController.MoveType.DragUp)
          {
            this.k = true;
            if ((Math.abs(f3) <= this.f) || (Math.abs(f2) <= Math.abs(f1))) {
              break label804;
            }
            localObject = this.i;
            if (localObject == null) {
              break label804;
            }
            ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
            break label804;
          }
          if (this.n != PullDownTouchController.MoveType.DragDown) {
            break label804;
          }
          this.k = true;
          if (this.i == null) {
            break label804;
          }
          paramMotionEvent = this.j;
          if ((paramMotionEvent == null) || (paramMotionEvent.getLayoutParams() == null)) {
            break label804;
          }
          paramMotionEvent = (ViewGroup.MarginLayoutParams)this.j.getLayoutParams();
          paramMotionEvent.topMargin = ((int)a(f3));
          this.j.setLayoutParams(paramMotionEvent);
          break label804;
        }
      }
      b();
      localObject = this.q;
      getClass();
      ((Handler)localObject).removeMessages(0);
      if ((!this.l) && (this.k)) {
        if (this.n == PullDownTouchController.MoveType.DragUp)
        {
          localObject = this.i;
          if (localObject != null) {
            ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
          }
        }
        else if (this.n == PullDownTouchController.MoveType.DragDown)
        {
          paramMotionEvent = this.i;
          if (paramMotionEvent != null) {
            paramMotionEvent.onResume();
          }
        }
      }
    }
    else
    {
      this.o = paramMotionEvent.getPointerId(0);
      this.b = paramMotionEvent.getRawY();
      this.c = paramMotionEvent.getRawX();
      this.k = false;
      this.l = false;
      this.m = false;
      this.n = PullDownTouchController.MoveType.None;
      paramMotionEvent = this.q;
      getClass();
      paramMotionEvent.removeMessages(0);
      paramMotionEvent = this.q;
      getClass();
      paramMotionEvent.sendEmptyMessageDelayed(0, this.d);
      paramMotionEvent = s;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downX:");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("  downY:");
      ((StringBuilder)localObject).append(this.b);
      f.b(paramMotionEvent, ((StringBuilder)localObject).toString(), new Object[0]);
    }
    label804:
    boolean bool1 = bool2;
    if (!this.l)
    {
      if (this.k) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public final boolean getConsumed()
  {
    return this.k;
  }
  
  public final Context getContext()
  {
    return this.r;
  }
  
  public final PullDownTouchController.OnLongClickListener getOnLongClick()
  {
    return this.p;
  }
  
  public final View getStoryView()
  {
    return this.j;
  }
  
  public final View getWrapperView()
  {
    return this.i;
  }
  
  public final boolean isLongPressed()
  {
    return this.l;
  }
  
  public final void onDestroy()
  {
    this.i = null;
    this.j = null;
  }
  
  public final void setConsumed(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public final void setLongPressed(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public final void setOnLongClickListener(PullDownTouchController.OnLongClickListener paramOnLongClickListener)
  {
    this.p = paramOnLongClickListener;
  }
  
  public final void setStoryView(View paramView)
  {
    this.j = paramView;
  }
  
  public final void setWrapperView(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof PullDownListView))) {
      this.i = ((PullDownListView)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownTouchController
 * JD-Core Version:    0.7.0.1
 */