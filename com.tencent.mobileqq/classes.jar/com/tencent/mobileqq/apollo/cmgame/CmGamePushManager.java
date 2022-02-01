package com.tencent.mobileqq.apollo.cmgame;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.model.CmGamePushItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CmGamePushManager
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private Comparator<CmGamePushItem> jdField_a_of_type_JavaUtilComparator = new CmGamePushManager.2(this);
  private List<CmGamePushItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void a(CmGamePushItem paramCmGamePushItem1, CmGamePushItem paramCmGamePushItem2)
  {
    if (paramCmGamePushItem1 == null) {}
    EntityManager localEntityManager;
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      localEntityManager = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    localObject = localEntityManager.getTransaction();
    ((EntityTransaction)localObject).begin();
    if (paramCmGamePushItem2 != null) {}
    for (;;)
    {
      try
      {
        localEntityManager.remove(paramCmGamePushItem2);
        localEntityManager.persist(paramCmGamePushItem1);
        ((EntityTransaction)localObject).commit();
        return;
      }
      catch (Exception paramCmGamePushItem1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CmGamePushManager", 2, "updatePushItem exception: ", paramCmGamePushItem1);
        return;
      }
      finally
      {
        ((EntityTransaction)localObject).end();
      }
      localEntityManager.update(paramCmGamePushItem1);
    }
  }
  
  /* Error */
  private void a(List<CmGamePushItem> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 109 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 18	com/tencent/mobileqq/apollo/cmgame/CmGamePushManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 23	com/tencent/mobileqq/apollo/cmgame/CmGamePushManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   25: aload_1
    //   26: invokeinterface 113 2 0
    //   31: pop
    //   32: aload_2
    //   33: monitorexit
    //   34: aload_0
    //   35: getfield 36	com/tencent/mobileqq/apollo/cmgame/CmGamePushManager:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   38: invokevirtual 42	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   41: checkcast 44	com/tencent/mobileqq/app/QQAppInterface
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull -33 -> 13
    //   49: aload_2
    //   50: invokevirtual 48	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   53: invokevirtual 54	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull -45 -> 13
    //   61: aload_3
    //   62: invokevirtual 60	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   65: astore_2
    //   66: aload_2
    //   67: invokevirtual 65	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   70: aload_1
    //   71: invokeinterface 117 1 0
    //   76: astore_1
    //   77: aload_1
    //   78: invokeinterface 122 1 0
    //   83: ifeq +46 -> 129
    //   86: aload_3
    //   87: aload_1
    //   88: invokeinterface 125 1 0
    //   93: checkcast 127	com/tencent/mobileqq/apollo/api/model/CmGamePushItem
    //   96: invokevirtual 69	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   99: pop
    //   100: goto -23 -> 77
    //   103: astore_1
    //   104: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +12 -> 119
    //   110: ldc 90
    //   112: iconst_2
    //   113: ldc 129
    //   115: aload_1
    //   116: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   119: aload_2
    //   120: invokevirtual 79	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   123: return
    //   124: astore_1
    //   125: aload_2
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    //   129: aload_2
    //   130: invokevirtual 76	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   133: aload_2
    //   134: invokevirtual 79	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   137: return
    //   138: astore_1
    //   139: aload_2
    //   140: invokevirtual 79	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	CmGamePushManager
    //   0	145	1	paramList	List<CmGamePushItem>
    //   18	122	2	localObject	Object
    //   56	31	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   70	77	103	java/lang/Exception
    //   77	100	103	java/lang/Exception
    //   129	133	103	java/lang/Exception
    //   21	34	124	finally
    //   125	127	124	finally
    //   70	77	138	finally
    //   77	100	138	finally
    //   104	119	138	finally
    //   129	133	138	finally
  }
  
  private CmGamePushItem b()
  {
    Object localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return null;
      }
      long l = NetConnInfoCenter.getServerTime();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext())
      {
        CmGamePushItem localCmGamePushItem2 = (CmGamePushItem)localIterator.next();
        if ((localCmGamePushItem2.msg_type != 1) || (localCmGamePushItem2.start_ts >= l) || (localCmGamePushItem2.end_ts <= l)) {
          break label283;
        }
        if (j == 0)
        {
          if (!localCmGamePushItem2.isShow) {
            i = 1;
          }
          localCmGamePushItem2.isShow = true;
          localStringBuilder.append(",current show item:").append(localCmGamePushItem2.toString());
          j = 1;
          localObject1 = localCmGamePushItem2;
          break label280;
        }
        if (!localCmGamePushItem2.isShow) {
          break label283;
        }
        localArrayList.add(localCmGamePushItem2);
        localStringBuilder.append("\n,remove item:").append(localCmGamePushItem2.toString());
        break label283;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmGamePushManager", 2, new Object[] { "getCmGamePromotionPush:", localStringBuilder.toString() });
      }
      if ((localArrayList.size() > 0) || (i != 0))
      {
        ThreadManager.excute(new CmGamePushManager.1(this, localObject1, localArrayList), 32, null, true);
        return localObject1;
      }
    }
    return localCmGamePushItem1;
    label280:
    label283:
    for (;;)
    {
      break;
    }
  }
  
  public CmGamePushItem a()
  {
    return b();
  }
  
  public void a(CmGamePushItem paramCmGamePushItem)
  {
    if (paramCmGamePushItem == null) {
      return;
    }
    Object localObject1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject1 != null) && (paramCmGamePushItem.msg_type == 1)) {
      ((RedTouchManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MGR_RED_TOUCH)).c(String.valueOf("103100.103200.103240.103248"));
    }
    Object localObject2 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    localObject1 = null;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if ((!TextUtils.isEmpty(((CmGamePushItem)this.jdField_a_of_type_JavaUtilList.get(i)).msg_id)) && (!TextUtils.isEmpty(paramCmGamePushItem.msg_id)) && (((CmGamePushItem)this.jdField_a_of_type_JavaUtilList.get(i)).msg_id.equals(paramCmGamePushItem.msg_id)))
          {
            CmGamePushItem localCmGamePushItem = (CmGamePushItem)this.jdField_a_of_type_JavaUtilList.get(i);
            this.jdField_a_of_type_JavaUtilList.remove(i);
            this.jdField_a_of_type_JavaUtilList.add(i, paramCmGamePushItem);
            localObject1 = localCmGamePushItem;
            if (QLog.isColorLevel())
            {
              QLog.d("CmGamePushManager", 2, new Object[] { "clearPushRedDots update after new item is:", paramCmGamePushItem.toString() });
              localObject1 = localCmGamePushItem;
            }
          }
        }
        else
        {
          ThreadManager.excute(new CmGamePushManager.3(this, paramCmGamePushItem, (CmGamePushItem)localObject1), 32, null, true);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGamePushManager
 * JD-Core Version:    0.7.0.1
 */