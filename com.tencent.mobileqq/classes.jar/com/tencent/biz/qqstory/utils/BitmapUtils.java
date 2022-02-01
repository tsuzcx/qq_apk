package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.util.MQLruCache;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

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
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      try
      {
        paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
        return paramConfig;
      }
      catch (OutOfMemoryError paramConfig)
      {
        SLog.c("BitmapUtils", "OutOfMemoryError", paramConfig);
      }
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = Math.round(paramBitmap.getWidth() * paramFloat);
    int j = Math.round(paramBitmap.getHeight() * paramFloat);
    if ((i == paramBitmap.getWidth()) && (j == paramBitmap.getHeight())) {
      return paramBitmap;
    }
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
      Object localObject = new Matrix();
      ((Matrix)localObject).reset();
      ((Matrix)localObject).postRotate(paramInt);
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("generateOrientation end, cost:");
      double d = System.currentTimeMillis() - l;
      Double.isNaN(d);
      ((StringBuilder)localObject).append(d / 1000.0D);
      SLog.d("BitmapUtils", ((StringBuilder)localObject).toString());
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
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i == paramInt1) && (j == paramInt2)) {
      return paramBitmap;
    }
    float f = Math.max(paramInt1 / i, paramInt2 / j);
    Bitmap localBitmap = a(paramInt1, paramInt2, a(paramBitmap), false);
    if (localBitmap == null) {
      return null;
    }
    if (paramBoolean2) {
      localBitmap.setDensity(paramBitmap.getDensity());
    }
    i = Math.round(paramBitmap.getWidth() * f);
    j = Math.round(paramBitmap.getHeight() * f);
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
    if (paramBitmap1 != null)
    {
      if (paramBitmap2 == null) {
        return null;
      }
      int i = paramBitmap1.getWidth();
      int j = paramBitmap1.getHeight();
      int k = paramBitmap2.getWidth();
      int m = paramBitmap2.getHeight();
      float f2 = i;
      float f1 = k;
      float f3 = f2 / f1;
      float f4 = j;
      f2 = m;
      f3 = Math.min(f3, f4 / f2);
      Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap2, (int)(f1 * f3), (int)(f3 * f2), false);
      k = localBitmap.getWidth();
      m = localBitmap.getHeight();
      if (paramBitmap1.isMutable()) {
        paramBitmap2 = paramBitmap1;
      } else {
        paramBitmap2 = paramBitmap1.copy(paramBitmap1.getConfig(), true);
      }
      paramBitmap2 = new Canvas(paramBitmap2);
      paramBitmap2.drawBitmap(localBitmap, (i - k) / 2, (j - m) / 2, null);
      paramBitmap2.save();
      paramBitmap2.restore();
      return paramBitmap1;
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean)
  {
    if (paramBitmap1 != null)
    {
      if (paramBitmap2 == null) {
        return null;
      }
      try
      {
        int i = paramBitmap1.getWidth();
        int j = paramBitmap1.getHeight();
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap == null) {
          return null;
        }
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
      catch (OutOfMemoryError paramBitmap1)
      {
        SLog.c("BitmapUtils", paramBitmap1.getMessage(), paramBitmap1);
      }
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, Rect paramRect, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    Bitmap localBitmap = a(paramRect.width(), paramRect.height(), a(paramBitmap), false);
    if (localBitmap == null) {
      return null;
    }
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
    if (a(paramRectF1, paramRectF2, k, m)) {
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, i, j, k, m);
        return paramBitmap;
      }
      catch (Throwable paramBitmap)
      {
        QLog.d("BitmapUtils", 1, "ImageStateTransform transform", paramBitmap);
        localBitmap = null;
      }
    }
    return localBitmap;
  }
  
  public static Bitmap a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView);
    Canvas localCanvas = null;
    int i;
    if (paramInt1 > 0)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {
        break label31;
      }
    }
    try
    {
      i = paramView.getWidth();
      paramInt1 = paramView.getHeight();
      label31:
      Object localObject = localCanvas;
      if (i > 0)
      {
        localObject = localCanvas;
        if (paramInt1 > 0)
        {
          localObject = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_4444);
          localCanvas = new Canvas((Bitmap)localObject);
          Matrix localMatrix = new Matrix();
          localMatrix.setTranslate(paramInt3, paramInt4);
          localMatrix.setScale(i / paramView.getWidth(), paramInt1 / paramView.getHeight());
          localCanvas.setMatrix(localMatrix);
          paramView.draw(localCanvas);
        }
      }
      return localObject;
    }
    catch (OutOfMemoryError|Exception paramView) {}
    return null;
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_1
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: iload_1
    //   14: ifeq +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: new 265	java/io/BufferedInputStream
    //   22: dup
    //   23: new 267	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 273	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_0
    //   35: aload_0
    //   36: astore_2
    //   37: aload_0
    //   38: invokestatic 279	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   41: astore_3
    //   42: aload_3
    //   43: astore_2
    //   44: aload_0
    //   45: invokevirtual 282	java/io/BufferedInputStream:close	()V
    //   48: aload_3
    //   49: areturn
    //   50: astore_0
    //   51: ldc 32
    //   53: ldc_w 284
    //   56: aload_0
    //   57: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_2
    //   61: areturn
    //   62: astore_3
    //   63: goto +14 -> 77
    //   66: astore_3
    //   67: goto +42 -> 109
    //   70: astore_0
    //   71: goto +53 -> 124
    //   74: astore_3
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: astore_2
    //   79: ldc 32
    //   81: ldc_w 286
    //   84: aload_3
    //   85: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: aload_0
    //   89: ifnull +10 -> 99
    //   92: aload 4
    //   94: astore_2
    //   95: aload_0
    //   96: invokevirtual 282	java/io/BufferedInputStream:close	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: goto +22 -> 124
    //   105: astore_3
    //   106: aload 5
    //   108: astore_0
    //   109: aload_0
    //   110: astore_2
    //   111: ldc 32
    //   113: ldc_w 288
    //   116: aload_3
    //   117: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_0
    //   121: astore_2
    //   122: aload_3
    //   123: athrow
    //   124: aload_2
    //   125: ifnull +20 -> 145
    //   128: aload_2
    //   129: invokevirtual 282	java/io/BufferedInputStream:close	()V
    //   132: goto +13 -> 145
    //   135: astore_2
    //   136: ldc 32
    //   138: ldc_w 284
    //   141: aload_2
    //   142: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_0
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString	String
    //   4	10	1	bool	boolean
    //   6	123	2	localObject1	Object
    //   135	7	2	localIOException	java.io.IOException
    //   41	8	3	localBitmap	Bitmap
    //   62	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   66	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   74	11	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   105	18	3	localOutOfMemoryError2	OutOfMemoryError
    //   11	82	4	localObject2	Object
    //   8	99	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/io/IOException
    //   95	99	50	java/io/IOException
    //   37	42	62	java/io/FileNotFoundException
    //   37	42	66	java/lang/OutOfMemoryError
    //   19	35	70	finally
    //   111	120	70	finally
    //   122	124	70	finally
    //   19	35	74	java/io/FileNotFoundException
    //   37	42	101	finally
    //   79	88	101	finally
    //   19	35	105	java/lang/OutOfMemoryError
    //   128	132	135	java/io/IOException
  }
  
  /* Error */
  public static Bitmap a(String paramString, BitmapUtils.ByteArrayRecycler paramByteArrayRecycler)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +426 -> 427
    //   4: aconst_null
    //   5: astore 9
    //   7: aconst_null
    //   8: astore 10
    //   10: aconst_null
    //   11: astore 6
    //   13: aconst_null
    //   14: astore 8
    //   16: new 291	java/io/DataInputStream
    //   19: dup
    //   20: new 267	java/io/FileInputStream
    //   23: dup
    //   24: new 293	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 294	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 297	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: invokespecial 298	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore 7
    //   40: aload 8
    //   42: astore 6
    //   44: aload 9
    //   46: astore 5
    //   48: aload 7
    //   50: invokevirtual 301	java/io/DataInputStream:readInt	()I
    //   53: istore_2
    //   54: aload 8
    //   56: astore 6
    //   58: aload 9
    //   60: astore 5
    //   62: aload 7
    //   64: invokevirtual 301	java/io/DataInputStream:readInt	()I
    //   67: pop
    //   68: iload_2
    //   69: sipush 187
    //   72: if_icmpne +206 -> 278
    //   75: aload 8
    //   77: astore 6
    //   79: aload 9
    //   81: astore 5
    //   83: aload 7
    //   85: invokevirtual 304	java/io/DataInputStream:readBoolean	()Z
    //   88: pop
    //   89: aload 8
    //   91: astore 6
    //   93: aload 9
    //   95: astore 5
    //   97: invokestatic 308	android/graphics/Bitmap$Config:values	()[Landroid/graphics/Bitmap$Config;
    //   100: aload 7
    //   102: invokevirtual 301	java/io/DataInputStream:readInt	()I
    //   105: aaload
    //   106: astore 10
    //   108: aload 8
    //   110: astore 6
    //   112: aload 9
    //   114: astore 5
    //   116: aload 7
    //   118: invokevirtual 301	java/io/DataInputStream:readInt	()I
    //   121: istore_2
    //   122: aload 8
    //   124: astore 6
    //   126: aload 9
    //   128: astore 5
    //   130: aload 7
    //   132: invokevirtual 301	java/io/DataInputStream:readInt	()I
    //   135: istore_3
    //   136: aload 8
    //   138: astore 6
    //   140: aload 9
    //   142: astore 5
    //   144: aload 7
    //   146: invokevirtual 301	java/io/DataInputStream:readInt	()I
    //   149: pop
    //   150: aload 8
    //   152: astore 6
    //   154: aload 9
    //   156: astore 5
    //   158: aload 7
    //   160: invokevirtual 301	java/io/DataInputStream:readInt	()I
    //   163: pop
    //   164: aload 8
    //   166: astore 6
    //   168: aload 9
    //   170: astore 5
    //   172: aload 7
    //   174: invokevirtual 301	java/io/DataInputStream:readInt	()I
    //   177: istore 4
    //   179: aload_1
    //   180: ifnull +21 -> 201
    //   183: aload 8
    //   185: astore 6
    //   187: aload 9
    //   189: astore 5
    //   191: aload_1
    //   192: iload 4
    //   194: invokevirtual 313	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	(I)[B
    //   197: astore_0
    //   198: goto +16 -> 214
    //   201: aload 8
    //   203: astore 6
    //   205: aload 9
    //   207: astore 5
    //   209: iload 4
    //   211: newarray byte
    //   213: astore_0
    //   214: aload_0
    //   215: astore 6
    //   217: aload_0
    //   218: astore 5
    //   220: aload 7
    //   222: aload_0
    //   223: invokevirtual 317	java/io/DataInputStream:read	([B)I
    //   226: pop
    //   227: aload_0
    //   228: astore 6
    //   230: aload_0
    //   231: astore 5
    //   233: iload_2
    //   234: iload_3
    //   235: aload 10
    //   237: invokestatic 30	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   240: astore 8
    //   242: aload_0
    //   243: astore 6
    //   245: aload_0
    //   246: astore 5
    //   248: aload 8
    //   250: aload_0
    //   251: invokestatic 323	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   254: invokevirtual 327	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   257: aload_1
    //   258: ifnull +12 -> 270
    //   261: aload_0
    //   262: ifnull +8 -> 270
    //   265: aload_1
    //   266: aload_0
    //   267: invokevirtual 330	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   270: aload 7
    //   272: invokevirtual 331	java/io/DataInputStream:close	()V
    //   275: aload 8
    //   277: areturn
    //   278: aload 8
    //   280: astore 6
    //   282: aload 9
    //   284: astore 5
    //   286: new 106	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   293: astore_0
    //   294: aload 8
    //   296: astore 6
    //   298: aload 9
    //   300: astore 5
    //   302: aload_0
    //   303: ldc_w 333
    //   306: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 8
    //   312: astore 6
    //   314: aload 9
    //   316: astore 5
    //   318: aload_0
    //   319: iload_2
    //   320: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 8
    //   326: astore 6
    //   328: aload 9
    //   330: astore 5
    //   332: new 257	java/io/IOException
    //   335: dup
    //   336: aload_0
    //   337: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokespecial 337	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   343: athrow
    //   344: astore_0
    //   345: aload 7
    //   347: astore 5
    //   349: goto +51 -> 400
    //   352: astore 6
    //   354: aload 7
    //   356: astore_0
    //   357: goto +18 -> 375
    //   360: astore_0
    //   361: aconst_null
    //   362: astore 5
    //   364: goto +36 -> 400
    //   367: astore 6
    //   369: aconst_null
    //   370: astore 5
    //   372: aload 10
    //   374: astore_0
    //   375: new 257	java/io/IOException
    //   378: dup
    //   379: ldc_w 339
    //   382: aload 6
    //   384: invokespecial 342	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   387: athrow
    //   388: astore 7
    //   390: aload 5
    //   392: astore 6
    //   394: aload_0
    //   395: astore 5
    //   397: aload 7
    //   399: astore_0
    //   400: aload_1
    //   401: ifnull +14 -> 415
    //   404: aload 6
    //   406: ifnull +9 -> 415
    //   409: aload_1
    //   410: aload 6
    //   412: invokevirtual 330	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   415: aload 5
    //   417: ifnull +8 -> 425
    //   420: aload 5
    //   422: invokevirtual 331	java/io/DataInputStream:close	()V
    //   425: aload_0
    //   426: athrow
    //   427: new 344	java/lang/IllegalArgumentException
    //   430: dup
    //   431: ldc_w 346
    //   434: invokespecial 347	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   437: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	paramString	String
    //   0	438	1	paramByteArrayRecycler	BitmapUtils.ByteArrayRecycler
    //   53	267	2	i	int
    //   135	100	3	j	int
    //   177	33	4	k	int
    //   46	375	5	localObject1	Object
    //   11	316	6	localObject2	Object
    //   352	1	6	localOutOfMemoryError1	OutOfMemoryError
    //   367	16	6	localOutOfMemoryError2	OutOfMemoryError
    //   392	19	6	localObject3	Object
    //   38	317	7	localDataInputStream	java.io.DataInputStream
    //   388	10	7	localObject4	Object
    //   14	311	8	localBitmap	Bitmap
    //   5	324	9	localObject5	Object
    //   8	365	10	localConfig	Bitmap.Config
    // Exception table:
    //   from	to	target	type
    //   48	54	344	finally
    //   62	68	344	finally
    //   83	89	344	finally
    //   97	108	344	finally
    //   116	122	344	finally
    //   130	136	344	finally
    //   144	150	344	finally
    //   158	164	344	finally
    //   172	179	344	finally
    //   191	198	344	finally
    //   209	214	344	finally
    //   220	227	344	finally
    //   233	242	344	finally
    //   248	257	344	finally
    //   286	294	344	finally
    //   302	310	344	finally
    //   318	324	344	finally
    //   332	344	344	finally
    //   48	54	352	java/lang/OutOfMemoryError
    //   62	68	352	java/lang/OutOfMemoryError
    //   83	89	352	java/lang/OutOfMemoryError
    //   97	108	352	java/lang/OutOfMemoryError
    //   116	122	352	java/lang/OutOfMemoryError
    //   130	136	352	java/lang/OutOfMemoryError
    //   144	150	352	java/lang/OutOfMemoryError
    //   158	164	352	java/lang/OutOfMemoryError
    //   172	179	352	java/lang/OutOfMemoryError
    //   191	198	352	java/lang/OutOfMemoryError
    //   209	214	352	java/lang/OutOfMemoryError
    //   220	227	352	java/lang/OutOfMemoryError
    //   233	242	352	java/lang/OutOfMemoryError
    //   248	257	352	java/lang/OutOfMemoryError
    //   286	294	352	java/lang/OutOfMemoryError
    //   302	310	352	java/lang/OutOfMemoryError
    //   318	324	352	java/lang/OutOfMemoryError
    //   332	344	352	java/lang/OutOfMemoryError
    //   16	40	360	finally
    //   16	40	367	java/lang/OutOfMemoryError
    //   375	388	388	finally
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_2
    //   5: astore_1
    //   6: new 350	android/graphics/BitmapFactory$Options
    //   9: dup
    //   10: invokespecial 351	android/graphics/BitmapFactory$Options:<init>	()V
    //   13: astore 4
    //   15: aload_2
    //   16: astore_1
    //   17: aload 4
    //   19: iconst_1
    //   20: putfield 355	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   23: aload_2
    //   24: astore_1
    //   25: new 265	java/io/BufferedInputStream
    //   28: dup
    //   29: new 267	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: invokespecial 273	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_0
    //   41: aload_0
    //   42: aconst_null
    //   43: aload 4
    //   45: invokestatic 360	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   48: pop
    //   49: ldc_w 362
    //   52: iconst_2
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload 4
    //   60: getfield 366	android/graphics/BitmapFactory$Options:outWidth	I
    //   63: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload 4
    //   71: getfield 375	android/graphics/BitmapFactory$Options:outHeight	I
    //   74: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokestatic 381	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   81: astore_1
    //   82: aload_0
    //   83: invokevirtual 384	java/io/InputStream:close	()V
    //   86: aload_1
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 387	java/lang/Exception:printStackTrace	()V
    //   93: aload_1
    //   94: areturn
    //   95: astore_1
    //   96: goto +44 -> 140
    //   99: astore_2
    //   100: goto +14 -> 114
    //   103: astore_2
    //   104: aload_1
    //   105: astore_0
    //   106: aload_2
    //   107: astore_1
    //   108: goto +32 -> 140
    //   111: astore_2
    //   112: aload_3
    //   113: astore_0
    //   114: aload_0
    //   115: astore_1
    //   116: aload_2
    //   117: invokevirtual 387	java/lang/Exception:printStackTrace	()V
    //   120: aload_0
    //   121: ifnull +15 -> 136
    //   124: aload_0
    //   125: invokevirtual 384	java/io/InputStream:close	()V
    //   128: goto +8 -> 136
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 387	java/lang/Exception:printStackTrace	()V
    //   136: ldc_w 389
    //   139: areturn
    //   140: aload_0
    //   141: ifnull +15 -> 156
    //   144: aload_0
    //   145: invokevirtual 384	java/io/InputStream:close	()V
    //   148: goto +8 -> 156
    //   151: astore_0
    //   152: aload_0
    //   153: invokevirtual 387	java/lang/Exception:printStackTrace	()V
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramString	String
    //   5	89	1	localObject1	Object
    //   95	10	1	localObject2	Object
    //   107	50	1	localObject3	Object
    //   3	21	2	localObject4	Object
    //   99	1	2	localException1	Exception
    //   103	4	2	localObject5	Object
    //   111	6	2	localException2	Exception
    //   1	112	3	localObject6	Object
    //   13	57	4	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   82	86	88	java/lang/Exception
    //   41	82	95	finally
    //   41	82	99	java/lang/Exception
    //   6	15	103	finally
    //   17	23	103	finally
    //   25	41	103	finally
    //   116	120	103	finally
    //   6	15	111	java/lang/Exception
    //   17	23	111	java/lang/Exception
    //   25	41	111	java/lang/Exception
    //   124	128	131	java/lang/Exception
    //   144	148	151	java/lang/Exception
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
    if (paramView == null) {
      return;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView.destroyDrawingCache();
      paramView.invalidate();
      int i = 0;
      for (;;)
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        if (i >= localViewGroup.getChildCount()) {
          break;
        }
        a(localViewGroup.getChildAt(i));
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
    //   1: ifnull +268 -> 269
    //   4: aload_0
    //   5: invokevirtual 433	android/graphics/Bitmap:isRecycled	()Z
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: invokestatic 438	android/os/SystemClock:uptimeMillis	()J
    //   16: pop2
    //   17: aconst_null
    //   18: astore 6
    //   20: aconst_null
    //   21: astore 7
    //   23: aconst_null
    //   24: astore 8
    //   26: aconst_null
    //   27: astore 5
    //   29: new 293	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: invokespecial 294	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 9
    //   39: aload 5
    //   41: astore_3
    //   42: aload 9
    //   44: invokevirtual 441	java/io/File:exists	()Z
    //   47: ifne +27 -> 74
    //   50: aload 5
    //   52: astore_3
    //   53: aload 9
    //   55: invokevirtual 444	java/io/File:createNewFile	()Z
    //   58: ifne +16 -> 74
    //   61: aload 5
    //   63: astore_3
    //   64: ldc 32
    //   66: ldc_w 446
    //   69: invokestatic 449	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: ireturn
    //   74: aload 5
    //   76: astore_3
    //   77: new 451	java/io/BufferedOutputStream
    //   80: dup
    //   81: new 453	java/io/FileOutputStream
    //   84: dup
    //   85: aload 9
    //   87: invokespecial 454	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: sipush 8192
    //   93: invokespecial 457	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   96: astore 5
    //   98: aload_0
    //   99: invokevirtual 433	android/graphics/Bitmap:isRecycled	()Z
    //   102: istore 4
    //   104: iload 4
    //   106: ifeq +10 -> 116
    //   109: aload 5
    //   111: invokevirtual 458	java/io/BufferedOutputStream:close	()V
    //   114: iconst_0
    //   115: ireturn
    //   116: aload_0
    //   117: aload_1
    //   118: iload_2
    //   119: aload 5
    //   121: invokevirtual 462	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   124: ifne +18 -> 142
    //   127: ldc 32
    //   129: ldc_w 464
    //   132: invokestatic 449	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 5
    //   137: invokevirtual 458	java/io/BufferedOutputStream:close	()V
    //   140: iconst_0
    //   141: ireturn
    //   142: aload 5
    //   144: invokevirtual 458	java/io/BufferedOutputStream:close	()V
    //   147: iconst_1
    //   148: ireturn
    //   149: astore_0
    //   150: aload 5
    //   152: astore_3
    //   153: goto +106 -> 259
    //   156: astore_1
    //   157: aload 5
    //   159: astore_0
    //   160: goto +25 -> 185
    //   163: astore_1
    //   164: aload 5
    //   166: astore_0
    //   167: goto +44 -> 211
    //   170: astore_1
    //   171: aload 5
    //   173: astore_0
    //   174: goto +63 -> 237
    //   177: astore_0
    //   178: goto +81 -> 259
    //   181: astore_1
    //   182: aload 6
    //   184: astore_0
    //   185: aload_0
    //   186: astore_3
    //   187: ldc 32
    //   189: aload_1
    //   190: invokevirtual 465	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   193: aload_1
    //   194: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 458	java/io/BufferedOutputStream:close	()V
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_1
    //   208: aload 7
    //   210: astore_0
    //   211: aload_0
    //   212: astore_3
    //   213: ldc 32
    //   215: aload_1
    //   216: invokevirtual 466	java/io/IOException:getMessage	()Ljava/lang/String;
    //   219: aload_1
    //   220: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   223: aload_0
    //   224: ifnull +7 -> 231
    //   227: aload_0
    //   228: invokevirtual 458	java/io/BufferedOutputStream:close	()V
    //   231: iconst_0
    //   232: ireturn
    //   233: astore_1
    //   234: aload 8
    //   236: astore_0
    //   237: aload_0
    //   238: astore_3
    //   239: ldc 32
    //   241: aload_1
    //   242: invokevirtual 467	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   245: aload_1
    //   246: invokestatic 40	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   249: aload_0
    //   250: ifnull +7 -> 257
    //   253: aload_0
    //   254: invokevirtual 458	java/io/BufferedOutputStream:close	()V
    //   257: iconst_0
    //   258: ireturn
    //   259: aload_3
    //   260: ifnull +7 -> 267
    //   263: aload_3
    //   264: invokevirtual 458	java/io/BufferedOutputStream:close	()V
    //   267: aload_0
    //   268: athrow
    //   269: iconst_0
    //   270: ireturn
    //   271: astore_0
    //   272: iconst_0
    //   273: ireturn
    //   274: astore_0
    //   275: iconst_0
    //   276: ireturn
    //   277: astore_0
    //   278: goto -131 -> 147
    //   281: astore_0
    //   282: iconst_0
    //   283: ireturn
    //   284: astore_0
    //   285: iconst_0
    //   286: ireturn
    //   287: astore_0
    //   288: iconst_0
    //   289: ireturn
    //   290: astore_1
    //   291: goto -24 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramBitmap	Bitmap
    //   0	294	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	294	2	paramInt	int
    //   0	294	3	paramString	String
    //   102	3	4	bool	boolean
    //   27	145	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   18	165	6	localObject1	Object
    //   21	188	7	localObject2	Object
    //   24	211	8	localObject3	Object
    //   37	49	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   98	104	149	finally
    //   116	135	149	finally
    //   98	104	156	java/lang/IllegalStateException
    //   116	135	156	java/lang/IllegalStateException
    //   98	104	163	java/io/IOException
    //   116	135	163	java/io/IOException
    //   98	104	170	java/io/FileNotFoundException
    //   116	135	170	java/io/FileNotFoundException
    //   42	50	177	finally
    //   53	61	177	finally
    //   64	72	177	finally
    //   77	98	177	finally
    //   187	197	177	finally
    //   213	223	177	finally
    //   239	249	177	finally
    //   42	50	181	java/lang/IllegalStateException
    //   53	61	181	java/lang/IllegalStateException
    //   64	72	181	java/lang/IllegalStateException
    //   77	98	181	java/lang/IllegalStateException
    //   42	50	207	java/io/IOException
    //   53	61	207	java/io/IOException
    //   64	72	207	java/io/IOException
    //   77	98	207	java/io/IOException
    //   42	50	233	java/io/FileNotFoundException
    //   53	61	233	java/io/FileNotFoundException
    //   64	72	233	java/io/FileNotFoundException
    //   77	98	233	java/io/FileNotFoundException
    //   109	114	271	java/lang/Exception
    //   135	140	274	java/lang/Exception
    //   142	147	277	java/lang/Exception
    //   201	205	281	java/lang/Exception
    //   227	231	284	java/lang/Exception
    //   253	257	287	java/lang/Exception
    //   263	267	290	java/lang/Exception
  }
  
  public static boolean a(Bitmap paramBitmap, String paramString)
  {
    return a(paramBitmap, Bitmap.CompressFormat.JPEG, 80, paramString);
  }
  
  private static boolean a(RectF paramRectF1, RectF paramRectF2, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    paramInt1 = (int)(1 + Math.max(paramInt1, paramInt2) / 1000.0F);
    float f1 = Math.abs(paramRectF1.left - paramRectF2.left);
    float f2 = paramInt1;
    boolean bool1 = bool2;
    if (f1 <= f2)
    {
      bool1 = bool2;
      if (Math.abs(paramRectF1.top - paramRectF2.top) <= f2)
      {
        bool1 = bool2;
        if (Math.abs(paramRectF1.bottom - paramRectF2.bottom) <= f2)
        {
          if (Math.abs(paramRectF1.right - paramRectF2.right) > f2) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString != null) {
      try
      {
        Bitmap localBitmap = a(paramString, null);
        FileUtils.deleteDirectory(paramString);
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
    float f1 = i * 1.0F / j;
    float f2 = paramInt1;
    float f3 = paramInt2;
    int k;
    if (f1 > 1.0F * f2 / f3)
    {
      k = Math.round(f2 / f1);
      localObject1 = new Rect(0, (paramInt2 - k) / 2, paramInt1, Math.round(f3 / 2.0F + k / 2.0F));
    }
    else
    {
      k = Math.round(f3 * f1);
      localObject1 = new Rect((paramInt1 - k) / 2, 0, Math.round(f2 / 2.0F + k / 2.0F), paramInt2);
    }
    SLog.c("BitmapUtils", "resizeAndFillBitmapEdge srcWidth=%s, srcHeight=%s, targetWidth=%s, targetHeight=%s, destRect=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject1 });
    localCanvas.drawBitmap(paramBitmap, null, (Rect)localObject1, new Paint(6));
    localCanvas.setBitmap(null);
    if (paramBoolean2) {
      a(paramBitmap);
    }
    return localObject2;
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
    //   0: aload_0
    //   1: ifnull +260 -> 261
    //   4: aload_0
    //   5: invokevirtual 433	android/graphics/Bitmap:isRecycled	()Z
    //   8: ifne +253 -> 261
    //   11: aload_1
    //   12: ifnull +238 -> 250
    //   15: aconst_null
    //   16: astore 5
    //   18: aconst_null
    //   19: astore_3
    //   20: new 518	java/io/DataOutputStream
    //   23: dup
    //   24: new 453	java/io/FileOutputStream
    //   27: dup
    //   28: new 293	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 294	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: invokespecial 454	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: invokespecial 521	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   42: astore 4
    //   44: aload_3
    //   45: astore_1
    //   46: aload 4
    //   48: sipush 187
    //   51: invokevirtual 524	java/io/DataOutputStream:writeInt	(I)V
    //   54: aload_3
    //   55: astore_1
    //   56: aload 4
    //   58: iconst_1
    //   59: invokevirtual 524	java/io/DataOutputStream:writeInt	(I)V
    //   62: aload_3
    //   63: astore_1
    //   64: aload 4
    //   66: aload_0
    //   67: invokevirtual 159	android/graphics/Bitmap:isMutable	()Z
    //   70: invokevirtual 528	java/io/DataOutputStream:writeBoolean	(Z)V
    //   73: aload_3
    //   74: astore_1
    //   75: aload 4
    //   77: aload_0
    //   78: invokevirtual 17	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   81: invokevirtual 531	android/graphics/Bitmap$Config:ordinal	()I
    //   84: invokevirtual 524	java/io/DataOutputStream:writeInt	(I)V
    //   87: aload_3
    //   88: astore_1
    //   89: aload 4
    //   91: aload_0
    //   92: invokevirtual 45	android/graphics/Bitmap:getWidth	()I
    //   95: invokevirtual 524	java/io/DataOutputStream:writeInt	(I)V
    //   98: aload_3
    //   99: astore_1
    //   100: aload 4
    //   102: aload_0
    //   103: invokevirtual 54	android/graphics/Bitmap:getHeight	()I
    //   106: invokevirtual 524	java/io/DataOutputStream:writeInt	(I)V
    //   109: aload_3
    //   110: astore_1
    //   111: aload 4
    //   113: aload_0
    //   114: invokevirtual 534	android/graphics/Bitmap:getRowBytes	()I
    //   117: invokevirtual 524	java/io/DataOutputStream:writeInt	(I)V
    //   120: aload_3
    //   121: astore_1
    //   122: aload 4
    //   124: aload_0
    //   125: invokevirtual 142	android/graphics/Bitmap:getDensity	()I
    //   128: invokevirtual 524	java/io/DataOutputStream:writeInt	(I)V
    //   131: aload_2
    //   132: ifnull +17 -> 149
    //   135: aload_3
    //   136: astore_1
    //   137: aload_2
    //   138: aload_0
    //   139: invokevirtual 537	android/graphics/Bitmap:getByteCount	()I
    //   142: invokevirtual 313	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	(I)[B
    //   145: astore_3
    //   146: goto +12 -> 158
    //   149: aload_3
    //   150: astore_1
    //   151: aload_0
    //   152: invokevirtual 537	android/graphics/Bitmap:getByteCount	()I
    //   155: newarray byte
    //   157: astore_3
    //   158: aload_3
    //   159: astore_1
    //   160: aload_0
    //   161: aload_3
    //   162: invokestatic 323	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   165: invokevirtual 540	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   168: aload_3
    //   169: astore_1
    //   170: aload 4
    //   172: aload_3
    //   173: arraylength
    //   174: invokevirtual 524	java/io/DataOutputStream:writeInt	(I)V
    //   177: aload_3
    //   178: astore_1
    //   179: aload 4
    //   181: aload_3
    //   182: iconst_0
    //   183: aload_3
    //   184: arraylength
    //   185: invokevirtual 544	java/io/DataOutputStream:write	([BII)V
    //   188: aload_3
    //   189: astore_1
    //   190: aload 4
    //   192: invokevirtual 547	java/io/DataOutputStream:flush	()V
    //   195: aload_2
    //   196: ifnull +12 -> 208
    //   199: aload_3
    //   200: ifnull +8 -> 208
    //   203: aload_2
    //   204: aload_3
    //   205: invokevirtual 330	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   208: aload 4
    //   210: invokevirtual 548	java/io/DataOutputStream:close	()V
    //   213: return
    //   214: astore_0
    //   215: aload 4
    //   217: astore_3
    //   218: goto +9 -> 227
    //   221: astore_0
    //   222: aconst_null
    //   223: astore_3
    //   224: aload 5
    //   226: astore_1
    //   227: aload_2
    //   228: ifnull +12 -> 240
    //   231: aload_1
    //   232: ifnull +8 -> 240
    //   235: aload_2
    //   236: aload_1
    //   237: invokevirtual 330	com/tencent/biz/qqstory/utils/BitmapUtils$ByteArrayRecycler:a	([B)V
    //   240: aload_3
    //   241: ifnull +7 -> 248
    //   244: aload_3
    //   245: invokevirtual 548	java/io/DataOutputStream:close	()V
    //   248: aload_0
    //   249: athrow
    //   250: new 344	java/lang/IllegalArgumentException
    //   253: dup
    //   254: ldc_w 550
    //   257: invokespecial 347	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   260: athrow
    //   261: new 344	java/lang/IllegalArgumentException
    //   264: dup
    //   265: ldc_w 552
    //   268: invokespecial 347	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   271: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramBitmap	Bitmap
    //   0	272	1	paramString	String
    //   0	272	2	paramByteArrayRecycler	BitmapUtils.ByteArrayRecycler
    //   19	226	3	localObject1	Object
    //   42	174	4	localDataOutputStream	java.io.DataOutputStream
    //   16	209	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   46	54	214	finally
    //   56	62	214	finally
    //   64	73	214	finally
    //   75	87	214	finally
    //   89	98	214	finally
    //   100	109	214	finally
    //   111	120	214	finally
    //   122	131	214	finally
    //   137	146	214	finally
    //   151	158	214	finally
    //   160	168	214	finally
    //   170	177	214	finally
    //   179	188	214	finally
    //   190	195	214	finally
    //   20	44	221	finally
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
      paramInt2 = Math.round(i / f2);
      paramInt1 = i;
    }
    else
    {
      paramInt1 = Math.round(j * f2);
      paramInt2 = j;
    }
    Object localObject2 = paramBitmap.getConfig();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Bitmap.Config.ARGB_8888;
    }
    localObject1 = a(paramInt1, paramInt2, (Bitmap.Config)localObject1, false);
    if (localObject1 == null) {
      return null;
    }
    localObject2 = new Canvas((Bitmap)localObject1);
    if (!paramBoolean1) {
      ((Canvas)localObject2).drawColor(-16777216);
    }
    Paint localPaint = new Paint(6);
    ((Canvas)localObject2).drawBitmap(paramBitmap, (paramInt1 - i) / 2, (paramInt2 - j) / 2, localPaint);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */