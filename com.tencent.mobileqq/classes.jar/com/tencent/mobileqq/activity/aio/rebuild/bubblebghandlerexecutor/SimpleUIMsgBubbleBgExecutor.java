package com.tencent.mobileqq.activity.aio.rebuild.bubblebghandlerexecutor;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.qphone.base.util.BaseApplication;

public class SimpleUIMsgBubbleBgExecutor
  extends ChatLayoutBubbleBgExecutor
{
  public SimpleUIMsgBubbleBgExecutor(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext);
  }
  
  private void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    boolean bool = paramChatMessage.isSend();
    Object localObject = this.a.getApp().getResources();
    int i = SimpleModeHelper.a(bool, true);
    int j = SimpleModeHelper.a(bool, false);
    paramChatMessage = ((Resources)localObject).getDrawable(i);
    localObject = ((Resources)localObject).getDrawable(j);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramChatMessage);
    localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject);
    paramViewHolder.h.setBackgroundDrawable(localStateListDrawable);
    paramViewHolder.i = new BubbleInfo(0);
  }
  
  public int a()
  {
    return ChatLayoutBubbleBgExecutorImpl.f;
  }
  
  public void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    a(paramChatMessage, paramViewHolder);
  }
  
  public boolean a(int paramInt, ChatMessage paramChatMessage)
  {
    return (paramInt != 0) && (SimpleUIUtil.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.bubblebghandlerexecutor.SimpleUIMsgBubbleBgExecutor
 * JD-Core Version:    0.7.0.1
 */