package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.codec.decoder.Decoder;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

public abstract interface IGrpDisPTTDecoder<MsgHandlerT>
  extends Decoder<MsgHandlerT>
{
  public abstract void a(MsgHandlerT paramMsgHandlerT, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.IGrpDisPTTDecoder
 * JD-Core Version:    0.7.0.1
 */