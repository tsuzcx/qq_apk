package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools.Pool;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.Engine.LoadStatus;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;

public final class SingleRequest<R>
  implements Request, ResourceCallback, SizeReadyCallback, FactoryPools.Poolable
{
  private static final Pools.Pool<SingleRequest<?>> a = FactoryPools.a(150, new SingleRequest.1());
  private static final boolean c = Log.isLoggable("Request", 2);
  private int A;
  private int B;
  private boolean b;
  @Nullable
  private final String d;
  private final StateVerifier e;
  @Nullable
  private RequestListener<R> f;
  private RequestCoordinator g;
  private Context h;
  private GlideContext i;
  @Nullable
  private Object j;
  private Class<R> k;
  private RequestOptions l;
  private int m;
  private int n;
  private Priority o;
  private Target<R> p;
  private RequestListener<R> q;
  private Engine r;
  private TransitionFactory<? super R> s;
  private Resource<R> t;
  private Engine.LoadStatus u;
  private long v;
  private SingleRequest.Status w;
  private Drawable x;
  private Drawable y;
  private Drawable z;
  
  SingleRequest()
  {
    String str;
    if (c) {
      str = String.valueOf(super.hashCode());
    } else {
      str = null;
    }
    this.d = str;
    this.e = StateVerifier.a();
  }
  
  private static int a(int paramInt, float paramFloat)
  {
    if (paramInt == -2147483648) {
      return paramInt;
    }
    return Math.round(paramFloat * paramInt);
  }
  
  private Drawable a(@DrawableRes int paramInt)
  {
    Resources.Theme localTheme;
    if (this.l.t() != null) {
      localTheme = this.l.t();
    } else {
      localTheme = this.h.getTheme();
    }
    return DrawableDecoderCompat.a(this.i, paramInt, localTheme);
  }
  
  public static <R> SingleRequest<R> a(Context paramContext, GlideContext paramGlideContext, Object paramObject, Class<R> paramClass, RequestOptions paramRequestOptions, int paramInt1, int paramInt2, Priority paramPriority, Target<R> paramTarget, RequestListener<R> paramRequestListener1, RequestListener<R> paramRequestListener2, RequestCoordinator paramRequestCoordinator, Engine paramEngine, TransitionFactory<? super R> paramTransitionFactory)
  {
    SingleRequest localSingleRequest2 = (SingleRequest)a.acquire();
    SingleRequest localSingleRequest1 = localSingleRequest2;
    if (localSingleRequest2 == null) {
      localSingleRequest1 = new SingleRequest();
    }
    localSingleRequest1.b(paramContext, paramGlideContext, paramObject, paramClass, paramRequestOptions, paramInt1, paramInt2, paramPriority, paramTarget, paramRequestListener1, paramRequestListener2, paramRequestCoordinator, paramEngine, paramTransitionFactory);
    return localSingleRequest1;
  }
  
  private void a(GlideException paramGlideException, int paramInt)
  {
    this.e.b();
    int i1 = this.i.d();
    if (i1 <= paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Load failed for ");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" with size [");
      localStringBuilder.append(this.A);
      localStringBuilder.append("x");
      localStringBuilder.append(this.B);
      localStringBuilder.append("]");
      Log.w("Glide", localStringBuilder.toString(), paramGlideException);
      if (i1 <= 4) {
        paramGlideException.logRootCauses("Glide");
      }
    }
    this.u = null;
    this.w = SingleRequest.Status.FAILED;
    this.b = true;
    try
    {
      if (((this.q == null) || (!this.q.a(paramGlideException, this.j, this.p, t()))) && ((this.f == null) || (!this.f.a(paramGlideException, this.j, this.p, t())))) {
        p();
      }
      this.b = false;
      v();
      return;
    }
    finally
    {
      this.b = false;
    }
  }
  
  private void a(Resource<?> paramResource)
  {
    this.r.a(paramResource);
    this.t = null;
  }
  
  private void a(Resource<R> paramResource, R paramR, DataSource paramDataSource)
  {
    boolean bool = t();
    this.w = SingleRequest.Status.COMPLETE;
    this.t = paramResource;
    if (this.i.d() <= 3)
    {
      paramResource = new StringBuilder();
      paramResource.append("Finished loading ");
      paramResource.append(paramR.getClass().getSimpleName());
      paramResource.append(" from ");
      paramResource.append(paramDataSource);
      paramResource.append(" for ");
      paramResource.append(this.j);
      paramResource.append(" with size [");
      paramResource.append(this.A);
      paramResource.append("x");
      paramResource.append(this.B);
      paramResource.append("] in ");
      paramResource.append(LogTime.a(this.v));
      paramResource.append(" ms");
      Log.d("Glide", paramResource.toString());
    }
    this.b = true;
    try
    {
      if (((this.q == null) || (!this.q.a(paramR, this.j, this.p, paramDataSource, bool))) && ((this.f == null) || (!this.f.a(paramR, this.j, this.p, paramDataSource, bool))))
      {
        paramResource = this.s.a(paramDataSource, bool);
        this.p.a(paramR, paramResource);
      }
      this.b = false;
      u();
      return;
    }
    finally
    {
      this.b = false;
    }
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" this: ");
    localStringBuilder.append(this.d);
    Log.v("Request", localStringBuilder.toString());
  }
  
  private void b(Context paramContext, GlideContext paramGlideContext, Object paramObject, Class<R> paramClass, RequestOptions paramRequestOptions, int paramInt1, int paramInt2, Priority paramPriority, Target<R> paramTarget, RequestListener<R> paramRequestListener1, RequestListener<R> paramRequestListener2, RequestCoordinator paramRequestCoordinator, Engine paramEngine, TransitionFactory<? super R> paramTransitionFactory)
  {
    this.h = paramContext;
    this.i = paramGlideContext;
    this.j = paramObject;
    this.k = paramClass;
    this.l = paramRequestOptions;
    this.m = paramInt1;
    this.n = paramInt2;
    this.o = paramPriority;
    this.p = paramTarget;
    this.f = paramRequestListener1;
    this.q = paramRequestListener2;
    this.g = paramRequestCoordinator;
    this.r = paramEngine;
    this.s = paramTransitionFactory;
    this.w = SingleRequest.Status.PENDING;
  }
  
  private void l()
  {
    if (!this.b) {
      return;
    }
    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
  }
  
  private Drawable m()
  {
    if (this.x == null)
    {
      this.x = this.l.n();
      if ((this.x == null) && (this.l.o() > 0)) {
        this.x = a(this.l.o());
      }
    }
    return this.x;
  }
  
  private Drawable n()
  {
    if (this.y == null)
    {
      this.y = this.l.q();
      if ((this.y == null) && (this.l.p() > 0)) {
        this.y = a(this.l.p());
      }
    }
    return this.y;
  }
  
  private Drawable o()
  {
    if (this.z == null)
    {
      this.z = this.l.s();
      if ((this.z == null) && (this.l.r() > 0)) {
        this.z = a(this.l.r());
      }
    }
    return this.z;
  }
  
  private void p()
  {
    if (!s()) {
      return;
    }
    Object localObject2 = null;
    if (this.j == null) {
      localObject2 = o();
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = m();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = n();
    }
    this.p.c((Drawable)localObject2);
  }
  
  private boolean q()
  {
    RequestCoordinator localRequestCoordinator = this.g;
    return (localRequestCoordinator == null) || (localRequestCoordinator.b(this));
  }
  
  private boolean r()
  {
    RequestCoordinator localRequestCoordinator = this.g;
    return (localRequestCoordinator == null) || (localRequestCoordinator.d(this));
  }
  
  private boolean s()
  {
    RequestCoordinator localRequestCoordinator = this.g;
    return (localRequestCoordinator == null) || (localRequestCoordinator.c(this));
  }
  
  private boolean t()
  {
    RequestCoordinator localRequestCoordinator = this.g;
    return (localRequestCoordinator == null) || (!localRequestCoordinator.k());
  }
  
  private void u()
  {
    RequestCoordinator localRequestCoordinator = this.g;
    if (localRequestCoordinator != null) {
      localRequestCoordinator.e(this);
    }
  }
  
  private void v()
  {
    RequestCoordinator localRequestCoordinator = this.g;
    if (localRequestCoordinator != null) {
      localRequestCoordinator.f(this);
    }
  }
  
  @NonNull
  public StateVerifier E_()
  {
    return this.e;
  }
  
  public void a()
  {
    l();
    this.e.b();
    this.v = LogTime.a();
    if (this.j == null)
    {
      if (Util.a(this.m, this.n))
      {
        this.A = this.m;
        this.B = this.n;
      }
      int i1;
      if (o() == null) {
        i1 = 5;
      } else {
        i1 = 3;
      }
      a(new GlideException("Received null model"), i1);
      return;
    }
    if (this.w != SingleRequest.Status.RUNNING)
    {
      if (this.w == SingleRequest.Status.COMPLETE)
      {
        a(this.t, DataSource.MEMORY_CACHE);
        return;
      }
      this.w = SingleRequest.Status.WAITING_FOR_SIZE;
      if (Util.a(this.m, this.n)) {
        a(this.m, this.n);
      } else {
        this.p.a(this);
      }
      if (((this.w == SingleRequest.Status.RUNNING) || (this.w == SingleRequest.Status.WAITING_FOR_SIZE)) && (s())) {
        this.p.b(n());
      }
      if (c)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("finished run method in ");
        localStringBuilder.append(LogTime.a(this.v));
        a(localStringBuilder.toString());
      }
      return;
    }
    throw new IllegalArgumentException("Cannot restart a running request");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e.b();
    StringBuilder localStringBuilder;
    if (c)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Got onSizeReady in ");
      localStringBuilder.append(LogTime.a(this.v));
      a(localStringBuilder.toString());
    }
    if (this.w != SingleRequest.Status.WAITING_FOR_SIZE) {
      return;
    }
    this.w = SingleRequest.Status.RUNNING;
    float f1 = this.l.B();
    this.A = a(paramInt1, f1);
    this.B = a(paramInt2, f1);
    if (c)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("finished setup for calling load in ");
      localStringBuilder.append(LogTime.a(this.v));
      a(localStringBuilder.toString());
    }
    this.u = this.r.a(this.i, this.j, this.l.v(), this.A, this.B, this.l.l(), this.k, this.o, this.l.m(), this.l.i(), this.l.j(), this.l.C(), this.l.k(), this.l.u(), this.l.D(), this.l.E(), this.l.F(), this);
    if (this.w != SingleRequest.Status.RUNNING) {
      this.u = null;
    }
    if (c)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("finished onSizeReady in ");
      localStringBuilder.append(LogTime.a(this.v));
      a(localStringBuilder.toString());
    }
  }
  
  public void a(GlideException paramGlideException)
  {
    a(paramGlideException, 5);
  }
  
  public void a(Resource<?> paramResource, DataSource paramDataSource)
  {
    this.e.b();
    this.u = null;
    if (paramResource == null)
    {
      paramResource = new StringBuilder();
      paramResource.append("Expected to receive a Resource<R> with an object of ");
      paramResource.append(this.k);
      paramResource.append(" inside, but instead got null.");
      a(new GlideException(paramResource.toString()));
      return;
    }
    Object localObject = paramResource.d();
    if ((localObject != null) && (this.k.isAssignableFrom(localObject.getClass())))
    {
      if (!q())
      {
        a(paramResource);
        this.w = SingleRequest.Status.COMPLETE;
        return;
      }
      a(paramResource, localObject, paramDataSource);
      return;
    }
    a(paramResource);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected to receive an object of ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" but instead got ");
    String str = "";
    if (localObject != null) {
      paramDataSource = localObject.getClass();
    } else {
      paramDataSource = "";
    }
    localStringBuilder.append(paramDataSource);
    localStringBuilder.append("{");
    localStringBuilder.append(localObject);
    localStringBuilder.append("} inside Resource{");
    localStringBuilder.append(paramResource);
    localStringBuilder.append("}.");
    if (localObject != null) {
      paramResource = str;
    } else {
      paramResource = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
    }
    localStringBuilder.append(paramResource);
    a(new GlideException(localStringBuilder.toString()));
  }
  
  public boolean a(Request paramRequest)
  {
    boolean bool3 = paramRequest instanceof SingleRequest;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramRequest = (SingleRequest)paramRequest;
      bool1 = bool2;
      if (this.m == paramRequest.m)
      {
        bool1 = bool2;
        if (this.n == paramRequest.n)
        {
          bool1 = bool2;
          if (Util.b(this.j, paramRequest.j))
          {
            bool1 = bool2;
            if (this.k.equals(paramRequest.k))
            {
              bool1 = bool2;
              if (this.l.equals(paramRequest.l))
              {
                bool1 = bool2;
                if (this.o == paramRequest.o)
                {
                  if (this.q != null)
                  {
                    bool1 = bool2;
                    if (paramRequest.q == null) {
                      return bool1;
                    }
                  }
                  else
                  {
                    bool1 = bool2;
                    if (paramRequest.q != null) {
                      return bool1;
                    }
                  }
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    c();
    this.w = SingleRequest.Status.PAUSED;
  }
  
  public void c()
  {
    Util.a();
    l();
    this.e.b();
    if (this.w == SingleRequest.Status.CLEARED) {
      return;
    }
    k();
    Resource localResource = this.t;
    if (localResource != null) {
      a(localResource);
    }
    if (r()) {
      this.p.a(n());
    }
    this.w = SingleRequest.Status.CLEARED;
  }
  
  public boolean d()
  {
    return this.w == SingleRequest.Status.PAUSED;
  }
  
  public boolean e()
  {
    return (this.w == SingleRequest.Status.RUNNING) || (this.w == SingleRequest.Status.WAITING_FOR_SIZE);
  }
  
  public boolean f()
  {
    return this.w == SingleRequest.Status.COMPLETE;
  }
  
  public boolean g()
  {
    return f();
  }
  
  public boolean h()
  {
    return (this.w == SingleRequest.Status.CANCELLED) || (this.w == SingleRequest.Status.CLEARED);
  }
  
  public boolean i()
  {
    return this.w == SingleRequest.Status.FAILED;
  }
  
  public void j()
  {
    l();
    this.h = null;
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = -1;
    this.n = -1;
    this.p = null;
    this.q = null;
    this.f = null;
    this.g = null;
    this.s = null;
    this.u = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = -1;
    this.B = -1;
    a.release(this);
  }
  
  void k()
  {
    l();
    this.e.b();
    this.p.b(this);
    this.w = SingleRequest.Status.CANCELLED;
    Engine.LoadStatus localLoadStatus = this.u;
    if (localLoadStatus != null)
    {
      localLoadStatus.a();
      this.u = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.SingleRequest
 * JD-Core Version:    0.7.0.1
 */