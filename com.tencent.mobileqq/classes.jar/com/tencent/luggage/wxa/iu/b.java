package com.tencent.luggage.wxa.iu;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jx.i;
import com.tencent.luggage.wxa.jx.j;
import com.tencent.luggage.wxa.jx.k;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;

public abstract class b
  extends i
{
  public final n A()
  {
    return (n)a(n.class);
  }
  
  public final <T extends com.tencent.luggage.wxa.ba.b> T a(Class<T> paramClass)
  {
    if (n.class == paramClass) {
      return super.a(paramClass);
    }
    Object localObject = q();
    if (localObject != null)
    {
      localObject = (com.tencent.luggage.wxa.ba.b)((d)localObject).d(paramClass);
      if (localObject != null) {
        return localObject;
      }
    }
    return super.a(paramClass);
  }
  
  public final void a(n paramn)
  {
    if (paramn != null)
    {
      super.a(n.class, paramn);
      return;
    }
    throw new NullPointerException();
  }
  
  public boolean a(k paramk)
  {
    if ((d()) && (q().a(paramk))) {
      return true;
    }
    return super.a(paramk);
  }
  
  @NonNull
  public <T extends j> T b(@NonNull Class<T> paramClass)
  {
    if (q() != null)
    {
      j localj = q().a(paramClass, false);
      if (localj != null) {
        return localj;
      }
    }
    return super.b(paramClass);
  }
  
  @Nullable
  public <T extends k> T c(@NonNull Class<T> paramClass)
  {
    if (d())
    {
      k localk = q().c(paramClass);
      if (localk != null) {
        return localk;
      }
    }
    return super.c(paramClass);
  }
  
  public boolean d()
  {
    d locald = q();
    return (locald != null) && (!locald.au());
  }
  
  public String getAppId()
  {
    if (q() == null) {
      return null;
    }
    return q().aa();
  }
  
  @NonNull
  public com.tencent.luggage.wxa.ix.b getAppState()
  {
    if (!d()) {
      return com.tencent.luggage.wxa.ix.b.d;
    }
    return q().al().a();
  }
  
  public final Context getContext()
  {
    if (q() == null) {
      return r.a();
    }
    Object localObject = q().ah();
    if (localObject != null) {
      return localObject;
    }
    localObject = q().a;
    if (localObject != null) {
      return localObject;
    }
    return r.a();
  }
  
  @Nullable
  public l getDialogContainer()
  {
    if (!d()) {
      return super.getDialogContainer();
    }
    return q().ao();
  }
  
  @Nullable
  public o getFileSystem()
  {
    if (!d()) {
      return super.getFileSystem();
    }
    return q().z();
  }
  
  public abstract com.tencent.luggage.wxa.oq.c y();
  
  @Nullable
  public h z()
  {
    d locald = q();
    if (locald == null) {
      return null;
    }
    return ad.b(locald);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.b
 * JD-Core Version:    0.7.0.1
 */