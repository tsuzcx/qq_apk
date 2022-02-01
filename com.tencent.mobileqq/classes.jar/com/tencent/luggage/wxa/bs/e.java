package com.tencent.luggage.wxa.bs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.dq.c;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.o.a;
import com.tencent.mm.plugin.appbrand.page.o.d;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.concurrent.Callable;

public class e
  implements o.a
{
  @Nullable
  public m a(String paramString, bg parambg, @NonNull o paramo, @NonNull Callable<m> paramCallable)
  {
    return new d(paramo.getContext(), paramo);
  }
  
  @Nullable
  public u a(@NonNull o paramo)
  {
    return new c(h.class);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(@NonNull String paramString, @NonNull bg parambg, @NonNull o paramo, @NonNull o.d paramd)
  {
    int i = e.1.a[parambg.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return true;
      }
      paramo.a(null, paramo.getCurrentPage(), bg.g, paramString, false);
      paramo.getCurrentPage().a(paramString);
      paramo.a(null, paramo.getCurrentPage(), bg.g);
      return true;
    }
    paramd.a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bs.e
 * JD-Core Version:    0.7.0.1
 */