package com.tencent.luggage.wxa.iu;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

class e$1
  implements View.OnSystemUiVisibilityChangeListener
{
  e$1(e parame) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((e.a(this.a).isShown()) && (ViewCompat.isAttachedToWindow(e.a(this.a))) && (Build.VERSION.SDK_INT >= 26) && ((e.a(this.a).getWindowSystemUiVisibility() & 0x2) == 0))
    {
      Activity localActivity = com.tencent.luggage.wxa.rc.a.a(this.a.getContext());
      if ((localActivity != null) && (localActivity.getWindow() != null))
      {
        boolean bool = com.tencent.mm.ui.e.a(localActivity.getWindow().getNavigationBarColor());
        com.tencent.mm.ui.a.d(localActivity.getWindow(), bool ^ true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.e.1
 * JD-Core Version:    0.7.0.1
 */