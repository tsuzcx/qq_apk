package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Size;

public class IndirectLight$Builder
{
  private final IndirectLight.Builder.BuilderFinalizer mFinalizer = new IndirectLight.Builder.BuilderFinalizer(this.mNativeBuilder);
  private final long mNativeBuilder = IndirectLight.access$000();
  
  @NonNull
  public IndirectLight build(@NonNull Engine paramEngine)
  {
    long l = IndirectLight.access$700(this.mNativeBuilder, paramEngine.getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create IndirectLight");
    }
    return new IndirectLight(l);
  }
  
  @NonNull
  public Builder intensity(float paramFloat)
  {
    IndirectLight.access$500(this.mNativeBuilder, paramFloat);
    return this;
  }
  
  @NonNull
  public Builder irradiance(@IntRange(from=1L, to=3L) int paramInt, @NonNull float[] paramArrayOfFloat)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("bands must be 1, 2 or 3");
    case 1: 
      if (paramArrayOfFloat.length < 3) {
        throw new ArrayIndexOutOfBoundsException("1 band SH, array must be at least 1 x float3");
      }
      break;
    case 2: 
      if (paramArrayOfFloat.length < 12) {
        throw new ArrayIndexOutOfBoundsException("2 bands SH, array must be at least 4 x float3");
      }
      break;
    case 3: 
      if (paramArrayOfFloat.length < 27) {
        throw new ArrayIndexOutOfBoundsException("3 bands SH, array must be at least 9 x float3");
      }
      break;
    }
    IndirectLight.access$200(this.mNativeBuilder, paramInt, paramArrayOfFloat);
    return this;
  }
  
  @NonNull
  public Builder irradiance(@NonNull Texture paramTexture)
  {
    IndirectLight.access$400(this.mNativeBuilder, paramTexture.getNativeObject());
    return this;
  }
  
  @NonNull
  public Builder radiance(@IntRange(from=1L, to=3L) int paramInt, @NonNull float[] paramArrayOfFloat)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("bands must be 1, 2 or 3");
    case 1: 
      if (paramArrayOfFloat.length < 3) {
        throw new ArrayIndexOutOfBoundsException("1 band SH, array must be at least 1 x float3");
      }
      break;
    case 2: 
      if (paramArrayOfFloat.length < 12) {
        throw new ArrayIndexOutOfBoundsException("2 bands SH, array must be at least 4 x float3");
      }
      break;
    case 3: 
      if (paramArrayOfFloat.length < 27) {
        throw new ArrayIndexOutOfBoundsException("3 bands SH, array must be at least 9 x float3");
      }
      break;
    }
    IndirectLight.access$300(this.mNativeBuilder, paramInt, paramArrayOfFloat);
    return this;
  }
  
  @NonNull
  public Builder reflections(@NonNull Texture paramTexture)
  {
    IndirectLight.access$100(this.mNativeBuilder, paramTexture.getNativeObject());
    return this;
  }
  
  @NonNull
  public Builder rotation(@NonNull @Size(min=9L) float[] paramArrayOfFloat)
  {
    IndirectLight.access$600(this.mNativeBuilder, paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3], paramArrayOfFloat[4], paramArrayOfFloat[5], paramArrayOfFloat[6], paramArrayOfFloat[7], paramArrayOfFloat[8]);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.IndirectLight.Builder
 * JD-Core Version:    0.7.0.1
 */