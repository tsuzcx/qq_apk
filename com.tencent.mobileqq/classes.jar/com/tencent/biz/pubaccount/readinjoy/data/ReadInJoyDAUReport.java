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
    //   4: getfield 22	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   7: invokevirtual 28	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 34	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore 4
    //   15: ldc 36
    //   17: monitorenter
    //   18: aload 4
    //   20: ldc 36
    //   22: invokevirtual 42	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   25: astore_3
    //   26: aload_0
    //   27: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   30: getfield 22	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   33: getstatic 48	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   36: invokevirtual 52	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   39: checkcast 54	anvk
    //   42: astore 5
    //   44: aload 5
    //   46: ifnull +602 -> 648
    //   49: aload 5
    //   51: aload_0
    //   52: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   55: getfield 22	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   58: invokevirtual 58	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   61: invokevirtual 62	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   64: astore 5
    //   66: aload 5
    //   68: ifnull +580 -> 648
    //   71: aload 5
    //   73: getfield 68	com/tencent/mobileqq/data/Card:shGender	S
    //   76: istore_2
    //   77: aload 5
    //   79: getfield 72	com/tencent/mobileqq/data/Card:age	B
    //   82: istore_1
    //   83: aload_3
    //   84: ifnull +550 -> 634
    //   87: aload_3
    //   88: invokeinterface 77 1 0
    //   93: ifle +541 -> 634
    //   96: aload_3
    //   97: invokeinterface 81 1 0
    //   102: astore_3
    //   103: aload_3
    //   104: invokeinterface 87 1 0
    //   109: ifeq +525 -> 634
    //   112: aload_3
    //   113: invokeinterface 91 1 0
    //   118: checkcast 36	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo
    //   121: astore 5
    //   123: new 93	java/util/HashMap
    //   126: dup
    //   127: iconst_2
    //   128: invokespecial 96	java/util/HashMap:<init>	(I)V
    //   131: astore 6
    //   133: aload 6
    //   135: ldc 98
    //   137: aload 5
    //   139: getfield 101	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   142: invokevirtual 105	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   145: pop
    //   146: aload 6
    //   148: ldc 107
    //   150: aload 5
    //   152: getfield 109	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:count	I
    //   155: invokestatic 115	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   158: invokevirtual 105	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: pop
    //   162: aload 6
    //   164: ldc 117
    //   166: iload_2
    //   167: invokestatic 115	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   170: invokevirtual 105	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: pop
    //   174: aload 6
    //   176: ldc 118
    //   178: iload_1
    //   179: invokestatic 115	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   182: invokevirtual 105	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: pop
    //   186: aload 6
    //   188: ldc 120
    //   190: aload 5
    //   192: getfield 122	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   195: invokevirtual 105	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   198: pop
    //   199: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +86 -> 288
    //   205: ldc 129
    //   207: iconst_2
    //   208: new 131	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   215: ldc 134
    //   217: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   224: getfield 22	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   227: invokevirtual 58	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   230: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 140
    //   235: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 5
    //   240: getfield 143	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   243: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc 145
    //   248: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 147
    //   253: iconst_1
    //   254: anewarray 149	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: invokestatic 154	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   262: aastore
    //   263: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   266: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc 160
    //   271: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 5
    //   276: getfield 164	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   279: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aconst_null
    //   289: ldc 176
    //   291: ldc 178
    //   293: ldc 178
    //   295: ldc 180
    //   297: ldc 180
    //   299: iconst_0
    //   300: iconst_0
    //   301: aload 5
    //   303: getfield 164	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   306: invokestatic 185	java/lang/Long:toString	(J)Ljava/lang/String;
    //   309: aload 5
    //   311: getfield 143	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   314: ldc 147
    //   316: iconst_1
    //   317: anewarray 149	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: invokestatic 154	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   325: aastore
    //   326: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   329: aconst_null
    //   330: invokestatic 191	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_0
    //   334: aload 5
    //   336: getfield 122	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   339: invokevirtual 194	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	(Ljava/lang/String;)Ljava/lang/String;
    //   342: astore 6
    //   344: aload 5
    //   346: getfield 101	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   349: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifne +152 -> 504
    //   355: aload 5
    //   357: getfield 101	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   360: ldc 202
    //   362: invokevirtual 206	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   365: ifeq +139 -> 504
    //   368: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq +86 -> 457
    //   374: ldc 129
    //   376: iconst_2
    //   377: new 131	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   384: ldc 208
    //   386: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_0
    //   390: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   393: getfield 22	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   396: invokevirtual 58	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   399: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc 140
    //   404: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 5
    //   409: getfield 143	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   412: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc 145
    //   417: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc 147
    //   422: iconst_1
    //   423: anewarray 149	java/lang/Object
    //   426: dup
    //   427: iconst_0
    //   428: invokestatic 154	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   431: aastore
    //   432: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   435: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc 160
    //   440: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 5
    //   445: getfield 164	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   448: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   451: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   457: aconst_null
    //   458: ldc 176
    //   460: ldc 178
    //   462: ldc 178
    //   464: ldc 210
    //   466: ldc 210
    //   468: iconst_0
    //   469: iconst_0
    //   470: aload 5
    //   472: getfield 164	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   475: invokestatic 185	java/lang/Long:toString	(J)Ljava/lang/String;
    //   478: aload 5
    //   480: getfield 143	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   483: ldc 147
    //   485: iconst_1
    //   486: anewarray 149	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: invokestatic 154	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   494: aastore
    //   495: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   498: invokestatic 214	pqf:a	()Ljava/lang/String;
    //   501: invokestatic 191	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload 5
    //   506: getfield 101	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   509: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   512: ifne -409 -> 103
    //   515: aload 6
    //   517: ifnull -414 -> 103
    //   520: aload 6
    //   522: ldc 202
    //   524: invokevirtual 206	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   527: ifeq -424 -> 103
    //   530: aload 5
    //   532: getfield 101	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   535: ldc 216
    //   537: invokevirtual 219	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   540: ifeq -437 -> 103
    //   543: aconst_null
    //   544: ldc 176
    //   546: ldc 178
    //   548: ldc 178
    //   550: ldc 210
    //   552: ldc 210
    //   554: iconst_0
    //   555: iconst_0
    //   556: aload 5
    //   558: getfield 164	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   561: invokestatic 185	java/lang/Long:toString	(J)Ljava/lang/String;
    //   564: aload 5
    //   566: getfield 143	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   569: ldc 147
    //   571: iconst_1
    //   572: anewarray 149	java/lang/Object
    //   575: dup
    //   576: iconst_0
    //   577: invokestatic 154	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   580: aastore
    //   581: invokestatic 158	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   584: invokestatic 214	pqf:a	()Ljava/lang/String;
    //   587: invokestatic 191	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   590: goto -487 -> 103
    //   593: astore_3
    //   594: ldc 36
    //   596: monitorexit
    //   597: aload_3
    //   598: athrow
    //   599: astore_3
    //   600: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   603: ifeq +52 -> 655
    //   606: ldc 129
    //   608: iconst_2
    //   609: new 131	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   616: ldc 221
    //   618: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload_3
    //   622: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   625: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: goto +24 -> 655
    //   634: aload 4
    //   636: ldc 36
    //   638: invokevirtual 228	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   641: pop
    //   642: ldc 36
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyDAUReport
 * JD-Core Version:    0.7.0.1
 */