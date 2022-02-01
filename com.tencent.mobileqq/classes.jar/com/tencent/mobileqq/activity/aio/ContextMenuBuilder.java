package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public abstract interface ContextMenuBuilder
{
  public abstract void a(int paramInt, Context paramContext, ChatMessage paramChatMessage);
  
  public abstract QQCustomMenuItem[] a(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ContextMenuBuilder
 * JD-Core Version:    0.7.0.1
 */