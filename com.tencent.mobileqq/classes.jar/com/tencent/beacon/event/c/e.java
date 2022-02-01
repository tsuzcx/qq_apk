package com.tencent.beacon.event.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.beacon.a.b.a;
import com.tencent.beacon.a.c.b;
import com.tencent.beacon.base.util.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class e
{
  private static final Map<String, e> a = new ConcurrentHashMap(5);
  private static volatile Handler b;
  private final String c = "normal_log_id";
  private final String d = "realtime_log_id";
  private final String e = "on_date";
  private final Context f;
  private final String g;
  private final List<String> h = new ArrayList();
  private String i;
  private AtomicLong j = new AtomicLong(0L);
  private AtomicLong k = new AtomicLong(0L);
  private SharedPreferences l;
  private final Runnable m = new d(this);
  private boolean n = false;
  
  private e(Context paramContext, String paramString)
  {
    this.f = paramContext;
    this.g = paramString;
  }
  
  private SharedPreferences a(Context paramContext)
  {
    if (this.l == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("b_log_ID_");
      localStringBuilder.append(b.c(paramContext));
      localStringBuilder.append("_");
      localStringBuilder.append(this.g);
      this.l = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
    }
    return this.l;
  }
  
  public static e a(Context paramContext, @NonNull String paramString)
  {
    try
    {
      e locale2 = (e)a.get(paramString);
      e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = new e(paramContext, paramString);
        a.put(paramString, locale1);
      }
      return locale1;
    }
    finally {}
  }
  
  private void a()
  {
    try
    {
      if (b == null) {
        b = a.a().a(113);
      }
      return;
    }
    finally {}
  }
  
  private void b()
  {
    a();
    this.h.add("rqd_model");
    this.h.add("rqd_appresumed");
    c();
  }
  
  private void c()
  {
    Object localObject = a(this.f);
    this.i = ((SharedPreferences)localObject).getString("on_date", "");
    this.k.set(((SharedPreferences)localObject).getLong("realtime_log_id", 0L));
    this.j.set(((SharedPreferences)localObject).getLong("normal_log_id", 0L));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[LogID ");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("]");
    c.a(((StringBuilder)localObject).toString(), " load LogID from sp, date: %s , realtime: %d, normal: %d", new Object[] { this.i, Long.valueOf(this.k.get()), Long.valueOf(this.j.get()) });
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    try
    {
      if (!this.n)
      {
        b();
        this.n = true;
      }
      if (this.h.contains(paramString)) {
        return "";
      }
      String str;
      if (paramBoolean) {
        str = String.valueOf(this.k.incrementAndGet());
      } else {
        str = String.valueOf(this.j.incrementAndGet());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[stat ");
      localStringBuilder.append(this.g);
      localStringBuilder.append("]");
      c.a(localStringBuilder.toString(), "type: %s, code: %s, logID: %s.", new Object[] { Boolean.valueOf(paramBoolean), paramString, str });
      b.post(this.m);
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.c.e
 * JD-Core Version:    0.7.0.1
 */