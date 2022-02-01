package com.huawei.hms.framework.common;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.android.os.BuildEx.VERSION;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public class CreateFileUtil
{
  private static final String BUILDEX_NAME = "com.huawei.android.os.BuildEx";
  private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
  private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
  private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
  private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
  private static final String TAG = "CreateFileUtil";
  
  private static boolean checkCompatible(String paramString)
  {
    try
    {
      tryLoadClass(paramString);
      return true;
    }
    catch (Exception localException)
    {
      Logger.w("CreateFileUtil", paramString + "ClassNotFoundException");
    }
    return false;
  }
  
  public static void deleteSecure(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()) && (!paramFile.delete())) {
      Logger.w("CreateFileUtil", "deleteSecure exception");
    }
  }
  
  public static void deleteSecure(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      deleteSecure(newFile(paramString));
    }
  }
  
  public static String getCacheDirPath(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (Build.VERSION.SDK_INT < 24) {
      return paramContext.getCacheDir().getPath();
    }
    return paramContext.createDeviceProtectedStorageContext().getCacheDir().getPath();
  }
  
  public static boolean isPVersion()
  {
    return (checkCompatible("com.huawei.android.os.BuildEx")) && (BuildEx.VERSION.EMUI_SDK_INT >= 17);
  }
  
  public static File newFile(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (isPVersion())
    {
      if (checkCompatible("com.huawei.libcore.io.ExternalStorageFile")) {
        return new ExternalStorageFile(paramString);
      }
      return new File(paramString);
    }
    return new File(paramString);
  }
  
  public static FileInputStream newFileInputStream(String paramString)
  {
    if (paramString == null)
    {
      Logger.w("CreateFileUtil", "newFileInputStream  file is null");
      throw new FileNotFoundException("file is null");
    }
    if (isPVersion())
    {
      if (checkCompatible("com.huawei.libcore.io.ExternalStorageFileInputStream")) {
        return new ExternalStorageFileInputStream(paramString);
      }
      return new FileInputStream(paramString);
    }
    return new FileInputStream(paramString);
  }
  
  public static FileOutputStream newFileOutputStream(File paramFile)
  {
    if (paramFile == null)
    {
      Logger.e("CreateFileUtil", "newFileOutputStream  file is null");
      throw new FileNotFoundException("file is null");
    }
    if (isPVersion())
    {
      if (checkCompatible("com.huawei.libcore.io.ExternalStorageFileOutputStream")) {
        return new ExternalStorageFileOutputStream(paramFile);
      }
      return new FileOutputStream(paramFile);
    }
    return new FileOutputStream(paramFile);
  }
  
  public static RandomAccessFile newRandomAccessFile(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      Logger.w("CreateFileUtil", "newFileOutputStream  file is null");
      throw new FileNotFoundException("file is null");
    }
    if (isPVersion())
    {
      if (checkCompatible("com.huawei.libcore.io.ExternalStorageRandomAccessFile")) {
        return new ExternalStorageRandomAccessFile(paramString1, paramString2);
      }
      return new RandomAccessFile(paramString1, paramString2);
    }
    return new RandomAccessFile(paramString1, paramString2);
  }
  
  private static void tryLoadClass(String paramString)
  {
    ClassLoader localClassLoader = CreateFileUtil.class.getClassLoader();
    if (localClassLoader == null) {
      throw new ClassNotFoundException("not found classloader");
    }
    localClassLoader.loadClass(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.CreateFileUtil
 * JD-Core Version:    0.7.0.1
 */