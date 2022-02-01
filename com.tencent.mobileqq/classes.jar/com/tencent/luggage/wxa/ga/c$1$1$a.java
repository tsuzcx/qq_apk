package com.tencent.luggage.wxa.ga;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fy.d;
import com.tencent.luggage.wxa.fy.d.a;
import com.tencent.luggage.wxa.gd.b;
import com.tencent.luggage.wxa.nb.c;

class c$1$1$a
  extends d<b>.a<b>
{
  @Nullable
  private Surface d = null;
  
  protected c$1$1$a(c.1.1 param1, @NonNull b paramb, @Nullable Runnable paramRunnable)
  {
    super(param1, paramb, paramRunnable);
  }
  
  protected void a() {}
  
  protected boolean a(@NonNull Surface paramSurface, int paramInt1, int paramInt2)
  {
    Surface localSurface = paramSurface;
    try
    {
      if (this.d != null)
      {
        localSurface = paramSurface;
        if (this.d == paramSurface) {
          localSurface = null;
        }
      }
      boolean bool1 = true;
      if (localSurface != null)
      {
        boolean bool2 = this.c.b.a(localSurface);
        bool1 = bool2;
        if (bool2)
        {
          this.d = localSurface;
          bool1 = bool2;
        }
      }
      if (bool1) {
        this.c.b.a(paramInt1, paramInt2);
      }
      return bool1;
    }
    catch (Exception paramSurface)
    {
      label86:
      break label86;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.c.1.1.a
 * JD-Core Version:    0.7.0.1
 */