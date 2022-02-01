package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

@VisibleForTesting
class GifFrameLoader$DelayTarget
  extends SimpleTarget<Bitmap>
{
  final int a;
  private final Handler b;
  private final long c;
  private Bitmap d;
  
  GifFrameLoader$DelayTarget(Handler paramHandler, int paramInt, long paramLong)
  {
    this.b = paramHandler;
    this.a = paramInt;
    this.c = paramLong;
  }
  
  Bitmap F_()
  {
    return this.d;
  }
  
  public void a(@NonNull Bitmap paramBitmap, @Nullable Transition<? super Bitmap> paramTransition)
  {
    this.d = paramBitmap;
    paramBitmap = this.b.obtainMessage(1, this);
    this.b.sendMessageAtTime(paramBitmap, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.GifFrameLoader.DelayTarget
 * JD-Core Version:    0.7.0.1
 */