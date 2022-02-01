package com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class NoneBubbleBgExecutor
  extends ChatLayoutBubbleBgExecutor
{
  public NoneBubbleBgExecutor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext);
  }
  
  public int a()
  {
    return ChatLayoutBubbleBgExecutorImpl.b;
  }
  
  public void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramViewHolder.a == null)
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("handleBubbleBg mContent is null type = ");
      paramViewHolder.append(paramChatMessage.istroop);
      QLog.e("NoneBubbleBgExecutor", 1, paramViewHolder.toString());
      return;
    }
    paramViewHolder.a.setBackgroundDrawable(null);
  }
  
  public boolean a(int paramInt, ChatMessage paramChatMessage)
  {
    return paramInt == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.NoneBubbleBgExecutor
 * JD-Core Version:    0.7.0.1
 */