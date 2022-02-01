package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.data.MessageRecord;

public class StrangerMsgListRefresher
  extends MsgListRefresher
{
  public StrangerMsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (this.a.O().b.equals(paramMessageRecord.frienduin)) && ((MsgProxyUtils.m(this.a.O().a)) || (this.a.O().a == paramMessageRecord.istroop) || ((UinTypeUtil.b(this.a.O().a)) && (UinTypeUtil.b(paramMessageRecord.istroop))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.StrangerMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */