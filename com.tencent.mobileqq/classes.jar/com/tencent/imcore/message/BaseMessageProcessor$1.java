package com.tencent.imcore.message;

import absm;
import abso;
import android.os.Bundle;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class BaseMessageProcessor$1
  extends SendMessageHandler.SendMessageRunnable
{
  public BaseMessageProcessor$1(absm paramabsm, abso paramabso, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_Abso.a();
    if (localToServiceMsg == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "prepareRetryRunnable cmd=" + localToServiceMsg.getServiceCmd() + ",reqSeq=" + this.jdField_a_of_type_Long + " timeout: " + this.c + " retryIndex:" + this.jdField_b_of_type_Int);
    }
    localToServiceMsg.extraData.putLong("timeOut", this.c);
    localToServiceMsg.extraData.putLong("startTime", this.jdField_b_of_type_Long);
    localToServiceMsg.extraData.putInt("retryIndex", this.jdField_b_of_type_Int);
    localToServiceMsg.setTimeout(this.c);
    this.this$0.a(localToServiceMsg, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */