package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageRecord;

public class ConfessMsgListRefresher
  extends MsgListRefresher
{
  public ConfessMsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (super.a(paramMessageRecord)) && (ConfessMsgUtil.a(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.a.O().a, this.a.O().v));
  }
  
  protected boolean b(MessageRecord paramMessageRecord)
  {
    BaseSessionInfo localBaseSessionInfo = this.a.O();
    return (paramMessageRecord.frienduin.equals(localBaseSessionInfo.b)) && (ConfessMsgUtil.a(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), localBaseSessionInfo.a, localBaseSessionInfo.v));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */