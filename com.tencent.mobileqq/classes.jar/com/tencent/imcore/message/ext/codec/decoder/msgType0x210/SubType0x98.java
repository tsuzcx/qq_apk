package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.s2c.msgtype0x210.submsgtype0x98.submsgtype0x98.ModBlock;
import tencent.im.s2c.msgtype0x210.submsgtype0x98.submsgtype0x98.MsgBody;

public class SubType0x98
  implements Msg0X210SubTypeDecoder
{
  private static void a(MsgType0x210 paramMsgType0x210)
  {
    submsgtype0x98.MsgBody localMsgBody = new submsgtype0x98.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      label17:
      localMsgBody.uint64_uin.get();
      localMsgBody.uint32_sub_cmd.get();
      ((submsgtype0x98.ModBlock)localMsgBody.msg_mod_block.get()).uint32_op.get();
      return;
    }
    catch (Throwable paramMsgType0x210)
    {
      break label17;
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x98
 * JD-Core Version:    0.7.0.1
 */