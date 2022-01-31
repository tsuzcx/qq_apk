package com.tencent.mapsdk.rastercore.b;

import com.tencent.mapsdk.rastercore.d.e;

public final class a
{
  private int a = 0;
  private int b = 0;
  private String c = "default";
  private String d = "";
  private String e = "";
  
  public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramString1;
    this.e = paramString2;
    this.c = paramString3;
  }
  
  public final int a()
  {
    return this.a * 10 + this.b;
  }
  
  public final boolean a(c paramc)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (this.a)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while ("default".equals(this.c));
      if (paramc == null) {
        return false;
      }
      paramc = paramc.a();
      e.a();
      return e.a(paramc, e.c(this.c));
      bool1 = bool2;
    } while ("default".equals(this.c));
    if (paramc != null)
    {
      e.a();
      f[] arrayOff = e.c(this.c);
      paramc = paramc.b();
      int j = paramc.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label147;
        }
        bool1 = bool2;
        if (e.a(paramc[i], arrayOff)) {
          break;
        }
        i += 1;
      }
    }
    label147:
    return false;
  }
  
  public final String b()
  {
    return this.d;
  }
  
  public final String c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.b.a
 * JD-Core Version:    0.7.0.1
 */