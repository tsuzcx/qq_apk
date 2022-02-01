package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.util.MQLruCache;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt1 > 0)
    {
      localObject1 = localObject2;
      if (paramInt2 <= 0) {}
    }
    try
    {
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return localObject1;
    }
    catch (OutOfMemoryError paramConfig)
    {
      SLog.c("BitmapUtils", "OutOfMemoryError", paramConfig);
      StoryDispatcher.a().dispatch(new BitmapUtils.OutOfMemHandleCommand());
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
    if (paramBitmap == null) {
      return null;
    }
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
    return a(paramBitmap, paramInt1, paramInt2, paramBoolean, false);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
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
    if (paramBoolean2) {
      localBitmap.setDensity(paramBitmap.getDensity());
    }
    int i = Math.round(paramBitmap.getWidth() * f);
    int j = Math.round(paramBitmap.getHeight() * f);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.translate((paramInt1 - i) / 2.0F, (paramInt2 - j) / 2.0F);
    localCanvas.scale(f, f);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(6));
    if (paramBoolean1) {
      a(paramBitmap);
    }
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 == null)) {
      return null;
    }
    int i = paramBitmap1.getWidth();
    int j = paramBitmap1.getHeight();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    float f = Math.min(i / k, j / m);
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap2, (int)(k * f), (int)(m * f), false);
    k = localBitmap.getWidth();
    m = localBitmap.getHeight();
    if (paramBitmap1.isMutable()) {}
    for (paramBitmap2 = paramBitmap1;; paramBitmap2 = paramBitmap1.copy(paramBitmap1.getConfig(), true))
    {
      paramBitmap2 = new Canvas(paramBitmap2);
      paramBitmap2.drawBitmap(localBitmap, (i - k) / 2, (j - m) / 2, null);
      paramBitmap2.save();
      paramBitmap2.restore();
      return paramBitmap1;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean)
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
          if (paramBoolean) {
            localBitmap.setDensity(paramBitmap1.getDensity());
          }
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
          float f1 = i / paramBitmap2.getWidth();
          float f2 = j / paramBitmap2.getHeight();
          paramBitmap1 = new Matrix();
          paramBitmap1.postScale(f1, f2);
          localCanvas.drawBitmap(paramBitmap2, paramBitmap1, null);
          localCanvas.save();
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
  
  public static Bitmap a(Bitmap paramBitmap, RectF paramRectF1, RectF paramRectF2, float paramFloat)
  {
    int i = (int)((paramRectF1.left - paramRectF2.left) / paramFloat);
    int j = (int)((paramRectF1.top - paramRectF2.top) / paramFloat);
    int k = (int)(paramRectF1.width() / paramFloat);
    int m = (int)(paramRectF1.height() / paramFloat);
    Bitmap localBitmap = paramBitmap;
    if (a(paramRectF1, paramRectF2, k, m)) {}
    try
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, i, j, k, m);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      QLog.d("BitmapUtils", 1, "ImageStateTransform transform", paramBitmap);
      StoryDispatcher.a().dispatch(new BitmapUtils.OutOfMemHandleCommand());
    }
    return null;
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
    //   3: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +7 -> 13
    //   9: aload_2
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: new 273	java/io/BufferedInputStream
    //   16: dup
    //   17: new 275	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 278	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 281	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_0
    //   29: aload_0
    //   30: astore_1
    //   31: aload_0
    //   32: invokestatic 287	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: aload_2
    //   39: astore_1
    //   40: aload_0
    //   41: ifnull -30 -> 11
    //   44: aload_0
    //   45: invokevirtual 290	java/io/BufferedInputStream:close	()V
    //   48: aload_2
    //   49: areturn
    //   50: astore_0
    //   51: ldc 32
    //   53: ldc_w 292
    //   56: aload_0
    //   57: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_2
    //   61: areturn
    //   62: astore_2
    //   63: aconst_null
    //   64: astore_0
    //   65: aload_0
    //   66: astore_1
    //   67: ldc 32
    //   69: ldc_w 294
    //   72: aload_2
    //   73: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_0
    //   77: astore_1
    //   78: aload_2
    //   79: athrow
    //   80: astore_0
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 290	java/io/BufferedInputStream:close	()V
    //   89: aload_0
    //   90: athrow
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_0
    //   94: ldc 32
    //   96: ldc_w 296
    //   99: aload_1
    //   100: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: astore_1
    //   105: aload_0
    //   106: ifnull -95 -> 11
    //   109: aload_0
    //   110: invokevirtual 290	java/io/BufferedInputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: ldc 32
    //   118: ldc_w 292
    //   121: aload_0
    //   122: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: ldc 32
    //   130: ldc_w 292
    //   133: aload_1
    //   134: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: goto -48 -> 89
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_1
    //   143: goto -62 -> 81
    //   146: astore_2
    //   147: aload_0
    //   148: astore_1
    //   149: aload_2
    //   150: astore_0
    //   151: goto -70 -> 81
    //   154: astore_1
    //   155: goto -61 -> 94
    //   158: astore_2
    //   159: goto -94 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   10	76	1	localObject1	Object
    //   91	9	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   104	1	1	localOutOfMemoryError1	OutOfMemoryError
    //   127	7	1	localIOException	java.io.IOException
    //   142	7	1	str	String
    //   154	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	60	2	localObject2	Object
    //   62	42	2	localOutOfMemoryError2	OutOfMemoryError
    //   146	4	2	localObject3	Object
    //   158	1	2	localOutOfMemoryError3	OutOfMemoryError
    //   35	2	3	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/io/IOException
    //   13	29	62	java/lang/OutOfMemoryError
    //   31	36	80	finally
    //   67	76	80	finally
    //   78	80	80	finally
    //   13	29	91	java/io/FileNotFoundException
    //   109	113	115	java/io/IOException
    //   85	89	127	java/io/IOException
    //   13	29	140	finally
    //   94	103	146	finally
    //   31	36	154	java/io/FileNotFoundException
    //   31	36	158	java/lang/OutOfMemoryError
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
    //   16: new 299	java/lang/IllegalArgumentException
    //   19: dup
    //   20: ldc_w 301
    //   23: invokespecial 302	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   26: athrow
    //   27: new 304	java/io/DataInputStream
    //   30: dup
    //   31: new 275	java/io/FileInputStream
    //   34: dup
    //   35: new 306	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 307	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 311	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore 8
    //   51: aload 5
    //   53: astore 6
    //   55: aload 9
    //   57: astore_0
    //   58: aload 8
    //   60: astore 7
    //   62: aload 8
    //   64: invokevirtual 314	java/io/DataInputStream:readInt	()I
    //   67: istore_2
    //   68: aload 5
    //   70: astore 6
    //   72: aload 9
    //   74: astore_0
    //   75: aload 8
    //   77: astore 7
    //   79: aload 8
    //   81: invokevirtual 314	java/io/DataInputStream:readInt	()I
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
    //   105: invokevirtual 317	java/io/DataInputStream:readBoolean	()Z
    //   108: pop
    //   109: aload 5
    //   111: astore 6
    //   113: aload 9
    //   115: astore_0
    //   116: aload 8
    //   118: astore 7
    //   120: invokestatic 321	android/graphics/Bitmap$Config:values	()[Landroid/graphics/Bitmap$Config;
    //   123: aload 8
    //   125: invokevirtual 314	java/io/DataInputStream:readInt	()I
    //   128: aaload
    //   129: astore 10
    //   131: aload 5
    //   133: astore 6
    //   135: aload 9
    //   137: astore_0
    //   138: aload 8
    //   140: astore 7
    //   142: aload 8
    //   144: invokevirtual 314	java/io/DataInputStream:readInt	()I
    //   147: istore_2
    //   148: aload 5
    //   150: astore 6
    //   152: aload 9
    //   154: astore_0
    //   155: aload 8
    //   157: astore 7
    //   159: aload 8
    //   161: invokevirtual 314	java/io/DataInputStream:readInt	()I
    //   164: istore_3
    //   165: aload 5
    //   167: astore 6
    //   169: aload 9
    //   171: astore_0
    //   172: aload 8
    //   174: astore 7
    //   176: aload 8
    //   178: invokevirtual 314	java/io/DataInputStream:readInt	()I
    //   181: pop
    //   182: aload 5
    //   184: astore 6
    //   186: aload 9
    //   188: astore_0
    //   189: aload 8
    //   191: astore 7
    //   193: aload 8
    //   195: invokevirtual 314	java/io/DataInputStream:readInt	()I
    //   198: pop
    //   199: aload 5
    //   201: astore 6
    //   203: aload 9
    //   205: astore_0
    //   206: aload 8
    //   208: astore 7
    //   210: aload 8
    //   212: invokevirtual 314	java/io/DataInputStream:readInt	()I
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
    //   235: invokevirtual 326	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	(I)[B
    //   238: astore 5
    //   240: aload 5
    //   242: astore 6
    //   244: aload 5
    //   246: astore_0
    //   247: aload 8
    //   249: astore 7
    //   251: aload 8
    //   253: aload 5
    //   255: invokevirtual 330	java/io/DataInputStream:read	([B)I
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
    //   294: invokestatic 336	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   297: invokevirtual 340	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   300: aload_1
    //   301: ifnull +14 -> 315
    //   304: aload 5
    //   306: ifnull +9 -> 315
    //   309: aload_1
    //   310: aload 5
    //   312: invokevirtual 343	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   315: aload 8
    //   317: ifnull +8 -> 325
    //   320: aload 8
    //   322: invokevirtual 344	java/io/DataInputStream:close	()V
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
    //   359: new 265	java/io/IOException
    //   362: dup
    //   363: new 120	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 346
    //   373: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: iload_2
    //   377: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokespecial 350	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   386: athrow
    //   387: astore 5
    //   389: aload 8
    //   391: astore 7
    //   393: aload 6
    //   395: astore_0
    //   396: new 265	java/io/IOException
    //   399: dup
    //   400: ldc_w 352
    //   403: aload 5
    //   405: invokespecial 355	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   429: invokevirtual 343	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   432: aload 7
    //   434: ifnull +8 -> 442
    //   437: aload 7
    //   439: invokevirtual 344	java/io/DataInputStream:close	()V
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
  
  @TargetApi(12)
  public static void a(Bitmap paramBitmap, String paramString, BitmapUtils.ByteArrayRecycler paramByteArrayRecycler)
  {
    try
    {
      b(paramBitmap, paramString, paramByteArrayRecycler);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SLog.c("BitmapUtils", "serializeBitmapToFile failed", localOutOfMemoryError);
      if (GlobalImageCache.a != null) {
        GlobalImageCache.a.evictAll();
      }
      b(paramBitmap, paramString, paramByteArrayRecycler);
    }
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
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 438	android/graphics/Bitmap:isRecycled	()Z
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: invokestatic 443	android/os/SystemClock:uptimeMillis	()J
    //   16: pop2
    //   17: aconst_null
    //   18: astore 7
    //   20: aconst_null
    //   21: astore 8
    //   23: aconst_null
    //   24: astore 5
    //   26: aconst_null
    //   27: astore 6
    //   29: new 306	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: invokespecial 307	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 9
    //   39: aload 5
    //   41: astore_3
    //   42: aload 9
    //   44: invokevirtual 446	java/io/File:exists	()Z
    //   47: ifne +31 -> 78
    //   50: aload 5
    //   52: astore_3
    //   53: aload 9
    //   55: invokevirtual 449	java/io/File:createNewFile	()Z
    //   58: ifne +20 -> 78
    //   61: aload 5
    //   63: astore_3
    //   64: ldc 32
    //   66: ldc_w 451
    //   69: invokestatic 454	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aconst_null
    //   73: invokestatic 459	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   76: iconst_0
    //   77: ireturn
    //   78: aload 5
    //   80: astore_3
    //   81: new 461	java/io/BufferedOutputStream
    //   84: dup
    //   85: new 463	java/io/FileOutputStream
    //   88: dup
    //   89: aload 9
    //   91: invokespecial 464	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: sipush 8192
    //   97: invokespecial 467	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   100: astore 5
    //   102: aload_0
    //   103: invokevirtual 438	android/graphics/Bitmap:isRecycled	()Z
    //   106: istore 4
    //   108: iload 4
    //   110: ifeq +10 -> 120
    //   113: aload 5
    //   115: invokestatic 459	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   118: iconst_0
    //   119: ireturn
    //   120: aload_0
    //   121: aload_1
    //   122: iload_2
    //   123: aload 5
    //   125: invokevirtual 471	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   128: ifne +18 -> 146
    //   131: ldc 32
    //   133: ldc_w 473
    //   136: invokestatic 454	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload 5
    //   141: invokestatic 459	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: aload 5
    //   148: invokestatic 459	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   151: iconst_1
    //   152: ireturn
    //   153: astore_1
    //   154: aload 6
    //   156: astore_0
    //   157: aload_0
    //   158: astore_3
    //   159: ldc 32
    //   161: aload_1
    //   162: invokevirtual 474	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   165: aload_1
    //   166: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: aload_0
    //   170: invokestatic 459	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_1
    //   176: aload 7
    //   178: astore_0
    //   179: aload_0
    //   180: astore_3
    //   181: ldc 32
    //   183: aload_1
    //   184: invokevirtual 475	java/io/IOException:getMessage	()Ljava/lang/String;
    //   187: aload_1
    //   188: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload_0
    //   192: invokestatic 459	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: aload 8
    //   200: astore_0
    //   201: aload_0
    //   202: astore_3
    //   203: ldc 32
    //   205: aload_1
    //   206: invokevirtual 476	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   209: aload_1
    //   210: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_0
    //   214: invokestatic 459	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   217: iconst_0
    //   218: ireturn
    //   219: astore_0
    //   220: aload_3
    //   221: invokestatic 459	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   224: aload_0
    //   225: athrow
    //   226: astore_0
    //   227: aload 5
    //   229: astore_3
    //   230: goto -10 -> 220
    //   233: astore_1
    //   234: aload 5
    //   236: astore_0
    //   237: goto -36 -> 201
    //   240: astore_1
    //   241: aload 5
    //   243: astore_0
    //   244: goto -65 -> 179
    //   247: astore_1
    //   248: aload 5
    //   250: astore_0
    //   251: goto -94 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramBitmap	Bitmap
    //   0	254	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	254	2	paramInt	int
    //   0	254	3	paramString	String
    //   106	3	4	bool	boolean
    //   24	225	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   27	128	6	localObject1	Object
    //   18	159	7	localObject2	Object
    //   21	178	8	localObject3	Object
    //   37	53	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   42	50	153	java/io/FileNotFoundException
    //   53	61	153	java/io/FileNotFoundException
    //   64	72	153	java/io/FileNotFoundException
    //   81	102	153	java/io/FileNotFoundException
    //   42	50	175	java/io/IOException
    //   53	61	175	java/io/IOException
    //   64	72	175	java/io/IOException
    //   81	102	175	java/io/IOException
    //   42	50	197	java/lang/IllegalStateException
    //   53	61	197	java/lang/IllegalStateException
    //   64	72	197	java/lang/IllegalStateException
    //   81	102	197	java/lang/IllegalStateException
    //   42	50	219	finally
    //   53	61	219	finally
    //   64	72	219	finally
    //   81	102	219	finally
    //   159	169	219	finally
    //   181	191	219	finally
    //   203	213	219	finally
    //   102	108	226	finally
    //   120	139	226	finally
    //   102	108	233	java/lang/IllegalStateException
    //   120	139	233	java/lang/IllegalStateException
    //   102	108	240	java/io/IOException
    //   120	139	240	java/io/IOException
    //   102	108	247	java/io/FileNotFoundException
    //   120	139	247	java/io/FileNotFoundException
  }
  
  public static boolean a(Bitmap paramBitmap, String paramString)
  {
    return a(paramBitmap, Bitmap.CompressFormat.JPEG, 80, paramString);
  }
  
  private static boolean a(RectF paramRectF1, RectF paramRectF2, int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(1 + Math.max(paramInt1, paramInt2) / 1000.0F);
    return (Math.abs(paramRectF1.left - paramRectF2.left) > paramInt1) || (Math.abs(paramRectF1.top - paramRectF2.top) > paramInt1) || (Math.abs(paramRectF1.bottom - paramRectF2.bottom) > paramInt1) || (Math.abs(paramRectF1.right - paramRectF2.right) > paramInt1);
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
  
  public static Bitmap b(Bitmap paramBitmap1, Bitmap paramBitmap2)
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
      localCanvas.save();
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap1)
    {
      SLog.c("BitmapUtils", paramBitmap1.getMessage(), paramBitmap1);
    }
    return null;
  }
  
  /* Error */
  @TargetApi(12)
  public static void b(Bitmap paramBitmap, String paramString, BitmapUtils.ByteArrayRecycler paramByteArrayRecycler)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: invokevirtual 438	android/graphics/Bitmap:isRecycled	()Z
    //   13: ifeq +14 -> 27
    //   16: new 299	java/lang/IllegalArgumentException
    //   19: dup
    //   20: ldc_w 526
    //   23: invokespecial 302	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   26: athrow
    //   27: aload_1
    //   28: ifnonnull +14 -> 42
    //   31: new 299	java/lang/IllegalArgumentException
    //   34: dup
    //   35: ldc_w 528
    //   38: invokespecial 302	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   41: athrow
    //   42: new 530	java/io/DataOutputStream
    //   45: dup
    //   46: new 463	java/io/FileOutputStream
    //   49: dup
    //   50: new 306	java/io/File
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 307	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: invokespecial 464	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 533	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: astore 4
    //   66: aload_3
    //   67: astore_1
    //   68: aload 4
    //   70: sipush 187
    //   73: invokevirtual 536	java/io/DataOutputStream:writeInt	(I)V
    //   76: aload_3
    //   77: astore_1
    //   78: aload 4
    //   80: iconst_1
    //   81: invokevirtual 536	java/io/DataOutputStream:writeInt	(I)V
    //   84: aload_3
    //   85: astore_1
    //   86: aload 4
    //   88: aload_0
    //   89: invokevirtual 167	android/graphics/Bitmap:isMutable	()Z
    //   92: invokevirtual 540	java/io/DataOutputStream:writeBoolean	(Z)V
    //   95: aload_3
    //   96: astore_1
    //   97: aload 4
    //   99: aload_0
    //   100: invokevirtual 17	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   103: invokevirtual 543	android/graphics/Bitmap$Config:ordinal	()I
    //   106: invokevirtual 536	java/io/DataOutputStream:writeInt	(I)V
    //   109: aload_3
    //   110: astore_1
    //   111: aload 4
    //   113: aload_0
    //   114: invokevirtual 59	android/graphics/Bitmap:getWidth	()I
    //   117: invokevirtual 536	java/io/DataOutputStream:writeInt	(I)V
    //   120: aload_3
    //   121: astore_1
    //   122: aload 4
    //   124: aload_0
    //   125: invokevirtual 68	android/graphics/Bitmap:getHeight	()I
    //   128: invokevirtual 536	java/io/DataOutputStream:writeInt	(I)V
    //   131: aload_3
    //   132: astore_1
    //   133: aload 4
    //   135: aload_0
    //   136: invokevirtual 546	android/graphics/Bitmap:getRowBytes	()I
    //   139: invokevirtual 536	java/io/DataOutputStream:writeInt	(I)V
    //   142: aload_3
    //   143: astore_1
    //   144: aload 4
    //   146: aload_0
    //   147: invokevirtual 150	android/graphics/Bitmap:getDensity	()I
    //   150: invokevirtual 536	java/io/DataOutputStream:writeInt	(I)V
    //   153: aload_2
    //   154: ifnull +75 -> 229
    //   157: aload_3
    //   158: astore_1
    //   159: aload_2
    //   160: aload_0
    //   161: invokevirtual 549	android/graphics/Bitmap:getByteCount	()I
    //   164: invokevirtual 326	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	(I)[B
    //   167: astore_3
    //   168: aload_3
    //   169: astore_1
    //   170: aload_0
    //   171: aload_3
    //   172: invokestatic 336	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   175: invokevirtual 552	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   178: aload_3
    //   179: astore_1
    //   180: aload 4
    //   182: aload_3
    //   183: arraylength
    //   184: invokevirtual 536	java/io/DataOutputStream:writeInt	(I)V
    //   187: aload_3
    //   188: astore_1
    //   189: aload 4
    //   191: aload_3
    //   192: iconst_0
    //   193: aload_3
    //   194: arraylength
    //   195: invokevirtual 556	java/io/DataOutputStream:write	([BII)V
    //   198: aload_3
    //   199: astore_1
    //   200: aload 4
    //   202: invokevirtual 559	java/io/DataOutputStream:flush	()V
    //   205: aload_2
    //   206: ifnull +12 -> 218
    //   209: aload_3
    //   210: ifnull +8 -> 218
    //   213: aload_2
    //   214: aload_3
    //   215: invokevirtual 343	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   218: aload 4
    //   220: ifnull +8 -> 228
    //   223: aload 4
    //   225: invokevirtual 560	java/io/DataOutputStream:close	()V
    //   228: return
    //   229: aload_3
    //   230: astore_1
    //   231: aload_0
    //   232: invokevirtual 549	android/graphics/Bitmap:getByteCount	()I
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
    //   257: invokevirtual 343	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   260: aload_3
    //   261: ifnull +7 -> 268
    //   264: aload_3
    //   265: invokevirtual 560	java/io/DataOutputStream:close	()V
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
  
  public static Bitmap c(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
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
  
  public static Bitmap c(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    return a(paramBitmap1, paramBitmap2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */