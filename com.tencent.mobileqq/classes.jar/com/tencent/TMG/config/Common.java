package com.tencent.TMG.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Common
{
  public static final String AV_ENGINE_VERSION = "V2.9.0304.001";
  public static final String AV_SHARP_VERSION = "1.0";
  public static final String CONFIG_INFO = "ConfigInfo";
  public static final int EM_Device_Android = 101;
  public static final String FILE_NAME = "VideoConfigInfo";
  public static final String SHARP_CONFIG_PAYLOAD_FILE_NAME = "SharpConfigPayload";
  public static final String SHARP_CONFIG_TYPE_CLEAR = "0";
  public static final String SHARP_CONFIG_TYPE_PAYLOAD = "1";
  public static final String SHARP_CONFIG_TYPE_URL = "2";
  
  public static String getVersion(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return "1.0";
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.versionName.trim())))
        {
          paramContext = paramContext.versionName.trim();
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "1.0";
  }
  
  public static int intPow(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      j = 0;
      return j;
    }
    int j = 1;
    int i = paramInt2;
    paramInt2 = j;
    for (;;)
    {
      j = paramInt2;
      if (i <= 0) {
        break;
      }
      paramInt2 *= paramInt1;
      i -= 1;
    }
  }
  
  public static byte[] readFile(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      paramString = paramContext.openFileInput(paramString);
      localObject1 = localObject2;
      int i = paramString.available();
      if (i <= 0) {
        return null;
      }
      localObject1 = localObject2;
      paramContext = new byte[i];
      localObject1 = paramContext;
      paramString.read(paramContext);
      localObject1 = paramContext;
      paramString.close();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return localObject1;
  }
  
  public static void writeFile(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramContext = paramContext.openFileOutput(paramString, 0);
      paramContext.write(paramArrayOfByte);
      paramContext.close();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.config.Common
 * JD-Core Version:    0.7.0.1
 */