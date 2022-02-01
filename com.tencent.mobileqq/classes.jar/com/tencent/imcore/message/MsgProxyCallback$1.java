package com.tencent.imcore.message;

import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.qphone.base.util.QLog;

class MsgProxyCallback$1
  implements Runnable
{
  MsgProxyCallback$1(MsgProxyCallback paramMsgProxyCallback, QSlowTableManager paramQSlowTableManager, MsgProxy paramMsgProxy, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        this.a.a(this.b.l(this.c, this.d), null, null);
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.MsgProxy", 1, "delete slowtable excep :", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyCallback.1
 * JD-Core Version:    0.7.0.1
 */