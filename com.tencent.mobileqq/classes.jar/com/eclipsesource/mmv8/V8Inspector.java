package com.eclipsesource.mmv8;

import androidx.annotation.Keep;

public class V8Inspector
{
  private static V8Inspector.JsInspectorChannelServer _server;
  
  static native int JniNotify(long paramLong1, long paramLong2, String paramString);
  
  static native void JniReceiveData(long paramLong, String paramString);
  
  @Keep
  public static int jniCallbackNotify(long paramLong1, long paramLong2, String paramString)
  {
    V8Inspector.JsInspectorChannelServer localJsInspectorChannelServer = _server;
    if (localJsInspectorChannelServer == null) {
      return -1;
    }
    return localJsInspectorChannelServer.notify(paramLong1, paramLong2, paramString);
  }
  
  @Keep
  public static int jniCallbackSendData(long paramLong, String paramString)
  {
    V8Inspector.JsInspectorChannelServer localJsInspectorChannelServer = _server;
    if (localJsInspectorChannelServer == null) {
      return -1;
    }
    return localJsInspectorChannelServer.sendData(paramLong, paramString);
  }
  
  public static int notify(long paramLong1, long paramLong2, String paramString)
  {
    return JniNotify(paramLong1, paramLong2, paramString);
  }
  
  public static void onReceiveData(long paramLong, String paramString)
  {
    JniReceiveData(paramLong, paramString);
  }
  
  public static void setServer(V8Inspector.JsInspectorChannelServer paramJsInspectorChannelServer)
  {
    _server = paramJsInspectorChannelServer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.V8Inspector
 * JD-Core Version:    0.7.0.1
 */