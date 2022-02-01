package com.google.android.filament.gltfio;

public class AceMaterialInfo
{
  private long mNativeObject;
  
  public AceMaterialInfo(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  public static String getEngineVersion()
  {
    return nGetEngineVersion();
  }
  
  public static String getGlbInfo(String paramString)
  {
    return nGetGlbInfo(paramString);
  }
  
  private static native boolean nAddBone(long paramLong, String paramString);
  
  private static native boolean nDeleteBone(long paramLong, String paramString);
  
  private static native float[] nGetDirectionColor(long paramLong);
  
  private static native int nGetDirectionIntensity(long paramLong);
  
  private static native String nGetEngineVersion();
  
  private static native String nGetGlbInfo(String paramString);
  
  private static native int nGetIblIntensity(long paramLong);
  
  private static native int nGetIblRotation(long paramLong);
  
  private static native float[] nGetLightDirection(long paramLong);
  
  private static native float[] nGetPosition(long paramLong);
  
  private static native float[] nGetRotation(long paramLong);
  
  private static native float[] nGetScale(long paramLong);
  
  private static native void nSetDirectionColor(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetDirectionIntensity(long paramLong, int paramInt);
  
  private static native void nSetIblDegree(long paramLong, float paramFloat);
  
  private static native void nSetIblIntensity(long paramLong, int paramInt);
  
  private static native void nSetLightDirection(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetPosition(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetRotation(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native void nSetScale(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native boolean nUpdateBoneGravity(long paramLong, String paramString, float[] paramArrayOfFloat);
  
  private static native boolean nUpdateBoneNoRotation(long paramLong, String paramString, int paramInt);
  
  private static native boolean nUpdateBoneParams(long paramLong, String paramString1, int paramInt, String paramString2, float paramFloat);
  
  private static native void nUpdateIntensityMap(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  public void addBone(String paramString)
  {
    nAddBone(this.mNativeObject, paramString);
  }
  
  public void deleteBone(String paramString)
  {
    nDeleteBone(this.mNativeObject, paramString);
  }
  
  public float[] getDirectionColor()
  {
    return nGetDirectionColor(this.mNativeObject);
  }
  
  public int getDirectionIntensity()
  {
    return nGetDirectionIntensity(this.mNativeObject);
  }
  
  public int getIblIntensity()
  {
    return nGetIblIntensity(this.mNativeObject);
  }
  
  public int getIblRotation()
  {
    return nGetIblRotation(this.mNativeObject);
  }
  
  public float[] getLightDirection()
  {
    return nGetLightDirection(this.mNativeObject);
  }
  
  public float[] getPosition()
  {
    return nGetPosition(this.mNativeObject);
  }
  
  public float[] getRotation()
  {
    return nGetRotation(this.mNativeObject);
  }
  
  public float[] getScale()
  {
    return nGetScale(this.mNativeObject);
  }
  
  public void setDirectionColor(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetDirectionColor(this.mNativeObject, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setDirectionIntensity(int paramInt)
  {
    nSetDirectionIntensity(this.mNativeObject, paramInt);
  }
  
  public void setIblDegree(float paramFloat)
  {
    nSetIblDegree(this.mNativeObject, paramFloat);
  }
  
  public void setIblIntensity(int paramInt)
  {
    nSetIblIntensity(this.mNativeObject, paramInt);
  }
  
  public void setLightDirection(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetLightDirection(this.mNativeObject, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setPosition(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetPosition(this.mNativeObject, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setRotation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetRotation(this.mNativeObject, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nSetScale(this.mNativeObject, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public boolean updateBoneGravity(String paramString, float[] paramArrayOfFloat)
  {
    return nUpdateBoneGravity(this.mNativeObject, paramString, paramArrayOfFloat);
  }
  
  public boolean updateBoneNoRotation(String paramString, int paramInt)
  {
    return nUpdateBoneNoRotation(this.mNativeObject, paramString, paramInt);
  }
  
  public boolean updateBoneParams(String paramString1, int paramInt, String paramString2, float paramFloat)
  {
    return nUpdateBoneParams(this.mNativeObject, paramString1, paramInt, paramString2, paramFloat);
  }
  
  public void updateIntensityMap(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    nUpdateIntensityMap(this.mNativeObject, paramArrayOfFloat1, paramArrayOfFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.gltfio.AceMaterialInfo
 * JD-Core Version:    0.7.0.1
 */