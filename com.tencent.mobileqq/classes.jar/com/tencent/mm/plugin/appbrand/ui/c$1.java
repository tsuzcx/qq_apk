package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.luggage.wxa.qz.o;

final class c$1
  implements View.OnSystemUiVisibilityChangeListener
{
  c$1(Window paramWindow) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("visibility = ");
    localStringBuilder.append(paramInt);
    o.e("MicroMsg.AppBrandUIUtil", localStringBuilder.toString());
    if ((paramInt & 0x4) == 0) {
      this.a.getDecorView().setSystemUiVisibility(c.b(this.a, true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.1
 * JD-Core Version:    0.7.0.1
 */