package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;

public class ActivityDAUReport
  extends AsyncStep
{
  /* Error */
  protected int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mobileqq/app/automator/step/ActivityDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   4: getfield 21	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   7: invokevirtual 27	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 33	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_3
    //   14: ldc 35
    //   16: monitorenter
    //   17: aload_3
    //   18: ldc 35
    //   20: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnull +324 -> 349
    //   28: aload_2
    //   29: invokeinterface 45 1 0
    //   34: ifle +315 -> 349
    //   37: aload_2
    //   38: invokeinterface 49 1 0
    //   43: astore 4
    //   45: aload 4
    //   47: invokeinterface 55 1 0
    //   52: ifeq +290 -> 342
    //   55: aload 4
    //   57: invokeinterface 59 1 0
    //   62: checkcast 35	com/tencent/mobileqq/data/ActivityDAUInfo
    //   65: astore 5
    //   67: new 61	java/util/HashMap
    //   70: dup
    //   71: iconst_2
    //   72: invokespecial 64	java/util/HashMap:<init>	(I)V
    //   75: astore 6
    //   77: aload 6
    //   79: ldc 66
    //   81: aload 5
    //   83: getfield 69	com/tencent/mobileqq/data/ActivityDAUInfo:activityName	Ljava/lang/String;
    //   86: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload 6
    //   92: ldc 75
    //   94: aload 5
    //   96: getfield 78	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   99: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   102: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: aload 6
    //   108: ldc 86
    //   110: aload 5
    //   112: getfield 88	com/tencent/mobileqq/data/ActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   115: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: pop
    //   119: aload 6
    //   121: ldc 90
    //   123: aload 5
    //   125: getfield 92	com/tencent/mobileqq/data/ActivityDAUInfo:webTitle	Ljava/lang/String;
    //   128: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: pop
    //   132: aload 6
    //   134: ldc 94
    //   136: aload 5
    //   138: getfield 96	com/tencent/mobileqq/data/ActivityDAUInfo:domain	Ljava/lang/String;
    //   141: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload 6
    //   147: ldc 98
    //   149: aload 5
    //   151: getfield 100	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   154: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   157: pop
    //   158: aload 6
    //   160: ldc 102
    //   162: aload 5
    //   164: getfield 104	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   167: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: pop
    //   171: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +97 -> 271
    //   177: ldc 111
    //   179: iconst_2
    //   180: new 113	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   187: ldc 116
    //   189: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 5
    //   194: getfield 69	com/tencent/mobileqq/data/ActivityDAUInfo:activityName	Ljava/lang/String;
    //   197: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 122
    //   202: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 5
    //   207: getfield 78	com/tencent/mobileqq/data/ActivityDAUInfo:count	I
    //   210: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: ldc 127
    //   215: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 5
    //   220: getfield 130	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   223: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc 122
    //   228: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 5
    //   233: getfield 134	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   236: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: ldc 139
    //   241: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 5
    //   246: getfield 104	com/tencent/mobileqq/data/ActivityDAUInfo:pageName	Ljava/lang/String;
    //   249: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 141
    //   254: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 5
    //   259: getfield 100	com/tencent/mobileqq/data/ActivityDAUInfo:reportVersion	Ljava/lang/String;
    //   262: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: invokestatic 155	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   274: invokestatic 160	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   277: aconst_null
    //   278: ldc 162
    //   280: iconst_1
    //   281: aload 5
    //   283: getfield 130	com/tencent/mobileqq/data/ActivityDAUInfo:displayCount	I
    //   286: i2l
    //   287: aload 5
    //   289: getfield 134	com/tencent/mobileqq/data/ActivityDAUInfo:showTime	J
    //   292: aload 6
    //   294: aconst_null
    //   295: invokevirtual 165	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   298: goto -253 -> 45
    //   301: astore_2
    //   302: ldc 35
    //   304: monitorexit
    //   305: aload_2
    //   306: athrow
    //   307: astore_2
    //   308: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +91 -> 402
    //   314: ldc 111
    //   316: iconst_2
    //   317: new 113	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   324: ldc 167
    //   326: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_2
    //   330: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: goto +63 -> 402
    //   342: aload_3
    //   343: ldc 35
    //   345: invokevirtual 173	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   348: pop
    //   349: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +34 -> 386
    //   355: aload_2
    //   356: ifnonnull +36 -> 392
    //   359: iconst_0
    //   360: istore_1
    //   361: ldc 111
    //   363: iconst_2
    //   364: new 113	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   371: ldc 175
    //   373: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: iload_1
    //   377: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: ldc 35
    //   388: monitorexit
    //   389: bipush 7
    //   391: ireturn
    //   392: aload_2
    //   393: invokeinterface 45 1 0
    //   398: istore_1
    //   399: goto -38 -> 361
    //   402: aconst_null
    //   403: astore_2
    //   404: goto -380 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	ActivityDAUReport
    //   360	39	1	i	int
    //   23	15	2	localList	java.util.List
    //   301	5	2	localObject1	java.lang.Object
    //   307	86	2	localException	java.lang.Exception
    //   403	1	2	localObject2	java.lang.Object
    //   13	330	3	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
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
    //   308	339	301	finally
    //   342	349	301	finally
    //   349	355	301	finally
    //   361	386	301	finally
    //   386	389	301	finally
    //   392	399	301	finally
    //   17	24	307	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActivityDAUReport
 * JD-Core Version:    0.7.0.1
 */