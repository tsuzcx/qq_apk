package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pc.c;
import com.tencent.luggage.wxa.pd.v;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rr.a;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import org.apache.commons.io.FilenameUtils;

@Deprecated
public final class AppBrandLocalMediaObjectManager
{
  private static String a;
  private static final Collection<AppBrandLocalMediaObjectManager.a> b;
  private static final d c = new AppBrandLocalMediaObjectManager.2();
  
  static
  {
    Object localObject2 = c.a();
    Object localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("wxafiles/");
    a = ((StringBuilder)localObject2).toString();
    localObject2 = i.a(r.a().getExternalCacheDir());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = i.a(r.a().getCacheDir());
    }
    a(((i)localObject1).l());
    localObject1 = new LinkedList();
    ((Collection)localObject1).add(new AppBrandLocalMediaObjectManager.b(null));
    b = Collections.unmodifiableCollection((Collection)localObject1);
  }
  
  private static <T extends d> T a(String paramString1, String paramString2, Class<T> paramClass, String paramString3, boolean paramBoolean)
  {
    if (af.c(paramString1)) {
      return null;
    }
    if (!k.h(paramString2)) {
      return null;
    }
    String str = b(FilenameUtils.getExtension(paramString2), paramString3);
    Iterator localIterator = b.iterator();
    paramString3 = null;
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = ((AppBrandLocalMediaObjectManager.a)localIterator.next()).a(paramString1, paramString2, str);
      paramString3 = (String)localObject;
      if (localObject != null) {
        paramString3 = (String)localObject;
      }
    }
    if ((paramString3 != null) && (paramString3.a() >= 2))
    {
      try
      {
        localObject = (d)paramClass.newInstance();
        ((d)localObject).a = ((String)paramString3.a(0));
        ((d)localObject).c = com.tencent.luggage.wxa.rc.d.a(str);
        ((d)localObject).b = ((String)paramString3.a(1));
        if (af.c(((d)localObject).b))
        {
          o.b("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
          return null;
        }
        paramClass = str;
        if (af.c(str)) {
          paramClass = c();
        }
        ((d)localObject).d = af.a((String)paramString3.a(3), paramClass);
        if (a(paramBoolean, paramString2, ((d)localObject).b))
        {
          paramString2 = new i(((d)localObject).b);
          ((d)localObject).f = paramString2.q();
          ((d)localObject).g = paramString2.p();
          paramClass = (p)com.tencent.luggage.wxa.ba.e.b(p.class);
          if (paramClass != null) {
            paramClass.a(paramString1, paramString2);
          }
          return localObject;
        }
      }
      catch (Exception paramString1)
      {
        o.a("MicroMsg.AppBrand.LocalMediaObjectManager", paramString1, "", new Object[0]);
      }
      return null;
    }
    int i;
    if (paramString3 == null) {
      i = -1;
    } else {
      i = paramString3.a();
    }
    o.b("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
    return null;
  }
  
  public static d a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramString1, paramString2, d.class, paramString3, paramBoolean);
  }
  
  public static String a()
  {
    return a;
  }
  
  public static void a(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.endsWith("/"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("/");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new StringBuilder();
    paramString.append((String)localObject);
    paramString.append("wxafiles/");
    a = paramString.toString();
  }
  
  private static boolean a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (k.c(paramString1, paramString2))) {
      return true;
    }
    return (!paramBoolean) && (k.b(paramString1, paramString2) >= 0L);
  }
  
  private static String b(String paramString1, String paramString2)
  {
    if (af.c(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  private static String c()
  {
    return "unknown";
  }
  
  private static String c(String paramString1, String paramString2)
  {
    return af.b(new v().b(paramString1.getBytes(), paramString2.getBytes()));
  }
  
  private static String d(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  private static String e(@NonNull String paramString)
  {
    paramString = d(paramString);
    com.tencent.luggage.wxa.qz.e.a(paramString);
    try
    {
      new i(paramString, ".nomedia").v();
      return paramString;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  private static long f(String paramString)
  {
    paramString = k.a(paramString);
    CheckedInputStream localCheckedInputStream = new CheckedInputStream(paramString, new Adler32());
    byte[] arrayOfByte = new byte[2048];
    while (localCheckedInputStream.read(arrayOfByte) >= 0) {}
    long l = localCheckedInputStream.getChecksum().getValue();
    af.a(localCheckedInputStream);
    af.a(paramString);
    return l;
  }
  
  @Keep
  public static String genMediaFilePath(String paramString1, String paramString2)
  {
    if ((!af.c(paramString1)) && (!af.c(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(e(paramString1));
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager
 * JD-Core Version:    0.7.0.1
 */