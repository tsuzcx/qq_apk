package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.oidb.oidb_0xdea.PassThrough;

public class ReplyTextGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      paramMessageRecord = (MessageForReplyText)paramMessageRecord;
      if (paramMessageRecord.isBarrageMsg)
      {
        paramResvAttr.uint32_comment_flag.set(1);
        paramResvAttr.uint64_comment_location.set(paramMessageRecord.barrageTimeLocation);
        oidb_0xdea.PassThrough localPassThrough = new oidb_0xdea.PassThrough();
        localPassThrough.entrance.set(paramMessageRecord.barrageSourceMsgType);
        localPassThrough.uint32_client_type.set(1);
        paramResvAttr.bytes_pass_through.set(ByteStringMicro.copyFrom(localPassThrough.toByteArray()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, new Object[] { "send replay msg, isBarrageMsg: ", Boolean.valueOf(paramMessageRecord.isBarrageMsg), " timeLocation:", Long.valueOf(paramMessageRecord.barrageTimeLocation), " type:", Integer.valueOf(paramMessageRecord.barrageSourceMsgType) });
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    return new boolean[] { paramBoolean1, a(paramMessageRecord, paramBoolean2, paramResvAttr) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.ReplyTextGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */