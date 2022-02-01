package com.tencent.beacon.core.network.volley;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class HurlStack
  extends BaseHttpStack
{
  private static final int HTTP_CONTINUE = 100;
  private final SSLSocketFactory mSslSocketFactory;
  private final HurlStack.UrlRewriter mUrlRewriter;
  
  public HurlStack()
  {
    this(null);
  }
  
  public HurlStack(HurlStack.UrlRewriter paramUrlRewriter)
  {
    this(paramUrlRewriter, null);
  }
  
  public HurlStack(HurlStack.UrlRewriter paramUrlRewriter, SSLSocketFactory paramSSLSocketFactory)
  {
    this.mUrlRewriter = paramUrlRewriter;
    this.mSslSocketFactory = paramSSLSocketFactory;
  }
  
  private static void addBody(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest, byte[] paramArrayOfByte)
  {
    paramHttpURLConnection.setDoOutput(true);
    if (!paramHttpURLConnection.getRequestProperties().containsKey("Content-Type")) {
      paramHttpURLConnection.setRequestProperty("Content-Type", paramRequest.getBodyContentType());
    }
    paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
    paramHttpURLConnection.write(paramArrayOfByte);
    paramHttpURLConnection.close();
  }
  
  private static void addBodyIfExists(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest)
  {
    byte[] arrayOfByte = paramRequest.getBody();
    if (arrayOfByte != null) {
      addBody(paramHttpURLConnection, paramRequest, arrayOfByte);
    }
  }
  
  static List<Header> convertHeaders(Map<String, List<String>> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localEntry.getKey() != null)
      {
        Iterator localIterator = ((List)localEntry.getValue()).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(new Header((String)localEntry.getKey(), str));
        }
      }
    }
    return localArrayList;
  }
  
  private static boolean hasResponseBody(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 4) && ((100 > paramInt2) || (paramInt2 >= 200)) && (paramInt2 != 204) && (paramInt2 != 304);
  }
  
  private static InputStream inputStreamFromConnection(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      InputStream localInputStream = paramHttpURLConnection.getInputStream();
      return localInputStream;
    }
    catch (IOException localIOException) {}
    return paramHttpURLConnection.getErrorStream();
  }
  
  private HttpURLConnection openConnection(URL paramURL, Request<?> paramRequest)
  {
    HttpURLConnection localHttpURLConnection = createConnection(paramURL);
    int i = paramRequest.getTimeoutMs();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    if ("https".equals(paramURL.getProtocol()))
    {
      paramURL = this.mSslSocketFactory;
      if (paramURL != null) {
        ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(paramURL);
      }
    }
    return localHttpURLConnection;
  }
  
  static void setConnectionParametersForRequest(HttpURLConnection paramHttpURLConnection, Request<?> paramRequest)
  {
    switch (paramRequest.getMethod())
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case 7: 
      paramHttpURLConnection.setRequestMethod("PATCH");
      addBodyIfExists(paramHttpURLConnection, paramRequest);
    }
    byte[] arrayOfByte;
    do
    {
      return;
      paramHttpURLConnection.setRequestMethod("TRACE");
      return;
      paramHttpURLConnection.setRequestMethod("OPTIONS");
      return;
      paramHttpURLConnection.setRequestMethod("HEAD");
      return;
      paramHttpURLConnection.setRequestMethod("DELETE");
      return;
      paramHttpURLConnection.setRequestMethod("PUT");
      addBodyIfExists(paramHttpURLConnection, paramRequest);
      return;
      paramHttpURLConnection.setRequestMethod("POST");
      addBodyIfExists(paramHttpURLConnection, paramRequest);
      return;
      paramHttpURLConnection.setRequestMethod("GET");
      return;
      arrayOfByte = paramRequest.getPostBody();
    } while (arrayOfByte == null);
    paramHttpURLConnection.setRequestMethod("POST");
    addBody(paramHttpURLConnection, paramRequest, arrayOfByte);
  }
  
  protected HttpURLConnection createConnection(URL paramURL)
  {
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    return paramURL;
  }
  
  public HttpResponse executeRequest(Request<?> paramRequest, Map<String, String> paramMap)
  {
    Object localObject = paramRequest.getUrl();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    localHashMap.putAll(paramRequest.getHeaders());
    paramMap = this.mUrlRewriter;
    int i;
    if (paramMap != null)
    {
      paramMap = paramMap.rewriteUrl((String)localObject);
      if (paramMap != null)
      {
        paramMap = openConnection(new URL(paramMap), paramRequest);
        try
        {
          localObject = localHashMap.keySet().iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              paramMap.setRequestProperty(str, (String)localHashMap.get(str));
              continue;
              if (i != 0) {
                break;
              }
            }
          }
        }
        finally
        {
          i = 0;
        }
      }
    }
    for (;;)
    {
      paramMap.disconnect();
      throw paramRequest;
      throw new IOException("URL blocked by rewriter: " + (String)localObject);
      paramMap = (Map<String, String>)localObject;
      break;
      setConnectionParametersForRequest(paramMap, paramRequest);
      int j = paramMap.getResponseCode();
      if (j == -1) {
        break label256;
      }
      if (!hasResponseBody(paramRequest.getMethod(), j))
      {
        paramRequest = new HttpResponse(j, convertHeaders(paramMap.getHeaderFields()));
        paramMap.disconnect();
        return paramRequest;
      }
      i = 1;
      try
      {
        paramRequest = new HttpResponse(j, convertHeaders(paramMap.getHeaderFields()), paramMap.getContentLength(), new HurlStack.UrlConnectionInputStream(paramMap));
        return paramRequest;
      }
      finally {}
    }
    label256:
    throw new IOException("Could not retrieve response code from HttpUrlConnection.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.HurlStack
 * JD-Core Version:    0.7.0.1
 */