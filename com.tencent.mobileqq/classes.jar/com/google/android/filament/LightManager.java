package com.google.android.filament;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;

public class LightManager
{
  public static final float EFFICIENCY_FLUORESCENT = 0.0878F;
  public static final float EFFICIENCY_HALOGEN = 0.0707F;
  public static final float EFFICIENCY_INCANDESCENT = 0.022F;
  public static final float EFFICIENCY_LED = 0.1171F;
  private long mNativeObject;
  
  LightManager(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native void nBuilderAngularRadius(long paramLong, float paramFloat);
  
  private static native boolean nBuilderBuild(long paramLong1, long paramLong2, int paramInt);
  
  private static native void nBuilderCastLight(long paramLong, boolean paramBoolean);
  
  private static native void nBuilderCastShadows(long paramLong, boolean paramBoolean);
  
  private static native void nBuilderColor(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nBuilderDirection(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nBuilderFalloff(long paramLong, float paramFloat);
  
  private static native void nBuilderHaloFalloff(long paramLong, float paramFloat);
  
  private static native void nBuilderHaloSize(long paramLong, float paramFloat);
  
  private static native void nBuilderIntensity(long paramLong, float paramFloat);
  
  private static native void nBuilderIntensity(long paramLong, float paramFloat1, float paramFloat2);
  
  private static native void nBuilderPosition(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nBuilderShadowOptions(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean);
  
  private static native void nBuilderSpotLightCone(long paramLong, float paramFloat1, float paramFloat2);
  
  private static native long nCreateBuilder(int paramInt);
  
  private static native void nDestroy(long paramLong, int paramInt);
  
  private static native void nDestroyBuilder(long paramLong);
  
  private static native void nGetColor(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  private static native void nGetDirection(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  private static native float nGetFalloff(long paramLong, int paramInt);
  
  private static native int nGetInstance(long paramLong, int paramInt);
  
  private static native float nGetIntensity(long paramLong, int paramInt);
  
  private static native void nGetPosition(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  private static native float nGetSunAngularRadius(long paramLong, int paramInt);
  
  private static native float nGetSunHaloFalloff(long paramLong, int paramInt);
  
  private static native float nGetSunHaloSize(long paramLong, int paramInt);
  
  private static native int nGetType(long paramLong, int paramInt);
  
  private static native boolean nHasComponent(long paramLong, int paramInt);
  
  private static native boolean nIsShadowCaster(long paramLong, int paramInt);
  
  private static native void nSetColor(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetDirection(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetFalloff(long paramLong, int paramInt, float paramFloat);
  
  private static native void nSetIntensity(long paramLong, int paramInt, float paramFloat);
  
  private static native void nSetIntensity(long paramLong, int paramInt, float paramFloat1, float paramFloat2);
  
  private static native void nSetPosition(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetShadowCaster(long paramLong, int paramInt, boolean paramBoolean);
  
  private static native void nSetSpotLightCone(long paramLong, int paramInt, float paramFloat1, float paramFloat2);
  
  private static native void nSetSunAngularRadius(long paramLong, int paramInt, float paramFloat);
  
  private static native void nSetSunHaloFalloff(long paramLong, int paramInt, float paramFloat);
  
  private static native void nSetSunHaloSize(long paramLong, int paramInt, float paramFloat);
  
  public void destroy(@Entity int paramInt)
  {
    nDestroy(this.mNativeObject, paramInt);
  }
  
  @NonNull
  public float[] getColor(@EntityInstance int paramInt, @Nullable @Size(min=3L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertFloat3(paramArrayOfFloat);
    nGetColor(this.mNativeObject, paramInt, paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  @NonNull
  public float[] getDirection(@EntityInstance int paramInt, @Nullable @Size(min=3L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertFloat3(paramArrayOfFloat);
    nGetDirection(this.mNativeObject, paramInt, paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  public float getFalloff(@EntityInstance int paramInt)
  {
    return nGetFalloff(this.mNativeObject, paramInt);
  }
  
  @EntityInstance
  public int getInstance(@Entity int paramInt)
  {
    return nGetInstance(this.mNativeObject, paramInt);
  }
  
  public float getIntensity(@EntityInstance int paramInt)
  {
    return nGetIntensity(this.mNativeObject, paramInt);
  }
  
  public long getNativeObject()
  {
    return this.mNativeObject;
  }
  
  @NonNull
  public float[] getPosition(@EntityInstance int paramInt, @Nullable @Size(min=3L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertFloat3(paramArrayOfFloat);
    nGetPosition(this.mNativeObject, paramInt, paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  public float getSunAngularRadius(@EntityInstance int paramInt)
  {
    return nGetSunAngularRadius(this.mNativeObject, paramInt);
  }
  
  public float getSunHaloFalloff(@EntityInstance int paramInt)
  {
    return nGetSunHaloFalloff(this.mNativeObject, paramInt);
  }
  
  public float getSunHaloSize(@EntityInstance int paramInt)
  {
    return nGetSunHaloSize(this.mNativeObject, paramInt);
  }
  
  @NonNull
  public LightManager.Type getType(@EntityInstance int paramInt)
  {
    return LightManager.Type.values()[nGetType(this.mNativeObject, paramInt)];
  }
  
  public boolean hasComponent(@Entity int paramInt)
  {
    return nHasComponent(this.mNativeObject, paramInt);
  }
  
  public boolean isShadowCaster(@EntityInstance int paramInt)
  {
    return nIsShadowCaster(this.mNativeObject, paramInt);
  }
  
  public void setColor(@EntityInstance int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetColor(this.mNativeObject, paramInt, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setDirection(@EntityInstance int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetDirection(this.mNativeObject, paramInt, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setFalloff(@EntityInstance int paramInt, float paramFloat)
  {
    nSetFalloff(this.mNativeObject, paramInt, paramFloat);
  }
  
  public void setIntensity(@EntityInstance int paramInt, float paramFloat)
  {
    nSetIntensity(this.mNativeObject, paramInt, paramFloat);
  }
  
  public void setIntensity(@EntityInstance int paramInt, float paramFloat1, float paramFloat2)
  {
    nSetIntensity(this.mNativeObject, paramInt, paramFloat1, paramFloat2);
  }
  
  public void setPosition(@EntityInstance int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetPosition(this.mNativeObject, paramInt, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setShadowCaster(@EntityInstance int paramInt, boolean paramBoolean)
  {
    nSetShadowCaster(this.mNativeObject, paramInt, paramBoolean);
  }
  
  public void setSpotLightCone(@EntityInstance int paramInt, float paramFloat1, float paramFloat2)
  {
    nSetSpotLightCone(this.mNativeObject, paramInt, paramFloat1, paramFloat2);
  }
  
  public void setSunAngularRadius(@EntityInstance int paramInt, float paramFloat)
  {
    nSetSunAngularRadius(this.mNativeObject, paramInt, paramFloat);
  }
  
  public void setSunHaloFalloff(@EntityInstance int paramInt, float paramFloat)
  {
    nSetSunHaloFalloff(this.mNativeObject, paramInt, paramFloat);
  }
  
  public void setSunHaloSize(@EntityInstance int paramInt, float paramFloat)
  {
    nSetSunHaloSize(this.mNativeObject, paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.LightManager
 * JD-Core Version:    0.7.0.1
 */