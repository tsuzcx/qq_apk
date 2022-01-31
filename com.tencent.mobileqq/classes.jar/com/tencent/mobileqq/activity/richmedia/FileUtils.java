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
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  public static Bitmap loadBitmapFromNative(String paramString, boolean paramBoolean)
  {
    return loadBitmapFromNative(paramString, paramBoolean, null);
  }
  
  /* Error */
  public static Bitmap loadBitmapFromNative(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 59	android/graphics/BitmapFactory$Options
    //   6: dup
    //   7: invokespecial 60	android/graphics/BitmapFactory$Options:<init>	()V
    //   10: astore 5
    //   12: aload 5
    //   14: getstatic 66	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   17: putfield 69	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   20: aload_2
    //   21: ifnull +9 -> 30
    //   24: aload 5
    //   26: aload_2
    //   27: putfield 73	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   30: aload_0
    //   31: getstatic 76	java/io/File:separator	Ljava/lang/String;
    //   34: invokevirtual 81	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +165 -> 204
    //   42: getstatic 25	com/tencent/mobileqq/activity/richmedia/FileUtils:sContextObj	Landroid/content/Context;
    //   45: invokevirtual 87	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   48: invokevirtual 93	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   51: new 95	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   58: ldc 98
    //   60: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: getstatic 76	java/io/File:separator	Ljava/lang/String;
    //   66: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokevirtual 112	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   79: astore_2
    //   80: aload_2
    //   81: astore_0
    //   82: aload_0
    //   83: aconst_null
    //   84: aload 5
    //   86: invokestatic 118	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   89: astore_2
    //   90: aload_2
    //   91: astore 4
    //   93: aload_2
    //   94: ifnull +47 -> 141
    //   97: aload_2
    //   98: astore 4
    //   100: iload_1
    //   101: ifeq +40 -> 141
    //   104: new 120	android/graphics/Matrix
    //   107: dup
    //   108: invokespecial 121	android/graphics/Matrix:<init>	()V
    //   111: astore 4
    //   113: aload 4
    //   115: fconst_1
    //   116: ldc 122
    //   118: invokevirtual 126	android/graphics/Matrix:preScale	(FF)Z
    //   121: pop
    //   122: aload_2
    //   123: iconst_0
    //   124: iconst_0
    //   125: aload_2
    //   126: invokevirtual 132	android/graphics/Bitmap:getWidth	()I
    //   129: aload_2
    //   130: invokevirtual 135	android/graphics/Bitmap:getHeight	()I
    //   133: aload 4
    //   135: iconst_1
    //   136: invokestatic 139	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   139: astore 4
    //   141: aload 4
    //   143: astore 5
    //   145: aload_0
    //   146: ifnull +11 -> 157
    //   149: aload_0
    //   150: invokevirtual 144	java/io/InputStream:close	()V
    //   153: aload 4
    //   155: astore 5
    //   157: aload 5
    //   159: areturn
    //   160: astore_2
    //   161: new 95	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   168: getstatic 29	com/tencent/mobileqq/activity/richmedia/FileUtils:RootBasePath	Ljava/lang/String;
    //   171: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: astore_0
    //   182: new 146	java/io/FileInputStream
    //   185: dup
    //   186: aload_0
    //   187: invokespecial 147	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   190: astore_0
    //   191: goto -109 -> 82
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 150	java/io/FileNotFoundException:printStackTrace	()V
    //   199: aconst_null
    //   200: astore_0
    //   201: goto -10 -> 191
    //   204: new 146	java/io/FileInputStream
    //   207: dup
    //   208: aload_0
    //   209: invokespecial 147	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   212: astore_0
    //   213: goto -131 -> 82
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 150	java/io/FileNotFoundException:printStackTrace	()V
    //   221: aconst_null
    //   222: astore_0
    //   223: goto -141 -> 82
    //   226: astore_2
    //   227: aload_2
    //   228: invokevirtual 151	java/lang/OutOfMemoryError:printStackTrace	()V
    //   231: aconst_null
    //   232: astore_2
    //   233: goto -143 -> 90
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   241: aload 4
    //   243: areturn
    //   244: astore 4
    //   246: aconst_null
    //   247: astore_2
    //   248: aconst_null
    //   249: astore_0
    //   250: aload 4
    //   252: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   255: aload_0
    //   256: astore 5
    //   258: aload_2
    //   259: ifnull -102 -> 157
    //   262: aload_2
    //   263: invokevirtual 144	java/io/InputStream:close	()V
    //   266: aload_0
    //   267: areturn
    //   268: astore_2
    //   269: aload_2
    //   270: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   273: aload_0
    //   274: areturn
    //   275: astore_0
    //   276: aload 4
    //   278: astore_2
    //   279: aload_2
    //   280: ifnull +7 -> 287
    //   283: aload_2
    //   284: invokevirtual 144	java/io/InputStream:close	()V
    //   287: aload_0
    //   288: athrow
    //   289: astore_2
    //   290: aload_2
    //   291: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   294: goto -7 -> 287
    //   297: astore 4
    //   299: aload_0
    //   300: astore_2
    //   301: aload 4
    //   303: astore_0
    //   304: goto -25 -> 279
    //   307: astore_0
    //   308: goto -29 -> 279
    //   311: astore 4
    //   313: aload_0
    //   314: astore_2
    //   315: aconst_null
    //   316: astore_0
    //   317: goto -67 -> 250
    //   320: astore 4
    //   322: aload_0
    //   323: astore 5
    //   325: aload_2
    //   326: astore_0
    //   327: aload 5
    //   329: astore_2
    //   330: goto -80 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramString	String
    //   0	333	1	paramBoolean	boolean
    //   0	333	2	paramBitmap	Bitmap
    //   37	2	3	bool	boolean
    //   1	241	4	localObject1	Object
    //   244	33	4	localException1	java.lang.Exception
    //   297	5	4	localObject2	Object
    //   311	1	4	localException2	java.lang.Exception
    //   320	1	4	localException3	java.lang.Exception
    //   10	318	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   42	80	160	java/lang/Exception
    //   182	191	194	java/io/FileNotFoundException
    //   204	213	216	java/io/FileNotFoundException
    //   82	90	226	java/lang/OutOfMemoryError
    //   149	153	236	java/io/IOException
    //   30	38	244	java/lang/Exception
    //   161	182	244	java/lang/Exception
    //   182	191	244	java/lang/Exception
    //   195	199	244	java/lang/Exception
    //   204	213	244	java/lang/Exception
    //   217	221	244	java/lang/Exception
    //   262	266	268	java/io/IOException
    //   30	38	275	finally
    //   42	80	275	finally
    //   161	182	275	finally
    //   182	191	275	finally
    //   195	199	275	finally
    //   204	213	275	finally
    //   217	221	275	finally
    //   283	287	289	java/io/IOException
    //   82	90	297	finally
    //   104	141	297	finally
    //   227	231	297	finally
    //   250	255	307	finally
    //   82	90	311	java/lang/Exception
    //   227	231	311	java/lang/Exception
    //   104	141	320	java/lang/Exception
  }
  
  /* Error */
  public static String readFileContent(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 8
    //   5: aload_0
    //   6: invokevirtual 161	java/io/File:length	()J
    //   9: l2i
    //   10: istore_2
    //   11: new 163	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: iload_2
    //   16: invokespecial 166	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore 4
    //   21: new 146	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 169	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload 4
    //   32: astore 6
    //   34: aload_0
    //   35: astore 5
    //   37: sipush 12288
    //   40: newarray byte
    //   42: astore 7
    //   44: iload_1
    //   45: iload_2
    //   46: if_icmpge +59 -> 105
    //   49: aload 4
    //   51: astore 6
    //   53: aload_0
    //   54: astore 5
    //   56: aload_0
    //   57: aload 7
    //   59: invokevirtual 173	java/io/FileInputStream:read	([B)I
    //   62: istore_3
    //   63: aload 4
    //   65: astore 6
    //   67: aload_0
    //   68: astore 5
    //   70: aload 4
    //   72: aload 7
    //   74: iconst_0
    //   75: iload_3
    //   76: invokevirtual 177	java/io/ByteArrayOutputStream:write	([BII)V
    //   79: iload_1
    //   80: iload_3
    //   81: iadd
    //   82: istore_1
    //   83: goto -39 -> 44
    //   86: astore 5
    //   88: aload 4
    //   90: astore 6
    //   92: aload_0
    //   93: astore 5
    //   95: sipush 4096
    //   98: newarray byte
    //   100: astore 7
    //   102: goto -58 -> 44
    //   105: aload 4
    //   107: astore 6
    //   109: aload_0
    //   110: astore 5
    //   112: aload 4
    //   114: ldc 179
    //   116: invokevirtual 182	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore 7
    //   121: aload 7
    //   123: astore 5
    //   125: aload 4
    //   127: ifnull +8 -> 135
    //   130: aload 4
    //   132: invokevirtual 183	java/io/ByteArrayOutputStream:close	()V
    //   135: aload 5
    //   137: astore 4
    //   139: aload_0
    //   140: ifnull +11 -> 151
    //   143: aload_0
    //   144: invokevirtual 184	java/io/FileInputStream:close	()V
    //   147: aload 5
    //   149: astore 4
    //   151: aload 4
    //   153: areturn
    //   154: astore_0
    //   155: aload 5
    //   157: astore 4
    //   159: invokestatic 189	com/tencent/sveffects/SLog:isEnable	()Z
    //   162: ifeq -11 -> 151
    //   165: ldc 9
    //   167: ldc 190
    //   169: aload_0
    //   170: invokestatic 194	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload 5
    //   175: areturn
    //   176: astore 7
    //   178: aconst_null
    //   179: astore 4
    //   181: aconst_null
    //   182: astore_0
    //   183: aload 4
    //   185: astore 6
    //   187: aload_0
    //   188: astore 5
    //   190: invokestatic 189	com/tencent/sveffects/SLog:isEnable	()Z
    //   193: ifeq +19 -> 212
    //   196: aload 4
    //   198: astore 6
    //   200: aload_0
    //   201: astore 5
    //   203: ldc 9
    //   205: ldc 190
    //   207: aload 7
    //   209: invokestatic 194	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload 4
    //   214: ifnull +8 -> 222
    //   217: aload 4
    //   219: invokevirtual 183	java/io/ByteArrayOutputStream:close	()V
    //   222: aload 8
    //   224: astore 4
    //   226: aload_0
    //   227: ifnull -76 -> 151
    //   230: aload_0
    //   231: invokevirtual 184	java/io/FileInputStream:close	()V
    //   234: aconst_null
    //   235: areturn
    //   236: astore_0
    //   237: aload 8
    //   239: astore 4
    //   241: invokestatic 189	com/tencent/sveffects/SLog:isEnable	()Z
    //   244: ifeq -93 -> 151
    //   247: ldc 9
    //   249: ldc 190
    //   251: aload_0
    //   252: invokestatic 194	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   255: aconst_null
    //   256: areturn
    //   257: astore_0
    //   258: aconst_null
    //   259: astore 4
    //   261: aconst_null
    //   262: astore 5
    //   264: aload 4
    //   266: ifnull +8 -> 274
    //   269: aload 4
    //   271: invokevirtual 183	java/io/ByteArrayOutputStream:close	()V
    //   274: aload 5
    //   276: ifnull +8 -> 284
    //   279: aload 5
    //   281: invokevirtual 184	java/io/FileInputStream:close	()V
    //   284: aload_0
    //   285: athrow
    //   286: astore 4
    //   288: invokestatic 189	com/tencent/sveffects/SLog:isEnable	()Z
    //   291: ifeq -7 -> 284
    //   294: ldc 9
    //   296: ldc 190
    //   298: aload 4
    //   300: invokestatic 194	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   303: goto -19 -> 284
    //   306: astore_0
    //   307: aconst_null
    //   308: astore 5
    //   310: goto -46 -> 264
    //   313: astore_0
    //   314: aload 6
    //   316: astore 4
    //   318: goto -54 -> 264
    //   321: astore 7
    //   323: aconst_null
    //   324: astore_0
    //   325: goto -142 -> 183
    //   328: astore 7
    //   330: goto -147 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramFile	File
    //   1	82	1	i	int
    //   10	37	2	j	int
    //   62	20	3	k	int
    //   19	251	4	localObject1	Object
    //   286	13	4	localIOException	java.io.IOException
    //   316	1	4	localObject2	Object
    //   35	34	5	localFile	File
    //   86	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   93	216	5	localObject3	Object
    //   32	283	6	localObject4	Object
    //   42	80	7	localObject5	Object
    //   176	32	7	localThrowable1	java.lang.Throwable
    //   321	1	7	localThrowable2	java.lang.Throwable
    //   328	1	7	localThrowable3	java.lang.Throwable
    //   3	235	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   37	44	86	java/lang/OutOfMemoryError
    //   130	135	154	java/io/IOException
    //   143	147	154	java/io/IOException
    //   5	21	176	java/lang/Throwable
    //   217	222	236	java/io/IOException
    //   230	234	236	java/io/IOException
    //   5	21	257	finally
    //   269	274	286	java/io/IOException
    //   279	284	286	java/io/IOException
    //   21	30	306	finally
    //   37	44	313	finally
    //   56	63	313	finally
    //   70	79	313	finally
    //   95	102	313	finally
    //   112	121	313	finally
    //   190	196	313	finally
    //   203	212	313	finally
    //   21	30	321	java/lang/Throwable
    //   37	44	328	java/lang/Throwable
    //   56	63	328	java/lang/Throwable
    //   70	79	328	java/lang/Throwable
    //   95	102	328	java/lang/Throwable
    //   112	121	328	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FileUtils
 * JD-Core Version:    0.7.0.1
 */