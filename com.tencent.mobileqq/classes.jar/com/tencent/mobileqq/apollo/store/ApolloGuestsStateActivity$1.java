package com.tencent.mobileqq.apollo.store;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;

class ApolloGuestsStateActivity$1
  implements View.OnTouchListener
{
  ApolloGuestsStateActivity$1(ApolloGuestsStateActivity paramApolloGuestsStateActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return true;
        }
        this.a.mApprovalLayout.setAlpha(1.0F);
        return true;
      }
      this.a.mApprovalLayout.setAlpha(1.0F);
      this.a.mButtonRight.performClick();
      return true;
    }
    this.a.mApprovalLayout.setAlpha(0.5F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity.1
 * JD-Core Version:    0.7.0.1
 */