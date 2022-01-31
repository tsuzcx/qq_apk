package com.tencent.beacon.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c
{
  private static c a;
  private SharedPreferences b;
  private SharedPreferences.Editor c;
  private Lock d = new ReentrantLock();
  private Runnable e = new c.1(this);
  
  private c(Context paramContext)
  {
    if (paramContext != null) {
      this.b = paramContext.getSharedPreferences("DENGTA_META", 0);
    }
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new c(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void c()
  {
    if (this.d.tryLock())
    {
      this.c.commit();
      this.d.unlock();
    }
  }
  
  public final int a(String paramString)
  {
    try
    {
      int i = this.b.getInt(paramString, 0);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final c a()
  {
    try
    {
      if ((this.b != null) && (this.c == null)) {
        this.c = this.b.edit();
      }
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final c a(String paramString, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if ((this.b == null) || (this.c == null))
        {
          com.tencent.beacon.core.d.b.d("[sp] create failed or edit() has not called.", new Object[0]);
          return this;
        }
        if ((paramObject instanceof String)) {
          this.c.putString(paramString, (String)paramObject);
        } else if ((paramObject instanceof Boolean)) {
          this.c.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        }
      }
      finally {}
      if ((paramObject instanceof Integer)) {
        this.c.putInt(paramString, ((Integer)paramObject).intValue());
      } else if ((paramObject instanceof Long)) {
        this.c.putLong(paramString, ((Long)paramObject).longValue());
      }
    }
  }
  
  public final String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.b.getString(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final long b(String paramString)
  {
    try
    {
      long l = this.b.getLong(paramString, 0L);
      return l;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b()
  {
    if ((this.b != null) && (this.c != null))
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        b.b().a(this.e);
      }
    }
    else {
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.a.c
 * JD-Core Version:    0.7.0.1
 */