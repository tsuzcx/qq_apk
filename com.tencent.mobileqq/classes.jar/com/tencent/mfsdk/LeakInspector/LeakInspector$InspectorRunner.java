package com.tencent.mfsdk.LeakInspector;

class LeakInspector$InspectorRunner
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private LeakInspector.InspectUUID jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID;
  
  LeakInspector$InspectorRunner(LeakInspector paramLeakInspector, LeakInspector.InspectUUID paramInspectUUID, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID = paramInspectUUID;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +58 -> 61
    //   6: ldc 36
    //   8: iconst_2
    //   9: bipush 6
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc 38
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_0
    //   22: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   25: invokevirtual 44	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID:toString	()Ljava/lang/String;
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: ldc 46
    //   33: aastore
    //   34: dup
    //   35: iconst_3
    //   36: invokestatic 52	java/lang/System:currentTimeMillis	()J
    //   39: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: aastore
    //   43: dup
    //   44: iconst_4
    //   45: ldc 60
    //   47: aastore
    //   48: dup
    //   49: iconst_5
    //   50: aload_0
    //   51: getfield 20	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_Int	I
    //   54: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   65: getfield 73	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID:weakObj	Ljava/lang/ref/WeakReference;
    //   68: invokevirtual 79	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   71: ifnull +597 -> 668
    //   74: aload_0
    //   75: getfield 20	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_Int	I
    //   78: iconst_1
    //   79: iadd
    //   80: istore_1
    //   81: aload_0
    //   82: iload_1
    //   83: putfield 20	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_Int	I
    //   86: iload_1
    //   87: invokestatic 84	com/tencent/mfsdk/LeakInspector/LeakInspector:a	()I
    //   90: if_icmpge +28 -> 118
    //   93: invokestatic 87	java/lang/System:runFinalization	()V
    //   96: invokestatic 93	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   99: invokevirtual 96	java/lang/Runtime:gc	()V
    //   102: aload_0
    //   103: getfield 15	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:this$0	Lcom/tencent/mfsdk/LeakInspector/LeakInspector;
    //   106: invokestatic 99	com/tencent/mfsdk/LeakInspector/LeakInspector:a	(Lcom/tencent/mfsdk/LeakInspector/LeakInspector;)Lmqq/os/MqqHandler;
    //   109: aload_0
    //   110: ldc2_w 100
    //   113: invokevirtual 107	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   116: pop
    //   117: return
    //   118: invokestatic 109	com/tencent/mfsdk/LeakInspector/LeakInspector:a	()Z
    //   121: ifne +330 -> 451
    //   124: aload_0
    //   125: getfield 15	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:this$0	Lcom/tencent/mfsdk/LeakInspector/LeakInspector;
    //   128: invokestatic 112	com/tencent/mfsdk/LeakInspector/LeakInspector:a	(Lcom/tencent/mfsdk/LeakInspector/LeakInspector;)Lzzt;
    //   131: aload_0
    //   132: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   135: invokevirtual 44	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID:toString	()Ljava/lang/String;
    //   138: invokeinterface 117 2 0
    //   143: astore_2
    //   144: aload_0
    //   145: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   148: invokevirtual 44	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID:toString	()Ljava/lang/String;
    //   151: astore_3
    //   152: aload_3
    //   153: invokestatic 123	zzq:b	(Ljava/lang/String;)[Ljava/lang/Object;
    //   156: astore 6
    //   158: aload 6
    //   160: iconst_0
    //   161: aaload
    //   162: checkcast 125	java/lang/Boolean
    //   165: astore 4
    //   167: ldc 127
    //   169: astore 5
    //   171: aload 4
    //   173: invokevirtual 130	java/lang/Boolean:booleanValue	()Z
    //   176: ifeq +425 -> 601
    //   179: new 132	java/util/ArrayList
    //   182: dup
    //   183: invokespecial 133	java/util/ArrayList:<init>	()V
    //   186: astore 4
    //   188: aload 4
    //   190: aload 6
    //   192: iconst_1
    //   193: aaload
    //   194: checkcast 135	java/lang/String
    //   197: invokeinterface 141 2 0
    //   202: pop
    //   203: aload_2
    //   204: ifnull +21 -> 225
    //   207: aload_2
    //   208: invokeinterface 144 1 0
    //   213: ifle +12 -> 225
    //   216: aload 4
    //   218: aload_2
    //   219: invokeinterface 148 2 0
    //   224: pop
    //   225: aload 4
    //   227: aload_3
    //   228: invokestatic 151	zzq:a	(Ljava/util/List;Ljava/lang/String;)[Ljava/lang/Object;
    //   231: astore_2
    //   232: aload_2
    //   233: iconst_0
    //   234: aaload
    //   235: checkcast 125	java/lang/Boolean
    //   238: astore 4
    //   240: aload_2
    //   241: iconst_1
    //   242: aaload
    //   243: checkcast 135	java/lang/String
    //   246: astore 5
    //   248: aload 4
    //   250: astore_3
    //   251: aload 5
    //   253: astore_2
    //   254: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +55 -> 312
    //   260: ldc 36
    //   262: iconst_2
    //   263: bipush 6
    //   265: anewarray 4	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: ldc 153
    //   272: aastore
    //   273: dup
    //   274: iconst_1
    //   275: aload 4
    //   277: aastore
    //   278: dup
    //   279: iconst_2
    //   280: ldc 155
    //   282: aastore
    //   283: dup
    //   284: iconst_3
    //   285: aload_0
    //   286: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   289: invokevirtual 44	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID:toString	()Ljava/lang/String;
    //   292: aastore
    //   293: dup
    //   294: iconst_4
    //   295: ldc 157
    //   297: aastore
    //   298: dup
    //   299: iconst_5
    //   300: aload 5
    //   302: aastore
    //   303: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   306: aload 5
    //   308: astore_2
    //   309: aload 4
    //   311: astore_3
    //   312: aload_0
    //   313: getfield 15	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:this$0	Lcom/tencent/mfsdk/LeakInspector/LeakInspector;
    //   316: invokestatic 112	com/tencent/mfsdk/LeakInspector/LeakInspector:a	(Lcom/tencent/mfsdk/LeakInspector/LeakInspector;)Lzzt;
    //   319: aload_3
    //   320: invokevirtual 130	java/lang/Boolean:booleanValue	()Z
    //   323: aload_0
    //   324: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   327: invokevirtual 44	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID:toString	()Ljava/lang/String;
    //   330: aload_2
    //   331: invokeinterface 160 4 0
    //   336: ldc 162
    //   338: invokestatic 167	com/tencent/common/config/AppSetting:g	()Ljava/lang/String;
    //   341: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   344: ifne +107 -> 451
    //   347: new 172	org/json/JSONObject
    //   350: dup
    //   351: invokespecial 173	org/json/JSONObject:<init>	()V
    //   354: astore_3
    //   355: new 172	org/json/JSONObject
    //   358: dup
    //   359: invokespecial 173	org/json/JSONObject:<init>	()V
    //   362: astore 4
    //   364: aload 4
    //   366: ldc 175
    //   368: aload_2
    //   369: invokevirtual 179	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   372: pop
    //   373: new 172	org/json/JSONObject
    //   376: dup
    //   377: invokespecial 173	org/json/JSONObject:<init>	()V
    //   380: astore_2
    //   381: aload_2
    //   382: ldc 181
    //   384: invokestatic 185	com/tencent/mfsdk/MagnifierSDK:a	()Ljava/lang/String;
    //   387: invokevirtual 179	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   390: pop
    //   391: aload_2
    //   392: ldc 187
    //   394: bipush 7
    //   396: invokestatic 190	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   399: invokevirtual 179	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   402: pop
    //   403: aload_3
    //   404: ldc 192
    //   406: aload 4
    //   408: invokevirtual 179	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   411: pop
    //   412: aload_3
    //   413: ldc 194
    //   415: aload_2
    //   416: invokevirtual 179	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   419: pop
    //   420: aload_3
    //   421: ldc 196
    //   423: bipush 107
    //   425: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   428: pop
    //   429: new 201	com/tencent/mfsdk/collector/ResultObject
    //   432: dup
    //   433: iconst_0
    //   434: ldc 203
    //   436: iconst_1
    //   437: lconst_1
    //   438: lconst_1
    //   439: aload_3
    //   440: iconst_1
    //   441: iconst_1
    //   442: getstatic 206	com/tencent/mfsdk/MagnifierSDK:a	J
    //   445: invokespecial 209	com/tencent/mfsdk/collector/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   448: invokestatic 214	com/tencent/mfsdk/reporter/ReporterMachine:a	(Lcom/tencent/mfsdk/collector/ResultObject;)V
    //   451: invokestatic 219	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   454: aload_0
    //   455: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   458: getfield 73	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID:weakObj	Ljava/lang/ref/WeakReference;
    //   461: invokevirtual 79	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   464: invokevirtual 222	com/tencent/mobileqq/app/MemoryManager:a	(Ljava/lang/Object;)V
    //   467: ldc 36
    //   469: iconst_1
    //   470: iconst_3
    //   471: anewarray 4	java/lang/Object
    //   474: dup
    //   475: iconst_0
    //   476: ldc 224
    //   478: aastore
    //   479: dup
    //   480: iconst_1
    //   481: aload_0
    //   482: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   485: invokevirtual 44	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID:toString	()Ljava/lang/String;
    //   488: aastore
    //   489: dup
    //   490: iconst_2
    //   491: ldc 226
    //   493: aastore
    //   494: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   497: aload_0
    //   498: getfield 15	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:this$0	Lcom/tencent/mfsdk/LeakInspector/LeakInspector;
    //   501: invokestatic 112	com/tencent/mfsdk/LeakInspector/LeakInspector:a	(Lcom/tencent/mfsdk/LeakInspector/LeakInspector;)Lzzt;
    //   504: aload_0
    //   505: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   508: invokeinterface 229 2 0
    //   513: ifne +201 -> 714
    //   516: invokestatic 232	com/tencent/mfsdk/LeakInspector/LeakInspector:a	()Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   519: aload_0
    //   520: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   523: invokevirtual 238	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   526: return
    //   527: astore_2
    //   528: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq +59 -> 590
    //   534: ldc 36
    //   536: iconst_2
    //   537: aload_2
    //   538: bipush 6
    //   540: anewarray 4	java/lang/Object
    //   543: dup
    //   544: iconst_0
    //   545: ldc 240
    //   547: aastore
    //   548: dup
    //   549: iconst_1
    //   550: aload_0
    //   551: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   554: invokevirtual 44	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID:toString	()Ljava/lang/String;
    //   557: aastore
    //   558: dup
    //   559: iconst_2
    //   560: ldc 46
    //   562: aastore
    //   563: dup
    //   564: iconst_3
    //   565: invokestatic 52	java/lang/System:currentTimeMillis	()J
    //   568: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   571: aastore
    //   572: dup
    //   573: iconst_4
    //   574: ldc 60
    //   576: aastore
    //   577: dup
    //   578: iconst_5
    //   579: aload_0
    //   580: getfield 20	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_Int	I
    //   583: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   586: aastore
    //   587: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   590: invokestatic 232	com/tencent/mfsdk/LeakInspector/LeakInspector:a	()Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   593: aload_0
    //   594: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   597: invokevirtual 238	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   600: return
    //   601: aload 4
    //   603: astore_3
    //   604: aload 5
    //   606: astore_2
    //   607: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq -298 -> 312
    //   613: ldc 36
    //   615: iconst_2
    //   616: iconst_2
    //   617: anewarray 4	java/lang/Object
    //   620: dup
    //   621: iconst_0
    //   622: ldc 246
    //   624: aastore
    //   625: dup
    //   626: iconst_1
    //   627: aload_0
    //   628: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   631: invokevirtual 44	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID:toString	()Ljava/lang/String;
    //   634: aastore
    //   635: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   638: aload 4
    //   640: astore_3
    //   641: aload 5
    //   643: astore_2
    //   644: goto -332 -> 312
    //   647: astore_2
    //   648: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   651: ifeq -200 -> 451
    //   654: ldc 36
    //   656: iconst_2
    //   657: aload_2
    //   658: iconst_0
    //   659: anewarray 4	java/lang/Object
    //   662: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   665: goto -214 -> 451
    //   668: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   671: ifeq +33 -> 704
    //   674: ldc 36
    //   676: iconst_2
    //   677: iconst_3
    //   678: anewarray 4	java/lang/Object
    //   681: dup
    //   682: iconst_0
    //   683: ldc 224
    //   685: aastore
    //   686: dup
    //   687: iconst_1
    //   688: aload_0
    //   689: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   692: invokevirtual 44	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID:toString	()Ljava/lang/String;
    //   695: aastore
    //   696: dup
    //   697: iconst_2
    //   698: ldc 250
    //   700: aastore
    //   701: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   704: invokestatic 232	com/tencent/mfsdk/LeakInspector/LeakInspector:a	()Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   707: aload_0
    //   708: getfield 22	com/tencent/mfsdk/LeakInspector/LeakInspector$InspectorRunner:jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectUUID	Lcom/tencent/mfsdk/LeakInspector/LeakInspector$InspectUUID;
    //   711: invokevirtual 238	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   714: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	715	0	this	InspectorRunner
    //   80	11	1	i	int
    //   143	273	2	localObject1	Object
    //   527	11	2	localThrowable	java.lang.Throwable
    //   606	38	2	localObject2	Object
    //   647	11	2	localJSONException	org.json.JSONException
    //   151	490	3	localObject3	Object
    //   165	474	4	localObject4	Object
    //   169	473	5	str	java.lang.String
    //   156	35	6	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   0	61	527	java/lang/Throwable
    //   61	117	527	java/lang/Throwable
    //   118	167	527	java/lang/Throwable
    //   171	203	527	java/lang/Throwable
    //   207	225	527	java/lang/Throwable
    //   225	248	527	java/lang/Throwable
    //   254	306	527	java/lang/Throwable
    //   312	336	527	java/lang/Throwable
    //   336	451	527	java/lang/Throwable
    //   451	526	527	java/lang/Throwable
    //   607	638	527	java/lang/Throwable
    //   648	665	527	java/lang/Throwable
    //   668	704	527	java/lang/Throwable
    //   704	714	527	java/lang/Throwable
    //   336	451	647	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.LeakInspector.LeakInspector.InspectorRunner
 * JD-Core Version:    0.7.0.1
 */