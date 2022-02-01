package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;

public class x
  extends g
{
  private final String a;
  private final String b;
  private volatile long c = -1L;
  private final x.b d = new x.1(this);
  private final x.b e = new x.7(this);
  private final x.a f = new x.8(this);
  private final x.a g = new x.9(this);
  private final x.a h = new x.10(this);
  private final x.a i = new x.11(this);
  private final x.a j = new x.12(this);
  private final x.b k = new x.13(this);
  private final x.a l = new x.14(this);
  private final x.a m = new x.2(this);
  private final x.a n = new x.3(this);
  private final x.a o = new x.4(this);
  private final x.a p = new x.5(this);
  
  public x(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    o.d("MicroMsg.LuggageNonFlattenedFileSystem", "mRootPath:%s mPathPrefix:%s", new Object[] { this.a, this.b });
  }
  
  private j a(String paramString, x.a parama, boolean paramBoolean, Object... paramVarArgs)
  {
    if (af.c(paramString)) {
      return j.e;
    }
    if (this.b.endsWith("/"))
    {
      localObject1 = this.b;
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append("/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2;
    if (paramString.equals(this.b))
    {
      localObject2 = localObject1;
    }
    else
    {
      localObject2 = paramString;
      if (!paramString.startsWith((String)localObject1)) {
        return j.e;
      }
    }
    paramString = k.a(((String)localObject2).replaceFirst(Pattern.quote(this.b), "")).replace("", "");
    Object localObject1 = g();
    if (localObject1 == null) {
      return j.c;
    }
    paramString = FilenameUtils.concat(((com.tencent.luggage.wxa.rt.i)localObject1).l(), paramString);
    if (af.c(paramString)) {
      return j.e;
    }
    paramString = new com.tencent.luggage.wxa.rt.i(paramString);
    if (!a(paramString)) {
      return j.e;
    }
    if ((!paramBoolean) && (!paramString.g().j())) {
      return j.d;
    }
    return parama.a(paramString, paramVarArgs);
  }
  
  private j a(String paramString, x.a parama, Object... paramVarArgs)
  {
    return a(paramString, parama, false, paramVarArgs);
  }
  
  private boolean a(com.tencent.luggage.wxa.rt.i parami)
  {
    com.tencent.luggage.wxa.rt.i locali = g();
    return (locali != null) && (a(locali, parami));
  }
  
  private static boolean a(@NonNull com.tencent.luggage.wxa.rt.i parami1, @NonNull com.tencent.luggage.wxa.rt.i parami2)
  {
    while (parami2 != null)
    {
      if (parami1.equals(parami2)) {
        return true;
      }
      parami2 = parami2.g();
    }
    return false;
  }
  
  @Nullable
  private com.tencent.luggage.wxa.rt.i g()
  {
    if (TextUtils.isEmpty(this.a)) {
      return null;
    }
    com.tencent.luggage.wxa.rt.i locali = new com.tencent.luggage.wxa.rt.i(this.a);
    if ((locali.j()) && (locali.o())) {
      locali.w();
    }
    locali.u();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(locali.b());
      localStringBuilder.append("/.nomedia");
      new com.tencent.luggage.wxa.rt.i(localStringBuilder.toString()).v();
      return locali;
    }
    catch (Exception localException) {}
    return locali;
  }
  
  private long h()
  {
    return k.a(new com.tencent.luggage.wxa.rt.i(this.a));
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i a(String paramString, boolean paramBoolean)
  {
    Object localObject = new com.tencent.luggage.wxa.pc.i();
    a(paramString, this.o, new Object[] { localObject });
    localObject = (com.tencent.luggage.wxa.rt.i)((com.tencent.luggage.wxa.pc.i)localObject).a;
    if (localObject == null)
    {
      o.b("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), get null file", new Object[] { paramString });
      return null;
    }
    if (!((com.tencent.luggage.wxa.rt.i)localObject).j())
    {
      o.b("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), file not exists", new Object[] { paramString });
      return null;
    }
    if ((!paramBoolean) && (!((com.tencent.luggage.wxa.rt.i)localObject).o()))
    {
      o.b("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), not a file", new Object[] { paramString });
      return null;
    }
    if (k.d((com.tencent.luggage.wxa.rt.i)localObject))
    {
      o.b("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), symlink file", new Object[] { paramString });
      return null;
    }
    return localObject;
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.pc.i<String> parami)
  {
    return j.q;
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.rt.i parami, String paramString, com.tencent.luggage.wxa.pc.i<String> parami1)
  {
    if (!a(paramString)) {
      return j.q;
    }
    if ((parami != null) && (parami.j()))
    {
      if (TextUtils.isEmpty(paramString)) {
        return j.q;
      }
      long l1 = h() + parami.q();
      if ((this.c > 0L) && (l1 > this.c))
      {
        o.b("MicroMsg.LuggageNonFlattenedFileSystem", "saveFile exceed directory max size, MAX_SIZE[%d MB], TOTAL_SIZE[%d MB]", new Object[] { Long.valueOf(this.c / 1048576L), Long.valueOf(l1 / 1048576L) });
        return j.p;
      }
      j localj = c(paramString);
      if ((localj != j.g) && (localj != j.i)) {
        return localj;
      }
      try
      {
        parami = a(paramString, new x.6(this, parami, parami1, paramString), new Object[0]);
        return parami;
      }
      catch (Exception parami)
      {
        o.a("MicroMsg.LuggageNonFlattenedFileSystem", parami, "saveFile() error", new Object[0]);
        return j.b;
      }
    }
    return j.b;
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.rt.i parami, String paramString, boolean paramBoolean, com.tencent.luggage.wxa.pc.i<String> parami1)
  {
    return j.q;
  }
  
  @NonNull
  public j a(String paramString, long paramLong1, long paramLong2, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami)
  {
    return a(paramString, this.i, new Object[] { parami, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  @NonNull
  public j a(String paramString, com.tencent.luggage.wxa.pc.i<List<h>> parami)
  {
    return a(paramString, this.h, new Object[] { parami });
  }
  
  @NonNull
  public j a(String paramString, @NonNull com.tencent.luggage.wxa.rt.i parami)
  {
    return a(paramString, this.p, new Object[] { parami });
  }
  
  @NonNull
  public j a(String paramString, com.tencent.luggage.wxa.rt.i parami, boolean paramBoolean)
  {
    return a(paramString, this.n, new Object[] { parami, Boolean.valueOf(paramBoolean) });
  }
  
  @NonNull
  public j a(String paramString, @NonNull FileStructStat paramFileStructStat)
  {
    return a(paramString, this.l, new Object[] { paramFileStructStat });
  }
  
  @NonNull
  public j a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    if (paramInputStream == null) {
      return j.b;
    }
    return a(paramString, this.j, new Object[] { paramInputStream, Boolean.valueOf(paramBoolean) });
  }
  
  @NonNull
  public j a(String paramString, List<v> paramList)
  {
    return a(paramString, this.m, new Object[] { paramList });
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.rt.i locali = g();
    if ((locali == null) || (!locali.j())) {
      o.b("MicroMsg.LuggageNonFlattenedFileSystem", "Initialization Failed");
    }
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public boolean a(String paramString)
  {
    return af.b(paramString).startsWith(this.b);
  }
  
  @NonNull
  public j b(String paramString)
  {
    return a(paramString, this.d, new Object[0]);
  }
  
  @NonNull
  public j b(String paramString, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami)
  {
    return a(paramString, this.i, new Object[] { parami });
  }
  
  @NonNull
  public j b(String paramString, boolean paramBoolean)
  {
    return a(paramString, this.f, paramBoolean, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void b() {}
  
  @NonNull
  public j c(String paramString)
  {
    return a(paramString, this.e, new Object[0]);
  }
  
  @NonNull
  public j c(String paramString, boolean paramBoolean)
  {
    return a(paramString, this.g, paramBoolean, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  @Nullable
  public List<o.a> c()
  {
    return null;
  }
  
  public String d()
  {
    return this.a;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public long f()
  {
    return this.c;
  }
  
  @NonNull
  public j f(String paramString)
  {
    return a(paramString, this.k, new Object[0]);
  }
  
  public boolean h(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x
 * JD-Core Version:    0.7.0.1
 */