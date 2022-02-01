package com.tencent.beacon.a.c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.beacon.module.BeaconModule;
import com.tencent.beacon.module.ModuleName;
import java.util.Map;

public class c
{
  private static volatile c a;
  private Context b;
  private byte c = -1;
  private String d = "";
  private String e = "";
  private String f = "";
  private long g;
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  private boolean l = true;
  
  public static c d()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new c();
        }
      }
      finally {}
    }
    return a;
  }
  
  public BeaconModule a(ModuleName paramModuleName)
  {
    return (BeaconModule)BeaconModule.a.get(paramModuleName);
  }
  
  public String a()
  {
    return this.i;
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.g = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Context paramContext)
  {
    try
    {
      if (this.b == null)
      {
        this.b = paramContext.getApplicationContext();
        if (this.b == null) {
          this.b = paramContext;
        }
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public String b()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public Context c()
  {
    try
    {
      Context localContext = this.b;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(String paramString)
  {
    this.k = paramString;
  }
  
  public void d(String paramString)
  {
    this.h = paramString;
  }
  
  public String e()
  {
    return this.k;
  }
  
  @NonNull
  public String f()
  {
    return this.h;
  }
  
  public byte g()
  {
    try
    {
      byte b1 = this.c;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String h()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String i()
  {
    return "4.1.22";
  }
  
  public long j()
  {
    try
    {
      long l1 = this.g;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String k()
  {
    return this.j;
  }
  
  public boolean l()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.c.c
 * JD-Core Version:    0.7.0.1
 */