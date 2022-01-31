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
    //   0: iconst_0
    //   1: istore_1
    //   2: new 29	java/io/FileReader
    //   5: dup
    //   6: new 31	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 33
    //   12: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: iload_0
    //   16: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc 42
    //   21: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokespecial 50	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   30: astore_3
    //   31: aload_3
    //   32: astore_2
    //   33: sipush 512
    //   36: newarray char
    //   38: astore 4
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: aload 4
    //   45: invokevirtual 54	java/io/FileReader:read	([C)I
    //   48: pop
    //   49: aload_3
    //   50: astore_2
    //   51: iload_1
    //   52: aload 4
    //   54: arraylength
    //   55: if_icmpge +17 -> 72
    //   58: aload 4
    //   60: iload_1
    //   61: caload
    //   62: ifeq +10 -> 72
    //   65: iload_1
    //   66: iconst_1
    //   67: iadd
    //   68: istore_1
    //   69: goto -20 -> 49
    //   72: aload_3
    //   73: astore_2
    //   74: new 14	java/lang/String
    //   77: dup
    //   78: aload 4
    //   80: invokespecial 57	java/lang/String:<init>	([C)V
    //   83: iconst_0
    //   84: iload_1
    //   85: invokevirtual 61	java/lang/String:substring	(II)Ljava/lang/String;
    //   88: astore 4
    //   90: aload 4
    //   92: astore_2
    //   93: aload_3
    //   94: invokevirtual 64	java/io/FileReader:close	()V
    //   97: aload_2
    //   98: areturn
    //   99: astore 4
    //   101: aconst_null
    //   102: astore_3
    //   103: aload_3
    //   104: astore_2
    //   105: aload 4
    //   107: invokestatic 69	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   110: ifne +10 -> 120
    //   113: aload_3
    //   114: astore_2
    //   115: aload 4
    //   117: invokevirtual 72	java/lang/Throwable:printStackTrace	()V
    //   120: iload_0
    //   121: invokestatic 75	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   124: astore 4
    //   126: aload 4
    //   128: astore_2
    //   129: aload_3
    //   130: ifnull -33 -> 97
    //   133: aload_3
    //   134: invokevirtual 64	java/io/FileReader:close	()V
    //   137: aload 4
    //   139: areturn
    //   140: astore_2
    //   141: aload 4
    //   143: areturn
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: aload_2
    //   148: ifnull +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 64	java/io/FileReader:close	()V
    //   155: aload_3
    //   156: athrow
    //   157: astore_3
    //   158: aload_2
    //   159: areturn
    //   160: astore_2
    //   161: goto -6 -> 155
    //   164: astore_3
    //   165: goto -18 -> 147
    //   168: astore 4
    //   170: goto -67 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramInt	int
    //   1	84	1	i	int
    //   32	97	2	localObject1	Object
    //   140	1	2	localThrowable1	Throwable
    //   146	13	2	str1	String
    //   160	1	2	localThrowable2	Throwable
    //   30	104	3	localFileReader	java.io.FileReader
    //   144	12	3	localObject2	Object
    //   157	1	3	localThrowable3	Throwable
    //   164	1	3	localObject3	Object
    //   38	53	4	localObject4	Object
    //   99	17	4	localThrowable4	Throwable
    //   124	18	4	str2	String
    //   168	1	4	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	31	99	java/lang/Throwable
    //   133	137	140	java/lang/Throwable
    //   2	31	144	finally
    //   93	97	157	java/lang/Throwable
    //   151	155	160	java/lang/Throwable
    //   33	40	164	finally
    //   42	49	164	finally
    //   51	58	164	finally
    //   74	90	164	finally
    //   105	113	164	finally
    //   115	120	164	finally
    //   33	40	168	java/lang/Throwable
    //   42	49	168	java/lang/Throwable
    //   51	58	168	java/lang/Throwable
    //   74	90	168	java/lang/Throwable
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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    for (;;)
    {
      try
      {
        localObject1 = CertificateFactory.getInstance("X.509");
        if (localObject1 == null) {
          return null;
        }
        paramArrayOfByte = (X509Certificate)((CertificateFactory)localObject1).generateCertificate(new ByteArrayInputStream(paramArrayOfByte));
        if (paramArrayOfByte == null) {
          return null;
        }
        localStringBuilder.append("Issuer|");
        localObject1 = paramArrayOfByte.getIssuerDN();
        if (localObject1 == null) {
          continue;
        }
        localStringBuilder.append(((Principal)localObject1).toString());
        localStringBuilder.append("\n");
        localStringBuilder.append("SerialNumber|");
        localObject2 = paramArrayOfByte.getSerialNumber();
        if (localObject1 == null) {
          continue;
        }
        localStringBuilder.append(((BigInteger)localObject2).toString(16));
      }
      catch (CertificateException paramArrayOfByte)
      {
        Object localObject1;
        Object localObject2;
        if (x.a(paramArrayOfByte)) {
          continue;
        }
        paramArrayOfByte.printStackTrace();
        continue;
        localStringBuilder.append("unknown");
        continue;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (x.a(paramArrayOfByte)) {
          continue;
        }
        paramArrayOfByte.printStackTrace();
        continue;
        localStringBuilder.append("unknown");
        continue;
        localStringBuilder.append("unknown");
        continue;
        localStringBuilder.append("unknown");
        continue;
        localStringBuilder.append("unknown");
        continue;
      }
      localStringBuilder.append("\n");
      localStringBuilder.append("NotBefore|");
      localObject2 = paramArrayOfByte.getNotBefore();
      if (localObject1 == null) {
        continue;
      }
      localStringBuilder.append(((Date)localObject2).toString());
      localStringBuilder.append("\n");
      localStringBuilder.append("NotAfter|");
      localObject2 = paramArrayOfByte.getNotAfter();
      if (localObject1 == null) {
        continue;
      }
      localStringBuilder.append(((Date)localObject2).toString());
      localStringBuilder.append("\n");
      localStringBuilder.append("SHA1|");
      localObject1 = z.a(MessageDigest.getInstance("SHA1").digest(paramArrayOfByte.getEncoded()));
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        continue;
      }
      localStringBuilder.append(((String)localObject1).toString());
      localStringBuilder.append("\n");
      localStringBuilder.append("MD5|");
      paramArrayOfByte = z.a(MessageDigest.getInstance("MD5").digest(paramArrayOfByte.getEncoded()));
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length() <= 0)) {
        continue;
      }
      localStringBuilder.append(paramArrayOfByte.toString());
      if (localStringBuilder.length() != 0) {
        break label376;
      }
      return "unknown";
      localStringBuilder.append("unknown");
    }
    label376:
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
      if ((paramMap != null) && (paramMap.length() != 0))
      {
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
    }
    catch (Throwable paramMap)
    {
      if (!x.a(paramMap)) {
        paramMap.printStackTrace();
      }
      return null;
    }
    return null;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {}
    for (;;)
    {
      return false;
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
          if (x.a(paramContext)) {}
        }
      }
      catch (Throwable paramContext) {}
    }
    paramContext.printStackTrace();
    return false;
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
    if (paramContext == null) {}
    do
    {
      for (;;)
      {
        return null;
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
        catch (Throwable paramContext) {}
      }
    } while (x.a(paramContext));
    paramContext.printStackTrace();
    return null;
  }
  
  public static Map<String, String> d(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        if (paramContext.metaData == null) {
          break label216;
        }
        HashMap localHashMap = new HashMap();
        Object localObject = paramContext.metaData.get("BUGLY_DISABLE");
        if (localObject != null) {
          localHashMap.put("BUGLY_DISABLE", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_APPID");
        if (localObject != null) {
          localHashMap.put("BUGLY_APPID", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_APP_CHANNEL");
        if (localObject != null) {
          localHashMap.put("BUGLY_APP_CHANNEL", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_APP_VERSION");
        if (localObject != null) {
          localHashMap.put("BUGLY_APP_VERSION", localObject.toString());
        }
        localObject = paramContext.metaData.get("BUGLY_ENABLE_DEBUG");
        if (localObject != null) {
          localHashMap.put("BUGLY_ENABLE_DEBUG", localObject.toString());
        }
        localObject = paramContext.metaData.get("com.tencent.rdm.uuid");
        paramContext = localHashMap;
        if (localObject != null)
        {
          localHashMap.put("com.tencent.rdm.uuid", localObject.toString());
          paramContext = localHashMap;
        }
        return paramContext;
      }
      catch (Throwable paramContext) {}
      if (x.a(paramContext)) {
        break;
      }
      paramContext.printStackTrace();
      return null;
      label216:
      paramContext = null;
    }
  }
  
  public static String e(Context paramContext)
  {
    Object localObject = a(paramContext);
    if (localObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 64);
        if (paramContext != null)
        {
          localObject = paramContext.signatures;
          if ((localObject != null) && (localObject.length != 0)) {
            return a(paramContext.signatures[0].toByteArray());
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
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
    Object localObject;
    if (paramContext == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = h(paramContext);
      localObject = str;
    } while (!z.a(str));
    return i(paramContext);
  }
  
  /* Error */
  private static String h(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 325
    //   3: aload_0
    //   4: invokestatic 328	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 330
    //   12: ldc_w 310
    //   15: invokeinterface 336 3 0
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: invokestatic 316	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;)Z
    //   27: ifeq +7 -> 34
    //   30: ldc_w 338
    //   33: astore_2
    //   34: new 31	java/lang/StringBuilder
    //   37: dup
    //   38: ldc_w 340
    //   41: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: aload_2
    //   45: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: iconst_0
    //   52: anewarray 4	java/lang/Object
    //   55: invokestatic 342	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   58: pop
    //   59: aload_2
    //   60: ldc_w 310
    //   63: invokevirtual 216	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifne +108 -> 174
    //   69: aload_0
    //   70: invokevirtual 346	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   73: aload_2
    //   74: invokevirtual 352	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   77: astore_0
    //   78: aload_0
    //   79: astore_3
    //   80: new 354	java/util/Properties
    //   83: dup
    //   84: invokespecial 355	java/util/Properties:<init>	()V
    //   87: astore_2
    //   88: aload_0
    //   89: astore_3
    //   90: aload_2
    //   91: aload_0
    //   92: invokevirtual 359	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   95: aload_0
    //   96: astore_3
    //   97: aload_2
    //   98: ldc_w 361
    //   101: ldc_w 310
    //   104: invokevirtual 364	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_2
    //   108: aload_0
    //   109: astore_3
    //   110: new 31	java/lang/StringBuilder
    //   113: dup
    //   114: ldc_w 366
    //   117: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload_2
    //   121: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: iconst_0
    //   128: anewarray 4	java/lang/Object
    //   131: invokestatic 342	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   134: pop
    //   135: aload_0
    //   136: astore_3
    //   137: aload_2
    //   138: invokestatic 316	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;)Z
    //   141: istore_1
    //   142: aload_2
    //   143: astore 4
    //   145: aload_0
    //   146: astore 5
    //   148: iload_1
    //   149: ifne +33 -> 182
    //   152: aload_2
    //   153: astore_3
    //   154: aload_0
    //   155: ifnull +9 -> 164
    //   158: aload_0
    //   159: invokevirtual 369	java/io/InputStream:close	()V
    //   162: aload_2
    //   163: astore_3
    //   164: aload_3
    //   165: areturn
    //   166: astore_0
    //   167: aload_0
    //   168: invokestatic 69	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   171: pop
    //   172: aload_2
    //   173: areturn
    //   174: aconst_null
    //   175: astore 5
    //   177: ldc_w 310
    //   180: astore 4
    //   182: aload 4
    //   184: astore_3
    //   185: aload 5
    //   187: ifnull -23 -> 164
    //   190: aload 5
    //   192: invokevirtual 369	java/io/InputStream:close	()V
    //   195: aload 4
    //   197: areturn
    //   198: astore_0
    //   199: aload_0
    //   200: invokestatic 69	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   203: pop
    //   204: aload 4
    //   206: areturn
    //   207: astore_0
    //   208: aconst_null
    //   209: astore_0
    //   210: ldc_w 310
    //   213: astore_2
    //   214: aload_0
    //   215: astore_3
    //   216: ldc_w 371
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokestatic 373	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   226: pop
    //   227: aload_2
    //   228: astore_3
    //   229: aload_0
    //   230: ifnull -66 -> 164
    //   233: aload_0
    //   234: invokevirtual 369	java/io/InputStream:close	()V
    //   237: aload_2
    //   238: areturn
    //   239: astore_0
    //   240: aload_0
    //   241: invokestatic 69	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   244: pop
    //   245: aload_2
    //   246: areturn
    //   247: astore_0
    //   248: aconst_null
    //   249: astore_3
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 369	java/io/InputStream:close	()V
    //   258: aload_0
    //   259: athrow
    //   260: astore_2
    //   261: aload_2
    //   262: invokestatic 69	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   265: pop
    //   266: goto -8 -> 258
    //   269: astore_0
    //   270: goto -20 -> 250
    //   273: astore_2
    //   274: ldc_w 310
    //   277: astore_2
    //   278: goto -64 -> 214
    //   281: astore_3
    //   282: goto -68 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramContext	Context
    //   141	8	1	bool	boolean
    //   7	239	2	localObject1	Object
    //   260	2	2	localIOException	java.io.IOException
    //   273	1	2	localException1	java.lang.Exception
    //   277	1	2	str	String
    //   20	235	3	localObject2	Object
    //   281	1	3	localException2	java.lang.Exception
    //   143	62	4	localObject3	Object
    //   146	45	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   158	162	166	java/io/IOException
    //   190	195	198	java/io/IOException
    //   8	21	207	java/lang/Exception
    //   23	30	207	java/lang/Exception
    //   34	78	207	java/lang/Exception
    //   233	237	239	java/io/IOException
    //   8	21	247	finally
    //   23	30	247	finally
    //   34	78	247	finally
    //   254	258	260	java/io/IOException
    //   80	88	269	finally
    //   90	95	269	finally
    //   97	108	269	finally
    //   110	135	269	finally
    //   137	142	269	finally
    //   216	227	269	finally
    //   80	88	273	java/lang/Exception
    //   90	95	273	java/lang/Exception
    //   97	108	273	java/lang/Exception
    //   110	135	281	java/lang/Exception
    //   137	142	281	java/lang/Exception
  }
  
  private static String i(Context paramContext)
  {
    String str = "";
    try
    {
      Object localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
      paramContext = str;
      if (localObject != null) {
        paramContext = localObject.toString();
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      x.d("[AppInfo] Failed to read beacon channel from manifest.", new Object[0]);
      x.a(paramContext);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.AppInfo
 * JD-Core Version:    0.7.0.1
 */