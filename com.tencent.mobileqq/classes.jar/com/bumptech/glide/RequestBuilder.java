package com.bumptech.glide;

import android.content.Context;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public class RequestBuilder<TranscodeType>
  implements ModelTypes<RequestBuilder<TranscodeType>>, Cloneable
{
  protected static final RequestOptions a = new RequestOptions().b(DiskCacheStrategy.c).a(Priority.LOW).b(true);
  @NonNull
  protected RequestOptions b;
  private final Context c;
  private final RequestManager d;
  private final Class<TranscodeType> e;
  private final RequestOptions f;
  private final Glide g;
  private final GlideContext h;
  @NonNull
  private TransitionOptions<?, ? super TranscodeType> i;
  @Nullable
  private Object j;
  @Nullable
  private RequestListener<TranscodeType> k;
  @Nullable
  private RequestBuilder<TranscodeType> l;
  @Nullable
  private RequestBuilder<TranscodeType> m;
  @Nullable
  private Float n;
  private boolean o = true;
  private boolean p;
  private boolean q;
  
  protected RequestBuilder(Glide paramGlide, RequestManager paramRequestManager, Class<TranscodeType> paramClass, Context paramContext)
  {
    this.g = paramGlide;
    this.d = paramRequestManager;
    this.e = paramClass;
    this.f = paramRequestManager.h();
    this.c = paramContext;
    this.i = paramRequestManager.b(paramClass);
    this.b = this.f;
    this.h = paramGlide.e();
  }
  
  @NonNull
  private Priority a(@NonNull Priority paramPriority)
  {
    int i1 = RequestBuilder.2.b[paramPriority.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if ((i1 != 3) && (i1 != 4))
        {
          paramPriority = new StringBuilder();
          paramPriority.append("unknown priority: ");
          paramPriority.append(this.b.x());
          throw new IllegalArgumentException(paramPriority.toString());
        }
        return Priority.IMMEDIATE;
      }
      return Priority.HIGH;
    }
    return Priority.NORMAL;
  }
  
  private Request a(Target<TranscodeType> paramTarget, @Nullable RequestListener<TranscodeType> paramRequestListener, @Nullable RequestCoordinator paramRequestCoordinator, TransitionOptions<?, ? super TranscodeType> paramTransitionOptions, Priority paramPriority, int paramInt1, int paramInt2, RequestOptions paramRequestOptions)
  {
    Object localObject1;
    if (this.m != null)
    {
      localObject1 = new ErrorRequestCoordinator(paramRequestCoordinator);
      paramRequestCoordinator = (RequestCoordinator)localObject1;
    }
    else
    {
      Object localObject2 = null;
      localObject1 = paramRequestCoordinator;
      paramRequestCoordinator = localObject2;
    }
    paramTransitionOptions = b(paramTarget, paramRequestListener, (RequestCoordinator)localObject1, paramTransitionOptions, paramPriority, paramInt1, paramInt2, paramRequestOptions);
    if (paramRequestCoordinator == null) {
      return paramTransitionOptions;
    }
    int i3 = this.m.b.y();
    int i4 = this.m.b.A();
    int i2 = i3;
    int i1 = i4;
    if (Util.a(paramInt1, paramInt2))
    {
      i2 = i3;
      i1 = i4;
      if (!this.m.b.z())
      {
        i2 = paramRequestOptions.y();
        i1 = paramRequestOptions.A();
      }
    }
    paramPriority = this.m;
    paramRequestCoordinator.a(paramTransitionOptions, paramPriority.a(paramTarget, paramRequestListener, paramRequestCoordinator, paramPriority.i, paramPriority.b.x(), i2, i1, this.m.b));
    return paramRequestCoordinator;
  }
  
  private Request a(Target<TranscodeType> paramTarget, RequestListener<TranscodeType> paramRequestListener, RequestOptions paramRequestOptions, RequestCoordinator paramRequestCoordinator, TransitionOptions<?, ? super TranscodeType> paramTransitionOptions, Priority paramPriority, int paramInt1, int paramInt2)
  {
    Context localContext = this.c;
    GlideContext localGlideContext = this.h;
    return SingleRequest.a(localContext, localGlideContext, this.j, this.e, paramRequestOptions, paramInt1, paramInt2, paramPriority, paramTarget, paramRequestListener, this.k, paramRequestCoordinator, localGlideContext.b(), paramTransitionOptions.b());
  }
  
  private <Y extends Target<TranscodeType>> Y a(@NonNull Y paramY, @Nullable RequestListener<TranscodeType> paramRequestListener, @NonNull RequestOptions paramRequestOptions)
  {
    Util.a();
    Preconditions.a(paramY);
    if (this.p)
    {
      paramRequestOptions = paramRequestOptions.h();
      paramRequestListener = b(paramY, paramRequestListener, paramRequestOptions);
      Request localRequest = paramY.a();
      if ((paramRequestListener.a(localRequest)) && (!a(paramRequestOptions, localRequest)))
      {
        paramRequestListener.j();
        if (!((Request)Preconditions.a(localRequest)).e()) {
          localRequest.a();
        }
        return paramY;
      }
      this.d.a(paramY);
      paramY.a(paramRequestListener);
      this.d.a(paramY, paramRequestListener);
      return paramY;
    }
    throw new IllegalArgumentException("You must call #load() before calling #into()");
  }
  
  private boolean a(RequestOptions paramRequestOptions, Request paramRequest)
  {
    return (!paramRequestOptions.u()) && (paramRequest.f());
  }
  
  @NonNull
  private RequestBuilder<TranscodeType> b(@Nullable Object paramObject)
  {
    this.j = paramObject;
    this.p = true;
    return this;
  }
  
  private Request b(Target<TranscodeType> paramTarget, RequestListener<TranscodeType> paramRequestListener, @Nullable RequestCoordinator paramRequestCoordinator, TransitionOptions<?, ? super TranscodeType> paramTransitionOptions, Priority paramPriority, int paramInt1, int paramInt2, RequestOptions paramRequestOptions)
  {
    Object localObject2 = this.l;
    if (localObject2 != null)
    {
      if (!this.q)
      {
        Object localObject1 = ((RequestBuilder)localObject2).i;
        if (((RequestBuilder)localObject2).o) {
          localObject1 = paramTransitionOptions;
        }
        if (this.l.b.w()) {
          localObject2 = this.l.b.x();
        } else {
          localObject2 = a(paramPriority);
        }
        int i3 = this.l.b.y();
        int i4 = this.l.b.A();
        int i2 = i3;
        int i1 = i4;
        if (Util.a(paramInt1, paramInt2))
        {
          i2 = i3;
          i1 = i4;
          if (!this.l.b.z())
          {
            i2 = paramRequestOptions.y();
            i1 = paramRequestOptions.A();
          }
        }
        paramRequestCoordinator = new ThumbnailRequestCoordinator(paramRequestCoordinator);
        paramTransitionOptions = a(paramTarget, paramRequestListener, paramRequestOptions, paramRequestCoordinator, paramTransitionOptions, paramPriority, paramInt1, paramInt2);
        this.q = true;
        paramPriority = this.l;
        paramTarget = paramPriority.a(paramTarget, paramRequestListener, paramRequestCoordinator, (TransitionOptions)localObject1, (Priority)localObject2, i2, i1, paramPriority.b);
        this.q = false;
        paramRequestCoordinator.a(paramTransitionOptions, paramTarget);
        return paramRequestCoordinator;
      }
      throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
    }
    if (this.n != null)
    {
      paramRequestCoordinator = new ThumbnailRequestCoordinator(paramRequestCoordinator);
      paramRequestCoordinator.a(a(paramTarget, paramRequestListener, paramRequestOptions, paramRequestCoordinator, paramTransitionOptions, paramPriority, paramInt1, paramInt2), a(paramTarget, paramRequestListener, paramRequestOptions.a().a(this.n.floatValue()), paramRequestCoordinator, paramTransitionOptions, a(paramPriority), paramInt1, paramInt2));
      return paramRequestCoordinator;
    }
    return a(paramTarget, paramRequestListener, paramRequestOptions, paramRequestCoordinator, paramTransitionOptions, paramPriority, paramInt1, paramInt2);
  }
  
  private Request b(Target<TranscodeType> paramTarget, @Nullable RequestListener<TranscodeType> paramRequestListener, RequestOptions paramRequestOptions)
  {
    return a(paramTarget, paramRequestListener, null, this.i, paramRequestOptions.x(), paramRequestOptions.y(), paramRequestOptions.A(), paramRequestOptions);
  }
  
  @CheckResult
  @NonNull
  public RequestBuilder<TranscodeType> a(@NonNull TransitionOptions<?, ? super TranscodeType> paramTransitionOptions)
  {
    this.i = ((TransitionOptions)Preconditions.a(paramTransitionOptions));
    this.o = false;
    return this;
  }
  
  @CheckResult
  @NonNull
  public RequestBuilder<TranscodeType> a(@NonNull RequestOptions paramRequestOptions)
  {
    Preconditions.a(paramRequestOptions);
    this.b = a().a(paramRequestOptions);
    return this;
  }
  
  @CheckResult
  @NonNull
  public RequestBuilder<TranscodeType> a(@Nullable Object paramObject)
  {
    return b(paramObject);
  }
  
  @CheckResult
  @NonNull
  public RequestBuilder<TranscodeType> a(@Nullable String paramString)
  {
    return b(paramString);
  }
  
  @NonNull
  protected RequestOptions a()
  {
    RequestOptions localRequestOptions3 = this.f;
    RequestOptions localRequestOptions2 = this.b;
    RequestOptions localRequestOptions1 = localRequestOptions2;
    if (localRequestOptions3 == localRequestOptions2) {
      localRequestOptions1 = localRequestOptions2.a();
    }
    return localRequestOptions1;
  }
  
  @NonNull
  public <Y extends Target<TranscodeType>> Y a(@NonNull Y paramY)
  {
    return a(paramY, null);
  }
  
  @NonNull
  <Y extends Target<TranscodeType>> Y a(@NonNull Y paramY, @Nullable RequestListener<TranscodeType> paramRequestListener)
  {
    return a(paramY, paramRequestListener, a());
  }
  
  @NonNull
  public ViewTarget<ImageView, TranscodeType> a(@NonNull ImageView paramImageView)
  {
    Util.a();
    Preconditions.a(paramImageView);
    RequestOptions localRequestOptions2 = this.b;
    RequestOptions localRequestOptions1 = localRequestOptions2;
    if (!localRequestOptions2.c())
    {
      localRequestOptions1 = localRequestOptions2;
      if (localRequestOptions2.b())
      {
        localRequestOptions1 = localRequestOptions2;
        if (paramImageView.getScaleType() != null) {
          switch (RequestBuilder.2.a[paramImageView.getScaleType().ordinal()])
          {
          default: 
            localRequestOptions1 = localRequestOptions2;
            break;
          case 6: 
            localRequestOptions1 = localRequestOptions2.a().f();
            break;
          case 3: 
          case 4: 
          case 5: 
            localRequestOptions1 = localRequestOptions2.a().e();
            break;
          case 2: 
            localRequestOptions1 = localRequestOptions2.a().f();
            break;
          case 1: 
            localRequestOptions1 = localRequestOptions2.a().d();
          }
        }
      }
    }
    return (ViewTarget)a(this.h.a(paramImageView, this.e), null, localRequestOptions1);
  }
  
  @CheckResult
  public RequestBuilder<TranscodeType> b()
  {
    try
    {
      RequestBuilder localRequestBuilder = (RequestBuilder)super.clone();
      localRequestBuilder.b = localRequestBuilder.b.a();
      localRequestBuilder.i = localRequestBuilder.i.a();
      return localRequestBuilder;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.RequestBuilder
 * JD-Core Version:    0.7.0.1
 */