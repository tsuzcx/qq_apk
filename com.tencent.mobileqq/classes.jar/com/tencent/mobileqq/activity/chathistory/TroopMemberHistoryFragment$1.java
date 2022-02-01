package com.tencent.mobileqq.activity.chathistory;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class TroopMemberHistoryFragment$1
  implements View.OnTouchListener
{
  TroopMemberHistoryFragment$1(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() == 2) && ((this.a.k == null) || (this.a.k.getCount() == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.1
 * JD-Core Version:    0.7.0.1
 */