package com.tencent.mobileqq.activity.home;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

class Conversation$21
  implements View.OnTouchListener
{
  Conversation$21(Conversation paramConversation) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("statusTitle onTouch event :");
      paramView.append(paramMotionEvent.toString());
      paramView.append(", mGestureDetector is null ");
      boolean bool;
      if (this.a.aD != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramView.append(bool);
      QLog.d("Q.recent", 2, paramView.toString());
    }
    if (this.a.aD != null) {
      this.a.aD.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.21
 * JD-Core Version:    0.7.0.1
 */