package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class TopMsgSeqFinder
{
  private long jdField_a_of_type_Long;
  private List<MessageRecord> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public TopMsgSeqFinder(List<MessageRecord> paramList, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public TopMsgSeqFinder a()
  {
    int i = 0;
    this.jdField_a_of_type_Boolean = false;
    List localList = this.jdField_a_of_type_JavaUtilList;
    int j;
    if (localList == null) {
      j = 0;
    } else {
      j = localList.size();
    }
    while (i < j)
    {
      if (((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(i)).uniseq == this.jdField_a_of_type_Long) {
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (UinTypeUtil.c(((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(i)).msgtype))
          {
            this.jdField_a_of_type_Long = ((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(i)).uniseq;
            this.jdField_a_of_type_Boolean = true;
            return this;
          }
          i += 1;
        }
      }
      i += 1;
    }
    return this;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.TopMsgSeqFinder
 * JD-Core Version:    0.7.0.1
 */