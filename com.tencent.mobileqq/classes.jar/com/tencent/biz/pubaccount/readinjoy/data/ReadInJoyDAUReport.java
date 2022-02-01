package com.tencent.biz.pubaccount.readinjoy.data;

import com.tencent.mobileqq.app.automator.AsyncStep;

public class ReadInJoyDAUReport
  extends AsyncStep
{
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   4: getfield 21	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 27	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   10: invokevirtual 33	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore 4
    //   15: ldc 35
    //   17: monitorenter
    //   18: aload 4
    //   20: ldc 35
    //   22: invokevirtual 41	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   25: astore_3
    //   26: aload_0
    //   27: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   30: getfield 21	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: getstatic 47	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   36: invokevirtual 51	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   39: checkcast 53	com/tencent/mobileqq/app/FriendsManager
    //   42: astore 5
    //   44: aload 5
    //   46: ifnull +602 -> 648
    //   49: aload 5
    //   51: aload_0
    //   52: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   55: getfield 21	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   58: invokevirtual 57	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   61: invokevirtual 61	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   64: astore 5
    //   66: aload 5
    //   68: ifnull +580 -> 648
    //   71: aload 5
    //   73: getfield 67	com/tencent/mobileqq/data/Card:shGender	S
    //   76: istore_2
    //   77: aload 5
    //   79: getfield 71	com/tencent/mobileqq/data/Card:age	B
    //   82: istore_1
    //   83: aload_3
    //   84: ifnull +550 -> 634
    //   87: aload_3
    //   88: invokeinterface 76 1 0
    //   93: ifle +541 -> 634
    //   96: aload_3
    //   97: invokeinterface 80 1 0
    //   102: astore_3
    //   103: aload_3
    //   104: invokeinterface 86 1 0
    //   109: ifeq +525 -> 634
    //   112: aload_3
    //   113: invokeinterface 90 1 0
    //   118: checkcast 35	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo
    //   121: astore 5
    //   123: new 92	java/util/HashMap
    //   126: dup
    //   127: iconst_2
    //   128: invokespecial 95	java/util/HashMap:<init>	(I)V
    //   131: astore 6
    //   133: aload 6
    //   135: ldc 97
    //   137: aload 5
    //   139: getfield 100	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   142: invokevirtual 104	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   145: pop
    //   146: aload 6
    //   148: ldc 106
    //   150: aload 5
    //   152: getfield 108	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:count	I
    //   155: invokestatic 114	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   158: invokevirtual 104	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: pop
    //   162: aload 6
    //   164: ldc 116
    //   166: iload_2
    //   167: invokestatic 114	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   170: invokevirtual 104	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: pop
    //   174: aload 6
    //   176: ldc 117
    //   178: iload_1
    //   179: invokestatic 114	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   182: invokevirtual 104	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: pop
    //   186: aload 6
    //   188: ldc 119
    //   190: aload 5
    //   192: getfield 121	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   195: invokevirtual 104	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   198: pop
    //   199: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +86 -> 288
    //   205: ldc 128
    //   207: iconst_2
    //   208: new 130	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   215: ldc 133
    //   217: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   224: getfield 21	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   227: invokevirtual 57	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   230: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 139
    //   235: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 5
    //   240: getfield 142	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   243: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc 144
    //   248: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 146
    //   253: iconst_1
    //   254: anewarray 148	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: invokestatic 153	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   262: aastore
    //   263: invokestatic 157	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   266: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc 159
    //   271: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 5
    //   276: getfield 163	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   279: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aconst_null
    //   289: ldc 175
    //   291: ldc 177
    //   293: ldc 177
    //   295: ldc 179
    //   297: ldc 179
    //   299: iconst_0
    //   300: iconst_0
    //   301: aload 5
    //   303: getfield 163	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   306: invokestatic 184	java/lang/Long:toString	(J)Ljava/lang/String;
    //   309: aload 5
    //   311: getfield 142	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   314: ldc 146
    //   316: iconst_1
    //   317: anewarray 148	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: invokestatic 153	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   325: aastore
    //   326: invokestatic 157	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   329: aconst_null
    //   330: invokestatic 189	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_0
    //   334: aload 5
    //   336: getfield 121	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   339: invokevirtual 192	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	(Ljava/lang/String;)Ljava/lang/String;
    //   342: astore 6
    //   344: aload 5
    //   346: getfield 100	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   349: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifne +152 -> 504
    //   355: aload 5
    //   357: getfield 100	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   360: ldc 200
    //   362: invokevirtual 204	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   365: ifeq +139 -> 504
    //   368: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq +86 -> 457
    //   374: ldc 128
    //   376: iconst_2
    //   377: new 130	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   384: ldc 206
    //   386: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_0
    //   390: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   393: getfield 21	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   396: invokevirtual 57	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   399: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc 139
    //   404: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 5
    //   409: getfield 142	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   412: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc 144
    //   417: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc 146
    //   422: iconst_1
    //   423: anewarray 148	java/lang/Object
    //   426: dup
    //   427: iconst_0
    //   428: invokestatic 153	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   431: aastore
    //   432: invokestatic 157	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   435: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc 159
    //   440: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 5
    //   445: getfield 163	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   448: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   451: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   457: aconst_null
    //   458: ldc 175
    //   460: ldc 177
    //   462: ldc 177
    //   464: ldc 208
    //   466: ldc 208
    //   468: iconst_0
    //   469: iconst_0
    //   470: aload 5
    //   472: getfield 163	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   475: invokestatic 184	java/lang/Long:toString	(J)Ljava/lang/String;
    //   478: aload 5
    //   480: getfield 142	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   483: ldc 146
    //   485: iconst_1
    //   486: anewarray 148	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: invokestatic 153	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   494: aastore
    //   495: invokestatic 157	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   498: invokestatic 212	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport:a	()Ljava/lang/String;
    //   501: invokestatic 189	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload 5
    //   506: getfield 100	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   509: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   512: ifne -409 -> 103
    //   515: aload 6
    //   517: ifnull -414 -> 103
    //   520: aload 6
    //   522: ldc 200
    //   524: invokevirtual 204	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   527: ifeq -424 -> 103
    //   530: aload 5
    //   532: getfield 100	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   535: ldc 214
    //   537: invokevirtual 217	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   540: ifeq -437 -> 103
    //   543: aconst_null
    //   544: ldc 175
    //   546: ldc 177
    //   548: ldc 177
    //   550: ldc 208
    //   552: ldc 208
    //   554: iconst_0
    //   555: iconst_0
    //   556: aload 5
    //   558: getfield 163	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   561: invokestatic 184	java/lang/Long:toString	(J)Ljava/lang/String;
    //   564: aload 5
    //   566: getfield 142	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   569: ldc 146
    //   571: iconst_1
    //   572: anewarray 148	java/lang/Object
    //   575: dup
    //   576: iconst_0
    //   577: invokestatic 153	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   580: aastore
    //   581: invokestatic 157	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   584: invokestatic 212	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport:a	()Ljava/lang/String;
    //   587: invokestatic 189	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   590: goto -487 -> 103
    //   593: astore_3
    //   594: ldc 35
    //   596: monitorexit
    //   597: aload_3
    //   598: athrow
    //   599: astore_3
    //   600: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   603: ifeq +52 -> 655
    //   606: ldc 128
    //   608: iconst_2
    //   609: new 130	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   616: ldc 219
    //   618: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload_3
    //   622: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   625: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: goto +24 -> 655
    //   634: aload 4
    //   636: ldc 35
    //   638: invokevirtual 226	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   641: pop
    //   642: ldc 35
    //   644: monitorexit
    //   645: bipush 7
    //   647: ireturn
    //   648: iconst_m1
    //   649: istore_1
    //   650: iconst_m1
    //   651: istore_2
    //   652: goto -569 -> 83
    //   655: aconst_null
    //   656: astore_3
    //   657: goto -631 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	660	0	this	ReadInJoyDAUReport
    //   82	568	1	i	int
    //   76	576	2	j	int
    //   25	88	3	localObject1	java.lang.Object
    //   593	5	3	localObject2	java.lang.Object
    //   599	23	3	localException	java.lang.Exception
    //   656	1	3	localObject3	java.lang.Object
    //   13	622	4	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   42	523	5	localObject4	java.lang.Object
    //   131	390	6	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   18	26	593	finally
    //   26	44	593	finally
    //   49	66	593	finally
    //   71	83	593	finally
    //   87	103	593	finally
    //   103	288	593	finally
    //   288	457	593	finally
    //   457	504	593	finally
    //   504	515	593	finally
    //   520	590	593	finally
    //   594	597	593	finally
    //   600	631	593	finally
    //   634	645	593	finally
    //   18	26	599	java/lang/Exception
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return null;
        paramString = paramString.split("\\|");
      } while (paramString == null);
      paramString = paramString[(paramString.length - 1)].split(".");
    } while ((paramString == null) || (paramString.length <= 1));
    return paramString[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyDAUReport
 * JD-Core Version:    0.7.0.1
 */