package com.tencent.beacon.stat;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.beacon.core.info.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class d
{
  private static final Map<String, d> a = new ConcurrentHashMap(5);
  private final String b = "normal_log_id";
  private final String c = "realtime_log_id";
  private final String d = "on_date";
  private final Context e;
  private final String f;
  private String g;
  private AtomicLong h = new AtomicLong(0L);
  private AtomicLong i = new AtomicLong(0L);
  private final List<String> j = new ArrayList();
  private SharedPreferences k;
  private boolean l = false;
  private final Runnable m = new c(this);
  
  private d(Context paramContext, String paramString)
  {
    this.e = paramContext;
    this.f = paramString;
  }
  
  private SharedPreferences a(Context paramContext)
  {
    if (this.k == null) {
      this.k = paramContext.getSharedPreferences("b_log_ID_" + a.c(paramContext) + "_" + this.f, 0);
    }
    return this.k;
  }
  
  public static d a(Context paramContext, String paramString)
  {
    try
    {
      d locald2 = (d)a.get(paramString);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(paramContext, paramString);
        a.put(paramString, locald1);
      }
      return locald1;
    }
    finally {}
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      com.tencent.beacon.core.a.d.a().a(new b(this, paramString, paramLong1, paramLong2));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b()
  {
    try
    {
      String str1 = com.tencent.beacon.core.e.b.a(com.tencent.beacon.core.e.b.b(com.tencent.beacon.core.info.b.b(this.e).j()));
      if (!str1.equals(this.g))
      {
        String str2 = this.g;
        this.g = str1;
        a(str2, this.i.get(), this.h.get());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c()
  {
    this.j.add("rqd_model");
    this.j.add("rqd_appresumed");
    d();
    b();
    a();
  }
  
  private void d()
  {
    if (com.tencent.beacon.core.info.b.b(this.e).k())
    {
      com.tencent.beacon.core.e.d.a("[LogID " + this.f + "]  All logID of the new SDK version will be reset!", new Object[0]);
      e();
      return;
    }
    SharedPreferences localSharedPreferences = a(this.e);
    this.g = localSharedPreferences.getString("on_date", "");
    this.i.set(localSharedPreferences.getLong("realtime_log_id", 0L));
    this.h.set(localSharedPreferences.getLong("normal_log_id", 0L));
    com.tencent.beacon.core.e.d.a("[LogID " + this.f + "]", new Object[] { " load LogID from sp, date: %s , realtime: %d, normal: %d", this.g, Long.valueOf(this.i.get()), Long.valueOf(this.h.get()) });
  }
  
  private void e()
  {
    this.i.set(0L);
    this.h.set(0L);
    this.g = com.tencent.beacon.core.e.b.a(com.tencent.beacon.core.e.b.b(com.tencent.beacon.core.info.b.b(this.e).j()));
    a();
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!this.l)
        {
          c();
          this.l = true;
        }
        if (this.j.contains(paramString))
        {
          str = "";
          return str;
        }
        if (paramBoolean)
        {
          str = String.valueOf(this.i.incrementAndGet());
          com.tencent.beacon.core.e.d.a("[stat " + this.f + "]type: %s, code: %s, logID: %s.", new Object[] { Boolean.valueOf(paramBoolean), paramString, str });
          continue;
        }
        l1 = this.h.incrementAndGet();
      }
      finally {}
      long l1;
      String str = String.valueOf(l1);
    }
  }
  
  public void a()
  {
    try
    {
      com.tencent.beacon.core.a.d.a(false);
      com.tencent.beacon.core.a.d.a().a(113, this.m, 0L, 500L);
      com.tencent.beacon.core.a.d.a(true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.stat.d
 * JD-Core Version:    0.7.0.1
 */