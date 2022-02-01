package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.util.a;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class g
  implements o
{
  @Nullable
  public com.tencent.luggage.wxa.rt.i a(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  protected j a(long paramLong1, long paramLong2, long paramLong3)
  {
    j localj = j.a;
    if ((paramLong1 >= 0L) && (paramLong1 <= paramLong3 - 1L))
    {
      if ((paramLong2 >= 1L) && (paramLong2 <= paramLong3 - paramLong1)) {
        return localj;
      }
      return j.m;
    }
    return j.l;
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.pc.i<String> parami)
  {
    return j.q;
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.rt.i parami, String paramString, com.tencent.luggage.wxa.pc.i<String> parami1)
  {
    return j.q;
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.rt.i parami, String paramString, boolean paramBoolean, com.tencent.luggage.wxa.pc.i<String> parami1)
  {
    return j.q;
  }
  
  @NonNull
  public j a(String paramString, long paramLong1, long paramLong2, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami)
  {
    return j.e;
  }
  
  @NonNull
  public j a(String paramString, com.tencent.luggage.wxa.pc.i<List<h>> parami)
  {
    return j.e;
  }
  
  @NonNull
  public j a(String paramString, @NonNull com.tencent.luggage.wxa.rt.i parami)
  {
    return j.e;
  }
  
  @NonNull
  public j a(String paramString, com.tencent.luggage.wxa.rt.i parami, boolean paramBoolean)
  {
    return j.e;
  }
  
  @NonNull
  public j a(String paramString, FileStructStat paramFileStructStat)
  {
    return j.e;
  }
  
  @NonNull
  public j a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return j.e;
  }
  
  @NonNull
  public j a(String paramString, List<v> paramList)
  {
    return j.e;
  }
  
  public void a() {}
  
  public void a(long paramLong) {}
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  @NonNull
  public j b(String paramString)
  {
    return j.e;
  }
  
  @NonNull
  public j b(String paramString, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami)
  {
    return j.e;
  }
  
  @NonNull
  public j b(String paramString, boolean paramBoolean)
  {
    return j.e;
  }
  
  public void b() {}
  
  @NonNull
  public j c(String paramString)
  {
    return j.e;
  }
  
  @NonNull
  public j c(String paramString, boolean paramBoolean)
  {
    return j.e;
  }
  
  @Nullable
  public List<? extends o.a> c()
  {
    return null;
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i d(String paramString)
  {
    return null;
  }
  
  public boolean e(String paramString)
  {
    return true;
  }
  
  @NonNull
  public j f(String paramString)
  {
    return j.e;
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i g(String paramString)
  {
    return a(paramString, false);
  }
  
  public boolean h(String paramString)
  {
    return false;
  }
  
  public com.tencent.luggage.wxa.rt.i i(String paramString)
  {
    return null;
  }
  
  public boolean j(String paramString)
  {
    return false;
  }
  
  @Nullable
  public InputStream k(String paramString)
  {
    com.tencent.luggage.wxa.pc.i locali = new com.tencent.luggage.wxa.pc.i();
    if (b(paramString, locali) == j.a) {
      return new a((ByteBuffer)locali.a);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.g
 * JD-Core Version:    0.7.0.1
 */