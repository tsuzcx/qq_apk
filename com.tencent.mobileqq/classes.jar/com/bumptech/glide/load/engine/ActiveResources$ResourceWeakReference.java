package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

@VisibleForTesting
final class ActiveResources$ResourceWeakReference
  extends WeakReference<EngineResource<?>>
{
  final Key a;
  final boolean b;
  @Nullable
  Resource<?> c;
  
  ActiveResources$ResourceWeakReference(@NonNull Key paramKey, @NonNull EngineResource<?> paramEngineResource, @NonNull ReferenceQueue<? super EngineResource<?>> paramReferenceQueue, boolean paramBoolean)
  {
    super(paramEngineResource, paramReferenceQueue);
    this.a = ((Key)Preconditions.a(paramKey));
    if ((paramEngineResource.b()) && (paramBoolean)) {
      paramKey = (Resource)Preconditions.a(paramEngineResource.a());
    } else {
      paramKey = null;
    }
    this.c = paramKey;
    this.b = paramEngineResource.b();
  }
  
  void a()
  {
    this.c = null;
    clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference
 * JD-Core Version:    0.7.0.1
 */