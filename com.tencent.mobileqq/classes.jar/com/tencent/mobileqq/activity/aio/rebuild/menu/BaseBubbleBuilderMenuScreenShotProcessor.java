package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
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
    paramContext = (BaseActivity)paramContext;
    if ((paramContext != null) && (paramContext.getChatFragment() != null))
    {
      paramContext = paramContext.getChatFragment().a();
      ((AIOLongShotHelper)paramContext.a(15)).a(paramChatMessage);
      paramContext.f(true);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(paramContext.a, "select_more_msg", true);
      if (paramChatMessage.istroop == 1) {
        paramContext = "2";
      } else if (paramChatMessage.istroop == 0) {
        paramContext = "1";
      } else {
        paramContext = "0";
      }
      ReportController.b(null, "dc00898", "", "", "0X8009DE5", "0X8009DE5", 1, 0, paramContext, "", "", "");
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
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    paramQQCustomMenu.a(2131362480, paramContext.getString(2131689936), 2130838922);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramQQCustomMenu, paramContext);
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131362480;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuScreenShotProcessor
 * JD-Core Version:    0.7.0.1
 */