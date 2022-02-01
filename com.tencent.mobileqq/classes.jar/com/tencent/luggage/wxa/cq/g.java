package com.tencent.luggage.wxa.cq;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.opensdk.OpenSDKApiContentProvider;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.r;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

final class g<CONTEXT extends com.tencent.luggage.wxa.jx.h>
{
  @Nullable
  private com.tencent.luggage.wxa.dq.c a(CONTEXT paramCONTEXT)
  {
    if (paramCONTEXT.q() == null)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.ShareWithSnapshot", "getPageViewLu runtime is null, return");
      return null;
    }
    paramCONTEXT = paramCONTEXT.q().C().getCurrentPage().getCurrentPageView();
    if ((paramCONTEXT instanceof com.tencent.luggage.wxa.dq.c)) {
      return (com.tencent.luggage.wxa.dq.c)paramCONTEXT;
    }
    return null;
  }
  
  private com.tencent.luggage.wxa.ro.d<String> a(com.tencent.luggage.wxa.dq.c paramc)
  {
    return paramc.q_().b(new g.6(this));
  }
  
  private String a(@NonNull JSONObject paramJSONObject, @NonNull CONTEXT paramCONTEXT)
  {
    String str = paramJSONObject.optString("imageUrl");
    if (af.c(str))
    {
      paramJSONObject = a(paramCONTEXT);
      if (paramJSONObject != null)
      {
        paramJSONObject.a(null);
        com.tencent.luggage.wxa.ro.h.a(a(paramJSONObject));
        return str;
      }
      com.tencent.luggage.wxa.qz.o.b("Luggage.ShareWithSnapshot", "curPageView is null, return");
      return str;
    }
    paramJSONObject = str;
    if (!str.startsWith("http://"))
    {
      if (str.startsWith("https://")) {
        return str;
      }
      if (str.startsWith("wxfile://")) {
        return c.a(paramCONTEXT.getFileSystem().g(str));
      }
      paramJSONObject = str;
      if (!str.startsWith("http://"))
      {
        paramJSONObject = str;
        if (!str.startsWith("https://")) {
          paramJSONObject = c.a(r.a(paramCONTEXT.q(), str));
        }
      }
    }
    return paramJSONObject;
  }
  
  private String b(@NonNull CONTEXT paramCONTEXT, @NonNull JSONObject paramJSONObject, int paramInt)
  {
    String str1 = paramJSONObject.optString("imageUrl");
    if (af.c(str1))
    {
      paramJSONObject = str1;
      try
      {
        String str2 = OpenSDKApiContentProvider.a("temp.png");
        paramJSONObject = str1;
        Object localObject = new File(str2);
        paramJSONObject = str1;
        ((File)localObject).createNewFile();
        paramJSONObject = str1;
        Context localContext = paramCONTEXT.getContext();
        paramJSONObject = str1;
        StringBuilder localStringBuilder = new StringBuilder();
        paramJSONObject = str1;
        localStringBuilder.append(paramCONTEXT.getContext().getPackageName());
        paramJSONObject = str1;
        localStringBuilder.append(".openapidata");
        paramJSONObject = str1;
        localObject = com.tencent.luggage.opensdk.c.a(localContext, localStringBuilder.toString(), (File)localObject);
        paramJSONObject = str1;
        paramCONTEXT.getContext().grantUriPermission("com.tencent.mm", (Uri)localObject, 1);
        paramJSONObject = str1;
        str1 = ((Uri)localObject).toString();
        paramJSONObject = str1;
        paramCONTEXT = a(paramCONTEXT);
        if (paramCONTEXT == null) {
          return null;
        }
        paramJSONObject = str1;
        paramCONTEXT.a(null);
        paramJSONObject = str1;
        paramCONTEXT.q_().b(new g.3(this, (Uri)localObject, str2)).a(new g.2(this)).a(new g.1(this));
        return str1;
      }
      catch (IOException paramCONTEXT)
      {
        com.tencent.luggage.wxa.qz.o.a("Luggage.ShareWithSnapshot", paramCONTEXT, "", new Object[0]);
        return paramJSONObject;
      }
    }
    if (!str1.startsWith("http://")) {
      str1.startsWith("https://");
    }
    return str1;
  }
  
  com.tencent.luggage.wxa.ro.d<Void> a(@NonNull CONTEXT paramCONTEXT, @NonNull JSONObject paramJSONObject, int paramInt)
  {
    return com.tencent.luggage.wxa.ro.h.a().a(new g.5(this, paramCONTEXT, paramJSONObject, paramInt)).a(new g.4(this, paramJSONObject));
  }
  
  public void a(@NonNull JSONObject paramJSONObject, String paramString)
  {
    if (!af.c(paramString)) {
      try
      {
        paramJSONObject.remove("imageUrl");
        paramJSONObject.put("imageUrl", paramString);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        com.tencent.luggage.wxa.qz.o.a("Luggage.ShareWithSnapshot", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.g
 * JD-Core Version:    0.7.0.1
 */