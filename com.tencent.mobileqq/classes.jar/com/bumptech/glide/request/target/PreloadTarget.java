package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

public final class PreloadTarget<Z>
  extends SimpleTarget<Z>
{
  private static final Handler a = new Handler(Looper.getMainLooper(), new PreloadTarget.1());
  private final RequestManager b;
  
  public void a(@NonNull Z paramZ, @Nullable Transition<? super Z> paramTransition)
  {
    a.obtainMessage(1, this).sendToTarget();
  }
  
  void b()
  {
    this.b.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.PreloadTarget
 * JD-Core Version:    0.7.0.1
 */