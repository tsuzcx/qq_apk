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
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager.a(this.jdField_a_of_type_ComTencentImcoreMessageMsgProxy.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int), null, null);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.MsgProxy", 1, "delete slowtable excep :", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyCallback.1
 * JD-Core Version:    0.7.0.1
 */