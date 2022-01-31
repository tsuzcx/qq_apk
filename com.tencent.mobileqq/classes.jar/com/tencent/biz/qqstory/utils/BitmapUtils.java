package com.tencent.biz.qqstory.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.SafeBitmapFactory;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BitmapUtils
{
  private static Bitmap.Config a(Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    paramBitmap = localConfig;
    if (localConfig == null) {
      paramBitmap = Bitmap.Config.ARGB_8888;
    }
    return paramBitmap;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return paramConfig;
    }
    catch (OutOfMemoryError paramConfig)
    {
      SLog.c("BitmapUtils", "OutOfMemoryError", paramConfig);
      Dispatchers.get().dispatch(new BitmapUtils.OutOfMemHandleCommand());
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      localBitmap = null;
    }
    int i;
    int j;
    do
    {
      return localBitmap;
      i = Math.round(paramBitmap.getWidth() * paramFloat);
      j = Math.round(paramBitmap.getHeight() * paramFloat);
      if (i != paramBitmap.getWidth()) {
        break;
      }
      localBitmap = paramBitmap;
    } while (j == paramBitmap.getHeight());
    Bitmap localBitmap = a(i, j, a(paramBitmap), false);
    if (localBitmap == null) {
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.scale(paramFloat, paramFloat);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(6));
    if (paramBoolean) {
      a(paramBitmap);
    }
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt % 360 != 0)
    {
      SLog.d("BitmapUtils", "generateOrientation begin!");
      long l = System.currentTimeMillis();
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.reset();
      localMatrix.postRotate(paramInt);
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      SLog.d("BitmapUtils", "generateOrientation end, cost:" + (System.currentTimeMillis() - l) / 1000.0D);
      return paramBitmap;
    }
    return Bitmap.createBitmap(paramBitmap);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      localBitmap = null;
    }
    do
    {
      return localBitmap;
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
      if (i != paramInt1) {
        break;
      }
      localBitmap = paramBitmap;
    } while (j == paramInt2);
    float f = Math.max(paramInt1 / i, paramInt2 / j);
    Bitmap localBitmap = a(paramInt1, paramInt2, a(paramBitmap), false);
    if (localBitmap == null) {
      return null;
    }
    int i = Math.round(paramBitmap.getWidth() * f);
    int j = Math.round(paramBitmap.getHeight() * f);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.translate((paramInt1 - i) / 2.0F, (paramInt2 - j) / 2.0F);
    localCanvas.scale(f, f);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(6));
    if (paramBoolean) {
      a(paramBitmap);
    }
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i == paramInt1) && (j == paramInt2)) {
      return paramBitmap;
    }
    Object localObject2 = paramBitmap.getConfig();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Bitmap.Config.ARGB_8888;
    }
    localObject2 = a(paramInt1, paramInt2, (Bitmap.Config)localObject1, false);
    if (localObject2 == null) {
      return null;
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject2);
    if (!paramBoolean1) {
      localCanvas.drawColor(-16777216);
    }
    float f = i * 1.0F / j;
    int k;
    int m;
    if (f > paramInt1 * 1.0F / paramInt2)
    {
      k = Math.round(paramInt1 / f);
      m = (paramInt2 - k) / 2;
      f = paramInt2 / 2.0F;
    }
    for (localObject1 = new Rect(0, m, paramInt1, Math.round(k / 2.0F + f));; localObject1 = new Rect(m, 0, Math.round(k / 2.0F + f), paramInt2))
    {
      SLog.c("BitmapUtils", "resizeAndFillBitmapEdge srcWidth=%s, srcHeight=%s, targetWidth=%s, targetHeight=%s, destRect=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject1 });
      localCanvas.drawBitmap(paramBitmap, null, (Rect)localObject1, new Paint(6));
      localCanvas.setBitmap(null);
      if (paramBoolean2) {
        a(paramBitmap);
      }
      return localObject2;
      k = Math.round(f * paramInt2);
      m = (paramInt1 - k) / 2;
      f = paramInt1 / 2.0F;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    try
    {
      int i = paramBitmap1.getWidth();
      int j = paramBitmap1.getHeight();
      Paint localPaint = new Paint();
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, localPaint);
      float f1 = i / paramBitmap2.getWidth();
      float f2 = j / paramBitmap2.getHeight();
      paramBitmap1 = new Matrix();
      paramBitmap1.postScale(f1, f2);
      localCanvas.drawBitmap(Bitmap.createBitmap(paramBitmap2, 0, 0, paramBitmap2.getWidth(), paramBitmap2.getHeight(), paramBitmap1, true), 0.0F, 0.0F, null);
      localCanvas.save(31);
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap1)
    {
      SLog.c("BitmapUtils", paramBitmap1.getMessage(), paramBitmap1);
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, Rect paramRect, boolean paramBoolean)
  {
    if (paramBitmap == null) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = a(paramRect.width(), paramRect.height(), a(paramBitmap), false);
    } while (localBitmap == null);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(6);
    localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), paramRect, localPaint);
    if (paramBoolean) {
      a(paramBitmap);
    }
    return localBitmap;
  }
  
  public static Bitmap a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView);
    int i;
    if (paramInt1 > 0)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {
        break label28;
      }
    }
    for (;;)
    {
      try
      {
        i = paramView.getWidth();
        paramInt1 = paramView.getHeight();
        label28:
        if ((i > 0) && (paramInt1 > 0))
        {
          Bitmap localBitmap = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_4444);
          Canvas localCanvas = new Canvas(localBitmap);
          Matrix localMatrix = new Matrix();
          localMatrix.setTranslate(paramInt3, paramInt4);
          localMatrix.setScale(i / paramView.getWidth(), paramInt1 / paramView.getHeight());
          localCanvas.setMatrix(localMatrix);
          paramView.draw(localCanvas);
          paramView = localBitmap;
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        return null;
      }
      catch (OutOfMemoryError paramView)
      {
        return null;
      }
      paramView = null;
    }
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +7 -> 13
    //   9: aload_2
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: new 235	java/io/BufferedInputStream
    //   16: dup
    //   17: new 237	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 240	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 243	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_0
    //   29: aload_0
    //   30: astore_1
    //   31: aload_0
    //   32: invokestatic 249	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: aload_2
    //   39: astore_1
    //   40: aload_0
    //   41: ifnull -30 -> 11
    //   44: aload_0
    //   45: invokevirtual 252	java/io/BufferedInputStream:close	()V
    //   48: aload_2
    //   49: areturn
    //   50: astore_0
    //   51: ldc 32
    //   53: ldc 254
    //   55: aload_0
    //   56: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: astore_1
    //   66: ldc 32
    //   68: ldc_w 256
    //   71: aload_2
    //   72: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   75: aload_0
    //   76: astore_1
    //   77: aload_2
    //   78: athrow
    //   79: astore_0
    //   80: aload_1
    //   81: ifnull +7 -> 88
    //   84: aload_1
    //   85: invokevirtual 252	java/io/BufferedInputStream:close	()V
    //   88: aload_0
    //   89: athrow
    //   90: astore_1
    //   91: aconst_null
    //   92: astore_0
    //   93: ldc 32
    //   95: ldc_w 258
    //   98: aload_1
    //   99: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: astore_1
    //   104: aload_0
    //   105: ifnull -94 -> 11
    //   108: aload_0
    //   109: invokevirtual 252	java/io/BufferedInputStream:close	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: ldc 32
    //   117: ldc 254
    //   119: aload_0
    //   120: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_1
    //   126: ldc 32
    //   128: ldc 254
    //   130: aload_1
    //   131: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: goto -46 -> 88
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_1
    //   140: goto -60 -> 80
    //   143: astore_2
    //   144: aload_0
    //   145: astore_1
    //   146: aload_2
    //   147: astore_0
    //   148: goto -68 -> 80
    //   151: astore_1
    //   152: goto -59 -> 93
    //   155: astore_2
    //   156: goto -92 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   10	75	1	localObject1	Object
    //   90	9	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   103	1	1	localOutOfMemoryError1	OutOfMemoryError
    //   125	6	1	localIOException	java.io.IOException
    //   139	7	1	str	String
    //   151	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	59	2	localObject2	Object
    //   61	42	2	localOutOfMemoryError2	OutOfMemoryError
    //   143	4	2	localObject3	Object
    //   155	1	2	localOutOfMemoryError3	OutOfMemoryError
    //   35	2	3	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/io/IOException
    //   13	29	61	java/lang/OutOfMemoryError
    //   31	36	79	finally
    //   66	75	79	finally
    //   77	79	79	finally
    //   13	29	90	java/io/FileNotFoundException
    //   108	112	114	java/io/IOException
    //   84	88	125	java/io/IOException
    //   13	29	137	finally
    //   93	102	143	finally
    //   31	36	151	java/io/FileNotFoundException
    //   31	36	155	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static Bitmap a(String paramString, BitmapUtils.ByteArrayRecycler paramByteArrayRecycler)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: aload_0
    //   13: ifnonnull +14 -> 27
    //   16: new 261	java/lang/IllegalArgumentException
    //   19: dup
    //   20: ldc_w 263
    //   23: invokespecial 264	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   26: athrow
    //   27: new 266	java/io/DataInputStream
    //   30: dup
    //   31: new 237	java/io/FileInputStream
    //   34: dup
    //   35: new 268	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 269	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 272	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 273	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore 8
    //   51: aload 5
    //   53: astore 6
    //   55: aload 9
    //   57: astore_0
    //   58: aload 8
    //   60: astore 7
    //   62: aload 8
    //   64: invokevirtual 276	java/io/DataInputStream:readInt	()I
    //   67: istore_2
    //   68: aload 5
    //   70: astore 6
    //   72: aload 9
    //   74: astore_0
    //   75: aload 8
    //   77: astore 7
    //   79: aload 8
    //   81: invokevirtual 276	java/io/DataInputStream:readInt	()I
    //   84: pop
    //   85: iload_2
    //   86: sipush 187
    //   89: if_icmpne +259 -> 348
    //   92: aload 5
    //   94: astore 6
    //   96: aload 9
    //   98: astore_0
    //   99: aload 8
    //   101: astore 7
    //   103: aload 8
    //   105: invokevirtual 280	java/io/DataInputStream:readBoolean	()Z
    //   108: pop
    //   109: aload 5
    //   111: astore 6
    //   113: aload 9
    //   115: astore_0
    //   116: aload 8
    //   118: astore 7
    //   120: invokestatic 284	android/graphics/Bitmap$Config:values	()[Landroid/graphics/Bitmap$Config;
    //   123: aload 8
    //   125: invokevirtual 276	java/io/DataInputStream:readInt	()I
    //   128: aaload
    //   129: astore 10
    //   131: aload 5
    //   133: astore 6
    //   135: aload 9
    //   137: astore_0
    //   138: aload 8
    //   140: astore 7
    //   142: aload 8
    //   144: invokevirtual 276	java/io/DataInputStream:readInt	()I
    //   147: istore_2
    //   148: aload 5
    //   150: astore 6
    //   152: aload 9
    //   154: astore_0
    //   155: aload 8
    //   157: astore 7
    //   159: aload 8
    //   161: invokevirtual 276	java/io/DataInputStream:readInt	()I
    //   164: istore_3
    //   165: aload 5
    //   167: astore 6
    //   169: aload 9
    //   171: astore_0
    //   172: aload 8
    //   174: astore 7
    //   176: aload 8
    //   178: invokevirtual 276	java/io/DataInputStream:readInt	()I
    //   181: pop
    //   182: aload 5
    //   184: astore 6
    //   186: aload 9
    //   188: astore_0
    //   189: aload 8
    //   191: astore 7
    //   193: aload 8
    //   195: invokevirtual 276	java/io/DataInputStream:readInt	()I
    //   198: pop
    //   199: aload 5
    //   201: astore 6
    //   203: aload 9
    //   205: astore_0
    //   206: aload 8
    //   208: astore 7
    //   210: aload 8
    //   212: invokevirtual 276	java/io/DataInputStream:readInt	()I
    //   215: istore 4
    //   217: aload_1
    //   218: ifnull +110 -> 328
    //   221: aload 5
    //   223: astore 6
    //   225: aload 9
    //   227: astore_0
    //   228: aload 8
    //   230: astore 7
    //   232: aload_1
    //   233: iload 4
    //   235: invokevirtual 289	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	(I)[B
    //   238: astore 5
    //   240: aload 5
    //   242: astore 6
    //   244: aload 5
    //   246: astore_0
    //   247: aload 8
    //   249: astore 7
    //   251: aload 8
    //   253: aload 5
    //   255: invokevirtual 293	java/io/DataInputStream:read	([B)I
    //   258: pop
    //   259: aload 5
    //   261: astore 6
    //   263: aload 5
    //   265: astore_0
    //   266: aload 8
    //   268: astore 7
    //   270: iload_2
    //   271: iload_3
    //   272: aload 10
    //   274: invokestatic 30	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   277: astore 9
    //   279: aload 5
    //   281: astore 6
    //   283: aload 5
    //   285: astore_0
    //   286: aload 8
    //   288: astore 7
    //   290: aload 9
    //   292: aload 5
    //   294: invokestatic 299	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   297: invokevirtual 303	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   300: aload_1
    //   301: ifnull +14 -> 315
    //   304: aload 5
    //   306: ifnull +9 -> 315
    //   309: aload_1
    //   310: aload 5
    //   312: invokevirtual 306	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   315: aload 8
    //   317: ifnull +8 -> 325
    //   320: aload 8
    //   322: invokevirtual 307	java/io/DataInputStream:close	()V
    //   325: aload 9
    //   327: areturn
    //   328: aload 5
    //   330: astore 6
    //   332: aload 9
    //   334: astore_0
    //   335: aload 8
    //   337: astore 7
    //   339: iload 4
    //   341: newarray byte
    //   343: astore 5
    //   345: goto -105 -> 240
    //   348: aload 5
    //   350: astore 6
    //   352: aload 9
    //   354: astore_0
    //   355: aload 8
    //   357: astore 7
    //   359: new 227	java/io/IOException
    //   362: dup
    //   363: new 121	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 309
    //   373: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: iload_2
    //   377: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokespecial 313	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   386: athrow
    //   387: astore 5
    //   389: aload 8
    //   391: astore 7
    //   393: aload 6
    //   395: astore_0
    //   396: new 227	java/io/IOException
    //   399: dup
    //   400: ldc_w 315
    //   403: aload 5
    //   405: invokespecial 318	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   408: athrow
    //   409: astore 6
    //   411: aload_0
    //   412: astore 5
    //   414: aload 6
    //   416: astore_0
    //   417: aload_1
    //   418: ifnull +14 -> 432
    //   421: aload 5
    //   423: ifnull +9 -> 432
    //   426: aload_1
    //   427: aload 5
    //   429: invokevirtual 306	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   432: aload 7
    //   434: ifnull +8 -> 442
    //   437: aload 7
    //   439: invokevirtual 307	java/io/DataInputStream:close	()V
    //   442: aload_0
    //   443: athrow
    //   444: astore_0
    //   445: aconst_null
    //   446: astore 6
    //   448: aload 7
    //   450: astore 5
    //   452: aload 6
    //   454: astore 7
    //   456: goto -39 -> 417
    //   459: astore 5
    //   461: aconst_null
    //   462: astore 7
    //   464: aload 6
    //   466: astore_0
    //   467: goto -71 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	paramString	String
    //   0	470	1	paramByteArrayRecycler	BitmapUtils.ByteArrayRecycler
    //   67	310	2	i	int
    //   164	108	3	j	int
    //   215	125	4	k	int
    //   10	339	5	arrayOfByte	byte[]
    //   387	17	5	localOutOfMemoryError1	OutOfMemoryError
    //   412	39	5	localObject1	Object
    //   459	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   1	393	6	localObject2	Object
    //   409	6	6	localObject3	Object
    //   446	19	6	localObject4	Object
    //   7	456	7	localObject5	Object
    //   49	341	8	localDataInputStream	java.io.DataInputStream
    //   4	349	9	localBitmap	Bitmap
    //   129	144	10	localConfig	Bitmap.Config
    // Exception table:
    //   from	to	target	type
    //   62	68	387	java/lang/OutOfMemoryError
    //   79	85	387	java/lang/OutOfMemoryError
    //   103	109	387	java/lang/OutOfMemoryError
    //   120	131	387	java/lang/OutOfMemoryError
    //   142	148	387	java/lang/OutOfMemoryError
    //   159	165	387	java/lang/OutOfMemoryError
    //   176	182	387	java/lang/OutOfMemoryError
    //   193	199	387	java/lang/OutOfMemoryError
    //   210	217	387	java/lang/OutOfMemoryError
    //   232	240	387	java/lang/OutOfMemoryError
    //   251	259	387	java/lang/OutOfMemoryError
    //   270	279	387	java/lang/OutOfMemoryError
    //   290	300	387	java/lang/OutOfMemoryError
    //   339	345	387	java/lang/OutOfMemoryError
    //   359	387	387	java/lang/OutOfMemoryError
    //   62	68	409	finally
    //   79	85	409	finally
    //   103	109	409	finally
    //   120	131	409	finally
    //   142	148	409	finally
    //   159	165	409	finally
    //   176	182	409	finally
    //   193	199	409	finally
    //   210	217	409	finally
    //   232	240	409	finally
    //   251	259	409	finally
    //   270	279	409	finally
    //   290	300	409	finally
    //   339	345	409	finally
    //   359	387	409	finally
    //   396	409	409	finally
    //   27	51	444	finally
    //   27	51	459	java/lang/OutOfMemoryError
  }
  
  public static String a(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramString)), null, localOptions);
      paramString = String.format("w=%d,h=%d", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    paramBitmap.recycle();
  }
  
  /* Error */
  @android.annotation.TargetApi(12)
  public static void a(Bitmap paramBitmap, String paramString, BitmapUtils.ByteArrayRecycler paramByteArrayRecycler)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: invokevirtual 361	android/graphics/Bitmap:isRecycled	()Z
    //   13: ifeq +14 -> 27
    //   16: new 261	java/lang/IllegalArgumentException
    //   19: dup
    //   20: ldc_w 363
    //   23: invokespecial 264	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   26: athrow
    //   27: aload_1
    //   28: ifnonnull +14 -> 42
    //   31: new 261	java/lang/IllegalArgumentException
    //   34: dup
    //   35: ldc_w 365
    //   38: invokespecial 264	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   41: athrow
    //   42: new 367	java/io/DataOutputStream
    //   45: dup
    //   46: new 369	java/io/FileOutputStream
    //   49: dup
    //   50: new 268	java/io/File
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 269	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: invokespecial 370	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 373	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: astore 4
    //   66: aload_3
    //   67: astore_1
    //   68: aload 4
    //   70: sipush 187
    //   73: invokevirtual 376	java/io/DataOutputStream:writeInt	(I)V
    //   76: aload_3
    //   77: astore_1
    //   78: aload 4
    //   80: iconst_1
    //   81: invokevirtual 376	java/io/DataOutputStream:writeInt	(I)V
    //   84: aload_3
    //   85: astore_1
    //   86: aload 4
    //   88: aload_0
    //   89: invokevirtual 379	android/graphics/Bitmap:isMutable	()Z
    //   92: invokevirtual 383	java/io/DataOutputStream:writeBoolean	(Z)V
    //   95: aload_3
    //   96: astore_1
    //   97: aload 4
    //   99: aload_0
    //   100: invokevirtual 17	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   103: invokevirtual 386	android/graphics/Bitmap$Config:ordinal	()I
    //   106: invokevirtual 376	java/io/DataOutputStream:writeInt	(I)V
    //   109: aload_3
    //   110: astore_1
    //   111: aload 4
    //   113: aload_0
    //   114: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   117: invokevirtual 376	java/io/DataOutputStream:writeInt	(I)V
    //   120: aload_3
    //   121: astore_1
    //   122: aload 4
    //   124: aload_0
    //   125: invokevirtual 69	android/graphics/Bitmap:getHeight	()I
    //   128: invokevirtual 376	java/io/DataOutputStream:writeInt	(I)V
    //   131: aload_3
    //   132: astore_1
    //   133: aload 4
    //   135: aload_0
    //   136: invokevirtual 389	android/graphics/Bitmap:getRowBytes	()I
    //   139: invokevirtual 376	java/io/DataOutputStream:writeInt	(I)V
    //   142: aload_3
    //   143: astore_1
    //   144: aload 4
    //   146: aload_0
    //   147: invokevirtual 392	android/graphics/Bitmap:getDensity	()I
    //   150: invokevirtual 376	java/io/DataOutputStream:writeInt	(I)V
    //   153: aload_2
    //   154: ifnull +75 -> 229
    //   157: aload_3
    //   158: astore_1
    //   159: aload_2
    //   160: aload_0
    //   161: invokevirtual 395	android/graphics/Bitmap:getByteCount	()I
    //   164: invokevirtual 289	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	(I)[B
    //   167: astore_3
    //   168: aload_3
    //   169: astore_1
    //   170: aload_0
    //   171: aload_3
    //   172: invokestatic 299	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   175: invokevirtual 398	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   178: aload_3
    //   179: astore_1
    //   180: aload 4
    //   182: aload_3
    //   183: arraylength
    //   184: invokevirtual 376	java/io/DataOutputStream:writeInt	(I)V
    //   187: aload_3
    //   188: astore_1
    //   189: aload 4
    //   191: aload_3
    //   192: iconst_0
    //   193: aload_3
    //   194: arraylength
    //   195: invokevirtual 402	java/io/DataOutputStream:write	([BII)V
    //   198: aload_3
    //   199: astore_1
    //   200: aload 4
    //   202: invokevirtual 405	java/io/DataOutputStream:flush	()V
    //   205: aload_2
    //   206: ifnull +12 -> 218
    //   209: aload_3
    //   210: ifnull +8 -> 218
    //   213: aload_2
    //   214: aload_3
    //   215: invokevirtual 306	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   218: aload 4
    //   220: ifnull +8 -> 228
    //   223: aload 4
    //   225: invokevirtual 406	java/io/DataOutputStream:close	()V
    //   228: return
    //   229: aload_3
    //   230: astore_1
    //   231: aload_0
    //   232: invokevirtual 395	android/graphics/Bitmap:getByteCount	()I
    //   235: newarray byte
    //   237: astore_3
    //   238: goto -70 -> 168
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_3
    //   244: aload 5
    //   246: astore_1
    //   247: aload_2
    //   248: ifnull +12 -> 260
    //   251: aload_1
    //   252: ifnull +8 -> 260
    //   255: aload_2
    //   256: aload_1
    //   257: invokevirtual 306	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   260: aload_3
    //   261: ifnull +7 -> 268
    //   264: aload_3
    //   265: invokevirtual 406	java/io/DataOutputStream:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: astore_0
    //   271: aload 4
    //   273: astore_3
    //   274: goto -27 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramBitmap	Bitmap
    //   0	277	1	paramString	String
    //   0	277	2	paramByteArrayRecycler	BitmapUtils.ByteArrayRecycler
    //   1	273	3	localObject1	Object
    //   64	208	4	localDataOutputStream	java.io.DataOutputStream
    //   3	242	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   42	66	241	finally
    //   68	76	270	finally
    //   78	84	270	finally
    //   86	95	270	finally
    //   97	109	270	finally
    //   111	120	270	finally
    //   122	131	270	finally
    //   133	142	270	finally
    //   144	153	270	finally
    //   159	168	270	finally
    //   170	178	270	finally
    //   180	187	270	finally
    //   189	198	270	finally
    //   200	205	270	finally
    //   231	238	270	finally
  }
  
  private static void a(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (!(paramView instanceof ViewGroup)) {
        break;
      }
      paramView.destroyDrawingCache();
      paramView.invalidate();
      int i = 0;
      while (i < ((ViewGroup)paramView).getChildCount())
      {
        a(((ViewGroup)paramView).getChildAt(i));
        i += 1;
      }
    }
    paramView.destroyDrawingCache();
    paramView.invalidate();
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
  {
    // Byte code:
    //   0: invokestatic 428	android/os/SystemClock:uptimeMillis	()J
    //   3: pop2
    //   4: aconst_null
    //   5: astore 6
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 5
    //   13: new 268	java/io/File
    //   16: dup
    //   17: aload_3
    //   18: invokespecial 269	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 7
    //   23: aload 4
    //   25: astore_3
    //   26: aload 7
    //   28: invokevirtual 431	java/io/File:exists	()Z
    //   31: ifne +31 -> 62
    //   34: aload 4
    //   36: astore_3
    //   37: aload 7
    //   39: invokevirtual 434	java/io/File:createNewFile	()Z
    //   42: ifne +20 -> 62
    //   45: aload 4
    //   47: astore_3
    //   48: ldc 32
    //   50: ldc_w 436
    //   53: invokestatic 439	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aconst_null
    //   57: invokestatic 444	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   60: iconst_0
    //   61: ireturn
    //   62: aload 4
    //   64: astore_3
    //   65: new 446	java/io/BufferedOutputStream
    //   68: dup
    //   69: new 369	java/io/FileOutputStream
    //   72: dup
    //   73: aload 7
    //   75: invokespecial 370	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   78: sipush 8192
    //   81: invokespecial 449	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   84: astore 4
    //   86: aload_0
    //   87: aload_1
    //   88: iload_2
    //   89: aload 4
    //   91: invokevirtual 453	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   94: ifne +18 -> 112
    //   97: ldc 32
    //   99: ldc_w 455
    //   102: invokestatic 439	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload 4
    //   107: invokestatic 444	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   110: iconst_0
    //   111: ireturn
    //   112: aload 4
    //   114: invokestatic 444	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   117: iconst_1
    //   118: ireturn
    //   119: astore_1
    //   120: aload 5
    //   122: astore_0
    //   123: aload_0
    //   124: astore_3
    //   125: ldc 32
    //   127: aload_1
    //   128: invokevirtual 456	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   131: aload_1
    //   132: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: aload_0
    //   136: invokestatic 444	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_1
    //   142: aload 6
    //   144: astore_0
    //   145: aload_0
    //   146: astore_3
    //   147: ldc 32
    //   149: aload_1
    //   150: invokevirtual 457	java/io/IOException:getMessage	()Ljava/lang/String;
    //   153: aload_1
    //   154: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   157: aload_0
    //   158: invokestatic 444	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   161: iconst_0
    //   162: ireturn
    //   163: astore_0
    //   164: aload_3
    //   165: invokestatic 444	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   168: aload_0
    //   169: athrow
    //   170: astore_0
    //   171: aload 4
    //   173: astore_3
    //   174: goto -10 -> 164
    //   177: astore_1
    //   178: aload 4
    //   180: astore_0
    //   181: goto -36 -> 145
    //   184: astore_1
    //   185: aload 4
    //   187: astore_0
    //   188: goto -65 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramBitmap	Bitmap
    //   0	191	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	191	2	paramInt	int
    //   0	191	3	paramString	String
    //   8	178	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   11	110	5	localObject1	Object
    //   5	138	6	localObject2	Object
    //   21	53	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   26	34	119	java/io/FileNotFoundException
    //   37	45	119	java/io/FileNotFoundException
    //   48	56	119	java/io/FileNotFoundException
    //   65	86	119	java/io/FileNotFoundException
    //   26	34	141	java/io/IOException
    //   37	45	141	java/io/IOException
    //   48	56	141	java/io/IOException
    //   65	86	141	java/io/IOException
    //   26	34	163	finally
    //   37	45	163	finally
    //   48	56	163	finally
    //   65	86	163	finally
    //   125	135	163	finally
    //   147	157	163	finally
    //   86	105	170	finally
    //   86	105	177	java/io/IOException
    //   86	105	184	java/io/FileNotFoundException
  }
  
  public static boolean a(Bitmap paramBitmap, String paramString)
  {
    return a(paramBitmap, Bitmap.CompressFormat.JPEG, 80, paramString);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString != null) {
      try
      {
        Bitmap localBitmap = a(paramString, null);
        FileUtils.d(paramString);
        boolean bool = a(localBitmap, Bitmap.CompressFormat.PNG, 100, paramString);
        return bool;
      }
      catch (Throwable paramString)
      {
        SLog.c("BitmapUtils", "convertBitmapBinFileToPng failed", paramString);
      }
    }
    return false;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight();
    float f2 = paramInt1 * 1.0F / paramInt2;
    if (f2 == f1)
    {
      SLog.b("BitmapUtils", "fillBackground. no need to resize");
      return paramBitmap;
    }
    if (f1 > f2)
    {
      paramInt1 = Math.round(i / f2);
      paramInt2 = i;
    }
    Object localObject1;
    for (;;)
    {
      localObject2 = paramBitmap.getConfig();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Bitmap.Config.ARGB_8888;
      }
      localObject1 = a(paramInt2, paramInt1, (Bitmap.Config)localObject1, false);
      if (localObject1 != null) {
        break;
      }
      return null;
      paramInt2 = Math.round(j * f2);
      paramInt1 = j;
    }
    Object localObject2 = new Canvas((Bitmap)localObject1);
    if (!paramBoolean1) {
      ((Canvas)localObject2).drawColor(-16777216);
    }
    Paint localPaint = new Paint(6);
    ((Canvas)localObject2).drawBitmap(paramBitmap, (paramInt2 - i) / 2, (paramInt1 - j) / 2, localPaint);
    ((Canvas)localObject2).setBitmap(null);
    if (paramBoolean2) {
      a(paramBitmap);
    }
    return localObject1;
  }
  
  public static Bitmap b(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 == null)) {}
    for (;;)
    {
      return null;
      try
      {
        int i = paramBitmap1.getWidth();
        int j = paramBitmap1.getHeight();
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
          float f1 = i / paramBitmap2.getWidth();
          float f2 = j / paramBitmap2.getHeight();
          paramBitmap1 = new Matrix();
          paramBitmap1.postScale(f1, f2);
          localCanvas.drawBitmap(paramBitmap2, paramBitmap1, null);
          localCanvas.save(31);
          return localBitmap;
        }
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        SLog.c("BitmapUtils", paramBitmap1.getMessage(), paramBitmap1);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */