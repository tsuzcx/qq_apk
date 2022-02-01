package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationManager;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationBanner;
import com.tencent.mobileqq.activity.contact.newfriend.msg.ContactBindedMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.MayKnowBannerMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.MayKnowMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendBindContactGuideMsg;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendBindContactGuideMsgV2;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMoreInfoMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendSlideTabMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendSubTitleMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendSysEmptyMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendTabEmptyMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendTabGuideMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendTabInfoMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendVerifyBlockedMsg;
import com.tencent.mobileqq.activity.contact.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.QIMFollowMessage;
import com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeObserver;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.config.business.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.config.business.NewFriendContactGuideConfProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NewFriendMoreInfo;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;>;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class NewFriendManager
  extends Observable
  implements Handler.Callback, Manager
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  NewFriendNotifyPokeObserver jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendPokeNewFriendNotifyPokeObserver = new NewFriendManager.3(this);
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new NewFriendManager.4(this);
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  private QIMNewFriendManager jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public NewFriendContactGuideConfBean a;
  private PhoneContactManager.IPhoneContactListener jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = new NewFriendManager.5(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ArrayList<NewFriendMessage> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<NewFriendMessage> jdField_a_of_type_JavaUtilComparator = new NewFriendManager.1(this);
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<NewFriendManager.INewFriendListener> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private ConcurrentHashMap<Long, SysSuspiciousMsg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
  public boolean a;
  private int jdField_b_of_type_Int;
  ArrayList<FriendSystemMessage> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<SysSuspiciousMsg> jdField_b_of_type_JavaUtilComparator = new NewFriendManager.2(this);
  public boolean b;
  private int jdField_c_of_type_Int;
  private Comparator<Object> jdField_c_of_type_JavaUtilComparator = new NewFriendManager.8(this);
  public boolean c;
  private int d;
  public boolean d;
  private volatile int e;
  public boolean e;
  private boolean f;
  private volatile boolean g = true;
  private volatile boolean h = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131707493);
  }
  
  public NewFriendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessNewFriendContactGuideConfBean = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager = ((QIMNewFriendManager)paramQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendPokeNewFriendNotifyPokeObserver);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private int a(boolean paramBoolean, StringBuilder paramStringBuilder, ArrayList<NewFriendMessage> paramArrayList, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      long l = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l);
      localObject1 = new ArrayList(((List)localObject2).size());
      ((List)localObject1).addAll((Collection)localObject2);
    }
    int i;
    for (;;)
    {
      i = paramInt;
      if (localObject1 == null) {
        break;
      }
      i = paramInt;
      if (((List)localObject1).size() <= 0) {
        break;
      }
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        i = paramInt;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForSystemMsg))
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder.append(" sys").append(((MessageRecord)localObject2).isread);
          }
          ((MessageForSystemMsg)localObject2).parse();
          i = paramInt;
          if (((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get() == 13)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(String.valueOf(((MessageForSystemMsg)localObject2).structMsg.req_uin.get()))) {
              continue;
            }
            paramInt += 1;
            i = paramInt;
            if (QLog.isColorLevel())
            {
              paramStringBuilder.append(" sys").append(((MessageRecord)localObject2).isread);
              i = paramInt;
            }
          }
          paramArrayList.add(new FriendSystemMessage((MessageForSystemMsg)localObject2));
          paramInt = i;
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
    }
    return i;
  }
  
  private ArrayList<ConnectionsTabInfo> a(int paramInt, boolean paramBoolean1, ArrayList<NewFriendMessage> paramArrayList, StringBuilder paramStringBuilder, boolean paramBoolean2, ArrayList<MayKnowRecommend> paramArrayList1, ArrayList<ConnectionsTabInfo> paramArrayList2, boolean paramBoolean3)
  {
    Object localObject;
    if (paramBoolean3)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a();
      paramArrayList2 = (ArrayList<ConnectionsTabInfo>)localObject;
      if (localObject != null)
      {
        paramArrayList2 = (ArrayList<ConnectionsTabInfo>)localObject;
        if (!((ArrayList)localObject).isEmpty())
        {
          ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(paramInt);
          paramArrayList2 = (ArrayList<ConnectionsTabInfo>)localObject;
          if (localArrayList != null)
          {
            paramArrayList1.addAll(localArrayList);
            paramArrayList2 = (ArrayList<ConnectionsTabInfo>)localObject;
          }
        }
      }
    }
    if ((paramBoolean1) || (paramBoolean2)) {}
    for (paramInt = 1; (paramArrayList1 != null) && (paramArrayList1.size() > 0) && (paramInt != 0); paramInt = 0)
    {
      localObject = new ArrayList(paramArrayList1.size());
      ((ArrayList)localObject).addAll(paramArrayList1);
      paramArrayList1 = ((ArrayList)localObject).iterator();
      while (paramArrayList1.hasNext())
      {
        localObject = (MayKnowRecommend)paramArrayList1.next();
        if ((localObject != null) && ((localObject instanceof MayKnowRecommend)))
        {
          paramArrayList.add(new MayKnowMessage((MayKnowRecommend)localObject));
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("mk uin:").append(((MayKnowRecommend)localObject).uin).append(" reason:").append(((MayKnowRecommend)localObject).recommendReason);
          }
        }
      }
    }
    return paramArrayList2;
  }
  
  private ArrayList<Entity> a(boolean paramBoolean1, ArrayList<NewFriendMessage> paramArrayList, StringBuilder paramStringBuilder, ArrayList<ConnectionsTabInfo> paramArrayList1, boolean paramBoolean2, ArrayList<Entity> paramArrayList2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b().clone();
      paramArrayList2 = null;
      Object localObject;
      if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty()))
      {
        localObject = paramArrayList1.iterator();
        for (paramArrayList1 = paramArrayList2; ((Iterator)localObject).hasNext(); paramArrayList1 = paramArrayList2)
        {
          paramArrayList2 = (ConnectionsTabInfo)((Iterator)localObject).next();
          if (!paramBoolean1) {
            break label355;
          }
        }
      }
      for (;;)
      {
        if ((paramArrayList1 != null) && (QLog.isColorLevel())) {
          QLog.d("NewFriendManager", 2, "loadNewFriendMsg init defaultTabInfo.recommend_count = " + paramArrayList1.jdField_b_of_type_Int);
        }
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          paramArrayList2 = localArrayList.iterator();
          while (paramArrayList2.hasNext())
          {
            localObject = (Entity)paramArrayList2.next();
            if ((localObject instanceof ContactMatch))
            {
              if (paramBoolean2) {
                paramArrayList.add(new ContactMatchMessage((ContactMatch)localObject));
              }
              if (paramArrayList1 != null) {
                paramArrayList1.jdField_b_of_type_Int += 1;
              }
              if (QLog.isColorLevel()) {
                paramStringBuilder.append(" cm").append(((ContactMatch)localObject).mobileNo).append(((ContactMatch)localObject).isReaded);
              }
            }
            else if ((localObject instanceof ContactBinded))
            {
              if (paramBoolean2) {
                paramArrayList.add(new ContactBindedMessage((ContactBinded)localObject));
              }
              if (QLog.isColorLevel()) {
                paramStringBuilder.append(" cb").append(((ContactBinded)localObject).isReaded);
              }
            }
          }
          if ((paramArrayList1 != null) && (QLog.isColorLevel())) {
            QLog.d("NewFriendManager", 2, "loadNewFriendMsg result defaultTabInfo.recommend_count = " + paramArrayList1.jdField_b_of_type_Int);
          }
        }
        return localArrayList;
        label355:
        break;
        paramArrayList1 = null;
      }
    }
    return paramArrayList2;
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
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      localRecentUser = localRecentUserProxy.a(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
      if ((localRecentUser.msg == null) || ((localRecentUser.msg instanceof String))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendManager", 2, "wrong ru.msg error | type is :" + localRecentUser.msg.getClass().toString());
    return;
    localRecentUser.msgType = 26;
    localRecentUser.displayName = jdField_a_of_type_JavaLangString;
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
      localRecentUserProxy.b(localRecentUser);
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
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "insertMsgForAIOShowNewsMsg" + paramString2 + ",msgType:" + paramInt);
    }
    long l2 = MessageCache.a() - 60L;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString2, 0);
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (!((List)localObject).isEmpty()) {
        l1 = ((ChatMessage)((List)localObject).get(0)).time - 360L;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString2, 0, new int[] { paramInt });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
        }
      }
    }
    localObject = MessageRecordFactory.a(paramInt);
    ((MessageRecord)localObject).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, paramString2, paramString1, l1, paramInt, 0, l1);
    ((MessageRecord)localObject).isread = true;
    if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false))
    {
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString2, 0, paramString1);
    }
  }
  
  private void a(ArrayList<NewFriendMessage> paramArrayList)
  {
    int i;
    if (QLog.isColorLevel())
    {
      Iterator localIterator = paramArrayList.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
        if ((localNewFriendMessage == null) || (localNewFriendMessage.a()) || (!(localNewFriendMessage instanceof FriendSystemMessage))) {
          break label102;
        }
        i += 1;
      }
    }
    label102:
    for (;;)
    {
      break;
      QLog.d("NewFriendManager", 2, "loadNewFriendMsg size = " + paramArrayList.size() + ",unReadSysMsgCountInCache = " + i);
      return;
    }
  }
  
  private void a(ArrayList<NewFriendMessage> paramArrayList, int paramInt)
  {
    String str = "";
    if (paramInt == 1)
    {
      str = NewFriendVerificationManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).jdField_a_of_type_JavaLangString;
      paramArrayList.add(new NewFriendVerifyBlockedMsg(str));
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendVerification.manager", 2, "ui.loadNewFriendMsg, type=" + paramInt + ",blockedUin=" + str);
    }
  }
  
  private void a(ArrayList<NewFriendMessage> paramArrayList, PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramArrayList.add(new NewFriendBindContactGuideMsg());
    }
    while ((!this.jdField_c_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (!paramPhoneContactManagerImp.n()))) {
      return;
    }
    paramArrayList.add(new NewFriendBindContactGuideMsgV2(a(), this.jdField_b_of_type_Boolean));
  }
  
  private void a(ArrayList<NewFriendMessage> paramArrayList1, ArrayList<NewFriendMessage> paramArrayList2)
  {
    boolean bool2 = true;
    int j = 0;
    if (paramArrayList2.size() > 3)
    {
      int i = paramArrayList2.size() - 1;
      int k;
      for (;;)
      {
        if ((i < 0) || (!((NewFriendMessage)paramArrayList2.get(i)).a()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("NewFriendManager", 2, "loadNewFriendMsg|lastUnReadIndex = " + i);
          }
          k = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (i > 2) {
            break label196;
          }
          i = j;
          while (i < 3)
          {
            paramArrayList1.add((NewFriendMessage)paramArrayList2.get(i));
            i += 1;
          }
        }
        i -= 1;
      }
      this.jdField_a_of_type_Int = 3;
      boolean bool1 = bool2;
      label196:
      do
      {
        do
        {
          this.f = bool1;
          if (bool1)
          {
            paramArrayList2 = new NewFriendMoreInfo();
            paramArrayList2.moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694473);
            paramArrayList2.type = 1000;
            paramArrayList1.add(new NewFriendMoreInfoMessage(paramArrayList2));
          }
          return;
          j = 0;
          while (j <= i)
          {
            paramArrayList1.add((NewFriendMessage)paramArrayList2.get(j));
            j += 1;
          }
          this.jdField_a_of_type_Int = (i + 1);
          bool1 = bool2;
        } while (k > 99);
        bool1 = bool2;
      } while (i + 1 != paramArrayList2.size());
      if (!FriendSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
    }
    paramArrayList1.addAll(paramArrayList2);
    this.f = false;
    this.jdField_a_of_type_Int = paramArrayList2.size();
  }
  
  private void a(ArrayList<NewFriendMessage> paramArrayList1, ArrayList<NewFriendMessage> paramArrayList2, int paramInt1, ArrayList<ConnectionsTabInfo> paramArrayList, boolean paramBoolean, ArrayList<Entity> paramArrayList3, int paramInt2)
  {
    int j = 0;
    int i = 0;
    if (paramArrayList2.size() > 0)
    {
      Collections.sort(paramArrayList2, this.jdField_a_of_type_JavaUtilComparator);
      NewFriendSubTitle localNewFriendSubTitle = new NewFriendSubTitle();
      localNewFriendSubTitle.title = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694479);
      boolean bool;
      if (paramInt2 == 3)
      {
        bool = true;
        localNewFriendSubTitle.showEntrance = bool;
        paramArrayList1.add(new NewFriendSubTitleMessage(localNewFriendSubTitle));
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendManager", 2, "loadNewFriendMsg|mLastSysMsgTotalCount = " + this.jdField_b_of_type_Int + ",notifyListSize = " + paramArrayList2.size() + ", mSysMsgShouldAddMoreInfo = " + this.f);
        }
        if (((!this.jdField_b_of_type_Boolean) || (paramArrayList3 == null) || (paramArrayList3.size() <= 0)) && (!paramBoolean) && ((paramArrayList == null) || (paramArrayList.isEmpty()))) {
          break label312;
        }
        paramInt1 = i;
        if (this.jdField_b_of_type_Int == paramArrayList2.size()) {
          break label219;
        }
        a(paramArrayList1, paramArrayList2);
        label204:
        this.jdField_b_of_type_Int = paramArrayList2.size();
      }
      label219:
      do
      {
        return;
        bool = false;
        break;
        while (paramInt1 < this.jdField_a_of_type_Int)
        {
          paramArrayList1.add((NewFriendMessage)paramArrayList2.get(paramInt1));
          paramInt1 += 1;
        }
        if (!this.f) {
          break label204;
        }
        paramArrayList = new NewFriendMoreInfo();
        paramArrayList.moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694473);
        paramArrayList.type = 1000;
        paramArrayList1.add(new NewFriendMoreInfoMessage(paramArrayList));
        break label204;
        if (paramArrayList2.size() > 100)
        {
          paramInt1 = j;
          while (paramInt1 < 100)
          {
            paramArrayList1.add(paramArrayList2.get(paramInt1));
            paramInt1 += 1;
          }
          paramArrayList2 = new NewFriendMoreInfo();
          paramArrayList2.moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694473);
          paramArrayList2.type = 1000;
          paramArrayList1.add(new NewFriendMoreInfoMessage(paramArrayList2));
          return;
        }
        paramArrayList1.addAll(paramArrayList2);
      } while (((paramInt1 % 20 != 0) || (FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) && ((paramInt1 <= 20) || (FriendSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))));
      label312:
      paramArrayList2 = new NewFriendMoreInfo();
      paramArrayList2.moreInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694473);
      paramArrayList2.type = 1000;
      paramArrayList1.add(new NewFriendMoreInfoMessage(paramArrayList2));
      return;
    }
    paramArrayList1.add(new NewFriendSysEmptyMessage());
  }
  
  private void a(ArrayList<QIMFollwerAdd> paramArrayList, ArrayList<NewFriendMessage> paramArrayList1, FlashChatManager paramFlashChatManager)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.a(false);
    if (localArrayList.size() > 0) {
      paramArrayList1.addAll(localArrayList);
    }
    if ((paramFlashChatManager.b()) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        paramArrayList1.add(new QIMFollowMessage((QIMFollwerAdd)paramArrayList.next()));
      }
    }
  }
  
  private void a(ArrayList<PhoneContactAdd> paramArrayList, ArrayList<NewFriendMessage> paramArrayList1, StringBuilder paramStringBuilder)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramArrayList = ((ArrayList)paramArrayList.clone()).iterator();
      while (paramArrayList.hasNext())
      {
        PhoneContactAdd localPhoneContactAdd = (PhoneContactAdd)paramArrayList.next();
        paramArrayList1.add(new PhoneContactAddMessage(localPhoneContactAdd));
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" pca").append(localPhoneContactAdd.unifiedCode);
        }
      }
    }
  }
  
  private void a(ArrayList<NewFriendMessage> paramArrayList1, boolean paramBoolean1, ArrayList<NewFriendMessage> paramArrayList2, StringBuilder paramStringBuilder, ArrayList<MayKnowRecommend> paramArrayList, boolean paramBoolean2)
  {
    if (paramArrayList2.size() > 0)
    {
      this.jdField_d_of_type_Int = paramArrayList1.size();
      Collections.sort(paramArrayList2, this.jdField_a_of_type_JavaUtilComparator);
      if ((paramBoolean2) && (paramBoolean1)) {
        b(paramArrayList, paramArrayList2);
      }
      paramArrayList1.addAll(paramArrayList2);
    }
    this.jdField_c_of_type_Int = paramArrayList2.size();
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append(" mRecommendSubTitleIndex : ").append(this.jdField_d_of_type_Int).append(" mRecommendShowCount : ").append(this.jdField_c_of_type_Int).append(" shouldShowNewFriendMayknow:").append(paramBoolean2);
      QLog.d("NewFriendManager", 2, paramStringBuilder.toString());
    }
  }
  
  private void a(ArrayList<NewFriendMessage> paramArrayList1, boolean paramBoolean1, ArrayList<NewFriendMessage> paramArrayList2, boolean paramBoolean2, ArrayList<ConnectionsTabInfo> paramArrayList, boolean paramBoolean3)
  {
    if ((paramBoolean3) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
      if (paramArrayList.size() > 1)
      {
        paramBoolean3 = true;
        paramArrayList1.add(new NewFriendTabInfoMessage(paramArrayList, paramBoolean3));
        if (paramArrayList.size() > 1) {
          paramArrayList1.add(new NewFriendSlideTabMessage(paramArrayList));
        }
        if (!paramBoolean1) {
          break label99;
        }
        if (paramArrayList2.size() == 0) {
          paramArrayList1.add(new NewFriendTabEmptyMessage());
        }
      }
    }
    label99:
    while (paramArrayList2.size() <= 0)
    {
      do
      {
        for (;;)
        {
          return;
          paramBoolean3 = false;
        }
        if (!paramBoolean2) {
          break;
        }
      } while (paramArrayList2.size() != 0);
      paramArrayList1.add(new NewFriendTabEmptyMessage());
      return;
      paramArrayList1.add(new NewFriendTabGuideMessage());
      return;
    }
    paramArrayList2 = new NewFriendSubTitle();
    paramArrayList2.title = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131689662);
    paramArrayList1.add(new NewFriendSubTitleMessage(paramArrayList2));
  }
  
  private boolean a(NewFriendMessage paramNewFriendMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    RecentUserProxy localRecentUserProxy;
    do
    {
      return false;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    } while ((paramNewFriendMessage == null) || (localRecentUserProxy == null) || ((paramNewFriendMessage.a()) && (!localRecentUserProxy.a(AppConstants.RECOMMEND_CONTACT_UIN, 4000))));
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    while ((!paramString.equals(AppConstants.RECOMMEND_CONTACT_UIN)) && (!paramString.equals(AppConstants.MAYKNOW_RECOMMEND_UIN)) && (!paramString.equals(AppConstants.FRIEND_SYSTEM_MSG_UIN)) && (!paramString.equals(AppConstants.FRIEND_ANNIVER_UIN))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.msgData == null)) {
      return false;
    }
    try
    {
      boolean bool = FriendSystemMessage.a(MessageForSystemMsg.parseStructMsg(paramMessageRecord.msgData));
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("NewFriendManager", 2, paramMessageRecord, new Object[0]);
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, 0, new int[] { paramInt });
    return (paramString != null) && (paramString.size() > 0);
  }
  
  private void b(ArrayList<MayKnowRecommend> paramArrayList, ArrayList<NewFriendMessage> paramArrayList1)
  {
    if (paramArrayList1 == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localArrayList = ((BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a();
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "loadNewFriendMsg|card.strSchool = " + ((Card)localObject).strSchool + "schoolInfos =" + localArrayList);
      }
    } while ((!TextUtils.isEmpty(((Card)localObject).strSchool)) || ((localArrayList != null) && (!localArrayList.isEmpty())) || (paramArrayList == null) || (paramArrayList.size() <= 0));
    Object localObject = new ConnectsExplorationBanner();
    ((ConnectsExplorationBanner)localObject).setBanner(true);
    localObject = new MayKnowBannerMessage((ConnectsExplorationBanner)localObject);
    if (paramArrayList.size() <= 4)
    {
      paramArrayList1.add(localObject);
      return;
    }
    paramArrayList1.add(4, localObject);
  }
  
  private boolean b()
  {
    return !((CTEntryMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).c();
  }
  
  private ArrayList<FriendSystemMessage> c()
  {
    return (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
  }
  
  private ArrayList<FriendSystemMessage> d()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB start,old unReadNewFriendSystemMsg.size() = " + this.jdField_b_of_type_JavaUtilArrayList.size());
        }
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
            if (!(localMessageRecord instanceof MessageForSystemMsg)) {
              continue;
            }
            ((MessageForSystemMsg)localMessageRecord).parse();
            if (((((MessageForSystemMsg)localMessageRecord).structMsg.msg.sub_type.get() == 13) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(String.valueOf(((MessageForSystemMsg)localMessageRecord).structMsg.req_uin.get())))) || (localMessageRecord.isread)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB add a msg,mr.senderuin = " + localMessageRecord.senderuin + ",mr.time = " + localMessageRecord.time);
            }
            if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
              break label367;
            }
            Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            if (!localIterator.hasNext()) {
              break label367;
            }
            FriendSystemMessage localFriendSystemMessage = (FriendSystemMessage)localIterator.next();
            if ((localFriendSystemMessage.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg == null) || (!localFriendSystemMessage.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.senderuin.equals(localMessageRecord.senderuin))) {
              continue;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(new FriendSystemMessage((MessageForSystemMsg)localMessageRecord));
            continue;
          }
        }
        if (!QLog.isColorLevel()) {
          break label358;
        }
      }
      finally {}
      QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB size = " + this.jdField_b_of_type_JavaUtilArrayList.size());
      label358:
      ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
      return localArrayList;
      label367:
      int i = 0;
    }
  }
  
  private void m()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = (ArrayList)localEntityManager.query(QIMFollwerAdd.class);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMFollwerAdd localQIMFollwerAdd = (QIMFollwerAdd)((Iterator)localObject).next();
        localQIMFollwerAdd.isRead = true;
        localEntityManager.update(localQIMFollwerAdd);
      }
    }
    localEntityManager.close();
  }
  
  private void n()
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
      c();
      return;
      e();
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
  
  public NewFriendContactGuideConfBean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessNewFriendContactGuideConfBean == null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessNewFriendContactGuideConfBean = NewFriendContactGuideConfProcessor.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessNewFriendContactGuideConfBean;
  }
  
  public ArrayList<QIMFollwerAdd> a()
  {
    return (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().query(QIMFollwerAdd.class);
  }
  
  public List<Object> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b().iterator();
    int i = 0;
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (NewFriendMessage)localIterator.next();
      if ((localObject != null) && (!((NewFriendMessage)localObject).a())) {
        if ((localObject instanceof FriendSystemMessage))
        {
          i += 1;
        }
        else if ((localObject instanceof ContactBindedMessage))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.c();
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            localArrayList.addAll((Collection)localObject);
          }
        }
        else if ((localObject instanceof ContactMatchMessage))
        {
          localArrayList.add(localObject);
        }
        else
        {
          localArrayList.add(localObject);
          QLog.d("NewFriendManager", 1, "getAllUnreadMsg unexpected nfm = " + localObject);
        }
      }
    }
    localArrayList.addAll(c());
    if (localArrayList.size() > 0) {}
    try
    {
      Collections.sort(localArrayList, this.jdField_c_of_type_JavaUtilComparator);
      if (QLog.isColorLevel())
      {
        QLog.d("NewFriendManager", 2, "getAllUnreadMsg size = " + localArrayList.size() + ",unReadSysMsgCountInCache = " + i);
        if (localArrayList.size() > 0)
        {
          localIterator = localArrayList.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return localArrayList;
            }
            localObject = localIterator.next();
            if (!(localObject instanceof PhoneContact)) {
              break;
            }
            QLog.d("NewFriendManager", 2, "getAllUnreadMsg PhoneContact time  = " + ((PhoneContact)localObject).lastScanTime);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("NewFriendManager", 1, "getAllUnreadMsg sort exception ", localException);
        continue;
        if ((localObject instanceof FriendSystemMessage)) {
          QLog.d("NewFriendManager", 2, "getAllUnreadMsg FriendSystemMessage time  = " + ((FriendSystemMessage)localObject).jdField_a_of_type_Long * 1000L);
        } else if ((localObject instanceof ContactMatchMessage)) {
          QLog.d("NewFriendManager", 2, "getAllUnreadMsg ContactMatchMessage time  = " + ((ContactMatchMessage)localObject).jdField_a_of_type_Long * 1000L);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("contact_guide_user_close", true).putInt("new_friend_show_count_after_user_close", 0).apply();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    SysSuspiciousMsg localSysSuspiciousMsg = (SysSuspiciousMsg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()))
    {
      if (localSysSuspiciousMsg != null) {
        break label115;
      }
      localSysSuspiciousMsg = (SysSuspiciousMsg)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(SysSuspiciousMsg.class, paramLong);
    }
    label115:
    for (;;)
    {
      boolean bool = false;
      if (localSysSuspiciousMsg != null) {
        bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localSysSuspiciousMsg);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "deleteSysSuspiciousMsg " + paramLong + " " + bool);
      }
      return;
    }
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
  
  public void a(FriendSystemMessage paramFriendSystemMessage)
  {
    long l = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l).iterator();
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
        c();
        return;
        e();
      }
    }
  }
  
  public void a(QIMFollwerAdd paramQIMFollwerAdd)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().remove(paramQIMFollwerAdd);
  }
  
  public void a(SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    if ((paramSysSuspiciousMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()))
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramSysSuspiciousMsg);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramSysSuspiciousMsg.uin), paramSysSuspiciousMsg);
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "updateOrInsertSysSuspiciousMsg " + paramSysSuspiciousMsg.uin + " " + paramSysSuspiciousMsg.time);
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
      paramString = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      if (localIterator.hasNext())
      {
        paramString.append((String)localIterator.next());
        paramString.append("#");
      }
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("new_friend", 0).edit().putString("new_friend_list", paramString.toString()).apply();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!a(paramString2, -2023)) {
      a(paramString1, paramString2, -2015);
    }
  }
  
  public void a(ArrayList<SysSuspiciousMsg> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "updateSuspiciousMsgListFromServer " + paramBoolean + " " + paramArrayList.size() + " " + paramArrayList.toString());
      }
      Object localObject = b();
      int i;
      if (localObject != null)
      {
        i = paramArrayList.size();
        if ((i == 0) && (paramBoolean)) {
          l();
        }
      }
      for (;;)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          a((SysSuspiciousMsg)paramArrayList.next());
        }
        if (i > 0)
        {
          Collections.sort(paramArrayList, this.jdField_b_of_type_JavaUtilComparator);
          SysSuspiciousMsg localSysSuspiciousMsg1 = (SysSuspiciousMsg)paramArrayList.get(0);
          SysSuspiciousMsg localSysSuspiciousMsg2 = (SysSuspiciousMsg)paramArrayList.get(paramArrayList.size() - 1);
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            SysSuspiciousMsg localSysSuspiciousMsg3 = (SysSuspiciousMsg)((Iterator)localObject).next();
            if (!paramBoolean)
            {
              if ((localSysSuspiciousMsg3.time <= localSysSuspiciousMsg1.time) && (localSysSuspiciousMsg3.time >= localSysSuspiciousMsg2.time)) {
                a(localSysSuspiciousMsg3.uin);
              }
            }
            else if (localSysSuspiciousMsg3.time <= localSysSuspiciousMsg1.time) {
              a(localSysSuspiciousMsg3.uin);
            }
          }
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("NewFriendManager", 2, "updateSuspiciousMsgListFromServer local empty");
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 23);
  }
  
  /* Error */
  public void a(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 74	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 75	java/util/ArrayList:<init>	()V
    //   9: astore 7
    //   11: aload_0
    //   12: getfield 183	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;
    //   15: invokevirtual 1047	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:c	()Ljava/util/ArrayList;
    //   18: astore 11
    //   20: aload_0
    //   21: invokevirtual 1048	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	()Ljava/util/ArrayList;
    //   24: astore 12
    //   26: iload_2
    //   27: bipush 23
    //   29: if_icmpne +325 -> 354
    //   32: iconst_1
    //   33: istore 4
    //   35: new 74	java/util/ArrayList
    //   38: dup
    //   39: invokespecial 75	java/util/ArrayList:<init>	()V
    //   42: astore 8
    //   44: new 74	java/util/ArrayList
    //   47: dup
    //   48: invokespecial 75	java/util/ArrayList:<init>	()V
    //   51: astore 9
    //   53: new 274	java/lang/StringBuilder
    //   56: dup
    //   57: sipush 256
    //   60: invokespecial 1049	java/lang/StringBuilder:<init>	(I)V
    //   63: astore 10
    //   65: invokestatic 270	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +12 -> 80
    //   71: aload 10
    //   73: ldc_w 1051
    //   76: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_0
    //   81: getfield 136	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   84: getstatic 179	com/tencent/mobileqq/app/QQManagerFactory:CONTACT_MANAGER	I
    //   87: invokevirtual 172	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   90: checkcast 181	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp
    //   93: astore 13
    //   95: aload_0
    //   96: aload 13
    //   98: invokevirtual 1053	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:m	()Z
    //   101: putfield 64	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:jdField_b_of_type_Boolean	Z
    //   104: aload_0
    //   105: getfield 136	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   108: getstatic 1056	com/tencent/mobileqq/app/QQManagerFactory:FLASH_CHAT_MANAGER	I
    //   111: invokevirtual 172	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   114: checkcast 718	com/tencent/mobileqq/flashchat/FlashChatManager
    //   117: astore 14
    //   119: aload_0
    //   120: aload 7
    //   122: aload 13
    //   124: invokespecial 1058	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;)V
    //   127: aload_0
    //   128: iload_1
    //   129: aload 10
    //   131: aload 8
    //   133: iconst_0
    //   134: invokespecial 1060	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	(ZLjava/lang/StringBuilder;Ljava/util/ArrayList;I)I
    //   137: istore_3
    //   138: aload_0
    //   139: aload 12
    //   141: aload 8
    //   143: aload 14
    //   145: invokespecial 1062	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/mobileqq/flashchat/FlashChatManager;)V
    //   148: aload_0
    //   149: aload 11
    //   151: aload 8
    //   153: aload 10
    //   155: invokespecial 1064	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/StringBuilder;)V
    //   158: aload_0
    //   159: invokespecial 1065	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:b	()Z
    //   162: istore 5
    //   164: new 74	java/util/ArrayList
    //   167: dup
    //   168: invokespecial 75	java/util/ArrayList:<init>	()V
    //   171: astore 11
    //   173: aload_0
    //   174: getfield 176	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager	Lcom/tencent/mobileqq/app/MayknowRecommendManager;
    //   177: invokevirtual 1067	com/tencent/mobileqq/app/MayknowRecommendManager:e	()Z
    //   180: istore 6
    //   182: aload_0
    //   183: iload_2
    //   184: iload 4
    //   186: aload 9
    //   188: aload 10
    //   190: iload 5
    //   192: aload 11
    //   194: aconst_null
    //   195: iload 6
    //   197: invokespecial 1069	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	(IZLjava/util/ArrayList;Ljava/lang/StringBuilder;ZLjava/util/ArrayList;Ljava/util/ArrayList;Z)Ljava/util/ArrayList;
    //   200: astore 12
    //   202: iconst_0
    //   203: istore_1
    //   204: iload 4
    //   206: ifeq +5 -> 211
    //   209: iconst_1
    //   210: istore_1
    //   211: invokestatic 270	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +43 -> 257
    //   217: ldc_w 383
    //   220: iconst_2
    //   221: new 274	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 1071
    //   231: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_0
    //   235: getfield 64	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:jdField_b_of_type_Boolean	Z
    //   238: invokevirtual 284	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   241: ldc_w 1073
    //   244: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: iload_1
    //   248: invokevirtual 284	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   251: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload_0
    //   258: iload 4
    //   260: aload 9
    //   262: aload 10
    //   264: aload 12
    //   266: iload_1
    //   267: aconst_null
    //   268: invokespecial 1075	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	(ZLjava/util/ArrayList;Ljava/lang/StringBuilder;Ljava/util/ArrayList;ZLjava/util/ArrayList;)Ljava/util/ArrayList;
    //   271: astore 13
    //   273: aload_0
    //   274: getfield 136	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   277: invokestatic 595	com/tencent/mobileqq/activity/contact/addfriendverifi/NewFriendVerificationManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/contact/addfriendverifi/NewFriendVerificationManager;
    //   280: invokevirtual 1077	com/tencent/mobileqq/activity/contact/addfriendverifi/NewFriendVerificationManager:a	()I
    //   283: istore_2
    //   284: aload_0
    //   285: aload 7
    //   287: iload_2
    //   288: invokespecial 1079	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	(Ljava/util/ArrayList;I)V
    //   291: aload_0
    //   292: aload 7
    //   294: aload 8
    //   296: iload_3
    //   297: aload 12
    //   299: iload 6
    //   301: aload 13
    //   303: iload_2
    //   304: invokespecial 1081	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;ILjava/util/ArrayList;ZLjava/util/ArrayList;I)V
    //   307: aload_0
    //   308: aload 7
    //   310: iload 4
    //   312: aload 9
    //   314: iload 5
    //   316: aload 12
    //   318: iload 6
    //   320: invokespecial 1083	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	(Ljava/util/ArrayList;ZLjava/util/ArrayList;ZLjava/util/ArrayList;Z)V
    //   323: aload_0
    //   324: aload 7
    //   326: iload 4
    //   328: aload 9
    //   330: aload 10
    //   332: aload 11
    //   334: iload 6
    //   336: invokespecial 1085	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	(Ljava/util/ArrayList;ZLjava/util/ArrayList;Ljava/lang/StringBuilder;Ljava/util/ArrayList;Z)V
    //   339: aload_0
    //   340: aload 7
    //   342: invokespecial 1087	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:a	(Ljava/util/ArrayList;)V
    //   345: aload_0
    //   346: aload 7
    //   348: putfield 77	com/tencent/mobileqq/activity/contact/newfriend/NewFriendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   351: aload_0
    //   352: monitorexit
    //   353: return
    //   354: iconst_0
    //   355: istore 4
    //   357: goto -322 -> 35
    //   360: astore 7
    //   362: aload_0
    //   363: monitorexit
    //   364: aload 7
    //   366: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	NewFriendManager
    //   0	367	1	paramBoolean	boolean
    //   0	367	2	paramInt	int
    //   137	160	3	i	int
    //   33	323	4	bool1	boolean
    //   162	153	5	bool2	boolean
    //   180	155	6	bool3	boolean
    //   9	338	7	localArrayList1	ArrayList
    //   360	5	7	localObject1	Object
    //   42	253	8	localArrayList2	ArrayList
    //   51	278	9	localArrayList3	ArrayList
    //   63	268	10	localStringBuilder	StringBuilder
    //   18	315	11	localArrayList4	ArrayList
    //   24	293	12	localArrayList5	ArrayList
    //   93	209	13	localObject2	Object
    //   117	27	14	localFlashChatManager	FlashChatManager
    // Exception table:
    //   from	to	target	type
    //   2	26	360	finally
    //   35	80	360	finally
    //   80	202	360	finally
    //   211	257	360	finally
    //   257	351	360	finally
  }
  
  public boolean a()
  {
    NewFriendMessage localNewFriendMessage = a();
    return (localNewFriendMessage != null) && (localNewFriendMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (paramInt != 0) {
      return false;
    }
    boolean bool1 = ((IceBreakingMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a();
    boolean bool2 = b(paramString);
    QLog.d("NewFriendManager", 1, String.format("handleNewFrdAIOShow [isNewFrd,newFrdMiniCardSwitch]=[%b,%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    if (!bool2) {
      return false;
    }
    if (!bool1)
    {
      a(paramString);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool;
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      bool = this.jdField_a_of_type_JavaUtilHashSet.remove(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      if (localIterator.hasNext())
      {
        paramString.append((String)localIterator.next());
        paramString.append("#");
      }
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("new_friend", 0).edit().putString("new_friend_list", paramString.toString()).apply();
    return bool;
  }
  
  public void addObserver(Observer paramObserver)
  {
    super.addObserver(paramObserver);
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public ArrayList<NewFriendMessage> b()
  {
    return (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
  }
  
  public List<SysSuspiciousMsg> b()
  {
    Object localObject1 = null;
    Object localObject2;
    if (!this.g)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values();
      if (localObject2 != null) {
        localObject1 = new ArrayList((Collection)localObject2);
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        Collections.sort((List)localObject1, this.jdField_b_of_type_JavaUtilComparator);
      }
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("getAllSysSuspiciousMsg ").append(this.g).append(" ");
        if (localObject1 == null) {
          break label198;
        }
      }
      label198:
      for (localObject2 = Integer.valueOf(((List)localObject1).size());; localObject2 = "null")
      {
        QLog.i("NewFriendManager", 2, localObject2);
        return localObject1;
        if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
          break label205;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(SysSuspiciousMsg.class);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        if (localObject1 != null)
        {
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SysSuspiciousMsg)((Iterator)localObject2).next();
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((SysSuspiciousMsg)localObject3).uin), localObject3);
          }
        }
        this.g = false;
        break;
      }
      label205:
      localObject1 = null;
    }
  }
  
  public void b()
  {
    a(true);
    n();
  }
  
  public void b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
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
    localEntityManager.persistOrReplace(paramQIMFollwerAdd);
    localEntityManager.close();
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshAppBadge();
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (!a(paramString2, -2015)) {
      a(paramString1, paramString2, -2023);
    }
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
    int i = d();
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new NewFriendManager.6(this, i));
  }
  
  public int d()
  {
    int k = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Iterator localIterator = b().iterator();
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
      if ((localNewFriendMessage == null) || (localNewFriendMessage.a())) {
        break label159;
      }
      if ((localNewFriendMessage instanceof FriendSystemMessage)) {
        j += 1;
      } else if ((localNewFriendMessage instanceof ContactBindedMessage)) {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a() + i;
      } else {
        i += 1;
      }
    }
    label159:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "getAllUnreadMessageCount|total unread = " + i + ",unReadSysMsgCount = " + k + ",unReadSysMsgCountInCache = " + j);
      }
      return i + k;
    }
  }
  
  public void d()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      c();
      return;
    }
    ThreadManager.postImmediately(new NewFriendManager.7(this), null, false);
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
  
  public int e()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    do
    {
      return;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      localRecentUser = localRecentUserProxy.b(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
    } while (localRecentUser == null);
    localRecentUserProxy.a(localRecentUser);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
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
      b();
      return true;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.h();
      m();
      this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.b();
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().b();
      b();
      return true;
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().b();
      this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.b();
      b();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.h();
    b();
    return true;
  }
  
  public void i()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "initNewFriendList hasInitNewFriendList: " + this.h);
    }
    if (this.h) {}
    do
    {
      return;
      this.h = true;
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
  
  public void j()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      localSharedPreferences.edit().putInt("new_friend_show_count_after_user_close", 0).putBoolean("contact_guide_user_close", false).apply();
      return;
    }
    boolean bool = localSharedPreferences.getBoolean("contact_guide_user_close", false);
    int i = localSharedPreferences.getInt("new_friend_show_count_after_user_close", 0);
    NewFriendContactGuideConfBean localNewFriendContactGuideConfBean = a();
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, String.format("updateBindContactGuideState [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(localNewFriendContactGuideConfBean.jdField_a_of_type_Boolean), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(localNewFriendContactGuideConfBean.jdField_a_of_type_Int) }));
    }
    if ((localNewFriendContactGuideConfBean.jdField_a_of_type_Boolean) && ((!bool) || (i >= localNewFriendContactGuideConfBean.jdField_a_of_type_Int)))
    {
      this.jdField_c_of_type_Boolean = true;
      localSharedPreferences.edit().putBoolean("contact_guide_user_close", false).putInt("new_friend_show_count_after_user_close", 0).apply();
      return;
    }
    if (bool) {
      localSharedPreferences.edit().putInt("new_friend_show_count_after_user_close", i + 1).apply();
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "clearAllSysSuspiciousCache ");
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    this.g = true;
  }
  
  public void l()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(SysSuspiciousMsg.class);
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "clearAllSysSuspiciousMsg " + bool);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onDestroy");
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendPokeNewFriendNotifyPokeObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager
 * JD-Core Version:    0.7.0.1
 */