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
  private AppInterface b;
  private final List<Message> c = new ArrayList();
  private Message d;
  
  public MsgNotifyManager(AppInterface paramAppInterface)
  {
    this.b = paramAppInterface;
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
    a.a(paramInt, paramMessage, this);
  }
  
  private void a(Message paramMessage1, Message paramMessage2)
  {
    a.a(paramMessage1, paramMessage2, this);
  }
  
  public static void a(MsgNotifyManager.Callback paramCallback)
  {
    a = paramCallback;
  }
  
  private void a(String paramString, int paramInt, Message paramMessage)
  {
    a.a(paramString, paramInt, paramMessage, this);
  }
  
  private boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return UinTypeUtil.a(paramMessageRecord1.frienduin, paramMessageRecord1.istroop).equals(UinTypeUtil.a(paramMessageRecord2.frienduin, paramMessageRecord2.istroop));
  }
  
  private boolean a(boolean paramBoolean, Message paramMessage)
  {
    return a.a(paramBoolean, paramMessage, this);
  }
  
  private int c(Message paramMessage)
  {
    return a.a(paramMessage, this);
  }
  
  public int a(int paramInt)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
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
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
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
  
  public void a()
  {
    synchronized (this.c)
    {
      this.c.clear();
      return;
    }
  }
  
  public void a(Message paramMessage)
  {
    this.d = paramMessage;
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
    if ((this.b.isBackgroundPause) && (this.c.size() != 0)) {}
    for (;;)
    {
      synchronized (this.c)
      {
        Message localMessage = a(this.c, paramMessageRecord);
        if ((localMessage != null) && (localMessage.msgInfoList != null) && (!localMessage.msgInfoList.isEmpty()))
        {
          int k = localMessage.msgInfoList.size();
          int j = k - 1;
          i = j;
          if (i < 0) {
            break label548;
          }
          Object localObject2 = (MsgCacheInfo)localMessage.msgInfoList.get(i);
          if ((((MsgCacheInfo)localObject2).b != 3000) && (((MsgCacheInfo)localObject2).b != 1)) {
            if ((((MsgCacheInfo)localObject2).d != paramMessageRecord.msgUid) || (((MsgCacheInfo)localObject2).e != paramMessageRecord.shmsgseq)) {
              break label541;
            }
          } else {
            if (((MsgCacheInfo)localObject2).e != paramMessageRecord.shmsgseq) {
              break label541;
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
            localObject2 = (MsgCacheInfo)localMessage.msgInfoList.get(k - 2);
            localObject2 = ((IMessageFacade)this.b.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(((MsgCacheInfo)localObject2).a, ((MsgCacheInfo)localObject2).b, ((MsgCacheInfo)localObject2).c);
            if (localObject2 == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("notification", 2, "cancelNotificationWhenRevokeMessage, preMsg not in cache");
              }
              return;
            }
            MessageRecord.copyMessageRecordBaseField(localMessage, (MessageRecord)localObject2);
            localMessage.emoRecentMsg = null;
            localMessage.fileType = -1;
            ((IMessageFacade)this.b.getRuntimeService(IMessageFacade.class, "")).decodeMsg(localMessage);
            if (QLog.isColorLevel()) {
              QLog.d("notification", 2, "cancelNotificationWhenRevokeMessage, match the last msg");
            }
          }
          localMessage.msgInfoList.remove(i);
          localMessage.counter -= 1;
          if ((localMessage.counter <= 0) || (localMessage.msgInfoList.isEmpty())) {
            this.c.remove(localMessage);
          }
          if (!this.c.isEmpty()) {
            paramMessageRecord = (Message)this.c.get(this.c.size() - 1);
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
        QLog.d("notification", 2, new Object[] { "cancelNotificationWhenRevokeMessage, isBackground: ", Boolean.valueOf(this.b.isBackgroundPause) });
      }
      return;
      label541:
      i -= 1;
      continue;
      label548:
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
    if (this.b.isBackgroundPause)
    {
      if (this.c.size() == 0) {
        return;
      }
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2;
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
        bool1 = localIterator.hasNext();
        bool2 = true;
        if (!bool1) {
          break label339;
        }
        localObject2 = (Message)localIterator.next();
        if (((paramInt != ((Message)localObject2).istroop) && ((!UinTypeUtil.b(paramInt)) || (!UinTypeUtil.b(((Message)localObject2).istroop)))) || (!((Message)localObject2).frienduin.equals(paramString))) {
          break label332;
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
            break label344;
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
      label332:
      localObject1 = localObject2;
      continue;
      label339:
      boolean bool1 = false;
      continue;
      label344:
      boolean bool2 = false;
    }
  }
  
  public int b(boolean paramBoolean)
  {
    int i;
    label131:
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        Message localMessage = (Message)localIterator.next();
        if ((localMessage.istroop != 1008) && (localMessage.istroop != 1044) && (localMessage.istroop != 1045) && (!a(paramBoolean, localMessage)))
        {
          if (7000 != localMessage.istroop) {
            break label131;
          }
          i += c(localMessage);
        }
      }
      return i;
    }
  }
  
  public Message b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showNotificationMsg type:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("notification", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.b.isBackgroundPause)
    {
      if (this.c.size() == 0) {
        return;
      }
      synchronized (this.c)
      {
        localObject1 = this.c.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((Message)((Iterator)localObject1).next()).istroop == paramInt) {
            ((Iterator)localObject1).remove();
          }
        }
        localObject1 = null;
        if (!this.c.isEmpty()) {
          localObject1 = (Message)this.c.get(this.c.size() - 1);
        }
        a(paramInt, (Message)localObject1);
        return;
      }
    }
  }
  
  public void b(Message paramMessage)
  {
    synchronized (this.c)
    {
      Object localObject = a(this.c, paramMessage);
      if (localObject != null)
      {
        paramMessage.msgInfoList = ((Message)localObject).msgInfoList;
        this.c.set(this.c.indexOf(localObject), paramMessage);
      }
      else
      {
        this.c.add(paramMessage);
      }
      if (paramMessage.msgInfoList == null) {
        paramMessage.msgInfoList = new ArrayList();
      }
      localObject = new MsgCacheInfo(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq, paramMessage.msgUid, paramMessage.shmsgseq);
      paramMessage.msgInfoList.add(localObject);
      return;
    }
  }
  
  public int c()
  {
    return a(false);
  }
  
  public int d()
  {
    return b(false);
  }
  
  public void e()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        Message localMessage = (Message)localIterator.next();
        localMessage.counter = 0;
        localMessage.msgInfoList = null;
      }
      this.c.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public List<Message> f()
  {
    synchronized (this.c)
    {
      List localList2 = (List)((ArrayList)this.c).clone();
      return localList2;
    }
  }
  
  public AppInterface g()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyManager
 * JD-Core Version:    0.7.0.1
 */