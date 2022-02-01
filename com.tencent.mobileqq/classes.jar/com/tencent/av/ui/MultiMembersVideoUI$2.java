package com.tencent.av.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.utils.MultiVideoMembersClickListener;

class MultiMembersVideoUI$2
  implements View.OnTouchListener
{
  MultiMembersVideoUI$2(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    return paramMotionEvent.getAction() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersVideoUI.2
 * JD-Core Version:    0.7.0.1
 */