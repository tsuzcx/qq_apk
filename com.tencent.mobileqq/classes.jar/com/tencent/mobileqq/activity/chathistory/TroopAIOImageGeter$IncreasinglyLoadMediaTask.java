package com.tencent.mobileqq.activity.chathistory;

class TroopAIOImageGeter$IncreasinglyLoadMediaTask
  implements Runnable
{
  TroopAIOImageGeter$IncreasinglyLoadMediaTask(TroopAIOImageGeter paramTroopAIOImageGeter) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   4: iconst_1
    //   5: putfield 27	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Boolean	Z
    //   8: aload_0
    //   9: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   12: getfield 30	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Int	I
    //   15: iconst_1
    //   16: if_icmpge +27 -> 43
    //   19: aload_0
    //   20: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   23: iconst_0
    //   24: putfield 27	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Boolean	Z
    //   27: aload_0
    //   28: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   31: invokevirtual 32	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:a	()V
    //   34: aload_0
    //   35: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   38: iconst_0
    //   39: putfield 27	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Boolean	Z
    //   42: return
    //   43: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +11 -> 57
    //   49: ldc 40
    //   51: iconst_2
    //   52: ldc 42
    //   54: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   61: getfield 49	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$LoadMediaDataCallBack;
    //   64: ifnonnull +37 -> 101
    //   67: aload_0
    //   68: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   71: getfield 52	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataListener	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$LoadMediaDataListener;
    //   74: ifnonnull +27 -> 101
    //   77: aload_0
    //   78: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   81: iconst_0
    //   82: putfield 27	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Boolean	Z
    //   85: aload_0
    //   86: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   89: invokevirtual 32	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:a	()V
    //   92: aload_0
    //   93: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   96: iconst_0
    //   97: putfield 27	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Boolean	Z
    //   100: return
    //   101: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   104: lstore_2
    //   105: getstatic 64	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   108: aload_0
    //   109: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   112: getfield 67	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   115: invokevirtual 71	com/tencent/common/app/BaseApplicationImpl:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   118: checkcast 73	com/tencent/mobileqq/app/QQAppInterface
    //   121: astore 8
    //   123: new 75	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 76	java/util/ArrayList:<init>	()V
    //   130: astore 7
    //   132: new 75	java/util/ArrayList
    //   135: dup
    //   136: invokespecial 76	java/util/ArrayList:<init>	()V
    //   139: astore 5
    //   141: aload_0
    //   142: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   145: getfield 79	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Boolean	Z
    //   148: ifne +368 -> 516
    //   151: aload_0
    //   152: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   155: getfield 81	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   158: ifnonnull +27 -> 185
    //   161: aload_0
    //   162: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   165: iconst_0
    //   166: putfield 27	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Boolean	Z
    //   169: aload_0
    //   170: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   173: invokevirtual 32	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:a	()V
    //   176: aload_0
    //   177: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   180: iconst_0
    //   181: putfield 27	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Boolean	Z
    //   184: return
    //   185: bipush 8
    //   187: newarray int
    //   189: astore 9
    //   191: aload 9
    //   193: iconst_0
    //   194: sipush -20000
    //   197: iastore
    //   198: aload 9
    //   200: iconst_1
    //   201: sipush -2000
    //   204: iastore
    //   205: aload 9
    //   207: iconst_2
    //   208: sipush -1035
    //   211: iastore
    //   212: aload 9
    //   214: iconst_3
    //   215: sipush -2011
    //   218: iastore
    //   219: aload 9
    //   221: iconst_4
    //   222: sipush -2022
    //   225: iastore
    //   226: aload 9
    //   228: iconst_5
    //   229: sipush -2005
    //   232: iastore
    //   233: aload 9
    //   235: bipush 6
    //   237: sipush -2017
    //   240: iastore
    //   241: aload 9
    //   243: bipush 7
    //   245: sipush -2071
    //   248: iastore
    //   249: aload_0
    //   250: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   253: getfield 84	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_c_of_type_Boolean	Z
    //   256: ifne +95 -> 351
    //   259: aload 8
    //   261: aload_0
    //   262: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   265: getfield 86	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Int	I
    //   268: invokevirtual 90	com/tencent/mobileqq/app/QQAppInterface:getMessageProxy	(I)Lcom/tencent/imcore/message/BaseMsgProxy;
    //   271: aload_0
    //   272: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   275: getfield 81	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   278: aload_0
    //   279: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   282: getfield 86	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Int	I
    //   285: aload 9
    //   287: invokevirtual 95	com/tencent/imcore/message/BaseMsgProxy:a	(Ljava/lang/String;I[I)Ljava/util/List;
    //   290: astore 6
    //   292: aload 6
    //   294: astore 4
    //   296: aload 6
    //   298: invokeinterface 101 1 0
    //   303: iconst_1
    //   304: if_icmpge +250 -> 554
    //   307: aload 8
    //   309: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   312: aload_0
    //   313: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   316: getfield 81	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   319: aload_0
    //   320: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   323: getfield 86	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Int	I
    //   326: aload 9
    //   328: iconst_1
    //   329: invokevirtual 110	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;I[II)Ljava/util/List;
    //   332: astore 4
    //   334: aload_0
    //   335: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   338: aload 4
    //   340: invokeinterface 101 1 0
    //   345: putfield 30	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Int	I
    //   348: goto +206 -> 554
    //   351: aload_0
    //   352: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   355: getfield 86	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Int	I
    //   358: invokestatic 116	com/tencent/imcore/message/UinTypeUtil:g	(I)Z
    //   361: ifeq +72 -> 433
    //   364: aload_0
    //   365: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   368: astore 4
    //   370: aload 4
    //   372: aload 4
    //   374: getfield 119	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Long	J
    //   377: lconst_1
    //   378: lsub
    //   379: putfield 119	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Long	J
    //   382: aload 8
    //   384: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   387: aload_0
    //   388: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   391: getfield 81	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   394: aload_0
    //   395: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   398: getfield 86	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Int	I
    //   401: aload_0
    //   402: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   405: getfield 121	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_c_of_type_Long	J
    //   408: aload_0
    //   409: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   412: getfield 123	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_c_of_type_Int	I
    //   415: aload_0
    //   416: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   419: getfield 119	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Long	J
    //   422: aload 9
    //   424: iconst_1
    //   425: invokevirtual 126	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJIJ[II)Ljava/util/List;
    //   428: astore 4
    //   430: goto +51 -> 481
    //   433: aload 8
    //   435: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   438: aload_0
    //   439: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   442: getfield 81	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   445: aload_0
    //   446: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   449: getfield 86	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Int	I
    //   452: aload_0
    //   453: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   456: getfield 121	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_c_of_type_Long	J
    //   459: aload_0
    //   460: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   463: getfield 123	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_c_of_type_Int	I
    //   466: aload_0
    //   467: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   470: getfield 128	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_d_of_type_Long	J
    //   473: aload 9
    //   475: iconst_1
    //   476: invokevirtual 126	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJIJ[II)Ljava/util/List;
    //   479: astore 4
    //   481: aload_0
    //   482: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   485: aload 4
    //   487: invokeinterface 101 1 0
    //   492: putfield 30	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Int	I
    //   495: aload_0
    //   496: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   499: astore 6
    //   501: aload 6
    //   503: aload 6
    //   505: getfield 130	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_d_of_type_Int	I
    //   508: iconst_1
    //   509: iadd
    //   510: putfield 130	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_d_of_type_Int	I
    //   513: goto +41 -> 554
    //   516: aload 8
    //   518: invokevirtual 134	com/tencent/mobileqq/app/QQAppInterface:getMultiMessageProxy	()Lcom/tencent/mobileqq/app/message/MultiMsgProxy;
    //   521: ifnull +547 -> 1068
    //   524: aload_0
    //   525: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   528: getfield 84	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_c_of_type_Boolean	Z
    //   531: ifeq +6 -> 537
    //   534: goto +534 -> 1068
    //   537: aload 8
    //   539: invokevirtual 134	com/tencent/mobileqq/app/QQAppInterface:getMultiMessageProxy	()Lcom/tencent/mobileqq/app/message/MultiMsgProxy;
    //   542: aload_0
    //   543: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   546: getfield 136	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Long	J
    //   549: invokevirtual 141	com/tencent/mobileqq/app/message/MultiMsgProxy:a	(J)Ljava/util/ArrayList;
    //   552: astore 4
    //   554: aload_0
    //   555: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   558: getfield 84	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_c_of_type_Boolean	Z
    //   561: ifne +43 -> 604
    //   564: aload 7
    //   566: aload 4
    //   568: invokeinterface 145 2 0
    //   573: pop
    //   574: aload 5
    //   576: aload_0
    //   577: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   580: aload 8
    //   582: aload 4
    //   584: invokestatic 148	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:a	(Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)Ljava/util/List;
    //   587: invokeinterface 145 2 0
    //   592: pop
    //   593: aload_0
    //   594: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   597: iconst_1
    //   598: putfield 84	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_c_of_type_Boolean	Z
    //   601: goto +34 -> 635
    //   604: aload 7
    //   606: iconst_0
    //   607: aload 4
    //   609: invokeinterface 151 3 0
    //   614: pop
    //   615: aload 5
    //   617: iconst_0
    //   618: aload_0
    //   619: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   622: aload 8
    //   624: aload 4
    //   626: invokestatic 148	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:a	(Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)Ljava/util/List;
    //   629: invokeinterface 151 3 0
    //   634: pop
    //   635: aload_0
    //   636: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   639: getfield 79	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Boolean	Z
    //   642: ifne +27 -> 669
    //   645: aload 5
    //   647: invokeinterface 101 1 0
    //   652: ifge +17 -> 669
    //   655: aload_0
    //   656: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   659: getfield 30	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Int	I
    //   662: iconst_1
    //   663: if_icmpge +509 -> 1172
    //   666: goto +3 -> 669
    //   669: aload 5
    //   671: invokeinterface 101 1 0
    //   676: ifle +274 -> 950
    //   679: aload_0
    //   680: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   683: getfield 49	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataCallBack	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$LoadMediaDataCallBack;
    //   686: astore 6
    //   688: aload 6
    //   690: ifnull +205 -> 895
    //   693: new 75	java/util/ArrayList
    //   696: dup
    //   697: invokespecial 76	java/util/ArrayList:<init>	()V
    //   700: astore 8
    //   702: aload_0
    //   703: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   706: getfield 86	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Int	I
    //   709: iconst_1
    //   710: if_icmpeq +465 -> 1175
    //   713: aload_0
    //   714: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   717: getfield 86	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Int	I
    //   720: sipush 1026
    //   723: if_icmpne +6 -> 729
    //   726: goto +449 -> 1175
    //   729: aload_0
    //   730: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   733: getfield 154	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   736: astore 4
    //   738: goto +3 -> 741
    //   741: aload_0
    //   742: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   745: getfield 86	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Int	I
    //   748: iconst_1
    //   749: if_icmpne +28 -> 777
    //   752: aload 4
    //   754: aload 4
    //   756: invokeinterface 101 1 0
    //   761: anewarray 156	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   764: invokeinterface 160 2 0
    //   769: checkcast 162	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   772: astore 4
    //   774: goto +94 -> 868
    //   777: aload_0
    //   778: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   781: getfield 154	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   784: astore 9
    //   786: aload 9
    //   788: monitorenter
    //   789: iconst_0
    //   790: istore_1
    //   791: iload_1
    //   792: aload 4
    //   794: invokeinterface 101 1 0
    //   799: if_icmpge +44 -> 843
    //   802: aload 4
    //   804: iload_1
    //   805: invokeinterface 166 2 0
    //   810: checkcast 156	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   813: astore 10
    //   815: aload_0
    //   816: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   819: aload 10
    //   821: invokevirtual 169	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:a	(Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;)Z
    //   824: ifeq +6 -> 830
    //   827: goto +355 -> 1182
    //   830: aload 8
    //   832: aload 10
    //   834: invokeinterface 173 2 0
    //   839: pop
    //   840: goto +342 -> 1182
    //   843: aload 9
    //   845: monitorexit
    //   846: aload 8
    //   848: aload 8
    //   850: invokeinterface 101 1 0
    //   855: anewarray 156	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   858: invokeinterface 160 2 0
    //   863: checkcast 162	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   866: astore 4
    //   868: aload 4
    //   870: arraylength
    //   871: ifle +24 -> 895
    //   874: aload 6
    //   876: aload 4
    //   878: iconst_m1
    //   879: invokeinterface 178 3 0
    //   884: goto +11 -> 895
    //   887: astore 4
    //   889: aload 9
    //   891: monitorexit
    //   892: aload 4
    //   894: athrow
    //   895: aload_0
    //   896: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   899: getfield 52	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$LoadMediaDataListener	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$LoadMediaDataListener;
    //   902: astore 4
    //   904: aload 4
    //   906: ifnull +51 -> 957
    //   909: aload 5
    //   911: aload 5
    //   913: invokeinterface 101 1 0
    //   918: anewarray 156	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   921: invokeinterface 160 2 0
    //   926: checkcast 162	[Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   929: astore 6
    //   931: aload 6
    //   933: arraylength
    //   934: ifle +23 -> 957
    //   937: aload 4
    //   939: aload 6
    //   941: iconst_m1
    //   942: invokeinterface 181 3 0
    //   947: goto +10 -> 957
    //   950: aload_0
    //   951: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   954: invokevirtual 32	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:a	()V
    //   957: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   960: ifeq +181 -> 1141
    //   963: new 183	java/lang/StringBuilder
    //   966: dup
    //   967: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   970: astore 4
    //   972: aload 4
    //   974: ldc 186
    //   976: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: aload 4
    //   982: aload_0
    //   983: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   986: getfield 79	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_b_of_type_Boolean	Z
    //   989: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   992: pop
    //   993: aload 4
    //   995: ldc 195
    //   997: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: pop
    //   1001: aload 4
    //   1003: aload 7
    //   1005: invokeinterface 101 1 0
    //   1010: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1013: pop
    //   1014: aload 4
    //   1016: ldc 200
    //   1018: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: aload 4
    //   1024: aload 5
    //   1026: invokeinterface 101 1 0
    //   1031: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1034: pop
    //   1035: aload 4
    //   1037: ldc 202
    //   1039: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: pop
    //   1043: aload 4
    //   1045: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   1048: lload_2
    //   1049: lsub
    //   1050: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1053: pop
    //   1054: ldc 40
    //   1056: iconst_2
    //   1057: aload 4
    //   1059: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1062: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1065: goto +76 -> 1141
    //   1068: aload_0
    //   1069: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   1072: astore 4
    //   1074: aload 4
    //   1076: iconst_0
    //   1077: putfield 27	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Boolean	Z
    //   1080: aload_0
    //   1081: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   1084: invokevirtual 32	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:a	()V
    //   1087: aload_0
    //   1088: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   1091: iconst_0
    //   1092: putfield 27	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Boolean	Z
    //   1095: return
    //   1096: astore 4
    //   1098: goto +52 -> 1150
    //   1101: astore 4
    //   1103: goto +47 -> 1150
    //   1106: astore 4
    //   1108: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1111: ifeq +30 -> 1141
    //   1114: ldc 40
    //   1116: iconst_2
    //   1117: ldc 211
    //   1119: aload 4
    //   1121: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1124: goto +17 -> 1141
    //   1127: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1130: ifeq +11 -> 1141
    //   1133: ldc 40
    //   1135: iconst_2
    //   1136: ldc 216
    //   1138: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1141: aload_0
    //   1142: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   1145: iconst_0
    //   1146: putfield 27	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Boolean	Z
    //   1149: return
    //   1150: aload_0
    //   1151: getfield 12	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter$IncreasinglyLoadMediaTask:this$0	Lcom/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter;
    //   1154: iconst_0
    //   1155: putfield 27	com/tencent/mobileqq/activity/chathistory/TroopAIOImageGeter:jdField_a_of_type_Boolean	Z
    //   1158: goto +6 -> 1164
    //   1161: aload 4
    //   1163: athrow
    //   1164: goto -3 -> 1161
    //   1167: astore 4
    //   1169: goto -42 -> 1127
    //   1172: goto -1031 -> 141
    //   1175: aload 5
    //   1177: astore 4
    //   1179: goto -438 -> 741
    //   1182: iload_1
    //   1183: iconst_1
    //   1184: iadd
    //   1185: istore_1
    //   1186: goto -395 -> 791
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1189	0	this	IncreasinglyLoadMediaTask
    //   790	396	1	i	int
    //   104	945	2	l	long
    //   294	583	4	localObject1	Object
    //   887	6	4	localObject2	Object
    //   902	173	4	localObject3	Object
    //   1096	1	4	localObject4	Object
    //   1101	1	4	localObject5	Object
    //   1106	56	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1167	1	4	localAccountNotMatchException	mqq.app.AccountNotMatchException
    //   1177	1	4	localArrayList1	java.util.ArrayList
    //   139	1037	5	localArrayList2	java.util.ArrayList
    //   290	650	6	localObject6	Object
    //   130	874	7	localArrayList3	java.util.ArrayList
    //   121	728	8	localObject7	Object
    //   189	701	9	localObject8	Object
    //   813	20	10	localAIORichMediaData	com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    // Exception table:
    //   from	to	target	type
    //   791	827	887	finally
    //   830	840	887	finally
    //   843	846	887	finally
    //   889	892	887	finally
    //   604	635	1096	finally
    //   1074	1087	1096	finally
    //   0	34	1101	finally
    //   43	57	1101	finally
    //   57	92	1101	finally
    //   101	141	1101	finally
    //   141	176	1101	finally
    //   185	191	1101	finally
    //   249	292	1101	finally
    //   296	348	1101	finally
    //   351	430	1101	finally
    //   433	481	1101	finally
    //   481	513	1101	finally
    //   516	534	1101	finally
    //   537	554	1101	finally
    //   554	601	1101	finally
    //   635	666	1101	finally
    //   669	688	1101	finally
    //   693	726	1101	finally
    //   729	738	1101	finally
    //   741	774	1101	finally
    //   777	789	1101	finally
    //   846	868	1101	finally
    //   868	884	1101	finally
    //   892	895	1101	finally
    //   895	904	1101	finally
    //   909	947	1101	finally
    //   950	957	1101	finally
    //   957	1065	1101	finally
    //   1068	1074	1101	finally
    //   1108	1124	1101	finally
    //   1127	1141	1101	finally
    //   0	34	1106	java/lang/OutOfMemoryError
    //   43	57	1106	java/lang/OutOfMemoryError
    //   57	92	1106	java/lang/OutOfMemoryError
    //   101	141	1106	java/lang/OutOfMemoryError
    //   141	176	1106	java/lang/OutOfMemoryError
    //   185	191	1106	java/lang/OutOfMemoryError
    //   249	292	1106	java/lang/OutOfMemoryError
    //   296	348	1106	java/lang/OutOfMemoryError
    //   351	430	1106	java/lang/OutOfMemoryError
    //   433	481	1106	java/lang/OutOfMemoryError
    //   481	513	1106	java/lang/OutOfMemoryError
    //   516	534	1106	java/lang/OutOfMemoryError
    //   537	554	1106	java/lang/OutOfMemoryError
    //   554	601	1106	java/lang/OutOfMemoryError
    //   604	635	1106	java/lang/OutOfMemoryError
    //   635	666	1106	java/lang/OutOfMemoryError
    //   669	688	1106	java/lang/OutOfMemoryError
    //   693	726	1106	java/lang/OutOfMemoryError
    //   729	738	1106	java/lang/OutOfMemoryError
    //   741	774	1106	java/lang/OutOfMemoryError
    //   777	789	1106	java/lang/OutOfMemoryError
    //   846	868	1106	java/lang/OutOfMemoryError
    //   868	884	1106	java/lang/OutOfMemoryError
    //   892	895	1106	java/lang/OutOfMemoryError
    //   895	904	1106	java/lang/OutOfMemoryError
    //   909	947	1106	java/lang/OutOfMemoryError
    //   950	957	1106	java/lang/OutOfMemoryError
    //   957	1065	1106	java/lang/OutOfMemoryError
    //   1068	1074	1106	java/lang/OutOfMemoryError
    //   1074	1087	1106	java/lang/OutOfMemoryError
    //   0	34	1167	mqq/app/AccountNotMatchException
    //   43	57	1167	mqq/app/AccountNotMatchException
    //   57	92	1167	mqq/app/AccountNotMatchException
    //   101	141	1167	mqq/app/AccountNotMatchException
    //   141	176	1167	mqq/app/AccountNotMatchException
    //   185	191	1167	mqq/app/AccountNotMatchException
    //   249	292	1167	mqq/app/AccountNotMatchException
    //   296	348	1167	mqq/app/AccountNotMatchException
    //   351	430	1167	mqq/app/AccountNotMatchException
    //   433	481	1167	mqq/app/AccountNotMatchException
    //   481	513	1167	mqq/app/AccountNotMatchException
    //   516	534	1167	mqq/app/AccountNotMatchException
    //   537	554	1167	mqq/app/AccountNotMatchException
    //   554	601	1167	mqq/app/AccountNotMatchException
    //   604	635	1167	mqq/app/AccountNotMatchException
    //   635	666	1167	mqq/app/AccountNotMatchException
    //   669	688	1167	mqq/app/AccountNotMatchException
    //   693	726	1167	mqq/app/AccountNotMatchException
    //   729	738	1167	mqq/app/AccountNotMatchException
    //   741	774	1167	mqq/app/AccountNotMatchException
    //   777	789	1167	mqq/app/AccountNotMatchException
    //   846	868	1167	mqq/app/AccountNotMatchException
    //   868	884	1167	mqq/app/AccountNotMatchException
    //   892	895	1167	mqq/app/AccountNotMatchException
    //   895	904	1167	mqq/app/AccountNotMatchException
    //   909	947	1167	mqq/app/AccountNotMatchException
    //   950	957	1167	mqq/app/AccountNotMatchException
    //   957	1065	1167	mqq/app/AccountNotMatchException
    //   1068	1074	1167	mqq/app/AccountNotMatchException
    //   1074	1087	1167	mqq/app/AccountNotMatchException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOImageGeter.IncreasinglyLoadMediaTask
 * JD-Core Version:    0.7.0.1
 */