import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aoaf
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private aoae jdField_a_of_type_Aoae;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m = true;
  private boolean n;
  private boolean o = true;
  
  public aoaf(WeakReference paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private boolean b()
  {
    return (!this.e) && (this.f) && (!this.g) && (this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0) && ((this.m) || (this.jdField_c_of_type_Int == 1));
  }
  
  private void f()
  {
    if (this.j)
    {
      this.j = false;
      this.jdField_a_of_type_Aoae.b();
    }
  }
  
  private void g()
  {
    if (this.i)
    {
      this.jdField_a_of_type_Aoae.c();
      this.i = false;
      GLTextureView.a().b(this);
    }
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 63	aoae
    //   4: dup
    //   5: aload_0
    //   6: getfield 46	aoaf:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 83	aoae:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 61	aoaf:jdField_a_of_type_Aoae	Laoae;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 67	aoaf:i	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 59	aoaf:j	Z
    //   25: iconst_0
    //   26: istore 10
    //   28: aconst_null
    //   29: astore 22
    //   31: iconst_0
    //   32: istore_1
    //   33: iconst_0
    //   34: istore_3
    //   35: iconst_0
    //   36: istore 5
    //   38: iconst_0
    //   39: istore 6
    //   41: iconst_0
    //   42: istore 7
    //   44: iconst_0
    //   45: istore 8
    //   47: iconst_0
    //   48: istore 9
    //   50: aconst_null
    //   51: astore 21
    //   53: iconst_0
    //   54: istore_2
    //   55: iconst_0
    //   56: istore 4
    //   58: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   61: astore 23
    //   63: aload 23
    //   65: monitorenter
    //   66: iload 10
    //   68: istore 11
    //   70: iload 7
    //   72: istore 10
    //   74: iload 4
    //   76: istore 14
    //   78: aload_0
    //   79: getfield 85	aoaf:jdField_b_of_type_Boolean	Z
    //   82: ifeq +34 -> 116
    //   85: aload 23
    //   87: monitorexit
    //   88: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   91: astore 21
    //   93: aload 21
    //   95: monitorenter
    //   96: aload_0
    //   97: invokespecial 87	aoaf:f	()V
    //   100: aload_0
    //   101: invokespecial 89	aoaf:g	()V
    //   104: aload 21
    //   106: monitorexit
    //   107: return
    //   108: astore 22
    //   110: aload 21
    //   112: monitorexit
    //   113: aload 22
    //   115: athrow
    //   116: aload_0
    //   117: getfield 34	aoaf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   120: invokevirtual 92	java/util/ArrayList:isEmpty	()Z
    //   123: ifne +93 -> 216
    //   126: aload_0
    //   127: getfield 34	aoaf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   130: iconst_0
    //   131: invokevirtual 96	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   134: checkcast 98	java/lang/Runnable
    //   137: astore 21
    //   139: iload 10
    //   141: istore 7
    //   143: iload 6
    //   145: istore 12
    //   147: iload_1
    //   148: istore 4
    //   150: iload 11
    //   152: istore 10
    //   154: iload 7
    //   156: istore 6
    //   158: iload 12
    //   160: istore 7
    //   162: iload_2
    //   163: istore_1
    //   164: iload 14
    //   166: istore_2
    //   167: aload 23
    //   169: monitorexit
    //   170: aload 21
    //   172: ifnull +648 -> 820
    //   175: aload 21
    //   177: invokeinterface 101 1 0
    //   182: iload 6
    //   184: istore 11
    //   186: aconst_null
    //   187: astore 21
    //   189: iload_1
    //   190: istore 12
    //   192: iload_2
    //   193: istore 6
    //   195: iload 4
    //   197: istore_1
    //   198: iload 12
    //   200: istore_2
    //   201: iload 6
    //   203: istore 4
    //   205: iload 7
    //   207: istore 6
    //   209: iload 11
    //   211: istore 7
    //   213: goto -155 -> 58
    //   216: aload_0
    //   217: getfield 53	aoaf:e	Z
    //   220: aload_0
    //   221: getfield 103	aoaf:d	Z
    //   224: if_icmpeq +1051 -> 1275
    //   227: aload_0
    //   228: getfield 103	aoaf:d	Z
    //   231: istore 19
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 103	aoaf:d	Z
    //   238: putfield 53	aoaf:e	Z
    //   241: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   244: invokevirtual 108	java/lang/Object:notifyAll	()V
    //   247: iload_3
    //   248: istore 4
    //   250: aload_0
    //   251: getfield 110	aoaf:l	Z
    //   254: ifeq +19 -> 273
    //   257: aload_0
    //   258: invokespecial 87	aoaf:f	()V
    //   261: aload_0
    //   262: invokespecial 89	aoaf:g	()V
    //   265: aload_0
    //   266: iconst_0
    //   267: putfield 110	aoaf:l	Z
    //   270: iconst_1
    //   271: istore 4
    //   273: iload 10
    //   275: istore 7
    //   277: iload 10
    //   279: ifeq +14 -> 293
    //   282: aload_0
    //   283: invokespecial 87	aoaf:f	()V
    //   286: aload_0
    //   287: invokespecial 89	aoaf:g	()V
    //   290: iconst_0
    //   291: istore 7
    //   293: iload 19
    //   295: ifeq +14 -> 309
    //   298: aload_0
    //   299: getfield 59	aoaf:j	Z
    //   302: ifeq +7 -> 309
    //   305: aload_0
    //   306: invokespecial 87	aoaf:f	()V
    //   309: iload 19
    //   311: ifeq +48 -> 359
    //   314: aload_0
    //   315: getfield 67	aoaf:i	Z
    //   318: ifeq +41 -> 359
    //   321: aload_0
    //   322: getfield 46	aoaf:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   325: invokevirtual 116	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   328: checkcast 71	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
    //   331: astore 24
    //   333: aload 24
    //   335: ifnonnull +346 -> 681
    //   338: iconst_0
    //   339: istore 20
    //   341: iload 20
    //   343: ifeq +12 -> 355
    //   346: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   349: invokevirtual 118	aoag:a	()Z
    //   352: ifeq +7 -> 359
    //   355: aload_0
    //   356: invokespecial 89	aoaf:g	()V
    //   359: iload 19
    //   361: ifeq +19 -> 380
    //   364: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   367: invokevirtual 120	aoag:b	()Z
    //   370: ifeq +10 -> 380
    //   373: aload_0
    //   374: getfield 61	aoaf:jdField_a_of_type_Aoae	Laoae;
    //   377: invokevirtual 69	aoae:c	()V
    //   380: aload_0
    //   381: getfield 55	aoaf:f	Z
    //   384: ifne +71 -> 455
    //   387: aload_0
    //   388: getfield 122	aoaf:h	Z
    //   391: ifne +64 -> 455
    //   394: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +31 -> 428
    //   400: ldc 129
    //   402: iconst_2
    //   403: new 131	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   410: ldc 134
    //   412: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_0
    //   416: invokevirtual 142	aoaf:getId	()J
    //   419: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload_0
    //   429: getfield 59	aoaf:j	Z
    //   432: ifeq +7 -> 439
    //   435: aload_0
    //   436: invokespecial 87	aoaf:f	()V
    //   439: aload_0
    //   440: iconst_1
    //   441: putfield 122	aoaf:h	Z
    //   444: aload_0
    //   445: iconst_0
    //   446: putfield 57	aoaf:g	Z
    //   449: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   452: invokevirtual 108	java/lang/Object:notifyAll	()V
    //   455: aload_0
    //   456: getfield 55	aoaf:f	Z
    //   459: ifeq +21 -> 480
    //   462: aload_0
    //   463: getfield 122	aoaf:h	Z
    //   466: ifeq +14 -> 480
    //   469: aload_0
    //   470: iconst_0
    //   471: putfield 122	aoaf:h	Z
    //   474: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   477: invokevirtual 108	java/lang/Object:notifyAll	()V
    //   480: iload 14
    //   482: istore 12
    //   484: iload 5
    //   486: istore 13
    //   488: iload 14
    //   490: ifeq +20 -> 510
    //   493: iconst_0
    //   494: istore 13
    //   496: iconst_0
    //   497: istore 12
    //   499: aload_0
    //   500: iconst_1
    //   501: putfield 154	aoaf:n	Z
    //   504: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   507: invokevirtual 108	java/lang/Object:notifyAll	()V
    //   510: iload 4
    //   512: istore_3
    //   513: iload 6
    //   515: istore 15
    //   517: iload 8
    //   519: istore 16
    //   521: iload 9
    //   523: istore 17
    //   525: iload 11
    //   527: istore 18
    //   529: aload_0
    //   530: invokespecial 155	aoaf:b	()Z
    //   533: ifeq +250 -> 783
    //   536: iload 4
    //   538: istore_3
    //   539: iload 11
    //   541: istore 10
    //   543: aload_0
    //   544: getfield 67	aoaf:i	Z
    //   547: ifne +14 -> 561
    //   550: iload 4
    //   552: ifeq +139 -> 691
    //   555: iconst_0
    //   556: istore_3
    //   557: iload 11
    //   559: istore 10
    //   561: aload_0
    //   562: getfield 67	aoaf:i	Z
    //   565: ifeq +699 -> 1264
    //   568: aload_0
    //   569: getfield 59	aoaf:j	Z
    //   572: ifne +692 -> 1264
    //   575: aload_0
    //   576: iconst_1
    //   577: putfield 59	aoaf:j	Z
    //   580: iconst_1
    //   581: istore 9
    //   583: iconst_1
    //   584: istore 5
    //   586: iconst_1
    //   587: istore 4
    //   589: aload_0
    //   590: getfield 59	aoaf:j	Z
    //   593: ifeq +691 -> 1284
    //   596: aload_0
    //   597: getfield 36	aoaf:o	Z
    //   600: ifeq +647 -> 1247
    //   603: iconst_1
    //   604: istore_2
    //   605: aload_0
    //   606: getfield 38	aoaf:jdField_a_of_type_Int	I
    //   609: istore 6
    //   611: aload_0
    //   612: getfield 40	aoaf:jdField_b_of_type_Int	I
    //   615: istore_1
    //   616: iconst_1
    //   617: istore 8
    //   619: iconst_1
    //   620: istore 5
    //   622: aload_0
    //   623: iconst_0
    //   624: putfield 36	aoaf:o	Z
    //   627: aload_0
    //   628: iconst_0
    //   629: putfield 42	aoaf:m	Z
    //   632: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   635: invokevirtual 108	java/lang/Object:notifyAll	()V
    //   638: iload 4
    //   640: istore 11
    //   642: iload 12
    //   644: istore 4
    //   646: iload 6
    //   648: istore 12
    //   650: iload 7
    //   652: istore 6
    //   654: iload_2
    //   655: istore 7
    //   657: iload 5
    //   659: istore 9
    //   661: iload 4
    //   663: istore_2
    //   664: iload_1
    //   665: istore 4
    //   667: iload 12
    //   669: istore_1
    //   670: iload 8
    //   672: istore 5
    //   674: iload 11
    //   676: istore 8
    //   678: goto -511 -> 167
    //   681: aload 24
    //   683: invokestatic 158	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Z
    //   686: istore 20
    //   688: goto -347 -> 341
    //   691: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   694: aload_0
    //   695: invokevirtual 161	aoag:a	(Laoaf;)Z
    //   698: istore 19
    //   700: iload 4
    //   702: istore_3
    //   703: iload 11
    //   705: istore 10
    //   707: iload 19
    //   709: ifeq -148 -> 561
    //   712: aload_0
    //   713: getfield 61	aoaf:jdField_a_of_type_Aoae	Laoae;
    //   716: invokevirtual 163	aoae:a	()V
    //   719: aload_0
    //   720: iconst_1
    //   721: putfield 67	aoaf:i	Z
    //   724: iconst_1
    //   725: istore 10
    //   727: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   730: invokevirtual 108	java/lang/Object:notifyAll	()V
    //   733: iload 4
    //   735: istore_3
    //   736: goto -175 -> 561
    //   739: astore 21
    //   741: aload 23
    //   743: monitorexit
    //   744: aload 21
    //   746: athrow
    //   747: astore 22
    //   749: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   752: astore 21
    //   754: aload 21
    //   756: monitorenter
    //   757: aload_0
    //   758: invokespecial 87	aoaf:f	()V
    //   761: aload_0
    //   762: invokespecial 89	aoaf:g	()V
    //   765: aload 21
    //   767: monitorexit
    //   768: aload 22
    //   770: athrow
    //   771: astore 21
    //   773: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   776: aload_0
    //   777: invokevirtual 79	aoag:b	(Laoaf;)V
    //   780: aload 21
    //   782: athrow
    //   783: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   786: invokevirtual 166	java/lang/Object:wait	()V
    //   789: iload 12
    //   791: istore 14
    //   793: iload 13
    //   795: istore 5
    //   797: iload 15
    //   799: istore 6
    //   801: iload 7
    //   803: istore 10
    //   805: iload 16
    //   807: istore 8
    //   809: iload 17
    //   811: istore 9
    //   813: iload 18
    //   815: istore 11
    //   817: goto -739 -> 78
    //   820: iload 9
    //   822: ifeq +422 -> 1244
    //   825: aload_0
    //   826: getfield 61	aoaf:jdField_a_of_type_Aoae	Laoae;
    //   829: invokevirtual 167	aoae:a	()Z
    //   832: ifeq +321 -> 1153
    //   835: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   838: astore 23
    //   840: aload 23
    //   842: monitorenter
    //   843: aload_0
    //   844: iconst_1
    //   845: putfield 169	aoaf:k	Z
    //   848: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   851: invokevirtual 108	java/lang/Object:notifyAll	()V
    //   854: aload 23
    //   856: monitorexit
    //   857: iconst_0
    //   858: istore 9
    //   860: iload 8
    //   862: ifeq +379 -> 1241
    //   865: aload_0
    //   866: getfield 61	aoaf:jdField_a_of_type_Aoae	Laoae;
    //   869: invokevirtual 172	aoae:a	()Ljavax/microedition/khronos/opengles/GL;
    //   872: checkcast 174	javax/microedition/khronos/opengles/GL10
    //   875: astore 22
    //   877: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   880: aload 22
    //   882: invokevirtual 177	aoag:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   885: iconst_0
    //   886: istore 8
    //   888: iload 10
    //   890: istore 11
    //   892: iload 10
    //   894: ifeq +50 -> 944
    //   897: aload_0
    //   898: getfield 46	aoaf:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   901: invokevirtual 116	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   904: checkcast 71	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
    //   907: astore 23
    //   909: aload 23
    //   911: ifnull +392 -> 1303
    //   914: aload 23
    //   916: invokestatic 180	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   919: ifnull +384 -> 1303
    //   922: aload 23
    //   924: invokestatic 180	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   927: aload 22
    //   929: aload_0
    //   930: getfield 61	aoaf:jdField_a_of_type_Aoae	Laoae;
    //   933: getfield 183	aoae:a	Ljavax/microedition/khronos/egl/EGLConfig;
    //   936: invokeinterface 189 3 0
    //   941: goto +362 -> 1303
    //   944: iload 7
    //   946: istore 10
    //   948: iload 7
    //   950: ifeq +46 -> 996
    //   953: aload_0
    //   954: getfield 46	aoaf:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   957: invokevirtual 116	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   960: checkcast 71	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
    //   963: astore 23
    //   965: aload 23
    //   967: ifnull +342 -> 1309
    //   970: aload 23
    //   972: invokestatic 180	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   975: ifnull +334 -> 1309
    //   978: aload 23
    //   980: invokestatic 180	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   983: aload 22
    //   985: iload_1
    //   986: iload 4
    //   988: invokeinterface 193 4 0
    //   993: goto +316 -> 1309
    //   996: aload_0
    //   997: getfield 46	aoaf:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1000: invokevirtual 116	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1003: checkcast 71	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
    //   1006: astore 23
    //   1008: aload 23
    //   1010: ifnull +23 -> 1033
    //   1013: aload 23
    //   1015: invokestatic 180	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   1018: ifnull +15 -> 1033
    //   1021: aload 23
    //   1023: invokestatic 180	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   1026: aload 22
    //   1028: invokeinterface 196 2 0
    //   1033: aload_0
    //   1034: getfield 61	aoaf:jdField_a_of_type_Aoae	Laoae;
    //   1037: invokevirtual 199	aoae:a	()I
    //   1040: istore 12
    //   1042: iload 6
    //   1044: istore 7
    //   1046: iload 12
    //   1048: lookupswitch	default:+267->1315, 12288:+63->1111, 12302:+171->1219
    //   1077: jsr_w 18 203 21 12
    //   1082: invokestatic 206	aoae:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1085: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   1088: astore 23
    //   1090: aload 23
    //   1092: monitorenter
    //   1093: aload_0
    //   1094: iconst_1
    //   1095: putfield 57	aoaf:g	Z
    //   1098: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   1101: invokevirtual 108	java/lang/Object:notifyAll	()V
    //   1104: aload 23
    //   1106: monitorexit
    //   1107: iload 6
    //   1109: istore 7
    //   1111: iload 5
    //   1113: ifeq +168 -> 1281
    //   1116: iconst_1
    //   1117: istore_2
    //   1118: iload_1
    //   1119: istore 12
    //   1121: iload_2
    //   1122: istore 6
    //   1124: iload 4
    //   1126: istore_1
    //   1127: iload 12
    //   1129: istore_2
    //   1130: iload 6
    //   1132: istore 4
    //   1134: iload 10
    //   1136: istore 6
    //   1138: iload 11
    //   1140: istore 10
    //   1142: goto -1084 -> 58
    //   1145: astore 21
    //   1147: aload 23
    //   1149: monitorexit
    //   1150: aload 21
    //   1152: athrow
    //   1153: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   1156: astore 23
    //   1158: aload 23
    //   1160: monitorenter
    //   1161: aload_0
    //   1162: iconst_1
    //   1163: putfield 169	aoaf:k	Z
    //   1166: aload_0
    //   1167: iconst_1
    //   1168: putfield 57	aoaf:g	Z
    //   1171: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   1174: invokevirtual 108	java/lang/Object:notifyAll	()V
    //   1177: aload 23
    //   1179: monitorexit
    //   1180: iload 6
    //   1182: istore 11
    //   1184: iload_1
    //   1185: istore 12
    //   1187: iload_2
    //   1188: istore 6
    //   1190: iload 4
    //   1192: istore_1
    //   1193: iload 12
    //   1195: istore_2
    //   1196: iload 6
    //   1198: istore 4
    //   1200: iload 7
    //   1202: istore 6
    //   1204: iload 11
    //   1206: istore 7
    //   1208: goto -1150 -> 58
    //   1211: astore 21
    //   1213: aload 23
    //   1215: monitorexit
    //   1216: aload 21
    //   1218: athrow
    //   1219: iconst_1
    //   1220: istore 7
    //   1222: goto -111 -> 1111
    //   1225: astore 21
    //   1227: aload 23
    //   1229: monitorexit
    //   1230: aload 21
    //   1232: athrow
    //   1233: astore 22
    //   1235: aload 21
    //   1237: monitorexit
    //   1238: aload 22
    //   1240: athrow
    //   1241: goto -353 -> 888
    //   1244: goto -384 -> 860
    //   1247: iload 13
    //   1249: istore 8
    //   1251: iload_2
    //   1252: istore 6
    //   1254: iload 5
    //   1256: istore_2
    //   1257: iload 9
    //   1259: istore 5
    //   1261: goto -634 -> 627
    //   1264: iload 6
    //   1266: istore 5
    //   1268: iload 8
    //   1270: istore 4
    //   1272: goto -683 -> 589
    //   1275: iconst_0
    //   1276: istore 19
    //   1278: goto -1031 -> 247
    //   1281: goto -163 -> 1118
    //   1284: iload 5
    //   1286: istore 15
    //   1288: iload 4
    //   1290: istore 16
    //   1292: iload 9
    //   1294: istore 17
    //   1296: iload 10
    //   1298: istore 18
    //   1300: goto -517 -> 783
    //   1303: iconst_0
    //   1304: istore 11
    //   1306: goto -362 -> 944
    //   1309: iconst_0
    //   1310: istore 10
    //   1312: goto -316 -> 996
    //   1315: goto -239 -> 1076
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1318	0	this	aoaf
    //   32	1161	1	i1	int
    //   54	1203	2	i2	int
    //   34	702	3	i3	int
    //   56	1233	4	i4	int
    //   36	1249	5	i5	int
    //   39	1226	6	i6	int
    //   42	1179	7	i7	int
    //   45	1224	8	i8	int
    //   48	1245	9	i9	int
    //   26	1285	10	i10	int
    //   68	1237	11	i11	int
    //   145	1049	12	i12	int
    //   486	762	13	i13	int
    //   76	716	14	i14	int
    //   515	772	15	i15	int
    //   519	772	16	i16	int
    //   523	772	17	i17	int
    //   527	772	18	i18	int
    //   231	1046	19	bool1	boolean
    //   339	348	20	bool2	boolean
    //   51	137	21	localObject1	Object
    //   739	6	21	localObject2	Object
    //   752	14	21	localaoag	aoag
    //   771	10	21	localRuntimeException	java.lang.RuntimeException
    //   1145	6	21	localObject3	Object
    //   1211	6	21	localObject4	Object
    //   1225	11	21	localObject5	Object
    //   29	1	22	localObject6	Object
    //   108	6	22	localObject7	Object
    //   747	22	22	localObject8	Object
    //   875	152	22	localGL10	javax.microedition.khronos.opengles.GL10
    //   1233	6	22	localObject9	Object
    //   331	351	24	localGLTextureView	GLTextureView
    // Exception table:
    //   from	to	target	type
    //   96	107	108	finally
    //   110	113	108	finally
    //   78	88	739	finally
    //   116	139	739	finally
    //   167	170	739	finally
    //   216	247	739	finally
    //   250	270	739	finally
    //   282	290	739	finally
    //   298	309	739	finally
    //   314	333	739	finally
    //   346	355	739	finally
    //   355	359	739	finally
    //   364	380	739	finally
    //   380	428	739	finally
    //   428	439	739	finally
    //   439	455	739	finally
    //   455	480	739	finally
    //   499	510	739	finally
    //   529	536	739	finally
    //   543	550	739	finally
    //   561	580	739	finally
    //   589	603	739	finally
    //   605	616	739	finally
    //   622	627	739	finally
    //   627	638	739	finally
    //   681	688	739	finally
    //   691	700	739	finally
    //   712	719	739	finally
    //   719	724	739	finally
    //   727	733	739	finally
    //   741	744	739	finally
    //   773	783	739	finally
    //   783	789	739	finally
    //   58	66	747	finally
    //   175	182	747	finally
    //   744	747	747	finally
    //   825	843	747	finally
    //   865	885	747	finally
    //   897	909	747	finally
    //   914	941	747	finally
    //   953	965	747	finally
    //   970	993	747	finally
    //   996	1008	747	finally
    //   1013	1033	747	finally
    //   1033	1042	747	finally
    //   1076	1093	747	finally
    //   1150	1153	747	finally
    //   1153	1161	747	finally
    //   1216	1219	747	finally
    //   1230	1233	747	finally
    //   712	719	771	java/lang/RuntimeException
    //   843	857	1145	finally
    //   1147	1150	1145	finally
    //   1161	1180	1211	finally
    //   1213	1216	1211	finally
    //   1093	1107	1225	finally
    //   1227	1230	1225	finally
    //   757	768	1233	finally
    //   1235	1238	1233	finally
  }
  
  public int a()
  {
    synchronized ()
    {
      int i1 = this.jdField_c_of_type_Int;
      return i1;
    }
  }
  
  public void a()
  {
    synchronized ()
    {
      this.m = true;
      GLTextureView.a().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1)) {
      throw new IllegalArgumentException("renderMode");
    }
    synchronized (GLTextureView.a())
    {
      this.jdField_c_of_type_Int = paramInt;
      GLTextureView.a().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized ()
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.o = true;
      this.m = true;
      this.n = false;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        if ((!this.jdField_c_of_type_Boolean) && (!this.e) && (!this.n))
        {
          boolean bool = a();
          if (bool) {
            try
            {
              GLTextureView.a().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException("r must not be null");
    }
    synchronized (GLTextureView.a())
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramRunnable);
      GLTextureView.a().notifyAll();
      return;
    }
  }
  
  public boolean a()
  {
    return (this.i) && (this.j) && (b());
  }
  
  public void b()
  {
    synchronized ()
    {
      this.f = true;
      this.k = false;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        if ((this.h) && (!this.k))
        {
          boolean bool = this.jdField_c_of_type_Boolean;
          if (!bool) {
            try
            {
              GLTextureView.a().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void c()
  {
    synchronized ()
    {
      this.f = false;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        if ((!this.h) && (!this.jdField_c_of_type_Boolean))
        {
          if ((!this.jdField_a_of_type_Boolean) && (QLog.isColorLevel()))
          {
            this.jdField_a_of_type_Boolean = true;
            QLog.d("GLTextureView", 2, "mWaitingForSurface " + this.h + " mExited " + this.jdField_c_of_type_Boolean);
          }
          try
          {
            GLTextureView.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
  
  public void d()
  {
    synchronized ()
    {
      this.jdField_b_of_type_Boolean = true;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        boolean bool = this.jdField_c_of_type_Boolean;
        if (!bool) {
          try
          {
            GLTextureView.a().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
  
  public void e()
  {
    this.l = true;
    GLTextureView.a().notifyAll();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 131	java/lang/StringBuilder
    //   4: dup
    //   5: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   8: ldc 243
    //   10: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: aload_0
    //   14: invokevirtual 142	aoaf:getId	()J
    //   17: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokevirtual 246	aoaf:setName	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: invokespecial 248	aoaf:h	()V
    //   30: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   33: aload_0
    //   34: invokevirtual 250	aoag:a	(Laoaf;)V
    //   37: return
    //   38: astore_1
    //   39: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   42: aload_0
    //   43: invokevirtual 250	aoag:a	(Laoaf;)V
    //   46: return
    //   47: astore_1
    //   48: invokestatic 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Laoag;
    //   51: aload_0
    //   52: invokevirtual 250	aoag:a	(Laoaf;)V
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	aoaf
    //   38	1	1	localInterruptedException	InterruptedException
    //   47	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	30	38	java/lang/InterruptedException
    //   26	30	47	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoaf
 * JD-Core Version:    0.7.0.1
 */