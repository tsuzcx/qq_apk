package com.google.android.filament;

import android.support.annotation.NonNull;

public class LightManager$Builder
{
  private final LightManager.Builder.BuilderFinalizer mFinalizer;
  private final long mNativeBuilder;
  
  public LightManager$Builder(@NonNull LightManager.Type paramType)
  {
    this.mNativeBuilder = LightManager.access$000(paramType.ordinal());
    this.mFinalizer = new LightManager.Builder.BuilderFinalizer(this.mNativeBuilder);
  }
  
  public void build(@NonNull Engine paramEngine, @Entity int paramInt)
  {
    if (!LightManager.access$1400(this.mNativeBuilder, paramEngine.getNativeObject(), paramInt)) {
      throw new IllegalStateException("Couldn't create Light component for entity " + paramInt + ", see log.");
    }
  }
  
  @NonNull
  public Builder castLight(boolean paramBoolean)
  {
    LightManager.access$300(this.mNativeBuilder, paramBoolean);
    return this;
  }
  
  @NonNull
  public Builder castShadows(boolean paramBoolean)
  {
    LightManager.access$100(this.mNativeBuilder, paramBoolean);
    return this;
  }
  
  @NonNull
  public Builder color(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    LightManager.access$600(this.mNativeBuilder, paramFloat1, paramFloat2, paramFloat3);
    return this;
  }
  
  @NonNull
  public Builder direction(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    LightManager.access$500(this.mNativeBuilder, paramFloat1, paramFloat2, paramFloat3);
    return this;
  }
  
  @NonNull
  public Builder falloff(float paramFloat)
  {
    LightManager.access$900(this.mNativeBuilder, paramFloat);
    return this;
  }
  
  @NonNull
  public Builder intensity(float paramFloat)
  {
    LightManager.access$700(this.mNativeBuilder, paramFloat);
    return this;
  }
  
  @NonNull
  public Builder intensity(float paramFloat1, float paramFloat2)
  {
    LightManager.access$800(this.mNativeBuilder, paramFloat1, paramFloat2);
    return this;
  }
  
  @NonNull
  public Builder position(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    LightManager.access$400(this.mNativeBuilder, paramFloat1, paramFloat2, paramFloat3);
    return this;
  }
  
  @NonNull
  public Builder shadowOptions(@NonNull LightManager.ShadowOptions paramShadowOptions)
  {
    LightManager.access$200(this.mNativeBuilder, paramShadowOptions.mapSize, paramShadowOptions.constantBias, paramShadowOptions.normalBias, paramShadowOptions.shadowFar, paramShadowOptions.shadowNearHint, paramShadowOptions.shadowFarHint, paramShadowOptions.stable);
    return this;
  }
  
  @NonNull
  public Builder spotLightCone(float paramFloat1, float paramFloat2)
  {
    LightManager.access$1000(this.mNativeBuilder, paramFloat1, paramFloat2);
    return this;
  }
  
  @NonNull
  public Builder sunAngularRadius(float paramFloat)
  {
    LightManager.access$1100(this.mNativeBuilder, paramFloat);
    return this;
  }
  
  @NonNull
  public Builder sunHaloFalloff(float paramFloat)
  {
    LightManager.access$1300(this.mNativeBuilder, paramFloat);
    return this;
  }
  
  @NonNull
  public Builder sunHaloSize(float paramFloat)
  {
    LightManager.access$1200(this.mNativeBuilder, paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.LightManager.Builder
 * JD-Core Version:    0.7.0.1
 */