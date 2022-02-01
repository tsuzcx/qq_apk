package com.tencent.avcore.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.lang.ref.WeakReference;

public class CameraConfigHelper
{
  private static final String SP_DEFAULT_VALUE = "preview-size-values=320x240,640x480;";
  private static final String SP_KEY = "CP";
  private static final String SP_NAME = "AV_CameraParameters";
  private static CameraConfigHelper sInstance;
  private String mCameraParameters = null;
  private WeakReference<Context> mRef;
  
  private CameraConfigHelper(Context paramContext)
  {
    this.mRef = new WeakReference(paramContext);
    if (paramContext != null) {
      this.mCameraParameters = paramContext.getSharedPreferences("AV_CameraParameters", 0).getString("CP", "preview-size-values=320x240,640x480;");
    }
  }
  
  public static CameraConfigHelper getInstance(Context paramContext)
  {
    CameraConfigHelper localCameraConfigHelper = sInstance;
    if (localCameraConfigHelper == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new CameraConfigHelper(paramContext);
        }
      }
      finally {}
    } else {
      localCameraConfigHelper.updateContext(paramContext);
    }
    return sInstance;
  }
  
  private void updateContext(Context paramContext)
  {
    if (paramContext != null)
    {
      WeakReference localWeakReference = this.mRef;
      if ((localWeakReference == null) || (localWeakReference.get() == null)) {
        this.mRef = new WeakReference(paramContext);
      }
    }
  }
  
  public String getCameraParameters()
  {
    try
    {
      String str2 = this.mCameraParameters;
      String str1 = str2;
      if (str2 == null) {
        str1 = "preview-size-values=320x240,640x480;";
      }
      return str1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCameraParameters(String paramString)
  {
    this.mCameraParameters = paramString;
    Object localObject = this.mRef;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (Context)((WeakReference)localObject).get();
    }
    if (localObject != null)
    {
      localObject = ((Context)localObject).getSharedPreferences("AV_CameraParameters", 0).edit();
      ((SharedPreferences.Editor)localObject).putString("CP", paramString);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.config.CameraConfigHelper
 * JD-Core Version:    0.7.0.1
 */