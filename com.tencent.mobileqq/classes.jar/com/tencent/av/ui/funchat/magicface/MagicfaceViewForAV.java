package com.tencent.av.ui.funchat.magicface;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.av.AVLog;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.MagicfaceRenderListener;

public class MagicfaceViewForAV
  extends SurfaceView
  implements SurfaceHolder.Callback, MagicfaceBaseDecoder.MagicfaceRenderListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  public volatile boolean a;
  
  public MagicfaceViewForAV(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = localDisplayMetrics.density;
    this.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
    AVLog.c("MagicfaceViewForAV", "init() density: " + this.jdField_a_of_type_Int + "|" + this.jdField_a_of_type_Float);
  }
  
  /* Error */
  public void a(android.graphics.Bitmap paramBitmap1, android.graphics.Bitmap paramBitmap2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, android.graphics.Rect paramRect)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 15
    //   3: aconst_null
    //   4: astore 14
    //   6: aload 14
    //   8: astore 13
    //   10: aload 15
    //   12: astore 12
    //   14: aload_0
    //   15: invokevirtual 98	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:getWidth	()I
    //   18: istore 9
    //   20: aload 14
    //   22: astore 13
    //   24: aload 15
    //   26: astore 12
    //   28: aload_0
    //   29: invokevirtual 101	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:getHeight	()I
    //   32: istore 10
    //   34: aload 14
    //   36: astore 13
    //   38: aload 15
    //   40: astore 12
    //   42: aload_0
    //   43: getfield 27	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   46: aconst_null
    //   47: invokeinterface 105 2 0
    //   52: astore 14
    //   54: aload 14
    //   56: astore 13
    //   58: aload 14
    //   60: astore 12
    //   62: new 107	android/graphics/Paint
    //   65: dup
    //   66: invokespecial 108	android/graphics/Paint:<init>	()V
    //   69: astore 15
    //   71: aload 14
    //   73: astore 13
    //   75: aload 14
    //   77: astore 12
    //   79: aload 15
    //   81: new 110	android/graphics/PorterDuffXfermode
    //   84: dup
    //   85: getstatic 116	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   88: invokespecial 119	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   91: invokevirtual 123	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   94: pop
    //   95: aload 14
    //   97: astore 13
    //   99: aload 14
    //   101: astore 12
    //   103: aload 14
    //   105: aload 15
    //   107: invokevirtual 129	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   110: aload 14
    //   112: astore 13
    //   114: aload 14
    //   116: astore 12
    //   118: aload 15
    //   120: new 110	android/graphics/PorterDuffXfermode
    //   123: dup
    //   124: getstatic 132	android/graphics/PorterDuff$Mode:SRC_OVER	Landroid/graphics/PorterDuff$Mode;
    //   127: invokespecial 119	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   130: invokevirtual 123	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   133: pop
    //   134: aload 14
    //   136: astore 13
    //   138: aload 14
    //   140: astore 12
    //   142: aload 15
    //   144: iconst_1
    //   145: invokevirtual 136	android/graphics/Paint:setFilterBitmap	(Z)V
    //   148: aload 14
    //   150: astore 13
    //   152: aload 14
    //   154: astore 12
    //   156: aload 15
    //   158: iconst_1
    //   159: invokevirtual 139	android/graphics/Paint:setAntiAlias	(Z)V
    //   162: aload 14
    //   164: astore 13
    //   166: aload 14
    //   168: astore 12
    //   170: new 141	android/graphics/Rect
    //   173: dup
    //   174: invokespecial 142	android/graphics/Rect:<init>	()V
    //   177: astore 16
    //   179: iload_3
    //   180: ifeq +225 -> 405
    //   183: iload 4
    //   185: ifeq +220 -> 405
    //   188: aload 14
    //   190: astore 13
    //   192: aload 14
    //   194: astore 12
    //   196: aload 16
    //   198: iconst_0
    //   199: putfield 145	android/graphics/Rect:top	I
    //   202: aload 14
    //   204: astore 13
    //   206: aload 14
    //   208: astore 12
    //   210: aload 16
    //   212: iconst_0
    //   213: putfield 148	android/graphics/Rect:left	I
    //   216: aload 14
    //   218: astore 13
    //   220: aload 14
    //   222: astore 12
    //   224: aload 16
    //   226: iload 9
    //   228: putfield 151	android/graphics/Rect:right	I
    //   231: aload 14
    //   233: astore 13
    //   235: aload 14
    //   237: astore 12
    //   239: aload 16
    //   241: iload 10
    //   243: putfield 154	android/graphics/Rect:bottom	I
    //   246: aload 14
    //   248: astore 13
    //   250: aload 14
    //   252: astore 12
    //   254: ldc 63
    //   256: new 65	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   263: ldc 156
    //   265: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: iload 9
    //   270: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: ldc 78
    //   275: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: iload 10
    //   280: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: ldc 78
    //   285: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload_3
    //   289: invokevirtual 159	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   292: ldc 78
    //   294: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: iload 4
    //   299: invokevirtual 159	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   302: ldc 78
    //   304: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 7
    //   309: invokevirtual 160	android/graphics/Rect:toString	()Ljava/lang/String;
    //   312: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc 78
    //   317: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 16
    //   322: invokevirtual 160	android/graphics/Rect:toString	()Ljava/lang/String;
    //   325: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: ldc 78
    //   330: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 91	com/tencent/av/AVLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: aload_2
    //   340: ifnull +22 -> 362
    //   343: aload 14
    //   345: astore 13
    //   347: aload 14
    //   349: astore 12
    //   351: aload 14
    //   353: aload_2
    //   354: aconst_null
    //   355: aload 16
    //   357: aload 15
    //   359: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   362: aload 14
    //   364: astore 13
    //   366: aload 14
    //   368: astore 12
    //   370: aload 14
    //   372: aload_1
    //   373: aconst_null
    //   374: aload 16
    //   376: aload 15
    //   378: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   381: aload 14
    //   383: ifnull +21 -> 404
    //   386: aload_0
    //   387: getfield 166	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Boolean	Z
    //   390: ifeq +14 -> 404
    //   393: aload_0
    //   394: getfield 27	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   397: aload 14
    //   399: invokeinterface 170 2 0
    //   404: return
    //   405: iload_3
    //   406: ifeq +184 -> 590
    //   409: aload 14
    //   411: astore 13
    //   413: aload 14
    //   415: astore 12
    //   417: aload 16
    //   419: iconst_0
    //   420: putfield 148	android/graphics/Rect:left	I
    //   423: aload 14
    //   425: astore 13
    //   427: aload 14
    //   429: astore 12
    //   431: aload 16
    //   433: iload 9
    //   435: putfield 151	android/graphics/Rect:right	I
    //   438: aload 14
    //   440: astore 13
    //   442: aload 14
    //   444: astore 12
    //   446: aload 16
    //   448: invokevirtual 173	android/graphics/Rect:width	()I
    //   451: aload_1
    //   452: invokevirtual 176	android/graphics/Bitmap:getHeight	()I
    //   455: imul
    //   456: aload_1
    //   457: invokevirtual 177	android/graphics/Bitmap:getWidth	()I
    //   460: idiv
    //   461: istore 11
    //   463: aload 14
    //   465: astore 13
    //   467: aload 14
    //   469: astore 12
    //   471: aload 16
    //   473: aload 7
    //   475: getfield 145	android/graphics/Rect:top	I
    //   478: i2f
    //   479: aload_0
    //   480: getfield 56	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Float	F
    //   483: fmul
    //   484: f2i
    //   485: putfield 145	android/graphics/Rect:top	I
    //   488: aload 14
    //   490: astore 13
    //   492: aload 14
    //   494: astore 12
    //   496: aload 16
    //   498: iload 11
    //   500: aload 16
    //   502: getfield 145	android/graphics/Rect:top	I
    //   505: iadd
    //   506: putfield 154	android/graphics/Rect:bottom	I
    //   509: goto -263 -> 246
    //   512: astore_1
    //   513: aload 13
    //   515: astore 12
    //   517: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +35 -> 555
    //   523: aload 13
    //   525: astore 12
    //   527: ldc 63
    //   529: iconst_2
    //   530: new 65	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   537: ldc 185
    //   539: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_1
    //   543: invokevirtual 186	java/lang/Exception:toString	()Ljava/lang/String;
    //   546: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   555: aload 13
    //   557: ifnull -153 -> 404
    //   560: aload_0
    //   561: getfield 166	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Boolean	Z
    //   564: ifeq -160 -> 404
    //   567: aload_0
    //   568: getfield 27	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   571: aload 13
    //   573: invokeinterface 170 2 0
    //   578: return
    //   579: astore_1
    //   580: ldc 63
    //   582: aload_1
    //   583: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   586: invokestatic 196	com/tencent/av/AVLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   589: return
    //   590: iload 4
    //   592: ifeq +132 -> 724
    //   595: aload 14
    //   597: astore 13
    //   599: aload 14
    //   601: astore 12
    //   603: aload 16
    //   605: iconst_0
    //   606: putfield 145	android/graphics/Rect:top	I
    //   609: aload 14
    //   611: astore 13
    //   613: aload 14
    //   615: astore 12
    //   617: aload 16
    //   619: iload 10
    //   621: putfield 154	android/graphics/Rect:bottom	I
    //   624: aload 14
    //   626: astore 13
    //   628: aload 14
    //   630: astore 12
    //   632: aload 16
    //   634: invokevirtual 199	android/graphics/Rect:height	()I
    //   637: aload_1
    //   638: invokevirtual 177	android/graphics/Bitmap:getWidth	()I
    //   641: imul
    //   642: aload_1
    //   643: invokevirtual 176	android/graphics/Bitmap:getHeight	()I
    //   646: idiv
    //   647: istore 11
    //   649: aload 14
    //   651: astore 13
    //   653: aload 14
    //   655: astore 12
    //   657: aload 16
    //   659: aload 7
    //   661: getfield 148	android/graphics/Rect:left	I
    //   664: i2f
    //   665: aload_0
    //   666: getfield 56	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Float	F
    //   669: fmul
    //   670: f2i
    //   671: putfield 148	android/graphics/Rect:left	I
    //   674: aload 14
    //   676: astore 13
    //   678: aload 14
    //   680: astore 12
    //   682: aload 16
    //   684: iload 11
    //   686: aload 16
    //   688: getfield 148	android/graphics/Rect:left	I
    //   691: iadd
    //   692: putfield 151	android/graphics/Rect:right	I
    //   695: goto -449 -> 246
    //   698: astore_1
    //   699: aload 12
    //   701: ifnull +21 -> 722
    //   704: aload_0
    //   705: getfield 166	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Boolean	Z
    //   708: ifeq +14 -> 722
    //   711: aload_0
    //   712: getfield 27	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   715: aload 12
    //   717: invokeinterface 170 2 0
    //   722: aload_1
    //   723: athrow
    //   724: iload 5
    //   726: ifne -480 -> 246
    //   729: iload 6
    //   731: ifne -485 -> 246
    //   734: iload 5
    //   736: ifne -490 -> 246
    //   739: iload 6
    //   741: ifne -495 -> 246
    //   744: aload 14
    //   746: astore 13
    //   748: aload 14
    //   750: astore 12
    //   752: aload 16
    //   754: aload 7
    //   756: invokevirtual 203	android/graphics/Rect:set	(Landroid/graphics/Rect;)V
    //   759: fconst_1
    //   760: fstore 8
    //   762: aload 14
    //   764: astore 13
    //   766: aload 14
    //   768: astore 12
    //   770: aload 14
    //   772: invokevirtual 204	android/graphics/Canvas:getWidth	()I
    //   775: istore 11
    //   777: aload 14
    //   779: astore 13
    //   781: aload 14
    //   783: astore 12
    //   785: iload 11
    //   787: aload_0
    //   788: getfield 61	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Int	I
    //   791: if_icmpeq +22 -> 813
    //   794: aload 14
    //   796: astore 13
    //   798: aload 14
    //   800: astore 12
    //   802: iload 11
    //   804: i2f
    //   805: aload_0
    //   806: getfield 61	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Int	I
    //   809: i2f
    //   810: fdiv
    //   811: fstore 8
    //   813: aload 14
    //   815: astore 13
    //   817: aload 14
    //   819: astore 12
    //   821: fload 8
    //   823: aload_0
    //   824: getfield 56	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Float	F
    //   827: fmul
    //   828: fstore 8
    //   830: aload 14
    //   832: astore 13
    //   834: aload 14
    //   836: astore 12
    //   838: aload 16
    //   840: aload 16
    //   842: getfield 148	android/graphics/Rect:left	I
    //   845: i2f
    //   846: fload 8
    //   848: fmul
    //   849: f2i
    //   850: putfield 148	android/graphics/Rect:left	I
    //   853: aload 14
    //   855: astore 13
    //   857: aload 14
    //   859: astore 12
    //   861: aload 16
    //   863: aload 16
    //   865: getfield 145	android/graphics/Rect:top	I
    //   868: i2f
    //   869: fload 8
    //   871: fmul
    //   872: f2i
    //   873: putfield 145	android/graphics/Rect:top	I
    //   876: aload 14
    //   878: astore 13
    //   880: aload 14
    //   882: astore 12
    //   884: aload 16
    //   886: aload 16
    //   888: getfield 151	android/graphics/Rect:right	I
    //   891: i2f
    //   892: fload 8
    //   894: fmul
    //   895: f2i
    //   896: putfield 151	android/graphics/Rect:right	I
    //   899: aload 14
    //   901: astore 13
    //   903: aload 14
    //   905: astore 12
    //   907: aload 16
    //   909: fload 8
    //   911: aload 16
    //   913: getfield 154	android/graphics/Rect:bottom	I
    //   916: i2f
    //   917: fmul
    //   918: f2i
    //   919: putfield 154	android/graphics/Rect:bottom	I
    //   922: goto -676 -> 246
    //   925: astore_1
    //   926: ldc 63
    //   928: aload_1
    //   929: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   932: invokestatic 196	com/tencent/av/AVLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   935: return
    //   936: astore_2
    //   937: ldc 63
    //   939: aload_2
    //   940: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   943: invokestatic 196	com/tencent/av/AVLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   946: goto -224 -> 722
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	MagicfaceViewForAV
    //   0	949	1	paramBitmap1	android.graphics.Bitmap
    //   0	949	2	paramBitmap2	android.graphics.Bitmap
    //   0	949	3	paramBoolean1	boolean
    //   0	949	4	paramBoolean2	boolean
    //   0	949	5	paramBoolean3	boolean
    //   0	949	6	paramBoolean4	boolean
    //   0	949	7	paramRect	android.graphics.Rect
    //   760	150	8	f	float
    //   18	416	9	i	int
    //   32	588	10	j	int
    //   461	342	11	k	int
    //   12	894	12	localObject	java.lang.Object
    //   8	894	13	localCanvas1	android.graphics.Canvas
    //   4	900	14	localCanvas2	android.graphics.Canvas
    //   1	376	15	localPaint	android.graphics.Paint
    //   177	735	16	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   14	20	512	java/lang/Exception
    //   28	34	512	java/lang/Exception
    //   42	54	512	java/lang/Exception
    //   62	71	512	java/lang/Exception
    //   79	95	512	java/lang/Exception
    //   103	110	512	java/lang/Exception
    //   118	134	512	java/lang/Exception
    //   142	148	512	java/lang/Exception
    //   156	162	512	java/lang/Exception
    //   170	179	512	java/lang/Exception
    //   196	202	512	java/lang/Exception
    //   210	216	512	java/lang/Exception
    //   224	231	512	java/lang/Exception
    //   239	246	512	java/lang/Exception
    //   254	339	512	java/lang/Exception
    //   351	362	512	java/lang/Exception
    //   370	381	512	java/lang/Exception
    //   417	423	512	java/lang/Exception
    //   431	438	512	java/lang/Exception
    //   446	463	512	java/lang/Exception
    //   471	488	512	java/lang/Exception
    //   496	509	512	java/lang/Exception
    //   603	609	512	java/lang/Exception
    //   617	624	512	java/lang/Exception
    //   632	649	512	java/lang/Exception
    //   657	674	512	java/lang/Exception
    //   682	695	512	java/lang/Exception
    //   752	759	512	java/lang/Exception
    //   770	777	512	java/lang/Exception
    //   785	794	512	java/lang/Exception
    //   802	813	512	java/lang/Exception
    //   821	830	512	java/lang/Exception
    //   838	853	512	java/lang/Exception
    //   861	876	512	java/lang/Exception
    //   884	899	512	java/lang/Exception
    //   907	922	512	java/lang/Exception
    //   567	578	579	java/lang/Exception
    //   14	20	698	finally
    //   28	34	698	finally
    //   42	54	698	finally
    //   62	71	698	finally
    //   79	95	698	finally
    //   103	110	698	finally
    //   118	134	698	finally
    //   142	148	698	finally
    //   156	162	698	finally
    //   170	179	698	finally
    //   196	202	698	finally
    //   210	216	698	finally
    //   224	231	698	finally
    //   239	246	698	finally
    //   254	339	698	finally
    //   351	362	698	finally
    //   370	381	698	finally
    //   417	423	698	finally
    //   431	438	698	finally
    //   446	463	698	finally
    //   471	488	698	finally
    //   496	509	698	finally
    //   517	523	698	finally
    //   527	555	698	finally
    //   603	609	698	finally
    //   617	624	698	finally
    //   632	649	698	finally
    //   657	674	698	finally
    //   682	695	698	finally
    //   752	759	698	finally
    //   770	777	698	finally
    //   785	794	698	finally
    //   802	813	698	finally
    //   821	830	698	finally
    //   838	853	698	finally
    //   861	876	698	finally
    //   884	899	698	finally
    //   907	922	698	finally
    //   393	404	925	java/lang/Exception
    //   711	722	936	java/lang/Exception
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.magicface.MagicfaceViewForAV
 * JD-Core Version:    0.7.0.1
 */