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
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 12
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
    //   47: ifnull +1058 -> 1105
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
    //   202: ifnull +134 -> 336
    //   205: sipush 132
    //   208: sipush 132
    //   211: getstatic 85	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   214: invokestatic 89	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   217: astore 14
    //   219: new 105	android/graphics/Canvas
    //   222: dup
    //   223: aload 14
    //   225: invokespecial 108	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   228: astore_2
    //   229: aload_2
    //   230: iconst_0
    //   231: invokevirtual 112	android/graphics/Canvas:setDensity	(I)V
    //   234: new 124	android/graphics/RectF
    //   237: dup
    //   238: fconst_0
    //   239: fconst_0
    //   240: ldc 125
    //   242: ldc 125
    //   244: invokespecial 128	android/graphics/RectF:<init>	(FFFF)V
    //   247: astore 16
    //   249: new 130	android/graphics/Paint
    //   252: dup
    //   253: invokespecial 131	android/graphics/Paint:<init>	()V
    //   256: astore 15
    //   258: aload 15
    //   260: iconst_1
    //   261: invokevirtual 135	android/graphics/Paint:setAntiAlias	(Z)V
    //   264: aload_2
    //   265: aload 16
    //   267: ldc 136
    //   269: ldc 136
    //   271: aload 15
    //   273: invokevirtual 140	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   276: aload 15
    //   278: new 142	android/graphics/PorterDuffXfermode
    //   281: dup
    //   282: getstatic 148	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   285: invokespecial 151	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   288: invokevirtual 155	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   291: pop
    //   292: aload_2
    //   293: aload 10
    //   295: aconst_null
    //   296: aload 16
    //   298: aload 15
    //   300: invokevirtual 158	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   303: aload_2
    //   304: invokevirtual 161	android/graphics/Canvas:save	()I
    //   307: pop
    //   308: aload_2
    //   309: invokevirtual 164	android/graphics/Canvas:restore	()V
    //   312: aload 13
    //   314: aload 14
    //   316: aconst_null
    //   317: new 124	android/graphics/RectF
    //   320: dup
    //   321: ldc 165
    //   323: ldc 166
    //   325: ldc 167
    //   327: ldc 168
    //   329: invokespecial 128	android/graphics/RectF:<init>	(FFFF)V
    //   332: aconst_null
    //   333: invokevirtual 158	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   336: new 170	android/text/TextPaint
    //   339: dup
    //   340: invokespecial 171	android/text/TextPaint:<init>	()V
    //   343: astore_2
    //   344: aload_2
    //   345: ldc 173
    //   347: invokestatic 179	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   350: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   353: aload_2
    //   354: ldc 183
    //   356: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   359: aload_2
    //   360: iconst_1
    //   361: invokevirtual 188	android/text/TextPaint:setAntiAlias	(Z)V
    //   364: aload_2
    //   365: aload_3
    //   366: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   369: fstore 7
    //   371: sipush 190
    //   374: i2f
    //   375: ldc 193
    //   377: aload_2
    //   378: invokevirtual 197	android/text/TextPaint:ascent	()F
    //   381: fneg
    //   382: fadd
    //   383: fadd
    //   384: f2i
    //   385: istore_1
    //   386: aload 13
    //   388: aload_3
    //   389: aload_0
    //   390: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   393: i2f
    //   394: fload 7
    //   396: fsub
    //   397: fconst_2
    //   398: fdiv
    //   399: iload_1
    //   400: i2f
    //   401: aload_2
    //   402: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   405: iload_1
    //   406: i2f
    //   407: fstore 7
    //   409: aload_2
    //   410: invokevirtual 204	android/text/TextPaint:descent	()F
    //   413: ldc 205
    //   415: fadd
    //   416: fload 7
    //   418: fadd
    //   419: f2i
    //   420: istore_1
    //   421: new 170	android/text/TextPaint
    //   424: dup
    //   425: invokespecial 171	android/text/TextPaint:<init>	()V
    //   428: astore_2
    //   429: aload_2
    //   430: iconst_m1
    //   431: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   434: aload_2
    //   435: ldc 206
    //   437: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   440: aload_2
    //   441: iconst_1
    //   442: invokevirtual 188	android/text/TextPaint:setAntiAlias	(Z)V
    //   445: aload_2
    //   446: ldc 208
    //   448: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   451: fstore 7
    //   453: iload_1
    //   454: i2f
    //   455: aload_2
    //   456: invokevirtual 197	android/text/TextPaint:ascent	()F
    //   459: fneg
    //   460: fadd
    //   461: f2i
    //   462: istore_1
    //   463: aload 13
    //   465: ldc 208
    //   467: aload_0
    //   468: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   471: i2f
    //   472: fload 7
    //   474: fsub
    //   475: fconst_2
    //   476: fdiv
    //   477: iload_1
    //   478: i2f
    //   479: aload_2
    //   480: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   483: iload_1
    //   484: i2f
    //   485: aload_2
    //   486: invokevirtual 204	android/text/TextPaint:descent	()F
    //   489: ldc 209
    //   491: fadd
    //   492: fadd
    //   493: f2i
    //   494: istore_1
    //   495: new 170	android/text/TextPaint
    //   498: dup
    //   499: invokespecial 171	android/text/TextPaint:<init>	()V
    //   502: astore_2
    //   503: aload_2
    //   504: ldc 211
    //   506: invokestatic 179	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   509: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   512: aload_2
    //   513: ldc 212
    //   515: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   518: aload_2
    //   519: iconst_1
    //   520: invokevirtual 188	android/text/TextPaint:setAntiAlias	(Z)V
    //   523: aload_2
    //   524: aload 4
    //   526: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   529: fstore 7
    //   531: iload_1
    //   532: i2f
    //   533: aload_2
    //   534: invokevirtual 197	android/text/TextPaint:ascent	()F
    //   537: fneg
    //   538: ldc 213
    //   540: fsub
    //   541: fadd
    //   542: f2i
    //   543: istore_1
    //   544: aload 13
    //   546: aload 4
    //   548: aload_0
    //   549: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   552: i2f
    //   553: fload 7
    //   555: fsub
    //   556: fconst_2
    //   557: fdiv
    //   558: iload_1
    //   559: i2f
    //   560: aload_2
    //   561: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   564: new 170	android/text/TextPaint
    //   567: dup
    //   568: invokespecial 171	android/text/TextPaint:<init>	()V
    //   571: astore_2
    //   572: aload_2
    //   573: iconst_m1
    //   574: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   577: aload_2
    //   578: ldc 206
    //   580: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   583: aload_2
    //   584: iconst_1
    //   585: invokevirtual 188	android/text/TextPaint:setAntiAlias	(Z)V
    //   588: iload_1
    //   589: bipush 58
    //   591: iadd
    //   592: i2f
    //   593: aload_2
    //   594: invokevirtual 197	android/text/TextPaint:ascent	()F
    //   597: fneg
    //   598: fadd
    //   599: f2i
    //   600: istore_1
    //   601: aload_2
    //   602: ldc 215
    //   604: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   607: fstore 7
    //   609: aload_2
    //   610: invokevirtual 218	android/text/TextPaint:getTextSize	()F
    //   613: fstore 9
    //   615: aload_2
    //   616: ldc 219
    //   618: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   621: aload_2
    //   622: aload 5
    //   624: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   627: fstore 8
    //   629: aload_2
    //   630: fload 9
    //   632: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   635: aload_2
    //   636: ldc 221
    //   638: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   641: fstore 9
    //   643: aload_0
    //   644: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   647: i2f
    //   648: fload 7
    //   650: fload 8
    //   652: fadd
    //   653: fload 9
    //   655: fadd
    //   656: fsub
    //   657: fconst_2
    //   658: fdiv
    //   659: fstore 7
    //   661: aload 13
    //   663: ldc 215
    //   665: fload 7
    //   667: iload_1
    //   668: i2f
    //   669: aload_2
    //   670: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   673: aload_2
    //   674: ldc 211
    //   676: invokestatic 179	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   679: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   682: aload_2
    //   683: ldc 215
    //   685: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   688: fload 7
    //   690: fadd
    //   691: fstore 9
    //   693: aload_2
    //   694: invokevirtual 218	android/text/TextPaint:getTextSize	()F
    //   697: fstore 8
    //   699: aload_2
    //   700: ldc 219
    //   702: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   705: aload 13
    //   707: aload 5
    //   709: fload 9
    //   711: iload_1
    //   712: i2f
    //   713: aload_2
    //   714: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   717: aload_2
    //   718: iconst_m1
    //   719: invokevirtual 182	android/text/TextPaint:setColor	(I)V
    //   722: aload_2
    //   723: aload 5
    //   725: invokevirtual 192	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   728: fstore 7
    //   730: aload_2
    //   731: fload 8
    //   733: invokevirtual 187	android/text/TextPaint:setTextSize	(F)V
    //   736: aload 13
    //   738: ldc 221
    //   740: fload 9
    //   742: fload 7
    //   744: fadd
    //   745: iload_1
    //   746: i2f
    //   747: aload_2
    //   748: invokevirtual 201	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   751: aload 13
    //   753: invokevirtual 161	android/graphics/Canvas:save	()I
    //   756: pop
    //   757: aload 13
    //   759: invokevirtual 164	android/graphics/Canvas:restore	()V
    //   762: new 20	java/lang/StringBuilder
    //   765: dup
    //   766: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   769: getstatic 44	com/tencent/biz/qqstory/takevideo/dancemachine/PKVideoSharer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   772: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: ldc 223
    //   777: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: astore_2
    //   784: aload_2
    //   785: invokestatic 228	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   788: ifeq +8 -> 796
    //   791: aload_2
    //   792: invokestatic 231	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   795: pop
    //   796: new 233	java/io/FileOutputStream
    //   799: dup
    //   800: aload_2
    //   801: invokestatic 236	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   804: invokespecial 239	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   807: astore 5
    //   809: aload 6
    //   811: getstatic 245	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   814: bipush 80
    //   816: aload 5
    //   818: invokevirtual 249	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   821: pop
    //   822: aload 5
    //   824: ifnull +8 -> 832
    //   827: aload 5
    //   829: invokevirtual 252	java/io/FileOutputStream:close	()V
    //   832: aload 5
    //   834: ifnull +7 -> 841
    //   837: aload_0
    //   838: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   841: aload 5
    //   843: ifnull +8 -> 851
    //   846: aload 6
    //   848: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   851: aload_2
    //   852: astore_0
    //   853: aload 10
    //   855: ifnull -739 -> 116
    //   858: aload 10
    //   860: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   863: aload_2
    //   864: areturn
    //   865: astore_0
    //   866: aload_0
    //   867: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   870: aload_2
    //   871: areturn
    //   872: astore_2
    //   873: aload 14
    //   875: astore_0
    //   876: aload 13
    //   878: astore_3
    //   879: aload 10
    //   881: astore 4
    //   883: aload 12
    //   885: astore 5
    //   887: aload_2
    //   888: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   891: aload 5
    //   893: ifnull +8 -> 901
    //   896: aload 5
    //   898: invokevirtual 252	java/io/FileOutputStream:close	()V
    //   901: aload 5
    //   903: ifnull +7 -> 910
    //   906: aload_0
    //   907: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   910: aload 5
    //   912: ifnull +7 -> 919
    //   915: aload_3
    //   916: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   919: aload 4
    //   921: ifnull +8 -> 929
    //   924: aload 4
    //   926: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   929: aconst_null
    //   930: areturn
    //   931: astore_0
    //   932: aload_0
    //   933: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   936: goto -7 -> 929
    //   939: astore_2
    //   940: aconst_null
    //   941: astore_0
    //   942: aconst_null
    //   943: astore 6
    //   945: aconst_null
    //   946: astore_3
    //   947: aload 11
    //   949: astore 5
    //   951: aload 5
    //   953: ifnull +8 -> 961
    //   956: aload 5
    //   958: invokevirtual 252	java/io/FileOutputStream:close	()V
    //   961: aload 5
    //   963: ifnull +7 -> 970
    //   966: aload_0
    //   967: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   970: aload 5
    //   972: ifnull +8 -> 980
    //   975: aload 6
    //   977: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   980: aload_3
    //   981: ifnull +7 -> 988
    //   984: aload_3
    //   985: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   988: aload_2
    //   989: athrow
    //   990: astore_0
    //   991: aload_0
    //   992: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   995: goto -7 -> 988
    //   998: astore_2
    //   999: aconst_null
    //   1000: astore 6
    //   1002: aconst_null
    //   1003: astore_3
    //   1004: aload 11
    //   1006: astore 5
    //   1008: goto -57 -> 951
    //   1011: astore_2
    //   1012: aconst_null
    //   1013: astore_3
    //   1014: aload 11
    //   1016: astore 5
    //   1018: goto -67 -> 951
    //   1021: astore_2
    //   1022: aload 11
    //   1024: astore 5
    //   1026: aload 10
    //   1028: astore_3
    //   1029: goto -78 -> 951
    //   1032: astore_2
    //   1033: aload 10
    //   1035: astore_3
    //   1036: goto -85 -> 951
    //   1039: astore_2
    //   1040: aload_3
    //   1041: astore 6
    //   1043: aload 4
    //   1045: astore_3
    //   1046: goto -95 -> 951
    //   1049: astore_2
    //   1050: aload 12
    //   1052: astore 5
    //   1054: aload 10
    //   1056: astore 4
    //   1058: aload 13
    //   1060: astore_3
    //   1061: goto -174 -> 887
    //   1064: astore_2
    //   1065: aload 6
    //   1067: astore_3
    //   1068: aload 12
    //   1070: astore 5
    //   1072: aload 10
    //   1074: astore 4
    //   1076: goto -189 -> 887
    //   1079: astore_2
    //   1080: aload 10
    //   1082: astore 4
    //   1084: aload 6
    //   1086: astore_3
    //   1087: aload 12
    //   1089: astore 5
    //   1091: goto -204 -> 887
    //   1094: astore_2
    //   1095: aload 10
    //   1097: astore 4
    //   1099: aload 6
    //   1101: astore_3
    //   1102: goto -215 -> 887
    //   1105: aconst_null
    //   1106: astore 6
    //   1108: goto -1042 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1111	0	paramString1	String
    //   0	1111	1	paramInt	int
    //   0	1111	2	paramString2	String
    //   0	1111	3	paramString3	String
    //   0	1111	4	paramString4	String
    //   0	1111	5	paramString5	String
    //   0	1111	6	paramContext	android.content.Context
    //   369	374	7	f1	float
    //   627	105	8	f2	float
    //   613	128	9	f3	float
    //   7	1089	10	str	String
    //   10	1013	11	localObject1	Object
    //   13	1075	12	localObject2	Object
    //   4	1055	13	localCanvas	android.graphics.Canvas
    //   1	873	14	localObject3	Object
    //   22	277	15	localObject4	Object
    //   247	50	16	localRectF	android.graphics.RectF
    // Exception table:
    //   from	to	target	type
    //   34	46	128	java/lang/OutOfMemoryError
    //   118	125	128	java/lang/OutOfMemoryError
    //   77	85	138	java/lang/Exception
    //   89	93	138	java/lang/Exception
    //   97	102	138	java/lang/Exception
    //   108	116	138	java/lang/Exception
    //   827	832	865	java/lang/Exception
    //   837	841	865	java/lang/Exception
    //   846	851	865	java/lang/Exception
    //   858	863	865	java/lang/Exception
    //   15	30	872	java/lang/Exception
    //   34	46	872	java/lang/Exception
    //   118	125	872	java/lang/Exception
    //   129	133	872	java/lang/Exception
    //   896	901	931	java/lang/Exception
    //   906	910	931	java/lang/Exception
    //   915	919	931	java/lang/Exception
    //   924	929	931	java/lang/Exception
    //   15	30	939	finally
    //   34	46	939	finally
    //   118	125	939	finally
    //   129	133	939	finally
    //   956	961	990	java/lang/Exception
    //   966	970	990	java/lang/Exception
    //   975	980	990	java/lang/Exception
    //   984	988	990	java/lang/Exception
    //   50	66	998	finally
    //   145	197	1011	finally
    //   205	336	1021	finally
    //   336	405	1021	finally
    //   409	796	1021	finally
    //   796	809	1021	finally
    //   809	822	1032	finally
    //   887	891	1039	finally
    //   50	66	1049	java/lang/Exception
    //   145	197	1064	java/lang/Exception
    //   205	336	1079	java/lang/Exception
    //   336	405	1079	java/lang/Exception
    //   409	796	1079	java/lang/Exception
    //   796	809	1079	java/lang/Exception
    //   809	822	1094	java/lang/Exception
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