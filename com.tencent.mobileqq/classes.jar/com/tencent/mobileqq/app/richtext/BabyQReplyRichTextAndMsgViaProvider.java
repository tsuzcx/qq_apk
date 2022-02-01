package com.tencent.mobileqq.app.richtext;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import tencent.im.msg.im_msg_body.RichText;

public class BabyQReplyRichTextAndMsgViaProvider
  implements IRichTextAndMsgViaProvider
{
  public Object[] a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    if (paramMessageRecord.msgtype == -5016) {
      paramRichText = MessageProtoCodec.c((MessageForArkBabyqReply)paramMessageRecord, false);
    }
    return new Object[] { paramRichText, Integer.valueOf(paramInt) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.richtext.BabyQReplyRichTextAndMsgViaProvider
 * JD-Core Version:    0.7.0.1
 */