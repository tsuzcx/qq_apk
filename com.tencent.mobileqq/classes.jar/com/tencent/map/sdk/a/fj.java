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
      localObject = null;
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          try
          {
            localObject = new URL(URLDecoder.decode(paramString, "UTF-8"));
            localObject = new URI(((URL)localObject).getProtocol(), ((URL)localObject).getUserInfo(), ((URL)localObject).getHost(), ((URL)localObject).getPort(), ((URL)localObject).getPath(), ((URL)localObject).getQuery(), ((URL)localObject).getRef()).toASCIIString();
            paramString = (String)localObject;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              localUnsupportedEncodingException.printStackTrace();
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              localMalformedURLException.printStackTrace();
            }
          }
          catch (URISyntaxException localURISyntaxException)
          {
            for (;;)
            {
              localURISyntaxException.printStackTrace();
              continue;
              paramString = "?";
            }
          }
          localObject = paramString;
        } while (paramfn == null);
        paramfn = Uri.encode(paramfn.toString(), "=&").trim();
        localObject = paramString;
      } while (paramfn.equals(""));
      localObject = paramString;
    } while (paramfn.equals("?"));
    Object localObject = new StringBuilder().append(paramString);
    if (paramString.contains("?"))
    {
      paramString = "&";
      paramString = paramString;
      return paramString + paramfn;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.fj
 * JD-Core Version:    0.7.0.1
 */