package com.tencent.mobileqq.ark.util;

import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class ArkAppDataUtil
{
  public static String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      String str = ArkEnvironmentManager.getInstance().getAppResPath(paramString1);
      int i = (int)(Math.random() * 10.0D);
      paramString1 = String.format("share_%d_%02d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString1);
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("res:");
      localStringBuilder.append(paramString1);
      paramString1 = localStringBuilder.toString();
      if (FileUtils.copyFile(paramString2, str)) {
        return paramString1;
      }
      return "";
    }
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.AppDataUtil", 2, "AAShare.CopyFileToCache appName is null or local path is null");
    }
    return null;
  }
  
  /* Error */
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 7
    //   15: iload 4
    //   17: ifne +352 -> 369
    //   20: aload_1
    //   21: ifnonnull +6 -> 27
    //   24: goto +345 -> 369
    //   27: invokestatic 23	com/tencent/ark/ArkEnvironmentManager:getInstance	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   30: aload_0
    //   31: invokevirtual 27	com/tencent/ark/ArkEnvironmentManager:getAppResPath	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore 10
    //   36: invokestatic 43	java/lang/System:currentTimeMillis	()J
    //   39: lstore 5
    //   41: iconst_0
    //   42: istore_3
    //   43: ldc 37
    //   45: iconst_2
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: lload 5
    //   53: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: invokestatic 33	java/lang/Math:random	()D
    //   62: ldc2_w 34
    //   65: dmul
    //   66: invokestatic 107	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   69: aastore
    //   70: invokestatic 60	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   73: astore_0
    //   74: new 62	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   81: astore 11
    //   83: aload 11
    //   85: aload 10
    //   87: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 11
    //   93: ldc 69
    //   95: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 11
    //   101: aload_0
    //   102: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 11
    //   108: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore 11
    //   113: new 62	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   120: astore 10
    //   122: aload 10
    //   124: ldc 75
    //   126: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 10
    //   132: aload_0
    //   133: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 10
    //   139: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: astore 10
    //   144: aload 7
    //   146: astore_0
    //   147: new 109	java/io/File
    //   150: dup
    //   151: aload 11
    //   153: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   156: astore 11
    //   158: aload 7
    //   160: astore_0
    //   161: aload 11
    //   163: invokevirtual 115	java/io/File:exists	()Z
    //   166: ifeq +12 -> 178
    //   169: aload 7
    //   171: astore_0
    //   172: aload 11
    //   174: invokevirtual 118	java/io/File:delete	()Z
    //   177: pop
    //   178: aload 7
    //   180: astore_0
    //   181: new 120	java/io/FileOutputStream
    //   184: dup
    //   185: aload 11
    //   187: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   190: astore 7
    //   192: aload 7
    //   194: aload_1
    //   195: iconst_0
    //   196: aload_1
    //   197: arraylength
    //   198: invokevirtual 127	java/io/FileOutputStream:write	([BII)V
    //   201: aload 7
    //   203: invokevirtual 130	java/io/FileOutputStream:flush	()V
    //   206: aload 7
    //   208: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   211: goto +13 -> 224
    //   214: astore_0
    //   215: ldc 91
    //   217: iconst_1
    //   218: ldc 135
    //   220: aload_0
    //   221: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: iconst_1
    //   225: istore_2
    //   226: goto +110 -> 336
    //   229: astore_1
    //   230: aload 7
    //   232: astore_0
    //   233: goto +113 -> 346
    //   236: astore_0
    //   237: aload 7
    //   239: astore_1
    //   240: aload_0
    //   241: astore 7
    //   243: goto +22 -> 265
    //   246: astore_0
    //   247: aload 7
    //   249: astore_1
    //   250: aload_0
    //   251: astore 7
    //   253: goto +44 -> 297
    //   256: astore_1
    //   257: goto +89 -> 346
    //   260: astore 7
    //   262: aload 8
    //   264: astore_1
    //   265: aload_1
    //   266: astore_0
    //   267: ldc 91
    //   269: iconst_1
    //   270: ldc 140
    //   272: aload 7
    //   274: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   277: iload_3
    //   278: istore_2
    //   279: aload_1
    //   280: ifnull +56 -> 336
    //   283: aload_1
    //   284: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   287: iload_3
    //   288: istore_2
    //   289: goto +47 -> 336
    //   292: astore 7
    //   294: aload 9
    //   296: astore_1
    //   297: aload_1
    //   298: astore_0
    //   299: ldc 91
    //   301: iconst_1
    //   302: ldc 135
    //   304: aload 7
    //   306: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   309: iload_3
    //   310: istore_2
    //   311: aload_1
    //   312: ifnull +24 -> 336
    //   315: aload_1
    //   316: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   319: iload_3
    //   320: istore_2
    //   321: goto +15 -> 336
    //   324: astore_0
    //   325: ldc 91
    //   327: iconst_1
    //   328: ldc 135
    //   330: aload_0
    //   331: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   334: iload_3
    //   335: istore_2
    //   336: iload_2
    //   337: ifeq +6 -> 343
    //   340: aload 10
    //   342: areturn
    //   343: ldc 83
    //   345: areturn
    //   346: aload_0
    //   347: ifnull +20 -> 367
    //   350: aload_0
    //   351: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   354: goto +13 -> 367
    //   357: astore_0
    //   358: ldc 91
    //   360: iconst_1
    //   361: ldc 135
    //   363: aload_0
    //   364: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: aload_1
    //   368: athrow
    //   369: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +11 -> 383
    //   375: ldc 91
    //   377: iconst_2
    //   378: ldc 142
    //   380: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aconst_null
    //   384: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramString	String
    //   0	385	1	paramArrayOfByte	byte[]
    //   225	112	2	i	int
    //   42	293	3	j	int
    //   4	12	4	bool	boolean
    //   39	13	5	l	long
    //   13	239	7	localObject1	Object
    //   260	13	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   292	13	7	localIOException	java.io.IOException
    //   7	256	8	localObject2	Object
    //   10	285	9	localObject3	Object
    //   34	307	10	localObject4	Object
    //   81	105	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   206	211	214	java/io/IOException
    //   192	206	229	finally
    //   192	206	236	java/lang/OutOfMemoryError
    //   192	206	246	java/io/IOException
    //   147	158	256	finally
    //   161	169	256	finally
    //   172	178	256	finally
    //   181	192	256	finally
    //   267	277	256	finally
    //   299	309	256	finally
    //   147	158	260	java/lang/OutOfMemoryError
    //   161	169	260	java/lang/OutOfMemoryError
    //   172	178	260	java/lang/OutOfMemoryError
    //   181	192	260	java/lang/OutOfMemoryError
    //   147	158	292	java/io/IOException
    //   161	169	292	java/io/IOException
    //   172	178	292	java/io/IOException
    //   181	192	292	java/io/IOException
    //   283	287	324	java/io/IOException
    //   315	319	324	java/io/IOException
    //   350	354	357	java/io/IOException
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ArkEnvironmentManager.getInstance().getAppResPath(paramString1));
      localStringBuilder.append("/");
      localStringBuilder.append(paramString2.replace("res:", ""));
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.util.ArkAppDataUtil
 * JD-Core Version:    0.7.0.1
 */