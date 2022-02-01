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
    catch (IOException localIOException) {}
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
    String str;
    if (this.a != null)
    {
      str = this.a.a();
      paramMap = str;
      if (str == null) {
        throw new IOException("URL blocked by rewriter: " + (String)localObject);
      }
    }
    else
    {
      paramMap = (Map<String, String>)localObject;
    }
    localObject = new URL(paramMap);
    paramMap = (HttpURLConnection)((URL)localObject).openConnection();
    paramMap.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    int i = paramm.n();
    paramMap.setConnectTimeout(i);
    paramMap.setReadTimeout(i);
    paramMap.setUseCaches(false);
    paramMap.setDoInput(true);
    if (("https".equals(((URL)localObject).getProtocol())) && (this.b != null)) {
      ((HttpsURLConnection)paramMap).setSSLSocketFactory(this.b);
    }
    localObject = localHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      paramMap.addRequestProperty(str, (String)localHashMap.get(str));
    }
    switch (paramm.a())
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case -1: 
      localObject = paramm.h();
      if (localObject != null)
      {
        paramMap.setRequestMethod("POST");
        a(paramMap, paramm, (byte[])localObject);
      }
      break;
    }
    int j;
    for (;;)
    {
      j = paramMap.getResponseCode();
      if (j != -1) {
        break;
      }
      throw new IOException("Could not retrieve response code from HttpUrlConnection.");
      paramMap.setRequestMethod("GET");
      continue;
      paramMap.setRequestMethod("DELETE");
      continue;
      paramMap.setRequestMethod("POST");
      a(paramMap, paramm);
      continue;
      paramMap.setRequestMethod("PUT");
      a(paramMap, paramm);
      continue;
      paramMap.setRequestMethod("HEAD");
      continue;
      paramMap.setRequestMethod("OPTIONS");
      continue;
      paramMap.setRequestMethod("TRACE");
      continue;
      paramMap.setRequestMethod("PATCH");
      a(paramMap, paramm);
    }
    if ((paramm.a() != 4) && ((100 > j) || (j >= 200)) && (j != 204) && (j != 304)) {}
    for (i = 1; i == 0; i = 0) {
      return new e(j, paramMap.getHeaderFields());
    }
    return new e(j, paramMap.getHeaderFields(), paramMap.getContentLength(), a(paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */