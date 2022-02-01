package com.tencent.luggage.wxa.rt;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.util.Iterator;
import java.util.Map;

public abstract class b
  extends a
{
  public ParcelFileDescriptor a(String paramString1, String paramString2)
  {
    int i;
    if (paramString2.contains("rw")) {
      i = 3;
    } else if (paramString2.contains("w")) {
      i = 2;
    } else {
      i = 1;
    }
    d locald = a(paramString1, i);
    if (locald != null) {
      return locald.a(paramString1, paramString2);
    }
    paramString2 = new StringBuilder();
    paramString2.append("Path not found on any filesystems: ");
    paramString2.append(paramString1);
    throw new FileNotFoundException(paramString2.toString());
  }
  
  protected abstract d a(String paramString, int paramInt);
  
  public OutputStream a(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 2;
    }
    Object localObject = a(paramString, i);
    if (localObject != null) {
      return ((d)localObject).a(paramString, paramBoolean);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Path not found on any filesystems: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  protected abstract Iterable<d> a();
  
  public ReadableByteChannel a(String paramString)
  {
    Object localObject = a(paramString, 1);
    if (localObject != null) {
      return ((d)localObject).a(paramString);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Path not found on any filesystems: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public void a(CancellationSignal paramCancellationSignal)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      paramCancellationSignal.throwIfCanceled();
      locald.a(paramCancellationSignal);
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).a(paramMap);
    }
  }
  
  public int b()
  {
    return a("", 0).b();
  }
  
  public InputStream b(String paramString)
  {
    Object localObject = a(paramString, 1);
    if (localObject != null) {
      return ((d)localObject).b(paramString);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Path not found on any filesystems: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public Iterable<d.a> b(String paramString, boolean paramBoolean)
  {
    return new b.1(this, paramString, paramBoolean);
  }
  
  protected final boolean b(String paramString1, d paramd, String paramString2)
  {
    throw new AssertionError();
  }
  
  public boolean c(String paramString)
  {
    d locald = a(paramString, 1);
    return (locald != null) && (locald.c(paramString));
  }
  
  public boolean c(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = a().iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      bool |= ((d)localIterator.next()).c(paramString, paramBoolean);
    }
    return bool;
  }
  
  protected final long d(String paramString1, d paramd, String paramString2)
  {
    throw new AssertionError();
  }
  
  public d.a d(String paramString)
  {
    d locald = a(paramString, 1);
    if (locald == null) {
      return null;
    }
    return locald.d(paramString);
  }
  
  public String d(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    d locald = a(paramString, i);
    if (locald == null) {
      return null;
    }
    return locald.d(paramString, paramBoolean);
  }
  
  public boolean e(String paramString)
  {
    Iterator localIterator = a().iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      bool |= ((d)localIterator.next()).e(paramString);
    }
    return bool;
  }
  
  public boolean f(String paramString)
  {
    d locald = a(paramString, 2);
    return (locald != null) && (locald.f(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.b
 * JD-Core Version:    0.7.0.1
 */