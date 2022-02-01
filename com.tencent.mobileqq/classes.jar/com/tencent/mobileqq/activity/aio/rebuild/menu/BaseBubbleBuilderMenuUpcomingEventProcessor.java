package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;

public class BaseBubbleBuilderMenuUpcomingEventProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  public BaseBubbleBuilderMenuUpcomingEventProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    a(paramContext, paramChatMessage);
  }
  
  protected void a(Context paramContext, ChatMessage paramChatMessage)
  {
    paramContext = (FragmentActivity)paramContext;
    if ((paramContext == null) || (paramContext.getChatFragment() == null))
    {
      paramChatMessage = new StringBuilder().append("onClickScreenShot Error:");
      if (paramContext != null) {}
      for (paramContext = paramContext.toString();; paramContext = "ca is null ")
      {
        QLog.e("BaseBubbleBuilder", 1, paramContext);
        return;
      }
    }
    ((AIOUpComingMsgHelper)paramContext.getChatFragment().a().a(59)).a(paramChatMessage);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramQQCustomMenu, paramContext, paramChatMessage, paramBundle.getBoolean("isSearch", false));
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    int j;
    int i;
    if ((paramChatMessage != null) && (paramQQCustomMenu != null) && (paramContext != null) && (UpComingMsgUtil.a(this.a.a)))
    {
      j = paramQQCustomMenu.a();
      if (!paramBoolean) {
        break label98;
      }
      paramChatMessage = paramQQCustomMenu.a();
      if (paramChatMessage == null) {
        break label98;
      }
      i = 0;
      if (i >= paramChatMessage.length) {
        break label98;
      }
      if (paramChatMessage[i].a() != 2131366625) {
        break label89;
      }
      i += 1;
    }
    for (;;)
    {
      paramQQCustomMenu.a(2131380949, paramContext.getString(2131691001), 0, i);
      return;
      label89:
      i += 1;
      break;
      label98:
      i = j;
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131380949;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuUpcomingEventProcessor
 * JD-Core Version:    0.7.0.1
 */