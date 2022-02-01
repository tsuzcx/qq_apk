package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.wxa.ha.f;
import com.tencent.luggage.wxa.rb.a.a;

public class j
  extends f
{
  static final String[] h;
  static final a.a i;
  
  static
  {
    int j = 0;
    h = new String[] { "appId", "version", "type", "moduleName" };
    i = f.a(f.class);
    Object localObject1 = h;
    int k = localObject1.length;
    String str = " PRIMARY KEY (";
    while (j < k)
    {
      localObject2 = localObject1[j];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(", ");
      localStringBuilder.append((String)localObject2);
      str = localStringBuilder.toString();
      j += 1;
    }
    str = str.replaceFirst(",", "");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append(" )");
    str = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    Object localObject2 = i;
    ((StringBuilder)localObject1).append(((a.a)localObject2).e);
    ((StringBuilder)localObject1).append(",");
    ((StringBuilder)localObject1).append(str);
    ((a.a)localObject2).e = ((StringBuilder)localObject1).toString();
  }
  
  protected a.a a()
  {
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.j
 * JD-Core Version:    0.7.0.1
 */