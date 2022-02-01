package com.tencent.luggage.wxa.or;

import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.tencent.mm.ui.c;
import java.util.List;

class k$2
  implements View.OnApplyWindowInsetsListener
{
  k$2(k paramk, int paramInt, View paramView, c paramc) {}
  
  public WindowInsets onApplyWindowInsets(View arg1, WindowInsets paramWindowInsets)
  {
    synchronized (k.a(this.d))
    {
      k.b(this.d).put(this.a, this.b.getRootWindowInsets());
      if (this.b.getRootWindowInsets() != null)
      {
        Object localObject = this.b.getRootWindowInsets().getDisplayCutout();
        if (localObject != null)
        {
          localObject = ((DisplayCutout)localObject).getBoundingRects();
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            k.a(this.d, true);
          }
        }
      }
      this.c.b(this);
      return paramWindowInsets;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.k.2
 * JD-Core Version:    0.7.0.1
 */