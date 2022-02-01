package com.tencent.mm.plugin.appbrand.page;

import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.qa.a;

class f$2
  implements Runnable
{
  f$2(f paramf) {}
  
  public void run()
  {
    if ((ViewCompat.isAttachedToWindow(this.a)) && ((f.b(this.a).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (((ViewGroup.MarginLayoutParams)f.b(this.a).getLayoutParams()).topMargin != f.b(this.a).getTop())) {
      f.b(this.a).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f.2
 * JD-Core Version:    0.7.0.1
 */