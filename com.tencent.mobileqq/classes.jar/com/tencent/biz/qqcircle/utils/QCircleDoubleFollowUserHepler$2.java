package com.tencent.biz.qqcircle.utils;

import java.util.List;
import vtj;

public class QCircleDoubleFollowUserHepler$2
  implements Runnable
{
  public QCircleDoubleFollowUserHepler$2(vtj paramvtj, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/biz/qqcircle/utils/QCircleDoubleFollowUserHepler$2:this$0	Lvtj;
    //   4: invokestatic 28	vtj:a	(Lvtj;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: ldc 30
    //   9: invokevirtual 36	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   12: aconst_null
    //   13: aconst_null
    //   14: invokevirtual 42	com/tencent/mobileqq/persistence/EntityManager:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   17: istore_1
    //   18: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +28 -> 49
    //   24: ldc 50
    //   26: iconst_2
    //   27: new 52	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   34: ldc 55
    //   36: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_1
    //   40: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 14	com/tencent/biz/qqcircle/utils/QCircleDoubleFollowUserHepler$2:this$0	Lvtj;
    //   53: invokestatic 28	vtj:a	(Lvtj;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   56: invokevirtual 73	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 78	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   64: aload_0
    //   65: getfield 16	com/tencent/biz/qqcircle/utils/QCircleDoubleFollowUserHepler$2:a	Ljava/util/List;
    //   68: invokeinterface 84 1 0
    //   73: astore_3
    //   74: aload_3
    //   75: invokeinterface 89 1 0
    //   80: ifeq +55 -> 135
    //   83: aload_3
    //   84: invokeinterface 93 1 0
    //   89: checkcast 30	com/tencent/biz/qqcircle/beans/Friend
    //   92: astore 4
    //   94: aload_0
    //   95: getfield 14	com/tencent/biz/qqcircle/utils/QCircleDoubleFollowUserHepler$2:this$0	Lvtj;
    //   98: invokestatic 28	vtj:a	(Lvtj;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   101: aload 4
    //   103: invokevirtual 97	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   106: goto -32 -> 74
    //   109: astore_3
    //   110: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +13 -> 126
    //   116: ldc 50
    //   118: iconst_2
    //   119: aload_3
    //   120: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 106	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   134: return
    //   135: aload_2
    //   136: invokevirtual 109	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   139: aload_2
    //   140: ifnull -6 -> 134
    //   143: aload_2
    //   144: invokevirtual 106	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   147: return
    //   148: astore_3
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 106	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   157: aload_3
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	2
    //   17	23	1	i	int
    //   59	95	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   73	11	3	localIterator	java.util.Iterator
    //   109	11	3	localException	java.lang.Exception
    //   148	10	3	localObject	Object
    //   92	10	4	localFriend	com.tencent.biz.qqcircle.beans.Friend
    // Exception table:
    //   from	to	target	type
    //   60	74	109	java/lang/Exception
    //   74	106	109	java/lang/Exception
    //   135	139	109	java/lang/Exception
    //   60	74	148	finally
    //   74	106	148	finally
    //   110	126	148	finally
    //   135	139	148	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleDoubleFollowUserHepler.2
 * JD-Core Version:    0.7.0.1
 */