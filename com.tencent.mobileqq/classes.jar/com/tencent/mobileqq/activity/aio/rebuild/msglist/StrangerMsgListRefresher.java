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
    return (this.a.a().jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((MsgProxyUtils.l(this.a.a().jdField_a_of_type_Int)) || (this.a.a().jdField_a_of_type_Int == paramMessageRecord.istroop) || ((UinTypeUtil.b(this.a.a().jdField_a_of_type_Int)) && (UinTypeUtil.b(paramMessageRecord.istroop))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.StrangerMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */