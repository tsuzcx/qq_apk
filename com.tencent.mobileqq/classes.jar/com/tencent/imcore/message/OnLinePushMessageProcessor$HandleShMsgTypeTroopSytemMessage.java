package com.tencent.imcore.message;

import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;

class OnLinePushMessageProcessor$HandleShMsgTypeTroopSytemMessage
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MsgInfo jdField_a_of_type_OnlinePushPackMsgInfo;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c;
  
  public OnLinePushMessageProcessor$HandleShMsgTypeTroopSytemMessage(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgInfo paramMsgInfo, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_OnlinePushPackMsgInfo = paramMsgInfo;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public HandleShMsgTypeTroopSytemMessage a()
  {
    this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getMsgHandler().a().a(3);
    if (this.jdField_a_of_type_Int != 45)
    {
      this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getMsgHandler().a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg, this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin, this.jdField_a_of_type_OnlinePushPackMsgInfo.uMsgTime, null);
      this.jdField_b_of_type_Long = 9998L;
      this.c = 32769;
      this.jdField_b_of_type_Int = SystemMsg.getTroopSystemMsgType(this.jdField_a_of_type_Int);
    }
    GroupSystemMsgController.a().a(this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a);
    return this;
  }
  
  public int b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.HandleShMsgTypeTroopSytemMessage
 * JD-Core Version:    0.7.0.1
 */