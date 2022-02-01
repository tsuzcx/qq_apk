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
  private MessageRecord a;
  private Comparator<MessageRecord> b = new LimitMsgLoader.1(this);
  
  public List<ChatMessage> a(@NonNull AIOContext paramAIOContext, boolean paramBoolean)
  {
    paramAIOContext = super.a(paramAIOContext, paramBoolean);
    Collections.sort(paramAIOContext, this.b);
    if ((paramAIOContext != null) && (paramAIOContext.size() > 0)) {
      this.a = ((MessageRecord)paramAIOContext.get(paramAIOContext.size() - 1));
    }
    return paramAIOContext;
  }
  
  public MessageRecord b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.LimitMsgLoader
 * JD-Core Version:    0.7.0.1
 */