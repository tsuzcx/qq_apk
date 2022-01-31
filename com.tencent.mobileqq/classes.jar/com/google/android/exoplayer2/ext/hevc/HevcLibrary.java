package com.google.android.exoplayer2.ext.hevc;

import android.os.Environment;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.util.LibraryLoader;
import java.io.File;

public final class HevcLibrary
{
  private static final LibraryLoader LOADER = new LibraryLoader(new String[] { "hevcdec" });
  
  static
  {
    ExoPlayerLibraryInfo.registerModule("oskHvc");
  }
  
  private static String ensureDir(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile.exists())
    {
      bool1 = bool2;
      if (paramFile.isFile()) {
        bool1 = paramFile.delete();
      }
    }
    if (!paramFile.exists()) {
      bool1 = paramFile.mkdirs();
    }
    bool2 = bool1;
    if (paramFile.isDirectory())
    {
      bool2 = bool1;
      if (paramFile.exists()) {
        bool2 = true;
      }
    }
    if (bool2) {
      return paramFile.getAbsolutePath();
    }
    return null;
  }
  
  public static String ensureFilesDir(String paramString)
  {
    Object localObject3 = null;
    String str = "";
    Object localObject1 = str;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject1 = Environment.getExternalStorageDirectory();
      if (localObject1 != null) {
        str = ensureDir(new File(localObject1 + File.separator + paramString));
      }
      localObject1 = str;
      if (TextUtils.isEmpty(str)) {}
      try
      {
        localObject1 = Environment.getDataDirectory();
        localObject3 = localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject2;
          localException2.printStackTrace();
        }
      }
      localObject1 = str;
      if (localObject3 != null) {
        localObject1 = ensureDir(new File(localObject3 + File.separator + paramString));
      }
      return localObject1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
        localObject2 = null;
      }
    }
  }
  
  public static String getBuildConfig()
  {
    if (isAvailable()) {
      return hevcGetBuildConfig();
    }
    return null;
  }
  
  public static String getVersion()
  {
    if (isAvailable()) {
      return hevcGetVersion();
    }
    return null;
  }
  
  private static native String hevcGetBuildConfig();
  
  private static native String hevcGetVersion();
  
  public static native boolean hevcIsSecureDecodeSupported();
  
  public static boolean isAvailable()
  {
    return LOADER.isAvailable();
  }
  
  public static void setLibraries(String... paramVarArgs)
  {
    LOADER.setLibraries(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.hevc.HevcLibrary
 * JD-Core Version:    0.7.0.1
 */