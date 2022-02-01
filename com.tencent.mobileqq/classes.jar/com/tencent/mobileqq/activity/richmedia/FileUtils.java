package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.sveffects.SdkContext;
import java.io.File;

public class FileUtils
{
  private static String RootBasePath = "/";
  private static final String TAG = "FileUtils";
  public static Context sContextObj = SdkContext.getInstance().getApplication();
  
  public static boolean fileExists(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static Bitmap loadBitmapFromNative(String paramString, boolean paramBoolean)
  {
    return loadBitmapFromNative(paramString, paramBoolean, null);
  }
  
  /* Error */
  public static Bitmap loadBitmapFromNative(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 59	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 60	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 9
    //   9: aload 9
    //   11: getstatic 66	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   14: putfield 69	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   17: aload_2
    //   18: ifnull +9 -> 27
    //   21: aload 9
    //   23: aload_2
    //   24: putfield 73	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 7
    //   33: aconst_null
    //   34: astore 4
    //   36: aconst_null
    //   37: astore 5
    //   39: aload 7
    //   41: astore_2
    //   42: aload_0
    //   43: getstatic 76	java/io/File:separator	Ljava/lang/String;
    //   46: invokevirtual 81	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   49: istore_3
    //   50: iload_3
    //   51: ifne +152 -> 203
    //   54: aload 7
    //   56: astore_2
    //   57: getstatic 25	com/tencent/mobileqq/activity/richmedia/FileUtils:sContextObj	Landroid/content/Context;
    //   60: invokevirtual 87	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   63: invokevirtual 93	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   66: astore 8
    //   68: aload 7
    //   70: astore_2
    //   71: new 95	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   78: astore 10
    //   80: aload 7
    //   82: astore_2
    //   83: aload 10
    //   85: ldc 98
    //   87: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 7
    //   93: astore_2
    //   94: aload 10
    //   96: getstatic 76	java/io/File:separator	Ljava/lang/String;
    //   99: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 7
    //   105: astore_2
    //   106: aload 10
    //   108: aload_0
    //   109: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 7
    //   115: astore_2
    //   116: aload 8
    //   118: aload 10
    //   120: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokevirtual 112	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   126: astore 8
    //   128: aload 8
    //   130: astore_0
    //   131: goto +97 -> 228
    //   134: aload 7
    //   136: astore_2
    //   137: new 95	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   144: astore 8
    //   146: aload 7
    //   148: astore_2
    //   149: aload 8
    //   151: getstatic 29	com/tencent/mobileqq/activity/richmedia/FileUtils:RootBasePath	Ljava/lang/String;
    //   154: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 7
    //   160: astore_2
    //   161: aload 8
    //   163: aload_0
    //   164: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 7
    //   170: astore_2
    //   171: aload 8
    //   173: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: astore_0
    //   177: aload 7
    //   179: astore_2
    //   180: new 114	java/io/FileInputStream
    //   183: dup
    //   184: aload_0
    //   185: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   188: astore_0
    //   189: goto +39 -> 228
    //   192: astore_0
    //   193: aload 7
    //   195: astore_2
    //   196: aload_0
    //   197: invokevirtual 118	java/io/FileNotFoundException:printStackTrace	()V
    //   200: goto +26 -> 226
    //   203: aload 7
    //   205: astore_2
    //   206: new 114	java/io/FileInputStream
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   214: astore_0
    //   215: goto +13 -> 228
    //   218: astore_0
    //   219: aload 7
    //   221: astore_2
    //   222: aload_0
    //   223: invokevirtual 118	java/io/FileNotFoundException:printStackTrace	()V
    //   226: aconst_null
    //   227: astore_0
    //   228: aload 5
    //   230: astore 4
    //   232: aload_0
    //   233: aconst_null
    //   234: aload 9
    //   236: invokestatic 124	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   239: astore_2
    //   240: goto +30 -> 270
    //   243: astore 4
    //   245: aload_0
    //   246: astore_2
    //   247: aload 4
    //   249: astore_0
    //   250: goto +141 -> 391
    //   253: astore 5
    //   255: goto +110 -> 365
    //   258: astore_2
    //   259: aload 5
    //   261: astore 4
    //   263: aload_2
    //   264: invokevirtual 125	java/lang/OutOfMemoryError:printStackTrace	()V
    //   267: aload 6
    //   269: astore_2
    //   270: aload_2
    //   271: astore 4
    //   273: aload_2
    //   274: ifnull +58 -> 332
    //   277: aload_2
    //   278: astore 4
    //   280: iload_1
    //   281: ifeq +51 -> 332
    //   284: aload_2
    //   285: astore 4
    //   287: new 127	android/graphics/Matrix
    //   290: dup
    //   291: invokespecial 128	android/graphics/Matrix:<init>	()V
    //   294: astore 5
    //   296: aload_2
    //   297: astore 4
    //   299: aload 5
    //   301: fconst_1
    //   302: ldc 129
    //   304: invokevirtual 133	android/graphics/Matrix:preScale	(FF)Z
    //   307: pop
    //   308: aload_2
    //   309: astore 4
    //   311: aload_2
    //   312: iconst_0
    //   313: iconst_0
    //   314: aload_2
    //   315: invokevirtual 139	android/graphics/Bitmap:getWidth	()I
    //   318: aload_2
    //   319: invokevirtual 142	android/graphics/Bitmap:getHeight	()I
    //   322: aload 5
    //   324: iconst_1
    //   325: invokestatic 146	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   328: astore_2
    //   329: aload_2
    //   330: astore 4
    //   332: aload_0
    //   333: ifnull +15 -> 348
    //   336: aload_0
    //   337: invokevirtual 151	java/io/InputStream:close	()V
    //   340: goto +8 -> 348
    //   343: astore_0
    //   344: aload_0
    //   345: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   348: aload 4
    //   350: areturn
    //   351: astore_0
    //   352: goto +39 -> 391
    //   355: astore 5
    //   357: aconst_null
    //   358: astore_2
    //   359: aload 4
    //   361: astore_0
    //   362: aload_2
    //   363: astore 4
    //   365: aload_0
    //   366: astore_2
    //   367: aload 5
    //   369: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   372: aload_0
    //   373: ifnull +15 -> 388
    //   376: aload_0
    //   377: invokevirtual 151	java/io/InputStream:close	()V
    //   380: aload 4
    //   382: areturn
    //   383: astore_0
    //   384: aload_0
    //   385: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   388: aload 4
    //   390: areturn
    //   391: aload_2
    //   392: ifnull +15 -> 407
    //   395: aload_2
    //   396: invokevirtual 151	java/io/InputStream:close	()V
    //   399: goto +8 -> 407
    //   402: astore_2
    //   403: aload_2
    //   404: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   407: aload_0
    //   408: athrow
    //   409: astore_2
    //   410: goto -276 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramString	String
    //   0	413	1	paramBoolean	boolean
    //   0	413	2	paramBitmap	Bitmap
    //   49	2	3	bool	boolean
    //   34	197	4	localObject1	Object
    //   243	5	4	localObject2	Object
    //   261	128	4	localObject3	Object
    //   37	192	5	localObject4	Object
    //   253	7	5	localException1	java.lang.Exception
    //   294	29	5	localMatrix	android.graphics.Matrix
    //   355	13	5	localException2	java.lang.Exception
    //   28	240	6	localObject5	Object
    //   31	189	7	localObject6	Object
    //   66	106	8	localObject7	Object
    //   7	228	9	localOptions	android.graphics.BitmapFactory.Options
    //   78	41	10	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   180	189	192	java/io/FileNotFoundException
    //   206	215	218	java/io/FileNotFoundException
    //   232	240	243	finally
    //   263	267	243	finally
    //   287	296	243	finally
    //   299	308	243	finally
    //   311	329	243	finally
    //   232	240	253	java/lang/Exception
    //   263	267	253	java/lang/Exception
    //   287	296	253	java/lang/Exception
    //   299	308	253	java/lang/Exception
    //   311	329	253	java/lang/Exception
    //   232	240	258	java/lang/OutOfMemoryError
    //   336	340	343	java/io/IOException
    //   42	50	351	finally
    //   57	68	351	finally
    //   71	80	351	finally
    //   83	91	351	finally
    //   94	103	351	finally
    //   106	113	351	finally
    //   116	128	351	finally
    //   137	146	351	finally
    //   149	158	351	finally
    //   161	168	351	finally
    //   171	177	351	finally
    //   180	189	351	finally
    //   196	200	351	finally
    //   206	215	351	finally
    //   222	226	351	finally
    //   367	372	351	finally
    //   42	50	355	java/lang/Exception
    //   137	146	355	java/lang/Exception
    //   149	158	355	java/lang/Exception
    //   161	168	355	java/lang/Exception
    //   171	177	355	java/lang/Exception
    //   180	189	355	java/lang/Exception
    //   196	200	355	java/lang/Exception
    //   206	215	355	java/lang/Exception
    //   222	226	355	java/lang/Exception
    //   376	380	383	java/io/IOException
    //   395	399	402	java/io/IOException
    //   57	68	409	java/lang/Exception
    //   71	80	409	java/lang/Exception
    //   83	91	409	java/lang/Exception
    //   94	103	409	java/lang/Exception
    //   106	113	409	java/lang/Exception
    //   116	128	409	java/lang/Exception
  }
  
  /* Error */
  public static String readFileContent(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: invokevirtual 161	java/io/File:length	()J
    //   10: l2i
    //   11: istore_2
    //   12: new 163	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: iload_2
    //   17: invokespecial 166	java/io/ByteArrayOutputStream:<init>	(I)V
    //   20: astore 4
    //   22: new 114	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 169	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_0
    //   31: aload 4
    //   33: astore 5
    //   35: aload_0
    //   36: astore 6
    //   38: sipush 12288
    //   41: newarray byte
    //   43: astore 7
    //   45: iconst_0
    //   46: istore_1
    //   47: goto +25 -> 72
    //   50: astore 7
    //   52: goto +145 -> 197
    //   55: aload 4
    //   57: astore 5
    //   59: aload_0
    //   60: astore 6
    //   62: sipush 4096
    //   65: newarray byte
    //   67: astore 7
    //   69: goto -24 -> 45
    //   72: iload_1
    //   73: iload_2
    //   74: if_icmpge +40 -> 114
    //   77: aload 4
    //   79: astore 5
    //   81: aload_0
    //   82: astore 6
    //   84: aload_0
    //   85: aload 7
    //   87: invokevirtual 173	java/io/FileInputStream:read	([B)I
    //   90: istore_3
    //   91: aload 4
    //   93: astore 5
    //   95: aload_0
    //   96: astore 6
    //   98: aload 4
    //   100: aload 7
    //   102: iconst_0
    //   103: iload_3
    //   104: invokevirtual 177	java/io/ByteArrayOutputStream:write	([BII)V
    //   107: iload_1
    //   108: iload_3
    //   109: iadd
    //   110: istore_1
    //   111: goto -39 -> 72
    //   114: aload 4
    //   116: astore 5
    //   118: aload_0
    //   119: astore 6
    //   121: aload 4
    //   123: ldc 179
    //   125: invokevirtual 182	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 7
    //   130: aload 4
    //   132: invokevirtual 183	java/io/ByteArrayOutputStream:close	()V
    //   135: aload_0
    //   136: invokevirtual 184	java/io/FileInputStream:close	()V
    //   139: aload 7
    //   141: areturn
    //   142: astore_0
    //   143: aload 7
    //   145: astore 4
    //   147: invokestatic 189	com/tencent/sveffects/SLog:isEnable	()Z
    //   150: ifeq +120 -> 270
    //   153: ldc 9
    //   155: ldc 190
    //   157: aload_0
    //   158: invokestatic 194	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload 7
    //   163: areturn
    //   164: astore_0
    //   165: aconst_null
    //   166: astore 6
    //   168: goto +110 -> 278
    //   171: astore 7
    //   173: aconst_null
    //   174: astore_0
    //   175: goto +22 -> 197
    //   178: astore_0
    //   179: aconst_null
    //   180: astore 4
    //   182: aload 4
    //   184: astore 6
    //   186: goto +92 -> 278
    //   189: astore 7
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 4
    //   196: astore_0
    //   197: aload 4
    //   199: astore 5
    //   201: aload_0
    //   202: astore 6
    //   204: invokestatic 189	com/tencent/sveffects/SLog:isEnable	()Z
    //   207: ifeq +19 -> 226
    //   210: aload 4
    //   212: astore 5
    //   214: aload_0
    //   215: astore 6
    //   217: ldc 9
    //   219: ldc 190
    //   221: aload 7
    //   223: invokestatic 194	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload 4
    //   228: ifnull +11 -> 239
    //   231: aload 4
    //   233: invokevirtual 183	java/io/ByteArrayOutputStream:close	()V
    //   236: goto +3 -> 239
    //   239: aload 9
    //   241: astore 4
    //   243: aload_0
    //   244: ifnull +26 -> 270
    //   247: aload_0
    //   248: invokevirtual 184	java/io/FileInputStream:close	()V
    //   251: aconst_null
    //   252: areturn
    //   253: aload 9
    //   255: astore 4
    //   257: invokestatic 189	com/tencent/sveffects/SLog:isEnable	()Z
    //   260: ifeq +10 -> 270
    //   263: aload 8
    //   265: astore 7
    //   267: goto -114 -> 153
    //   270: aload 4
    //   272: areturn
    //   273: astore_0
    //   274: aload 5
    //   276: astore 4
    //   278: aload 4
    //   280: ifnull +11 -> 291
    //   283: aload 4
    //   285: invokevirtual 183	java/io/ByteArrayOutputStream:close	()V
    //   288: goto +3 -> 291
    //   291: aload 6
    //   293: ifnull +26 -> 319
    //   296: aload 6
    //   298: invokevirtual 184	java/io/FileInputStream:close	()V
    //   301: goto +18 -> 319
    //   304: invokestatic 189	com/tencent/sveffects/SLog:isEnable	()Z
    //   307: ifeq +12 -> 319
    //   310: ldc 9
    //   312: ldc 190
    //   314: aload 4
    //   316: invokestatic 194	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   319: goto +5 -> 324
    //   322: aload_0
    //   323: athrow
    //   324: goto -2 -> 322
    //   327: astore 5
    //   329: goto -274 -> 55
    //   332: astore_0
    //   333: goto -80 -> 253
    //   336: astore 4
    //   338: goto -34 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramFile	File
    //   46	65	1	i	int
    //   11	64	2	j	int
    //   90	20	3	k	int
    //   20	295	4	localObject1	Object
    //   336	1	4	localIOException	java.io.IOException
    //   33	242	5	localObject2	Object
    //   327	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   36	261	6	localObject3	Object
    //   43	1	7	arrayOfByte	byte[]
    //   50	1	7	localThrowable1	java.lang.Throwable
    //   67	95	7	localObject4	Object
    //   171	1	7	localThrowable2	java.lang.Throwable
    //   189	33	7	localThrowable3	java.lang.Throwable
    //   265	1	7	localObject5	Object
    //   4	260	8	localObject6	Object
    //   1	253	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   38	45	50	java/lang/Throwable
    //   62	69	50	java/lang/Throwable
    //   84	91	50	java/lang/Throwable
    //   98	107	50	java/lang/Throwable
    //   121	130	50	java/lang/Throwable
    //   130	139	142	java/io/IOException
    //   22	31	164	finally
    //   22	31	171	java/lang/Throwable
    //   6	22	178	finally
    //   6	22	189	java/lang/Throwable
    //   38	45	273	finally
    //   62	69	273	finally
    //   84	91	273	finally
    //   98	107	273	finally
    //   121	130	273	finally
    //   204	210	273	finally
    //   217	226	273	finally
    //   38	45	327	java/lang/OutOfMemoryError
    //   231	236	332	java/io/IOException
    //   247	251	332	java/io/IOException
    //   283	288	336	java/io/IOException
    //   296	301	336	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FileUtils
 * JD-Core Version:    0.7.0.1
 */