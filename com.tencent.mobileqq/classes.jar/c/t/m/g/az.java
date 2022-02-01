package c.t.m.g;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class az
  extends aq
{
  private static az d = new az();
  
  public static String a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    Object localObject = x.d();
    paramMap.put("A23", m.d);
    bb localbb = new bb();
    localbb.a(String.valueOf(paramString));
    localbb.a = System.currentTimeMillis();
    localbb.b = ay.a;
    localbb.c = ((String)localObject);
    paramMap.put("A1", m.c);
    paramMap.put("A2", cn.a());
    paramMap.put("A4", cn.b());
    paramMap.put("A6", cn.c());
    paramMap.put("A7", cn.e());
    paramMap.put("A23", m.d);
    paramMap.put("A33", x.f());
    paramMap.put("A10", ay.d);
    paramMap.put("A9", ay.c);
    paramMap.put("A19", localObject);
    localbb.a(paramMap);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(cn.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + "|");
    ((StringBuilder)localObject).append("INFO|");
    ((StringBuilder)localObject).append(x.a.a + "|");
    ((StringBuilder)localObject).append(ay.b + "|");
    ((StringBuilder)localObject).append("beacon|");
    ((StringBuilder)localObject).append("1.8.1|");
    paramString = localbb.b;
    try
    {
      paramMap = URLEncoder.encode(localbb.b, "utf-8");
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
    ((StringBuilder)localObject).append(localbb.c + "|");
    ((StringBuilder)localObject).append(localbb.a() + "|");
    ((StringBuilder)localObject).append(paramBoolean + "|");
    ((StringBuilder)localObject).append("0|");
    ((StringBuilder)localObject).append("0|");
    paramString = a(localbb.b());
    ((StringBuilder)localObject).append(paramString + "|");
    ((StringBuilder)localObject).append(cn.a(localbb.a, "yyyy-MM-dd HH:mm:ss") + "|");
    ((StringBuilder)localObject).append("upload_time");
    return ((StringBuilder)localObject).toString();
  }
  
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
  
  public static az e()
  {
    return d;
  }
  
  public final int a()
  {
    return x.a.a("report_insert_new_record_num_limit", 5, 100, 100);
  }
  
  public final String b()
  {
    return "beacon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.az
 * JD-Core Version:    0.7.0.1
 */