package com.google.android.filament.gltfio;

import android.support.annotation.NonNull;
import com.google.android.filament.Engine;
import java.lang.reflect.Method;
import java.nio.Buffer;

public class ResourceLoader
{
  private static Method sEngineGetNativeObject;
  private final long mNativeObject;
  
  static
  {
    try
    {
      sEngineGetNativeObject = Engine.class.getDeclaredMethod("getNativeObject", new Class[0]);
      sEngineGetNativeObject.setAccessible(true);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  public ResourceLoader(@NonNull Engine paramEngine)
  {
    this.mNativeObject = nCreateResourceLoader(((Long)sEngineGetNativeObject.invoke(paramEngine, new Object[0])).longValue());
  }
  
  private static native void nAddResourceData(long paramLong, String paramString, Buffer paramBuffer, int paramInt);
  
  private static native long nCreateResourceLoader(long paramLong);
  
  private static native void nDestroyResourceLoader(long paramLong);
  
  private static native void nLoadResources(long paramLong1, long paramLong2);
  
  @NonNull
  public ResourceLoader addResourceData(@NonNull String paramString, @NonNull Buffer paramBuffer)
  {
    nAddResourceData(this.mNativeObject, paramString, paramBuffer, paramBuffer.remaining());
    return this;
  }
  
  public void destroy()
  {
    nDestroyResourceLoader(this.mNativeObject);
  }
  
  @NonNull
  public ResourceLoader loadResources(@NonNull FilamentAsset paramFilamentAsset)
  {
    nLoadResources(this.mNativeObject, paramFilamentAsset.getNativeObject());
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.gltfio.ResourceLoader
 * JD-Core Version:    0.7.0.1
 */