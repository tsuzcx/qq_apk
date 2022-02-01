package com.huawei.hms.framework.common;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CreateFileUtil
{
  private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
  private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
  private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
  private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
  private static final String TAG = "CreateFileUtil";
  
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
    return ContextCompat.getProtectedStorageContext(paramContext).getCacheDir().getPath();
  }
  
  public static String getCanonicalPath(String paramString)
  {
    try
    {
      String str = newFile(paramString).getCanonicalPath();
      return str;
    }
    catch (Exception localException)
    {
      Logger.w("CreateFileUtil", "the canonicalPath has other Exception", localException);
      return paramString;
    }
    catch (SecurityException localSecurityException)
    {
      Logger.w("CreateFileUtil", "the canonicalPath has securityException", localSecurityException);
      return paramString;
    }
    catch (IOException localIOException)
    {
      Logger.w("CreateFileUtil", "the canonicalPath has IOException", localIOException);
    }
    return paramString;
  }
  
  @Deprecated
  public static boolean isPVersion()
  {
    return EmuiUtil.isUpPVersion();
  }
  
  public static File newFile(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if ((EmuiUtil.isUpPVersion()) && (ReflectionUtils.checkCompatible("com.huawei.libcore.io.ExternalStorageFile"))) {
      return new ExternalStorageFile(paramString);
    }
    return new File(paramString);
  }
  
  public static FileInputStream newFileInputStream(String paramString)
  {
    if (paramString != null)
    {
      if ((EmuiUtil.isUpPVersion()) && (ReflectionUtils.checkCompatible("com.huawei.libcore.io.ExternalStorageFileInputStream"))) {
        return new ExternalStorageFileInputStream(paramString);
      }
      return new FileInputStream(paramString);
    }
    Logger.w("CreateFileUtil", "newFileInputStream  file is null");
    throw new FileNotFoundException("file is null");
  }
  
  public static FileOutputStream newFileOutputStream(File paramFile)
  {
    if (paramFile != null)
    {
      if ((EmuiUtil.isUpPVersion()) && (ReflectionUtils.checkCompatible("com.huawei.libcore.io.ExternalStorageFileOutputStream"))) {
        return new ExternalStorageFileOutputStream(paramFile);
      }
      return new FileOutputStream(paramFile);
    }
    Logger.e("CreateFileUtil", "newFileOutputStream  file is null");
    throw new FileNotFoundException("file is null");
  }
  
  public static RandomAccessFile newRandomAccessFile(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if ((EmuiUtil.isUpPVersion()) && (ReflectionUtils.checkCompatible("com.huawei.libcore.io.ExternalStorageRandomAccessFile"))) {
        return new ExternalStorageRandomAccessFile(paramString1, paramString2);
      }
      return new RandomAccessFile(paramString1, paramString2);
    }
    Logger.w("CreateFileUtil", "newFileOutputStream  file is null");
    throw new FileNotFoundException("file is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.CreateFileUtil
 * JD-Core Version:    0.7.0.1
 */