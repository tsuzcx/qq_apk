package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rc.d;
import com.tencent.luggage.wxa.rr.a;
import java.io.IOException;
import java.util.Locale;
import org.apache.commons.io.FilenameUtils;

final class LuggageLocalFileObjectManager$b
  implements LuggageLocalFileObjectManager.a
{
  private LuggageLocalFileObjectManager$b(LuggageLocalFileObjectManager paramLuggageLocalFileObjectManager) {}
  
  public a a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (af.c(paramString2)) {
      str = LuggageLocalFileObjectManager.d(this.a);
    }
    try
    {
      long l = LuggageLocalFileObjectManager.a(this.a, paramString1);
      paramString1 = String.format(Locale.US, "%d|%s", new Object[] { Long.valueOf(l), str });
      try
      {
        o.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "hy: attach media obj: %s", new Object[] { paramString1 });
        paramString1 = LuggageLocalFileObjectManager.b(this.a, paramString1, LuggageLocalFileObjectManager.a(this.a));
      }
      catch (Exception paramString1)
      {
        o.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", paramString1, "attachMediaObject, enc exp = ", new Object[0]);
        paramString1 = null;
      }
      if (af.c(paramString1)) {
        return null;
      }
      paramString2 = new StringBuilder();
      paramString2.append("tmp_");
      paramString2.append(paramString1);
      paramString1 = paramString2.toString();
      paramString2 = new StringBuilder();
      paramString2.append(LuggageLocalFileObjectManager.b(this.a));
      paramString2.append(paramString1);
      paramString2 = paramString2.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(LuggageLocalFileObjectManager.c(this.a));
      localStringBuilder.append(paramString1);
      if (af.c(str))
      {
        paramString1 = "";
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append('.');
        paramString1.append(str);
        paramString1 = paramString1.toString();
      }
      localStringBuilder.append(paramString1);
      paramString1 = localStringBuilder.toString();
      o.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", new Object[] { paramString1, paramString2 });
      return a.a(paramString1, paramString2, str);
    }
    catch (Exception paramString1)
    {
      o.b("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", new Object[] { af.a(paramString1) });
    }
    return null;
  }
  
  public w a(w paramw)
  {
    w localw = null;
    if (paramw == null) {
      return null;
    }
    String str = paramw.b.replaceFirst("tmp_", "store_");
    if (i.a(paramw.b, str))
    {
      localw = new w();
      localw.b = str;
      localw.a = paramw.a.replaceFirst("tmp_", "store_");
      localw.f = paramw.f;
      localw.d = paramw.d;
      localw.g = new com.tencent.luggage.wxa.rt.i(localw.b).p();
      localw.c = paramw.c;
      localw.e = true;
    }
    return localw;
  }
  
  public w a(String paramString)
  {
    boolean bool = paramString.startsWith("store_");
    Object localObject2 = null;
    Object localObject3 = "tmp_";
    if ((!bool) && (!paramString.startsWith("tmp_"))) {
      return null;
    }
    Object localObject5 = FilenameUtils.getExtension(paramString);
    String str = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
    Object localObject1 = str;
    if (!af.c((String)localObject5))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("\\.");
      ((StringBuilder)localObject1).append((String)localObject5);
      localObject1 = str.replaceFirst(((StringBuilder)localObject1).toString(), "");
    }
    if (af.c((String)localObject1)) {
      return LuggageLocalFileObjectManager.e();
    }
    try
    {
      str = LuggageLocalFileObjectManager.a(this.a, (String)localObject1, LuggageLocalFileObjectManager.a(this.a));
      localObject2 = str;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObject, decrypt exp ", new Object[0]);
    }
    if (af.c((String)localObject2))
    {
      o.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
      return LuggageLocalFileObjectManager.e();
    }
    Object localObject4 = ((String)localObject2).split("\\|");
    if ((localObject4 != null) && (localObject4.length == 2))
    {
      localObject2 = localObject3;
      if (paramString.startsWith("store_")) {
        localObject2 = "store_";
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(LuggageLocalFileObjectManager.b(this.a));
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject3).toString();
      long l1 = af.a(localObject4[0], 0L);
      localObject3 = localObject4[1];
      if (!((String)localObject3).equalsIgnoreCase((String)localObject5)) {
        return LuggageLocalFileObjectManager.e();
      }
      try
      {
        long l2 = LuggageLocalFileObjectManager.a(this.a, (String)localObject1);
        if (l1 != l2)
        {
          o.b("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString });
          paramString = LuggageLocalFileObjectManager.e();
          return paramString;
        }
        localObject4 = new w();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(LuggageLocalFileObjectManager.c(this.a));
        ((StringBuilder)localObject5).append(paramString);
        ((w)localObject4).a = ((StringBuilder)localObject5).toString();
        ((w)localObject4).b = ((String)localObject1);
        ((w)localObject4).c = d.a((String)localObject3);
        ((w)localObject4).e = ((String)localObject2).equalsIgnoreCase("store_");
        paramString = new com.tencent.luggage.wxa.rt.i(((w)localObject4).b);
        ((w)localObject4).g = paramString.p();
        ((w)localObject4).f = paramString.q();
        return localObject4;
      }
      catch (IOException paramString)
      {
        o.b("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { af.a(paramString) });
        return LuggageLocalFileObjectManager.e();
      }
    }
    return LuggageLocalFileObjectManager.e();
  }
  
  public w b(String paramString)
  {
    Object localObject2 = "";
    String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
    StringBuilder localStringBuilder = null;
    try
    {
      String str1 = LuggageLocalFileObjectManager.a(this.a, str2, LuggageLocalFileObjectManager.a(this.a));
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
      localObject1 = null;
    }
    if (af.c((String)localObject1)) {
      return null;
    }
    String[] arrayOfString = ((String)localObject1).split("\\|");
    Object localObject1 = localStringBuilder;
    if (arrayOfString != null)
    {
      if (arrayOfString.length != 2) {
        return null;
      }
      localObject1 = arrayOfString[1];
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(LuggageLocalFileObjectManager.c(this.a));
      localStringBuilder.append(paramString);
      if (af.c((String)localObject1))
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(".");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      localStringBuilder.append((String)localObject1);
      localObject2 = localStringBuilder.toString();
      localObject1 = new w();
      ((w)localObject1).a = ((String)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(LuggageLocalFileObjectManager.b(this.a));
      ((StringBuilder)localObject2).append(paramString);
      ((w)localObject1).b = ((StringBuilder)localObject2).toString();
      ((w)localObject1).d = str2;
      ((w)localObject1).e = paramString.startsWith("store_");
      paramString = new com.tencent.luggage.wxa.rt.i(((w)localObject1).b);
      ((w)localObject1).g = paramString.p();
      ((w)localObject1).f = paramString.q();
    }
    return localObject1;
  }
  
  public String toString()
  {
    return "V2MediaObjectInfoHandler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.b
 * JD-Core Version:    0.7.0.1
 */