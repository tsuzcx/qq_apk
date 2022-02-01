package com.tencent.imcore.message.facade;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Sqlite;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QQMessageFacadeRefresher
{
  private volatile int jdField_a_of_type_Int = -1;
  private final QQMessageFacade jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public QQMessageFacadeRefresher(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade = paramQQMessageFacade;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.frienduin != null) && (paramMessage.frienduin.equals(AppConstants.SAME_STATE_BOX_UIN)) && (paramMessage.istroop == 1009))
    {
      paramMessage.unReadNum = 0;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessage.istroop).a(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          paramMessage.unReadNum += this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessage.istroop).a(localMessageRecord.senderuin, localMessageRecord.istroop, 0L);
        }
        localEntityManager.close();
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(paramString, paramInt);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
        if (UinTypeUtil.c(localMessageRecord.senderuin))
        {
          a(localMessageRecord.senderuin, localMessageRecord.istroop);
        }
        else if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(localMessageRecord.senderuin))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt, localMessageRecord.frienduin, localMessageRecord.istroop);
          a(paramString, paramInt, localMessageRecord.senderuin, localMessageRecord.selfuin);
          Object localObject2 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(localMessageRecord.senderuin, paramInt);
          RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
          RecentUser localRecentUser = localRecentUserProxy.a(((Message)localObject2).frienduin, ((Message)localObject2).istroop);
          localRecentUser.lastmsgtime = ((Message)localObject2).time;
          RecentUtil.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade());
          localRecentUserProxy.b(localRecentUser);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("refreshMsgBox uin=");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(",type=");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(",move ");
            ((StringBuilder)localObject2).append(localMessageRecord.senderuin);
            ((StringBuilder)localObject2).append(" from box to recentlist");
            QLog.d("QQMessageFacadeRefresher", 2, ((StringBuilder)localObject2).toString());
          }
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.d();
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.notifyObservers(localRecentUser);
        }
      }
    }
  }
  
  private void a(List<RecentUser> paramList, Message paramMessage)
  {
    int i = 0;
    while (i < paramList.size())
    {
      RecentUser localRecentUser = (RecentUser)paramList.get(i);
      if ((localRecentUser != null) && (localRecentUser.uin != null) && (localRecentUser.uin.equals(paramMessage.frienduin)))
      {
        if ((!UinTypeUtil.h(paramMessage.istroop)) || (!this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a().a(paramMessage.frienduin, UinTypeUtil.a(paramMessage.istroop)))) {
          break;
        }
        c(paramMessage);
        return;
      }
      i += 1;
    }
  }
  
  private void b(Message paramMessage)
  {
    if (((!AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin)) && ((UinTypeUtil.a(paramMessage.istroop) == 10002) || (UinTypeUtil.a(paramMessage.istroop) == 1001))) || (UinTypeUtil.a(paramMessage.istroop) == 10010) || ((!AppConstants.DATE_UIN.equals(paramMessage.frienduin)) && (UinTypeUtil.a(paramMessage.istroop) == 1010)))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessage.istroop).b(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equals(localMessageRecord.frienduin)) && (!MessageUtils.a(localMessageRecord.msgtype)))
          {
            paramMessage.hasReply = true;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("requeryLastMessage = ");
              ((StringBuilder)localObject).append(paramMessage);
              ((StringBuilder)localObject).append(",hasReply=");
              ((StringBuilder)localObject).append(paramMessage.hasReply);
              QLog.d("QQMessageFacadeRefresher", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
  }
  
  private void b(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.query(TroopAssistantData.class, false, null, null, null, null, "lastmsgtime desc", null);
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopAssistantData)((Iterator)localObject).next()).troopUin, 1, paramEntityManager);
      }
    }
  }
  
  private void c(Message paramMessage)
  {
    if (paramMessage.istroop != 1009) {
      a(AppConstants.SAME_STATE_BOX_UIN, 1009, paramMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    if (paramMessage.istroop != 1001)
    {
      a(AppConstants.LBS_HELLO_UIN, 1001, paramMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
    a(AppConstants.LBS_HELLO_UIN, 10002, paramMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    return a(paramString, paramInt, paramEntityManager, 0);
  }
  
  public Message a(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    paramEntityManager = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramInt1).a(paramString, paramInt1, paramEntityManager, paramInt2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshSingleLastMsg() called with: uin = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], uinType = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], topicId = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], cost = [");
      localStringBuilder.append(SystemClock.uptimeMillis() - l);
      localStringBuilder.append("]ms");
      QLog.d("QQMessageFacadeRefresher", 2, localStringBuilder.toString());
    }
    return paramEntityManager;
  }
  
  public void a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.query(PubAccountAssistantData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)((Iterator)localObject).next();
        a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType, paramEntityManager);
      }
    }
    localObject = paramEntityManager.query(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopBarData)((Iterator)localObject).next()).mUin, 1008, paramEntityManager);
      }
    }
  }
  
  public void a(String paramString, int paramInt, RefreshMessageContext paramRefreshMessageContext)
  {
    Object localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(paramString, paramInt);
    if (localObject == null) {
      i = 0;
    } else {
      i = ((List)localObject).size();
    }
    int i = 10 - i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshMessageListHeadByAIOBreak numTroopRefresh = ");
      ((StringBuilder)localObject).append(paramRefreshMessageContext.i);
      ((StringBuilder)localObject).append(", count = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("QQMessageFacadeRefresher", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0)
    {
      paramRefreshMessageContext.i = true;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramInt).a(paramString, paramInt, i, paramRefreshMessageContext);
      return;
    }
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.a = paramString;
    paramRefreshMessageContext.jdField_d_of_type_Int = paramInt;
    paramRefreshMessageContext.e = i;
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramRefreshMessageContext);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramInt).a(paramString1, paramInt, paramString2, paramString3);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    a(AppConstants.SAME_STATE_BOX_UIN, 1009);
    a(AppConstants.LBS_HELLO_UIN, 1001);
    a(AppConstants.LBS_HELLO_UIN, 10002);
    a(AppConstants.DATE_UIN, 1010);
    a(AppConstants.MATCH_CHAT_UIN, 1044);
    a(AppConstants.QCIRCLE_CHAT_UIN, 10008);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("refreshCache", "");
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1 = localEntityManager.rawQuery(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    int i;
    if (localObject1 != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(true);
      boolean bool1 = localEntityManager.tabbleIsExist(ConversationInfo.getConversationInfoTableName());
      ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a();
      StringBuilder localStringBuilder = new StringBuilder(128);
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Sqlite localSqlite = (Sqlite)((Iterator)localObject1).next();
        localSqlite.tbl_name = SecurityUtile.decode(localSqlite.tbl_name);
        if ((!localSqlite.tbl_name.equals("mr_fileManager")) && (!localSqlite.tbl_name.startsWith("mr_confess_a")) && (!localSqlite.tbl_name.startsWith("mr_confess_b")))
        {
          boolean bool2 = localSqlite.tbl_name.endsWith("_New");
          int j = MsgProxyUtils.a(localSqlite.tbl_name);
          Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(j).a(localSqlite.tbl_name, localEntityManager);
          if (QLog.isDevelopLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getMsgProxy().queryLastMessage = ");
            ((StringBuilder)localObject2).append(localObject3);
            QLog.d("QQMessageFacadeRefresher", 4, ((StringBuilder)localObject2).toString());
          }
          if ((localObject3 != null) && (((Message)localObject3).frienduin != null))
          {
            localObject2 = localObject3;
            if (((Message)localObject3).uniseq == 0L)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(((Message)localObject3).istroop).b(((Message)localObject3).frienduin, ((Message)localObject3).istroop);
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(((Message)localObject3).istroop).a(localSqlite.tbl_name, localEntityManager);
              localObject2 = localObject3;
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("requeryLastMessage = ");
                ((StringBuilder)localObject2).append(localObject3);
                QLog.d("QQMessageFacadeRefresher", 2, ((StringBuilder)localObject2).toString());
                localObject2 = localObject3;
              }
            }
            if ((localObject2 != null) && ((!AppConstants.DATALINE_PC_UIN.equals(((Message)localObject2).frienduin)) || (localSqlite.tbl_name.equals(DataLineMsgRecord.tableName()))) && ((!AppConstants.DATALINE_IPAD_UIN.equals(((Message)localObject2).frienduin)) || (localSqlite.tbl_name.equals(DataLineMsgRecord.tableName(1)))))
            {
              b((Message)localObject2);
              this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a((Message)localObject2);
              if (!bool1)
              {
                a((Message)localObject2);
                if (localList != null) {
                  a(localList, (Message)localObject2);
                }
                localStringBuilder.setLength(0);
                localStringBuilder.append("refreshCache message uin = ");
                localStringBuilder.append(((Message)localObject2).frienduin);
                localStringBuilder.append(", type = ");
                localStringBuilder.append(((Message)localObject2).istroop);
                localStringBuilder.append(", unread = ");
                localStringBuilder.append(((Message)localObject2).unReadNum);
                localStringBuilder.append(", time = ");
                localStringBuilder.append(((Message)localObject2).time);
                this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localStringBuilder.toString(), "");
              }
              localObject3 = UinTypeUtil.a(((Message)localObject2).frienduin, ((Message)localObject2).istroop);
              if ((bool2) || (!this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.containsKey(localObject3)))
              {
                this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.put(localObject3, localObject2);
                j = i + 1;
                i = j;
                if (!bool1)
                {
                  localConversationFacade.c(((Message)localObject2).frienduin, ((Message)localObject2).istroop, ((Message)localObject2).unReadNum);
                  i = j;
                }
              }
            }
          }
        }
      }
    }
    else
    {
      i = 0;
    }
    localEntityManager.close();
    localObject1 = MsgAutoMonitorUtil.getInstance();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("");
    ((MsgAutoMonitorUtil)localObject1).printKeyAndValue("MSG_TableNum", ((StringBuilder)localObject2).toString());
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.QQMessageFacadeRefresher
 * JD-Core Version:    0.7.0.1
 */