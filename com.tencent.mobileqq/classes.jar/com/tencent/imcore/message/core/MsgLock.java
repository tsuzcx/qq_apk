package com.tencent.imcore.message.core;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;

public class MsgLock
  extends ReentrantLock
{
  private final String tag;
  
  public MsgLock(String paramString)
  {
    this.tag = ("MsgLock_" + paramString);
  }
  
  public void lock()
  {
    super.lock();
    QLog.d(this.tag, 2, toString());
  }
  
  public String toString()
  {
    Object localObject = getOwner();
    StringBuilder localStringBuilder = new StringBuilder().append(this.tag).append("@").append(Integer.toHexString(hashCode()));
    if (localObject == null) {}
    for (localObject = "[Unlocked]";; localObject = "[Locked by thread " + ((Thread)localObject).getName() + "]") {
      return (String)localObject;
    }
  }
  
  public void unlock()
  {
    super.unlock();
    QLog.d(this.tag, 2, toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.core.MsgLock
 * JD-Core Version:    0.7.0.1
 */