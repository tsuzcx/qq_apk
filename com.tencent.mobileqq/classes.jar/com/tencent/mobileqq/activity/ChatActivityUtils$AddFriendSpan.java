package com.tencent.mobileqq.activity;

import aipm;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;

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
      paramView = (FragmentActivity)paramView;
      if ((paramView.getChatFragment().a() instanceof aipm)) {
        ((aipm)paramView.getChatFragment().a()).bo();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.AddFriendSpan
 * JD-Core Version:    0.7.0.1
 */