package com.tencent.luggage.wxa.gd;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fy.d;
import com.tencent.luggage.wxa.fy.d.a;
import com.tencent.luggage.wxa.nf.j;

class e$1$1$a
  extends d<b>.a<b>
{
  @Nullable
  private Surface d = null;
  
  protected e$1$1$a(e.1.1 param1, @NonNull b paramb, @Nullable Runnable paramRunnable)
  {
    super(param1, paramb, paramRunnable);
  }
  
  protected void a()
  {
    e.1.1.a(this.c, null);
  }
  
  protected boolean a(@NonNull Surface paramSurface, int paramInt1, int paramInt2)
  {
    Surface localSurface = this.d;
    if ((localSurface != null) && (localSurface == paramSurface)) {
      return true;
    }
    try
    {
      boolean bool = this.c.b.a(paramSurface);
      if (bool) {
        this.d = paramSurface;
      }
      return bool;
    }
    catch (Exception paramSurface)
    {
      label45:
      break label45;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.e.1.1.a
 * JD-Core Version:    0.7.0.1
 */