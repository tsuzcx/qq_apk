package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class an
  extends k
{
  private static byte[] i;
  private static Map<String, String> j;
  public byte a = 0;
  public int b = 0;
  public byte[] c = null;
  public String d = "";
  public long e = 0L;
  public String f = "";
  private String g = "";
  private Map<String, String> h = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    i = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    j = new HashMap();
    j.put("", "");
  }
  
  public final void a(i parami)
  {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.a(this.b, 1, true);
    byte[] arrayOfByte = i;
    this.c = ((byte[])parami.c(2, false));
    this.d = parami.b(3, false);
    this.e = parami.a(this.e, 4, false);
    this.g = parami.b(5, false);
    this.f = parami.b(6, false);
    this.h = ((Map)parami.a(j, 7, false));
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    Object localObject = this.c;
    if (localObject != null) {
      paramj.a((byte[])localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramj.a((String)localObject, 3);
    }
    paramj.a(this.e, 4);
    localObject = this.g;
    if (localObject != null) {
      paramj.a((String)localObject, 5);
    }
    localObject = this.f;
    if (localObject != null) {
      paramj.a((String)localObject, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      paramj.a((Map)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.proguard.an
 * JD-Core Version:    0.7.0.1
 */