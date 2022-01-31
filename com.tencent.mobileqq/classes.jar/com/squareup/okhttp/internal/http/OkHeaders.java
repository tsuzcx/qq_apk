package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class OkHeaders
{
  private static final Comparator<String> FIELD_NAME_COMPARATOR = new OkHeaders.1();
  static final String PREFIX = Platform.get().getPrefix();
  public static final String RECEIVED_MILLIS;
  public static final String RESPONSE_SOURCE = PREFIX + "-Response-Source";
  public static final String SELECTED_PROTOCOL;
  public static final String SENT_MILLIS = PREFIX + "-Sent-Millis";
  
  static
  {
    RECEIVED_MILLIS = PREFIX + "-Received-Millis";
    SELECTED_PROTOCOL = PREFIX + "-Selected-Protocol";
  }
  
  public static void addCookies(Request.Builder paramBuilder, Map<String, List<String>> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      if ((("Cookie".equalsIgnoreCase(str)) || ("Cookie2".equalsIgnoreCase(str))) && (!((List)localEntry.getValue()).isEmpty())) {
        paramBuilder.addHeader(str, buildCookieHeader((List)localEntry.getValue()));
      }
    }
  }
  
  private static String buildCookieHeader(List<String> paramList)
  {
    if (paramList.size() == 1) {
      return (String)paramList.get(0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append("; ");
      }
      localStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static long contentLength(Headers paramHeaders)
  {
    return stringToLong(paramHeaders.get("Content-Length"));
  }
  
  public static long contentLength(Request paramRequest)
  {
    return contentLength(paramRequest.headers());
  }
  
  public static long contentLength(Response paramResponse)
  {
    return contentLength(paramResponse.headers());
  }
  
  public static boolean hasVaryAll(Headers paramHeaders)
  {
    return varyFields(paramHeaders).contains("*");
  }
  
  public static boolean hasVaryAll(Response paramResponse)
  {
    return hasVaryAll(paramResponse.headers());
  }
  
  static boolean isEndToEnd(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  public static List<Challenge> parseChallenges(Headers paramHeaders, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramHeaders.size();
    int i = 0;
    if (i < k)
    {
      if (!paramString.equalsIgnoreCase(paramHeaders.name(i))) {}
      label176:
      for (;;)
      {
        i += 1;
        break;
        String str1 = paramHeaders.value(i);
        int j = 0;
        for (;;)
        {
          if (j >= str1.length()) {
            break label176;
          }
          int m = HeaderParser.skipUntil(str1, j, " ");
          String str2 = str1.substring(j, m).trim();
          j = HeaderParser.skipWhitespace(str1, m);
          if (!str1.regionMatches(true, j, "realm=\"", 0, "realm=\"".length())) {
            break;
          }
          j = "realm=\"".length() + j;
          m = HeaderParser.skipUntil(str1, j, "\"");
          String str3 = str1.substring(j, m);
          j = HeaderParser.skipWhitespace(str1, HeaderParser.skipUntil(str1, m + 1, ",") + 1);
          localArrayList.add(new Challenge(str2, str3));
        }
      }
    }
    return localArrayList;
  }
  
  public static Request processAuthHeader(Authenticator paramAuthenticator, Response paramResponse, Proxy paramProxy)
  {
    if (paramResponse.code() == 407) {
      return paramAuthenticator.authenticateProxy(paramProxy, paramResponse);
    }
    return paramAuthenticator.authenticate(paramProxy, paramResponse);
  }
  
  private static long stringToLong(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  public static Map<String, List<String>> toMultimap(Headers paramHeaders, String paramString)
  {
    TreeMap localTreeMap = new TreeMap(FIELD_NAME_COMPARATOR);
    int j = paramHeaders.size();
    int i = 0;
    while (i < j)
    {
      String str1 = paramHeaders.name(i);
      String str2 = paramHeaders.value(i);
      ArrayList localArrayList = new ArrayList();
      List localList = (List)localTreeMap.get(str1);
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      localArrayList.add(str2);
      localTreeMap.put(str1, Collections.unmodifiableList(localArrayList));
      i += 1;
    }
    if (paramString != null) {
      localTreeMap.put(null, Collections.unmodifiableList(Collections.singletonList(paramString)));
    }
    return Collections.unmodifiableMap(localTreeMap);
  }
  
  public static Set<String> varyFields(Headers paramHeaders)
  {
    Object localObject2 = Collections.emptySet();
    int k = paramHeaders.size();
    int i = 0;
    while (i < k) {
      if (!"Vary".equalsIgnoreCase(paramHeaders.name(i)))
      {
        i += 1;
      }
      else
      {
        Object localObject3 = paramHeaders.value(i);
        Object localObject1 = localObject2;
        if (((Set)localObject2).isEmpty()) {
          localObject1 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        }
        localObject3 = ((String)localObject3).split(",");
        int m = localObject3.length;
        int j = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (j >= m) {
            break;
          }
          ((Set)localObject1).add(localObject3[j].trim());
          j += 1;
        }
      }
    }
    return localObject2;
  }
  
  private static Set<String> varyFields(Response paramResponse)
  {
    return varyFields(paramResponse.headers());
  }
  
  public static Headers varyHeaders(Headers paramHeaders1, Headers paramHeaders2)
  {
    paramHeaders2 = varyFields(paramHeaders2);
    if (paramHeaders2.isEmpty()) {
      return new Headers.Builder().build();
    }
    Headers.Builder localBuilder = new Headers.Builder();
    int i = 0;
    int j = paramHeaders1.size();
    while (i < j)
    {
      String str = paramHeaders1.name(i);
      if (paramHeaders2.contains(str)) {
        localBuilder.add(str, paramHeaders1.value(i));
      }
      i += 1;
    }
    return localBuilder.build();
  }
  
  public static Headers varyHeaders(Response paramResponse)
  {
    return varyHeaders(paramResponse.networkResponse().request().headers(), paramResponse.headers());
  }
  
  public static boolean varyMatches(Response paramResponse, Headers paramHeaders, Request paramRequest)
  {
    paramResponse = varyFields(paramResponse).iterator();
    while (paramResponse.hasNext())
    {
      String str = (String)paramResponse.next();
      if (!Util.equal(paramHeaders.values(str), paramRequest.headers(str))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.OkHeaders
 * JD-Core Version:    0.7.0.1
 */