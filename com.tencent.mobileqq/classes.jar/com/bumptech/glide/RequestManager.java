package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Iterator;
import java.util.List;

public class RequestManager
  implements ModelTypes<RequestBuilder<Drawable>>, LifecycleListener
{
  private static final RequestOptions d = RequestOptions.a(Bitmap.class).g();
  private static final RequestOptions e = RequestOptions.a(GifDrawable.class).g();
  private static final RequestOptions f = RequestOptions.a(DiskCacheStrategy.c).a(Priority.LOW).b(true);
  protected final Glide a;
  protected final Context b;
  final Lifecycle c;
  private final RequestTracker g;
  private final RequestManagerTreeNode h;
  private final TargetTracker i = new TargetTracker();
  private final Runnable j = new RequestManager.1(this);
  private final Handler k = new Handler(Looper.getMainLooper());
  private final ConnectivityMonitor l;
  private RequestOptions m;
  
  public RequestManager(@NonNull Glide paramGlide, @NonNull Lifecycle paramLifecycle, @NonNull RequestManagerTreeNode paramRequestManagerTreeNode, @NonNull Context paramContext)
  {
    this(paramGlide, paramLifecycle, paramRequestManagerTreeNode, new RequestTracker(), paramGlide.d(), paramContext);
  }
  
  RequestManager(Glide paramGlide, Lifecycle paramLifecycle, RequestManagerTreeNode paramRequestManagerTreeNode, RequestTracker paramRequestTracker, ConnectivityMonitorFactory paramConnectivityMonitorFactory, Context paramContext)
  {
    this.a = paramGlide;
    this.c = paramLifecycle;
    this.h = paramRequestManagerTreeNode;
    this.g = paramRequestTracker;
    this.b = paramContext;
    this.l = paramConnectivityMonitorFactory.a(paramContext.getApplicationContext(), new RequestManager.RequestManagerConnectivityListener(paramRequestTracker));
    if (Util.d()) {
      this.k.post(this.j);
    } else {
      paramLifecycle.a(this);
    }
    paramLifecycle.a(this.l);
    a(paramGlide.e().a());
    paramGlide.a(this);
  }
  
  private void c(@NonNull Target<?> paramTarget)
  {
    if ((!b(paramTarget)) && (!this.a.a(paramTarget)) && (paramTarget.a() != null))
    {
      Request localRequest = paramTarget.a();
      paramTarget.a(null);
      localRequest.c();
    }
  }
  
  @CheckResult
  @NonNull
  public <ResourceType> RequestBuilder<ResourceType> a(@NonNull Class<ResourceType> paramClass)
  {
    return new RequestBuilder(this.a, this, paramClass, this.b);
  }
  
  @CheckResult
  @NonNull
  public RequestBuilder<Drawable> a(@Nullable String paramString)
  {
    return g().a(paramString);
  }
  
  public void a()
  {
    Util.a();
    this.g.a();
  }
  
  protected void a(@NonNull RequestOptions paramRequestOptions)
  {
    this.m = paramRequestOptions.a().h();
  }
  
  public void a(@Nullable Target<?> paramTarget)
  {
    if (paramTarget == null) {
      return;
    }
    if (Util.c())
    {
      c(paramTarget);
      return;
    }
    this.k.post(new RequestManager.2(this, paramTarget));
  }
  
  void a(@NonNull Target<?> paramTarget, @NonNull Request paramRequest)
  {
    this.i.a(paramTarget);
    this.g.a(paramRequest);
  }
  
  @NonNull
  <T> TransitionOptions<?, T> b(Class<T> paramClass)
  {
    return this.a.e().a(paramClass);
  }
  
  public void b()
  {
    Util.a();
    this.g.b();
  }
  
  boolean b(@NonNull Target<?> paramTarget)
  {
    Request localRequest = paramTarget.a();
    if (localRequest == null) {
      return true;
    }
    if (this.g.b(localRequest))
    {
      this.i.b(paramTarget);
      paramTarget.a(null);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    b();
    this.i.c();
  }
  
  public void d()
  {
    a();
    this.i.d();
  }
  
  public void e()
  {
    this.i.e();
    Iterator localIterator = this.i.a().iterator();
    while (localIterator.hasNext()) {
      a((Target)localIterator.next());
    }
    this.i.b();
    this.g.c();
    this.c.b(this);
    this.c.b(this.l);
    this.k.removeCallbacks(this.j);
    this.a.b(this);
  }
  
  @CheckResult
  @NonNull
  public RequestBuilder<Bitmap> f()
  {
    return a(Bitmap.class).a(d);
  }
  
  @CheckResult
  @NonNull
  public RequestBuilder<Drawable> g()
  {
    return a(Drawable.class);
  }
  
  RequestOptions h()
  {
    return this.m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("{tracker=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", treeNode=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.RequestManager
 * JD-Core Version:    0.7.0.1
 */