package com.google.android.filament.gltfio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CMShowLoader
{
  private String[] keyList = { "face", "eyebrow", "eyelash", "mouth", "tongue", "tooth_up", "tooth_down", "eyes_l", "eyes_r" };
  private long mNativeObject = nCreateLoader();
  
  public CMShowLoader()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Unable to parse glTF asset.");
    }
  }
  
  private static native long nCreateLoader();
  
  private static native void nDestroy(long paramLong);
  
  private static native float[] nGetVerticesData(long paramLong, String paramString);
  
  private static native void nReset(long paramLong);
  
  private static native void nSetAnimationPath(long paramLong, String paramString);
  
  private static native void nSetFaceJsonPath(long paramLong, String paramString);
  
  private static native void nSetFaceStr(long paramLong, String paramString);
  
  private static native void nSetMorphData(long paramLong, String paramString, String[] paramArrayOfString, float[][] paramArrayOfFloat);
  
  private static native void nSetupKapuModels(long paramLong, String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  public void destroy()
  {
    nDestroy(this.mNativeObject);
  }
  
  public HashMap<String, float[]> getBaseData()
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = this.keyList;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      float[] arrayOfFloat = getVerticesData(str);
      if (arrayOfFloat != null) {
        localHashMap.put(str, arrayOfFloat);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public long getNativeObject()
  {
    return this.mNativeObject;
  }
  
  public float[] getVerticesData(String paramString)
  {
    return nGetVerticesData(this.mNativeObject, paramString);
  }
  
  public void reset()
  {
    nReset(this.mNativeObject);
  }
  
  public void setAnimationPath(String paramString)
  {
    nSetAnimationPath(this.mNativeObject, paramString);
  }
  
  public void setFaceJsonPath(String paramString)
  {
    nSetFaceJsonPath(this.mNativeObject, paramString);
  }
  
  public void setFaceStr(String paramString)
  {
    nSetFaceStr(this.mNativeObject, paramString);
  }
  
  public void setKapuModels(Map<String, String> paramMap)
  {
    nSetupKapuModels(this.mNativeObject, (String[])paramMap.keySet().toArray(new String[0]), (String[])paramMap.values().toArray(new String[0]));
  }
  
  public void setMorphData(String paramString, Map<String, float[]> paramMap)
  {
    nSetMorphData(this.mNativeObject, paramString, (String[])paramMap.keySet().toArray(new String[0]), (float[][])paramMap.values().toArray(new float[0][]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.gltfio.CMShowLoader
 * JD-Core Version:    0.7.0.1
 */