package com.huawei.hms.framework.network.grs.c;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  private static final String a = "f";
  private Map<String, List<String>> b;
  private byte[] c;
  private int d = 0;
  private long e;
  private long f;
  private long g;
  private String h;
  private int i = 2;
  private int j = 9001;
  private String k = "";
  private String l = "";
  private String m = "";
  private long n = 0L;
  private Exception o;
  private String p;
  private int q;
  
  public f(int paramInt, Map<String, List<String>> paramMap, byte[] paramArrayOfByte, long paramLong)
  {
    this.d = paramInt;
    this.b = paramMap;
    this.c = ByteBuffer.wrap(paramArrayOfByte).array();
    this.e = paramLong;
    q();
  }
  
  public f(Exception paramException, long paramLong)
  {
    this.o = paramException;
    this.e = paramLong;
  }
  
  private void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      if (paramMap.containsKey("Cache-Control"))
      {
        paramMap = (String)paramMap.get("Cache-Control");
        if ((!TextUtils.isEmpty(paramMap)) && (paramMap.contains("max-age=")))
        {
          try
          {
            l1 = Long.parseLong(paramMap.substring(paramMap.indexOf("max-age=") + 8));
            try
            {
              paramMap = a;
              Logger.v(paramMap, "Cache-Control value{%s}", new Object[] { Long.valueOf(l1) });
            }
            catch (NumberFormatException paramMap) {}
            Logger.w(a, "getExpireTime addHeadersToResult NumberFormatException", paramMap);
          }
          catch (NumberFormatException paramMap)
          {
            l1 = 0L;
          }
          break label274;
        }
      }
      else if (paramMap.containsKey("Expires"))
      {
        Object localObject = (String)paramMap.get("Expires");
        Logger.v(a, "expires is{%s}", new Object[] { localObject });
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
        String str = null;
        if (paramMap.containsKey("Date")) {
          str = (String)paramMap.get("Date");
        }
        try
        {
          localObject = localSimpleDateFormat.parse((String)localObject);
          if (TextUtils.isEmpty(str)) {
            paramMap = new Date();
          } else {
            paramMap = localSimpleDateFormat.parse(str);
          }
          l1 = (((Date)localObject).getTime() - paramMap.getTime()) / 1000L;
        }
        catch (ParseException paramMap)
        {
          Logger.w(a, "getExpireTime ParseException.", paramMap);
          break label272;
        }
      }
      else
      {
        Logger.i(a, "response headers neither contains Cache-Control nor Expires.");
      }
      label272:
      long l1 = 0L;
      label274:
      long l2;
      if (l1 > 0L)
      {
        l2 = l1;
        if (l1 <= 2592000L) {}
      }
      else
      {
        l2 = 86400L;
      }
      l1 = l2 * 1000L;
      Logger.v(a, "convert expireTime{%s}", new Object[] { Long.valueOf(l1) });
      b(String.valueOf(l1 + System.currentTimeMillis()));
      return;
    }
    Logger.w(a, "getExpireTime {headers == null} or {headers.size() <= 0}");
  }
  
  private void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  private void b(String paramString)
  {
    this.m = paramString;
  }
  
  private void b(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      long l2 = 0L;
      long l1 = l2;
      if (paramMap.containsKey("Retry-After"))
      {
        paramMap = (String)paramMap.get("Retry-After");
        l1 = l2;
        if (!TextUtils.isEmpty(paramMap)) {
          try
          {
            l1 = Long.parseLong(paramMap);
          }
          catch (NumberFormatException paramMap)
          {
            Logger.w(a, "getRetryAfter addHeadersToResult NumberFormatException", paramMap);
            l1 = l2;
          }
        }
      }
      l1 *= 1000L;
      Logger.v(a, "convert retry-afterTime{%s}", new Object[] { Long.valueOf(l1) });
      c(l1);
      return;
    }
    Logger.w(a, "getExpireTime {headers == null} or {headers.size() <= 0}");
  }
  
  private void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  private void c(long paramLong)
  {
    this.n = paramLong;
  }
  
  private void c(String paramString)
  {
    this.k = paramString;
  }
  
  private void d(String paramString)
  {
    this.l = paramString;
  }
  
  private void e(String paramString)
  {
    this.h = paramString;
  }
  
  private void n()
  {
    String str1 = "isSuccess";
    if (!m())
    {
      Logger.i(a, "GRSSDK parse server body all failed.");
      c(2);
      return;
    }
    for (;;)
    {
      try
      {
        String str2 = StringUtils.byte2Str(this.c);
        JSONObject localJSONObject = new JSONObject(str2);
        i1 = -1;
        boolean bool = localJSONObject.has("isSuccess");
        if (!bool)
        {
          if (localJSONObject.has("resultCode")) {
            str1 = "resultCode";
          }
        }
        else
        {
          i1 = localJSONObject.getInt(str1);
          continue;
        }
        str1 = a;
        Logger.e(str1, "sth. wrong because server errorcode's key.");
        c(i1);
        if (i1 == 0)
        {
          bool = str2.contains("services");
          if (bool)
          {
            i2 = 1;
            continue;
          }
        }
        int i2 = 0;
        str1 = "";
        if ((i1 != 1) && (i2 == 0))
        {
          c(2);
          if (!localJSONObject.has("errorCode")) {
            break label267;
          }
          i1 = localJSONObject.getInt("errorCode");
          b(i1);
          if (localJSONObject.has("errorDesc")) {
            str1 = localJSONObject.getString("errorDesc");
          }
          c(str1);
          return;
        }
        e(localJSONObject.getJSONObject("services").toString());
        if (i2 != 0)
        {
          if (localJSONObject.has("errorList")) {
            str1 = localJSONObject.getString("errorList");
          }
          d(str1);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Logger.w(a, "GrsResponse GrsResponse(String result) JSONException", localJSONException);
        c(2);
      }
      return;
      label267:
      int i1 = 9001;
    }
  }
  
  private void o()
  {
    if ((!m()) && (!l())) {
      return;
    }
    Map localMap = p();
    try
    {
      if (m()) {
        a(localMap);
      }
      if (l())
      {
        b(localMap);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Logger.w(a, "parseHeader catch JSONException", localJSONException);
    }
  }
  
  private Map<String, String> p()
  {
    HashMap localHashMap = new HashMap(16);
    Object localObject = this.b;
    if ((localObject != null) && (((Map)localObject).size() > 0))
    {
      localObject = this.b.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localHashMap.put((String)localEntry.getKey(), ((List)localEntry.getValue()).get(0));
      }
      return localHashMap;
    }
    Logger.v(a, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
    return localHashMap;
  }
  
  private void q()
  {
    o();
    n();
  }
  
  public String a()
  {
    return this.m;
  }
  
  public void a(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void a(String paramString)
  {
    this.p = paramString;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(long paramLong)
  {
    this.f = paramLong;
  }
  
  public int c()
  {
    return this.j;
  }
  
  public Exception d()
  {
    return this.o;
  }
  
  public int e()
  {
    return this.i;
  }
  
  public long f()
  {
    return this.g;
  }
  
  public long g()
  {
    return this.f;
  }
  
  public long h()
  {
    return this.e;
  }
  
  public String i()
  {
    return this.h;
  }
  
  public long j()
  {
    return this.n;
  }
  
  public String k()
  {
    return this.p;
  }
  
  public boolean l()
  {
    return this.d == 503;
  }
  
  public boolean m()
  {
    return this.d == 200;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.f
 * JD-Core Version:    0.7.0.1
 */