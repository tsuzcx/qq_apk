package com.tencent.luggage.wxa.nv;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.ui.base.g;

public abstract class a<T extends u>
{
  private final int a;
  
  public a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public void a(@NonNull Context paramContext, @NonNull T paramT, g paramg, String paramString) {}
  
  public final void a(@NonNull Context paramContext, @NonNull T paramT, g paramg, String paramString, com.tencent.luggage.wxa.nu.a parama)
  {
    if (b(paramContext, paramT, paramg, paramString, parama)) {
      return;
    }
    a(paramContext, paramT, paramg, paramString);
  }
  
  public abstract void a(@NonNull Context paramContext, @NonNull T paramT, String paramString, com.tencent.luggage.wxa.nu.a parama);
  
  public boolean b(@NonNull Context paramContext, @NonNull T paramT, g paramg, String paramString, com.tencent.luggage.wxa.nu.a parama)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nv.a
 * JD-Core Version:    0.7.0.1
 */