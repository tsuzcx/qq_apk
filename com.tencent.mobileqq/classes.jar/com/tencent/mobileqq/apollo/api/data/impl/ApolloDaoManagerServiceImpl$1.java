package com.tencent.mobileqq.apollo.api.data.impl;

class ApolloDaoManagerServiceImpl$1
  implements Runnable
{
  ApolloDaoManagerServiceImpl$1(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   6: getfield 27	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   9: ifnull +992 -> 1001
    //   12: aload_0
    //   13: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   16: getfield 27	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   19: invokevirtual 33	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: astore_2
    //   23: goto +978 -> 1001
    //   26: aload_0
    //   27: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   30: getfield 27	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   33: invokevirtual 37	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   36: invokevirtual 43	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +964 -> 1005
    //   44: aload_0
    //   45: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   48: iconst_1
    //   49: aconst_null
    //   50: invokevirtual 47	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:saveWhiteFaceIdMapping	(ZLjava/util/List;)V
    //   53: aload_2
    //   54: ldc 49
    //   56: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnull +72 -> 135
    //   66: aload_0
    //   67: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   70: getfield 59	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   73: astore_3
    //   74: aload_3
    //   75: monitorenter
    //   76: aload_0
    //   77: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   80: aload 4
    //   82: putfield 59	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   85: iconst_0
    //   86: istore_1
    //   87: iload_1
    //   88: aload_0
    //   89: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   92: getfield 59	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   95: invokeinterface 65 1 0
    //   100: if_icmpge +33 -> 133
    //   103: aload_0
    //   104: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   107: aload_0
    //   108: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   111: getfield 59	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionList	Ljava/util/List;
    //   114: iload_1
    //   115: invokeinterface 69 2 0
    //   120: checkcast 49	com/tencent/mobileqq/apollo/api/model/ApolloActionData
    //   123: invokestatic 73	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:access$000	(Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;)V
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_1
    //   130: goto -43 -> 87
    //   133: aload_3
    //   134: monitorexit
    //   135: aload_2
    //   136: ldc 75
    //   138: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   141: astore 4
    //   143: aload 4
    //   145: ifnull +24 -> 169
    //   148: aload_0
    //   149: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   152: getfield 78	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   155: astore_3
    //   156: aload_3
    //   157: monitorenter
    //   158: aload_0
    //   159: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   162: aload 4
    //   164: putfield 78	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:packageList	Ljava/util/List;
    //   167: aload_3
    //   168: monitorexit
    //   169: aload_2
    //   170: ldc 80
    //   172: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   175: astore 4
    //   177: aload 4
    //   179: ifnull +24 -> 203
    //   182: aload_0
    //   183: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   186: getfield 83	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionPackageList	Ljava/util/List;
    //   189: astore_3
    //   190: aload_3
    //   191: monitorenter
    //   192: aload_0
    //   193: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   196: aload 4
    //   198: putfield 83	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionPackageList	Ljava/util/List;
    //   201: aload_3
    //   202: monitorexit
    //   203: aload_2
    //   204: ldc 85
    //   206: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   209: astore 4
    //   211: aload_0
    //   212: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   215: getfield 88	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   218: ifnull +29 -> 247
    //   221: aload_0
    //   222: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   225: getfield 88	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   228: astore_3
    //   229: aload_3
    //   230: monitorenter
    //   231: aload 4
    //   233: ifnull +12 -> 245
    //   236: aload_0
    //   237: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   240: aload 4
    //   242: putfield 88	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:favActionList	Ljava/util/List;
    //   245: aload_3
    //   246: monitorexit
    //   247: aload_2
    //   248: ldc 90
    //   250: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   253: astore 4
    //   255: aload_0
    //   256: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   259: getfield 93	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameList	Ljava/util/List;
    //   262: ifnull +29 -> 291
    //   265: aload_0
    //   266: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   269: getfield 93	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameList	Ljava/util/List;
    //   272: astore_3
    //   273: aload_3
    //   274: monitorenter
    //   275: aload 4
    //   277: ifnull +12 -> 289
    //   280: aload_0
    //   281: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   284: aload 4
    //   286: putfield 93	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameList	Ljava/util/List;
    //   289: aload_3
    //   290: monitorexit
    //   291: aload_2
    //   292: ldc 95
    //   294: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   297: astore 4
    //   299: aload 4
    //   301: ifnull +43 -> 344
    //   304: aload_0
    //   305: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   308: getfield 98	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   311: ifnull +33 -> 344
    //   314: aload_0
    //   315: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   318: getfield 98	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   321: astore_3
    //   322: aload_3
    //   323: monitorenter
    //   324: aload_0
    //   325: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   328: aload 4
    //   330: putfield 98	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   333: aload_0
    //   334: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   337: aload 4
    //   339: invokevirtual 102	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:saveTabGameRoamList	(Ljava/util/List;)V
    //   342: aload_3
    //   343: monitorexit
    //   344: aload_0
    //   345: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   348: getfield 98	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   351: ifnull +18 -> 369
    //   354: aload_0
    //   355: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   358: getfield 98	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:gameRoamList	Ljava/util/List;
    //   361: invokeinterface 65 1 0
    //   366: ifne +22 -> 388
    //   369: ldc 104
    //   371: iconst_1
    //   372: ldc 106
    //   374: invokestatic 112	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload_0
    //   378: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   381: getfield 27	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   384: lconst_0
    //   385: invokestatic 118	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(Lcom/tencent/common/app/AppInterface;J)V
    //   388: aload_2
    //   389: ldc 120
    //   391: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   394: astore_3
    //   395: aload_3
    //   396: ifnull +33 -> 429
    //   399: aload_3
    //   400: monitorenter
    //   401: aload_0
    //   402: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   405: getfield 123	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mBattleGameList	Ljava/util/List;
    //   408: invokeinterface 126 1 0
    //   413: aload_0
    //   414: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   417: getfield 123	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mBattleGameList	Ljava/util/List;
    //   420: aload_3
    //   421: invokeinterface 130 2 0
    //   426: pop
    //   427: aload_3
    //   428: monitorexit
    //   429: aload_2
    //   430: ldc 132
    //   432: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   435: astore 4
    //   437: aload 4
    //   439: ifnull +44 -> 483
    //   442: aload 4
    //   444: invokeinterface 65 1 0
    //   449: ifle +34 -> 483
    //   452: aload_0
    //   453: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   456: getfield 135	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionPushList	Ljava/util/List;
    //   459: ifnull +24 -> 483
    //   462: aload_0
    //   463: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   466: getfield 135	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionPushList	Ljava/util/List;
    //   469: astore_3
    //   470: aload_3
    //   471: monitorenter
    //   472: aload_0
    //   473: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   476: aload 4
    //   478: putfield 135	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:actionPushList	Ljava/util/List;
    //   481: aload_3
    //   482: monitorexit
    //   483: aload_2
    //   484: ldc 137
    //   486: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   489: astore 4
    //   491: aload 4
    //   493: ifnull +44 -> 537
    //   496: aload 4
    //   498: invokeinterface 65 1 0
    //   503: ifle +34 -> 537
    //   506: aload_0
    //   507: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   510: getfield 140	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   513: ifnull +24 -> 537
    //   516: aload_0
    //   517: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   520: getfield 140	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   523: astore_3
    //   524: aload_3
    //   525: monitorenter
    //   526: aload_0
    //   527: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   530: aload 4
    //   532: putfield 140	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mActionObtainedList	Ljava/util/List;
    //   535: aload_3
    //   536: monitorexit
    //   537: aload_2
    //   538: ldc 142
    //   540: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   543: astore 4
    //   545: aload 4
    //   547: ifnull +45 -> 592
    //   550: aload 4
    //   552: invokeinterface 65 1 0
    //   557: ifle +35 -> 592
    //   560: aload_0
    //   561: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   564: invokestatic 146	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:access$100	(Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;)Ljava/util/List;
    //   567: ifnull +25 -> 592
    //   570: aload_0
    //   571: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   574: invokestatic 146	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:access$100	(Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;)Ljava/util/List;
    //   577: astore_3
    //   578: aload_3
    //   579: monitorenter
    //   580: aload_0
    //   581: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   584: aload 4
    //   586: invokestatic 150	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:access$102	(Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;Ljava/util/List;)Ljava/util/List;
    //   589: pop
    //   590: aload_3
    //   591: monitorexit
    //   592: aload_2
    //   593: ldc 152
    //   595: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   598: astore 4
    //   600: aload 4
    //   602: ifnull +195 -> 797
    //   605: aload 4
    //   607: invokeinterface 65 1 0
    //   612: ifle +185 -> 797
    //   615: aload_0
    //   616: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   619: getfield 155	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mGameRedDotList	Ljava/util/List;
    //   622: ifnull +175 -> 797
    //   625: aload_0
    //   626: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   629: invokestatic 159	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:access$200	(Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;)Ljava/lang/Object;
    //   632: astore_3
    //   633: aload_3
    //   634: monitorenter
    //   635: aload_0
    //   636: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   639: getfield 155	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mGameRedDotList	Ljava/util/List;
    //   642: invokeinterface 126 1 0
    //   647: aload 4
    //   649: invokeinterface 163 1 0
    //   654: astore 4
    //   656: aload 4
    //   658: invokeinterface 169 1 0
    //   663: ifeq +132 -> 795
    //   666: aload 4
    //   668: invokeinterface 173 1 0
    //   673: checkcast 152	com/tencent/mobileqq/apollo/api/model/ApolloGameRedDot
    //   676: astore 5
    //   678: aload 5
    //   680: invokevirtual 176	com/tencent/mobileqq/apollo/api/model/ApolloGameRedDot:isTimeValid	()Z
    //   683: ifeq -27 -> 656
    //   686: aload_0
    //   687: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   690: getfield 155	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mGameRedDotList	Ljava/util/List;
    //   693: aload 5
    //   695: invokeinterface 180 2 0
    //   700: pop
    //   701: goto -45 -> 656
    //   704: astore_2
    //   705: aload_3
    //   706: monitorexit
    //   707: aload_2
    //   708: athrow
    //   709: astore_2
    //   710: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq +292 -> 1005
    //   716: ldc 104
    //   718: iconst_2
    //   719: aload_2
    //   720: invokevirtual 187	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   723: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   726: return
    //   727: astore_2
    //   728: aload_3
    //   729: monitorexit
    //   730: aload_2
    //   731: athrow
    //   732: astore_2
    //   733: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   736: ifeq +269 -> 1005
    //   739: ldc 104
    //   741: iconst_2
    //   742: aload_2
    //   743: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   746: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: return
    //   750: astore_2
    //   751: aload_3
    //   752: monitorexit
    //   753: aload_2
    //   754: athrow
    //   755: astore_2
    //   756: aload_3
    //   757: monitorexit
    //   758: aload_2
    //   759: athrow
    //   760: astore_2
    //   761: aload_3
    //   762: monitorexit
    //   763: aload_2
    //   764: athrow
    //   765: astore_2
    //   766: aload_3
    //   767: monitorexit
    //   768: aload_2
    //   769: athrow
    //   770: astore_2
    //   771: aload_3
    //   772: monitorexit
    //   773: aload_2
    //   774: athrow
    //   775: astore_2
    //   776: aload_3
    //   777: monitorexit
    //   778: aload_2
    //   779: athrow
    //   780: astore_2
    //   781: aload_3
    //   782: monitorexit
    //   783: aload_2
    //   784: athrow
    //   785: astore_2
    //   786: aload_3
    //   787: monitorexit
    //   788: aload_2
    //   789: athrow
    //   790: astore_2
    //   791: aload_3
    //   792: monitorexit
    //   793: aload_2
    //   794: athrow
    //   795: aload_3
    //   796: monitorexit
    //   797: aload_2
    //   798: ldc 193
    //   800: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   803: astore 4
    //   805: aload 4
    //   807: ifnull +44 -> 851
    //   810: aload 4
    //   812: invokeinterface 65 1 0
    //   817: ifle +34 -> 851
    //   820: aload_0
    //   821: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   824: getfield 196	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mScoreData	Ljava/util/List;
    //   827: ifnull +24 -> 851
    //   830: aload_0
    //   831: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   834: getfield 196	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mScoreData	Ljava/util/List;
    //   837: astore_3
    //   838: aload_3
    //   839: monitorenter
    //   840: aload_0
    //   841: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   844: aload 4
    //   846: putfield 196	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mScoreData	Ljava/util/List;
    //   849: aload_3
    //   850: monitorexit
    //   851: aload_2
    //   852: ldc 198
    //   854: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   857: astore 4
    //   859: aload 4
    //   861: ifnull +39 -> 900
    //   864: aload 4
    //   866: invokeinterface 65 1 0
    //   871: ifle +29 -> 900
    //   874: aload 4
    //   876: ifnull +24 -> 900
    //   879: aload_0
    //   880: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   883: getfield 201	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRankData	Ljava/util/List;
    //   886: astore_3
    //   887: aload_3
    //   888: monitorenter
    //   889: aload_0
    //   890: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   893: aload 4
    //   895: putfield 201	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRankData	Ljava/util/List;
    //   898: aload_3
    //   899: monitorexit
    //   900: aload_2
    //   901: ldc 203
    //   903: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   906: astore 4
    //   908: aload 4
    //   910: ifnull +34 -> 944
    //   913: aload 4
    //   915: invokeinterface 65 1 0
    //   920: ifle +24 -> 944
    //   923: aload_0
    //   924: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   927: getfield 206	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRecommendActionList	Ljava/util/List;
    //   930: astore_3
    //   931: aload_3
    //   932: monitorenter
    //   933: aload_0
    //   934: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   937: aload 4
    //   939: putfield 206	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mRecommendActionList	Ljava/util/List;
    //   942: aload_3
    //   943: monitorexit
    //   944: aload_2
    //   945: invokestatic 209	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:a	(Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   948: aload_0
    //   949: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   952: invokevirtual 212	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:readApolloGameVerFromFile	()V
    //   955: aload_0
    //   956: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   959: getfield 27	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   962: ifnull +43 -> 1005
    //   965: aload_0
    //   966: getfield 12	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl$1:this$0	Lcom/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl;
    //   969: getfield 27	com/tencent/mobileqq/apollo/api/data/impl/ApolloDaoManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   972: ldc 214
    //   974: ldc 216
    //   976: invokevirtual 220	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   979: checkcast 222	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl
    //   982: invokevirtual 225	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:checkCompat2DActionRsc	()V
    //   985: return
    //   986: astore_2
    //   987: aload_3
    //   988: monitorexit
    //   989: aload_2
    //   990: athrow
    //   991: astore_2
    //   992: aload_3
    //   993: monitorexit
    //   994: aload_2
    //   995: athrow
    //   996: astore_2
    //   997: aload_3
    //   998: monitorexit
    //   999: aload_2
    //   1000: athrow
    //   1001: aload_2
    //   1002: ifnonnull -976 -> 26
    //   1005: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	this	1
    //   86	44	1	i	int
    //   1	592	2	localObject1	Object
    //   704	4	2	localObject2	Object
    //   709	11	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   727	4	2	localObject3	Object
    //   732	11	2	localException	java.lang.Exception
    //   750	4	2	localObject4	Object
    //   755	4	2	localObject5	Object
    //   760	4	2	localObject6	Object
    //   765	4	2	localObject7	Object
    //   770	4	2	localObject8	Object
    //   775	4	2	localObject9	Object
    //   780	4	2	localObject10	Object
    //   785	4	2	localObject11	Object
    //   790	155	2	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   986	4	2	localObject12	Object
    //   991	4	2	localObject13	Object
    //   996	6	2	localObject14	Object
    //   59	879	4	localObject16	Object
    //   676	18	5	localApolloGameRedDot	com.tencent.mobileqq.apollo.api.model.ApolloGameRedDot
    // Exception table:
    //   from	to	target	type
    //   635	656	704	finally
    //   656	701	704	finally
    //   705	707	704	finally
    //   795	797	704	finally
    //   2	23	709	java/lang/OutOfMemoryError
    //   26	40	709	java/lang/OutOfMemoryError
    //   44	61	709	java/lang/OutOfMemoryError
    //   66	76	709	java/lang/OutOfMemoryError
    //   135	143	709	java/lang/OutOfMemoryError
    //   148	158	709	java/lang/OutOfMemoryError
    //   169	177	709	java/lang/OutOfMemoryError
    //   182	192	709	java/lang/OutOfMemoryError
    //   203	231	709	java/lang/OutOfMemoryError
    //   247	275	709	java/lang/OutOfMemoryError
    //   291	299	709	java/lang/OutOfMemoryError
    //   304	324	709	java/lang/OutOfMemoryError
    //   344	369	709	java/lang/OutOfMemoryError
    //   369	388	709	java/lang/OutOfMemoryError
    //   388	395	709	java/lang/OutOfMemoryError
    //   399	401	709	java/lang/OutOfMemoryError
    //   429	437	709	java/lang/OutOfMemoryError
    //   442	472	709	java/lang/OutOfMemoryError
    //   483	491	709	java/lang/OutOfMemoryError
    //   496	526	709	java/lang/OutOfMemoryError
    //   537	545	709	java/lang/OutOfMemoryError
    //   550	580	709	java/lang/OutOfMemoryError
    //   592	600	709	java/lang/OutOfMemoryError
    //   605	635	709	java/lang/OutOfMemoryError
    //   707	709	709	java/lang/OutOfMemoryError
    //   730	732	709	java/lang/OutOfMemoryError
    //   753	755	709	java/lang/OutOfMemoryError
    //   758	760	709	java/lang/OutOfMemoryError
    //   763	765	709	java/lang/OutOfMemoryError
    //   768	770	709	java/lang/OutOfMemoryError
    //   773	775	709	java/lang/OutOfMemoryError
    //   778	780	709	java/lang/OutOfMemoryError
    //   783	785	709	java/lang/OutOfMemoryError
    //   788	790	709	java/lang/OutOfMemoryError
    //   793	795	709	java/lang/OutOfMemoryError
    //   797	805	709	java/lang/OutOfMemoryError
    //   810	840	709	java/lang/OutOfMemoryError
    //   851	859	709	java/lang/OutOfMemoryError
    //   864	874	709	java/lang/OutOfMemoryError
    //   879	889	709	java/lang/OutOfMemoryError
    //   900	908	709	java/lang/OutOfMemoryError
    //   913	933	709	java/lang/OutOfMemoryError
    //   944	985	709	java/lang/OutOfMemoryError
    //   989	991	709	java/lang/OutOfMemoryError
    //   994	996	709	java/lang/OutOfMemoryError
    //   999	1001	709	java/lang/OutOfMemoryError
    //   76	85	727	finally
    //   87	126	727	finally
    //   133	135	727	finally
    //   728	730	727	finally
    //   2	23	732	java/lang/Exception
    //   26	40	732	java/lang/Exception
    //   44	61	732	java/lang/Exception
    //   66	76	732	java/lang/Exception
    //   135	143	732	java/lang/Exception
    //   148	158	732	java/lang/Exception
    //   169	177	732	java/lang/Exception
    //   182	192	732	java/lang/Exception
    //   203	231	732	java/lang/Exception
    //   247	275	732	java/lang/Exception
    //   291	299	732	java/lang/Exception
    //   304	324	732	java/lang/Exception
    //   344	369	732	java/lang/Exception
    //   369	388	732	java/lang/Exception
    //   388	395	732	java/lang/Exception
    //   399	401	732	java/lang/Exception
    //   429	437	732	java/lang/Exception
    //   442	472	732	java/lang/Exception
    //   483	491	732	java/lang/Exception
    //   496	526	732	java/lang/Exception
    //   537	545	732	java/lang/Exception
    //   550	580	732	java/lang/Exception
    //   592	600	732	java/lang/Exception
    //   605	635	732	java/lang/Exception
    //   707	709	732	java/lang/Exception
    //   730	732	732	java/lang/Exception
    //   753	755	732	java/lang/Exception
    //   758	760	732	java/lang/Exception
    //   763	765	732	java/lang/Exception
    //   768	770	732	java/lang/Exception
    //   773	775	732	java/lang/Exception
    //   778	780	732	java/lang/Exception
    //   783	785	732	java/lang/Exception
    //   788	790	732	java/lang/Exception
    //   793	795	732	java/lang/Exception
    //   797	805	732	java/lang/Exception
    //   810	840	732	java/lang/Exception
    //   851	859	732	java/lang/Exception
    //   864	874	732	java/lang/Exception
    //   879	889	732	java/lang/Exception
    //   900	908	732	java/lang/Exception
    //   913	933	732	java/lang/Exception
    //   944	985	732	java/lang/Exception
    //   989	991	732	java/lang/Exception
    //   994	996	732	java/lang/Exception
    //   999	1001	732	java/lang/Exception
    //   158	169	750	finally
    //   751	753	750	finally
    //   192	203	755	finally
    //   756	758	755	finally
    //   236	245	760	finally
    //   245	247	760	finally
    //   761	763	760	finally
    //   280	289	765	finally
    //   289	291	765	finally
    //   766	768	765	finally
    //   324	344	770	finally
    //   771	773	770	finally
    //   401	429	775	finally
    //   776	778	775	finally
    //   472	483	780	finally
    //   781	783	780	finally
    //   526	537	785	finally
    //   786	788	785	finally
    //   580	592	790	finally
    //   791	793	790	finally
    //   840	851	986	finally
    //   987	989	986	finally
    //   889	900	991	finally
    //   992	994	991	finally
    //   933	944	996	finally
    //   997	999	996	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */