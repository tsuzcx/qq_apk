import android.content.Context;
import com.tencent.mobileqq.ar.arcloud.ARCloudImageFilter;
import com.tencent.qphone.base.util.QLog;

public class apna
{
  public static int a;
  public static int b;
  Context jdField_a_of_type_AndroidContentContext = null;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  public int c;
  private byte[] c;
  public int d;
  private byte[] d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j = 10;
  private int k = 170;
  private int l = 640;
  private int m = 480;
  private int n;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public apna(int paramInt)
  {
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_d_of_type_Int = -2147483648;
    this.e = paramInt;
    if ((paramInt == jdField_a_of_type_Int) && (azag.a() != null))
    {
      this.j = azag.a().g;
      this.k = azag.a().h;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARCloudImageSelect", 2, "init args ocr bestImgThreshold:" + this.j + ",sameSceneDiff:" + this.k);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ARCloudImageFilter.nativeUninit();
      this.jdField_a_of_type_Boolean = false;
    }
    this.f = 0;
    this.g = 0;
    this.j = 10;
    this.k = 170;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.h = 0;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.i = 0;
    this.l = 0;
    this.m = 0;
    this.jdField_c_of_type_ArrayOfByte = null;
    this.n = 0;
    this.jdField_d_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    if (this.e == jdField_a_of_type_Int) {
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.h);
    }
    try
    {
      if (this.e == jdField_a_of_type_Int) {}
      for (bool = ARCloudImageFilter.nativeIsSameScene(this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte);; bool = ARCloudImageFilter.nativeIsSameScene(this.jdField_c_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte))
      {
        return bool;
        if ((this.f != this.l) || (this.g != this.m))
        {
          int i2 = (this.f - this.l) / 2;
          int i1 = this.l;
          int i3 = (this.g - this.m) / 2;
          i1 = this.m;
          i1 = 0;
          while (i1 < this.m)
          {
            System.arraycopy(paramArrayOfByte, (i1 + i3) * this.f + i2, this.jdField_c_of_type_ArrayOfByte, this.l * i1, this.l);
            i1 += 1;
          }
        }
        System.arraycopy(paramArrayOfByte, 0, this.jdField_c_of_type_ArrayOfByte, 0, this.n);
        break;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        QLog.i("AREngine_ARCloudImageSelect", 1, "ARCloudImageFilter.nativeIsSameScene()" + paramArrayOfByte.getMessage());
        boolean bool = false;
      }
    }
  }
  
  /* Error */
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	apna:f	I
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: getfield 99	apna:g	I
    //   11: ifne +149 -> 160
    //   14: ldc 67
    //   16: iconst_1
    //   17: ldc 140
    //   19: invokestatic 135	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: iload_2
    //   24: putfield 98	apna:f	I
    //   27: aload_0
    //   28: iload_3
    //   29: putfield 99	apna:g	I
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 98	apna:f	I
    //   37: aload_0
    //   38: getfield 99	apna:g	I
    //   41: imul
    //   42: putfield 102	apna:h	I
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 98	apna:f	I
    //   50: aload_0
    //   51: getfield 99	apna:g	I
    //   54: imul
    //   55: iconst_3
    //   56: imul
    //   57: iconst_2
    //   58: idiv
    //   59: putfield 106	apna:i	I
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 102	apna:h	I
    //   67: newarray byte
    //   69: putfield 101	apna:jdField_a_of_type_ArrayOfByte	[B
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 106	apna:i	I
    //   77: newarray byte
    //   79: putfield 104	apna:jdField_b_of_type_ArrayOfByte	[B
    //   82: aload_0
    //   83: aload_0
    //   84: getfield 102	apna:h	I
    //   87: newarray byte
    //   89: putfield 112	apna:jdField_d_of_type_ArrayOfByte	[B
    //   92: aload_0
    //   93: getfield 98	apna:f	I
    //   96: aload_0
    //   97: getfield 99	apna:g	I
    //   100: if_icmple +553 -> 653
    //   103: aload_0
    //   104: getfield 98	apna:f	I
    //   107: sipush 480
    //   110: if_icmplt +460 -> 570
    //   113: aload_0
    //   114: getfield 99	apna:g	I
    //   117: sipush 480
    //   120: if_icmplt +450 -> 570
    //   123: aload_0
    //   124: sipush 480
    //   127: putfield 39	apna:l	I
    //   130: aload_0
    //   131: sipush 480
    //   134: putfield 41	apna:m	I
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 39	apna:l	I
    //   142: aload_0
    //   143: getfield 41	apna:m	I
    //   146: imul
    //   147: putfield 110	apna:n	I
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 110	apna:n	I
    //   155: newarray byte
    //   157: putfield 108	apna:jdField_c_of_type_ArrayOfByte	[B
    //   160: aload_0
    //   161: getfield 98	apna:f	I
    //   164: iload_2
    //   165: if_icmpne +11 -> 176
    //   168: aload_0
    //   169: getfield 99	apna:g	I
    //   172: iload_3
    //   173: if_icmpeq +161 -> 334
    //   176: aload_0
    //   177: iload_2
    //   178: putfield 98	apna:f	I
    //   181: aload_0
    //   182: iload_3
    //   183: putfield 99	apna:g	I
    //   186: aload_0
    //   187: aload_0
    //   188: getfield 98	apna:f	I
    //   191: aload_0
    //   192: getfield 99	apna:g	I
    //   195: imul
    //   196: putfield 102	apna:h	I
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 98	apna:f	I
    //   204: aload_0
    //   205: getfield 99	apna:g	I
    //   208: imul
    //   209: iconst_3
    //   210: imul
    //   211: iconst_2
    //   212: idiv
    //   213: putfield 106	apna:i	I
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 102	apna:h	I
    //   221: newarray byte
    //   223: putfield 101	apna:jdField_a_of_type_ArrayOfByte	[B
    //   226: aload_0
    //   227: aload_0
    //   228: getfield 106	apna:i	I
    //   231: newarray byte
    //   233: putfield 104	apna:jdField_b_of_type_ArrayOfByte	[B
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 102	apna:h	I
    //   241: newarray byte
    //   243: putfield 112	apna:jdField_d_of_type_ArrayOfByte	[B
    //   246: aload_0
    //   247: getfield 98	apna:f	I
    //   250: aload_0
    //   251: getfield 99	apna:g	I
    //   254: if_icmple +474 -> 728
    //   257: aload_0
    //   258: getfield 98	apna:f	I
    //   261: sipush 480
    //   264: if_icmplt +445 -> 709
    //   267: aload_0
    //   268: getfield 99	apna:g	I
    //   271: sipush 480
    //   274: if_icmplt +435 -> 709
    //   277: aload_0
    //   278: sipush 480
    //   281: putfield 39	apna:l	I
    //   284: aload_0
    //   285: sipush 480
    //   288: putfield 41	apna:m	I
    //   291: aload_0
    //   292: aload_0
    //   293: getfield 39	apna:l	I
    //   296: aload_0
    //   297: getfield 41	apna:m	I
    //   300: imul
    //   301: putfield 110	apna:n	I
    //   304: aload_0
    //   305: aload_0
    //   306: getfield 110	apna:n	I
    //   309: newarray byte
    //   311: putfield 108	apna:jdField_c_of_type_ArrayOfByte	[B
    //   314: aload_0
    //   315: getfield 90	apna:jdField_a_of_type_Boolean	Z
    //   318: istore 5
    //   320: iload 5
    //   322: ifeq +12 -> 334
    //   325: invokestatic 96	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeUninit	()I
    //   328: pop
    //   329: aload_0
    //   330: iconst_0
    //   331: putfield 90	apna:jdField_a_of_type_Boolean	Z
    //   334: aload_0
    //   335: getfield 90	apna:jdField_a_of_type_Boolean	Z
    //   338: ifne +104 -> 442
    //   341: invokestatic 145	apkn:a	()Lapkn;
    //   344: invokevirtual 147	apkn:a	()Z
    //   347: ifeq +471 -> 818
    //   350: iconst_1
    //   351: istore_2
    //   352: aload_0
    //   353: getfield 48	apna:e	I
    //   356: getstatic 50	apna:jdField_a_of_type_Int	I
    //   359: if_icmpne +464 -> 823
    //   362: aload_0
    //   363: getfield 98	apna:f	I
    //   366: aload_0
    //   367: getfield 99	apna:g	I
    //   370: aload_0
    //   371: getfield 35	apna:j	I
    //   374: aload_0
    //   375: getfield 37	apna:k	I
    //   378: aload_0
    //   379: getfield 106	apna:i	I
    //   382: invokestatic 151	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeInitOcr	(IIIII)I
    //   385: pop
    //   386: iload_2
    //   387: iconst_1
    //   388: if_icmpne +496 -> 884
    //   391: aload_0
    //   392: iload_2
    //   393: invokestatic 155	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeSetNeonOpen	(I)I
    //   396: putfield 44	apna:jdField_c_of_type_Int	I
    //   399: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +35 -> 437
    //   405: ldc 67
    //   407: iconst_2
    //   408: ldc 157
    //   410: iconst_2
    //   411: anewarray 4	java/lang/Object
    //   414: dup
    //   415: iconst_0
    //   416: iconst_0
    //   417: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   420: aastore
    //   421: dup
    //   422: iconst_1
    //   423: aload_0
    //   424: getfield 44	apna:jdField_c_of_type_Int	I
    //   427: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   430: aastore
    //   431: invokestatic 169	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   434: invokestatic 135	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload_0
    //   438: iconst_1
    //   439: putfield 90	apna:jdField_a_of_type_Boolean	Z
    //   442: aload_0
    //   443: getfield 48	apna:e	I
    //   446: getstatic 50	apna:jdField_a_of_type_Int	I
    //   449: if_icmpne +443 -> 892
    //   452: aload_1
    //   453: iconst_0
    //   454: aload_0
    //   455: getfield 101	apna:jdField_a_of_type_ArrayOfByte	[B
    //   458: iconst_0
    //   459: aload_0
    //   460: getfield 102	apna:h	I
    //   463: invokestatic 124	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   466: aload_1
    //   467: iconst_0
    //   468: aload_0
    //   469: getfield 104	apna:jdField_b_of_type_ArrayOfByte	[B
    //   472: iconst_0
    //   473: aload_0
    //   474: getfield 106	apna:i	I
    //   477: invokestatic 124	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   480: lconst_0
    //   481: lstore 6
    //   483: getstatic 170	apkn:jdField_a_of_type_Boolean	Z
    //   486: ifeq +8 -> 494
    //   489: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   492: lstore 6
    //   494: aload_0
    //   495: getfield 48	apna:e	I
    //   498: getstatic 50	apna:jdField_a_of_type_Int	I
    //   501: if_icmpne +511 -> 1012
    //   504: aload_0
    //   505: aload_0
    //   506: getfield 101	apna:jdField_a_of_type_ArrayOfByte	[B
    //   509: aload_0
    //   510: getfield 104	apna:jdField_b_of_type_ArrayOfByte	[B
    //   513: invokestatic 177	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeFilter	([B[B)Z
    //   516: putfield 114	apna:jdField_b_of_type_Boolean	Z
    //   519: aload_0
    //   520: getfield 114	apna:jdField_b_of_type_Boolean	Z
    //   523: ifeq +20 -> 543
    //   526: aload_0
    //   527: getfield 101	apna:jdField_a_of_type_ArrayOfByte	[B
    //   530: iconst_0
    //   531: aload_0
    //   532: getfield 112	apna:jdField_d_of_type_ArrayOfByte	[B
    //   535: iconst_0
    //   536: aload_0
    //   537: getfield 102	apna:h	I
    //   540: invokestatic 124	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   543: getstatic 170	apkn:jdField_a_of_type_Boolean	Z
    //   546: ifeq +19 -> 565
    //   549: invokestatic 145	apkn:a	()Lapkn;
    //   552: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   555: lload 6
    //   557: lsub
    //   558: aload_0
    //   559: getfield 44	apna:jdField_c_of_type_Int	I
    //   562: invokevirtual 180	apkn:a	(JI)V
    //   565: aload_0
    //   566: getfield 114	apna:jdField_b_of_type_Boolean	Z
    //   569: ireturn
    //   570: aload_0
    //   571: aload_0
    //   572: getfield 98	apna:f	I
    //   575: putfield 39	apna:l	I
    //   578: aload_0
    //   579: aload_0
    //   580: getfield 99	apna:g	I
    //   583: putfield 41	apna:m	I
    //   586: goto -449 -> 137
    //   589: astore_1
    //   590: ldc 67
    //   592: iconst_1
    //   593: new 69	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   600: ldc 182
    //   602: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload_1
    //   606: invokevirtual 183	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   609: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 135	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload_0
    //   619: aconst_null
    //   620: putfield 101	apna:jdField_a_of_type_ArrayOfByte	[B
    //   623: aload_0
    //   624: aconst_null
    //   625: putfield 104	apna:jdField_b_of_type_ArrayOfByte	[B
    //   628: aload_0
    //   629: aconst_null
    //   630: putfield 108	apna:jdField_c_of_type_ArrayOfByte	[B
    //   633: aload_0
    //   634: iconst_0
    //   635: putfield 98	apna:f	I
    //   638: aload_0
    //   639: iconst_0
    //   640: putfield 99	apna:g	I
    //   643: aload_0
    //   644: aconst_null
    //   645: putfield 112	apna:jdField_d_of_type_ArrayOfByte	[B
    //   648: invokestatic 186	java/lang/System:gc	()V
    //   651: iconst_0
    //   652: ireturn
    //   653: aload_0
    //   654: getfield 98	apna:f	I
    //   657: sipush 480
    //   660: if_icmplt +30 -> 690
    //   663: aload_0
    //   664: getfield 99	apna:g	I
    //   667: sipush 480
    //   670: if_icmplt +20 -> 690
    //   673: aload_0
    //   674: sipush 480
    //   677: putfield 39	apna:l	I
    //   680: aload_0
    //   681: sipush 480
    //   684: putfield 41	apna:m	I
    //   687: goto -550 -> 137
    //   690: aload_0
    //   691: aload_0
    //   692: getfield 98	apna:f	I
    //   695: putfield 39	apna:l	I
    //   698: aload_0
    //   699: aload_0
    //   700: getfield 99	apna:g	I
    //   703: putfield 41	apna:m	I
    //   706: goto -569 -> 137
    //   709: aload_0
    //   710: aload_0
    //   711: getfield 98	apna:f	I
    //   714: putfield 39	apna:l	I
    //   717: aload_0
    //   718: aload_0
    //   719: getfield 99	apna:g	I
    //   722: putfield 41	apna:m	I
    //   725: goto -434 -> 291
    //   728: aload_0
    //   729: getfield 98	apna:f	I
    //   732: sipush 480
    //   735: if_icmplt +30 -> 765
    //   738: aload_0
    //   739: getfield 99	apna:g	I
    //   742: sipush 480
    //   745: if_icmplt +20 -> 765
    //   748: aload_0
    //   749: sipush 480
    //   752: putfield 39	apna:l	I
    //   755: aload_0
    //   756: sipush 480
    //   759: putfield 41	apna:m	I
    //   762: goto -471 -> 291
    //   765: aload_0
    //   766: aload_0
    //   767: getfield 98	apna:f	I
    //   770: putfield 39	apna:l	I
    //   773: aload_0
    //   774: aload_0
    //   775: getfield 99	apna:g	I
    //   778: putfield 41	apna:m	I
    //   781: goto -490 -> 291
    //   784: astore 8
    //   786: ldc 67
    //   788: iconst_1
    //   789: new 69	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   796: ldc 188
    //   798: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 8
    //   803: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   806: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokestatic 135	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: goto -486 -> 329
    //   818: iconst_0
    //   819: istore_2
    //   820: goto -468 -> 352
    //   823: aload_0
    //   824: getfield 39	apna:l	I
    //   827: aload_0
    //   828: getfield 41	apna:m	I
    //   831: aload_0
    //   832: getfield 35	apna:j	I
    //   835: aload_0
    //   836: getfield 37	apna:k	I
    //   839: aload_0
    //   840: getfield 106	apna:i	I
    //   843: invokestatic 191	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeInit	(IIIII)I
    //   846: pop
    //   847: goto -461 -> 386
    //   850: astore 8
    //   852: ldc 67
    //   854: iconst_1
    //   855: new 69	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   862: ldc 193
    //   864: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload 8
    //   869: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   872: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 135	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: goto -444 -> 437
    //   884: aload_0
    //   885: iconst_0
    //   886: putfield 44	apna:jdField_c_of_type_Int	I
    //   889: goto -490 -> 399
    //   892: aload_0
    //   893: getfield 98	apna:f	I
    //   896: aload_0
    //   897: getfield 39	apna:l	I
    //   900: if_icmpne +14 -> 914
    //   903: aload_0
    //   904: getfield 99	apna:g	I
    //   907: aload_0
    //   908: getfield 41	apna:m	I
    //   911: if_icmpeq +84 -> 995
    //   914: aload_0
    //   915: getfield 98	apna:f	I
    //   918: aload_0
    //   919: getfield 39	apna:l	I
    //   922: isub
    //   923: iconst_2
    //   924: idiv
    //   925: istore_3
    //   926: aload_0
    //   927: getfield 39	apna:l	I
    //   930: istore_2
    //   931: aload_0
    //   932: getfield 99	apna:g	I
    //   935: aload_0
    //   936: getfield 41	apna:m	I
    //   939: isub
    //   940: iconst_2
    //   941: idiv
    //   942: istore 4
    //   944: aload_0
    //   945: getfield 41	apna:m	I
    //   948: istore_2
    //   949: iconst_0
    //   950: istore_2
    //   951: iload_2
    //   952: aload_0
    //   953: getfield 41	apna:m	I
    //   956: if_icmpge -490 -> 466
    //   959: aload_1
    //   960: iload_2
    //   961: iload 4
    //   963: iadd
    //   964: aload_0
    //   965: getfield 98	apna:f	I
    //   968: imul
    //   969: iload_3
    //   970: iadd
    //   971: aload_0
    //   972: getfield 108	apna:jdField_c_of_type_ArrayOfByte	[B
    //   975: aload_0
    //   976: getfield 39	apna:l	I
    //   979: iload_2
    //   980: imul
    //   981: aload_0
    //   982: getfield 39	apna:l	I
    //   985: invokestatic 124	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   988: iload_2
    //   989: iconst_1
    //   990: iadd
    //   991: istore_2
    //   992: goto -41 -> 951
    //   995: aload_1
    //   996: iconst_0
    //   997: aload_0
    //   998: getfield 108	apna:jdField_c_of_type_ArrayOfByte	[B
    //   1001: iconst_0
    //   1002: aload_0
    //   1003: getfield 110	apna:n	I
    //   1006: invokestatic 124	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1009: goto -543 -> 466
    //   1012: aload_0
    //   1013: aload_0
    //   1014: getfield 108	apna:jdField_c_of_type_ArrayOfByte	[B
    //   1017: aload_0
    //   1018: getfield 104	apna:jdField_b_of_type_ArrayOfByte	[B
    //   1021: invokestatic 177	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeFilter	([B[B)Z
    //   1024: putfield 114	apna:jdField_b_of_type_Boolean	Z
    //   1027: aload_0
    //   1028: getfield 114	apna:jdField_b_of_type_Boolean	Z
    //   1031: ifeq -488 -> 543
    //   1034: aload_0
    //   1035: getfield 108	apna:jdField_c_of_type_ArrayOfByte	[B
    //   1038: iconst_0
    //   1039: aload_0
    //   1040: getfield 112	apna:jdField_d_of_type_ArrayOfByte	[B
    //   1043: iconst_0
    //   1044: aload_0
    //   1045: getfield 110	apna:n	I
    //   1048: invokestatic 124	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1051: goto -508 -> 543
    //   1054: astore_1
    //   1055: ldc 67
    //   1057: iconst_1
    //   1058: new 69	java/lang/StringBuilder
    //   1061: dup
    //   1062: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   1065: ldc 195
    //   1067: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: aload_1
    //   1071: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1074: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokestatic 135	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: goto -518 -> 565
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1086	0	this	apna
    //   0	1086	1	paramArrayOfByte	byte[]
    //   0	1086	2	paramInt1	int
    //   0	1086	3	paramInt2	int
    //   942	22	4	i1	int
    //   318	3	5	bool	boolean
    //   481	75	6	l1	long
    //   784	18	8	localException1	Exception
    //   850	18	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	14	589	java/lang/OutOfMemoryError
    //   14	137	589	java/lang/OutOfMemoryError
    //   137	160	589	java/lang/OutOfMemoryError
    //   160	176	589	java/lang/OutOfMemoryError
    //   176	291	589	java/lang/OutOfMemoryError
    //   291	320	589	java/lang/OutOfMemoryError
    //   325	329	589	java/lang/OutOfMemoryError
    //   329	334	589	java/lang/OutOfMemoryError
    //   570	586	589	java/lang/OutOfMemoryError
    //   653	687	589	java/lang/OutOfMemoryError
    //   690	706	589	java/lang/OutOfMemoryError
    //   709	725	589	java/lang/OutOfMemoryError
    //   728	762	589	java/lang/OutOfMemoryError
    //   765	781	589	java/lang/OutOfMemoryError
    //   786	815	589	java/lang/OutOfMemoryError
    //   325	329	784	java/lang/Exception
    //   352	386	850	java/lang/Exception
    //   391	399	850	java/lang/Exception
    //   399	437	850	java/lang/Exception
    //   823	847	850	java/lang/Exception
    //   884	889	850	java/lang/Exception
    //   483	494	1054	java/lang/Exception
    //   494	543	1054	java/lang/Exception
    //   543	565	1054	java/lang/Exception
    //   1012	1051	1054	java/lang/Exception
  }
  
  public byte[] a()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apna
 * JD-Core Version:    0.7.0.1
 */