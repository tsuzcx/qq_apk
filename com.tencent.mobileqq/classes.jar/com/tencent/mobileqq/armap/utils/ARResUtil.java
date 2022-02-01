package com.tencent.mobileqq.armap.utils;

import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;

public class ARResUtil
{
  public static String a = "";
  public static String b = "";
  public static String c = new File(b, "preload_map").getAbsolutePath();
  
  static
  {
    try
    {
      bool = "mounted".equals(Environment.getExternalStorageState());
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      label12:
      File localFile;
      break label12;
    }
    bool = false;
    if (bool) {
      localFile = new File(AppConstants.SDCARD_PATH);
    } else {
      localFile = BaseApplicationImpl.getApplication().getCacheDir();
    }
    b = new File(localFile, "AR_MAP").getAbsolutePath();
    a = new File(localFile, "res_precover").getAbsolutePath();
  }
  
  public static String a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.utils.ARResUtil
 * JD-Core Version:    0.7.0.1
 */