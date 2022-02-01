import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatCenterManager.1;
import com.tencent.mobileqq.app.HotChatCenterManager.5;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
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

public class anwa
  implements Manager
{
  protected long a;
  public SharedPreferences a;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  protected Map<String, HotChatItemData> a;
  public Set<String> a;
  private CopyOnWriteArrayList<HotChatItemData> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  public anwa(QQAppInterface paramQQAppInterface)
  {
    QLog.i("HotChatCenterManager", 1, "create HotChatFolderManager.");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("hotchat_last_read_time", 0L);
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("troop_assis_show_on_top", false);
    }
  }
  
  private HotChatItemData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    c();
    Object localObject2 = (HotChatItemData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HotChatItemData();
      ((HotChatItemData)localObject1).mTroopUin = paramString;
      localObject2 = ((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
      if (localObject2 != null)
      {
        ((HotChatItemData)localObject1).mHotChatCode = ((HotChatInfo)localObject2).name;
        if (((HotChatInfo)localObject2).apolloGameId <= 0)
        {
          ApolloGameData localApolloGameData = ((ankc)paramQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(((HotChatInfo)localObject2).name);
          if (localApolloGameData != null) {
            ((HotChatInfo)localObject2).apolloGameId = localApolloGameData.gameId;
          }
        }
        ((HotChatItemData)localObject1).mGameId = ((HotChatInfo)localObject2).apolloGameId;
        if (QLog.isColorLevel()) {
          QLog.d("HotChatCenterManager", 2, new Object[] { "code:", ((HotChatInfo)localObject2).name, ",gameId:", Integer.valueOf(((HotChatInfo)localObject2).apolloGameId) });
        }
        if (((HotChatInfo)localObject2).apolloGameId > 0) {
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "creat_reliao_enter", 0, 0, new String[] { "" + ((HotChatInfo)localObject2).apolloGameId });
        }
      }
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramString, 1);
        if (paramQQAppInterface != null) {
          ((HotChatItemData)localObject1).mDraftSec = paramQQAppInterface.getTime();
        }
      }
    }
    return localObject1;
  }
  
  private void a(HotChatItemData paramHotChatItemData)
  {
    if ((paramHotChatItemData == null) || (TextUtils.isEmpty(paramHotChatItemData.mTroopUin))) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramHotChatItemData.mTroopUin, paramHotChatItemData);
    if (!paramHotChatItemData.mIsMakeTop)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        HotChatItemData localHotChatItemData = (HotChatItemData)((Iterator)localObject).next();
        if (paramHotChatItemData.mTroopUin.equals(localHotChatItemData.mTroopUin)) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localHotChatItemData);
        }
      }
      int j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
      i = 0;
      if (i >= j) {
        break label246;
      }
      localObject = (HotChatItemData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if ((((HotChatItemData)localObject).mIsMakeTop) || (Math.max(paramHotChatItemData.mLatestMsgSec, paramHotChatItemData.mDraftSec) <= Math.max(((HotChatItemData)localObject).mLatestMsgSec, ((HotChatItemData)localObject).mDraftSec))) {
        break label239;
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(i, paramHotChatItemData);
    }
    label239:
    label246:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size(), paramHotChatItemData);
      }
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterManager", 2, "saveHotChatItemData data=" + paramHotChatItemData);
      }
      ThreadManager.getSubThreadHandler().post(new HotChatCenterManager.1(this, paramHotChatItemData));
      return;
      i += 1;
      break;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
      this.jdField_a_of_type_JavaUtilSet.add(paramString);
    }
    h();
  }
  
  private void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if ((paramQQAppInterface.getConversationFacade().a(paramString, 1) > 0) && (this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
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
  
  private void b(String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    aoxz localaoxz;
    do
    {
      return;
      localaoxz = localQQAppInterface.getProxyManager().a();
      paramString = (RecentUser)localaoxz.findRecentUser(paramString, paramInt);
    } while ((paramString == null) || (paramString.shouldShowInRecentList(localQQAppInterface)));
    localaoxz.delRecentUser(paramString);
  }
  
  private void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    while ((paramQQAppInterface.getConversationFacade().a(paramString, 1) <= 0) || (this.jdField_a_of_type_JavaUtilSet == null) || (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
    h();
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) || (TextUtils.isEmpty(paramString))) {}
    label89:
    label90:
    for (;;)
    {
      return;
      Object localObject = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext())
      {
        HotChatItemData localHotChatItemData = (HotChatItemData)localIterator.next();
        if (!paramString.equals(localHotChatItemData.mTroopUin)) {
          break label89;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localHotChatItemData);
        localObject = localHotChatItemData;
      }
      for (;;)
      {
        break;
        if (localObject == null) {
          break label90;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, localObject);
        return;
      }
    }
  }
  
  private void d()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      aoxz localaoxz;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      try
      {
        localaoxz = localQQAppInterface.getProxyManager().a();
        localObject2 = localaoxz.getRecentList(false);
        localObject1 = new ArrayList();
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
          QLog.i("HotChatCenterManager", 1, "[initHotChatFolder], hotchat.size:" + ((List)localObject1).size());
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
        return;
      }
      if (((List)localObject1).size() > 0)
      {
        long l = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          localObject3 = a(localThrowable, ((RecentUser)localObject2).uin);
          ((HotChatItemData)localObject3).mDraftSec = ((RecentUser)localObject2).lastmsgdrafttime;
          QQMessageFacade.Message localMessage;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            localMessage = localThrowable.getMessageFacade().getLastMessage(((HotChatItemData)localObject3).mTroopUin, 1);
            if (localMessage == null) {}
          }
          for (((HotChatItemData)localObject3).mLatestMsgSec = localMessage.time;; ((HotChatItemData)localObject3).mLatestMsgSec = ((RecentUser)localObject2).lastmsgtime)
          {
            a((HotChatItemData)localObject3);
            localaoxz.delRecentUser((BaseRecentUser)localObject2);
            b(((HotChatItemData)localObject3).mTroopUin, localThrowable);
            break;
          }
        }
        a(l);
      }
    } while (this.jdField_a_of_type_AndroidContentSharedPreferences == null);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("init_hotchat_folder", false).commit();
  }
  
  private void d(String paramString)
  {
    Object localObject = a();
    if (localObject == null) {}
    HotChatItemData localHotChatItemData;
    do
    {
      do
      {
        do
        {
          return;
          localHotChatItemData = a(paramString);
        } while ((localHotChatItemData == null) || (localHotChatItemData.mGameId > 0));
        paramString = ((HotChatManager)((QQAppInterface)localObject).getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
        if ((paramString != null) && (paramString.apolloGameId > 0))
        {
          localHotChatItemData.mGameId = paramString.apolloGameId;
          return;
        }
        localObject = ((ankc)((QQAppInterface)localObject).getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(localHotChatItemData.mHotChatCode);
      } while (localObject == null);
      localHotChatItemData.mGameId = ((ApolloGameData)localObject).gameId;
    } while (paramString == null);
    paramString.apolloGameId = localHotChatItemData.mGameId;
  }
  
  private void e()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    for (;;)
    {
      return;
      Object localObject1;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        localObject1 = bhhs.a(this.jdField_a_of_type_AndroidContentSharedPreferences, "hotchat_new_unread_list", null);
        if (localObject1 != null) {
          this.jdField_a_of_type_JavaUtilSet = ((Set)localObject1);
        }
      }
      if (this.jdField_a_of_type_JavaUtilSet.size() == 0)
      {
        this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
        localObject1 = localQQAppInterface.getMessageFacade();
        if (localObject1 != null)
        {
          Object localObject2 = a();
          if ((localObject2 != null) && (((List)localObject2).size() != 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              HotChatItemData localHotChatItemData = (HotChatItemData)((Iterator)localObject2).next();
              QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).getLastMessage(localHotChatItemData.mTroopUin, 1);
              if ((localQQAppInterface.getConversationFacade().a(localHotChatItemData.mTroopUin, 1) > 0) && (localMessage.time > this.jdField_a_of_type_Long)) {
                b(localMessage.frienduin, localQQAppInterface);
              }
            }
          }
        }
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {}
    for (;;)
    {
      return;
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
      Collections.sort((List)localObject2, new anwb(this));
      Collections.sort((List)localObject1, new anwc(this));
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
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   4: invokevirtual 264	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   7: ifne +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: invokevirtual 337	anwa:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull -7 -> 10
    //   20: aload_3
    //   21: getstatic 125	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   24: invokevirtual 129	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   27: checkcast 131	com/tencent/mobileqq/app/HotChatManager
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   36: invokevirtual 264	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   39: istore_1
    //   40: aconst_null
    //   41: astore_2
    //   42: aload_3
    //   43: invokevirtual 489	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   46: invokevirtual 495	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   49: astore_3
    //   50: aload_3
    //   51: astore_2
    //   52: iload_1
    //   53: iconst_1
    //   54: isub
    //   55: istore_1
    //   56: iload_1
    //   57: iflt +107 -> 164
    //   60: aload_0
    //   61: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   64: iload_1
    //   65: invokevirtual 267	java/util/concurrent/CopyOnWriteArrayList:get	(I)Ljava/lang/Object;
    //   68: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   71: astore_3
    //   72: aload_0
    //   73: aload_3
    //   74: getfield 119	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   77: invokespecial 497	anwa:d	(Ljava/lang/String;)V
    //   80: aload 4
    //   82: aload_3
    //   83: getfield 119	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   86: invokevirtual 500	com/tencent/mobileqq/app/HotChatManager:b	(Ljava/lang/String;)Z
    //   89: ifne +68 -> 157
    //   92: aload_3
    //   93: getfield 161	com/tencent/mobileqq/data/HotChatItemData:mGameId	I
    //   96: ifne +61 -> 157
    //   99: ldc 25
    //   101: iconst_1
    //   102: new 189	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   109: aload_3
    //   110: getfield 142	com/tencent/mobileqq/data/HotChatItemData:mHotChatCode	Ljava/lang/String;
    //   113: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 502
    //   119: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 33	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_0
    //   129: getfield 56	anwa:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   132: aload_3
    //   133: getfield 119	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   136: invokeinterface 504 2 0
    //   141: pop
    //   142: aload_0
    //   143: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   146: iload_1
    //   147: invokevirtual 506	java/util/concurrent/CopyOnWriteArrayList:remove	(I)Ljava/lang/Object;
    //   150: pop
    //   151: aload_2
    //   152: aload_3
    //   153: invokevirtual 511	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   156: pop
    //   157: iload_1
    //   158: iconst_1
    //   159: isub
    //   160: istore_1
    //   161: goto -105 -> 56
    //   164: aload_2
    //   165: ifnull -155 -> 10
    //   168: aload_2
    //   169: invokevirtual 514	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   172: return
    //   173: astore_3
    //   174: ldc 25
    //   176: iconst_1
    //   177: aload_3
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 387	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   185: aload_2
    //   186: ifnull -176 -> 10
    //   189: aload_2
    //   190: invokevirtual 514	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   193: return
    //   194: astore_3
    //   195: aconst_null
    //   196: astore_2
    //   197: aload_2
    //   198: ifnull +7 -> 205
    //   201: aload_2
    //   202: invokevirtual 514	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   205: aload_3
    //   206: athrow
    //   207: astore_3
    //   208: goto -11 -> 197
    //   211: astore_3
    //   212: goto -15 -> 197
    //   215: astore_3
    //   216: goto -42 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	anwa
    //   39	122	1	i	int
    //   41	161	2	localObject1	Object
    //   15	138	3	localObject2	Object
    //   173	5	3	localThrowable1	Throwable
    //   194	12	3	localObject3	Object
    //   207	1	3	localObject4	Object
    //   211	1	3	localObject5	Object
    //   215	1	3	localThrowable2	Throwable
    //   30	51	4	localHotChatManager	HotChatManager
    // Exception table:
    //   from	to	target	type
    //   42	50	173	java/lang/Throwable
    //   42	50	194	finally
    //   60	157	207	finally
    //   174	185	211	finally
    //   60	157	215	java/lang/Throwable
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
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      return this.jdField_a_of_type_JavaUtilSet.size();
    }
    return 0;
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public HotChatItemData a()
  {
    if (a() == null) {}
    do
    {
      return null;
      c();
    } while (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0);
    return (HotChatItemData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
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
    Object localObject;
    if (a() == null) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      return localObject;
      localArrayList = new ArrayList();
      c();
      localObject = localArrayList;
    } while (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0);
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    return localArrayList;
  }
  
  public void a()
  {
    QLog.i("HotChatCenterManager", 1, "[initManager], threadId:" + Thread.currentThread().getId());
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
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("hotchat_last_read_time", paramLong).commit();
    }
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    h();
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject = a();
    if ((localObject == null) || (paramMessageRecord == null)) {}
    while ((!TextUtils.isEmpty(paramMessageRecord.frienduin)) && (arxx.b((QQAppInterface)localObject, paramMessageRecord.frienduin))) {
      return;
    }
    for (;;)
    {
      long l1;
      HotChatItemData localHotChatItemData;
      try
      {
        String str = paramMessageRecord.frienduin;
        l1 = paramMessageRecord.time;
        localHotChatItemData = a((QQAppInterface)localObject, str);
        if ((paramMessageRecord != null) && (paramMessageRecord.time > l1))
        {
          localHotChatItemData.mLatestMsgSec = paramMessageRecord.time;
          localObject = ((QQAppInterface)localObject).getMessageFacade().getLastMessage(localHotChatItemData.mTroopUin, 1);
          if (localObject != null)
          {
            long l2 = ((QQMessageFacade.Message)localObject).time;
            if (l2 > localHotChatItemData.mLatestMsgSec) {
              localHotChatItemData.mLatestMsgSec = l2;
            }
          }
          a(localHotChatItemData);
          a(paramMessageRecord, str);
          b(str, 1);
          a(l1);
          return;
        }
      }
      catch (Throwable paramMessageRecord)
      {
        QLog.e("HotChatCenterManager", 1, paramMessageRecord, new Object[0]);
        return;
      }
      localHotChatItemData.mLatestMsgSec = l1;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    HotChatItemData localHotChatItemData;
    do
    {
      return;
      localHotChatItemData = a(paramString);
      if (localHotChatItemData != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("HotChatCenterManager", 2, "findItemByTroopUin HotChatItemData null troopUin= " + paramString);
    return;
    localHotChatItemData.mIsMakeTop = true;
    localHotChatItemData.mMakeTopTime = NetConnInfoCenter.getServerTimeMillis();
    c(paramString);
    a(localHotChatItemData);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterManager", 2, new Object[] { "[read promotion], troopUin:", paramString });
      }
      paramString = a(paramString);
    } while (paramString == null);
    if (paramInt == 1) {
      paramString.mIsRead4Folder = true;
    }
    for (;;)
    {
      a(paramString);
      return;
      if (paramInt == 2) {
        paramString.mIsRead4List = true;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        return;
        HotChatItemData localHotChatItemData = b(paramString1);
        if (localHotChatItemData == null)
        {
          QLog.w("HotChatCenterManager", 1, "[setPromotionInfo], fail to find hotchat, code:" + paramString1);
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
      } while (paramString1 == null);
      paramString1 = paramString1.getHandler(Conversation.class);
    } while (paramString1 == null);
    paramString1.sendEmptyMessage(1009);
  }
  
  public boolean a()
  {
    if (a() == null) {}
    while (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("init_hotchat_folder", true);
  }
  
  public boolean a(long paramLong)
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)
      {
        QLog.w("HotChatCenterManager", 1, "no item in folder, don't add to ru.");
        return false;
      }
      localObject2 = (TroopManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_MANAGER);
      localObject1 = ((QQAppInterface)localObject1).getProxyManager().a();
    } while (localObject2 == null);
    Object localObject3;
    int i;
    if (!((aoxz)localObject1).isRecentUserInCache(AppConstants.HOTCHAT_CENTER_UIN, 5001))
    {
      localObject2 = (HotChatItemData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
      if (localObject2 != null)
      {
        localObject3 = a();
        if (((HotChatItemData)localObject2).mGameId <= 0) {
          break label204;
        }
        i = 0;
        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "reliao_folder_show", i, 0, new String[0]);
      }
    }
    Object localObject2 = (RecentUser)((aoxz)localObject1).findRecentUserByUin(AppConstants.HOTCHAT_CENTER_UIN, 5001);
    ((RecentUser)localObject2).uin = AppConstants.HOTCHAT_CENTER_UIN;
    ((RecentUser)localObject2).setType(5001);
    if (((RecentUser)localObject2).lastmsgtime < paramLong) {
      ((RecentUser)localObject2).lastmsgtime = paramLong;
    }
    if (b()) {}
    for (((RecentUser)localObject2).showUpTime = (System.currentTimeMillis() / 1000L);; ((RecentUser)localObject2).showUpTime = 0L)
    {
      ((aoxz)localObject1).saveRecentUser((BaseRecentUser)localObject2);
      return true;
      label204:
      i = 1;
      break;
      localObject3 = a();
      if (localObject3 != null)
      {
        ((RecentUser)localObject2).lastmsgtime = ((HotChatItemData)localObject3).mLatestMsgSec;
        ((RecentUser)localObject2).lastmsgdrafttime = ((HotChatItemData)localObject3).mDraftSec;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    d(paramString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      HotChatItemData localHotChatItemData = (HotChatItemData)localIterator.next();
      if ((localHotChatItemData != null) && (paramString.equals(localHotChatItemData.mTroopUin)) && (localHotChatItemData.mGameId > 0)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    HotChatItemData localHotChatItemData;
    do
    {
      return false;
      d(paramString);
      localHotChatItemData = a(paramString);
    } while (localHotChatItemData == null);
    if (localHotChatItemData.mGameId > 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatCenterManager", 2, new Object[] { "[removeHotChatData], troopUin:", paramString, ",state:", Integer.valueOf(paramInt), ",isCmShowGame:", Boolean.valueOf(bool) });
      }
      if ((bool) && (HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL.targetState == paramInt))
      {
        ((VasExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(localHotChatItemData.mGameId, "android.aio", false, 2, localHotChatItemData.mHotChatCode);
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "delete_reliao_enter", 1, 0, new String[] { String.valueOf(localHotChatItemData.mGameId) });
      }
      if ((!bool) || ((HotChatManager.HotChatStateWrapper.STATE_LEFT_LONG_TIME_NOT_SAY.targetState != paramInt) && (HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_LEFT_OVERCOUNT.targetState != paramInt))) {
        break;
      }
      QLog.i("HotChatCenterManager", 1, "kicked out from hotchat as long time no say or hotchat is overcount.");
      if (localHotChatItemData != null) {}
      try
      {
        localHotChatItemData.mState = 1;
        if (QLog.isColorLevel()) {
          QLog.d("HotChatCenterManager", 2, new Object[] { "[removeHotChatData], code:", localHotChatItemData.mHotChatCode });
        }
        a(localHotChatItemData);
        return false;
      }
      catch (Throwable paramString)
      {
        QLog.e("HotChatCenterManager", 1, paramString, new Object[0]);
        return false;
      }
    }
    b(paramString);
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return false;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("troop_assis_show_on_top", paramBoolean).commit();
    }
    a(0L);
    MqqHandler localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
    if (paramBoolean) {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "top_reliao_folder", 0, 0, new String[0]);
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_JavaUtilSet == null) {
          break label111;
        }
        localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        i = 0;
      }
      catch (Exception localException1)
      {
        try
        {
          Iterator localIterator;
          if (!localIterator.hasNext()) {
            break label95;
          }
          String str = (String)localIterator.next();
          if (localQQAppInterface.getConversationFacade().a(str, 1) > 0) {
            break label108;
          }
          localIterator.remove();
          i = 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i;
          }
        }
        localException1 = localException1;
        i = 0;
      }
      int j = i;
      QLog.e("HotChatCenterManager", 1, localException1, new Object[0]);
      label95:
      label108:
      label111:
      for (j = i; j != 0; j = 0)
      {
        h();
        return;
      }
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      HotChatItemData localHotChatItemData;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localHotChatItemData = (HotChatItemData)localIterator.next();
      } while ((!localHotChatItemData.mIsMakeTop) || (!paramString.equals(localHotChatItemData.mTroopUin)));
      for (paramString = localHotChatItemData; paramString != null; paramString = null)
      {
        paramString.mIsMakeTop = false;
        f();
        a(paramString);
        return;
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore 4
    //   5: aload_0
    //   6: invokevirtual 337	anwa:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: astore 6
    //   11: aload 6
    //   13: ifnull +10 -> 23
    //   16: aload_1
    //   17: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +9 -> 29
    //   23: iconst_0
    //   24: istore 4
    //   26: iload 4
    //   28: ireturn
    //   29: aload 6
    //   31: invokevirtual 489	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   34: invokevirtual 495	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   37: astore 5
    //   39: aload_0
    //   40: getfield 56	anwa:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   43: aload_1
    //   44: invokeinterface 504 2 0
    //   49: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   52: astore 7
    //   54: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +259 -> 316
    //   60: ldc 25
    //   62: iconst_2
    //   63: iconst_4
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: ldc_w 655
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: aload_1
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: ldc_w 715
    //   82: aastore
    //   83: dup
    //   84: iconst_3
    //   85: aload 7
    //   87: getfield 142	com/tencent/mobileqq/data/HotChatItemData:mHotChatCode	Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   94: goto +222 -> 316
    //   97: iload_2
    //   98: aload_0
    //   99: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   102: invokevirtual 264	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   105: if_icmpge +36 -> 141
    //   108: aload_1
    //   109: aload_0
    //   110: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   113: iload_2
    //   114: invokevirtual 267	java/util/concurrent/CopyOnWriteArrayList:get	(I)Ljava/lang/Object;
    //   117: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   120: getfield 119	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   123: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   126: ifeq +195 -> 321
    //   129: aload_0
    //   130: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   133: iload_2
    //   134: invokevirtual 506	java/util/concurrent/CopyOnWriteArrayList:remove	(I)Ljava/lang/Object;
    //   137: pop
    //   138: goto +183 -> 321
    //   141: aload 7
    //   143: ifnull +167 -> 310
    //   146: new 717	com/tencent/mobileqq/app/HotChatCenterManager$2
    //   149: dup
    //   150: aload_0
    //   151: aload 5
    //   153: aload 7
    //   155: invokespecial 720	com/tencent/mobileqq/app/HotChatCenterManager$2:<init>	(Lanwa;Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/data/HotChatItemData;)V
    //   158: bipush 8
    //   160: aconst_null
    //   161: iconst_0
    //   162: invokestatic 520	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   165: aload_0
    //   166: aload_1
    //   167: aload 6
    //   169: invokespecial 722	anwa:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   172: iload 4
    //   174: istore_3
    //   175: aload_0
    //   176: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   179: invokevirtual 264	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   182: ifne +39 -> 221
    //   185: iload 4
    //   187: istore_3
    //   188: aload_0
    //   189: getstatic 623	com/tencent/mobileqq/app/AppConstants:HOTCHAT_CENTER_UIN	Ljava/lang/String;
    //   192: sipush 5001
    //   195: invokespecial 567	anwa:b	(Ljava/lang/String;I)V
    //   198: iload 4
    //   200: istore_3
    //   201: aload_0
    //   202: invokevirtual 337	anwa:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   205: ldc 181
    //   207: ldc 183
    //   209: ldc_w 724
    //   212: iconst_1
    //   213: iconst_0
    //   214: iconst_0
    //   215: anewarray 187	java/lang/String
    //   218: invokestatic 207	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   221: aload 5
    //   223: ifnull +84 -> 307
    //   226: aload 5
    //   228: invokevirtual 514	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   231: iload 4
    //   233: ireturn
    //   234: astore_1
    //   235: aconst_null
    //   236: astore_1
    //   237: iconst_0
    //   238: istore_3
    //   239: ldc 25
    //   241: iconst_1
    //   242: ldc 192
    //   244: invokestatic 726	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: iload_3
    //   248: istore 4
    //   250: aload_1
    //   251: ifnull -225 -> 26
    //   254: aload_1
    //   255: invokevirtual 514	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   258: iload_3
    //   259: ireturn
    //   260: astore_1
    //   261: aconst_null
    //   262: astore 5
    //   264: aload 5
    //   266: ifnull +8 -> 274
    //   269: aload 5
    //   271: invokevirtual 514	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   274: aload_1
    //   275: athrow
    //   276: astore_1
    //   277: goto -13 -> 264
    //   280: astore 6
    //   282: aload_1
    //   283: astore 5
    //   285: aload 6
    //   287: astore_1
    //   288: goto -24 -> 264
    //   291: astore_1
    //   292: aload 5
    //   294: astore_1
    //   295: iconst_0
    //   296: istore_3
    //   297: goto -58 -> 239
    //   300: astore_1
    //   301: aload 5
    //   303: astore_1
    //   304: goto -65 -> 239
    //   307: iload 4
    //   309: ireturn
    //   310: iconst_0
    //   311: istore 4
    //   313: goto -141 -> 172
    //   316: iconst_0
    //   317: istore_2
    //   318: goto -221 -> 97
    //   321: iload_2
    //   322: iconst_1
    //   323: iadd
    //   324: istore_2
    //   325: goto -228 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	anwa
    //   0	328	1	paramString	String
    //   97	228	2	i	int
    //   1	296	3	bool1	boolean
    //   3	309	4	bool2	boolean
    //   37	265	5	localObject1	Object
    //   9	159	6	localQQAppInterface	QQAppInterface
    //   280	6	6	localObject2	Object
    //   52	102	7	localHotChatItemData	HotChatItemData
    // Exception table:
    //   from	to	target	type
    //   29	39	234	java/lang/Throwable
    //   29	39	260	finally
    //   39	94	276	finally
    //   97	138	276	finally
    //   146	165	276	finally
    //   165	172	276	finally
    //   175	185	276	finally
    //   188	198	276	finally
    //   201	221	276	finally
    //   239	247	280	finally
    //   39	94	291	java/lang/Throwable
    //   97	138	291	java/lang/Throwable
    //   146	165	291	java/lang/Throwable
    //   165	172	300	java/lang/Throwable
    //   175	185	300	java/lang/Throwable
    //   188	198	300	java/lang/Throwable
    //   201	221	300	java/lang/Throwable
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   9: invokevirtual 264	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   12: ifle +4 -> 16
    //   15: return
    //   16: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +31 -> 50
    //   22: ldc 25
    //   24: iconst_2
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: ldc_w 728
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: invokestatic 537	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   40: invokevirtual 540	java/lang/Thread:getId	()J
    //   43: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   46: aastore
    //   47: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   50: aload_0
    //   51: invokevirtual 337	anwa:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull -41 -> 15
    //   59: aload_2
    //   60: invokevirtual 489	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   63: invokevirtual 495	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   66: astore_2
    //   67: aload_2
    //   68: ldc 114
    //   70: iconst_0
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: ldc_w 730
    //   78: aconst_null
    //   79: invokevirtual 734	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +276 -> 360
    //   87: aload_1
    //   88: invokeinterface 375 1 0
    //   93: ifle +267 -> 360
    //   96: aload_1
    //   97: checkcast 371	java/util/ArrayList
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 735	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 249 1 0
    //   112: ifeq +50 -> 162
    //   115: aload_3
    //   116: invokeinterface 253 1 0
    //   121: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   124: astore 4
    //   126: aload_0
    //   127: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   130: aload 4
    //   132: invokevirtual 465	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -30 -> 106
    //   139: astore_3
    //   140: aload_2
    //   141: astore_1
    //   142: ldc 25
    //   144: iconst_1
    //   145: aload_3
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 387	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: ifnull -139 -> 15
    //   157: aload_2
    //   158: invokevirtual 514	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   161: return
    //   162: aload_0
    //   163: invokespecial 713	anwa:f	()V
    //   166: aload_0
    //   167: getfield 56	anwa:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   170: invokeinterface 736 1 0
    //   175: aload_1
    //   176: invokevirtual 735	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   179: astore_1
    //   180: aload_1
    //   181: invokeinterface 249 1 0
    //   186: ifeq +46 -> 232
    //   189: aload_1
    //   190: invokeinterface 253 1 0
    //   195: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   198: astore_3
    //   199: aload_0
    //   200: getfield 56	anwa:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   203: aload_3
    //   204: getfield 119	com/tencent/mobileqq/data/HotChatItemData:mTroopUin	Ljava/lang/String;
    //   207: aload_3
    //   208: invokeinterface 237 3 0
    //   213: pop
    //   214: goto -34 -> 180
    //   217: astore_1
    //   218: aload_2
    //   219: astore_3
    //   220: aload_1
    //   221: astore_2
    //   222: aload_3
    //   223: ifnull +7 -> 230
    //   226: aload_3
    //   227: invokevirtual 514	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   230: aload_2
    //   231: athrow
    //   232: aload_0
    //   233: invokespecial 738	anwa:g	()V
    //   236: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +121 -> 360
    //   242: ldc 25
    //   244: iconst_2
    //   245: new 189	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 740
    //   255: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   262: invokevirtual 264	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   265: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: getfield 45	anwa:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   278: invokevirtual 244	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   281: astore_1
    //   282: aload_1
    //   283: invokeinterface 249 1 0
    //   288: ifeq +72 -> 360
    //   291: aload_1
    //   292: invokeinterface 253 1 0
    //   297: checkcast 114	com/tencent/mobileqq/data/HotChatItemData
    //   300: astore_3
    //   301: ldc 25
    //   303: iconst_2
    //   304: bipush 6
    //   306: anewarray 4	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: ldc_w 742
    //   314: aastore
    //   315: dup
    //   316: iconst_1
    //   317: aload_3
    //   318: getfield 161	com/tencent/mobileqq/data/HotChatItemData:mGameId	I
    //   321: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: aastore
    //   325: dup
    //   326: iconst_2
    //   327: ldc_w 657
    //   330: aastore
    //   331: dup
    //   332: iconst_3
    //   333: aload_3
    //   334: getfield 700	com/tencent/mobileqq/data/HotChatItemData:mState	I
    //   337: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: dup
    //   342: iconst_4
    //   343: ldc_w 744
    //   346: aastore
    //   347: dup
    //   348: iconst_5
    //   349: aload_3
    //   350: getfield 142	com/tencent/mobileqq/data/HotChatItemData:mHotChatCode	Ljava/lang/String;
    //   353: aastore
    //   354: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   357: goto -75 -> 282
    //   360: aload_2
    //   361: ifnull -346 -> 15
    //   364: aload_2
    //   365: invokevirtual 514	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   368: return
    //   369: astore_2
    //   370: aload_1
    //   371: astore_3
    //   372: goto -150 -> 222
    //   375: astore_3
    //   376: aload 4
    //   378: astore_2
    //   379: goto -239 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	this	anwa
    //   1	189	1	localObject1	Object
    //   217	4	1	localObject2	Object
    //   281	90	1	localIterator1	Iterator
    //   54	311	2	localObject3	Object
    //   369	1	2	localObject4	Object
    //   378	1	2	localHotChatItemData1	HotChatItemData
    //   105	11	3	localIterator2	Iterator
    //   139	7	3	localThrowable1	Throwable
    //   198	174	3	localObject5	Object
    //   375	1	3	localThrowable2	Throwable
    //   3	374	4	localHotChatItemData2	HotChatItemData
    // Exception table:
    //   from	to	target	type
    //   67	83	139	java/lang/Throwable
    //   87	106	139	java/lang/Throwable
    //   106	136	139	java/lang/Throwable
    //   162	180	139	java/lang/Throwable
    //   180	214	139	java/lang/Throwable
    //   232	282	139	java/lang/Throwable
    //   282	357	139	java/lang/Throwable
    //   67	83	217	finally
    //   87	106	217	finally
    //   106	136	217	finally
    //   162	180	217	finally
    //   180	214	217	finally
    //   232	282	217	finally
    //   282	357	217	finally
    //   59	67	369	finally
    //   142	153	369	finally
    //   59	67	375	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    QLog.i("HotChatCenterManager", 1, "destroy HotChatFolderManager.");
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwa
 * JD-Core Version:    0.7.0.1
 */