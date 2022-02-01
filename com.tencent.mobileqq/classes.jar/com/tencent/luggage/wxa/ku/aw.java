package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.util.Locale;
import org.json.JSONObject;

final class aw
  extends d
{
  @NonNull
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    Object localObject = paramc.getFileSystem();
    if (localObject == null) {
      return new f.a("fail:internal error", new Object[0]);
    }
    String str2 = paramJSONObject.optString("newPath");
    paramJSONObject = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    String str1 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    if (!((o)localObject).h(paramString)) {
      return new f.a(str1, new Object[0]);
    }
    localObject = paramc.getFileSystem().a(paramString, true);
    if ((localObject != null) && (((i)localObject).j()))
    {
      if (k.d((i)localObject)) {
        return new f.a("fail \"%s\" not a regular file", new Object[] { paramString });
      }
      paramc = paramc.getFileSystem().a(str2, (i)localObject, true);
      int i = aw.1.a[paramc.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              paramString = new StringBuilder();
              paramString.append("fail ");
              paramString.append(paramc.name());
              return new f.a(paramString.toString(), new Object[0]);
            }
            return new f.a("ok", new Object[0]);
          }
          return new f.a("fail sdcard not mounted", new Object[0]);
        }
        return new f.a(paramJSONObject, new Object[0]);
      }
      return new f.a(str1, new Object[0]);
    }
    return new f.a(paramJSONObject, new Object[0]);
  }
  
  protected String a(@NonNull JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("oldPath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.aw
 * JD-Core Version:    0.7.0.1
 */