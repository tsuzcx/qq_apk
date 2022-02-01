package com.tencent.beacon.core.network.volley;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;

public class HttpHeaderParser
{
  private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
  static final String HEADER_CONTENT_TYPE = "Content-Type";
  private static final String RFC1123_OUTPUT_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";
  private static final String RFC1123_PARSE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";
  
  static String formatEpochAsRfc1123(long paramLong)
  {
    return newUsGmtFormatter("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(paramLong));
  }
  
  private static SimpleDateFormat newUsGmtFormatter(String paramString)
  {
    paramString = new SimpleDateFormat(paramString, Locale.US);
    paramString.setTimeZone(TimeZone.getTimeZone("GMT"));
    return paramString;
  }
  
  public static Cache.Entry parseCacheHeaders(NetworkResponse paramNetworkResponse)
  {
    long l6 = System.currentTimeMillis();
    Map localMap = paramNetworkResponse.headers;
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    Object localObject1 = (String)localMap.get("Date");
    if (localObject1 != null) {
      l3 = parseDateAsEpoch((String)localObject1);
    }
    localObject1 = (String)localMap.get("Cache-Control");
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split(",", 0);
      j = 0;
      i = 0;
      l1 = 0L;
      l2 = 0L;
      if (j < localObject1.length)
      {
        localObject2 = localObject1[j].trim();
        if ((((String)localObject2).equals("no-cache")) || (((String)localObject2).equals("no-store"))) {
          return null;
        }
        if (((String)localObject2).startsWith("max-age=")) {}
        for (;;)
        {
          try
          {
            l5 = Long.parseLong(((String)localObject2).substring(8));
            l4 = l1;
          }
          catch (Exception localException)
          {
            long l4 = l1;
            long l5 = l2;
            continue;
            l4 = 0L;
            continue;
            l5 = 0L;
            continue;
          }
          j += 1;
          l1 = l4;
          l2 = l5;
          break;
          if (((String)localObject2).startsWith("stale-while-revalidate="))
          {
            l4 = Long.parseLong(((String)localObject2).substring(23));
            l5 = l2;
          }
          else if (!((String)localObject2).equals("must-revalidate"))
          {
            l4 = l1;
            l5 = l2;
            if (!((String)localObject2).equals("proxy-revalidate")) {}
          }
          else
          {
            i = 1;
            l4 = l1;
            l5 = l2;
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      localObject1 = (String)localMap.get("Expires");
      if (localObject1 != null)
      {
        l5 = parseDateAsEpoch((String)localObject1);
        localObject1 = (String)localMap.get("Last-Modified");
        if (localObject1 != null)
        {
          l4 = parseDateAsEpoch((String)localObject1);
          localObject1 = (String)localMap.get("ETag");
          if (j != 0)
          {
            l2 = l6 + 1000L * l2;
            if (i != 0) {
              l1 = l2;
            }
          }
          for (;;)
          {
            localObject2 = new Cache.Entry();
            ((Cache.Entry)localObject2).data = paramNetworkResponse.data;
            ((Cache.Entry)localObject2).etag = ((String)localObject1);
            ((Cache.Entry)localObject2).softTtl = l2;
            ((Cache.Entry)localObject2).ttl = l1;
            ((Cache.Entry)localObject2).serverDate = l3;
            ((Cache.Entry)localObject2).lastModified = l4;
            ((Cache.Entry)localObject2).responseHeaders = localMap;
            ((Cache.Entry)localObject2).allResponseHeaders = paramNetworkResponse.allHeaders;
            return localObject2;
            l1 = 1000L * l1 + l2;
            continue;
            if ((l3 > 0L) && (l5 >= l3))
            {
              l1 = l5 - l3 + l6;
              l2 = l1;
            }
            else
            {
              l1 = 0L;
              l2 = 0L;
            }
          }
        }
      }
      i = 0;
    }
  }
  
  public static String parseCharset(Map<String, String> paramMap)
  {
    return parseCharset(paramMap, "ISO-8859-1");
  }
  
  public static String parseCharset(Map<String, String> paramMap, String paramString)
  {
    Object localObject = (String)paramMap.get("Content-Type");
    paramMap = paramString;
    int i;
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";", 0);
      i = 1;
    }
    for (;;)
    {
      paramMap = paramString;
      if (i < localObject.length)
      {
        paramMap = localObject[i].trim().split("=", 0);
        if ((paramMap.length == 2) && (paramMap[0].equals("charset"))) {
          paramMap = paramMap[1];
        }
      }
      else
      {
        return paramMap;
      }
      i += 1;
    }
  }
  
  public static long parseDateAsEpoch(String paramString)
  {
    try
    {
      long l = newUsGmtFormatter("EEE, dd MMM yyyy HH:mm:ss zzz").parse(paramString).getTime();
      return l;
    }
    catch (ParseException localParseException)
    {
      if ("0".equals(paramString)) {
        break label34;
      }
    }
    if ("-1".equals(paramString)) {
      label34:
      VolleyLog.v("Unable to parse dateStr: %s, falling back to 0", new Object[] { paramString });
    }
    for (;;)
    {
      return 0L;
      VolleyLog.e(localParseException, "Unable to parse dateStr: %s, falling back to 0", new Object[] { paramString });
    }
  }
  
  static List<Header> toAllHeaderList(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList.add(new Header((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localArrayList;
  }
  
  static Map<String, String> toHeaderMap(List<Header> paramList)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Header localHeader = (Header)paramList.next();
      localTreeMap.put(localHeader.getName(), localHeader.getValue());
    }
    return localTreeMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.HttpHeaderParser
 * JD-Core Version:    0.7.0.1
 */