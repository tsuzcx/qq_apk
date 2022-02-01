package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class TroopMemberListActivity$19
  implements View.OnTouchListener
{
  TroopMemberListActivity$19(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.a.clickSearchBar();
      paramView = this.a.mMyTroopRole;
      this.a.doReport("Clk_find", paramView, "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.19
 * JD-Core Version:    0.7.0.1
 */