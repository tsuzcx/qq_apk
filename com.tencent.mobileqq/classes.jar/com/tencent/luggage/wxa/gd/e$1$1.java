package com.tencent.luggage.wxa.gd;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fy.d;
import com.tencent.luggage.wxa.nf.j;
import com.tencent.luggage.wxa.qz.o;

class e$1$1
  extends d<b>
{
  e$1$1(e.1 param1, j paramj) {}
  
  private void a(@Nullable Runnable paramRunnable)
  {
    Object localObject = this.b.h();
    if ((localObject != null) && (((Surface)localObject).isValid())) {}
    try
    {
      this.b.a((Surface)localObject);
      if (paramRunnable != null)
      {
        localObject = this.b.g();
        if (localObject != null)
        {
          a(paramRunnable, (SurfaceTexture)localObject);
          return;
        }
        o.d(this.a, "transferFrom, run afterTransferFromTask when originSurfaceTexture is null");
        paramRunnable.run();
      }
      return;
    }
    catch (Exception paramRunnable) {}
    o.c(this.a, "transferFrom, originSurface is invalid");
    if (paramRunnable != null)
    {
      o.d(this.a, "transferFrom, run afterTransferFromTask when originSurface is invalid");
      paramRunnable.run();
    }
    return;
  }
  
  protected d<b>.a<b> a(@NonNull b paramb, @Nullable Runnable paramRunnable)
  {
    return new e.1.1.a(this, paramb, paramRunnable);
  }
  
  @NonNull
  public b b(@NonNull Context paramContext)
  {
    o.e(this.a, "createVideoContainerView");
    paramContext = new b(paramContext);
    j localj = this.b;
    localj.a(new c(localj, paramContext));
    return paramContext;
  }
  
  public void b(@NonNull b paramb, @Nullable Runnable paramRunnable)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transferFrom, textureView: ");
    localStringBuilder.append(paramb);
    o.d(str, localStringBuilder.toString());
    super.c(paramb, paramRunnable);
    a(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.e.1.1
 * JD-Core Version:    0.7.0.1
 */