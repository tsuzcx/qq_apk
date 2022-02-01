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
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;

public class BaseBubbleBuilderMenuScreenShotProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  public BaseBubbleBuilderMenuScreenShotProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
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
    paramContext = paramContext.getChatFragment().a();
    ((AIOLongShotHelper)paramContext.a(15)).a(paramChatMessage);
    paramContext.h(true);
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(paramContext.a, "select_more_msg", true);
    paramContext = "0";
    if (paramChatMessage.istroop == 1) {
      paramContext = "2";
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X8009DE5", "0X8009DE5", 1, 0, paramContext, "", "", "");
      return;
      if (paramChatMessage.istroop == 0) {
        paramContext = "1";
      }
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    paramQQCustomMenu.a(2131362524, paramContext.getString(2131690021), 2130839069);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramQQCustomMenu, paramContext);
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131362524;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuScreenShotProcessor
 * JD-Core Version:    0.7.0.1
 */