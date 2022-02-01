package com.tencent.luggage.wxa.pp;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.mn.e;
import com.tencent.luggage.wxa.mn.e.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import java.util.Locale;

final class ah<Input extends EditText,  extends ac>
{
  final Input a;
  private final String b;
  private final float c;
  private e.f d;
  private MotionEvent e;
  private boolean f = false;
  private final Runnable g = new ah.1(this);
  private final Runnable h = new ah.2(this);
  
  ah(Input paramInput)
  {
    this.a = paramInput;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.AppBrand.InputFakeTapEventEmitter");
    localStringBuilder.append(String.format(Locale.US, "[%s]", new Object[] { paramInput.toString() }));
    this.b = localStringBuilder.toString();
    this.c = ViewConfiguration.get(paramInput.getContext()).getScaledTouchSlop();
  }
  
  private void a()
  {
    this.f = false;
    this.a.removeCallbacks(this.g);
    this.a.removeCallbacks(this.h);
    this.d = null;
    MotionEvent localMotionEvent = this.e;
    if (localMotionEvent != null)
    {
      localMotionEvent.recycle();
      this.e = null;
    }
  }
  
  private boolean a(@NonNull MotionEvent paramMotionEvent1, @NonNull MotionEvent paramMotionEvent2)
  {
    float f1 = paramMotionEvent1.getX(paramMotionEvent1.getActionIndex());
    float f2 = paramMotionEvent1.getY(paramMotionEvent1.getActionIndex());
    float f3 = paramMotionEvent2.getX(paramMotionEvent2.getActionIndex());
    float f4 = paramMotionEvent2.getY(paramMotionEvent2.getActionIndex());
    String str = this.b;
    float f5 = this.c;
    boolean bool2 = false;
    o.f(str, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[] { Float.valueOf(f5), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f4), a.a(paramMotionEvent1), a.a(paramMotionEvent2) });
    boolean bool1 = bool2;
    if (Math.abs(f4 - f2) <= this.c)
    {
      bool1 = bool2;
      if (Math.abs(f3 - f1) <= this.c) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    a.a(this.b, "processTouchEvent", paramMotionEvent);
    Object localObject1 = this.a;
    int i = paramMotionEvent.getActionIndex();
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    if ((paramMotionEvent.getActionMasked() != 0) && (this.e == null))
    {
      o.f(this.b, "[textscroll] no pointer down before, just return");
      a();
      return false;
    }
    int j = paramMotionEvent.getActionMasked();
    i = 1;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            a();
          }
        }
        else
        {
          if ((e.a((View)localObject1, f1, f2, this.c)) && (a(this.e, paramMotionEvent))) {
            break label384;
          }
          this.f = false;
          ((EditText)localObject1).removeCallbacks(this.g);
          ((EditText)localObject1).removeCallbacks(this.h);
        }
      }
      else
      {
        o.f(this.b, "[apptouch] ACTION_UP, pointerDown %B", new Object[] { Boolean.valueOf(this.f) });
        if ((this.f) && (this.e != null))
        {
          localObject2 = e.a(this.a);
          e.f localf = this.d;
          if ((localf != null) && (Math.abs(localf.b - ((e.f)localObject2).b) <= 1.0F) && (Math.abs(this.d.c - ((e.f)localObject2).c) <= 1.0F))
          {
            if (!a(this.e, paramMotionEvent)) {
              o.f(this.b, "[apptouch] check tap on ACTION_UP exceed tap scope");
            } else {
              ((ac)localObject1).a(f1, f2);
            }
          }
          else {
            o.f(this.b, "[apptouch] check tap on ACTION_UP, but view has moved.");
          }
        }
        a();
      }
      i = 0;
    }
    else
    {
      this.e = MotionEvent.obtain(paramMotionEvent);
      this.d = e.a((View)localObject1);
      bool = e.b((View)localObject1);
      ((EditText)localObject1).removeCallbacks(this.g);
      if (bool) {
        ((EditText)localObject1).postDelayed(this.g, ViewConfiguration.getTapTimeout());
      } else {
        this.g.run();
      }
    }
    label384:
    localObject1 = this.a;
    boolean bool = aj.a((TextView)localObject1, ((EditText)localObject1).getText(), paramMotionEvent) | i;
    localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[textscroll] handled | ");
    ((StringBuilder)localObject2).append(bool);
    a.a((String)localObject1, ((StringBuilder)localObject2).toString(), paramMotionEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.ah
 * JD-Core Version:    0.7.0.1
 */