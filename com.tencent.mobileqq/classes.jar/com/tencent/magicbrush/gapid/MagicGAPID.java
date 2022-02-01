package com.tencent.magicbrush.gapid;

import androidx.annotation.Keep;

public class MagicGAPID
{
  public static int a = 25;
  public static String b = "/sdcard/tencent/MicroMsg/appbrand/trace";
  private static boolean c = false;
  
  @Keep
  private static native int nativeAttach(String paramString1, String paramString2, int paramInt);
  
  @Keep
  private static native void nativeDetach();
  
  @Keep
  private static native int nativeSnapshotCapture();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.gapid.MagicGAPID
 * JD-Core Version:    0.7.0.1
 */