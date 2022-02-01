package com.tencent.mobileqq.app.msgnotify;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgNotifyManager
{
  public static MsgNotifyManager.Callback a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Message jdField_a_of_type_ComTencentImcoreMessageMessage;
  private final List<Message> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public MsgNotifyManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private int a(Message paramMessage)
  {
    return jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager$Callback.a(paramMessage, this);
  }
  
  private Message a(List<Message> paramList, MessageRecord paramMessageRecord)
  {
    if (paramList != null)
    {
      if (paramMessageRecord == null) {
        return null;
      }
      int i = 0;
      while (i < paramList.size())
      {
        Message localMessage = (Message)paramList.get(i);
        if (a(localMessage, paramMessageRecord)) {
          return localMessage;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void a(int paramInt, Message paramMessage)
  {
    jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager$Callback.a(paramInt, paramMessage, this);
  }
  
  private void a(Message paramMessage1, Message paramMessage2)
  {
    jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager$Callback.a(paramMessage1, paramMessage2, this);
  }
  
  public static void a(MsgNotifyManager.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager$Callback = paramCallback;
  }
  
  private void a(String paramString, int paramInt, Message paramMessage)
  {
    jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager$Callback.a(paramString, paramInt, paramMessage, this);
  }
  
  private boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return UinTypeUtil.a(paramMessageRecord1.frienduin, paramMessageRecord1.istroop).equals(UinTypeUtil.a(paramMessageRecord2.frienduin, paramMessageRecord2.istroop));
  }
  
  private boolean a(boolean paramBoolean, Message paramMessage)
  {
    return jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager$Callback.a(paramBoolean, paramMessage, this);
  }
  
  public int a()
  {
    return a(false);
  }
  
  public int a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Message localMessage = (Message)localIterator.next();
        if (localMessage.istroop == paramInt) {
          i += localMessage.counter;
        }
      }
      return i;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Message localMessage = (Message)localIterator.next();
        if ((localMessage.istroop != 1044) && (localMessage.istroop != 1045) && (!a(paramBoolean, localMessage))) {
          i += localMessage.counter;
        }
      }
      return i;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface;
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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showNotificationMsg type:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("notification", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isBackgroundPause)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        return;
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((Message)((Iterator)localObject1).next()).istroop == paramInt) {
            ((Iterator)localObject1).remove();
          }
        }
        localObject1 = null;
        if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          localObject1 = (Message)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        }
        a(paramInt, (Message)localObject1);
        return;
      }
    }
  }
  
  public void a(Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageMessage = paramMessage;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("cancelNotificationWhenRevokeMessage, ");
      ((StringBuilder)???).append(paramMessageRecord);
      QLog.d("notification", 2, ((StringBuilder)???).toString());
    }
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface.isBackgroundPause) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Message localMessage = a(this.jdField_a_of_type_JavaUtilList, paramMessageRecord);
        if ((localMessage != null) && (localMessage.msgInfoList != null) && (!localMessage.msgInfoList.isEmpty()))
        {
          int k = localMessage.msgInfoList.size();
          int j = k - 1;
          i = j;
          if (i < 0) {
            break label521;
          }
          MsgCacheInfo localMsgCacheInfo = (MsgCacheInfo)localMessage.msgInfoList.get(i);
          if ((localMsgCacheInfo.jdField_a_of_type_Int != 3000) && (localMsgCacheInfo.jdField_a_of_type_Int != 1)) {
            if ((localMsgCacheInfo.b != paramMessageRecord.msgUid) || (localMsgCacheInfo.c != paramMessageRecord.shmsgseq)) {
              break label514;
            }
          } else {
            if (localMsgCacheInfo.c != paramMessageRecord.shmsgseq) {
              break label514;
            }
          }
          if (i == -1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("notification", 2, "cancelNotificationWhenRevokeMessage, not in cache");
            }
            return;
          }
          paramMessageRecord = null;
          if ((i == j) && (k > 1))
          {
            localMsgCacheInfo = (MsgCacheInfo)localMessage.msgInfoList.get(k - 2);
            MessageRecord.copyMessageRecordBaseField(localMessage, ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(localMsgCacheInfo.jdField_a_of_type_JavaLangString, localMsgCacheInfo.jdField_a_of_type_Int, localMsgCacheInfo.jdField_a_of_type_Long));
            localMessage.emoRecentMsg = null;
            localMessage.fileType = -1;
            ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).decodeMsg(localMessage);
            if (QLog.isColorLevel()) {
              QLog.d("notification", 2, "cancelNotificationWhenRevokeMessage, match the last msg");
            }
          }
          localMessage.msgInfoList.remove(i);
          localMessage.counter -= 1;
          if ((localMessage.counter <= 0) || (localMessage.msgInfoList.isEmpty())) {
            this.jdField_a_of_type_JavaUtilList.remove(localMessage);
          }
          if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
            paramMessageRecord = (Message)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
          }
          a(localMessage, paramMessageRecord);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "cancelNotificationWhenRevokeMessage, conversation not in cache");
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, new Object[] { "cancelNotificationWhenRevokeMessage, isBackground: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.isBackgroundPause) });
      }
      return;
      label514:
      i -= 1;
      continue;
      label521:
      int i = -1;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("removeNotification uin");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",type:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("notification", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isBackgroundPause)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        return;
      }
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        bool1 = localIterator.hasNext();
        bool2 = true;
        if (!bool1) {
          break label341;
        }
        localObject2 = (Message)localIterator.next();
        if (((paramInt != ((Message)localObject2).istroop) && ((!UinTypeUtil.b(paramInt)) || (!UinTypeUtil.b(((Message)localObject2).istroop)))) || (!((Message)localObject2).frienduin.equals(paramString))) {
          break label334;
        }
        ((Message)localObject2).counter = 0;
        localIterator.remove();
        bool1 = true;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("removeNotification remove:");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append(",preMsg is null");
          if (localObject1 != null) {
            break label346;
          }
          ((StringBuilder)localObject2).append(bool2);
          ((StringBuilder)localObject2).append(",iterator.hasNext():");
          ((StringBuilder)localObject2).append(localIterator.hasNext());
          QLog.d("notification", 2, ((StringBuilder)localObject2).toString());
        }
        if (bool1)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (localIterator.hasNext()) {
              localObject2 = (Message)localIterator.next();
            }
          }
          a(paramString, paramInt, (Message)localObject2);
        }
        return;
      }
      return;
      label334:
      localObject1 = localObject2;
      continue;
      label341:
      boolean bool1 = false;
      continue;
      label346:
      boolean bool2 = false;
    }
  }
  
  public int b()
  {
    return b(false);
  }
  
  public int b(boolean paramBoolean)
  {
    int i;
    label131:
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        Message localMessage = (Message)localIterator.next();
        if ((localMessage.istroop != 1008) && (localMessage.istroop != 1044) && (localMessage.istroop != 1045) && (!a(paramBoolean, localMessage)))
        {
          if (7000 != localMessage.istroop) {
            break label131;
          }
          i += a(localMessage);
        }
      }
      return i;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Message localMessage = (Message)localIterator.next();
        localMessage.counter = 0;
        localMessage.msgInfoList = null;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
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
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.add(paramMessage);
      }
      if (paramMessage.msgInfoList == null) {
        paramMessage.msgInfoList = new ArrayList();
      }
      localObject = new MsgCacheInfo(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq, paramMessage.msgUid, paramMessage.shmsgseq);
      paramMessage.msgInfoList.add(localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyManager
 * JD-Core Version:    0.7.0.1
 */