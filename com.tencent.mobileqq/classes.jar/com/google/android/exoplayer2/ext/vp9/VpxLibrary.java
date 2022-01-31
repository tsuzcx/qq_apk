package com.google.android.exoplayer2.ext.vp9;

import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.util.LibraryLoader;

public final class VpxLibrary
{
  private static final LibraryLoader LOADER = new LibraryLoader(new String[] { "vpx", "vpxJNI" });
  
  static
  {
    ExoPlayerLibraryInfo.registerModule("goog.exo.vpx");
  }
  
  public static String getBuildConfig()
  {
    if (isAvailable()) {
      return vpxGetBuildConfig();
    }
    return null;
  }
  
  public static String getVersion()
  {
    if (isAvailable()) {
      return vpxGetVersion();
    }
    return null;
  }
  
  public static boolean isAvailable()
  {
    return LOADER.isAvailable();
  }
  
  public static boolean isHighBitDepthSupported()
  {
    String str = getBuildConfig();
    if (str != null) {}
    for (int i = str.indexOf("--enable-vp9-highbitdepth"); i >= 0; i = -1) {
      return true;
    }
    return false;
  }
  
  public static void setLibraries(String... paramVarArgs)
  {
    LOADER.setLibraries(paramVarArgs);
  }
  
  private static native String vpxGetBuildConfig();
  
  private static native String vpxGetVersion();
  
  public static native boolean vpxIsSecureDecodeSupported();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.vp9.VpxLibrary
 * JD-Core Version:    0.7.0.1
 */