package com.tencent.luggage.wxa.pp;

import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.plugin.appbrand.widget.base.e;

public final class ai
{
  private final g a;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private final ai.a<ViewGroup, g> e = new ai.1(this);
  private final ai.a<ViewGroup, y> f = new ai.2(this);
  
  public ai(@NonNull g paramg)
  {
    this.a = paramg;
  }
  
  private void a()
  {
    if (this.b)
    {
      y localy = (y)this.f.d(this.a);
      if (localy != null) {
        localy.setPullDownEnabled(this.c);
      }
      this.b = false;
    }
  }
  
  private boolean b(@NonNull MotionEvent paramMotionEvent)
  {
    boolean bool = this.a.a.a(paramMotionEvent);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[textscroll] handled | ");
    ((StringBuilder)localObject).append(bool);
    a.a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", ((StringBuilder)localObject).toString(), paramMotionEvent);
    if (2 == paramMotionEvent.getActionMasked())
    {
      if ((bool) && (!this.b))
      {
        localObject = (y)this.f.d(this.a);
        if (localObject != null)
        {
          this.c = ((y)localObject).a();
          ((y)localObject).setPullDownEnabled(false);
          ((y)localObject).requestDisallowInterceptTouchEvent(true);
          this.b = true;
        }
      }
      if (bool) {
        this.d = true;
      } else if (this.d) {
        this.d = false;
      }
    }
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return bool;
      }
      a();
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    return b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.ai
 * JD-Core Version:    0.7.0.1
 */