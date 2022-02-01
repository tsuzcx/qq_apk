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
  protected int a;
  protected QQMessageFacade a;
  protected QQAppInterface a;
  protected String a;
  
  public DatalineMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    this.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
    this.jdField_a_of_type_Int = 6000;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade = paramQQMessageFacade;
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, EntityManager paramEntityManager)
  {
    a().b(paramDataLineMsgRecord);
    paramEntityManager = a().a(paramDataLineMsgRecord.groupId);
    Message localMessage = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
    localMessage.selfuin = String.valueOf(this.jdField_a_of_type_JavaLangString);
    localMessage.senderuin = String.valueOf(this.jdField_a_of_type_JavaLangString);
    localMessage.msgtype = paramDataLineMsgRecord.msgtype;
    if (localMessage.msgtype == -2009) {
      localMessage.msgtype = -2005;
    }
    localMessage.msg = paramDataLineMsgRecord.msg;
    localMessage.emoRecentMsg = null;
    if (paramDataLineMsgRecord.time > localMessage.time)
    {
      QLog.d("DatalineMessageManager", 2, "updateLastMsg mr msg time[" + localMessage.time + "] to time[" + paramDataLineMsgRecord.time + "]");
      localMessage.time = paramDataLineMsgRecord.time;
    }
    localMessage.msgseq = paramDataLineMsgRecord.msgseq;
    localMessage.isread = paramDataLineMsgRecord.isread;
    localMessage.issend = paramDataLineMsgRecord.issend;
    localMessage.frienduin = String.valueOf(this.jdField_a_of_type_JavaLangString);
    localMessage.istroop = this.jdField_a_of_type_Int;
    localMessage.fileType = -1;
    localMessage.msgId = paramDataLineMsgRecord.msgId;
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localMessage);
    if (!paramDataLineMsgRecord.isSend()) {
      localMessage.hasReply = true;
    }
    if ((!paramDataLineMsgRecord.isSendFromLocal()) && (!paramDataLineMsgRecord.isread))
    {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(localMessage);
      if (!DataLineMsgSet.isSingle(paramDataLineMsgRecord)) {
        break label290;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(localMessage.frienduin, localMessage.istroop, 1);
    }
    label290:
    while ((paramEntityManager != null) && (paramEntityManager.getComeCount() != 1)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(localMessage.frienduin, localMessage.istroop, 1);
  }
  
  public int a()
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread()) {
      throw new RuntimeException("clearHistory in no-main thread");
    }
    localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase() == null) {
      return 0;
    }
    int i = a().a();
    if (i > 0)
    {
      ((Message)localObject).msg = null;
      ((Message)localObject).emoRecentMsg = null;
      ((Message)localObject).fileType = -1;
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localObject);
    return i;
  }
  
  public int a(long paramLong)
  {
    DataLineMsgSet localDataLineMsgSet = a().a(paramLong);
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
  
  public int a(DataLineMsgSet paramDataLineMsgSet)
  {
    boolean bool = false;
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      int i = a().a(paramDataLineMsgSet);
      if (i > 0)
      {
        paramDataLineMsgSet = UinTypeUtil.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.containsKey(paramDataLineMsgSet))
        {
          bool = ((Message)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.get(paramDataLineMsgSet)).hasReply;
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.remove(paramDataLineMsgSet);
        }
        long l = a().a().size();
        if (l > 0L)
        {
          localObject = a().a();
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
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a((Message)localObject);
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.put(UinTypeUtil.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int), localObject);
          }
        }
        paramDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
        paramDataLineMsgSet.close();
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localObject);
        }
      }
      return i;
    }
    new Handler((Looper)localObject).post(new DatalineMessageManager.3(this, paramDataLineMsgSet));
    return 0;
  }
  
  public long a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    long l1;
    if (paramDataLineMsgRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.DatalineMessageManager", 2, "mr is null");
      }
      l1 = -1L;
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      return l1;
      if (!paramDataLineMsgRecord.isSend())
      {
        int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDatalineMsgDBTransformer().a(i);
        localObject1 = new DatalineMsgTransformer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((DatalineMsgTransformer)localObject1).a(paramDataLineMsgRecord);
        localObject1 = ((DatalineMsgTransformer)localObject1).a();
        ((MessageRecord)localObject1).isread = false;
        new DatalineMsgHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((MessageRecord)localObject1);
        ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).f();
      }
      a();
      localObject1 = new WaitEvent(false, false);
      localObject2 = Looper.getMainLooper();
      if (Thread.currentThread() == ((Looper)localObject2).getThread())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        try
        {
          if (paramDataLineMsgRecord.time == 0L) {
            paramDataLineMsgRecord.time = MessageCache.a();
          }
          if (paramDataLineMsgRecord.msgseq == 0L) {
            paramDataLineMsgRecord.msgseq = ((int)paramDataLineMsgRecord.time);
          }
          a(paramDataLineMsgRecord, (EntityManager)localObject1);
          long l2 = paramDataLineMsgRecord.msgId;
          if (paramBoolean) {
            paramDataLineMsgRecord.issuc = true;
          }
          if (!QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
            RecentUser localRecentUser = ((RecentUserProxy)localObject2).a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
            localRecentUser.setType(this.jdField_a_of_type_Int);
            localRecentUser.lastmsgtime = paramDataLineMsgRecord.time;
            ((RecentUserProxy)localObject2).b(localRecentUser);
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramDataLineMsgRecord);
          }
          ((EntityManager)localObject1).close();
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.DatalineMessageManager", 2, "mr.msgId: " + l2);
            return l2;
          }
        }
        finally
        {
          ((EntityManager)localObject1).close();
        }
      }
    }
    new Handler((Looper)localObject2).post(new DatalineMessageManager.1(this, paramDataLineMsgRecord, (WaitEvent)localObject1));
    ((WaitEvent)localObject1).a(-1L);
    return 0L;
  }
  
  protected DataLineMsgProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0);
  }
  
  public DataLineMsgRecord a(long paramLong)
  {
    return a().b(paramLong);
  }
  
  public DataLineMsgSet a(long paramLong)
  {
    return a().b(paramLong);
  }
  
  public List<DataLineMsgRecord> a()
  {
    return a().a();
  }
  
  protected void a()
  {
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(false);
  }
  
  public void a(int paramInt, DataLineMsgProxy.LoadMoreAioMessageCb paramLoadMoreAioMessageCb)
  {
    a().a(paramInt, paramLoadMoreAioMessageCb);
  }
  
  public void a(long paramLong)
  {
    a().a(paramLong);
  }
  
  public void a(long paramLong, String paramString)
  {
    a().b(paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    a().a(paramLong, paramString, paramArrayOfByte);
  }
  
  public void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy();
      RecentUser localRecentUser = localRecentUserProxy.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
      localRecentUser.setType(this.jdField_a_of_type_Int);
      localRecentUser.lastmsgtime = MessageCache.a();
      localRecentUserProxy.b(localRecentUser);
      ((EntityManager)localObject1).close();
      localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localObject1);
      return;
    }
    finally
    {
      ((EntityManager)localObject1).close();
    }
  }
  
  public void b(long paramLong)
  {
    a().b(paramLong);
  }
  
  public void b(long paramLong, String paramString)
  {
    a().a(paramLong, paramString);
  }
  
  public void c()
  {
    a().b();
  }
  
  public void c(long paramLong)
  {
    a().c(paramLong);
  }
  
  public void d()
  {
    a().a();
  }
  
  public void d(long paramLong)
  {
    a().a(paramLong);
  }
  
  public void e()
  {
    if (!LiteActivity.class.getName().equals(ConfigHandler.a(BaseApplication.getContext()))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DatalineMessageManager", 2, "setDataLineMsgReaded,unread=" + this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int));
      }
    } while (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int) <= 0);
    a().c();
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int));
  }
  
  public void e(long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
    if (paramLong > localMessage.time)
    {
      QLog.d("DatalineMessageManager", 2, "updateLastMsg msg time[" + localMessage.time + "] to time[" + paramLong + "]");
      localMessage.time = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageManager
 * JD-Core Version:    0.7.0.1
 */