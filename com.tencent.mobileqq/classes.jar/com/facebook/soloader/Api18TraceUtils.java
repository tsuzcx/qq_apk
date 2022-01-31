package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;

@TargetApi(18)
@DoNotOptimize
class Api18TraceUtils
{
  public static void beginTraceSection(String paramString)
  {
    Trace.beginSection(paramString);
  }
  
  public static void endSection() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.soloader.Api18TraceUtils
 * JD-Core Version:    0.7.0.1
 */