package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;

public class ActivityDAUReport
  extends AsyncStep
{
  /* Error */
  protected int doStep()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mobileqq/app/automator/step/ActivityDAUReport:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   4: getfield 23	com/tencent/mobileqq/app/automator/Automator:l	Lcom/tencent/common/app/AppInterface;
    //   7: invokevirtual 29	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 35	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore 4
    //   15: ldc 37
    //   17: monitorenter
    //   18: aconst_null
    //   19: astore_3
    //   20: aload 4
    //   22: ldc 37
    //   24: invokevirtual 43	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   27: astore_2
    //   28: goto +29 -> 57
    //   31: astore_2
    //   32: goto +406 -> 438
    //   35: astore 5
    //   37: aload_3
    //   38: astore_2
    //   39: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +15 -> 57
    //   45: ldc 51
    //   47: iconst_2
    //   48: ldc 53
    //   50: aload 5
    //   52: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   55: aload_3
    //   56: astore_2
    //   57: aload_2
    //   58: ifnull +321 -> 379
    //   61: aload_2
    //   62: invokeinterface 62 1 0
    //   67: ifle +312 -> 379
    //   70: aload_2
    //   71: invokeinterface 66 1 0
    //   76: astore_3
    //   77: aload_3
    //   78: invokeinterface 71 1 0
    //   83: ifeq +288 -> 371
    //   86: aload_3
    //   87: invokeinterface 75 1 0
    //   92: checkcast 37	com/tencent/mobileqq/data/ActivityDAUInfo
    //   95: astore 5
    //   97: new 77	java/util/HashMap
    //   100: dup
    //   101: iconst_2
    //   102: invokespecial 80	java/util/HashMap:<init>	(I)V
    //   105: astore 6
    //   107: aload 6
    //   109: ldc 82
    //   111: aload 5
    //   113: getfield 85	com/tencent/mobileqq/data/ActivityDAUInfo:activityName	Ljava/lang/String;
    //   116: invokevirtual 89	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: aload 6
    //   122: ldc 91
    //   124: aload 5
    //   126: getfield 94	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   129: invokestatic 100	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   132: invokevirtual 89	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: aload 6
    //   138: ldc 102
    //   140: aload 5
    //   142: getfield 104	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   145: invokevirtual 89	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: aload 6
    //   151: ldc 106
    //   153: aload 5
    //   155: getfield 108	com/tencent/mobileqq/data/ActivityDAUInfo:webTitle	Ljava/lang/String;
    //   158: invokevirtual 89	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: pop
    //   162: aload 6
    //   164: ldc 110
    //   166: aload 5
    //   168: getfield 112	com/tencent/mobileqq/data/ActivityDAUInfo:domain	Ljava/lang/String;
    //   171: invokevirtual 89	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: aload 6
    //   177: ldc 114
    //   179: aload 5
    //   181: getfield 116	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   184: invokevirtual 89	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: aload 6
    //   190: ldc 118
    //   192: aload 5
    //   194: getfield 120	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   197: invokevirtual 89	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +137 -> 341
    //   207: new 122	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   214: astore 7
    //   216: aload 7
    //   218: ldc 125
    //   220: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 7
    //   226: aload 5
    //   228: getfield 85	com/tencent/mobileqq/data/ActivityDAUInfo:activityName	Ljava/lang/String;
    //   231: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 7
    //   237: ldc 131
    //   239: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 7
    //   245: aload 5
    //   247: getfield 94	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   250: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 7
    //   256: ldc 136
    //   258: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 7
    //   264: aload 5
    //   266: getfield 139	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   269: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 7
    //   275: ldc 131
    //   277: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 7
    //   283: aload 5
    //   285: getfield 143	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   288: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 7
    //   294: ldc 148
    //   296: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 7
    //   302: aload 5
    //   304: getfield 120	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   307: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 7
    //   313: ldc 150
    //   315: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 7
    //   321: aload 5
    //   323: getfield 116	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   326: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: ldc 51
    //   332: iconst_2
    //   333: aload 7
    //   335: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: invokestatic 163	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   344: invokestatic 169	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   347: aconst_null
    //   348: ldc 171
    //   350: iconst_1
    //   351: aload 5
    //   353: getfield 139	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   356: i2l
    //   357: aload 5
    //   359: getfield 143	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   362: aload 6
    //   364: aconst_null
    //   365: invokevirtual 175	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   368: goto -291 -> 77
    //   371: aload 4
    //   373: ldc 37
    //   375: invokevirtual 179	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   378: pop
    //   379: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +50 -> 432
    //   385: aload_2
    //   386: ifnonnull +8 -> 394
    //   389: iconst_0
    //   390: istore_1
    //   391: goto +10 -> 401
    //   394: aload_2
    //   395: invokeinterface 62 1 0
    //   400: istore_1
    //   401: new 122	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   408: astore_2
    //   409: aload_2
    //   410: ldc 181
    //   412: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_2
    //   417: iload_1
    //   418: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: ldc 51
    //   424: iconst_2
    //   425: aload_2
    //   426: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: ldc 37
    //   434: monitorexit
    //   435: bipush 7
    //   437: ireturn
    //   438: ldc 37
    //   440: monitorexit
    //   441: goto +5 -> 446
    //   444: aload_2
    //   445: athrow
    //   446: goto -2 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	ActivityDAUReport
    //   390	28	1	i	int
    //   27	1	2	localList	java.util.List
    //   31	1	2	localObject1	java.lang.Object
    //   38	407	2	localObject2	java.lang.Object
    //   19	68	3	localIterator	java.util.Iterator
    //   13	359	4	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   35	16	5	localException	java.lang.Exception
    //   95	263	5	localActivityDAUInfo	com.tencent.mobileqq.data.ActivityDAUInfo
    //   105	258	6	localHashMap	java.util.HashMap
    //   214	120	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   20	28	31	finally
    //   39	55	31	finally
    //   61	77	31	finally
    //   77	341	31	finally
    //   341	368	31	finally
    //   371	379	31	finally
    //   379	385	31	finally
    //   394	401	31	finally
    //   401	432	31	finally
    //   432	435	31	finally
    //   438	441	31	finally
    //   20	28	35	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActivityDAUReport
 * JD-Core Version:    0.7.0.1
 */