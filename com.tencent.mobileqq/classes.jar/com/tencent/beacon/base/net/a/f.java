package com.tencent.beacon.base.net.a;

import com.tencent.beacon.base.net.BodyType;
import com.tencent.beacon.base.net.HttpMethod;
import java.util.Map;

public class f
{
  private final String a;
  private final HttpMethod b;
  private final Map<String, String> c;
  private final Map<String, String> d;
  private final String e;
  private BodyType f;
  private String g;
  private byte[] h;
  
  private f(HttpMethod paramHttpMethod, String paramString1, Map<String, String> paramMap1, BodyType paramBodyType, String paramString2, Map<String, String> paramMap2, byte[] paramArrayOfByte, String paramString3)
  {
    this.b = paramHttpMethod;
    this.a = paramString1;
    this.c = paramMap1;
    this.f = paramBodyType;
    this.g = paramString2;
    this.d = paramMap2;
    this.h = paramArrayOfByte;
    this.e = paramString3;
  }
  
  public static f.a b()
  {
    return new f.a();
  }
  
  public BodyType a()
  {
    return this.f;
  }
  
  public byte[] c()
  {
    return this.h;
  }
  
  public Map<String, String> d()
  {
    return this.d;
  }
  
  public Map<String, String> e()
  {
    return this.c;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public HttpMethod g()
  {
    return this.b;
  }
  
  public String h()
  {
    return this.e;
  }
  
  public String i()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HttpRequestEntity{url='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", method=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", headers=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", formParams=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", bodyType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", json='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tag='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.a.f
 * JD-Core Version:    0.7.0.1
 */