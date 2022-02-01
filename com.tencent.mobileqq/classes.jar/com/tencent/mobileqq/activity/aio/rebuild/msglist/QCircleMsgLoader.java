package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.BaseMsgLoader;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QCircleMsgLoader
  extends BaseMsgLoader
{
  private Comparator<MessageRecord> a = new QCircleMsgLoader.1(this);
  
  public List<ChatMessage> a(@NonNull AIOContext paramAIOContext, boolean paramBoolean)
  {
    paramAIOContext = super.a(paramAIOContext, paramBoolean);
    Collections.sort(paramAIOContext, this.a);
    return paramAIOContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.QCircleMsgLoader
 * JD-Core Version:    0.7.0.1
 */