package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import kotlin.jvm.functions.Function0;

class a$2
  implements Runnable
{
  a$2(a parama, Function0 paramFunction0) {}
  
  public void run()
  {
    this.b.setVisibility(8);
    if (this.b.getParent() != null) {
      ((ViewGroup)this.b.getParent()).removeView(this.b);
    }
    a.c(this.b).a();
    Function0 localFunction0 = this.a;
    if (localFunction0 != null) {
      localFunction0.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.a.2
 * JD-Core Version:    0.7.0.1
 */