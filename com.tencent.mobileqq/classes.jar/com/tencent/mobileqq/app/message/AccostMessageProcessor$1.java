package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class AccostMessageProcessor$1
  implements BaseMessageProcessor.RequestBuilder
{
  AccostMessageProcessor$1(AccostMessageProcessor paramAccostMessageProcessor, byte[] paramArrayOfByte, int paramInt) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = AccostMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageAccostMessageProcessor).createToServiceMsg("MessageSvc.GetMsgV4");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->getC2CMessage cChannel: 4vCookies: ");
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfByte);
      localStringBuilder.append(",cSyncFlag:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
    localToServiceMsg.extraData.putByte("cChannel", (byte)4);
    localToServiceMsg.extraData.putByteArray("vCookies", this.jdField_a_of_type_ArrayOfByte);
    localToServiceMsg.extraData.putInt("cSyncFlag", this.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putByte("onlineSyncFlag", (byte)1);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.AccostMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */