package com.tencent.mobileqq.activity.fling;

import aiuy;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ScreenCapture
{
  public static final String SNAP_CACHE_FILE = "snap_cache";
  public static final String SNAP_CACHE_FILE_SUCCESS_KEY = "snap_cache_file_success_key";
  
  public static void captureViewToFile(String paramString, View paramView)
  {
    if ((paramString == null) || (paramView == null)) {
      return;
    }
    QLog.i("sethmao", 4, "path is " + paramString);
    new aiuy(paramView).execute(new String[] { paramString });
  }
  
  public static boolean clearSnapCacheFile(Context paramContext)
  {
    return deleteDir(new File(getSnapDir(paramContext)));
  }
  
  public static boolean deleteDir(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          if (!deleteDir(new File(paramFile, arrayOfString[i]))) {
            return false;
          }
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static String getSnapDir(Context paramContext)
  {
    return paramContext.getFilesDir() + "/" + "snap";
  }
  
  public static String getSnapPath(Context paramContext, int paramInt)
  {
    return paramContext.getFilesDir() + "/" + "snap/" + paramInt;
  }
  
  public static boolean hasSnapFile(Context paramContext)
  {
    return paramContext.getSharedPreferences("snap_cache", 0).getBoolean("snap_cache_file_success_key", false);
  }
  
  public static void setSnapFile(Context paramContext, boolean paramBoolean)
  {
    boolean bool = paramContext.getSharedPreferences("snap_cache", 0).edit().putBoolean("snap_cache_file_success_key", paramBoolean).commit();
    QLog.i("sethmao", 4, "captured is " + paramBoolean + ", success is " + bool + ", has snap file is " + hasSnapFile(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ScreenCapture
 * JD-Core Version:    0.7.0.1
 */