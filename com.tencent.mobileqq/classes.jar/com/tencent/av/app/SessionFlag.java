package com.tencent.av.app;

import java.util.HashMap;

public class SessionFlag
{
  private static volatile SessionFlag c;
  public int a = 0;
  protected HashMap<String, Integer> b = null;
  
  public static SessionFlag a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new SessionFlag();
        }
      }
      finally {}
    }
    return c;
  }
  
  public int a(String paramString)
  {
    HashMap localHashMap = this.b;
    if (localHashMap == null) {
      return 0;
    }
    if (!localHashMap.containsKey(paramString)) {
      return 0;
    }
    return ((Integer)this.b.get(paramString)).intValue();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    this.b.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    this.b = null;
    this.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.SessionFlag
 * JD-Core Version:    0.7.0.1
 */