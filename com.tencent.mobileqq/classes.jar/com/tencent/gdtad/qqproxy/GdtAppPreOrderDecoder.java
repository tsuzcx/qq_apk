package com.tencent.gdtad.qqproxy;

import android.text.TextUtils;
import com.tencent.ad.tangram.preorder.AdAppPreOrderManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.SubTypeDecoder;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.gdt.MsgType0x210_SubMsgType0x13c.MsgBody;

public class GdtAppPreOrderDecoder
  implements SubTypeDecoder
{
  private void a(msg_comm.Msg paramMsg, MessageHandler paramMessageHandler)
  {
    MessageProtoCodec.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    GdtLog.a("GdtAppPreOrderDecoder", "OFFLINE SubType0x13c receive");
    paramList = new MsgType0x210_SubMsgType0x13c.MsgBody();
    try
    {
      paramList.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
      paramMsgType0x210 = paramList.str_msg_id.get();
      GdtLog.a("GdtAppPreOrderDecoder", "msg_id:" + paramMsgType0x210);
      if (TextUtils.isEmpty(paramMsgType0x210)) {
        return;
      }
      long l = paramMsg.msg_head.to_uin.get();
      GdtLog.a("GdtAppPreOrderDecoder", "lToUin:" + l);
      AdAppPreOrderManager.INSTANCE.processPublishMessage(paramMsgType0x210, String.valueOf(l), System.currentTimeMillis());
    }
    catch (InvalidProtocolBufferMicroException paramMsgType0x210)
    {
      for (;;)
      {
        paramMsgType0x210.printStackTrace();
      }
    }
    catch (Exception paramMsgType0x210)
    {
      for (;;)
      {
        paramMsgType0x210.printStackTrace();
      }
    }
    a(paramMsg, paramMessageHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.qqproxy.GdtAppPreOrderDecoder
 * JD-Core Version:    0.7.0.1
 */