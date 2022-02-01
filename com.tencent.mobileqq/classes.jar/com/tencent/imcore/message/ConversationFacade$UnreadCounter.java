package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ConversationFacade$UnreadCounter
{
  private int b;
  private List<MessageRecord> c;
  private long d;
  private int e;
  private int f;
  private int g;
  private Set<String> h;
  private Map<String, Set<MessageRecord>> i;
  
  public ConversationFacade$UnreadCounter(int paramInt1, List<MessageRecord> paramList, long paramLong, int paramInt2, int paramInt3, int paramInt4, Set<String> paramSet, Map<String, Set<MessageRecord>> paramMap)
  {
    this.b = paramList;
    this.c = paramLong;
    this.d = ???;
    this.e = paramInt3;
    this.f = paramInt4;
    this.g = paramSet;
    this.h = paramMap;
    Object localObject;
    this.i = localObject;
  }
  
  private void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramLong > this.d)
    {
      if (UinTypeUtil.m(paramMessageRecord.msgtype))
      {
        this.e -= 1;
        return;
      }
      if ((ConversationFacade.a(this.b)) && (ConversationFacade.a.b(paramMessageRecord)))
      {
        this.e -= 1;
        return;
      }
      if (paramMessageRecord.isLongMsg())
      {
        Object localObject = this.i;
        if ((localObject != null) && (((Map)localObject).containsKey(UinTypeUtil.a(paramMessageRecord))) && (ConversationFacade.a(this.a, paramMessageRecord, (Set)this.i.get(UinTypeUtil.a(paramMessageRecord)))))
        {
          this.e -= 1;
          return;
        }
        if (this.h == null) {
          this.h = new HashSet();
        }
        localObject = UinTypeUtil.a(paramMessageRecord);
        if (ConversationFacade.a.f(paramMessageRecord))
        {
          if (ConversationFacade.a.a(ConversationFacade.b(this.a), paramMessageRecord))
          {
            this.e -= 1;
            return;
          }
          if (this.h.contains(localObject))
          {
            this.e -= 1;
            return;
          }
          this.h.add(localObject);
        }
        else if (this.h.contains(localObject))
        {
          this.h.remove(localObject);
        }
      }
      this.f += this.a.a(paramMessageRecord);
      this.g += this.a.b(paramMessageRecord);
    }
  }
  
  private void b(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramLong <= this.d) {
      if (paramMessageRecord.isLongMsg())
      {
        if (this.i == null) {
          this.i = new HashMap();
        }
        Object localObject = UinTypeUtil.a(paramMessageRecord);
        if (this.i.containsKey(UinTypeUtil.a(paramMessageRecord)))
        {
          localObject = (Set)this.i.get(localObject);
          if ((localObject != null) && (!((Set)localObject).isEmpty()) && (!ConversationFacade.a(this.a, paramMessageRecord, (Set)localObject))) {
            ((Set)localObject).add(paramMessageRecord);
          }
        }
        else
        {
          HashSet localHashSet = new HashSet();
          localHashSet.add(paramMessageRecord);
          this.i.put(localObject, localHashSet);
        }
      }
      else if ((UinTypeUtil.g(paramMessageRecord.msgtype)) && (!paramMessageRecord.isread))
      {
        this.e += 1;
        this.f += this.a.a(paramMessageRecord);
        this.g += this.a.b(paramMessageRecord);
      }
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public UnreadCounter d()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      long l;
      if (ConversationFacade.a(this.b)) {
        l = localMessageRecord.shmsgseq;
      } else {
        l = localMessageRecord.time;
      }
      b(localMessageRecord, l);
      a(localMessageRecord, l);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationFacade.UnreadCounter
 * JD-Core Version:    0.7.0.1
 */