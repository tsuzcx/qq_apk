package com.tencent.luggage.wxa.pp;

import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.luggage.wxa.qz.o;

class ah$1
  implements Runnable
{
  ah$1(ah paramah) {}
  
  public void run()
  {
    ah.a(this.a, true);
    o.f(ah.a(this.a), "[apptouch] pendingCheckForTap run, pointerDown TRUE");
    this.a.a.postDelayed(ah.b(this.a), ViewConfiguration.getLongPressTimeout());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.ah.1
 * JD-Core Version:    0.7.0.1
 */