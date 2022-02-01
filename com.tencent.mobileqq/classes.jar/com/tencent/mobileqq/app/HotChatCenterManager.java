package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.msg.RecentUserAppearLogic;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class HotChatCenterManager
  implements Manager
{
  protected long a;
  protected SharedPreferences a;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  protected Map<String, HotChatItemData> a;
  protected Set<String> a;
  private CopyOnWriteArrayList<HotChatItemData> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  public HotChatCenterManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = 0L;
    QLog.i("HotChatCenterManager", 1, "create HotChatFolderManager.");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
    paramQQAppInterface = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_Long = paramQQAppInterface.getLong("hotchat_last_read_time", 0L);
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("troop_assis_show_on_top", false);
    }
  }
  
  private HotChatItemData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    c();
    HotChatItemData localHotChatItemData = (HotChatItemData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    Object localObject = localHotChatItemData;
    if (localHotChatItemData == null)
    {
      localHotChatItemData = new HotChatItemData();
      localHotChatItemData.mTroopUin = paramString;
      localObject = ((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
      if (localObject != null)
      {
        localHotChatItemData.mHotChatCode = ((HotChatInfo)localObject).name;
        localHotChatItemData.mGameId = ((HotChatInfo)localObject).apolloGameId;
        if (QLog.isColorLevel()) {
          QLog.d("HotChatCenterManager", 2, new Object[] { "code:", ((HotChatInfo)localObject).name, ",gameId:", Integer.valueOf(((HotChatInfo)localObject).apolloGameId) });
        }
        if (((HotChatInfo)localObject).apolloGameId > 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(((HotChatInfo)localObject).apolloGameId);
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "creat_reliao_enter", 0, 0, new String[] { localStringBuilder.toString() });
        }
      }
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
      localObject = localHotChatItemData;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramString, 1);
        localObject = localHotChatItemData;
        if (paramQQAppInterface != null)
        {
          localHotChatItemData.mDraftSec = paramQQAppInterface.getTime();
          localObject = localHotChatItemData;
        }
      }
    }
    return localObject;
  }
  
  private void a(HotChatItemData paramHotChatItemData)
  {
    if (paramHotChatItemData != null)
    {
      if (TextUtils.isEmpty(paramHotChatItemData.mTroopUin)) {
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramHotChatItemData.mTroopUin, paramHotChatItemData);
      Object localObject;
      if (!paramHotChatItemData.mIsMakeTop)
      {
        localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          HotChatItemData localHotChatItemData = (HotChatItemData)((Iterator)localObject).next();
          if (paramHotChatItemData.mTroopUin.equals(localHotChatItemData.mTroopUin)) {
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localHotChatItemData);
          }
        }
        int m = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
        int k = 0;
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= m) {
            break;
          }
          localObject = (HotChatItemData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if ((!((HotChatItemData)localObject).mIsMakeTop) && (Math.max(paramHotChatItemData.mLatestMsgSec, paramHotChatItemData.mDraftSec) > Math.max(((HotChatItemData)localObject).mLatestMsgSec, ((HotChatItemData)localObject).mDraftSec)))
          {
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(i, paramHotChatItemData);
            j = 1;
            break;
          }
          i += 1;
        }
        if (j == 0)
        {
          localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
          ((CopyOnWriteArrayList)localObject).add(((CopyOnWriteArrayList)localObject).size(), paramHotChatItemData);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveHotChatItemData data=");
        ((StringBuilder)localObject).append(paramHotChatItemData);
        QLog.d("HotChatCenterManager", 2, ((StringBuilder)localObject).toString());
      }
      ThreadManager.getSubThreadHandler().post(new HotChatCenterManager.1(this, paramHotChatItemData));
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
      this.jdField_a_of_type_JavaUtilSet.add(paramString);
    }
    h();
  }
  
  private void a(String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    RecentUserProxy localRecentUserProxy = localQQAppInterface.getProxyManager().a();
    paramString = localRecentUserProxy.b(paramString, paramInt);
    if ((paramString != null) && (!RecentUserAppearLogic.a(localQQAppInterface, paramString.msgType))) {
      localRecentUserProxy.a(paramString);
    }
  }
  
  private void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (paramQQAppInterface.getConversationFacade().a(paramString, 1) > 0)
    {
      paramQQAppInterface = this.jdField_a_of_type_JavaUtilSet;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
    }
    h();
  }
  
  private HotChatItemData b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      HotChatItemData localHotChatItemData = (HotChatItemData)localIterator.next();
      if (paramString.equals(localHotChatItemData.mHotChatCode)) {
        return localHotChatItemData;
      }
    }
    return null;
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        HotChatItemData localHotChatItemData = (HotChatItemData)localIterator.next();
        if (paramString.equals(localHotChatItemData.mTroopUin))
        {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localHotChatItemData);
          localObject = localHotChatItemData;
        }
      }
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, localObject);
      }
    }
  }
  
  private void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (paramQQAppInterface.getConversationFacade().a(paramString, 1) > 0)
    {
      paramQQAppInterface = this.jdField_a_of_type_JavaUtilSet;
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.contains(paramString)))
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
        h();
      }
    }
  }
  
  private void c(String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    HotChatItemData localHotChatItemData = a(paramString);
    if (localHotChatItemData != null)
    {
      if (localHotChatItemData.mGameId > 0) {
        return;
      }
      paramString = ((HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
      if ((paramString != null) && (paramString.apolloGameId > 0)) {
        localHotChatItemData.mGameId = paramString.apolloGameId;
      }
    }
  }
  
  private void d()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    try
    {
      RecentUserProxy localRecentUserProxy = localQQAppInterface.getProxyManager().a();
      Object localObject2 = localRecentUserProxy.a(false);
      Object localObject1 = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          if ((((RecentUser)localObject3).getType() == 1) && ((((RecentUser)localObject3).lFlag & 1L) != 0L)) {
            ((List)localObject1).add(localObject3);
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[initHotChatFolder], hotchat.size:");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.i("HotChatCenterManager", 1, ((StringBuilder)localObject2).toString());
      }
      if (((List)localObject1).size() > 0)
      {
        long l = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          localObject3 = a(localQQAppInterface, ((RecentUser)localObject2).uin);
          ((HotChatItemData)localObject3).mDraftSec = ((RecentUser)localObject2).lastmsgdrafttime;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            Message localMessage = localQQAppInterface.getMessageFacade().getLastMessage(((HotChatItemData)localObject3).mTroopUin, 1);
            if (localMessage != null) {
              ((HotChatItemData)localObject3).mLatestMsgSec = localMessage.time;
            }
          }
          else
          {
            ((HotChatItemData)localObject3).mLatestMsgSec = ((RecentUser)localObject2).lastmsgtime;
          }
          a((HotChatItemData)localObject3);
          localRecentUserProxy.a((RecentUser)localObject2);
          b(((HotChatItemData)localObject3).mTroopUin, localQQAppInterface);
        }
        a(l);
      }
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("init_hotchat_folder", false).commit();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
    }
  }
  
  private void e()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localObject1 != null)
    {
      localObject1 = SharedPreferencesHandler.a((SharedPreferences)localObject1, "hotchat_new_unread_list", null);
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaUtilSet = ((Set)localObject1);
      }
    }
    if (this.jdField_a_of_type_JavaUtilSet.size() == 0)
    {
      this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
      localObject1 = localQQAppInterface.getMessageFacade();
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = a();
      if (localObject2 != null)
      {
        if (((List)localObject2).size() == 0) {
          return;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          HotChatItemData localHotChatItemData = (HotChatItemData)((Iterator)localObject2).next();
          Message localMessage = ((QQMessageFacade)localObject1).getLastMessage(localHotChatItemData.mTroopUin, 1);
          if ((localQQAppInterface.getConversationFacade().a(localHotChatItemData.mTroopUin, 1) > 0) && (localMessage.time > this.jdField_a_of_type_Long)) {
            b(localMessage.frienduin, localQQAppInterface);
          }
        }
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
      return;
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      HotChatItemData localHotChatItemData = (HotChatItemData)((Iterator)localObject3).next();
      if (localHotChatItemData.mIsMakeTop) {
        ((List)localObject2).add(localHotChatItemData);
      } else {
        ((List)localObject1).add(localHotChatItemData);
      }
    }
    Collections.sort((List)localObject2, new HotChatCenterManager.3(this));
    Collections.sort((List)localObject1, new HotChatCenterManager.4(this));
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (HotChatItemData)((Iterator)localObject2).next();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterManager", 2, new Object[] { "[sort],", ((HotChatItemData)localObject3).mHotChatCode, ",isMakeTop:", Boolean.valueOf(((HotChatItemData)localObject3).mIsMakeTop), ",topTime:", Long.valueOf(((HotChatItemData)localObject3).mMakeTopTime) });
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HotChatItemData)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterManager", 2, new Object[] { "[sort],", ((HotChatItemData)localObject2).mHotChatCode, ",isMakeTop:", Boolean.valueOf(((HotChatItemData)localObject2).mIsMakeTop), ",topTime:", Long.valueOf(((HotChatItemData)localObject2).mMakeTopTime) });
      }
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   4: invokevirtual 251	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   7: ifne +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: invokevirtual 311	com/tencent/mobileqq/app/HotChatCenterManager:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +4 -> 23
    //   22: return
    //   23: aload 4
    //   25: getstatic 125	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   28: invokevirtual 129	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   31: checkcast 131	com/tencent/mobileqq/app/HotChatManager
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   40: invokevirtual 251	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   43: istore_1
    //   44: aconst_null
    //   45: astore_2
    //   46: aconst_null
    //   47: astore_3
    //   48: aload 4
    //   50: invokevirtual 477	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   53: invokevirtual 483	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   56: astore 4
    //   58: iload_1
    //   59: iconst_1
    //   60: isub
    //   61: istore_1
    //   62: iload_1
    //   63: iflt +191 -> 254
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: astore_2
    //   72: aload_0
    //   73: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   76: iload_1
    //   77: invokevirtual 254	java/util/concurrent/CopyOnWriteArrayList:get	(I)Ljava/lang/Object;
    //   80: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   83: astore 6
    //   85: aload 4
    //   87: astore_3
    //   88: aload 4
    //   90: astore_2
    //   91: aload_0
    //   92: aload 6
    //   94: getfield 119	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   97: invokespecial 485	com/tencent/mobileqq/app/HotChatCenterManager:c	(Ljava/lang/String;)V
    //   100: aload 4
    //   102: astore_3
    //   103: aload 4
    //   105: astore_2
    //   106: aload 5
    //   108: aload 6
    //   110: getfield 119	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   113: invokevirtual 488	com/tencent/mobileqq/app/HotChatManager:b	(Ljava/lang/String;)Z
    //   116: ifne +131 -> 247
    //   119: aload 4
    //   121: astore_3
    //   122: aload 4
    //   124: astore_2
    //   125: aload 6
    //   127: getfield 148	com/tencent/mobileqq/data/HotChatItemData:mGameId	I
    //   130: ifne +117 -> 247
    //   133: aload 4
    //   135: astore_3
    //   136: aload 4
    //   138: astore_2
    //   139: new 168	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   146: astore 7
    //   148: aload 4
    //   150: astore_3
    //   151: aload 4
    //   153: astore_2
    //   154: aload 7
    //   156: aload 6
    //   158: getfield 142	com/tencent/mobileqq/data/HotChatItemData:mHotChatCode	Ljava/lang/String;
    //   161: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 4
    //   167: astore_3
    //   168: aload 4
    //   170: astore_2
    //   171: aload 7
    //   173: ldc_w 490
    //   176: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 4
    //   182: astore_3
    //   183: aload 4
    //   185: astore_2
    //   186: ldc 27
    //   188: iconst_1
    //   189: aload 7
    //   191: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 35	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload 4
    //   199: astore_3
    //   200: aload 4
    //   202: astore_2
    //   203: aload_0
    //   204: getfield 58	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   207: aload 6
    //   209: getfield 119	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   212: invokeinterface 492 2 0
    //   217: pop
    //   218: aload 4
    //   220: astore_3
    //   221: aload 4
    //   223: astore_2
    //   224: aload_0
    //   225: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   228: iload_1
    //   229: invokevirtual 494	java/util/concurrent/CopyOnWriteArrayList:remove	(I)Ljava/lang/Object;
    //   232: pop
    //   233: aload 4
    //   235: astore_3
    //   236: aload 4
    //   238: astore_2
    //   239: aload 4
    //   241: aload 6
    //   243: invokevirtual 499	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   246: pop
    //   247: iload_1
    //   248: iconst_1
    //   249: isub
    //   250: istore_1
    //   251: goto -189 -> 62
    //   254: aload 4
    //   256: ifnull +38 -> 294
    //   259: aload 4
    //   261: astore_2
    //   262: aload_2
    //   263: invokevirtual 502	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   266: return
    //   267: astore_2
    //   268: goto +27 -> 295
    //   271: astore 4
    //   273: aload_2
    //   274: astore_3
    //   275: ldc 27
    //   277: iconst_1
    //   278: aload 4
    //   280: iconst_0
    //   281: anewarray 4	java/lang/Object
    //   284: invokestatic 422	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   287: aload_2
    //   288: ifnull +6 -> 294
    //   291: goto -29 -> 262
    //   294: return
    //   295: aload_3
    //   296: ifnull +7 -> 303
    //   299: aload_3
    //   300: invokevirtual 502	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   303: goto +5 -> 308
    //   306: aload_2
    //   307: athrow
    //   308: goto -2 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	HotChatCenterManager
    //   43	208	1	i	int
    //   45	218	2	localObject1	Object
    //   267	40	2	localObject2	Object
    //   47	253	3	localObject3	Object
    //   15	245	4	localObject4	Object
    //   271	8	4	localThrowable	Throwable
    //   34	73	5	localHotChatManager	HotChatManager
    //   83	159	6	localHotChatItemData	HotChatItemData
    //   146	44	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	58	267	finally
    //   72	85	267	finally
    //   91	100	267	finally
    //   106	119	267	finally
    //   125	133	267	finally
    //   139	148	267	finally
    //   154	165	267	finally
    //   171	180	267	finally
    //   186	197	267	finally
    //   203	218	267	finally
    //   224	233	267	finally
    //   239	247	267	finally
    //   275	287	267	finally
    //   48	58	271	java/lang/Throwable
    //   72	85	271	java/lang/Throwable
    //   91	100	271	java/lang/Throwable
    //   106	119	271	java/lang/Throwable
    //   125	133	271	java/lang/Throwable
    //   139	148	271	java/lang/Throwable
    //   154	165	271	java/lang/Throwable
    //   171	180	271	java/lang/Throwable
    //   186	197	271	java/lang/Throwable
    //   203	218	271	java/lang/Throwable
    //   224	233	271	java/lang/Throwable
    //   239	247	271	java/lang/Throwable
  }
  
  private void h()
  {
    if (a() == null) {
      return;
    }
    ThreadManager.post(new HotChatCenterManager.5(this), 5, null, false);
  }
  
  public int a()
  {
    Set localSet = this.jdField_a_of_type_JavaUtilSet;
    if (localSet != null) {
      return localSet.size();
    }
    return 0;
  }
  
  public QQAppInterface a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (QQAppInterface)localWeakReference.get();
    }
    return null;
  }
  
  public HotChatItemData a()
  {
    QQAppInterface localQQAppInterface = a();
    HotChatItemData localHotChatItemData = null;
    if (localQQAppInterface == null) {
      return null;
    }
    c();
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0) {
      localHotChatItemData = (HotChatItemData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
    }
    return localHotChatItemData;
  }
  
  public HotChatItemData a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      HotChatItemData localHotChatItemData = (HotChatItemData)localIterator.next();
      if (paramString.equals(localHotChatItemData.mTroopUin)) {
        return localHotChatItemData;
      }
    }
    return null;
  }
  
  public List<HotChatItemData> a()
  {
    if (a() == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    c();
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0) {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    }
    return localArrayList;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[initManager], threadId:");
    localStringBuilder.append(Thread.currentThread().getId());
    QLog.i("HotChatCenterManager", 1, localStringBuilder.toString());
    if (a()) {
      d();
    }
    e();
    a();
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0) {
      a(0L);
    }
  }
  
  public void a(long paramLong)
  {
    if (a() == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putLong("hotchat_last_read_time", paramLong).commit();
    }
    this.jdField_a_of_type_Long = paramLong;
    localObject = this.jdField_a_of_type_JavaUtilSet;
    if (localObject != null) {
      ((Set)localObject).clear();
    }
    h();
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject = a();
    if (localObject != null)
    {
      if (paramMessageRecord == null) {
        return;
      }
      if ((!TextUtils.isEmpty(paramMessageRecord.frienduin)) && (DatingUtil.b((QQAppInterface)localObject, paramMessageRecord.frienduin))) {
        return;
      }
      try
      {
        String str = paramMessageRecord.frienduin;
        long l1 = paramMessageRecord.time;
        HotChatItemData localHotChatItemData = a((QQAppInterface)localObject, str);
        if ((paramMessageRecord != null) && (paramMessageRecord.time > l1)) {
          localHotChatItemData.mLatestMsgSec = paramMessageRecord.time;
        } else {
          localHotChatItemData.mLatestMsgSec = l1;
        }
        localObject = ((QQAppInterface)localObject).getMessageFacade().getLastMessage(localHotChatItemData.mTroopUin, 1);
        if (localObject != null)
        {
          long l2 = ((Message)localObject).time;
          if (l2 > localHotChatItemData.mLatestMsgSec) {
            localHotChatItemData.mLatestMsgSec = l2;
          }
        }
        a(localHotChatItemData);
        a(paramMessageRecord, str);
        a(str, 1);
        a(l1);
        return;
      }
      catch (Throwable paramMessageRecord)
      {
        QLog.e("HotChatCenterManager", 1, paramMessageRecord, new Object[0]);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = a(paramString);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("findItemByTroopUin HotChatItemData null troopUin= ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("HotChatCenterManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    ((HotChatItemData)localObject).mIsMakeTop = true;
    ((HotChatItemData)localObject).mMakeTopTime = NetConnInfoCenter.getServerTimeMillis();
    b(paramString);
    a((HotChatItemData)localObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      HotChatItemData localHotChatItemData = b(paramString1);
      if (localHotChatItemData == null)
      {
        paramString2 = new StringBuilder();
        paramString2.append("[setPromotionInfo], fail to find hotchat, code:");
        paramString2.append(paramString1);
        QLog.w("HotChatCenterManager", 1, paramString2.toString());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterManager", 2, new Object[] { "[setPromotionInfo], code:", paramString1, ",content:", paramString2 });
      }
      localHotChatItemData.mIsRead4List = false;
      localHotChatItemData.mIsRead4Folder = false;
      localHotChatItemData.mADsContent = paramString2;
      a(localHotChatItemData.mTroopUin);
      a(localHotChatItemData);
      paramString1 = a();
      if (paramString1 == null) {
        return;
      }
      paramString1 = paramString1.getHandler(Conversation.class);
      if (paramString1 != null) {
        paramString1.sendEmptyMessage(1009);
      }
    }
  }
  
  public boolean a()
  {
    if (a() == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean("init_hotchat_folder", true);
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)
    {
      QLog.w("HotChatCenterManager", 1, "no item in folder, don't add to ru.");
      return false;
    }
    Object localObject2 = (TroopManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_MANAGER);
    localObject1 = ((QQAppInterface)localObject1).getProxyManager().a();
    if (localObject2 == null) {
      return false;
    }
    Object localObject3;
    if (!((RecentUserProxy)localObject1).a(AppConstants.HOTCHAT_CENTER_UIN, 5001))
    {
      localObject2 = (HotChatItemData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
      if (localObject2 != null)
      {
        localObject3 = a();
        int i;
        if (((HotChatItemData)localObject2).mGameId > 0) {
          i = 0;
        } else {
          i = 1;
        }
        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "reliao_folder_show", i, 0, new String[0]);
      }
    }
    localObject2 = ((RecentUserProxy)localObject1).a(AppConstants.HOTCHAT_CENTER_UIN, 5001);
    ((RecentUser)localObject2).uin = AppConstants.HOTCHAT_CENTER_UIN;
    ((RecentUser)localObject2).setType(5001);
    if (((RecentUser)localObject2).lastmsgtime < paramLong) {
      ((RecentUser)localObject2).lastmsgtime = paramLong;
    }
    if (b())
    {
      ((RecentUser)localObject2).showUpTime = (System.currentTimeMillis() / 1000L);
    }
    else
    {
      localObject3 = a();
      if (localObject3 != null)
      {
        ((RecentUser)localObject2).lastmsgtime = ((HotChatItemData)localObject3).mLatestMsgSec;
        ((RecentUser)localObject2).lastmsgdrafttime = ((HotChatItemData)localObject3).mDraftSec;
      }
      ((RecentUser)localObject2).showUpTime = 0L;
    }
    ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
    return true;
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 311	com/tencent/mobileqq/app/HotChatCenterManager:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: astore 8
    //   6: aload 8
    //   8: ifnull +297 -> 305
    //   11: aload_1
    //   12: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aconst_null
    //   21: astore 7
    //   23: aconst_null
    //   24: astore 6
    //   26: aload 8
    //   28: invokevirtual 477	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   31: invokevirtual 483	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 58	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   40: aload_1
    //   41: invokeinterface 492 2 0
    //   46: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   49: astore 6
    //   51: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +272 -> 326
    //   57: ldc 27
    //   59: iconst_2
    //   60: iconst_4
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: ldc_w 638
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: aload_1
    //   73: aastore
    //   74: dup
    //   75: iconst_2
    //   76: ldc_w 640
    //   79: aastore
    //   80: dup
    //   81: iconst_3
    //   82: aload 6
    //   84: getfield 142	com/tencent/mobileqq/data/HotChatItemData:mHotChatCode	Ljava/lang/String;
    //   87: aastore
    //   88: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   91: goto +235 -> 326
    //   94: iload_2
    //   95: aload_0
    //   96: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   99: invokevirtual 251	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   102: if_icmpge +36 -> 138
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   110: iload_2
    //   111: invokevirtual 254	java/util/concurrent/CopyOnWriteArrayList:get	(I)Ljava/lang/Object;
    //   114: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   117: getfield 119	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   120: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifeq +208 -> 331
    //   126: aload_0
    //   127: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   130: iload_2
    //   131: invokevirtual 494	java/util/concurrent/CopyOnWriteArrayList:remove	(I)Ljava/lang/Object;
    //   134: pop
    //   135: goto +196 -> 331
    //   138: aload 6
    //   140: ifnull +42 -> 182
    //   143: new 642	com/tencent/mobileqq/app/HotChatCenterManager$2
    //   146: dup
    //   147: aload_0
    //   148: aload 5
    //   150: aload 6
    //   152: invokespecial 645	com/tencent/mobileqq/app/HotChatCenterManager$2:<init>	(Lcom/tencent/mobileqq/app/HotChatCenterManager;Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/data/HotChatItemData;)V
    //   155: bipush 8
    //   157: aconst_null
    //   158: iconst_0
    //   159: invokestatic 508	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   162: aload_0
    //   163: aload_1
    //   164: aload 8
    //   166: invokespecial 647	com/tencent/mobileqq/app/HotChatCenterManager:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   169: iconst_1
    //   170: istore_3
    //   171: goto +13 -> 184
    //   174: aload 5
    //   176: astore_1
    //   177: iconst_1
    //   178: istore_3
    //   179: goto +86 -> 265
    //   182: iconst_0
    //   183: istore_3
    //   184: aload_0
    //   185: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   188: invokevirtual 251	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   191: ifne +33 -> 224
    //   194: aload_0
    //   195: getstatic 609	com/tencent/mobileqq/app/AppConstants:HOTCHAT_CENTER_UIN	Ljava/lang/String;
    //   198: sipush 5001
    //   201: invokespecial 555	com/tencent/mobileqq/app/HotChatCenterManager:a	(Ljava/lang/String;I)V
    //   204: aload_0
    //   205: invokevirtual 311	com/tencent/mobileqq/app/HotChatCenterManager:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   208: ldc 180
    //   210: ldc 182
    //   212: ldc_w 649
    //   215: iconst_1
    //   216: iconst_0
    //   217: iconst_0
    //   218: anewarray 186	java/lang/String
    //   221: invokestatic 194	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   224: iload_3
    //   225: istore 4
    //   227: aload 5
    //   229: ifnull +61 -> 290
    //   232: aload 5
    //   234: invokevirtual 502	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   237: iload_3
    //   238: ireturn
    //   239: aload 5
    //   241: astore_1
    //   242: goto +23 -> 265
    //   245: astore_1
    //   246: goto +47 -> 293
    //   249: aload 5
    //   251: astore_1
    //   252: goto +11 -> 263
    //   255: astore_1
    //   256: aload 6
    //   258: astore 5
    //   260: goto +33 -> 293
    //   263: iconst_0
    //   264: istore_3
    //   265: aload_1
    //   266: astore 6
    //   268: ldc 27
    //   270: iconst_1
    //   271: ldc 171
    //   273: invokestatic 651	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: iload_3
    //   277: istore 4
    //   279: aload_1
    //   280: ifnull +10 -> 290
    //   283: aload_1
    //   284: invokevirtual 502	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   287: iload_3
    //   288: istore 4
    //   290: iload 4
    //   292: ireturn
    //   293: aload 5
    //   295: ifnull +8 -> 303
    //   298: aload 5
    //   300: invokevirtual 502	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   303: aload_1
    //   304: athrow
    //   305: iconst_0
    //   306: ireturn
    //   307: astore_1
    //   308: aload 7
    //   310: astore_1
    //   311: goto -48 -> 263
    //   314: astore_1
    //   315: goto -66 -> 249
    //   318: astore_1
    //   319: goto -145 -> 174
    //   322: astore_1
    //   323: goto -84 -> 239
    //   326: iconst_0
    //   327: istore_2
    //   328: goto -234 -> 94
    //   331: iload_2
    //   332: iconst_1
    //   333: iadd
    //   334: istore_2
    //   335: goto -241 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	HotChatCenterManager
    //   0	338	1	paramString	String
    //   94	241	2	i	int
    //   170	118	3	bool1	boolean
    //   225	66	4	bool2	boolean
    //   34	265	5	localObject1	Object
    //   24	243	6	localObject2	Object
    //   21	288	7	localObject3	Object
    //   4	161	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   36	91	245	finally
    //   94	135	245	finally
    //   143	162	245	finally
    //   162	169	245	finally
    //   184	224	245	finally
    //   26	36	255	finally
    //   268	276	255	finally
    //   26	36	307	java/lang/Throwable
    //   36	91	314	java/lang/Throwable
    //   94	135	314	java/lang/Throwable
    //   143	162	314	java/lang/Throwable
    //   162	169	318	java/lang/Throwable
    //   184	224	322	java/lang/Throwable
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (a() == null) {
      return false;
    }
    c(paramString);
    if (a(paramString) == null) {
      return false;
    }
    a(paramString);
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return false;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putBoolean("troop_assis_show_on_top", paramBoolean).commit();
    }
    a(0L);
    localObject = localQQAppInterface.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1009);
    }
    if (paramBoolean) {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "top_reliao_folder", 0, 0, new String[0]);
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    int j = 0;
    int i;
    try
    {
      if (this.jdField_a_of_type_JavaUtilSet == null) {
        break label101;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      i = 0;
      for (;;)
      {
        j = i;
        try
        {
          if (!localIterator.hasNext()) {
            break label101;
          }
          String str = (String)localIterator.next();
          if (localQQAppInterface.getConversationFacade().a(str, 1) <= 0)
          {
            localIterator.remove();
            i = 1;
          }
        }
        catch (Exception localException1) {}
      }
      QLog.e("HotChatCenterManager", 1, localException2, new Object[0]);
    }
    catch (Exception localException2)
    {
      i = 0;
    }
    j = i;
    label101:
    if (j != 0) {
      h();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   4: invokevirtual 251	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   7: ifle +4 -> 11
    //   10: return
    //   11: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +31 -> 45
    //   17: ldc 27
    //   19: iconst_2
    //   20: iconst_2
    //   21: anewarray 4	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: ldc_w 663
    //   29: aastore
    //   30: dup
    //   31: iconst_1
    //   32: invokestatic 525	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   35: invokevirtual 528	java/lang/Thread:getId	()J
    //   38: invokestatic 472	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   41: aastore
    //   42: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   45: aconst_null
    //   46: astore_1
    //   47: aconst_null
    //   48: astore_2
    //   49: aload_0
    //   50: invokevirtual 311	com/tencent/mobileqq/app/HotChatCenterManager:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnonnull +4 -> 59
    //   58: return
    //   59: aload_3
    //   60: invokevirtual 477	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   63: invokevirtual 483	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   66: astore_3
    //   67: aload_3
    //   68: astore_2
    //   69: aload_3
    //   70: astore_1
    //   71: aload_3
    //   72: ldc 114
    //   74: iconst_0
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: ldc_w 665
    //   82: aconst_null
    //   83: invokevirtual 669	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   86: astore 4
    //   88: aload 4
    //   90: ifnull +357 -> 447
    //   93: aload_3
    //   94: astore_2
    //   95: aload_3
    //   96: astore_1
    //   97: aload 4
    //   99: invokeinterface 365 1 0
    //   104: ifle +343 -> 447
    //   107: aload_3
    //   108: astore_2
    //   109: aload_3
    //   110: astore_1
    //   111: aload 4
    //   113: checkcast 361	java/util/ArrayList
    //   116: astore 4
    //   118: aload_3
    //   119: astore_2
    //   120: aload_3
    //   121: astore_1
    //   122: aload 4
    //   124: invokevirtual 670	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   127: astore 5
    //   129: aload_3
    //   130: astore_2
    //   131: aload_3
    //   132: astore_1
    //   133: aload 5
    //   135: invokeinterface 236 1 0
    //   140: ifeq +36 -> 176
    //   143: aload_3
    //   144: astore_2
    //   145: aload_3
    //   146: astore_1
    //   147: aload 5
    //   149: invokeinterface 240 1 0
    //   154: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   157: astore 6
    //   159: aload_3
    //   160: astore_2
    //   161: aload_3
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   167: aload 6
    //   169: invokevirtual 453	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: goto -44 -> 129
    //   176: aload_3
    //   177: astore_2
    //   178: aload_3
    //   179: astore_1
    //   180: aload_0
    //   181: invokespecial 672	com/tencent/mobileqq/app/HotChatCenterManager:f	()V
    //   184: aload_3
    //   185: astore_2
    //   186: aload_3
    //   187: astore_1
    //   188: aload_0
    //   189: getfield 58	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   192: invokeinterface 673 1 0
    //   197: aload_3
    //   198: astore_2
    //   199: aload_3
    //   200: astore_1
    //   201: aload 4
    //   203: invokevirtual 670	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   206: astore 4
    //   208: aload_3
    //   209: astore_2
    //   210: aload_3
    //   211: astore_1
    //   212: aload 4
    //   214: invokeinterface 236 1 0
    //   219: ifeq +43 -> 262
    //   222: aload_3
    //   223: astore_2
    //   224: aload_3
    //   225: astore_1
    //   226: aload 4
    //   228: invokeinterface 240 1 0
    //   233: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   236: astore 5
    //   238: aload_3
    //   239: astore_2
    //   240: aload_3
    //   241: astore_1
    //   242: aload_0
    //   243: getfield 58	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   246: aload 5
    //   248: getfield 119	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   251: aload 5
    //   253: invokeinterface 224 3 0
    //   258: pop
    //   259: goto -51 -> 208
    //   262: aload_3
    //   263: astore_2
    //   264: aload_3
    //   265: astore_1
    //   266: aload_0
    //   267: invokespecial 675	com/tencent/mobileqq/app/HotChatCenterManager:g	()V
    //   270: aload_3
    //   271: astore_2
    //   272: aload_3
    //   273: astore_1
    //   274: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +170 -> 447
    //   280: aload_3
    //   281: astore_2
    //   282: aload_3
    //   283: astore_1
    //   284: new 168	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   291: astore 4
    //   293: aload_3
    //   294: astore_2
    //   295: aload_3
    //   296: astore_1
    //   297: aload 4
    //   299: ldc_w 677
    //   302: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_3
    //   307: astore_2
    //   308: aload_3
    //   309: astore_1
    //   310: aload 4
    //   312: aload_0
    //   313: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   316: invokevirtual 251	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   319: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_3
    //   324: astore_2
    //   325: aload_3
    //   326: astore_1
    //   327: ldc 27
    //   329: iconst_2
    //   330: aload 4
    //   332: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload_3
    //   339: astore_2
    //   340: aload_3
    //   341: astore_1
    //   342: aload_0
    //   343: getfield 47	com/tencent/mobileqq/app/HotChatCenterManager:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   346: invokevirtual 231	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   349: astore 4
    //   351: aload_3
    //   352: astore_2
    //   353: aload_3
    //   354: astore_1
    //   355: aload 4
    //   357: invokeinterface 236 1 0
    //   362: ifeq +85 -> 447
    //   365: aload_3
    //   366: astore_2
    //   367: aload_3
    //   368: astore_1
    //   369: aload 4
    //   371: invokeinterface 240 1 0
    //   376: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   379: astore 5
    //   381: aload_3
    //   382: astore_2
    //   383: aload_3
    //   384: astore_1
    //   385: ldc 27
    //   387: iconst_2
    //   388: bipush 6
    //   390: anewarray 4	java/lang/Object
    //   393: dup
    //   394: iconst_0
    //   395: ldc_w 679
    //   398: aastore
    //   399: dup
    //   400: iconst_1
    //   401: aload 5
    //   403: getfield 148	com/tencent/mobileqq/data/HotChatItemData:mGameId	I
    //   406: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   409: aastore
    //   410: dup
    //   411: iconst_2
    //   412: ldc_w 681
    //   415: aastore
    //   416: dup
    //   417: iconst_3
    //   418: aload 5
    //   420: getfield 684	com/tencent/mobileqq/data/HotChatItemData:mState	I
    //   423: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   426: aastore
    //   427: dup
    //   428: iconst_4
    //   429: ldc_w 686
    //   432: aastore
    //   433: dup
    //   434: iconst_5
    //   435: aload 5
    //   437: getfield 142	com/tencent/mobileqq/data/HotChatItemData:mHotChatCode	Ljava/lang/String;
    //   440: aastore
    //   441: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   444: goto -93 -> 351
    //   447: aload_3
    //   448: ifnull +34 -> 482
    //   451: aload_3
    //   452: astore_1
    //   453: goto +25 -> 478
    //   456: astore_1
    //   457: goto +26 -> 483
    //   460: astore_3
    //   461: aload_1
    //   462: astore_2
    //   463: ldc 27
    //   465: iconst_1
    //   466: aload_3
    //   467: iconst_0
    //   468: anewarray 4	java/lang/Object
    //   471: invokestatic 422	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   474: aload_1
    //   475: ifnull +7 -> 482
    //   478: aload_1
    //   479: invokevirtual 502	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   482: return
    //   483: aload_2
    //   484: ifnull +7 -> 491
    //   487: aload_2
    //   488: invokevirtual 502	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   491: goto +5 -> 496
    //   494: aload_1
    //   495: athrow
    //   496: goto -2 -> 494
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	this	HotChatCenterManager
    //   46	407	1	localObject1	Object
    //   456	39	1	localObject2	Object
    //   48	440	2	localObject3	Object
    //   53	399	3	localObject4	Object
    //   460	7	3	localThrowable	Throwable
    //   86	284	4	localObject5	Object
    //   127	309	5	localObject6	Object
    //   157	11	6	localHotChatItemData	HotChatItemData
    // Exception table:
    //   from	to	target	type
    //   59	67	456	finally
    //   71	88	456	finally
    //   97	107	456	finally
    //   111	118	456	finally
    //   122	129	456	finally
    //   133	143	456	finally
    //   147	159	456	finally
    //   163	173	456	finally
    //   180	184	456	finally
    //   188	197	456	finally
    //   201	208	456	finally
    //   212	222	456	finally
    //   226	238	456	finally
    //   242	259	456	finally
    //   266	270	456	finally
    //   274	280	456	finally
    //   284	293	456	finally
    //   297	306	456	finally
    //   310	323	456	finally
    //   327	338	456	finally
    //   342	351	456	finally
    //   355	365	456	finally
    //   369	381	456	finally
    //   385	444	456	finally
    //   463	474	456	finally
    //   59	67	460	java/lang/Throwable
    //   71	88	460	java/lang/Throwable
    //   97	107	460	java/lang/Throwable
    //   111	118	460	java/lang/Throwable
    //   122	129	460	java/lang/Throwable
    //   133	143	460	java/lang/Throwable
    //   147	159	460	java/lang/Throwable
    //   163	173	460	java/lang/Throwable
    //   180	184	460	java/lang/Throwable
    //   188	197	460	java/lang/Throwable
    //   201	208	460	java/lang/Throwable
    //   212	222	460	java/lang/Throwable
    //   226	238	460	java/lang/Throwable
    //   242	259	460	java/lang/Throwable
    //   266	270	460	java/lang/Throwable
    //   274	280	460	java/lang/Throwable
    //   284	293	460	java/lang/Throwable
    //   297	306	460	java/lang/Throwable
    //   310	323	460	java/lang/Throwable
    //   327	338	460	java/lang/Throwable
    //   342	351	460	java/lang/Throwable
    //   355	365	460	java/lang/Throwable
    //   369	381	460	java/lang/Throwable
    //   385	444	460	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    QLog.i("HotChatCenterManager", 1, "destroy HotChatFolderManager.");
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    Set localSet = this.jdField_a_of_type_JavaUtilSet;
    if (localSet != null) {
      localSet.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatCenterManager
 * JD-Core Version:    0.7.0.1
 */