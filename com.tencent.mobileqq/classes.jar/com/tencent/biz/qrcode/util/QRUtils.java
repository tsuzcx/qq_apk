package com.tencent.biz.qrcode.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.biz.qrcode.QRActionEntity;
import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import com.tencent.biz.qrcode.QRCodeServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.QrCodeConfBean;
import com.tencent.mobileqq.config.business.QrCodeConfBean.QrCodeList;
import com.tencent.mobileqq.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BaseQRUtil;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class QRUtils
  extends BaseQRUtil
{
  protected static String a = "^https?://qm\\.qq\\.com/cgi-bin/qm/qr\\?.+";
  protected static String b = ".*(\\+86|086)?\\d{5,12}.*";
  protected static String c = "58.250.135.158";
  protected static String d = "120.198.189.104";
  protected static String e = "182.254.1.144";
  private static String h = "^https?://qm\\.qq\\.com/cgi-bin/dc/ft\\?.+";
  private static String i = "^https?://url\\.cn/.+#flyticket";
  
  protected static int a(int paramInt)
  {
    if (paramInt < 21) {
      return 1;
    }
    if (paramInt > 177) {
      return 39;
    }
    return (paramInt - 21) / 4 + 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int j = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("my_qr_code_cfg_sp_index", -1);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "getMyQrBgIndexFromSp().settingValue:" + j);
    }
    return j;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    while (!QVipQidProcessor.c().b) {
      return 1;
    }
    return paramQQAppInterface.getApp().getSharedPreferences("sp_vip_qid_info", 0).getInt("user_qr_card_type" + paramString, 1);
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int k = paramArrayOfByte.length;
    int j = 0;
    while (j < k)
    {
      l += ((paramArrayOfByte[(k - j - 1)] & 0xFF) << j * 8);
      j += 1;
    }
    return l;
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    int j = Math.min(750, ScreenUtil.getRealWidth(paramContext));
    int k = Math.min(1344, ScreenUtil.getRealHeight(paramContext));
    try
    {
      paramContext = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
      if (paramContext == null)
      {
        QLog.d("QRUtils", 1, "QID_QR,getQidQrCard() myCode == null || myShare == null");
        return paramContext;
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.w("QRUtils", 1, paramContext.getMessage());
      return null;
    }
    Canvas localCanvas = new Canvas(paramContext);
    a(paramBitmap1, j, k, localCanvas);
    a(paramBitmap2, j, localCanvas);
    return paramContext;
  }
  
  /* Error */
  public static final Bitmap a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, String paramString1, Bitmap paramBitmap3, Bitmap paramBitmap4, int paramInt2, int paramInt3, String paramString2, Rect paramRect, ArrayList<Rect> paramArrayList, int paramInt4)
  {
    // Byte code:
    //   0: sipush 540
    //   3: sipush 740
    //   6: getstatic 145	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   9: invokestatic 151	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   12: astore 15
    //   14: iload 12
    //   16: ifeq +1251 -> 1267
    //   19: aload_0
    //   20: invokevirtual 181	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   23: iload 12
    //   25: invokestatic 187	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   28: astore 14
    //   30: aload 15
    //   32: ifnonnull +24 -> 56
    //   35: aconst_null
    //   36: areturn
    //   37: astore_0
    //   38: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +13 -> 54
    //   44: ldc 80
    //   46: iconst_2
    //   47: aload_0
    //   48: invokevirtual 158	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   51: invokestatic 161	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aconst_null
    //   55: areturn
    //   56: new 163	android/graphics/Canvas
    //   59: dup
    //   60: aload 15
    //   62: invokespecial 166	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   65: astore 16
    //   67: aload_1
    //   68: ifnull +672 -> 740
    //   71: new 189	android/graphics/Paint
    //   74: dup
    //   75: invokespecial 190	android/graphics/Paint:<init>	()V
    //   78: astore 17
    //   80: new 192	android/graphics/Rect
    //   83: dup
    //   84: iconst_0
    //   85: iconst_0
    //   86: sipush 540
    //   89: sipush 740
    //   92: invokespecial 195	android/graphics/Rect:<init>	(IIII)V
    //   95: astore 18
    //   97: aload 17
    //   99: iconst_1
    //   100: invokevirtual 199	android/graphics/Paint:setAntiAlias	(Z)V
    //   103: aload 16
    //   105: aload_1
    //   106: aconst_null
    //   107: aload 18
    //   109: aload 17
    //   111: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   114: aload_2
    //   115: ifnull +41 -> 156
    //   118: new 189	android/graphics/Paint
    //   121: dup
    //   122: invokespecial 190	android/graphics/Paint:<init>	()V
    //   125: astore_1
    //   126: aload_1
    //   127: iconst_1
    //   128: invokevirtual 199	android/graphics/Paint:setAntiAlias	(Z)V
    //   131: aload 16
    //   133: aload_2
    //   134: aconst_null
    //   135: new 192	android/graphics/Rect
    //   138: dup
    //   139: bipush 20
    //   141: sipush 621
    //   144: bipush 120
    //   146: sipush 721
    //   149: invokespecial 195	android/graphics/Rect:<init>	(IIII)V
    //   152: aload_1
    //   153: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   156: iconst_0
    //   157: istore 12
    //   159: aload 14
    //   161: ifnull +52 -> 213
    //   164: iconst_1
    //   165: istore 12
    //   167: new 189	android/graphics/Paint
    //   170: dup
    //   171: invokespecial 190	android/graphics/Paint:<init>	()V
    //   174: astore_1
    //   175: aload_1
    //   176: iconst_1
    //   177: invokevirtual 199	android/graphics/Paint:setAntiAlias	(Z)V
    //   180: aload_1
    //   181: iconst_1
    //   182: invokevirtual 206	android/graphics/Paint:setFilterBitmap	(Z)V
    //   185: aload 16
    //   187: aload 14
    //   189: aconst_null
    //   190: new 192	android/graphics/Rect
    //   193: dup
    //   194: sipush 140
    //   197: sipush 633
    //   200: sipush 176
    //   203: sipush 669
    //   206: invokespecial 195	android/graphics/Rect:<init>	(IIII)V
    //   209: aload_1
    //   210: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   213: new 189	android/graphics/Paint
    //   216: dup
    //   217: invokespecial 190	android/graphics/Paint:<init>	()V
    //   220: astore 17
    //   222: aload 17
    //   224: getstatic 212	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   227: invokevirtual 216	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   230: aload 17
    //   232: iconst_1
    //   233: invokevirtual 199	android/graphics/Paint:setAntiAlias	(Z)V
    //   236: aload 17
    //   238: iload_3
    //   239: invokevirtual 220	android/graphics/Paint:setColor	(I)V
    //   242: aload 17
    //   244: ldc 221
    //   246: invokevirtual 225	android/graphics/Paint:setTextSize	(F)V
    //   249: aload 17
    //   251: iconst_1
    //   252: invokevirtual 228	android/graphics/Paint:setFlags	(I)V
    //   255: aload 17
    //   257: getstatic 234	android/graphics/Typeface:SANS_SERIF	Landroid/graphics/Typeface;
    //   260: invokevirtual 238	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   263: pop
    //   264: iload 12
    //   266: ifeq +578 -> 844
    //   269: sipush 342
    //   272: istore_3
    //   273: aload 4
    //   275: ifnull +114 -> 389
    //   278: iconst_2
    //   279: aload 4
    //   281: invokevirtual 244	java/lang/String:length	()I
    //   284: invokestatic 247	java/lang/Math:max	(II)I
    //   287: istore 13
    //   289: aload 4
    //   291: astore 14
    //   293: aload 17
    //   295: aload 4
    //   297: invokevirtual 251	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   300: iload_3
    //   301: i2f
    //   302: fcmpl
    //   303: ifle +63 -> 366
    //   306: iload 13
    //   308: iconst_2
    //   309: isub
    //   310: istore 13
    //   312: new 82	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   319: aload 4
    //   321: iconst_0
    //   322: iload 13
    //   324: invokevirtual 255	java/lang/String:substring	(II)Ljava/lang/String;
    //   327: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc_w 257
    //   333: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: astore_1
    //   340: aload_1
    //   341: astore 14
    //   343: iload 13
    //   345: ifle +21 -> 366
    //   348: aload_1
    //   349: astore 4
    //   351: aload 17
    //   353: aload_1
    //   354: invokevirtual 251	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   357: iload_3
    //   358: i2f
    //   359: fcmpl
    //   360: ifgt -54 -> 306
    //   363: aload_1
    //   364: astore 14
    //   366: iload 12
    //   368: ifeq +483 -> 851
    //   371: sipush 182
    //   374: istore_3
    //   375: aload 16
    //   377: aload 14
    //   379: iload_3
    //   380: i2f
    //   381: ldc_w 258
    //   384: aload 17
    //   386: invokevirtual 262	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   389: aload 5
    //   391: ifnull +27 -> 418
    //   394: aload 16
    //   396: aload 5
    //   398: aconst_null
    //   399: new 192	android/graphics/Rect
    //   402: dup
    //   403: iconst_0
    //   404: iconst_0
    //   405: sipush 540
    //   408: sipush 600
    //   411: invokespecial 195	android/graphics/Rect:<init>	(IIII)V
    //   414: aconst_null
    //   415: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   418: aload 10
    //   420: ifnull +438 -> 858
    //   423: aload 6
    //   425: astore_1
    //   426: invokestatic 264	com/tencent/biz/qrcode/util/QRUtils:a	()Z
    //   429: ifeq +150 -> 579
    //   432: aload 6
    //   434: astore_1
    //   435: aload 10
    //   437: invokevirtual 267	android/graphics/Rect:width	()I
    //   440: sipush 350
    //   443: if_icmple +136 -> 579
    //   446: aload 6
    //   448: astore_1
    //   449: aload 10
    //   451: invokevirtual 270	android/graphics/Rect:height	()I
    //   454: sipush 350
    //   457: if_icmple +122 -> 579
    //   460: aload 6
    //   462: astore_1
    //   463: aload 6
    //   465: ifnull +114 -> 579
    //   468: aload 6
    //   470: aload 10
    //   472: invokevirtual 267	android/graphics/Rect:width	()I
    //   475: iconst_2
    //   476: idiv
    //   477: aload 10
    //   479: invokevirtual 270	android/graphics/Rect:height	()I
    //   482: iconst_2
    //   483: idiv
    //   484: iconst_0
    //   485: invokestatic 274	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   488: astore 4
    //   490: aload 6
    //   492: astore_1
    //   493: aload 4
    //   495: ifnull +84 -> 579
    //   498: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +75 -> 576
    //   504: ldc 80
    //   506: iconst_2
    //   507: new 82	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   514: ldc_w 276
    //   517: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload 4
    //   522: invokevirtual 279	android/graphics/Bitmap:getWidth	()I
    //   525: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   528: ldc_w 281
    //   531: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload 4
    //   536: invokevirtual 284	android/graphics/Bitmap:getHeight	()I
    //   539: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: ldc_w 286
    //   545: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload 6
    //   550: invokevirtual 279	android/graphics/Bitmap:getWidth	()I
    //   553: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   556: ldc_w 288
    //   559: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload 6
    //   564: invokevirtual 284	android/graphics/Bitmap:getHeight	()I
    //   567: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   570: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 161	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: aload 4
    //   578: astore_1
    //   579: aload 11
    //   581: ifnull +477 -> 1058
    //   584: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +49 -> 636
    //   590: aload_1
    //   591: ifnull +45 -> 636
    //   594: ldc 80
    //   596: iconst_2
    //   597: new 82	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   604: ldc_w 290
    //   607: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload_1
    //   611: invokevirtual 279	android/graphics/Bitmap:getWidth	()I
    //   614: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   617: ldc_w 281
    //   620: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload_1
    //   624: invokevirtual 284	android/graphics/Bitmap:getHeight	()I
    //   627: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   630: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 161	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   636: aload_1
    //   637: aload 10
    //   639: invokevirtual 267	android/graphics/Rect:width	()I
    //   642: aload 10
    //   644: invokevirtual 270	android/graphics/Rect:height	()I
    //   647: iconst_0
    //   648: invokestatic 274	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   651: astore_1
    //   652: new 163	android/graphics/Canvas
    //   655: dup
    //   656: aload_1
    //   657: invokespecial 166	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   660: astore 4
    //   662: new 189	android/graphics/Paint
    //   665: dup
    //   666: invokespecial 190	android/graphics/Paint:<init>	()V
    //   669: astore 5
    //   671: aload 5
    //   673: iconst_0
    //   674: invokevirtual 293	android/graphics/Paint:setAlpha	(I)V
    //   677: aload 5
    //   679: iconst_1
    //   680: invokevirtual 199	android/graphics/Paint:setAntiAlias	(Z)V
    //   683: aload 5
    //   685: new 295	android/graphics/PorterDuffXfermode
    //   688: dup
    //   689: getstatic 301	android/graphics/PorterDuff$Mode:DST_IN	Landroid/graphics/PorterDuff$Mode;
    //   692: invokespecial 304	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   695: invokevirtual 308	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   698: pop
    //   699: iconst_0
    //   700: istore_3
    //   701: iload_3
    //   702: aload 11
    //   704: invokevirtual 313	java/util/ArrayList:size	()I
    //   707: if_icmpge +209 -> 916
    //   710: aload 4
    //   712: new 192	android/graphics/Rect
    //   715: dup
    //   716: aload 11
    //   718: iload_3
    //   719: invokevirtual 317	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   722: checkcast 192	android/graphics/Rect
    //   725: invokespecial 320	android/graphics/Rect:<init>	(Landroid/graphics/Rect;)V
    //   728: aload 5
    //   730: invokevirtual 324	android/graphics/Canvas:drawRect	(Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   733: iload_3
    //   734: iconst_1
    //   735: iadd
    //   736: istore_3
    //   737: goto -36 -> 701
    //   740: new 189	android/graphics/Paint
    //   743: dup
    //   744: invokespecial 190	android/graphics/Paint:<init>	()V
    //   747: astore_1
    //   748: aload_1
    //   749: new 326	android/graphics/LinearGradient
    //   752: dup
    //   753: fconst_0
    //   754: fconst_0
    //   755: fconst_0
    //   756: ldc_w 327
    //   759: ldc_w 328
    //   762: ldc_w 329
    //   765: getstatic 335	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   768: invokespecial 338	android/graphics/LinearGradient:<init>	(FFFFIILandroid/graphics/Shader$TileMode;)V
    //   771: invokevirtual 342	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   774: pop
    //   775: aload 16
    //   777: fconst_0
    //   778: fconst_0
    //   779: ldc_w 343
    //   782: ldc_w 327
    //   785: aload_1
    //   786: invokevirtual 346	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   789: aload_1
    //   790: aconst_null
    //   791: invokevirtual 342	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   794: pop
    //   795: aload_1
    //   796: ldc_w 347
    //   799: invokevirtual 220	android/graphics/Paint:setColor	(I)V
    //   802: aload 16
    //   804: fconst_0
    //   805: ldc_w 327
    //   808: ldc_w 343
    //   811: ldc_w 327
    //   814: aload_1
    //   815: invokevirtual 350	android/graphics/Canvas:drawLine	(FFFFLandroid/graphics/Paint;)V
    //   818: aload_1
    //   819: ldc_w 351
    //   822: invokevirtual 220	android/graphics/Paint:setColor	(I)V
    //   825: aload 16
    //   827: fconst_0
    //   828: ldc_w 352
    //   831: ldc_w 343
    //   834: ldc_w 353
    //   837: aload_1
    //   838: invokevirtual 346	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   841: goto -727 -> 114
    //   844: sipush 380
    //   847: istore_3
    //   848: goto -575 -> 273
    //   851: sipush 140
    //   854: istore_3
    //   855: goto -480 -> 375
    //   858: new 192	android/graphics/Rect
    //   861: dup
    //   862: bipush 70
    //   864: bipush 100
    //   866: sipush 470
    //   869: sipush 500
    //   872: invokespecial 195	android/graphics/Rect:<init>	(IIII)V
    //   875: astore 10
    //   877: goto -454 -> 423
    //   880: astore_1
    //   881: ldc 80
    //   883: iconst_2
    //   884: new 82	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   891: ldc_w 355
    //   894: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: aload_1
    //   898: invokevirtual 356	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   901: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 98	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: aload 6
    //   912: astore_1
    //   913: goto -334 -> 579
    //   916: aload 16
    //   918: aload_1
    //   919: aconst_null
    //   920: aload 10
    //   922: aconst_null
    //   923: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   926: aload_1
    //   927: invokevirtual 359	android/graphics/Bitmap:recycle	()V
    //   930: iload 7
    //   932: iconst_1
    //   933: if_icmpne +142 -> 1075
    //   936: new 189	android/graphics/Paint
    //   939: dup
    //   940: invokespecial 190	android/graphics/Paint:<init>	()V
    //   943: astore_1
    //   944: aload_1
    //   945: iconst_1
    //   946: invokevirtual 199	android/graphics/Paint:setAntiAlias	(Z)V
    //   949: new 192	android/graphics/Rect
    //   952: dup
    //   953: sipush 217
    //   956: sipush 247
    //   959: sipush 323
    //   962: sipush 353
    //   965: invokespecial 195	android/graphics/Rect:<init>	(IIII)V
    //   968: astore_2
    //   969: aload_0
    //   970: invokevirtual 181	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   973: ldc_w 360
    //   976: invokestatic 187	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   979: astore_0
    //   980: aload 16
    //   982: aload_0
    //   983: aconst_null
    //   984: aload_2
    //   985: aload_1
    //   986: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   989: aload_0
    //   990: invokevirtual 359	android/graphics/Bitmap:recycle	()V
    //   993: new 189	android/graphics/Paint
    //   996: dup
    //   997: invokespecial 190	android/graphics/Paint:<init>	()V
    //   1000: astore_0
    //   1001: aload_0
    //   1002: getstatic 212	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   1005: invokevirtual 216	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   1008: aload_0
    //   1009: iconst_1
    //   1010: invokevirtual 199	android/graphics/Paint:setAntiAlias	(Z)V
    //   1013: aload_0
    //   1014: iload 8
    //   1016: invokevirtual 220	android/graphics/Paint:setColor	(I)V
    //   1019: aload_0
    //   1020: ldc_w 361
    //   1023: invokevirtual 225	android/graphics/Paint:setTextSize	(F)V
    //   1026: aload_0
    //   1027: getstatic 234	android/graphics/Typeface:SANS_SERIF	Landroid/graphics/Typeface;
    //   1030: invokevirtual 238	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   1033: pop
    //   1034: aload 16
    //   1036: aload 9
    //   1038: ldc_w 362
    //   1041: ldc_w 363
    //   1044: aload_0
    //   1045: invokevirtual 262	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1048: aload 15
    //   1050: areturn
    //   1051: astore_0
    //   1052: aload_0
    //   1053: invokevirtual 366	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1056: aconst_null
    //   1057: areturn
    //   1058: aload_1
    //   1059: ifnull -129 -> 930
    //   1062: aload 16
    //   1064: aload_1
    //   1065: aconst_null
    //   1066: aload 10
    //   1068: aconst_null
    //   1069: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1072: goto -142 -> 930
    //   1075: iload 7
    //   1077: iconst_2
    //   1078: if_icmpne +57 -> 1135
    //   1081: aload_2
    //   1082: ifnull +53 -> 1135
    //   1085: new 189	android/graphics/Paint
    //   1088: dup
    //   1089: invokespecial 190	android/graphics/Paint:<init>	()V
    //   1092: astore_0
    //   1093: aload_0
    //   1094: iconst_1
    //   1095: invokevirtual 199	android/graphics/Paint:setAntiAlias	(Z)V
    //   1098: aload 16
    //   1100: aload_2
    //   1101: aconst_null
    //   1102: new 192	android/graphics/Rect
    //   1105: dup
    //   1106: sipush 217
    //   1109: sipush 247
    //   1112: sipush 323
    //   1115: sipush 353
    //   1118: invokespecial 195	android/graphics/Rect:<init>	(IIII)V
    //   1121: aload_0
    //   1122: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1125: goto -132 -> 993
    //   1128: astore_0
    //   1129: aload_0
    //   1130: invokevirtual 366	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1133: aconst_null
    //   1134: areturn
    //   1135: iload 7
    //   1137: iconst_3
    //   1138: if_icmpne +63 -> 1201
    //   1141: new 189	android/graphics/Paint
    //   1144: dup
    //   1145: invokespecial 190	android/graphics/Paint:<init>	()V
    //   1148: astore_1
    //   1149: aload_1
    //   1150: iconst_1
    //   1151: invokevirtual 199	android/graphics/Paint:setAntiAlias	(Z)V
    //   1154: new 192	android/graphics/Rect
    //   1157: dup
    //   1158: sipush 217
    //   1161: sipush 247
    //   1164: sipush 323
    //   1167: sipush 353
    //   1170: invokespecial 195	android/graphics/Rect:<init>	(IIII)V
    //   1173: astore_2
    //   1174: aload_0
    //   1175: invokevirtual 181	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1178: ldc_w 360
    //   1181: invokestatic 187	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1184: astore_0
    //   1185: aload 16
    //   1187: aload_0
    //   1188: aconst_null
    //   1189: aload_2
    //   1190: aload_1
    //   1191: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1194: aload_0
    //   1195: invokevirtual 359	android/graphics/Bitmap:recycle	()V
    //   1198: goto -205 -> 993
    //   1201: iload 7
    //   1203: iconst_4
    //   1204: if_icmpne -211 -> 993
    //   1207: new 189	android/graphics/Paint
    //   1210: dup
    //   1211: invokespecial 190	android/graphics/Paint:<init>	()V
    //   1214: astore_1
    //   1215: aload_1
    //   1216: iconst_1
    //   1217: invokevirtual 199	android/graphics/Paint:setAntiAlias	(Z)V
    //   1220: new 192	android/graphics/Rect
    //   1223: dup
    //   1224: sipush 217
    //   1227: sipush 247
    //   1230: sipush 323
    //   1233: sipush 353
    //   1236: invokespecial 195	android/graphics/Rect:<init>	(IIII)V
    //   1239: astore_2
    //   1240: aload_0
    //   1241: invokevirtual 181	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1244: ldc_w 360
    //   1247: invokestatic 187	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1250: astore_0
    //   1251: aload 16
    //   1253: aload_0
    //   1254: aconst_null
    //   1255: aload_2
    //   1256: aload_1
    //   1257: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1260: aload_0
    //   1261: invokevirtual 359	android/graphics/Bitmap:recycle	()V
    //   1264: goto -271 -> 993
    //   1267: aconst_null
    //   1268: astore 14
    //   1270: goto -1240 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1273	0	paramContext	Context
    //   0	1273	1	paramBitmap1	Bitmap
    //   0	1273	2	paramBitmap2	Bitmap
    //   0	1273	3	paramInt1	int
    //   0	1273	4	paramString1	String
    //   0	1273	5	paramBitmap3	Bitmap
    //   0	1273	6	paramBitmap4	Bitmap
    //   0	1273	7	paramInt2	int
    //   0	1273	8	paramInt3	int
    //   0	1273	9	paramString2	String
    //   0	1273	10	paramRect	Rect
    //   0	1273	11	paramArrayList	ArrayList<Rect>
    //   0	1273	12	paramInt4	int
    //   287	57	13	j	int
    //   28	1241	14	localObject	Object
    //   12	1037	15	localBitmap	Bitmap
    //   65	1187	16	localCanvas	Canvas
    //   78	307	17	localPaint	Paint
    //   95	13	18	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   0	14	37	java/lang/OutOfMemoryError
    //   19	30	37	java/lang/OutOfMemoryError
    //   468	490	880	java/lang/Throwable
    //   498	576	880	java/lang/Throwable
    //   636	699	1051	java/lang/OutOfMemoryError
    //   701	733	1051	java/lang/OutOfMemoryError
    //   916	930	1051	java/lang/OutOfMemoryError
    //   936	993	1128	java/lang/OutOfMemoryError
    //   1085	1125	1128	java/lang/OutOfMemoryError
    //   1141	1198	1128	java/lang/OutOfMemoryError
    //   1207	1264	1128	java/lang/OutOfMemoryError
  }
  
  public static Bitmap a(View paramView)
  {
    Bitmap localBitmap2 = null;
    if (paramView == null) {
      return null;
    }
    paramView.clearFocus();
    paramView.setPressed(false);
    Bitmap localBitmap1 = localBitmap2;
    try
    {
      paramView.layout(0, 0, paramView.getWidth(), paramView.getHeight());
      localBitmap1 = localBitmap2;
      paramView.setDrawingCacheEnabled(true);
      localBitmap1 = localBitmap2;
      paramView.buildDrawingCache();
      localBitmap1 = localBitmap2;
      localBitmap2 = Bitmap.createBitmap(paramView.getDrawingCache());
      localBitmap1 = localBitmap2;
      paramView.destroyDrawingCache();
      return localBitmap2;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return localBitmap1;
  }
  
  public static BitMatrix a(String paramString, int paramInt)
  {
    EnumMap localEnumMap = new EnumMap(EncodeHintType.class);
    localEnumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    Object localObject = a(paramString);
    if (localObject != null) {
      localEnumMap.put(EncodeHintType.CHARACTER_SET, localObject);
    }
    if (paramInt != -1) {
      localEnumMap.put(EncodeHintType.QRCODE_VERSION, Integer.valueOf(a(paramInt)));
    }
    localEnumMap.put(EncodeHintType.MARGIN, Integer.valueOf(0));
    localObject = new QRCodeWriter();
    try
    {
      paramString = ((QRCodeWriter)localObject).a(paramString, 0, 0, localEnumMap);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.e("QRUtils", 1, "encode error:" + paramString.getMessage());
    }
    return null;
  }
  
  public static QrCodeConfBean.QrCodeList a(QQAppInterface paramQQAppInterface, QrCodeConfBean paramQrCodeConfBean, int paramInt)
  {
    if ((paramQrCodeConfBean == null) || (paramQrCodeConfBean.a == null) || (paramQrCodeConfBean.a.size() <= 0)) {
      return null;
    }
    int k = 0;
    for (int j = (int)(Math.random() * paramQrCodeConfBean.a.size()); (paramInt != -1) && (j == paramInt) && (k < 50); j = (int)(Math.random() * paramQrCodeConfBean.a.size())) {
      k += 1;
    }
    return (QrCodeConfBean.QrCodeList)paramQrCodeConfBean.a.get(j);
  }
  
  /* Error */
  @android.annotation.TargetApi(8)
  public static String a(Context paramContext, String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 482	java/io/File
    //   9: dup
    //   10: ldc_w 484
    //   13: invokestatic 490	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokespecial 493	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 496	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: ifnonnull +8 -> 40
    //   35: aload_0
    //   36: invokevirtual 500	android/content/Context:getCacheDir	()Ljava/io/File;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull -37 -> 4
    //   44: aload_3
    //   45: invokevirtual 503	java/io/File:canWrite	()Z
    //   48: ifeq -44 -> 4
    //   51: new 482	java/io/File
    //   54: dup
    //   55: aload_3
    //   56: invokevirtual 506	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: aload_1
    //   60: invokespecial 509	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 506	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: astore 5
    //   70: aload_0
    //   71: invokevirtual 512	java/io/File:exists	()Z
    //   74: ifeq +8 -> 82
    //   77: aload_0
    //   78: invokevirtual 515	java/io/File:delete	()Z
    //   81: pop
    //   82: new 517	java/io/FileOutputStream
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 520	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: astore_0
    //   91: new 522	java/io/BufferedOutputStream
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 525	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   99: astore 4
    //   101: aload 4
    //   103: astore_3
    //   104: aload_0
    //   105: astore_1
    //   106: aload_2
    //   107: getstatic 531	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   110: bipush 100
    //   112: aload 4
    //   114: invokevirtual 535	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   117: pop
    //   118: aload 4
    //   120: astore_3
    //   121: aload_0
    //   122: astore_1
    //   123: aload 4
    //   125: invokevirtual 538	java/io/BufferedOutputStream:flush	()V
    //   128: aload 4
    //   130: ifnull +8 -> 138
    //   133: aload 4
    //   135: invokevirtual 541	java/io/BufferedOutputStream:close	()V
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 542	java/io/FileOutputStream:close	()V
    //   146: aload 5
    //   148: areturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 543	java/io/IOException:printStackTrace	()V
    //   154: goto -8 -> 146
    //   157: astore 5
    //   159: aconst_null
    //   160: astore_2
    //   161: aconst_null
    //   162: astore_0
    //   163: aload_2
    //   164: astore_3
    //   165: aload_0
    //   166: astore_1
    //   167: aload 5
    //   169: invokevirtual 544	java/io/FileNotFoundException:printStackTrace	()V
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 541	java/io/BufferedOutputStream:close	()V
    //   180: aload_0
    //   181: ifnull -177 -> 4
    //   184: aload_0
    //   185: invokevirtual 542	java/io/FileOutputStream:close	()V
    //   188: aconst_null
    //   189: areturn
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 543	java/io/IOException:printStackTrace	()V
    //   195: aconst_null
    //   196: areturn
    //   197: astore 5
    //   199: aconst_null
    //   200: astore_2
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_2
    //   204: astore_3
    //   205: aload_0
    //   206: astore_1
    //   207: aload 5
    //   209: invokevirtual 543	java/io/IOException:printStackTrace	()V
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 541	java/io/BufferedOutputStream:close	()V
    //   220: aload_0
    //   221: ifnull -217 -> 4
    //   224: aload_0
    //   225: invokevirtual 542	java/io/FileOutputStream:close	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 543	java/io/IOException:printStackTrace	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_2
    //   238: aconst_null
    //   239: astore_3
    //   240: aconst_null
    //   241: astore_0
    //   242: aload_3
    //   243: ifnull +7 -> 250
    //   246: aload_3
    //   247: invokevirtual 541	java/io/BufferedOutputStream:close	()V
    //   250: aload_0
    //   251: ifnull +7 -> 258
    //   254: aload_0
    //   255: invokevirtual 542	java/io/FileOutputStream:close	()V
    //   258: aload_2
    //   259: athrow
    //   260: astore_0
    //   261: aload_0
    //   262: invokevirtual 543	java/io/IOException:printStackTrace	()V
    //   265: goto -7 -> 258
    //   268: astore_1
    //   269: goto -131 -> 138
    //   272: astore_1
    //   273: goto -93 -> 180
    //   276: astore_1
    //   277: goto -57 -> 220
    //   280: astore_1
    //   281: goto -31 -> 250
    //   284: astore_2
    //   285: aconst_null
    //   286: astore_3
    //   287: goto -45 -> 242
    //   290: astore_2
    //   291: aload_1
    //   292: astore_0
    //   293: goto -51 -> 242
    //   296: astore 5
    //   298: aconst_null
    //   299: astore_2
    //   300: goto -97 -> 203
    //   303: astore 5
    //   305: aload 4
    //   307: astore_2
    //   308: goto -105 -> 203
    //   311: astore 5
    //   313: aconst_null
    //   314: astore_2
    //   315: goto -152 -> 163
    //   318: astore 5
    //   320: aload 4
    //   322: astore_2
    //   323: goto -160 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramContext	Context
    //   0	326	1	paramString	String
    //   0	326	2	paramBitmap	Bitmap
    //   29	258	3	localObject1	Object
    //   19	302	4	localObject2	Object
    //   68	79	5	str	String
    //   157	11	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   197	11	5	localIOException1	java.io.IOException
    //   296	1	5	localIOException2	java.io.IOException
    //   303	1	5	localIOException3	java.io.IOException
    //   311	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   318	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   142	146	149	java/io/IOException
    //   82	91	157	java/io/FileNotFoundException
    //   184	188	190	java/io/IOException
    //   82	91	197	java/io/IOException
    //   224	228	230	java/io/IOException
    //   82	91	237	finally
    //   254	258	260	java/io/IOException
    //   133	138	268	java/io/IOException
    //   176	180	272	java/io/IOException
    //   216	220	276	java/io/IOException
    //   246	250	280	java/io/IOException
    //   91	101	284	finally
    //   106	118	290	finally
    //   123	128	290	finally
    //   167	172	290	finally
    //   207	212	290	finally
    //   91	101	296	java/io/IOException
    //   106	118	303	java/io/IOException
    //   123	128	303	java/io/IOException
    //   91	101	311	java/io/FileNotFoundException
    //   106	118	318	java/io/FileNotFoundException
    //   123	128	318	java/io/FileNotFoundException
  }
  
  protected static String a(CharSequence paramCharSequence)
  {
    int j = 0;
    while (j < paramCharSequence.length())
    {
      if (paramCharSequence.charAt(j) > 'ÿ') {
        return "UTF-8";
      }
      j += 1;
    }
    return null;
  }
  
  public static short a(byte[] paramArrayOfByte)
  {
    return (short)(((paramArrayOfByte[0] & 0xFF) << 8) + (paramArrayOfByte[1] & 0xFF));
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    QQToast.a(localBaseApplication, paramInt1, paramInt2, 1).b(localBaseApplication.getResources().getDimensionPixelSize(2131299166));
  }
  
  private static void a(int paramInt1, Canvas paramCanvas, int paramInt2)
  {
    Paint localPaint = new Paint();
    paramInt1 = paramInt1 / 2 - 70;
    RectF localRectF = new RectF(paramInt1, paramInt2 - 66, paramInt1 + 140, paramInt2 - 66 + 140);
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(16.0F);
    localPaint.setColor(Color.parseColor("#E6FFFFFF"));
    paramCanvas.drawArc(localRectF, 182.0F, 176.0F, false, localPaint);
  }
  
  private static void a(int paramInt1, String paramString, int paramInt2, Canvas paramCanvas, int paramInt3, int paramInt4)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(28.0F);
    localPaint.setTypeface(Typeface.SANS_SERIF);
    if (paramString != null)
    {
      int j = (int)localPaint.measureText(paramString);
      paramInt1 = paramInt2 / 2;
      paramInt2 = j / 2;
      paramInt4 = (paramInt4 - (paramInt3 + 228 + 440)) / 2;
      paramCanvas.drawText(paramString, paramInt1 - paramInt2, paramInt4 + 14 + (paramInt3 + 228 + 440), localPaint);
    }
  }
  
  private static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, Canvas paramCanvas, int paramInt3)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(48.0F);
    localPaint.setFlags(1);
    localPaint.setTypeface(Typeface.SANS_SERIF);
    if (paramString2 != null)
    {
      paramInt1 = Math.max(2, paramString1.length());
      paramString2 = paramString1;
      if (localPaint.measureText(paramString1) > 500)
      {
        paramString2 = paramString1;
        do
        {
          paramInt1 -= 2;
          paramString1 = paramString2.substring(0, paramInt1) + "…";
          paramString2 = paramString1;
          if (paramInt1 <= 0) {
            break;
          }
          paramString2 = paramString1;
        } while (localPaint.measureText(paramString1) > 500);
        paramString2 = paramString1;
      }
      paramInt1 = (int)localPaint.measureText(paramString2);
      paramCanvas.drawText(paramString2, paramInt2 / 2 - paramInt1 / 2, paramInt3 - 66 + 140 + 72, localPaint);
    }
  }
  
  private static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, Canvas paramCanvas, int paramInt3)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    int j = paramInt1 / 2 - 68;
    paramInt2 = paramInt3 + 74;
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    Rect localRect = new Rect(j, paramInt1, j + 136, paramInt1 + 67);
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localPaint.setColorFilter(new PorterDuffColorFilter(Color.parseColor(paramString), PorterDuff.Mode.SRC_ATOP));
      paramCanvas.drawBitmap(BitmapFactory.decodeResource(paramContext.getResources(), 2130847312), null, localRect, localPaint);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        QLog.d("QRUtils", 1, "logoColor is illegal please check manage info logoColor = " + paramString);
      }
    }
  }
  
  private static void a(Bitmap paramBitmap, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
      localPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramBitmap, null, localRect, localPaint);
    }
  }
  
  private static void a(Bitmap paramBitmap, int paramInt, Canvas paramCanvas)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, paramInt, paramInt * 550 / 375), localPaint);
    }
  }
  
  private static void a(Bitmap paramBitmap, int paramInt1, Canvas paramCanvas, int paramInt2)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      paramInt1 = (paramInt1 - 440) / 2;
      Rect localRect = new Rect(paramInt1, paramInt2 + 228, paramInt1 + 440, paramInt2 + 228 + 440);
      localPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramBitmap, null, localRect, localPaint);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, QRCodeEncodeCallback paramQRCodeEncodeCallback)
  {
    paramString1 = QRActionEntity.a(paramInt1, paramString1);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QRUtils", 2, "entity is null in getCardQRCode, type=" + paramInt1);
      }
      return;
    }
    paramString1 = paramString1.a();
    paramString2 = new QRUtils.1(paramQRCodeEncodeCallback);
    paramContext = new NewIntent(paramContext, QRCodeServlet.class);
    paramContext.putExtra("skey", paramString3);
    paramContext.putExtra("d", paramString1);
    paramContext.putExtra("cmd", "QRCodeSvc.encode");
    if (paramInt1 == 2) {
      paramContext.putExtra("no_verify_token", paramInt2);
    }
    paramContext.setObserver(paramString2);
    paramQQAppInterface.startServlet(paramContext);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas, int paramInt3)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(28.0F);
    localPaint.setFlags(1);
    localPaint.setTypeface(Typeface.SANS_SERIF);
    if (paramString != null)
    {
      paramInt1 = (int)localPaint.measureText(paramString);
      paramCanvas.drawText(paramString, paramInt2 / 2 - paramInt1 / 2, paramInt3 - 66 + 140 + 72 + 42, localPaint);
    }
  }
  
  public static boolean a()
  {
    String str1 = Build.MANUFACTURER.toLowerCase();
    String str2 = Build.MODEL.toLowerCase();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("meizu".equals(str1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str2))
      {
        bool1 = bool2;
        if (str2.contains("pro 6 plus")) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "isMeizuRubbishDevices device: " + str1 + "   model:" + str2 + "  return:" + bool1);
    }
    return bool1;
  }
  
  /* Error */
  private static boolean a(Bitmap paramBitmap, ArrayList<Rect> paramArrayList, Canvas paramCanvas, Rect paramRect)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 5
    //   3: invokestatic 264	com/tencent/biz/qrcode/util/QRUtils:a	()Z
    //   6: ifeq +143 -> 149
    //   9: aload_0
    //   10: astore 5
    //   12: aload_3
    //   13: invokevirtual 267	android/graphics/Rect:width	()I
    //   16: sipush 350
    //   19: if_icmple +130 -> 149
    //   22: aload_0
    //   23: astore 5
    //   25: aload_3
    //   26: invokevirtual 270	android/graphics/Rect:height	()I
    //   29: sipush 350
    //   32: if_icmple +117 -> 149
    //   35: aload_0
    //   36: astore 5
    //   38: aload_0
    //   39: ifnull +110 -> 149
    //   42: aload_0
    //   43: aload_3
    //   44: invokevirtual 267	android/graphics/Rect:width	()I
    //   47: iconst_2
    //   48: idiv
    //   49: aload_3
    //   50: invokevirtual 270	android/graphics/Rect:height	()I
    //   53: iconst_2
    //   54: idiv
    //   55: iconst_0
    //   56: invokestatic 274	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   59: astore 6
    //   61: aload_0
    //   62: astore 5
    //   64: aload 6
    //   66: ifnull +83 -> 149
    //   69: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +73 -> 145
    //   75: ldc 80
    //   77: iconst_2
    //   78: new 82	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 276
    //   88: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 6
    //   93: invokevirtual 279	android/graphics/Bitmap:getWidth	()I
    //   96: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc_w 281
    //   102: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 6
    //   107: invokevirtual 284	android/graphics/Bitmap:getHeight	()I
    //   110: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc_w 286
    //   116: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokevirtual 279	android/graphics/Bitmap:getWidth	()I
    //   123: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc_w 288
    //   129: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: invokevirtual 284	android/graphics/Bitmap:getHeight	()I
    //   136: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 161	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload 6
    //   147: astore 5
    //   149: aload_1
    //   150: ifnull +223 -> 373
    //   153: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +52 -> 208
    //   159: aload 5
    //   161: ifnull +47 -> 208
    //   164: ldc 80
    //   166: iconst_2
    //   167: new 82	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 290
    //   177: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokevirtual 279	android/graphics/Bitmap:getWidth	()I
    //   185: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: ldc_w 281
    //   191: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 5
    //   196: invokevirtual 284	android/graphics/Bitmap:getHeight	()I
    //   199: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 161	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload 5
    //   210: aload_3
    //   211: invokevirtual 267	android/graphics/Rect:width	()I
    //   214: aload_3
    //   215: invokevirtual 270	android/graphics/Rect:height	()I
    //   218: iconst_0
    //   219: invokestatic 274	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   222: astore_0
    //   223: new 163	android/graphics/Canvas
    //   226: dup
    //   227: aload_0
    //   228: invokespecial 166	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   231: astore 5
    //   233: new 189	android/graphics/Paint
    //   236: dup
    //   237: invokespecial 190	android/graphics/Paint:<init>	()V
    //   240: astore 6
    //   242: aload 6
    //   244: iconst_0
    //   245: invokevirtual 293	android/graphics/Paint:setAlpha	(I)V
    //   248: aload 6
    //   250: iconst_1
    //   251: invokevirtual 199	android/graphics/Paint:setAntiAlias	(Z)V
    //   254: aload 6
    //   256: new 295	android/graphics/PorterDuffXfermode
    //   259: dup
    //   260: getstatic 301	android/graphics/PorterDuff$Mode:DST_IN	Landroid/graphics/PorterDuff$Mode;
    //   263: invokespecial 304	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   266: invokevirtual 308	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   269: pop
    //   270: iconst_0
    //   271: istore 4
    //   273: iload 4
    //   275: aload_1
    //   276: invokevirtual 313	java/util/ArrayList:size	()I
    //   279: if_icmpge +73 -> 352
    //   282: aload 5
    //   284: new 192	android/graphics/Rect
    //   287: dup
    //   288: aload_1
    //   289: iload 4
    //   291: invokevirtual 317	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   294: checkcast 192	android/graphics/Rect
    //   297: invokespecial 320	android/graphics/Rect:<init>	(Landroid/graphics/Rect;)V
    //   300: aload 6
    //   302: invokevirtual 324	android/graphics/Canvas:drawRect	(Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   305: iload 4
    //   307: iconst_1
    //   308: iadd
    //   309: istore 4
    //   311: goto -38 -> 273
    //   314: astore 5
    //   316: ldc 80
    //   318: iconst_1
    //   319: new 82	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 355
    //   329: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload 5
    //   334: invokevirtual 356	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   337: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 98	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload_0
    //   347: astore 5
    //   349: goto -200 -> 149
    //   352: aload_2
    //   353: aload_0
    //   354: aconst_null
    //   355: aload_3
    //   356: aconst_null
    //   357: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   360: aload_0
    //   361: invokevirtual 359	android/graphics/Bitmap:recycle	()V
    //   364: iconst_0
    //   365: ireturn
    //   366: astore_0
    //   367: aload_0
    //   368: invokevirtual 366	java/lang/OutOfMemoryError:printStackTrace	()V
    //   371: iconst_1
    //   372: ireturn
    //   373: aload 5
    //   375: ifnull -11 -> 364
    //   378: aload_2
    //   379: aload 5
    //   381: aconst_null
    //   382: aload_3
    //   383: aconst_null
    //   384: invokevirtual 203	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   387: goto -23 -> 364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramBitmap	Bitmap
    //   0	390	1	paramArrayList	ArrayList<Rect>
    //   0	390	2	paramCanvas	Canvas
    //   0	390	3	paramRect	Rect
    //   271	39	4	j	int
    //   1	282	5	localObject1	Object
    //   314	19	5	localThrowable	Throwable
    //   347	33	5	localBitmap	Bitmap
    //   59	242	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   42	61	314	java/lang/Throwable
    //   69	145	314	java/lang/Throwable
    //   208	270	366	java/lang/OutOfMemoryError
    //   273	305	366	java/lang/OutOfMemoryError
    //   352	364	366	java/lang/OutOfMemoryError
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt("my_qr_code_cfg_sp_index", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "saveMyQrBgIndex2Sp().index:" + paramInt);
    }
    return paramQQAppInterface.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    while (!QVipQidProcessor.c().b) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("sp_vip_qid_info", 0).edit();
    paramQQAppInterface.putInt("user_qr_card_type" + paramString, paramInt);
    return paramQQAppInterface.commit();
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(a, paramString);
  }
  
  public static byte[] a(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >>> 56), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 8), (byte)(int)paramLong };
  }
  
  public static final Bitmap[] a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, ArrayList<Rect> paramArrayList, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2)
  {
    Bitmap[] arrayOfBitmap = new Bitmap[2];
    int n = Math.min(750, ScreenUtil.getRealWidth(paramContext));
    int i1 = Math.min(1344, ScreenUtil.getRealHeight(paramContext));
    if (QLog.isColorLevel()) {
      QLog.w("QRUtils", 2, "getMyQRCard() shareWidth=" + n + ",shareHeight=" + i1);
    }
    Bitmap localBitmap1;
    Bitmap localBitmap2;
    try
    {
      localBitmap1 = Bitmap.createBitmap(440, 440, Bitmap.Config.ARGB_8888);
      localBitmap2 = Bitmap.createBitmap(n, i1, Bitmap.Config.ARGB_8888);
      if ((localBitmap1 == null) || (localBitmap2 == null))
      {
        QLog.d("QRUtils", 1, "getMyQRCard() myCode == null || myShare == null");
        return arrayOfBitmap;
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.w("QRUtils", 1, paramContext.getMessage());
      return arrayOfBitmap;
    }
    if (a(paramBitmap3, paramArrayList, new Canvas(localBitmap1), new Rect(0, 0, 440, 440))) {
      return null;
    }
    arrayOfBitmap[0] = localBitmap1;
    paramBitmap3 = new Canvas(localBitmap2);
    if (QLog.isColorLevel()) {
      QLog.d("QRUtils", 2, " shareWidth = " + n + " shareHeight = " + i1);
    }
    a(paramBitmap1, n, i1, paramBitmap3);
    paramBitmap1 = new Paint();
    int i2 = (n - 550) / 2;
    int j = (i1 - 982) / 2;
    int k;
    if (j > 0)
    {
      j += 78;
      int m = j + 772;
      k = m;
      if (paramBoolean2) {
        k = m - 42;
      }
      paramArrayList = new RectF(i2, j, i2 + 550, k);
      paramBitmap1.setAntiAlias(true);
      paramBitmap1.setColor(Color.parseColor("#E6FFFFFF"));
      paramBitmap3.drawRoundRect(paramArrayList, 32.0F, 32.0F, paramBitmap1);
      a(n, paramBitmap3, j);
      b(paramBitmap2, n, paramBitmap3, j);
      a(paramInt1, paramString1, paramString2, n, paramBitmap3, j);
      if (paramBoolean2) {
        break label455;
      }
      a(localBitmap1, n, paramBitmap3, j - 42);
      a(paramInt1, paramString3, n, paramBitmap3, j - 42, k);
    }
    for (;;)
    {
      if (paramBoolean1) {
        a(paramContext, paramString4, n, i1, paramBitmap3, k);
      }
      arrayOfBitmap[1] = localBitmap2;
      return arrayOfBitmap;
      j = 78;
      break;
      label455:
      a(paramString2, paramInt2, n, paramBitmap3, j);
      a(localBitmap1, n, paramBitmap3, j);
      a(paramInt1, paramString3, n, paramBitmap3, j, k);
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    int j = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("troop_qr_code_cfg_sp_index", -1);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "getTroopQrBgIndexFromSp().settingValue:" + j);
    }
    return j;
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new QRUtils.2(paramInt1, paramInt2));
  }
  
  private static void b(Bitmap paramBitmap, int paramInt1, Canvas paramCanvas, int paramInt2)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      paramInt1 = paramInt1 / 2 - 70;
      paramCanvas.drawBitmap(paramBitmap, null, new Rect(paramInt1, paramInt2 - 66, paramInt1 + 140, paramInt2 - 66 + 140), localPaint);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt("troop_qr_code_cfg_sp_index", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "saveTroopQrBgIndex2Sp().index:" + paramInt);
    }
    return paramQQAppInterface.commit();
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    while ((!Pattern.matches(h, paramString)) && (!Pattern.matches(i, paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(i, paramString);
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://vac.qq.com/wallet/qrcode.htm")) && (!paramString.startsWith("https://vac.qq.com/wallet/qrcode.htm")) && (!paramString.startsWith("https://i.qianbao.qq.com/wallet/sqrcode.htm"))) {
      return false;
    }
    return true;
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://qpay.qq.com/qr/")) && (!paramString.startsWith("https://qpay.qq.com/qr/"))) {
      return false;
    }
    return true;
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://mqq.tenpay.com/qrhb")) && (!paramString.startsWith("https://mqq.tenpay.com/qrhb"))) {
      return false;
    }
    return true;
  }
  
  public static boolean g(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return URLUtil.isValidUrl(paramString);
  }
  
  public static boolean h(String paramString)
  {
    return (g(paramString)) && ((paramString.startsWith("http:")) || (paramString.startsWith("https:")) || (paramString.startsWith("www.")));
  }
  
  public static boolean i(String paramString)
  {
    return Pattern.matches(b, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.util.QRUtils
 * JD-Core Version:    0.7.0.1
 */