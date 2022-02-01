package com.bumptech.glide.manager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker
{
  private final Set<Request> a = Collections.newSetFromMap(new WeakHashMap());
  private final List<Request> b = new ArrayList();
  private boolean c;
  
  private boolean a(@Nullable Request paramRequest, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramRequest == null) {
      return true;
    }
    boolean bool3 = this.a.remove(paramRequest);
    boolean bool1 = bool2;
    if (!this.b.remove(paramRequest)) {
      if (bool3) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    if (bool1)
    {
      paramRequest.c();
      if (paramBoolean) {
        paramRequest.j();
      }
    }
    return bool1;
  }
  
  public void a()
  {
    this.c = true;
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      Request localRequest = (Request)localIterator.next();
      if (localRequest.e())
      {
        localRequest.b();
        this.b.add(localRequest);
      }
    }
  }
  
  public void a(@NonNull Request paramRequest)
  {
    this.a.add(paramRequest);
    if (!this.c)
    {
      paramRequest.a();
      return;
    }
    if (Log.isLoggable("RequestTracker", 2)) {
      Log.v("RequestTracker", "Paused, delaying request");
    }
    this.b.add(paramRequest);
  }
  
  public void b()
  {
    this.c = false;
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      Request localRequest = (Request)localIterator.next();
      if ((!localRequest.f()) && (!localRequest.h()) && (!localRequest.e())) {
        localRequest.a();
      }
    }
    this.b.clear();
  }
  
  public boolean b(@Nullable Request paramRequest)
  {
    return a(paramRequest, true);
  }
  
  public void c()
  {
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext()) {
      a((Request)localIterator.next(), false);
    }
    this.b.clear();
  }
  
  public void d()
  {
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      Request localRequest = (Request)localIterator.next();
      if ((!localRequest.f()) && (!localRequest.h()))
      {
        localRequest.b();
        if (!this.c) {
          localRequest.a();
        } else {
          this.b.add(localRequest);
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("{numRequests=");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append(", isPaused=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.manager.RequestTracker
 * JD-Core Version:    0.7.0.1
 */