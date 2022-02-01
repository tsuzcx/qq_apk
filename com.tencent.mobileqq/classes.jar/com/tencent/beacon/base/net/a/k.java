package com.tencent.beacon.base.net.a;

import com.tencent.beacon.base.net.RequestType;
import java.util.Map;

public class k
{
  private final RequestType a;
  private final String b;
  private final String c;
  private final int d;
  private final String e;
  private final byte[] f;
  private final Map<String, String> g;
  private final int h;
  private final int i;
  
  private k(RequestType paramRequestType, String paramString1, String paramString2, int paramInt1, String paramString3, byte[] paramArrayOfByte, Map<String, String> paramMap, int paramInt2, int paramInt3)
  {
    this.a = paramRequestType;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt1;
    this.e = paramString3;
    this.f = paramArrayOfByte;
    this.g = paramMap;
    this.h = paramInt2;
    this.i = paramInt3;
  }
  
  public static k.a a()
  {
    return new k.a();
  }
  
  public byte[] b()
  {
    return this.f;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public Map<String, String> d()
  {
    return this.g;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.i;
  }
  
  public RequestType g()
  {
    return this.a;
  }
  
  public String h()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JceRequestEntity{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", domain='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", port=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", appKey='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", content.length=");
    localStringBuilder.append(this.f.length);
    localStringBuilder.append(", header=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", requestCmd=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", responseCmd=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.a.k
 * JD-Core Version:    0.7.0.1
 */