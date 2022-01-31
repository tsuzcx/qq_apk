package com.google.android.filament;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

public class Texture$Builder
{
  private final Texture.Builder.BuilderFinalizer mFinalizer = new Texture.Builder.BuilderFinalizer(this.mNativeBuilder);
  private final long mNativeBuilder = Texture.access$000();
  
  @NonNull
  public Texture build(@NonNull Engine paramEngine)
  {
    long l = Texture.access$800(this.mNativeBuilder, paramEngine.getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create Texture");
    }
    return new Texture(l);
  }
  
  @NonNull
  public Builder depth(@IntRange(from=1L) int paramInt)
  {
    Texture.access$300(this.mNativeBuilder, paramInt);
    return this;
  }
  
  @NonNull
  public Builder format(@NonNull Texture.InternalFormat paramInternalFormat)
  {
    Texture.access$600(this.mNativeBuilder, paramInternalFormat.ordinal());
    return this;
  }
  
  @NonNull
  public Builder height(@IntRange(from=1L) int paramInt)
  {
    Texture.access$200(this.mNativeBuilder, paramInt);
    return this;
  }
  
  @NonNull
  public Builder levels(@IntRange(from=1L) int paramInt)
  {
    Texture.access$400(this.mNativeBuilder, paramInt);
    return this;
  }
  
  @NonNull
  public Builder sampler(@NonNull Texture.Sampler paramSampler)
  {
    Texture.access$500(this.mNativeBuilder, paramSampler.ordinal());
    return this;
  }
  
  @NonNull
  public Builder usage(int paramInt)
  {
    Texture.access$700(this.mNativeBuilder, paramInt);
    return this;
  }
  
  @NonNull
  public Builder width(@IntRange(from=1L) int paramInt)
  {
    Texture.access$100(this.mNativeBuilder, paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.Texture.Builder
 * JD-Core Version:    0.7.0.1
 */