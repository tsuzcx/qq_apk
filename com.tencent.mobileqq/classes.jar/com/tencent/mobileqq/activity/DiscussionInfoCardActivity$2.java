package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;

class DiscussionInfoCardActivity$2
  implements View.OnTouchListener
{
  DiscussionInfoCardActivity$2(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent != null) && (this.a.a != null))
    {
      paramView = this.a.a;
      float f;
      if (paramMotionEvent.getAction() == 0) {
        f = 0.5F;
      } else {
        f = 1.0F;
      }
      paramView.setAlpha(f);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.2
 * JD-Core Version:    0.7.0.1
 */