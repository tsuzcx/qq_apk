package com.tencent.mobileqq.activity.aio;

import android.view.View;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.XListView;

public abstract interface MediaPlayerManager$Callback
{
  public abstract void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage);
  
  public abstract boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage);
  
  public abstract boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer);
  
  public abstract boolean b(ChatMessage paramChatMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback
 * JD-Core Version:    0.7.0.1
 */