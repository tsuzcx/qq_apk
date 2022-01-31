package com.google.android.filament.gltfio;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.filament.Engine;
import com.google.android.filament.EntityManager;
import com.google.android.filament.IndirectLight;
import com.google.android.filament.Skybox;
import com.google.android.filament.Texture;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.Buffer;

public class AssetLoader
{
  static Method sEngineGetNativeObject;
  static Method sEntityManagerGetNativeObject;
  static Constructor<IndirectLight> sIndirectLightConstructor;
  static Constructor<Skybox> sSkyboxConstructor;
  static Constructor<Texture> sTextureConstructor;
  private long mNativeObject;
  
  public AssetLoader(@NonNull Engine paramEngine, @NonNull MaterialProvider paramMaterialProvider, @NonNull EntityManager paramEntityManager)
  {
    try
    {
      this.mNativeObject = nCreateAssetLoader(((Long)sEngineGetNativeObject.invoke(paramEngine, new Object[0])).longValue(), paramMaterialProvider.getNativeObject(), ((Long)sEntityManagerGetNativeObject.invoke(paramEntityManager, new Object[0])).longValue());
      label49:
      if (this.mNativeObject == 0L) {
        throw new IllegalStateException("Unable to parse glTF asset.");
      }
      return;
    }
    catch (Exception paramEngine)
    {
      break label49;
    }
  }
  
  public static void init()
  {
    System.loadLibrary("gltfio-jni");
    try
    {
      sEngineGetNativeObject = Engine.class.getDeclaredMethod("getNativeObject", new Class[0]);
      sEngineGetNativeObject.setAccessible(true);
      sEntityManagerGetNativeObject = EntityManager.class.getDeclaredMethod("getNativeObject", new Class[0]);
      sEntityManagerGetNativeObject.setAccessible(true);
      sTextureConstructor = Texture.class.getDeclaredConstructor(new Class[] { Long.TYPE });
      sTextureConstructor.setAccessible(true);
      sIndirectLightConstructor = IndirectLight.class.getDeclaredConstructor(new Class[] { Long.TYPE });
      sIndirectLightConstructor.setAccessible(true);
      sSkyboxConstructor = Skybox.class.getDeclaredConstructor(new Class[] { Long.TYPE });
      sSkyboxConstructor.setAccessible(true);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  public static void initAfterSoLoaded()
  {
    try
    {
      sEngineGetNativeObject = Engine.class.getDeclaredMethod("getNativeObject", new Class[0]);
      sEngineGetNativeObject.setAccessible(true);
      sEntityManagerGetNativeObject = EntityManager.class.getDeclaredMethod("getNativeObject", new Class[0]);
      sEntityManagerGetNativeObject.setAccessible(true);
      sTextureConstructor = Texture.class.getDeclaredConstructor(new Class[] { Long.TYPE });
      sTextureConstructor.setAccessible(true);
      sIndirectLightConstructor = IndirectLight.class.getDeclaredConstructor(new Class[] { Long.TYPE });
      sIndirectLightConstructor.setAccessible(true);
      sSkyboxConstructor = Skybox.class.getDeclaredConstructor(new Class[] { Long.TYPE });
      sSkyboxConstructor.setAccessible(true);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  private static native long nCreateAssetFromBinary(long paramLong, Buffer paramBuffer, int paramInt);
  
  private static native long nCreateAssetLoader(long paramLong1, long paramLong2, long paramLong3);
  
  private static native void nDestroyAsset(long paramLong1, long paramLong2);
  
  private static native void nDestroyAssetLoader(long paramLong);
  
  private static native void nEnableDiagnostics(long paramLong, boolean paramBoolean);
  
  @Nullable
  public FilamentAsset createAssetFromBinary(@NonNull Buffer paramBuffer)
  {
    return new FilamentAsset(nCreateAssetFromBinary(this.mNativeObject, paramBuffer, paramBuffer.remaining()));
  }
  
  public void destroy()
  {
    nDestroyAssetLoader(this.mNativeObject);
    this.mNativeObject = 0L;
  }
  
  public void destroyAsset(@Nullable FilamentAsset paramFilamentAsset)
  {
    nDestroyAsset(this.mNativeObject, paramFilamentAsset.getNativeObject());
    paramFilamentAsset.clearNativeObject();
  }
  
  public void enableDiagnostics(boolean paramBoolean)
  {
    nEnableDiagnostics(this.mNativeObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.gltfio.AssetLoader
 * JD-Core Version:    0.7.0.1
 */