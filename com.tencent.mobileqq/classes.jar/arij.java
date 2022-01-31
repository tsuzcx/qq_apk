public class arij
  implements arii
{
  /* Error */
  public void a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aload_1
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: new 17	com/tencent/mobileqq/data/QQEntityManagerFactory
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 19	com/tencent/mobileqq/data/QQEntityManagerFactory:<init>	(Ljava/lang/String;)V
    //   21: astore 8
    //   23: aload 8
    //   25: aload_1
    //   26: invokevirtual 25	atmq:build	(Ljava/lang/String;)Lajrl;
    //   29: invokevirtual 30	ajrl:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   32: astore 9
    //   34: aload 9
    //   36: ldc 32
    //   38: aconst_null
    //   39: invokevirtual 37	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +165 -> 209
    //   47: aload_3
    //   48: invokeinterface 43 1 0
    //   53: ifeq +156 -> 209
    //   56: aload 9
    //   58: aload_3
    //   59: iconst_0
    //   60: invokeinterface 47 2 0
    //   65: invokestatic 52	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   74: pop
    //   75: goto -28 -> 47
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_2
    //   81: aconst_null
    //   82: astore 4
    //   84: aload_3
    //   85: ifnull +9 -> 94
    //   88: aload_3
    //   89: invokeinterface 61 1 0
    //   94: aload 4
    //   96: ifnull +10 -> 106
    //   99: aload 4
    //   101: invokeinterface 61 1 0
    //   106: aload_2
    //   107: ifnull +9 -> 116
    //   110: aload_2
    //   111: invokeinterface 61 1 0
    //   116: new 63	atoa
    //   119: dup
    //   120: aload_1
    //   121: invokespecial 64	atoa:<init>	(Ljava/lang/String;)V
    //   124: aload_1
    //   125: invokevirtual 25	atmq:build	(Ljava/lang/String;)Lajrl;
    //   128: invokevirtual 30	ajrl:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   131: astore 4
    //   133: aload 6
    //   135: astore_1
    //   136: aload 5
    //   138: astore_2
    //   139: aload 4
    //   141: ldc 32
    //   143: aconst_null
    //   144: invokevirtual 37	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   147: astore_3
    //   148: aload_3
    //   149: ifnull +426 -> 575
    //   152: aload_3
    //   153: astore_1
    //   154: aload_3
    //   155: astore_2
    //   156: aload_3
    //   157: invokeinterface 43 1 0
    //   162: ifeq +413 -> 575
    //   165: aload_3
    //   166: astore_1
    //   167: aload_3
    //   168: astore_2
    //   169: aload 4
    //   171: aload_3
    //   172: iconst_0
    //   173: invokeinterface 47 2 0
    //   178: invokestatic 52	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   181: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   184: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   187: pop
    //   188: goto -36 -> 152
    //   191: astore_3
    //   192: aload_1
    //   193: astore_2
    //   194: aload_3
    //   195: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   198: aload_1
    //   199: ifnull -187 -> 12
    //   202: aload_1
    //   203: invokeinterface 61 1 0
    //   208: return
    //   209: aload 9
    //   211: ldc 69
    //   213: aconst_null
    //   214: invokevirtual 37	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   217: astore 4
    //   219: aload 4
    //   221: ifnull +36 -> 257
    //   224: aload 4
    //   226: invokeinterface 43 1 0
    //   231: ifeq +26 -> 257
    //   234: aload 9
    //   236: aload 4
    //   238: iconst_0
    //   239: invokeinterface 47 2 0
    //   244: invokestatic 52	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   247: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   250: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   253: pop
    //   254: goto -30 -> 224
    //   257: aload 9
    //   259: ldc 71
    //   261: aconst_null
    //   262: invokevirtual 37	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   265: astore 7
    //   267: aload 7
    //   269: astore_2
    //   270: aload_2
    //   271: ifnull +34 -> 305
    //   274: aload_2
    //   275: invokeinterface 43 1 0
    //   280: ifeq +25 -> 305
    //   283: aload 9
    //   285: aload_2
    //   286: iconst_0
    //   287: invokeinterface 47 2 0
    //   292: invokestatic 52	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   295: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   298: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   301: pop
    //   302: goto -28 -> 274
    //   305: aload 9
    //   307: new 73	com/tencent/mobileqq/data/RecentUser
    //   310: dup
    //   311: invokespecial 74	com/tencent/mobileqq/data/RecentUser:<init>	()V
    //   314: invokevirtual 78	com/tencent/mobileqq/data/RecentUser:getTableName	()Ljava/lang/String;
    //   317: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   320: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   323: pop
    //   324: aload 9
    //   326: new 80	com/tencent/mobileqq/data/QCallRecent
    //   329: dup
    //   330: invokespecial 81	com/tencent/mobileqq/data/QCallRecent:<init>	()V
    //   333: invokevirtual 82	com/tencent/mobileqq/data/QCallRecent:getTableName	()Ljava/lang/String;
    //   336: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   339: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   342: pop
    //   343: aload 9
    //   345: new 84	com/tencent/mobileqq/data/TroopAssistantData
    //   348: dup
    //   349: invokespecial 85	com/tencent/mobileqq/data/TroopAssistantData:<init>	()V
    //   352: invokevirtual 86	com/tencent/mobileqq/data/TroopAssistantData:getTableName	()Ljava/lang/String;
    //   355: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   358: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   361: pop
    //   362: aload 9
    //   364: new 88	com/tencent/mobileqq/data/PubAccountAssistantData
    //   367: dup
    //   368: invokespecial 89	com/tencent/mobileqq/data/PubAccountAssistantData:<init>	()V
    //   371: invokevirtual 90	com/tencent/mobileqq/data/PubAccountAssistantData:getTableName	()Ljava/lang/String;
    //   374: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   377: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   380: pop
    //   381: aload 9
    //   383: new 92	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   386: dup
    //   387: invokespecial 93	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:<init>	()V
    //   390: invokevirtual 94	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:getTableName	()Ljava/lang/String;
    //   393: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   396: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   399: pop
    //   400: aload 9
    //   402: new 96	com/tencent/mobileqq/data/NeedHandleUserData
    //   405: dup
    //   406: invokespecial 97	com/tencent/mobileqq/data/NeedHandleUserData:<init>	()V
    //   409: invokevirtual 98	com/tencent/mobileqq/data/NeedHandleUserData:getTableName	()Ljava/lang/String;
    //   412: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   415: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   418: pop
    //   419: aload 9
    //   421: new 100	com/tencent/mobileqq/data/ConversationInfo
    //   424: dup
    //   425: invokespecial 101	com/tencent/mobileqq/data/ConversationInfo:<init>	()V
    //   428: invokevirtual 102	com/tencent/mobileqq/data/ConversationInfo:getTableName	()Ljava/lang/String;
    //   431: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   434: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   437: pop
    //   438: aload 9
    //   440: new 104	com/tencent/mobileqq/data/RecommendContact
    //   443: dup
    //   444: invokespecial 105	com/tencent/mobileqq/data/RecommendContact:<init>	()V
    //   447: invokevirtual 106	com/tencent/mobileqq/data/RecommendContact:getTableName	()Ljava/lang/String;
    //   450: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   453: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   456: pop
    //   457: aload 9
    //   459: new 108	com/tencent/mobileqq/data/SubAccountInfo
    //   462: dup
    //   463: invokespecial 109	com/tencent/mobileqq/data/SubAccountInfo:<init>	()V
    //   466: invokevirtual 110	com/tencent/mobileqq/data/SubAccountInfo:getTableName	()Ljava/lang/String;
    //   469: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   472: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   475: pop
    //   476: aload 9
    //   478: new 112	com/tencent/mobileqq/data/SubAccountMessage
    //   481: dup
    //   482: invokespecial 113	com/tencent/mobileqq/data/SubAccountMessage:<init>	()V
    //   485: invokevirtual 114	com/tencent/mobileqq/data/SubAccountMessage:getTableName	()Ljava/lang/String;
    //   488: invokestatic 55	atnp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   491: invokevirtual 58	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   494: pop
    //   495: aload 8
    //   497: invokevirtual 115	atmq:close	()V
    //   500: aload_3
    //   501: ifnull +9 -> 510
    //   504: aload_3
    //   505: invokeinterface 61 1 0
    //   510: aload 4
    //   512: ifnull +10 -> 522
    //   515: aload 4
    //   517: invokeinterface 61 1 0
    //   522: aload_2
    //   523: ifnull -407 -> 116
    //   526: aload_2
    //   527: invokeinterface 61 1 0
    //   532: goto -416 -> 116
    //   535: astore_1
    //   536: aconst_null
    //   537: astore 4
    //   539: aconst_null
    //   540: astore_3
    //   541: aload_3
    //   542: ifnull +9 -> 551
    //   545: aload_3
    //   546: invokeinterface 61 1 0
    //   551: aload 4
    //   553: ifnull +10 -> 563
    //   556: aload 4
    //   558: invokeinterface 61 1 0
    //   563: aload_2
    //   564: ifnull +9 -> 573
    //   567: aload_2
    //   568: invokeinterface 61 1 0
    //   573: aload_1
    //   574: athrow
    //   575: aload_3
    //   576: ifnull -564 -> 12
    //   579: aload_3
    //   580: invokeinterface 61 1 0
    //   585: return
    //   586: astore_1
    //   587: aload_2
    //   588: ifnull +9 -> 597
    //   591: aload_2
    //   592: invokeinterface 61 1 0
    //   597: aload_1
    //   598: athrow
    //   599: astore_1
    //   600: aconst_null
    //   601: astore 4
    //   603: goto -62 -> 541
    //   606: astore_1
    //   607: goto -66 -> 541
    //   610: astore_1
    //   611: goto -70 -> 541
    //   614: astore_2
    //   615: aconst_null
    //   616: astore_2
    //   617: aconst_null
    //   618: astore 4
    //   620: aconst_null
    //   621: astore_3
    //   622: goto -538 -> 84
    //   625: astore_2
    //   626: aconst_null
    //   627: astore_2
    //   628: goto -544 -> 84
    //   631: astore 7
    //   633: goto -549 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	this	arij
    //   0	636	1	paramString	java.lang.String
    //   1	1	2	localObject1	Object
    //   78	1	2	localException1	java.lang.Exception
    //   80	512	2	localObject2	Object
    //   614	1	2	localException2	java.lang.Exception
    //   616	1	2	localObject3	Object
    //   625	1	2	localException3	java.lang.Exception
    //   627	1	2	localObject4	Object
    //   42	130	3	localCursor1	android.database.Cursor
    //   191	314	3	localException4	java.lang.Exception
    //   540	82	3	localObject5	Object
    //   82	537	4	localObject6	Object
    //   3	134	5	localObject7	Object
    //   6	128	6	localObject8	Object
    //   265	3	7	localCursor2	android.database.Cursor
    //   631	1	7	localException5	java.lang.Exception
    //   21	475	8	localQQEntityManagerFactory	com.tencent.mobileqq.data.QQEntityManagerFactory
    //   32	445	9	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   47	75	78	java/lang/Exception
    //   209	219	78	java/lang/Exception
    //   139	148	191	java/lang/Exception
    //   156	165	191	java/lang/Exception
    //   169	188	191	java/lang/Exception
    //   34	43	535	finally
    //   139	148	586	finally
    //   156	165	586	finally
    //   169	188	586	finally
    //   194	198	586	finally
    //   47	75	599	finally
    //   209	219	599	finally
    //   224	254	606	finally
    //   257	267	606	finally
    //   274	302	610	finally
    //   305	500	610	finally
    //   34	43	614	java/lang/Exception
    //   224	254	625	java/lang/Exception
    //   257	267	625	java/lang/Exception
    //   274	302	631	java/lang/Exception
    //   305	500	631	java/lang/Exception
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arij
 * JD-Core Version:    0.7.0.1
 */