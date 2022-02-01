package com.tencent.ilink.dev.ota;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class IlinkOtaInterface
{
  private static String a;
  
  private static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.open(paramString1);
      new File(paramString2).createNewFile();
      paramString1 = new FileOutputStream(paramString2);
      paramString2 = new byte[1024];
      for (;;)
      {
        int i = paramContext.read(paramString2);
        if (i == -1) {
          break;
        }
        paramString1.write(paramString2, 0, i);
      }
      paramContext.close();
      paramString1.flush();
      paramString1.close();
      return 1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  private static String a(Context paramContext)
  {
    if (paramContext != null)
    {
      if (!a("cacert.pem", paramContext)) {
        return null;
      }
      String str = paramContext.getApplicationInfo().dataDir;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append("cacert.pem");
      str = ((StringBuilder)localObject).toString();
      localObject = new File(str);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      if (a(paramContext, "cacert.pem", str) == 1) {
        return str;
      }
    }
    return null;
  }
  
  private static boolean a(String paramString, Context paramContext)
  {
    try
    {
      boolean bool = Arrays.asList(paramContext.getResources().getAssets().list("")).contains(paramString);
      return bool;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static native int cancelCheckUpdate(String paramString);
  
  public static native int checkUpdate(long paramLong1, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4);
  
  public static int init(Context paramContext)
  {
    a = a(paramContext);
    paramContext = a;
    if (paramContext == null) {
      return -1;
    }
    init(paramContext);
    return 0;
  }
  
  static native void init(String paramString);
  
  public static void setCallBack(IlinkOtaCallback paramIlinkOtaCallback)
  {
    IlinkOtaCallbackInterface.callback = paramIlinkOtaCallback;
  }
  
  public static native int startDownload(String paramString1, String paramString2, int paramInt, String paramString3);
  
  public static native int stopAllDownloadTask();
  
  public static native int stopDownloadTask(String paramString);
  
  public static native void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.dev.ota.IlinkOtaInterface
 * JD-Core Version:    0.7.0.1
 */