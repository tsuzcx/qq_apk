package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;

public class ActivityDAUReport
  extends AsyncStep
{
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mobileqq/app/automator/step/ActivityDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   4: getfield 22	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   7: invokevirtual 28	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 34	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_3
    //   14: ldc 36
    //   16: monitorenter
    //   17: aload_3
    //   18: ldc 36
    //   20: invokevirtual 42	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnull +308 -> 333
    //   28: aload_2
    //   29: invokeinterface 47 1 0
    //   34: ifle +299 -> 333
    //   37: aload_2
    //   38: invokeinterface 51 1 0
    //   43: astore 4
    //   45: aload 4
    //   47: invokeinterface 57 1 0
    //   52: ifeq +274 -> 326
    //   55: aload 4
    //   57: invokeinterface 61 1 0
    //   62: checkcast 36	com/tencent/mobileqq/data/ActivityDAUInfo
    //   65: astore 5
    //   67: new 63	java/util/HashMap
    //   70: dup
    //   71: iconst_2
    //   72: invokespecial 66	java/util/HashMap:<init>	(I)V
    //   75: astore 6
    //   77: aload 6
    //   79: ldc 68
    //   81: aload 5
    //   83: getfield 71	com/tencent/mobileqq/data/ActivityDAUInfo:activityName	Ljava/lang/String;
    //   86: invokevirtual 75	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload 6
    //   92: ldc 77
    //   94: aload 5
    //   96: getfield 80	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   99: invokestatic 86	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   102: invokevirtual 75	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: aload 6
    //   108: ldc 88
    //   110: aload 5
    //   112: getfield 90	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   115: invokevirtual 75	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: pop
    //   119: aload 6
    //   121: ldc 92
    //   123: aload 5
    //   125: getfield 94	com/tencent/mobileqq/data/ActivityDAUInfo:webTitle	Ljava/lang/String;
    //   128: invokevirtual 75	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: pop
    //   132: aload 6
    //   134: ldc 96
    //   136: aload 5
    //   138: getfield 98	com/tencent/mobileqq/data/ActivityDAUInfo:domain	Ljava/lang/String;
    //   141: invokevirtual 75	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload 6
    //   147: ldc 100
    //   149: aload 5
    //   151: getfield 102	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   154: invokevirtual 75	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   157: pop
    //   158: aload 6
    //   160: ldc 104
    //   162: aload 5
    //   164: getfield 106	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   167: invokevirtual 75	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: pop
    //   171: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +97 -> 271
    //   177: ldc 113
    //   179: iconst_2
    //   180: new 115	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   187: ldc 118
    //   189: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 5
    //   194: getfield 71	com/tencent/mobileqq/data/ActivityDAUInfo:activityName	Ljava/lang/String;
    //   197: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 124
    //   202: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 5
    //   207: getfield 80	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   210: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: ldc 129
    //   215: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 5
    //   220: getfield 132	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   223: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc 124
    //   228: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 5
    //   233: getfield 136	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   236: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: ldc 141
    //   241: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 5
    //   246: getfield 106	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   249: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 143
    //   254: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 5
    //   259: getfield 102	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   262: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: invokestatic 157	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   274: invokestatic 163	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   277: aconst_null
    //   278: ldc 165
    //   280: iconst_1
    //   281: aload 5
    //   283: getfield 132	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   286: i2l
    //   287: aload 5
    //   289: getfield 136	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   292: aload 6
    //   294: aconst_null
    //   295: invokevirtual 169	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   298: goto -253 -> 45
    //   301: astore_2
    //   302: ldc 36
    //   304: monitorexit
    //   305: aload_2
    //   306: athrow
    //   307: astore_2
    //   308: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +75 -> 386
    //   314: ldc 113
    //   316: iconst_2
    //   317: ldc 171
    //   319: aload_2
    //   320: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   323: goto +63 -> 386
    //   326: aload_3
    //   327: ldc 36
    //   329: invokevirtual 178	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   332: pop
    //   333: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +34 -> 370
    //   339: aload_2
    //   340: ifnonnull +36 -> 376
    //   343: iconst_0
    //   344: istore_1
    //   345: ldc 113
    //   347: iconst_2
    //   348: new 115	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   355: ldc 180
    //   357: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: iload_1
    //   361: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: ldc 36
    //   372: monitorexit
    //   373: bipush 7
    //   375: ireturn
    //   376: aload_2
    //   377: invokeinterface 47 1 0
    //   382: istore_1
    //   383: goto -38 -> 345
    //   386: aconst_null
    //   387: astore_2
    //   388: goto -364 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	ActivityDAUReport
    //   344	39	1	i	int
    //   23	15	2	localList	java.util.List
    //   301	5	2	localObject1	java.lang.Object
    //   307	70	2	localException	java.lang.Exception
    //   387	1	2	localObject2	java.lang.Object
    //   13	314	3	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   43	13	4	localIterator	java.util.Iterator
    //   65	223	5	localActivityDAUInfo	com.tencent.mobileqq.data.ActivityDAUInfo
    //   75	218	6	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   17	24	301	finally
    //   28	45	301	finally
    //   45	271	301	finally
    //   271	298	301	finally
    //   302	305	301	finally
    //   308	323	301	finally
    //   326	333	301	finally
    //   333	339	301	finally
    //   345	370	301	finally
    //   370	373	301	finally
    //   376	383	301	finally
    //   17	24	307	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActivityDAUReport
 * JD-Core Version:    0.7.0.1
 */