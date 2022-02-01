package com.tencent.mobileqq.app.msgnotify;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotifyIdManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgNotifyManager
{
  private Message jdField_a_of_type_ComTencentImcoreMessageMessage;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final List<Message> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public MsgNotifyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private Message a(List<Message> paramList, MessageRecord paramMessageRecord)
  {
    Object localObject;
    if ((paramList == null) || (paramMessageRecord == null))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label59;
      }
      Message localMessage = (Message)paramList.get(i);
      localObject = localMessage;
      if (a(localMessage, paramMessageRecord)) {
        break;
      }
      i += 1;
    }
    label59:
    return null;
  }
  
  private boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return UinTypeUtil.a(paramMessageRecord1.frienduin, paramMessageRecord1.istroop).equals(UinTypeUtil.a(paramMessageRecord2.frienduin, paramMessageRecord2.istroop));
  }
  
  public int a()
  {
    return a(false);
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          Message localMessage = (Message)localIterator.next();
          if (localMessage.istroop == paramInt) {
            i = localMessage.counter + i;
          }
        }
        else
        {
          return i;
        }
      }
    }
  }
  
  public int a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      label20:
      Message localMessage;
      for (int i = 0; localIterator.hasNext(); i = localMessage.counter + i)
      {
        localMessage = (Message)localIterator.next();
        if ((localMessage.istroop == 1037) || (localMessage.istroop == 1044) || (localMessage.istroop == 1045) || ((paramBoolean) && (NotifyIdManager.a(localMessage)))) {
          break label20;
        }
      }
      return i;
    }
  }
  
  public Message a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageMessage;
  }
  
  public List<Message> a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      List localList2 = (List)((ArrayList)this.jdField_a_of_type_JavaUtilList).clone();
      return localList2;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showNotificationMsg type:" + paramInt);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (((Message)localIterator.next()).istroop == paramInt) {
          localIterator.remove();
        }
      }
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (Message localMessage = (Message)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);; localMessage = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.showReadedMsgNotification(localMessage, null);
      return;
    }
  }
  
  public void a(Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageMessage = paramMessage;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "cancelNotificationWhenRevokeMessage, " + paramMessageRecord);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, new Object[] { "cancelNotificationWhenRevokeMessage, isBackground: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause) });
      }
      return;
    }
    Message localMessage;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localMessage = a(this.jdField_a_of_type_JavaUtilList, paramMessageRecord);
      if ((localMessage == null) || (localMessage.msgInfoList == null) || (localMessage.msgInfoList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "cancelNotificationWhenRevokeMessage, conversation not in cache");
        }
        return;
      }
    }
    int k = localMessage.msgInfoList.size();
    int i = k - 1;
    for (;;)
    {
      MsgCacheInfo localMsgCacheInfo;
      int j;
      if (i >= 0)
      {
        localMsgCacheInfo = (MsgCacheInfo)localMessage.msgInfoList.get(i);
        if ((localMsgCacheInfo.jdField_a_of_type_Int == 3000) || (localMsgCacheInfo.jdField_a_of_type_Int == 1))
        {
          if (localMsgCacheInfo.c != paramMessageRecord.shmsgseq) {
            break label486;
          }
          j = i;
        }
      }
      for (;;)
      {
        if (j == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "cancelNotificationWhenRevokeMessage, not in cache");
          }
          return;
          if (localMsgCacheInfo.b != paramMessageRecord.msgUid) {
            break;
          }
          j = i;
          if (localMsgCacheInfo.c != paramMessageRecord.shmsgseq) {
            break;
          }
        }
        else
        {
          if ((j == k - 1) && (k > 1))
          {
            paramMessageRecord = (MsgCacheInfo)localMessage.msgInfoList.get(k - 2);
            MessageRecord.copyMessageRecordBaseField(localMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageRecord.jdField_a_of_type_JavaLangString, paramMessageRecord.jdField_a_of_type_Int, paramMessageRecord.jdField_a_of_type_Long));
            localMessage.emoRecentMsg = null;
            localMessage.fileType = -1;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessage);
            if (QLog.isColorLevel()) {
              QLog.d("notification", 2, "cancelNotificationWhenRevokeMessage, match the last msg");
            }
          }
          localMessage.msgInfoList.remove(j);
          localMessage.counter -= 1;
          if ((localMessage.counter <= 0) || (localMessage.msgInfoList.isEmpty())) {
            this.jdField_a_of_type_JavaUtilList.remove(localMessage);
          }
          if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
          for (paramMessageRecord = (Message)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);; paramMessageRecord = null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.showReadedMsgNotification(paramMessageRecord, localMessage);
            return;
          }
          j = -1;
        }
      }
      label486:
      i -= 1;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "removeNotification uin" + paramString + ",type:" + paramInt);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label319;
        }
        localObject2 = (Message)localIterator.next();
        if (((paramInt == ((Message)localObject2).istroop) || ((UinTypeUtil.b(paramInt)) && (UinTypeUtil.b(((Message)localObject2).istroop)))) && (((Message)localObject2).frienduin.equals(paramString)))
        {
          ((Message)localObject2).counter = 0;
          localIterator.remove();
          bool1 = true;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("removeNotification remove:").append(bool1).append(",preMsg is null");
            if (localObject1 != null) {
              break label297;
            }
            bool2 = true;
            QLog.d("notification", 2, bool2 + ",iterator.hasNext():" + localIterator.hasNext());
          }
          if (bool1)
          {
            if ((localObject1 != null) || (!localIterator.hasNext())) {
              break label316;
            }
            localObject1 = (Message)localIterator.next();
            if (!NotifyIdManager.a(paramInt, paramString)) {
              break label303;
            }
            NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramString);
          }
          return;
        }
      }
      localObject1 = localObject2;
      continue;
      label297:
      boolean bool2 = false;
      continue;
      label303:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.showReadedMsgNotification((Message)localObject1, null);
      continue;
      label316:
      continue;
      label319:
      boolean bool1 = false;
    }
  }
  
  public int b()
  {
    return b(false);
  }
  
  public int b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        Message localMessage = (Message)localIterator.next();
        if ((localMessage.istroop != 1008) && (localMessage.istroop != 1037) && (localMessage.istroop != 1044) && (localMessage.istroop != 1045) && ((!paramBoolean) || (!NotifyIdManager.a(localMessage))))
        {
          if (7000 != localMessage.istroop) {
            break label167;
          }
          SubAccountManager localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
          if (localSubAccountManager == null) {
            break label158;
          }
          j = localSubAccountManager.b(localMessage.frienduin);
          break label160;
        }
      }
      return i;
    }
    label158:
    int j = 0;
    label160:
    int i = j + i;
    for (;;)
    {
      break;
      label167:
      i += 1;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext())
      {
        Message localMessage = (Message)localIterator.next();
        localMessage.counter = 0;
        localMessage.msgInfoList = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(Message paramMessage)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Object localObject = a(this.jdField_a_of_type_JavaUtilList, paramMessage);
      if (localObject != null)
      {
        paramMessage.msgInfoList = ((Message)localObject).msgInfoList;
        this.jdField_a_of_type_JavaUtilList.set(this.jdField_a_of_type_JavaUtilList.indexOf(localObject), paramMessage);
        if (paramMessage.msgInfoList == null) {
          paramMessage.msgInfoList = new ArrayList();
        }
        localObject = new MsgCacheInfo(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq, paramMessage.msgUid, paramMessage.shmsgseq);
        paramMessage.msgInfoList.add(localObject);
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyManager
 * JD-Core Version:    0.7.0.1
 */