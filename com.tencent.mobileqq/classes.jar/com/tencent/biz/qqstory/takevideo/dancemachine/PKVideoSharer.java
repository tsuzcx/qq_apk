package com.tencent.biz.qqstory.takevideo.dancemachine;

import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class PKVideoSharer
  extends VideoSharer
{
  public static final String a;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/capture_ptv_template/share/";
  }
  
  /* Error */
  public static String a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 11
    //   15: new 53	android/graphics/BitmapFactory$Options
    //   18: dup
    //   19: invokespecial 54	android/graphics/BitmapFactory$Options:<init>	()V
    //   22: astore 15
    //   24: aload 15
    //   26: iconst_0
    //   27: putfield 58	android/graphics/BitmapFactory$Options:inScaled	Z
    //   30: iload_1
    //   31: ifeq +87 -> 118
    //   34: aload 6
    //   36: invokevirtual 64	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   39: iload_1
    //   40: aload 15
    //   42: invokestatic 70	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   45: astore_0
    //   46: aload_0
    //   47: ifnull +1059 -> 1106
    //   50: aload_0
    //   51: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   54: aload_0
    //   55: invokevirtual 79	android/graphics/Bitmap:getHeight	()I
    //   58: getstatic 85	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   61: invokestatic 89	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   64: astore 6
    //   66: aload 6
    //   68: ifnonnull +77 -> 145
    //   71: aconst_null
    //   72: astore_2
    //   73: iconst_0
    //   74: ifeq +11 -> 85
    //   77: new 91	java/lang/NullPointerException
    //   80: dup
    //   81: invokespecial 92	java/lang/NullPointerException:<init>	()V
    //   84: athrow
    //   85: iconst_0
    //   86: ifeq +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   93: iconst_0
    //   94: ifeq +8 -> 102
    //   97: aload 6
    //   99: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   102: aload_2
    //   103: astore_0
    //   104: iconst_0
    //   105: ifeq +11 -> 116
    //   108: new 91	java/lang/NullPointerException
    //   111: dup
    //   112: invokespecial 92	java/lang/NullPointerException:<init>	()V
    //   115: athrow
    //   116: aload_0
    //   117: areturn
    //   118: aload_0
    //   119: aload 15
    //   121: invokestatic 99	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   124: astore_0
    //   125: goto -79 -> 46
    //   128: astore_0
    //   129: aload_0
    //   130: invokevirtual 102	java/lang/OutOfMemoryError:printStackTrace	()V
    //   133: aconst_null
    //   134: astore_0
    //   135: goto -89 -> 46
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   143: aconst_null
    //   144: areturn
    //   145: new 105	android/graphics/Canvas
    //   148: dup
    //   149: aload 6
    //   151: invokespecial 108	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   154: astore 13
    //   156: aload 13
    //   158: iconst_0
    //   159: invokevirtual 112	android/graphics/Canvas:setDensity	(I)V
    //   162: aload 13
    //   164: aload_0
    //   165: fconst_0
    //   166: fconst_0
    //   167: aconst_null
    //   168: invokevirtual 116	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   171: new 53	android/graphics/BitmapFactory$Options
    //   174: dup
    //   175: invokespecial 54	android/graphics/BitmapFactory$Options:<init>	()V
    //   178: astore 14
    //   180: aload 14
    //   182: iconst_1
    //   183: putfield 119	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   186: aload 14
    //   188: iconst_0
    //   189: putfield 58	android/graphics/BitmapFactory$Options:inScaled	Z
    //   192: aload_2
    //   193: invokestatic 122	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   196: astore_2
    //   197: aload_2
    //   198: astore 10
    //   200: aload 10
    //   202: ifnull +135 -> 337
    //   205: sipush 132
    //   208: sipush 132
    //   211: getstatic 85	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   214: invokestatic 89	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   217: astore 14
    //   219: new 105	android/graphics/Canvas
    //   222: dup
    //   223: aload 14
    //   225: invokespecial 108	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   228: astore 16
    //   230: aload 16
    //   232: iconst_0
    //   233: invokevirtual 112	android/graphics/Canvas:setDensity	(I)V
    //   236: new 124	android/graphics/RectF
    //   239: dup
    //   240: fconst_0
    //   241: fconst_0
    //   242: ldc 125
    //   244: ldc 125
    //   246: invokespecial 128	android/graphics/RectF:<init>	(FFFF)V
    //   249: astore 15
    //   251: new 130	android/graphics/Paint
    //   254: dup
    //   255: invokespecial 131	android/graphics/Paint:<init>	()V
    //   258: astore_2
    //   259: aload_2
    //   260: iconst_1
    //   261: invokevirtual 135	android/graphics/Paint:setAntiAlias	(Z)V
    //   264: aload 16
    //   266: aload 15
    //   268: ldc 136
    //   270: ldc 136
    //   272: aload_2
    //   273: invokevirtual 140	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   276: aload_2
    //   277: new 142	android/graphics/PorterDuffXfermode
    //   280: dup
    //   281: getstatic 148	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   284: invokespecial 151	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   287: invokevirtual 155	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   290: pop
    //   291: aload 16
    //   293: aload 10
    //   295: aconst_null
    //   296: aload 15
    //   298: aload_2
    //   299: invokevirtual 158	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   302: aload 16
    //   304: invokevirtual 161	android/graphics/Canvas:save	()I
    //   307: pop
    //   308: aload 16
    //   310: invokevirtual 164	android/graphics/Canvas:restore	()V
    //   313: aload 13
    //   315: aload 14
    //   317: aconst_null
    //   318: new 124	android/graphics/RectF
    //   321: dup
    //   322: ldc 165
    //   324: ldc 166
    //   326: ldc 167
    //   328: ldc 168
    //   330: invokespecial 128	android/graphics/RectF:<init>	(FFFF)V
    //   333: aconst_null
    //   334: invokevirtual 158	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   337: new 170	android/text/TextPaint
    //   340: dup
    //   341: invokespecial 171	android/text/TextPaint:<init>	()V
    //   344: astore_2
    //   345: aload_2
    //   346: ldc 173
    //   348: invokestatic 179	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   351: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   354: aload_2
    //   355: ldc 183
    //   357: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   360: aload_2
    //   361: iconst_1
    //   362: invokevirtual 188	android/text/TextPaint:setAntiAlias	(Z)V
    //   365: aload_2
    //   366: aload_3
    //   367: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   370: fstore 7
    //   372: sipush 190
    //   375: i2f
    //   376: ldc 193
    //   378: aload_2
    //   379: invokevirtual 197	android/text/TextPaint:ascent	()F
    //   382: fneg
    //   383: fadd
    //   384: fadd
    //   385: f2i
    //   386: istore_1
    //   387: aload 13
    //   389: aload_3
    //   390: aload_0
    //   391: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   394: i2f
    //   395: fload 7
    //   397: fsub
    //   398: fconst_2
    //   399: fdiv
    //   400: iload_1
    //   401: i2f
    //   402: aload_2
    //   403: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   406: iload_1
    //   407: i2f
    //   408: fstore 7
    //   410: aload_2
    //   411: invokevirtual 204	android/text/TextPaint:descent	()F
    //   414: ldc 205
    //   416: fadd
    //   417: fload 7
    //   419: fadd
    //   420: f2i
    //   421: istore_1
    //   422: new 170	android/text/TextPaint
    //   425: dup
    //   426: invokespecial 171	android/text/TextPaint:<init>	()V
    //   429: astore_2
    //   430: aload_2
    //   431: iconst_m1
    //   432: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   435: aload_2
    //   436: ldc 206
    //   438: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   441: aload_2
    //   442: iconst_1
    //   443: invokevirtual 188	android/text/TextPaint:setAntiAlias	(Z)V
    //   446: aload_2
    //   447: ldc 208
    //   449: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   452: fstore 7
    //   454: iload_1
    //   455: i2f
    //   456: aload_2
    //   457: invokevirtual 197	android/text/TextPaint:ascent	()F
    //   460: fneg
    //   461: fadd
    //   462: f2i
    //   463: istore_1
    //   464: aload 13
    //   466: ldc 208
    //   468: aload_0
    //   469: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   472: i2f
    //   473: fload 7
    //   475: fsub
    //   476: fconst_2
    //   477: fdiv
    //   478: iload_1
    //   479: i2f
    //   480: aload_2
    //   481: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   484: iload_1
    //   485: i2f
    //   486: aload_2
    //   487: invokevirtual 204	android/text/TextPaint:descent	()F
    //   490: ldc 209
    //   492: fadd
    //   493: fadd
    //   494: f2i
    //   495: istore_1
    //   496: new 170	android/text/TextPaint
    //   499: dup
    //   500: invokespecial 171	android/text/TextPaint:<init>	()V
    //   503: astore_2
    //   504: aload_2
    //   505: ldc 211
    //   507: invokestatic 179	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   510: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   513: aload_2
    //   514: ldc 212
    //   516: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   519: aload_2
    //   520: iconst_1
    //   521: invokevirtual 188	android/text/TextPaint:setAntiAlias	(Z)V
    //   524: aload_2
    //   525: aload 4
    //   527: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   530: fstore 7
    //   532: iload_1
    //   533: i2f
    //   534: aload_2
    //   535: invokevirtual 197	android/text/TextPaint:ascent	()F
    //   538: fneg
    //   539: ldc 213
    //   541: fsub
    //   542: fadd
    //   543: f2i
    //   544: istore_1
    //   545: aload 13
    //   547: aload 4
    //   549: aload_0
    //   550: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   553: i2f
    //   554: fload 7
    //   556: fsub
    //   557: fconst_2
    //   558: fdiv
    //   559: iload_1
    //   560: i2f
    //   561: aload_2
    //   562: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   565: new 170	android/text/TextPaint
    //   568: dup
    //   569: invokespecial 171	android/text/TextPaint:<init>	()V
    //   572: astore_2
    //   573: aload_2
    //   574: iconst_m1
    //   575: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   578: aload_2
    //   579: ldc 206
    //   581: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   584: aload_2
    //   585: iconst_1
    //   586: invokevirtual 188	android/text/TextPaint:setAntiAlias	(Z)V
    //   589: iload_1
    //   590: bipush 58
    //   592: iadd
    //   593: i2f
    //   594: aload_2
    //   595: invokevirtual 197	android/text/TextPaint:ascent	()F
    //   598: fneg
    //   599: fadd
    //   600: f2i
    //   601: istore_1
    //   602: aload_2
    //   603: ldc 215
    //   605: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   608: fstore 7
    //   610: aload_2
    //   611: invokevirtual 218	android/text/TextPaint:getTextSize	()F
    //   614: fstore 9
    //   616: aload_2
    //   617: ldc 219
    //   619: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   622: aload_2
    //   623: aload 5
    //   625: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   628: fstore 8
    //   630: aload_2
    //   631: fload 9
    //   633: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   636: aload_2
    //   637: ldc 221
    //   639: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   642: fstore 9
    //   644: aload_0
    //   645: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   648: i2f
    //   649: fload 7
    //   651: fload 8
    //   653: fadd
    //   654: fload 9
    //   656: fadd
    //   657: fsub
    //   658: fconst_2
    //   659: fdiv
    //   660: fstore 7
    //   662: aload 13
    //   664: ldc 215
    //   666: fload 7
    //   668: iload_1
    //   669: i2f
    //   670: aload_2
    //   671: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   674: aload_2
    //   675: ldc 211
    //   677: invokestatic 179	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   680: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   683: aload_2
    //   684: ldc 215
    //   686: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   689: fload 7
    //   691: fadd
    //   692: fstore 9
    //   694: aload_2
    //   695: invokevirtual 218	android/text/TextPaint:getTextSize	()F
    //   698: fstore 8
    //   700: aload_2
    //   701: ldc 219
    //   703: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   706: aload 13
    //   708: aload 5
    //   710: fload 9
    //   712: iload_1
    //   713: i2f
    //   714: aload_2
    //   715: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   718: aload_2
    //   719: iconst_m1
    //   720: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   723: aload_2
    //   724: aload 5
    //   726: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   729: fstore 7
    //   731: aload_2
    //   732: fload 8
    //   734: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   737: aload 13
    //   739: ldc 221
    //   741: fload 9
    //   743: fload 7
    //   745: fadd
    //   746: iload_1
    //   747: i2f
    //   748: aload_2
    //   749: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   752: aload 13
    //   754: invokevirtual 161	android/graphics/Canvas:save	()I
    //   757: pop
    //   758: aload 13
    //   760: invokevirtual 164	android/graphics/Canvas:restore	()V
    //   763: new 20	java/lang/StringBuilder
    //   766: dup
    //   767: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   770: getstatic 44	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   773: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: ldc 223
    //   778: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: astore_2
    //   785: aload_2
    //   786: invokestatic 228	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   789: ifeq +8 -> 797
    //   792: aload_2
    //   793: invokestatic 231	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   796: pop
    //   797: new 233	java/io/FileOutputStream
    //   800: dup
    //   801: aload_2
    //   802: invokestatic 236	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   805: invokespecial 239	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   808: astore 5
    //   810: aload 6
    //   812: getstatic 245	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   815: bipush 80
    //   817: aload 5
    //   819: invokevirtual 249	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   822: pop
    //   823: aload 5
    //   825: ifnull +8 -> 833
    //   828: aload 5
    //   830: invokevirtual 252	java/io/FileOutputStream:close	()V
    //   833: aload 5
    //   835: ifnull +7 -> 842
    //   838: aload_0
    //   839: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   842: aload 5
    //   844: ifnull +8 -> 852
    //   847: aload 6
    //   849: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   852: aload_2
    //   853: astore_0
    //   854: aload 10
    //   856: ifnull -740 -> 116
    //   859: aload 10
    //   861: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   864: aload_2
    //   865: areturn
    //   866: astore_0
    //   867: aload_0
    //   868: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   871: aload_2
    //   872: areturn
    //   873: astore_2
    //   874: aload 14
    //   876: astore_0
    //   877: aload 13
    //   879: astore_3
    //   880: aload 10
    //   882: astore 4
    //   884: aload 11
    //   886: astore 5
    //   888: aload_2
    //   889: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   892: aload 5
    //   894: ifnull +8 -> 902
    //   897: aload 5
    //   899: invokevirtual 252	java/io/FileOutputStream:close	()V
    //   902: aload 5
    //   904: ifnull +7 -> 911
    //   907: aload_0
    //   908: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   911: aload 5
    //   913: ifnull +7 -> 920
    //   916: aload_3
    //   917: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   920: aload 4
    //   922: ifnull +8 -> 930
    //   925: aload 4
    //   927: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   930: aconst_null
    //   931: areturn
    //   932: astore_0
    //   933: aload_0
    //   934: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   937: goto -7 -> 930
    //   940: astore_2
    //   941: aconst_null
    //   942: astore_0
    //   943: aconst_null
    //   944: astore 6
    //   946: aconst_null
    //   947: astore_3
    //   948: aload 12
    //   950: astore 5
    //   952: aload 5
    //   954: ifnull +8 -> 962
    //   957: aload 5
    //   959: invokevirtual 252	java/io/FileOutputStream:close	()V
    //   962: aload 5
    //   964: ifnull +7 -> 971
    //   967: aload_0
    //   968: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   971: aload 5
    //   973: ifnull +8 -> 981
    //   976: aload 6
    //   978: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   981: aload_3
    //   982: ifnull +7 -> 989
    //   985: aload_3
    //   986: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   989: aload_2
    //   990: athrow
    //   991: astore_0
    //   992: aload_0
    //   993: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   996: goto -7 -> 989
    //   999: astore_2
    //   1000: aconst_null
    //   1001: astore 6
    //   1003: aconst_null
    //   1004: astore_3
    //   1005: aload 12
    //   1007: astore 5
    //   1009: goto -57 -> 952
    //   1012: astore_2
    //   1013: aconst_null
    //   1014: astore_3
    //   1015: aload 12
    //   1017: astore 5
    //   1019: goto -67 -> 952
    //   1022: astore_2
    //   1023: aload 12
    //   1025: astore 5
    //   1027: aload 10
    //   1029: astore_3
    //   1030: goto -78 -> 952
    //   1033: astore_2
    //   1034: aload 10
    //   1036: astore_3
    //   1037: goto -85 -> 952
    //   1040: astore_2
    //   1041: aload_3
    //   1042: astore 6
    //   1044: aload 4
    //   1046: astore_3
    //   1047: goto -95 -> 952
    //   1050: astore_2
    //   1051: aload 11
    //   1053: astore 5
    //   1055: aload 10
    //   1057: astore 4
    //   1059: aload 13
    //   1061: astore_3
    //   1062: goto -174 -> 888
    //   1065: astore_2
    //   1066: aload 6
    //   1068: astore_3
    //   1069: aload 11
    //   1071: astore 5
    //   1073: aload 10
    //   1075: astore 4
    //   1077: goto -189 -> 888
    //   1080: astore_2
    //   1081: aload 10
    //   1083: astore 4
    //   1085: aload 6
    //   1087: astore_3
    //   1088: aload 11
    //   1090: astore 5
    //   1092: goto -204 -> 888
    //   1095: astore_2
    //   1096: aload 10
    //   1098: astore 4
    //   1100: aload 6
    //   1102: astore_3
    //   1103: goto -215 -> 888
    //   1106: aconst_null
    //   1107: astore 6
    //   1109: goto -1043 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1112	0	paramString1	String
    //   0	1112	1	paramInt	int
    //   0	1112	2	paramString2	String
    //   0	1112	3	paramString3	String
    //   0	1112	4	paramString4	String
    //   0	1112	5	paramString5	String
    //   0	1112	6	paramContext	android.content.Context
    //   370	374	7	f1	float
    //   628	105	8	f2	float
    //   614	128	9	f3	float
    //   7	1090	10	str	String
    //   13	1076	11	localObject1	Object
    //   10	1014	12	localObject2	Object
    //   4	1056	13	localCanvas1	android.graphics.Canvas
    //   1	874	14	localObject3	Object
    //   22	275	15	localObject4	Object
    //   228	81	16	localCanvas2	android.graphics.Canvas
    // Exception table:
    //   from	to	target	type
    //   34	46	128	java/lang/OutOfMemoryError
    //   118	125	128	java/lang/OutOfMemoryError
    //   77	85	138	java/lang/Exception
    //   89	93	138	java/lang/Exception
    //   97	102	138	java/lang/Exception
    //   108	116	138	java/lang/Exception
    //   828	833	866	java/lang/Exception
    //   838	842	866	java/lang/Exception
    //   847	852	866	java/lang/Exception
    //   859	864	866	java/lang/Exception
    //   15	30	873	java/lang/Exception
    //   34	46	873	java/lang/Exception
    //   118	125	873	java/lang/Exception
    //   129	133	873	java/lang/Exception
    //   897	902	932	java/lang/Exception
    //   907	911	932	java/lang/Exception
    //   916	920	932	java/lang/Exception
    //   925	930	932	java/lang/Exception
    //   15	30	940	finally
    //   34	46	940	finally
    //   118	125	940	finally
    //   129	133	940	finally
    //   957	962	991	java/lang/Exception
    //   967	971	991	java/lang/Exception
    //   976	981	991	java/lang/Exception
    //   985	989	991	java/lang/Exception
    //   50	66	999	finally
    //   145	197	1012	finally
    //   205	337	1022	finally
    //   337	406	1022	finally
    //   410	797	1022	finally
    //   797	810	1022	finally
    //   810	823	1033	finally
    //   888	892	1040	finally
    //   50	66	1050	java/lang/Exception
    //   145	197	1065	java/lang/Exception
    //   205	337	1080	java/lang/Exception
    //   337	406	1080	java/lang/Exception
    //   410	797	1080	java/lang/Exception
    //   797	810	1080	java/lang/Exception
    //   810	823	1095	java/lang/Exception
  }
  
  protected String a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ("share_PK".equals(this.m))
    {
      paramString1 = "[QQ高能舞室]我拿到" + paramInt1 + "分！好友排名第" + paramInt2 + "，你能超越我吗？";
      this.t = paramString1;
      return paramString1;
    }
    this.u = super.a(paramInt1, paramString1, paramString2, paramInt2);
    return this.u;
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 255
    //   5: aload_0
    //   6: getfield 257	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:m	Ljava/lang/String;
    //   9: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +180 -> 192
    //   15: aload_0
    //   16: new 20	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   23: invokestatic 29	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   26: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: ldc_w 281
    //   32: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: putfield 283	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:r	Ljava/lang/String;
    //   41: aload_0
    //   42: getfield 283	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:r	Ljava/lang/String;
    //   45: invokestatic 228	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   48: ifne +61 -> 109
    //   51: aload_0
    //   52: getfield 286	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   55: invokevirtual 289	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   58: ldc_w 290
    //   61: invokestatic 293	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   64: astore_3
    //   65: aload_3
    //   66: ifnull +43 -> 109
    //   69: new 233	java/io/FileOutputStream
    //   72: dup
    //   73: aload_0
    //   74: getfield 283	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:r	Ljava/lang/String;
    //   77: invokestatic 236	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   80: invokespecial 239	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore_2
    //   84: aload_2
    //   85: astore_1
    //   86: aload_3
    //   87: getstatic 296	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   90: bipush 100
    //   92: aload_2
    //   93: invokevirtual 249	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   96: pop
    //   97: aload_3
    //   98: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 252	java/io/FileOutputStream:close	()V
    //   109: aload_0
    //   110: getfield 283	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:r	Ljava/lang/String;
    //   113: areturn
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 102	java/lang/OutOfMemoryError:printStackTrace	()V
    //   119: aconst_null
    //   120: astore_3
    //   121: goto -56 -> 65
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   129: goto -20 -> 109
    //   132: astore 4
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: astore_1
    //   138: aload 4
    //   140: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   143: aload_3
    //   144: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   147: aload_2
    //   148: ifnull -39 -> 109
    //   151: aload_2
    //   152: invokevirtual 252	java/io/FileOutputStream:close	()V
    //   155: goto -46 -> 109
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   163: goto -54 -> 109
    //   166: astore_1
    //   167: aload 4
    //   169: astore_2
    //   170: aload_3
    //   171: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 252	java/io/FileOutputStream:close	()V
    //   182: aload_1
    //   183: athrow
    //   184: astore_2
    //   185: aload_2
    //   186: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   189: goto -7 -> 182
    //   192: aload_0
    //   193: getfield 300	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:h	Ljava/lang/String;
    //   196: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   199: ifne +25 -> 224
    //   202: aload_0
    //   203: getfield 300	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:h	Ljava/lang/String;
    //   206: aload_0
    //   207: getfield 283	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:r	Ljava/lang/String;
    //   210: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifne +11 -> 224
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 300	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:h	Ljava/lang/String;
    //   221: invokevirtual 309	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:a	(Ljava/lang/String;)V
    //   224: aload_0
    //   225: aload_1
    //   226: putfield 311	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:s	Ljava/lang/String;
    //   229: aload_0
    //   230: getfield 311	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:s	Ljava/lang/String;
    //   233: areturn
    //   234: astore 4
    //   236: aload_1
    //   237: astore_2
    //   238: aload 4
    //   240: astore_1
    //   241: goto -71 -> 170
    //   244: astore 4
    //   246: goto -110 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	PKVideoSharer
    //   0	249	1	paramString	String
    //   83	96	2	localObject1	Object
    //   184	2	2	localIOException	java.io.IOException
    //   237	1	2	str	String
    //   64	107	3	localBitmap	android.graphics.Bitmap
    //   1	1	4	localObject2	Object
    //   132	36	4	localException1	java.lang.Exception
    //   234	5	4	localObject3	Object
    //   244	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   51	65	114	java/lang/OutOfMemoryError
    //   97	101	124	java/io/IOException
    //   105	109	124	java/io/IOException
    //   69	84	132	java/lang/Exception
    //   143	147	158	java/io/IOException
    //   151	155	158	java/io/IOException
    //   69	84	166	finally
    //   170	174	184	java/io/IOException
    //   178	182	184	java/io/IOException
    //   86	97	234	finally
    //   138	143	234	finally
    //   86	97	244	java/lang/Exception
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ("share_PK".equals(this.m))
    {
      this.p = (this.l + String.format("&uuid=%s", new Object[] { paramString1 }));
      return this.p;
    }
    this.q = super.a(paramString1, paramString2);
    return this.q;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ("share_PK".equals(this.m))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("upload_pic_busi_type", 2);
      localIntent.putExtra("dance_machine_rank", this.n);
      localIntent.putExtra("dance_machine_score", this.o);
      localIntent.putExtra("share_method", paramInt1);
      localIntent.putExtra("pk_rank", this.n);
      PublicTransFragmentActivity.b(this.jdField_a_of_type_AndroidAppActivity, localIntent, CommonPicUploadFragment.class, 90002);
      return;
    }
    super.a(paramInt1, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.l = paramString2;
    this.m = paramString1;
    this.n = paramString3;
    this.o = paramString4;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewShareActionSheet.a();
    }
  }
  
  protected void a(List paramList)
  {
    super.a(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((ShareActionSheetBuilder.ActionSheetItem)paramList.next()).c == 2) {
        paramList.remove();
      }
    }
  }
  
  protected boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ("share_PK".equals(this.m))
    {
      if ((!TextUtils.isEmpty(this.p)) && (!TextUtils.isEmpty(this.r))) {}
      for (;;)
      {
        bool2 = bool1;
        if (bool1)
        {
          this.i = this.p;
          this.h = this.r;
          this.j = this.t;
          bool2 = bool1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DanceMachinePKVideoSharer", 2, "hasShare : " + bool2 + " shareUrl : " + this.i + " thumbPath : " + this.h + " lastShareType" + this.m);
        }
        return bool2;
        bool1 = false;
      }
    }
    if ((!TextUtils.isEmpty(this.q)) && (!TextUtils.isEmpty(this.s))) {}
    for (bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.i = this.q;
      this.h = this.s;
      this.j = this.u;
      bool2 = bool1;
      break;
    }
  }
  
  protected boolean a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.dancemachine.PKVideoSharer
 * JD-Core Version:    0.7.0.1
 */