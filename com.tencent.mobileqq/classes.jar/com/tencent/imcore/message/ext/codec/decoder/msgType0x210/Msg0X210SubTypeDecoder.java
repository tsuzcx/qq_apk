package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.BaseOnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;

public abstract interface Msg0X210SubTypeDecoder<T extends BaseOnLinePushMessageProcessor>
{
  public abstract MessageRecord a(T paramT, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.Msg0X210SubTypeDecoder
 * JD-Core Version:    0.7.0.1
 */