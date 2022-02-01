package com.tencent.mobileqq.app.asyncdb.cache;

import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.util.concurrent.ConcurrentHashMap;

public class TroopStatisticsCache
  extends FullCache
{
  /* Error */
  public TroopStatisticsCache(com.tencent.common.app.AppInterface paramAppInterface, com.tencent.mobileqq.app.asyncdb.DBDelayManager paramDBDelayManager)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: ldc 10
    //   5: invokespecial 13	com/tencent/mobileqq/app/asyncdb/FullCache:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/app/asyncdb/DBDelayManager;Ljava/lang/Class;)V
    //   8: aload_1
    //   9: invokevirtual 19	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   12: invokevirtual 25	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: astore_1
    //   16: invokestatic 31	java/lang/System:currentTimeMillis	()J
    //   19: lstore 4
    //   21: lload 4
    //   23: getstatic 37	com/tencent/mobileqq/pic/PreDownloadStrategyBeta:R	Ljava/lang/String;
    //   26: lconst_0
    //   27: invokestatic 43	com/tencent/mobileqq/pic/PicPreDownloadUtils:b	(Ljava/lang/String;J)J
    //   30: lsub
    //   31: ldc2_w 44
    //   34: lcmp
    //   35: ifle +42 -> 77
    //   38: getstatic 37	com/tencent/mobileqq/pic/PreDownloadStrategyBeta:R	Ljava/lang/String;
    //   41: lload 4
    //   43: invokestatic 49	com/tencent/mobileqq/pic/PicPreDownloadUtils:a	(Ljava/lang/String;J)V
    //   46: aload_1
    //   47: ldc 10
    //   49: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   52: pop
    //   53: aload_0
    //   54: getfield 59	com/tencent/mobileqq/app/asyncdb/cache/TroopStatisticsCache:cacheMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   57: invokevirtual 65	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   60: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq +162 -> 225
    //   66: ldc 73
    //   68: iconst_2
    //   69: ldc 75
    //   71: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: goto +151 -> 225
    //   77: aload_1
    //   78: ldc 10
    //   80: invokevirtual 83	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +59 -> 144
    //   88: aload_0
    //   89: getfield 59	com/tencent/mobileqq/app/asyncdb/cache/TroopStatisticsCache:cacheMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   92: invokevirtual 65	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   95: aload_2
    //   96: invokeinterface 89 1 0
    //   101: astore 6
    //   103: aload 6
    //   105: invokeinterface 94 1 0
    //   110: ifeq +34 -> 144
    //   113: aload 6
    //   115: invokeinterface 98 1 0
    //   120: checkcast 10	com/tencent/mobileqq/data/TroopStatisticsInfo
    //   123: astore 7
    //   125: aload_0
    //   126: getfield 59	com/tencent/mobileqq/app/asyncdb/cache/TroopStatisticsCache:cacheMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   129: aload_0
    //   130: aload 7
    //   132: invokevirtual 102	com/tencent/mobileqq/app/asyncdb/cache/TroopStatisticsCache:getKey	(Lcom/tencent/mobileqq/persistence/Entity;)Ljava/lang/String;
    //   135: aload 7
    //   137: invokevirtual 106	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: goto -38 -> 103
    //   144: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +78 -> 225
    //   150: new 108	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   157: astore 6
    //   159: aload 6
    //   161: ldc 112
    //   163: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_2
    //   168: ifnonnull +8 -> 176
    //   171: iconst_0
    //   172: istore_3
    //   173: goto +10 -> 183
    //   176: aload_2
    //   177: invokeinterface 120 1 0
    //   182: istore_3
    //   183: aload 6
    //   185: iload_3
    //   186: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: ldc 73
    //   192: iconst_2
    //   193: aload 6
    //   195: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: goto +24 -> 225
    //   204: astore_2
    //   205: goto +25 -> 230
    //   208: astore_2
    //   209: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +13 -> 225
    //   215: ldc 73
    //   217: iconst_2
    //   218: aload_2
    //   219: invokevirtual 130	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   222: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_1
    //   226: invokevirtual 136	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   229: return
    //   230: aload_1
    //   231: invokevirtual 136	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   234: goto +5 -> 239
    //   237: aload_2
    //   238: athrow
    //   239: goto -2 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	TroopStatisticsCache
    //   0	242	1	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	242	2	paramDBDelayManager	com.tencent.mobileqq.app.asyncdb.DBDelayManager
    //   172	14	3	i	int
    //   19	23	4	l	long
    //   101	93	6	localObject	java.lang.Object
    //   123	13	7	localTroopStatisticsInfo	TroopStatisticsInfo
    // Exception table:
    //   from	to	target	type
    //   38	74	204	finally
    //   77	84	204	finally
    //   88	103	204	finally
    //   103	141	204	finally
    //   144	167	204	finally
    //   176	183	204	finally
    //   183	201	204	finally
    //   209	225	204	finally
    //   38	74	208	java/lang/Exception
    //   77	84	208	java/lang/Exception
    //   88	103	208	java/lang/Exception
    //   103	141	208	java/lang/Exception
    //   144	167	208	java/lang/Exception
    //   176	183	208	java/lang/Exception
    //   183	201	208	java/lang/Exception
  }
  
  public TroopStatisticsInfo a(String paramString)
  {
    if ((this.cacheMap != null) && (paramString != null)) {
      return (TroopStatisticsInfo)this.cacheMap.get(paramString);
    }
    return null;
  }
  
  protected void destroy() {}
  
  protected String getKey(Entity paramEntity)
  {
    return ((TroopStatisticsInfo)paramEntity).troopUin;
  }
  
  protected void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.TroopStatisticsCache
 * JD-Core Version:    0.7.0.1
 */