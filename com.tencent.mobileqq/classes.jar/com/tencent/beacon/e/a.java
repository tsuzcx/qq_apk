package com.tencent.beacon.e;

import java.util.Calendar;
import java.util.Map;

public class a
  implements c
{
  private static volatile a a;
  public boolean b = false;
  private String c = "oth.str.mdt.qq.com";
  private int d = 360;
  private int e = 100;
  private Map<String, String> f = null;
  private boolean g = false;
  private d h = new d(1);
  
  public static a a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new a();
        }
      }
      finally {}
    }
    return a;
  }
  
  public String a(String paramString)
  {
    try
    {
      Map localMap = this.f;
      if (localMap != null)
      {
        paramString = (String)localMap.get(paramString);
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(Map<String, String> paramMap)
  {
    try
    {
      this.f = paramMap;
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public int b()
  {
    return this.d;
  }
  
  public String b(String paramString)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((d)localObject).a();
      if (localObject != null) {
        return (String)((Map)localObject).get(paramString);
      }
    }
    return null;
  }
  
  public int c()
  {
    try
    {
      Object localObject1 = this.f;
      if (localObject1 != null)
      {
        localObject1 = (String)((Map)localObject1).get("maxStrategyQueryOneDay");
        if ((localObject1 != null) && (!((String)localObject1).trim().equals("")))
        {
          i = this.e;
          try
          {
            int j = Integer.parseInt((String)localObject1);
            i = j;
          }
          catch (Exception localException)
          {
            com.tencent.beacon.base.util.c.a(localException);
          }
          return i;
        }
      }
      int i = this.e;
      return i;
    }
    finally {}
  }
  
  public d d()
  {
    return this.h;
  }
  
  public boolean e()
  {
    try
    {
      Map localMap = this.f;
      boolean bool = false;
      if ((localMap != null) && ("y".equalsIgnoreCase((String)localMap.get("zeroPeak"))))
      {
        int i = Calendar.getInstance().get(11);
        if (i == 0) {
          bool = true;
        }
        return bool;
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.e.a
 * JD-Core Version:    0.7.0.1
 */