package com.tencent.map.sdk.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.map.tools.net.AdapterType;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.http.HttpResponseListener;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public final class fj
{
  static String a(String paramString, fn paramfn)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject1 = new URL(URLDecoder.decode(paramString, "UTF-8"));
      localObject1 = new URI(((URL)localObject1).getProtocol(), ((URL)localObject1).getUserInfo(), ((URL)localObject1).getHost(), ((URL)localObject1).getPort(), ((URL)localObject1).getPath(), ((URL)localObject1).getQuery(), ((URL)localObject1).getRef()).toASCIIString();
      paramString = (String)localObject1;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      localURISyntaxException.printStackTrace();
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    Object localObject2 = paramString;
    if (paramfn != null)
    {
      String str = Uri.encode(paramfn.toString(), "=&").trim();
      localObject2 = paramString;
      if (!str.equals(""))
      {
        paramfn = "?";
        localObject2 = paramString;
        if (!str.equals("?"))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          if (paramString.contains("?")) {
            paramfn = "&";
          }
          ((StringBuilder)localObject2).append(paramfn);
          paramString = ((StringBuilder)localObject2).toString();
          paramfn = new StringBuilder();
          paramfn.append(paramString);
          paramfn.append(str);
          localObject2 = paramfn.toString();
        }
      }
    }
    return localObject2;
  }
  
  public static <T extends BaseObject> void a(Context paramContext, String paramString, fn paramfn, Class<T> paramClass, HttpResponseListener<T> paramHttpResponseListener)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("halley_app_id", 3203);
    ((Bundle)localObject).putString("halley_app_name", pz.a);
    ((Bundle)localObject).putString("halley_app_version", "android_search1.1.7.1");
    localObject = NetManager.buildAdapter(AdapterType.Halley, (Bundle)localObject);
    NetManager.getInstance().setAdapter(paramContext, (NetAdapter)localObject);
    paramContext = ol.a(new fj.2(paramString, paramfn, paramClass));
    paramString = new fj.1(paramHttpResponseListener);
    paramContext.a(new ol.d(null)).b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fj
 * JD-Core Version:    0.7.0.1
 */