package com.tencent.mobileqq.activity.richmedia;

class NewFlowCameraActivity$56
  implements Runnable
{
  NewFlowCameraActivity$56(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 25	java/util/HashMap
    //   3: dup
    //   4: invokespecial 26	java/util/HashMap:<init>	()V
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 14	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$56:this$0	Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity;
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
    //   53: getfield 14	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$56:this$0	Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity;
    //   56: invokestatic 31	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:a	(Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity;)Ljava/util/HashMap;
    //   59: aload 7
    //   61: invokevirtual 57	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: goto -42 -> 26
    //   71: aload_0
    //   72: getfield 14	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$56:this$0	Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity;
    //   75: invokestatic 31	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity:a	(Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity;)Ljava/util/HashMap;
    //   78: invokevirtual 64	java/util/HashMap:clear	()V
    //   81: invokestatic 69	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   84: getstatic 75	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:PreUploadVideoConfig	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   87: invokevirtual 79	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   90: ldc 81
    //   92: invokevirtual 84	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 5
    //   97: aload 5
    //   99: ifnull +450 -> 549
    //   102: aload 5
    //   104: invokevirtual 88	java/lang/String:length	()I
    //   107: ifle +442 -> 549
    //   110: aload 5
    //   112: ldc 90
    //   114: invokevirtual 94	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   117: astore 5
    //   119: aload 5
    //   121: ifnull +428 -> 549
    //   124: aload 5
    //   126: arraylength
    //   127: bipush 6
    //   129: if_icmplt +420 -> 549
    //   132: aload 5
    //   134: iconst_5
    //   135: aaload
    //   136: invokestatic 100	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   139: invokevirtual 103	java/lang/Integer:intValue	()I
    //   142: istore_2
    //   143: iload_2
    //   144: istore_1
    //   145: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +30 -> 178
    //   151: ldc 110
    //   153: iconst_2
    //   154: new 112	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   161: ldc 115
    //   163: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload_2
    //   167: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: iload_2
    //   177: istore_1
    //   178: iload_1
    //   179: iconst_1
    //   180: if_icmpne +363 -> 543
    //   183: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   186: lstore_3
    //   187: aload_0
    //   188: getfield 16	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$56:a	Z
    //   191: aload 6
    //   193: invokestatic 141	azij:b	(ZLjava/util/HashMap;)Ljava/lang/String;
    //   196: astore 5
    //   198: aload 5
    //   200: ifnull +259 -> 459
    //   203: aload 6
    //   205: ldc 143
    //   207: ldc 145
    //   209: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload 5
    //   215: invokestatic 100	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   218: invokevirtual 103	java/lang/Integer:intValue	()I
    //   221: istore_2
    //   222: aload 6
    //   224: ldc 147
    //   226: aload 5
    //   228: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: aload_0
    //   233: getfield 16	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$56:a	Z
    //   236: ifeq +211 -> 447
    //   239: iconst_1
    //   240: istore_1
    //   241: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +37 -> 281
    //   247: ldc 110
    //   249: iconst_2
    //   250: new 112	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   257: ldc 149
    //   259: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload_2
    //   263: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc 151
    //   268: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: iload_1
    //   272: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: iload_1
    //   282: iload_2
    //   283: if_icmpne +169 -> 452
    //   286: ldc 145
    //   288: astore 5
    //   290: aload 6
    //   292: ldc 153
    //   294: aload 5
    //   296: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   299: pop
    //   300: aload 6
    //   302: ldc 155
    //   304: invokestatic 135	java/lang/System:currentTimeMillis	()J
    //   307: lload_3
    //   308: lsub
    //   309: invokestatic 158	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   312: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   315: pop
    //   316: aload_0
    //   317: getfield 16	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$56:a	Z
    //   320: aload 6
    //   322: invokestatic 161	azij:a	(ZLjava/util/HashMap;)V
    //   325: new 112	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   332: astore 5
    //   334: aload 6
    //   336: invokevirtual 35	java/util/HashMap:keySet	()Ljava/util/Set;
    //   339: invokeinterface 41 1 0
    //   344: astore 7
    //   346: aload 7
    //   348: invokeinterface 47 1 0
    //   353: ifeq +133 -> 486
    //   356: aload 7
    //   358: invokeinterface 51 1 0
    //   363: checkcast 53	java/lang/String
    //   366: astore 8
    //   368: aload 5
    //   370: aload 8
    //   372: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc 163
    //   377: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 6
    //   383: aload 8
    //   385: aload 6
    //   387: aload 8
    //   389: invokevirtual 57	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   392: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   395: pop
    //   396: aload 5
    //   398: aload 6
    //   400: aload 8
    //   402: invokevirtual 57	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   405: checkcast 53	java/lang/String
    //   408: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: ldc 165
    //   413: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: goto -71 -> 346
    //   420: astore 5
    //   422: iconst_0
    //   423: istore_2
    //   424: iload_2
    //   425: istore_1
    //   426: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq -251 -> 178
    //   432: ldc 110
    //   434: iconst_2
    //   435: ldc 167
    //   437: aload 5
    //   439: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: iload_2
    //   443: istore_1
    //   444: goto -266 -> 178
    //   447: iconst_0
    //   448: istore_1
    //   449: goto -208 -> 241
    //   452: ldc 173
    //   454: astore 5
    //   456: goto -166 -> 290
    //   459: aload 6
    //   461: ldc 143
    //   463: ldc 173
    //   465: invokevirtual 61	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   468: pop
    //   469: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   472: ifeq -172 -> 300
    //   475: ldc 110
    //   477: iconst_2
    //   478: ldc 175
    //   480: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: goto -183 -> 300
    //   486: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq +32 -> 521
    //   492: ldc 110
    //   494: iconst_2
    //   495: new 112	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   502: ldc 177
    //   504: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload 5
    //   509: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: invokestatic 183	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   524: invokestatic 188	azri:a	(Landroid/content/Context;)Lazri;
    //   527: aconst_null
    //   528: ldc 190
    //   530: aload_0
    //   531: getfield 16	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$56:a	Z
    //   534: lconst_0
    //   535: lconst_0
    //   536: aload 6
    //   538: ldc 192
    //   540: invokevirtual 195	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   543: return
    //   544: astore 5
    //   546: goto -122 -> 424
    //   549: iconst_0
    //   550: istore_1
    //   551: goto -373 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	this	56
    //   144	407	1	i	int
    //   142	301	2	j	int
    //   186	122	3	l	long
    //   24	373	5	localObject1	Object
    //   420	18	5	localNumberFormatException1	java.lang.NumberFormatException
    //   454	54	5	str1	java.lang.String
    //   544	1	5	localNumberFormatException2	java.lang.NumberFormatException
    //   7	530	6	localHashMap	java.util.HashMap
    //   46	311	7	localObject2	Object
    //   366	35	8	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   132	143	420	java/lang/NumberFormatException
    //   145	176	544	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.56
 * JD-Core Version:    0.7.0.1
 */