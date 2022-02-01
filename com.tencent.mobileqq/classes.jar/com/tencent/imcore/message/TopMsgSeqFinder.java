package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class TopMsgSeqFinder
{
  private List<MessageRecord> a;
  private long b;
  private boolean c;
  
  public TopMsgSeqFinder(List<MessageRecord> paramList, long paramLong)
  {
    this.a = paramList;
    this.b = paramLong;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public TopMsgSeqFinder c()
  {
    int i = 0;
    this.c = false;
    List localList = this.a;
    int j;
    if (localList == null) {
      j = 0;
    } else {
      j = localList.size();
    }
    while (i < j)
    {
      if (((MessageRecord)this.a.get(i)).uniseq == this.b) {
        while (i < this.a.size())
        {
          if (UinTypeUtil.c(((MessageRecord)this.a.get(i)).msgtype))
          {
            this.b = ((MessageRecord)this.a.get(i)).uniseq;
            this.c = true;
            return this;
          }
          i += 1;
        }
      }
      i += 1;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.TopMsgSeqFinder
 * JD-Core Version:    0.7.0.1
 */