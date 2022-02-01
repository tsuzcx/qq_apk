package com.tencent.mobileqq.activity.aio.core.tips;

import android.content.Intent;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.data.MessageRecord;

public abstract interface IMsgTipsFilter
{
  public abstract CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage);
  
  public abstract CharSequence a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage);
  
  public abstract boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter
 * JD-Core Version:    0.7.0.1
 */