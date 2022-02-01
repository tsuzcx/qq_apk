package com.tencent.imcore.message;

import com.tencent.imcore.message.msgboxappender.IMsgBoxAppender;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class C2CMessageManager$MsgBoxAppender
{
  private MessageRecord b;
  private EntityManager c;
  private Map<String, RecentUser> d;
  private RecentUserProxy e;
  private IConversationFacade f;
  private String g;
  private int h;
  private long i;
  
  public C2CMessageManager$MsgBoxAppender(MessageRecord paramMessageRecord, EntityManager paramEntityManager, Map<String, RecentUser> paramMap, RecentUserProxy paramRecentUserProxy, IConversationFacade paramIConversationFacade, String paramString, int paramInt, long paramLong)
  {
    this.b = paramEntityManager;
    this.c = paramMap;
    this.d = paramRecentUserProxy;
    this.e = paramIConversationFacade;
    this.f = paramString;
    this.g = paramInt;
    this.h = paramLong;
    Object localObject;
    this.i = localObject;
  }
  
  public String a()
  {
    return this.g;
  }
  
  public int b()
  {
    return this.h;
  }
  
  public long c()
  {
    return this.i;
  }
  
  public MsgBoxAppender d()
  {
    Iterator localIterator = this.a.b.getRegistry().v().iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = ((IMsgBoxAppender)localIterator.next()).a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
      if (((Boolean)arrayOfObject[0]).booleanValue())
      {
        this.g = ((String)arrayOfObject[1]);
        this.h = ((Integer)arrayOfObject[2]).intValue();
        this.i = ((Long)arrayOfObject[3]).longValue();
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager.MsgBoxAppender
 * JD-Core Version:    0.7.0.1
 */