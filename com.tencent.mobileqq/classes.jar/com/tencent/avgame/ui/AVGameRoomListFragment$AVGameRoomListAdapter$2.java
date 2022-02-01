package com.tencent.avgame.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AVGameRoomListFragment$AVGameRoomListAdapter$2
  implements View.OnTouchListener
{
  AVGameRoomListFragment$AVGameRoomListAdapter$2(AVGameRoomListFragment.AVGameRoomListAdapter paramAVGameRoomListAdapter) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.AVGameRoomListAdapter.2
 * JD-Core Version:    0.7.0.1
 */