package com.tencent.luggage.wxa.oc;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.o;

class a
  extends com.tencent.luggage.wxa.lk.c
{
  @Nullable
  private volatile b b = b.a;
  @Nullable
  private c.a c = null;
  @Nullable
  private Intent d = null;
  
  public a(@NonNull String paramString, @NonNull Activity paramActivity, @NonNull com.tencent.luggage.wxa.jx.c paramc)
  {
    super(paramString, paramActivity, paramc);
    a(c());
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.jx.c paramc)
  {
    paramc = c(paramc);
    if (paramc == null)
    {
      o.c("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryListenRunningStateChange, runningStateController is null");
      return;
    }
    b localb = paramc.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryListenRunningStateChange, curRunningState: ");
    localStringBuilder.append(localb);
    o.d("MicroMsg.AppBrand.WxaNFCReadWriteManager", localStringBuilder.toString());
    this.b = localb;
    paramc.a(i());
  }
  
  private void b(@NonNull Intent paramIntent)
  {
    o.d("MicroMsg.AppBrand.WxaNFCReadWriteManager", "realTryDispatchNfcTagDiscovered");
    super.a(paramIntent);
  }
  
  private void b(@NonNull com.tencent.luggage.wxa.jx.c paramc)
  {
    c.a locala = h();
    if (locala == null)
    {
      o.d("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, not need");
      return;
    }
    paramc = c(paramc);
    if (paramc == null)
    {
      o.c("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, runningStateController is null");
      return;
    }
    this.b = b.a;
    paramc.b(locala);
  }
  
  @Nullable
  private com.tencent.luggage.wxa.ix.c c(@NonNull com.tencent.luggage.wxa.jx.c paramc)
  {
    if (!(paramc instanceof h))
    {
      o.c("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, component is not AppBrandComponentWithExtra");
      return null;
    }
    paramc = ((h)paramc).q();
    if (paramc == null)
    {
      o.c("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, runtime is null");
      return null;
    }
    return paramc.al();
  }
  
  @Nullable
  private c.a h()
  {
    try
    {
      c.a locala = this.c;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @NonNull
  private c.a i()
  {
    try
    {
      if (this.c == null) {
        this.c = new a.1(this);
      }
      c.a locala = this.c;
      return locala;
    }
    finally {}
  }
  
  public void a(@NonNull Intent paramIntent)
  {
    b localb = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryDispatchNfcTagDiscovered, curRunningState: ");
    localStringBuilder.append(localb);
    o.d("MicroMsg.AppBrand.WxaNFCReadWriteManager", localStringBuilder.toString());
    if (b.a == localb)
    {
      b(paramIntent);
      return;
    }
    o.d("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryDispatchNfcTagDiscovered, dispatch pending");
    this.d = paramIntent;
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRequireForegroundDispatch, requireForegroundDispatch: ");
    localStringBuilder.append(paramBoolean);
    o.d("MicroMsg.AppBrand.WxaNFCReadWriteManager", localStringBuilder.toString());
    super.a(paramBoolean);
    if (paramBoolean)
    {
      a(c());
      return;
    }
    b(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oc.a
 * JD-Core Version:    0.7.0.1
 */