package com.tencent.luggage.wxa.kt;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.e;

class f$4
  implements View.OnTouchListener
{
  f$4(f paramf, a.b paramb, e parame, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = "webview".equals(this.a.b("sendTo", null));
    d.a(this.b, paramView, this.c, paramMotionEvent, this.a.b("data", ""), bool);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.f.4
 * JD-Core Version:    0.7.0.1
 */