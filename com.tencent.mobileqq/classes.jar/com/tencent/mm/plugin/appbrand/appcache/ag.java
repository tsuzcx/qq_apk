package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.wxa.ha.i;
import com.tencent.luggage.wxa.oz.a;
import com.tencent.luggage.wxa.rb.a.a;
import com.tencent.luggage.wxa.rb.d;

public class ag
  extends i
  implements a
{
  static final String[] e = { "pluginAppID", "pluginAppVersion" };
  static final a.a f = i.a(ag.class);
  public static final String[] g = { d.a(f, "WxaPluginCodeVersionInfo") };
  
  static
  {
    Object localObject1 = e;
    int j = localObject1.length;
    String str = " PRIMARY KEY (";
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(", ");
      localStringBuilder.append((String)localObject2);
      str = localStringBuilder.toString();
      i += 1;
    }
    str = str.replaceFirst(",", "");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append(" )");
    str = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    Object localObject2 = f;
    ((StringBuilder)localObject1).append(((a.a)localObject2).e);
    ((StringBuilder)localObject1).append(",");
    ((StringBuilder)localObject1).append(str);
    ((a.a)localObject2).e = ((StringBuilder)localObject1).toString();
  }
  
  protected a.a a()
  {
    return f;
  }
  
  public String[] t_()
  {
    return e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ag
 * JD-Core Version:    0.7.0.1
 */