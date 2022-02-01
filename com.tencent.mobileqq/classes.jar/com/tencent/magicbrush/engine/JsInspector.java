package com.tencent.magicbrush.engine;

import androidx.annotation.Keep;

public class JsInspector
{
  private static JsInspector.a a;
  
  @Keep
  public static int jniCallbackNotify(long paramLong1, long paramLong2, String paramString)
  {
    JsInspector.a locala = a;
    if (locala == null) {
      return -1;
    }
    return locala.a(paramLong1, paramLong2, paramString);
  }
  
  @Keep
  public static int jniCallbackSendData(long paramLong, String paramString)
  {
    JsInspector.a locala = a;
    if (locala == null) {
      return -1;
    }
    return locala.a(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.engine.JsInspector
 * JD-Core Version:    0.7.0.1
 */