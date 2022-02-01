package com.tencent.liteav.basic.module;

import com.tencent.liteav.basic.util.h;

public class Monitor
{
  static
  {
    h.f();
  }
  
  public static void a() {}
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    nativeOnlineLogWithLimit(paramInt1, paramInt2, paramString1, paramString2, paramInt3, paramInt4);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    nativeOnlineLog(paramInt1, paramString1, paramString2, paramInt2);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    nativeOnlineLogWithTag(paramInt1, paramString1, paramString2, paramInt2, paramString3);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    nativeInit(paramString1, paramInt, paramString2);
  }
  
  private static native void nativeInit(String paramString1, int paramInt, String paramString2);
  
  private static native void nativeOnlineLog(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  private static native void nativeOnlineLogWithLimit(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4);
  
  private static native void nativeOnlineLogWithTag(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3);
  
  private static native void nativeUnInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.module.Monitor
 * JD-Core Version:    0.7.0.1
 */