package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.BaseMsgLoader;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LimitMsgLoader
  extends BaseMsgLoader
{
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private Comparator<MessageRecord> jdField_a_of_type_JavaUtilComparator = new LimitMsgLoader.1(this);
  
  public MessageRecord a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public List<ChatMessage> a(@NonNull AIOContext paramAIOContext, boolean paramBoolean)
  {
    paramAIOContext = super.a(paramAIOContext, paramBoolean);
    Collections.sort(paramAIOContext, this.jdField_a_of_type_JavaUtilComparator);
    if ((paramAIOContext != null) && (paramAIOContext.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)paramAIOContext.get(paramAIOContext.size() - 1));
    }
    return paramAIOContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.LimitMsgLoader
 * JD-Core Version:    0.7.0.1
 */