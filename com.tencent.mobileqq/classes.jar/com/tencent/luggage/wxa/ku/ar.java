package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.util.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class ar
  extends d
{
  @NonNull
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("destPath");
    String str1 = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    String str2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    Object localObject = paramc.getFileSystem().g(paramString);
    boolean bool = paramc.getFileSystem().e(paramString);
    if ((localObject != null) && (((com.tencent.luggage.wxa.rt.i)localObject).j()) && (((com.tencent.luggage.wxa.rt.i)localObject).o()))
    {
      if (k.d((com.tencent.luggage.wxa.rt.i)localObject)) {
        return new f.a("fail \"%s\" not a regular file", new Object[] { paramString });
      }
      paramc = paramc.getFileSystem().a(paramJSONObject, (com.tencent.luggage.wxa.rt.i)localObject, false);
    }
    else
    {
      if (!bool) {
        return new f.a(str2, new Object[0]);
      }
      localObject = new com.tencent.luggage.wxa.pc.i();
      paramc.getFileSystem().b(paramString, (com.tencent.luggage.wxa.pc.i)localObject);
      if (((com.tencent.luggage.wxa.pc.i)localObject).a == null) {
        return new f.a(str1, new Object[0]);
      }
      paramString = new a((ByteBuffer)((com.tencent.luggage.wxa.pc.i)localObject).a);
      paramc = paramc.getFileSystem().a(paramJSONObject, paramString, false);
      af.a(paramString);
    }
    switch (ar.1.a[paramc.ordinal()])
    {
    default: 
      paramString = new StringBuilder();
      paramString.append("fail ");
      paramString.append(paramc.name());
      return new f.a(paramString.toString(), new Object[0]);
    case 7: 
      return new f.a("ok", new Object[0]);
    case 6: 
      return new f.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
    case 5: 
      return new f.a("fail \"%s\" is not a regular file", new Object[] { paramJSONObject });
    case 4: 
      return new f.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramJSONObject });
    case 3: 
      return new f.a("fail sdcard not mounted", new Object[0]);
    case 2: 
      return new f.a(str1, new Object[0]);
    }
    return new f.a(str2, new Object[0]);
  }
  
  protected String a(@NonNull JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("srcPath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.ar
 * JD-Core Version:    0.7.0.1
 */