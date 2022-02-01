package com.tencent.map.sdk.a;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends n
{
  static byte[] k = null;
  static Map<String, String> l = null;
  public short a = 0;
  public byte b = 0;
  public int c = 0;
  public int d = 0;
  public String e = null;
  public String f = null;
  public byte[] g;
  public int h = 0;
  public Map<String, String> i;
  public Map<String, String> j;
  
  public final Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if (m) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "iVersion");
    paramStringBuilder.a(this.b, "cPacketType");
    paramStringBuilder.a(this.c, "iMessageType");
    paramStringBuilder.a(this.d, "iRequestId");
    paramStringBuilder.a(this.e, "sServantName");
    paramStringBuilder.a(this.f, "sFuncName");
    paramStringBuilder.a(this.g, "sBuffer");
    paramStringBuilder.a(this.h, "iTimeout");
    paramStringBuilder.a(this.i, "context");
    paramStringBuilder.a(this.j, "status");
  }
  
  public final boolean equals(Object paramObject)
  {
    paramObject = (f)paramObject;
    int n = paramObject.a;
    Integer localInteger = Integer.valueOf(1);
    return (o.a(1, n)) && (o.a(1, paramObject.b)) && (o.a(1, paramObject.c)) && (o.a(1, paramObject.d)) && (o.a(localInteger, paramObject.e)) && (o.a(localInteger, paramObject.f)) && (o.a(localInteger, paramObject.g)) && (o.a(1, paramObject.h)) && (o.a(localInteger, paramObject.i)) && (o.a(localInteger, paramObject.j));
  }
  
  public final void readFrom(k paramk)
  {
    try
    {
      this.a = paramk.a(this.a, 1, true);
      this.b = paramk.a(this.b, 2, true);
      this.c = paramk.a(this.c, 3, true);
      this.d = paramk.a(this.d, 4, true);
      this.e = paramk.b(5, true);
      this.f = paramk.b(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.g = ((byte[])paramk.c(7, true));
      this.h = paramk.a(this.h, 8, true);
      localObject = l;
      if (localObject == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.i = ((Map)paramk.a(l, 9, true));
      if (l == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.j = ((Map)paramk.a(l, 10, true));
      return;
    }
    catch (Exception paramk)
    {
      paramk.printStackTrace();
      Object localObject = System.out;
      StringBuilder localStringBuilder = new StringBuilder("RequestPacket decode error ");
      localStringBuilder.append(g.a(this.g));
      ((PrintStream)localObject).println(localStringBuilder.toString());
      throw new RuntimeException(paramk);
    }
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.a, 1);
    paraml.a(this.b, 2);
    paraml.a(this.c, 3);
    paraml.a(this.d, 4);
    paraml.a(this.e, 5);
    paraml.a(this.f, 6);
    paraml.a(this.g, 7);
    paraml.a(this.h, 8);
    paraml.a(this.i, 9);
    paraml.a(this.j, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.f
 * JD-Core Version:    0.7.0.1
 */