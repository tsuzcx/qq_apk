package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public final class gd
{
  public static String a;
  public static String b;
  
  public static final InputStream a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = paramContext.getAssets();
    } while (paramContext == null);
    try
    {
      paramContext = paramContext.open(paramString);
      return paramContext;
    }
    catch (IOException paramContext) {}
    return null;
  }
  
  public static final InputStream a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1 + paramString2);
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 43	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: aload_2
    //   9: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: invokevirtual 50	java/io/File:exists	()Z
    //   15: ifne +188 -> 203
    //   18: new 26	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   25: aload_0
    //   26: invokestatic 56	com/tencent/tencentmap/io/QStorageManager:getInstance	(Landroid/content/Context;)Lcom/tencent/tencentmap/io/QStorageManager;
    //   29: aconst_null
    //   30: invokevirtual 60	com/tencent/tencentmap/io/QStorageManager:getAssetsLoadPath	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 64	com/tencent/map/sdk/a/on:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   46: astore 7
    //   48: aload 7
    //   50: astore 4
    //   52: aload 7
    //   54: ifnonnull +51 -> 105
    //   57: aload 7
    //   59: astore 6
    //   61: aload 7
    //   63: astore 5
    //   65: getstatic 66	com/tencent/map/sdk/a/gd:a	Ljava/lang/String;
    //   68: ifnull +136 -> 204
    //   71: aload 7
    //   73: astore 6
    //   75: aload 7
    //   77: astore 5
    //   79: aload_0
    //   80: new 26	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   87: getstatic 66	com/tencent/map/sdk/a/gd:a	Ljava/lang/String;
    //   90: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 40	com/tencent/map/sdk/a/gd:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   103: astore 4
    //   105: aload 4
    //   107: astore 5
    //   109: aload 4
    //   111: ifnonnull +44 -> 155
    //   114: aload 4
    //   116: astore 6
    //   118: aload 4
    //   120: astore 5
    //   122: new 26	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   129: aload_0
    //   130: invokestatic 56	com/tencent/tencentmap/io/QStorageManager:getInstance	(Landroid/content/Context;)Lcom/tencent/tencentmap/io/QStorageManager;
    //   133: invokevirtual 69	com/tencent/tencentmap/io/QStorageManager:getAssetsDynamicPath	()Ljava/lang/String;
    //   136: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_3
    //   140: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 64	com/tencent/map/sdk/a/on:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   149: astore 4
    //   151: aload 4
    //   153: astore 5
    //   155: aload 5
    //   157: ifnonnull +178 -> 335
    //   160: aload 5
    //   162: astore 6
    //   164: aload_0
    //   165: ldc 71
    //   167: aload_3
    //   168: invokestatic 73	com/tencent/map/sdk/a/gd:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   171: astore_0
    //   172: new 75	java/io/FileOutputStream
    //   175: dup
    //   176: new 43	java/io/File
    //   179: dup
    //   180: aload_1
    //   181: aload_2
    //   182: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: invokespecial 78	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   188: astore_2
    //   189: aload_0
    //   190: aload_2
    //   191: invokestatic 81	com/tencent/map/sdk/a/on:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   194: pop2
    //   195: aload_2
    //   196: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   203: return
    //   204: aload 7
    //   206: astore 4
    //   208: aload 7
    //   210: astore 6
    //   212: aload 7
    //   214: astore 5
    //   216: getstatic 86	com/tencent/map/sdk/a/gd:b	Ljava/lang/String;
    //   219: ifnull -114 -> 105
    //   222: aload 7
    //   224: astore 6
    //   226: aload 7
    //   228: astore 5
    //   230: new 26	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   237: getstatic 86	com/tencent/map/sdk/a/gd:b	Ljava/lang/String;
    //   240: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_3
    //   244: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 64	com/tencent/map/sdk/a/on:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   253: astore 4
    //   255: goto -150 -> 105
    //   258: astore_0
    //   259: aconst_null
    //   260: astore 5
    //   262: aload 8
    //   264: astore_0
    //   265: aload_0
    //   266: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   269: aload 5
    //   271: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   274: return
    //   275: astore_1
    //   276: aconst_null
    //   277: astore_0
    //   278: aconst_null
    //   279: astore_2
    //   280: aload_2
    //   281: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   284: aload_0
    //   285: invokestatic 84	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   288: aload_1
    //   289: athrow
    //   290: astore_1
    //   291: aload 6
    //   293: astore_0
    //   294: aconst_null
    //   295: astore_2
    //   296: goto -16 -> 280
    //   299: astore_1
    //   300: aconst_null
    //   301: astore_2
    //   302: goto -22 -> 280
    //   305: astore_1
    //   306: goto -26 -> 280
    //   309: astore_0
    //   310: aload 8
    //   312: astore_0
    //   313: goto -48 -> 265
    //   316: astore_1
    //   317: aload_0
    //   318: astore 5
    //   320: aload 8
    //   322: astore_0
    //   323: goto -58 -> 265
    //   326: astore_1
    //   327: aload_0
    //   328: astore 5
    //   330: aload_2
    //   331: astore_0
    //   332: goto -67 -> 265
    //   335: aload 5
    //   337: astore_0
    //   338: goto -166 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramContext	Context
    //   0	341	1	paramString1	String
    //   0	341	2	paramString2	String
    //   0	341	3	paramString3	String
    //   50	204	4	localInputStream1	InputStream
    //   63	273	5	localObject1	Object
    //   59	233	6	localObject2	Object
    //   46	181	7	localInputStream2	InputStream
    //   1	320	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	48	258	java/io/IOException
    //   18	48	275	finally
    //   65	71	290	finally
    //   79	105	290	finally
    //   122	151	290	finally
    //   164	172	290	finally
    //   216	222	290	finally
    //   230	255	290	finally
    //   172	189	299	finally
    //   189	195	305	finally
    //   65	71	309	java/io/IOException
    //   79	105	309	java/io/IOException
    //   122	151	309	java/io/IOException
    //   164	172	309	java/io/IOException
    //   216	222	309	java/io/IOException
    //   230	255	309	java/io/IOException
    //   172	189	316	java/io/IOException
    //   189	195	326	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.gd
 * JD-Core Version:    0.7.0.1
 */