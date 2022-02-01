package com.tencent.map.sdk.a;

import java.util.HashMap;
import java.util.Set;

public class d
  extends c
{
  protected HashMap<String, byte[]> e = null;
  k f = new k();
  private HashMap<String, Object> g = new HashMap();
  
  public final <T> T a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    if (this.e == null) {
      return super.a(paramString, paramBoolean, paramClassLoader);
    }
    throw new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
  }
  
  public <T> void a(String paramString, T paramT)
  {
    if (this.e != null)
    {
      if (paramString != null)
      {
        if (paramT != null)
        {
          if (!(paramT instanceof Set))
          {
            l locall = new l();
            locall.a(this.c);
            locall.a(paramT, 0);
            paramT = o.a(locall.a);
            this.e.put(paramString, paramT);
            return;
          }
          throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
      }
      throw new IllegalArgumentException("put key can not is null");
    }
    super.a(paramString, paramT);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      super.a(paramArrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      label6:
      break label6;
    }
    this.f.a(paramArrayOfByte);
    this.f.a(this.c);
    paramArrayOfByte = new HashMap(1);
    paramArrayOfByte.put("", new byte[0]);
    this.e = this.f.a(paramArrayOfByte, 0, false);
  }
  
  public byte[] a()
  {
    if (this.e != null)
    {
      l locall = new l(0);
      locall.a(this.c);
      locall.a(this.e, 0);
      return o.a(locall.a);
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */