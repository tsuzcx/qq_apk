package com.tencent.mobileqq.apollo;

import akmg;
import akmh;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GLTextureView$GLThread
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private akmg jdField_a_of_type_Akmg;
  private WeakReference<GLTextureView> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<Runnable> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
  private boolean l = true;
  private boolean m;
  private boolean n = true;
  
  GLTextureView$GLThread(WeakReference<GLTextureView> paramWeakReference, String paramString)
  {
    super(str);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private boolean a()
  {
    return (!this.d) && (this.e) && (!this.f) && (this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0) && ((this.l) || (this.jdField_c_of_type_Int == 1));
  }
  
  private void h()
  {
    if (this.i)
    {
      this.i = false;
      this.jdField_a_of_type_Akmg.b();
    }
  }
  
  private void i()
  {
    if (this.h)
    {
      this.jdField_a_of_type_Akmg.c();
      this.h = false;
      GLTextureView.access$1100().b(this);
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 96	akmg
    //   4: dup
    //   5: aload_0
    //   6: getfield 77	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 116	akmg:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 94	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_Akmg	Lakmg;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 100	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 92	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	Z
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
    //   58: invokestatic 122	java/lang/System:currentTimeMillis	()J
    //   61: pop2
    //   62: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   65: astore 23
    //   67: aload 23
    //   69: monitorenter
    //   70: iload 10
    //   72: istore 11
    //   74: iload 7
    //   76: istore 10
    //   78: iload 4
    //   80: istore 14
    //   82: aload_0
    //   83: getfield 124	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_Boolean	Z
    //   86: ifeq +34 -> 120
    //   89: aload 23
    //   91: monitorexit
    //   92: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   95: astore 21
    //   97: aload 21
    //   99: monitorenter
    //   100: aload_0
    //   101: invokespecial 126	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	()V
    //   104: aload_0
    //   105: invokespecial 128	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	()V
    //   108: aload 21
    //   110: monitorexit
    //   111: return
    //   112: astore 22
    //   114: aload 21
    //   116: monitorexit
    //   117: aload 22
    //   119: athrow
    //   120: aload_0
    //   121: getfield 65	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   124: invokevirtual 130	java/util/ArrayList:isEmpty	()Z
    //   127: ifne +93 -> 220
    //   130: aload_0
    //   131: getfield 65	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   134: iconst_0
    //   135: invokevirtual 134	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   138: checkcast 136	java/lang/Runnable
    //   141: astore 21
    //   143: iload 10
    //   145: istore 7
    //   147: iload 6
    //   149: istore 12
    //   151: iload_1
    //   152: istore 4
    //   154: iload 11
    //   156: istore 10
    //   158: iload 7
    //   160: istore 6
    //   162: iload 12
    //   164: istore 7
    //   166: iload_2
    //   167: istore_1
    //   168: iload 14
    //   170: istore_2
    //   171: aload 23
    //   173: monitorexit
    //   174: aload 21
    //   176: ifnull +708 -> 884
    //   179: aload 21
    //   181: invokeinterface 139 1 0
    //   186: iload 6
    //   188: istore 11
    //   190: aconst_null
    //   191: astore 21
    //   193: iload_1
    //   194: istore 12
    //   196: iload_2
    //   197: istore 6
    //   199: iload 4
    //   201: istore_1
    //   202: iload 12
    //   204: istore_2
    //   205: iload 6
    //   207: istore 4
    //   209: iload 7
    //   211: istore 6
    //   213: iload 11
    //   215: istore 7
    //   217: goto -159 -> 58
    //   220: aload_0
    //   221: getfield 83	com/tencent/mobileqq/apollo/GLTextureView$GLThread:d	Z
    //   224: aload_0
    //   225: getfield 141	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_c_of_type_Boolean	Z
    //   228: if_icmpeq +1147 -> 1375
    //   231: aload_0
    //   232: getfield 141	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_c_of_type_Boolean	Z
    //   235: istore 19
    //   237: aload_0
    //   238: aload_0
    //   239: getfield 141	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_c_of_type_Boolean	Z
    //   242: putfield 83	com/tencent/mobileqq/apollo/GLTextureView$GLThread:d	Z
    //   245: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   248: invokevirtual 146	java/lang/Object:notifyAll	()V
    //   251: iload_3
    //   252: istore 4
    //   254: aload_0
    //   255: getfield 148	com/tencent/mobileqq/apollo/GLTextureView$GLThread:k	Z
    //   258: ifeq +19 -> 277
    //   261: aload_0
    //   262: invokespecial 126	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	()V
    //   265: aload_0
    //   266: invokespecial 128	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	()V
    //   269: aload_0
    //   270: iconst_0
    //   271: putfield 148	com/tencent/mobileqq/apollo/GLTextureView$GLThread:k	Z
    //   274: iconst_1
    //   275: istore 4
    //   277: iload 10
    //   279: istore 7
    //   281: iload 10
    //   283: ifeq +14 -> 297
    //   286: aload_0
    //   287: invokespecial 126	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	()V
    //   290: aload_0
    //   291: invokespecial 128	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	()V
    //   294: iconst_0
    //   295: istore 7
    //   297: iload 19
    //   299: ifeq +14 -> 313
    //   302: aload_0
    //   303: getfield 92	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	Z
    //   306: ifeq +7 -> 313
    //   309: aload_0
    //   310: invokespecial 126	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	()V
    //   313: iload 19
    //   315: ifeq +48 -> 363
    //   318: aload_0
    //   319: getfield 100	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	Z
    //   322: ifeq +41 -> 363
    //   325: aload_0
    //   326: getfield 77	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   329: invokevirtual 154	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   332: checkcast 46	com/tencent/mobileqq/apollo/GLTextureView
    //   335: astore 24
    //   337: aload 24
    //   339: ifnonnull +346 -> 685
    //   342: iconst_0
    //   343: istore 20
    //   345: iload 20
    //   347: ifeq +12 -> 359
    //   350: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   353: invokevirtual 156	akmh:a	()Z
    //   356: ifeq +7 -> 363
    //   359: aload_0
    //   360: invokespecial 128	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	()V
    //   363: iload 19
    //   365: ifeq +19 -> 384
    //   368: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   371: invokevirtual 158	akmh:b	()Z
    //   374: ifeq +10 -> 384
    //   377: aload_0
    //   378: getfield 94	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_Akmg	Lakmg;
    //   381: invokevirtual 102	akmg:c	()V
    //   384: aload_0
    //   385: getfield 85	com/tencent/mobileqq/apollo/GLTextureView$GLThread:e	Z
    //   388: ifne +71 -> 459
    //   391: aload_0
    //   392: getfield 160	com/tencent/mobileqq/apollo/GLTextureView$GLThread:g	Z
    //   395: ifne +64 -> 459
    //   398: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq +31 -> 432
    //   404: ldc 167
    //   406: iconst_2
    //   407: new 35	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   414: ldc 169
    //   416: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_0
    //   420: invokevirtual 172	com/tencent/mobileqq/apollo/GLTextureView$GLThread:getId	()J
    //   423: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   426: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload_0
    //   433: getfield 92	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	Z
    //   436: ifeq +7 -> 443
    //   439: aload_0
    //   440: invokespecial 126	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	()V
    //   443: aload_0
    //   444: iconst_1
    //   445: putfield 160	com/tencent/mobileqq/apollo/GLTextureView$GLThread:g	Z
    //   448: aload_0
    //   449: iconst_0
    //   450: putfield 87	com/tencent/mobileqq/apollo/GLTextureView$GLThread:f	Z
    //   453: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   456: invokevirtual 146	java/lang/Object:notifyAll	()V
    //   459: aload_0
    //   460: getfield 85	com/tencent/mobileqq/apollo/GLTextureView$GLThread:e	Z
    //   463: ifeq +21 -> 484
    //   466: aload_0
    //   467: getfield 160	com/tencent/mobileqq/apollo/GLTextureView$GLThread:g	Z
    //   470: ifeq +14 -> 484
    //   473: aload_0
    //   474: iconst_0
    //   475: putfield 160	com/tencent/mobileqq/apollo/GLTextureView$GLThread:g	Z
    //   478: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   481: invokevirtual 146	java/lang/Object:notifyAll	()V
    //   484: iload 14
    //   486: istore 12
    //   488: iload 5
    //   490: istore 13
    //   492: iload 14
    //   494: ifeq +20 -> 514
    //   497: iconst_0
    //   498: istore 13
    //   500: iconst_0
    //   501: istore 12
    //   503: aload_0
    //   504: iconst_1
    //   505: putfield 180	com/tencent/mobileqq/apollo/GLTextureView$GLThread:m	Z
    //   508: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   511: invokevirtual 146	java/lang/Object:notifyAll	()V
    //   514: iload 4
    //   516: istore_3
    //   517: iload 6
    //   519: istore 15
    //   521: iload 8
    //   523: istore 16
    //   525: iload 9
    //   527: istore 17
    //   529: iload 11
    //   531: istore 18
    //   533: aload_0
    //   534: invokespecial 181	com/tencent/mobileqq/apollo/GLTextureView$GLThread:a	()Z
    //   537: ifeq +310 -> 847
    //   540: iload 4
    //   542: istore_3
    //   543: iload 11
    //   545: istore 10
    //   547: aload_0
    //   548: getfield 100	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	Z
    //   551: ifne +14 -> 565
    //   554: iload 4
    //   556: ifeq +139 -> 695
    //   559: iconst_0
    //   560: istore_3
    //   561: iload 11
    //   563: istore 10
    //   565: aload_0
    //   566: getfield 100	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	Z
    //   569: ifeq +795 -> 1364
    //   572: aload_0
    //   573: getfield 92	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	Z
    //   576: ifne +788 -> 1364
    //   579: aload_0
    //   580: iconst_1
    //   581: putfield 92	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	Z
    //   584: iconst_1
    //   585: istore 9
    //   587: iconst_1
    //   588: istore 5
    //   590: iconst_1
    //   591: istore 4
    //   593: aload_0
    //   594: getfield 92	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	Z
    //   597: ifeq +787 -> 1384
    //   600: aload_0
    //   601: getfield 67	com/tencent/mobileqq/apollo/GLTextureView$GLThread:n	Z
    //   604: ifeq +743 -> 1347
    //   607: iconst_1
    //   608: istore_2
    //   609: aload_0
    //   610: getfield 69	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_Int	I
    //   613: istore 6
    //   615: aload_0
    //   616: getfield 71	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_b_of_type_Int	I
    //   619: istore_1
    //   620: iconst_1
    //   621: istore 8
    //   623: iconst_1
    //   624: istore 5
    //   626: aload_0
    //   627: iconst_0
    //   628: putfield 67	com/tencent/mobileqq/apollo/GLTextureView$GLThread:n	Z
    //   631: aload_0
    //   632: iconst_0
    //   633: putfield 73	com/tencent/mobileqq/apollo/GLTextureView$GLThread:l	Z
    //   636: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   639: invokevirtual 146	java/lang/Object:notifyAll	()V
    //   642: iload 4
    //   644: istore 11
    //   646: iload 12
    //   648: istore 4
    //   650: iload 6
    //   652: istore 12
    //   654: iload 7
    //   656: istore 6
    //   658: iload_2
    //   659: istore 7
    //   661: iload 5
    //   663: istore 9
    //   665: iload 4
    //   667: istore_2
    //   668: iload_1
    //   669: istore 4
    //   671: iload 12
    //   673: istore_1
    //   674: iload 8
    //   676: istore 5
    //   678: iload 11
    //   680: istore 8
    //   682: goto -511 -> 171
    //   685: aload 24
    //   687: invokestatic 185	com/tencent/mobileqq/apollo/GLTextureView:access$1200	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Z
    //   690: istore 20
    //   692: goto -347 -> 345
    //   695: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   698: aload_0
    //   699: invokevirtual 188	akmh:a	(Lcom/tencent/mobileqq/apollo/GLTextureView$GLThread;)Z
    //   702: istore 19
    //   704: iload 4
    //   706: istore_3
    //   707: iload 11
    //   709: istore 10
    //   711: iload 19
    //   713: ifeq -148 -> 565
    //   716: aload_0
    //   717: getfield 94	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_Akmg	Lakmg;
    //   720: invokevirtual 190	akmg:a	()V
    //   723: aload_0
    //   724: getfield 77	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   727: invokevirtual 154	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   730: checkcast 46	com/tencent/mobileqq/apollo/GLTextureView
    //   733: astore 24
    //   735: aload 24
    //   737: ifnull +90 -> 827
    //   740: aload 24
    //   742: invokestatic 193	com/tencent/mobileqq/apollo/GLTextureView:access$600	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Z
    //   745: istore 19
    //   747: iload 19
    //   749: ifeq +78 -> 827
    //   752: aload 23
    //   754: monitorexit
    //   755: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   758: astore 21
    //   760: aload 21
    //   762: monitorenter
    //   763: aload_0
    //   764: invokespecial 126	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	()V
    //   767: aload_0
    //   768: invokespecial 128	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	()V
    //   771: aload 21
    //   773: monitorexit
    //   774: return
    //   775: astore 22
    //   777: aload 21
    //   779: monitorexit
    //   780: aload 22
    //   782: athrow
    //   783: astore 21
    //   785: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   788: aload_0
    //   789: invokevirtual 111	akmh:b	(Lcom/tencent/mobileqq/apollo/GLTextureView$GLThread;)V
    //   792: aload 21
    //   794: athrow
    //   795: astore 21
    //   797: aload 23
    //   799: monitorexit
    //   800: aload 21
    //   802: athrow
    //   803: astore 22
    //   805: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   808: astore 21
    //   810: aload 21
    //   812: monitorenter
    //   813: aload_0
    //   814: invokespecial 126	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	()V
    //   817: aload_0
    //   818: invokespecial 128	com/tencent/mobileqq/apollo/GLTextureView$GLThread:i	()V
    //   821: aload 21
    //   823: monitorexit
    //   824: aload 22
    //   826: athrow
    //   827: aload_0
    //   828: iconst_1
    //   829: putfield 100	com/tencent/mobileqq/apollo/GLTextureView$GLThread:h	Z
    //   832: iconst_1
    //   833: istore 10
    //   835: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   838: invokevirtual 146	java/lang/Object:notifyAll	()V
    //   841: iload 4
    //   843: istore_3
    //   844: goto -279 -> 565
    //   847: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   850: invokevirtual 196	java/lang/Object:wait	()V
    //   853: iload 12
    //   855: istore 14
    //   857: iload 13
    //   859: istore 5
    //   861: iload 15
    //   863: istore 6
    //   865: iload 7
    //   867: istore 10
    //   869: iload 16
    //   871: istore 8
    //   873: iload 17
    //   875: istore 9
    //   877: iload 18
    //   879: istore 11
    //   881: goto -799 -> 82
    //   884: iload 9
    //   886: ifeq +458 -> 1344
    //   889: aload_0
    //   890: getfield 94	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_Akmg	Lakmg;
    //   893: invokevirtual 197	akmg:a	()Z
    //   896: ifeq +357 -> 1253
    //   899: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   902: astore 23
    //   904: aload 23
    //   906: monitorenter
    //   907: aload_0
    //   908: iconst_1
    //   909: putfield 199	com/tencent/mobileqq/apollo/GLTextureView$GLThread:j	Z
    //   912: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   915: invokevirtual 146	java/lang/Object:notifyAll	()V
    //   918: aload 23
    //   920: monitorexit
    //   921: iconst_0
    //   922: istore 9
    //   924: iload 8
    //   926: ifeq +415 -> 1341
    //   929: aload_0
    //   930: getfield 94	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_Akmg	Lakmg;
    //   933: invokevirtual 202	akmg:a	()Ljavax/microedition/khronos/opengles/GL;
    //   936: checkcast 204	javax/microedition/khronos/opengles/GL10
    //   939: astore 22
    //   941: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   944: aload 22
    //   946: invokevirtual 207	akmh:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   949: iconst_0
    //   950: istore 8
    //   952: iload 10
    //   954: istore 11
    //   956: iload 10
    //   958: ifeq +42 -> 1000
    //   961: aload_0
    //   962: getfield 77	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   965: invokevirtual 154	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   968: checkcast 46	com/tencent/mobileqq/apollo/GLTextureView
    //   971: astore 23
    //   973: aload 23
    //   975: ifnull +428 -> 1403
    //   978: aload 23
    //   980: invokestatic 211	com/tencent/mobileqq/apollo/GLTextureView:access$1300	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   983: aload 22
    //   985: aload_0
    //   986: getfield 94	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_Akmg	Lakmg;
    //   989: getfield 214	akmg:a	Ljavax/microedition/khronos/egl/EGLConfig;
    //   992: invokeinterface 220 3 0
    //   997: goto +406 -> 1403
    //   1000: iload 7
    //   1002: istore 10
    //   1004: iload 7
    //   1006: ifeq +52 -> 1058
    //   1009: aload_0
    //   1010: getfield 77	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1013: invokevirtual 154	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1016: checkcast 46	com/tencent/mobileqq/apollo/GLTextureView
    //   1019: astore 23
    //   1021: aload 23
    //   1023: ifnull +386 -> 1409
    //   1026: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1029: ifeq +11 -> 1040
    //   1032: ldc 167
    //   1034: iconst_2
    //   1035: ldc 222
    //   1037: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1040: aload 23
    //   1042: invokestatic 211	com/tencent/mobileqq/apollo/GLTextureView:access$1300	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   1045: aload 22
    //   1047: iload_1
    //   1048: iload 4
    //   1050: invokeinterface 226 4 0
    //   1055: goto +354 -> 1409
    //   1058: invokestatic 122	java/lang/System:currentTimeMillis	()J
    //   1061: pop2
    //   1062: aload_0
    //   1063: getfield 77	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1066: invokevirtual 154	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1069: checkcast 46	com/tencent/mobileqq/apollo/GLTextureView
    //   1072: astore 23
    //   1074: aload 23
    //   1076: ifnull +49 -> 1125
    //   1079: aload 23
    //   1081: invokestatic 211	com/tencent/mobileqq/apollo/GLTextureView:access$1300	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   1084: aload 22
    //   1086: invokeinterface 229 2 0
    //   1091: aload 23
    //   1093: invokestatic 232	com/tencent/mobileqq/apollo/GLTextureView:access$1400	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Z
    //   1096: ifne +29 -> 1125
    //   1099: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1102: ifeq +11 -> 1113
    //   1105: ldc 167
    //   1107: iconst_2
    //   1108: ldc 234
    //   1110: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1113: aload 23
    //   1115: iconst_1
    //   1116: invokestatic 238	com/tencent/mobileqq/apollo/GLTextureView:access$1402	(Lcom/tencent/mobileqq/apollo/GLTextureView;Z)Z
    //   1119: pop
    //   1120: aload 23
    //   1122: invokevirtual 241	com/tencent/mobileqq/apollo/GLTextureView:checkSetAlpha	()V
    //   1125: invokestatic 122	java/lang/System:currentTimeMillis	()J
    //   1128: pop2
    //   1129: aload_0
    //   1130: getfield 94	com/tencent/mobileqq/apollo/GLTextureView$GLThread:jdField_a_of_type_Akmg	Lakmg;
    //   1133: invokevirtual 243	akmg:a	()I
    //   1136: istore 12
    //   1138: invokestatic 122	java/lang/System:currentTimeMillis	()J
    //   1141: pop2
    //   1142: iload 6
    //   1144: istore 7
    //   1146: iload 12
    //   1148: lookupswitch	default:+267->1415, 12288:+63->1211, 12302:+171->1319
    //   1177: <illegal opcode>
    //   1178: ldc 247
    //   1180: iload 12
    //   1182: invokestatic 250	akmg:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1185: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   1188: astore 23
    //   1190: aload 23
    //   1192: monitorenter
    //   1193: aload_0
    //   1194: iconst_1
    //   1195: putfield 87	com/tencent/mobileqq/apollo/GLTextureView$GLThread:f	Z
    //   1198: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   1201: invokevirtual 146	java/lang/Object:notifyAll	()V
    //   1204: aload 23
    //   1206: monitorexit
    //   1207: iload 6
    //   1209: istore 7
    //   1211: iload 5
    //   1213: ifeq +168 -> 1381
    //   1216: iconst_1
    //   1217: istore_2
    //   1218: iload_1
    //   1219: istore 12
    //   1221: iload_2
    //   1222: istore 6
    //   1224: iload 4
    //   1226: istore_1
    //   1227: iload 12
    //   1229: istore_2
    //   1230: iload 6
    //   1232: istore 4
    //   1234: iload 10
    //   1236: istore 6
    //   1238: iload 11
    //   1240: istore 10
    //   1242: goto -1184 -> 58
    //   1245: astore 21
    //   1247: aload 23
    //   1249: monitorexit
    //   1250: aload 21
    //   1252: athrow
    //   1253: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   1256: astore 23
    //   1258: aload 23
    //   1260: monitorenter
    //   1261: aload_0
    //   1262: iconst_1
    //   1263: putfield 199	com/tencent/mobileqq/apollo/GLTextureView$GLThread:j	Z
    //   1266: aload_0
    //   1267: iconst_1
    //   1268: putfield 87	com/tencent/mobileqq/apollo/GLTextureView$GLThread:f	Z
    //   1271: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   1274: invokevirtual 146	java/lang/Object:notifyAll	()V
    //   1277: aload 23
    //   1279: monitorexit
    //   1280: iload 6
    //   1282: istore 11
    //   1284: iload_1
    //   1285: istore 12
    //   1287: iload_2
    //   1288: istore 6
    //   1290: iload 4
    //   1292: istore_1
    //   1293: iload 12
    //   1295: istore_2
    //   1296: iload 6
    //   1298: istore 4
    //   1300: iload 7
    //   1302: istore 6
    //   1304: iload 11
    //   1306: istore 7
    //   1308: goto -1250 -> 58
    //   1311: astore 21
    //   1313: aload 23
    //   1315: monitorexit
    //   1316: aload 21
    //   1318: athrow
    //   1319: iconst_1
    //   1320: istore 7
    //   1322: goto -111 -> 1211
    //   1325: astore 21
    //   1327: aload 23
    //   1329: monitorexit
    //   1330: aload 21
    //   1332: athrow
    //   1333: astore 22
    //   1335: aload 21
    //   1337: monitorexit
    //   1338: aload 22
    //   1340: athrow
    //   1341: goto -389 -> 952
    //   1344: goto -420 -> 924
    //   1347: iload 13
    //   1349: istore 8
    //   1351: iload_2
    //   1352: istore 6
    //   1354: iload 5
    //   1356: istore_2
    //   1357: iload 9
    //   1359: istore 5
    //   1361: goto -730 -> 631
    //   1364: iload 6
    //   1366: istore 5
    //   1368: iload 8
    //   1370: istore 4
    //   1372: goto -779 -> 593
    //   1375: iconst_0
    //   1376: istore 19
    //   1378: goto -1127 -> 251
    //   1381: goto -163 -> 1218
    //   1384: iload 5
    //   1386: istore 15
    //   1388: iload 4
    //   1390: istore 16
    //   1392: iload 9
    //   1394: istore 17
    //   1396: iload 10
    //   1398: istore 18
    //   1400: goto -553 -> 847
    //   1403: iconst_0
    //   1404: istore 11
    //   1406: goto -406 -> 1000
    //   1409: iconst_0
    //   1410: istore 10
    //   1412: goto -354 -> 1058
    //   1415: goto -239 -> 1176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1418	0	this	GLThread
    //   32	1261	1	i1	int
    //   54	1303	2	i2	int
    //   34	810	3	i3	int
    //   56	1333	4	i4	int
    //   36	1349	5	i5	int
    //   39	1326	6	i6	int
    //   42	1279	7	i7	int
    //   45	1324	8	i8	int
    //   48	1345	9	i9	int
    //   26	1385	10	i10	int
    //   72	1333	11	i11	int
    //   149	1145	12	i12	int
    //   490	858	13	i13	int
    //   80	776	14	i14	int
    //   519	868	15	i15	int
    //   523	868	16	i16	int
    //   527	868	17	i17	int
    //   531	868	18	i18	int
    //   235	1142	19	bool1	boolean
    //   343	348	20	bool2	boolean
    //   51	727	21	localObject1	Object
    //   783	10	21	localRuntimeException	java.lang.RuntimeException
    //   795	6	21	localObject2	Object
    //   808	14	21	localakmh	akmh
    //   1245	6	21	localObject3	Object
    //   1311	6	21	localObject4	Object
    //   1325	11	21	localObject5	Object
    //   29	1	22	localObject6	Object
    //   112	6	22	localObject7	Object
    //   775	6	22	localObject8	Object
    //   803	22	22	localObject9	Object
    //   939	146	22	localGL10	javax.microedition.khronos.opengles.GL10
    //   1333	6	22	localObject10	Object
    //   335	406	24	localGLTextureView	GLTextureView
    // Exception table:
    //   from	to	target	type
    //   100	111	112	finally
    //   114	117	112	finally
    //   763	774	775	finally
    //   777	780	775	finally
    //   716	735	783	java/lang/RuntimeException
    //   740	747	783	java/lang/RuntimeException
    //   82	92	795	finally
    //   120	143	795	finally
    //   171	174	795	finally
    //   220	251	795	finally
    //   254	274	795	finally
    //   286	294	795	finally
    //   302	313	795	finally
    //   318	337	795	finally
    //   350	359	795	finally
    //   359	363	795	finally
    //   368	384	795	finally
    //   384	432	795	finally
    //   432	443	795	finally
    //   443	459	795	finally
    //   459	484	795	finally
    //   503	514	795	finally
    //   533	540	795	finally
    //   547	554	795	finally
    //   565	584	795	finally
    //   593	607	795	finally
    //   609	620	795	finally
    //   626	631	795	finally
    //   631	642	795	finally
    //   685	692	795	finally
    //   695	704	795	finally
    //   716	735	795	finally
    //   740	747	795	finally
    //   752	755	795	finally
    //   785	795	795	finally
    //   797	800	795	finally
    //   827	832	795	finally
    //   835	841	795	finally
    //   847	853	795	finally
    //   58	70	803	finally
    //   179	186	803	finally
    //   800	803	803	finally
    //   889	907	803	finally
    //   929	949	803	finally
    //   961	973	803	finally
    //   978	997	803	finally
    //   1009	1021	803	finally
    //   1026	1040	803	finally
    //   1040	1055	803	finally
    //   1058	1074	803	finally
    //   1079	1113	803	finally
    //   1113	1125	803	finally
    //   1125	1142	803	finally
    //   1176	1193	803	finally
    //   1250	1253	803	finally
    //   1253	1261	803	finally
    //   1316	1319	803	finally
    //   1330	1333	803	finally
    //   907	921	1245	finally
    //   1247	1250	1245	finally
    //   1261	1280	1311	finally
    //   1313	1316	1311	finally
    //   1193	1207	1325	finally
    //   1327	1330	1325	finally
    //   813	824	1333	finally
    //   1335	1338	1333	finally
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
      this.l = true;
      GLTextureView.access$1100().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1)) {
      throw new IllegalArgumentException("renderMode");
    }
    synchronized (GLTextureView.access$1100())
    {
      this.jdField_c_of_type_Int = paramInt;
      GLTextureView.access$1100().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized ()
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.n = true;
      this.l = true;
      this.m = false;
      GLTextureView.access$1100().notifyAll();
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException("r must not be null");
    }
    synchronized (GLTextureView.access$1100())
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramRunnable);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramRunnable);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 100) {
        QLog.e("GLTextureView", 1, new Object[] { "GLThread runable queueList size is > 100, last r:", paramRunnable });
      }
      GLTextureView.access$1100().notifyAll();
      return;
    }
  }
  
  public void b()
  {
    synchronized ()
    {
      this.e = true;
      this.j = false;
      GLTextureView.access$1100().notifyAll();
      return;
    }
  }
  
  public void c()
  {
    synchronized ()
    {
      this.e = false;
      GLTextureView.access$1100().notifyAll();
      return;
    }
  }
  
  public void d()
  {
    synchronized ()
    {
      this.jdField_c_of_type_Boolean = true;
      GLTextureView.access$1100().notifyAll();
      for (;;)
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          boolean bool = this.d;
          if (!bool) {
            try
            {
              GLTextureView.access$1100().wait();
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
  
  public void e()
  {
    synchronized ()
    {
      this.jdField_c_of_type_Boolean = false;
      this.l = true;
      this.m = false;
      GLTextureView.access$1100().notifyAll();
      for (;;)
      {
        if ((!this.jdField_b_of_type_Boolean) && (this.d))
        {
          boolean bool = this.m;
          if (!bool) {
            try
            {
              GLTextureView.access$1100().wait();
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
  
  public void f()
  {
    synchronized ()
    {
      this.jdField_a_of_type_Boolean = true;
      GLTextureView.access$1100().notifyAll();
      return;
    }
  }
  
  public void g()
  {
    this.k = true;
    GLTextureView.access$1100().notifyAll();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 285	com/tencent/mobileqq/apollo/GLTextureView$GLThread:j	()V
    //   4: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   7: aload_0
    //   8: invokevirtual 287	akmh:a	(Lcom/tencent/mobileqq/apollo/GLTextureView$GLThread;)V
    //   11: return
    //   12: astore_1
    //   13: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   16: aload_0
    //   17: invokevirtual 287	akmh:a	(Lcom/tencent/mobileqq/apollo/GLTextureView$GLThread;)V
    //   20: return
    //   21: astore_1
    //   22: invokestatic 106	com/tencent/mobileqq/apollo/GLTextureView:access$1100	()Lakmh;
    //   25: aload_0
    //   26: invokevirtual 287	akmh:a	(Lcom/tencent/mobileqq/apollo/GLTextureView$GLThread;)V
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	GLThread
    //   12	1	1	localInterruptedException	InterruptedException
    //   21	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	12	java/lang/InterruptedException
    //   0	4	21	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.GLTextureView.GLThread
 * JD-Core Version:    0.7.0.1
 */