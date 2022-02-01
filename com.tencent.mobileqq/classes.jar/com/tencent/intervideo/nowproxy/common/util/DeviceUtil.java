package com.tencent.intervideo.nowproxy.common.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.UUID;

public class DeviceUtil
{
  public static final String DEVICE_ID_FILE = "DEVICE_ID";
  public static String sDeviceId = "";
  
  public static File createDir(File paramFile, String paramString)
  {
    if ((paramFile == null) || (paramString == null) || (paramString.length() == 0)) {
      paramFile = null;
    }
    do
    {
      return paramFile;
      paramString = new File(paramFile, paramString);
      paramFile = paramString;
    } while (paramString.exists());
    paramString.mkdirs();
    return paramString;
  }
  
  public static String getDeviceId(Context paramContext)
  {
    if (!TextUtils.isEmpty(sDeviceId)) {
      return sDeviceId;
    }
    try
    {
      paramContext = new File(getExternalFilesDir(paramContext, null).getAbsolutePath() + "/now/", "DEVICE_ID");
      if (paramContext.exists()) {
        sDeviceId = readDeviceIdFromFile(paramContext);
      }
      for (;;)
      {
        return sDeviceId;
        sDeviceId = UUID.randomUUID().toString();
        paramContext.createNewFile();
        writeDeviceIdToFile(paramContext, sDeviceId);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static int getDeviceIdHash(Context paramContext)
  {
    return getDeviceId(paramContext).hashCode() & 0x7FFFFFFF;
  }
  
  public static File getExternalFilesDir(Context paramContext, String paramString)
  {
    File localFile = paramContext.getExternalFilesDir(paramString);
    if (localFile != null) {
      return localFile;
    }
    if (paramString == null) {
      return createDir(getSDcardDir(paramContext), "/Android/data/" + paramContext.getPackageName() + "/files");
    }
    return createDir(getSDcardDir(paramContext), "/Android/data/" + paramContext.getPackageName() + "/files/" + paramString);
  }
  
  public static File getSDcardDir(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        localFile = paramContext.getExternalFilesDir(null);
        paramContext = localFile;
        if (localFile == null) {
          paramContext = Environment.getExternalStorageDirectory();
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        File localFile = new File("/mnt/sdcard");
        if (localFile == null) {
          continue;
        }
        paramContext = localFile;
        if (localFile.exists()) {
          continue;
        }
        localFile = new File("/storage/sdcard0");
        if (localFile == null) {
          break label78;
        }
        paramContext = localFile;
        if (localFile.exists()) {
          continue;
        }
      }
      return paramContext;
      localFile = null;
    }
    label78:
    return null;
  }
  
  private static String readDeviceIdFromFile(File paramFile)
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[(int)paramFile.length()];
    paramFile.readFully(arrayOfByte);
    paramFile.close();
    return new String(arrayOfByte);
  }
  
  private static void writeDeviceIdToFile(File paramFile, String paramString)
  {
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(paramString.getBytes());
    paramFile.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.util.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */