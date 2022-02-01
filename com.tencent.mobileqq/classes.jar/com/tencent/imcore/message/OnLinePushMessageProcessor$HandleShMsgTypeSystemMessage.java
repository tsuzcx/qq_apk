package com.tencent.imcore.message;

import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;

class OnLinePushMessageProcessor$HandleShMsgTypeSystemMessage
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MsgInfo jdField_a_of_type_OnlinePushPackMsgInfo;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public OnLinePushMessageProcessor$HandleShMsgTypeSystemMessage(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, long paramLong, MsgInfo paramMsgInfo, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_OnlinePushPackMsgInfo = paramMsgInfo;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public HandleShMsgTypeSystemMessage a()
  {
    this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getMsgHandler().a().a(2);
    this.jdField_b_of_type_Long = 9998L;
    this.jdField_b_of_type_Int = (-1006 - (this.jdField_a_of_type_Int - 187));
    this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getMsgHandler().a().a(this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_OnlinePushPackMsgInfo.uMsgTime, this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgSeq);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.HandleShMsgTypeSystemMessage
 * JD-Core Version:    0.7.0.1
 */