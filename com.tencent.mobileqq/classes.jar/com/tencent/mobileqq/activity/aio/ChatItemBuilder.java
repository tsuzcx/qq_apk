package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.ChatMessage;

public abstract class ChatItemBuilder
  implements ContextMenuBuilder
{
  public static final boolean v = AppSetting.e;
  public int u = 0;
  
  public abstract View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  public abstract void a(View paramView, ChatMessage paramChatMessage, int paramInt);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */