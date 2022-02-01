package com.tencent.mobileqq.activity.history.helper;

import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;

public class ContentHelper
{
  public static String a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForText))
    {
      paramMessageRecord = (MessageForText)paramMessageRecord;
      if (paramMessageRecord.sb != null) {
        return paramMessageRecord.sb.toString();
      }
      return paramMessageRecord.msg;
    }
    if ((paramMessageRecord instanceof MessageForMixedMsg)) {
      return String.valueOf(MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)paramMessageRecord));
    }
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      paramMessageRecord = (MessageForReplyText)paramMessageRecord;
      if (paramMessageRecord.sb != null) {
        return paramMessageRecord.sb.toString();
      }
      return paramMessageRecord.msg;
    }
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      return ((MessageForArkApp)paramMessageRecord).getJumpUrl();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.helper.ContentHelper
 * JD-Core Version:    0.7.0.1
 */