package com.tencent.mobileqq.app.richtext;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import tencent.im.msg.im_msg_body.RichText;

public class StickerMsgRichTextAndMsgViaProvider
  implements IRichTextAndMsgViaProvider
{
  public Object[] a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    paramAppInterface = paramRichText;
    int i = paramInt;
    if (paramMessageRecord.msgtype == -2058) {
      if ((paramMessageRecord instanceof MessageForMarketFace))
      {
        paramMessageRecord = (MessageForMarketFace)paramMessageRecord;
        paramAppInterface = MessageProtoCodec.a(paramMessageRecord);
        i = paramMessageRecord.msgVia;
      }
      else if ((paramMessageRecord instanceof MessageForText))
      {
        paramMessageRecord = (MessageForText)paramMessageRecord;
        paramAppInterface = MessageProtoCodec.a(paramMessageRecord);
        i = paramMessageRecord.msgVia;
      }
      else
      {
        paramAppInterface = paramRichText;
        i = paramInt;
        if ((paramMessageRecord instanceof MessageForPic))
        {
          paramMessageRecord = (MessageForPic)paramMessageRecord;
          paramAppInterface = MessageProtoCodec.a(paramMessageRecord);
          i = paramMessageRecord.msgVia;
        }
      }
    }
    return new Object[] { paramAppInterface, Integer.valueOf(i) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.richtext.StickerMsgRichTextAndMsgViaProvider
 * JD-Core Version:    0.7.0.1
 */