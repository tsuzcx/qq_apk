package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NewFriendMoreInfo;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.newfriend.ContactBindedMessage;
import com.tencent.mobileqq.newfriend.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.MayKnowMessage;
import com.tencent.mobileqq.newfriend.NewFriendBindContactGuideMsg;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.NewFriendMoreInfoMessage;
import com.tencent.mobileqq.newfriend.NewFriendSubTitleMessage;
import com.tencent.mobileqq.newfriend.PhoneContactAddMessage;
import com.tencent.mobileqq.newfriend.QIMFollowMessage;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.manager.Manager;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import zep;
import zeq;
import zes;
import zet;
import zeu;
import zev;
import zew;

public class NewFriendManager
  extends Observable
  implements Handler.Callback, Manager
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new zeq(this);
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private QIMNewFriendManager jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PhoneContactManager.IPhoneContactListener jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = new zes(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator jdField_a_of_type_JavaUtilComparator = new zep(this);
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int d = -1;
  
  public NewFriendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(158));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(10));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager = ((QIMNewFriendManager)paramQQAppInterface.getManager(256));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  private void a(NewFriendMessage paramNewFriendMessage)
  {
    if (!a(paramNewFriendMessage)) {}
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "refreshRecentData | isShouldCreateOrGetRecentUser = true");
      }
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localRecentUserProxy.a(AppConstants.C, 4000);
      if ((localRecentUser.msg == null) || ((localRecentUser.msg instanceof String))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendManager", 2, "wrong ru.msg error | type is :" + localRecentUser.msg.getClass().toString());
    return;
    localRecentUser.msgType = 22;
    localRecentUser.displayName = "新朋友";
    if ((paramNewFriendMessage != null) && ((paramNewFriendMessage instanceof MayKnowMessage)))
    {
      localRecentUser.lastmsgdrafttime = paramNewFriendMessage.jdField_a_of_type_Long;
      localRecentUser.msg = paramNewFriendMessage.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | temp str = " + localRecentUser.msg);
      }
    }
    for (;;)
    {
      if (localRecentUser.msgData == null) {
        localRecentUser.msgData = String.valueOf(localRecentUser.msg).getBytes();
      }
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "refreshRecentData | ru.msg = " + localRecentUser.msg);
      }
      localRecentUserProxy.a(localRecentUser);
      return;
      if ((paramNewFriendMessage != null) && ((paramNewFriendMessage instanceof FriendSystemMessage)) && (!TextUtils.isEmpty(paramNewFriendMessage.jdField_a_of_type_JavaLangString)))
      {
        if (paramNewFriendMessage.jdField_a_of_type_Long > 0L) {
          localRecentUser.lastmsgtime = paramNewFriendMessage.jdField_a_of_type_Long;
        }
        localRecentUser.msg = paramNewFriendMessage.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | ru.lastmsgtime = " + localRecentUser.lastmsgtime);
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    while ((!paramString.equals(AppConstants.C)) && (!paramString.equals(AppConstants.ap)) && (!paramString.equals(AppConstants.K)) && (!paramString.equals(AppConstants.aw))) {
      return false;
    }
    return true;
  }
  
  private boolean a(NewFriendMessage paramNewFriendMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    RecentUserProxy localRecentUserProxy;
    do
    {
      return false;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    } while ((paramNewFriendMessage == null) || (localRecentUserProxy == null) || ((paramNewFriendMessage.a()) && (!localRecentUserProxy.a(AppConstants.C, 4000))));
    return true;
  }
  
  private void h()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = (ArrayList)localEntityManager.a(QIMFollwerAdd.class);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMFollwerAdd localQIMFollwerAdd = (QIMFollwerAdd)((Iterator)localObject).next();
        localQIMFollwerAdd.isRead = true;
        localEntityManager.a(localQIMFollwerAdd);
      }
    }
    localEntityManager.a();
  }
  
  private void i()
  {
    int i = d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new zet(this, i));
  }
  
  private void j()
  {
    NewFriendMessage localNewFriendMessage = a();
    if (localNewFriendMessage != null)
    {
      a(localNewFriendMessage);
      setChanged();
      notifyObservers(localNewFriendMessage);
    }
    for (;;)
    {
      i();
      return;
      c();
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public NewFriendMessage a()
  {
    int j = 0;
    Object localObject = b();
    int i = 0;
    NewFriendMessage localNewFriendMessage1;
    if (i < ((ArrayList)localObject).size())
    {
      localNewFriendMessage1 = (NewFriendMessage)((ArrayList)localObject).get(i);
      if ((localNewFriendMessage1 == null) || (localNewFriendMessage1.a())) {}
    }
    for (;;)
    {
      if ((localNewFriendMessage1 != null) && (!(localNewFriendMessage1 instanceof ContactBindedMessage)) && (!(localNewFriendMessage1 instanceof MayKnowMessage)))
      {
        i = j;
        if (!(localNewFriendMessage1 instanceof ContactMatchMessage)) {
          break label80;
        }
      }
      for (;;)
      {
        return localNewFriendMessage1;
        i += 1;
        break;
        label80:
        NewFriendMessage localNewFriendMessage2;
        do
        {
          i += 1;
          if (i >= ((ArrayList)localObject).size()) {
            break;
          }
          localNewFriendMessage2 = (NewFriendMessage)((ArrayList)localObject).get(i);
        } while ((localNewFriendMessage2 == null) || (localNewFriendMessage2.a()) || ((localNewFriendMessage2 instanceof FriendSystemMessage)));
        while (localNewFriendMessage2 != null)
        {
          localObject = localNewFriendMessage2;
          if (localNewFriendMessage1.jdField_a_of_type_Long >= localNewFriendMessage2.jdField_a_of_type_Long) {
            localObject = localNewFriendMessage1;
          }
          return localObject;
          localNewFriendMessage2 = null;
        }
      }
      localNewFriendMessage1 = null;
    }
  }
  
  public ArrayList a()
  {
    return (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(QIMFollwerAdd.class);
  }
  
  public void a()
  {
    a(true);
    j();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(NewFriendManager.INewFriendListener paramINewFriendListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramINewFriendListener)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramINewFriendListener);
      }
      return;
    }
  }
  
  public void a(QIMFollwerAdd paramQIMFollwerAdd)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().b(paramQIMFollwerAdd);
  }
  
  public void a(FriendSystemMessage paramFriendSystemMessage)
  {
    long l = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.K, 0, l).iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject).next();
    } while ((localMessageRecord.isread) || (!(localMessageRecord instanceof MessageForSystemMsg)));
    for (localObject = new FriendSystemMessage((MessageForSystemMsg)localMessageRecord);; localObject = null)
    {
      if (localObject != null)
      {
        ((FriendSystemMessage)localObject).jdField_a_of_type_Long = paramFriendSystemMessage.jdField_a_of_type_Long;
        ((FriendSystemMessage)localObject).jdField_a_of_type_JavaLangString = paramFriendSystemMessage.jdField_a_of_type_JavaLangString;
        a((NewFriendMessage)localObject);
        setChanged();
        notifyObservers(localObject);
      }
      for (;;)
      {
        i();
        return;
        c();
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      ThreadManager.executeOnFileThread(new zev(this));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "insertCommonHobbyForAIOShowNewMsg" + paramString2);
    }
    long l2 = MessageCache.a() - 60L;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0);
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (!((List)localObject).isEmpty()) {
        l1 = ((ChatMessage)((List)localObject).get(0)).time - 360L;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0, new int[] { -2023 });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
        }
      }
    }
    localObject = MessageRecordFactory.a(-2023);
    ((MessageRecord)localObject).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, paramString2, paramString1, l1, -2023, 0, l1);
    ((MessageRecord)localObject).isread = true;
    if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false))
    {
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 0, paramString1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ArrayList localArrayList1;
    Object localObject6;
    Object localObject7;
    StringBuilder localStringBuilder;
    Object localObject4;
    ArrayList localArrayList2;
    Object localObject5;
    int k;
    int i;
    int j;
    try
    {
      localArrayList1 = new ArrayList();
      localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b();
      localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
      ArrayList localArrayList3 = a();
      localStringBuilder = new StringBuilder(256);
      if (QLog.isColorLevel()) {
        localStringBuilder.append("loadNewFriendMsg");
      }
      if (this.jdField_a_of_type_Boolean) {
        localArrayList1.add(new NewFriendBindContactGuideMsg());
      }
      localObject4 = new ArrayList();
      localArrayList2 = new ArrayList();
      localObject5 = new HashSet();
      k = 0;
      i = 0;
      if (paramBoolean)
      {
        long l = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.K, 0, l);
        localObject1 = new ArrayList(((List)localObject8).size());
        ((List)localObject1).addAll((Collection)localObject8);
      }
      for (;;)
      {
        j = k;
        if (localObject1 == null) {
          break;
        }
        j = k;
        if (((List)localObject1).size() <= 0) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        do
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject8 = (MessageRecord)((Iterator)localObject1).next();
          if (!(localObject8 instanceof MessageForSystemMsg)) {
            break label1883;
          }
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" sys").append(((MessageRecord)localObject8).isread);
          }
          ((MessageForSystemMsg)localObject8).parse();
          if (((MessageForSystemMsg)localObject8).structMsg.msg.sub_type.get() != 13) {
            break label1880;
          }
          ((HashSet)localObject5).add(String.valueOf(((MessageForSystemMsg)localObject8).structMsg.req_uin.get()));
        } while (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(String.valueOf(((MessageForSystemMsg)localObject8).structMsg.req_uin.get())));
        j = i + 1;
        i = j;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" sys").append(((MessageRecord)localObject8).isread);
          i = j;
        }
        label370:
        ((ArrayList)localObject4).add(new FriendSystemMessage((MessageForSystemMsg)localObject8));
        break label1883;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.K, 0);
      }
      Object localObject1 = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216);
      Object localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.a(false);
      if (((ArrayList)localObject8).size() > 0) {
        ((ArrayList)localObject4).addAll((Collection)localObject8);
      }
      if ((((FlashChatManager)localObject1).d()) && (localArrayList3 != null) && (localArrayList3.size() > 0))
      {
        localObject1 = localArrayList3.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((ArrayList)localObject4).add(new QIMFollowMessage((QIMFollwerAdd)((Iterator)localObject1).next()));
        }
      }
      if (localObject7 == null) {
        break label611;
      }
    }
    finally {}
    if (!((ArrayList)localObject7).isEmpty())
    {
      localObject3 = ((ArrayList)((ArrayList)localObject7).clone()).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject7 = (PhoneContactAdd)((Iterator)localObject3).next();
        ((ArrayList)localObject4).add(new PhoneContactAddMessage((PhoneContactAdd)localObject7));
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" pca").append(((PhoneContactAdd)localObject7).unifiedCode);
        }
      }
    }
    label611:
    if (((ArrayList)localObject6).size() > 0)
    {
      localObject3 = ((ArrayList)((ArrayList)localObject6).clone()).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject6 = (MayKnowRecommend)((Iterator)localObject3).next();
        if ((localObject6 != null) && ((localObject6 instanceof PushRecommend)))
        {
          localObject6 = (PushRecommend)localObject6;
          if ((!((HashSet)localObject5).contains(((PushRecommend)localObject6).uin)) && (Math.abs(System.currentTimeMillis() - ((PushRecommend)localObject6).timestamp * 1000L) < 15552000000L))
          {
            localArrayList2.add(new MayKnowMessage((PushRecommend)localObject6));
            if (QLog.isColorLevel()) {
              localStringBuilder.append(" Push").append(((PushRecommend)localObject6).uin).append(((PushRecommend)localObject6).isReaded);
            }
          }
        }
      }
    }
    Object localObject3 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b().clone();
    if (((ArrayList)localObject3).size() > 0)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (Entity)((Iterator)localObject3).next();
        if ((localObject5 instanceof ContactMatch))
        {
          localArrayList2.add(new ContactMatchMessage((ContactMatch)localObject5));
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" cm").append(((ContactMatch)localObject5).mobileNo).append(((ContactMatch)localObject5).isReaded);
          }
        }
        else if ((localObject5 instanceof ContactBinded))
        {
          localArrayList2.add(new ContactBindedMessage((ContactBinded)localObject5));
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" cb").append(((ContactBinded)localObject5).isReaded);
          }
        }
      }
    }
    if (((ArrayList)localObject4).size() > 0)
    {
      Collections.sort((List)localObject4, this.jdField_a_of_type_JavaUtilComparator);
      localObject3 = new NewFriendSubTitle();
      ((NewFriendSubTitle)localObject3).title = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131433308);
      localArrayList1.add(new NewFriendSubTitleMessage((NewFriendSubTitle)localObject3));
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "loadNewFriendMsg|mLastSysMsgTotalCount = " + this.jdField_b_of_type_Int + ",notifyListSize = " + ((ArrayList)localObject4).size() + ", mSysMsgShouldAddMoreInfo = " + this.jdField_b_of_type_Boolean);
      }
      if (localArrayList2.size() != 0) {
        break label1474;
      }
      if (((ArrayList)localObject4).size() <= 100) {
        break label1368;
      }
      i = 0;
      while (i < 100)
      {
        localArrayList1.add(((ArrayList)localObject4).get(i));
        i += 1;
      }
      localObject3 = new NewFriendMoreInfo();
      ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131433309);
      ((NewFriendMoreInfo)localObject3).type = 1000;
      localArrayList1.add(new NewFriendMoreInfoMessage((NewFriendMoreInfo)localObject3));
    }
    for (;;)
    {
      if (localArrayList2.size() > 0)
      {
        this.d = localArrayList1.size();
        Collections.sort(localArrayList2, this.jdField_a_of_type_JavaUtilComparator);
        localObject3 = new NewFriendSubTitle();
        ((NewFriendSubTitle)localObject3).title = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131433311);
        localObject4 = new NewFriendMoreInfo();
        ((NewFriendMoreInfo)localObject4).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131433310);
        ((NewFriendMoreInfo)localObject4).type = 1001;
        localArrayList1.add(new NewFriendSubTitleMessage((NewFriendSubTitle)localObject3));
        localArrayList1.addAll(localArrayList2);
        localArrayList1.add(new NewFriendMoreInfoMessage((NewFriendMoreInfo)localObject4));
      }
      this.jdField_c_of_type_Int = localArrayList2.size();
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" mRecommendSubTitleIndex : ").append(this.d).append(" mRecommendShowCount : ").append(this.jdField_c_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
      return;
      label1368:
      localArrayList1.addAll((Collection)localObject4);
      if (((j % 20 == 0) && (!FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || ((j > 20) && (!FriendSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))))
      {
        localObject3 = new NewFriendMoreInfo();
        ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131433309);
        ((NewFriendMoreInfo)localObject3).type = 1000;
        localArrayList1.add(new NewFriendMoreInfoMessage((NewFriendMoreInfo)localObject3));
      }
    }
    label1474:
    if (this.jdField_b_of_type_Int != ((ArrayList)localObject4).size())
    {
      if (((ArrayList)localObject4).size() > 3)
      {
        i = ((ArrayList)localObject4).size() - 1;
        label1503:
        if ((i >= 0) && (((NewFriendMessage)((ArrayList)localObject4).get(i)).a())) {
          break label1886;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendManager", 2, "loadNewFriendMsg|lastUnReadIndex = " + i);
        }
        k = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (i > 2) {
          break label1893;
        }
        i = 0;
        while (i < 3)
        {
          localArrayList1.add((NewFriendMessage)((ArrayList)localObject4).get(i));
          i += 1;
        }
        this.jdField_a_of_type_Int = 3;
        paramBoolean = true;
        label1607:
        this.jdField_b_of_type_Boolean = paramBoolean;
        if (paramBoolean)
        {
          localObject3 = new NewFriendMoreInfo();
          ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131433309);
          ((NewFriendMoreInfo)localObject3).type = 1000;
          localArrayList1.add(new NewFriendMoreInfoMessage((NewFriendMoreInfo)localObject3));
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = ((ArrayList)localObject4).size();
        break;
        while (j <= i)
        {
          localArrayList1.add((NewFriendMessage)((ArrayList)localObject4).get(j));
          j += 1;
        }
        this.jdField_a_of_type_Int = (i + 1);
        if ((k > 99) || (i + 1 != ((ArrayList)localObject4).size())) {
          break label1875;
        }
        if (FriendSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label1898;
        }
        paramBoolean = true;
        break label1607;
        localArrayList1.addAll((Collection)localObject4);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Int = ((ArrayList)localObject4).size();
      }
    }
    for (;;)
    {
      label1672:
      label1684:
      if (i < this.jdField_a_of_type_Int)
      {
        localArrayList1.add((NewFriendMessage)((ArrayList)localObject4).get(i));
        i += 1;
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label1672;
        }
        localObject3 = new NewFriendMoreInfo();
        ((NewFriendMoreInfo)localObject3).moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131433309);
        ((NewFriendMoreInfo)localObject3).type = 1000;
        localArrayList1.add(new NewFriendMoreInfoMessage((NewFriendMoreInfo)localObject3));
        break label1672;
        label1875:
        paramBoolean = true;
        break label1607;
        label1880:
        break label370;
        label1883:
        break;
        label1886:
        i -= 1;
        break label1503;
        label1893:
        j = 0;
        break label1684;
        label1898:
        paramBoolean = false;
        break label1607;
        i = 0;
      }
    }
  }
  
  public boolean a()
  {
    NewFriendMessage localNewFriendMessage = a();
    return (localNewFriendMessage != null) && (localNewFriendMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashSet.remove(paramString);
      ThreadManager.executeOnFileThread(new zew(this));
      return bool;
    }
  }
  
  public void addObserver(Observer paramObserver)
  {
    super.addObserver(paramObserver);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public ArrayList b()
  {
    return (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
  }
  
  public void b()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      i();
      return;
    }
    ThreadManager.postImmediately(new zeu(this), null, false);
  }
  
  public void b(NewFriendManager.INewFriendListener paramINewFriendListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramINewFriendListener);
      return;
    }
  }
  
  public void b(QIMFollwerAdd paramQIMFollwerAdd)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.b(paramQIMFollwerAdd);
    localEntityManager.a();
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.C();
  }
  
  public boolean b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashSet.contains(paramString);
      return bool;
    }
  }
  
  public int c()
  {
    return FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    do
    {
      return;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localRecentUserProxy.b(AppConstants.C, 4000);
    } while (localRecentUser == null);
    localRecentUserProxy.b(localRecentUser);
  }
  
  public int d()
  {
    int j = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Iterator localIterator = b().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
      if ((localNewFriendMessage == null) || (localNewFriendMessage.a())) {
        break label136;
      }
      if (!(localNewFriendMessage instanceof FriendSystemMessage)) {
        if ((localNewFriendMessage instanceof ContactBindedMessage)) {
          i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a() + i;
        } else {
          i += 1;
        }
      }
    }
    label136:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "getAllUnreadMessageCount|total unread = " + i + ",unReadSysMsgCount = " + j);
      }
      return i + j;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    try
    {
      super.deleteObserver(paramObserver);
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public void g()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "initNewFriendList hasInitNewFriendList: " + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = true;
      ??? = BaseApplicationImpl.getApplication().getSharedPreferences("new_friend", 0).getString("new_friend_list", "");
    } while (TextUtils.isEmpty((CharSequence)???));
    String[] arrayOfString = ((String)???).split("#");
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashSet)
      {
        int j = arrayOfString.length;
        if (i < j)
        {
          if (!TextUtils.isEmpty(arrayOfString[i])) {
            this.jdField_a_of_type_JavaUtilHashSet.add(arrayOfString[i]);
          }
        }
        else {
          return;
        }
      }
      i += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "HandleMessage what=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    case 4: 
    case 6: 
    case 7: 
    default: 
      return true;
    case 1: 
      a(true);
      return true;
    case 2: 
      a();
      return true;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.K, 0, true, true);
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a();
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.f();
      h();
      this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.b();
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
      a();
      return true;
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.K, 0, true, true);
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
      this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.b();
      a();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.f();
    a();
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onDestroy");
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NewFriendManager
 * JD-Core Version:    0.7.0.1
 */