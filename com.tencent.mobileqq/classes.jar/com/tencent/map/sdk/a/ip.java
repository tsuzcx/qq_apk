package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ip
  implements go
{
  public hi a;
  public int[] b;
  public int[] c;
  public int d;
  public GeoPoint e;
  public int f = -1;
  public int g = -1;
  private lg h;
  private boolean i = true;
  private ip.a j;
  private float k = -1.0F;
  private lv l;
  
  public ip(lv paramlv, hi paramhi)
  {
    this.l = paramlv;
    a(paramhi);
  }
  
  private ip.a c()
  {
    try
    {
      ip.a locala = this.j;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Rect a(fu paramfu)
  {
    Object localObject2 = b(paramfu);
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = new GeoPoint(((Rect)localObject2).top, ((Rect)localObject2).left);
    localObject2 = new GeoPoint(((Rect)localObject2).bottom, ((Rect)localObject2).right);
    localObject1 = paramfu.a((GeoPoint)localObject1);
    paramfu = paramfu.a((GeoPoint)localObject2);
    return new Rect((int)((DoublePoint)localObject1).x, (int)((DoublePoint)localObject1).y, (int)paramfu.x, (int)paramfu.y);
  }
  
  public final void a()
  {
    try
    {
      this.j = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.j = new ip.a();
      this.j.a = paramInt1;
      this.j.b = paramInt2;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt, GeoPoint paramGeoPoint)
  {
    this.d = paramInt;
    this.e = paramGeoPoint;
  }
  
  public final void a(hi paramhi)
  {
    if (paramhi == null) {
      try
      {
        throw new IllegalArgumentException("LineOptions不能为空！");
      }
      finally {}
    }
    if ((paramhi.b == null) || (paramhi.b.size() < 2)) {
      throw new IllegalArgumentException("LineOptions中点的个数不能小于2");
    }
    if ((paramhi.c == null) || (paramhi.c.length <= 0)) {
      throw new IllegalArgumentException("参数startIndexes不能为空!");
    }
    if ((paramhi.d == null) || (paramhi.d.length <= 0)) {
      throw new IllegalArgumentException("参数colors不能为空!");
    }
    this.a = paramhi;
    this.b = paramhi.c;
    this.c = paramhi.d;
    this.f = -1;
  }
  
  /* Error */
  public final void a(javax.microedition.khronos.opengles.GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/tencent/map/sdk/a/ip:l	Lcom/tencent/map/sdk/a/lv;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: aload_0
    //   10: getfield 43	com/tencent/map/sdk/a/ip:l	Lcom/tencent/map/sdk/a/lv;
    //   13: getfield 139	com/tencent/map/sdk/a/lv:a	Lcom/tencent/map/sdk/a/lg;
    //   16: putfield 141	com/tencent/map/sdk/a/ip:h	Lcom/tencent/map/sdk/a/lg;
    //   19: aload_0
    //   20: getfield 43	com/tencent/map/sdk/a/ip:l	Lcom/tencent/map/sdk/a/lv;
    //   23: getfield 139	com/tencent/map/sdk/a/lv:a	Lcom/tencent/map/sdk/a/lg;
    //   26: invokeinterface 146 1 0
    //   31: getfield 151	com/tencent/map/sdk/a/kl:i	Lcom/tencent/map/sdk/a/kc;
    //   34: getfield 156	com/tencent/map/sdk/a/kc:b	Lcom/tencent/map/sdk/a/kc$a;
    //   37: getfield 160	com/tencent/map/sdk/a/kc$a:e	F
    //   40: fstore_2
    //   41: aload_0
    //   42: getfield 39	com/tencent/map/sdk/a/ip:k	F
    //   45: ldc 37
    //   47: fcmpl
    //   48: ifeq +12 -> 60
    //   51: aload_0
    //   52: getfield 39	com/tencent/map/sdk/a/ip:k	F
    //   55: fload_2
    //   56: fcmpl
    //   57: ifeq +8 -> 65
    //   60: aload_0
    //   61: fload_2
    //   62: putfield 39	com/tencent/map/sdk/a/ip:k	F
    //   65: aload_0
    //   66: getfield 43	com/tencent/map/sdk/a/ip:l	Lcom/tencent/map/sdk/a/lv;
    //   69: astore_1
    //   70: aload_1
    //   71: getfield 163	com/tencent/map/sdk/a/lv:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   74: aload_0
    //   75: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   78: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: invokevirtual 175	java/util/concurrent/CopyOnWriteArrayList:contains	(Ljava/lang/Object;)Z
    //   84: ifne +176 -> 260
    //   87: aload_1
    //   88: getfield 139	com/tencent/map/sdk/a/lv:a	Lcom/tencent/map/sdk/a/lg;
    //   91: instanceof 177
    //   94: ifeq +53 -> 147
    //   97: aload_0
    //   98: ifnull +49 -> 147
    //   101: aload_0
    //   102: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   105: getfield 180	com/tencent/map/sdk/a/hi:n	Z
    //   108: ifne +39 -> 147
    //   111: aload_1
    //   112: getfield 139	com/tencent/map/sdk/a/lv:a	Lcom/tencent/map/sdk/a/lg;
    //   115: checkcast 177	com/tencent/map/sdk/a/lw
    //   118: getfield 183	com/tencent/map/sdk/a/lw:l	Landroid/content/Context;
    //   121: astore 9
    //   123: aload_0
    //   124: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   127: getfield 185	com/tencent/map/sdk/a/hi:j	F
    //   130: fstore_2
    //   131: aload 9
    //   133: invokestatic 190	com/tencent/map/sdk/a/pz:a	(Landroid/content/Context;)F
    //   136: fstore_3
    //   137: aload_0
    //   138: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   141: fload_3
    //   142: fload_2
    //   143: fmul
    //   144: putfield 185	com/tencent/map/sdk/a/hi:j	F
    //   147: aload_0
    //   148: ifnull +344 -> 492
    //   151: aload_1
    //   152: getfield 139	com/tencent/map/sdk/a/lv:a	Lcom/tencent/map/sdk/a/lg;
    //   155: invokeinterface 193 1 0
    //   160: aload_0
    //   161: invokevirtual 198	com/tencent/map/sdk/a/pf:a	(Lcom/tencent/map/sdk/a/ip;)I
    //   164: istore 5
    //   166: aload_0
    //   167: iload 5
    //   169: putfield 36	com/tencent/map/sdk/a/ip:f	I
    //   172: iload 5
    //   174: istore 4
    //   176: aload_1
    //   177: getfield 163	com/tencent/map/sdk/a/lv:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   180: iload 5
    //   182: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: invokevirtual 175	java/util/concurrent/CopyOnWriteArrayList:contains	(Ljava/lang/Object;)Z
    //   188: ifne +36 -> 224
    //   191: aload_1
    //   192: getfield 163	com/tencent/map/sdk/a/lv:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   195: iload 5
    //   197: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: invokevirtual 201	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   203: pop
    //   204: aload_1
    //   205: getfield 204	com/tencent/map/sdk/a/lv:f	Landroid/util/SparseBooleanArray;
    //   208: iload 5
    //   210: aload_0
    //   211: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   214: getfield 180	com/tencent/map/sdk/a/hi:n	Z
    //   217: invokevirtual 210	android/util/SparseBooleanArray:append	(IZ)V
    //   220: iload 5
    //   222: istore 4
    //   224: aload_0
    //   225: iload 4
    //   227: putfield 36	com/tencent/map/sdk/a/ip:f	I
    //   230: aload_1
    //   231: getfield 213	com/tencent/map/sdk/a/lv:b	Lcom/tencent/map/sdk/a/pf;
    //   234: astore 9
    //   236: aload 9
    //   238: invokevirtual 215	com/tencent/map/sdk/a/pf:y	()V
    //   241: aload 9
    //   243: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   246: lstore 7
    //   248: lload 7
    //   250: lconst_0
    //   251: lcmp
    //   252: ifne +246 -> 498
    //   255: aload 9
    //   257: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   260: aload_1
    //   261: getfield 223	com/tencent/map/sdk/a/lv:g	Ljava/util/ArrayList;
    //   264: aload_0
    //   265: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   268: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: invokevirtual 224	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   274: ifne +18 -> 292
    //   277: aload_1
    //   278: getfield 223	com/tencent/map/sdk/a/lv:g	Ljava/util/ArrayList;
    //   281: aload_0
    //   282: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   285: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: invokevirtual 225	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   291: pop
    //   292: aload_1
    //   293: getfield 213	com/tencent/map/sdk/a/lv:b	Lcom/tencent/map/sdk/a/pf;
    //   296: astore 9
    //   298: aload 9
    //   300: invokevirtual 215	com/tencent/map/sdk/a/pf:y	()V
    //   303: aload 9
    //   305: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   308: lstore 7
    //   310: lload 7
    //   312: lconst_0
    //   313: lcmp
    //   314: ifne +270 -> 584
    //   317: aload 9
    //   319: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   322: aload_1
    //   323: getfield 213	com/tencent/map/sdk/a/lv:b	Lcom/tencent/map/sdk/a/pf;
    //   326: astore 9
    //   328: aload 9
    //   330: invokevirtual 215	com/tencent/map/sdk/a/pf:y	()V
    //   333: aload 9
    //   335: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   338: lstore 7
    //   340: lload 7
    //   342: lconst_0
    //   343: lcmp
    //   344: ifne +336 -> 680
    //   347: aload 9
    //   349: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   352: aload_0
    //   353: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   356: getfield 228	com/tencent/map/sdk/a/hi:q	Z
    //   359: ifeq +484 -> 843
    //   362: aload_1
    //   363: getfield 213	com/tencent/map/sdk/a/lv:b	Lcom/tencent/map/sdk/a/pf;
    //   366: astore 9
    //   368: aload 9
    //   370: invokevirtual 215	com/tencent/map/sdk/a/pf:y	()V
    //   373: aload 9
    //   375: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   378: lstore 7
    //   380: lload 7
    //   382: lconst_0
    //   383: lcmp
    //   384: ifne +367 -> 751
    //   387: aload 9
    //   389: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   392: aload_1
    //   393: getfield 213	com/tencent/map/sdk/a/lv:b	Lcom/tencent/map/sdk/a/pf;
    //   396: astore 9
    //   398: aload 9
    //   400: invokevirtual 215	com/tencent/map/sdk/a/pf:y	()V
    //   403: aload 9
    //   405: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   408: lstore 7
    //   410: lload 7
    //   412: lconst_0
    //   413: lcmp
    //   414: ifne +554 -> 968
    //   417: aload 9
    //   419: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   422: aload_0
    //   423: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   426: getfield 232	com/tencent/map/sdk/a/hi:t	Ljava/lang/String;
    //   429: invokestatic 237	com/tencent/map/sdk/a/nl:a	(Ljava/lang/String;)Z
    //   432: ifne +33 -> 465
    //   435: aload_1
    //   436: getfield 213	com/tencent/map/sdk/a/lv:b	Lcom/tencent/map/sdk/a/pf;
    //   439: astore 9
    //   441: aload 9
    //   443: invokevirtual 215	com/tencent/map/sdk/a/pf:y	()V
    //   446: aload 9
    //   448: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   451: lstore 7
    //   453: lload 7
    //   455: lconst_0
    //   456: lcmp
    //   457: ifne +582 -> 1039
    //   460: aload 9
    //   462: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   465: aload_1
    //   466: getfield 213	com/tencent/map/sdk/a/lv:b	Lcom/tencent/map/sdk/a/pf;
    //   469: astore_1
    //   470: aload_1
    //   471: invokevirtual 215	com/tencent/map/sdk/a/pf:y	()V
    //   474: aload_1
    //   475: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   478: lstore 7
    //   480: lload 7
    //   482: lconst_0
    //   483: lcmp
    //   484: ifne +626 -> 1110
    //   487: aload_1
    //   488: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   491: return
    //   492: iconst_0
    //   493: istore 4
    //   495: goto -271 -> 224
    //   498: aload_0
    //   499: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   502: istore 4
    //   504: iload 4
    //   506: iconst_m1
    //   507: if_icmpne +11 -> 518
    //   510: aload 9
    //   512: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   515: goto -255 -> 260
    //   518: aload_0
    //   519: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   522: getfield 240	com/tencent/map/sdk/a/hi:v	I
    //   525: istore 5
    //   527: aload_0
    //   528: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   531: getfield 243	com/tencent/map/sdk/a/hi:w	I
    //   534: istore 6
    //   536: aload 9
    //   538: getfield 246	com/tencent/map/sdk/a/pf:f	Lcom/tencent/map/sdk/a/lw;
    //   541: new 248	com/tencent/map/sdk/a/pf$32
    //   544: dup
    //   545: aload 9
    //   547: iload 4
    //   549: iconst_2
    //   550: newarray int
    //   552: dup
    //   553: iconst_0
    //   554: iload 5
    //   556: iastore
    //   557: dup
    //   558: iconst_1
    //   559: iload 6
    //   561: iastore
    //   562: invokespecial 251	com/tencent/map/sdk/a/pf$32:<init>	(Lcom/tencent/map/sdk/a/pf;I[I)V
    //   565: invokevirtual 254	com/tencent/map/sdk/a/lw:a	(Lcom/tencent/map/sdk/a/lw$a;)V
    //   568: aload 9
    //   570: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   573: goto -313 -> 260
    //   576: astore_1
    //   577: aload 9
    //   579: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   582: aload_1
    //   583: athrow
    //   584: aload_0
    //   585: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   588: istore 4
    //   590: iload 4
    //   592: iconst_m1
    //   593: if_icmpne +11 -> 604
    //   596: aload 9
    //   598: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   601: goto -279 -> 322
    //   604: aload 9
    //   606: monitorenter
    //   607: aload_0
    //   608: invokespecial 256	com/tencent/map/sdk/a/ip:c	()Lcom/tencent/map/sdk/a/ip$a;
    //   611: astore 10
    //   613: aload 10
    //   615: ifnonnull +14 -> 629
    //   618: aload 9
    //   620: monitorexit
    //   621: aload 9
    //   623: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   626: goto -304 -> 322
    //   629: aload 9
    //   631: getfield 259	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   634: aload 9
    //   636: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   639: iload 4
    //   641: i2l
    //   642: aload 10
    //   644: getfield 94	com/tencent/map/sdk/a/ip$a:a	I
    //   647: aload 10
    //   649: getfield 96	com/tencent/map/sdk/a/ip$a:b	I
    //   652: invokevirtual 265	com/tencent/map/sdk/engine/jni/JNI:nativeSetTurnArrow	(JJII)V
    //   655: aload 9
    //   657: monitorexit
    //   658: aload 9
    //   660: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   663: goto -341 -> 322
    //   666: astore_1
    //   667: aload 9
    //   669: monitorexit
    //   670: aload_1
    //   671: athrow
    //   672: astore_1
    //   673: aload 9
    //   675: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   678: aload_1
    //   679: athrow
    //   680: aload_0
    //   681: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   684: istore 4
    //   686: iload 4
    //   688: iconst_m1
    //   689: if_icmpne +11 -> 700
    //   692: aload 9
    //   694: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   697: goto -345 -> 352
    //   700: aload 9
    //   702: monitorenter
    //   703: aload 9
    //   705: getfield 259	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   708: aload 9
    //   710: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   713: iload 4
    //   715: i2l
    //   716: aload_0
    //   717: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   720: getfield 266	com/tencent/map/sdk/a/hi:i	Z
    //   723: invokevirtual 270	com/tencent/map/sdk/engine/jni/JNI:nativeSetLineDrawArrow	(JJZ)V
    //   726: aload 9
    //   728: monitorexit
    //   729: aload 9
    //   731: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   734: goto -382 -> 352
    //   737: astore_1
    //   738: aload 9
    //   740: monitorexit
    //   741: aload_1
    //   742: athrow
    //   743: astore_1
    //   744: aload 9
    //   746: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   749: aload_1
    //   750: athrow
    //   751: aload_0
    //   752: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   755: istore 4
    //   757: iload 4
    //   759: iconst_m1
    //   760: if_icmpne +11 -> 771
    //   763: aload 9
    //   765: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   768: goto -376 -> 392
    //   771: aload 9
    //   773: monitorenter
    //   774: aload_0
    //   775: getfield 101	com/tencent/map/sdk/a/ip:e	Lcom/tencent/map/lib/basemap/data/GeoPoint;
    //   778: astore 10
    //   780: aload 10
    //   782: ifnonnull +14 -> 796
    //   785: aload 9
    //   787: monitorexit
    //   788: aload 9
    //   790: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   793: goto -401 -> 392
    //   796: aload 9
    //   798: getfield 259	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   801: aload 9
    //   803: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   806: iload 4
    //   808: i2l
    //   809: aload 10
    //   811: aload_0
    //   812: getfield 99	com/tencent/map/sdk/a/ip:d	I
    //   815: invokevirtual 274	com/tencent/map/sdk/engine/jni/JNI:nativeLineClearPoint	(JJLcom/tencent/map/lib/basemap/data/GeoPoint;I)V
    //   818: aload 9
    //   820: monitorexit
    //   821: aload 9
    //   823: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   826: goto -434 -> 392
    //   829: astore_1
    //   830: aload 9
    //   832: monitorexit
    //   833: aload_1
    //   834: athrow
    //   835: astore_1
    //   836: aload 9
    //   838: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   841: aload_1
    //   842: athrow
    //   843: aload_1
    //   844: getfield 213	com/tencent/map/sdk/a/lv:b	Lcom/tencent/map/sdk/a/pf;
    //   847: astore 9
    //   849: aload 9
    //   851: invokevirtual 215	com/tencent/map/sdk/a/pf:y	()V
    //   854: aload 9
    //   856: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   859: lstore 7
    //   861: lload 7
    //   863: lconst_0
    //   864: lcmp
    //   865: ifne +11 -> 876
    //   868: aload 9
    //   870: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   873: goto -481 -> 392
    //   876: aload_0
    //   877: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   880: istore 4
    //   882: iload 4
    //   884: iconst_m1
    //   885: if_icmpne +11 -> 896
    //   888: aload 9
    //   890: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   893: goto -501 -> 392
    //   896: aload 9
    //   898: monitorenter
    //   899: aload_0
    //   900: getfield 101	com/tencent/map/sdk/a/ip:e	Lcom/tencent/map/lib/basemap/data/GeoPoint;
    //   903: astore 10
    //   905: aload 10
    //   907: ifnonnull +14 -> 921
    //   910: aload 9
    //   912: monitorexit
    //   913: aload 9
    //   915: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   918: goto -526 -> 392
    //   921: aload 9
    //   923: getfield 259	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   926: aload 9
    //   928: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   931: iload 4
    //   933: i2l
    //   934: aload 10
    //   936: aload_0
    //   937: getfield 99	com/tencent/map/sdk/a/ip:d	I
    //   940: invokevirtual 277	com/tencent/map/sdk/engine/jni/JNI:nativeLineInsertPoint	(JJLcom/tencent/map/lib/basemap/data/GeoPoint;I)V
    //   943: aload 9
    //   945: monitorexit
    //   946: aload 9
    //   948: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   951: goto -559 -> 392
    //   954: astore_1
    //   955: aload 9
    //   957: monitorexit
    //   958: aload_1
    //   959: athrow
    //   960: astore_1
    //   961: aload 9
    //   963: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   966: aload_1
    //   967: athrow
    //   968: aload_0
    //   969: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   972: istore 4
    //   974: iload 4
    //   976: iconst_m1
    //   977: if_icmpne +11 -> 988
    //   980: aload 9
    //   982: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   985: goto -563 -> 422
    //   988: aload 9
    //   990: monitorenter
    //   991: aload 9
    //   993: getfield 259	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   996: aload 9
    //   998: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   1001: iload 4
    //   1003: i2l
    //   1004: aload_0
    //   1005: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   1008: getfield 279	com/tencent/map/sdk/a/hi:l	Z
    //   1011: invokevirtual 282	com/tencent/map/sdk/engine/jni/JNI:nativeSetDrawCap	(JJZ)V
    //   1014: aload 9
    //   1016: monitorexit
    //   1017: aload 9
    //   1019: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   1022: goto -600 -> 422
    //   1025: astore_1
    //   1026: aload 9
    //   1028: monitorexit
    //   1029: aload_1
    //   1030: athrow
    //   1031: astore_1
    //   1032: aload 9
    //   1034: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   1037: aload_1
    //   1038: athrow
    //   1039: aload_0
    //   1040: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   1043: istore 4
    //   1045: iload 4
    //   1047: iconst_m1
    //   1048: if_icmpne +11 -> 1059
    //   1051: aload 9
    //   1053: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   1056: goto -591 -> 465
    //   1059: aload 9
    //   1061: monitorenter
    //   1062: aload 9
    //   1064: getfield 259	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   1067: aload 9
    //   1069: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   1072: iload 4
    //   1074: i2l
    //   1075: aload_0
    //   1076: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   1079: getfield 232	com/tencent/map/sdk/a/hi:t	Ljava/lang/String;
    //   1082: invokevirtual 286	com/tencent/map/sdk/engine/jni/JNI:nativeSetLineDirectionArrowTextureName	(JJLjava/lang/String;)V
    //   1085: aload 9
    //   1087: monitorexit
    //   1088: aload 9
    //   1090: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   1093: goto -628 -> 465
    //   1096: astore_1
    //   1097: aload 9
    //   1099: monitorexit
    //   1100: aload_1
    //   1101: athrow
    //   1102: astore_1
    //   1103: aload 9
    //   1105: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   1108: aload_1
    //   1109: athrow
    //   1110: aload_0
    //   1111: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   1114: istore 4
    //   1116: iload 4
    //   1118: iconst_m1
    //   1119: if_icmpne +8 -> 1127
    //   1122: aload_1
    //   1123: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   1126: return
    //   1127: aload_0
    //   1128: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   1131: getfield 289	com/tencent/map/sdk/a/hi:u	F
    //   1134: fstore_2
    //   1135: fload_2
    //   1136: fconst_0
    //   1137: fcmpg
    //   1138: ifge +8 -> 1146
    //   1141: aload_1
    //   1142: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   1145: return
    //   1146: aload_0
    //   1147: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   1150: getfield 292	com/tencent/map/sdk/a/hi:o	I
    //   1153: istore 5
    //   1155: iload 5
    //   1157: iconst_3
    //   1158: if_icmpeq +8 -> 1166
    //   1161: iload 5
    //   1163: ifne +48 -> 1211
    //   1166: aload_1
    //   1167: monitorenter
    //   1168: aload_1
    //   1169: getfield 259	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   1172: aload_1
    //   1173: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   1176: iload 4
    //   1178: aload_0
    //   1179: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   1182: getfield 289	com/tencent/map/sdk/a/hi:u	F
    //   1185: invokevirtual 296	com/tencent/map/sdk/engine/jni/JNI:nativeSetLineArrowSpacing	(JIF)V
    //   1188: aload_1
    //   1189: monitorexit
    //   1190: aload_1
    //   1191: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   1194: return
    //   1195: astore 9
    //   1197: aload_1
    //   1198: monitorexit
    //   1199: aload 9
    //   1201: athrow
    //   1202: astore 9
    //   1204: aload_1
    //   1205: invokevirtual 221	com/tencent/map/sdk/a/pf:z	()V
    //   1208: aload 9
    //   1210: athrow
    //   1211: aload_1
    //   1212: monitorenter
    //   1213: aload_1
    //   1214: getfield 259	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   1217: aload_1
    //   1218: getfield 218	com/tencent/map/sdk/a/pf:b	J
    //   1221: iload 4
    //   1223: aload_0
    //   1224: getfield 131	com/tencent/map/sdk/a/ip:a	Lcom/tencent/map/sdk/a/hi;
    //   1227: getfield 289	com/tencent/map/sdk/a/hi:u	F
    //   1230: invokevirtual 299	com/tencent/map/sdk/engine/jni/JNI:nativeSetLineFootPrintSpacing	(JIF)V
    //   1233: aload_1
    //   1234: monitorexit
    //   1235: goto -45 -> 1190
    //   1238: astore 9
    //   1240: aload_1
    //   1241: monitorexit
    //   1242: aload 9
    //   1244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1245	0	this	ip
    //   0	1245	1	paramGL10	javax.microedition.khronos.opengles.GL10
    //   40	1096	2	f1	float
    //   136	6	3	f2	float
    //   174	1048	4	m	int
    //   164	998	5	n	int
    //   534	26	6	i1	int
    //   246	616	7	l1	long
    //   121	983	9	localObject1	Object
    //   1195	5	9	localObject2	Object
    //   1202	7	9	localObject3	Object
    //   1238	5	9	localObject4	Object
    //   611	324	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   236	248	576	finally
    //   498	504	576	finally
    //   518	568	576	finally
    //   607	613	666	finally
    //   618	621	666	finally
    //   629	658	666	finally
    //   667	670	666	finally
    //   298	310	672	finally
    //   584	590	672	finally
    //   604	607	672	finally
    //   670	672	672	finally
    //   703	729	737	finally
    //   738	741	737	finally
    //   328	340	743	finally
    //   680	686	743	finally
    //   700	703	743	finally
    //   741	743	743	finally
    //   774	780	829	finally
    //   785	788	829	finally
    //   796	821	829	finally
    //   830	833	829	finally
    //   368	380	835	finally
    //   751	757	835	finally
    //   771	774	835	finally
    //   833	835	835	finally
    //   899	905	954	finally
    //   910	913	954	finally
    //   921	946	954	finally
    //   955	958	954	finally
    //   849	861	960	finally
    //   876	882	960	finally
    //   896	899	960	finally
    //   958	960	960	finally
    //   991	1017	1025	finally
    //   1026	1029	1025	finally
    //   398	410	1031	finally
    //   968	974	1031	finally
    //   988	991	1031	finally
    //   1029	1031	1031	finally
    //   1062	1088	1096	finally
    //   1097	1100	1096	finally
    //   441	453	1102	finally
    //   1039	1045	1102	finally
    //   1059	1062	1102	finally
    //   1100	1102	1102	finally
    //   1168	1190	1195	finally
    //   1197	1199	1195	finally
    //   470	480	1202	finally
    //   1110	1116	1202	finally
    //   1127	1135	1202	finally
    //   1146	1155	1202	finally
    //   1166	1168	1202	finally
    //   1199	1202	1202	finally
    //   1211	1213	1202	finally
    //   1242	1245	1202	finally
    //   1213	1235	1238	finally
    //   1240	1242	1238	finally
  }
  
  /* Error */
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 141	com/tencent/map/sdk/a/ip:h	Lcom/tencent/map/sdk/a/lg;
    //   9: astore 8
    //   11: aload 8
    //   13: ifnonnull +12 -> 25
    //   16: iload 5
    //   18: istore 4
    //   20: aload_0
    //   21: monitorexit
    //   22: iload 4
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 141	com/tencent/map/sdk/a/ip:h	Lcom/tencent/map/sdk/a/lg;
    //   29: invokeinterface 193 1 0
    //   34: fload_1
    //   35: fload_2
    //   36: invokevirtual 303	com/tencent/map/sdk/a/pf:b	(FF)Lcom/tencent/map/sdk/engine/jni/models/TappedElement;
    //   39: astore 8
    //   41: iload 5
    //   43: istore 4
    //   45: aload 8
    //   47: ifnull -27 -> 20
    //   50: aload 8
    //   52: getfield 308	com/tencent/map/sdk/engine/jni/models/TappedElement:itemId	J
    //   55: lstore 6
    //   57: aload_0
    //   58: getfield 36	com/tencent/map/sdk/a/ip:f	I
    //   61: istore_3
    //   62: iload 5
    //   64: istore 4
    //   66: lload 6
    //   68: iload_3
    //   69: i2l
    //   70: lcmp
    //   71: ifne -51 -> 20
    //   74: iconst_1
    //   75: istore 4
    //   77: goto -57 -> 20
    //   80: astore 8
    //   82: aload_0
    //   83: monitorexit
    //   84: aload 8
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	ip
    //   0	87	1	paramFloat1	float
    //   0	87	2	paramFloat2	float
    //   61	8	3	m	int
    //   18	58	4	bool1	boolean
    //   1	62	5	bool2	boolean
    //   55	12	6	l1	long
    //   9	42	8	localObject1	Object
    //   80	5	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	11	80	finally
    //   25	41	80	finally
    //   50	62	80	finally
  }
  
  public final Rect b()
  {
    Object localObject = this.a.a;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()) && (this.d >= 0) && (this.d < ((ArrayList)localObject).size()))
    {
      localObject = ((ArrayList)localObject).subList(this.d, ((ArrayList)localObject).size());
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break label97;
      }
      localObject = null;
      if (localObject != null) {
        this.a.r = ((Rect)localObject);
      }
    }
    return this.a.r;
    label97:
    GeoPoint localGeoPoint = (GeoPoint)((List)localObject).get(0);
    int m = localGeoPoint.getLongitudeE6();
    int i2 = localGeoPoint.getLongitudeE6();
    int n = localGeoPoint.getLatitudeE6();
    int i1 = localGeoPoint.getLatitudeE6();
    int i6 = ((List)localObject).size();
    int i3 = 0;
    label147:
    int i4;
    int i5;
    if (i3 < i6)
    {
      localGeoPoint = (GeoPoint)((List)localObject).get(i3);
      if (localGeoPoint == null) {
        break label319;
      }
      i4 = localGeoPoint.getLatitudeE6();
      i5 = localGeoPoint.getLongitudeE6();
      if (i5 < m)
      {
        m = i2;
        i2 = i5;
        label200:
        if (i4 >= i1) {
          break label260;
        }
        i1 = n;
        n = m;
        m = i4;
      }
    }
    for (;;)
    {
      i5 = i3 + 1;
      i3 = i2;
      i4 = i1;
      i1 = m;
      i2 = n;
      n = i4;
      m = i3;
      i3 = i5;
      break label147;
      if (i5 > i2)
      {
        i2 = m;
        m = i5;
        break label200;
        label260:
        if (i4 > n)
        {
          n = m;
          m = i1;
          i1 = i4;
          continue;
          localObject = new Rect(m, n, i2, i1);
          break;
        }
        i4 = m;
        m = i1;
        i1 = n;
        n = i4;
        continue;
      }
      i5 = m;
      m = i2;
      i2 = i5;
      break label200;
      label319:
      i4 = n;
      i5 = m;
      m = i1;
      n = i2;
      i1 = i4;
      i2 = i5;
    }
  }
  
  public final Rect b(fu paramfu)
  {
    if ((this.a == null) || (this.a.b == null) || (this.a.b.isEmpty())) {
      return null;
    }
    paramfu = this.a.b.iterator();
    int i4 = 2147483647;
    int i1 = -2147483648;
    int i3 = -2147483648;
    int m = 2147483647;
    int i5;
    int n;
    if (paramfu.hasNext())
    {
      GeoPoint localGeoPoint = (GeoPoint)paramfu.next();
      i5 = localGeoPoint.getLatitudeE6();
      int i2 = localGeoPoint.getLongitudeE6();
      n = i3;
      if (i5 > i3) {
        n = i5;
      }
      i3 = i4;
      if (i5 < i4) {
        i3 = i5;
      }
      i5 = i1;
      if (i2 > i1) {
        i5 = i2;
      }
      if (i2 >= m) {
        break label177;
      }
      m = i2;
    }
    label177:
    for (;;)
    {
      i4 = i3;
      i1 = i5;
      i3 = n;
      break;
      return new Rect(m, i3, i1, i4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.ip
 * JD-Core Version:    0.7.0.1
 */