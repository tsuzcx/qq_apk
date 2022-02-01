package com.tencent.liteav.renderer;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

class TXCGLSurfaceViewBase$i
  extends Thread
{
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private int l = 0;
  private int m = 0;
  private int n = 1;
  private boolean o = true;
  private boolean p;
  private ArrayList<Runnable> q = new ArrayList();
  private boolean r = true;
  private TXCGLSurfaceViewBase.h s;
  private WeakReference<TXCGLSurfaceViewBase> t;
  
  TXCGLSurfaceViewBase$i(WeakReference<TXCGLSurfaceViewBase> paramWeakReference)
  {
    this.t = paramWeakReference;
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 63	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h
    //   4: dup
    //   5: aload_0
    //   6: getfield 53	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:t	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 65	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 67	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 69	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:h	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 71	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
    //   25: iconst_0
    //   26: istore 4
    //   28: iconst_0
    //   29: istore 8
    //   31: iconst_0
    //   32: istore 7
    //   34: aconst_null
    //   35: astore 20
    //   37: iconst_0
    //   38: istore 10
    //   40: iconst_0
    //   41: istore 9
    //   43: iconst_0
    //   44: istore_3
    //   45: iconst_0
    //   46: istore 5
    //   48: iconst_0
    //   49: istore_2
    //   50: iconst_0
    //   51: istore_1
    //   52: iconst_0
    //   53: istore 6
    //   55: aconst_null
    //   56: astore 21
    //   58: iload_3
    //   59: istore 11
    //   61: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   64: astore 22
    //   66: aload 22
    //   68: monitorenter
    //   69: iload 6
    //   71: istore 12
    //   73: iload 11
    //   75: istore 6
    //   77: iload 8
    //   79: istore 13
    //   81: aload_0
    //   82: getfield 78	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:a	Z
    //   85: ifeq +34 -> 119
    //   88: aload 22
    //   90: monitorexit
    //   91: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   94: astore 20
    //   96: aload 20
    //   98: monitorenter
    //   99: aload_0
    //   100: invokespecial 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
    //   103: aload_0
    //   104: invokespecial 82	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	()V
    //   107: aload 20
    //   109: monitorexit
    //   110: return
    //   111: astore 21
    //   113: aload 20
    //   115: monitorexit
    //   116: aload 21
    //   118: athrow
    //   119: aload_0
    //   120: getfield 41	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:q	Ljava/util/ArrayList;
    //   123: invokevirtual 86	java/util/ArrayList:isEmpty	()Z
    //   126: ifne +30 -> 156
    //   129: aload_0
    //   130: getfield 41	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:q	Ljava/util/ArrayList;
    //   133: iconst_0
    //   134: invokevirtual 90	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   137: checkcast 92	java/lang/Runnable
    //   140: astore 21
    //   142: iload 13
    //   144: istore 8
    //   146: iload 6
    //   148: istore_3
    //   149: iload 12
    //   151: istore 6
    //   153: goto +493 -> 646
    //   156: aload_0
    //   157: getfield 94	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:d	Z
    //   160: aload_0
    //   161: getfield 96	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:c	Z
    //   164: if_icmpeq +988 -> 1152
    //   167: aload_0
    //   168: getfield 96	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:c	Z
    //   171: istore 18
    //   173: aload_0
    //   174: aload_0
    //   175: getfield 96	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:c	Z
    //   178: putfield 94	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:d	Z
    //   181: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   184: invokevirtual 101	java/lang/Object:notifyAll	()V
    //   187: goto +3 -> 190
    //   190: iload 7
    //   192: istore 8
    //   194: aload_0
    //   195: getfield 103	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	Z
    //   198: ifeq +19 -> 217
    //   201: aload_0
    //   202: invokespecial 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
    //   205: aload_0
    //   206: invokespecial 82	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	()V
    //   209: aload_0
    //   210: iconst_0
    //   211: putfield 103	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	Z
    //   214: iconst_1
    //   215: istore 8
    //   217: iload 4
    //   219: ifeq +939 -> 1158
    //   222: aload_0
    //   223: invokespecial 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
    //   226: aload_0
    //   227: invokespecial 82	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	()V
    //   230: iconst_0
    //   231: istore_3
    //   232: goto +3 -> 235
    //   235: iload 18
    //   237: ifeq +14 -> 251
    //   240: aload_0
    //   241: getfield 71	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
    //   244: ifeq +7 -> 251
    //   247: aload_0
    //   248: invokespecial 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
    //   251: iload 18
    //   253: ifeq +58 -> 311
    //   256: aload_0
    //   257: getfield 69	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:h	Z
    //   260: ifeq +51 -> 311
    //   263: aload_0
    //   264: getfield 53	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:t	Ljava/lang/ref/WeakReference;
    //   267: invokevirtual 109	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   270: checkcast 73	com/tencent/liteav/renderer/TXCGLSurfaceViewBase
    //   273: astore 23
    //   275: aload 23
    //   277: ifnonnull +9 -> 286
    //   280: iconst_0
    //   281: istore 19
    //   283: goto +10 -> 293
    //   286: aload 23
    //   288: invokestatic 112	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:a	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase;)Z
    //   291: istore 19
    //   293: iload 19
    //   295: ifeq +12 -> 307
    //   298: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   301: invokevirtual 116	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:a	()Z
    //   304: ifeq +7 -> 311
    //   307: aload_0
    //   308: invokespecial 82	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	()V
    //   311: iload 18
    //   313: ifeq +19 -> 332
    //   316: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   319: invokevirtual 118	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:b	()Z
    //   322: ifeq +10 -> 332
    //   325: aload_0
    //   326: getfield 67	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
    //   329: invokevirtual 120	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:h	()V
    //   332: aload_0
    //   333: getfield 122	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:e	Z
    //   336: ifne +37 -> 373
    //   339: aload_0
    //   340: getfield 124	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:g	Z
    //   343: ifne +30 -> 373
    //   346: aload_0
    //   347: getfield 71	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
    //   350: ifeq +7 -> 357
    //   353: aload_0
    //   354: invokespecial 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
    //   357: aload_0
    //   358: iconst_1
    //   359: putfield 124	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:g	Z
    //   362: aload_0
    //   363: iconst_0
    //   364: putfield 126	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:f	Z
    //   367: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   370: invokevirtual 101	java/lang/Object:notifyAll	()V
    //   373: aload_0
    //   374: getfield 122	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:e	Z
    //   377: ifeq +21 -> 398
    //   380: aload_0
    //   381: getfield 124	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:g	Z
    //   384: ifeq +14 -> 398
    //   387: aload_0
    //   388: iconst_0
    //   389: putfield 124	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:g	Z
    //   392: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   395: invokevirtual 101	java/lang/Object:notifyAll	()V
    //   398: iload 13
    //   400: istore 11
    //   402: iload 13
    //   404: ifeq +20 -> 424
    //   407: aload_0
    //   408: iconst_1
    //   409: putfield 128	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:p	Z
    //   412: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   415: invokevirtual 101	java/lang/Object:notifyAll	()V
    //   418: iconst_0
    //   419: istore 11
    //   421: iconst_0
    //   422: istore 12
    //   424: iload 8
    //   426: istore 7
    //   428: iload 6
    //   430: istore 17
    //   432: iload 5
    //   434: istore 16
    //   436: iload_2
    //   437: istore 15
    //   439: iload_1
    //   440: istore 14
    //   442: aload_0
    //   443: invokespecial 130	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:m	()Z
    //   446: ifeq +630 -> 1076
    //   449: iload 8
    //   451: istore 7
    //   453: iload 6
    //   455: istore 4
    //   457: aload_0
    //   458: getfield 69	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:h	Z
    //   461: ifne +89 -> 550
    //   464: iload 8
    //   466: ifeq +13 -> 479
    //   469: iconst_0
    //   470: istore 7
    //   472: iload 6
    //   474: istore 4
    //   476: goto +74 -> 550
    //   479: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   482: aload_0
    //   483: invokevirtual 133	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:b	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$i;)Z
    //   486: istore 18
    //   488: iload 8
    //   490: istore 7
    //   492: iload 6
    //   494: istore 4
    //   496: iload 18
    //   498: ifeq +52 -> 550
    //   501: aload_0
    //   502: getfield 67	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
    //   505: invokevirtual 135	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:a	()V
    //   508: goto +24 -> 532
    //   511: astore 23
    //   513: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   516: aload_0
    //   517: invokevirtual 138	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:c	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$i;)V
    //   520: ldc 140
    //   522: ldc 142
    //   524: aload 23
    //   526: invokestatic 147	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   529: goto -21 -> 508
    //   532: aload_0
    //   533: iconst_1
    //   534: putfield 69	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:h	Z
    //   537: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   540: invokevirtual 101	java/lang/Object:notifyAll	()V
    //   543: iconst_1
    //   544: istore 4
    //   546: iload 8
    //   548: istore 7
    //   550: aload_0
    //   551: getfield 69	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:h	Z
    //   554: ifeq +610 -> 1164
    //   557: aload_0
    //   558: getfield 71	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
    //   561: ifne +603 -> 1164
    //   564: aload_0
    //   565: iconst_1
    //   566: putfield 71	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
    //   569: iconst_1
    //   570: istore 5
    //   572: iconst_1
    //   573: istore_2
    //   574: iconst_1
    //   575: istore_1
    //   576: goto +3 -> 579
    //   579: aload_0
    //   580: getfield 71	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:i	Z
    //   583: ifeq +479 -> 1062
    //   586: aload_0
    //   587: getfield 43	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:r	Z
    //   590: ifeq +577 -> 1167
    //   593: aload_0
    //   594: getfield 45	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	I
    //   597: istore 10
    //   599: aload_0
    //   600: getfield 47	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:m	I
    //   603: istore 9
    //   605: aload_0
    //   606: iconst_0
    //   607: putfield 43	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:r	Z
    //   610: iconst_1
    //   611: istore 5
    //   613: iconst_1
    //   614: istore_1
    //   615: iconst_1
    //   616: istore 6
    //   618: goto +3 -> 621
    //   621: aload_0
    //   622: iconst_0
    //   623: putfield 49	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:o	Z
    //   626: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   629: invokevirtual 101	java/lang/Object:notifyAll	()V
    //   632: iload_3
    //   633: istore 12
    //   635: iload 4
    //   637: istore_3
    //   638: iload 11
    //   640: istore 8
    //   642: iload 12
    //   644: istore 4
    //   646: aload 22
    //   648: monitorexit
    //   649: aload 21
    //   651: ifnull +13 -> 664
    //   654: aload 21
    //   656: invokeinterface 150 1 0
    //   661: goto -606 -> 55
    //   664: iload 5
    //   666: istore 11
    //   668: iload 5
    //   670: ifeq +100 -> 770
    //   673: aload_0
    //   674: getfield 67	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
    //   677: invokevirtual 151	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:b	()Z
    //   680: ifeq +39 -> 719
    //   683: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   686: astore 22
    //   688: aload 22
    //   690: monitorenter
    //   691: aload_0
    //   692: iconst_1
    //   693: putfield 153	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:j	Z
    //   696: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   699: invokevirtual 101	java/lang/Object:notifyAll	()V
    //   702: aload 22
    //   704: monitorexit
    //   705: iconst_0
    //   706: istore 11
    //   708: goto +62 -> 770
    //   711: astore 20
    //   713: aload 22
    //   715: monitorexit
    //   716: aload 20
    //   718: athrow
    //   719: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   722: astore 22
    //   724: aload 22
    //   726: monitorenter
    //   727: aload_0
    //   728: iconst_1
    //   729: putfield 153	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:j	Z
    //   732: aload_0
    //   733: iconst_1
    //   734: putfield 126	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:f	Z
    //   737: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   740: invokevirtual 101	java/lang/Object:notifyAll	()V
    //   743: aload 22
    //   745: monitorexit
    //   746: iload 5
    //   748: istore 14
    //   750: aload 20
    //   752: astore 22
    //   754: iload_3
    //   755: istore 12
    //   757: iload_2
    //   758: istore_3
    //   759: goto +286 -> 1045
    //   762: astore 20
    //   764: aload 22
    //   766: monitorexit
    //   767: aload 20
    //   769: athrow
    //   770: iload_2
    //   771: istore 5
    //   773: iload_2
    //   774: ifeq +26 -> 800
    //   777: aload_0
    //   778: getfield 67	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
    //   781: invokevirtual 156	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:e	()Ljavax/microedition/khronos/opengles/GL;
    //   784: checkcast 158	javax/microedition/khronos/opengles/GL10
    //   787: astore 20
    //   789: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   792: aload 20
    //   794: invokevirtual 161	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   797: iconst_0
    //   798: istore 5
    //   800: iload_3
    //   801: istore_2
    //   802: iload_3
    //   803: ifeq +42 -> 845
    //   806: aload_0
    //   807: getfield 53	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:t	Ljava/lang/ref/WeakReference;
    //   810: invokevirtual 109	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   813: checkcast 73	com/tencent/liteav/renderer/TXCGLSurfaceViewBase
    //   816: astore 22
    //   818: aload 22
    //   820: ifnull +354 -> 1174
    //   823: aload 22
    //   825: invokestatic 164	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:b	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase;)Landroid/opengl/GLSurfaceView$Renderer;
    //   828: aload 20
    //   830: aload_0
    //   831: getfield 67	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:s	Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$h;
    //   834: getfield 167	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:d	Ljavax/microedition/khronos/egl/EGLConfig;
    //   837: invokeinterface 173 3 0
    //   842: goto +332 -> 1174
    //   845: iload_1
    //   846: istore 13
    //   848: iload_1
    //   849: ifeq +39 -> 888
    //   852: aload_0
    //   853: getfield 53	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:t	Ljava/lang/ref/WeakReference;
    //   856: invokevirtual 109	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   859: checkcast 73	com/tencent/liteav/renderer/TXCGLSurfaceViewBase
    //   862: astore 22
    //   864: aload 22
    //   866: ifnull +313 -> 1179
    //   869: aload 22
    //   871: invokestatic 164	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:b	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase;)Landroid/opengl/GLSurfaceView$Renderer;
    //   874: aload 20
    //   876: iload 10
    //   878: iload 9
    //   880: invokeinterface 177 4 0
    //   885: goto +294 -> 1179
    //   888: aload_0
    //   889: getfield 53	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:t	Ljava/lang/ref/WeakReference;
    //   892: invokevirtual 109	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   895: checkcast 73	com/tencent/liteav/renderer/TXCGLSurfaceViewBase
    //   898: astore 22
    //   900: aload 22
    //   902: ifnull +283 -> 1185
    //   905: aload 22
    //   907: invokestatic 164	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:b	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase;)Landroid/opengl/GLSurfaceView$Renderer;
    //   910: aload 20
    //   912: invokeinterface 180 2 0
    //   917: aload 22
    //   919: invokevirtual 183	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:c	()I
    //   922: istore_1
    //   923: goto +3 -> 926
    //   926: iload_1
    //   927: sipush 12288
    //   930: if_icmpeq +61 -> 991
    //   933: iload_1
    //   934: sipush 12302
    //   937: if_icmpeq +48 -> 985
    //   940: ldc 185
    //   942: ldc 187
    //   944: iload_1
    //   945: invokestatic 190	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$h:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   948: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   951: astore 22
    //   953: aload 22
    //   955: monitorenter
    //   956: aload_0
    //   957: iconst_1
    //   958: putfield 126	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:f	Z
    //   961: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   964: invokevirtual 101	java/lang/Object:notifyAll	()V
    //   967: aload 22
    //   969: monitorexit
    //   970: iload 4
    //   972: istore 15
    //   974: goto +21 -> 995
    //   977: astore 20
    //   979: aload 22
    //   981: monitorexit
    //   982: aload 20
    //   984: athrow
    //   985: iconst_1
    //   986: istore 15
    //   988: goto +7 -> 995
    //   991: iload 4
    //   993: istore 15
    //   995: iload 15
    //   997: istore 4
    //   999: iload 11
    //   1001: istore 14
    //   1003: aload 20
    //   1005: astore 22
    //   1007: iload_2
    //   1008: istore 12
    //   1010: iload 5
    //   1012: istore_3
    //   1013: iload 13
    //   1015: istore_1
    //   1016: iload 6
    //   1018: ifeq +27 -> 1045
    //   1021: iconst_1
    //   1022: istore 8
    //   1024: iload 13
    //   1026: istore_1
    //   1027: iload 5
    //   1029: istore_3
    //   1030: iload_2
    //   1031: istore 12
    //   1033: aload 20
    //   1035: astore 22
    //   1037: iload 11
    //   1039: istore 14
    //   1041: iload 15
    //   1043: istore 4
    //   1045: iload 14
    //   1047: istore 5
    //   1049: aload 22
    //   1051: astore 20
    //   1053: iload 12
    //   1055: istore 11
    //   1057: iload_3
    //   1058: istore_2
    //   1059: goto -998 -> 61
    //   1062: iload_1
    //   1063: istore 14
    //   1065: iload_2
    //   1066: istore 15
    //   1068: iload 5
    //   1070: istore 16
    //   1072: iload 4
    //   1074: istore 17
    //   1076: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   1079: invokevirtual 193	java/lang/Object:wait	()V
    //   1082: iload_3
    //   1083: istore 4
    //   1085: iload 11
    //   1087: istore 13
    //   1089: iload 17
    //   1091: istore 6
    //   1093: iload 16
    //   1095: istore 5
    //   1097: iload 15
    //   1099: istore_2
    //   1100: iload 14
    //   1102: istore_1
    //   1103: goto -1022 -> 81
    //   1106: astore 20
    //   1108: aload 22
    //   1110: monitorexit
    //   1111: aload 20
    //   1113: athrow
    //   1114: astore 21
    //   1116: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   1119: astore 20
    //   1121: aload 20
    //   1123: monitorenter
    //   1124: aload_0
    //   1125: invokespecial 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:k	()V
    //   1128: aload_0
    //   1129: invokespecial 82	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:l	()V
    //   1132: aload 20
    //   1134: monitorexit
    //   1135: aload 21
    //   1137: athrow
    //   1138: astore 21
    //   1140: aload 20
    //   1142: monitorexit
    //   1143: goto +6 -> 1149
    //   1146: aload 21
    //   1148: athrow
    //   1149: goto -3 -> 1146
    //   1152: iconst_0
    //   1153: istore 18
    //   1155: goto -965 -> 190
    //   1158: iload 4
    //   1160: istore_3
    //   1161: goto -926 -> 235
    //   1164: goto -585 -> 579
    //   1167: iload 12
    //   1169: istore 6
    //   1171: goto -550 -> 621
    //   1174: iconst_0
    //   1175: istore_2
    //   1176: goto -331 -> 845
    //   1179: iconst_0
    //   1180: istore 13
    //   1182: goto -294 -> 888
    //   1185: sipush 12288
    //   1188: istore_1
    //   1189: goto -263 -> 926
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1192	0	this	i
    //   51	1138	1	i1	int
    //   49	1127	2	i2	int
    //   44	1117	3	i3	int
    //   26	1133	4	i4	int
    //   46	1050	5	i5	int
    //   53	1117	6	i6	int
    //   32	517	7	i7	int
    //   29	994	8	i8	int
    //   41	838	9	i9	int
    //   38	839	10	i10	int
    //   59	1027	11	i11	int
    //   71	1097	12	i12	int
    //   79	1102	13	i13	int
    //   440	661	14	i14	int
    //   437	661	15	i15	int
    //   434	660	16	i16	int
    //   430	660	17	i17	int
    //   171	983	18	bool1	boolean
    //   281	13	19	bool2	boolean
    //   35	79	20	localj1	TXCGLSurfaceViewBase.j
    //   711	40	20	localObject1	Object
    //   762	6	20	localObject2	Object
    //   787	124	20	localGL10	javax.microedition.khronos.opengles.GL10
    //   977	57	20	localObject3	Object
    //   1051	1	20	localObject4	Object
    //   1106	6	20	localObject5	Object
    //   1119	22	20	localj2	TXCGLSurfaceViewBase.j
    //   56	1	21	localObject6	Object
    //   111	6	21	localObject7	Object
    //   140	515	21	localRunnable	Runnable
    //   1114	22	21	localObject8	Object
    //   1138	9	21	localObject9	Object
    //   64	1045	22	localObject10	Object
    //   273	14	23	localTXCGLSurfaceViewBase	TXCGLSurfaceViewBase
    //   511	14	23	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   99	110	111	finally
    //   113	116	111	finally
    //   501	508	511	java/lang/RuntimeException
    //   691	705	711	finally
    //   713	716	711	finally
    //   727	746	762	finally
    //   764	767	762	finally
    //   956	970	977	finally
    //   979	982	977	finally
    //   81	91	1106	finally
    //   119	142	1106	finally
    //   156	187	1106	finally
    //   194	214	1106	finally
    //   222	230	1106	finally
    //   240	251	1106	finally
    //   256	275	1106	finally
    //   286	293	1106	finally
    //   298	307	1106	finally
    //   307	311	1106	finally
    //   316	332	1106	finally
    //   332	357	1106	finally
    //   357	373	1106	finally
    //   373	398	1106	finally
    //   407	418	1106	finally
    //   442	449	1106	finally
    //   457	464	1106	finally
    //   479	488	1106	finally
    //   501	508	1106	finally
    //   513	529	1106	finally
    //   532	543	1106	finally
    //   550	569	1106	finally
    //   579	610	1106	finally
    //   621	632	1106	finally
    //   646	649	1106	finally
    //   1076	1082	1106	finally
    //   1108	1111	1106	finally
    //   61	69	1114	finally
    //   654	661	1114	finally
    //   673	691	1114	finally
    //   716	719	1114	finally
    //   719	727	1114	finally
    //   767	770	1114	finally
    //   777	797	1114	finally
    //   806	818	1114	finally
    //   823	842	1114	finally
    //   852	864	1114	finally
    //   869	885	1114	finally
    //   888	900	1114	finally
    //   905	923	1114	finally
    //   940	956	1114	finally
    //   982	985	1114	finally
    //   1111	1114	1114	finally
    //   1124	1135	1138	finally
    //   1140	1143	1138	finally
  }
  
  private void k()
  {
    if (this.i)
    {
      this.i = false;
      this.s.g();
    }
  }
  
  private void l()
  {
    if (this.h)
    {
      this.s.h();
      this.h = false;
      TXCGLSurfaceViewBase localTXCGLSurfaceViewBase = (TXCGLSurfaceViewBase)this.t.get();
      if (localTXCGLSurfaceViewBase != null) {
        localTXCGLSurfaceViewBase.f = false;
      }
      TXCGLSurfaceViewBase.f().c(this);
    }
  }
  
  private boolean m()
  {
    boolean bool2 = this.d;
    boolean bool1 = true;
    if ((!bool2) && (this.e) && (!this.f) && (this.l > 0) && (this.m > 0))
    {
      if (this.o) {
        return bool1;
      }
      if (this.n == 1) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      synchronized (TXCGLSurfaceViewBase.f())
      {
        this.n = paramInt;
        TXCGLSurfaceViewBase.f().notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("renderMode");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized ()
    {
      this.l = paramInt1;
      this.m = paramInt2;
      this.r = true;
      this.o = true;
      this.p = false;
      TXCGLSurfaceViewBase.f().notifyAll();
      while ((!this.b) && (!this.d) && (!this.p))
      {
        boolean bool = d();
        if (!bool) {
          break;
        }
        try
        {
          TXCGLSurfaceViewBase.f().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label78:
          break label78;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      synchronized (TXCGLSurfaceViewBase.f())
      {
        this.q.add(paramRunnable);
        TXCGLSurfaceViewBase.f().notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("r must not be null");
  }
  
  public boolean a()
  {
    return this.s.c();
  }
  
  public int b()
  {
    return this.s.d();
  }
  
  public TXCGLSurfaceViewBase.h c()
  {
    return this.s;
  }
  
  public boolean d()
  {
    return (this.h) && (this.i) && (m());
  }
  
  public int e()
  {
    synchronized ()
    {
      int i1 = this.n;
      return i1;
    }
  }
  
  public void f()
  {
    synchronized ()
    {
      this.e = true;
      this.j = false;
      TXCGLSurfaceViewBase.f().notifyAll();
      while ((this.g) && (!this.j))
      {
        boolean bool = this.b;
        if (bool) {
          break;
        }
        try
        {
          TXCGLSurfaceViewBase.f().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label54:
          break label54;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void g()
  {
    synchronized ()
    {
      this.e = false;
      TXCGLSurfaceViewBase.f().notifyAll();
      while (!this.g)
      {
        boolean bool = this.b;
        if (bool) {
          break;
        }
        try
        {
          TXCGLSurfaceViewBase.f().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label42:
          break label42;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void h()
  {
    synchronized ()
    {
      this.a = true;
      TXCGLSurfaceViewBase.f().notifyAll();
      for (;;)
      {
        boolean bool = this.b;
        if (bool) {
          break;
        }
        try
        {
          TXCGLSurfaceViewBase.f().wait();
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
  
  public void i()
  {
    this.k = true;
    TXCGLSurfaceViewBase.f().notifyAll();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 230	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 233
    //   11: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 241	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:getId	()J
    //   20: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 251	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:setName	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: invokespecial 253	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$i:j	()V
    //   36: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   39: aload_0
    //   40: invokevirtual 255	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:a	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$i;)V
    //   43: return
    //   44: astore_1
    //   45: invokestatic 76	com/tencent/liteav/renderer/TXCGLSurfaceViewBase:f	()Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$j;
    //   48: aload_0
    //   49: invokevirtual 255	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:a	(Lcom/tencent/liteav/renderer/TXCGLSurfaceViewBase$i;)V
    //   52: aload_1
    //   53: athrow
    //   54: astore_1
    //   55: goto -19 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	i
    //   7	19	1	localStringBuilder	java.lang.StringBuilder
    //   44	9	1	localObject	Object
    //   54	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   32	36	44	finally
    //   32	36	54	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase.i
 * JD-Core Version:    0.7.0.1
 */