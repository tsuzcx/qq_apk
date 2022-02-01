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
    return (super.a(paramMessageRecord)) && (ConfessMsgUtil.a(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.a.a().jdField_a_of_type_Int, this.a.a().e));
  }
  
  protected boolean b(MessageRecord paramMessageRecord)
  {
    BaseSessionInfo localBaseSessionInfo = this.a.a();
    return (paramMessageRecord.frienduin.equals(localBaseSessionInfo.jdField_a_of_type_JavaLangString)) && (ConfessMsgUtil.a(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), localBaseSessionInfo.jdField_a_of_type_Int, localBaseSessionInfo.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */