package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.util.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class l
  extends g
{
  public String a = "tmp";
  private final String b;
  private final String c;
  private final String d;
  private final LuggageLocalFileObjectManager e;
  private volatile long f = -1L;
  
  public l(String paramString1, String paramString2, String paramString3)
  {
    this.b = new com.tencent.luggage.wxa.rt.i(paramString1).l();
    this.c = paramString2;
    this.d = paramString3;
    this.e = new LuggageLocalFileObjectManager(this.b, this.c, this.d);
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i a(String paramString, boolean paramBoolean)
  {
    return g(paramString);
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.pc.i<String> parami)
  {
    parami.a = this.b;
    return j.a;
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.rt.i parami, String paramString, com.tencent.luggage.wxa.pc.i<String> parami1)
  {
    if ((parami != null) && (parami.j()))
    {
      if ((TextUtils.isEmpty(paramString)) && (parami1 != null))
      {
        if ((this.f > 0L) && (this.e.d() + parami.q() > this.f)) {
          return j.p;
        }
        paramString = this.e.b(parami.d());
        if (paramString != null)
        {
          if (paramString.e)
          {
            parami1.a = paramString.a;
            return j.a;
          }
          parami1.a = this.e.a(paramString).a;
          return j.a;
        }
        parami = this.e.a(parami.l());
        parami1.a = this.e.a(parami).a;
        return j.a;
      }
      return j.q;
    }
    return j.b;
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.rt.i parami, String paramString, boolean paramBoolean, com.tencent.luggage.wxa.pc.i<String> parami1)
  {
    o.d("MicroMsg.Luggage.FlattenFileSystem", "createTempFileFrom src[%s] suffix[%s] deleteSrc[%b]", new Object[] { parami, paramString, Boolean.valueOf(paramBoolean) });
    parami = this.e.a(parami.l(), paramString, paramBoolean);
    if (parami == null) {
      return j.b;
    }
    parami1.a = parami.a;
    return j.a;
  }
  
  @NonNull
  public j a(String paramString, long paramLong1, long paramLong2, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami)
  {
    paramString = this.e.c(paramString);
    if ((paramString != null) && (com.tencent.luggage.wxa.rt.k.h(paramString.b)))
    {
      paramString = new com.tencent.luggage.wxa.rt.i(paramString.b);
      j localj = a(paramLong1, paramLong2, paramString.q());
      if (localj != j.a) {
        return localj;
      }
      long l = paramLong2;
      if (paramLong2 == 9223372036854775807L) {
        l = paramString.q() - paramLong1;
      }
      parami.a = k.a(paramString, paramLong1, l);
      return j.a;
    }
    return j.g;
  }
  
  @NonNull
  public j a(String paramString, com.tencent.luggage.wxa.pc.i<List<h>> parami)
  {
    Object localObject = new LinkedList();
    b.a((List)localObject, this.e.a());
    b.a((List)localObject, this.e.c());
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      w localw = (w)((Iterator)localObject).next();
      h localh = new h();
      localh.a = localw.a;
      paramString.add(localh);
    }
    parami.a = paramString;
    return j.a;
  }
  
  @NonNull
  public j a(String paramString, FileStructStat paramFileStructStat)
  {
    paramString = this.e.c(paramString);
    if ((paramString != null) && (com.tencent.luggage.wxa.rt.k.h(paramString.b)))
    {
      if (paramFileStructStat == null) {
        return j.b;
      }
      if (FileStat.a(paramString.b, paramFileStructStat) == 0) {
        return j.a;
      }
      return j.b;
    }
    return j.g;
  }
  
  public void a()
  {
    if (!com.tencent.luggage.wxa.rt.k.g(this.b)) {
      o.b("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
    }
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public boolean a(String paramString)
  {
    return af.b(paramString).startsWith(this.d);
  }
  
  @NonNull
  public j b(String paramString)
  {
    paramString = this.e.c(paramString);
    if ((paramString != null) && (com.tencent.luggage.wxa.rt.k.h(paramString.b))) {
      return j.a;
    }
    return j.g;
  }
  
  @NonNull
  public j b(String paramString, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami)
  {
    paramString = this.e.c(paramString);
    if ((paramString != null) && (com.tencent.luggage.wxa.rt.k.h(paramString.b)))
    {
      parami.a = k.b(new com.tencent.luggage.wxa.rt.i(paramString.b));
      return j.a;
    }
    return j.g;
  }
  
  @Nullable
  public List<w> c()
  {
    return this.e.a();
  }
  
  public String d()
  {
    return this.b;
  }
  
  public void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("/dir.lock");
    com.tencent.luggage.wxa.rt.k.i(localStringBuilder.toString());
  }
  
  @NonNull
  public j f(String paramString)
  {
    return j.e;
  }
  
  public String f()
  {
    return this.d;
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i g(String paramString)
  {
    paramString = this.e.c(paramString);
    if (paramString == null) {
      return null;
    }
    return new com.tencent.luggage.wxa.rt.i(paramString.b);
  }
  
  public com.tencent.luggage.wxa.rt.i i(String paramString)
  {
    com.tencent.luggage.wxa.rt.k.g(this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    return new com.tencent.luggage.wxa.rt.i(localStringBuilder.toString());
  }
  
  public boolean j(String paramString)
  {
    paramString = this.e.c(paramString);
    return (paramString != null) && (paramString.e);
  }
  
  public String l(String paramString)
  {
    paramString = this.e.c(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.l
 * JD-Core Version:    0.7.0.1
 */