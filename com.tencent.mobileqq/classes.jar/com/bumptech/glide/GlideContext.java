package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GlideContext
  extends ContextWrapper
{
  @VisibleForTesting
  static final TransitionOptions<?, ?> a = new GenericTransitionOptions();
  private final Handler b;
  private final ArrayPool c;
  private final Registry d;
  private final ImageViewTargetFactory e;
  private final RequestOptions f;
  private final Map<Class<?>, TransitionOptions<?, ?>> g;
  private final Engine h;
  private final int i;
  
  public GlideContext(@NonNull Context paramContext, @NonNull ArrayPool paramArrayPool, @NonNull Registry paramRegistry, @NonNull ImageViewTargetFactory paramImageViewTargetFactory, @NonNull RequestOptions paramRequestOptions, @NonNull Map<Class<?>, TransitionOptions<?, ?>> paramMap, @NonNull Engine paramEngine, int paramInt)
  {
    super(paramContext.getApplicationContext());
    this.c = paramArrayPool;
    this.d = paramRegistry;
    this.e = paramImageViewTargetFactory;
    this.f = paramRequestOptions;
    this.g = paramMap;
    this.h = paramEngine;
    this.i = paramInt;
    this.b = new Handler(Looper.getMainLooper());
  }
  
  @NonNull
  public <T> TransitionOptions<?, T> a(@NonNull Class<T> paramClass)
  {
    TransitionOptions localTransitionOptions = (TransitionOptions)this.g.get(paramClass);
    Object localObject = localTransitionOptions;
    if (localTransitionOptions == null)
    {
      Iterator localIterator = this.g.entrySet().iterator();
      for (;;)
      {
        localObject = localTransitionOptions;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        if (((Class)((Map.Entry)localObject).getKey()).isAssignableFrom(paramClass)) {
          localTransitionOptions = (TransitionOptions)((Map.Entry)localObject).getValue();
        }
      }
    }
    paramClass = (Class<T>)localObject;
    if (localObject == null) {
      paramClass = a;
    }
    return paramClass;
  }
  
  public RequestOptions a()
  {
    return this.f;
  }
  
  @NonNull
  public <X> ViewTarget<ImageView, X> a(@NonNull ImageView paramImageView, @NonNull Class<X> paramClass)
  {
    return this.e.a(paramImageView, paramClass);
  }
  
  @NonNull
  public Engine b()
  {
    return this.h;
  }
  
  @NonNull
  public Registry c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.i;
  }
  
  @NonNull
  public ArrayPool e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.GlideContext
 * JD-Core Version:    0.7.0.1
 */