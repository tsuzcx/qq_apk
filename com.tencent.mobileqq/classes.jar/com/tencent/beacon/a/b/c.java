package com.tencent.beacon.a.b;

import android.content.Context;
import com.tencent.beacon.a.f;
import com.tencent.beacon.d.a;
import com.tencent.beacon.upload.h;

public final class c
  implements Runnable
{
  private static long b = 0L;
  Context a = null;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static long a()
  {
    try
    {
      long l = b;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      b = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    try
    {
      int i = Integer.parseInt(com.tencent.beacon.a.b.b(paramContext, "querytimes", "0"));
      if (!f.n().equals(paramString)) {
        i = 0;
      }
      if (i <= d.a().h())
      {
        com.tencent.beacon.a.b.d(paramContext, String.valueOf(i + 1));
        return false;
      }
      bool = true;
      a.c(" set init times failed! ", new Object[0]);
    }
    catch (Exception paramContext)
    {
      try
      {
        a.e(" sdk init max times", new Object[0]);
        return true;
      }
      catch (Exception paramContext)
      {
        boolean bool;
        break label62;
      }
      paramContext = paramContext;
      bool = false;
    }
    label62:
    return bool;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   4: invokestatic 94	com/tencent/beacon/a/f:o	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/g;
    //   7: astore 8
    //   9: aload 8
    //   11: ifnull +60 -> 71
    //   14: aload 8
    //   16: invokevirtual 98	com/tencent/beacon/a/b/g:b	()I
    //   19: bipush 101
    //   21: if_icmpne +50 -> 71
    //   24: aload 8
    //   26: invokevirtual 101	com/tencent/beacon/a/b/g:c	()[B
    //   29: ifnull +42 -> 71
    //   32: aload_0
    //   33: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   36: invokestatic 106	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   39: invokevirtual 110	com/tencent/beacon/a/b/b:f	()Lcom/tencent/beacon/upload/g;
    //   42: astore 9
    //   44: aload 9
    //   46: ifnull +25 -> 71
    //   49: aload 9
    //   51: bipush 101
    //   53: aload 8
    //   55: invokevirtual 101	com/tencent/beacon/a/b/g:c	()[B
    //   58: iconst_0
    //   59: invokevirtual 115	com/tencent/beacon/upload/g:a	(I[BZ)V
    //   62: ldc 117
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_0
    //   72: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   75: invokestatic 106	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   78: astore 9
    //   80: aload 9
    //   82: invokevirtual 120	com/tencent/beacon/a/b/b:j	()I
    //   85: ifne +189 -> 274
    //   88: ldc 122
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload 9
    //   99: iconst_1
    //   100: invokevirtual 125	com/tencent/beacon/a/b/b:a	(I)V
    //   103: aload_0
    //   104: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   107: invokestatic 128	com/tencent/beacon/a/b:d	(Landroid/content/Context;)Z
    //   110: istore_3
    //   111: ldc 130
    //   113: iconst_1
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: iload_3
    //   120: invokestatic 135	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   123: aastore
    //   124: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: iload_3
    //   128: ifeq +112 -> 240
    //   131: ldc 137
    //   133: iconst_1
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_0
    //   140: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   143: aconst_null
    //   144: invokestatic 142	com/tencent/beacon/a/a/a:a	(Landroid/content/Context;[I)I
    //   147: invokestatic 145	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: aastore
    //   151: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: aload 9
    //   156: monitorenter
    //   157: ldc 147
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload 9
    //   168: invokevirtual 151	com/tencent/beacon/a/b/b:i	()[Lcom/tencent/beacon/a/b/a;
    //   171: astore 8
    //   173: aload 9
    //   175: invokevirtual 153	com/tencent/beacon/a/b/b:h	()V
    //   178: aload 9
    //   180: monitorexit
    //   181: aload 8
    //   183: ifnull +91 -> 274
    //   186: ldc 155
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload 8
    //   197: arraylength
    //   198: istore_2
    //   199: iconst_0
    //   200: istore_1
    //   201: iload_1
    //   202: iload_2
    //   203: if_icmpge +71 -> 274
    //   206: aload 8
    //   208: iload_1
    //   209: aaload
    //   210: invokeinterface 159 1 0
    //   215: iload_1
    //   216: iconst_1
    //   217: iadd
    //   218: istore_1
    //   219: goto -18 -> 201
    //   222: astore 8
    //   224: aload 8
    //   226: invokestatic 162	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   229: goto -158 -> 71
    //   232: astore 8
    //   234: aload 9
    //   236: monitorexit
    //   237: aload 8
    //   239: athrow
    //   240: invokestatic 164	com/tencent/beacon/a/b/c:a	()J
    //   243: lstore 4
    //   245: lload 4
    //   247: lconst_0
    //   248: lcmp
    //   249: ifle +25 -> 274
    //   252: ldc 166
    //   254: iconst_1
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: lload 4
    //   262: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   265: aastore
    //   266: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: lload 4
    //   271: invokestatic 176	java/lang/Thread:sleep	(J)V
    //   274: aload 9
    //   276: monitorenter
    //   277: ldc 178
    //   279: iconst_0
    //   280: anewarray 4	java/lang/Object
    //   283: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: aload 9
    //   288: invokevirtual 151	com/tencent/beacon/a/b/b:i	()[Lcom/tencent/beacon/a/b/a;
    //   291: astore 8
    //   293: aload 9
    //   295: iconst_2
    //   296: invokevirtual 125	com/tencent/beacon/a/b/b:a	(I)V
    //   299: aload 9
    //   301: monitorexit
    //   302: aload 8
    //   304: ifnull +57 -> 361
    //   307: ldc 180
    //   309: iconst_0
    //   310: anewarray 4	java/lang/Object
    //   313: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: aload 8
    //   318: arraylength
    //   319: istore_2
    //   320: iconst_0
    //   321: istore_1
    //   322: iload_1
    //   323: iload_2
    //   324: if_icmpge +37 -> 361
    //   327: aload 8
    //   329: iload_1
    //   330: aaload
    //   331: invokeinterface 182 1 0
    //   336: iload_1
    //   337: iconst_1
    //   338: iadd
    //   339: istore_1
    //   340: goto -18 -> 322
    //   343: astore 8
    //   345: aload 8
    //   347: invokestatic 162	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   350: goto -76 -> 274
    //   353: astore 8
    //   355: aload 9
    //   357: monitorexit
    //   358: aload 8
    //   360: athrow
    //   361: invokestatic 60	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   364: invokevirtual 185	com/tencent/beacon/a/b/d:i	()Z
    //   367: ifne +202 -> 569
    //   370: invokestatic 188	com/tencent/beacon/a/b/b:c	()Lcom/tencent/beacon/upload/h;
    //   373: astore 8
    //   375: iconst_0
    //   376: istore_1
    //   377: aload 8
    //   379: ifnonnull +36 -> 415
    //   382: iload_1
    //   383: iconst_1
    //   384: iadd
    //   385: istore_1
    //   386: iload_1
    //   387: iconst_5
    //   388: if_icmpge +27 -> 415
    //   391: ldc2_w 189
    //   394: invokestatic 176	java/lang/Thread:sleep	(J)V
    //   397: invokestatic 188	com/tencent/beacon/a/b/b:c	()Lcom/tencent/beacon/upload/h;
    //   400: astore 8
    //   402: goto -25 -> 377
    //   405: astore 8
    //   407: aload 8
    //   409: invokestatic 162	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   412: goto -15 -> 397
    //   415: aload 8
    //   417: ifnull +404 -> 821
    //   420: aload_0
    //   421: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   424: ldc 192
    //   426: ldc 194
    //   428: invokestatic 37	com/tencent/beacon/a/b:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   431: astore 10
    //   433: invokestatic 49	com/tencent/beacon/a/f:n	()Ljava/lang/String;
    //   436: aload 10
    //   438: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   441: ifne +13 -> 454
    //   444: aload_0
    //   445: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   448: invokestatic 49	com/tencent/beacon/a/f:n	()Ljava/lang/String;
    //   451: invokestatic 196	com/tencent/beacon/a/b:e	(Landroid/content/Context;Ljava/lang/String;)V
    //   454: aload_0
    //   455: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   458: aload 10
    //   460: invokestatic 198	com/tencent/beacon/a/b/c:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   463: istore_3
    //   464: aload_0
    //   465: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   468: astore 11
    //   470: invokestatic 203	com/tencent/beacon/event/o:d	()Lcom/tencent/beacon/event/o;
    //   473: getfield 206	com/tencent/beacon/event/o:a	Lcom/tencent/beacon/event/g;
    //   476: astore 12
    //   478: aload 12
    //   480: invokevirtual 211	com/tencent/beacon/event/g:x	()Z
    //   483: ifeq +195 -> 678
    //   486: invokestatic 216	java/lang/System:currentTimeMillis	()J
    //   489: lstore 4
    //   491: lload 4
    //   493: ldc2_w 217
    //   496: ldiv
    //   497: ldc2_w 219
    //   500: ladd
    //   501: ldc2_w 221
    //   504: lrem
    //   505: lstore 6
    //   507: lload 6
    //   509: lconst_0
    //   510: lcmp
    //   511: iflt +127 -> 638
    //   514: lload 6
    //   516: ldc2_w 223
    //   519: lcmp
    //   520: ifgt +118 -> 638
    //   523: lload 4
    //   525: aload 11
    //   527: ldc 226
    //   529: invokestatic 229	com/tencent/beacon/a/b:b	(Landroid/content/Context;Ljava/lang/String;)J
    //   532: lsub
    //   533: ldc2_w 230
    //   536: lcmp
    //   537: ifgt +101 -> 638
    //   540: iconst_1
    //   541: istore_1
    //   542: iload_3
    //   543: ifne +7 -> 550
    //   546: iload_1
    //   547: ifeq +136 -> 683
    //   550: ldc 233
    //   552: iconst_0
    //   553: anewarray 4	java/lang/Object
    //   556: invokestatic 85	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   559: aload_0
    //   560: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   563: invokestatic 106	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   566: invokevirtual 235	com/tencent/beacon/a/b/b:b	()V
    //   569: ldc 237
    //   571: iconst_0
    //   572: anewarray 4	java/lang/Object
    //   575: invokestatic 239	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   578: aload 9
    //   580: monitorenter
    //   581: aload 9
    //   583: invokevirtual 151	com/tencent/beacon/a/b/b:i	()[Lcom/tencent/beacon/a/b/a;
    //   586: astore 8
    //   588: aload 9
    //   590: iconst_3
    //   591: invokevirtual 125	com/tencent/beacon/a/b/b:a	(I)V
    //   594: aload 9
    //   596: monitorexit
    //   597: aload 8
    //   599: ifnull +243 -> 842
    //   602: ldc 241
    //   604: iconst_0
    //   605: anewarray 4	java/lang/Object
    //   608: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   611: aload 8
    //   613: arraylength
    //   614: istore_2
    //   615: iconst_0
    //   616: istore_1
    //   617: iload_1
    //   618: iload_2
    //   619: if_icmpge +223 -> 842
    //   622: aload 8
    //   624: iload_1
    //   625: aaload
    //   626: invokeinterface 242 1 0
    //   631: iload_1
    //   632: iconst_1
    //   633: iadd
    //   634: istore_1
    //   635: goto -18 -> 617
    //   638: invokestatic 49	com/tencent/beacon/a/f:n	()Ljava/lang/String;
    //   641: aload 10
    //   643: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   646: ifeq +23 -> 669
    //   649: aload 11
    //   651: ldc 244
    //   653: invokestatic 247	com/tencent/beacon/a/b:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   656: aload 12
    //   658: invokevirtual 250	com/tencent/beacon/event/g:w	()I
    //   661: if_icmplt +17 -> 678
    //   664: iconst_1
    //   665: istore_1
    //   666: goto -124 -> 542
    //   669: aload 11
    //   671: ldc 244
    //   673: iconst_0
    //   674: invokestatic 253	com/tencent/beacon/a/b:a	(Landroid/content/Context;Ljava/lang/String;I)Z
    //   677: pop
    //   678: iconst_0
    //   679: istore_1
    //   680: goto -138 -> 542
    //   683: aload 8
    //   685: new 255	com/tencent/beacon/upload/c
    //   688: dup
    //   689: aload_0
    //   690: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   693: invokespecial 257	com/tencent/beacon/upload/c:<init>	(Landroid/content/Context;)V
    //   696: invokeinterface 262 2 0
    //   701: invokestatic 60	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   704: invokevirtual 264	com/tencent/beacon/a/b/d:f	()Z
    //   707: ifeq +109 -> 816
    //   710: iconst_1
    //   711: istore_1
    //   712: new 266	com/tencent/beacon/d/b
    //   715: dup
    //   716: aload_0
    //   717: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   720: invokespecial 267	com/tencent/beacon/d/b:<init>	(Landroid/content/Context;)V
    //   723: astore 10
    //   725: iload_1
    //   726: istore_2
    //   727: iload_1
    //   728: ifeq +15 -> 743
    //   731: iload_1
    //   732: istore_2
    //   733: aload 10
    //   735: invokevirtual 269	com/tencent/beacon/d/b:b	()Z
    //   738: ifeq +5 -> 743
    //   741: iconst_0
    //   742: istore_2
    //   743: ldc 194
    //   745: aload_0
    //   746: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   749: invokestatic 274	com/tencent/beacon/a/j:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/j;
    //   752: invokevirtual 276	com/tencent/beacon/a/j:b	()Ljava/lang/String;
    //   755: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   758: ifeq +5 -> 763
    //   761: iconst_1
    //   762: istore_2
    //   763: iload_2
    //   764: ifeq -195 -> 569
    //   767: invokestatic 60	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   770: invokevirtual 278	com/tencent/beacon/a/b/d:j	()Z
    //   773: ifne -204 -> 569
    //   776: new 8	com/tencent/beacon/a/b/c$1
    //   779: dup
    //   780: aload_0
    //   781: aload 8
    //   783: aload 10
    //   785: invokespecial 281	com/tencent/beacon/a/b/c$1:<init>	(Lcom/tencent/beacon/a/b/c;Lcom/tencent/beacon/upload/h;Lcom/tencent/beacon/d/b;)V
    //   788: astore 8
    //   790: invokestatic 286	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   793: aload 8
    //   795: invokevirtual 289	com/tencent/beacon/a/c:a	(Ljava/lang/Runnable;)V
    //   798: goto -229 -> 569
    //   801: astore 8
    //   803: ldc_w 291
    //   806: iconst_0
    //   807: anewarray 4	java/lang/Object
    //   810: invokestatic 85	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   813: goto -244 -> 569
    //   816: iconst_0
    //   817: istore_1
    //   818: goto -106 -> 712
    //   821: ldc_w 293
    //   824: iconst_0
    //   825: anewarray 4	java/lang/Object
    //   828: invokestatic 239	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   831: goto -262 -> 569
    //   834: astore 8
    //   836: aload 9
    //   838: monitorexit
    //   839: aload 8
    //   841: athrow
    //   842: aload_0
    //   843: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   846: invokestatic 106	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   849: invokevirtual 295	com/tencent/beacon/a/b/b:e	()Lcom/tencent/beacon/a/b/d;
    //   852: astore 8
    //   854: aload 8
    //   856: ifnonnull +14 -> 870
    //   859: ldc_w 297
    //   862: iconst_0
    //   863: anewarray 4	java/lang/Object
    //   866: invokestatic 299	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   869: return
    //   870: aload 8
    //   872: invokevirtual 301	com/tencent/beacon/a/b/d:c	()I
    //   875: ldc_w 302
    //   878: imul
    //   879: i2l
    //   880: lstore 4
    //   882: lload 4
    //   884: lconst_0
    //   885: lcmp
    //   886: ifle +42 -> 928
    //   889: invokestatic 286	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   892: aload_0
    //   893: lload 4
    //   895: invokevirtual 305	com/tencent/beacon/a/c:a	(Ljava/lang/Runnable;J)V
    //   898: ldc_w 307
    //   901: iconst_1
    //   902: anewarray 4	java/lang/Object
    //   905: dup
    //   906: iconst_0
    //   907: lload 4
    //   909: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   912: aastore
    //   913: invokestatic 239	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   916: aload_0
    //   917: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   920: invokestatic 106	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   923: iconst_4
    //   924: invokevirtual 125	com/tencent/beacon/a/b/b:a	(I)V
    //   927: return
    //   928: ldc_w 309
    //   931: iconst_0
    //   932: anewarray 4	java/lang/Object
    //   935: invokestatic 239	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   938: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	939	0	this	c
    //   200	618	1	i	int
    //   198	566	2	j	int
    //   110	433	3	bool	boolean
    //   243	665	4	l1	long
    //   505	10	6	l2	long
    //   7	200	8	localObject1	Object
    //   222	3	8	localThrowable	java.lang.Throwable
    //   232	6	8	localObject2	Object
    //   291	37	8	arrayOfa	a[]
    //   343	3	8	localInterruptedException1	java.lang.InterruptedException
    //   353	6	8	localObject3	Object
    //   373	28	8	localh	h
    //   405	11	8	localInterruptedException2	java.lang.InterruptedException
    //   586	208	8	localObject4	Object
    //   801	1	8	localException	Exception
    //   834	6	8	localObject5	Object
    //   852	19	8	locald	d
    //   42	795	9	localObject6	Object
    //   431	353	10	localObject7	Object
    //   468	202	11	localContext	Context
    //   476	181	12	localg	com.tencent.beacon.event.g
    // Exception table:
    //   from	to	target	type
    //   32	44	222	java/lang/Throwable
    //   49	71	222	java/lang/Throwable
    //   157	181	232	finally
    //   269	274	343	java/lang/InterruptedException
    //   277	302	353	finally
    //   391	397	405	java/lang/InterruptedException
    //   701	710	801	java/lang/Exception
    //   712	725	801	java/lang/Exception
    //   733	741	801	java/lang/Exception
    //   743	761	801	java/lang/Exception
    //   767	798	801	java/lang/Exception
    //   581	597	834	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b.c
 * JD-Core Version:    0.7.0.1
 */