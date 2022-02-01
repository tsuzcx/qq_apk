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
      if (UinTypeUtil.k(paramMessageRecord.msgtype)) {
        this.b -= 1;
      }
    }
    else {
      return;
    }
    if ((ConversationFacade.a(this.jdField_a_of_type_Int)) && (ConversationFacade.a.b(paramMessageRecord)))
    {
      this.b -= 1;
      return;
    }
    String str;
    if (paramMessageRecord.isLongMsg())
    {
      if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(UinTypeUtil.a(paramMessageRecord))) && (ConversationFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade, paramMessageRecord, (Set)this.jdField_a_of_type_JavaUtilMap.get(UinTypeUtil.a(paramMessageRecord)))))
      {
        this.b -= 1;
        return;
      }
      if (this.jdField_a_of_type_JavaUtilSet == null) {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
      }
      str = UinTypeUtil.a(paramMessageRecord);
      if (!ConversationFacade.a.f(paramMessageRecord)) {
        break label269;
      }
      if (ConversationFacade.a.a(ConversationFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade), paramMessageRecord))
      {
        this.b -= 1;
        return;
      }
      if (this.jdField_a_of_type_JavaUtilSet.contains(str))
      {
        this.b -= 1;
        return;
      }
      this.jdField_a_of_type_JavaUtilSet.add(str);
    }
    for (;;)
    {
      this.c += this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade.a(paramMessageRecord);
      this.d += this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade.b(paramMessageRecord);
      return;
      label269:
      if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
        this.jdField_a_of_type_JavaUtilSet.remove(str);
      }
    }
  }
  
  private void b(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramLong <= this.jdField_a_of_type_Long)
    {
      if (!paramMessageRecord.isLongMsg()) {
        break label143;
      }
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
      }
      localObject = UinTypeUtil.a(paramMessageRecord);
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(UinTypeUtil.a(paramMessageRecord))) {
        break label110;
      }
      localObject = (Set)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      if ((localObject != null) && (!((Set)localObject).isEmpty()) && (!ConversationFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade, paramMessageRecord, (Set)localObject))) {
        ((Set)localObject).add(paramMessageRecord);
      }
    }
    label110:
    while ((!UinTypeUtil.f(paramMessageRecord.msgtype)) || (paramMessageRecord.isread))
    {
      Object localObject;
      return;
      HashSet localHashSet = new HashSet();
      localHashSet.add(paramMessageRecord);
      this.jdField_a_of_type_JavaUtilMap.put(localObject, localHashSet);
      return;
    }
    label143:
    this.b += 1;
    this.c += this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade.a(paramMessageRecord);
    this.d += this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade.b(paramMessageRecord);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public UnreadCounter a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (ConversationFacade.a(this.jdField_a_of_type_Int)) {}
      for (long l = localMessageRecord.shmsgseq;; l = localMessageRecord.time)
      {
        b(localMessageRecord, l);
        a(localMessageRecord, l);
        break;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationFacade.UnreadCounter
 * JD-Core Version:    0.7.0.1
 */