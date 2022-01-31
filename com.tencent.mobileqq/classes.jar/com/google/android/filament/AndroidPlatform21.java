package com.google.android.filament;

import android.opengl.EGLContext;

final class AndroidPlatform21
{
  static long getSharedContextNativeHandle(Object paramObject)
  {
    return ((EGLContext)paramObject).getNativeHandle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.AndroidPlatform21
 * JD-Core Version:    0.7.0.1
 */