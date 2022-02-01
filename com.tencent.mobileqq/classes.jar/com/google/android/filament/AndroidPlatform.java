package com.google.android.filament;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Surface;
import java.lang.reflect.Method;

final class AndroidPlatform
  extends Platform
{
  private static final String LOG_TAG = "Filament";
  
  static
  {
    EGL14.eglGetDisplay(0);
  }
  
  long getSharedContextNativeHandle(Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return AndroidPlatform21.getSharedContextNativeHandle(paramObject);
    }
    try
    {
      long l = ((Integer)EGLContext.class.getDeclaredMethod("getHandle", new Class[0]).invoke(paramObject, new Object[0])).longValue();
      return l;
    }
    catch (Exception paramObject)
    {
      Log.d("Filament", "Could not access shared context's native handle", paramObject);
    }
    return 0L;
  }
  
  void log(String paramString)
  {
    Log.d("Filament", paramString);
  }
  
  boolean validateSharedContext(Object paramObject)
  {
    return paramObject instanceof EGLContext;
  }
  
  boolean validateStreamSource(Object paramObject)
  {
    return paramObject instanceof SurfaceTexture;
  }
  
  boolean validateSurface(Object paramObject)
  {
    return paramObject instanceof Surface;
  }
  
  void warn(String paramString)
  {
    Log.w("Filament", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.AndroidPlatform
 * JD-Core Version:    0.7.0.1
 */