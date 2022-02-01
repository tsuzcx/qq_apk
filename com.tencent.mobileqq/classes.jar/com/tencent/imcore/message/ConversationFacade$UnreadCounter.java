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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private List<MessageRecord> jdField_a_of_type_JavaUtilList;
  private Map<String, Set<MessageRecord>> jdField_a_of_type_JavaUtilMap;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private int b;
  private int c;
  private int d;
  
  public ConversationFacade$UnreadCounter(int paramInt1, List<MessageRecord> paramList, long paramLong, int paramInt2, int paramInt3, int paramInt4, Set<String> paramSet, Map<String, Set<MessageRecord>> paramMap)
  {
    this.jdField_a_of_type_Int = paramList;
    this.jdField_a_of_type_JavaUtilList = paramLong;
    this.jdField_a_of_type_Long = ???;
    this.b = paramInt3;
    this.c = paramInt4;
    this.d = paramSet;
    this.jdField_a_of_type_JavaUtilSet = paramMap;
    Object localObject;
    this.jdField_a_of_type_JavaUtilMap = localObject;
  }
  
  private void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramLong > this.jdField_a_of_type_Long)
    {
      if (UinTypeUtil.k(paramMessageRecord.msgtype))
      {
        this.b -= 1;
        return;
      }
      if ((ConversationFacade.a(this.jdField_a_of_type_Int)) && (ConversationFacade.a.b(paramMessageRecord)))
      {
        this.b -= 1;
        return;
      }
      if (paramMessageRecord.isLongMsg())
      {
        Object localObject = this.jdField_a_of_type_JavaUtilMap;
        if ((localObject != null) && (((Map)localObject).containsKey(UinTypeUtil.a(paramMessageRecord))) && (ConversationFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade, paramMessageRecord, (Set)this.jdField_a_of_type_JavaUtilMap.get(UinTypeUtil.a(paramMessageRecord)))))
        {
          this.b -= 1;
          return;
        }
        if (this.jdField_a_of_type_JavaUtilSet == null) {
          this.jdField_a_of_type_JavaUtilSet = new HashSet();
        }
        localObject = UinTypeUtil.a(paramMessageRecord);
        if (ConversationFacade.a.f(paramMessageRecord))
        {
          if (ConversationFacade.a.a(ConversationFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade), paramMessageRecord))
          {
            this.b -= 1;
            return;
          }
          if (this.jdField_a_of_type_JavaUtilSet.contains(localObject))
          {
            this.b -= 1;
            return;
          }
          this.jdField_a_of_type_JavaUtilSet.add(localObject);
        }
        else if (this.jdField_a_of_type_JavaUtilSet.contains(localObject))
        {
          this.jdField_a_of_type_JavaUtilSet.remove(localObject);
        }
      }
      this.c += this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade.a(paramMessageRecord);
      this.d += this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade.b(paramMessageRecord);
    }
  }
  
  private void b(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramLong <= this.jdField_a_of_type_Long) {
      if (paramMessageRecord.isLongMsg())
      {
        if (this.jdField_a_of_type_JavaUtilMap == null) {
          this.jdField_a_of_type_JavaUtilMap = new HashMap();
        }
        Object localObject = UinTypeUtil.a(paramMessageRecord);
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(UinTypeUtil.a(paramMessageRecord)))
        {
          localObject = (Set)this.jdField_a_of_type_JavaUtilMap.get(localObject);
          if ((localObject != null) && (!((Set)localObject).isEmpty()) && (!ConversationFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade, paramMessageRecord, (Set)localObject))) {
            ((Set)localObject).add(paramMessageRecord);
          }
        }
        else
        {
          HashSet localHashSet = new HashSet();
          localHashSet.add(paramMessageRecord);
          this.jdField_a_of_type_JavaUtilMap.put(localObject, localHashSet);
        }
      }
      else if ((UinTypeUtil.f(paramMessageRecord.msgtype)) && (!paramMessageRecord.isread))
      {
        this.b += 1;
        this.c += this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade.a(paramMessageRecord);
        this.d += this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade.b(paramMessageRecord);
      }
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public UnreadCounter a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      long l;
      if (ConversationFacade.a(this.jdField_a_of_type_Int)) {
        l = localMessageRecord.shmsgseq;
      } else {
        l = localMessageRecord.time;
      }
      b(localMessageRecord, l);
      a(localMessageRecord, l);
    }
    return this;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationFacade.UnreadCounter
 * JD-Core Version:    0.7.0.1
 */