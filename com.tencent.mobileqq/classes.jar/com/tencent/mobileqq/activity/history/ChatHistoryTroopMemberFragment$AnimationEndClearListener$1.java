package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

class ChatHistoryTroopMemberFragment$AnimationEndClearListener$1
  implements Runnable
{
  ChatHistoryTroopMemberFragment$AnimationEndClearListener$1(ChatHistoryTroopMemberFragment.AnimationEndClearListener paramAnimationEndClearListener) {}
  
  public void run()
  {
    if (this.a.a == null) {
      return;
    }
    int i = this.a.b;
    RelativeLayout.LayoutParams localLayoutParams;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              this.a.a.setVisibility(4);
            }
            else
            {
              this.a.a.setVisibility(0);
            }
          }
          else {
            ((ImageView)this.a.a).setImageResource(2130851766);
          }
        }
        else {
          ((ImageView)this.a.a).setImageResource(2130851767);
        }
      }
      else
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
        localLayoutParams.leftMargin -= (int)(this.a.c.I * 34.0F);
        this.a.a.setLayoutParams(localLayoutParams);
        this.a.a.setTag("left");
      }
    }
    else
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
      localLayoutParams.leftMargin += (int)(this.a.c.I * 34.0F);
      this.a.a.setLayoutParams(localLayoutParams);
      this.a.a.setTag("right");
    }
    this.a.a.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.AnimationEndClearListener.1
 * JD-Core Version:    0.7.0.1
 */