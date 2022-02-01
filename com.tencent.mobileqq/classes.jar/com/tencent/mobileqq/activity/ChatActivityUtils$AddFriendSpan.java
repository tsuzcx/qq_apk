package com.tencent.mobileqq.activity;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.app.BaseActivity;

class ChatActivityUtils$AddFriendSpan
  extends URLSpan
{
  int a = -16776961;
  
  public ChatActivityUtils$AddFriendSpan(String paramString, int paramInt)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getContext();
    if (((paramView instanceof SplashActivity)) || ((paramView instanceof ChatActivity)))
    {
      paramView = (BaseActivity)paramView;
      if ((paramView.getChatFragment().a() instanceof StrangerChatPie)) {
        ((StrangerChatPie)paramView.getChatFragment().a()).ap();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.AddFriendSpan
 * JD-Core Version:    0.7.0.1
 */