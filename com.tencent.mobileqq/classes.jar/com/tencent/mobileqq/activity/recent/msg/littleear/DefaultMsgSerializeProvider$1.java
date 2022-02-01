package com.tencent.mobileqq.activity.recent.msg.littleear;

import com.tencent.mobileqq.activity.recent.msg.IRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.MsgSerialize;

class DefaultMsgSerializeProvider$1
  implements MsgSerialize
{
  DefaultMsgSerializeProvider$1(DefaultMsgSerializeProvider paramDefaultMsgSerializeProvider) {}
  
  public byte[] a(Object paramObject)
  {
    if ((paramObject instanceof IRecentUserMsg)) {
      return ((IRecentUserMsg)paramObject).a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.littleear.DefaultMsgSerializeProvider.1
 * JD-Core Version:    0.7.0.1
 */