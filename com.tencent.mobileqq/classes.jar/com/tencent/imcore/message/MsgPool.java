package com.tencent.imcore.message;

import com.tencent.imcore.message.core.MsgLock;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

public class MsgPool
{
  protected ConcurrentHashMap<String, Lock> a;
  private ConcurrentHashMap<String, List<MessageRecord>> b;
  private ConcurrentHashMap<String, List<MessageRecord>> c;
  
  public MsgPool()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MsgPool() called ");
      localStringBuilder.append(this);
      QLog.d("MsgPool", 2, localStringBuilder.toString());
    }
    this.c = new ConcurrentHashMap();
    this.a = new ConcurrentHashMap();
    this.b = a();
  }
  
  protected ConcurrentHashMap<String, List<MessageRecord>> a()
  {
    return new ConcurrentHashMap();
  }
  
  public Lock a(String paramString)
  {
    if (!this.a.containsKey(paramString)) {
      synchronized (this.a)
      {
        if (!this.a.containsKey(paramString))
        {
          ConcurrentHashMap localConcurrentHashMap2 = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("MsgPool");
          localStringBuilder.append(paramString);
          localConcurrentHashMap2.put(paramString, new MsgLock(localStringBuilder.toString()));
        }
      }
    }
    return (Lock)this.a.get(paramString);
  }
  
  public Lock a(String paramString, int paramInt)
  {
    return a(UinTypeUtil.a(paramString, paramInt));
  }
  
  public ConcurrentHashMap<String, List<MessageRecord>> b()
  {
    return this.b;
  }
  
  public Map<String, List<MessageRecord>> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MsgPool
 * JD-Core Version:    0.7.0.1
 */