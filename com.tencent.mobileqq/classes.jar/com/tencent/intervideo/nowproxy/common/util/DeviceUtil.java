package com.tencent.intervideo.nowproxy.common.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.UUID;

public class DeviceUtil
{
  public static final String DEVICE_ID_FILE = "DEVICE_ID";
  public static String sDeviceId = "";
  
  public static String getDeviceId(Context paramContext)
  {
    if (!TextUtils.isEmpty(sDeviceId)) {
      return sDeviceId;
    }
    paramContext = new File(paramContext.getExternalFilesDir(null).getAbsolutePath() + "/now/", "DEVICE_ID");
    try
    {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.util.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */