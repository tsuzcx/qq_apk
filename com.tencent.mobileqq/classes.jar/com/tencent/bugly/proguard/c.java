package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class c
  extends a
{
  protected HashMap<String, byte[]> d = null;
  private HashMap<String, Object> e = new HashMap();
  private i f = new i();
  
  public <T> void a(String paramString, T paramT)
  {
    if (this.d != null)
    {
      if (paramString != null)
      {
        if (paramT != null)
        {
          if (!(paramT instanceof Set))
          {
            j localj = new j();
            localj.a(this.b);
            localj.a(paramT, 0);
            paramT = l.a(localj.a());
            this.d.put(paramString, paramT);
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
    this.f.a(this.b);
    paramArrayOfByte = new HashMap(1);
    paramArrayOfByte.put("", new byte[0]);
    this.d = this.f.a(paramArrayOfByte, 0, false);
  }
  
  public byte[] a()
  {
    if (this.d != null)
    {
      j localj = new j(0);
      localj.a(this.b);
      localj.a(this.d, 0);
      return l.a(localj.a());
    }
    return super.a();
  }
  
  public final <T> T b(String paramString, T paramT)
  {
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      if (!((HashMap)localObject1).containsKey(paramString)) {
        return null;
      }
      if (this.e.containsKey(paramString)) {
        return this.e.get(paramString);
      }
      localObject1 = (byte[])this.d.get(paramString);
      try
      {
        this.f.a((byte[])localObject1);
        this.f.a(this.b);
        paramT = this.f.a(paramT, 0, true);
        if (paramT != null) {
          this.e.put(paramString, paramT);
        }
        return paramT;
      }
      catch (Exception paramString)
      {
        throw new b(paramString);
      }
    }
    if (!this.a.containsKey(paramString)) {
      return null;
    }
    if (this.e.containsKey(paramString)) {
      return this.e.get(paramString);
    }
    Object localObject2 = (HashMap)this.a.get(paramString);
    localObject1 = new byte[0];
    localObject2 = ((HashMap)localObject2).entrySet().iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      ((Map.Entry)localObject1).getKey();
      localObject1 = (byte[])((Map.Entry)localObject1).getValue();
    }
    try
    {
      this.f.a((byte[])localObject1);
      this.f.a(this.b);
      paramT = this.f.a(paramT, 0, true);
      this.e.put(paramString, paramT);
      return paramT;
    }
    catch (Exception paramString)
    {
      throw new b(paramString);
    }
  }
  
  public void d()
  {
    this.d = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.proguard.c
 * JD-Core Version:    0.7.0.1
 */