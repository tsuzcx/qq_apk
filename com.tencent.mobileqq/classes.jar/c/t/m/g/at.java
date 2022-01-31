package c.t.m.g;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class at
  extends al
{
  private static at m = new at();
  
  private static String a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append("&");
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append((String)paramMap.get(str));
    }
    paramMap = localStringBuilder.substring(1);
    localStringBuilder.setLength(0);
    return paramMap;
  }
  
  private static String b(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    Object localObject = o.d();
    paramMap.put("A23", l.e);
    av localav = new av();
    localav.c(paramString);
    localav.a(System.currentTimeMillis());
    localav.b(as.a);
    localav.a((String)localObject);
    paramMap.put("A1", l.d);
    paramMap.put("A2", ch.a());
    paramMap.put("A4", ch.b());
    paramMap.put("A6", ch.c());
    paramMap.put("A7", ch.e());
    paramMap.put("A23", l.e);
    paramMap.put("A33", o.f());
    paramMap.put("A10", as.d);
    paramMap.put("A9", as.c);
    paramMap.put("A19", localObject);
    localav.a(paramMap);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ch.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + "|");
    ((StringBuilder)localObject).append("INFO|");
    ((StringBuilder)localObject).append(v.a + "|");
    ((StringBuilder)localObject).append(as.b + "|");
    ((StringBuilder)localObject).append("beacon|");
    ((StringBuilder)localObject).append("1.8.1|");
    paramString = localav.b();
    try
    {
      paramMap = URLEncoder.encode(localav.b(), "utf-8");
      paramString = paramMap;
    }
    catch (UnsupportedEncodingException paramMap)
    {
      for (;;)
      {
        paramMap.printStackTrace();
      }
    }
    ((StringBuilder)localObject).append(paramString + "|");
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append("upload_ip|");
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(localav.a() + "|");
    ((StringBuilder)localObject).append(localav.d() + "|");
    ((StringBuilder)localObject).append(paramBoolean + "|");
    ((StringBuilder)localObject).append("0|");
    ((StringBuilder)localObject).append("0|");
    paramString = a(localav.e());
    ((StringBuilder)localObject).append(paramString + "|");
    ((StringBuilder)localObject).append(ch.a(localav.c(), "yyyy-MM-dd HH:mm:ss") + "|");
    ((StringBuilder)localObject).append("upload_time");
    return ((StringBuilder)localObject).toString();
  }
  
  public static at e()
  {
    return m;
  }
  
  public final String a()
  {
    return "halley-cloud-HalleyAction";
  }
  
  public final void a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    paramString = b(paramString, paramBoolean, paramMap);
    try
    {
      if (this.h.getAndIncrement() > this.i)
      {
        this.h.decrementAndGet();
        return;
      }
      new al.b(this, paramString).a(false);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public final int b()
  {
    return v.a("report_insert_new_record_num_limit", 5, 100, 100);
  }
  
  public final String c()
  {
    return "beacon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.at
 * JD-Core Version:    0.7.0.1
 */