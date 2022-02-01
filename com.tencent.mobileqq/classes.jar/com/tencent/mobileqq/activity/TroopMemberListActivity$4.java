package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.widget.PopupMenuDialog;

class TroopMemberListActivity$4
  implements View.OnTouchListener
{
  TroopMemberListActivity$4(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.mSortTypeDialog.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.4
 * JD-Core Version:    0.7.0.1
 */