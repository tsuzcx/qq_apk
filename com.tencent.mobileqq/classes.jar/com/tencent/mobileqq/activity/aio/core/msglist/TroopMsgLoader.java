package com.tencent.mobileqq.activity.aio.core.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.TroopAIOContext;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public class TroopMsgLoader
  extends BaseMsgLoader
{
  public List<ChatMessage> a(@NonNull AIOContext paramAIOContext, boolean paramBoolean)
  {
    List localList = super.a(paramAIOContext, paramBoolean);
    return ((TroopAIOContext)paramAIOContext).a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.TroopMsgLoader
 * JD-Core Version:    0.7.0.1
 */