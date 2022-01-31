package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.newfriend.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import zhd;
import zhe;

public class QIMNewFriendManager
  implements Manager
{
  public Handler a;
  private QIMNewFriendManager.IQIMNotifyNewFriendListener jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public QIMNewFriendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    ThreadManager.postImmediately(new zhd(this, paramQQAppInterface), null, true);
  }
  
  public String a(long paramLong1, long paramLong2)
  {
    String str = ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong2));
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMNewFriendManager", 2, "getQQInfoFromQQUin|uinStr is null " + paramLong2);
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMNewFriendManager", 2, "getQQInfoFromQQUin|nickName " + str);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ好友：").append(str);
    return localStringBuilder.toString();
  }
  
  public ArrayList a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(QIMNotifyAddFriend.class);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
  }
  
  public ArrayList a(boolean paramBoolean)
  {
    ??? = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216);
    ArrayList localArrayList1 = new ArrayList();
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (((FlashChatManager)???).e())
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label156;
        }
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext()) {
          localArrayList1.add(new QIMNotifyAddFriendMsg((QIMNotifyAddFriend)localIterator.next()));
        }
      }
      this.b.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("QIMNewFriendManager", 2, "getQIMNotifyAddFriendsMsg | list size = " + localArrayList2.size() + paramBoolean);
      }
    }
    label156:
    while (!QLog.isColorLevel())
    {
      Iterator localIterator;
      return localArrayList2;
    }
    QLog.e("QIMNewFriendManager", 2, "getQIMNotifyAddFriendsMsg qim notify has close");
    return localArrayList2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMNewFriendManager", 2, "removeListener");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener = null;
  }
  
  public void a(QIMNewFriendManager.IQIMNotifyNewFriendListener paramIQIMNotifyNewFriendListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMNewFriendManager", 2, "addListener");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener = paramIQIMNotifyNewFriendListener;
  }
  
  public void a(QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMNewFriendManager", 2, "addNewNotifyFromQIM " + paramQIMNotifyAddFriend.toString());
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramQIMNotifyAddFriend))
      {
        if (QLog.isColorLevel()) {
          QLog.e("QIMNewFriendManager", 2, "addNewNotifyFromQIM already has data !");
        }
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramQIMNotifyAddFriend);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramQIMNotifyAddFriend);
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.C();
      ??? = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216);
      if ((!((FlashChatManager)???).e()) || (!((FlashChatManager)???).f())) {
        break label190;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener.a();
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.e("QIMNewFriendManager", 2, "addNewNotifyFromQIM|mListener is null ");
      return;
      label190:
      if (QLog.isColorLevel()) {
        QLog.e("QIMNewFriendManager", 2, "addNewNotifyFromQIM | popUp enable close " + paramQIMNotifyAddFriend.uin);
      }
    }
  }
  
  /* Error */
  public void a(ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/tencent/mobileqq/app/QIMNewFriendManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 52	com/tencent/mobileqq/app/QIMNewFriendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 241	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 244	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   19: aload_1
    //   20: invokevirtual 166	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface 171 1 0
    //   30: ifeq +98 -> 128
    //   33: aload_1
    //   34: invokeinterface 177 1 0
    //   39: checkcast 131	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   42: astore 4
    //   44: aload_0
    //   45: getfield 25	com/tencent/mobileqq/app/QIMNewFriendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   48: invokevirtual 166	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   51: astore 5
    //   53: aload 5
    //   55: invokeinterface 171 1 0
    //   60: ifeq -36 -> 24
    //   63: aload 5
    //   65: invokeinterface 177 1 0
    //   70: checkcast 131	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   73: astore 6
    //   75: aload 4
    //   77: getfield 235	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   80: aload 6
    //   82: getfield 235	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   85: lcmp
    //   86: ifne -33 -> 53
    //   89: aload 6
    //   91: iconst_1
    //   92: putfield 248	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasShowToast	Z
    //   95: aload_0
    //   96: aload 6
    //   98: invokevirtual 251	com/tencent/mobileqq/app/QIMNewFriendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   101: pop
    //   102: goto -78 -> 24
    //   105: astore_1
    //   106: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +12 -> 121
    //   112: ldc 104
    //   114: iconst_2
    //   115: ldc 253
    //   117: aload_1
    //   118: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_3
    //   122: invokevirtual 258	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   125: aload_2
    //   126: monitorexit
    //   127: return
    //   128: aload_3
    //   129: invokevirtual 261	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   132: aload_3
    //   133: invokevirtual 258	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   136: goto -11 -> 125
    //   139: astore_1
    //   140: aload_2
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    //   144: astore_1
    //   145: aload_3
    //   146: invokevirtual 258	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	QIMNewFriendManager
    //   0	151	1	paramArrayList	ArrayList
    //   4	137	2	localObject	Object
    //   14	132	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   42	34	4	localQIMNotifyAddFriend1	QIMNotifyAddFriend
    //   51	13	5	localIterator	Iterator
    //   73	24	6	localQIMNotifyAddFriend2	QIMNotifyAddFriend
    // Exception table:
    //   from	to	target	type
    //   15	24	105	java/lang/Exception
    //   24	53	105	java/lang/Exception
    //   53	102	105	java/lang/Exception
    //   128	132	105	java/lang/Exception
    //   7	15	139	finally
    //   121	125	139	finally
    //   125	127	139	finally
    //   132	136	139	finally
    //   140	142	139	finally
    //   145	151	139	finally
    //   15	24	144	finally
    //   24	53	144	finally
    //   53	102	144	finally
    //   106	121	144	finally
    //   128	132	144	finally
  }
  
  /* Error */
  public void a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/tencent/mobileqq/app/QIMNewFriendManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 52	com/tencent/mobileqq/app/QIMNewFriendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 241	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 244	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   19: aload_1
    //   20: invokeinterface 265 1 0
    //   25: astore_1
    //   26: aload_1
    //   27: invokeinterface 171 1 0
    //   32: ifeq +114 -> 146
    //   35: aload_1
    //   36: invokeinterface 177 1 0
    //   41: checkcast 131	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   44: astore 4
    //   46: aload_0
    //   47: getfield 25	com/tencent/mobileqq/app/QIMNewFriendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   50: invokevirtual 166	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   53: astore 5
    //   55: aload 5
    //   57: invokeinterface 171 1 0
    //   62: ifeq -36 -> 26
    //   65: aload 5
    //   67: invokeinterface 177 1 0
    //   72: checkcast 131	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   75: astore 6
    //   77: aload 4
    //   79: getfield 235	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   82: aload 6
    //   84: getfield 235	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   87: lcmp
    //   88: ifne -33 -> 55
    //   91: aload 6
    //   93: iconst_1
    //   94: putfield 268	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasRead	Z
    //   97: aload_0
    //   98: aload 6
    //   100: invokevirtual 251	com/tencent/mobileqq/app/QIMNewFriendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   103: pop
    //   104: goto -78 -> 26
    //   107: astore_1
    //   108: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +13 -> 124
    //   114: ldc 104
    //   116: iconst_2
    //   117: ldc_w 270
    //   120: aload_1
    //   121: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_3
    //   125: invokevirtual 258	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   128: aload_2
    //   129: monitorexit
    //   130: aload_0
    //   131: getfield 38	com/tencent/mobileqq/app/QIMNewFriendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   134: bipush 33
    //   136: invokevirtual 152	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   139: checkcast 216	com/tencent/mobileqq/app/NewFriendManager
    //   142: invokevirtual 218	com/tencent/mobileqq/app/NewFriendManager:a	()V
    //   145: return
    //   146: aload_3
    //   147: invokevirtual 261	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   150: aload_3
    //   151: invokevirtual 258	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   154: goto -26 -> 128
    //   157: astore_1
    //   158: aload_2
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: aload_3
    //   164: invokevirtual 258	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   167: aload_1
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	QIMNewFriendManager
    //   0	169	1	paramList	List
    //   4	155	2	localObject	Object
    //   14	150	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   44	34	4	localQIMNotifyAddFriend1	QIMNotifyAddFriend
    //   53	13	5	localIterator	Iterator
    //   75	24	6	localQIMNotifyAddFriend2	QIMNotifyAddFriend
    // Exception table:
    //   from	to	target	type
    //   15	26	107	java/lang/Exception
    //   26	55	107	java/lang/Exception
    //   55	104	107	java/lang/Exception
    //   146	150	107	java/lang/Exception
    //   7	15	157	finally
    //   124	128	157	finally
    //   128	130	157	finally
    //   150	154	157	finally
    //   158	160	157	finally
    //   163	169	157	finally
    //   15	26	162	finally
    //   26	55	162	finally
    //   55	104	162	finally
    //   108	124	162	finally
    //   146	150	162	finally
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
      }
    }
    QLog.d("QIMNewFriendManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public ArrayList b()
  {
    ??? = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216);
    ArrayList localArrayList = new ArrayList();
    if ((((FlashChatManager)???).e()) && (((FlashChatManager)???).f()))
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localQIMNotifyAddFriend = (QIMNotifyAddFriend)localIterator.next();
          if (!localQIMNotifyAddFriend.hasShowToast) {
            localArrayList.add(localQIMNotifyAddFriend);
          }
        }
      }
      Collections.sort(localList, new zhe(this));
    }
    while (!QLog.isColorLevel())
    {
      Iterator localIterator;
      QIMNotifyAddFriend localQIMNotifyAddFriend;
      return localList;
    }
    QLog.d("QIMNewFriendManager", 2, "getQIMAddFriendPopUpData enable close");
    return localList;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/mobileqq/app/QIMNewFriendManager:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 157	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifeq +97 -> 104
    //   10: aload_0
    //   11: getfield 27	com/tencent/mobileqq/app/QIMNewFriendManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   14: astore_1
    //   15: aload_1
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 52	com/tencent/mobileqq/app/QIMNewFriendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: invokevirtual 241	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 244	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   29: aload_0
    //   30: getfield 25	com/tencent/mobileqq/app/QIMNewFriendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   33: invokevirtual 166	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   36: astore_3
    //   37: aload_3
    //   38: invokeinterface 171 1 0
    //   43: ifeq +62 -> 105
    //   46: aload_3
    //   47: invokeinterface 177 1 0
    //   52: checkcast 131	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   55: astore 4
    //   57: aload 4
    //   59: getfield 268	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasRead	Z
    //   62: ifne -25 -> 37
    //   65: aload 4
    //   67: iconst_1
    //   68: putfield 268	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasRead	Z
    //   71: aload_0
    //   72: aload 4
    //   74: invokevirtual 251	com/tencent/mobileqq/app/QIMNewFriendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   77: pop
    //   78: goto -41 -> 37
    //   81: astore_3
    //   82: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +13 -> 98
    //   88: ldc 104
    //   90: iconst_2
    //   91: ldc_w 270
    //   94: aload_3
    //   95: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_2
    //   99: invokevirtual 258	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   102: aload_1
    //   103: monitorexit
    //   104: return
    //   105: aload_2
    //   106: invokevirtual 261	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   109: aload_2
    //   110: invokevirtual 258	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   113: goto -11 -> 102
    //   116: astore_2
    //   117: aload_1
    //   118: monitorexit
    //   119: aload_2
    //   120: athrow
    //   121: astore_3
    //   122: aload_2
    //   123: invokevirtual 258	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   126: aload_3
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	QIMNewFriendManager
    //   14	104	1	localObject1	Object
    //   24	86	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   116	7	2	localObject2	Object
    //   36	11	3	localIterator	Iterator
    //   81	14	3	localException	java.lang.Exception
    //   121	6	3	localObject3	Object
    //   55	18	4	localQIMNotifyAddFriend	QIMNotifyAddFriend
    // Exception table:
    //   from	to	target	type
    //   25	37	81	java/lang/Exception
    //   37	78	81	java/lang/Exception
    //   105	109	81	java/lang/Exception
    //   17	25	116	finally
    //   98	102	116	finally
    //   102	104	116	finally
    //   109	113	116	finally
    //   117	119	116	finally
    //   122	128	116	finally
    //   25	37	121	finally
    //   37	78	121	finally
    //   82	98	121	finally
    //   105	109	121	finally
  }
  
  public void b(QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    if (paramQIMNotifyAddFriend == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((QIMNotifyAddFriend)localIterator.next()).uin == paramQIMNotifyAddFriend.uin) {
          localIterator.remove();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().b(paramQIMNotifyAddFriend);
      return;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QIMNewFriendManager
 * JD-Core Version:    0.7.0.1
 */