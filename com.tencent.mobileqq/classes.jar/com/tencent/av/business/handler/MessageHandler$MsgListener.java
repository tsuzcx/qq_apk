package com.tencent.av.business.handler;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public abstract class MessageHandler$MsgListener<T1 extends MessageMicro, T2 extends MessageMicro>
{
  protected final void a(long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = MessageHandler.a(this);
    ((MessageHandler.ClassInfo)localObject).a("QAVMessageHandler", paramLong);
    if ((((MessageHandler.ClassInfo)localObject).a != null) && (((MessageHandler.ClassInfo)localObject).b != null)) {}
    try
    {
      MessageMicro localMessageMicro = (MessageMicro)((MessageHandler.ClassInfo)localObject).a.newInstance();
      localObject = (MessageMicro)((MessageHandler.ClassInfo)localObject).b.newInstance();
      paramToServiceMsg = paramToServiceMsg.getWupBuffer();
      if ((paramToServiceMsg != null) && (paramToServiceMsg.length > 4)) {
        localMessageMicro.mergeFrom(paramToServiceMsg, 4, paramToServiceMsg.length - 4);
      }
      ((MessageMicro)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
      a(paramLong, paramFromServiceMsg.isSuccess(), localMessageMicro, (MessageMicro)localObject, paramObject);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("QAVMessageHandler", 1, "onSendMsgRsp, Exception, seq[" + paramLong + "]", paramToServiceMsg);
    }
  }
  
  public abstract void a(long paramLong, boolean paramBoolean, T1 paramT1, T2 paramT2, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.handler.MessageHandler.MsgListener
 * JD-Core Version:    0.7.0.1
 */