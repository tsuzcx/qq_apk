package com.google.android.filament.gltfio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.filament.Engine;
import com.google.android.filament.EntityManager;
import java.nio.Buffer;

public class AssetLoader
{
  private long mNativeObject;
  
  public AssetLoader(@NonNull Engine paramEngine, @NonNull MaterialProvider paramMaterialProvider, @NonNull EntityManager paramEntityManager)
  {
    this.mNativeObject = nCreateAssetLoader(paramEngine.getNativeObject(), paramMaterialProvider.getNativeObject(), paramEntityManager.getNativeObject());
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Unable to parse glTF asset.");
    }
  }
  
  public static void init()
  {
    System.loadLibrary("gltfio-jni");
  }
  
  private static native long nCreateAssetFromBinary(long paramLong, Buffer paramBuffer, int paramInt);
  
  private static native long nCreateAssetFromJson(long paramLong, Buffer paramBuffer, int paramInt);
  
  private static native long nCreateAssetLoader(long paramLong1, long paramLong2, long paramLong3);
  
  private static native void nDestroyAsset(long paramLong1, long paramLong2);
  
  private static native void nDestroyAssetLoader(long paramLong);
  
  private static native void nEnableDiagnostics(long paramLong, boolean paramBoolean);
  
  @Nullable
  public FilamentAsset createAssetFromBinary(@NonNull Buffer paramBuffer)
  {
    return new FilamentAsset(nCreateAssetFromBinary(this.mNativeObject, paramBuffer, paramBuffer.remaining()));
  }
  
  @Nullable
  public FilamentAsset createAssetFromJson(@NonNull Buffer paramBuffer)
  {
    return new FilamentAsset(nCreateAssetFromJson(this.mNativeObject, paramBuffer, paramBuffer.remaining()));
  }
  
  public void destroy()
  {
    nDestroyAssetLoader(this.mNativeObject);
    this.mNativeObject = 0L;
  }
  
  public void destroyAsset(@NonNull FilamentAsset paramFilamentAsset)
  {
    nDestroyAsset(this.mNativeObject, paramFilamentAsset.getNativeObject());
    paramFilamentAsset.clearNativeObject();
  }
  
  public void enableDiagnostics(boolean paramBoolean)
  {
    nEnableDiagnostics(this.mNativeObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.gltfio.AssetLoader
 * JD-Core Version:    0.7.0.1
 */