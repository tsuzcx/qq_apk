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
    //   33: bipush 51
    //   35: invokevirtual 46	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   38: checkcast 48	amsw
    //   41: astore 5
    //   43: aload 5
    //   45: ifnull +602 -> 647
    //   48: aload 5
    //   50: aload_0
    //   51: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   54: getfield 22	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   57: invokevirtual 52	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   60: invokevirtual 56	amsw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +580 -> 647
    //   70: aload 5
    //   72: getfield 62	com/tencent/mobileqq/data/Card:shGender	S
    //   75: istore_2
    //   76: aload 5
    //   78: getfield 66	com/tencent/mobileqq/data/Card:age	B
    //   81: istore_1
    //   82: aload_3
    //   83: ifnull +550 -> 633
    //   86: aload_3
    //   87: invokeinterface 71 1 0
    //   92: ifle +541 -> 633
    //   95: aload_3
    //   96: invokeinterface 75 1 0
    //   101: astore_3
    //   102: aload_3
    //   103: invokeinterface 81 1 0
    //   108: ifeq +525 -> 633
    //   111: aload_3
    //   112: invokeinterface 85 1 0
    //   117: checkcast 36	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo
    //   120: astore 5
    //   122: new 87	java/util/HashMap
    //   125: dup
    //   126: iconst_2
    //   127: invokespecial 90	java/util/HashMap:<init>	(I)V
    //   130: astore 6
    //   132: aload 6
    //   134: ldc 92
    //   136: aload 5
    //   138: getfield 95	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   141: invokevirtual 99	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload 6
    //   147: ldc 101
    //   149: aload 5
    //   151: getfield 104	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:count	I
    //   154: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   157: invokevirtual 99	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: aload 6
    //   163: ldc 112
    //   165: iload_2
    //   166: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   169: invokevirtual 99	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: pop
    //   173: aload 6
    //   175: ldc 113
    //   177: iload_1
    //   178: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   181: invokevirtual 99	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: pop
    //   185: aload 6
    //   187: ldc 115
    //   189: aload 5
    //   191: getfield 117	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   194: invokevirtual 99	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +86 -> 287
    //   204: ldc 124
    //   206: iconst_2
    //   207: new 126	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   214: ldc 129
    //   216: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   223: getfield 22	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   226: invokevirtual 52	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   229: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 135
    //   234: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload 5
    //   239: getfield 138	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   242: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc 140
    //   247: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 142
    //   252: iconst_1
    //   253: anewarray 144	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: invokestatic 149	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   261: aastore
    //   262: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   265: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 155
    //   270: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 5
    //   275: getfield 159	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   278: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   281: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aconst_null
    //   288: ldc 171
    //   290: ldc 173
    //   292: ldc 173
    //   294: ldc 175
    //   296: ldc 175
    //   298: iconst_0
    //   299: iconst_0
    //   300: aload 5
    //   302: getfield 159	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   305: invokestatic 180	java/lang/Long:toString	(J)Ljava/lang/String;
    //   308: aload 5
    //   310: getfield 138	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   313: ldc 142
    //   315: iconst_1
    //   316: anewarray 144	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: invokestatic 149	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   324: aastore
    //   325: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   328: aconst_null
    //   329: invokestatic 186	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload_0
    //   333: aload 5
    //   335: getfield 117	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   338: invokevirtual 189	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	(Ljava/lang/String;)Ljava/lang/String;
    //   341: astore 6
    //   343: aload 5
    //   345: getfield 95	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   348: invokestatic 195	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   351: ifne +152 -> 503
    //   354: aload 5
    //   356: getfield 95	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   359: ldc 197
    //   361: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   364: ifeq +139 -> 503
    //   367: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +86 -> 456
    //   373: ldc 124
    //   375: iconst_2
    //   376: new 126	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   383: ldc 203
    //   385: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_0
    //   389: getfield 16	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   392: getfield 22	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   395: invokevirtual 52	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   398: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: ldc 135
    //   403: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload 5
    //   408: getfield 138	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   411: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc 140
    //   416: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: ldc 142
    //   421: iconst_1
    //   422: anewarray 144	java/lang/Object
    //   425: dup
    //   426: iconst_0
    //   427: invokestatic 149	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   430: aastore
    //   431: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   434: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc 155
    //   439: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload 5
    //   444: getfield 159	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   447: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   450: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: aconst_null
    //   457: ldc 171
    //   459: ldc 173
    //   461: ldc 173
    //   463: ldc 205
    //   465: ldc 205
    //   467: iconst_0
    //   468: iconst_0
    //   469: aload 5
    //   471: getfield 159	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   474: invokestatic 180	java/lang/Long:toString	(J)Ljava/lang/String;
    //   477: aload 5
    //   479: getfield 138	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   482: ldc 142
    //   484: iconst_1
    //   485: anewarray 144	java/lang/Object
    //   488: dup
    //   489: iconst_0
    //   490: invokestatic 149	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   493: aastore
    //   494: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   497: invokestatic 208	pay:f	()Ljava/lang/String;
    //   500: invokestatic 186	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   503: aload 5
    //   505: getfield 95	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   508: invokestatic 195	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   511: ifne -409 -> 102
    //   514: aload 6
    //   516: ifnull -414 -> 102
    //   519: aload 6
    //   521: ldc 197
    //   523: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   526: ifeq -424 -> 102
    //   529: aload 5
    //   531: getfield 95	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   534: ldc 210
    //   536: invokevirtual 213	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   539: ifeq -437 -> 102
    //   542: aconst_null
    //   543: ldc 171
    //   545: ldc 173
    //   547: ldc 173
    //   549: ldc 205
    //   551: ldc 205
    //   553: iconst_0
    //   554: iconst_0
    //   555: aload 5
    //   557: getfield 159	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   560: invokestatic 180	java/lang/Long:toString	(J)Ljava/lang/String;
    //   563: aload 5
    //   565: getfield 138	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   568: ldc 142
    //   570: iconst_1
    //   571: anewarray 144	java/lang/Object
    //   574: dup
    //   575: iconst_0
    //   576: invokestatic 149	com/tencent/common/config/AppSetting:f	()Ljava/lang/String;
    //   579: aastore
    //   580: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   583: invokestatic 208	pay:f	()Ljava/lang/String;
    //   586: invokestatic 186	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   589: goto -487 -> 102
    //   592: astore_3
    //   593: ldc 36
    //   595: monitorexit
    //   596: aload_3
    //   597: athrow
    //   598: astore_3
    //   599: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   602: ifeq +52 -> 654
    //   605: ldc 124
    //   607: iconst_2
    //   608: new 126	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   615: ldc 215
    //   617: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload_3
    //   621: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: goto +24 -> 654
    //   633: aload 4
    //   635: ldc 36
    //   637: invokevirtual 222	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   640: pop
    //   641: ldc 36
    //   643: monitorexit
    //   644: bipush 7
    //   646: ireturn
    //   647: iconst_m1
    //   648: istore_1
    //   649: iconst_m1
    //   650: istore_2
    //   651: goto -569 -> 82
    //   654: aconst_null
    //   655: astore_3
    //   656: goto -630 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	659	0	this	ReadInJoyDAUReport
    //   81	568	1	i	int
    //   75	576	2	j	int
    //   25	87	3	localObject1	java.lang.Object
    //   592	5	3	localObject2	java.lang.Object
    //   598	23	3	localException	java.lang.Exception
    //   655	1	3	localObject3	java.lang.Object
    //   13	621	4	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   41	523	5	localObject4	java.lang.Object
    //   130	390	6	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   18	26	592	finally
    //   26	43	592	finally
    //   48	65	592	finally
    //   70	82	592	finally
    //   86	102	592	finally
    //   102	287	592	finally
    //   287	456	592	finally
    //   456	503	592	finally
    //   503	514	592	finally
    //   519	589	592	finally
    //   593	596	592	finally
    //   599	630	592	finally
    //   633	644	592	finally
    //   18	26	598	java/lang/Exception
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