package com.tencent.luggage.wxa.cz;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ea.c;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.nl.g;
import com.tencent.luggage.wxa.ou.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.ac;

public abstract class a
{
  public final a.a a(Context paramContext, String paramString, int paramInt)
  {
    o.d("Luggage.AbsLinkOpener", "handle url = %s", new Object[] { paramString });
    Object localObject;
    if (af.c(paramString))
    {
      localObject = a.a.b;
      paramContext = null;
    }
    else
    {
      int i = paramString.indexOf('#');
      int j = paramString.indexOf('?');
      localObject = paramString;
      if (i > 0)
      {
        localObject = paramString;
        if (j > 0)
        {
          localObject = paramString;
          if (i < j)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString.substring(0, i));
            ((StringBuilder)localObject).append(paramString.substring(j, paramString.length()));
            localObject = ((StringBuilder)localObject).toString();
            o.d("Luggage.AbsLinkOpener", "replace url for parsing %s", new Object[] { localObject });
          }
        }
      }
      Uri localUri = Uri.parse((String)localObject);
      paramContext = a(paramContext, (String)localObject, localUri, paramInt);
      paramString = (String)localObject;
      localObject = paramContext;
      paramContext = localUri;
    }
    a(paramString, paramContext, paramInt, (a.a)localObject);
    return localObject;
  }
  
  final a.a a(Context paramContext, String paramString, Uri paramUri, int paramInt)
  {
    if (af.a(paramUri.getQueryParameter("debug"), 0) > 0) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject1;
    Object localObject2;
    if (i != 0)
    {
      paramInt = af.a(paramUri.getQueryParameter("ret"), 0);
      if (paramInt == 1) {
        return a.a.c;
      }
      if (paramInt == 2) {
        return a.a.d;
      }
      paramString = paramUri.getQueryParameter("appid");
      str1 = paramUri.getQueryParameter("username");
      str2 = af.b(paramUri.getQueryParameter("path"));
      localObject1 = paramUri.getQueryParameter("codeurl");
      localObject2 = paramUri.getQueryParameter("md5");
      af.a(paramUri.getQueryParameter("test_lifespan"), 7200L);
      if ((!af.c(paramString)) && (!af.c(str1)) && (!af.c((String)localObject1)))
      {
        boolean bool = ac.a().a(paramString, 1, (String)localObject1, (String)localObject2);
        o.d("Luggage.AbsLinkOpener", "updated:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          c.b.c(paramString, -1);
        }
        paramUri = paramUri.getQueryParameter("json_extinfo");
        localObject1 = new com.tencent.luggage.wxa.ie.a();
        ((com.tencent.luggage.wxa.ie.a)localObject1).c = paramUri;
        g.a().a(paramString, 1, paramUri);
        a(paramContext, paramString, str1, str2, 1, -1, new d(), null, (com.tencent.luggage.wxa.ie.a)localObject1);
        return a.a.a;
      }
      o.d("Luggage.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { paramString, str1, localObject1 });
      return a.a.b;
    }
    int i = af.a(paramUri.getQueryParameter("openType"), 0);
    if (2 == i)
    {
      paramString = paramUri.getQueryParameter("userName");
      str1 = paramUri.getQueryParameter("appId");
      str2 = paramUri.getQueryParameter("extJsonInfo");
      localObject1 = paramUri.getQueryParameter("relativeURL");
      if (TextUtils.isEmpty(str1)) {
        return a.a.b;
      }
      g.a().a(str1, i, str2);
      localObject2 = new d();
      ((d)localObject2).c = af.a(paramUri.getQueryParameter("scene"), paramInt);
      paramUri = new com.tencent.luggage.wxa.ie.a();
      paramUri.c = str2;
      a(paramContext, str1, paramString, (String)localObject1, i, -1, (d)localObject2, null, paramUri);
      return a.a.a;
    }
    paramString = paramUri.getQueryParameter("username");
    String str1 = paramUri.getQueryParameter("appid");
    if ((af.c(paramString)) && (af.c(str1)))
    {
      o.d("Luggage.AbsLinkOpener", "username = %s, invalid, return", new Object[] { paramString });
      return a.a.b;
    }
    String str2 = af.b(paramUri.getQueryParameter("path"));
    paramInt = af.a(paramUri.getQueryParameter("version"), 0);
    a(paramContext, str1, paramString, str2, af.a(paramUri.getQueryParameter("type"), 0), paramInt, new d(), null, null);
    return a.a.a;
  }
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, d paramd, j paramj, com.tencent.luggage.wxa.ie.a parama);
  
  public abstract void a(@Nullable String paramString, @Nullable Uri paramUri, int paramInt, @NonNull a.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cz.a
 * JD-Core Version:    0.7.0.1
 */