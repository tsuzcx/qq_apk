import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bkle
  extends bklt<bkld, bkld>
  implements sxl
{
  public final int a;
  public final String a;
  public final WeakReference<bjsu> a;
  public final WeakReference<bjsv> b;
  
  public bkle(bjsu parambjsu)
  {
    this(parambjsu, null, 0);
  }
  
  public bkle(bjsu parambjsu, bjsv parambjsv, int paramInt)
  {
    this(parambjsu, parambjsv, null, paramInt);
  }
  
  public bkle(bjsu parambjsu, bjsv parambjsv, String paramString, int paramInt)
  {
    if (parambjsu == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjsu);
    this.b = new WeakReference(parambjsv);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt + 90) % 180 == 0) {
      try
      {
        ved.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation begin!");
        long l = System.currentTimeMillis();
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.reset();
        localMatrix.postRotate(paramInt);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        ved.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation end, cost:" + (System.currentTimeMillis() - l) / 1000.0D);
        return paramBitmap;
      }
      catch (Exception paramBitmap)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 2, "rotate exception:" + paramBitmap);
        }
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, bkld parambkld)
  {
    // Byte code:
    //   0: invokestatic 133	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 7
    //   5: aload_2
    //   6: getfield 136	bkld:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: astore_1
    //   10: aload_1
    //   11: invokestatic 142	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +31 -> 45
    //   17: aload_0
    //   18: new 144	com/tencent/biz/qqstory/base/ErrorMessage
    //   21: dup
    //   22: iconst_m1
    //   23: ldc 146
    //   25: invokespecial 149	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   28: invokespecial 153	bklt:notifyError	(Ljava/lang/Error;)V
    //   31: ldc 155
    //   33: ldc 157
    //   35: iconst_0
    //   36: iconst_m1
    //   37: iconst_0
    //   38: anewarray 159	java/lang/String
    //   41: invokestatic 164	vei:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   44: return
    //   45: aload_0
    //   46: getfield 40	bkle:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   49: invokevirtual 168	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   52: checkcast 170	bjsu
    //   55: astore 14
    //   57: aload_0
    //   58: getfield 42	bkle:b	Ljava/lang/ref/WeakReference;
    //   61: invokevirtual 168	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   64: checkcast 172	bjsv
    //   67: astore 15
    //   69: aload 14
    //   71: ifnull +837 -> 908
    //   74: aload 14
    //   76: aload_0
    //   77: getfield 46	bkle:jdField_a_of_type_Int	I
    //   80: invokeinterface 175 2 0
    //   85: ifeq +22 -> 107
    //   88: aload 15
    //   90: ifnull +818 -> 908
    //   93: aload 15
    //   95: aload_0
    //   96: getfield 46	bkle:jdField_a_of_type_Int	I
    //   99: invokeinterface 176 2 0
    //   104: ifeq +804 -> 908
    //   107: aload 14
    //   109: invokeinterface 179 1 0
    //   114: aload_0
    //   115: getfield 46	bkle:jdField_a_of_type_Int	I
    //   118: invokevirtual 184	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	(I)Landroid/graphics/Bitmap;
    //   121: astore 12
    //   123: aload 12
    //   125: ifnull +44 -> 169
    //   128: aload_2
    //   129: getfield 185	bkld:jdField_a_of_type_Int	I
    //   132: aload_2
    //   133: getfield 187	bkld:b	Ljava/lang/String;
    //   136: ldc 189
    //   138: invokestatic 194	bklw:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 13
    //   143: aload 12
    //   145: aload 13
    //   147: aconst_null
    //   148: invokestatic 199	vxv:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lvxw;)V
    //   151: aload_2
    //   152: getfield 202	bkld:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   155: aload 13
    //   157: putfield 207	com/tencent/biz/qqstory/database/PublishVideoEntry:mosaicPath	Ljava/lang/String;
    //   160: ldc 51
    //   162: ldc 209
    //   164: aload 13
    //   166: invokestatic 212	ved:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   169: new 214	android/graphics/BitmapFactory$Options
    //   172: dup
    //   173: invokespecial 215	android/graphics/BitmapFactory$Options:<init>	()V
    //   176: astore 16
    //   178: aload 16
    //   180: iconst_1
    //   181: putfield 219	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   184: aload_1
    //   185: aload 16
    //   187: invokestatic 224	bbef:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   190: pop
    //   191: aload 16
    //   193: getfield 227	android/graphics/BitmapFactory$Options:outWidth	I
    //   196: istore 5
    //   198: aload 16
    //   200: getfield 230	android/graphics/BitmapFactory$Options:outHeight	I
    //   203: istore 6
    //   205: aload 14
    //   207: invokeinterface 179 1 0
    //   212: invokevirtual 233	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	()Lbkai;
    //   215: astore_1
    //   216: aload_1
    //   217: ifnull +28 -> 245
    //   220: aload_1
    //   221: iload 5
    //   223: iload 6
    //   225: iconst_1
    //   226: invokevirtual 238	bkai:a	(IIZ)Ljava/lang/String;
    //   229: astore_1
    //   230: aload_1
    //   231: ifnull +14 -> 245
    //   234: aload_2
    //   235: getfield 202	bkld:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   238: ldc 240
    //   240: aload_1
    //   241: invokevirtual 244	com/tencent/biz/qqstory/database/PublishVideoEntry:putExtra	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   244: pop
    //   245: aload 14
    //   247: invokeinterface 179 1 0
    //   252: astore_1
    //   253: aload_1
    //   254: ifnull +27 -> 281
    //   257: aload_1
    //   258: aload_2
    //   259: getfield 187	bkld:b	Ljava/lang/String;
    //   262: invokevirtual 247	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:a	(Ljava/lang/String;)Ljava/lang/String;
    //   265: astore_1
    //   266: aload_1
    //   267: ifnull +14 -> 281
    //   270: aload_2
    //   271: getfield 202	bkld:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   274: ldc 249
    //   276: aload_1
    //   277: invokevirtual 244	com/tencent/biz/qqstory/database/PublishVideoEntry:putExtra	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   280: pop
    //   281: aload 14
    //   283: aload_0
    //   284: getfield 46	bkle:jdField_a_of_type_Int	I
    //   287: iconst_0
    //   288: invokeinterface 252 3 0
    //   293: astore 13
    //   295: aload_0
    //   296: getfield 44	bkle:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   299: astore 12
    //   301: aload 12
    //   303: astore_1
    //   304: aload 12
    //   306: ifnonnull +17 -> 323
    //   309: aload_2
    //   310: getfield 185	bkld:jdField_a_of_type_Int	I
    //   313: aload_2
    //   314: getfield 187	bkld:b	Ljava/lang/String;
    //   317: ldc 254
    //   319: invokestatic 194	bklw:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   322: astore_1
    //   323: aload 13
    //   325: ifnull +537 -> 862
    //   328: aload 15
    //   330: ifnull +48 -> 378
    //   333: aload 15
    //   335: aload_0
    //   336: getfield 46	bkle:jdField_a_of_type_Int	I
    //   339: invokeinterface 176 2 0
    //   344: ifeq +34 -> 378
    //   347: aload 15
    //   349: aload_0
    //   350: getfield 46	bkle:jdField_a_of_type_Int	I
    //   353: new 256	android/graphics/Canvas
    //   356: dup
    //   357: aload 13
    //   359: invokespecial 259	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   362: aload 13
    //   364: invokevirtual 71	android/graphics/Bitmap:getWidth	()I
    //   367: aload 13
    //   369: invokevirtual 74	android/graphics/Bitmap:getHeight	()I
    //   372: invokeinterface 262 5 0
    //   377: pop
    //   378: iload 6
    //   380: istore 4
    //   382: iload 5
    //   384: istore_3
    //   385: aload_2
    //   386: getfield 265	bkld:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   389: instanceof 267
    //   392: ifeq +37 -> 429
    //   395: iload 6
    //   397: istore 4
    //   399: iload 5
    //   401: istore_3
    //   402: aload_2
    //   403: getfield 202	bkld:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   406: ldc_w 269
    //   409: iconst_0
    //   410: invokevirtual 273	com/tencent/biz/qqstory/database/PublishVideoEntry:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   413: ifeq +16 -> 429
    //   416: aload 16
    //   418: getfield 230	android/graphics/BitmapFactory$Options:outHeight	I
    //   421: istore_3
    //   422: aload 16
    //   424: getfield 227	android/graphics/BitmapFactory$Options:outWidth	I
    //   427: istore 4
    //   429: aload_2
    //   430: getfield 276	bkld:jdField_a_of_type_Bkll	Lbkll;
    //   433: getfield 281	bkll:c	I
    //   436: istore 5
    //   438: aload_2
    //   439: getfield 185	bkld:jdField_a_of_type_Int	I
    //   442: istore 6
    //   444: iload 6
    //   446: iconst_2
    //   447: if_icmpeq +36 -> 483
    //   450: iload 6
    //   452: iconst_3
    //   453: if_icmpeq +30 -> 483
    //   456: iload 6
    //   458: iconst_5
    //   459: if_icmpeq +24 -> 483
    //   462: iload 6
    //   464: bipush 101
    //   466: if_icmpeq +17 -> 483
    //   469: iload 6
    //   471: bipush 6
    //   473: if_icmpeq +10 -> 483
    //   476: iload 6
    //   478: bipush 102
    //   480: if_icmpne +456 -> 936
    //   483: aload_2
    //   484: getfield 265	bkld:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   487: instanceof 267
    //   490: ifeq +31 -> 521
    //   493: iconst_0
    //   494: istore 5
    //   496: ldc 51
    //   498: new 90	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 283
    //   508: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: iconst_0
    //   512: invokevirtual 286	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   515: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 59	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload 13
    //   523: iload 5
    //   525: invokestatic 288	bkle:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   528: astore 12
    //   530: aload 12
    //   532: ifnull +404 -> 936
    //   535: aload 12
    //   537: iload_3
    //   538: iload 4
    //   540: iconst_1
    //   541: iconst_0
    //   542: invokestatic 291	vxv:c	(Landroid/graphics/Bitmap;IIZZ)Landroid/graphics/Bitmap;
    //   545: astore 12
    //   547: aload 12
    //   549: ifnull +381 -> 930
    //   552: aload_2
    //   553: getfield 185	bkld:jdField_a_of_type_Int	I
    //   556: iconst_1
    //   557: if_icmpne +231 -> 788
    //   560: aload_2
    //   561: getfield 185	bkld:jdField_a_of_type_Int	I
    //   564: aload_2
    //   565: getfield 187	bkld:b	Ljava/lang/String;
    //   568: ldc 254
    //   570: invokestatic 194	bklw:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   573: astore 15
    //   575: aload 12
    //   577: aload 15
    //   579: aconst_null
    //   580: invokestatic 199	vxv:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Lvxw;)V
    //   583: aload_2
    //   584: getfield 202	bkld:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   587: aload 15
    //   589: putfield 294	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   592: iconst_1
    //   593: istore 11
    //   595: aconst_null
    //   596: astore_1
    //   597: aload 14
    //   599: aload 13
    //   601: invokeinterface 296 2 0
    //   606: aload 12
    //   608: aload 13
    //   610: if_acmpeq +8 -> 618
    //   613: aload 12
    //   615: invokestatic 297	vxv:a	(Landroid/graphics/Bitmap;)V
    //   618: aload 12
    //   620: ifnull +196 -> 816
    //   623: iload 11
    //   625: ifeq +191 -> 816
    //   628: ldc 51
    //   630: ldc_w 299
    //   633: invokestatic 301	ved:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: invokestatic 133	android/os/SystemClock:uptimeMillis	()J
    //   639: lstore 9
    //   641: ldc 155
    //   643: ldc_w 303
    //   646: iconst_0
    //   647: iconst_0
    //   648: iconst_1
    //   649: anewarray 159	java/lang/String
    //   652: dup
    //   653: iconst_0
    //   654: new 90	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   661: ldc_w 305
    //   664: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: lload 9
    //   669: lload 7
    //   671: lsub
    //   672: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   675: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: aastore
    //   679: invokestatic 164	vei:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   682: ldc 155
    //   684: ldc 157
    //   686: iconst_0
    //   687: iconst_0
    //   688: iconst_0
    //   689: anewarray 159	java/lang/String
    //   692: invokestatic 164	vei:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   695: aload_2
    //   696: getfield 202	bkld:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   699: aload_1
    //   700: putfield 311	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   703: aload_0
    //   704: aload_2
    //   705: invokespecial 314	bklt:notifyResult	(Ljava/lang/Object;)V
    //   708: return
    //   709: astore_1
    //   710: ldc 51
    //   712: ldc_w 316
    //   715: aload_1
    //   716: invokestatic 319	ved:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   719: aload_0
    //   720: new 144	com/tencent/biz/qqstory/base/ErrorMessage
    //   723: dup
    //   724: iconst_m1
    //   725: ldc 146
    //   727: invokespecial 149	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   730: invokespecial 153	bklt:notifyError	(Ljava/lang/Error;)V
    //   733: return
    //   734: astore_1
    //   735: ldc 51
    //   737: ldc_w 321
    //   740: aload_1
    //   741: invokestatic 323	ved:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   744: aload_0
    //   745: new 325	com/tencent/biz/qqstory/base/BitmapError
    //   748: dup
    //   749: ldc 51
    //   751: bipush 6
    //   753: invokespecial 328	com/tencent/biz/qqstory/base/BitmapError:<init>	(Ljava/lang/String;I)V
    //   756: invokespecial 153	bklt:notifyError	(Ljava/lang/Error;)V
    //   759: return
    //   760: astore 15
    //   762: ldc 51
    //   764: ldc_w 316
    //   767: aload 15
    //   769: invokestatic 319	ved:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   772: aload 12
    //   774: getstatic 334	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   777: bipush 60
    //   779: aload_1
    //   780: invokestatic 337	vxv:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   783: istore 11
    //   785: goto -188 -> 597
    //   788: aload 12
    //   790: getstatic 334	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   793: bipush 60
    //   795: aload_1
    //   796: invokestatic 337	vxv:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   799: istore 11
    //   801: goto -204 -> 597
    //   804: astore_1
    //   805: aload 14
    //   807: aload 13
    //   809: invokeinterface 296 2 0
    //   814: aload_1
    //   815: athrow
    //   816: ldc 51
    //   818: ldc_w 339
    //   821: invokestatic 59	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   824: ldc 155
    //   826: ldc 157
    //   828: iconst_0
    //   829: bipush 254
    //   831: iconst_0
    //   832: anewarray 159	java/lang/String
    //   835: invokestatic 164	vei:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   838: aload_2
    //   839: getfield 202	bkld:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   842: aconst_null
    //   843: putfield 311	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   846: aload_0
    //   847: new 144	com/tencent/biz/qqstory/base/ErrorMessage
    //   850: dup
    //   851: iconst_m1
    //   852: ldc_w 341
    //   855: invokespecial 149	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   858: invokespecial 153	bklt:notifyError	(Ljava/lang/Error;)V
    //   861: return
    //   862: ldc 51
    //   864: ldc_w 343
    //   867: invokestatic 59	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   870: ldc 155
    //   872: ldc 157
    //   874: iconst_0
    //   875: bipush 254
    //   877: iconst_0
    //   878: anewarray 159	java/lang/String
    //   881: invokestatic 164	vei:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   884: aload_2
    //   885: getfield 202	bkld:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   888: aconst_null
    //   889: putfield 311	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   892: aload_0
    //   893: new 144	com/tencent/biz/qqstory/base/ErrorMessage
    //   896: dup
    //   897: iconst_m1
    //   898: ldc_w 345
    //   901: invokespecial 149	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   904: invokespecial 153	bklt:notifyError	(Ljava/lang/Error;)V
    //   907: return
    //   908: ldc 51
    //   910: ldc_w 347
    //   913: invokestatic 59	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   916: aload_2
    //   917: getfield 202	bkld:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   920: aconst_null
    //   921: putfield 311	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   924: aload_0
    //   925: aload_2
    //   926: invokespecial 314	bklt:notifyResult	(Ljava/lang/Object;)V
    //   929: return
    //   930: iconst_0
    //   931: istore 11
    //   933: goto -336 -> 597
    //   936: aload 13
    //   938: astore 12
    //   940: goto -405 -> 535
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	943	0	this	bkle
    //   0	943	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	943	2	parambkld	bkld
    //   384	154	3	i	int
    //   380	159	4	j	int
    //   196	328	5	k	int
    //   203	278	6	m	int
    //   3	667	7	l1	long
    //   639	29	9	l2	long
    //   593	339	11	bool	boolean
    //   121	818	12	localObject1	java.lang.Object
    //   141	796	13	localObject2	java.lang.Object
    //   55	751	14	localbjsu	bjsu
    //   67	521	15	localObject3	java.lang.Object
    //   760	8	15	localThrowable	java.lang.Throwable
    //   176	247	16	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   143	169	709	java/io/IOException
    //   184	191	734	java/lang/OutOfMemoryError
    //   575	592	760	java/lang/Throwable
    //   333	378	804	finally
    //   385	395	804	finally
    //   402	429	804	finally
    //   429	444	804	finally
    //   483	493	804	finally
    //   496	521	804	finally
    //   521	530	804	finally
    //   535	547	804	finally
    //   552	575	804	finally
    //   575	592	804	finally
    //   762	785	804	finally
    //   788	801	804	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkle
 * JD-Core Version:    0.7.0.1
 */