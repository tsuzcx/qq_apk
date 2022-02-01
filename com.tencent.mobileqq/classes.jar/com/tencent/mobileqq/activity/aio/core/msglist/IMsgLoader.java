package com.tencent.mobileqq.activity.aio.core.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public abstract interface IMsgLoader
{
  public abstract boolean a(@NonNull AIOContext paramAIOContext, boolean paramBoolean, List<ChatMessage> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.IMsgLoader
 * JD-Core Version:    0.7.0.1
 */