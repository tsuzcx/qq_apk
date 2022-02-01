package com.tencent.luggage.wxa.ke;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.kl.d;
import com.tencent.luggage.wxa.kl.e;
import com.tencent.luggage.wxa.kl.g;
import com.tencent.luggage.wxa.kl.h;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.km.f;
import com.tencent.luggage.wxa.qz.r;
import java.util.List;

public class b
  extends c.c
{
  @Nullable
  private final String a;
  @Nullable
  private com.tencent.luggage.wxa.kh.b b;
  @Nullable
  private volatile b.a c;
  
  public b(@Nullable String paramString)
  {
    this.a = paramString;
  }
  
  @Nullable
  private com.tencent.luggage.wxa.kh.b m()
  {
    try
    {
      com.tencent.luggage.wxa.kh.b localb = this.b;
      if (localb == null) {
        com.tencent.luggage.wxa.kn.a.b("MicroMsg.ble.BleWorker", "getBleManager, bleManager is null", new Object[0]);
      }
      return localb;
    }
    finally {}
  }
  
  public com.tencent.luggage.wxa.kl.c a(String paramString1, String paramString2, String paramString3)
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      return localb.a(paramString1, paramString2, paramString3);
    }
    return null;
  }
  
  public List<e> a(String paramString)
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      return localb.a(paramString);
    }
    return null;
  }
  
  public List<com.tencent.luggage.wxa.kl.c> a(String paramString1, String paramString2)
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      return localb.a(paramString1, paramString2);
    }
    return null;
  }
  
  public List<d> a(List<String> paramList)
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      return localb.a(paramList);
    }
    return null;
  }
  
  public void a(@NonNull b.a parama)
  {
    this.c = parama;
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.kh.a parama)
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      localb.a(parama);
    }
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.kl.b paramb, @Nullable List<f> paramList, @NonNull i parami)
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      localb.a(paramb, paramList, parami);
    }
  }
  
  public void a(g paramg)
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      localb.a(paramg);
    }
  }
  
  public void a(h paramh)
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      localb.a(paramh);
    }
  }
  
  public void a(String paramString, @NonNull com.tencent.luggage.wxa.kl.a parama, @NonNull com.tencent.luggage.wxa.kl.b paramb)
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      localb.a(paramString, parama, paramb);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b.a locala = this.c;
    if (locala != null) {
      locala.a(paramBoolean);
    }
  }
  
  public void c()
  {
    a.b(this.a);
  }
  
  public void f()
  {
    try
    {
      this.b = new com.tencent.luggage.wxa.kh.b(r.a());
      this.b.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<d> g()
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      return localb.b();
    }
    return null;
  }
  
  public List<d> h()
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      return localb.d();
    }
    return null;
  }
  
  public j i()
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      return localb.c();
    }
    return j.b;
  }
  
  public boolean j()
  {
    return com.tencent.luggage.wxa.kn.c.f();
  }
  
  public boolean k()
  {
    com.tencent.luggage.wxa.kh.b localb = m();
    if (localb != null) {
      return localb.e();
    }
    return false;
  }
  
  public void l()
  {
    try
    {
      if (this.b != null)
      {
        this.b.f();
        this.b = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ke.b
 * JD-Core Version:    0.7.0.1
 */