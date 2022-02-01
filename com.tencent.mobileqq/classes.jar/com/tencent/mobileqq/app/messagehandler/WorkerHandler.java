package com.tencent.mobileqq.app.messagehandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class WorkerHandler
  extends Handler
{
  private final BaseMessageHandler a;
  private HashSet<String> b = new HashSet();
  private List<Message> c = new ArrayList();
  
  public WorkerHandler(BaseMessageHandler paramBaseMessageHandler, Looper paramLooper)
  {
    super(paramLooper);
    this.a = paramBaseMessageHandler;
  }
  
  public void a()
  {
    synchronized (this.c)
    {
      if (this.c.size() > 0)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
          sendMessage((Message)localIterator.next());
        }
        this.c.clear();
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageHandler", 2, "updateUnreadWorker doC2CUpdateNow");
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(Message paramMessage)
  {
    synchronized (this.b)
    {
      Object localObject = paramMessage.getData();
      if ((localObject != null) && (((Bundle)localObject).containsKey("update_unread_uin")) && (((Bundle)localObject).containsKey("update_unread_time")))
      {
        paramMessage = ((Bundle)localObject).getString("update_unread_uin");
        int i = ((Bundle)localObject).getInt("update_unread_type", 0);
        long l = ((Bundle)localObject).getLong("update_unread_time");
        localObject = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(UinTypeUtil.a(paramMessage, i));
        localStringBuilder.append("&");
        localStringBuilder.append(l);
        ((HashSet)localObject).add(localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    synchronized (this.b)
    {
      HashSet localHashSet2 = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(UinTypeUtil.a(paramString, paramInt));
      localStringBuilder.append("&");
      localStringBuilder.append(paramLong);
      if (localHashSet2.contains(localStringBuilder.toString()))
      {
        localHashSet2 = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(UinTypeUtil.a(paramString, paramInt));
        localStringBuilder.append("&");
        localStringBuilder.append(paramLong);
        localHashSet2.remove(localStringBuilder.toString());
      }
      return;
    }
  }
  
  public boolean b(Message paramMessage)
  {
    synchronized (this.b)
    {
      Object localObject = paramMessage.getData();
      if ((localObject != null) && (((Bundle)localObject).containsKey("update_unread_uin")) && (((Bundle)localObject).containsKey("update_unread_time")))
      {
        paramMessage = ((Bundle)localObject).getString("update_unread_uin");
        int i = ((Bundle)localObject).getInt("update_unread_type", 0);
        long l = ((Bundle)localObject).getLong("update_unread_time");
        localObject = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(UinTypeUtil.a(paramMessage, i));
        localStringBuilder.append("&");
        localStringBuilder.append(l);
        boolean bool = ((HashSet)localObject).contains(localStringBuilder.toString());
        return bool;
      }
      return false;
    }
  }
  
  public void c(Message paramMessage)
  {
    synchronized (this.c)
    {
      this.c.add(paramMessage);
      return;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageHandler", 2, "updateUnreadWorker C2CWorkerTimeout");
      }
      a();
      return;
    }
    Object localObject = paramMessage.getData();
    if ((localObject != null) && (((Bundle)localObject).containsKey("update_unread_uin")) && (((Bundle)localObject).containsKey("update_unread_time")))
    {
      paramMessage = ((Bundle)localObject).getString("update_unread_uin");
      i = ((Bundle)localObject).getInt("update_unread_type", 0);
      long l = ((Bundle)localObject).getLong("update_unread_time");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("msg update_c2c_unread-->uin:");
        ((StringBuilder)localObject).append(paramMessage);
        ((StringBuilder)localObject).append(", uinType:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", lastReadTime:");
        ((StringBuilder)localObject).append(l);
        QLog.d("MessageHandler", 2, ((StringBuilder)localObject).toString());
      }
      a(paramMessage, i, l);
      ((IMessageFacade)this.a.b().getRuntimeService(IMessageFacade.class, "")).setReadFrom(paramMessage, i, l);
      this.a.a(2002, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.messagehandler.WorkerHandler
 * JD-Core Version:    0.7.0.1
 */