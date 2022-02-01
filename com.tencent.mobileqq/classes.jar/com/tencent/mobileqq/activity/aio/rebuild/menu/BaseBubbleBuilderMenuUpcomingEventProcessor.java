package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgUtil;
import com.tencent.mobileqq.app.BaseActivity;
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
    paramContext = (BaseActivity)paramContext;
    if ((paramContext != null) && (paramContext.getChatFragment() != null))
    {
      ((AIOUpComingMsgHelper)paramContext.getChatFragment().a().a(59)).a(paramChatMessage);
      return;
    }
    paramChatMessage = new StringBuilder();
    paramChatMessage.append("onClickScreenShot Error:");
    if (paramContext != null) {
      paramContext = paramContext.toString();
    } else {
      paramContext = "ca is null ";
    }
    paramChatMessage.append(paramContext);
    QLog.e("BaseBubbleBuilder", 1, paramChatMessage.toString());
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramQQCustomMenu, paramContext, paramChatMessage, paramBundle.getBoolean("isSearch", false));
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if ((paramChatMessage != null) && (paramQQCustomMenu != null) && (paramContext != null) && (UpComingMsgUtil.a(this.a.a)))
    {
      int k = paramQQCustomMenu.a();
      int j = k;
      if (paramBoolean)
      {
        paramChatMessage = paramQQCustomMenu.a();
        j = k;
        if (paramChatMessage != null)
        {
          int i = 0;
          for (;;)
          {
            j = k;
            if (i >= paramChatMessage.length) {
              break;
            }
            if (paramChatMessage[i].a() == 2131366494)
            {
              j = i + 1;
              break;
            }
            i += 1;
          }
        }
      }
      paramQQCustomMenu.a(2131380215, paramContext.getString(2131690921), 0, j);
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131380215;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuUpcomingEventProcessor
 * JD-Core Version:    0.7.0.1
 */