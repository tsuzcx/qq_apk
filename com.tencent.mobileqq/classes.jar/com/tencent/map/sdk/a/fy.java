package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import java.io.ByteArrayOutputStream;

public final class fy
{
  protected static Paint a;
  public static fy.a b;
  private static final String c = Bitmap.class.getCanonicalName();
  private static byte[] d;
  
  static
  {
    b = null;
    Paint localPaint = new Paint();
    a = localPaint;
    localPaint.setAntiAlias(true);
  }
  
  private static Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label9:
      label18:
      break label9;
    }
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return paramConfig;
    }
    catch (OutOfMemoryError paramConfig)
    {
      break label18;
    }
    return null;
  }
  
  public static Bitmap a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      label11:
      break label11;
    }
    return null;
  }
  
  /* Error */
  public static final Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: ifnull +168 -> 173
    //   8: aload_1
    //   9: invokevirtual 65	java/lang/String:trim	()Ljava/lang/String;
    //   12: invokevirtual 69	java/lang/String:length	()I
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_1
    //   21: invokevirtual 65	java/lang/String:trim	()Ljava/lang/String;
    //   24: iconst_0
    //   25: invokevirtual 73	java/lang/String:charAt	(I)C
    //   28: bipush 47
    //   30: if_icmpeq +46 -> 76
    //   33: new 75	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   40: astore 4
    //   42: aload 4
    //   44: aload_0
    //   45: invokevirtual 80	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 4
    //   54: ldc 86
    //   56: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 4
    //   62: aload_1
    //   63: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 4
    //   69: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_0
    //   73: goto +35 -> 108
    //   76: new 75	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   83: astore 4
    //   85: aload 4
    //   87: aload_0
    //   88: invokevirtual 80	android/content/Context:getFilesDir	()Ljava/io/File;
    //   91: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 4
    //   97: aload_1
    //   98: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 4
    //   104: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore_0
    //   108: new 94	java/io/FileInputStream
    //   111: dup
    //   112: aload_0
    //   113: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   116: astore_0
    //   117: aload_0
    //   118: astore_1
    //   119: aload_0
    //   120: invokestatic 101	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   123: astore_2
    //   124: aload_2
    //   125: astore_1
    //   126: aload_0
    //   127: invokevirtual 106	java/io/InputStream:close	()V
    //   130: aload_1
    //   131: areturn
    //   132: astore_2
    //   133: goto +12 -> 145
    //   136: astore_0
    //   137: aload_2
    //   138: astore_1
    //   139: goto +24 -> 163
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_0
    //   145: aload_0
    //   146: astore_1
    //   147: aload_2
    //   148: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   151: aload_0
    //   152: ifnull +8 -> 160
    //   155: aload_3
    //   156: astore_1
    //   157: goto -31 -> 126
    //   160: aconst_null
    //   161: areturn
    //   162: astore_0
    //   163: aload_1
    //   164: ifnull +7 -> 171
    //   167: aload_1
    //   168: invokevirtual 106	java/io/InputStream:close	()V
    //   171: aload_0
    //   172: athrow
    //   173: aconst_null
    //   174: areturn
    //   175: astore_0
    //   176: aload_1
    //   177: areturn
    //   178: astore_1
    //   179: goto -8 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramContext	Context
    //   0	182	1	paramString	String
    //   1	124	2	localBitmap	Bitmap
    //   132	6	2	localException1	java.lang.Exception
    //   142	6	2	localException2	java.lang.Exception
    //   3	153	3	localObject	Object
    //   40	63	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   119	124	132	java/lang/Exception
    //   8	18	136	finally
    //   20	73	136	finally
    //   76	108	136	finally
    //   108	117	136	finally
    //   8	18	142	java/lang/Exception
    //   20	73	142	java/lang/Exception
    //   76	108	142	java/lang/Exception
    //   108	117	142	java/lang/Exception
    //   119	124	162	finally
    //   147	151	162	finally
    //   126	130	175	java/lang/Exception
    //   167	171	178	java/lang/Exception
  }
  
  public static Bitmap a(Bitmap paramBitmap, Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (paramInt1 > 0))
    {
      if (paramInt2 <= 0) {
        return null;
      }
      int i = paramInt1;
      if (paramInt1 > 2048) {
        i = 2048;
      }
      paramInt1 = paramInt2;
      if (paramInt2 > 2048) {
        paramInt1 = 2048;
      }
      Bitmap localBitmap = a(i, paramInt1, Bitmap.Config.ARGB_8888);
      if (localBitmap == null) {
        return null;
      }
      localBitmap.eraseColor(0);
      Canvas localCanvas = new Canvas(localBitmap);
      paramBitmap = new BitmapDrawable(paramContext.getResources(), paramBitmap);
      paramBitmap.setBounds(0, 0, i, paramInt1);
      paramBitmap.draw(localCanvas);
      return localBitmap;
    }
    return null;
  }
  
  public static Bitmap a(View paramView)
  {
    if (paramView != null) {}
    for (;;)
    {
      try
      {
        try
        {
          paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
          paramView.setDrawingCacheEnabled(true);
          paramView.buildDrawingCache();
          Bitmap localBitmap2 = paramView.getDrawingCache();
          if ((localBitmap2 == null) || (localBitmap2.isRecycled())) {
            break label201;
          }
          int i = localBitmap2.getWidth();
          int j = localBitmap2.getHeight();
          if ((localBitmap2 == null) || (localBitmap2.isRecycled()) || (i <= 0) || (j <= 0)) {
            break label201;
          }
          Bitmap localBitmap1 = a(i, j, Bitmap.Config.ARGB_8888);
          if (localBitmap1 == null) {
            break label201;
          }
          localBitmap1.setDensity(localBitmap2.getDensity());
          Canvas localCanvas = new Canvas(localBitmap1);
          localBitmap1.eraseColor(0);
          localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, a);
          paramView.destroyDrawingCache();
          return localBitmap1;
        }
        finally {}
        return null;
      }
      catch (Throwable paramView)
      {
        localStringBuilder = new StringBuilder("BitmapUtil.convertToBitmap errorDetail:");
        localStringBuilder.append(Log.getStackTraceString(paramView));
        Log.e("BitmapUtil", localStringBuilder.toString());
      }
      label201:
      StringBuilder localStringBuilder = null;
    }
  }
  
  public static final Bitmap a(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public static Drawable a(Bitmap paramBitmap)
  {
    return new BitmapDrawable(paramBitmap);
  }
  
  public static byte[] a()
  {
    if (d == null)
    {
      Bitmap localBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawARGB(0, 255, 255, 255);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      d = localByteArrayOutputStream.toByteArray();
    }
    return d;
  }
  
  /* Error */
  public static final Bitmap b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 75	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokestatic 248	com/tencent/tencentmap/io/QStorageManager:getInstance	(Landroid/content/Context;)Lcom/tencent/tencentmap/io/QStorageManager;
    //   13: invokevirtual 251	com/tencent/tencentmap/io/QStorageManager:getAssetsDynamicPath	()Ljava/lang/String;
    //   16: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_2
    //   21: aload_1
    //   22: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_2
    //   27: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 256	com/tencent/map/sdk/a/on:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   33: astore 4
    //   35: aload 4
    //   37: astore_2
    //   38: aload 4
    //   40: ifnonnull +195 -> 235
    //   43: aload 4
    //   45: astore_3
    //   46: aload 4
    //   48: astore 5
    //   50: aload 4
    //   52: astore 6
    //   54: getstatic 260	com/tencent/map/sdk/a/gd:a	Ljava/lang/String;
    //   57: ifnull +81 -> 138
    //   60: aload 4
    //   62: astore_3
    //   63: aload 4
    //   65: astore 5
    //   67: aload 4
    //   69: astore 6
    //   71: new 75	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   78: astore_2
    //   79: aload 4
    //   81: astore_3
    //   82: aload 4
    //   84: astore 5
    //   86: aload 4
    //   88: astore 6
    //   90: aload_2
    //   91: getstatic 260	com/tencent/map/sdk/a/gd:a	Ljava/lang/String;
    //   94: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 4
    //   100: astore_3
    //   101: aload 4
    //   103: astore 5
    //   105: aload 4
    //   107: astore 6
    //   109: aload_2
    //   110: aload_1
    //   111: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: astore_3
    //   118: aload 4
    //   120: astore 5
    //   122: aload 4
    //   124: astore 6
    //   126: aload_0
    //   127: aload_2
    //   128: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 263	com/tencent/map/sdk/a/gd:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   134: astore_2
    //   135: goto +100 -> 235
    //   138: aload 4
    //   140: astore_2
    //   141: aload 4
    //   143: astore_3
    //   144: aload 4
    //   146: astore 5
    //   148: aload 4
    //   150: astore 6
    //   152: getstatic 265	com/tencent/map/sdk/a/gd:b	Ljava/lang/String;
    //   155: ifnull +80 -> 235
    //   158: aload 4
    //   160: astore_3
    //   161: aload 4
    //   163: astore 5
    //   165: aload 4
    //   167: astore 6
    //   169: new 75	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   176: astore_2
    //   177: aload 4
    //   179: astore_3
    //   180: aload 4
    //   182: astore 5
    //   184: aload 4
    //   186: astore 6
    //   188: aload_2
    //   189: getstatic 265	com/tencent/map/sdk/a/gd:b	Ljava/lang/String;
    //   192: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 4
    //   198: astore_3
    //   199: aload 4
    //   201: astore 5
    //   203: aload 4
    //   205: astore 6
    //   207: aload_2
    //   208: aload_1
    //   209: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 4
    //   215: astore_3
    //   216: aload 4
    //   218: astore 5
    //   220: aload 4
    //   222: astore 6
    //   224: aload_2
    //   225: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 256	com/tencent/map/sdk/a/on:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   231: astore_2
    //   232: goto +3 -> 235
    //   235: aload_2
    //   236: ifnonnull +29 -> 265
    //   239: aload_2
    //   240: astore_3
    //   241: aload_2
    //   242: astore 5
    //   244: aload_2
    //   245: astore 6
    //   247: aload_0
    //   248: ldc_w 267
    //   251: aload_1
    //   252: invokestatic 271	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   255: invokevirtual 275	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   258: invokestatic 263	com/tencent/map/sdk/a/gd:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   261: astore_0
    //   262: goto +5 -> 267
    //   265: aload_2
    //   266: astore_0
    //   267: aload_0
    //   268: invokestatic 101	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   271: astore_1
    //   272: aload_0
    //   273: invokestatic 278	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   276: aload_1
    //   277: areturn
    //   278: astore_1
    //   279: aload_0
    //   280: astore_3
    //   281: aload_1
    //   282: astore_0
    //   283: goto +37 -> 320
    //   286: goto +15 -> 301
    //   289: astore_1
    //   290: goto +20 -> 310
    //   293: astore_0
    //   294: aconst_null
    //   295: astore_3
    //   296: goto +24 -> 320
    //   299: aconst_null
    //   300: astore_0
    //   301: aload_0
    //   302: invokestatic 278	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   305: aconst_null
    //   306: areturn
    //   307: astore_1
    //   308: aconst_null
    //   309: astore_0
    //   310: aload_0
    //   311: astore_3
    //   312: aload_1
    //   313: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   316: goto -15 -> 301
    //   319: astore_0
    //   320: aload_3
    //   321: invokestatic 278	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   324: goto +5 -> 329
    //   327: aload_0
    //   328: athrow
    //   329: goto -2 -> 327
    //   332: astore_0
    //   333: goto -34 -> 299
    //   336: astore_0
    //   337: aload 5
    //   339: astore_0
    //   340: goto -39 -> 301
    //   343: astore_1
    //   344: goto -58 -> 286
    //   347: astore_1
    //   348: aload 6
    //   350: astore_0
    //   351: goto -41 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramContext	Context
    //   0	354	1	paramString	String
    //   7	259	2	localObject1	Object
    //   45	276	3	localObject2	Object
    //   33	188	4	localInputStream	java.io.InputStream
    //   48	290	5	localObject3	Object
    //   52	297	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   267	272	278	finally
    //   267	272	289	java/lang/Exception
    //   0	35	293	finally
    //   0	35	307	java/lang/Exception
    //   54	60	319	finally
    //   71	79	319	finally
    //   90	98	319	finally
    //   109	115	319	finally
    //   126	135	319	finally
    //   152	158	319	finally
    //   169	177	319	finally
    //   188	196	319	finally
    //   207	213	319	finally
    //   224	232	319	finally
    //   247	262	319	finally
    //   312	316	319	finally
    //   0	35	332	java/lang/OutOfMemoryError
    //   54	60	336	java/lang/OutOfMemoryError
    //   71	79	336	java/lang/OutOfMemoryError
    //   90	98	336	java/lang/OutOfMemoryError
    //   109	115	336	java/lang/OutOfMemoryError
    //   126	135	336	java/lang/OutOfMemoryError
    //   152	158	336	java/lang/OutOfMemoryError
    //   169	177	336	java/lang/OutOfMemoryError
    //   188	196	336	java/lang/OutOfMemoryError
    //   207	213	336	java/lang/OutOfMemoryError
    //   224	232	336	java/lang/OutOfMemoryError
    //   247	262	336	java/lang/OutOfMemoryError
    //   267	272	343	java/lang/OutOfMemoryError
    //   54	60	347	java/lang/Exception
    //   71	79	347	java/lang/Exception
    //   90	98	347	java/lang/Exception
    //   109	115	347	java/lang/Exception
    //   126	135	347	java/lang/Exception
    //   152	158	347	java/lang/Exception
    //   169	177	347	java/lang/Exception
    //   188	196	347	java/lang/Exception
    //   207	213	347	java/lang/Exception
    //   224	232	347	java/lang/Exception
    //   247	262	347	java/lang/Exception
  }
  
  public static final Bitmap b(Bitmap paramBitmap)
  {
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  /* Error */
  public static final Bitmap c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 285	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore_0
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 290	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_0
    //   13: aload_0
    //   14: invokestatic 101	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   17: astore_1
    //   18: goto +20 -> 38
    //   21: astore_1
    //   22: goto +6 -> 28
    //   25: astore_1
    //   26: aconst_null
    //   27: astore_0
    //   28: aload_0
    //   29: invokestatic 278	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   32: aload_1
    //   33: athrow
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_2
    //   37: astore_1
    //   38: aload_0
    //   39: invokestatic 278	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   42: aload_1
    //   43: areturn
    //   44: aconst_null
    //   45: astore_0
    //   46: aload_0
    //   47: invokestatic 278	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   50: aconst_null
    //   51: areturn
    //   52: astore_0
    //   53: goto -9 -> 44
    //   56: astore_0
    //   57: goto -23 -> 34
    //   60: astore_1
    //   61: goto -15 -> 46
    //   64: astore_1
    //   65: aload_2
    //   66: astore_1
    //   67: goto -29 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramContext	Context
    //   0	70	1	paramString	String
    //   6	60	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	18	21	finally
    //   7	13	25	finally
    //   7	13	52	java/lang/Exception
    //   7	13	56	java/lang/OutOfMemoryError
    //   13	18	60	java/lang/Exception
    //   13	18	64	java/lang/OutOfMemoryError
  }
  
  public static Bitmap c(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    int i;
    int j;
    if (paramBitmap != null)
    {
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      i = (int)(f1 / fz.f);
      j = (int)(f2 / fz.f);
    }
    try
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      label45:
      break label45;
    }
    localBitmap = null;
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.fy
 * JD-Core Version:    0.7.0.1
 */