package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;

public class DecodeMsg
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private C2CMessageProcessor jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor;
  private DecodeProtoPkgContext jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  private msg_comm.UinPairMsg jdField_a_of_type_MsfMsgcommMsg_comm$UinPairMsg;
  private ArrayList<msg_comm.Msg> b;
  
  public DecodeMsg(C2CMessageProcessor paramC2CMessageProcessor, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, ArrayList<MessageRecord> paramArrayList, ArrayList<msg_comm.Msg> paramArrayList1, StringBuilder paramStringBuilder, DecodeProtoPkgContext paramDecodeProtoPkgContext, int paramInt)
  {
    this.jdField_a_of_type_MsfMsgcommMsg_comm$UinPairMsg = paramUinPairMsg;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.b = paramArrayList1;
    this.jdField_a_of_type_JavaLangStringBuilder = paramStringBuilder;
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext = paramDecodeProtoPkgContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor = paramC2CMessageProcessor;
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    return C2CMessageProcessor.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong2, paramLong1, this.jdField_a_of_type_MsfMsgcommMsg_comm$UinPairMsg.peer_uin.get(), this.jdField_a_of_type_MsfMsgcommMsg_comm$UinPairMsg);
  }
  
  private static void a(DecodeProtoPkgContext paramDecodeProtoPkgContext, ArrayList<MessageRecord> paramArrayList, C2CMessageProcessor paramC2CMessageProcessor, long paramLong1, long paramLong2, List<MessageRecord> paramList)
  {
    C2CMessageProcessor.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramC2CMessageProcessor, paramArrayList, paramLong1, paramLong2, paramList, paramDecodeProtoPkgContext);
  }
  
  public DecodeMsg a()
  {
    for (;;)
    {
      try
      {
        Object localObject = (msg_comm.Msg)this.b.get(this.jdField_a_of_type_Int);
        msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get();
        if (!((msg_comm.Msg)localObject).msg_head.has())
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("<---decodeC2CMessagePackage: msgList[");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
            ((StringBuilder)localObject).append("] : msg doesn't has msgHead.");
            QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject).toString());
            return this;
          }
        }
        else
        {
          long l3 = localMsgHead.to_uin.get();
          long l1 = localMsgHead.from_uin.get();
          long l4 = localMsgHead.from_uin.get();
          long l2 = localMsgHead.msg_time.get();
          long l5 = this.jdField_a_of_type_Long;
          bool1 = false;
          if (l2 <= l5) {
            break label304;
          }
          bool2 = false;
          l3 = a(l3, l4);
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext.i = true;
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext.jdField_a_of_type_JavaLangString = String.valueOf(l3);
          if (C2CMessageProcessor.a(this.jdField_a_of_type_JavaLangStringBuilder, this.jdField_a_of_type_Int, bool1, l2, l3, this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
            return this;
          }
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext.jdField_a_of_type_Boolean = bool1;
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext.g = l3;
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext.h = bool2;
          localObject = this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a((msg_comm.Msg)localObject, this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext);
          a(this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor, l1, l3, (List)localObject);
          return this;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", localException);
        }
        return this;
      }
      return this;
      label304:
      boolean bool1 = true;
      boolean bool2 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.DecodeMsg
 * JD-Core Version:    0.7.0.1
 */