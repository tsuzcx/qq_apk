package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private final ViewGroup a;
  private final LinkedList<View> b = new LinkedList();
  private e.a c;
  
  public e(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
  
  private void a()
  {
    this.b.clear();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.a.onFilterTouchEventForSecurity(paramMotionEvent))
    {
      Object localObject1;
      if (paramMotionEvent.getActionMasked() == 0) {
        localObject1 = new b(this.a);
      } else {
        localObject1 = this.b.iterator();
      }
      Object localObject2;
      if (paramMotionEvent.getActionMasked() == 0) {
        localObject2 = new e.a(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), null);
      } else {
        localObject2 = null;
      }
      this.c = ((e.a)localObject2);
      boolean bool = false;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (View)((Iterator)localObject1).next();
        int j = paramMotionEvent.getActionIndex();
        if (this.a.isMotionEventSplittingEnabled()) {
          i = 1 << paramMotionEvent.getPointerId(j);
        } else {
          i = -1;
        }
        float f1 = paramMotionEvent.getX(j);
        float f2 = paramMotionEvent.getY(j);
        if (paramMotionEvent.getActionMasked() == 0)
        {
          if ((AppBrandViewMotionCompat.b((View)localObject2)) && (AppBrandViewMotionCompat.a(this.a, f1, f2, (View)localObject2, null)) && (AppBrandViewMotionCompat.a((View)localObject2)) && (AppBrandViewMotionCompat.dispatchTransformedTouchEvent(this.a, paramMotionEvent, false, (View)localObject2, i)))
          {
            this.b.addLast(localObject2);
            bool |= true;
          }
        }
        else {
          bool |= AppBrandViewMotionCompat.dispatchTransformedTouchEvent(this.a, paramMotionEvent, false, (View)localObject2, i);
        }
      }
      int i = paramMotionEvent.getActionMasked();
      if ((i != 1) && (i != 3)) {
        return bool;
      }
      a();
      return bool;
    }
    return false;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMotionEvent != null)
    {
      bool1 = bool2;
      if (paramMotionEvent.getActionMasked() == 0)
      {
        if (this.c == null) {
          return false;
        }
        bool1 = bool2;
        if (paramMotionEvent.getDownTime() == this.c.a)
        {
          bool1 = bool2;
          if (paramMotionEvent.getEventTime() == this.c.b) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.e
 * JD-Core Version:    0.7.0.1
 */