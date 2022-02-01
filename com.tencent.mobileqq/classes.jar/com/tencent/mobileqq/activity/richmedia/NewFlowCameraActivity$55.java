package com.tencent.mobileqq.activity.richmedia;

class NewFlowCameraActivity$55
  implements Runnable
{
  NewFlowCameraActivity$55(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 25	java/util/HashMap
    //   3: dup
    //   4: invokespecial 26	java/util/HashMap:<init>	()V
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 14	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$55:this$0	Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity;
    //   13: invokestatic 31	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:a	(Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity;)Ljava/util/HashMap;
    //   16: invokevirtual 35	java/util/HashMap:keySet	()Ljava/util/Set;
    //   19: invokeinterface 41 1 0
    //   24: astore 5
    //   26: aload 5
    //   28: invokeinterface 47 1 0
    //   33: ifeq +38 -> 71
    //   36: aload 5
    //   38: invokeinterface 51 1 0
    //   43: checkcast 53	java/lang/String
    //   46: astore 7
    //   48: aload 6
    //   50: aload 7
    //   52: aload_0
    //   53: getfield 14	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$55:this$0	Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity;
    //   56: invokestatic 31	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:a	(Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity;)Ljava/util/HashMap;
    //   59: aload 7
    //   61: invokevirtual 57	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: goto -42 -> 26
    //   71: aload_0
    //   72: getfield 14	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$55:this$0	Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity;
    //   75: invokestatic 31	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:a	(Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity;)Ljava/util/HashMap;
    //   78: invokevirtual 64	java/util/HashMap:clear	()V
    //   81: ldc 66
    //   83: invokestatic 72	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   86: checkcast 66	com/tencent/mobileqq/dpc/api/IDPCApi
    //   89: getstatic 78	com/tencent/mobileqq/dpc/enumname/DPCNames:PreUploadVideoConfig	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   92: invokevirtual 82	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   95: ldc 84
    //   97: invokeinterface 88 3 0
    //   102: astore 5
    //   104: aload 5
    //   106: ifnull +450 -> 556
    //   109: aload 5
    //   111: invokevirtual 92	java/lang/String:length	()I
    //   114: ifle +442 -> 556
    //   117: aload 5
    //   119: ldc 94
    //   121: invokevirtual 98	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   124: astore 5
    //   126: aload 5
    //   128: ifnull +428 -> 556
    //   131: aload 5
    //   133: arraylength
    //   134: bipush 6
    //   136: if_icmplt +420 -> 556
    //   139: aload 5
    //   141: iconst_5
    //   142: aaload
    //   143: invokestatic 104	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   146: invokevirtual 107	java/lang/Integer:intValue	()I
    //   149: istore_2
    //   150: iload_2
    //   151: istore_1
    //   152: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +30 -> 185
    //   158: ldc 114
    //   160: iconst_2
    //   161: new 116	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   168: ldc 119
    //   170: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload_2
    //   174: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload_2
    //   184: istore_1
    //   185: iload_1
    //   186: iconst_1
    //   187: if_icmpne +363 -> 550
    //   190: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   193: lstore_3
    //   194: aload_0
    //   195: getfield 16	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$55:a	Z
    //   198: aload 6
    //   200: invokestatic 145	com/tencent/mobileqq/shortvideo/ml/Predictor:b	(ZLjava/util/HashMap;)Ljava/lang/String;
    //   203: astore 5
    //   205: aload 5
    //   207: ifnull +259 -> 466
    //   210: aload 6
    //   212: ldc 147
    //   214: ldc 149
    //   216: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   219: pop
    //   220: aload 5
    //   222: invokestatic 104	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   225: invokevirtual 107	java/lang/Integer:intValue	()I
    //   228: istore_2
    //   229: aload 6
    //   231: ldc 151
    //   233: aload 5
    //   235: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: pop
    //   239: aload_0
    //   240: getfield 16	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$55:a	Z
    //   243: ifeq +211 -> 454
    //   246: iconst_1
    //   247: istore_1
    //   248: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +37 -> 288
    //   254: ldc 114
    //   256: iconst_2
    //   257: new 116	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   264: ldc 153
    //   266: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: iload_2
    //   270: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: ldc 155
    //   275: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: iload_1
    //   279: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: iload_1
    //   289: iload_2
    //   290: if_icmpne +169 -> 459
    //   293: ldc 149
    //   295: astore 5
    //   297: aload 6
    //   299: ldc 157
    //   301: aload 5
    //   303: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   306: pop
    //   307: aload 6
    //   309: ldc 159
    //   311: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   314: lload_3
    //   315: lsub
    //   316: invokestatic 162	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   319: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   322: pop
    //   323: aload_0
    //   324: getfield 16	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$55:a	Z
    //   327: aload 6
    //   329: invokestatic 165	com/tencent/mobileqq/shortvideo/ml/Predictor:a	(ZLjava/util/HashMap;)V
    //   332: new 116	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   339: astore 5
    //   341: aload 6
    //   343: invokevirtual 35	java/util/HashMap:keySet	()Ljava/util/Set;
    //   346: invokeinterface 41 1 0
    //   351: astore 7
    //   353: aload 7
    //   355: invokeinterface 47 1 0
    //   360: ifeq +133 -> 493
    //   363: aload 7
    //   365: invokeinterface 51 1 0
    //   370: checkcast 53	java/lang/String
    //   373: astore 8
    //   375: aload 5
    //   377: aload 8
    //   379: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: ldc 167
    //   384: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload 6
    //   390: aload 8
    //   392: aload 6
    //   394: aload 8
    //   396: invokevirtual 57	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   399: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   402: pop
    //   403: aload 5
    //   405: aload 6
    //   407: aload 8
    //   409: invokevirtual 57	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   412: checkcast 53	java/lang/String
    //   415: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc 169
    //   420: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: goto -71 -> 353
    //   427: astore 5
    //   429: iconst_0
    //   430: istore_2
    //   431: iload_2
    //   432: istore_1
    //   433: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq -251 -> 185
    //   439: ldc 114
    //   441: iconst_2
    //   442: ldc 171
    //   444: aload 5
    //   446: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   449: iload_2
    //   450: istore_1
    //   451: goto -266 -> 185
    //   454: iconst_0
    //   455: istore_1
    //   456: goto -208 -> 248
    //   459: ldc 177
    //   461: astore 5
    //   463: goto -166 -> 297
    //   466: aload 6
    //   468: ldc 147
    //   470: ldc 177
    //   472: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   475: pop
    //   476: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq -172 -> 307
    //   482: ldc 114
    //   484: iconst_2
    //   485: ldc 179
    //   487: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: goto -183 -> 307
    //   493: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +32 -> 528
    //   499: ldc 114
    //   501: iconst_2
    //   502: new 116	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   509: ldc 181
    //   511: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload 5
    //   516: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: invokestatic 187	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   531: invokestatic 193	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   534: aconst_null
    //   535: ldc 195
    //   537: aload_0
    //   538: getfield 16	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$55:a	Z
    //   541: lconst_0
    //   542: lconst_0
    //   543: aload 6
    //   545: ldc 197
    //   547: invokevirtual 201	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   550: return
    //   551: astore 5
    //   553: goto -122 -> 431
    //   556: iconst_0
    //   557: istore_1
    //   558: goto -373 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	561	0	this	55
    //   151	407	1	i	int
    //   149	301	2	j	int
    //   193	122	3	l	long
    //   24	380	5	localObject1	Object
    //   427	18	5	localNumberFormatException1	java.lang.NumberFormatException
    //   461	54	5	str1	java.lang.String
    //   551	1	5	localNumberFormatException2	java.lang.NumberFormatException
    //   7	537	6	localHashMap	java.util.HashMap
    //   46	318	7	localObject2	Object
    //   373	35	8	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   139	150	427	java/lang/NumberFormatException
    //   152	183	551	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.55
 * JD-Core Version:    0.7.0.1
 */