package com.tencent.mobileqq.app.generalflag;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class StructLongTextGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    if ((paramMessageRecord instanceof MessageForLongTextMsg))
    {
      paramMessageRecord = (MessageForLongTextMsg)paramMessageRecord;
      bool = paramBoolean;
      if (paramMessageRecord.structingMsg == null) {
        break label153;
      }
      paramGeneralFlags.long_text_flag.set(1);
      paramGeneralFlags.long_text_resid.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.structingMsg.mResid));
    }
    else if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      bool = paramBoolean;
      if (TextUtils.isEmpty(paramMessageRecord.resIDForLongMsg)) {
        break label153;
      }
      paramGeneralFlags.long_text_flag.set(1);
      paramGeneralFlags.long_text_resid.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.resIDForLongMsg));
    }
    else
    {
      bool = paramBoolean;
      if (!(paramMessageRecord instanceof MessageForArkBabyqReply)) {
        break label153;
      }
      paramMessageRecord = (MessageForArkBabyqReply)paramMessageRecord;
      bool = paramBoolean;
      if (TextUtils.isEmpty(paramMessageRecord.resIDForLongMsg)) {
        break label153;
      }
      paramGeneralFlags.long_text_flag.set(1);
      paramGeneralFlags.long_text_resid.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.resIDForLongMsg));
    }
    boolean bool = true;
    label153:
    return bool;
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    return new boolean[] { a(paramMessageRecord, paramBoolean1, paramGeneralFlags), paramBoolean2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.StructLongTextGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */