package com.tencent.mobileqq.activity.aio.core;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.msglist.BaseMsgLoader;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class UnreadTask
  implements Runnable
{
  protected final AIOContext a;
  protected final BaseSessionInfo b;
  protected volatile boolean c = false;
  protected boolean d = false;
  protected int e = 0;
  protected boolean f = false;
  
  public UnreadTask(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    this.b = paramAIOContext.O();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UnreadTask", 2, "read confirm send readconfirm");
    }
    this.a.g().sendEmptyMessageDelayed(16711689, 300000L);
    ThreadManager.post(new UnreadTask.1(this), 8, null, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ChatActivityFacade.a(paramQQAppInterface, this.b);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    Object localObject1 = this.a.e().a().e();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((IMsgUpdateCallback)((Iterator)localObject2).next()).b(this.a, paramChatMessage);
    }
    localObject2 = this.a.e().e();
    ((UnreadTask)localObject2).c();
    ((UnreadTask)localObject2).b(true);
    ((UnreadTask)localObject2).a(true);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((IMsgUpdateCallback)((Iterator)localObject1).next()).c(this.a, paramChatMessage);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void c()
  {
    int i = this.b.a;
    if ((i != 1033) && (i != 1034))
    {
      i = e();
      FightMsgReporter.a(1, 0, this.b.a, i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("UnreadTask", 2, "setReaded");
    }
    this.a.a().getMessageFacade().a(this.b.b, this.b.a, true, true);
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public int d()
  {
    int i = e();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initHaveUnRead count ");
      localStringBuilder.append(i);
      QLog.d("UnreadTask", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public int e()
  {
    return this.a.a().getConversationFacade().a(this.b.b, this.b.a);
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public boolean g()
  {
    return this.d;
  }
  
  public void h()
  {
    if (!this.c)
    {
      if (!StringUtil.isEmpty(this.b.b))
      {
        a(this.a.a());
        c();
        QLog.d("UnreadTask", 1, "setReaded() call");
      }
      this.c = true;
    }
  }
  
  public void run()
  {
    Object localObject = this.a.a();
    if (localObject == null)
    {
      QLog.d("UnreadTask", 1, "UnReadTask mApp==null");
      return;
    }
    List localList1 = this.a.e().c().a(this.a);
    this.e = d();
    boolean bool;
    if (this.e > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    List localList2 = this.a.e().a().b();
    Iterator localIterator = localList2.iterator();
    while (localIterator.hasNext()) {
      ((IReadConfirmCallback)localIterator.next()).a(this.a, localList1, this.e);
    }
    this.a.g().sendEmptyMessageDelayed(16711689, 300000L);
    if ((!this.f) && (!this.d))
    {
      if (this.b.h == -1L) {
        this.b.h = ((QQAppInterface)localObject).getMessageFacade().i(this.b.b, this.b.a);
      }
    }
    else {
      a((QQAppInterface)localObject);
    }
    ((QQAppInterface)localObject).getMessageFacade().a(this.b.b, this.b.a, true, true);
    localObject = localList2.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IReadConfirmCallback)((Iterator)localObject).next()).a(this.a);
    }
    this.c = true;
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.UnreadTask
 * JD-Core Version:    0.7.0.1
 */