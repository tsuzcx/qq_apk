package c.t.m.g;

import android.os.Handler;
import android.os.Looper;

final class el$a
  extends Handler
{
  private int a = 0;
  private boolean b = true;
  
  el$a(el paramel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void a()
  {
    removeCallbacksAndMessages(null);
    this.b = true;
    this.a = 0;
  }
  
  /* Error */
  public final void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   4: invokestatic 42	c/t/m/g/el:a	(Lc/t/m/g/el;)Ljava/lang/Object;
    //   7: astore 13
    //   9: aload 13
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   16: invokestatic 45	c/t/m/g/el:b	(Lc/t/m/g/el;)Lcom/tencent/map/geolocation/TencentLocationListener;
    //   19: ifnonnull +7 -> 26
    //   22: aload 13
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   30: invokestatic 45	c/t/m/g/el:b	(Lc/t/m/g/el;)Lcom/tencent/map/geolocation/TencentLocationListener;
    //   33: astore 12
    //   35: aload 13
    //   37: monitorexit
    //   38: aload_0
    //   39: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   42: invokestatic 48	c/t/m/g/el:c	(Lc/t/m/g/el;)Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   45: astore 14
    //   47: aload 14
    //   49: invokevirtual 54	com/tencent/map/geolocation/TencentLocationRequest:getRequestLevel	()I
    //   52: istore 4
    //   54: aload 14
    //   56: invokevirtual 58	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   59: lstore 5
    //   61: aload 14
    //   63: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   66: ldc 64
    //   68: invokevirtual 70	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   71: istore 11
    //   73: aload_1
    //   74: getfield 75	android/os/Message:what	I
    //   77: lookupswitch	default:+91->168, 555:+92->169, 3998:+1275->1352, 3999:+550->627, 4996:+2624->2701, 4997:+2153->2230, 4998:+2593->2670, 4999:+1449->1526, 7999:+540->617, 11998:+401->478, 11999:+115->192
    //   169: aload_0
    //   170: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   173: invokestatic 79	c/t/m/g/el:C	(Lc/t/m/g/el;)Lc/t/m/g/ey;
    //   176: pop
    //   177: aload_0
    //   178: sipush 3999
    //   181: invokevirtual 83	c/t/m/g/el$a:sendEmptyMessage	(I)Z
    //   184: pop
    //   185: return
    //   186: astore_1
    //   187: aload 13
    //   189: monitorexit
    //   190: aload_1
    //   191: athrow
    //   192: aload_0
    //   193: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   196: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   199: ifnull +207 -> 406
    //   202: aload 14
    //   204: invokevirtual 58	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   207: lconst_0
    //   208: lcmp
    //   209: ifle +197 -> 406
    //   212: aload_0
    //   213: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   216: invokestatic 91	c/t/m/g/el:e	(Lc/t/m/g/el;)Ljava/lang/String;
    //   219: ifnull +187 -> 406
    //   222: aload_0
    //   223: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   226: invokestatic 91	c/t/m/g/el:e	(Lc/t/m/g/el;)Ljava/lang/String;
    //   229: ldc 93
    //   231: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   234: ifeq +172 -> 406
    //   237: aload_0
    //   238: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   241: aload_0
    //   242: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   245: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   248: invokestatic 101	c/t/m/g/el:a	(Lc/t/m/g/el;Lc/t/m/g/fi;)V
    //   251: new 103	java/lang/StringBuilder
    //   254: dup
    //   255: ldc 105
    //   257: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload_0
    //   261: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   264: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   267: invokevirtual 114	c/t/m/g/fi:getLatitude	()D
    //   270: invokevirtual 118	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   273: ldc 120
    //   275: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_0
    //   279: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   282: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   285: invokevirtual 126	c/t/m/g/fi:getLongitude	()D
    //   288: invokevirtual 118	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 12
    //   294: aload_0
    //   295: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   298: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   301: aload_0
    //   302: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   305: invokestatic 130	c/t/m/g/el:f	(Lc/t/m/g/el;)I
    //   308: invokestatic 133	c/t/m/g/el:e	()Landroid/util/SparseArray;
    //   311: aload_0
    //   312: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   315: invokestatic 130	c/t/m/g/el:f	(Lc/t/m/g/el;)I
    //   318: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   321: checkcast 95	java/lang/String
    //   324: invokeinterface 145 4 0
    //   329: aload_0
    //   330: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   333: invokestatic 149	c/t/m/g/el:g	(Lc/t/m/g/el;)Z
    //   336: ifeq +70 -> 406
    //   339: aload_0
    //   340: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   343: invokestatic 153	c/t/m/g/el:h	(Lc/t/m/g/el;)Lcom/tencent/map/geolocation/TencentDistanceListener;
    //   346: ifnull +60 -> 406
    //   349: aload_0
    //   350: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   353: invokestatic 153	c/t/m/g/el:h	(Lc/t/m/g/el;)Lcom/tencent/map/geolocation/TencentDistanceListener;
    //   356: aload_0
    //   357: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   360: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   363: aload_0
    //   364: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   367: invokestatic 157	c/t/m/g/el:i	(Lc/t/m/g/el;)D
    //   370: ldc2_w 158
    //   373: ddiv
    //   374: iconst_2
    //   375: invokestatic 164	c/t/m/g/fp:a	(DI)D
    //   378: aload_0
    //   379: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   382: invokestatic 130	c/t/m/g/el:f	(Lc/t/m/g/el;)I
    //   385: invokestatic 133	c/t/m/g/el:e	()Landroid/util/SparseArray;
    //   388: aload_0
    //   389: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   392: invokestatic 130	c/t/m/g/el:f	(Lc/t/m/g/el;)I
    //   395: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   398: checkcast 95	java/lang/String
    //   401: invokeinterface 170 6 0
    //   406: lload 5
    //   408: lconst_0
    //   409: lcmp
    //   410: ifle +18 -> 428
    //   413: iload 11
    //   415: ifne +13 -> 428
    //   418: aload_0
    //   419: sipush 11999
    //   422: lload 5
    //   424: invokevirtual 174	c/t/m/g/el$a:sendEmptyMessageDelayed	(IJ)Z
    //   427: pop
    //   428: aload_0
    //   429: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   432: invokestatic 177	c/t/m/g/el:j	(Lc/t/m/g/el;)Z
    //   435: istore 9
    //   437: aload_0
    //   438: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   441: invokestatic 181	c/t/m/g/el:k	(Lc/t/m/g/el;)Lc/t/m/g/es;
    //   444: iload 9
    //   446: putfield 185	c/t/m/g/es:d	Z
    //   449: iload 9
    //   451: ifeq +2318 -> 2769
    //   454: lload 5
    //   456: ldc2_w 186
    //   459: lcmp
    //   460: ifle +2309 -> 2769
    //   463: aload_0
    //   464: sipush 3999
    //   467: lload 5
    //   469: ldc2_w 188
    //   472: lsub
    //   473: invokevirtual 174	c/t/m/g/el$a:sendEmptyMessageDelayed	(IJ)Z
    //   476: pop
    //   477: return
    //   478: aload_0
    //   479: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   482: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   485: ifnull +2284 -> 2769
    //   488: aload_0
    //   489: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   492: aload_0
    //   493: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   496: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   499: invokestatic 101	c/t/m/g/el:a	(Lc/t/m/g/el;Lc/t/m/g/fi;)V
    //   502: aload 12
    //   504: aload_0
    //   505: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   508: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   511: aload_0
    //   512: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   515: invokestatic 130	c/t/m/g/el:f	(Lc/t/m/g/el;)I
    //   518: invokestatic 133	c/t/m/g/el:e	()Landroid/util/SparseArray;
    //   521: aload_0
    //   522: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   525: invokestatic 130	c/t/m/g/el:f	(Lc/t/m/g/el;)I
    //   528: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   531: checkcast 95	java/lang/String
    //   534: invokeinterface 145 4 0
    //   539: aload_0
    //   540: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   543: invokestatic 149	c/t/m/g/el:g	(Lc/t/m/g/el;)Z
    //   546: ifeq +2223 -> 2769
    //   549: aload_0
    //   550: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   553: invokestatic 153	c/t/m/g/el:h	(Lc/t/m/g/el;)Lcom/tencent/map/geolocation/TencentDistanceListener;
    //   556: ifnull +2213 -> 2769
    //   559: aload_0
    //   560: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   563: invokestatic 153	c/t/m/g/el:h	(Lc/t/m/g/el;)Lcom/tencent/map/geolocation/TencentDistanceListener;
    //   566: aload_0
    //   567: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   570: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   573: aload_0
    //   574: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   577: invokestatic 157	c/t/m/g/el:i	(Lc/t/m/g/el;)D
    //   580: ldc2_w 158
    //   583: ddiv
    //   584: iconst_2
    //   585: invokestatic 164	c/t/m/g/fp:a	(DI)D
    //   588: aload_0
    //   589: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   592: invokestatic 130	c/t/m/g/el:f	(Lc/t/m/g/el;)I
    //   595: invokestatic 133	c/t/m/g/el:e	()Landroid/util/SparseArray;
    //   598: aload_0
    //   599: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   602: invokestatic 130	c/t/m/g/el:f	(Lc/t/m/g/el;)I
    //   605: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   608: checkcast 95	java/lang/String
    //   611: invokeinterface 170 6 0
    //   616: return
    //   617: aload_0
    //   618: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   621: invokestatic 192	c/t/m/g/el:l	(Lc/t/m/g/el;)Z
    //   624: ifne +2145 -> 2769
    //   627: new 103	java/lang/StringBuilder
    //   630: dup
    //   631: ldc 194
    //   633: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   636: invokestatic 199	java/lang/System:currentTimeMillis	()J
    //   639: invokestatic 201	c/t/m/g/el:f	()J
    //   642: lsub
    //   643: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: iload 11
    //   649: ifeq +272 -> 921
    //   652: new 103	java/lang/StringBuilder
    //   655: dup
    //   656: ldc 206
    //   658: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   661: aload_0
    //   662: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   665: invokestatic 210	c/t/m/g/el:m	(Lc/t/m/g/el;)J
    //   668: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   671: ldc 120
    //   673: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokestatic 199	java/lang/System:currentTimeMillis	()J
    //   679: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   682: ldc 120
    //   684: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload_0
    //   688: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   691: invokestatic 213	c/t/m/g/el:n	(Lc/t/m/g/el;)J
    //   694: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: invokestatic 199	java/lang/System:currentTimeMillis	()J
    //   701: aload_0
    //   702: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   705: invokestatic 213	c/t/m/g/el:n	(Lc/t/m/g/el;)J
    //   708: lsub
    //   709: aload_0
    //   710: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   713: invokestatic 210	c/t/m/g/el:m	(Lc/t/m/g/el;)J
    //   716: lcmp
    //   717: iflt +2052 -> 2769
    //   720: aload_0
    //   721: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   724: invokestatic 199	java/lang/System:currentTimeMillis	()J
    //   727: invokestatic 216	c/t/m/g/el:a	(Lc/t/m/g/el;J)J
    //   730: pop2
    //   731: iconst_0
    //   732: istore 9
    //   734: aload_1
    //   735: getfield 220	android/os/Message:obj	Ljava/lang/Object;
    //   738: ifnull +23 -> 761
    //   741: new 103	java/lang/StringBuilder
    //   744: dup
    //   745: ldc 222
    //   747: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   750: aload_1
    //   751: getfield 220	android/os/Message:obj	Ljava/lang/Object;
    //   754: invokevirtual 228	java/lang/Object:toString	()Ljava/lang/String;
    //   757: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload_0
    //   762: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   765: invokestatic 231	c/t/m/g/el:p	(Lc/t/m/g/el;)I
    //   768: istore_3
    //   769: aload_0
    //   770: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   773: invokestatic 235	c/t/m/g/el:q	(Lc/t/m/g/el;)Lc/t/m/g/ew;
    //   776: astore 13
    //   778: aload_0
    //   779: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   782: invokestatic 238	c/t/m/g/el:r	(Lc/t/m/g/el;)Ljava/lang/String;
    //   785: astore_1
    //   786: aload_0
    //   787: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   790: invokestatic 242	c/t/m/g/el:s	(Lc/t/m/g/el;)Lc/t/m/g/ea;
    //   793: astore 15
    //   795: aload_0
    //   796: getfield 21	c/t/m/g/el$a:b	Z
    //   799: ifeq +195 -> 994
    //   802: iload 11
    //   804: ifne +190 -> 994
    //   807: iconst_1
    //   808: istore 10
    //   810: aload 13
    //   812: iload 4
    //   814: aload_1
    //   815: aload 15
    //   817: iload 10
    //   819: aload_0
    //   820: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   823: invokestatic 245	c/t/m/g/el:t	(Lc/t/m/g/el;)Z
    //   826: iload 11
    //   828: invokevirtual 250	c/t/m/g/ew:a	(ILjava/lang/String;Lc/t/m/g/ea;ZZZ)Ljava/lang/String;
    //   831: astore_1
    //   832: new 103	java/lang/StringBuilder
    //   835: dup
    //   836: ldc 252
    //   838: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   841: iload 9
    //   843: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   846: ldc_w 257
    //   849: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: aload_1
    //   853: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload_1
    //   858: invokestatic 259	c/t/m/g/fp:a	(Ljava/lang/String;)Z
    //   861: ifne +139 -> 1000
    //   864: iconst_1
    //   865: istore_2
    //   866: iload_2
    //   867: ifeq +138 -> 1005
    //   870: aload_0
    //   871: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   874: invokestatic 177	c/t/m/g/el:j	(Lc/t/m/g/el;)Z
    //   877: istore 9
    //   879: new 103	java/lang/StringBuilder
    //   882: dup
    //   883: ldc 252
    //   885: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   888: iload 9
    //   890: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   893: ldc_w 261
    //   896: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: aload_1
    //   900: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: pop
    //   904: iload 9
    //   906: ifne +1863 -> 2769
    //   909: aload_0
    //   910: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   913: iconst_2
    //   914: getstatic 264	c/t/m/g/fi:a	Lc/t/m/g/fi;
    //   917: invokestatic 267	c/t/m/g/el:a	(Lc/t/m/g/el;ILc/t/m/g/fi;)V
    //   920: return
    //   921: aload_0
    //   922: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   925: invokestatic 177	c/t/m/g/el:j	(Lc/t/m/g/el;)Z
    //   928: istore 9
    //   930: aload_0
    //   931: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   934: invokestatic 181	c/t/m/g/el:k	(Lc/t/m/g/el;)Lc/t/m/g/es;
    //   937: iload 9
    //   939: putfield 185	c/t/m/g/es:d	Z
    //   942: iload 9
    //   944: ifeq +1822 -> 2766
    //   947: lload 5
    //   949: ldc2_w 186
    //   952: lcmp
    //   953: ifle +1813 -> 2766
    //   956: invokestatic 199	java/lang/System:currentTimeMillis	()J
    //   959: lstore 7
    //   961: lload 7
    //   963: aload_0
    //   964: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   967: invokestatic 270	c/t/m/g/el:o	(Lc/t/m/g/el;)J
    //   970: lsub
    //   971: lload 5
    //   973: ldc2_w 188
    //   976: lsub
    //   977: lcmp
    //   978: iflt +1791 -> 2769
    //   981: aload_0
    //   982: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   985: lload 7
    //   987: invokestatic 272	c/t/m/g/el:b	(Lc/t/m/g/el;J)J
    //   990: pop2
    //   991: goto -257 -> 734
    //   994: iconst_0
    //   995: istore 10
    //   997: goto -187 -> 810
    //   1000: iconst_0
    //   1001: istore_2
    //   1002: goto -136 -> 866
    //   1005: iload 11
    //   1007: ifne +80 -> 1087
    //   1010: aload 14
    //   1012: invokestatic 278	com/tencent/map/geolocation/internal/TencentExtraKeys:isRequestRawData	(Lcom/tencent/map/geolocation/TencentLocationRequest;)Z
    //   1015: ifeq +72 -> 1087
    //   1018: new 280	c/t/m/g/fi$a
    //   1021: dup
    //   1022: invokespecial 282	c/t/m/g/fi$a:<init>	()V
    //   1025: astore 13
    //   1027: aload 13
    //   1029: aconst_null
    //   1030: putfield 284	c/t/m/g/fi$a:b	Lc/t/m/g/fi;
    //   1033: aload 13
    //   1035: iload 4
    //   1037: putfield 286	c/t/m/g/fi$a:c	I
    //   1040: aload 13
    //   1042: invokevirtual 289	c/t/m/g/fi$a:a	()Lc/t/m/g/fi;
    //   1045: astore 13
    //   1047: aload 13
    //   1049: aload_1
    //   1050: invokevirtual 293	java/lang/String:getBytes	()[B
    //   1053: invokestatic 297	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawData	(Lcom/tencent/map/geolocation/TencentLocation;[B)Lcom/tencent/map/geolocation/TencentLocation;
    //   1056: pop
    //   1057: aload_0
    //   1058: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1061: aload 13
    //   1063: invokestatic 101	c/t/m/g/el:a	(Lc/t/m/g/el;Lc/t/m/g/fi;)V
    //   1066: aload 12
    //   1068: aload 13
    //   1070: iconst_0
    //   1071: invokestatic 133	c/t/m/g/el:e	()Landroid/util/SparseArray;
    //   1074: iconst_0
    //   1075: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1078: checkcast 95	java/lang/String
    //   1081: invokeinterface 145 4 0
    //   1086: return
    //   1087: new 103	java/lang/StringBuilder
    //   1090: dup
    //   1091: ldc_w 299
    //   1094: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1097: invokestatic 199	java/lang/System:currentTimeMillis	()J
    //   1100: invokestatic 201	c/t/m/g/el:f	()J
    //   1103: lsub
    //   1104: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1107: pop
    //   1108: aload_0
    //   1109: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1112: invokestatic 302	c/t/m/g/el:u	(Lc/t/m/g/el;)Lc/t/m/g/ew;
    //   1115: astore 12
    //   1117: aload 12
    //   1119: ifnull +159 -> 1278
    //   1122: aload 12
    //   1124: invokevirtual 305	c/t/m/g/ew:b	()Z
    //   1127: ifeq +92 -> 1219
    //   1130: aload 13
    //   1132: invokevirtual 305	c/t/m/g/ew:b	()Z
    //   1135: ifeq +84 -> 1219
    //   1138: aload 13
    //   1140: getfield 308	c/t/m/g/ew:b	Lc/t/m/g/ey;
    //   1143: aload 12
    //   1145: getfield 308	c/t/m/g/ew:b	Lc/t/m/g/ey;
    //   1148: invokevirtual 313	c/t/m/g/ey:a	(Lc/t/m/g/ey;)Z
    //   1151: ifeq +68 -> 1219
    //   1154: iconst_2
    //   1155: istore_2
    //   1156: aload_0
    //   1157: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1160: invokestatic 130	c/t/m/g/el:f	(Lc/t/m/g/el;)I
    //   1163: ifne +120 -> 1283
    //   1166: aload_0
    //   1167: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1170: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   1173: ifnull +110 -> 1283
    //   1176: iload_2
    //   1177: iconst_1
    //   1178: if_icmpeq +25 -> 1203
    //   1181: iload_2
    //   1182: iconst_2
    //   1183: if_icmplt +100 -> 1283
    //   1186: aload_0
    //   1187: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1190: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   1193: invokevirtual 317	c/t/m/g/fi:getAccuracy	()F
    //   1196: ldc_w 318
    //   1199: fcmpg
    //   1200: ifge +83 -> 1283
    //   1203: aload_0
    //   1204: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1207: iconst_0
    //   1208: aload_0
    //   1209: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1212: invokestatic 87	c/t/m/g/el:d	(Lc/t/m/g/el;)Lc/t/m/g/fi;
    //   1215: invokestatic 267	c/t/m/g/el:a	(Lc/t/m/g/el;ILc/t/m/g/fi;)V
    //   1218: return
    //   1219: aload 12
    //   1221: invokevirtual 305	c/t/m/g/ew:b	()Z
    //   1224: ifne +54 -> 1278
    //   1227: aload 13
    //   1229: invokevirtual 305	c/t/m/g/ew:b	()Z
    //   1232: ifne +46 -> 1278
    //   1235: aload 12
    //   1237: invokevirtual 320	c/t/m/g/ew:a	()Z
    //   1240: ifeq +38 -> 1278
    //   1243: aload 13
    //   1245: invokevirtual 320	c/t/m/g/ew:a	()Z
    //   1248: ifeq +30 -> 1278
    //   1251: aload 13
    //   1253: getfield 323	c/t/m/g/ew:c	Lc/t/m/g/eu;
    //   1256: invokevirtual 327	c/t/m/g/eu:c	()Ljava/lang/String;
    //   1259: aload 12
    //   1261: getfield 323	c/t/m/g/ew:c	Lc/t/m/g/eu;
    //   1264: invokevirtual 327	c/t/m/g/eu:c	()Ljava/lang/String;
    //   1267: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1270: ifeq +8 -> 1278
    //   1273: iconst_1
    //   1274: istore_2
    //   1275: goto -119 -> 1156
    //   1278: iconst_0
    //   1279: istore_2
    //   1280: goto -124 -> 1156
    //   1283: aload_0
    //   1284: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1287: invokestatic 331	c/t/m/g/el:v	(Lc/t/m/g/el;)Lc/t/m/g/eq;
    //   1290: astore 12
    //   1292: aload_1
    //   1293: ldc_w 333
    //   1296: invokevirtual 336	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1299: invokestatic 341	c/t/m/g/co:c	([B)[B
    //   1302: astore 14
    //   1304: new 343	c/t/m/g/eq$a
    //   1307: dup
    //   1308: iconst_1
    //   1309: aload 14
    //   1311: aload 14
    //   1313: iload_3
    //   1314: invokestatic 348	c/t/m/g/eq:a	([BI)Ljava/lang/String;
    //   1317: aload 13
    //   1319: invokespecial 351	c/t/m/g/eq$a:<init>	(I[BLjava/lang/String;Ljava/lang/Object;)V
    //   1322: astore 13
    //   1324: aload 13
    //   1326: aload_1
    //   1327: putfield 354	c/t/m/g/eq$a:b	Ljava/lang/String;
    //   1330: aload 13
    //   1332: invokestatic 357	c/t/m/g/eq$a:a	(Lc/t/m/g/eq$a;)[B
    //   1335: ifnull +1434 -> 2769
    //   1338: aload 12
    //   1340: getfield 360	c/t/m/g/eq:a	Ljava/util/concurrent/LinkedBlockingQueue;
    //   1343: aload 13
    //   1345: invokevirtual 366	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
    //   1348: pop
    //   1349: return
    //   1350: astore_1
    //   1351: return
    //   1352: aload_0
    //   1353: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1356: invokestatic 235	c/t/m/g/el:q	(Lc/t/m/g/el;)Lc/t/m/g/ew;
    //   1359: astore 13
    //   1361: aload 13
    //   1363: iload 4
    //   1365: aload_0
    //   1366: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1369: invokestatic 238	c/t/m/g/el:r	(Lc/t/m/g/el;)Ljava/lang/String;
    //   1372: aload_0
    //   1373: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1376: invokestatic 242	c/t/m/g/el:s	(Lc/t/m/g/el;)Lc/t/m/g/ea;
    //   1379: iconst_1
    //   1380: iconst_0
    //   1381: iconst_0
    //   1382: invokevirtual 250	c/t/m/g/ew:a	(ILjava/lang/String;Lc/t/m/g/ea;ZZZ)Ljava/lang/String;
    //   1385: astore_1
    //   1386: aload_1
    //   1387: invokestatic 259	c/t/m/g/fp:a	(Ljava/lang/String;)Z
    //   1390: ifne +131 -> 1521
    //   1393: iconst_1
    //   1394: istore_2
    //   1395: iload_2
    //   1396: ifne +1373 -> 2769
    //   1399: aload_0
    //   1400: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1403: invokestatic 331	c/t/m/g/el:v	(Lc/t/m/g/el;)Lc/t/m/g/eq;
    //   1406: astore 12
    //   1408: aload_0
    //   1409: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1412: invokestatic 231	c/t/m/g/el:p	(Lc/t/m/g/el;)I
    //   1415: istore_2
    //   1416: invokestatic 371	android/os/SystemClock:elapsedRealtime	()J
    //   1419: lstore 5
    //   1421: aload_1
    //   1422: ldc_w 333
    //   1425: invokevirtual 336	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1428: invokestatic 341	c/t/m/g/co:c	([B)[B
    //   1431: astore 14
    //   1433: new 343	c/t/m/g/eq$a
    //   1436: dup
    //   1437: iconst_3
    //   1438: aload 14
    //   1440: aload 14
    //   1442: iload_2
    //   1443: invokestatic 348	c/t/m/g/eq:a	([BI)Ljava/lang/String;
    //   1446: aload 13
    //   1448: invokespecial 351	c/t/m/g/eq$a:<init>	(I[BLjava/lang/String;Ljava/lang/Object;)V
    //   1451: astore 13
    //   1453: aload 13
    //   1455: aload_1
    //   1456: putfield 354	c/t/m/g/eq$a:b	Ljava/lang/String;
    //   1459: iconst_0
    //   1460: istore 9
    //   1462: aload 13
    //   1464: invokestatic 357	c/t/m/g/eq$a:a	(Lc/t/m/g/eq$a;)[B
    //   1467: ifnull +23 -> 1490
    //   1470: aload 12
    //   1472: getfield 360	c/t/m/g/eq:a	Ljava/util/concurrent/LinkedBlockingQueue;
    //   1475: invokevirtual 374	java/util/concurrent/LinkedBlockingQueue:clear	()V
    //   1478: aload 12
    //   1480: getfield 360	c/t/m/g/eq:a	Ljava/util/concurrent/LinkedBlockingQueue;
    //   1483: aload 13
    //   1485: invokevirtual 366	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
    //   1488: istore 9
    //   1490: iload 9
    //   1492: ifeq +10 -> 1502
    //   1495: aload 12
    //   1497: lload 5
    //   1499: putfield 377	c/t/m/g/eq:h	J
    //   1502: aload_0
    //   1503: sipush 3998
    //   1506: aload_0
    //   1507: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1510: invokestatic 48	c/t/m/g/el:c	(Lc/t/m/g/el;)Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1513: invokevirtual 380	com/tencent/map/geolocation/TencentLocationRequest:getCheckInterval	()J
    //   1516: invokevirtual 174	c/t/m/g/el$a:sendEmptyMessageDelayed	(IJ)Z
    //   1519: pop
    //   1520: return
    //   1521: iconst_0
    //   1522: istore_2
    //   1523: goto -128 -> 1395
    //   1526: aload_0
    //   1527: sipush 4998
    //   1530: invokevirtual 384	c/t/m/g/el$a:removeMessages	(I)V
    //   1533: aload_0
    //   1534: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1537: invokestatic 48	c/t/m/g/el:c	(Lc/t/m/g/el;)Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1540: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   1543: ldc 64
    //   1545: invokevirtual 70	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   1548: ifeq +13 -> 1561
    //   1551: aload_0
    //   1552: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1555: iconst_1
    //   1556: invokestatic 387	c/t/m/g/el:a	(Lc/t/m/g/el;Z)Z
    //   1559: pop
    //   1560: return
    //   1561: new 103	java/lang/StringBuilder
    //   1564: dup
    //   1565: ldc_w 389
    //   1568: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1571: invokestatic 199	java/lang/System:currentTimeMillis	()J
    //   1574: invokestatic 201	c/t/m/g/el:f	()J
    //   1577: lsub
    //   1578: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1581: pop
    //   1582: aload_1
    //   1583: getfield 220	android/os/Message:obj	Ljava/lang/Object;
    //   1586: checkcast 391	android/util/Pair
    //   1589: astore 13
    //   1591: aload 13
    //   1593: getfield 394	android/util/Pair:first	Ljava/lang/Object;
    //   1596: invokevirtual 228	java/lang/Object:toString	()Ljava/lang/String;
    //   1599: astore 14
    //   1601: aload 13
    //   1603: getfield 397	android/util/Pair:second	Ljava/lang/Object;
    //   1606: checkcast 343	c/t/m/g/eq$a
    //   1609: astore 13
    //   1611: aload 13
    //   1613: getfield 399	c/t/m/g/eq$a:a	Ljava/lang/Object;
    //   1616: checkcast 247	c/t/m/g/ew
    //   1619: astore 15
    //   1621: aload_0
    //   1622: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1625: aload 15
    //   1627: invokestatic 402	c/t/m/g/el:a	(Lc/t/m/g/el;Lc/t/m/g/ew;)Lc/t/m/g/ew;
    //   1630: pop
    //   1631: aload 13
    //   1633: getfield 354	c/t/m/g/eq$a:b	Ljava/lang/String;
    //   1636: astore 15
    //   1638: new 280	c/t/m/g/fi$a
    //   1641: dup
    //   1642: invokespecial 282	c/t/m/g/fi$a:<init>	()V
    //   1645: astore 13
    //   1647: aload 13
    //   1649: aload 14
    //   1651: putfield 404	c/t/m/g/fi$a:a	Ljava/lang/String;
    //   1654: aload 13
    //   1656: iload 4
    //   1658: putfield 286	c/t/m/g/fi$a:c	I
    //   1661: aload 13
    //   1663: invokevirtual 289	c/t/m/g/fi$a:a	()Lc/t/m/g/fi;
    //   1666: astore 13
    //   1668: aload 13
    //   1670: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   1673: ldc_w 409
    //   1676: aload 14
    //   1678: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1681: aload 13
    //   1683: invokestatic 416	c/t/m/g/fi:a	(Lc/t/m/g/fi;)V
    //   1686: aload 13
    //   1688: aload_0
    //   1689: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1692: invokestatic 420	c/t/m/g/el:w	(Lc/t/m/g/el;)Lc/t/m/g/eu;
    //   1695: iconst_0
    //   1696: invokestatic 423	c/t/m/g/fi:a	(Lc/t/m/g/fi;Lc/t/m/g/eu;Z)Lc/t/m/g/fi;
    //   1699: pop
    //   1700: aload 13
    //   1702: aload 15
    //   1704: invokestatic 427	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawQuery	(Lcom/tencent/map/geolocation/TencentLocation;Ljava/lang/String;)V
    //   1707: aload 13
    //   1709: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   1712: ldc_w 429
    //   1715: aload_1
    //   1716: getfield 432	android/os/Message:arg1	I
    //   1719: i2l
    //   1720: invokevirtual 436	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1723: getstatic 439	com/tencent/map/geolocation/internal/TencentExtraKeys:COMPHTTPIO	Z
    //   1726: ifeq +19 -> 1745
    //   1729: aload 13
    //   1731: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   1734: ldc_w 441
    //   1737: aload_1
    //   1738: getfield 444	android/os/Message:arg2	I
    //   1741: i2l
    //   1742: invokevirtual 436	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1745: aload_0
    //   1746: iconst_0
    //   1747: putfield 21	c/t/m/g/el$a:b	Z
    //   1750: aload 13
    //   1752: invokevirtual 447	c/t/m/g/fi:getVerifyKey	()Ljava/lang/String;
    //   1755: ifnull +235 -> 1990
    //   1758: aload 13
    //   1760: invokevirtual 447	c/t/m/g/fi:getVerifyKey	()Ljava/lang/String;
    //   1763: ldc_w 449
    //   1766: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1769: ifne +221 -> 1990
    //   1772: aload 15
    //   1774: ifnull +116 -> 1890
    //   1777: new 451	org/json/JSONObject
    //   1780: dup
    //   1781: aload 15
    //   1783: invokespecial 452	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1786: astore_1
    //   1787: aload_1
    //   1788: ldc_w 454
    //   1791: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1794: pop
    //   1795: aload_1
    //   1796: ldc_w 460
    //   1799: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1802: pop
    //   1803: aload_1
    //   1804: ldc_w 462
    //   1807: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1810: pop
    //   1811: aload_1
    //   1812: ldc_w 464
    //   1815: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1818: pop
    //   1819: aload_1
    //   1820: ldc_w 466
    //   1823: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1826: pop
    //   1827: aload_1
    //   1828: ldc_w 468
    //   1831: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1834: pop
    //   1835: aload_1
    //   1836: ldc_w 470
    //   1839: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1842: pop
    //   1843: aload_1
    //   1844: ldc_w 472
    //   1847: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1850: pop
    //   1851: aload_1
    //   1852: ldc_w 474
    //   1855: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1858: pop
    //   1859: aload_1
    //   1860: ldc_w 476
    //   1863: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1866: pop
    //   1867: aload_1
    //   1868: ldc_w 478
    //   1871: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   1874: pop
    //   1875: aload 13
    //   1877: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   1880: ldc_w 480
    //   1883: aload_1
    //   1884: invokevirtual 481	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1887: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1890: aload 13
    //   1892: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   1895: ldc_w 483
    //   1898: aload_0
    //   1899: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1902: invokestatic 487	c/t/m/g/el:x	(Lc/t/m/g/el;)Lc/t/m/g/em;
    //   1905: invokevirtual 491	c/t/m/g/em:e	()Ljava/lang/String;
    //   1908: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1911: aload 13
    //   1913: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   1916: aload_0
    //   1917: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1920: invokestatic 48	c/t/m/g/el:c	(Lc/t/m/g/el;)Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1923: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   1926: invokevirtual 495	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   1929: aload 13
    //   1931: invokevirtual 317	c/t/m/g/fi:getAccuracy	()F
    //   1934: f2d
    //   1935: ldc2_w 496
    //   1938: dcmpl
    //   1939: ifne +266 -> 2205
    //   1942: aload_0
    //   1943: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1946: invokestatic 500	c/t/m/g/el:y	(Lc/t/m/g/el;)Z
    //   1949: ifeq +256 -> 2205
    //   1952: iconst_1
    //   1953: istore 9
    //   1955: aload 13
    //   1957: aload_0
    //   1958: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1961: invokestatic 420	c/t/m/g/el:w	(Lc/t/m/g/el;)Lc/t/m/g/eu;
    //   1964: iload 9
    //   1966: invokestatic 423	c/t/m/g/fi:a	(Lc/t/m/g/fi;Lc/t/m/g/eu;Z)Lc/t/m/g/fi;
    //   1969: pop
    //   1970: aload 12
    //   1972: aload 13
    //   1974: iconst_0
    //   1975: invokestatic 133	c/t/m/g/el:e	()Landroid/util/SparseArray;
    //   1978: iconst_0
    //   1979: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1982: checkcast 95	java/lang/String
    //   1985: invokeinterface 145 4 0
    //   1990: aload_0
    //   1991: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   1994: iconst_1
    //   1995: invokestatic 387	c/t/m/g/el:a	(Lc/t/m/g/el;Z)Z
    //   1998: pop
    //   1999: aload_0
    //   2000: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2003: invokestatic 177	c/t/m/g/el:j	(Lc/t/m/g/el;)Z
    //   2006: ifne +54 -> 2060
    //   2009: aload 13
    //   2011: aconst_null
    //   2012: putfield 502	c/t/m/g/fi:c	Ljava/lang/String;
    //   2015: aload 13
    //   2017: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   2020: ldc_w 480
    //   2023: ldc_w 504
    //   2026: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2029: aload_0
    //   2030: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2033: iconst_0
    //   2034: aload 13
    //   2036: invokestatic 267	c/t/m/g/el:a	(Lc/t/m/g/el;ILc/t/m/g/fi;)V
    //   2039: new 103	java/lang/StringBuilder
    //   2042: dup
    //   2043: ldc_w 389
    //   2046: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2049: invokestatic 199	java/lang/System:currentTimeMillis	()J
    //   2052: invokestatic 201	c/t/m/g/el:f	()J
    //   2055: lsub
    //   2056: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2059: pop
    //   2060: aload_0
    //   2061: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2064: invokestatic 245	c/t/m/g/el:t	(Lc/t/m/g/el;)Z
    //   2067: ifeq +59 -> 2126
    //   2070: aload 13
    //   2072: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   2075: astore_1
    //   2076: aload_1
    //   2077: ifnull +41 -> 2118
    //   2080: aload_1
    //   2081: ldc_w 506
    //   2084: iconst_m1
    //   2085: invokevirtual 510	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2088: istore_2
    //   2089: aload_0
    //   2090: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2093: invokestatic 242	c/t/m/g/el:s	(Lc/t/m/g/el;)Lc/t/m/g/ea;
    //   2096: getfield 515	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   2099: invokeinterface 521 1 0
    //   2104: ldc_w 466
    //   2107: iload_2
    //   2108: invokeinterface 527 3 0
    //   2113: invokeinterface 530 1 0
    //   2118: aload_0
    //   2119: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2122: invokestatic 533	c/t/m/g/el:z	(Lc/t/m/g/el;)Z
    //   2125: pop
    //   2126: aload_0
    //   2127: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2130: aload 13
    //   2132: invokestatic 536	c/t/m/g/el:b	(Lc/t/m/g/el;Lc/t/m/g/fi;)Lc/t/m/g/fi;
    //   2135: pop
    //   2136: aload_0
    //   2137: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2140: invokestatic 539	c/t/m/g/el:A	(Lc/t/m/g/el;)Z
    //   2143: ifne +17 -> 2160
    //   2146: invokestatic 544	c/t/m/g/cz:a	()Lc/t/m/g/cz;
    //   2149: invokevirtual 546	c/t/m/g/cz:b	()V
    //   2152: aload_0
    //   2153: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2156: invokestatic 549	c/t/m/g/el:B	(Lc/t/m/g/el;)Z
    //   2159: pop
    //   2160: aload_0
    //   2161: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2164: invokestatic 331	c/t/m/g/el:v	(Lc/t/m/g/el;)Lc/t/m/g/eq;
    //   2167: aload_0
    //   2168: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2171: invokestatic 242	c/t/m/g/el:s	(Lc/t/m/g/el;)Lc/t/m/g/ea;
    //   2174: iconst_0
    //   2175: invokevirtual 552	c/t/m/g/ea:a	(Z)Ljava/lang/String;
    //   2178: invokevirtual 554	c/t/m/g/eq:a	(Ljava/lang/String;)V
    //   2181: return
    //   2182: astore_1
    //   2183: aload_0
    //   2184: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2187: invokestatic 192	c/t/m/g/el:l	(Lc/t/m/g/el;)Z
    //   2190: ifeq +579 -> 2769
    //   2193: aload_0
    //   2194: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2197: iconst_2
    //   2198: getstatic 264	c/t/m/g/fi:a	Lc/t/m/g/fi;
    //   2201: invokestatic 267	c/t/m/g/el:a	(Lc/t/m/g/el;ILc/t/m/g/fi;)V
    //   2204: return
    //   2205: iconst_0
    //   2206: istore 9
    //   2208: goto -253 -> 1955
    //   2211: astore_1
    //   2212: new 103	java/lang/StringBuilder
    //   2215: dup
    //   2216: ldc_w 556
    //   2219: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2222: aload_1
    //   2223: invokevirtual 559	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2226: pop
    //   2227: goto -109 -> 2118
    //   2230: aload_1
    //   2231: getfield 220	android/os/Message:obj	Ljava/lang/Object;
    //   2234: checkcast 391	android/util/Pair
    //   2237: astore 13
    //   2239: aload 13
    //   2241: getfield 394	android/util/Pair:first	Ljava/lang/Object;
    //   2244: invokevirtual 228	java/lang/Object:toString	()Ljava/lang/String;
    //   2247: astore_1
    //   2248: aload 13
    //   2250: getfield 397	android/util/Pair:second	Ljava/lang/Object;
    //   2253: checkcast 343	c/t/m/g/eq$a
    //   2256: astore 13
    //   2258: aload 13
    //   2260: getfield 399	c/t/m/g/eq$a:a	Ljava/lang/Object;
    //   2263: checkcast 247	c/t/m/g/ew
    //   2266: astore 14
    //   2268: aload 13
    //   2270: getfield 354	c/t/m/g/eq$a:b	Ljava/lang/String;
    //   2273: astore 15
    //   2275: aload_0
    //   2276: iconst_0
    //   2277: putfield 19	c/t/m/g/el$a:a	I
    //   2280: new 280	c/t/m/g/fi$a
    //   2283: dup
    //   2284: invokespecial 282	c/t/m/g/fi$a:<init>	()V
    //   2287: astore 13
    //   2289: aload 13
    //   2291: aload_1
    //   2292: putfield 404	c/t/m/g/fi$a:a	Ljava/lang/String;
    //   2295: aload 13
    //   2297: iload 4
    //   2299: putfield 286	c/t/m/g/fi$a:c	I
    //   2302: aload 13
    //   2304: invokevirtual 289	c/t/m/g/fi$a:a	()Lc/t/m/g/fi;
    //   2307: astore 13
    //   2309: aload 13
    //   2311: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   2314: ldc_w 409
    //   2317: aload_1
    //   2318: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2321: aload 13
    //   2323: invokestatic 416	c/t/m/g/fi:a	(Lc/t/m/g/fi;)V
    //   2326: aload 13
    //   2328: invokevirtual 317	c/t/m/g/fi:getAccuracy	()F
    //   2331: f2d
    //   2332: ldc2_w 496
    //   2335: dcmpl
    //   2336: ifne +320 -> 2656
    //   2339: aload_0
    //   2340: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2343: invokestatic 500	c/t/m/g/el:y	(Lc/t/m/g/el;)Z
    //   2346: ifeq +310 -> 2656
    //   2349: iconst_1
    //   2350: istore 9
    //   2352: aload 13
    //   2354: aload_0
    //   2355: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2358: invokestatic 420	c/t/m/g/el:w	(Lc/t/m/g/el;)Lc/t/m/g/eu;
    //   2361: iload 9
    //   2363: invokestatic 423	c/t/m/g/fi:a	(Lc/t/m/g/fi;Lc/t/m/g/eu;Z)Lc/t/m/g/fi;
    //   2366: pop
    //   2367: aload 13
    //   2369: aload 15
    //   2371: invokestatic 427	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawQuery	(Lcom/tencent/map/geolocation/TencentLocation;Ljava/lang/String;)V
    //   2374: iconst_0
    //   2375: istore_2
    //   2376: aload 14
    //   2378: getfield 562	c/t/m/g/ew:d	Lc/t/m/g/ev;
    //   2381: ifnull +12 -> 2393
    //   2384: aload 14
    //   2386: getfield 562	c/t/m/g/ew:d	Lc/t/m/g/ev;
    //   2389: getfield 565	c/t/m/g/ev:c	I
    //   2392: istore_2
    //   2393: aload 13
    //   2395: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   2398: ldc_w 567
    //   2401: iload_2
    //   2402: invokevirtual 570	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2405: aload 13
    //   2407: invokevirtual 447	c/t/m/g/fi:getVerifyKey	()Ljava/lang/String;
    //   2410: ifnull +359 -> 2769
    //   2413: aload 13
    //   2415: invokevirtual 447	c/t/m/g/fi:getVerifyKey	()Ljava/lang/String;
    //   2418: ldc_w 449
    //   2421: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2424: ifne +345 -> 2769
    //   2427: aload 15
    //   2429: ifnull +134 -> 2563
    //   2432: new 451	org/json/JSONObject
    //   2435: dup
    //   2436: aload 15
    //   2438: invokespecial 452	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2441: astore_1
    //   2442: aload_1
    //   2443: ldc_w 454
    //   2446: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   2449: pop
    //   2450: aload_1
    //   2451: ldc_w 460
    //   2454: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   2457: pop
    //   2458: aload_1
    //   2459: ldc_w 462
    //   2462: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   2465: pop
    //   2466: aload_1
    //   2467: ldc_w 464
    //   2470: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   2473: pop
    //   2474: aload_1
    //   2475: ldc_w 466
    //   2478: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   2481: pop
    //   2482: aload_1
    //   2483: ldc_w 468
    //   2486: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   2489: pop
    //   2490: aload_1
    //   2491: ldc_w 470
    //   2494: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   2497: pop
    //   2498: aload_1
    //   2499: ldc_w 472
    //   2502: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   2505: pop
    //   2506: aload_1
    //   2507: ldc_w 474
    //   2510: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   2513: pop
    //   2514: aload_1
    //   2515: ldc_w 476
    //   2518: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   2521: pop
    //   2522: aload_1
    //   2523: ldc_w 478
    //   2526: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   2529: pop
    //   2530: aload_1
    //   2531: ldc_w 483
    //   2534: aload_0
    //   2535: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2538: invokestatic 487	c/t/m/g/el:x	(Lc/t/m/g/el;)Lc/t/m/g/em;
    //   2541: invokevirtual 491	c/t/m/g/em:e	()Ljava/lang/String;
    //   2544: invokevirtual 574	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2547: pop
    //   2548: aload 13
    //   2550: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   2553: ldc_w 480
    //   2556: aload_1
    //   2557: invokevirtual 481	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2560: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2563: aload 13
    //   2565: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   2568: ldc_w 483
    //   2571: aload_0
    //   2572: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2575: invokestatic 487	c/t/m/g/el:x	(Lc/t/m/g/el;)Lc/t/m/g/em;
    //   2578: invokevirtual 491	c/t/m/g/em:e	()Ljava/lang/String;
    //   2581: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2584: aload 13
    //   2586: invokevirtual 407	c/t/m/g/fi:getExtra	()Landroid/os/Bundle;
    //   2589: aload_0
    //   2590: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2593: invokestatic 48	c/t/m/g/el:c	(Lc/t/m/g/el;)Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   2596: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   2599: invokevirtual 495	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   2602: aload_0
    //   2603: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2606: aload 13
    //   2608: invokestatic 536	c/t/m/g/el:b	(Lc/t/m/g/el;Lc/t/m/g/fi;)Lc/t/m/g/fi;
    //   2611: pop
    //   2612: aload 12
    //   2614: aload 13
    //   2616: iconst_0
    //   2617: invokestatic 133	c/t/m/g/el:e	()Landroid/util/SparseArray;
    //   2620: iconst_0
    //   2621: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   2624: checkcast 95	java/lang/String
    //   2627: invokeinterface 145 4 0
    //   2632: return
    //   2633: astore_1
    //   2634: aload_0
    //   2635: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2638: invokestatic 192	c/t/m/g/el:l	(Lc/t/m/g/el;)Z
    //   2641: ifeq +128 -> 2769
    //   2644: aload_0
    //   2645: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2648: iconst_2
    //   2649: getstatic 264	c/t/m/g/fi:a	Lc/t/m/g/fi;
    //   2652: invokestatic 267	c/t/m/g/el:a	(Lc/t/m/g/el;ILc/t/m/g/fi;)V
    //   2655: return
    //   2656: iconst_0
    //   2657: istore 9
    //   2659: goto -307 -> 2352
    //   2662: astore_1
    //   2663: aload_1
    //   2664: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   2667: goto -104 -> 2563
    //   2670: aload_0
    //   2671: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2674: iconst_0
    //   2675: invokestatic 387	c/t/m/g/el:a	(Lc/t/m/g/el;Z)Z
    //   2678: pop
    //   2679: aload_0
    //   2680: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2683: invokestatic 177	c/t/m/g/el:j	(Lc/t/m/g/el;)Z
    //   2686: ifne +83 -> 2769
    //   2689: aload_0
    //   2690: getfield 14	c/t/m/g/el$a:c	Lc/t/m/g/el;
    //   2693: iconst_1
    //   2694: getstatic 264	c/t/m/g/fi:a	Lc/t/m/g/fi;
    //   2697: invokestatic 267	c/t/m/g/el:a	(Lc/t/m/g/el;ILc/t/m/g/fi;)V
    //   2700: return
    //   2701: aload_0
    //   2702: aload_0
    //   2703: getfield 19	c/t/m/g/el$a:a	I
    //   2706: iconst_1
    //   2707: iadd
    //   2708: putfield 19	c/t/m/g/el$a:a	I
    //   2711: aload_0
    //   2712: getfield 19	c/t/m/g/el$a:a	I
    //   2715: iconst_3
    //   2716: if_icmpne +53 -> 2769
    //   2719: aload 12
    //   2721: getstatic 264	c/t/m/g/fi:a	Lc/t/m/g/fi;
    //   2724: iconst_5
    //   2725: invokestatic 133	c/t/m/g/el:e	()Landroid/util/SparseArray;
    //   2728: iconst_5
    //   2729: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   2732: checkcast 95	java/lang/String
    //   2735: invokeinterface 145 4 0
    //   2740: aload_0
    //   2741: iconst_0
    //   2742: putfield 19	c/t/m/g/el$a:a	I
    //   2745: return
    //   2746: astore_1
    //   2747: goto -145 -> 2602
    //   2750: astore_1
    //   2751: goto -633 -> 2118
    //   2754: astore_1
    //   2755: goto -826 -> 1929
    //   2758: astore_1
    //   2759: goto -869 -> 1890
    //   2762: astore_1
    //   2763: goto -1261 -> 1502
    //   2766: goto -2032 -> 734
    //   2769: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2770	0	this	a
    //   0	2770	1	paramMessage	android.os.Message
    //   865	1537	2	i	int
    //   768	546	3	j	int
    //   52	2246	4	k	int
    //   59	1439	5	l1	long
    //   959	27	7	l2	long
    //   435	2223	9	bool1	boolean
    //   808	188	10	bool2	boolean
    //   71	935	11	bool3	boolean
    //   33	2687	12	localObject1	java.lang.Object
    //   7	2608	13	localObject2	java.lang.Object
    //   45	2340	14	localObject3	java.lang.Object
    //   793	1644	15	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   12	25	186	finally
    //   26	38	186	finally
    //   187	190	186	finally
    //   1292	1349	1350	java/io/UnsupportedEncodingException
    //   1638	1686	2182	org/json/JSONException
    //   2070	2076	2211	java/lang/Exception
    //   2080	2118	2211	java/lang/Exception
    //   2280	2326	2633	org/json/JSONException
    //   2432	2563	2662	java/lang/Exception
    //   2563	2602	2746	java/lang/Exception
    //   2070	2076	2750	java/lang/Error
    //   2080	2118	2750	java/lang/Error
    //   1890	1929	2754	java/lang/Exception
    //   1777	1890	2758	java/lang/Exception
    //   1421	1459	2762	java/io/UnsupportedEncodingException
    //   1462	1490	2762	java/io/UnsupportedEncodingException
    //   1495	1502	2762	java/io/UnsupportedEncodingException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.el.a
 * JD-Core Version:    0.7.0.1
 */