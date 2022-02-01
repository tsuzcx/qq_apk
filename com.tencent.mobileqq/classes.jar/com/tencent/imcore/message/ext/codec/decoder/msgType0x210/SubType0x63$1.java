package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.service.QavWrapper.OnReadyListener;

final class SubType0x63$1
  implements QavWrapper.OnReadyListener
{
  SubType0x63$1(MsgType0x210 paramMsgType0x210) {}
  
  public void a(QavWrapper paramQavWrapper)
  {
    paramQavWrapper.b(this.a.vProtobuf);
    paramQavWrapper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x63.1
 * JD-Core Version:    0.7.0.1
 */