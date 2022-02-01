package com.tencent.luggage.wxa.kh;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.kl.d;
import com.tencent.luggage.wxa.kl.e;
import com.tencent.luggage.wxa.kl.g;
import com.tencent.luggage.wxa.kl.h;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.km.f;
import java.util.List;

public class b
{
  @NonNull
  private final com.tencent.luggage.wxa.ki.c a;
  @NonNull
  private final com.tencent.luggage.wxa.km.a b;
  
  public b(Context paramContext)
  {
    this.a = new com.tencent.luggage.wxa.ki.c(paramContext);
    this.b = new com.tencent.luggage.wxa.km.a(paramContext);
  }
  
  public com.tencent.luggage.wxa.kl.c a(String paramString1, String paramString2, String paramString3)
  {
    return this.a.a(paramString1, paramString2, paramString3);
  }
  
  public List<e> a(String paramString)
  {
    return this.a.b(paramString);
  }
  
  public List<com.tencent.luggage.wxa.kl.c> a(String paramString1, String paramString2)
  {
    return this.a.a(paramString1, paramString2);
  }
  
  public List<d> a(List<String> paramList)
  {
    return this.a.a(paramList);
  }
  
  public void a()
  {
    this.a.a();
    this.b.a();
  }
  
  public void a(@NonNull a parama)
  {
    com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.BleManager", "initBleConfig:%s", new Object[] { parama });
    a.a(parama);
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.kl.b paramb, @Nullable List<f> paramList, @NonNull i parami)
  {
    this.b.a(paramb, paramList, parami);
  }
  
  public void a(g paramg)
  {
    this.a.a(paramg);
  }
  
  public void a(h paramh)
  {
    this.a.a(paramh);
  }
  
  public void a(String paramString, @NonNull com.tencent.luggage.wxa.kl.a parama, @NonNull com.tencent.luggage.wxa.kl.b paramb)
  {
    this.a.a(paramString, parama, paramb);
  }
  
  public List<d> b()
  {
    return this.b.c();
  }
  
  public j c()
  {
    return this.b.b();
  }
  
  public List<d> d()
  {
    return this.a.c();
  }
  
  public boolean e()
  {
    return this.b.d();
  }
  
  public void f()
  {
    this.a.b();
    this.b.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kh.b
 * JD-Core Version:    0.7.0.1
 */