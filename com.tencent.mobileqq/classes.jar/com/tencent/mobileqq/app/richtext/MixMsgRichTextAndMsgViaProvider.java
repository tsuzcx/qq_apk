package com.tencent.mobileqq.app.richtext;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import tencent.im.msg.im_msg_body.RichText;

public class MixMsgRichTextAndMsgViaProvider
  implements IRichTextAndMsgViaProvider
{
  public Object[] a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    if (paramMessageRecord.msgtype == -1035) {
      paramRichText = MessageProtoCodec.a((MessageForMixedMsg)paramMessageRecord);
    }
    return new Object[] { paramRichText, Integer.valueOf(paramInt) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.richtext.MixMsgRichTextAndMsgViaProvider
 * JD-Core Version:    0.7.0.1
 */