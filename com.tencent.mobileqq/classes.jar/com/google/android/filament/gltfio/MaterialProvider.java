package com.google.android.filament.gltfio;

import com.google.android.filament.Engine;

public class MaterialProvider
{
  private long mNativeObject;
  
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