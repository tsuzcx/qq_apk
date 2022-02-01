package com.tencent.mobileqq.avatar.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.face.FaceConstant.Apollo;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public class ApolloUtil
{
  public static int a(int paramInt)
  {
    return paramInt >>> 4 & 0xF;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 << 4 | paramInt2;
  }
  
  public static int a(String paramString)
  {
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (Exception paramString)
    {
      long l;
      label8:
      break label8;
    }
    l = 0L;
    return FaceConstant.Apollo.FACE_BG_COLOR_INDEXED[((int)(l % FaceConstant.Apollo.FACE_BG_COLOR_INDEXED.length))];
  }
  
  public static Bitmap a(Bitmap paramBitmap, String paramString, int paramInt)
  {
    Object localObject = null;
    Canvas localCanvas = null;
    if ((paramInt == 3) || (paramInt == 4) || (paramInt == 2))
    {
      paramInt = a(paramString);
      float f2 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
      int i = paramBitmap.getWidth();
      float f1 = f2;
      if (i > 0)
      {
        float f3 = i;
        float f4 = 40;
        f1 = f2;
        if (f3 < f2 * f4) {
          f1 = f3 / f4;
        }
      }
      i = (int)(40 * f1);
      f1 = i;
      RectF localRectF1 = new RectF(0.0F, 0.0F, f1, f1);
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      paramString = localCanvas;
      try
      {
        localObject = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        paramString = (String)localObject;
        localCanvas = new Canvas((Bitmap)localObject);
        paramString = (String)localObject;
        Paint localPaint = new Paint();
        paramString = (String)localObject;
        localPaint.setAntiAlias(true);
        paramString = (String)localObject;
        localPaint.setDither(true);
        paramString = (String)localObject;
        localPaint.setFilterBitmap(true);
        paramString = (String)localObject;
        localCanvas.drawARGB(0, 0, 0, 0);
        paramString = (String)localObject;
        localPaint.setColor(paramInt);
        paramString = (String)localObject;
        RectF localRectF2 = new RectF(0.0F, 0.0F, f1, f1);
        paramString = (String)localObject;
        f1 /= 2.0F;
        paramString = (String)localObject;
        localCanvas.drawRoundRect(localRectF2, f1, f1, localPaint);
        paramString = (String)localObject;
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        paramString = (String)localObject;
        localCanvas.drawBitmap(paramBitmap, localRect, localRectF1, localPaint);
        return localObject;
      }
      catch (Throwable paramBitmap)
      {
        QLog.d("ApolloUtil", 1, new Object[] { "getApolloRoundHeadWithColorBg throw= ", paramBitmap.getMessage(), paramBitmap });
        localObject = paramString;
      }
    }
    return localObject;
  }
  
  private static Bitmap a(String paramString, int paramInt)
  {
    return ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getBitmapWithCache(paramString, paramInt);
  }
  
  public static String a(int paramInt)
  {
    int i = b(paramInt);
    paramInt = a(paramInt);
    String str1 = b(i);
    String str2 = c(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append("/");
    localStringBuilder.append(str1);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    if (paramInt != 116) {
      return;
    }
    int[] arrayOfInt = FaceConstant.Apollo.FACE_SPEC_ALL;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = ((IQQAvatarDataService)paramAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(null, paramInt, paramString, 200, k);
      try
      {
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("ApolloUtil", 1, new Object[] { "removeFaceFileCacheApollo throw = ", localThrowable.getMessage(), localThrowable });
      }
      i += 1;
    }
  }
  
  public static int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = new int[paramArrayOfInt1.length * paramArrayOfInt2.length];
    int m = paramArrayOfInt1.length;
    int j = 0;
    int i = 0;
    while (j < m)
    {
      int n = paramArrayOfInt1[j];
      int i1 = paramArrayOfInt2.length;
      int k = 0;
      while (k < i1)
      {
        arrayOfInt[i] = a(n, paramArrayOfInt2[k]);
        i += 1;
        k += 1;
      }
      j += 1;
    }
    return arrayOfInt;
  }
  
  public static int b(int paramInt)
  {
    return paramInt & 0xF;
  }
  
  /* Error */
  public static Bitmap b(Bitmap paramBitmap, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: iconst_3
    //   2: if_icmpeq +18 -> 20
    //   5: iload_2
    //   6: iconst_4
    //   7: if_icmpeq +13 -> 20
    //   10: iload_2
    //   11: iconst_2
    //   12: if_icmpne +6 -> 18
    //   15: goto +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_1
    //   21: invokestatic 32	com/tencent/mobileqq/avatar/utils/ApolloUtil:a	(Ljava/lang/String;)I
    //   24: istore 6
    //   26: invokestatic 38	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   29: invokevirtual 42	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   32: invokevirtual 48	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   35: getfield 54	android/util/DisplayMetrics:density	F
    //   38: fstore_3
    //   39: fload_3
    //   40: ldc 218
    //   42: fmul
    //   43: f2i
    //   44: istore 7
    //   46: fload_3
    //   47: ldc 219
    //   49: fmul
    //   50: f2i
    //   51: istore 8
    //   53: new 62	android/graphics/RectF
    //   56: dup
    //   57: fconst_0
    //   58: fconst_0
    //   59: iload 7
    //   61: i2f
    //   62: iload 8
    //   64: i2f
    //   65: invokespecial 65	android/graphics/RectF:<init>	(FFFF)V
    //   68: astore 12
    //   70: iload_2
    //   71: iconst_4
    //   72: if_icmpne +8 -> 80
    //   75: iconst_1
    //   76: istore_2
    //   77: goto +5 -> 82
    //   80: iconst_0
    //   81: istore_2
    //   82: iload_2
    //   83: ifeq +9 -> 92
    //   86: bipush 120
    //   88: istore_2
    //   89: goto +6 -> 95
    //   92: bipush 80
    //   94: istore_2
    //   95: aload_0
    //   96: invokevirtual 70	android/graphics/Bitmap:getHeight	()I
    //   99: i2f
    //   100: ldc 219
    //   102: fmul
    //   103: iload_2
    //   104: i2f
    //   105: fdiv
    //   106: f2i
    //   107: istore 9
    //   109: iload 9
    //   111: i2f
    //   112: ldc 218
    //   114: fmul
    //   115: ldc 219
    //   117: fdiv
    //   118: f2i
    //   119: istore 5
    //   121: iload 5
    //   123: aload_0
    //   124: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   127: if_icmple +14 -> 141
    //   130: aload_0
    //   131: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   134: istore 5
    //   136: iconst_1
    //   137: istore_2
    //   138: goto +5 -> 143
    //   141: iconst_0
    //   142: istore_2
    //   143: aload_0
    //   144: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   147: iload 5
    //   149: isub
    //   150: i2f
    //   151: fconst_2
    //   152: fdiv
    //   153: f2i
    //   154: istore 10
    //   156: new 67	android/graphics/Rect
    //   159: dup
    //   160: iload 10
    //   162: iconst_0
    //   163: iload 5
    //   165: iload 10
    //   167: iadd
    //   168: iload 9
    //   170: invokespecial 73	android/graphics/Rect:<init>	(IIII)V
    //   173: astore 13
    //   175: ldc 220
    //   177: fload_3
    //   178: fmul
    //   179: f2i
    //   180: iconst_2
    //   181: idiv
    //   182: istore 5
    //   184: ldc 221
    //   186: fload_3
    //   187: fmul
    //   188: f2i
    //   189: istore 9
    //   191: fload_3
    //   192: ldc 222
    //   194: fmul
    //   195: f2i
    //   196: istore 10
    //   198: iload 9
    //   200: i2f
    //   201: fstore_3
    //   202: iload 10
    //   204: i2f
    //   205: fstore 4
    //   207: iload 5
    //   209: iconst_2
    //   210: imul
    //   211: istore 11
    //   213: new 62	android/graphics/RectF
    //   216: dup
    //   217: fload_3
    //   218: fload 4
    //   220: iload 9
    //   222: iload 11
    //   224: iadd
    //   225: i2f
    //   226: iload 10
    //   228: iload 11
    //   230: iadd
    //   231: i2f
    //   232: invokespecial 65	android/graphics/RectF:<init>	(FFFF)V
    //   235: astore 14
    //   237: iload 7
    //   239: iload 8
    //   241: getstatic 79	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   244: invokestatic 83	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   247: astore_1
    //   248: ldc 224
    //   250: ldc 225
    //   252: invokestatic 227	com/tencent/mobileqq/avatar/utils/ApolloUtil:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   255: astore 15
    //   257: new 85	android/graphics/Canvas
    //   260: dup
    //   261: aload_1
    //   262: invokespecial 88	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   265: astore 16
    //   267: new 90	android/graphics/Paint
    //   270: dup
    //   271: invokespecial 91	android/graphics/Paint:<init>	()V
    //   274: astore 17
    //   276: aload 17
    //   278: iconst_1
    //   279: invokevirtual 95	android/graphics/Paint:setAntiAlias	(Z)V
    //   282: aload 17
    //   284: iconst_1
    //   285: invokevirtual 98	android/graphics/Paint:setDither	(Z)V
    //   288: aload 17
    //   290: iconst_1
    //   291: invokevirtual 101	android/graphics/Paint:setFilterBitmap	(Z)V
    //   294: aload 16
    //   296: iconst_0
    //   297: iconst_0
    //   298: iconst_0
    //   299: iconst_0
    //   300: invokevirtual 104	android/graphics/Canvas:drawARGB	(IIII)V
    //   303: aload 17
    //   305: iload 6
    //   307: invokevirtual 108	android/graphics/Paint:setColor	(I)V
    //   310: iload 5
    //   312: i2f
    //   313: fstore_3
    //   314: aload 16
    //   316: aload 14
    //   318: fload_3
    //   319: fload_3
    //   320: aload 17
    //   322: invokevirtual 112	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   325: aload 17
    //   327: new 114	android/graphics/PorterDuffXfermode
    //   330: dup
    //   331: getstatic 230	android/graphics/PorterDuff$Mode:SRC_OVER	Landroid/graphics/PorterDuff$Mode;
    //   334: invokespecial 123	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   337: invokevirtual 127	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   340: pop
    //   341: iload_2
    //   342: ifeq +75 -> 417
    //   345: aload 13
    //   347: invokevirtual 233	android/graphics/Rect:width	()I
    //   350: i2f
    //   351: aload 12
    //   353: invokevirtual 237	android/graphics/RectF:height	()F
    //   356: fmul
    //   357: aload 13
    //   359: invokevirtual 239	android/graphics/Rect:height	()I
    //   362: i2f
    //   363: fdiv
    //   364: f2i
    //   365: istore_2
    //   366: aload 12
    //   368: invokevirtual 241	android/graphics/RectF:width	()F
    //   371: iload_2
    //   372: i2f
    //   373: fsub
    //   374: fconst_2
    //   375: fdiv
    //   376: f2i
    //   377: istore 5
    //   379: aload 16
    //   381: aload_0
    //   382: aload 13
    //   384: new 62	android/graphics/RectF
    //   387: dup
    //   388: iload 5
    //   390: i2f
    //   391: aload 12
    //   393: getfield 244	android/graphics/RectF:top	F
    //   396: iload 5
    //   398: iload_2
    //   399: iadd
    //   400: i2f
    //   401: aload 12
    //   403: getfield 247	android/graphics/RectF:bottom	F
    //   406: invokespecial 65	android/graphics/RectF:<init>	(FFFF)V
    //   409: aload 17
    //   411: invokevirtual 131	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   414: goto +15 -> 429
    //   417: aload 16
    //   419: aload_0
    //   420: aload 13
    //   422: aload 12
    //   424: aload 17
    //   426: invokevirtual 131	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   429: aload 15
    //   431: ifnull +49 -> 480
    //   434: aload 17
    //   436: new 114	android/graphics/PorterDuffXfermode
    //   439: dup
    //   440: getstatic 250	android/graphics/PorterDuff$Mode:DST_OUT	Landroid/graphics/PorterDuff$Mode;
    //   443: invokespecial 123	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   446: invokevirtual 127	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   449: pop
    //   450: aload 16
    //   452: aload 15
    //   454: new 67	android/graphics/Rect
    //   457: dup
    //   458: iconst_0
    //   459: iconst_0
    //   460: aload 15
    //   462: invokevirtual 60	android/graphics/Bitmap:getWidth	()I
    //   465: aload 15
    //   467: invokevirtual 70	android/graphics/Bitmap:getHeight	()I
    //   470: invokespecial 73	android/graphics/Rect:<init>	(IIII)V
    //   473: aload 12
    //   475: aload 17
    //   477: invokevirtual 131	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   480: aload_1
    //   481: areturn
    //   482: astore 12
    //   484: aload_1
    //   485: astore_0
    //   486: aload 12
    //   488: astore_1
    //   489: goto +6 -> 495
    //   492: astore_1
    //   493: aconst_null
    //   494: astore_0
    //   495: ldc 133
    //   497: iconst_1
    //   498: iconst_3
    //   499: anewarray 4	java/lang/Object
    //   502: dup
    //   503: iconst_0
    //   504: ldc 252
    //   506: aastore
    //   507: dup
    //   508: iconst_1
    //   509: aload_1
    //   510: invokevirtual 139	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   513: aastore
    //   514: dup
    //   515: iconst_2
    //   516: aload_1
    //   517: aastore
    //   518: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   521: aload_0
    //   522: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	paramBitmap	Bitmap
    //   0	523	1	paramString	String
    //   0	523	2	paramInt	int
    //   38	282	3	f1	float
    //   205	14	4	f2	float
    //   119	281	5	i	int
    //   24	282	6	j	int
    //   44	194	7	k	int
    //   51	189	8	m	int
    //   107	118	9	n	int
    //   154	77	10	i1	int
    //   211	20	11	i2	int
    //   68	406	12	localRectF1	RectF
    //   482	5	12	localThrowable	Throwable
    //   173	248	13	localRect	Rect
    //   235	82	14	localRectF2	RectF
    //   255	211	15	localBitmap	Bitmap
    //   265	186	16	localCanvas	Canvas
    //   274	202	17	localPaint	Paint
    // Exception table:
    //   from	to	target	type
    //   248	310	482	java/lang/Throwable
    //   314	341	482	java/lang/Throwable
    //   345	414	482	java/lang/Throwable
    //   417	429	482	java/lang/Throwable
    //   434	480	482	java/lang/Throwable
    //   237	248	492	java/lang/Throwable
  }
  
  private static String b(int paramInt)
  {
    String str = "100";
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return "100";
        }
        return "640";
      }
      str = "140";
    }
    return str;
  }
  
  private static String c(int paramInt)
  {
    String str = "head";
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return "head";
      }
      str = "body";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.utils.ApolloUtil
 * JD-Core Version:    0.7.0.1
 */