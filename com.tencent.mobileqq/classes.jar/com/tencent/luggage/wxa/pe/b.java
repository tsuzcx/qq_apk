package com.tencent.luggage.wxa.pe;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;

class b
  implements e
{
  protected Context a;
  private final IntentFilter b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  private final d c = new d();
  private Intent d = null;
  private final e e = this;
  private b.a f;
  
  private Intent b(Context paramContext)
  {
    Intent localIntent = this.d;
    if (localIntent != null) {
      return localIntent;
    }
    this.f = new b.a(this, null);
    paramContext = paramContext.getApplicationContext().registerReceiver(this.f, this.b);
    this.d = paramContext;
    return paramContext;
  }
  
  @NonNull
  public c a()
  {
    try
    {
      if (this.a == null)
      {
        o.b("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no context");
        localObject1 = a.b;
        return localObject1;
      }
      Object localObject1 = b(this.a);
      if (localObject1 == null)
      {
        o.b("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no intent got");
        localObject1 = a.b;
        return localObject1;
      }
      localObject1 = this.c.a((Intent)localObject1);
      if (localObject1 == null)
      {
        localObject1 = a.b;
        return localObject1;
      }
      return localObject1;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    try
    {
      this.d = null;
      if (paramContext.getApplicationContext() != null) {
        paramContext = paramContext.getApplicationContext();
      }
      this.a = paramContext;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pe.b
 * JD-Core Version:    0.7.0.1
 */