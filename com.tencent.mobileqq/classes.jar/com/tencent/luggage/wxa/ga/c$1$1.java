package com.tencent.luggage.wxa.ga;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fy.d;
import com.tencent.luggage.wxa.gd.b;
import com.tencent.luggage.wxa.nb.c;
import com.tencent.luggage.wxa.qz.o;

class c$1$1
  extends d<b>
{
  c$1$1(c.1 param1, c paramc) {}
  
  protected d<b>.a<b> a(@NonNull b paramb, @Nullable Runnable paramRunnable)
  {
    return new c.1.1.a(this, paramb, paramRunnable);
  }
  
  @NonNull
  public b b(@NonNull Context paramContext)
  {
    o.e(this.a, "createVideoContainerView");
    return new b(paramContext);
  }
  
  public void b(@NonNull b paramb, @Nullable Runnable paramRunnable)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transferFrom, textureView: ");
    localStringBuilder.append(paramb);
    o.d(str, localStringBuilder.toString());
    super.c(paramb, paramRunnable);
    paramb = this.b.h();
    if ((paramb != null) && (paramb.isValid())) {}
    try
    {
      if (this.b.a(paramb)) {
        this.b.a(this.b.a(), this.b.b());
      }
      if (paramRunnable != null)
      {
        paramb = this.b.g();
        if (paramb != null)
        {
          a(paramRunnable, paramb);
          return;
        }
        o.d(this.a, "transferFrom, run afterTransferFromTask when originSurfaceTexture is null");
        paramRunnable.run();
      }
      return;
    }
    catch (Exception paramb) {}
    o.c(this.a, "transferFrom, originSurface is invalid");
    if (paramRunnable != null)
    {
      o.d(this.a, "transferFrom, run afterTransferFromTask when originSurface is invalid");
      paramRunnable.run();
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.c.1.1
 * JD-Core Version:    0.7.0.1
 */