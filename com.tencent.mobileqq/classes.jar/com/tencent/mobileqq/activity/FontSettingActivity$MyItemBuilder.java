package com.tencent.mobileqq.activity;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

class FontSettingActivity$MyItemBuilder
  extends TextItemBuilder
{
  public FontSettingActivity$MyItemBuilder(FontSettingActivity paramFontSettingActivity, QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage) {}
  
  public void b(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.MyItemBuilder
 * JD-Core Version:    0.7.0.1
 */