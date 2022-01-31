package com.tencent.beacon.core.strategy;

import android.content.Context;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.i;

public final class c
  implements Runnable
{
  private static long b = 0L;
  public boolean a = false;
  private Context c = null;
  
  public c(Context paramContext)
  {
    this.c = paramContext;
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
      paramContext = com.tencent.beacon.core.a.c.a(paramContext);
      int i = Integer.parseInt(paramContext.a("querytimes", "0"));
      if (!i.a().equals(paramString)) {
        i = 0;
      }
      if (i <= a.a().f())
      {
        paramContext.a().a("querytimes", String.valueOf(i + 1)).b();
        return false;
      }
      bool = true;
      b.c("[strategy] set init times failed! ", new Object[0]);
    }
    catch (Exception paramContext)
    {
      try
      {
        b.e("[strategy] sdk init max times", new Object[0]);
        return true;
      }
      catch (Exception paramContext)
      {
        boolean bool;
        break label75;
      }
      paramContext = paramContext;
      bool = false;
    }
    label75:
    return bool;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   6: invokestatic 101	com/tencent/beacon/core/strategy/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/strategy/e;
    //   9: astore 7
    //   11: aload 7
    //   13: ifnull +66 -> 79
    //   16: aload 7
    //   18: getfield 106	com/tencent/beacon/core/strategy/e:b	I
    //   21: bipush 101
    //   23: if_icmpne +56 -> 79
    //   26: aload 7
    //   28: getfield 109	com/tencent/beacon/core/strategy/e:c	[B
    //   31: astore 8
    //   33: aload 8
    //   35: ifnull +44 -> 79
    //   38: aload_0
    //   39: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   42: invokestatic 115	com/tencent/beacon/core/strategy/StrategyQueryModule:getInstance	(Landroid/content/Context;)Lcom/tencent/beacon/core/strategy/StrategyQueryModule;
    //   45: invokevirtual 119	com/tencent/beacon/core/strategy/StrategyQueryModule:getStrategyHandler	()Lcom/tencent/beacon/core/c/g;
    //   48: astore 8
    //   50: aload 8
    //   52: ifnull +27 -> 79
    //   55: aload 8
    //   57: bipush 101
    //   59: aload 7
    //   61: getfield 109	com/tencent/beacon/core/strategy/e:c	[B
    //   64: iconst_0
    //   65: invokeinterface 124 4 0
    //   70: ldc 126
    //   72: iconst_0
    //   73: anewarray 4	java/lang/Object
    //   76: invokestatic 88	com/tencent/beacon/core/d/b:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: aload_0
    //   80: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   83: invokestatic 115	com/tencent/beacon/core/strategy/StrategyQueryModule:getInstance	(Landroid/content/Context;)Lcom/tencent/beacon/core/strategy/StrategyQueryModule;
    //   86: astore 8
    //   88: aload 8
    //   90: invokevirtual 129	com/tencent/beacon/core/strategy/StrategyQueryModule:getCurrentQueryStep	()I
    //   93: ifne +182 -> 275
    //   96: ldc 131
    //   98: iconst_0
    //   99: anewarray 4	java/lang/Object
    //   102: invokestatic 88	com/tencent/beacon/core/d/b:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: aload 8
    //   107: iconst_1
    //   108: invokevirtual 135	com/tencent/beacon/core/strategy/StrategyQueryModule:setCurrentQueryStep	(I)V
    //   111: aload_0
    //   112: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   115: invokestatic 140	com/tencent/beacon/core/b/a:b	(Landroid/content/Context;)Z
    //   118: istore_2
    //   119: ldc 142
    //   121: iconst_1
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: iload_2
    //   128: invokestatic 147	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   131: aastore
    //   132: invokestatic 88	com/tencent/beacon/core/d/b:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: iload_2
    //   136: ifeq +109 -> 245
    //   139: ldc 149
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_0
    //   148: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   151: aload_0
    //   152: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   155: invokestatic 154	com/tencent/beacon/core/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/b/b;
    //   158: invokevirtual 156	com/tencent/beacon/core/b/b:b	()Ljava/lang/String;
    //   161: aconst_null
    //   162: invokestatic 161	com/tencent/beacon/core/a/a/b:a	(Landroid/content/Context;Ljava/lang/String;[I)I
    //   165: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: invokestatic 88	com/tencent/beacon/core/d/b:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload 8
    //   174: monitorenter
    //   175: aload 8
    //   177: iconst_1
    //   178: invokevirtual 168	com/tencent/beacon/core/strategy/StrategyQueryModule:setAppFirstRun	(Z)V
    //   181: aload 8
    //   183: monitorexit
    //   184: getstatic 174	com/tencent/beacon/event/UserAction:beaconModules	Ljava/util/List;
    //   187: invokeinterface 180 1 0
    //   192: astore 7
    //   194: aload 7
    //   196: invokeinterface 186 1 0
    //   201: ifeq +74 -> 275
    //   204: aload 7
    //   206: invokeinterface 190 1 0
    //   211: checkcast 192	com/tencent/beacon/core/b
    //   214: invokevirtual 195	com/tencent/beacon/core/b:onAppFirstRun	()V
    //   217: goto -23 -> 194
    //   220: astore 7
    //   222: aload_0
    //   223: monitorexit
    //   224: aload 7
    //   226: athrow
    //   227: astore 7
    //   229: aload 7
    //   231: invokestatic 198	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   234: goto -155 -> 79
    //   237: astore 7
    //   239: aload 8
    //   241: monitorexit
    //   242: aload 7
    //   244: athrow
    //   245: invokestatic 200	com/tencent/beacon/core/strategy/c:a	()J
    //   248: lstore_3
    //   249: lload_3
    //   250: lconst_0
    //   251: lcmp
    //   252: ifle +23 -> 275
    //   255: ldc 202
    //   257: iconst_1
    //   258: anewarray 4	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: lload_3
    //   264: invokestatic 207	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   267: aastore
    //   268: invokestatic 88	com/tencent/beacon/core/d/b:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: lload_3
    //   272: invokestatic 212	java/lang/Thread:sleep	(J)V
    //   275: ldc 214
    //   277: iconst_0
    //   278: anewarray 4	java/lang/Object
    //   281: invokestatic 88	com/tencent/beacon/core/d/b:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: aload 8
    //   286: iconst_2
    //   287: invokevirtual 135	com/tencent/beacon/core/strategy/StrategyQueryModule:setCurrentQueryStep	(I)V
    //   290: aload 8
    //   292: aload 8
    //   294: invokevirtual 217	com/tencent/beacon/core/strategy/StrategyQueryModule:getCommonQueryTime	()I
    //   297: iconst_1
    //   298: iadd
    //   299: invokevirtual 220	com/tencent/beacon/core/strategy/StrategyQueryModule:setCommonQueryTime	(I)V
    //   302: getstatic 174	com/tencent/beacon/event/UserAction:beaconModules	Ljava/util/List;
    //   305: invokeinterface 180 1 0
    //   310: astore 7
    //   312: aload 7
    //   314: invokeinterface 186 1 0
    //   319: ifeq +29 -> 348
    //   322: aload 7
    //   324: invokeinterface 190 1 0
    //   329: checkcast 192	com/tencent/beacon/core/b
    //   332: invokevirtual 223	com/tencent/beacon/core/b:onStrategyQueryStarted	()V
    //   335: goto -23 -> 312
    //   338: astore 7
    //   340: aload 7
    //   342: invokestatic 198	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   345: goto -70 -> 275
    //   348: invokestatic 64	com/tencent/beacon/core/strategy/a:a	()Lcom/tencent/beacon/core/strategy/a;
    //   351: invokevirtual 226	com/tencent/beacon/core/strategy/a:g	()Z
    //   354: ifne +214 -> 568
    //   357: invokestatic 230	com/tencent/beacon/core/strategy/StrategyQueryModule:getMyUpload	()Lcom/tencent/beacon/core/c/h;
    //   360: astore 7
    //   362: iconst_0
    //   363: istore_1
    //   364: aload 7
    //   366: ifnonnull +36 -> 402
    //   369: iload_1
    //   370: iconst_1
    //   371: iadd
    //   372: istore_1
    //   373: iload_1
    //   374: iconst_5
    //   375: if_icmpge +27 -> 402
    //   378: ldc2_w 231
    //   381: invokestatic 212	java/lang/Thread:sleep	(J)V
    //   384: invokestatic 230	com/tencent/beacon/core/strategy/StrategyQueryModule:getMyUpload	()Lcom/tencent/beacon/core/c/h;
    //   387: astore 7
    //   389: goto -25 -> 364
    //   392: astore 7
    //   394: aload 7
    //   396: invokestatic 198	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   399: goto -15 -> 384
    //   402: aload 7
    //   404: ifnull +300 -> 704
    //   407: aload_0
    //   408: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   411: invokestatic 35	com/tencent/beacon/core/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/a/c;
    //   414: astore 10
    //   416: aload 10
    //   418: ldc 234
    //   420: ldc 236
    //   422: invokevirtual 42	com/tencent/beacon/core/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   425: astore 9
    //   427: invokestatic 53	com/tencent/beacon/core/d/i:a	()Ljava/lang/String;
    //   430: aload 9
    //   432: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   435: ifne +19 -> 454
    //   438: aload 10
    //   440: invokevirtual 71	com/tencent/beacon/core/a/c:a	()Lcom/tencent/beacon/core/a/c;
    //   443: ldc 234
    //   445: invokestatic 53	com/tencent/beacon/core/d/i:a	()Ljava/lang/String;
    //   448: invokevirtual 78	com/tencent/beacon/core/a/c:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/beacon/core/a/c;
    //   451: invokevirtual 80	com/tencent/beacon/core/a/c:b	()V
    //   454: aload_0
    //   455: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   458: aload 9
    //   460: invokestatic 238	com/tencent/beacon/core/strategy/c:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   463: istore_2
    //   464: aload_0
    //   465: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   468: astore 11
    //   470: invokestatic 243	com/tencent/beacon/core/event/EventStrategyBean:getInstance	()Lcom/tencent/beacon/core/event/EventStrategyBean;
    //   473: astore 10
    //   475: aload 10
    //   477: invokevirtual 246	com/tencent/beacon/core/event/EventStrategyBean:isStrategyQuerySuccessDaxMax	()Z
    //   480: ifeq +347 -> 827
    //   483: aload 11
    //   485: invokestatic 35	com/tencent/beacon/core/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/a/c;
    //   488: astore 11
    //   490: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   493: lstore_3
    //   494: lload_3
    //   495: ldc2_w 252
    //   498: ldiv
    //   499: ldc2_w 254
    //   502: ladd
    //   503: ldc2_w 256
    //   506: lrem
    //   507: lstore 5
    //   509: lload 5
    //   511: lconst_0
    //   512: lcmp
    //   513: iflt +107 -> 620
    //   516: lload 5
    //   518: ldc2_w 258
    //   521: lcmp
    //   522: ifgt +98 -> 620
    //   525: lload_3
    //   526: aload 11
    //   528: ldc_w 261
    //   531: invokevirtual 264	com/tencent/beacon/core/a/c:b	(Ljava/lang/String;)J
    //   534: lsub
    //   535: ldc2_w 265
    //   538: lcmp
    //   539: ifgt +81 -> 620
    //   542: iconst_1
    //   543: istore_1
    //   544: goto +272 -> 816
    //   547: ldc_w 268
    //   550: iconst_0
    //   551: anewarray 4	java/lang/Object
    //   554: invokestatic 92	com/tencent/beacon/core/d/b:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: aload_0
    //   558: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   561: invokestatic 115	com/tencent/beacon/core/strategy/StrategyQueryModule:getInstance	(Landroid/content/Context;)Lcom/tencent/beacon/core/strategy/StrategyQueryModule;
    //   564: iconst_1
    //   565: invokevirtual 271	com/tencent/beacon/core/strategy/StrategyQueryModule:setAtLeastAComQuerySuccess	(Z)V
    //   568: ldc_w 273
    //   571: iconst_0
    //   572: anewarray 4	java/lang/Object
    //   575: invokestatic 276	com/tencent/beacon/core/d/b:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   578: aload 8
    //   580: iconst_3
    //   581: invokevirtual 135	com/tencent/beacon/core/strategy/StrategyQueryModule:setCurrentQueryStep	(I)V
    //   584: getstatic 174	com/tencent/beacon/event/UserAction:beaconModules	Ljava/util/List;
    //   587: invokeinterface 180 1 0
    //   592: astore 7
    //   594: aload 7
    //   596: invokeinterface 186 1 0
    //   601: ifeq +116 -> 717
    //   604: aload 7
    //   606: invokeinterface 190 1 0
    //   611: checkcast 192	com/tencent/beacon/core/b
    //   614: invokevirtual 279	com/tencent/beacon/core/b:onStrategyQueryFinished	()V
    //   617: goto -23 -> 594
    //   620: invokestatic 53	com/tencent/beacon/core/d/i:a	()Ljava/lang/String;
    //   623: aload 9
    //   625: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   628: ifeq +24 -> 652
    //   631: aload 11
    //   633: ldc_w 281
    //   636: invokevirtual 283	com/tencent/beacon/core/a/c:a	(Ljava/lang/String;)I
    //   639: aload 10
    //   641: invokevirtual 286	com/tencent/beacon/core/event/EventStrategyBean:getStrategyQuerySuccessDayMaxTimes	()I
    //   644: if_icmplt +183 -> 827
    //   647: iconst_1
    //   648: istore_1
    //   649: goto +167 -> 816
    //   652: aload 11
    //   654: invokevirtual 71	com/tencent/beacon/core/a/c:a	()Lcom/tencent/beacon/core/a/c;
    //   657: ldc_w 281
    //   660: iconst_0
    //   661: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   664: invokevirtual 78	com/tencent/beacon/core/a/c:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/beacon/core/a/c;
    //   667: invokevirtual 80	com/tencent/beacon/core/a/c:b	()V
    //   670: goto +157 -> 827
    //   673: aload 7
    //   675: new 288	com/tencent/beacon/core/c/c
    //   678: dup
    //   679: aload_0
    //   680: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   683: aload_0
    //   684: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   687: invokestatic 154	com/tencent/beacon/core/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/b/b;
    //   690: invokevirtual 156	com/tencent/beacon/core/b/b:b	()Ljava/lang/String;
    //   693: invokespecial 291	com/tencent/beacon/core/c/c:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   696: invokeinterface 296 2 0
    //   701: goto -133 -> 568
    //   704: ldc_w 298
    //   707: iconst_0
    //   708: anewarray 4	java/lang/Object
    //   711: invokestatic 276	com/tencent/beacon/core/d/b:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   714: goto -146 -> 568
    //   717: aload_0
    //   718: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   721: invokestatic 115	com/tencent/beacon/core/strategy/StrategyQueryModule:getInstance	(Landroid/content/Context;)Lcom/tencent/beacon/core/strategy/StrategyQueryModule;
    //   724: invokevirtual 301	com/tencent/beacon/core/strategy/StrategyQueryModule:getStrategy	()Lcom/tencent/beacon/core/strategy/a;
    //   727: astore 7
    //   729: aload 7
    //   731: ifnonnull +16 -> 747
    //   734: ldc_w 303
    //   737: iconst_0
    //   738: anewarray 4	java/lang/Object
    //   741: invokestatic 306	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   744: aload_0
    //   745: monitorexit
    //   746: return
    //   747: aload 7
    //   749: invokevirtual 308	com/tencent/beacon/core/strategy/a:c	()I
    //   752: ldc_w 309
    //   755: imul
    //   756: i2l
    //   757: lstore_3
    //   758: lload_3
    //   759: lconst_0
    //   760: lcmp
    //   761: ifle +42 -> 803
    //   764: invokestatic 314	com/tencent/beacon/core/a/b:b	()Lcom/tencent/beacon/core/a/b;
    //   767: aload_0
    //   768: lload_3
    //   769: invokevirtual 317	com/tencent/beacon/core/a/b:a	(Ljava/lang/Runnable;J)V
    //   772: ldc_w 319
    //   775: iconst_1
    //   776: anewarray 4	java/lang/Object
    //   779: dup
    //   780: iconst_0
    //   781: lload_3
    //   782: invokestatic 207	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   785: aastore
    //   786: invokestatic 276	com/tencent/beacon/core/d/b:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   789: aload_0
    //   790: getfield 23	com/tencent/beacon/core/strategy/c:c	Landroid/content/Context;
    //   793: invokestatic 115	com/tencent/beacon/core/strategy/StrategyQueryModule:getInstance	(Landroid/content/Context;)Lcom/tencent/beacon/core/strategy/StrategyQueryModule;
    //   796: iconst_4
    //   797: invokevirtual 135	com/tencent/beacon/core/strategy/StrategyQueryModule:setCurrentQueryStep	(I)V
    //   800: goto -56 -> 744
    //   803: ldc_w 321
    //   806: iconst_0
    //   807: anewarray 4	java/lang/Object
    //   810: invokestatic 276	com/tencent/beacon/core/d/b:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   813: goto -69 -> 744
    //   816: iload_2
    //   817: ifne -270 -> 547
    //   820: iload_1
    //   821: ifeq -148 -> 673
    //   824: goto -277 -> 547
    //   827: iconst_0
    //   828: istore_1
    //   829: goto -13 -> 816
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	832	0	this	c
    //   363	466	1	i	int
    //   118	699	2	bool	boolean
    //   248	534	3	l1	long
    //   507	10	5	l2	long
    //   9	196	7	localObject1	Object
    //   220	5	7	localObject2	Object
    //   227	3	7	localThrowable	java.lang.Throwable
    //   237	6	7	localObject3	Object
    //   310	13	7	localIterator	java.util.Iterator
    //   338	3	7	localInterruptedException1	java.lang.InterruptedException
    //   360	28	7	localh	com.tencent.beacon.core.c.h
    //   392	11	7	localInterruptedException2	java.lang.InterruptedException
    //   592	156	7	localObject4	Object
    //   31	548	8	localObject5	Object
    //   425	199	9	str	String
    //   414	226	10	localObject6	Object
    //   468	185	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	220	finally
    //   16	33	220	finally
    //   38	50	220	finally
    //   55	79	220	finally
    //   79	135	220	finally
    //   139	175	220	finally
    //   184	194	220	finally
    //   194	217	220	finally
    //   229	234	220	finally
    //   242	245	220	finally
    //   245	249	220	finally
    //   255	271	220	finally
    //   271	275	220	finally
    //   275	312	220	finally
    //   312	335	220	finally
    //   340	345	220	finally
    //   348	362	220	finally
    //   378	384	220	finally
    //   384	389	220	finally
    //   394	399	220	finally
    //   407	454	220	finally
    //   454	509	220	finally
    //   525	542	220	finally
    //   547	568	220	finally
    //   568	594	220	finally
    //   594	617	220	finally
    //   620	647	220	finally
    //   652	670	220	finally
    //   673	701	220	finally
    //   704	714	220	finally
    //   717	729	220	finally
    //   734	744	220	finally
    //   747	758	220	finally
    //   764	800	220	finally
    //   803	813	220	finally
    //   38	50	227	java/lang/Throwable
    //   55	79	227	java/lang/Throwable
    //   175	184	237	finally
    //   239	242	237	finally
    //   271	275	338	java/lang/InterruptedException
    //   378	384	392	java/lang/InterruptedException
  }
  
  public final void run()
  {
    this.a = true;
    b();
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.c
 * JD-Core Version:    0.7.0.1
 */