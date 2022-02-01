package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ba.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public abstract interface o
  extends b
{
  @Nullable
  public abstract com.tencent.luggage.wxa.rt.i a(String paramString, boolean paramBoolean);
  
  @NonNull
  public abstract j a(com.tencent.luggage.wxa.pc.i<String> parami);
  
  @NonNull
  public abstract j a(com.tencent.luggage.wxa.rt.i parami, String paramString, com.tencent.luggage.wxa.pc.i<String> parami1);
  
  @NonNull
  public abstract j a(com.tencent.luggage.wxa.rt.i parami, String paramString, boolean paramBoolean, com.tencent.luggage.wxa.pc.i<String> parami1);
  
  @NonNull
  public abstract j a(String paramString, long paramLong1, long paramLong2, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami);
  
  @NonNull
  public abstract j a(String paramString, com.tencent.luggage.wxa.pc.i<List<h>> parami);
  
  @NonNull
  public abstract j a(String paramString, @NonNull com.tencent.luggage.wxa.rt.i parami);
  
  @NonNull
  public abstract j a(String paramString, com.tencent.luggage.wxa.rt.i parami, boolean paramBoolean);
  
  @NonNull
  public abstract j a(String paramString, FileStructStat paramFileStructStat);
  
  @NonNull
  public abstract j a(String paramString, InputStream paramInputStream, boolean paramBoolean);
  
  @NonNull
  public abstract j a(String paramString, List<v> paramList);
  
  public abstract void a();
  
  public abstract boolean a(String paramString);
  
  @NonNull
  public abstract j b(String paramString);
  
  @NonNull
  public abstract j b(String paramString, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami);
  
  @NonNull
  public abstract j b(String paramString, boolean paramBoolean);
  
  public abstract void b();
  
  @NonNull
  public abstract j c(String paramString);
  
  @NonNull
  public abstract j c(String paramString, boolean paramBoolean);
  
  @Nullable
  public abstract List<? extends o.a> c();
  
  @Nullable
  public abstract com.tencent.luggage.wxa.rt.i d(String paramString);
  
  public abstract boolean e(String paramString);
  
  @NonNull
  public abstract j f(String paramString);
  
  @Nullable
  public abstract com.tencent.luggage.wxa.rt.i g(String paramString);
  
  public abstract boolean h(String paramString);
  
  @Nullable
  public abstract com.tencent.luggage.wxa.rt.i i(String paramString);
  
  public abstract boolean j(String paramString);
  
  public abstract InputStream k(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.o
 * JD-Core Version:    0.7.0.1
 */