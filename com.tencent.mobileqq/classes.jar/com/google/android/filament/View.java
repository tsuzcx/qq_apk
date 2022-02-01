package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;

public class View
{
  private View.AmbientOcclusionOptions mAmbientOcclusionOptions;
  private Camera mCamera;
  private View.DepthPrepass mDepthPrepass = View.DepthPrepass.DEFAULT;
  private View.DynamicResolutionOptions mDynamicResolution;
  private String mName;
  private long mNativeObject;
  private View.RenderQuality mRenderQuality;
  private RenderTarget mRenderTarget;
  private Scene mScene;
  private Viewport mViewport = new Viewport(0, 0, 0, 0);
  
  View(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native int nGetAmbientOcclusion(long paramLong);
  
  private static native int nGetAntiAliasing(long paramLong);
  
  private static native void nGetClearColor(long paramLong, float[] paramArrayOfFloat);
  
  private static native int nGetDithering(long paramLong);
  
  private static native int nGetSampleCount(long paramLong);
  
  private static native int nGetToneMapping(long paramLong);
  
  private static native boolean nIsFrontFaceWindingInverted(long paramLong);
  
  private static native boolean nIsPostProcessingEnabled(long paramLong);
  
  private static native void nSetAmbientOcclusion(long paramLong, int paramInt);
  
  private static native void nSetAmbientOcclusionOptions(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5);
  
  private static native void nSetAntiAliasing(long paramLong, int paramInt);
  
  private static native void nSetCamera(long paramLong1, long paramLong2);
  
  private static native void nSetClearColor(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  private static native void nSetClearTargets(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  private static native void nSetDepthPrepass(long paramLong, int paramInt);
  
  private static native void nSetDithering(long paramLong, int paramInt);
  
  private static native void nSetDynamicLightingOptions(long paramLong, float paramFloat1, float paramFloat2);
  
  private static native void nSetDynamicResolutionOptions(long paramLong, boolean paramBoolean1, boolean paramBoolean2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt);
  
  private static native void nSetFrontFaceWindingInverted(long paramLong, boolean paramBoolean);
  
  private static native void nSetName(long paramLong, String paramString);
  
  private static native void nSetPostProcessingEnabled(long paramLong, boolean paramBoolean);
  
  private static native void nSetRenderFlag(long paramLong, byte paramByte);
  
  private static native void nSetRenderQuality(long paramLong, int paramInt);
  
  private static native void nSetRenderTarget(long paramLong1, long paramLong2);
  
  private static native void nSetSampleCount(long paramLong, int paramInt);
  
  private static native void nSetScene(long paramLong1, long paramLong2);
  
  private static native void nSetShadowsEnabled(long paramLong, boolean paramBoolean);
  
  private static native void nSetToneMapping(long paramLong, int paramInt);
  
  private static native void nSetViewport(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void nSetVisibleLayers(long paramLong, int paramInt1, int paramInt2);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  @NonNull
  public View.AmbientOcclusion getAmbientOcclusion()
  {
    return View.AmbientOcclusion.values()[nGetAmbientOcclusion(getNativeObject())];
  }
  
  @NonNull
  public View.AmbientOcclusionOptions getAmbientOcclusionOptions()
  {
    if (this.mAmbientOcclusionOptions == null) {
      this.mAmbientOcclusionOptions = new View.AmbientOcclusionOptions();
    }
    return this.mAmbientOcclusionOptions;
  }
  
  @NonNull
  public View.AntiAliasing getAntiAliasing()
  {
    return View.AntiAliasing.values()[nGetAntiAliasing(getNativeObject())];
  }
  
  @Nullable
  public Camera getCamera()
  {
    return this.mCamera;
  }
  
  @NonNull
  @Size(min=4L)
  public float[] getClearColor(@NonNull @Size(min=4L) float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Asserts.assertFloat4(paramArrayOfFloat);
    nGetClearColor(getNativeObject(), paramArrayOfFloat);
    return paramArrayOfFloat;
  }
  
  @NonNull
  public View.DepthPrepass getDepthPrepass()
  {
    return this.mDepthPrepass;
  }
  
  @NonNull
  public View.Dithering getDithering()
  {
    return View.Dithering.values()[nGetDithering(getNativeObject())];
  }
  
  @NonNull
  public View.DynamicResolutionOptions getDynamicResolutionOptions()
  {
    if (this.mDynamicResolution == null) {
      this.mDynamicResolution = new View.DynamicResolutionOptions();
    }
    return this.mDynamicResolution;
  }
  
  @Nullable
  public String getName()
  {
    return this.mName;
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed View");
    }
    return this.mNativeObject;
  }
  
  @NonNull
  public View.RenderQuality getRenderQuality()
  {
    if (this.mRenderQuality == null) {
      this.mRenderQuality = new View.RenderQuality();
    }
    return this.mRenderQuality;
  }
  
  @Nullable
  public RenderTarget getRenderTarget()
  {
    return this.mRenderTarget;
  }
  
  public int getSampleCount()
  {
    return nGetSampleCount(getNativeObject());
  }
  
  @Nullable
  public Scene getScene()
  {
    return this.mScene;
  }
  
  @NonNull
  public View.ToneMapping getToneMapping()
  {
    return View.ToneMapping.values()[nGetToneMapping(getNativeObject())];
  }
  
  @NonNull
  public Viewport getViewport()
  {
    return this.mViewport;
  }
  
  public boolean isFrontFaceWindingInverted()
  {
    return nIsFrontFaceWindingInverted(getNativeObject());
  }
  
  public boolean isPostProcessingEnabled()
  {
    return nIsPostProcessingEnabled(getNativeObject());
  }
  
  public void setAmbientOcclusion(@NonNull View.AmbientOcclusion paramAmbientOcclusion)
  {
    nSetAmbientOcclusion(getNativeObject(), paramAmbientOcclusion.ordinal());
  }
  
  public void setAmbientOcclusionOptions(@NonNull View.AmbientOcclusionOptions paramAmbientOcclusionOptions)
  {
    this.mAmbientOcclusionOptions = paramAmbientOcclusionOptions;
    nSetAmbientOcclusionOptions(getNativeObject(), paramAmbientOcclusionOptions.radius, paramAmbientOcclusionOptions.bias, paramAmbientOcclusionOptions.power, paramAmbientOcclusionOptions.resolution, paramAmbientOcclusionOptions.intensity);
  }
  
  public void setAntiAliasing(@NonNull View.AntiAliasing paramAntiAliasing)
  {
    nSetAntiAliasing(getNativeObject(), paramAntiAliasing.ordinal());
  }
  
  public void setCamera(@Nullable Camera paramCamera)
  {
    this.mCamera = paramCamera;
    long l2 = getNativeObject();
    if (paramCamera == null) {}
    for (long l1 = 0L;; l1 = paramCamera.getNativeObject())
    {
      nSetCamera(l2, l1);
      return;
    }
  }
  
  public void setClearColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    nSetClearColor(getNativeObject(), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void setClearTargets(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    nSetClearTargets(getNativeObject(), paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  @Deprecated
  public void setDepthPrepass(@NonNull View.DepthPrepass paramDepthPrepass)
  {
    this.mDepthPrepass = paramDepthPrepass;
    nSetDepthPrepass(getNativeObject(), paramDepthPrepass.value);
  }
  
  public void setDithering(@NonNull View.Dithering paramDithering)
  {
    nSetDithering(getNativeObject(), paramDithering.ordinal());
  }
  
  public void setDynamicLightingOptions(float paramFloat1, float paramFloat2)
  {
    nSetDynamicLightingOptions(getNativeObject(), paramFloat1, paramFloat2);
  }
  
  public void setDynamicResolutionOptions(@NonNull View.DynamicResolutionOptions paramDynamicResolutionOptions)
  {
    this.mDynamicResolution = paramDynamicResolutionOptions;
    nSetDynamicResolutionOptions(getNativeObject(), paramDynamicResolutionOptions.enabled, paramDynamicResolutionOptions.homogeneousScaling, paramDynamicResolutionOptions.targetFrameTimeMilli, paramDynamicResolutionOptions.headRoomRatio, paramDynamicResolutionOptions.scaleRate, paramDynamicResolutionOptions.minScale, paramDynamicResolutionOptions.maxScale, paramDynamicResolutionOptions.history);
  }
  
  public void setFrontFaceWindingInverted(boolean paramBoolean)
  {
    nSetFrontFaceWindingInverted(getNativeObject(), paramBoolean);
  }
  
  public void setName(@NonNull String paramString)
  {
    this.mName = paramString;
    nSetName(getNativeObject(), paramString);
  }
  
  public void setPostProcessingEnabled(boolean paramBoolean)
  {
    nSetPostProcessingEnabled(getNativeObject(), paramBoolean);
  }
  
  public void setRenderFlag(byte paramByte)
  {
    nSetRenderFlag(getNativeObject(), paramByte);
  }
  
  public void setRenderQuality(@NonNull View.RenderQuality paramRenderQuality)
  {
    this.mRenderQuality = paramRenderQuality;
    nSetRenderQuality(getNativeObject(), paramRenderQuality.hdrColorBuffer.ordinal());
  }
  
  public void setRenderTarget(@Nullable RenderTarget paramRenderTarget)
  {
    this.mRenderTarget = paramRenderTarget;
    long l2 = getNativeObject();
    if (paramRenderTarget != null) {}
    for (long l1 = paramRenderTarget.getNativeObject();; l1 = 0L)
    {
      nSetRenderTarget(l2, l1);
      return;
    }
  }
  
  public void setSampleCount(int paramInt)
  {
    nSetSampleCount(getNativeObject(), paramInt);
  }
  
  public void setScene(@Nullable Scene paramScene)
  {
    this.mScene = paramScene;
    long l2 = getNativeObject();
    if (paramScene == null) {}
    for (long l1 = 0L;; l1 = paramScene.getNativeObject())
    {
      nSetScene(l2, l1);
      return;
    }
  }
  
  public void setShadowsEnabled(boolean paramBoolean)
  {
    nSetShadowsEnabled(getNativeObject(), paramBoolean);
  }
  
  public void setToneMapping(@NonNull View.ToneMapping paramToneMapping)
  {
    nSetToneMapping(getNativeObject(), paramToneMapping.ordinal());
  }
  
  public void setViewport(@NonNull Viewport paramViewport)
  {
    this.mViewport = paramViewport;
    nSetViewport(getNativeObject(), this.mViewport.left, this.mViewport.bottom, this.mViewport.width, this.mViewport.height);
  }
  
  public void setVisibleLayers(@IntRange(from=0L, to=255L) int paramInt1, @IntRange(from=0L, to=255L) int paramInt2)
  {
    nSetVisibleLayers(getNativeObject(), paramInt1 & 0xFF, paramInt2 & 0xFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.View
 * JD-Core Version:    0.7.0.1
 */