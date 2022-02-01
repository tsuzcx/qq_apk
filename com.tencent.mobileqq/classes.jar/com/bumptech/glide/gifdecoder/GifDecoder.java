package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.nio.ByteBuffer;

public abstract interface GifDecoder
{
  @NonNull
  public abstract ByteBuffer a();
  
  public abstract void a(@NonNull Bitmap.Config paramConfig);
  
  public abstract void b();
  
  public abstract int c();
  
  public abstract int d();
  
  public abstract int e();
  
  public abstract void f();
  
  public abstract int g();
  
  @Nullable
  public abstract Bitmap h();
  
  public abstract void i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.gifdecoder.GifDecoder
 * JD-Core Version:    0.7.0.1
 */