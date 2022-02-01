package com.bumptech.glide.request;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

public class ThumbnailRequestCoordinator
  implements Request, RequestCoordinator
{
  @Nullable
  private final RequestCoordinator a;
  private Request b;
  private Request c;
  private boolean d;
  
  @VisibleForTesting
  ThumbnailRequestCoordinator()
  {
    this(null);
  }
  
  public ThumbnailRequestCoordinator(@Nullable RequestCoordinator paramRequestCoordinator)
  {
    this.a = paramRequestCoordinator;
  }
  
  private boolean l()
  {
    RequestCoordinator localRequestCoordinator = this.a;
    return (localRequestCoordinator == null) || (localRequestCoordinator.b(this));
  }
  
  private boolean m()
  {
    RequestCoordinator localRequestCoordinator = this.a;
    return (localRequestCoordinator == null) || (localRequestCoordinator.d(this));
  }
  
  private boolean n()
  {
    RequestCoordinator localRequestCoordinator = this.a;
    return (localRequestCoordinator == null) || (localRequestCoordinator.c(this));
  }
  
  private boolean o()
  {
    RequestCoordinator localRequestCoordinator = this.a;
    return (localRequestCoordinator != null) && (localRequestCoordinator.k());
  }
  
  public void a()
  {
    this.d = true;
    if ((!this.b.f()) && (!this.c.e())) {
      this.c.a();
    }
    if ((this.d) && (!this.b.e())) {
      this.b.a();
    }
  }
  
  public void a(Request paramRequest1, Request paramRequest2)
  {
    this.b = paramRequest1;
    this.c = paramRequest2;
  }
  
  public boolean a(Request paramRequest)
  {
    boolean bool3 = paramRequest instanceof ThumbnailRequestCoordinator;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramRequest = (ThumbnailRequestCoordinator)paramRequest;
      Request localRequest = this.b;
      if (localRequest == null)
      {
        bool1 = bool2;
        if (paramRequest.b != null) {
          return bool1;
        }
      }
      else
      {
        bool1 = bool2;
        if (!localRequest.a(paramRequest.b)) {
          return bool1;
        }
      }
      localRequest = this.c;
      if (localRequest == null)
      {
        bool1 = bool2;
        if (paramRequest.c != null) {
          return bool1;
        }
      }
      else
      {
        bool1 = bool2;
        if (!localRequest.a(paramRequest.c)) {
          return bool1;
        }
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    this.d = false;
    this.b.b();
    this.c.b();
  }
  
  public boolean b(Request paramRequest)
  {
    return (l()) && ((paramRequest.equals(this.b)) || (!this.b.g()));
  }
  
  public void c()
  {
    this.d = false;
    this.c.c();
    this.b.c();
  }
  
  public boolean c(Request paramRequest)
  {
    return (n()) && (paramRequest.equals(this.b)) && (!k());
  }
  
  public boolean d()
  {
    return this.b.d();
  }
  
  public boolean d(Request paramRequest)
  {
    return (m()) && (paramRequest.equals(this.b));
  }
  
  public void e(Request paramRequest)
  {
    if (paramRequest.equals(this.c)) {
      return;
    }
    paramRequest = this.a;
    if (paramRequest != null) {
      paramRequest.e(this);
    }
    if (!this.c.f()) {
      this.c.c();
    }
  }
  
  public boolean e()
  {
    return this.b.e();
  }
  
  public void f(Request paramRequest)
  {
    if (!paramRequest.equals(this.b)) {
      return;
    }
    paramRequest = this.a;
    if (paramRequest != null) {
      paramRequest.f(this);
    }
  }
  
  public boolean f()
  {
    return (this.b.f()) || (this.c.f());
  }
  
  public boolean g()
  {
    return (this.b.g()) || (this.c.g());
  }
  
  public boolean h()
  {
    return this.b.h();
  }
  
  public boolean i()
  {
    return this.b.i();
  }
  
  public void j()
  {
    this.b.j();
    this.c.j();
  }
  
  public boolean k()
  {
    return (o()) || (g());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.ThumbnailRequestCoordinator
 * JD-Core Version:    0.7.0.1
 */