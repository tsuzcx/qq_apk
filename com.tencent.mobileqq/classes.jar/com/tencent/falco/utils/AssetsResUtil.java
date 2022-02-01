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
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: invokevirtual 23	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_1
    //   11: invokevirtual 29	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_0
    //   15: aload_1
    //   16: getstatic 34	java/io/File:separator	Ljava/lang/String;
    //   19: invokevirtual 40	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   22: istore 5
    //   24: iconst_1
    //   25: istore 4
    //   27: aload_1
    //   28: astore 6
    //   30: iload 5
    //   32: ifeq +18 -> 50
    //   35: aload_1
    //   36: aload_1
    //   37: getstatic 34	java/io/File:separator	Ljava/lang/String;
    //   40: invokevirtual 44	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   43: iconst_1
    //   44: iadd
    //   45: invokevirtual 48	java/lang/String:substring	(I)Ljava/lang/String;
    //   48: astore 6
    //   50: new 50	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   57: astore 8
    //   59: aload 8
    //   61: aload_2
    //   62: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: getstatic 34	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 59	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   73: ifeq +9 -> 82
    //   76: ldc 61
    //   78: astore_1
    //   79: goto +7 -> 86
    //   82: getstatic 34	java/io/File:separator	Ljava/lang/String;
    //   85: astore_1
    //   86: aload 8
    //   88: aload_1
    //   89: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 8
    //   95: aload 6
    //   97: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 8
    //   103: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: astore_1
    //   107: new 31	java/io/File
    //   110: dup
    //   111: aload_2
    //   112: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: astore_2
    //   116: aload_2
    //   117: invokevirtual 72	java/io/File:exists	()Z
    //   120: ifne +9 -> 129
    //   123: aload_2
    //   124: invokevirtual 75	java/io/File:mkdirs	()Z
    //   127: istore 4
    //   129: iload 4
    //   131: ifne +12 -> 143
    //   134: aload_0
    //   135: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   138: aconst_null
    //   139: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   142: return
    //   143: new 31	java/io/File
    //   146: dup
    //   147: aload_1
    //   148: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 72	java/io/File:exists	()Z
    //   156: ifeq +8 -> 164
    //   159: aload_1
    //   160: invokevirtual 84	java/io/File:delete	()Z
    //   163: pop
    //   164: aload_1
    //   165: invokevirtual 87	java/io/File:createNewFile	()Z
    //   168: ifeq +57 -> 225
    //   171: new 89	java/io/FileOutputStream
    //   174: dup
    //   175: aload_1
    //   176: invokespecial 92	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   179: astore_1
    //   180: sipush 1024
    //   183: newarray byte
    //   185: astore 6
    //   187: aload_0
    //   188: aload 6
    //   190: invokevirtual 98	java/io/InputStream:read	([B)I
    //   193: istore_3
    //   194: aload_1
    //   195: astore_2
    //   196: iload_3
    //   197: ifle +30 -> 227
    //   200: aload_1
    //   201: aload 6
    //   203: iconst_0
    //   204: iload_3
    //   205: invokevirtual 104	java/io/OutputStream:write	([BII)V
    //   208: goto -21 -> 187
    //   211: astore 6
    //   213: aload_0
    //   214: astore_2
    //   215: aload 6
    //   217: astore_0
    //   218: goto +72 -> 290
    //   221: astore_2
    //   222: goto +48 -> 270
    //   225: aconst_null
    //   226: astore_2
    //   227: aload_0
    //   228: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   231: aload_2
    //   232: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   235: return
    //   236: astore 6
    //   238: aload 7
    //   240: astore_1
    //   241: aload_0
    //   242: astore_2
    //   243: aload 6
    //   245: astore_0
    //   246: goto +44 -> 290
    //   249: astore_2
    //   250: aconst_null
    //   251: astore_1
    //   252: goto +18 -> 270
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_2
    //   258: aload 7
    //   260: astore_1
    //   261: goto +29 -> 290
    //   264: astore_2
    //   265: aconst_null
    //   266: astore_1
    //   267: aload 6
    //   269: astore_0
    //   270: aload_2
    //   271: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   274: aload_0
    //   275: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   278: aload_1
    //   279: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   282: return
    //   283: astore 6
    //   285: aload_0
    //   286: astore_2
    //   287: aload 6
    //   289: astore_0
    //   290: aload_2
    //   291: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   294: aload_1
    //   295: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   298: goto +5 -> 303
    //   301: aload_0
    //   302: athrow
    //   303: goto -2 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramContext	Context
    //   0	306	1	paramString1	String
    //   0	306	2	paramString2	String
    //   193	12	3	i	int
    //   25	105	4	bool1	boolean
    //   22	9	5	bool2	boolean
    //   4	198	6	localObject1	Object
    //   211	5	6	localObject2	Object
    //   236	32	6	localObject3	Object
    //   283	5	6	localObject4	Object
    //   1	258	7	localObject5	Object
    //   57	45	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   180	187	211	finally
    //   187	194	211	finally
    //   200	208	211	finally
    //   180	187	221	java/lang/Exception
    //   187	194	221	java/lang/Exception
    //   200	208	221	java/lang/Exception
    //   15	24	236	finally
    //   35	50	236	finally
    //   50	76	236	finally
    //   82	86	236	finally
    //   86	116	236	finally
    //   116	129	236	finally
    //   143	164	236	finally
    //   164	180	236	finally
    //   15	24	249	java/lang/Exception
    //   35	50	249	java/lang/Exception
    //   50	76	249	java/lang/Exception
    //   82	86	249	java/lang/Exception
    //   86	116	249	java/lang/Exception
    //   116	129	249	java/lang/Exception
    //   143	164	249	java/lang/Exception
    //   164	180	249	java/lang/Exception
    //   6	15	255	finally
    //   6	15	264	java/lang/Exception
    //   270	274	283	finally
  }
  
  /* Error */
  public static android.graphics.Bitmap getBitmapFromAsset(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 23	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: aload_1
    //   7: invokevirtual 29	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   17: astore_2
    //   18: aload_2
    //   19: astore_1
    //   20: goto +24 -> 44
    //   23: astore_2
    //   24: goto +12 -> 36
    //   27: astore_0
    //   28: aconst_null
    //   29: astore_1
    //   30: goto +21 -> 51
    //   33: astore_2
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_0
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   42: aload_3
    //   43: astore_1
    //   44: aload_0
    //   45: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   48: aload_1
    //   49: areturn
    //   50: astore_0
    //   51: aload_1
    //   52: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramContext	Context
    //   0	57	1	paramString	String
    //   17	2	2	localBitmap	android.graphics.Bitmap
    //   23	1	2	localException1	java.lang.Exception
    //   33	6	2	localException2	java.lang.Exception
    //   1	42	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	18	23	java/lang/Exception
    //   2	11	27	finally
    //   2	11	33	java/lang/Exception
    //   13	18	50	finally
    //   38	42	50	finally
  }
  
  /* Error */
  public static android.graphics.drawable.Drawable getDrawableFromAsset(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 23	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: aload_1
    //   7: invokevirtual 29	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: aconst_null
    //   15: invokestatic 123	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: goto +24 -> 45
    //   24: astore_2
    //   25: goto +12 -> 37
    //   28: astore_0
    //   29: aconst_null
    //   30: astore_1
    //   31: goto +21 -> 52
    //   34: astore_2
    //   35: aconst_null
    //   36: astore_0
    //   37: aload_0
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   43: aload_3
    //   44: astore_1
    //   45: aload_0
    //   46: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   49: aload_1
    //   50: areturn
    //   51: astore_0
    //   52: aload_1
    //   53: invokestatic 81	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramContext	Context
    //   0	58	1	paramString	String
    //   18	2	2	localDrawable	android.graphics.drawable.Drawable
    //   24	1	2	localException1	java.lang.Exception
    //   34	6	2	localException2	java.lang.Exception
    //   1	43	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	19	24	java/lang/Exception
    //   2	11	28	finally
    //   2	11	34	java/lang/Exception
    //   13	19	51	finally
    //   39	43	51	finally
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
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: new 130	java/io/InputStreamReader
    //   8: dup
    //   9: aload_0
    //   10: invokevirtual 23	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_1
    //   14: invokevirtual 29	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: aload_2
    //   18: invokespecial 133	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: astore_1
    //   24: new 135	java/io/BufferedReader
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 138	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   32: astore 4
    //   34: new 50	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   41: astore_1
    //   42: aload 4
    //   44: invokevirtual 141	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +12 -> 61
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: goto -16 -> 42
    //   61: new 36	java/lang/String
    //   64: dup
    //   65: aload_1
    //   66: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: aload_2
    //   70: invokevirtual 145	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   73: aload_2
    //   74: invokespecial 148	java/lang/String:<init>	([BLjava/lang/String;)V
    //   77: astore_1
    //   78: iconst_2
    //   79: anewarray 150	java/io/Closeable
    //   82: dup
    //   83: iconst_0
    //   84: aload 4
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: aload_0
    //   90: aastore
    //   91: invokestatic 153	com/tencent/falco/utils/IOUtil:close	([Ljava/io/Closeable;)V
    //   94: aload_1
    //   95: areturn
    //   96: astore_3
    //   97: aload 4
    //   99: astore_2
    //   100: goto +70 -> 170
    //   103: astore_1
    //   104: aload 4
    //   106: astore_2
    //   107: aload_1
    //   108: astore 4
    //   110: goto +26 -> 136
    //   113: astore 4
    //   115: aload 5
    //   117: astore_2
    //   118: goto +18 -> 136
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: astore_0
    //   126: goto +44 -> 170
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_0
    //   133: aload 5
    //   135: astore_2
    //   136: aload_2
    //   137: astore_3
    //   138: aload_0
    //   139: astore_1
    //   140: aload 4
    //   142: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   145: iconst_2
    //   146: anewarray 150	java/io/Closeable
    //   149: dup
    //   150: iconst_0
    //   151: aload_2
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: aload_0
    //   156: aastore
    //   157: invokestatic 153	com/tencent/falco/utils/IOUtil:close	([Ljava/io/Closeable;)V
    //   160: ldc 61
    //   162: areturn
    //   163: astore_0
    //   164: aload_3
    //   165: astore_2
    //   166: aload_0
    //   167: astore_3
    //   168: aload_1
    //   169: astore_0
    //   170: iconst_2
    //   171: anewarray 150	java/io/Closeable
    //   174: dup
    //   175: iconst_0
    //   176: aload_2
    //   177: aastore
    //   178: dup
    //   179: iconst_1
    //   180: aload_0
    //   181: aastore
    //   182: invokestatic 153	com/tencent/falco/utils/IOUtil:close	([Ljava/io/Closeable;)V
    //   185: goto +5 -> 190
    //   188: aload_3
    //   189: athrow
    //   190: goto -2 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramContext	Context
    //   0	193	1	paramString1	String
    //   0	193	2	paramString2	String
    //   1	53	3	str	String
    //   96	1	3	localObject1	Object
    //   121	1	3	localObject2	Object
    //   137	52	3	localObject3	Object
    //   32	77	4	localObject4	Object
    //   113	1	4	localException1	java.lang.Exception
    //   129	12	4	localException2	java.lang.Exception
    //   3	131	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   34	42	96	finally
    //   42	48	96	finally
    //   52	58	96	finally
    //   61	78	96	finally
    //   34	42	103	java/lang/Exception
    //   42	48	103	java/lang/Exception
    //   52	58	103	java/lang/Exception
    //   61	78	103	java/lang/Exception
    //   24	34	113	java/lang/Exception
    //   5	22	121	finally
    //   5	22	129	java/lang/Exception
    //   24	34	163	finally
    //   140	145	163	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.AssetsResUtil
 * JD-Core Version:    0.7.0.1
 */