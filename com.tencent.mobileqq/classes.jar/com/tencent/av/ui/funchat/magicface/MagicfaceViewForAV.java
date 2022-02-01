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
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    Object localObject = getContext().getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = ((DisplayMetrics)localObject).density;
    this.jdField_a_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init() density: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Float);
    AVLog.printColorLog("MagicfaceViewForAV", ((StringBuilder)localObject).toString());
  }
  
  /* Error */
  public void a(android.graphics.Bitmap paramBitmap1, android.graphics.Bitmap paramBitmap2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, android.graphics.Rect paramRect)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aload_0
    //   4: invokevirtual 100	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:getWidth	()I
    //   7: istore 9
    //   9: aload_0
    //   10: invokevirtual 103	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:getHeight	()I
    //   13: istore 10
    //   15: aload_0
    //   16: getfield 29	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   19: aconst_null
    //   20: invokeinterface 107 2 0
    //   25: astore 12
    //   27: aload 12
    //   29: ifnull +621 -> 650
    //   32: new 109	android/graphics/Paint
    //   35: dup
    //   36: invokespecial 110	android/graphics/Paint:<init>	()V
    //   39: astore 13
    //   41: aload 13
    //   43: new 112	android/graphics/PorterDuffXfermode
    //   46: dup
    //   47: getstatic 118	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   50: invokespecial 121	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   53: invokevirtual 125	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   56: pop
    //   57: aload 12
    //   59: aload 13
    //   61: invokevirtual 131	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   64: aload 13
    //   66: new 112	android/graphics/PorterDuffXfermode
    //   69: dup
    //   70: getstatic 134	android/graphics/PorterDuff$Mode:SRC_OVER	Landroid/graphics/PorterDuff$Mode;
    //   73: invokespecial 121	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   76: invokevirtual 125	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   79: pop
    //   80: aload 13
    //   82: iconst_1
    //   83: invokevirtual 138	android/graphics/Paint:setFilterBitmap	(Z)V
    //   86: aload 13
    //   88: iconst_1
    //   89: invokevirtual 141	android/graphics/Paint:setAntiAlias	(Z)V
    //   92: new 143	android/graphics/Rect
    //   95: dup
    //   96: invokespecial 144	android/graphics/Rect:<init>	()V
    //   99: astore 14
    //   101: iload_3
    //   102: ifeq +37 -> 139
    //   105: iload 4
    //   107: ifeq +32 -> 139
    //   110: aload 14
    //   112: iconst_0
    //   113: putfield 147	android/graphics/Rect:top	I
    //   116: aload 14
    //   118: iconst_0
    //   119: putfield 150	android/graphics/Rect:left	I
    //   122: aload 14
    //   124: iload 9
    //   126: putfield 153	android/graphics/Rect:right	I
    //   129: aload 14
    //   131: iload 10
    //   133: putfield 156	android/graphics/Rect:bottom	I
    //   136: goto +333 -> 469
    //   139: iload_3
    //   140: ifeq +66 -> 206
    //   143: aload 14
    //   145: iconst_0
    //   146: putfield 150	android/graphics/Rect:left	I
    //   149: aload 14
    //   151: iload 9
    //   153: putfield 153	android/graphics/Rect:right	I
    //   156: aload 14
    //   158: invokevirtual 159	android/graphics/Rect:width	()I
    //   161: aload_1
    //   162: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   165: imul
    //   166: aload_1
    //   167: invokevirtual 163	android/graphics/Bitmap:getWidth	()I
    //   170: idiv
    //   171: istore 11
    //   173: aload 14
    //   175: aload 7
    //   177: getfield 147	android/graphics/Rect:top	I
    //   180: i2f
    //   181: aload_0
    //   182: getfield 58	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Float	F
    //   185: fmul
    //   186: f2i
    //   187: putfield 147	android/graphics/Rect:top	I
    //   190: aload 14
    //   192: aload 14
    //   194: getfield 147	android/graphics/Rect:top	I
    //   197: iload 11
    //   199: iadd
    //   200: putfield 156	android/graphics/Rect:bottom	I
    //   203: goto +266 -> 469
    //   206: iload 4
    //   208: ifeq +561 -> 769
    //   211: aload 14
    //   213: iconst_0
    //   214: putfield 147	android/graphics/Rect:top	I
    //   217: aload 14
    //   219: iload 10
    //   221: putfield 156	android/graphics/Rect:bottom	I
    //   224: aload 14
    //   226: invokevirtual 166	android/graphics/Rect:height	()I
    //   229: aload_1
    //   230: invokevirtual 163	android/graphics/Bitmap:getWidth	()I
    //   233: imul
    //   234: aload_1
    //   235: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   238: idiv
    //   239: istore 11
    //   241: aload 14
    //   243: aload 7
    //   245: getfield 150	android/graphics/Rect:left	I
    //   248: i2f
    //   249: aload_0
    //   250: getfield 58	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Float	F
    //   253: fmul
    //   254: f2i
    //   255: putfield 150	android/graphics/Rect:left	I
    //   258: aload 14
    //   260: aload 14
    //   262: getfield 150	android/graphics/Rect:left	I
    //   265: iload 11
    //   267: iadd
    //   268: putfield 153	android/graphics/Rect:right	I
    //   271: goto +198 -> 469
    //   274: aload 14
    //   276: aload 7
    //   278: invokevirtual 170	android/graphics/Rect:set	(Landroid/graphics/Rect;)V
    //   281: fconst_1
    //   282: fstore 8
    //   284: aload 12
    //   286: invokevirtual 171	android/graphics/Canvas:getWidth	()I
    //   289: istore 11
    //   291: iload 11
    //   293: aload_0
    //   294: getfield 63	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Int	I
    //   297: if_icmpeq +14 -> 311
    //   300: iload 11
    //   302: i2f
    //   303: aload_0
    //   304: getfield 63	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Int	I
    //   307: i2f
    //   308: fdiv
    //   309: fstore 8
    //   311: fload 8
    //   313: aload_0
    //   314: getfield 58	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Float	F
    //   317: fconst_2
    //   318: fdiv
    //   319: fmul
    //   320: fstore 8
    //   322: invokestatic 177	com/tencent/av/utils/AudioHelper:b	()Z
    //   325: ifeq +84 -> 409
    //   328: new 65	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   335: astore 15
    //   337: aload 15
    //   339: ldc 179
    //   341: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 15
    //   347: fload 8
    //   349: invokevirtual 81	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 15
    //   355: ldc 181
    //   357: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 15
    //   363: aload_0
    //   364: getfield 58	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Float	F
    //   367: invokevirtual 81	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 15
    //   373: ldc 183
    //   375: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 15
    //   381: aload 14
    //   383: invokevirtual 184	android/graphics/Rect:toString	()Ljava/lang/String;
    //   386: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 15
    //   392: ldc 186
    //   394: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: ldc 83
    //   400: iconst_1
    //   401: aload 15
    //   403: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 192	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload 14
    //   411: aload 14
    //   413: getfield 150	android/graphics/Rect:left	I
    //   416: i2f
    //   417: fload 8
    //   419: fmul
    //   420: f2i
    //   421: putfield 150	android/graphics/Rect:left	I
    //   424: aload 14
    //   426: aload 14
    //   428: getfield 147	android/graphics/Rect:top	I
    //   431: i2f
    //   432: fload 8
    //   434: fmul
    //   435: f2i
    //   436: putfield 147	android/graphics/Rect:top	I
    //   439: aload 14
    //   441: aload 14
    //   443: getfield 153	android/graphics/Rect:right	I
    //   446: i2f
    //   447: fload 8
    //   449: fmul
    //   450: f2i
    //   451: putfield 153	android/graphics/Rect:right	I
    //   454: aload 14
    //   456: aload 14
    //   458: getfield 156	android/graphics/Rect:bottom	I
    //   461: i2f
    //   462: fload 8
    //   464: fmul
    //   465: f2i
    //   466: putfield 156	android/graphics/Rect:bottom	I
    //   469: invokestatic 177	com/tencent/av/utils/AudioHelper:b	()Z
    //   472: ifeq +132 -> 604
    //   475: new 65	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   482: astore 15
    //   484: aload 15
    //   486: ldc 194
    //   488: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 15
    //   494: iload 9
    //   496: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 15
    //   502: ldc 196
    //   504: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 15
    //   510: iload 10
    //   512: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 15
    //   518: ldc 198
    //   520: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 15
    //   526: iload_3
    //   527: invokevirtual 201	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload 15
    //   533: ldc 203
    //   535: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload 15
    //   541: iload 4
    //   543: invokevirtual 201	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 15
    //   549: ldc 205
    //   551: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 15
    //   557: aload 7
    //   559: invokevirtual 184	android/graphics/Rect:toString	()Ljava/lang/String;
    //   562: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 15
    //   568: ldc 183
    //   570: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 15
    //   576: aload 14
    //   578: invokevirtual 184	android/graphics/Rect:toString	()Ljava/lang/String;
    //   581: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload 15
    //   587: ldc 186
    //   589: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: ldc 83
    //   595: iconst_1
    //   596: aload 15
    //   598: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 192	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload_2
    //   605: ifnull +193 -> 798
    //   608: aload 12
    //   610: aload_2
    //   611: aconst_null
    //   612: aload 14
    //   614: aload 13
    //   616: invokevirtual 209	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   619: goto +3 -> 622
    //   622: aload 12
    //   624: aload_1
    //   625: aconst_null
    //   626: aload 14
    //   628: aload 13
    //   630: invokevirtual 209	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   633: goto +17 -> 650
    //   636: astore_2
    //   637: aload 12
    //   639: astore_1
    //   640: goto +37 -> 677
    //   643: astore_2
    //   644: aload 12
    //   646: astore_1
    //   647: goto +37 -> 684
    //   650: aload 12
    //   652: ifnull +79 -> 731
    //   655: aload_0
    //   656: getfield 19	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Boolean	Z
    //   659: ifeq +72 -> 731
    //   662: aload_0
    //   663: getfield 29	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   666: aload 12
    //   668: invokeinterface 213 2 0
    //   673: return
    //   674: astore_2
    //   675: aconst_null
    //   676: astore_1
    //   677: goto +56 -> 733
    //   680: astore_2
    //   681: aload 13
    //   683: astore_1
    //   684: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   687: ifeq +12 -> 699
    //   690: ldc 83
    //   692: iconst_2
    //   693: ldc 218
    //   695: aload_2
    //   696: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   699: aload_1
    //   700: ifnull +31 -> 731
    //   703: aload_0
    //   704: getfield 19	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Boolean	Z
    //   707: ifeq +24 -> 731
    //   710: aload_0
    //   711: getfield 29	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   714: aload_1
    //   715: invokeinterface 213 2 0
    //   720: return
    //   721: astore_1
    //   722: ldc 83
    //   724: aload_1
    //   725: invokevirtual 225	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   728: invokestatic 228	com/tencent/av/AVLog:printErrorLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: return
    //   732: astore_2
    //   733: aload_1
    //   734: ifnull +33 -> 767
    //   737: aload_0
    //   738: getfield 19	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_Boolean	Z
    //   741: ifeq +26 -> 767
    //   744: aload_0
    //   745: getfield 29	com/tencent/av/ui/funchat/magicface/MagicfaceViewForAV:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   748: aload_1
    //   749: invokeinterface 213 2 0
    //   754: goto +13 -> 767
    //   757: astore_1
    //   758: ldc 83
    //   760: aload_1
    //   761: invokevirtual 225	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   764: invokestatic 228	com/tencent/av/AVLog:printErrorLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   767: aload_2
    //   768: athrow
    //   769: iload 5
    //   771: ifne -302 -> 469
    //   774: iload 6
    //   776: ifeq +6 -> 782
    //   779: goto -310 -> 469
    //   782: iload 5
    //   784: ifeq +6 -> 790
    //   787: goto -318 -> 469
    //   790: iload 6
    //   792: ifeq -518 -> 274
    //   795: goto -326 -> 469
    //   798: goto -176 -> 622
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	801	0	this	MagicfaceViewForAV
    //   0	801	1	paramBitmap1	android.graphics.Bitmap
    //   0	801	2	paramBitmap2	android.graphics.Bitmap
    //   0	801	3	paramBoolean1	boolean
    //   0	801	4	paramBoolean2	boolean
    //   0	801	5	paramBoolean3	boolean
    //   0	801	6	paramBoolean4	boolean
    //   0	801	7	paramRect	android.graphics.Rect
    //   282	181	8	f	float
    //   7	488	9	i	int
    //   13	498	10	j	int
    //   171	130	11	k	int
    //   25	642	12	localCanvas	android.graphics.Canvas
    //   1	681	13	localPaint	android.graphics.Paint
    //   99	528	14	localRect	android.graphics.Rect
    //   335	262	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   32	101	636	finally
    //   110	136	636	finally
    //   143	203	636	finally
    //   211	271	636	finally
    //   274	281	636	finally
    //   284	291	636	finally
    //   291	311	636	finally
    //   311	409	636	finally
    //   409	469	636	finally
    //   469	604	636	finally
    //   608	619	636	finally
    //   622	633	636	finally
    //   32	101	643	java/lang/Exception
    //   110	136	643	java/lang/Exception
    //   143	203	643	java/lang/Exception
    //   211	271	643	java/lang/Exception
    //   274	281	643	java/lang/Exception
    //   284	291	643	java/lang/Exception
    //   291	311	643	java/lang/Exception
    //   311	409	643	java/lang/Exception
    //   409	469	643	java/lang/Exception
    //   469	604	643	java/lang/Exception
    //   608	619	643	java/lang/Exception
    //   622	633	643	java/lang/Exception
    //   3	27	674	finally
    //   3	27	680	java/lang/Exception
    //   662	673	721	java/lang/Exception
    //   710	720	721	java/lang/Exception
    //   684	699	732	finally
    //   744	754	757	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.magicface.MagicfaceViewForAV
 * JD-Core Version:    0.7.0.1
 */