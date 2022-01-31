package com.google.android.filament.gltfio;

import com.google.android.filament.Engine;
import java.lang.reflect.Method;

public class MaterialProvider
{
  private static Method sEngineGetNativeObject;
  private long mNativeObject;
  
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
  
  public MaterialProvider(Engine paramEngine)
  {
    this.mNativeObject = nCreateMaterialProvider(paramEngine.getNativeObject());
  }
  
  private static native long nCreateMaterialProvider(long paramLong);
  
  private static native void nDestroyMaterialProvider(long paramLong);
  
  public void destroy()
  {
    nDestroyMaterialProvider(this.mNativeObject);
    this.mNativeObject = 0L;
  }
  
  long getNativeObject()
  {
    return this.mNativeObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.gltfio.MaterialProvider
 * JD-Core Version:    0.7.0.1
 */