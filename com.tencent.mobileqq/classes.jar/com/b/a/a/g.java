package com.b.a.a;

import com.b.a.m;
import com.b.a.n.a;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class g
  extends f
{
  private final n.a a;
  private final SSLSocketFactory b;
  
  public g()
  {
    this(null);
  }
  
  private g(n.a parama)
  {
    this(null, null);
  }
  
  private g(n.a parama, SSLSocketFactory paramSSLSocketFactory)
  {
    this.a = parama;
    this.b = null;
  }
  
  private static InputStream a(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      InputStream localInputStream = paramHttpURLConnection.getInputStream();
      return localInputStream;
    }
    catch (IOException localIOException)
    {
      label7:
      break label7;
    }
    return paramHttpURLConnection.getErrorStream();
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, m<?> paramm)
  {
    byte[] arrayOfByte = paramm.k();
    if (arrayOfByte != null) {
      a(paramHttpURLConnection, paramm, arrayOfByte);
    }
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, m<?> paramm, byte[] paramArrayOfByte)
  {
    paramHttpURLConnection.setDoOutput(true);
    paramHttpURLConnection.addRequestProperty("Content-Type", paramm.j());
    paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
    paramHttpURLConnection.write(paramArrayOfByte);
    paramHttpURLConnection.close();
  }
  
  public final e a(m<?> paramm, Map<String, String> paramMap)
  {
    Object localObject = paramm.c();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramm.g());
    localHashMap.putAll(paramMap);
    paramMap = this.a;
    if (paramMap != null)
    {
      paramMap = paramMap.a();
      if (paramMap == null)
      {
        paramm = new StringBuilder("URL blocked by rewriter: ");
        paramm.append((String)localObject);
        throw new IOException(paramm.toString());
      }
    }
    else
    {
      paramMap = (Map<String, String>)localObject;
    }
    paramMap = new URL(paramMap);
    localObject = (HttpURLConnection)paramMap.openConnection();
    ((HttpURLConnection)localObject).setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    int i = paramm.n();
    ((HttpURLConnection)localObject).setConnectTimeout(i);
    ((HttpURLConnection)localObject).setReadTimeout(i);
    int j = 0;
    ((HttpURLConnection)localObject).setUseCaches(false);
    ((HttpURLConnection)localObject).setDoInput(true);
    if ("https".equals(paramMap.getProtocol()))
    {
      paramMap = this.b;
      if (paramMap != null) {
        ((HttpsURLConnection)localObject).setSSLSocketFactory(paramMap);
      }
    }
    paramMap = localHashMap.keySet().iterator();
    while (paramMap.hasNext())
    {
      String str = (String)paramMap.next();
      ((HttpURLConnection)localObject).addRequestProperty(str, (String)localHashMap.get(str));
    }
    switch (paramm.a())
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case 7: 
      paramMap = "PATCH";
      break;
    case 6: 
      paramMap = "TRACE";
      break;
    case 5: 
      paramMap = "OPTIONS";
      break;
    case 4: 
      paramMap = "HEAD";
      break;
    case 3: 
      paramMap = "DELETE";
      break;
    case 2: 
      paramMap = "PUT";
      ((HttpURLConnection)localObject).setRequestMethod(paramMap);
      break;
    case 1: 
      ((HttpURLConnection)localObject).setRequestMethod("POST");
      a((HttpURLConnection)localObject, paramm);
      break;
    case 0: 
      paramMap = "GET";
      ((HttpURLConnection)localObject).setRequestMethod(paramMap);
      break;
    }
    paramMap = paramm.h();
    if (paramMap != null)
    {
      ((HttpURLConnection)localObject).setRequestMethod("POST");
      a((HttpURLConnection)localObject, paramm, paramMap);
    }
    int k = ((HttpURLConnection)localObject).getResponseCode();
    if (k != -1)
    {
      i = j;
      if (paramm.a() != 4) {
        if (100 <= k)
        {
          i = j;
          if (k < 200) {}
        }
        else
        {
          i = j;
          if (k != 204)
          {
            i = j;
            if (k != 304) {
              i = 1;
            }
          }
        }
      }
      if (i == 0) {
        return new e(k, ((HttpURLConnection)localObject).getHeaderFields());
      }
      return new e(k, ((HttpURLConnection)localObject).getHeaderFields(), ((HttpURLConnection)localObject).getContentLength(), a((HttpURLConnection)localObject));
    }
    paramm = new IOException("Could not retrieve response code from HttpUrlConnection.");
    for (;;)
    {
      throw paramm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */