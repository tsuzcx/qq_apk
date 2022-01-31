package com.tencent.mobileqq.app.msgnotify;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgNotifyManager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQMessageFacade.Message jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  private final List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public MsgNotifyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private QQMessageFacade.Message a(List paramList, MessageRecord paramMessageRecord)
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
      QQMessageFacade.Message localMessage = (QQMessageFacade.Message)paramList.get(i);
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
    return MsgProxyUtils.a(paramMessageRecord1.frienduin, paramMessageRecord1.istroop).equals(MsgProxyUtils.a(paramMessageRecord2.frienduin, paramMessageRecord2.istroop));
  }
  
  public int a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0; localIterator.hasNext(); i = ((QQMessageFacade.Message)localIterator.next()).counter + i) {}
      return i;
    }
  }
  
  public QQMessageFacade.Message a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  }
  
  public List a()
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
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (((QQMessageFacade.Message)localIterator.next()).istroop == paramInt) {
          localIterator.remove();
        }
      }
    }
    QQMessageFacade.Message localMessage = null;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localMessage);
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message = paramMessage;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "revokeNotificationMsg, " + paramMessageRecord);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, new Object[] { "revokeNotificationMsg, isBackground: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) });
      }
      return;
    }
    QQMessageFacade.Message localMessage;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localMessage = a(this.jdField_a_of_type_JavaUtilList, paramMessageRecord);
      if ((localMessage == null) || (localMessage.msgInfoList == null) || (localMessage.msgInfoList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "revokeNotificationMsg, conversation not in cache");
        }
        return;
      }
    }
    int k = localMessage.msgInfoList.size();
    int i = k - 1;
    for (;;)
    {
      MsgNotifyManager.MsgCacheInfo localMsgCacheInfo;
      int j;
      if (i >= 0)
      {
        localMsgCacheInfo = (MsgNotifyManager.MsgCacheInfo)localMessage.msgInfoList.get(i);
        if ((localMsgCacheInfo.jdField_a_of_type_Int == 3000) || (localMsgCacheInfo.jdField_a_of_type_Int == 1))
        {
          if (localMsgCacheInfo.c != paramMessageRecord.shmsgseq) {
            break label484;
          }
          j = i;
        }
      }
      for (;;)
      {
        if (j == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "revokeNotificationMsg, not in cache");
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
            paramMessageRecord = (MsgNotifyManager.MsgCacheInfo)localMessage.msgInfoList.get(k - 2);
            MessageRecord.copyMessageRecordBaseField(localMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.jdField_a_of_type_JavaLangString, paramMessageRecord.jdField_a_of_type_Int, paramMessageRecord.jdField_a_of_type_Long));
            localMessage.emoRecentMsg = null;
            localMessage.fileType = -1;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessage);
            if (QLog.isColorLevel()) {
              QLog.d("notification", 2, "revokeNotificationMsg, match the last msg");
            }
          }
          localMessage.msgInfoList.remove(j);
          localMessage.counter -= 1;
          if ((localMessage.counter <= 0) || (localMessage.msgInfoList.isEmpty())) {
            this.jdField_a_of_type_JavaUtilList.remove(localMessage);
          }
          if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
          for (paramMessageRecord = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);; paramMessageRecord = null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord);
            return;
          }
          j = -1;
        }
      }
      label484:
      i -= 1;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "removeNotification uin" + paramString + ",type:" + paramInt);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    Object localObject = null;
    for (;;)
    {
      QQMessageFacade.Message localMessage;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label295;
        }
        localMessage = (QQMessageFacade.Message)localIterator.next();
        if (((paramInt == localMessage.istroop) || ((MsgProxyUtils.c(paramInt)) && (MsgProxyUtils.c(localMessage.istroop)))) && (localMessage.frienduin.equals(paramString)))
        {
          localMessage.counter = 0;
          localIterator.remove();
          bool1 = true;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder().append("removeNotification remove:").append(bool1).append(",preMsg is null");
            if (localObject != null) {
              break label283;
            }
            bool2 = true;
            QLog.d("notification", 2, bool2 + ",iterator.hasNext():" + localIterator.hasNext());
          }
          if (bool1)
          {
            if ((localObject != null) || (!localIterator.hasNext())) {
              break label289;
            }
            paramString = (QQMessageFacade.Message)localIterator.next();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString);
          }
          return;
        }
      }
      localObject = localMessage;
      continue;
      label283:
      boolean bool2 = false;
      continue;
      label289:
      paramString = localObject;
      continue;
      label295:
      boolean bool1 = false;
    }
  }
  
  public int b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        QQMessageFacade.Message localMessage = (QQMessageFacade.Message)localIterator.next();
        if (localMessage.istroop != 1008)
        {
          if (7000 != localMessage.istroop) {
            break label117;
          }
          SubAccountManager localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
          if (localSubAccountManager == null) {
            break label108;
          }
          j = localSubAccountManager.b(localMessage.frienduin);
          break label110;
        }
      }
      return i;
    }
    label108:
    int j = 0;
    label110:
    int i = j + i;
    for (;;)
    {
      break;
      label117:
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
        QQMessageFacade.Message localMessage = (QQMessageFacade.Message)localIterator.next();
        localMessage.counter = 0;
        localMessage.msgInfoList = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(QQMessageFacade.Message paramMessage)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Object localObject = a(this.jdField_a_of_type_JavaUtilList, paramMessage);
      if (localObject != null)
      {
        paramMessage.msgInfoList = ((QQMessageFacade.Message)localObject).msgInfoList;
        this.jdField_a_of_type_JavaUtilList.set(this.jdField_a_of_type_JavaUtilList.indexOf(localObject), paramMessage);
        if (paramMessage.msgInfoList == null) {
          paramMessage.msgInfoList = new ArrayList();
        }
        localObject = new MsgNotifyManager.MsgCacheInfo(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq, paramMessage.msgUid, paramMessage.shmsgseq);
        paramMessage.msgInfoList.add(localObject);
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyManager
 * JD-Core Version:    0.7.0.1
 */