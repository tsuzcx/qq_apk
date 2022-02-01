package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

class ChatHistoryTroopMemberFragment$31
  implements Animation.AnimationListener
{
  ChatHistoryTroopMemberFragment$31(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, TranslateAnimation paramTranslateAnimation1, TranslateAnimation paramTranslateAnimation2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.a)
    {
      this.d.bm.show();
      this.d.U.setAnimation(null);
      this.d.M.setVisibility(8);
      return;
    }
    if (paramAnimation == this.b)
    {
      this.d.U.setAnimation(null);
      this.d.U.offsetTopAndBottom(this.c);
      this.d.U.requestLayout();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.31
 * JD-Core Version:    0.7.0.1
 */