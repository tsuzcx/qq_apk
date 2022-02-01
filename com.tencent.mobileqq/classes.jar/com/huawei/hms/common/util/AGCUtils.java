package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;

public class AGCUtils
{
  public static String a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
      return "";
    }
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.get("com.huawei.hms.client.appid");
        if (paramContext != null)
        {
          paramContext = String.valueOf(paramContext);
          if (!paramContext.startsWith("appid=")) {
            return paramContext;
          }
          return paramContext.substring(6);
        }
      }
      HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
      return "";
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label90:
      break label90;
    }
    HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
    return "";
    return paramContext;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 90	com/huawei/agconnect/config/AGConnectServicesConfig:fromContext	(Landroid/content/Context;)Lcom/huawei/agconnect/config/AGConnectServicesConfig;
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 94	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   17: invokevirtual 100	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   20: ldc 102
    //   22: invokevirtual 108	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore_0
    //   26: aload_0
    //   27: astore_2
    //   28: aload_0
    //   29: astore_3
    //   30: aload_0
    //   31: astore 4
    //   33: aload 5
    //   35: aload_0
    //   36: invokevirtual 112	com/huawei/agconnect/config/AGConnectServicesConfig:overlayWith	(Ljava/io/InputStream;)V
    //   39: aload_0
    //   40: astore_2
    //   41: aload_0
    //   42: astore_3
    //   43: aload_0
    //   44: astore 4
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 116	com/huawei/agconnect/config/AGConnectServicesConfig:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 5
    //   54: aload 5
    //   56: astore_2
    //   57: goto +142 -> 199
    //   60: astore_0
    //   61: goto +191 -> 252
    //   64: astore_0
    //   65: aload_3
    //   66: astore_2
    //   67: new 118	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   74: astore 4
    //   76: aload_3
    //   77: astore_2
    //   78: aload 4
    //   80: ldc 121
    //   82: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: astore_2
    //   88: aload 4
    //   90: aload_1
    //   91: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_3
    //   96: astore_2
    //   97: aload 4
    //   99: ldc 127
    //   101: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_3
    //   106: astore_2
    //   107: aload 4
    //   109: aload_0
    //   110: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_3
    //   115: astore_2
    //   116: ldc 21
    //   118: aload 4
    //   120: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 29	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: goto +68 -> 194
    //   129: astore_0
    //   130: aload 4
    //   132: astore_2
    //   133: new 118	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   140: astore_3
    //   141: aload 4
    //   143: astore_2
    //   144: aload_3
    //   145: ldc 121
    //   147: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 4
    //   153: astore_2
    //   154: aload_3
    //   155: aload_1
    //   156: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 4
    //   162: astore_2
    //   163: aload_3
    //   164: ldc 135
    //   166: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 4
    //   172: astore_2
    //   173: aload_3
    //   174: aload_0
    //   175: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 4
    //   181: astore_2
    //   182: ldc 21
    //   184: aload_3
    //   185: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 29	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 4
    //   193: astore_3
    //   194: ldc 31
    //   196: astore_2
    //   197: aload_3
    //   198: astore_0
    //   199: aload_0
    //   200: invokestatic 140	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   203: aload_2
    //   204: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +5 -> 212
    //   210: aload_2
    //   211: areturn
    //   212: new 118	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   219: astore_0
    //   220: aload_0
    //   221: ldc 148
    //   223: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_0
    //   228: aload_1
    //   229: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_0
    //   234: ldc 150
    //   236: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: ldc 21
    //   242: aload_0
    //   243: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 29	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: ldc 31
    //   251: areturn
    //   252: aload_2
    //   253: invokestatic 140	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   256: aload_0
    //   257: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramContext	Context
    //   0	258	1	paramString	String
    //   12	241	2	localObject1	Object
    //   7	191	3	localObject2	Object
    //   9	183	4	localObject3	Object
    //   4	51	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   13	26	60	finally
    //   33	39	60	finally
    //   46	54	60	finally
    //   67	76	60	finally
    //   78	86	60	finally
    //   88	95	60	finally
    //   97	105	60	finally
    //   107	114	60	finally
    //   116	126	60	finally
    //   133	141	60	finally
    //   144	151	60	finally
    //   154	160	60	finally
    //   163	170	60	finally
    //   173	179	60	finally
    //   182	191	60	finally
    //   13	26	64	java/lang/NullPointerException
    //   33	39	64	java/lang/NullPointerException
    //   46	54	64	java/lang/NullPointerException
    //   13	26	129	java/io/IOException
    //   33	39	129	java/io/IOException
    //   46	54	129	java/io/IOException
  }
  
  public static String b(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
      return "";
    }
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.get("com.huawei.hms.client.cpid");
        if (paramContext != null)
        {
          paramContext = String.valueOf(paramContext);
          if (!paramContext.startsWith("cpid=")) {
            return paramContext;
          }
          return paramContext.substring(5);
        }
      }
      HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
      return "";
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label89:
      break label89;
    }
    HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
    return "";
    return paramContext;
  }
  
  public static boolean c(Context paramContext)
  {
    return paramContext.getPackageName().equals(HMSPackageManager.getInstance(paramContext).getHMSPackageName());
  }
  
  public static String getAppId(Context paramContext)
  {
    if (c(paramContext)) {
      return a(paramContext, "client/app_id");
    }
    Object localObject = null;
    try
    {
      String str = AGConnectServicesConfig.fromContext(paramContext).getString("client/app_id");
      localObject = str;
    }
    catch (NullPointerException localNullPointerException)
    {
      label31:
      break label31;
    }
    HMSLog.e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    localObject = a(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    return a(paramContext, "client/app_id");
  }
  
  public static String getCpId(Context paramContext)
  {
    if (c(paramContext)) {
      return a(paramContext, "client/cp_id");
    }
    Object localObject = null;
    try
    {
      String str = AGConnectServicesConfig.fromContext(paramContext).getString("client/cp_id");
      localObject = str;
    }
    catch (NullPointerException localNullPointerException)
    {
      label31:
      break label31;
    }
    HMSLog.e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    localObject = b(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    return a(paramContext, "client/cp_id");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.util.AGCUtils
 * JD-Core Version:    0.7.0.1
 */