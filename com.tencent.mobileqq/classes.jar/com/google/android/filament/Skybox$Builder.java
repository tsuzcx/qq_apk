package com.google.android.filament;

import androidx.annotation.NonNull;

public class Skybox$Builder
{
  private final Skybox.Builder.BuilderFinalizer mFinalizer = new Skybox.Builder.BuilderFinalizer(this.mNativeBuilder);
  private final long mNativeBuilder = Skybox.access$000();
  
  @NonNull
  public Skybox build(@NonNull Engine paramEngine)
  {
    long l = Skybox.access$400(this.mNativeBuilder, paramEngine.getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create Skybox");
    }
    return new Skybox(l);
  }
  
  @NonNull
  public Builder environment(@NonNull Texture paramTexture)
  {
    Skybox.access$100(this.mNativeBuilder, paramTexture.getNativeObject());
    return this;
  }
  
  @NonNull
  public Builder intensity(float paramFloat)
  {
    Skybox.access$300(this.mNativeBuilder, paramFloat);
    return this;
  }
  
  @NonNull
  public Builder showSun(boolean paramBoolean)
  {
    Skybox.access$200(this.mNativeBuilder, paramBoolean);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.Skybox.Builder
 * JD-Core Version:    0.7.0.1
 */