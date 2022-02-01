package com.b.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class m<T>
  implements Comparable<m<T>>
{
  private final u.a a;
  private final int b;
  private final String c;
  private final int d;
  private final o.a e;
  private Integer f;
  private n g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private q l;
  private b.a m;
  private m.a n;
  private final Object o;
  
  public m(int paramInt, String paramString, o.a parama)
  {
    u.a locala;
    if (u.a.a) {
      locala = new u.a();
    } else {
      locala = null;
    }
    this.a = locala;
    this.h = true;
    int i1 = 0;
    this.i = false;
    this.j = false;
    this.k = false;
    this.m = null;
    this.o = new Object();
    this.b = paramInt;
    this.c = paramString;
    this.e = parama;
    this.l = new q();
    paramInt = i1;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      paramInt = i1;
      if (paramString != null)
      {
        paramString = paramString.getHost();
        paramInt = i1;
        if (paramString != null) {
          paramInt = paramString.hashCode();
        }
      }
    }
    this.d = paramInt;
  }
  
  protected static t a(t paramt)
  {
    return paramt;
  }
  
  private static byte[] a(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey(), paramString));
        localStringBuilder.append('=');
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), paramString));
        localStringBuilder.append('&');
      }
      paramMap = localStringBuilder.toString().getBytes(paramString);
      return paramMap;
    }
    catch (UnsupportedEncodingException paramMap)
    {
      localStringBuilder = new StringBuilder("Encoding not supported: ");
      localStringBuilder.append(paramString);
      paramMap = new RuntimeException(localStringBuilder.toString(), paramMap);
    }
    for (;;)
    {
      throw paramMap;
    }
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final m<?> a(int paramInt)
  {
    this.f = Integer.valueOf(paramInt);
    return this;
  }
  
  public final m<?> a(b.a parama)
  {
    this.m = parama;
    return this;
  }
  
  public final m<?> a(n paramn)
  {
    this.g = paramn;
    return this;
  }
  
  public final m<?> a(boolean paramBoolean)
  {
    this.h = false;
    return this;
  }
  
  protected abstract o<T> a(j paramj);
  
  final void a(m.a parama)
  {
    synchronized (this.o)
    {
      this.n = parama;
      return;
    }
  }
  
  final void a(o<?> paramo)
  {
    synchronized (this.o)
    {
      if (this.n != null) {
        this.n.a(this, paramo);
      }
      return;
    }
  }
  
  protected abstract void a(T paramT);
  
  public final void a(String paramString)
  {
    if (u.a.a) {
      this.a.a(paramString, Thread.currentThread().getId());
    }
  }
  
  public final int b()
  {
    return this.d;
  }
  
  public final void b(t paramt)
  {
    o.a locala = this.e;
    if (locala != null) {
      locala.a(paramt);
    }
  }
  
  final void b(String paramString)
  {
    n localn = this.g;
    if (localn != null) {
      localn.b(this);
    }
    if (u.a.a)
    {
      long l1 = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        new Handler(Looper.getMainLooper()).post(new m.1(this, paramString, l1));
        return;
      }
      this.a.a(paramString, l1);
      this.a.a(toString());
    }
  }
  
  public final String c()
  {
    return this.c;
  }
  
  public final String d()
  {
    return this.c;
  }
  
  public final b.a e()
  {
    return this.m;
  }
  
  public final boolean f()
  {
    return this.i;
  }
  
  public Map<String, String> g()
  {
    return Collections.emptyMap();
  }
  
  public final byte[] h()
  {
    Map localMap = i();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, "UTF-8");
    }
    return null;
  }
  
  protected Map<String, String> i()
  {
    return null;
  }
  
  public final String j()
  {
    StringBuilder localStringBuilder = new StringBuilder("application/x-www-form-urlencoded; charset=");
    localStringBuilder.append("UTF-8");
    return localStringBuilder.toString();
  }
  
  public final byte[] k()
  {
    Map localMap = i();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, "UTF-8");
    }
    return null;
  }
  
  public final boolean l()
  {
    return this.h;
  }
  
  public m.b m()
  {
    return m.b.b;
  }
  
  public final int n()
  {
    return this.l.a();
  }
  
  public final q o()
  {
    return this.l;
  }
  
  public final void p()
  {
    this.j = true;
  }
  
  public final boolean q()
  {
    return this.j;
  }
  
  final void r()
  {
    synchronized (this.o)
    {
      if (this.n != null) {
        this.n.a(this);
      }
      return;
    }
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder("0x");
    ((StringBuilder)localObject).append(Integer.toHexString(this.d));
    String str = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.i) {
      localObject = "[X] ";
    } else {
      localObject = "[ ] ";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(m());
    localStringBuilder.append(" ");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.m
 * JD-Core Version:    0.7.0.1
 */