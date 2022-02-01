package com.tencent.ilive.util.soloader;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;

public class LoadLibraryUtil
{
  private static final String TAG = "soloaderutil";
  private static File lastSoDir;
  
  @TargetApi(23)
  private static int getPreviousSdkInt()
  {
    try
    {
      int i = Build.VERSION.PREVIEW_SDK_INT;
      return i;
    }
    catch (Throwable localThrowable)
    {
      label6:
      break label6;
    }
    return 1;
  }
  
  public static boolean installNativeLibraryPath(ClassLoader paramClassLoader, File paramFile)
  {
    int i = 0;
    if ((paramClassLoader != null) && (paramFile != null)) {}
    int j;
    label51:
    label63:
    label71:
    try
    {
      if (paramFile.exists())
      {
        j = Build.VERSION.SDK_INT;
        if (j == 25)
        {
          int k = getPreviousSdkInt();
          if (k != 0) {}
        }
        else
        {
          if (j <= 25) {
            break label51;
          }
        }
        i = 1;
        if (i == 0) {}
      }
    }
    finally {}
    try
    {
      LoadLibraryUtil.V25.access$000(paramClassLoader, paramFile);
    }
    catch (Throwable localThrowable1)
    {
      break label63;
    }
    try
    {
      LoadLibraryUtil.V23.access$100(paramClassLoader, paramFile);
    }
    catch (Throwable localThrowable2)
    {
      break label71;
    }
    LoadLibraryUtil.V14.access$200(paramClassLoader, paramFile);
    break label112;
    if (j >= 23) {}
    try
    {
      LoadLibraryUtil.V23.access$100(paramClassLoader, paramFile);
    }
    catch (Throwable localThrowable3)
    {
      label93:
      label112:
      break label93;
    }
    LoadLibraryUtil.V14.access$200(paramClassLoader, paramFile);
    break label112;
    if (j >= 14) {
      LoadLibraryUtil.V14.access$200(paramClassLoader, paramFile);
    }
    lastSoDir = paramFile;
    return true;
    paramClassLoader = new StringBuilder();
    paramClassLoader.append("classLoader or folder is illegal ");
    paramClassLoader.append(paramFile);
    Log.e("soloaderutil", paramClassLoader.toString());
    return false;
  }
  
  public static boolean installNativeLibraryPath(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      boolean bool = installNativeLibraryPath(paramClassLoader, new File(paramString));
      return bool;
    }
    finally
    {
      paramClassLoader = finally;
      throw paramClassLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.util.soloader.LoadLibraryUtil
 * JD-Core Version:    0.7.0.1
 */