package com.tencent.mobileqq.app.message;

import android.os.Handler;
import android.os.Looper;
import com.dataline.activities.LiteActivity;
import com.dataline.util.WaitEvent;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy.LoadMoreAioMessageCb;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgDbTransformer;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgHelper;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgTransformer;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class DatalineMessageManager
  implements IMessageManager
{
  protected QQAppInterface a;
  protected QQMessageFacade b;
  protected String c = AppConstants.DATALINE_PC_UIN;
  protected int d = 6000;
  
  public DatalineMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    this.a = paramQQAppInterface;
    this.b = paramQQMessageFacade;
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, EntityManager paramEntityManager)
  {
    a().b(paramDataLineMsgRecord);
    paramEntityManager = a().a(paramDataLineMsgRecord.groupId);
    Message localMessage = this.b.getLastMessage(String.valueOf(this.c), this.d);
    localMessage.selfuin = String.valueOf(this.c);
    localMessage.senderuin = String.valueOf(this.c);
    localMessage.msgtype = paramDataLineMsgRecord.msgtype;
    if (localMessage.msgtype == -2009) {
      localMessage.msgtype = -2005;
    }
    localMessage.msg = paramDataLineMsgRecord.msg;
    localMessage.emoRecentMsg = null;
    if (paramDataLineMsgRecord.time > localMessage.time)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateLastMsg mr msg time[");
      localStringBuilder.append(localMessage.time);
      localStringBuilder.append("] to time[");
      localStringBuilder.append(paramDataLineMsgRecord.time);
      localStringBuilder.append("]");
      QLog.d("DatalineMessageManager", 2, localStringBuilder.toString());
      localMessage.time = paramDataLineMsgRecord.time;
    }
    localMessage.msgseq = paramDataLineMsgRecord.msgseq;
    localMessage.isread = paramDataLineMsgRecord.isread;
    localMessage.issend = paramDataLineMsgRecord.issend;
    localMessage.frienduin = String.valueOf(this.c);
    localMessage.istroop = this.d;
    localMessage.fileType = -1;
    localMessage.msgId = paramDataLineMsgRecord.msgId;
    this.b.a(localMessage);
    if (!paramDataLineMsgRecord.isSend()) {
      localMessage.hasReply = true;
    }
    if ((!paramDataLineMsgRecord.isSendFromLocal()) && (!paramDataLineMsgRecord.isread))
    {
      this.b.c(localMessage);
      if (DataLineMsgSet.isSingle(paramDataLineMsgRecord))
      {
        this.a.getConversationFacade().e(localMessage.frienduin, localMessage.istroop, 1);
        return;
      }
      if ((paramEntityManager == null) || (paramEntityManager.getComeCount() == 1)) {
        this.a.getConversationFacade().e(localMessage.frienduin, localMessage.istroop, 1);
      }
    }
  }
  
  public int a(DataLineMsgSet paramDataLineMsgSet)
  {
    Object localObject = Looper.getMainLooper();
    Thread localThread1 = Thread.currentThread();
    Thread localThread2 = ((Looper)localObject).getThread();
    boolean bool = false;
    if (localThread1 == localThread2)
    {
      int i = a().b(paramDataLineMsgSet);
      if (i > 0)
      {
        paramDataLineMsgSet = UinTypeUtil.a(String.valueOf(this.c), this.d);
        if (this.b.a.containsKey(paramDataLineMsgSet))
        {
          bool = ((Message)this.b.a.get(paramDataLineMsgSet)).hasReply;
          this.b.a.remove(paramDataLineMsgSet);
        }
        long l = a().a().size();
        if (l > 0L)
        {
          localObject = a().c();
          paramDataLineMsgSet = (DataLineMsgSet)localObject;
          if (localObject != null) {
            if ((((DataLineMsgRecord)localObject).msgtype != -5000) && (((DataLineMsgRecord)localObject).msgtype != -5041))
            {
              paramDataLineMsgSet = (DataLineMsgSet)localObject;
              if (((DataLineMsgRecord)localObject).msgtype != -2073) {}
            }
            else
            {
              paramDataLineMsgSet = (DataLineMsgSet)localObject;
              if (l > 1L) {
                paramDataLineMsgSet = a().a().get((int)(l - 2L)).getLastItem();
              }
            }
          }
          localObject = new Message();
          if (paramDataLineMsgSet != null)
          {
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, paramDataLineMsgSet);
            ((Message)localObject).emoRecentMsg = null;
            ((Message)localObject).hasReply = bool;
            this.b.a((Message)localObject);
            this.b.a.put(UinTypeUtil.a(String.valueOf(this.c), this.d), localObject);
          }
        }
        paramDataLineMsgSet = this.a.getEntityManagerFactory().createEntityManager();
        localObject = this.a.getProxyManager().g().b(String.valueOf(this.c), this.d);
        paramDataLineMsgSet.close();
        if (localObject != null) {
          this.b.a(localObject);
        }
      }
      return i;
    }
    new Handler((Looper)localObject).post(new DatalineMessageManager.3(this, paramDataLineMsgSet));
    return 0;
  }
  
  public long a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    if (paramDataLineMsgRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.DatalineMessageManager", 2, "mr is null");
      }
      return -1L;
    }
    if (!paramDataLineMsgRecord.isSend())
    {
      int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
      this.a.getDatalineMsgDBTransformer().b(i);
      localObject1 = new DatalineMsgTransformer(this.a);
      ((DatalineMsgTransformer)localObject1).a(paramDataLineMsgRecord);
      localObject1 = ((DatalineMsgTransformer)localObject1).a();
      ((MessageRecord)localObject1).isread = false;
      new DatalineMsgHelper(this.a).a((MessageRecord)localObject1);
      ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).o();
    }
    b();
    Object localObject1 = new WaitEvent(false, false);
    Object localObject2 = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject2).getThread())
    {
      localObject1 = this.a.getEntityManagerFactory().createEntityManager();
      try
      {
        if (paramDataLineMsgRecord.time == 0L) {
          paramDataLineMsgRecord.time = MessageCache.c();
        }
        if (paramDataLineMsgRecord.msgseq == 0L) {
          paramDataLineMsgRecord.msgseq = ((int)paramDataLineMsgRecord.time);
        }
        a(paramDataLineMsgRecord, (EntityManager)localObject1);
        long l = paramDataLineMsgRecord.msgId;
        if (paramBoolean) {
          paramDataLineMsgRecord.issuc = true;
        }
        if (!QFileAssistantUtils.a(this.a))
        {
          localObject2 = this.a.getProxyManager().g();
          RecentUser localRecentUser = ((RecentUserProxy)localObject2).b(String.valueOf(this.c), this.d);
          localRecentUser.setType(this.d);
          localRecentUser.lastmsgtime = paramDataLineMsgRecord.time;
          ((RecentUserProxy)localObject2).b(localRecentUser);
          this.b.a(paramDataLineMsgRecord);
        }
        ((EntityManager)localObject1).close();
        if (QLog.isColorLevel())
        {
          paramDataLineMsgRecord = new StringBuilder();
          paramDataLineMsgRecord.append("mr.msgId: ");
          paramDataLineMsgRecord.append(l);
          QLog.d("Q.msg.DatalineMessageManager", 2, paramDataLineMsgRecord.toString());
        }
        return l;
      }
      finally
      {
        ((EntityManager)localObject1).close();
      }
    }
    new Handler((Looper)localObject2).post(new DatalineMessageManager.1(this, paramDataLineMsgRecord, (WaitEvent)localObject1));
    ((WaitEvent)localObject1).a(-1L);
    return 0L;
  }
  
  protected DataLineMsgProxy a()
  {
    return this.a.getDataLineMsgProxy(0);
  }
  
  public DataLineMsgRecord a(long paramLong)
  {
    return a().b(paramLong);
  }
  
  public void a(int paramInt, DataLineMsgProxy.LoadMoreAioMessageCb paramLoadMoreAioMessageCb)
  {
    a().a(paramInt, paramLoadMoreAioMessageCb);
  }
  
  public void a(long paramLong, String paramString)
  {
    a().b(paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    a().a(paramLong, paramString, paramArrayOfByte);
  }
  
  public DataLineMsgSet b(long paramLong)
  {
    return a().d(paramLong);
  }
  
  protected void b()
  {
    ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(false);
  }
  
  public void b(long paramLong, String paramString)
  {
    a().a(paramLong, paramString);
  }
  
  public void c()
  {
    Object localObject1 = this.a.getEntityManagerFactory().createEntityManager();
    try
    {
      RecentUserProxy localRecentUserProxy = this.a.getRecentUserProxy();
      RecentUser localRecentUser = localRecentUserProxy.b(String.valueOf(this.c), this.d);
      localRecentUser.setType(this.d);
      localRecentUser.lastmsgtime = MessageCache.c();
      localRecentUserProxy.b(localRecentUser);
      ((EntityManager)localObject1).close();
      localObject1 = this.b.getLastMessage(String.valueOf(this.c), this.d);
      this.b.a(localObject1);
      return;
    }
    finally
    {
      ((EntityManager)localObject1).close();
    }
  }
  
  public void c(long paramLong)
  {
    a().h(paramLong);
  }
  
  public List<DataLineMsgRecord> d()
  {
    return a().d();
  }
  
  public void d(long paramLong)
  {
    a().f(paramLong);
  }
  
  public void e()
  {
    a().e();
  }
  
  public void e(long paramLong)
  {
    a().g(paramLong);
  }
  
  public void f()
  {
    a().b();
  }
  
  public void f(long paramLong)
  {
    a().e(paramLong);
  }
  
  public void g()
  {
    if (!LiteActivity.class.getName().equals(ConfigHandler.a(BaseApplication.getContext()))) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDataLineMsgReaded,unread=");
      ((StringBuilder)localObject).append(this.b.a().a(this.c, this.d));
      QLog.d("Q.msg.DatalineMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.b.a().a(this.c, this.d) > 0)
    {
      a().f();
      this.b.a().a(this.c, this.d, true);
      localObject = this.b;
      ((QQMessageFacade)localObject).a(((QQMessageFacade)localObject).getLastMessage(this.c, this.d));
    }
  }
  
  public void g(long paramLong)
  {
    Message localMessage = this.b.getLastMessage(String.valueOf(this.c), this.d);
    if (paramLong > localMessage.time)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateLastMsg msg time[");
      localStringBuilder.append(localMessage.time);
      localStringBuilder.append("] to time[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d("DatalineMessageManager", 2, localStringBuilder.toString());
      localMessage.time = paramLong;
    }
  }
  
  public int h()
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      localObject = this.b.getLastMessage(String.valueOf(this.c), this.d);
      if (this.a.getWritableDatabase() == null) {
        return 0;
      }
      int i = a().g();
      if (i > 0)
      {
        ((Message)localObject).msg = null;
        ((Message)localObject).emoRecentMsg = null;
        ((Message)localObject).fileType = -1;
      }
      this.b.a(localObject);
      return i;
    }
    throw new RuntimeException("clearHistory in no-main thread");
  }
  
  public int h(long paramLong)
  {
    DataLineMsgSet localDataLineMsgSet = a().c(paramLong);
    if (localDataLineMsgSet == null) {
      return -1;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread()) {
      return a(localDataLineMsgSet);
    }
    new Handler(localLooper).post(new DatalineMessageManager.2(this, localDataLineMsgSet));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageManager
 * JD-Core Version:    0.7.0.1
 */