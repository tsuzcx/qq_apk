package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.ha.h;
import com.tencent.luggage.wxa.oz.a;
import com.tencent.luggage.wxa.rb.a.a;
import com.tencent.luggage.wxa.rb.d;

public class f
  extends h
  implements a
{
  static final String[] a = { "userName", "versionType" };
  static final a.a b = h.a(f.class);
  public static final String[] c = { d.a(b, "WxaCollectionTableV2") };
  
  static
  {
    Object localObject1 = a;
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
    Object localObject2 = b;
    ((StringBuilder)localObject1).append(((a.a)localObject2).e);
    ((StringBuilder)localObject1).append(",");
    ((StringBuilder)localObject1).append(str);
    ((a.a)localObject2).e = ((StringBuilder)localObject1).toString();
  }
  
  public static f a(String paramString, int paramInt)
  {
    f localf = new f();
    localf.e = paramString;
    localf.f = paramInt;
    return localf;
  }
  
  protected a.a a()
  {
    return b;
  }
  
  public String[] t_()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.f
 * JD-Core Version:    0.7.0.1
 */