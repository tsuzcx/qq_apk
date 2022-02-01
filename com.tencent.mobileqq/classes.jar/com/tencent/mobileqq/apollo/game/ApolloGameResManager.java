package com.tencent.mobileqq.apollo.game;

import android.util.LruCache;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameRscVerify;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.HashMap;

public class ApolloGameResManager
{
  public static ApolloGameResManager a;
  private static LRULinkedHashMap<String, LruCache<String, ApolloGameResManager.ApolloGameRes>> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(2);
  private static HashMap<String, ApolloGameRscVerify> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static ApolloGameResManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager == null) {
          jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager = new ApolloGameResManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    localStringBuilder.append(String.valueOf(paramString));
    return localStringBuilder.toString();
  }
  
  /* Error */
  public ApolloGameResManager.ApolloGameRes a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +759 -> 763
    //   7: aload_2
    //   8: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: getstatic 26	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: ifnonnull +13 -> 32
    //   22: new 22	java/util/HashMap
    //   25: dup
    //   26: invokespecial 24	java/util/HashMap:<init>	()V
    //   29: putstatic 26	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   32: aload_2
    //   33: invokestatic 67	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   36: istore_3
    //   37: goto +19 -> 56
    //   40: astore 5
    //   42: ldc 69
    //   44: iconst_1
    //   45: aload 5
    //   47: iconst_0
    //   48: anewarray 4	java/lang/Object
    //   51: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   54: iconst_0
    //   55: istore_3
    //   56: iload_3
    //   57: invokestatic 80	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:a	(I)Z
    //   60: ifne +22 -> 82
    //   63: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +11 -> 77
    //   69: ldc 69
    //   71: iconst_2
    //   72: ldc 86
    //   74: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: iconst_0
    //   78: istore_3
    //   79: goto +5 -> 84
    //   82: iconst_1
    //   83: istore_3
    //   84: iload_3
    //   85: ifeq +100 -> 185
    //   88: getstatic 26	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   91: astore 5
    //   93: aload 5
    //   95: monitorenter
    //   96: aload_2
    //   97: invokestatic 67	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   100: istore 4
    //   102: getstatic 26	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   105: aload_2
    //   106: invokevirtual 94	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 77	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify
    //   112: ifnonnull +62 -> 174
    //   115: new 77	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify
    //   118: dup
    //   119: iload 4
    //   121: invokespecial 95	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:<init>	(I)V
    //   124: astore 6
    //   126: aload 6
    //   128: invokevirtual 98	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:b	()Z
    //   131: ifeq +16 -> 147
    //   134: getstatic 26	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   137: aload_2
    //   138: aload 6
    //   140: invokevirtual 102	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: pop
    //   144: goto +30 -> 174
    //   147: ldc 69
    //   149: iconst_1
    //   150: ldc 104
    //   152: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload 5
    //   157: monitorexit
    //   158: aconst_null
    //   159: areturn
    //   160: astore 6
    //   162: ldc 69
    //   164: iconst_1
    //   165: aload 6
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   174: aload 5
    //   176: monitorexit
    //   177: goto +8 -> 185
    //   180: aload 5
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    //   185: aload_1
    //   186: aload_2
    //   187: invokestatic 67	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   190: aconst_null
    //   191: iconst_1
    //   192: invokestatic 111	com/tencent/mobileqq/apollo/game/ApolloGameTool:a	(Ljava/lang/String;ILjava/lang/String;Z)Ljava/lang/String;
    //   195: astore 7
    //   197: aload 7
    //   199: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifeq +5 -> 207
    //   205: aconst_null
    //   206: areturn
    //   207: getstatic 20	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   210: aload_2
    //   211: invokevirtual 112	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   214: checkcast 114	android/util/LruCache
    //   217: astore_1
    //   218: aload_1
    //   219: astore 5
    //   221: aload_1
    //   222: ifnonnull +25 -> 247
    //   225: new 116	com/tencent/mobileqq/apollo/game/ApolloGameResManager$1
    //   228: dup
    //   229: aload_0
    //   230: ldc 117
    //   232: invokespecial 120	com/tencent/mobileqq/apollo/game/ApolloGameResManager$1:<init>	(Lcom/tencent/mobileqq/apollo/game/ApolloGameResManager;I)V
    //   235: astore 5
    //   237: getstatic 20	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   240: aload_2
    //   241: aload 5
    //   243: invokevirtual 121	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: aload 5
    //   249: aload 7
    //   251: invokevirtual 122	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   254: checkcast 124	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes
    //   257: astore_1
    //   258: aload_1
    //   259: ifnull +5 -> 264
    //   262: aload_1
    //   263: areturn
    //   264: iload_3
    //   265: ifeq +380 -> 645
    //   268: aload_1
    //   269: astore 6
    //   271: getstatic 26	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   274: astore 8
    //   276: aload_1
    //   277: astore 6
    //   279: aload 8
    //   281: monitorenter
    //   282: aload_1
    //   283: astore 6
    //   285: getstatic 26	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   288: aload_2
    //   289: invokevirtual 94	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   292: checkcast 77	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify
    //   295: astore 9
    //   297: aload_1
    //   298: astore 6
    //   300: aload_2
    //   301: invokestatic 126	com/tencent/mobileqq/apollo/game/ApolloGameResManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   304: astore_2
    //   305: aload_1
    //   306: astore 6
    //   308: new 35	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   315: astore 10
    //   317: aload_1
    //   318: astore 6
    //   320: aload 10
    //   322: aload_2
    //   323: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_1
    //   328: astore 6
    //   330: aload 10
    //   332: ldc 128
    //   334: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_1
    //   339: astore 6
    //   341: aload 7
    //   343: aload 10
    //   345: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: ldc 130
    //   350: invokevirtual 134	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   353: astore_2
    //   354: aload 9
    //   356: ifnull +160 -> 516
    //   359: aload_1
    //   360: astore 6
    //   362: aload 9
    //   364: aload_2
    //   365: invokevirtual 137	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:a	(Ljava/lang/String;)Z
    //   368: ifeq +148 -> 516
    //   371: aload_1
    //   372: astore 6
    //   374: aload 9
    //   376: aload 7
    //   378: aload_2
    //   379: invokevirtual 140	com/tencent/mobileqq/apollo/game/utils/ApolloGameRscVerify:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   382: ifne +6 -> 388
    //   385: goto +131 -> 516
    //   388: aload_1
    //   389: astore 6
    //   391: new 124	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes
    //   394: dup
    //   395: invokespecial 141	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:<init>	()V
    //   398: astore_2
    //   399: aload_2
    //   400: aload 7
    //   402: putfield 144	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:b	Ljava/lang/String;
    //   405: ldc 146
    //   407: astore_1
    //   408: aload 7
    //   410: ldc 148
    //   412: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   415: ifeq +9 -> 424
    //   418: ldc 153
    //   420: astore_1
    //   421: goto +62 -> 483
    //   424: aload 7
    //   426: ldc 155
    //   428: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   431: ifeq +9 -> 440
    //   434: ldc 157
    //   436: astore_1
    //   437: goto +46 -> 483
    //   440: aload 7
    //   442: ldc 159
    //   444: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   447: ifne +322 -> 769
    //   450: aload 7
    //   452: ldc 161
    //   454: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   457: ifne +312 -> 769
    //   460: aload 7
    //   462: ldc 163
    //   464: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   467: ifne +302 -> 769
    //   470: aload 7
    //   472: ldc 165
    //   474: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   477: ifeq +6 -> 483
    //   480: goto +289 -> 769
    //   483: aload_2
    //   484: aload_1
    //   485: putfield 167	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:a	Ljava/lang/String;
    //   488: aload_2
    //   489: invokevirtual 169	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:a	()V
    //   492: aload 5
    //   494: aload 7
    //   496: aload_2
    //   497: invokevirtual 170	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   500: pop
    //   501: aload 8
    //   503: monitorexit
    //   504: aload_2
    //   505: areturn
    //   506: astore 5
    //   508: aload_2
    //   509: astore_1
    //   510: aload 5
    //   512: astore_2
    //   513: goto +106 -> 619
    //   516: aload_1
    //   517: astore 6
    //   519: new 35	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   526: astore 5
    //   528: aload_1
    //   529: astore 6
    //   531: aload 5
    //   533: ldc 172
    //   535: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload_1
    //   540: astore 6
    //   542: aload 5
    //   544: aload 7
    //   546: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload_1
    //   551: astore 6
    //   553: aload 5
    //   555: ldc 174
    //   557: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload_1
    //   562: astore 6
    //   564: aload 5
    //   566: aload_2
    //   567: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload_1
    //   572: astore 6
    //   574: aload 5
    //   576: ldc 174
    //   578: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload_1
    //   583: astore 6
    //   585: aload 5
    //   587: invokestatic 180	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   590: invokevirtual 183	java/lang/Thread:getName	()Ljava/lang/String;
    //   593: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload_1
    //   598: astore 6
    //   600: ldc 69
    //   602: iconst_1
    //   603: aload 5
    //   605: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: aload_1
    //   612: astore 6
    //   614: aload 8
    //   616: monitorexit
    //   617: aconst_null
    //   618: areturn
    //   619: aload_1
    //   620: astore 6
    //   622: aload 8
    //   624: monitorexit
    //   625: aload_1
    //   626: astore 6
    //   628: aload_2
    //   629: athrow
    //   630: astore_1
    //   631: ldc 69
    //   633: iconst_1
    //   634: aload_1
    //   635: iconst_0
    //   636: anewarray 4	java/lang/Object
    //   639: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   642: aload 6
    //   644: areturn
    //   645: new 124	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes
    //   648: dup
    //   649: invokespecial 141	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:<init>	()V
    //   652: astore_2
    //   653: aload_2
    //   654: aload 7
    //   656: putfield 144	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:b	Ljava/lang/String;
    //   659: aload 7
    //   661: ldc 148
    //   663: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   666: ifeq +9 -> 675
    //   669: ldc 153
    //   671: astore_1
    //   672: goto +71 -> 743
    //   675: aload 7
    //   677: ldc 155
    //   679: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   682: ifeq +9 -> 691
    //   685: ldc 157
    //   687: astore_1
    //   688: goto +55 -> 743
    //   691: aload 7
    //   693: ldc 159
    //   695: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   698: ifne +42 -> 740
    //   701: aload 7
    //   703: ldc 161
    //   705: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   708: ifne +32 -> 740
    //   711: aload 7
    //   713: ldc 163
    //   715: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   718: ifne +22 -> 740
    //   721: aload 7
    //   723: ldc 165
    //   725: invokevirtual 151	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   728: ifeq +6 -> 734
    //   731: goto +9 -> 740
    //   734: ldc 146
    //   736: astore_1
    //   737: goto +6 -> 743
    //   740: ldc 185
    //   742: astore_1
    //   743: aload_2
    //   744: aload_1
    //   745: putfield 167	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:a	Ljava/lang/String;
    //   748: aload_2
    //   749: invokevirtual 169	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:a	()V
    //   752: aload 5
    //   754: aload 7
    //   756: aload_2
    //   757: invokevirtual 170	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   760: pop
    //   761: aload_2
    //   762: areturn
    //   763: aconst_null
    //   764: areturn
    //   765: astore_1
    //   766: goto -586 -> 180
    //   769: ldc 185
    //   771: astore_1
    //   772: goto -289 -> 483
    //   775: astore_2
    //   776: aload 6
    //   778: astore_1
    //   779: goto -160 -> 619
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	782	0	this	ApolloGameResManager
    //   0	782	1	paramString1	String
    //   0	782	2	paramString2	String
    //   36	229	3	i	int
    //   100	20	4	j	int
    //   40	6	5	localThrowable1	Throwable
    //   91	402	5	localObject1	Object
    //   506	5	5	localObject2	Object
    //   526	227	5	localStringBuilder1	StringBuilder
    //   124	15	6	localApolloGameRscVerify1	ApolloGameRscVerify
    //   160	6	6	localThrowable2	Throwable
    //   269	508	6	str1	String
    //   195	560	7	str2	String
    //   274	349	8	localHashMap	HashMap
    //   295	80	9	localApolloGameRscVerify2	ApolloGameRscVerify
    //   315	29	10	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   32	37	40	java/lang/Throwable
    //   96	144	160	java/lang/Throwable
    //   147	155	160	java/lang/Throwable
    //   399	405	506	finally
    //   408	418	506	finally
    //   424	434	506	finally
    //   440	470	506	finally
    //   470	480	506	finally
    //   483	504	506	finally
    //   271	276	630	java/lang/Throwable
    //   279	282	630	java/lang/Throwable
    //   628	630	630	java/lang/Throwable
    //   96	144	765	finally
    //   147	155	765	finally
    //   155	158	765	finally
    //   162	174	765	finally
    //   174	177	765	finally
    //   180	183	765	finally
    //   285	297	775	finally
    //   300	305	775	finally
    //   308	317	775	finally
    //   320	327	775	finally
    //   330	338	775	finally
    //   341	354	775	finally
    //   362	371	775	finally
    //   374	385	775	finally
    //   391	399	775	finally
    //   519	528	775	finally
    //   531	539	775	finally
    //   542	550	775	finally
    //   553	561	775	finally
    //   564	571	775	finally
    //   574	582	775	finally
    //   585	597	775	finally
    //   600	611	775	finally
    //   614	617	775	finally
    //   622	625	775	finally
  }
  
  public void a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager != null) {
        jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager = null;
      }
      if (jdField_a_of_type_ComTencentUtilLRULinkedHashMap != null) {
        jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
      }
      if (jdField_a_of_type_JavaUtilHashMap != null)
      {
        jdField_a_of_type_JavaUtilHashMap.clear();
        jdField_a_of_type_JavaUtilHashMap = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloGameResManager", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameResManager
 * JD-Core Version:    0.7.0.1
 */