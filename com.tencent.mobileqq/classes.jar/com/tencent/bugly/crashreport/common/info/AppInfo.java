package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppInfo
{
  private static ActivityManager a;
  
  static
  {
    "@buglyAllChannel@".split(",");
    "@buglyAllChannelPriority@".split(",");
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: new 29	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 31
    //   13: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: astore 4
    //   18: aload_3
    //   19: astore_2
    //   20: aload 4
    //   22: iload_0
    //   23: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: astore_2
    //   29: aload 4
    //   31: ldc 40
    //   33: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: astore_2
    //   39: new 45	java/io/FileReader
    //   42: dup
    //   43: aload 4
    //   45: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 50	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   51: astore_3
    //   52: sipush 512
    //   55: newarray char
    //   57: astore_2
    //   58: aload_3
    //   59: aload_2
    //   60: invokevirtual 54	java/io/FileReader:read	([C)I
    //   63: pop
    //   64: iconst_0
    //   65: istore_1
    //   66: iload_1
    //   67: aload_2
    //   68: arraylength
    //   69: if_icmpge +16 -> 85
    //   72: aload_2
    //   73: iload_1
    //   74: caload
    //   75: ifeq +10 -> 85
    //   78: iload_1
    //   79: iconst_1
    //   80: iadd
    //   81: istore_1
    //   82: goto -16 -> 66
    //   85: new 14	java/lang/String
    //   88: dup
    //   89: aload_2
    //   90: invokespecial 57	java/lang/String:<init>	([C)V
    //   93: iconst_0
    //   94: iload_1
    //   95: invokevirtual 61	java/lang/String:substring	(II)Ljava/lang/String;
    //   98: astore_2
    //   99: aload_3
    //   100: invokevirtual 64	java/io/FileReader:close	()V
    //   103: aload_2
    //   104: areturn
    //   105: astore 4
    //   107: aload_3
    //   108: astore_2
    //   109: aload 4
    //   111: astore_3
    //   112: goto +55 -> 167
    //   115: astore_2
    //   116: aload_2
    //   117: astore 4
    //   119: goto +12 -> 131
    //   122: astore_3
    //   123: goto +44 -> 167
    //   126: astore 4
    //   128: aload 5
    //   130: astore_3
    //   131: aload_3
    //   132: astore_2
    //   133: aload 4
    //   135: invokestatic 69	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   138: ifne +10 -> 148
    //   141: aload_3
    //   142: astore_2
    //   143: aload 4
    //   145: invokevirtual 72	java/lang/Throwable:printStackTrace	()V
    //   148: aload_3
    //   149: astore_2
    //   150: iload_0
    //   151: invokestatic 75	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   154: astore 4
    //   156: aload_3
    //   157: ifnull +7 -> 164
    //   160: aload_3
    //   161: invokevirtual 64	java/io/FileReader:close	()V
    //   164: aload 4
    //   166: areturn
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 64	java/io/FileReader:close	()V
    //   175: goto +5 -> 180
    //   178: aload_3
    //   179: athrow
    //   180: goto -2 -> 178
    //   183: astore_3
    //   184: aload_2
    //   185: areturn
    //   186: astore_2
    //   187: aload 4
    //   189: areturn
    //   190: astore_2
    //   191: goto -16 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramInt	int
    //   65	30	1	i	int
    //   6	103	2	localObject1	Object
    //   115	2	2	localThrowable1	Throwable
    //   132	53	2	localObject2	Object
    //   186	1	2	localThrowable2	Throwable
    //   190	1	2	localThrowable3	Throwable
    //   4	108	3	localObject3	Object
    //   122	1	3	localObject4	Object
    //   130	49	3	localObject5	Object
    //   183	1	3	localThrowable4	Throwable
    //   16	28	4	localStringBuilder	StringBuilder
    //   105	5	4	localObject6	Object
    //   117	1	4	localThrowable5	Throwable
    //   126	18	4	localThrowable6	Throwable
    //   154	34	4	str	String
    //   1	128	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   52	64	105	finally
    //   66	72	105	finally
    //   85	99	105	finally
    //   52	64	115	java/lang/Throwable
    //   66	72	115	java/lang/Throwable
    //   85	99	115	java/lang/Throwable
    //   7	18	122	finally
    //   20	27	122	finally
    //   29	37	122	finally
    //   39	52	122	finally
    //   133	141	122	finally
    //   143	148	122	finally
    //   150	156	122	finally
    //   7	18	126	java/lang/Throwable
    //   20	27	126	java/lang/Throwable
    //   29	37	126	java/lang/Throwable
    //   39	52	126	java/lang/Throwable
    //   99	103	183	java/lang/Throwable
    //   160	164	186	java/lang/Throwable
    //   171	175	190	java/lang/Throwable
  }
  
  public static String a(Context paramContext)
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
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return "fail";
  }
  
  private static String a(byte[] paramArrayOfByte)
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
        localObject1 = z.a(MessageDigest.getInstance("SHA1").digest(paramArrayOfByte.getEncoded()));
        if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
          localStringBuilder.append(((String)localObject1).toString());
        } else {
          localStringBuilder.append("unknown");
        }
        localStringBuilder.append("\n");
        localStringBuilder.append("MD5|");
        paramArrayOfByte = z.a(MessageDigest.getInstance("MD5").digest(paramArrayOfByte.getEncoded()));
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length() > 0)) {
          localStringBuilder.append(paramArrayOfByte.toString());
        } else {
          localStringBuilder.append("unknown");
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!x.a(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
      catch (CertificateException paramArrayOfByte)
      {
        if (!x.a(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
    if (localStringBuilder.length() == 0) {
      return "unknown";
    }
    return localStringBuilder.toString();
  }
  
  public static List<String> a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    try
    {
      paramMap = (String)paramMap.get("BUGLY_DISABLE");
      if (paramMap != null)
      {
        if (paramMap.length() == 0) {
          return null;
        }
        paramMap = paramMap.split(",");
        int i = 0;
        while (i < paramMap.length)
        {
          paramMap[i] = paramMap[i].trim();
          i += 1;
        }
        paramMap = Arrays.asList(paramMap);
        return paramMap;
      }
      return null;
    }
    catch (Throwable paramMap)
    {
      if (!x.a(paramMap)) {
        paramMap.printStackTrace();
      }
    }
    return null;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null))
    {
      if (paramString.trim().length() <= 0) {
        return false;
      }
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
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
        if (!x.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  public static PackageInfo b(Context paramContext)
  {
    try
    {
      String str = a(paramContext);
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static String c(Context paramContext)
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
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static Map<String, String> d(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      return null;
    }
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      paramContext = localObject;
      if (localApplicationInfo.metaData != null)
      {
        paramContext = new HashMap();
        localObject = localApplicationInfo.metaData.get("BUGLY_DISABLE");
        if (localObject != null) {
          paramContext.put("BUGLY_DISABLE", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_APPID");
        if (localObject != null) {
          paramContext.put("BUGLY_APPID", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_APP_CHANNEL");
        if (localObject != null) {
          paramContext.put("BUGLY_APP_CHANNEL", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_APP_VERSION");
        if (localObject != null) {
          paramContext.put("BUGLY_APP_VERSION", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
        if (localObject != null) {
          paramContext.put("BUGLY_ENABLE_DEBUG", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("com.tencent.rdm.uuid");
        if (localObject != null) {
          paramContext.put("com.tencent.rdm.uuid", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
        if (localObject != null) {
          paramContext.put("BUGLY_APP_BUILD_NO", localObject.toString());
        }
        localObject = localApplicationInfo.metaData.get("BUGLY_AREA");
        if (localObject != null) {
          paramContext.put("BUGLY_AREA", localObject.toString());
        }
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static String e(Context paramContext)
  {
    Object localObject = a(paramContext);
    if (localObject == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 64);
      if (paramContext == null) {
        return null;
      }
      localObject = paramContext.signatures;
      if (localObject != null)
      {
        if (localObject.length == 0) {
          return null;
        }
        return a(paramContext.signatures[0].toByteArray());
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static boolean f(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (a == null) {
      a = (ActivityManager)paramContext.getSystemService("activity");
    }
    try
    {
      paramContext = new ActivityManager.MemoryInfo();
      a.getMemoryInfo(paramContext);
      if (paramContext.lowMemory)
      {
        x.c("Memory is low.", new Object[0]);
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  public static String g(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = h(paramContext);
    if (!z.a(str)) {
      return str;
    }
    return i(paramContext);
  }
  
  /* Error */
  private static String h(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 314
    //   3: astore 6
    //   5: ldc_w 329
    //   8: aload_0
    //   9: invokestatic 332	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   12: astore_3
    //   13: aconst_null
    //   14: astore 9
    //   16: aconst_null
    //   17: astore 10
    //   19: aconst_null
    //   20: astore 7
    //   22: aload 9
    //   24: astore 5
    //   26: aload 6
    //   28: astore_2
    //   29: aload 10
    //   31: astore 4
    //   33: aload_3
    //   34: ldc_w 334
    //   37: ldc_w 314
    //   40: invokeinterface 340 3 0
    //   45: astore_3
    //   46: aload_3
    //   47: astore 8
    //   49: aload 9
    //   51: astore 5
    //   53: aload 6
    //   55: astore_2
    //   56: aload 10
    //   58: astore 4
    //   60: aload_3
    //   61: invokestatic 320	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;)Z
    //   64: ifeq +8 -> 72
    //   67: ldc_w 342
    //   70: astore 8
    //   72: aload 9
    //   74: astore 5
    //   76: aload 6
    //   78: astore_2
    //   79: aload 10
    //   81: astore 4
    //   83: new 29	java/lang/StringBuilder
    //   86: dup
    //   87: ldc_w 344
    //   90: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload 9
    //   96: astore 5
    //   98: aload 6
    //   100: astore_2
    //   101: aload 10
    //   103: astore 4
    //   105: aload_3
    //   106: aload 8
    //   108: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 9
    //   114: astore 5
    //   116: aload 6
    //   118: astore_2
    //   119: aload 10
    //   121: astore 4
    //   123: aload_3
    //   124: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: iconst_0
    //   128: anewarray 4	java/lang/Object
    //   131: invokestatic 346	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   134: pop
    //   135: aload 6
    //   137: astore_3
    //   138: aload 9
    //   140: astore 5
    //   142: aload 6
    //   144: astore_2
    //   145: aload 10
    //   147: astore 4
    //   149: aload 8
    //   151: ldc_w 314
    //   154: invokevirtual 216	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifne +178 -> 335
    //   160: aload 9
    //   162: astore 5
    //   164: aload 6
    //   166: astore_2
    //   167: aload 10
    //   169: astore 4
    //   171: aload_0
    //   172: invokevirtual 350	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   175: aload 8
    //   177: invokevirtual 356	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   180: astore_0
    //   181: aload_0
    //   182: astore 5
    //   184: aload 6
    //   186: astore_2
    //   187: aload_0
    //   188: astore 4
    //   190: new 358	java/util/Properties
    //   193: dup
    //   194: invokespecial 359	java/util/Properties:<init>	()V
    //   197: astore_3
    //   198: aload_0
    //   199: astore 5
    //   201: aload 6
    //   203: astore_2
    //   204: aload_0
    //   205: astore 4
    //   207: aload_3
    //   208: aload_0
    //   209: invokevirtual 363	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   212: aload_0
    //   213: astore 5
    //   215: aload 6
    //   217: astore_2
    //   218: aload_0
    //   219: astore 4
    //   221: aload_3
    //   222: ldc_w 365
    //   225: ldc_w 314
    //   228: invokevirtual 368	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   231: astore 6
    //   233: aload_0
    //   234: astore 5
    //   236: aload 6
    //   238: astore_2
    //   239: aload_0
    //   240: astore 4
    //   242: new 29	java/lang/StringBuilder
    //   245: dup
    //   246: ldc_w 370
    //   249: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   252: astore_3
    //   253: aload_0
    //   254: astore 5
    //   256: aload 6
    //   258: astore_2
    //   259: aload_0
    //   260: astore 4
    //   262: aload_3
    //   263: aload 6
    //   265: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_0
    //   270: astore 5
    //   272: aload 6
    //   274: astore_2
    //   275: aload_0
    //   276: astore 4
    //   278: aload_3
    //   279: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: iconst_0
    //   283: anewarray 4	java/lang/Object
    //   286: invokestatic 346	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   289: pop
    //   290: aload_0
    //   291: astore 5
    //   293: aload 6
    //   295: astore_2
    //   296: aload_0
    //   297: astore 4
    //   299: aload 6
    //   301: invokestatic 320	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;)Z
    //   304: istore_1
    //   305: aload 6
    //   307: astore_3
    //   308: aload_0
    //   309: astore 7
    //   311: iload_1
    //   312: ifne +23 -> 335
    //   315: aload_0
    //   316: ifnull +16 -> 332
    //   319: aload_0
    //   320: invokevirtual 373	java/io/InputStream:close	()V
    //   323: aload 6
    //   325: areturn
    //   326: astore_0
    //   327: aload_0
    //   328: invokestatic 69	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   331: pop
    //   332: aload 6
    //   334: areturn
    //   335: aload_3
    //   336: astore_0
    //   337: aload 7
    //   339: ifnull +55 -> 394
    //   342: aload_3
    //   343: astore_0
    //   344: aload 7
    //   346: invokevirtual 373	java/io/InputStream:close	()V
    //   349: aload_3
    //   350: areturn
    //   351: astore_2
    //   352: aload_2
    //   353: invokestatic 69	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   356: pop
    //   357: aload_0
    //   358: areturn
    //   359: astore_0
    //   360: goto +36 -> 396
    //   363: aload 4
    //   365: astore 5
    //   367: ldc_w 375
    //   370: iconst_0
    //   371: anewarray 4	java/lang/Object
    //   374: invokestatic 377	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   377: pop
    //   378: aload_2
    //   379: astore_0
    //   380: aload 4
    //   382: ifnull +12 -> 394
    //   385: aload_2
    //   386: astore_0
    //   387: aload 4
    //   389: invokevirtual 373	java/io/InputStream:close	()V
    //   392: aload_2
    //   393: astore_0
    //   394: aload_0
    //   395: areturn
    //   396: aload 5
    //   398: ifnull +17 -> 415
    //   401: aload 5
    //   403: invokevirtual 373	java/io/InputStream:close	()V
    //   406: goto +9 -> 415
    //   409: astore_2
    //   410: aload_2
    //   411: invokestatic 69	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   414: pop
    //   415: aload_0
    //   416: athrow
    //   417: astore_0
    //   418: goto -55 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	paramContext	Context
    //   304	8	1	bool	boolean
    //   28	268	2	str1	String
    //   351	42	2	localIOException1	java.io.IOException
    //   409	2	2	localIOException2	java.io.IOException
    //   12	338	3	localObject1	Object
    //   31	357	4	localObject2	Object
    //   24	378	5	localObject3	Object
    //   3	330	6	str2	String
    //   20	325	7	localContext	Context
    //   47	129	8	localObject4	Object
    //   14	147	9	localObject5	Object
    //   17	151	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   319	323	326	java/io/IOException
    //   344	349	351	java/io/IOException
    //   387	392	351	java/io/IOException
    //   33	46	359	finally
    //   60	67	359	finally
    //   83	94	359	finally
    //   105	112	359	finally
    //   123	135	359	finally
    //   149	160	359	finally
    //   171	181	359	finally
    //   190	198	359	finally
    //   207	212	359	finally
    //   221	233	359	finally
    //   242	253	359	finally
    //   262	269	359	finally
    //   278	290	359	finally
    //   299	305	359	finally
    //   367	378	359	finally
    //   401	406	409	java/io/IOException
    //   33	46	417	java/lang/Exception
    //   60	67	417	java/lang/Exception
    //   83	94	417	java/lang/Exception
    //   105	112	417	java/lang/Exception
    //   123	135	417	java/lang/Exception
    //   149	160	417	java/lang/Exception
    //   171	181	417	java/lang/Exception
    //   190	198	417	java/lang/Exception
    //   207	212	417	java/lang/Exception
    //   221	233	417	java/lang/Exception
    //   242	253	417	java/lang/Exception
    //   262	269	417	java/lang/Exception
    //   278	290	417	java/lang/Exception
    //   299	305	417	java/lang/Exception
  }
  
  private static String i(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
      if (paramContext == null) {
        break label46;
      }
      paramContext = paramContext.toString();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label35:
      label46:
      break label35;
    }
    x.d("[AppInfo] Failed to read beacon channel from manifest.", new Object[0]);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.AppInfo
 * JD-Core Version:    0.7.0.1
 */