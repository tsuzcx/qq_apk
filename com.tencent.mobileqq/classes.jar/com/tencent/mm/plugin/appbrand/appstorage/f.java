package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class f
  extends g
{
  private final String a;
  private final String b;
  private String c;
  private final s d;
  private volatile long e = -1L;
  
  public f(String paramString1, String paramString2, String paramString3, f.a parama)
  {
    this.c = paramString1;
    paramString1 = new com.tencent.luggage.wxa.rt.i(paramString1).l();
    this.a = paramString2;
    this.b = paramString3;
    this.d = new s(paramString1, this.a, this.b, parama);
  }
  
  @NonNull
  public j a(String paramString, long paramLong1, long paramLong2, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami)
  {
    if (!a(paramString)) {
      return j.q;
    }
    paramString = this.d.c(paramString);
    if (paramString == null) {
      return j.g;
    }
    long l = paramString.limit();
    Object localObject = a(paramLong1, paramLong2, l);
    if (localObject != j.a) {
      return localObject;
    }
    if (paramLong2 > 2147483647L) {
      paramLong2 = l - paramLong1;
    }
    int i = (int)paramLong2;
    localObject = new byte[i];
    paramString.get((byte[])localObject, (int)paramLong1, i);
    paramString = ByteBuffer.wrap((byte[])localObject);
    paramString.order(ByteOrder.BIG_ENDIAN);
    parami.a = paramString;
    return j.a;
  }
  
  @NonNull
  public j a(String paramString, FileStructStat paramFileStructStat)
  {
    if (!a(paramString)) {
      return j.q;
    }
    paramString = this.d.c(paramString);
    if (paramString == null) {
      return j.g;
    }
    if (paramFileStructStat == null) {
      return j.b;
    }
    paramFileStructStat.st_mode = 33152;
    paramFileStructStat.st_size = paramString.limit();
    return j.a;
  }
  
  public void a()
  {
    if (!k.g(this.c)) {
      o.b("MicroMsg.Luggage.BlobFileSystem", "Initialization Failed");
    }
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public boolean a(String paramString)
  {
    return af.b(paramString).startsWith(this.b);
  }
  
  @NonNull
  public j b(String paramString)
  {
    if (this.d.c(paramString) == null) {
      return j.g;
    }
    return j.a;
  }
  
  @NonNull
  public j b(String paramString, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami)
  {
    if (!a(paramString)) {
      return j.q;
    }
    paramString = this.d.c(paramString);
    if (paramString == null) {
      return j.g;
    }
    parami.a = paramString;
    return j.a;
  }
  
  public void b()
  {
    this.d.a();
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i d(String paramString)
  {
    return this.d.a(paramString);
  }
  
  public boolean e(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.f
 * JD-Core Version:    0.7.0.1
 */