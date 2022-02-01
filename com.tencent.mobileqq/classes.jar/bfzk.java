import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class bfzk
  extends Observable
  implements Manager
{
  protected QQAppInterface a;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected final ConcurrentHashMap<String, List<TroopMessageNavigateInfo>> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  
  public bfzk()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public bfzk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mapTroopNavigateInfo: size = ").append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()).append(" {");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    int i = 0;
    label208:
    label222:
    for (;;)
    {
      Object localObject1;
      int j;
      if (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        localObject1 = (List)((Map.Entry)localObject2).getValue();
        localObject2 = localStringBuilder.append((String)((Map.Entry)localObject2).getKey()).append(": size = ");
        if (localObject1 != null) {
          break label208;
        }
        j = 0;
        ((StringBuilder)localObject2).append(j).append("->{ ");
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          j = 0;
        }
      }
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localStringBuilder.append(((TroopMessageNavigateInfo)((Iterator)localObject1).next()).toString()).append(" ");
          j += 1;
          if (j < 10) {}
        }
        else
        {
          localStringBuilder.append(" } ");
          i += 1;
          if (i < 20) {
            break label222;
          }
          localStringBuilder.append(" }");
          return localStringBuilder.toString();
          j = ((List)localObject1).size();
          break;
        }
      }
    }
  }
  
  protected static String a(String paramString, int paramInt)
  {
    if (paramInt == 1) {}
    while (paramInt != 3000) {
      return paramString;
    }
    return paramString + "&" + 3000;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +16 -> 22
    //   9: aload_0
    //   10: getfield 22	bfzk:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_1
    //   14: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 22	bfzk:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: aload_1
    //   30: invokevirtual 123	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 82	java/util/List
    //   36: new 125	bfzl
    //   39: dup
    //   40: aconst_null
    //   41: invokespecial 128	bfzl:<init>	(Lcom/tencent/mobileqq/troop/navigatebar/TroopAioNavigateBarManager$1;)V
    //   44: invokestatic 134	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   47: goto -25 -> 22
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	bfzk
    //   0	55	1	paramString	String
    //   17	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	50	finally
    //   25	47	50	finally
  }
  
  private void b()
  {
    ThreadManager.excute(new TroopAioNavigateBarManager.1(this), 32, null, false);
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        a();
        int i = 0;
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          List localList = (List)localEntry.getValue();
          Iterator localIterator2 = localList.iterator();
          if (localIterator2.hasNext())
          {
            TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localIterator2.next();
            if (localTroopMessageNavigateInfo != null) {
              if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().doAddMsgQueue(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 3, null);
                i = 1;
              }
              else if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_MODIFY)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().doAddMsgQueue(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 4, null);
                i = 1;
              }
              else if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE)
              {
                localIterator2.remove();
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().doAddMsgQueue(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 5, null);
                i = 1;
              }
            }
          }
          else if (localList.isEmpty())
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEntry.getKey());
          }
        }
        else
        {
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().saveNotify();
          }
          return;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 194	bfzk:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopMessageNavigateInfo;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +12 -> 21
    //   12: aload_1
    //   13: getfield 197	com/tencent/mobileqq/data/TroopMessageNavigateInfo:type	I
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: iconst_m1
    //   22: istore_2
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	bfzk
    //   0	31	1	paramString	String
    //   16	7	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	8	26	finally
    //   12	17	26	finally
  }
  
  /* Error */
  public int a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_2
    //   4: invokevirtual 201	bfzk:a	(I)Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifne +9 -> 18
    //   12: iconst_m1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: iload_2
    //   21: invokestatic 203	bfzk:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   24: invokevirtual 205	bfzk:a	(Ljava/lang/String;)I
    //   27: istore_2
    //   28: goto -14 -> 14
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	bfzk
    //   0	36	1	paramString	String
    //   0	36	2	paramInt	int
    //   7	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	31	finally
    //   18	28	31	finally
  }
  
  /* Error */
  public long a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokevirtual 201	bfzk:a	(I)Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifne +13 -> 22
    //   12: ldc2_w 207
    //   15: lstore 4
    //   17: aload_0
    //   18: monitorexit
    //   19: lload 4
    //   21: lreturn
    //   22: aload_0
    //   23: aload_2
    //   24: iload_1
    //   25: invokestatic 203	bfzk:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   28: invokevirtual 211	bfzk:a	(Ljava/lang/String;)J
    //   31: lstore 4
    //   33: goto -16 -> 17
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	bfzk
    //   0	41	1	paramInt	int
    //   0	41	2	paramString	String
    //   7	2	3	bool	boolean
    //   15	17	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	8	36	finally
    //   22	33	36	finally
  }
  
  /* Error */
  public long a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 194	bfzk:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopMessageNavigateInfo;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +12 -> 21
    //   12: aload_1
    //   13: getfield 215	com/tencent/mobileqq/data/TroopMessageNavigateInfo:msgseq	J
    //   16: lstore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: lload_2
    //   20: lreturn
    //   21: lconst_0
    //   22: lstore_2
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	bfzk
    //   0	31	1	paramString	String
    //   16	7	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	8	26	finally
    //   12	17	26	finally
  }
  
  /* Error */
  public long a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	bfzk:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +88 -> 98
    //   13: aload_0
    //   14: getfield 22	bfzk:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 123	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 82	java/util/List
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 221	bhfc:a	(Ljava/util/Collection;)Z
    //   29: istore 5
    //   31: iload 5
    //   33: ifeq +9 -> 42
    //   36: lconst_0
    //   37: lstore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: lload_2
    //   41: lreturn
    //   42: aload_1
    //   43: invokeinterface 105 1 0
    //   48: iconst_1
    //   49: isub
    //   50: istore 4
    //   52: iload 4
    //   54: iflt +44 -> 98
    //   57: aload_1
    //   58: iload 4
    //   60: invokeinterface 224 2 0
    //   65: checkcast 94	com/tencent/mobileqq/data/TroopMessageNavigateInfo
    //   68: astore 6
    //   70: aload 6
    //   72: getfield 215	com/tencent/mobileqq/data/TroopMessageNavigateInfo:msgseq	J
    //   75: lload_2
    //   76: lcmp
    //   77: ifne +12 -> 89
    //   80: aload 6
    //   82: getfield 227	com/tencent/mobileqq/data/TroopMessageNavigateInfo:shmsgseq	J
    //   85: lstore_2
    //   86: goto -48 -> 38
    //   89: iload 4
    //   91: iconst_1
    //   92: isub
    //   93: istore 4
    //   95: goto -43 -> 52
    //   98: lconst_0
    //   99: lstore_2
    //   100: goto -62 -> 38
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	bfzk
    //   0	108	1	paramString	String
    //   0	108	2	paramLong	long
    //   50	44	4	i	int
    //   29	3	5	bool	boolean
    //   68	13	6	localTroopMessageNavigateInfo	TroopMessageNavigateInfo
    // Exception table:
    //   from	to	target	type
    //   2	31	103	finally
    //   42	52	103	finally
    //   57	86	103	finally
  }
  
  @Nullable
  TroopMessageNavigateInfo a(String paramString)
  {
    a();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (bhfc.a(localList))
      {
        paramString = null;
        return paramString;
      }
      int j = localList.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label89;
        }
        TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localList.get(i);
        paramString = localTroopMessageNavigateInfo;
        if (localTroopMessageNavigateInfo.status != TroopMessageNavigateInfo.STATUS_DELETE) {
          break;
        }
        i += 1;
      }
    }
    label89:
    return null;
  }
  
  /* Error */
  public Object a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 194	bfzk:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopMessageNavigateInfo;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +12 -> 21
    //   12: aload_1
    //   13: getfield 234	com/tencent/mobileqq/data/TroopMessageNavigateInfo:extObj	Ljava/lang/Object;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aconst_null
    //   22: astore_1
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	bfzk
    //   0	31	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	8	26	finally
    //   12	17	26	finally
  }
  
  public List<Long> a(String paramString, int paramInt)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      int i;
      try
      {
        a();
        ArrayList localArrayList = new ArrayList();
        localStringBuilder = new StringBuilder("getMultiNavigateSeqList, troopUin = ");
        localStringBuilder.append(paramString).append(", type = ").append(paramInt).append(", seqList = ");
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
        {
          paramString = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (bhfc.a(paramString))
          {
            localStringBuilder.append("null");
            if (QLog.isColorLevel()) {
              QLog.d("Navigate.Manager", 2, localStringBuilder.toString());
            }
            return localArrayList;
          }
          int j = paramString.size();
          i = 0;
          if (i < j)
          {
            TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)paramString.get(i);
            if ((localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE) || (localTroopMessageNavigateInfo.type != paramInt)) {
              break label219;
            }
            localArrayList.add(Long.valueOf(localTroopMessageNavigateInfo.msgseq));
            localStringBuilder.append(localTroopMessageNavigateInfo.msgseq).append(",");
          }
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.Manager", 2, localStringBuilder.toString());
      }
      continue;
      label219:
      i += 1;
    }
  }
  
  public void a()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Navigate.Manager", 2, "initTroopMessageNavigateInfo before, " + a());
        }
        Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().query(TroopMessageNavigateInfo.class, false, null, null, null, null, null, null);
        if (localObject1 == null) {
          break label251;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label251;
        }
        localObject3 = (TroopMessageNavigateInfo)((Iterator)localObject1).next();
        if ((localObject3 == null) || (TextUtils.isEmpty(((TroopMessageNavigateInfo)localObject3).troopCode))) {
          continue;
        }
        localObject4 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((TroopMessageNavigateInfo)localObject3).troopCode);
        if (localObject4 != null)
        {
          localObject3 = ((List)localObject4).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (TroopMessageNavigateInfo)((Iterator)localObject3).next();
            if ((localObject4 == null) || (((TroopMessageNavigateInfo)localObject4).status != TroopMessageNavigateInfo.STATUS_ADD)) {
              continue;
            }
            ((TroopMessageNavigateInfo)localObject4).status = TroopMessageNavigateInfo.STATUS_MODIFY;
            continue;
          }
          continue;
        }
        ((TroopMessageNavigateInfo)localObject3).status = TroopMessageNavigateInfo.STATUS_NORMAL;
      }
      finally {}
      Object localObject4 = new ArrayList();
      ((List)localObject4).add(localObject3);
      a(((TroopMessageNavigateInfo)localObject3).troopCode);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((TroopMessageNavigateInfo)localObject3).troopCode, localObject4);
      continue;
      label251:
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.Manager", 2, "initTroopMessageNavigateInfo after, " + a());
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  void a(@Nullable TroopMessageNavigateInfo paramTroopMessageNavigateInfo1, TroopMessageNavigateInfo paramTroopMessageNavigateInfo2, int paramInt)
  {
    if (bfzm.a(paramInt))
    {
      paramTroopMessageNavigateInfo2.status = TroopMessageNavigateInfo.STATUS_ADD;
      return;
    }
    if ((paramTroopMessageNavigateInfo1 == null) || (paramTroopMessageNavigateInfo1.status == TroopMessageNavigateInfo.STATUS_DELETE))
    {
      paramTroopMessageNavigateInfo2.status = TroopMessageNavigateInfo.STATUS_ADD;
      return;
    }
    paramTroopMessageNavigateInfo2.status = TroopMessageNavigateInfo.STATUS_MODIFY;
  }
  
  void a(@Nullable TroopMessageNavigateInfo paramTroopMessageNavigateInfo1, TroopMessageNavigateInfo paramTroopMessageNavigateInfo2, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 26) {
      return;
    }
    if ((paramTroopMessageNavigateInfo1 == null) || (paramTroopMessageNavigateInfo1.status == TroopMessageNavigateInfo.STATUS_DELETE))
    {
      paramTroopMessageNavigateInfo2.receivedFlowserCount = paramInt2;
      return;
    }
    paramTroopMessageNavigateInfo1.receivedFlowserCount += paramInt2;
  }
  
  public void a(String paramString, int paramInt)
  {
    for (;;)
    {
      List localList;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Navigate.Manager", 2, "clearTroopMsgNavigateInfo: troopCode = " + paramString + ", type = " + paramInt);
        }
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
          continue;
        }
        localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if (bhfc.a(localList)) {
          continue;
        }
        i = localList.size() - 1;
        if (i >= 0)
        {
          TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localList.get(i);
          if ((paramInt != localTroopMessageNavigateInfo.type) && (paramInt != 0)) {
            break label190;
          }
          if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD) {
            localList.remove(i);
          } else {
            localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_DELETE;
          }
        }
      }
      finally {}
      if (localList.isEmpty())
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        continue;
        label190:
        i -= 1;
      }
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_2
    //   4: invokevirtual 201	bfzk:a	(I)Z
    //   7: istore 4
    //   9: iload 4
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: aload_1
    //   19: iload_2
    //   20: invokestatic 203	bfzk:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   23: iload_3
    //   24: invokevirtual 326	bfzk:a	(Ljava/lang/String;I)V
    //   27: goto -13 -> 14
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	bfzk
    //   0	35	1	paramString	String
    //   0	35	2	paramInt1	int
    //   0	35	3	paramInt2	int
    //   7	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	30	finally
    //   17	27	30	finally
  }
  
  /* Error */
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString2, int paramInt3, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_2
    //   4: invokevirtual 201	bfzk:a	(I)Z
    //   7: istore 11
    //   9: iload 11
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: aload_1
    //   19: iload_2
    //   20: invokestatic 203	bfzk:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   23: iload_3
    //   24: lload 4
    //   26: lload 6
    //   28: aload 8
    //   30: iload 9
    //   32: aload 10
    //   34: invokevirtual 330	bfzk:a	(Ljava/lang/String;IJJLjava/lang/String;ILjava/lang/Object;)V
    //   37: goto -23 -> 14
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	bfzk
    //   0	45	1	paramString1	String
    //   0	45	2	paramInt1	int
    //   0	45	3	paramInt2	int
    //   0	45	4	paramLong1	long
    //   0	45	6	paramLong2	long
    //   0	45	8	paramString2	String
    //   0	45	9	paramInt3	int
    //   0	45	10	paramObject	Object
    //   7	3	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	40	finally
    //   17	37	40	finally
  }
  
  public void a(String paramString1, int paramInt1, long paramLong1, long paramLong2, String paramString2, int paramInt2, Object paramObject)
  {
    if (paramInt1 <= 0) {}
    TroopMessageNavigateInfo localTroopMessageNavigateInfo;
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Navigate.Manager", 2, "addTroopMsgNavigateInfo, troopCode = " + paramString1 + ", navType = " + paramInt1 + ", shMsgSeq = " + paramLong1 + " ,uinseq = " + paramLong2 + " ,summary = " + paramString2 + ", flowersCount = " + paramInt2);
        }
        localTroopMessageNavigateInfo = new TroopMessageNavigateInfo();
        localTroopMessageNavigateInfo.type = paramInt1;
        localTroopMessageNavigateInfo.troopCode = paramString1;
        localTroopMessageNavigateInfo.shmsgseq = paramLong1;
        localTroopMessageNavigateInfo.msgseq = paramLong2;
        localTroopMessageNavigateInfo.summary = paramString2;
        localTroopMessageNavigateInfo.extObj = paramObject;
        paramObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
        if (bhfc.a(paramObject)) {
          break label408;
        }
        if (bfzm.a(paramInt1))
        {
          localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
          paramObject.add(localTroopMessageNavigateInfo);
          a(paramString1);
        }
      }
      finally {}
    }
    int i = paramObject.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramInt1 != ((TroopMessageNavigateInfo)paramObject.get(i)).type) {}
      }
      else {
        for (paramString2 = (TroopMessageNavigateInfo)paramObject.get(i);; paramString2 = null)
        {
          int j = bfyj.a(paramInt1);
          if ((paramInt1 != 1) && (paramString2 != null) && (paramString2.status != TroopMessageNavigateInfo.STATUS_DELETE) && (!bffm.a(bfyj.a(paramString2.type), paramString2.shmsgseq, j, paramLong1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Navigate.Manager", 2, "addTroopMsgNavigateInfo, but do not need update, shMsgSeq = " + paramLong1);
            }
            localTroopMessageNavigateInfo.receivedFlowserCount = paramInt2;
            a(localTroopMessageNavigateInfo, paramString2, paramInt1, paramString2.receivedFlowserCount);
            break;
          }
          if (i >= 0) {
            paramObject.remove(i);
          }
          a(paramString2, localTroopMessageNavigateInfo, paramInt1);
          a(paramString2, localTroopMessageNavigateInfo, paramInt1, paramInt2);
          paramObject.add(localTroopMessageNavigateInfo);
          a(paramString1);
          break;
          label408:
          localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
          if (paramInt1 == 26) {
            localTroopMessageNavigateInfo.receivedFlowserCount = paramInt2;
          }
          paramString2 = new ArrayList();
          paramString2.add(localTroopMessageNavigateInfo);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
          break;
        }
      }
      i -= 1;
    }
  }
  
  boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3000);
  }
  
  /* Error */
  public long b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	bfzk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 363	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +35 -> 45
    //   13: aload_0
    //   14: getfield 29	bfzk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 364	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 261	java/lang/Long
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +11 -> 37
    //   29: ldc2_w 207
    //   32: lstore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: lload_2
    //   36: lreturn
    //   37: aload_1
    //   38: invokevirtual 368	java/lang/Long:longValue	()J
    //   41: lstore_2
    //   42: goto -9 -> 33
    //   45: ldc2_w 207
    //   48: lstore_2
    //   49: goto -16 -> 33
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	bfzk
    //   0	57	1	paramString	String
    //   32	17	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	25	52	finally
    //   37	42	52	finally
  }
  
  public void onDestroy()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzk
 * JD-Core Version:    0.7.0.1
 */