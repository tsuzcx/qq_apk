package com.google.android.filament;

import java.io.PrintStream;

class Platform$UnknownPlatform
  extends Platform
{
  long getSharedContextNativeHandle(Object paramObject)
  {
    return 0L;
  }
  
  void log(String paramString)
  {
    System.out.println(paramString);
  }
  
  boolean validateSharedContext(Object paramObject)
  {
    return false;
  }
  
  boolean validateStreamSource(Object paramObject)
  {
    return false;
  }
  
  boolean validateSurface(Object paramObject)
  {
    return false;
  }
  
  void warn(String paramString)
  {
    System.out.println(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.Platform.UnknownPlatform
 * JD-Core Version:    0.7.0.1
 */