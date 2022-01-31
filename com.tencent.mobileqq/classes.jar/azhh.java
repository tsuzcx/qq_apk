import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.1;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class azhh
{
  public static List<TroopAIONotifyItem> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList();
        try
        {
          atmp localatmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          paramQQAppInterface = localatmp.a(TroopAIONotifyItem.class, false, "troopUin=?", new String[] { paramString }, null, null, null, null);
          localatmp.a();
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder().append("getLocalNotifyItems, size=");
            if (paramQQAppInterface != null) {
              continue;
            }
            i = 0;
            QLog.d(".troop.notify_feeds.data", 2, i);
          }
          if (paramQQAppInterface == null) {
            continue;
          }
        }
        catch (Exception paramQQAppInterface)
        {
          int i;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(".troop.notify_feeds.data", 2, "getLocalNotifyItems, exp:" + paramQQAppInterface.toString());
          paramQQAppInterface = localArrayList;
          continue;
        }
        return paramQQAppInterface;
      }
      finally {}
      i = paramQQAppInterface.size();
    }
  }
  
  public static List<TroopAIONotifyItem> a(QQAppInterface paramQQAppInterface, List<TroopAIONotifyItem> paramList1, List<TroopAIONotifyItem> paramList2)
  {
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i;
    int j;
    Object localObject;
    boolean bool2;
    boolean bool1;
    label328:
    try
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      i = 0;
      j = 0;
      if (j < paramList1.size())
      {
        localObject = (TroopAIONotifyItem)paramList1.get(j);
        if (QLog.isColorLevel()) {
          QLog.i(".troop.notify_feeds.data.detail", 2, "mergeItemList, fromServer=" + localObject);
        }
        if (((TroopAIONotifyItem)localObject).type == 1)
        {
          if (localArrayList1.size() != 0) {
            break label700;
          }
          localArrayList1.add(localObject);
          break label700;
        }
        if (((TroopAIONotifyItem)localObject).type != 2) {
          break label711;
        }
        localArrayList2.add(localObject);
        break label711;
      }
      long l = NetConnInfoCenter.getServerTime();
      paramList1 = new ArrayList();
      j = paramList2.size() - 1;
      if (j < 0) {
        break label429;
      }
      localObject = (TroopAIONotifyItem)paramList2.get(j);
      if (QLog.isColorLevel()) {
        QLog.i(".troop.notify_feeds.data.detail", 2, "mergeItemList, fromDb=" + localObject);
      }
      if (((TroopAIONotifyItem)localObject).type == 1)
      {
        if (i == 0) {
          break label714;
        }
        paramList2.remove(j);
        paramList1.add(localObject);
        if (!QLog.isColorLevel()) {
          break label714;
        }
        QLog.i(".troop.notify_feeds.data", 2, "mergeItemList, hasNewAppNotify removeLocalAppItem, id=" + ((TroopAIONotifyItem)localObject).id + ", " + ((TroopAIONotifyItem)localObject).title);
        break label714;
      }
      if (((TroopAIONotifyItem)localObject).type != 2) {
        break label714;
      }
      bool2 = localArrayList2.contains(localObject);
      if (((TroopAIONotifyItem)localObject).expireTime >= l) {
        break label423;
      }
      bool1 = true;
    }
    finally {}
    paramList2.remove(j);
    paramList1.add(localObject);
    label423:
    label429:
    ArrayList localArrayList3;
    if (QLog.isColorLevel())
    {
      QLog.i(".troop.notify_feeds.data", 2, "mergeItemList, removeLocalPushItem, hasUpdate=" + bool2 + ", isExpired=" + bool1 + ", id=" + ((TroopAIONotifyItem)localObject).id + ", " + ((TroopAIONotifyItem)localObject).title);
      break label714;
      bool1 = false;
      break label723;
      localObject = new ArrayList();
      localArrayList3 = new ArrayList();
      j = 0;
    }
    for (;;)
    {
      if (j < paramList2.size())
      {
        TroopAIONotifyItem localTroopAIONotifyItem = (TroopAIONotifyItem)paramList2.get(j);
        if (localTroopAIONotifyItem.type == 1)
        {
          if (i == 0) {
            if (((List)localObject).size() == 0)
            {
              ((List)localObject).add(localTroopAIONotifyItem);
            }
            else
            {
              paramList1.add(localTroopAIONotifyItem);
              if (QLog.isColorLevel()) {
                QLog.i(".troop.notify_feeds.data", 2, "mergeItemList, moreThanOne removeLocalAppItem, id=" + localTroopAIONotifyItem.id + ", " + localTroopAIONotifyItem.title);
              }
            }
          }
        }
        else if (localTroopAIONotifyItem.type == 2) {
          localArrayList3.add(localTroopAIONotifyItem);
        }
      }
      else
      {
        b(paramQQAppInterface, paramList1);
        paramList1 = new ArrayList();
        paramList1.addAll(localArrayList1);
        paramList1.addAll(localArrayList2);
        a(paramQQAppInterface, paramList1);
        paramList1.clear();
        if (i != 0)
        {
          paramList1.addAll(localArrayList1);
          paramList1.addAll(localArrayList2);
          paramList1.addAll(localArrayList3);
        }
        for (;;)
        {
          return paramList1;
          paramList1.addAll((Collection)localObject);
          paramList1.addAll(localArrayList2);
          paramList1.addAll(localArrayList3);
        }
        label700:
        i = 1;
        label711:
        for (;;)
        {
          j += 1;
          break;
        }
        label714:
        label723:
        do
        {
          j -= 1;
          break;
          if (bool2) {
            break label328;
          }
        } while (!bool1);
        break label328;
      }
      j += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopAIONotifyItem paramTroopAIONotifyItem)
  {
    if (paramTroopAIONotifyItem == null) {
      return;
    }
    ThreadManager.post(new TroopAioNotifyManager.2(paramQQAppInterface, paramTroopAIONotifyItem), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ajtg localajtg = (ajtg)paramQQAppInterface.a(20);
    Integer localInteger = ChatActivityUtils.a(paramString, paramQQAppInterface.getCurrentAccountUin());
    if ((localInteger != null) && (localInteger.intValue() == -1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.data", 2, "reqNotifyItems, troopUin=" + paramString + ", hasNewNotify=" + bool);
      }
      if (!bool) {
        break;
      }
      localajtg.e(Long.valueOf(paramString).longValue());
      azkm.a(paramQQAppInterface, paramString, 1102858908);
      ChatActivityUtils.a(paramQQAppInterface, paramString, Integer.valueOf(0));
      return;
    }
    ThreadManager.post(new TroopAioNotifyManager.1(paramQQAppInterface, paramString, localajtg), 8, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<TroopAIONotifyItem> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      int j;
      int i;
      try
      {
        j = paramList.size();
        if (j == 0) {
          return;
        }
        try
        {
          paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          i = 0;
          if (i >= j) {
            break label123;
          }
          TroopAIONotifyItem localTroopAIONotifyItem = (TroopAIONotifyItem)paramList.get(i);
          if (localTroopAIONotifyItem.getStatus() == 1000) {
            paramQQAppInterface.b(localTroopAIONotifyItem);
          } else {
            paramQQAppInterface.a(localTroopAIONotifyItem);
          }
        }
        catch (Exception paramQQAppInterface) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(".troop.notify_feeds.data", 2, "saveNotifyItems, exp:" + paramQQAppInterface.toString());
        continue;
        paramQQAppInterface.a();
      }
      finally {}
      label123:
      if (QLog.isColorLevel())
      {
        QLog.d(".troop.notify_feeds.data", 2, "saveNotifyItems, size=" + j);
        continue;
        i += 1;
      }
    }
  }
  
  /* Error */
  public static void b(QQAppInterface paramQQAppInterface, List<TroopAIONotifyItem> paramList)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnull +14 -> 18
    //   7: aload_1
    //   8: invokeinterface 75 1 0
    //   13: istore_3
    //   14: iload_3
    //   15: ifne +7 -> 22
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: invokevirtual 22	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Latmq;
    //   26: invokevirtual 28	atmq:createEntityManager	()Latmp;
    //   29: astore_0
    //   30: iconst_0
    //   31: istore_2
    //   32: iload_2
    //   33: iload_3
    //   34: if_icmpge +25 -> 59
    //   37: aload_0
    //   38: aload_1
    //   39: iload_2
    //   40: invokeinterface 88 2 0
    //   45: checkcast 239	atmo
    //   48: invokevirtual 241	atmp:b	(Latmo;)Z
    //   51: pop
    //   52: iload_2
    //   53: iconst_1
    //   54: iadd
    //   55: istore_2
    //   56: goto -24 -> 32
    //   59: aload_0
    //   60: invokevirtual 41	atmp:a	()V
    //   63: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq -48 -> 18
    //   69: ldc 58
    //   71: iconst_2
    //   72: new 49	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   79: ldc 243
    //   81: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload_3
    //   85: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: goto -76 -> 18
    //   97: astore_0
    //   98: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq -83 -> 18
    //   104: ldc 58
    //   106: iconst_2
    //   107: new 49	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   114: ldc 245
    //   116: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokevirtual 78	java/lang/Exception:toString	()Ljava/lang/String;
    //   123: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: goto -114 -> 18
    //   135: astore_0
    //   136: ldc 2
    //   138: monitorexit
    //   139: aload_0
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramQQAppInterface	QQAppInterface
    //   0	141	1	paramList	List<TroopAIONotifyItem>
    //   31	25	2	i	int
    //   13	72	3	j	int
    // Exception table:
    //   from	to	target	type
    //   22	30	97	java/lang/Exception
    //   37	52	97	java/lang/Exception
    //   59	94	97	java/lang/Exception
    //   7	14	135	finally
    //   22	30	135	finally
    //   37	52	135	finally
    //   59	94	135	finally
    //   98	132	135	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azhh
 * JD-Core Version:    0.7.0.1
 */