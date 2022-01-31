import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pic.CompressInfo;

public class auow
  extends auos
{
  public static final int l;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    int i = localResources.getDisplayMetrics().heightPixels;
    int j = localResources.getDisplayMetrics().widthPixels;
    if (i > j) {}
    for (;;)
    {
      l = i;
      return;
      i = j;
    }
  }
  
  auow(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a(CompressInfo paramCompressInfo)
  {
    switch (paramCompressInfo.jdField_g_of_type_Int)
    {
    default: 
      return -1;
    case 0: 
    case 1: 
      return 0;
    }
    return 2;
  }
  
  protected int[] a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Int == 2) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    int j = auos.e;
    int i = j;
    if (j > l) {
      i = l;
    }
    arrayOfInt[0] = i;
    arrayOfInt[1] = (arrayOfInt[0] * 2);
    aune.a("PicTypeNormal", "getScaleLargerSide", "PicType.SendPhotoMaxLongSide = " + arrayOfInt[0]);
    return arrayOfInt;
  }
  
  /* Error */
  protected boolean d()
  {
    // Byte code:
    //   0: fconst_1
    //   1: fstore_1
    //   2: iconst_0
    //   3: istore 6
    //   5: aload_0
    //   6: getfield 90	auow:k	I
    //   9: ifne +909 -> 918
    //   12: aload_0
    //   13: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   16: getfield 93	com/tencent/mobileqq/pic/CompressInfo:jdField_g_of_type_Boolean	Z
    //   19: ifeq +111 -> 130
    //   22: aload_0
    //   23: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   26: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   29: invokestatic 103	auoy:b	(Ljava/lang/String;)Z
    //   32: ifeq +98 -> 130
    //   35: aload_0
    //   36: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   39: aload_0
    //   40: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   43: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   46: putfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   49: aload_0
    //   50: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   53: new 59	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   71: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 109
    //   79: invokestatic 114	ajyc:a	(I)Ljava/lang/String;
    //   82: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: putfield 117	com/tencent/mobileqq/pic/CompressInfo:f	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: new 59	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   102: aload_0
    //   103: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   106: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   109: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 119
    //   114: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: ldc 120
    //   122: invokestatic 114	ajyc:a	(I)Ljava/lang/String;
    //   125: invokestatic 79	aune:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   128: iconst_1
    //   129: ireturn
    //   130: aload_0
    //   131: invokevirtual 122	auow:a	()[I
    //   134: astore 9
    //   136: aload 9
    //   138: ifnonnull +39 -> 177
    //   141: aload_0
    //   142: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   145: ldc 124
    //   147: new 59	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   154: aload_0
    //   155: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   158: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 126
    //   166: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 128	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   175: iconst_0
    //   176: ireturn
    //   177: aload 9
    //   179: iconst_0
    //   180: iaload
    //   181: istore 7
    //   183: aload 9
    //   185: iconst_1
    //   186: iaload
    //   187: istore_2
    //   188: aload_0
    //   189: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   192: aload_0
    //   193: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   196: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   199: aload_0
    //   200: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   203: getfield 46	com/tencent/mobileqq/pic/CompressInfo:jdField_g_of_type_Int	I
    //   206: invokestatic 131	auoy:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   209: putfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   212: aload_0
    //   213: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   216: getfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   219: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   222: ifeq +39 -> 261
    //   225: aload_0
    //   226: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   229: ldc 124
    //   231: new 59	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   238: aload_0
    //   239: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   242: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   245: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 139
    //   250: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 128	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   259: iconst_0
    //   260: ireturn
    //   261: aload_0
    //   262: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   265: getfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   268: invokestatic 142	bbdj:b	(Ljava/lang/String;)Z
    //   271: ifeq +39 -> 310
    //   274: aload_0
    //   275: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   278: ldc 124
    //   280: new 59	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   287: aload_0
    //   288: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   291: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   294: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc 144
    //   299: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 128	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   308: iconst_1
    //   309: ireturn
    //   310: new 146	android/graphics/BitmapFactory$Options
    //   313: dup
    //   314: invokespecial 147	android/graphics/BitmapFactory$Options:<init>	()V
    //   317: astore 9
    //   319: aload 9
    //   321: aload_0
    //   322: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   325: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   328: iload_2
    //   329: iload 7
    //   331: invokestatic 150	auoy:a	(Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;II)Z
    //   334: ifne +39 -> 373
    //   337: aload_0
    //   338: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   341: ldc 124
    //   343: new 59	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   350: aload_0
    //   351: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   354: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   357: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc 152
    //   362: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 128	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   371: iconst_0
    //   372: ireturn
    //   373: aload_0
    //   374: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   377: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   380: aload 9
    //   382: invokestatic 157	bbdr:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   385: astore 10
    //   387: aload 10
    //   389: ifnonnull +102 -> 491
    //   392: aload_0
    //   393: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   396: ldc 124
    //   398: new 59	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   405: aload_0
    //   406: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   409: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   412: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc 159
    //   417: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 128	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   426: iconst_0
    //   427: ireturn
    //   428: astore 9
    //   430: aload_0
    //   431: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   434: iconst_1
    //   435: invokevirtual 162	com/tencent/mobileqq/pic/CompressInfo:a	(Z)V
    //   438: aload 9
    //   440: invokevirtual 165	java/lang/OutOfMemoryError:printStackTrace	()V
    //   443: aload_0
    //   444: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   447: ldc 124
    //   449: new 59	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   456: aload_0
    //   457: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   460: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   463: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: ldc 167
    //   468: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 128	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload_0
    //   478: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   481: ldc 169
    //   483: putfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   486: aload_0
    //   487: invokevirtual 171	auow:c	()Z
    //   490: ireturn
    //   491: aload 10
    //   493: invokevirtual 177	android/graphics/Bitmap:getWidth	()I
    //   496: istore_2
    //   497: aload 10
    //   499: invokevirtual 180	android/graphics/Bitmap:getHeight	()I
    //   502: istore_3
    //   503: new 182	android/graphics/Matrix
    //   506: dup
    //   507: invokespecial 183	android/graphics/Matrix:<init>	()V
    //   510: astore 11
    //   512: iload_2
    //   513: iload_3
    //   514: if_icmple +258 -> 772
    //   517: iload_2
    //   518: istore 4
    //   520: iload_3
    //   521: istore 5
    //   523: iload 4
    //   525: iload 7
    //   527: if_icmple +393 -> 920
    //   530: iload 7
    //   532: i2f
    //   533: fconst_1
    //   534: iload 4
    //   536: i2f
    //   537: fmul
    //   538: fdiv
    //   539: fstore_1
    //   540: iload 5
    //   542: i2f
    //   543: fload_1
    //   544: fmul
    //   545: f2i
    //   546: istore 5
    //   548: iload 4
    //   550: i2f
    //   551: fload_1
    //   552: fmul
    //   553: f2i
    //   554: istore 4
    //   556: iconst_1
    //   557: istore 4
    //   559: iload_2
    //   560: iload_3
    //   561: if_icmple +3 -> 564
    //   564: aload_0
    //   565: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   568: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   571: invokestatic 186	bbdr:b	(Ljava/lang/String;)I
    //   574: istore 7
    //   576: iload 6
    //   578: istore 5
    //   580: aload_0
    //   581: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   584: getfield 188	com/tencent/mobileqq/pic/CompressInfo:d	Z
    //   587: ifeq +44 -> 631
    //   590: iload 6
    //   592: istore 5
    //   594: iload 7
    //   596: ifeq +35 -> 631
    //   599: iload 6
    //   601: istore 5
    //   603: iload 7
    //   605: bipush 90
    //   607: irem
    //   608: ifne +23 -> 631
    //   611: aload 11
    //   613: iload 7
    //   615: i2f
    //   616: iload_2
    //   617: iconst_1
    //   618: ishr
    //   619: i2f
    //   620: iload_3
    //   621: iconst_1
    //   622: ishr
    //   623: i2f
    //   624: invokevirtual 192	android/graphics/Matrix:postRotate	(FFF)Z
    //   627: pop
    //   628: iconst_1
    //   629: istore 5
    //   631: iload 4
    //   633: ifeq +11 -> 644
    //   636: aload 11
    //   638: fload_1
    //   639: fload_1
    //   640: invokevirtual 196	android/graphics/Matrix:postScale	(FF)Z
    //   643: pop
    //   644: iload 5
    //   646: ifne +12 -> 658
    //   649: aload 10
    //   651: astore 9
    //   653: iload 4
    //   655: ifeq +17 -> 672
    //   658: aload 10
    //   660: iconst_0
    //   661: iconst_0
    //   662: iload_2
    //   663: iload_3
    //   664: aload 11
    //   666: iconst_1
    //   667: invokestatic 200	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   670: astore 9
    //   672: aload_0
    //   673: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   676: getfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   679: aload 9
    //   681: aload_0
    //   682: invokevirtual 202	auow:a	()I
    //   685: aload_0
    //   686: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   689: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   692: aload_0
    //   693: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   696: invokestatic 205	auoy:a	(Ljava/lang/String;Landroid/graphics/Bitmap;ILjava/lang/String;Lcom/tencent/mobileqq/pic/CompressInfo;)Z
    //   699: istore 8
    //   701: aload_0
    //   702: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   705: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   708: invokestatic 210	com/tencent/image/JpegExifReader:isCrashJpeg	(Ljava/lang/String;)Z
    //   711: ifne +193 -> 904
    //   714: new 212	android/media/ExifInterface
    //   717: dup
    //   718: aload_0
    //   719: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   722: getfield 97	com/tencent/mobileqq/pic/CompressInfo:c	Ljava/lang/String;
    //   725: invokespecial 215	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   728: new 212	android/media/ExifInterface
    //   731: dup
    //   732: aload_0
    //   733: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   736: getfield 105	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   739: invokespecial 215	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   742: invokestatic 218	bbdr:a	(Landroid/media/ExifInterface;Landroid/media/ExifInterface;)Z
    //   745: ifne +14 -> 759
    //   748: aload_0
    //   749: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   752: ldc 124
    //   754: ldc 220
    //   756: invokestatic 128	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   759: aload 9
    //   761: ifnull +8 -> 769
    //   764: aload 9
    //   766: invokevirtual 223	android/graphics/Bitmap:recycle	()V
    //   769: iload 8
    //   771: ireturn
    //   772: iload_3
    //   773: istore 4
    //   775: iload_2
    //   776: istore 5
    //   778: goto -255 -> 523
    //   781: astore 9
    //   783: aload_0
    //   784: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   787: ldc 124
    //   789: new 59	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   796: aload_0
    //   797: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   800: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   803: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: ldc 225
    //   808: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: invokestatic 128	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   817: aload 10
    //   819: astore 9
    //   821: goto -149 -> 672
    //   824: astore 9
    //   826: aload_0
    //   827: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   830: ldc 124
    //   832: new 59	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   839: aload_0
    //   840: getfield 50	auow:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   843: getfield 108	com/tencent/mobileqq/pic/CompressInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   846: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: ldc 227
    //   851: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   857: invokestatic 128	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   860: aload 10
    //   862: astore 9
    //   864: goto -192 -> 672
    //   867: astore 10
    //   869: aload_0
    //   870: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   873: ldc 124
    //   875: new 59	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   882: ldc 229
    //   884: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: aload 10
    //   889: invokevirtual 232	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   892: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   898: invokestatic 128	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   901: goto -142 -> 759
    //   904: aload_0
    //   905: getfield 107	auow:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   908: ldc 124
    //   910: ldc 234
    //   912: invokestatic 128	aune:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   915: goto -156 -> 759
    //   918: iconst_0
    //   919: ireturn
    //   920: iconst_0
    //   921: istore 4
    //   923: goto -364 -> 559
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	926	0	this	auow
    //   1	639	1	f	float
    //   187	589	2	i	int
    //   502	271	3	j	int
    //   518	404	4	k	int
    //   521	256	5	m	int
    //   3	597	6	n	int
    //   181	433	7	i1	int
    //   699	71	8	bool	boolean
    //   134	247	9	localObject1	java.lang.Object
    //   428	11	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   651	114	9	localObject2	java.lang.Object
    //   781	1	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   819	1	9	localObject3	java.lang.Object
    //   824	1	9	localNullPointerException	java.lang.NullPointerException
    //   862	1	9	localObject4	java.lang.Object
    //   385	476	10	localBitmap	android.graphics.Bitmap
    //   867	21	10	localThrowable	java.lang.Throwable
    //   510	155	11	localMatrix	android.graphics.Matrix
    // Exception table:
    //   from	to	target	type
    //   373	387	428	java/lang/OutOfMemoryError
    //   392	426	428	java/lang/OutOfMemoryError
    //   658	672	781	java/lang/OutOfMemoryError
    //   658	672	824	java/lang/NullPointerException
    //   714	759	867	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auow
 * JD-Core Version:    0.7.0.1
 */