package com.tencent.liteav.basic.module;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.File;

public class TXCKeyPointReportProxy
{
  public static void a() {}
  
  public static void a(int paramInt)
  {
    nativeTagKeyPointStart(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    nativeSetCpu(paramInt1, paramInt2);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    nativeSetLocalQuality(paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.getApplicationContext().getExternalFilesDir(null);
    if (paramContext == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getAbsolutePath());
    ((StringBuilder)localObject).append("/txrtmp/ssoreport.txt");
    paramContext = ((StringBuilder)localObject).toString();
    localObject = new File(paramContext);
    if (!((File)localObject).exists()) {
      try
      {
        if (!((File)localObject).mkdirs())
        {
          TXCLog.e("TXCKeyPointReportProxy", "can not create sso file path");
          return;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("create sso file exception:");
        localStringBuilder.append(localException.toString());
        TXCLog.e("TXCKeyPointReportProxy", localStringBuilder.toString());
      }
    }
    nativeInit(paramContext);
  }
  
  public static void a(TXCKeyPointReportProxy.a parama)
  {
    nativeSetDeviceInfo(parama.a, parama.b, parama.c, parama.d, parama.e, parama.f, parama.g, parama.h);
  }
  
  public static void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    nativesetRemoteQuality(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public static void b(int paramInt)
  {
    nativeSetErrorCode(paramInt);
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    nativeTagKeyPointEnd(paramInt1, paramInt2);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    nativeSetBasicInfo(paramInt1, paramInt2);
  }
  
  private static native void nativeInit(String paramString);
  
  private static native void nativeSendCacheReport();
  
  private static native void nativeSetBasicInfo(int paramInt1, int paramInt2);
  
  private static native void nativeSetCpu(int paramInt1, int paramInt2);
  
  private static native void nativeSetDeviceInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static native void nativeSetErrorCode(int paramInt);
  
  private static native void nativeSetLocalQuality(int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeTagKeyPointEnd(int paramInt1, int paramInt2);
  
  private static native void nativeTagKeyPointStart(int paramInt);
  
  private static native void nativesetRemoteQuality(String paramString, int paramInt1, long paramLong, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.module.TXCKeyPointReportProxy
 * JD-Core Version:    0.7.0.1
 */