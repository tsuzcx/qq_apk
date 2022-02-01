package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class BaseBubbleBuilderMenuDeleteProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor
{
  public BaseBubbleBuilderMenuDeleteProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramQQCustomMenu, paramChatMessage, paramContext, paramBundle);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, MessageRecord paramMessageRecord, Context paramContext, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("isInvokeMenuShow", false);; bool = false)
    {
      if ((!bool) || ((paramMessageRecord != null) && (!paramMessageRecord.isSend()))) {
        ChatActivityFacade.a(paramQQCustomMenu, paramContext, this.a.a);
      }
      if (paramBundle != null) {
        paramBundle.putBoolean("isInvokeMenuShow", false);
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131365636;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuDeleteProcessor
 * JD-Core Version:    0.7.0.1
 */