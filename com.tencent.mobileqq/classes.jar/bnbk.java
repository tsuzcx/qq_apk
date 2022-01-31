import com.tencent.biz.qqstory.database.PublishVideoEntry;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import java.lang.ref.WeakReference;

public class bnbk
  extends bnbp<bnaz, bnaz>
  implements uqm
{
  public final int a;
  public final String a;
  public final WeakReference<bmiq> a;
  public final WeakReference<bmir> b;
  
  public bnbk(bmiq parambmiq)
  {
    this(parambmiq, null, 0);
  }
  
  public bnbk(bmiq parambmiq, bmir parambmir, int paramInt)
  {
    this(parambmiq, parambmir, null, paramInt);
  }
  
  public bnbk(bmiq parambmiq, bmir parambmir, String paramString, int paramInt)
  {
    if (parambmiq == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmiq);
    this.b = new WeakReference(parambmir);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static int a(bnaz parambnaz)
  {
    int j = 0;
    int i = parambnaz.jdField_a_of_type_Bnbh.c;
    if ((parambnaz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      i = j;
      if (!parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false))
      {
        i = j;
        if (parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false)) {
          i = 270;
        }
      }
      return i;
    }
    return i;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, bnaz parambnaz)
  {
    // Byte code:
    //   0: invokestatic 90	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 5
    //   5: aload_2
    //   6: getfield 91	bnaz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: astore_1
    //   10: aload_1
    //   11: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +31 -> 45
    //   17: aload_0
    //   18: new 99	com/tencent/biz/qqstory/base/ErrorMessage
    //   21: dup
    //   22: iconst_m1
    //   23: ldc 101
    //   25: invokespecial 104	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   28: invokespecial 108	bnbp:notifyError	(Ljava/lang/Error;)V
    //   31: ldc 110
    //   33: ldc 112
    //   35: iconst_0
    //   36: iconst_m1
    //   37: iconst_0
    //   38: anewarray 114	java/lang/String
    //   41: invokestatic 119	wxj:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   44: return
    //   45: aload_0
    //   46: getfield 40	bnbk:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   49: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   52: checkcast 125	bmiq
    //   55: astore 11
    //   57: aload_0
    //   58: getfield 42	bnbk:b	Ljava/lang/ref/WeakReference;
    //   61: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   64: checkcast 127	bmir
    //   67: astore 13
    //   69: aload 11
    //   71: ifnull +877 -> 948
    //   74: aload 11
    //   76: aload_0
    //   77: getfield 46	bnbk:jdField_a_of_type_Int	I
    //   80: invokeinterface 130 2 0
    //   85: ifeq +22 -> 107
    //   88: aload 13
    //   90: ifnull +858 -> 948
    //   93: aload 13
    //   95: aload_0
    //   96: getfield 46	bnbk:jdField_a_of_type_Int	I
    //   99: invokeinterface 131 2 0
    //   104: ifeq +844 -> 948
    //   107: aload 11
    //   109: invokeinterface 134 1 0
    //   114: aload_0
    //   115: getfield 46	bnbk:jdField_a_of_type_Int	I
    //   118: invokevirtual 139	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	(I)Landroid/graphics/Bitmap;
    //   121: astore 10
    //   123: aload 10
    //   125: ifnull +44 -> 169
    //   128: aload_2
    //   129: getfield 140	bnaz:jdField_a_of_type_Int	I
    //   132: aload_2
    //   133: getfield 142	bnaz:b	Ljava/lang/String;
    //   136: ldc 144
    //   138: invokestatic 149	bnbs:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 12
    //   143: aload 10
    //   145: aload 12
    //   147: aconst_null
    //   148: invokestatic 154	xqw:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lxqx;)V
    //   151: aload_2
    //   152: getfield 65	bnaz:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   155: aload 12
    //   157: putfield 157	com/tencent/biz/qqstory/database/PublishVideoEntry:mosaicPath	Ljava/lang/String;
    //   160: ldc 159
    //   162: ldc 161
    //   164: aload 12
    //   166: invokestatic 166	wxe:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   169: new 168	android/graphics/BitmapFactory$Options
    //   172: dup
    //   173: invokespecial 169	android/graphics/BitmapFactory$Options:<init>	()V
    //   176: astore 14
    //   178: aload 14
    //   180: iconst_1
    //   181: putfield 173	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   184: aload_1
    //   185: aload 14
    //   187: invokestatic 178	bdhj:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   190: pop
    //   191: aload 14
    //   193: getfield 181	android/graphics/BitmapFactory$Options:outWidth	I
    //   196: istore 4
    //   198: aload 14
    //   200: getfield 184	android/graphics/BitmapFactory$Options:outHeight	I
    //   203: istore_3
    //   204: aload_2
    //   205: getfield 187	bnaz:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   208: getfield 190	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:jdField_a_of_type_Int	I
    //   211: bipush 14
    //   213: if_icmpne +40 -> 253
    //   216: aload_2
    //   217: getfield 187	bnaz:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   220: invokevirtual 194	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:d	()Z
    //   223: ifeq +30 -> 253
    //   226: aload_2
    //   227: getfield 187	bnaz:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   230: getfield 195	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   233: invokeinterface 200 1 0
    //   238: aload_2
    //   239: getfield 187	bnaz:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   242: getfield 195	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   245: invokeinterface 202 1 0
    //   250: if_icmplt +15 -> 265
    //   253: aload_2
    //   254: getfield 187	bnaz:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   257: getfield 190	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:jdField_a_of_type_Int	I
    //   260: bipush 14
    //   262: if_icmpeq +472 -> 734
    //   265: iconst_1
    //   266: istore 9
    //   268: aload 11
    //   270: invokeinterface 134 1 0
    //   275: invokevirtual 205	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	()Lbmqe;
    //   278: astore_1
    //   279: aload_1
    //   280: ifnull +28 -> 308
    //   283: aload_1
    //   284: iload 4
    //   286: iload_3
    //   287: iload 9
    //   289: invokevirtual 210	bmqe:a	(IIZ)Ljava/lang/String;
    //   292: astore_1
    //   293: aload_1
    //   294: ifnull +14 -> 308
    //   297: aload_2
    //   298: getfield 65	bnaz:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   301: ldc 212
    //   303: aload_1
    //   304: invokevirtual 216	com/tencent/biz/qqstory/database/PublishVideoEntry:putExtra	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   307: pop
    //   308: aload 11
    //   310: invokeinterface 134 1 0
    //   315: astore_1
    //   316: aload_1
    //   317: ifnull +27 -> 344
    //   320: aload_1
    //   321: aload_2
    //   322: getfield 142	bnaz:b	Ljava/lang/String;
    //   325: invokevirtual 219	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	(Ljava/lang/String;)Ljava/lang/String;
    //   328: astore_1
    //   329: aload_1
    //   330: ifnull +14 -> 344
    //   333: aload_2
    //   334: getfield 65	bnaz:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   337: ldc 221
    //   339: aload_1
    //   340: invokevirtual 216	com/tencent/biz/qqstory/database/PublishVideoEntry:putExtra	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   343: pop
    //   344: aload 11
    //   346: aload_0
    //   347: getfield 46	bnbk:jdField_a_of_type_Int	I
    //   350: iconst_0
    //   351: invokeinterface 224 3 0
    //   356: astore 12
    //   358: aload_0
    //   359: getfield 44	bnbk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   362: astore 10
    //   364: aload 10
    //   366: astore_1
    //   367: aload 10
    //   369: ifnonnull +17 -> 386
    //   372: aload_2
    //   373: getfield 140	bnaz:jdField_a_of_type_Int	I
    //   376: aload_2
    //   377: getfield 142	bnaz:b	Ljava/lang/String;
    //   380: ldc 226
    //   382: invokestatic 149	bnbs:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   385: astore_1
    //   386: aload 12
    //   388: ifnull +514 -> 902
    //   391: aload 13
    //   393: ifnull +48 -> 441
    //   396: aload 13
    //   398: aload_0
    //   399: getfield 46	bnbk:jdField_a_of_type_Int	I
    //   402: invokeinterface 131 2 0
    //   407: ifeq +34 -> 441
    //   410: aload 13
    //   412: aload_0
    //   413: getfield 46	bnbk:jdField_a_of_type_Int	I
    //   416: new 228	android/graphics/Canvas
    //   419: dup
    //   420: aload 12
    //   422: invokespecial 231	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   425: aload 12
    //   427: invokevirtual 236	android/graphics/Bitmap:getWidth	()I
    //   430: aload 12
    //   432: invokevirtual 239	android/graphics/Bitmap:getHeight	()I
    //   435: invokeinterface 242 5 0
    //   440: pop
    //   441: iload 4
    //   443: iload_3
    //   444: if_icmple +535 -> 979
    //   447: iload 9
    //   449: ifeq +530 -> 979
    //   452: aload 14
    //   454: getfield 184	android/graphics/BitmapFactory$Options:outHeight	I
    //   457: istore 4
    //   459: aload 14
    //   461: getfield 181	android/graphics/BitmapFactory$Options:outWidth	I
    //   464: istore_3
    //   465: aload 12
    //   467: iload 4
    //   469: iload_3
    //   470: iconst_1
    //   471: iconst_0
    //   472: invokestatic 245	xqw:c	(Landroid/graphics/Bitmap;IIZZ)Landroid/graphics/Bitmap;
    //   475: astore 10
    //   477: aload_2
    //   478: invokestatic 247	bnbk:a	(Lbnaz;)I
    //   481: istore_3
    //   482: iload_3
    //   483: ifeq +257 -> 740
    //   486: aload 10
    //   488: iload_3
    //   489: i2f
    //   490: invokestatic 252	xsm:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   493: astore 10
    //   495: aload 10
    //   497: ifnull +473 -> 970
    //   500: aload_2
    //   501: getfield 140	bnaz:jdField_a_of_type_Int	I
    //   504: iconst_1
    //   505: if_icmpne +315 -> 820
    //   508: aload_2
    //   509: getfield 140	bnaz:jdField_a_of_type_Int	I
    //   512: aload_2
    //   513: getfield 142	bnaz:b	Ljava/lang/String;
    //   516: ldc 226
    //   518: invokestatic 149	bnbs:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   521: astore 13
    //   523: aload 10
    //   525: aload 13
    //   527: aconst_null
    //   528: invokestatic 154	xqw:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lxqx;)V
    //   531: aload_2
    //   532: getfield 65	bnaz:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   535: aload 13
    //   537: putfield 255	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   540: iconst_1
    //   541: istore 9
    //   543: aconst_null
    //   544: astore_1
    //   545: aload 11
    //   547: aload 12
    //   549: invokeinterface 257 2 0
    //   554: aload 10
    //   556: aload 12
    //   558: if_acmpeq +8 -> 566
    //   561: aload 10
    //   563: invokestatic 258	xqw:a	(Landroid/graphics/Bitmap;)V
    //   566: aload 10
    //   568: ifnull +288 -> 856
    //   571: iload 9
    //   573: ifeq +283 -> 856
    //   576: ldc 159
    //   578: ldc_w 260
    //   581: invokestatic 263	wxe:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: invokestatic 90	android/os/SystemClock:uptimeMillis	()J
    //   587: lstore 7
    //   589: ldc 110
    //   591: ldc_w 265
    //   594: iconst_0
    //   595: iconst_0
    //   596: iconst_1
    //   597: anewarray 114	java/lang/String
    //   600: dup
    //   601: iconst_0
    //   602: new 267	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   609: ldc_w 270
    //   612: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: lload 7
    //   617: lload 5
    //   619: lsub
    //   620: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   623: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: aastore
    //   627: invokestatic 119	wxj:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   630: ldc 110
    //   632: ldc 112
    //   634: iconst_0
    //   635: iconst_0
    //   636: iconst_0
    //   637: anewarray 114	java/lang/String
    //   640: invokestatic 119	wxj:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   643: aload_2
    //   644: getfield 65	bnaz:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   647: aload_1
    //   648: putfield 284	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   651: aload_0
    //   652: aload_2
    //   653: invokespecial 287	bnbp:notifyResult	(Ljava/lang/Object;)V
    //   656: return
    //   657: astore_1
    //   658: ldc 159
    //   660: ldc_w 289
    //   663: aload_1
    //   664: invokestatic 292	wxe:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   667: aload_0
    //   668: new 99	com/tencent/biz/qqstory/base/ErrorMessage
    //   671: dup
    //   672: iconst_m1
    //   673: ldc 101
    //   675: invokespecial 104	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   678: invokespecial 108	bnbp:notifyError	(Ljava/lang/Error;)V
    //   681: return
    //   682: astore_1
    //   683: ldc 159
    //   685: ldc_w 294
    //   688: aload_1
    //   689: invokestatic 292	wxe:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   692: aload_0
    //   693: new 99	com/tencent/biz/qqstory/base/ErrorMessage
    //   696: dup
    //   697: iconst_m1
    //   698: ldc_w 296
    //   701: invokespecial 104	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   704: invokespecial 108	bnbp:notifyError	(Ljava/lang/Error;)V
    //   707: return
    //   708: astore_1
    //   709: ldc 159
    //   711: ldc_w 298
    //   714: aload_1
    //   715: invokestatic 300	wxe:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   718: aload_0
    //   719: new 302	com/tencent/biz/qqstory/base/BitmapError
    //   722: dup
    //   723: ldc 159
    //   725: bipush 6
    //   727: invokespecial 305	com/tencent/biz/qqstory/base/BitmapError:<init>	(Ljava/lang/String;I)V
    //   730: invokespecial 108	bnbp:notifyError	(Ljava/lang/Error;)V
    //   733: return
    //   734: iconst_0
    //   735: istore 9
    //   737: goto -469 -> 268
    //   740: aload 14
    //   742: getfield 181	android/graphics/BitmapFactory$Options:outWidth	I
    //   745: aload 14
    //   747: getfield 184	android/graphics/BitmapFactory$Options:outHeight	I
    //   750: if_icmple +226 -> 976
    //   753: aload_2
    //   754: getfield 140	bnaz:jdField_a_of_type_Int	I
    //   757: bipush 12
    //   759: if_icmpeq +12 -> 771
    //   762: aload_2
    //   763: getfield 140	bnaz:jdField_a_of_type_Int	I
    //   766: bipush 11
    //   768: if_icmpne +208 -> 976
    //   771: aload 10
    //   773: ldc_w 306
    //   776: invokestatic 252	xsm:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   779: astore 10
    //   781: goto -286 -> 495
    //   784: astore 13
    //   786: ldc 159
    //   788: ldc_w 289
    //   791: aload 13
    //   793: invokestatic 292	wxe:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   796: aload 10
    //   798: getstatic 312	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   801: bipush 60
    //   803: aload_1
    //   804: invokestatic 315	xqw:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   807: istore 9
    //   809: aload_2
    //   810: getfield 65	bnaz:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   813: aload_1
    //   814: putfield 255	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   817: goto -272 -> 545
    //   820: aload 10
    //   822: getstatic 312	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   825: bipush 60
    //   827: aload_1
    //   828: invokestatic 315	xqw:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   831: istore 9
    //   833: aload_2
    //   834: getfield 65	bnaz:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   837: aload_1
    //   838: putfield 255	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   841: goto -296 -> 545
    //   844: astore_1
    //   845: aload 11
    //   847: aload 12
    //   849: invokeinterface 257 2 0
    //   854: aload_1
    //   855: athrow
    //   856: ldc 159
    //   858: ldc_w 317
    //   861: invokestatic 319	wxe:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   864: ldc 110
    //   866: ldc 112
    //   868: iconst_0
    //   869: bipush 254
    //   871: iconst_0
    //   872: anewarray 114	java/lang/String
    //   875: invokestatic 119	wxj:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   878: aload_2
    //   879: getfield 65	bnaz:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   882: aconst_null
    //   883: putfield 284	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   886: aload_0
    //   887: new 99	com/tencent/biz/qqstory/base/ErrorMessage
    //   890: dup
    //   891: iconst_m1
    //   892: ldc_w 321
    //   895: invokespecial 104	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   898: invokespecial 108	bnbp:notifyError	(Ljava/lang/Error;)V
    //   901: return
    //   902: ldc 159
    //   904: ldc_w 323
    //   907: invokestatic 319	wxe:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   910: ldc 110
    //   912: ldc 112
    //   914: iconst_0
    //   915: bipush 254
    //   917: iconst_0
    //   918: anewarray 114	java/lang/String
    //   921: invokestatic 119	wxj:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   924: aload_2
    //   925: getfield 65	bnaz:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   928: aconst_null
    //   929: putfield 284	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   932: aload_0
    //   933: new 99	com/tencent/biz/qqstory/base/ErrorMessage
    //   936: dup
    //   937: iconst_m1
    //   938: ldc_w 325
    //   941: invokespecial 104	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   944: invokespecial 108	bnbp:notifyError	(Ljava/lang/Error;)V
    //   947: return
    //   948: ldc 159
    //   950: ldc_w 327
    //   953: invokestatic 319	wxe:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   956: aload_2
    //   957: getfield 65	bnaz:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   960: aconst_null
    //   961: putfield 284	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   964: aload_0
    //   965: aload_2
    //   966: invokespecial 287	bnbp:notifyResult	(Ljava/lang/Object;)V
    //   969: return
    //   970: iconst_0
    //   971: istore 9
    //   973: goto -428 -> 545
    //   976: goto -481 -> 495
    //   979: goto -514 -> 465
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	982	0	this	bnbk
    //   0	982	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	982	2	parambnaz	bnaz
    //   203	286	3	i	int
    //   196	272	4	j	int
    //   3	615	5	l1	long
    //   587	29	7	l2	long
    //   266	706	9	bool	boolean
    //   121	700	10	localObject1	java.lang.Object
    //   55	791	11	localbmiq	bmiq
    //   141	707	12	localObject2	java.lang.Object
    //   67	469	13	localObject3	java.lang.Object
    //   784	8	13	localThrowable	java.lang.Throwable
    //   176	570	14	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   143	169	657	java/io/IOException
    //   143	169	682	java/lang/UnsupportedOperationException
    //   184	191	708	java/lang/OutOfMemoryError
    //   523	540	784	java/lang/Throwable
    //   396	441	844	finally
    //   452	465	844	finally
    //   465	482	844	finally
    //   486	495	844	finally
    //   500	523	844	finally
    //   523	540	844	finally
    //   740	771	844	finally
    //   771	781	844	finally
    //   786	817	844	finally
    //   820	841	844	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbk
 * JD-Core Version:    0.7.0.1
 */