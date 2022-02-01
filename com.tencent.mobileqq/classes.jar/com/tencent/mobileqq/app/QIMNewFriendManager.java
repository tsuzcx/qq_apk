package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public class QIMNewFriendManager
  implements Manager
{
  QQAppInterface a;
  EntityManager b;
  public Handler c;
  private ArrayList<QIMNotifyAddFriend> d = new ArrayList();
  private Object e = new Object();
  private AtomicBoolean f = new AtomicBoolean(false);
  private AtomicBoolean g = new AtomicBoolean(false);
  private WeakReference<QIMNewFriendManager.IQIMNotifyNewFriendListener> h;
  
  public QIMNewFriendManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.c = new Handler(Looper.getMainLooper());
    ThreadManager.postImmediately(new QIMNewFriendManager.1(this, paramQQAppInterface), null, true);
  }
  
  public String a(long paramLong1, long paramLong2)
  {
    Object localObject = ContactUtils.d(this.a, String.valueOf(paramLong2));
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getQQInfoFromQQUin|uinStr is null ");
        ((StringBuilder)localObject).append(paramLong2);
        QLog.d("QIMNewFriendManager", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQQInfoFromQQUin|nickName ");
      localStringBuilder.append((String)localObject);
      QLog.d("QIMNewFriendManager", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ好友：");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public ArrayList<QIMNotifyAddFriendMsg> a(boolean paramBoolean)
  {
    ??? = (FlashChatManager)this.a.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    ArrayList localArrayList = new ArrayList();
    if (!this.f.get()) {
      b();
    }
    if (((FlashChatManager)???).i()) {
      synchronized (this.e)
      {
        if (this.d.size() > 0)
        {
          Object localObject2 = this.d.iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList.add(new QIMNotifyAddFriendMsg((QIMNotifyAddFriend)((Iterator)localObject2).next()));
          }
          this.g.set(true);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getQIMNotifyAddFriendsMsg | list size = ");
            ((StringBuilder)localObject2).append(localArrayList.size());
            ((StringBuilder)localObject2).append(paramBoolean);
            QLog.d("QIMNewFriendManager", 2, ((StringBuilder)localObject2).toString());
          }
        }
        return localArrayList;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QIMNewFriendManager", 2, "getQIMNotifyAddFriendsMsg qim notify has close");
    }
    return localArrayList1;
  }
  
  public void a()
  {
    if (this.h == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMNewFriendManager", 2, "removeListener");
    }
    this.h = null;
  }
  
  public void a(QIMNewFriendManager.IQIMNotifyNewFriendListener paramIQIMNotifyNewFriendListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMNewFriendManager", 2, "addListener");
    }
    this.h = new WeakReference(paramIQIMNotifyNewFriendListener);
  }
  
  public void a(QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("addNewNotifyFromQIM ");
      ((StringBuilder)???).append(paramQIMNotifyAddFriend.toString());
      QLog.d("QIMNewFriendManager", 2, ((StringBuilder)???).toString());
    }
    if (!this.f.get()) {
      b();
    }
    synchronized (this.e)
    {
      if (this.d.contains(paramQIMNotifyAddFriend))
      {
        if (QLog.isColorLevel()) {
          QLog.e("QIMNewFriendManager", 2, "addNewNotifyFromQIM already has data !");
        }
        return;
      }
      this.d.add(paramQIMNotifyAddFriend);
      this.b.persistOrReplace(paramQIMNotifyAddFriend);
      ((INewFriendService)this.a.getRuntimeService(INewFriendService.class)).reloadNewFriendMsg();
      if (this.a.isLogin()) {
        ((IAppBadgeService)this.a.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
      }
      ??? = (FlashChatManager)this.a.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
      if ((((FlashChatManager)???).i()) && (((FlashChatManager)???).j()))
      {
        paramQIMNotifyAddFriend = this.h;
        if (paramQIMNotifyAddFriend != null)
        {
          paramQIMNotifyAddFriend = (QIMNewFriendManager.IQIMNotifyNewFriendListener)paramQIMNotifyAddFriend.get();
          if (paramQIMNotifyAddFriend != null) {
            paramQIMNotifyAddFriend.a();
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("QIMNewFriendManager", 2, "addNewNotifyFromQIM|mListener is null ");
        }
      }
      else if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("addNewNotifyFromQIM | popUp enable close ");
        ((StringBuilder)???).append(paramQIMNotifyAddFriend.uin);
        QLog.e("QIMNewFriendManager", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  /* Error */
  public void a(ArrayList<QIMNotifyAddFriend> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/app/QIMNewFriendManager:e	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 60	com/tencent/mobileqq/app/QIMNewFriendManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 273	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 278	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_1
    //   20: invokevirtual 164	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   23: astore_1
    //   24: aload_1
    //   25: invokeinterface 169 1 0
    //   30: ifeq +75 -> 105
    //   33: aload_1
    //   34: invokeinterface 175 1 0
    //   39: checkcast 177	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   42: astore 4
    //   44: aload_0
    //   45: getfield 33	com/tencent/mobileqq/app/QIMNewFriendManager:d	Ljava/util/ArrayList;
    //   48: invokevirtual 164	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   51: astore 5
    //   53: aload 5
    //   55: invokeinterface 169 1 0
    //   60: ifeq -36 -> 24
    //   63: aload 5
    //   65: invokeinterface 175 1 0
    //   70: checkcast 177	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   73: astore 6
    //   75: aload 4
    //   77: getfield 266	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   80: aload 6
    //   82: getfield 266	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   85: lcmp
    //   86: ifne -33 -> 53
    //   89: aload 6
    //   91: iconst_1
    //   92: putfield 282	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasShowToast	Z
    //   95: aload_0
    //   96: aload 6
    //   98: invokevirtual 285	com/tencent/mobileqq/app/QIMNewFriendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   101: pop
    //   102: goto -78 -> 24
    //   105: aload_3
    //   106: invokevirtual 288	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   109: aload_3
    //   110: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   113: goto +27 -> 140
    //   116: astore_1
    //   117: goto +26 -> 143
    //   120: astore_1
    //   121: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq -15 -> 109
    //   127: ldc 123
    //   129: iconst_2
    //   130: ldc_w 293
    //   133: aload_1
    //   134: invokestatic 296	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   137: goto -28 -> 109
    //   140: aload_2
    //   141: monitorexit
    //   142: return
    //   143: aload_3
    //   144: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   147: aload_1
    //   148: athrow
    //   149: astore_1
    //   150: aload_2
    //   151: monitorexit
    //   152: goto +5 -> 157
    //   155: aload_1
    //   156: athrow
    //   157: goto -2 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	QIMNewFriendManager
    //   0	160	1	paramArrayList	ArrayList<QIMNotifyAddFriend>
    //   4	147	2	localObject	Object
    //   14	130	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   42	34	4	localQIMNotifyAddFriend1	QIMNotifyAddFriend
    //   51	13	5	localIterator	Iterator
    //   73	24	6	localQIMNotifyAddFriend2	QIMNotifyAddFriend
    // Exception table:
    //   from	to	target	type
    //   15	24	116	finally
    //   24	53	116	finally
    //   53	102	116	finally
    //   105	109	116	finally
    //   121	137	116	finally
    //   15	24	120	java/lang/Exception
    //   24	53	120	java/lang/Exception
    //   53	102	120	java/lang/Exception
    //   105	109	120	java/lang/Exception
    //   7	15	149	finally
    //   109	113	149	finally
    //   140	142	149	finally
    //   143	149	149	finally
    //   150	152	149	finally
  }
  
  /* Error */
  public void a(java.util.List<QIMNotifyAddFriend> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/app/QIMNewFriendManager:e	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 60	com/tencent/mobileqq/app/QIMNewFriendManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 273	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 278	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_1
    //   20: invokeinterface 301 1 0
    //   25: astore_1
    //   26: aload_1
    //   27: invokeinterface 169 1 0
    //   32: ifeq +75 -> 107
    //   35: aload_1
    //   36: invokeinterface 175 1 0
    //   41: checkcast 177	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   44: astore 4
    //   46: aload_0
    //   47: getfield 33	com/tencent/mobileqq/app/QIMNewFriendManager:d	Ljava/util/ArrayList;
    //   50: invokevirtual 164	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   53: astore 5
    //   55: aload 5
    //   57: invokeinterface 169 1 0
    //   62: ifeq -36 -> 26
    //   65: aload 5
    //   67: invokeinterface 175 1 0
    //   72: checkcast 177	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   75: astore 6
    //   77: aload 4
    //   79: getfield 266	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   82: aload 6
    //   84: getfield 266	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   87: lcmp
    //   88: ifne -33 -> 55
    //   91: aload 6
    //   93: iconst_1
    //   94: putfield 304	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasRead	Z
    //   97: aload_0
    //   98: aload 6
    //   100: invokevirtual 285	com/tencent/mobileqq/app/QIMNewFriendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   103: pop
    //   104: goto -78 -> 26
    //   107: aload_3
    //   108: invokevirtual 288	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   111: aload_3
    //   112: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   115: goto +27 -> 142
    //   118: astore_1
    //   119: goto +43 -> 162
    //   122: astore_1
    //   123: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq -15 -> 111
    //   129: ldc 123
    //   131: iconst_2
    //   132: ldc_w 306
    //   135: aload_1
    //   136: invokestatic 296	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: goto -28 -> 111
    //   142: aload_2
    //   143: monitorexit
    //   144: aload_0
    //   145: getfield 46	com/tencent/mobileqq/app/QIMNewFriendManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   148: ldc 229
    //   150: invokevirtual 233	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   153: checkcast 229	com/tencent/mobileqq/newfriend/api/INewFriendService
    //   156: invokeinterface 236 1 0
    //   161: return
    //   162: aload_3
    //   163: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: aload_2
    //   170: monitorexit
    //   171: goto +5 -> 176
    //   174: aload_1
    //   175: athrow
    //   176: goto -2 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	QIMNewFriendManager
    //   0	179	1	paramList	java.util.List<QIMNotifyAddFriend>
    //   4	166	2	localObject	Object
    //   14	149	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   44	34	4	localQIMNotifyAddFriend1	QIMNotifyAddFriend
    //   53	13	5	localIterator	Iterator
    //   75	24	6	localQIMNotifyAddFriend2	QIMNotifyAddFriend
    // Exception table:
    //   from	to	target	type
    //   15	26	118	finally
    //   26	55	118	finally
    //   55	104	118	finally
    //   107	111	118	finally
    //   123	139	118	finally
    //   15	26	122	java/lang/Exception
    //   26	55	122	java/lang/Exception
    //   55	104	122	java/lang/Exception
    //   107	111	122	java/lang/Exception
    //   7	15	168	finally
    //   111	115	168	finally
    //   142	144	168	finally
    //   162	168	168	finally
    //   169	171	168	finally
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool2 = this.b.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.b.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.b.update(paramEntity);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity em closed e=");
      localStringBuilder.append(paramEntity.getTableName());
      QLog.d("QIMNewFriendManager", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public ArrayList<QIMNotifyAddFriend> b()
  {
    synchronized (this.e)
    {
      ArrayList localArrayList = (ArrayList)this.b.query(QIMNotifyAddFriend.class);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        this.d.addAll(localArrayList);
      }
      this.f.set(true);
      return this.d;
    }
  }
  
  public void b(QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    if (paramQIMNotifyAddFriend == null) {
      return;
    }
    synchronized (this.e)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        if (((QIMNotifyAddFriend)localIterator.next()).uin == paramQIMNotifyAddFriend.uin) {
          localIterator.remove();
        }
      }
      this.a.getEntityManagerFactory().createEntityManager().remove(paramQIMNotifyAddFriend);
      return;
    }
    for (;;)
    {
      throw paramQIMNotifyAddFriend;
    }
  }
  
  public ArrayList<QIMNotifyAddFriend> c()
  {
    ??? = (FlashChatManager)this.a.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    ArrayList localArrayList = new ArrayList();
    if ((((FlashChatManager)???).i()) && (((FlashChatManager)???).j())) {
      synchronized (this.e)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          QIMNotifyAddFriend localQIMNotifyAddFriend = (QIMNotifyAddFriend)localIterator.next();
          if (!localQIMNotifyAddFriend.hasShowToast) {
            localArrayList.add(localQIMNotifyAddFriend);
          }
        }
        Collections.sort(localArrayList, new QIMNewFriendManager.2(this));
        return localArrayList;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMNewFriendManager", 2, "getQIMAddFriendPopUpData enable close");
    }
    return localArrayList1;
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mobileqq/app/QIMNewFriendManager:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifeq +123 -> 130
    //   10: aload_0
    //   11: getfield 35	com/tencent/mobileqq/app/QIMNewFriendManager:e	Ljava/lang/Object;
    //   14: astore_1
    //   15: aload_1
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 60	com/tencent/mobileqq/app/QIMNewFriendManager:b	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: invokevirtual 273	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 278	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   29: aload_0
    //   30: getfield 33	com/tencent/mobileqq/app/QIMNewFriendManager:d	Ljava/util/ArrayList;
    //   33: invokevirtual 164	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   36: astore_3
    //   37: aload_3
    //   38: invokeinterface 169 1 0
    //   43: ifeq +38 -> 81
    //   46: aload_3
    //   47: invokeinterface 175 1 0
    //   52: checkcast 177	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   55: astore 4
    //   57: aload 4
    //   59: getfield 304	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasRead	Z
    //   62: ifne -25 -> 37
    //   65: aload 4
    //   67: iconst_1
    //   68: putfield 304	com/tencent/mobileqq/data/QIMNotifyAddFriend:hasRead	Z
    //   71: aload_0
    //   72: aload 4
    //   74: invokevirtual 285	com/tencent/mobileqq/app/QIMNewFriendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   77: pop
    //   78: goto -41 -> 37
    //   81: aload_2
    //   82: invokevirtual 288	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   85: aload_2
    //   86: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   89: goto +27 -> 116
    //   92: astore_3
    //   93: goto +26 -> 119
    //   96: astore_3
    //   97: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq -15 -> 85
    //   103: ldc 123
    //   105: iconst_2
    //   106: ldc_w 306
    //   109: aload_3
    //   110: invokestatic 296	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: goto -28 -> 85
    //   116: aload_1
    //   117: monitorexit
    //   118: return
    //   119: aload_2
    //   120: invokevirtual 291	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   123: aload_3
    //   124: athrow
    //   125: astore_2
    //   126: aload_1
    //   127: monitorexit
    //   128: aload_2
    //   129: athrow
    //   130: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	QIMNewFriendManager
    //   14	113	1	localObject1	Object
    //   24	96	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   125	4	2	localObject2	Object
    //   36	11	3	localIterator	Iterator
    //   92	1	3	localObject3	Object
    //   96	28	3	localException	java.lang.Exception
    //   55	18	4	localQIMNotifyAddFriend	QIMNotifyAddFriend
    // Exception table:
    //   from	to	target	type
    //   25	37	92	finally
    //   37	78	92	finally
    //   81	85	92	finally
    //   97	113	92	finally
    //   25	37	96	java/lang/Exception
    //   37	78	96	java/lang/Exception
    //   81	85	96	java/lang/Exception
    //   17	25	125	finally
    //   85	89	125	finally
    //   116	118	125	finally
    //   119	125	125	finally
    //   126	128	125	finally
  }
  
  public void onDestroy()
  {
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QIMNewFriendManager
 * JD-Core Version:    0.7.0.1
 */