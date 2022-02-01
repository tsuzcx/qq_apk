package com.tencent.mobileqq.activity.aio.rebuild.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class BaseBubbleBuilderMenuMutePlayProcessor
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor
{
  public BaseBubbleBuilderMenuMutePlayProcessor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu)
  {
    paramQQCustomMenu.a(2131372063, HardCodeUtil.a(2131701022), 2130839069);
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    a(paramQQCustomMenu);
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 2131372063;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.menu.BaseBubbleBuilderMenuMutePlayProcessor
 * JD-Core Version:    0.7.0.1
 */