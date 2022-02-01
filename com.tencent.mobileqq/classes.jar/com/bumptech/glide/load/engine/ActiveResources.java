package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

final class ActiveResources
{
  @VisibleForTesting
  final Map<Key, ActiveResources.ResourceWeakReference> a = new HashMap();
  private final boolean b;
  private final Handler c = new Handler(Looper.getMainLooper(), new ActiveResources.1(this));
  private EngineResource.ResourceListener d;
  @Nullable
  private ReferenceQueue<EngineResource<?>> e;
  @Nullable
  private Thread f;
  private volatile boolean g;
  @Nullable
  private volatile ActiveResources.DequeuedResourceCallback h;
  
  ActiveResources(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  private ReferenceQueue<EngineResource<?>> b()
  {
    if (this.e == null)
    {
      this.e = new ReferenceQueue();
      this.f = new Thread(new ActiveResources.2(this), "glide-active-resources");
      this.f.start();
    }
    return this.e;
  }
  
  void a()
  {
    while (!this.g)
    {
      try
      {
        Object localObject = (ActiveResources.ResourceWeakReference)this.e.remove();
        this.c.obtainMessage(1, localObject).sendToTarget();
        localObject = this.h;
        if (localObject == null) {
          continue;
        }
        ((ActiveResources.DequeuedResourceCallback)localObject).a();
      }
      catch (InterruptedException localInterruptedException)
      {
        label48:
        break label48;
      }
      Thread.currentThread().interrupt();
    }
  }
  
  void a(Key paramKey)
  {
    paramKey = (ActiveResources.ResourceWeakReference)this.a.remove(paramKey);
    if (paramKey != null) {
      paramKey.a();
    }
  }
  
  void a(Key paramKey, EngineResource<?> paramEngineResource)
  {
    paramEngineResource = new ActiveResources.ResourceWeakReference(paramKey, paramEngineResource, b(), this.b);
    paramKey = (ActiveResources.ResourceWeakReference)this.a.put(paramKey, paramEngineResource);
    if (paramKey != null) {
      paramKey.a();
    }
  }
  
  void a(@NonNull ActiveResources.ResourceWeakReference paramResourceWeakReference)
  {
    Util.a();
    this.a.remove(paramResourceWeakReference.a);
    if (paramResourceWeakReference.b)
    {
      if (paramResourceWeakReference.c == null) {
        return;
      }
      EngineResource localEngineResource = new EngineResource(paramResourceWeakReference.c, true, false);
      localEngineResource.a(paramResourceWeakReference.a, this.d);
      this.d.a(paramResourceWeakReference.a, localEngineResource);
    }
  }
  
  void a(EngineResource.ResourceListener paramResourceListener)
  {
    this.d = paramResourceListener;
  }
  
  @Nullable
  EngineResource<?> b(Key paramKey)
  {
    paramKey = (ActiveResources.ResourceWeakReference)this.a.get(paramKey);
    if (paramKey == null) {
      return null;
    }
    EngineResource localEngineResource = (EngineResource)paramKey.get();
    if (localEngineResource == null) {
      a(paramKey);
    }
    return localEngineResource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.ActiveResources
 * JD-Core Version:    0.7.0.1
 */