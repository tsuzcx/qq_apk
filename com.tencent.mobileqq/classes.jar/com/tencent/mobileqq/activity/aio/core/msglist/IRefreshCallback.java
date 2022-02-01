package com.tencent.mobileqq.activity.aio.core.msglist;

import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public abstract interface IRefreshCallback
{
  public abstract void a(List<ChatMessage> paramList1, List<ChatMessage> paramList2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.IRefreshCallback
 * JD-Core Version:    0.7.0.1
 */