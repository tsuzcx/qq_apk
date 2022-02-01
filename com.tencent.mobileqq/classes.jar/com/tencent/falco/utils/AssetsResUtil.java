package com.tencent.falco.utils;

import android.content.Context;

public final class AssetsResUtil
{
  private static final String CHARSET_NAME = "UTF-8";
  
  /* Error */
  public static void copyAsset(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: aload_0
    //   10: invokevirtual 23	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_1
    //   14: invokevirtual 29	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_0
    //   18: aload_1
    //   19: astore 7
    //   21: aload 9
    //   23: astore 6
    //   25: aload_0
    //   26: astore 5
    //   28: aload_1
    //   29: getstatic 34	java/io/File:separator	Ljava/lang/String;
    //   32: invokevirtual 40	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +25 -> 60
    //   38: aload 9
    //   40: astore 6
    //   42: aload_0
    //   43: astore 5
    //   45: aload_1
    //   46: aload_1
    //   47: getstatic 34	java/io/File:separator	Ljava/lang/String;
    //   50: invokevirtual 44	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   53: iconst_1
    //   54: iadd
    //   55: invokevirtual 48	java/lang/String:substring	(I)Ljava/lang/String;
    //   58: astore 7
    //   60: aload 9
    //   62: astore 6
    //   64: aload_0
    //   65: astore 5
    //   67: new 50	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   74: aload_2
    //   75: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: astore 10
    //   80: aload 9
    //   82: astore 6
    //   84: aload_0
    //   85: astore 5
    //   87: aload_2
    //   88: getstatic 34	java/io/File:separator	Ljava/lang/String;
    //   91: invokevirtual 59	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   94: ifeq +88 -> 182
    //   97: ldc 61
    //   99: astore_1
    //   100: aload 9
    //   102: astore 6
    //   104: aload_0
    //   105: astore 5
    //   107: aload 10
    //   109: aload_1
    //   110: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 7
    //   115: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: astore_1
    //   122: aload 9
    //   124: astore 6
    //   126: aload_0
    //   127: astore 5
    //   129: new 31	java/io/File
    //   132: dup
    //   133: aload_2
    //   134: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: astore_2
    //   138: iconst_1
    //   139: istore 4
    //   141: aload 9
    //   143: astore 6
    //   145: aload_0
    //   146: astore 5
    //   148: aload_2
    //   149: invokevirtual 72	java/io/File:exists	()Z
    //   152: ifne +16 -> 168
    //   155: aload 9
    //   157: astore 6
    //   159: aload_0
    //   160: astore 5
    //   162: aload_2
    //   163: invokevirtual 75	java/io/File:mkdirs	()Z
    //   166: istore 4
    //   168: iload 4
    //   170: ifne +26 -> 196
    //   173: aload_0
    //   174: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   177: aconst_null
    //   178: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   181: return
    //   182: aload 9
    //   184: astore 6
    //   186: aload_0
    //   187: astore 5
    //   189: getstatic 34	java/io/File:separator	Ljava/lang/String;
    //   192: astore_1
    //   193: goto -93 -> 100
    //   196: aload 9
    //   198: astore 6
    //   200: aload_0
    //   201: astore 5
    //   203: new 31	java/io/File
    //   206: dup
    //   207: aload_1
    //   208: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   211: astore_1
    //   212: aload 9
    //   214: astore 6
    //   216: aload_0
    //   217: astore 5
    //   219: aload_1
    //   220: invokevirtual 72	java/io/File:exists	()Z
    //   223: ifeq +15 -> 238
    //   226: aload 9
    //   228: astore 6
    //   230: aload_0
    //   231: astore 5
    //   233: aload_1
    //   234: invokevirtual 84	java/io/File:delete	()Z
    //   237: pop
    //   238: aload 9
    //   240: astore 6
    //   242: aload_0
    //   243: astore 5
    //   245: aload_1
    //   246: invokevirtual 87	java/io/File:createNewFile	()Z
    //   249: ifeq +76 -> 325
    //   252: aload 9
    //   254: astore 6
    //   256: aload_0
    //   257: astore 5
    //   259: new 89	java/io/FileOutputStream
    //   262: dup
    //   263: aload_1
    //   264: invokespecial 92	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   267: astore_1
    //   268: sipush 1024
    //   271: newarray byte
    //   273: astore 5
    //   275: aload_0
    //   276: aload 5
    //   278: invokevirtual 98	java/io/InputStream:read	([B)I
    //   281: istore_3
    //   282: aload_1
    //   283: astore_2
    //   284: iload_3
    //   285: ifle +42 -> 327
    //   288: aload_1
    //   289: aload 5
    //   291: iconst_0
    //   292: iload_3
    //   293: invokevirtual 104	java/io/OutputStream:write	([BII)V
    //   296: goto -21 -> 275
    //   299: astore 5
    //   301: aload_1
    //   302: astore_2
    //   303: aload 5
    //   305: astore_1
    //   306: aload_2
    //   307: astore 6
    //   309: aload_0
    //   310: astore 5
    //   312: aload_1
    //   313: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   316: aload_0
    //   317: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   320: aload_2
    //   321: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   324: return
    //   325: aconst_null
    //   326: astore_2
    //   327: aload_0
    //   328: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   331: aload_2
    //   332: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   335: return
    //   336: astore_1
    //   337: aconst_null
    //   338: astore_0
    //   339: aload_0
    //   340: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   343: aload 6
    //   345: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   348: aload_1
    //   349: athrow
    //   350: astore_1
    //   351: aload 5
    //   353: astore_0
    //   354: goto -15 -> 339
    //   357: astore_2
    //   358: aload_1
    //   359: astore 6
    //   361: aload_2
    //   362: astore_1
    //   363: goto -24 -> 339
    //   366: astore_1
    //   367: aconst_null
    //   368: astore_0
    //   369: aload 8
    //   371: astore_2
    //   372: goto -66 -> 306
    //   375: astore_1
    //   376: aload 8
    //   378: astore_2
    //   379: goto -73 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	paramContext	Context
    //   0	382	1	paramString1	String
    //   0	382	2	paramString2	String
    //   281	12	3	i	int
    //   139	30	4	bool	boolean
    //   26	264	5	localObject1	Object
    //   299	5	5	localException	java.lang.Exception
    //   310	42	5	localContext	Context
    //   1	359	6	localObject2	Object
    //   19	95	7	str	String
    //   7	370	8	localObject3	Object
    //   4	249	9	localObject4	Object
    //   78	30	10	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   268	275	299	java/lang/Exception
    //   275	282	299	java/lang/Exception
    //   288	296	299	java/lang/Exception
    //   9	18	336	finally
    //   28	38	350	finally
    //   45	60	350	finally
    //   67	80	350	finally
    //   87	97	350	finally
    //   107	122	350	finally
    //   129	138	350	finally
    //   148	155	350	finally
    //   162	168	350	finally
    //   189	193	350	finally
    //   203	212	350	finally
    //   219	226	350	finally
    //   233	238	350	finally
    //   245	252	350	finally
    //   259	268	350	finally
    //   312	316	350	finally
    //   268	275	357	finally
    //   275	282	357	finally
    //   288	296	357	finally
    //   9	18	366	java/lang/Exception
    //   28	38	375	java/lang/Exception
    //   45	60	375	java/lang/Exception
    //   67	80	375	java/lang/Exception
    //   87	97	375	java/lang/Exception
    //   107	122	375	java/lang/Exception
    //   129	138	375	java/lang/Exception
    //   148	155	375	java/lang/Exception
    //   162	168	375	java/lang/Exception
    //   189	193	375	java/lang/Exception
    //   203	212	375	java/lang/Exception
    //   219	226	375	java/lang/Exception
    //   233	238	375	java/lang/Exception
    //   245	252	375	java/lang/Exception
    //   259	268	375	java/lang/Exception
  }
  
  /* Error */
  public static android.graphics.Bitmap getBitmapFromAsset(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 23	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 29	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   15: astore_2
    //   16: aload_1
    //   17: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_2
    //   23: aconst_null
    //   24: astore_1
    //   25: aload_1
    //   26: astore_0
    //   27: aload_2
    //   28: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   31: aload_1
    //   32: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   35: aconst_null
    //   36: areturn
    //   37: astore_0
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_0
    //   41: astore_1
    //   42: aload_2
    //   43: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   46: aload_1
    //   47: athrow
    //   48: astore_1
    //   49: aload_0
    //   50: astore_2
    //   51: goto -9 -> 42
    //   54: astore_2
    //   55: goto -30 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramContext	Context
    //   0	58	1	paramString	String
    //   15	6	2	localBitmap	android.graphics.Bitmap
    //   22	6	2	localException1	java.lang.Exception
    //   39	12	2	localObject	Object
    //   54	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	9	22	java/lang/Exception
    //   0	9	37	finally
    //   11	16	48	finally
    //   27	31	48	finally
    //   11	16	54	java/lang/Exception
  }
  
  /* Error */
  public static android.graphics.drawable.Drawable getDrawableFromAsset(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 23	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 29	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: aconst_null
    //   13: invokestatic 123	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   16: astore_2
    //   17: aload_1
    //   18: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   21: aload_2
    //   22: areturn
    //   23: astore_2
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: aload_2
    //   29: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   32: aload_1
    //   33: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   36: aconst_null
    //   37: areturn
    //   38: astore_0
    //   39: aconst_null
    //   40: astore_2
    //   41: aload_0
    //   42: astore_1
    //   43: aload_2
    //   44: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   47: aload_1
    //   48: athrow
    //   49: astore_1
    //   50: aload_0
    //   51: astore_2
    //   52: goto -9 -> 43
    //   55: astore_2
    //   56: goto -30 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramContext	Context
    //   0	59	1	paramString	String
    //   16	6	2	localDrawable	android.graphics.drawable.Drawable
    //   23	6	2	localException1	java.lang.Exception
    //   40	12	2	localObject	Object
    //   55	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	9	23	java/lang/Exception
    //   0	9	38	finally
    //   11	17	49	finally
    //   28	32	49	finally
    //   11	17	55	java/lang/Exception
  }
  
  public static String readAssetsByName(Context paramContext, String paramString)
  {
    return readAssetsByName(paramContext, paramString, "UTF-8");
  }
  
  /* Error */
  public static String readAssetsByName(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 130	java/io/InputStreamReader
    //   6: dup
    //   7: aload_0
    //   8: invokevirtual 23	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   11: aload_1
    //   12: invokevirtual 29	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   15: aload_2
    //   16: invokespecial 133	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   19: astore_3
    //   20: new 135	java/io/BufferedReader
    //   23: dup
    //   24: aload_3
    //   25: invokespecial 138	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_0
    //   29: new 50	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   36: astore_1
    //   37: aload_0
    //   38: invokevirtual 141	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +38 -> 83
    //   48: aload_1
    //   49: aload 4
    //   51: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: goto -18 -> 37
    //   58: astore_2
    //   59: aload_3
    //   60: astore_1
    //   61: aload_2
    //   62: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   65: iconst_2
    //   66: anewarray 143	java/io/Closeable
    //   69: dup
    //   70: iconst_0
    //   71: aload_0
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: aload_1
    //   76: aastore
    //   77: invokestatic 146	com/tencent/falco/utils/IOUtil:close	([Ljava/io/Closeable;)V
    //   80: ldc 61
    //   82: areturn
    //   83: new 36	java/lang/String
    //   86: dup
    //   87: aload_1
    //   88: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: aload_2
    //   92: invokevirtual 150	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   95: aload_2
    //   96: invokespecial 153	java/lang/String:<init>	([BLjava/lang/String;)V
    //   99: astore_1
    //   100: iconst_2
    //   101: anewarray 143	java/io/Closeable
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_3
    //   111: aastore
    //   112: invokestatic 146	com/tencent/falco/utils/IOUtil:close	([Ljava/io/Closeable;)V
    //   115: aload_1
    //   116: areturn
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_3
    //   122: iconst_2
    //   123: anewarray 143	java/io/Closeable
    //   126: dup
    //   127: iconst_0
    //   128: aload_0
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: aload_3
    //   133: aastore
    //   134: invokestatic 146	com/tencent/falco/utils/IOUtil:close	([Ljava/io/Closeable;)V
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_0
    //   142: goto -20 -> 122
    //   145: astore_1
    //   146: goto -24 -> 122
    //   149: astore_2
    //   150: aload_1
    //   151: astore_3
    //   152: aload_2
    //   153: astore_1
    //   154: goto -32 -> 122
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_0
    //   160: aload 4
    //   162: astore_1
    //   163: goto -102 -> 61
    //   166: astore_2
    //   167: aconst_null
    //   168: astore_0
    //   169: aload_3
    //   170: astore_1
    //   171: goto -110 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramContext	Context
    //   0	174	1	paramString1	String
    //   0	174	2	paramString2	String
    //   19	151	3	localObject	Object
    //   1	160	4	str	String
    // Exception table:
    //   from	to	target	type
    //   29	37	58	java/lang/Exception
    //   37	43	58	java/lang/Exception
    //   48	55	58	java/lang/Exception
    //   83	100	58	java/lang/Exception
    //   3	20	117	finally
    //   20	29	139	finally
    //   29	37	145	finally
    //   37	43	145	finally
    //   48	55	145	finally
    //   83	100	145	finally
    //   61	65	149	finally
    //   3	20	157	java/lang/Exception
    //   20	29	166	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.AssetsResUtil
 * JD-Core Version:    0.7.0.1
 */