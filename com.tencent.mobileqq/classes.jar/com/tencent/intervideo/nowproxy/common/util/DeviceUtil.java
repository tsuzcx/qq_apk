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
    if ((paramFile != null) && (paramString != null) && (paramString.length() != 0))
    {
      paramFile = new File(paramFile, paramString);
      if (!paramFile.exists()) {
        paramFile.mkdirs();
      }
      return paramFile;
    }
    return null;
  }
  
  public static String getDeviceId(Context paramContext)
  {
    if (!TextUtils.isEmpty(sDeviceId)) {
      return sDeviceId;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getExternalFilesDir(paramContext, null).getAbsolutePath());
      localStringBuilder.append("/now/");
      paramContext = new File(localStringBuilder.toString(), "DEVICE_ID");
      if (paramContext.exists())
      {
        sDeviceId = readDeviceIdFromFile(paramContext);
      }
      else
      {
        sDeviceId = UUID.randomUUID().toString();
        paramContext.createNewFile();
        writeDeviceIdToFile(paramContext, sDeviceId);
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return sDeviceId;
  }
  
  public static int getDeviceIdHash(Context paramContext)
  {
    return getDeviceId(paramContext).hashCode() & 0x7FFFFFFF;
  }
  
  public static File getExternalFilesDir(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getExternalFilesDir(paramString);
    if (localObject != null) {
      return localObject;
    }
    if (paramString == null)
    {
      paramString = getSDcardDir(paramContext);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/Android/data/");
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append("/files");
      return createDir(paramString, ((StringBuilder)localObject).toString());
    }
    localObject = getSDcardDir(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/Android/data/");
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("/files/");
    localStringBuilder.append(paramString);
    return createDir((File)localObject, localStringBuilder.toString());
  }
  
  public static File getSDcardDir(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = paramContext.getExternalFilesDir(null);
        if (paramContext != null) {
          continue;
        }
        paramContext = Environment.getExternalStorageDirectory();
        return paramContext;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      paramContext.printStackTrace();
      paramContext = new File("/mnt/sdcard");
      if (paramContext.exists()) {
        return paramContext;
      }
      paramContext = new File("/storage/sdcard0");
      if (paramContext.exists()) {
        return paramContext;
      }
      return null;
      return paramContext;
      paramContext = null;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.util.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */