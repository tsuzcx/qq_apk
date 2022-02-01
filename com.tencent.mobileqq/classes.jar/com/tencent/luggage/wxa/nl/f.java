package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.ha.d;
import com.tencent.luggage.wxa.rb.a.a;

public final class f
  extends d
{
  static final String[] e;
  static final a.a f;
  
  static
  {
    int i = 0;
    e = new String[] { "appId", "versionType" };
    f = d.a(f.class);
    Object localObject1 = e;
    int j = localObject1.length;
    String str = " PRIMARY KEY (";
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
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.f
 * JD-Core Version:    0.7.0.1
 */