package com.tencent.mobileqq.activity.aio.rebuild.tips;

import android.content.Intent;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageRecord;

public class FoldMsgTipsFilter
  implements IMsgTipsFilter
{
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public CharSequence a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return (paramMessageRecord.msgtype == -2006) && ((paramMessageRecord instanceof MessageForFoldMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.FoldMsgTipsFilter
 * JD-Core Version:    0.7.0.1
 */