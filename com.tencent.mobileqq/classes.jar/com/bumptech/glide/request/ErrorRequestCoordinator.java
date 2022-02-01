package com.bumptech.glide.request;

import android.support.annotation.Nullable;

public final class ErrorRequestCoordinator
  implements Request, RequestCoordinator
{
  @Nullable
  private final RequestCoordinator a;
  private Request b;
  private Request c;
  
  public ErrorRequestCoordinator(@Nullable RequestCoordinator paramRequestCoordinator)
  {
    this.a = paramRequestCoordinator;
  }
  
  private boolean g(Request paramRequest)
  {
    return (paramRequest.equals(this.b)) || ((this.b.i()) && (paramRequest.equals(this.c)));
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
    if (!this.b.e()) {
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
    boolean bool3 = paramRequest instanceof ErrorRequestCoordinator;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramRequest = (ErrorRequestCoordinator)paramRequest;
      bool1 = bool2;
      if (this.b.a(paramRequest.b))
      {
        bool1 = bool2;
        if (this.c.a(paramRequest.c)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (!this.b.i()) {
      this.b.b();
    }
    if (this.c.e()) {
      this.c.b();
    }
  }
  
  public boolean b(Request paramRequest)
  {
    return (l()) && (g(paramRequest));
  }
  
  public void c()
  {
    this.b.c();
    if (this.c.e()) {
      this.c.c();
    }
  }
  
  public boolean c(Request paramRequest)
  {
    return (n()) && (g(paramRequest));
  }
  
  public boolean d()
  {
    Request localRequest;
    if (this.b.i()) {
      localRequest = this.c;
    } else {
      localRequest = this.b;
    }
    return localRequest.d();
  }
  
  public boolean d(Request paramRequest)
  {
    return (m()) && (g(paramRequest));
  }
  
  public void e(Request paramRequest)
  {
    paramRequest = this.a;
    if (paramRequest != null) {
      paramRequest.e(this);
    }
  }
  
  public boolean e()
  {
    Request localRequest;
    if (this.b.i()) {
      localRequest = this.c;
    } else {
      localRequest = this.b;
    }
    return localRequest.e();
  }
  
  public void f(Request paramRequest)
  {
    if (!paramRequest.equals(this.c))
    {
      if (!this.c.e()) {
        this.c.a();
      }
      return;
    }
    paramRequest = this.a;
    if (paramRequest != null) {
      paramRequest.f(this);
    }
  }
  
  public boolean f()
  {
    Request localRequest;
    if (this.b.i()) {
      localRequest = this.c;
    } else {
      localRequest = this.b;
    }
    return localRequest.f();
  }
  
  public boolean g()
  {
    Request localRequest;
    if (this.b.i()) {
      localRequest = this.c;
    } else {
      localRequest = this.b;
    }
    return localRequest.g();
  }
  
  public boolean h()
  {
    Request localRequest;
    if (this.b.i()) {
      localRequest = this.c;
    } else {
      localRequest = this.b;
    }
    return localRequest.h();
  }
  
  public boolean i()
  {
    return (this.b.i()) && (this.c.i());
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
 * Qualified Name:     com.bumptech.glide.request.ErrorRequestCoordinator
 * JD-Core Version:    0.7.0.1
 */