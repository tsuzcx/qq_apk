package com.tencent.map.sdk.a;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class pv$i
  extends Thread
{
  boolean a;
  boolean b;
  boolean c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  boolean h;
  boolean i;
  int j = 0;
  int k = 0;
  boolean l = true;
  boolean m;
  boolean n = true;
  private boolean o;
  private boolean p;
  private int q = 1;
  private ArrayList<Runnable> r = new ArrayList();
  private pv.h s;
  private WeakReference<pv> t;
  
  pv$i(WeakReference<pv> paramWeakReference)
  {
    this.t = paramWeakReference;
  }
  
  private void d()
  {
    if (this.g)
    {
      this.g = false;
      this.s.a();
    }
  }
  
  private void e()
  {
    if (this.f)
    {
      this.s.b();
      this.f = false;
      pv.a().c(this);
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 65	com/tencent/map/sdk/a/pv$h
    //   4: dup
    //   5: aload_0
    //   6: getfield 53	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 87	com/tencent/map/sdk/a/pv$h:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 63	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 69	com/tencent/map/sdk/a/pv$i:f	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 61	com/tencent/map/sdk/a/pv$i:g	Z
    //   25: iconst_0
    //   26: istore_3
    //   27: iconst_0
    //   28: istore 7
    //   30: iconst_0
    //   31: istore 6
    //   33: iconst_0
    //   34: istore 5
    //   36: aconst_null
    //   37: astore 19
    //   39: iconst_0
    //   40: istore_2
    //   41: aconst_null
    //   42: astore 18
    //   44: iconst_0
    //   45: istore 4
    //   47: iconst_0
    //   48: istore_1
    //   49: iconst_0
    //   50: istore 9
    //   52: iconst_0
    //   53: istore 11
    //   55: iconst_0
    //   56: istore 10
    //   58: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   61: astore 21
    //   63: aload 21
    //   65: monitorenter
    //   66: iload 9
    //   68: istore 12
    //   70: iload_1
    //   71: istore 8
    //   73: iload_2
    //   74: istore 9
    //   76: aload_0
    //   77: getfield 89	com/tencent/map/sdk/a/pv$i:o	Z
    //   80: ifeq +57 -> 137
    //   83: aload_0
    //   84: getfield 53	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
    //   87: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   90: checkcast 73	com/tencent/map/sdk/a/pv
    //   93: astore 18
    //   95: aload 18
    //   97: ifnull +9 -> 106
    //   100: aload 18
    //   102: invokestatic 98	com/tencent/map/sdk/a/pv:g	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$m;
    //   105: pop
    //   106: aload 21
    //   108: monitorexit
    //   109: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   112: astore 18
    //   114: aload 18
    //   116: monitorenter
    //   117: aload_0
    //   118: invokespecial 100	com/tencent/map/sdk/a/pv$i:d	()V
    //   121: aload_0
    //   122: invokespecial 102	com/tencent/map/sdk/a/pv$i:e	()V
    //   125: aload 18
    //   127: monitorexit
    //   128: return
    //   129: astore 19
    //   131: aload 18
    //   133: monitorexit
    //   134: aload 19
    //   136: athrow
    //   137: aload_0
    //   138: getfield 41	com/tencent/map/sdk/a/pv$i:r	Ljava/util/ArrayList;
    //   141: invokevirtual 106	java/util/ArrayList:isEmpty	()Z
    //   144: ifne +37 -> 181
    //   147: aload_0
    //   148: getfield 41	com/tencent/map/sdk/a/pv$i:r	Ljava/util/ArrayList;
    //   151: iconst_0
    //   152: invokevirtual 110	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   155: checkcast 112	java/lang/Runnable
    //   158: astore 20
    //   160: iload 9
    //   162: istore_2
    //   163: iload 8
    //   165: istore_1
    //   166: iload 12
    //   168: istore 9
    //   170: iload 11
    //   172: istore 15
    //   174: iload 10
    //   176: istore 14
    //   178: goto +683 -> 861
    //   181: aload_0
    //   182: getfield 114	com/tencent/map/sdk/a/pv$i:c	Z
    //   185: aload_0
    //   186: getfield 116	com/tencent/map/sdk/a/pv$i:b	Z
    //   189: if_icmpeq +1597 -> 1786
    //   192: aload_0
    //   193: getfield 116	com/tencent/map/sdk/a/pv$i:b	Z
    //   196: istore 16
    //   198: aload_0
    //   199: aload_0
    //   200: getfield 116	com/tencent/map/sdk/a/pv$i:b	Z
    //   203: putfield 114	com/tencent/map/sdk/a/pv$i:c	Z
    //   206: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   209: invokevirtual 121	java/lang/Object:notifyAll	()V
    //   212: goto +3 -> 215
    //   215: aload_0
    //   216: getfield 123	com/tencent/map/sdk/a/pv$i:i	Z
    //   219: ifeq +19 -> 238
    //   222: aload_0
    //   223: invokespecial 100	com/tencent/map/sdk/a/pv$i:d	()V
    //   226: aload_0
    //   227: invokespecial 102	com/tencent/map/sdk/a/pv$i:e	()V
    //   230: aload_0
    //   231: iconst_0
    //   232: putfield 123	com/tencent/map/sdk/a/pv$i:i	Z
    //   235: iconst_1
    //   236: istore 6
    //   238: iload_3
    //   239: istore_1
    //   240: iload_3
    //   241: ifeq +13 -> 254
    //   244: aload_0
    //   245: invokespecial 100	com/tencent/map/sdk/a/pv$i:d	()V
    //   248: aload_0
    //   249: invokespecial 102	com/tencent/map/sdk/a/pv$i:e	()V
    //   252: iconst_0
    //   253: istore_1
    //   254: iload 16
    //   256: ifeq +14 -> 270
    //   259: aload_0
    //   260: getfield 61	com/tencent/map/sdk/a/pv$i:g	Z
    //   263: ifeq +7 -> 270
    //   266: aload_0
    //   267: invokespecial 100	com/tencent/map/sdk/a/pv$i:d	()V
    //   270: iload 16
    //   272: ifeq +58 -> 330
    //   275: aload_0
    //   276: getfield 69	com/tencent/map/sdk/a/pv$i:f	Z
    //   279: ifeq +51 -> 330
    //   282: aload_0
    //   283: getfield 53	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
    //   286: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   289: checkcast 73	com/tencent/map/sdk/a/pv
    //   292: astore 20
    //   294: aload 20
    //   296: ifnonnull +9 -> 305
    //   299: iconst_0
    //   300: istore 17
    //   302: goto +10 -> 312
    //   305: aload 20
    //   307: invokestatic 126	com/tencent/map/sdk/a/pv:h	(Lcom/tencent/map/sdk/a/pv;)Z
    //   310: istore 17
    //   312: iload 17
    //   314: ifeq +12 -> 326
    //   317: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   320: invokevirtual 128	com/tencent/map/sdk/a/pv$j:a	()Z
    //   323: ifeq +7 -> 330
    //   326: aload_0
    //   327: invokespecial 102	com/tencent/map/sdk/a/pv$i:e	()V
    //   330: iload 16
    //   332: ifeq +19 -> 351
    //   335: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   338: invokevirtual 130	com/tencent/map/sdk/a/pv$j:b	()Z
    //   341: ifeq +10 -> 351
    //   344: aload_0
    //   345: getfield 63	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
    //   348: invokevirtual 71	com/tencent/map/sdk/a/pv$h:b	()V
    //   351: aload_0
    //   352: getfield 132	com/tencent/map/sdk/a/pv$i:d	Z
    //   355: ifne +37 -> 392
    //   358: aload_0
    //   359: getfield 134	com/tencent/map/sdk/a/pv$i:e	Z
    //   362: ifne +30 -> 392
    //   365: aload_0
    //   366: getfield 61	com/tencent/map/sdk/a/pv$i:g	Z
    //   369: ifeq +7 -> 376
    //   372: aload_0
    //   373: invokespecial 100	com/tencent/map/sdk/a/pv$i:d	()V
    //   376: aload_0
    //   377: iconst_1
    //   378: putfield 134	com/tencent/map/sdk/a/pv$i:e	Z
    //   381: aload_0
    //   382: iconst_0
    //   383: putfield 136	com/tencent/map/sdk/a/pv$i:p	Z
    //   386: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   389: invokevirtual 121	java/lang/Object:notifyAll	()V
    //   392: aload_0
    //   393: getfield 132	com/tencent/map/sdk/a/pv$i:d	Z
    //   396: ifeq +21 -> 417
    //   399: aload_0
    //   400: getfield 134	com/tencent/map/sdk/a/pv$i:e	Z
    //   403: ifeq +14 -> 417
    //   406: aload_0
    //   407: iconst_0
    //   408: putfield 134	com/tencent/map/sdk/a/pv$i:e	Z
    //   411: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   414: invokevirtual 121	java/lang/Object:notifyAll	()V
    //   417: iload 7
    //   419: istore_2
    //   420: iload 7
    //   422: ifeq +19 -> 441
    //   425: aload_0
    //   426: iconst_1
    //   427: putfield 138	com/tencent/map/sdk/a/pv$i:m	Z
    //   430: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   433: invokevirtual 121	java/lang/Object:notifyAll	()V
    //   436: iconst_0
    //   437: istore_2
    //   438: iconst_0
    //   439: istore 12
    //   441: aload_0
    //   442: invokevirtual 139	com/tencent/map/sdk/a/pv$i:a	()Z
    //   445: ifeq +1228 -> 1673
    //   448: aload_0
    //   449: getfield 69	com/tencent/map/sdk/a/pv$i:f	Z
    //   452: ifne +1343 -> 1795
    //   455: iload 6
    //   457: ifeq +12 -> 469
    //   460: iconst_0
    //   461: istore 6
    //   463: iload 9
    //   465: istore_3
    //   466: goto +284 -> 750
    //   469: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   472: aload_0
    //   473: invokevirtual 141	com/tencent/map/sdk/a/pv$j:b	(Lcom/tencent/map/sdk/a/pv$i;)Z
    //   476: istore 16
    //   478: iload 16
    //   480: ifeq +1315 -> 1795
    //   483: aload_0
    //   484: getfield 63	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
    //   487: astore 20
    //   489: aload 20
    //   491: invokestatic 147	javax/microedition/khronos/egl/EGLContext:getEGL	()Ljavax/microedition/khronos/egl/EGL;
    //   494: checkcast 149	javax/microedition/khronos/egl/EGL10
    //   497: putfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   500: aload 20
    //   502: aload 20
    //   504: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   507: getstatic 156	javax/microedition/khronos/egl/EGL10:EGL_DEFAULT_DISPLAY	Ljava/lang/Object;
    //   510: invokeinterface 160 2 0
    //   515: putfield 163	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   518: aload 20
    //   520: getfield 163	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   523: getstatic 166	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   526: if_acmpeq +191 -> 717
    //   529: iconst_2
    //   530: newarray int
    //   532: astore 22
    //   534: aload 20
    //   536: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   539: astore 23
    //   541: aload 23
    //   543: aload 20
    //   545: getfield 163	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   548: aload 22
    //   550: invokeinterface 170 3 0
    //   555: ifeq +152 -> 707
    //   558: aload 20
    //   560: getfield 172	com/tencent/map/sdk/a/pv$h:a	Ljava/lang/ref/WeakReference;
    //   563: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   566: checkcast 73	com/tencent/map/sdk/a/pv
    //   569: astore 22
    //   571: aload 22
    //   573: ifnonnull +18 -> 591
    //   576: aload 20
    //   578: aconst_null
    //   579: putfield 175	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
    //   582: aload 20
    //   584: aconst_null
    //   585: putfield 178	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
    //   588: goto +66 -> 654
    //   591: aload 22
    //   593: invokestatic 181	com/tencent/map/sdk/a/pv:b	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$e;
    //   596: astore 23
    //   598: aload 20
    //   600: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   603: astore 24
    //   605: aload 20
    //   607: aload 23
    //   609: aload 24
    //   611: aload 20
    //   613: getfield 163	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   616: invokeinterface 186 3 0
    //   621: putfield 175	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
    //   624: aload 20
    //   626: aload 22
    //   628: invokestatic 189	com/tencent/map/sdk/a/pv:c	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$f;
    //   631: aload 20
    //   633: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   636: aload 20
    //   638: getfield 163	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   641: aload 20
    //   643: getfield 175	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
    //   646: invokeinterface 194 4 0
    //   651: putfield 178	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
    //   654: aload 20
    //   656: getfield 178	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
    //   659: ifnull +17 -> 676
    //   662: aload 20
    //   664: getfield 178	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
    //   667: getstatic 197	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   670: if_acmpne +1122 -> 1792
    //   673: goto +3 -> 676
    //   676: aload 20
    //   678: aconst_null
    //   679: putfield 178	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
    //   682: aload 20
    //   684: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   687: invokeinterface 201 1 0
    //   692: pop
    //   693: ldc 203
    //   695: invokestatic 206	com/tencent/map/sdk/a/pv$h:a	(Ljava/lang/String;)V
    //   698: aload 20
    //   700: aconst_null
    //   701: putfield 209	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
    //   704: goto +30 -> 734
    //   707: new 85	java/lang/RuntimeException
    //   710: dup
    //   711: ldc 211
    //   713: invokespecial 213	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   716: athrow
    //   717: new 85	java/lang/RuntimeException
    //   720: dup
    //   721: ldc 215
    //   723: invokespecial 213	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   726: athrow
    //   727: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   730: aload_0
    //   731: invokevirtual 81	com/tencent/map/sdk/a/pv$j:c	(Lcom/tencent/map/sdk/a/pv$i;)V
    //   734: aload_0
    //   735: iconst_1
    //   736: putfield 69	com/tencent/map/sdk/a/pv$i:f	Z
    //   739: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   742: invokevirtual 121	java/lang/Object:notifyAll	()V
    //   745: iconst_1
    //   746: istore_3
    //   747: goto +3 -> 750
    //   750: aload_0
    //   751: getfield 69	com/tencent/map/sdk/a/pv$i:f	Z
    //   754: ifeq +1047 -> 1801
    //   757: aload_0
    //   758: getfield 61	com/tencent/map/sdk/a/pv$i:g	Z
    //   761: ifne +1040 -> 1801
    //   764: aload_0
    //   765: iconst_1
    //   766: putfield 61	com/tencent/map/sdk/a/pv$i:g	Z
    //   769: iconst_1
    //   770: istore 5
    //   772: iconst_1
    //   773: istore 4
    //   775: iconst_1
    //   776: istore 8
    //   778: goto +3 -> 781
    //   781: aload_0
    //   782: getfield 61	com/tencent/map/sdk/a/pv$i:g	Z
    //   785: ifeq +882 -> 1667
    //   788: aload_0
    //   789: getfield 43	com/tencent/map/sdk/a/pv$i:n	Z
    //   792: ifeq +1012 -> 1804
    //   795: aload_0
    //   796: getfield 45	com/tencent/map/sdk/a/pv$i:j	I
    //   799: istore 11
    //   801: aload_0
    //   802: getfield 47	com/tencent/map/sdk/a/pv$i:k	I
    //   805: istore 10
    //   807: aload_0
    //   808: iconst_0
    //   809: putfield 43	com/tencent/map/sdk/a/pv$i:n	Z
    //   812: iconst_1
    //   813: istore 5
    //   815: iconst_1
    //   816: istore 8
    //   818: iconst_1
    //   819: istore 9
    //   821: goto +3 -> 824
    //   824: aload_0
    //   825: iconst_0
    //   826: putfield 49	com/tencent/map/sdk/a/pv$i:l	Z
    //   829: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   832: invokevirtual 121	java/lang/Object:notifyAll	()V
    //   835: iload_1
    //   836: istore 12
    //   838: iload_2
    //   839: istore 7
    //   841: iload 10
    //   843: istore 14
    //   845: iload 11
    //   847: istore 15
    //   849: iload 8
    //   851: istore_1
    //   852: iload_3
    //   853: istore_2
    //   854: aload 19
    //   856: astore 20
    //   858: iload 12
    //   860: istore_3
    //   861: aload 21
    //   863: monitorexit
    //   864: aload 20
    //   866: ifnull +24 -> 890
    //   869: aload 20
    //   871: invokeinterface 218 1 0
    //   876: aconst_null
    //   877: astore 19
    //   879: iload 15
    //   881: istore 11
    //   883: iload 14
    //   885: istore 10
    //   887: goto -829 -> 58
    //   890: iload 5
    //   892: ifeq +955 -> 1847
    //   895: aload_0
    //   896: getfield 63	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
    //   899: astore 19
    //   901: aload 19
    //   903: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   906: ifnull +310 -> 1216
    //   909: aload 19
    //   911: getfield 163	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   914: ifnull +291 -> 1205
    //   917: aload 19
    //   919: getfield 175	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
    //   922: ifnull +272 -> 1194
    //   925: aload 19
    //   927: invokevirtual 67	com/tencent/map/sdk/a/pv$h:a	()V
    //   930: aload 19
    //   932: getfield 172	com/tencent/map/sdk/a/pv$h:a	Ljava/lang/ref/WeakReference;
    //   935: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   938: checkcast 73	com/tencent/map/sdk/a/pv
    //   941: astore 21
    //   943: aload 21
    //   945: ifnull +41 -> 986
    //   948: aload 19
    //   950: aload 21
    //   952: invokestatic 221	com/tencent/map/sdk/a/pv:d	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$g;
    //   955: aload 19
    //   957: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   960: aload 19
    //   962: getfield 163	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   965: aload 19
    //   967: getfield 175	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
    //   970: aload 21
    //   972: invokevirtual 225	com/tencent/map/sdk/a/pv:getHolder	()Landroid/view/SurfaceHolder;
    //   975: invokeinterface 230 5 0
    //   980: putfield 209	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
    //   983: goto +9 -> 992
    //   986: aload 19
    //   988: aconst_null
    //   989: putfield 209	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
    //   992: aload 19
    //   994: getfield 209	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
    //   997: ifnull +71 -> 1068
    //   1000: aload 19
    //   1002: getfield 209	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1005: getstatic 233	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1008: if_acmpne +6 -> 1014
    //   1011: goto +57 -> 1068
    //   1014: aload 19
    //   1016: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   1019: aload 19
    //   1021: getfield 163	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1024: aload 19
    //   1026: getfield 209	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1029: aload 19
    //   1031: getfield 209	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1034: aload 19
    //   1036: getfield 178	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
    //   1039: invokeinterface 237 5 0
    //   1044: ifne +767 -> 1811
    //   1047: aload 19
    //   1049: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   1052: invokeinterface 201 1 0
    //   1057: pop
    //   1058: ldc 239
    //   1060: ldc 240
    //   1062: invokestatic 243	com/tencent/map/sdk/a/pv$h:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1065: goto +752 -> 1817
    //   1068: aload 19
    //   1070: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   1073: invokeinterface 201 1 0
    //   1078: sipush 12299
    //   1081: if_icmpne +736 -> 1817
    //   1084: ldc 245
    //   1086: ldc 247
    //   1088: invokestatic 252	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1091: pop
    //   1092: goto +725 -> 1817
    //   1095: iload 8
    //   1097: ifeq +39 -> 1136
    //   1100: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   1103: astore 19
    //   1105: aload 19
    //   1107: monitorenter
    //   1108: aload_0
    //   1109: iconst_1
    //   1110: putfield 254	com/tencent/map/sdk/a/pv$i:h	Z
    //   1113: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   1116: invokevirtual 121	java/lang/Object:notifyAll	()V
    //   1119: aload 19
    //   1121: monitorexit
    //   1122: iconst_0
    //   1123: istore 5
    //   1125: goto +102 -> 1227
    //   1128: astore 18
    //   1130: aload 19
    //   1132: monitorexit
    //   1133: aload 18
    //   1135: athrow
    //   1136: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   1139: astore 19
    //   1141: aload 19
    //   1143: monitorenter
    //   1144: aload_0
    //   1145: iconst_1
    //   1146: putfield 254	com/tencent/map/sdk/a/pv$i:h	Z
    //   1149: aload_0
    //   1150: iconst_1
    //   1151: putfield 136	com/tencent/map/sdk/a/pv$i:p	Z
    //   1154: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   1157: invokevirtual 121	java/lang/Object:notifyAll	()V
    //   1160: aload 19
    //   1162: monitorexit
    //   1163: iload_3
    //   1164: istore 13
    //   1166: iload 5
    //   1168: istore_3
    //   1169: iload_2
    //   1170: istore 10
    //   1172: aload 18
    //   1174: astore 19
    //   1176: iload 4
    //   1178: istore 11
    //   1180: iload_1
    //   1181: istore 12
    //   1183: goto +640 -> 1823
    //   1186: astore 18
    //   1188: aload 19
    //   1190: monitorexit
    //   1191: aload 18
    //   1193: athrow
    //   1194: new 85	java/lang/RuntimeException
    //   1197: dup
    //   1198: ldc_w 256
    //   1201: invokespecial 213	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1204: athrow
    //   1205: new 85	java/lang/RuntimeException
    //   1208: dup
    //   1209: ldc_w 258
    //   1212: invokespecial 213	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1215: athrow
    //   1216: new 85	java/lang/RuntimeException
    //   1219: dup
    //   1220: ldc_w 260
    //   1223: invokespecial 213	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1226: athrow
    //   1227: iload 4
    //   1229: istore 8
    //   1231: iload 4
    //   1233: ifeq +142 -> 1375
    //   1236: aload_0
    //   1237: getfield 63	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
    //   1240: astore 19
    //   1242: aload 19
    //   1244: getfield 178	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
    //   1247: invokevirtual 264	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
    //   1250: astore 18
    //   1252: aload 19
    //   1254: getfield 172	com/tencent/map/sdk/a/pv$h:a	Ljava/lang/ref/WeakReference;
    //   1257: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1260: checkcast 73	com/tencent/map/sdk/a/pv
    //   1263: astore 21
    //   1265: aload 18
    //   1267: astore 19
    //   1269: aload 21
    //   1271: ifnull +86 -> 1357
    //   1274: aload 21
    //   1276: invokestatic 267	com/tencent/map/sdk/a/pv:e	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$k;
    //   1279: ifnull +15 -> 1294
    //   1282: aload 21
    //   1284: invokestatic 267	com/tencent/map/sdk/a/pv:e	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$k;
    //   1287: invokeinterface 271 1 0
    //   1292: astore 18
    //   1294: aload 18
    //   1296: astore 19
    //   1298: aload 21
    //   1300: invokestatic 274	com/tencent/map/sdk/a/pv:f	(Lcom/tencent/map/sdk/a/pv;)I
    //   1303: iconst_3
    //   1304: iand
    //   1305: ifeq +52 -> 1357
    //   1308: aload 21
    //   1310: invokestatic 274	com/tencent/map/sdk/a/pv:f	(Lcom/tencent/map/sdk/a/pv;)I
    //   1313: iconst_1
    //   1314: iand
    //   1315: ifeq +535 -> 1850
    //   1318: iconst_1
    //   1319: istore 4
    //   1321: goto +3 -> 1324
    //   1324: aload 21
    //   1326: invokestatic 274	com/tencent/map/sdk/a/pv:f	(Lcom/tencent/map/sdk/a/pv;)I
    //   1329: iconst_2
    //   1330: iand
    //   1331: ifeq +525 -> 1856
    //   1334: new 276	com/tencent/map/sdk/a/pv$l
    //   1337: dup
    //   1338: invokespecial 277	com/tencent/map/sdk/a/pv$l:<init>	()V
    //   1341: astore 19
    //   1343: goto +3 -> 1346
    //   1346: aload 18
    //   1348: iload 4
    //   1350: aload 19
    //   1352: invokestatic 283	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
    //   1355: astore 19
    //   1357: aload 19
    //   1359: checkcast 285	javax/microedition/khronos/opengles/GL10
    //   1362: astore 18
    //   1364: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   1367: aload 18
    //   1369: invokevirtual 288	com/tencent/map/sdk/a/pv$j:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   1372: iconst_0
    //   1373: istore 8
    //   1375: iload_2
    //   1376: istore 4
    //   1378: iload_2
    //   1379: ifeq +42 -> 1421
    //   1382: aload_0
    //   1383: getfield 53	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
    //   1386: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1389: checkcast 73	com/tencent/map/sdk/a/pv
    //   1392: astore 19
    //   1394: aload 19
    //   1396: ifnull +466 -> 1862
    //   1399: aload 19
    //   1401: invokestatic 98	com/tencent/map/sdk/a/pv:g	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$m;
    //   1404: aload 18
    //   1406: aload_0
    //   1407: getfield 63	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
    //   1410: getfield 175	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1413: invokeinterface 293 3 0
    //   1418: goto +444 -> 1862
    //   1421: iload_1
    //   1422: istore_2
    //   1423: iload_1
    //   1424: ifeq +39 -> 1463
    //   1427: aload_0
    //   1428: getfield 53	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
    //   1431: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1434: checkcast 73	com/tencent/map/sdk/a/pv
    //   1437: astore 19
    //   1439: aload 19
    //   1441: ifnull +427 -> 1868
    //   1444: aload 19
    //   1446: invokestatic 98	com/tencent/map/sdk/a/pv:g	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$m;
    //   1449: aload 18
    //   1451: iload 15
    //   1453: iload 14
    //   1455: invokeinterface 296 4 0
    //   1460: goto +408 -> 1868
    //   1463: aload_0
    //   1464: getfield 53	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
    //   1467: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1470: checkcast 73	com/tencent/map/sdk/a/pv
    //   1473: astore 19
    //   1475: aload 19
    //   1477: ifnull +396 -> 1873
    //   1480: aload 19
    //   1482: invokestatic 98	com/tencent/map/sdk/a/pv:g	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$m;
    //   1485: aload 18
    //   1487: invokeinterface 299 2 0
    //   1492: istore 16
    //   1494: goto +3 -> 1497
    //   1497: iload 16
    //   1499: ifeq +107 -> 1606
    //   1502: aload_0
    //   1503: getfield 63	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
    //   1506: astore 19
    //   1508: aload 19
    //   1510: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   1513: aload 19
    //   1515: getfield 163	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1518: aload 19
    //   1520: getfield 209	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1523: invokeinterface 303 3 0
    //   1528: ifne +351 -> 1879
    //   1531: aload 19
    //   1533: getfield 152	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
    //   1536: invokeinterface 201 1 0
    //   1541: istore_1
    //   1542: goto +3 -> 1545
    //   1545: iload_1
    //   1546: sipush 12288
    //   1549: if_icmpeq +57 -> 1606
    //   1552: iload_1
    //   1553: sipush 12302
    //   1556: if_icmpeq +45 -> 1601
    //   1559: ldc_w 305
    //   1562: ldc_w 306
    //   1565: invokestatic 243	com/tencent/map/sdk/a/pv$h:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1568: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   1571: astore 19
    //   1573: aload 19
    //   1575: monitorenter
    //   1576: aload_0
    //   1577: iconst_1
    //   1578: putfield 136	com/tencent/map/sdk/a/pv$i:p	Z
    //   1581: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   1584: invokevirtual 121	java/lang/Object:notifyAll	()V
    //   1587: aload 19
    //   1589: monitorexit
    //   1590: goto +16 -> 1606
    //   1593: astore 18
    //   1595: aload 19
    //   1597: monitorexit
    //   1598: aload 18
    //   1600: athrow
    //   1601: iconst_1
    //   1602: istore_1
    //   1603: goto +5 -> 1608
    //   1606: iload_3
    //   1607: istore_1
    //   1608: iload_1
    //   1609: istore 13
    //   1611: iload 5
    //   1613: istore_3
    //   1614: iload 4
    //   1616: istore 10
    //   1618: aload 18
    //   1620: astore 19
    //   1622: iload 8
    //   1624: istore 11
    //   1626: iload_2
    //   1627: istore 12
    //   1629: iload 9
    //   1631: ifeq +192 -> 1823
    //   1634: iconst_1
    //   1635: istore 7
    //   1637: iload_2
    //   1638: istore 10
    //   1640: iload 4
    //   1642: istore_2
    //   1643: iload_1
    //   1644: istore_3
    //   1645: aload 20
    //   1647: astore 19
    //   1649: iload 8
    //   1651: istore 4
    //   1653: iload 10
    //   1655: istore_1
    //   1656: iload 15
    //   1658: istore 11
    //   1660: iload 14
    //   1662: istore 10
    //   1664: goto -1606 -> 58
    //   1667: iload_3
    //   1668: istore 9
    //   1670: goto +3 -> 1673
    //   1673: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   1676: invokevirtual 309	java/lang/Object:wait	()V
    //   1679: iload_1
    //   1680: istore_3
    //   1681: iload_2
    //   1682: istore 7
    //   1684: goto -1608 -> 76
    //   1687: astore 18
    //   1689: aload 21
    //   1691: monitorexit
    //   1692: aload 18
    //   1694: athrow
    //   1695: astore 19
    //   1697: goto +38 -> 1735
    //   1700: astore 18
    //   1702: aload 18
    //   1704: invokevirtual 312	java/lang/Exception:printStackTrace	()V
    //   1707: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   1710: astore 18
    //   1712: aload 18
    //   1714: monitorenter
    //   1715: aload_0
    //   1716: invokespecial 100	com/tencent/map/sdk/a/pv$i:d	()V
    //   1719: aload_0
    //   1720: invokespecial 102	com/tencent/map/sdk/a/pv$i:e	()V
    //   1723: aload 18
    //   1725: monitorexit
    //   1726: return
    //   1727: astore 19
    //   1729: aload 18
    //   1731: monitorexit
    //   1732: aload 19
    //   1734: athrow
    //   1735: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   1738: astore 18
    //   1740: aload 18
    //   1742: monitorenter
    //   1743: aload_0
    //   1744: invokespecial 100	com/tencent/map/sdk/a/pv$i:d	()V
    //   1747: aload_0
    //   1748: invokespecial 102	com/tencent/map/sdk/a/pv$i:e	()V
    //   1751: aload 18
    //   1753: monitorexit
    //   1754: aload 19
    //   1756: athrow
    //   1757: astore 19
    //   1759: aload 18
    //   1761: monitorexit
    //   1762: goto +6 -> 1768
    //   1765: aload 19
    //   1767: athrow
    //   1768: goto -3 -> 1765
    //   1771: astore 20
    //   1773: goto -1046 -> 727
    //   1776: astore 20
    //   1778: goto -1051 -> 727
    //   1781: astore 20
    //   1783: goto -1056 -> 727
    //   1786: iconst_0
    //   1787: istore 16
    //   1789: goto -1574 -> 215
    //   1792: goto -1094 -> 698
    //   1795: iload 9
    //   1797: istore_3
    //   1798: goto -1048 -> 750
    //   1801: goto -1020 -> 781
    //   1804: iload 12
    //   1806: istore 9
    //   1808: goto -984 -> 824
    //   1811: iconst_1
    //   1812: istore 8
    //   1814: goto -719 -> 1095
    //   1817: iconst_0
    //   1818: istore 8
    //   1820: goto -725 -> 1095
    //   1823: iload 13
    //   1825: istore_1
    //   1826: iload_3
    //   1827: istore 5
    //   1829: iload 10
    //   1831: istore_2
    //   1832: aload 19
    //   1834: astore 18
    //   1836: iload 11
    //   1838: istore 8
    //   1840: iload 12
    //   1842: istore 10
    //   1844: goto -201 -> 1643
    //   1847: goto -620 -> 1227
    //   1850: iconst_0
    //   1851: istore 4
    //   1853: goto -529 -> 1324
    //   1856: aconst_null
    //   1857: astore 19
    //   1859: goto -513 -> 1346
    //   1862: iconst_0
    //   1863: istore 4
    //   1865: goto -444 -> 1421
    //   1868: iconst_0
    //   1869: istore_2
    //   1870: goto -407 -> 1463
    //   1873: iconst_0
    //   1874: istore 16
    //   1876: goto -379 -> 1497
    //   1879: sipush 12288
    //   1882: istore_1
    //   1883: goto -338 -> 1545
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1886	0	this	i
    //   48	1835	1	i1	int
    //   40	1830	2	i2	int
    //   26	1801	3	i3	int
    //   45	1819	4	i4	int
    //   34	1794	5	i5	int
    //   31	431	6	i6	int
    //   28	1655	7	i7	int
    //   71	1768	8	i8	int
    //   50	1757	9	i9	int
    //   56	1787	10	i10	int
    //   53	1784	11	i11	int
    //   68	1773	12	i12	int
    //   1164	660	13	i13	int
    //   176	1485	14	i14	int
    //   172	1485	15	i15	int
    //   196	1679	16	bool1	boolean
    //   300	13	17	bool2	boolean
    //   42	90	18	localObject1	Object
    //   1128	45	18	localObject2	Object
    //   1186	6	18	localObject3	Object
    //   1250	236	18	localObject4	Object
    //   1593	26	18	localObject5	Object
    //   1687	6	18	localObject6	Object
    //   1700	3	18	localException	java.lang.Exception
    //   1710	125	18	localObject7	Object
    //   37	1	19	localObject8	Object
    //   129	726	19	localObject9	Object
    //   877	771	19	localObject10	Object
    //   1695	1	19	localObject11	Object
    //   1727	28	19	localObject12	Object
    //   1757	76	19	localObject13	Object
    //   1857	1	19	localObject14	Object
    //   158	1488	20	localObject15	Object
    //   1771	1	20	localRuntimeException1	java.lang.RuntimeException
    //   1776	1	20	localRuntimeException2	java.lang.RuntimeException
    //   1781	1	20	localRuntimeException3	java.lang.RuntimeException
    //   61	1629	21	localObject16	Object
    //   532	95	22	localObject17	Object
    //   539	69	23	localObject18	Object
    //   603	7	24	localEGL10	javax.microedition.khronos.egl.EGL10
    // Exception table:
    //   from	to	target	type
    //   117	128	129	finally
    //   131	134	129	finally
    //   1108	1122	1128	finally
    //   1130	1133	1128	finally
    //   1144	1163	1186	finally
    //   1188	1191	1186	finally
    //   1576	1590	1593	finally
    //   1595	1598	1593	finally
    //   76	95	1687	finally
    //   100	106	1687	finally
    //   106	109	1687	finally
    //   137	160	1687	finally
    //   181	212	1687	finally
    //   215	235	1687	finally
    //   244	252	1687	finally
    //   259	270	1687	finally
    //   275	294	1687	finally
    //   305	312	1687	finally
    //   317	326	1687	finally
    //   326	330	1687	finally
    //   335	351	1687	finally
    //   351	376	1687	finally
    //   376	392	1687	finally
    //   392	417	1687	finally
    //   425	436	1687	finally
    //   441	455	1687	finally
    //   469	478	1687	finally
    //   483	541	1687	finally
    //   541	571	1687	finally
    //   576	588	1687	finally
    //   591	605	1687	finally
    //   605	654	1687	finally
    //   654	673	1687	finally
    //   676	698	1687	finally
    //   698	704	1687	finally
    //   707	717	1687	finally
    //   717	727	1687	finally
    //   727	734	1687	finally
    //   734	745	1687	finally
    //   750	769	1687	finally
    //   781	812	1687	finally
    //   824	835	1687	finally
    //   861	864	1687	finally
    //   1673	1679	1687	finally
    //   1689	1692	1687	finally
    //   58	66	1695	finally
    //   869	876	1695	finally
    //   895	943	1695	finally
    //   948	983	1695	finally
    //   986	992	1695	finally
    //   992	1011	1695	finally
    //   1014	1065	1695	finally
    //   1068	1092	1695	finally
    //   1100	1108	1695	finally
    //   1133	1136	1695	finally
    //   1136	1144	1695	finally
    //   1191	1194	1695	finally
    //   1194	1205	1695	finally
    //   1205	1216	1695	finally
    //   1216	1227	1695	finally
    //   1236	1265	1695	finally
    //   1274	1294	1695	finally
    //   1298	1318	1695	finally
    //   1324	1343	1695	finally
    //   1346	1357	1695	finally
    //   1357	1372	1695	finally
    //   1382	1394	1695	finally
    //   1399	1418	1695	finally
    //   1427	1439	1695	finally
    //   1444	1460	1695	finally
    //   1463	1475	1695	finally
    //   1480	1494	1695	finally
    //   1502	1542	1695	finally
    //   1559	1576	1695	finally
    //   1598	1601	1695	finally
    //   1692	1695	1695	finally
    //   1702	1707	1695	finally
    //   58	66	1700	java/lang/Exception
    //   869	876	1700	java/lang/Exception
    //   895	943	1700	java/lang/Exception
    //   948	983	1700	java/lang/Exception
    //   986	992	1700	java/lang/Exception
    //   992	1011	1700	java/lang/Exception
    //   1014	1065	1700	java/lang/Exception
    //   1068	1092	1700	java/lang/Exception
    //   1100	1108	1700	java/lang/Exception
    //   1133	1136	1700	java/lang/Exception
    //   1136	1144	1700	java/lang/Exception
    //   1191	1194	1700	java/lang/Exception
    //   1194	1205	1700	java/lang/Exception
    //   1205	1216	1700	java/lang/Exception
    //   1216	1227	1700	java/lang/Exception
    //   1236	1265	1700	java/lang/Exception
    //   1274	1294	1700	java/lang/Exception
    //   1298	1318	1700	java/lang/Exception
    //   1324	1343	1700	java/lang/Exception
    //   1346	1357	1700	java/lang/Exception
    //   1357	1372	1700	java/lang/Exception
    //   1382	1394	1700	java/lang/Exception
    //   1399	1418	1700	java/lang/Exception
    //   1427	1439	1700	java/lang/Exception
    //   1444	1460	1700	java/lang/Exception
    //   1463	1475	1700	java/lang/Exception
    //   1480	1494	1700	java/lang/Exception
    //   1502	1542	1700	java/lang/Exception
    //   1559	1576	1700	java/lang/Exception
    //   1598	1601	1700	java/lang/Exception
    //   1692	1695	1700	java/lang/Exception
    //   1715	1726	1727	finally
    //   1729	1732	1727	finally
    //   1743	1754	1757	finally
    //   1759	1762	1757	finally
    //   483	541	1771	java/lang/RuntimeException
    //   541	571	1776	java/lang/RuntimeException
    //   576	588	1776	java/lang/RuntimeException
    //   591	605	1776	java/lang/RuntimeException
    //   605	654	1781	java/lang/RuntimeException
    //   654	673	1781	java/lang/RuntimeException
    //   676	698	1781	java/lang/RuntimeException
    //   698	704	1781	java/lang/RuntimeException
    //   707	717	1781	java/lang/RuntimeException
    //   717	727	1781	java/lang/RuntimeException
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      synchronized (pv.a())
      {
        this.q = paramInt;
        pv.a().notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("renderMode");
  }
  
  final boolean a()
  {
    return (!this.c) && (this.d) && (!this.p) && (this.j > 0) && (this.k > 0) && ((this.l) || (this.q == 1));
  }
  
  public final int b()
  {
    synchronized ()
    {
      int i1 = this.q;
      return i1;
    }
  }
  
  public final void c()
  {
    synchronized ()
    {
      this.o = true;
      pv.a().notifyAll();
      for (;;)
      {
        boolean bool = this.a;
        if (bool) {
          break;
        }
        try
        {
          pv.a().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label35:
          break label35;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: new 329	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 331
    //   7: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: aload_0
    //   13: invokevirtual 336	com/tencent/map/sdk/a/pv$i:getId	()J
    //   16: invokevirtual 340	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokevirtual 347	com/tencent/map/sdk/a/pv$i:setName	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokespecial 349	com/tencent/map/sdk/a/pv$i:f	()V
    //   32: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   35: aload_0
    //   36: invokevirtual 351	com/tencent/map/sdk/a/pv$j:a	(Lcom/tencent/map/sdk/a/pv$i;)V
    //   39: return
    //   40: astore_1
    //   41: goto +12 -> 53
    //   44: invokestatic 324	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   47: invokevirtual 327	java/lang/Thread:interrupt	()V
    //   50: goto -18 -> 32
    //   53: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
    //   56: aload_0
    //   57: invokevirtual 351	com/tencent/map/sdk/a/pv$j:a	(Lcom/tencent/map/sdk/a/pv$i;)V
    //   60: goto +5 -> 65
    //   63: aload_1
    //   64: athrow
    //   65: goto -2 -> 63
    //   68: astore_1
    //   69: goto -25 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	i
    //   10	12	1	localStringBuilder	java.lang.StringBuilder
    //   40	24	1	localObject	Object
    //   68	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   28	32	40	finally
    //   44	50	40	finally
    //   28	32	68	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pv.i
 * JD-Core Version:    0.7.0.1
 */