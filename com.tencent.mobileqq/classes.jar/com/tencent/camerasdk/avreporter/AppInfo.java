package com.tencent.camerasdk.avreporter;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Process;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppInfo
{
  private static final String TAG = "MobileBase-AppInfo";
  private static final String UNKNOWN_INFO = "unknown";
  private static ActivityManager activityManager;
  
  private static String byte2Hex(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase();
  }
  
  @SuppressLint({"PackageManagerGetSignatures"})
  public static String getApkCertificate(Context paramContext)
  {
    Object localObject = getPackageName(paramContext);
    if (localObject == null) {
      return null;
    }
    paramContext = paramContext.getPackageManager();
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageInfo((String)localObject, 64);
      if (paramContext == null) {
        return null;
      }
      localObject = paramContext.signatures;
      if (localObject != null)
      {
        if (localObject.length == 0) {
          return null;
        }
        return getSignature(paramContext.signatures[0].toByteArray());
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static String getAppName(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = paramContext.getApplicationInfo();
      if ((localPackageManager != null) && (paramContext != null))
      {
        paramContext = localPackageManager.getApplicationLabel(paramContext);
        if (paramContext != null)
        {
          paramContext = paramContext.toString();
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      LogUtils.e("MobileBase-AppInfo", "getAppName error", paramContext);
    }
    return null;
  }
  
  public static String getCurProcessName(Context paramContext)
  {
    if (paramContext != null)
    {
      int i = Process.myPid();
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        try
        {
          paramContext = paramContext.getRunningAppProcesses();
        }
        catch (Throwable paramContext)
        {
          LogUtils.e("MobileBase-AppInfo", "Exception occurred when getting process name.", paramContext);
          paramContext = null;
        }
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.pid == i)) {
              return localRunningAppProcessInfo.processName;
            }
          }
        }
      }
    }
    return null;
  }
  
  public static Map<String, String> getManifestMetadata(Context paramContext, Set<String> paramSet)
  {
    if (paramContext == null) {
      return null;
    }
    localHashMap = new HashMap();
    try
    {
      Object localObject1 = paramContext.getPackageManager();
      if (localObject1 == null) {
        return null;
      }
      paramContext = ((PackageManager)localObject1).getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext.metaData != null)
      {
        paramSet = paramSet.iterator();
        while (paramSet.hasNext())
        {
          localObject1 = (String)paramSet.next();
          Object localObject2 = paramContext.metaData.get((String)localObject1);
          if (localObject2 != null) {
            localHashMap.put(localObject1, localObject2.toString());
          }
        }
      }
      return localHashMap;
    }
    catch (Throwable paramContext)
    {
      LogUtils.e("MobileBase-AppInfo", "getManifestMetaDatas error", paramContext);
    }
  }
  
  public static PackageInfo getPackageInfo(Context paramContext)
  {
    try
    {
      String str = getPackageName(paramContext);
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        paramContext = paramContext.getPackageInfo(str, 0);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      LogUtils.e("MobileBase-AppInfo", "getPackageInfo error", paramContext);
    }
    return null;
  }
  
  public static String getPackageName(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageName();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      LogUtils.e("MobileBase-AppInfo", "getPackageName error", paramContext);
    }
    return "fail";
  }
  
  /* Error */
  public static String getProcessName(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_0
    //   7: new 24	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   14: astore 5
    //   16: aload_3
    //   17: astore_0
    //   18: aload 5
    //   20: ldc 199
    //   22: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: astore_0
    //   28: aload 5
    //   30: iload_1
    //   31: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: astore_0
    //   37: aload 5
    //   39: ldc 204
    //   41: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: astore_0
    //   47: new 206	java/io/FileReader
    //   50: dup
    //   51: aload 5
    //   53: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 209	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   59: astore_3
    //   60: sipush 512
    //   63: newarray char
    //   65: astore_0
    //   66: aload_3
    //   67: aload_0
    //   68: invokevirtual 213	java/io/FileReader:read	([C)I
    //   71: pop
    //   72: iconst_0
    //   73: istore_2
    //   74: iload_2
    //   75: aload_0
    //   76: arraylength
    //   77: if_icmpge +12 -> 89
    //   80: aload_0
    //   81: iload_2
    //   82: caload
    //   83: ifne +109 -> 192
    //   86: goto +3 -> 89
    //   89: new 33	java/lang/String
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 216	java/lang/String:<init>	([C)V
    //   97: iconst_0
    //   98: iload_2
    //   99: invokevirtual 220	java/lang/String:substring	(II)Ljava/lang/String;
    //   102: astore_0
    //   103: aload_3
    //   104: invokevirtual 223	java/io/FileReader:close	()V
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: goto +55 -> 165
    //   113: astore 4
    //   115: goto +20 -> 135
    //   118: astore 4
    //   120: aload_0
    //   121: astore_3
    //   122: aload 4
    //   124: astore_0
    //   125: goto +40 -> 165
    //   128: astore_0
    //   129: aload 4
    //   131: astore_3
    //   132: aload_0
    //   133: astore 4
    //   135: aload_3
    //   136: astore_0
    //   137: ldc 8
    //   139: ldc 225
    //   141: aload 4
    //   143: invokestatic 110	com/tencent/camerasdk/avreporter/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: aload_3
    //   147: astore_0
    //   148: iload_1
    //   149: invokestatic 228	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   152: astore 4
    //   154: aload_3
    //   155: ifnull +7 -> 162
    //   158: aload_3
    //   159: invokevirtual 223	java/io/FileReader:close	()V
    //   162: aload 4
    //   164: areturn
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 223	java/io/FileReader:close	()V
    //   173: goto +5 -> 178
    //   176: aload_0
    //   177: athrow
    //   178: goto -2 -> 176
    //   181: astore_3
    //   182: aload_0
    //   183: areturn
    //   184: astore_0
    //   185: aload 4
    //   187: areturn
    //   188: astore_3
    //   189: goto -16 -> 173
    //   192: iload_2
    //   193: iconst_1
    //   194: iadd
    //   195: istore_2
    //   196: goto -122 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramContext	Context
    //   0	199	1	paramInt	int
    //   73	123	2	i	int
    //   4	166	3	localObject1	Object
    //   181	1	3	localThrowable1	Throwable
    //   188	1	3	localThrowable2	Throwable
    //   1	1	4	localObject2	Object
    //   113	1	4	localThrowable3	Throwable
    //   118	12	4	localObject3	Object
    //   133	53	4	localObject4	Object
    //   14	38	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   60	72	109	finally
    //   74	80	109	finally
    //   89	103	109	finally
    //   60	72	113	java/lang/Throwable
    //   74	80	113	java/lang/Throwable
    //   89	103	113	java/lang/Throwable
    //   7	16	118	finally
    //   18	26	118	finally
    //   28	35	118	finally
    //   37	45	118	finally
    //   47	60	118	finally
    //   137	146	118	finally
    //   148	154	118	finally
    //   7	16	128	java/lang/Throwable
    //   18	26	128	java/lang/Throwable
    //   28	35	128	java/lang/Throwable
    //   37	45	128	java/lang/Throwable
    //   47	60	128	java/lang/Throwable
    //   103	107	181	java/lang/Throwable
    //   158	162	184	java/lang/Throwable
    //   169	173	188	java/lang/Throwable
  }
  
  public static String getSignature(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      try
      {
        Object localObject1 = CertificateFactory.getInstance("X.509");
        if (localObject1 == null) {
          return null;
        }
        paramArrayOfByte = (X509Certificate)((CertificateFactory)localObject1).generateCertificate(new ByteArrayInputStream(paramArrayOfByte));
        if (paramArrayOfByte == null) {
          return null;
        }
        localStringBuilder.append("Issuer|");
        localObject1 = paramArrayOfByte.getIssuerDN();
        if (localObject1 != null) {
          localStringBuilder.append(((Principal)localObject1).toString());
        } else {
          localStringBuilder.append("unknown");
        }
        localStringBuilder.append("\n");
        localStringBuilder.append("SerialNumber|");
        Object localObject2 = paramArrayOfByte.getSerialNumber();
        if (localObject1 != null) {
          localStringBuilder.append(((BigInteger)localObject2).toString(16));
        } else {
          localStringBuilder.append("unknown");
        }
        localStringBuilder.append("\n");
        localStringBuilder.append("NotBefore|");
        localObject2 = paramArrayOfByte.getNotBefore();
        if (localObject1 != null) {
          localStringBuilder.append(((Date)localObject2).toString());
        } else {
          localStringBuilder.append("unknown");
        }
        localStringBuilder.append("\n");
        localStringBuilder.append("NotAfter|");
        localObject2 = paramArrayOfByte.getNotAfter();
        if (localObject1 != null) {
          localStringBuilder.append(((Date)localObject2).toString());
        } else {
          localStringBuilder.append("unknown");
        }
        localStringBuilder.append("\n");
        localStringBuilder.append("SHA1|");
        localObject1 = byte2Hex(MessageDigest.getInstance("SHA1").digest(paramArrayOfByte.getEncoded()));
        if (((String)localObject1).length() > 0) {
          localStringBuilder.append((String)localObject1);
        } else {
          localStringBuilder.append("unknown");
        }
        localStringBuilder.append("\n");
        localStringBuilder.append("MD5|");
        paramArrayOfByte = byte2Hex(MessageDigest.getInstance("MD5").digest(paramArrayOfByte.getEncoded()));
        if (paramArrayOfByte.length() > 0) {
          localStringBuilder.append(paramArrayOfByte);
        } else {
          localStringBuilder.append("unknown");
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        LogUtils.e("MobileBase-AppInfo", "getSignature error", paramArrayOfByte);
      }
      catch (CertificateException paramArrayOfByte)
      {
        LogUtils.e("MobileBase-AppInfo", "getSignature CertificateException error", paramArrayOfByte);
      }
    }
    if (localStringBuilder.length() == 0) {
      return "unknown";
    }
    return localStringBuilder.toString();
  }
  
  public static int getVersionCode(Context paramContext)
  {
    paramContext = getPackageInfo(paramContext);
    if (paramContext == null) {
      return -1;
    }
    return paramContext.versionCode;
  }
  
  public static String getVersionName(Context paramContext)
  {
    paramContext = getPackageInfo(paramContext);
    if (paramContext == null) {
      return "CantGetVersionName";
    }
    return paramContext.versionName;
  }
  
  public static boolean isContainPermission(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null))
    {
      if (paramString.trim().length() <= 0) {
        return false;
      }
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null) {
          return false;
        }
        paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
        if (paramContext != null)
        {
          int j = paramContext.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = paramString.equals(paramContext[i]);
            if (bool) {
              return true;
            }
            i += 1;
          }
        }
        return false;
      }
      catch (Throwable paramContext)
      {
        LogUtils.e("MobileBase-AppInfo", "isContainPermission error", paramContext);
      }
    }
  }
  
  public static boolean isLowMemory(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (activityManager == null) {
      activityManager = (ActivityManager)paramContext.getSystemService("activity");
    }
    try
    {
      paramContext = new ActivityManager.MemoryInfo();
      activityManager.getMemoryInfo(paramContext);
      LogUtils.d("MobileBase-AppInfo", "Memory is low.");
      boolean bool = paramContext.lowMemory;
      return bool;
    }
    catch (Throwable paramContext)
    {
      LogUtils.e("MobileBase-AppInfo", "isLowMemory error", paramContext);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.camerasdk.avreporter.AppInfo
 * JD-Core Version:    0.7.0.1
 */