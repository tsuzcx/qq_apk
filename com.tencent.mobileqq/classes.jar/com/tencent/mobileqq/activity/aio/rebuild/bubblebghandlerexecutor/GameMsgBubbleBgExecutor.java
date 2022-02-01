package com.tencent.mobileqq.activity.aio.rebuild.bubblebghandlerexecutor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.ChatLayoutBubbleBgExecutor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.ChatLayoutBubbleBgExecutorImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.theme.SkinEngine;

public class GameMsgBubbleBgExecutor
  extends ChatLayoutBubbleBgExecutor
{
  public GameMsgBubbleBgExecutor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext);
  }
  
  public int a()
  {
    return ChatLayoutBubbleBgExecutorImpl.j;
  }
  
  public void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    paramBoolean = paramChatMessage.isSend();
    paramChatMessage = SkinEngine.getInstances();
    if (paramBoolean) {
      paramInt1 = 2130852127;
    } else {
      paramInt1 = 2130851945;
    }
    paramChatMessage = paramChatMessage.getDefaultThemeDrawable(paramInt1);
    Object localObject = SkinEngine.getInstances();
    if (paramBoolean) {
      paramInt1 = 2130852126;
    } else {
      paramInt1 = 2130851944;
    }
    localObject = ((SkinEngine)localObject).getDefaultThemeDrawable(paramInt1);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramChatMessage);
    localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject);
    paramViewHolder.h.setBackgroundDrawable(localStateListDrawable);
    paramViewHolder.i = new BubbleInfo(0);
  }
  
  public boolean a(int paramInt, ChatMessage paramChatMessage)
  {
    return (paramInt != 0) && (!ThemeUtil.isInNightMode(this.a)) && (paramChatMessage.istroop == 10007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.bubblebghandlerexecutor.GameMsgBubbleBgExecutor
 * JD-Core Version:    0.7.0.1
 */