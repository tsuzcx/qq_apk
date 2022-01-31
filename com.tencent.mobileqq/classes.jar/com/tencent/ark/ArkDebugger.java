package com.tencent.ark;

public class ArkDebugger
{
  public static final int ERROR_CODE_LISTENNING_TIMEOUT = 1;
  public static final int ERROR_CODE_OK = 0;
  public static final int ERROR_CODE_STOP_ESTABLISHED = 3;
  public static final int ERROR_CODE_STOP_LISTENNING = 2;
  
  public static final native boolean Create();
  
  public static final native boolean Destroy();
  
  public static final native boolean Listen(String paramString1, long paramLong1, long paramLong2, String paramString2);
  
  public static final native boolean SetCallback(ArkDebugger.DebuggerCallback paramDebuggerCallback);
  
  public static final native boolean SetJSLibraryPath(String paramString1, String paramString2);
  
  public static final native boolean Stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.ArkDebugger
 * JD-Core Version:    0.7.0.1
 */