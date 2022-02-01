package com.huawei.hms.framework.network.grs.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.m;
import com.huawei.hms.framework.network.grs.d.e;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private static final String a = "a";
  private Map<String, Map<String, Map<String, String>>> b = new ConcurrentHashMap(16);
  private Map<String, Long> c = new ConcurrentHashMap(16);
  private c d;
  private c e;
  private m f;
  
  public a(c paramc1, c paramc2, m paramm)
  {
    this.e = paramc2;
    this.d = paramc1;
    this.f = paramm;
    this.f.a(this);
  }
  
  private void a(GrsBaseInfo paramGrsBaseInfo, b paramb, Context paramContext, String paramString)
  {
    Object localObject = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    localObject = (Long)this.c.get(localObject);
    if (e.a((Long)localObject))
    {
      paramb.a(2);
      return;
    }
    if (e.a((Long)localObject, 300000L))
    {
      paramGrsBaseInfo = new com.huawei.hms.framework.network.grs.c.b.c(paramGrsBaseInfo, paramContext);
      this.f.a(paramGrsBaseInfo, null, paramString, this.e);
    }
    paramb.a(1);
  }
  
  private void a(GrsBaseInfo paramGrsBaseInfo, String paramString, Context paramContext)
  {
    if (e.a((Long)this.c.get(paramString), 300000L))
    {
      paramGrsBaseInfo = new com.huawei.hms.framework.network.grs.c.b.c(paramGrsBaseInfo, paramContext);
      this.f.a(paramGrsBaseInfo, null, null, this.e);
    }
  }
  
  public c a()
  {
    return this.d;
  }
  
  public String a(GrsBaseInfo paramGrsBaseInfo, String paramString1, String paramString2, b paramb, Context paramContext)
  {
    paramGrsBaseInfo = a(paramGrsBaseInfo, paramString1, paramb, paramContext);
    if (paramGrsBaseInfo == null) {
      return null;
    }
    return (String)paramGrsBaseInfo.get(paramString2);
  }
  
  public Map<String, String> a(GrsBaseInfo paramGrsBaseInfo, String paramString, b paramb, Context paramContext)
  {
    Object localObject = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    localObject = (Map)this.b.get(localObject);
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      a(paramGrsBaseInfo, paramb, paramContext, paramString);
      return (Map)((Map)localObject).get(paramString);
    }
    return new HashMap();
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo, Context paramContext)
  {
    paramGrsBaseInfo = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    paramContext = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramGrsBaseInfo);
    localStringBuilder.append("time");
    paramContext.b(localStringBuilder.toString(), "0");
    paramContext = this.c;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramGrsBaseInfo);
    localStringBuilder.append("time");
    paramContext.remove(localStringBuilder.toString());
    this.b.remove(paramGrsBaseInfo);
    this.f.a(paramGrsBaseInfo);
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo, f paramf, Context paramContext, com.huawei.hms.framework.network.grs.c.b.c paramc)
  {
    if (paramf.e() == 2)
    {
      Logger.w(a, "update cache from server failed");
      return;
    }
    if (paramc.d().size() == 0)
    {
      paramGrsBaseInfo = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
      this.d.b(paramGrsBaseInfo, paramf.i());
      paramContext = this.d;
      paramc = new StringBuilder();
      paramc.append(paramGrsBaseInfo);
      paramc.append("time");
      paramContext.b(paramc.toString(), paramf.a());
      this.b.put(paramGrsBaseInfo, com.huawei.hms.framework.network.grs.a.a(paramf.i()));
      this.c.put(paramGrsBaseInfo, Long.valueOf(Long.parseLong(paramf.a())));
      return;
    }
    this.d.b("geoipCountryCode", paramf.i());
    this.d.b("geoipCountryCodetime", paramf.a());
  }
  
  public m b()
  {
    return this.f;
  }
  
  public void b(GrsBaseInfo paramGrsBaseInfo, Context paramContext)
  {
    String str1 = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    String str2 = this.d.a(str1, "");
    Object localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("time");
    localObject = ((c)localObject).a(localStringBuilder.toString(), "0");
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    long l2 = 0L;
    long l1 = l2;
    if (!bool)
    {
      l1 = l2;
      if (((String)localObject).matches("\\d+")) {
        try
        {
          l1 = Long.parseLong((String)localObject);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Logger.w(a, "convert urlParamKey from String to Long catch NumberFormatException.", localNumberFormatException);
          l1 = l2;
        }
      }
    }
    this.b.put(str1, com.huawei.hms.framework.network.grs.a.a(str2));
    this.c.put(str1, Long.valueOf(l1));
    a(paramGrsBaseInfo, str1, paramContext);
  }
  
  public c c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.a.a
 * JD-Core Version:    0.7.0.1
 */