package com.tencent.beacon.base.net.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.b.a;
import com.tencent.beacon.base.net.b.b;
import com.tencent.beacon.base.net.b.c;
import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackageV2;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k$a
{
  private String a;
  private int b;
  private String c;
  private int d;
  private int e;
  private RequestType f;
  private String g;
  private Map<String, String> h = new ConcurrentHashMap(5);
  private Map<String, String> i = new LinkedHashMap(10);
  private byte[] j;
  private AbstractJceStruct k;
  
  public a a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public a a(RequestType paramRequestType)
  {
    this.f = paramRequestType;
    return this;
  }
  
  public a a(AbstractJceStruct paramAbstractJceStruct)
  {
    this.k = paramAbstractJceStruct;
    return this;
  }
  
  public a a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public a a(String paramString, int paramInt)
  {
    this.g = paramString;
    this.b = paramInt;
    return this;
  }
  
  public a a(@NonNull String paramString1, String paramString2)
  {
    this.h.put(paramString1, paramString2);
    return this;
  }
  
  public a a(Map<String, String> paramMap)
  {
    if (paramMap != null) {
      this.i.putAll(paramMap);
    }
    return this;
  }
  
  public k a()
  {
    if ((TextUtils.isEmpty(this.a)) && (TextUtils.isEmpty(this.g))) {
      throw new IllegalArgumentException("url || domain == null");
    }
    if (!TextUtils.isEmpty(this.c))
    {
      com.tencent.beacon.base.net.d locald = com.tencent.beacon.base.net.d.c();
      this.h.putAll(com.tencent.beacon.base.net.c.d.a());
      if (this.f == RequestType.EVENT)
      {
        this.j = ((byte[])locald.f.c().a((RequestPackageV2)this.k));
      }
      else
      {
        Object localObject = this.k;
        if (localObject == null) {
          localObject = "".getBytes();
        } else {
          localObject = ((AbstractJceStruct)localObject).toByteArray();
        }
        localObject = com.tencent.beacon.base.net.c.d.a(this.d, (byte[])localObject, this.i, this.c);
        this.j = ((byte[])locald.e.c().a(localObject));
      }
      return new k(this.f, this.a, this.g, this.b, this.c, this.j, this.h, this.d, this.e, null);
    }
    throw new IllegalArgumentException("appKey == null");
  }
  
  public a b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public a b(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public a b(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    this.i.put(paramString1, str);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.a.k.a
 * JD-Core Version:    0.7.0.1
 */