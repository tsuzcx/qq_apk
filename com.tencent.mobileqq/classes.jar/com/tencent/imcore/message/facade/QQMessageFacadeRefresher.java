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
  private volatile boolean a = false;
  private volatile int b = -1;
  private final QQMessageFacade c;
  private final QQAppInterface d;
  
  public QQMessageFacadeRefresher(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQMessageFacade;
    this.d = paramQQAppInterface;
  }
  
  private void a(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.frienduin != null) && (paramMessage.frienduin.equals(AppConstants.SAME_STATE_BOX_UIN)) && (paramMessage.istroop == 1009))
    {
      paramMessage.unReadNum = 0;
      Object localObject = this.d.getMessageProxy(paramMessage.istroop).b(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        EntityManager localEntityManager = this.d.getEntityManagerFactory().createEntityManager();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          paramMessage.unReadNum += this.d.getMessageProxy(paramMessage.istroop).f(localMessageRecord.senderuin, localMessageRecord.istroop, 0L);
        }
        localEntityManager.close();
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject1 = this.d.getMessageProxy(paramInt).b(paramString, paramInt);
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
        else if (((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(localMessageRecord.senderuin))
        {
          this.d.getConversationFacade().a(paramString, paramInt, localMessageRecord.frienduin, localMessageRecord.istroop);
          a(paramString, paramInt, localMessageRecord.senderuin, localMessageRecord.selfuin);
          Object localObject2 = this.c.getLastMessage(localMessageRecord.senderuin, paramInt);
          RecentUserProxy localRecentUserProxy = this.d.getProxyManager().g();
          RecentUser localRecentUser = localRecentUserProxy.b(((Message)localObject2).frienduin, ((Message)localObject2).istroop);
          localRecentUser.lastmsgtime = ((Message)localObject2).time;
          RecentUtil.a(localRecentUser, this.d.getMessageFacade());
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
          this.c.f();
          this.c.notifyObservers(localRecentUser);
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
        if ((!UinTypeUtil.j(paramMessage.istroop)) || (!this.c.a().j(paramMessage.frienduin, UinTypeUtil.e(paramMessage.istroop)))) {
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
    if (((!AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin)) && ((UinTypeUtil.e(paramMessage.istroop) == 10002) || (UinTypeUtil.e(paramMessage.istroop) == 1001))) || (UinTypeUtil.e(paramMessage.istroop) == 10010) || ((!AppConstants.DATE_UIN.equals(paramMessage.frienduin)) && (UinTypeUtil.e(paramMessage.istroop) == 1010)))
    {
      Object localObject = this.d.getMessageProxy(paramMessage.istroop).c(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equals(localMessageRecord.frienduin)) && (!MessageUtils.b(localMessageRecord.msgtype)))
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
      a(AppConstants.SAME_STATE_BOX_UIN, 1009, paramMessage.frienduin, this.d.getCurrentAccountUin());
    }
    if (paramMessage.istroop != 1001)
    {
      a(AppConstants.LBS_HELLO_UIN, 1001, paramMessage.frienduin, this.d.getCurrentAccountUin());
      return;
    }
    a(AppConstants.LBS_HELLO_UIN, 10002, paramMessage.frienduin, this.d.getCurrentAccountUin());
  }
  
  public Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    return a(paramString, paramInt, paramEntityManager, 0);
  }
  
  public Message a(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    paramEntityManager = this.c.a(paramInt1).a(paramString, paramInt1, paramEntityManager, paramInt2);
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
    Object localObject = this.c.o(paramString, paramInt);
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
      ((StringBuilder)localObject).append(paramRefreshMessageContext.s);
      ((StringBuilder)localObject).append(", count = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("QQMessageFacadeRefresher", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0)
    {
      paramRefreshMessageContext.s = true;
      this.c.a(paramInt).a(paramString, paramInt, i, paramRefreshMessageContext);
      return;
    }
    paramRefreshMessageContext.f = true;
    paramRefreshMessageContext.p = paramString;
    paramRefreshMessageContext.q = paramInt;
    paramRefreshMessageContext.r = i;
    this.c.a(paramRefreshMessageContext);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.c.a(paramInt).a(paramString1, paramInt, paramString2, paramString3);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void c()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void d()
  {
    a(AppConstants.SAME_STATE_BOX_UIN, 1009);
    a(AppConstants.LBS_HELLO_UIN, 1001);
    a(AppConstants.LBS_HELLO_UIN, 10002);
    a(AppConstants.DATE_UIN, 1010);
    a(AppConstants.MATCH_CHAT_UIN, 1044);
    a(AppConstants.QCIRCLE_CHAT_UIN, 10008);
  }
  
  public void e()
  {
    this.c.a("refreshCache", "");
    EntityManager localEntityManager = this.d.getEntityManagerFactory().createEntityManager();
    Object localObject1 = localEntityManager.rawQuery(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    int i;
    if (localObject1 != null)
    {
      List localList = this.d.getProxyManager().g().a(true);
      boolean bool1 = localEntityManager.tabbleIsExist(ConversationInfo.getConversationInfoTableName());
      ConversationFacade localConversationFacade = this.c.a();
      StringBuilder localStringBuilder = new StringBuilder(128);
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Sqlite localSqlite = (Sqlite)((Iterator)localObject1).next();
        localSqlite.tbl_name = SecurityUtile.decode(localSqlite.tbl_name);
        break label152;
        if (!localSqlite.tbl_name.equals("mr_fileManager"))
        {
          label152:
          boolean bool2;
          int j;
          Object localObject3;
          do
          {
            do
            {
              while ((localSqlite.tbl_name.startsWith("mr_guild")) || (localSqlite.tbl_name.startsWith("mr_confess_a")) || (localSqlite.tbl_name.startsWith("mr_confess_b"))) {}
              bool2 = localSqlite.tbl_name.endsWith("_New");
              j = MsgProxyUtils.a(localSqlite.tbl_name);
              localObject3 = this.d.getMessageProxy(j).a(localSqlite.tbl_name, localEntityManager);
              if (QLog.isDevelopLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("getMsgProxy().queryLastMessage = ");
                ((StringBuilder)localObject2).append(localObject3);
                QLog.d("QQMessageFacadeRefresher", 4, ((StringBuilder)localObject2).toString());
              }
            } while ((localObject3 == null) || (((Message)localObject3).frienduin == null));
            localObject2 = localObject3;
            if (((Message)localObject3).uniseq == 0L)
            {
              this.d.getMessageProxy(((Message)localObject3).istroop).c(((Message)localObject3).frienduin, ((Message)localObject3).istroop);
              localObject3 = this.d.getMessageProxy(((Message)localObject3).istroop).a(localSqlite.tbl_name, localEntityManager);
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
          } while ((localObject2 == null) || ((AppConstants.DATALINE_PC_UIN.equals(((Message)localObject2).frienduin)) && (!localSqlite.tbl_name.equals(DataLineMsgRecord.tableName()))));
          if ((!AppConstants.DATALINE_IPAD_UIN.equals(((Message)localObject2).frienduin)) || (localSqlite.tbl_name.equals(DataLineMsgRecord.tableName(1))))
          {
            b((Message)localObject2);
            this.c.a((Message)localObject2);
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
              this.c.a(localStringBuilder.toString(), "");
            }
            localObject3 = UinTypeUtil.a(((Message)localObject2).frienduin, ((Message)localObject2).istroop);
            if ((bool2) || (!this.c.a.containsKey(localObject3)))
            {
              this.c.a.put(localObject3, localObject2);
              j = i + 1;
              i = j;
              if (!bool1)
              {
                localConversationFacade.d(((Message)localObject2).frienduin, ((Message)localObject2).istroop, ((Message)localObject2).unReadNum);
                i = j;
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
  
  public void f()
  {
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.QQMessageFacadeRefresher
 * JD-Core Version:    0.7.0.1
 */