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
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.theme.SkinEngine;

public class LimitChatMsgBubbleBgExecutor
  extends ChatLayoutBubbleBgExecutor
{
  public LimitChatMsgBubbleBgExecutor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext);
  }
  
  public int a()
  {
    return ChatLayoutBubbleBgExecutorImpl.f;
  }
  
  public void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    paramBoolean = paramChatMessage.isSend();
    paramChatMessage = SkinEngine.getInstances();
    Object localObject;
    if (paramBoolean)
    {
      paramInt1 = 2130850409;
      paramChatMessage = paramChatMessage.getDefaultThemeDrawable(paramInt1);
      localObject = SkinEngine.getInstances();
      if (!paramBoolean) {
        break label111;
      }
    }
    label111:
    for (paramInt1 = 2130850408;; paramInt1 = 2130850232)
    {
      localObject = ((SkinEngine)localObject).getDefaultThemeDrawable(paramInt1);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, paramChatMessage);
      localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = new BubbleInfo(0);
      return;
      paramInt1 = 2130850233;
      break;
    }
  }
  
  public boolean a(int paramInt, ChatMessage paramChatMessage)
  {
    return (paramInt != 0) && (LimitChatUtil.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.bubblebghandlerexecutor.LimitChatMsgBubbleBgExecutor
 * JD-Core Version:    0.7.0.1
 */