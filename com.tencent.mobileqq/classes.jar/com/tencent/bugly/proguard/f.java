package com.tencent.bugly.proguard;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends k
{
  private static byte[] k = null;
  private static Map<String, String> l = null;
  public short a = 0;
  public int b = 0;
  public String c = null;
  public String d = null;
  public byte[] e;
  private byte f = 0;
  private int g = 0;
  private int h = 0;
  private Map<String, String> i;
  private Map<String, String> j;
  
  public final void a(i parami)
  {
    try
    {
      this.a = parami.a(this.a, 1, true);
      this.f = parami.a(this.f, 2, true);
      this.g = parami.a(this.g, 3, true);
      this.b = parami.a(this.b, 4, true);
      this.c = parami.b(5, true);
      this.d = parami.b(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      localObject = k;
      this.e = ((byte[])parami.c(7, true));
      this.h = parami.a(this.h, 8, true);
      localObject = l;
      if (localObject == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.i = ((Map)parami.a(l, 9, true));
      if (l == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.j = ((Map)parami.a(l, 10, true));
      return;
    }
    catch (Exception parami)
    {
      parami.printStackTrace();
      Object localObject = System.out;
      StringBuilder localStringBuilder = new StringBuilder("RequestPacket decode error ");
      localStringBuilder.append(e.a(this.e));
      ((PrintStream)localObject).println(localStringBuilder.toString());
      throw new RuntimeException(parami);
    }
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 1);
    paramj.a(this.f, 2);
    paramj.a(this.g, 3);
    paramj.a(this.b, 4);
    paramj.a(this.c, 5);
    paramj.a(this.d, 6);
    paramj.a(this.e, 7);
    paramj.a(this.h, 8);
    paramj.a(this.i, 9);
    paramj.a(this.j, 10);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new h(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "iVersion");
    paramStringBuilder.a(this.f, "cPacketType");
    paramStringBuilder.a(this.g, "iMessageType");
    paramStringBuilder.a(this.b, "iRequestId");
    paramStringBuilder.a(this.c, "sServantName");
    paramStringBuilder.a(this.d, "sFuncName");
    paramStringBuilder.a(this.e, "sBuffer");
    paramStringBuilder.a(this.h, "iTimeout");
    paramStringBuilder.a(this.i, "context");
    paramStringBuilder.a(this.j, "status");
  }
  
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
  
  public final boolean equals(Object paramObject)
  {
    paramObject = (f)paramObject;
    int n = paramObject.a;
    Integer localInteger = Integer.valueOf(1);
    return (l.a(1, n)) && (l.a(1, paramObject.f)) && (l.a(1, paramObject.g)) && (l.a(1, paramObject.b)) && (l.a(localInteger, paramObject.c)) && (l.a(localInteger, paramObject.d)) && (l.a(localInteger, paramObject.e)) && (l.a(1, paramObject.h)) && (l.a(localInteger, paramObject.i)) && (l.a(localInteger, paramObject.j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.proguard.f
 * JD-Core Version:    0.7.0.1
 */