package com.google.android.filament;

import android.support.annotation.NonNull;
import com.google.android.filament.proguard.UsedByReflection;

public class Engine
{
  @NonNull
  private final LightManager mLightManager;
  private long mNativeObject;
  @NonNull
  private final RenderableManager mRenderableManager;
  @NonNull
  private final TransformManager mTransformManager;
  
  private Engine(long paramLong)
  {
    this.mNativeObject = paramLong;
    this.mTransformManager = new TransformManager(nGetTransformManager(paramLong));
    this.mLightManager = new LightManager(nGetLightManager(paramLong));
    this.mRenderableManager = new RenderableManager(nGetRenderableManager(paramLong));
  }
  
  private void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  @NonNull
  public static Engine create()
  {
    long l = nCreateEngine(0L, 0L);
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create Engine");
    }
    return new Engine(l);
  }
  
  @NonNull
  public static Engine create(@NonNull Engine.Backend paramBackend)
  {
    long l = nCreateEngine(paramBackend.ordinal(), 0L);
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create Engine");
    }
    return new Engine(l);
  }
  
  @NonNull
  public static Engine create(@NonNull Object paramObject)
  {
    if (Platform.get().validateSharedContext(paramObject))
    {
      long l = nCreateEngine(0L, Platform.get().getSharedContextNativeHandle(paramObject));
      if (l == 0L) {
        throw new IllegalStateException("Couldn't create Engine");
      }
      return new Engine(l);
    }
    throw new IllegalArgumentException("Invalid shared context " + paramObject);
  }
  
  private static native long nCreateCamera(long paramLong);
  
  private static native long nCreateCameraWithEntity(long paramLong, int paramInt);
  
  private static native long nCreateEngine(long paramLong1, long paramLong2);
  
  private static native long nCreateFence(long paramLong);
  
  private static native long nCreateRenderer(long paramLong);
  
  private static native long nCreateScene(long paramLong);
  
  private static native long nCreateSwapChain(long paramLong1, Object paramObject, long paramLong2);
  
  private static native long nCreateSwapChainFromRawPointer(long paramLong1, long paramLong2, long paramLong3);
  
  private static native long nCreateView(long paramLong);
  
  private static native void nDestroyCamera(long paramLong1, long paramLong2);
  
  private static native void nDestroyEngine(long paramLong);
  
  private static native void nDestroyEntity(long paramLong, int paramInt);
  
  private static native void nDestroyFence(long paramLong1, long paramLong2);
  
  private static native void nDestroyIndexBuffer(long paramLong1, long paramLong2);
  
  private static native void nDestroyIndirectLight(long paramLong1, long paramLong2);
  
  private static native void nDestroyMaterial(long paramLong1, long paramLong2);
  
  private static native void nDestroyMaterialInstance(long paramLong1, long paramLong2);
  
  private static native void nDestroyRenderTarget(long paramLong1, long paramLong2);
  
  private static native void nDestroyRenderer(long paramLong1, long paramLong2);
  
  private static native void nDestroyScene(long paramLong1, long paramLong2);
  
  private static native void nDestroySkybox(long paramLong1, long paramLong2);
  
  private static native void nDestroyStream(long paramLong1, long paramLong2);
  
  private static native void nDestroySwapChain(long paramLong1, long paramLong2);
  
  private static native void nDestroyTexture(long paramLong1, long paramLong2);
  
  private static native void nDestroyVertexBuffer(long paramLong1, long paramLong2);
  
  private static native void nDestroyView(long paramLong1, long paramLong2);
  
  private static native void nFlushAndWait(long paramLong);
  
  private static native long nGetBackend(long paramLong);
  
  private static native long nGetLightManager(long paramLong);
  
  private static native long nGetRenderableManager(long paramLong);
  
  private static native long nGetTransformManager(long paramLong);
  
  @NonNull
  public Camera createCamera()
  {
    long l = nCreateCamera(getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create Camera");
    }
    return new Camera(l);
  }
  
  @NonNull
  public Camera createCamera(@Entity int paramInt)
  {
    long l = nCreateCameraWithEntity(getNativeObject(), paramInt);
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create Camera");
    }
    return new Camera(l);
  }
  
  @NonNull
  public Fence createFence()
  {
    long l = nCreateFence(getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create Fence");
    }
    return new Fence(l);
  }
  
  @NonNull
  public Renderer createRenderer()
  {
    long l = nCreateRenderer(getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create Renderer");
    }
    return new Renderer(this, l);
  }
  
  @NonNull
  public Scene createScene()
  {
    long l = nCreateScene(getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create Scene");
    }
    return new Scene(l);
  }
  
  @NonNull
  public SwapChain createSwapChain(@NonNull Object paramObject)
  {
    return createSwapChain(paramObject, 0L);
  }
  
  @NonNull
  public SwapChain createSwapChain(@NonNull Object paramObject, long paramLong)
  {
    if (Platform.get().validateSurface(paramObject))
    {
      paramLong = nCreateSwapChain(getNativeObject(), paramObject, paramLong);
      if (paramLong == 0L) {
        throw new IllegalStateException("Couldn't create SwapChain");
      }
      return new SwapChain(paramLong, paramObject);
    }
    throw new IllegalArgumentException("Invalid surface " + paramObject);
  }
  
  @NonNull
  public SwapChain createSwapChainFromNativeSurface(@NonNull NativeSurface paramNativeSurface, long paramLong)
  {
    paramLong = nCreateSwapChainFromRawPointer(getNativeObject(), paramNativeSurface.getNativeObject(), paramLong);
    if (paramLong == 0L) {
      throw new IllegalStateException("Couldn't create SwapChain");
    }
    return new SwapChain(paramLong, paramNativeSurface);
  }
  
  @NonNull
  public View createView()
  {
    long l = nCreateView(getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create View");
    }
    return new View(l);
  }
  
  public void destroy()
  {
    nDestroyEngine(getNativeObject());
    clearNativeObject();
  }
  
  public void destroyCamera(@NonNull Camera paramCamera)
  {
    nDestroyCamera(getNativeObject(), paramCamera.getNativeObject());
    paramCamera.clearNativeObject();
  }
  
  public void destroyEntity(@Entity int paramInt)
  {
    nDestroyEntity(getNativeObject(), paramInt);
  }
  
  public void destroyFence(@NonNull Fence paramFence)
  {
    nDestroyFence(getNativeObject(), paramFence.getNativeObject());
    paramFence.clearNativeObject();
  }
  
  public void destroyIndexBuffer(@NonNull IndexBuffer paramIndexBuffer)
  {
    nDestroyIndexBuffer(getNativeObject(), paramIndexBuffer.getNativeObject());
    paramIndexBuffer.clearNativeObject();
  }
  
  public void destroyIndirectLight(@NonNull IndirectLight paramIndirectLight)
  {
    nDestroyIndirectLight(getNativeObject(), paramIndirectLight.getNativeObject());
    paramIndirectLight.clearNativeObject();
  }
  
  public void destroyMaterial(@NonNull Material paramMaterial)
  {
    nDestroyMaterial(getNativeObject(), paramMaterial.getNativeObject());
    paramMaterial.clearNativeObject();
  }
  
  public void destroyMaterialInstance(@NonNull MaterialInstance paramMaterialInstance)
  {
    nDestroyMaterialInstance(getNativeObject(), paramMaterialInstance.getNativeObject());
    paramMaterialInstance.clearNativeObject();
  }
  
  public void destroyRenderTarget(@NonNull RenderTarget paramRenderTarget)
  {
    nDestroyRenderTarget(getNativeObject(), paramRenderTarget.getNativeObject());
    paramRenderTarget.clearNativeObject();
  }
  
  public void destroyRenderer(@NonNull Renderer paramRenderer)
  {
    nDestroyRenderer(getNativeObject(), paramRenderer.getNativeObject());
    paramRenderer.clearNativeObject();
  }
  
  public void destroyScene(@NonNull Scene paramScene)
  {
    nDestroyScene(getNativeObject(), paramScene.getNativeObject());
    paramScene.clearNativeObject();
  }
  
  public void destroySkybox(@NonNull Skybox paramSkybox)
  {
    nDestroySkybox(getNativeObject(), paramSkybox.getNativeObject());
    paramSkybox.clearNativeObject();
  }
  
  public void destroyStream(@NonNull Stream paramStream)
  {
    nDestroyStream(getNativeObject(), paramStream.getNativeObject());
    paramStream.clearNativeObject();
  }
  
  public void destroySwapChain(@NonNull SwapChain paramSwapChain)
  {
    nDestroySwapChain(getNativeObject(), paramSwapChain.getNativeObject());
    paramSwapChain.clearNativeObject();
  }
  
  public void destroyTexture(@NonNull Texture paramTexture)
  {
    nDestroyTexture(getNativeObject(), paramTexture.getNativeObject());
    paramTexture.clearNativeObject();
  }
  
  public void destroyVertexBuffer(@NonNull VertexBuffer paramVertexBuffer)
  {
    nDestroyVertexBuffer(getNativeObject(), paramVertexBuffer.getNativeObject());
    paramVertexBuffer.clearNativeObject();
  }
  
  public void destroyView(@NonNull View paramView)
  {
    nDestroyView(getNativeObject(), paramView.getNativeObject());
    paramView.clearNativeObject();
  }
  
  public void flushAndWait()
  {
    nFlushAndWait(getNativeObject());
  }
  
  @NonNull
  public Engine.Backend getBackend()
  {
    return Engine.Backend.values()[((int)nGetBackend(getNativeObject()))];
  }
  
  @NonNull
  public LightManager getLightManager()
  {
    return this.mLightManager;
  }
  
  @UsedByReflection("TextureHelper.java")
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed Engine");
    }
    return this.mNativeObject;
  }
  
  @NonNull
  public RenderableManager getRenderableManager()
  {
    return this.mRenderableManager;
  }
  
  @NonNull
  public TransformManager getTransformManager()
  {
    return this.mTransformManager;
  }
  
  public boolean isValid()
  {
    return this.mNativeObject != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.Engine
 * JD-Core Version:    0.7.0.1
 */