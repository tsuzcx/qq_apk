package com.tencent.mobileqq.activity.aio.coreui.msglist.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public abstract interface IBaseBubbleBuilderMenuAddProcessor
{
  public abstract void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor
 * JD-Core Version:    0.7.0.1
 */