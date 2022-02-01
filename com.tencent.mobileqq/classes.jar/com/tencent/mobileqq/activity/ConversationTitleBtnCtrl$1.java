package com.tencent.mobileqq.activity;

import android.app.Activity;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;

class ConversationTitleBtnCtrl$1
  implements ApngDrawable.OnPlayRepeatListener
{
  ConversationTitleBtnCtrl$1(ConversationTitleBtnCtrl paramConversationTitleBtnCtrl) {}
  
  public void onPlayRepeat(int paramInt)
  {
    if (ConversationTitleBtnCtrl.a(this.a) != null) {
      ConversationTitleBtnCtrl.a(this.a).runOnUiThread(new ConversationTitleBtnCtrl.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1
 * JD-Core Version:    0.7.0.1
 */